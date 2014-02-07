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

package zen.type;

import zen.ast.ZCastNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZListNode;
import zen.ast.ZNode;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.lang.ZFunc;
import zen.lang.ZenError;
import zen.parser.ZGenerator;
import zen.parser.ZLogger;
import zen.parser.ZUtils;
import zen.parser.ZVisitor;

public abstract class ZTypeChecker extends ZVisitor {

	protected void println(String string) {
		LibNative.Debug("debug: " + string);
	}

	protected void FIXME(String string) {
		LibNative.Debug("FIXME: " + string);
	}

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

	private final ZNode VisitTypeChecker(ZNode Node, ZType ContextType, int TypeCheckPolicy) {
		if(this.IsVisitable()) {
			if(Node.HasUntypedNode()) {
				@Var ZNode ParentNode = Node.ParentNode;
				this.StackedContextType = ContextType;
				this.ReturnedNode = null;
				Node.Accept(this);
				if(this.ReturnedNode == null) {
					this.FIXME(Node.getClass().getSimpleName() + " returns no value");
				}
				else {
					Node = this.ReturnedNode;
				}
				this.VarScope.CheckVarNode(ContextType, Node);
				Node = this.TypeCheckImpl(Node, ContextType, TypeCheckPolicy);
				if(ParentNode != Node.ParentNode && ParentNode != null) {
					ParentNode.SetChild(Node);
				}
			}
			else {
				Node = this.TypeCheckImpl(Node, ContextType, TypeCheckPolicy);
				this.VarScope.CheckVarNode(ContextType, Node);
			}
		}
		this.ReturnedNode = null;
		return Node;
	}

	public final static int DefaultTypeCheckPolicy			= 0;
	public final static int NoCheckPolicy                   = 1;
	public final static int EnforceCoercion                 = (1 << 1);

	private final ZNode TypeCheckImpl(ZNode Node, ZType ContextType, int TypeCheckPolicy) {
		if(Node.IsErrorNode()) {
			if(!ContextType.IsVarType()) {
				Node.Type = ContextType;
			}
			return Node;
		}
		if(Node.IsUntyped() || ContextType.IsVarType() || ZUtils.IsFlag(TypeCheckPolicy, NoCheckPolicy)) {
			return Node;
		}
		if(Node.Type == ContextType || ContextType.Accept(Node.Type)) {
			return Node;
		}
		if(ContextType.IsVoidType() && !Node.Type.IsVoidType()) {
			return new ZCastNode(Node.ParentNode, ZType.VoidType, Node);
		}
		@Var ZFunc CoercionFunc = this.Generator.GetCoercionFunc(Node.Type, ContextType);
		if(CoercionFunc != null) {

		}
		if(ContextType.IsFloatType() && Node.Type.IsIntType()) {
			return new ZCastNode(Node.ParentNode, ContextType, Node);
		}
		if(ZUtils.IsFlag(TypeCheckPolicy, EnforceCoercion) && ContextType.IsStringType()) {
			return new ZCastNode(Node.ParentNode, ContextType, Node);
		}
		return ZenError.CreateStupidCast(ContextType, Node);
	}

	public final ZNode TryType(ZNode Node, ZType ContextType) {
		return this.VisitTypeChecker(Node, ContextType, NoCheckPolicy);
	}

	public final void TryTypeAt(ZNode Node, int Index, ZType ContextType) {
		Node.AST[Index] = this.VisitTypeChecker(Node.AST[Index], ContextType, NoCheckPolicy);
	}

	public final ZNode CheckType(ZNode Node, ZType ContextType) {
		return this.VisitTypeChecker(Node, ContextType, DefaultTypeCheckPolicy);
	}

	public final void CheckTypeAt(ZNode Node, int Index, ZType ContextType) {
		Node.AST[Index] = this.VisitTypeChecker(Node.AST[Index], ContextType, DefaultTypeCheckPolicy);
	}

	public final ZNode EnforceType(ZNode Node, ZType ContextType) {
		return this.VisitTypeChecker(Node, ContextType, EnforceCoercion);
	}

	public final boolean TypeCheckNodeList(ZListNode List) {
		if(this.IsVisitable()) {
			@Var boolean AllTyped = true;
			@Var int i = 0;
			while(i < List.GetListSize()) {
				ZNode SubNode = List.GetListAt(i);
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

	@Override public void VisitExtendedNode(ZNode Node) {
		this.Return(Node);
	}


	public final void Return(ZNode Node) {
		if(Node != null) {
			if(this.ReturnedNode != null) {
				this.FIXME("previous returned node " + Node);
			}
			this.ReturnedNode = Node;
		}
	}

	public final void TypedNode(ZNode Node, ZType Type) {
		Node.Type = Type;
		if(this.ReturnedNode != null) {
			this.FIXME("previous returned node " + Node);
		}
		this.ReturnedNode = Node;
	}

	public final void Todo(ZNode Node) {
		this.Logger.ReportWarning(Node.SourceToken, "TODO: unimplemented type checker node: " + Node.getClass().getSimpleName());
		Node.Type = ZType.VarType;
		this.ReturnedNode = Node;
	}

	public abstract void DefineFunction(ZFunctionNode FunctionNode, boolean Enforced);



}

