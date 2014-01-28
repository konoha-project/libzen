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

import java.util.ArrayList;

import zen.ast.ZCastNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZNode;
import zen.ast.ZStupidCastNode;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.lang.ZFunc;
import zen.lang.ZSystem;
import zen.lang.ZType;
import zen.parser.ZLogger;
import zen.parser.ZNameSpace;
import zen.parser.ZUtils;
import zen.parser.ZVisitor;

public abstract class ZTypeSafer extends ZVisitor {

	protected void println(String string) {
		LibNative.Debug("debug: " + string);
	}

	protected void FIXME(String string) {
		LibNative.Debug("FIXME: " + string);
	}

	@Field private ZNameSpace StackedNameSpace;
	@Field private ZType      StackedContextType;
	@Field private ZNode      ReturnedNode;

	@Field public ZLogger     Logger;
	@Field private boolean    StoppedVisitor;
	@Field public ZVarScope   VarScope;

	public ZTypeSafer(ZLogger Logger) {
		this.Logger = Logger;
		this.StackedNameSpace = null;
		this.StackedContextType = null;
		this.ReturnedNode = null;
		this.StoppedVisitor = false;
		this.VarScope = new ZVarScope(null, Logger, null);
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

	public final ZNameSpace GetNameSpace() {
		return this.StackedNameSpace;
	}

	public final ZType GetContextType() {
		return this.StackedContextType;
	}

	private final ZNode VisitTypeSafer(ZNode Node, ZNameSpace NameSpace, ZType ContextType, int TypeCheckPolicy) {
		if(this.IsVisitable()) {
			if(Node.IsUntyped()) {
				ZNode ParentNode = Node.ParentNode;
				this.StackedNameSpace = NameSpace;
				this.StackedContextType = ContextType;
				this.ReturnedNode = null;
				Node.Accept(this);
				if(this.ReturnedNode == null) {
					this.FIXME(Node.getClass().getSimpleName() + " returns no value");
					this.ReturnedNode = Node;
				}
				Node = this.TypeCheckImpl(this.ReturnedNode, NameSpace, ContextType, TypeCheckPolicy);
				this.VarScope.CheckVarNode(ContextType, Node);
				if(ParentNode != Node.ParentNode && ParentNode != null) {
					ParentNode.SetChild(Node);
				}
			}
			else {
				Node = this.TypeCheckImpl(Node, NameSpace, ContextType, TypeCheckPolicy);
				this.VarScope.CheckVarNode(ContextType, Node);
			}
		}
		return Node;
	}

	public final static int DefaultTypeCheckPolicy			= 0;
	public final static int NoCheckPolicy                   = 1;
	public final static int EnforceCoercion                 = (1 << 1);

	private final ZNode TypeCheckImpl(ZNode Node, ZNameSpace NameSpace, ZType ContextType, int TypeCheckPolicy) {
		if(Node.IsErrorNode()) {
			return Node;
		}
		if(Node.Type == ContextType || ContextType.IsVarType() || ContextType.Accept(Node.Type) || ZUtils.IsFlag(TypeCheckPolicy, NoCheckPolicy)) {
			return Node;
		}
		if(ContextType.IsVoidType() && !Node.Type.IsVoidType()) {
			return new ZCastNode(ZSystem.VoidType, Node);
		}
		@Var ZFunc CoercionFunc = NameSpace.GetCoercionFunc(Node.Type, ContextType);
		if(CoercionFunc != null) {

		}
		if(ContextType.IsFloatType() && Node.Type.IsIntType()) {
			return new ZCastNode(ContextType, Node);
		}
		if(ZUtils.IsFlag(TypeCheckPolicy, EnforceCoercion) && ContextType.IsStringType()) {
			return new ZCastNode(ContextType, Node);
		}
		//System.err.println("node="+ LibZen.GetClassName(Node) + "type error: requested = " + Type + ", given = " + Node.Type);
		return new ZStupidCastNode(Node.SourceToken, ContextType, Node);
	}

	public final ZNode TryType(ZNode Node, ZNameSpace NameSpace, ZType ContextType) {
		return this.VisitTypeSafer(Node, NameSpace, ContextType, NoCheckPolicy);
	}

	public final ZNode CheckType(ZNode Node, ZNameSpace NameSpace, ZType ContextType) {
		return this.VisitTypeSafer(Node, NameSpace, ContextType, DefaultTypeCheckPolicy);
	}

	public final ZNode EnforceType(ZNode Node, ZNameSpace NameSpace, ZType ContextType) {
		return this.VisitTypeSafer(Node, NameSpace, ContextType, EnforceCoercion);
	}

	public final boolean TypeCheckNodeList(ZNameSpace NameSpace, ArrayList<ZNode> ParamList) {
		if(this.IsVisitable()) {
			@Var boolean AllTyped = true;
			@Var int i = 0;
			while(i < ParamList.size()) {
				ZNode SubNode = ParamList.get(i);
				SubNode = this.CheckType(SubNode, NameSpace, ZSystem.VarType);
				ParamList.set(i, SubNode);
				if(SubNode.IsVarType()) {
					AllTyped = false;
				}
				i = i + 1;
			}
			return AllTyped;
		}
		return false;
	}

	public final void Return(ZNode Node) {
		if(Node != null) {
			if(this.ReturnedNode == null) {
				this.ReturnedNode = Node;
			}
			else {
				if(this.ReturnedNode == Node) {
					this.FIXME("type safer returns twice");
				}
			}
		}
	}

	public final void TypedNode(ZNode Node, ZType Type) {
		Node.Type = Type;
		if(this.ReturnedNode == null) {
			this.ReturnedNode = Node;
		}
		else {
			if(this.ReturnedNode == Node) {
				this.FIXME("type safer returns twice");
			}
		}
	}

	//	public final void TypedCastNode(ZNode Node, ZType ContextType, ZType NodeType) {
	//		if(NodeType.IsVarType() && !ContextType.IsVarType() && !(Node.ParentNode instanceof ZCastNode)) {
	//			this.TypedNode(new ZCastNode(ContextType, Node), ContextType);
	//		}
	//		else {
	//			this.TypedNode(Node, NodeType);
	//		}
	//	}

	public final void TypedNodeIf(ZNode Node, ZType Type, ZNode P1) {
		if(P1.IsVarType()) {
			Node.Type = ZSystem.VarType;
		}
		else {
			Node.Type = Type;
		}
		this.ReturnedNode = Node;
	}

	public final void TypedNodeIf2(ZNode Node, ZType Type, ZNode P1, ZNode P2) {
		if(P1.IsVarType() || P2.IsVarType()) {
			Node.Type = ZSystem.VarType;
		}
		else {
			Node.Type = Type;
		}
		this.ReturnedNode = Node;
	}

	public final void TypedNodeIf3(ZNode Node, ZType Type, ZNode P1, ZNode P2, ZNode P3) {
		if(P1.IsVarType() || P2.IsVarType() || P3.IsVarType()) {
			Node.Type = ZSystem.VarType;
		}
		else {
			Node.Type = Type;
		}
		this.ReturnedNode = Node;
	}

	public final void Todo(ZNode Node) {
		this.Logger.ReportWarning(Node.SourceToken, "TODO: unimplemented type checker node: " + Node.getClass().getSimpleName());
		Node.Type = ZSystem.VarType;
		this.ReturnedNode = Node;
	}

	public abstract void DefineFunction(ZNameSpace NameSpace, ZFunctionNode FunctionNode, boolean Enforced);

	//	public final boolean TypeCheckNodeList(ZNameSpace NameSpace, ArrayList<ZNode> ParamList) {
	//		if(this.IsVisitable()) {
	//			@Var boolean AllTyped = true;
	//			@Var int i = 0;
	//			while(i < ParamList.size()) {
	//				ZNode SubNode = ParamList.get(i);
	//				SubNode = this.TypeCheck(SubNode, NameSpace, ZSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
	//				ParamList.set(i, SubNode);
	//				if(SubNode.IsVarType()) {
	//					AllTyped = false;
	//				}
	//				i = i + 1;
	//			}
	//			return AllTyped;
	//		}
	//		return false;
	//	}

	//	private void DumpFuncList(ArrayList<ZenFunc> FuncList, int StartIdx, int EndIdx) {
	//		@Var int i = StartIdx;
	//		while(i < EndIdx) {
	//			@Var ZenFunc Func = FuncList.get(i);
	//			System.err.println("["+i+"] " + Func);
	//			i = i + 1;
	//		}
	//		System.err.println("" + StartIdx + " ===> " + EndIdx);
	//	}
	//
	//	private boolean IsAcceptFunc(ZenFunc Func, ArrayList<ZenNode> ParamList) {
	//		@Var int i = 0;
	//		while(i < ParamList.size()) {
	//			@Var ZenType FuncType = Func.FuncType.GetFuncParamType(i);
	//			@Var ZenType ParamType = ParamList.get(i).Type;
	//			if(Func.FuncType.GetFuncParamType(i) != ParamList.get(i).Type) {
	//				if(FuncType != ParamType && !FuncType.Accept(ParamType)) {
	//					return false;
	//				}
	//			}
	//			i = i + 1;
	//		}
	//		return true;
	//	}
	//
	//	private void GuessFuncTypeAcceptedParam(ArrayList<ZenFunc> FuncList, ZenApplyNode Node, int BaseSize) {
	//		@Var int i = 0;
	//		while(i < BaseSize) {
	//			@Var ZenFunc Func = FuncList.get(i);
	//			if(this.IsAcceptFunc(Func, Node.ParamList)) {
	//				Node.ResolvedFunc = FuncList.get(0);
	//			}
	//			i = i + 1;
	//		}
	//	}
}

//protected ZFunc InferFuncType(ZNameSpace NameSpace, String FuncName, ZType FuncType, ZToken SourceToken) {
//		if(FuncType.IsCompleteFunc(false)) {
//			@Var ZNameSpace RootNameSpace = NameSpace.GetRootNameSpace();
//			@Var String Signature = FuncType.StringfySignature(FuncName);
//			LibNative.Assert(!RootNameSpace.HasSymbol(Signature));
//			@Var ZFunc Func = new ZSignature(0, FuncName, (ZFuncType)FuncType, SourceToken);
//			RootNameSpace.SetSymbol(Signature, Func, null);
//			Func.Used();
//			return Func;
//		}
//		return null;
//	}
//
//	protected ZType GuessFuncType(ZNameSpace NameSpace, String FuncName, ZApplyNode Node, ZType ContextFuncType) {
//		if(Node.ResolvedFunc == null) {
//			@Var int FuncParamSize = Node.ParamList.size();
//			@Var ZType RecvType = Node.GetRecvType();
//			@Var String Signature = ZFunc.StringfySignature(FuncName, FuncParamSize, RecvType);
//			@Var Object Func = NameSpace.GetSymbol(Signature);
//			if(Func instanceof ZFunc) {
//				Node.ResolvedFunc = ((ZFunc)Func);
//				Node.ResolvedFunc.Used();
//				return Node.ResolvedFunc.GetFuncType();
//			}
//			Node.ResolvedFunc = this.InferFuncType(NameSpace, FuncName, ContextFuncType, Node.SourceToken);
//		}
//		if(Node.ResolvedFunc == null) {
//			this.println("unfound function call: " + FuncName + ", " + ContextFuncType);
//			return ContextFuncType;
//		}
//		return Node.ResolvedFunc.FuncType;
//	}


