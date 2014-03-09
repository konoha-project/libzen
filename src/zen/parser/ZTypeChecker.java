//***************************************************************************
//Copyright (c) 2013-2014, Konoha project authors. All rights reserved.
//Redistribution and use in source and binary forms, with or without
//modification, are permitted provided that the following conditions are met:
//
//*  Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
//*  Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
//THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
//"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
//TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
//PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
//CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
//EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
//PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
//OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
//WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
//OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
//ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//**************************************************************************

package zen.parser;

import zen.ast.ZAsmNode;
import zen.ast.ZCastNode;
import zen.ast.ZErrorNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZListNode;
import zen.ast.ZMacroNode;
import zen.ast.ZNode;
import zen.ast.ZStupidCastErrorNode;
import zen.ast.sugar.ZDesugarNode;
import zen.ast.sugar.ZSyntaxSugarNode;
import zen.type.ZFunc;
import zen.type.ZType;
import zen.type.ZVarScope;
import zen.type.ZVarType;
import zen.util.Field;
import zen.util.LibZen;
import zen.util.Var;

public abstract class ZTypeChecker extends ZVisitor {

	@Field private ZType      StackedContextType;
	@Field private ZNode      ReturnedNode;

	@Field public ZGenerator  Generator;
	@Field public ZLogger     Logger;
	@Field private boolean    StoppedVisitor;
	@Field public ZVarScope   VarScope;

	public ZTypeChecker(ZGenerator Generator) {
		this.Generator = Generator;
		this.Logger = Generator.Logger;
		this.StackedContextType = null;
		this.ReturnedNode = null;
		this.StoppedVisitor = false;
		this.VarScope = new ZVarScope(null, this.Logger, null);
	}

	@Override public final void EnableVisitor() {
		this.StoppedVisitor = false;
	}

	@Override public final void StopVisitor() {
		this.StoppedVisitor = true;
	}

	@Override public final boolean IsVisitable() {
		return !this.StoppedVisitor;
	}

	public final ZType GetContextType() {
		return this.StackedContextType;
	}

	protected final ZNode CreateStupidCastNode(ZType Requested, ZNode Node) {
		@Var ZNode ErrorNode = new ZStupidCastErrorNode(Node, "type error: requested=" +  Requested + ", given=" + Node.Type/* + " of node " + Node*/);
		ErrorNode.Type = Requested;
		return ErrorNode;
	}

	protected final ZNode EnforceNodeType(ZNode Node, ZType EnforcedType) {
		@Var ZFunc Func = this.Generator.LookupConverterFunc(Node.Type, EnforcedType);
		if(Func == null && EnforcedType.IsStringType()) {
			Func = this.Generator.LookupFunc("toString", Node.Type, 1);
		}
		if(Func instanceof ZMacroFunc) {
			@Var ZMacroNode MacroNode = new ZMacroNode(Node.ParentNode, null, (ZMacroFunc)Func);
			MacroNode.Append(Node);
			// this.VisitListNodeAsFuncCall(MacroNode, Func.GetFuncType()); FIXME
			this.VarScope.TypeNode(MacroNode, EnforcedType);
			return MacroNode;
		}
		else if(Func != null) {
			@Var ZFuncCallNode MacroNode = new ZFuncCallNode(Node.ParentNode, Func.FuncName, Func.GetFuncType());
			MacroNode.Append(Node);
			this.VarScope.TypeNode(MacroNode, EnforcedType);
			return MacroNode;
		}
		return this.CreateStupidCastNode(EnforcedType, Node);
	}


	public final static int _DefaultTypeCheckPolicy			= 0;
	public final static int _NoCheckPolicy                   = 1;

	private final ZNode TypeCheckImpl(ZNode Node, ZType ContextType, int TypeCheckPolicy) {
		if(Node.IsErrorNode()) {
			if(!ContextType.IsVarType()) {
				this.VarScope.TypeNode(Node, ContextType);
			}
			return Node;
		}
		if(Node.IsUntyped() || ContextType.IsVarType() || LibZen._IsFlag(TypeCheckPolicy, ZTypeChecker._NoCheckPolicy)) {
			return Node;
		}
		if(Node.Type == ContextType || ContextType.Accept(Node.Type)) {
			return Node;
		}
		if(ContextType.IsVoidType() && !Node.Type.IsVoidType()) {
			return new ZCastNode(Node.ParentNode, ZType.VoidType, Node);
		}
		if(ContextType.IsFloatType() && Node.Type.IsIntType()) {
			return this.EnforceNodeType(Node, ContextType);
		}
		if(ContextType.IsIntType() && Node.Type.IsFloatType()) {
			return this.EnforceNodeType(Node, ContextType);
		}
		return this.CreateStupidCastNode(ContextType, Node);
	}

	private ZNode VisitNode(ZNode Node, ZType ContextType) {
		@Var ZNode ParentNode = Node.ParentNode;
		this.StackedContextType = ContextType;
		this.ReturnedNode = null;
		Node.Accept(this);
		if(this.ReturnedNode == null) {  /* debug check */
			LibZen._PrintDebug("!! returns no value: " + Node);
		}
		else {
			Node = this.ReturnedNode;
		}
		if(ParentNode != Node.ParentNode && ParentNode != null) {
			ParentNode.SetChild(Node);
		}
		return Node;
	}

	private final ZNode TypeCheck(ZNode Node, ZType ContextType, int TypeCheckPolicy) {
		if(this.IsVisitable() && Node != null) {
			if(Node.HasUntypedNode()) {
				Node = this.VisitNode(Node, ContextType);
				this.VarScope.InferType(ContextType, Node);
			}
			Node = this.TypeCheckImpl(Node, ContextType, TypeCheckPolicy);
			this.VarScope.InferType(ContextType, Node);
		}
		this.ReturnedNode = null;
		return Node;
	}


	public final ZNode TryType(ZNode Node, ZType ContextType) {
		return this.TypeCheck(Node, ContextType, ZTypeChecker._NoCheckPolicy);
	}

	public final void TryTypeAt(ZNode Node, int Index, ZType ContextType) {
		//		@Var ZNode N = Node.AST[Index];
		Node.SetNode(Index, this.TypeCheck(Node.AST[Index], ContextType, ZTypeChecker._NoCheckPolicy));
		//		if(N != Node.AST[Index]) {
		//			System.out.println("Node="+Node+"\n\tFrom="+N+"\n\tTo="+Node.AST[Index]);
		//		}
	}

	public final ZNode CheckType(ZNode Node, ZType ContextType) {
		return this.TypeCheck(Node, ContextType, ZTypeChecker._DefaultTypeCheckPolicy);
	}

	public final void CheckTypeAt(ZNode Node, int Index, ZType ContextType) {
		//		@Var ZNode N = Node.AST[Index];
		Node.SetNode(Index, this.TypeCheck(Node.AST[Index], ContextType, ZTypeChecker._DefaultTypeCheckPolicy));
		//		if(N != Node.AST[Index]) {
		//			System.out.println("Node="+Node+"\n\tFrom="+N+"\n\tTo="+Node.AST[Index]);
		//		}
	}

	public final boolean TypeCheckNodeList(ZListNode List) {
		if(this.IsVisitable()) {
			@Var boolean AllTyped = true;
			@Var int i = 0;
			while(i < List.GetListSize()) {
				@Var ZNode SubNode = List.GetListAt(i);
				SubNode = this.CheckType(SubNode, ZType.VarType);
				List.SetListAt(i, SubNode);
				if(SubNode.IsUntyped()) {
					AllTyped = false;
				}
				i = i + 1;
			}
			return AllTyped;
		}
		return false;
	}

	public final void Return(ZNode Node) {
		if(this.ReturnedNode != null) {
			LibZen._PrintDebug("previous returned node " + Node);
		}
		this.ReturnedNode = Node;
	}

	public final void TypedNode(ZNode Node, ZType Type) {
		if(Type instanceof ZVarType) {
			if(!Type.IsVarType()) {
				Type = Type.GetRealType();
			}
		}
		this.VarScope.TypeNode(Node, Type);
		if(this.ReturnedNode != null) {
			LibZen._PrintDebug("previous returned node " + Node);
		}
		this.ReturnedNode = Node;
	}

	public final void ReturnErrorNode(ZNode Node, ZToken ErrorToken, String Message) {
		if(ErrorToken == null) {
			ErrorToken = Node.SourceToken;
		}
		this.Return(new ZErrorNode(Node.ParentNode, ErrorToken, Message));
	}

	public abstract void DefineFunction(ZFunctionNode FunctionNode, boolean Enforced);

	@Override public void VisitErrorNode(ZErrorNode Node) {
		@Var ZType ContextType = this.GetContextType();
		if(!ContextType.IsVarType()) {
			this.TypedNode(Node, ContextType);
		}
		else {
			this.Return(Node);
		}
	}

	@Override public void VisitSyntaxSugarNode(ZSyntaxSugarNode Node) {
		@Var ZType ContextType = this.GetContextType();
		@Var ZDesugarNode DesugarNode = Node.DeSugar(this.Generator);
		@Var int i = 0;
		while(i < DesugarNode.GetAstSize()) {
			this.CheckTypeAt(DesugarNode, i, ContextType);
			i = i + 1;
		}
		this.TypedNode(DesugarNode, DesugarNode.GetAstType(DesugarNode.GetAstSize()-1));
	}

	@Override public void VisitAsmNode(ZAsmNode Node) {
		this.TypedNode(Node, Node.MacroType());
	}



}

