// ***************************************************************************
// Copyright (c) 2013-2014, Konoha project authors. All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// *  Redistributions of source code must retain the above copyright notice,
//    this list of conditions and the following disclaimer.
// *  Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// **************************************************************************

//ifdef JAVA

package zen.lang;

import java.util.ArrayList;

import zen.ast.GtAndNode;
import zen.ast.GtApplyNode;
import zen.ast.GtArrayLiteralNode;
import zen.ast.GtBinaryNode;
import zen.ast.GtBlockNode;
import zen.ast.GtBooleanNode;
import zen.ast.GtBreakNode;
import zen.ast.GtCastNode;
import zen.ast.GtCatchNode;
import zen.ast.GtConstPoolNode;
import zen.ast.GtErrorNode;
import zen.ast.GtFloatNode;
import zen.ast.GtFuncDeclNode;
import zen.ast.GtFunctionLiteralNode;
import zen.ast.GtGetCapturedNode;
import zen.ast.GtGetIndexNode;
import zen.ast.GtGetLocalNode;
import zen.ast.GtGetterNode;
import zen.ast.GtGroupNode;
import zen.ast.GtIfNode;
import zen.ast.GtInstanceOfNode;
import zen.ast.GtIntNode;
import zen.ast.GtMapLiteralNode;
import zen.ast.GtMethodCallNode;
import zen.ast.GtNewArrayNode;
import zen.ast.GtNewObjectNode;
import zen.ast.GtNullNode;
import zen.ast.GtOrNode;
import zen.ast.GtParamNode;
import zen.ast.GtReturnNode;
import zen.ast.GtSetCapturedNode;
import zen.ast.GtSetIndexNode;
import zen.ast.GtSetLocalNode;
import zen.ast.GtSetterNode;
import zen.ast.GtStringNode;
import zen.ast.GtThrowNode;
import zen.ast.GtTryNode;
import zen.ast.GtUnaryNode;
import zen.ast.GtVarDeclNode;
import zen.ast.GtWhileNode;
import zen.ast.ZenComparatorNode;
import zen.ast.ZenNode;
import zen.ast.ZenNotNode;
import zen.parser.ZenLogger;
import zen.parser.ZenNameSpace;
import zen.parser.ZenUtils;
import zen.parser.ZenVisitor;

abstract class ZenTypeChecker implements ZenVisitor {
	public final static int DefaultTypeCheckPolicy			= 0;
	public final static int NoCheckPolicy                   = 1;
	public final static int CastPolicy                      = (1 << 1);
	public final static int IgnoreEmptyPolicy               = (1 << 2);
	public final static int AllowEmptyPolicy                = (1 << 3);
	public final static int AllowVoidPolicy                 = (1 << 4);
	public final static int AllowCoercionPolicy             = (1 << 5);
	public final static int OnlyConstPolicy                 = (1 << 6);
	public final static int NullablePolicy                  = (1 << 8);
	public final static int BlockPolicy                     = (1 << 7);

	/*field*/private ZenNameSpace NameSpace_;
	/*field*/private ZenType ContextType_;
	/*field*/private ZenNode TypedNode_;

	/*field*/public ZenLogger Logger;
	/*field*/private boolean StoppedVisitor;

	public ZenTypeChecker(ZenLogger Logger) {
		this.Logger = Logger;
		this.NameSpace_ = null;
		this.ContextType_ = null;
		this.TypedNode_ = null;
		this.StoppedVisitor = false;
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

	public final ZenNameSpace GetNameSpace() {
		return this.NameSpace_;
	}

	public final ZenType GetContextType() {
		return this.ContextType_;
	}

	public final void TypedNode(ZenNode Node, ZenType Type) {
		Node.Type = Type;
		if(this.IsVisitable()) {
			this.TypedNode_ = Node;
		}
	}

	public final void Todo(ZenNode Node) {
		this.Logger.ReportWarning(Node.SourceToken, "TODO: unimplemented type checker node: " + Node.getClass().getSimpleName());
		Node.Type = ZenSystem.AnyType;
		if(this.IsVisitable()) {
			this.TypedNode_ = Node;
		}
	}

	public final void CheckErrorNode(ZenNode Node) {
		if(Node.IsErrorNode()) {
			this.TypedNode_ = Node;
			this.StopVisitor();
		}
	}

	public final void TypeCheckNodeList(ZenNameSpace NameSpace, ArrayList<ZenNode> ParamList) {
		if(this.IsVisitable()) {
			for(int i = 0; i < ParamList.size(); i = i + 1) {
				ZenNode SubNode = ParamList.get(i);
				SubNode = this.TypeCheck(SubNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
				ParamList.set(i, SubNode);
			}
		}
	}

	public final ZenNode TypeCheck(ZenNode Node, ZenNameSpace NameSpace, ZenType ContextType, int TypeCheckPolicy) {
		if(this.IsVisitable()) {
			ZenNode ParentNode = Node.ParentNode;
			ZenNameSpace NameSpace_ = this.NameSpace_;
			ZenType ContextType_ = this.ContextType_;
			ZenNode TypedNode_ = this.TypedNode_;
			this.NameSpace_ = NameSpace;
			this.ContextType_ = ContextType;
			if(Node.Type == null || Node.Type.IsVarType()) {
				Node.Accept(this);
				Node = this.TypedNode_;
			}
			Node = this.TypeCheckImpl(Node, ContextType, TypeCheckPolicy);
			this.NameSpace_ = NameSpace_;
			this.ContextType_ = ContextType_;
			this.TypedNode_ = TypedNode_;
			if(ParentNode != Node.ParentNode && ParentNode != null) {
				ParentNode.SetChild(Node);
			}
		}
		this.CheckErrorNode(Node);
		return Node;
	}

	private final ZenNode TypeCheckImpl(ZenNode Node, ZenType ContextType, int TypeCheckPolicy) {
		if(Node.IsErrorNode()) {
			return Node;
		}
		//		if(Node.Type.IsUnrevealedType()) {
		//			/*local*/GtFunc Func = ParsedTree.NameSpace.GetConverterFunc(Node.Type, Node.Type.BaseType, true);
		//			Node = this.Generator.CreateCoercionNode(Func.GetReturnType(), ParsedTree.NameSpace, Func, Node);
		//		}
		//		System.err.println("**** " + Node.getClass());
		//		/*local*/Object ConstValue = Node.ToConstValue(this.Context, IsFlag(TypeCheckPolicy, OnlyConstPolicy));
		//		if(ConstValue != null && !(Node.IsConstNode())) {  // recreated
		//			Node = this.Generator.CreateConstNode_OLD(Node.Type, ParsedTree, ConstValue);
		//		}
		//		if(IsFlag(TypeCheckPolicy, OnlyConstPolicy) && ConstValue == null) {
		//			if(IsFlag(TypeCheckPolicy, NullablePolicy) && Node.IsNullNode()) { // OK
		//			}
		//			else {
		//				return this.CreateSyntaxErrorNode(ParsedTree, "value must be const");
		//			}
		//		}
		if(ZenUtils.IsFlag(TypeCheckPolicy, ZenTypeChecker.AllowVoidPolicy) || Node.Type.IsVoidType()) {
			return Node;
		}
		if(Node.Type == ContextType || ContextType.IsVarType() || ContextType.Accept(Node.Type)) {
			return Node;
		}
		//		/*local*/GtFunc Func1 = this.GetConverterFunc(Node.Type, ContextType, true);
		//		if(Func1 != null && (Func1.Is(CoercionFunc) || IsFlag(TypeCheckPolicy, CastPolicy))) {
		//			return this.Generator.CreateCoercionNode(Type, ParsedTree.NameSpace, Func1, Node);
		//		}
		//System.err.println("node="+ LibZen.GetClassName(Node) + "type error: requested = " + Type + ", given = " + Node.Type);
		return new GtErrorNode(Node.SourceToken, "type error: requested = " + ContextType + ", given = " + Node.Type);
	}

	protected final ZenType GetFieldType(ZenNameSpace NameSpace, ZenType BaseType, String Name) {
		return NameSpace.Generator.GetFieldType(BaseType, Name);
	}

	protected final ZenType GetSetterType(ZenNameSpace NameSpace, ZenType BaseType, String Name) {
		return NameSpace.Generator.GetSetterType(BaseType, Name);
	}

	protected ZenType GetReturnType(ZenNameSpace NameSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void InferReturnType(ZenNameSpace NameSpace, ZenType InferredType) {
		// TODO Auto-generated method stub
	}

	protected ZenNode CreateDefaultValueNode(ZenType Type) {
		// TODO Auto-generated method stub
		return null;
	}

	protected ZenNode CreateReadOnlyErrorNode(ZenNode Node, ZenType ClassType, String NativeName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZenVarInfo GetVarInfo(ZenNameSpace nameSpace, String nativeName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void SetVarInfo(ZenNameSpace NameSpace, ZenType VarType, String NativeName) {
		ZenVarInfo VarInfo = new ZenVarInfo();
		// TODO Auto-generated method stub

	}

	public void UntypedNameNode(String nativeName, GtGetLocalNode node) {
		// TODO Auto-generated method stub

	}


	public ZenNode CanDefineFunc(ZenNameSpace nameSpace, String funcName,
			ZenFuncType funcType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZenFunc Define(ZenNameSpace nameSpace, String funcName,
			ZenFuncType funcType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZenFunc SetFuncParamType(ZenNameSpace NameSpace, ZenFunc DefinedFunc, ArrayList<ZenNode> ArgumentList) {
		// TODO Auto-generated method stub
		return null;
	}

	public void PopFunc(ZenFunc upperFunc) {
		// TODO Auto-generated method stub

	}

	public ZenFuncType CheckFunctionType(ZenFuncType funcType,
			ZenType contextType) {
		// TODO Auto-generated method stub
		return null;
	}

	public void UpdateParamType() {
		// TODO Auto-generated method stub

	}

}

public class ZenTypeCheckerImpl2 extends ZenTypeChecker {

	public ZenTypeCheckerImpl2(ZenLogger Logger) {
		super(Logger);
	}

	@Override public void VisitNullNode(GtNullNode Node) {
		ZenType Type = this.GetContextType();
		if(Type.IsVarType()) {
			Type = ZenSystem.AnyType;
		}
		this.TypedNode(Node, Type);
	}

	@Override public void VisitBooleanNode(GtBooleanNode Node) {
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override
	public void VisitIntNode(GtIntNode Node) {
		this.TypedNode(Node, ZenSystem.IntType);
	}

	@Override public void VisitFloatNode(GtFloatNode Node) {
		this.TypedNode(Node, ZenSystem.FloatType);
	}

	@Override public void VisitStringNode(GtStringNode Node) {
		this.TypedNode(Node, ZenSystem.StringType);
	}

	@Override
	public void VisitConstPoolNode(GtConstPoolNode Node) {
		this.TypedNode(Node, ZenSystem.GuessType(Node.ConstValue));
	}

	@Override
	public void VisitArrayLiteralNode(GtArrayLiteralNode Node) {
		this.Todo(Node);
	}

	@Override
	public void VisitMapLiteralNode(GtMapLiteralNode Node) {
		this.Todo(Node);
	}

	@Override
	public void VisitNewArrayNode(GtNewArrayNode Node) {
		this.Todo(Node);
	}

	@Override
	public void VisitNewObjectNode(GtNewObjectNode Node) {
		this.Todo(Node);
	}

	@Override
	public void VisitGetLocalNode(GtGetLocalNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenVarInfo VarInfo = this.GetVarInfo(NameSpace, Node.NativeName);
		if(VarInfo != null) {
			Node.NativeName = VarInfo.NativeName;
			this.TypedNode(Node, VarInfo.Type);
			return;
		}
		this.UntypedNameNode(Node.NativeName, Node);
	}

	@Override
	public void VisitSetLocalNode(GtSetLocalNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenVarInfo VarInfo = this.GetVarInfo(NameSpace, Node.NativeName);
		if(VarInfo != null) {
			Node.NativeName = VarInfo.NativeName;
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, VarInfo.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
			this.TypedNode(Node, ZenSystem.VoidType);
			return;
		}
		//		this.UntypedNameNode(Node.NativeName, Node);
	}

	@Override
	public void VisitGetCapturedNode(GtGetCapturedNode Node) {
		this.Todo(Node);
	}

	@Override
	public void VisitSetCapturedNode(GtSetCapturedNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.Todo(Node);
	}

	@Override
	public void VisitGetIndexNode(GtGetIndexNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.Todo(Node);
	}

	@Override public void VisitSetIndexNode(GtSetIndexNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.IndexNode = this.TypeCheck(Node.IndexNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.Todo(Node);
	}

	@Override public void VisitGroupNode(GtGroupNode Node) {
		Node.Accept(this); // this is shortcut
	}

	@Override public void VisitGetterNode(GtGetterNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		ZenType FieldType = this.GetFieldType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		this.TypedNode(Node, FieldType);
	}

	@Override public void VisitSetterNode(GtSetterNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		ZenType FieldType = this.GetSetterType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		if(FieldType.IsVoidType()) {
			this.CheckErrorNode(this.CreateReadOnlyErrorNode(Node, Node.RecvNode.Type, Node.NativeName));
		}
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, FieldType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitMethodCallNode(GtMethodCallNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypeCheckNodeList(NameSpace, Node.ParamList);
		this.Todo(Node);
	}

	@Override public void VisitApplyNode(GtApplyNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		this.TypeCheckNodeList(NameSpace, Node.ParamList);
		this.Todo(Node);
	}

	@Override public void VisitUnaryNode(GtUnaryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.Todo(Node);
	}

	@Override public void VisitNotNode(ZenNotNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitCastNode(GtCastNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.ExprNode = this.TypeCheck(Node.ExprNode, NameSpace, Node.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, Node.Type);
	}

	@Override public void VisitInstanceOfNode(GtInstanceOfNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.LeftNode.IsErrorNode()) {
			this.Todo(Node.LeftNode);
		}
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitBinaryNode(GtBinaryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.Todo(Node);
	}

	@Override public void VisitComparatorNode(ZenComparatorNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitAndNode(GtAndNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitOrNode(GtOrNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.BooleanType);
	}

	@Override public void VisitBlockNode(GtBlockNode Node) {
		if(this.IsVisitable()) {
			int i = 0;
			while(i < Node.StatementList.size()) {
				ZenNode SubNode = Node.StatementList.get(i);
				SubNode = this.TypeCheck(SubNode, Node.NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
				Node.StatementList.set(i, SubNode);
				if(SubNode.IsBreakingBlock()) {
					break;
				}
				i = i + 1;
			}
			this.EnableVisitor();
			this.TypedNode(Node, ZenSystem.VoidType);
		}
	}

	@Override public void VisitVarDeclNode(GtVarDeclNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenType VarType = Node.Type;
		if(Node.Type == null) {
			Node.InitNode = this.TypeCheck(Node.InitNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
			VarType = Node.InitNode.Type;
		}
		else {
			Node.InitNode = this.TypeCheck(Node.InitNode, NameSpace, Node.Type, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		if(this.IsVisitable()) {
			this.SetVarInfo(NameSpace, VarType, Node.NativeName);
			this.VisitBlockNode(Node);
		}
	}

	@Override public void VisitIfNode(GtIfNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.ThenNode = this.TypeCheck(Node.ThenNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.ElseNode != null) {
			Node.ElseNode = this.TypeCheck(Node.ElseNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitReturnNode(GtReturnNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenType ReturnType = this.GetReturnType(NameSpace);
		if(Node.ValueNode != null) {
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ReturnType, ZenTypeChecker.DefaultTypeCheckPolicy);
			if(Node.ValueNode.IsErrorNode()) {
				this.Todo(Node.ValueNode);
			}
		}
		if(ReturnType.IsVarType()) {
			if(Node.ValueNode == null) {
				this.InferReturnType(NameSpace, ZenSystem.VoidType);
			}
			else {
				this.InferReturnType(NameSpace, Node.ValueNode.Type);
			}
		}
		else if(ReturnType.IsVoidType()) {
			if(Node.ValueNode != null) {
				Node.ValueNode = null;
			}
		}
		else {
			if(Node.ValueNode == null) {
				Node.ValueNode = this.CreateDefaultValueNode(ReturnType);
			}
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitWhileNode(GtWhileNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitBreakNode(GtBreakNode Node) {
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override
	public void VisitThrowNode(GtThrowNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ZenSystem.VarType, ZenTypeChecker.DefaultTypeCheckPolicy);
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override
	public void VisitTryNode(GtTryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.TryNode = this.TypeCheck(Node.TryNode, NameSpace, ZenSystem.BooleanType, ZenTypeChecker.DefaultTypeCheckPolicy);
		if(Node.CatchNode != null) {
			Node.CatchNode = this.TypeCheck(Node.CatchNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		if(Node.FinallyNode != null) {
			Node.FinallyNode = this.TypeCheck(Node.FinallyNode, NameSpace, ZenSystem.VoidType, ZenTypeChecker.DefaultTypeCheckPolicy);
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override
	public void VisitCatchNode(GtCatchNode Node) {
		// TODO Auto-generated method stub
		this.Todo(Node);
	}

	@Override
	public void VisitParamNode(GtParamNode Node) {
		// TODO Auto-generated method stub
		this.Todo(Node);
	}

	protected ZenFuncType LookupTypeFunc(ZenType ReturnType, ArrayList<ZenNode> NodeList) {
		ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
		TypeList.add(ReturnType);
		int i = 0;
		while(i < NodeList.size()) {
			GtParamNode Node = (GtParamNode)NodeList.get(i);
			if(Node.Type == null) {
				Node.Type = ZenSystem.VarType;
			}
			TypeList.add(Node.Type);
			i = i + 1;
		}
		return ZenSystem.LookupFuncType(TypeList);
	}

	@Override public void VisitFunctionLiteralNode(GtFunctionLiteralNode Node) {
		ZenType ContextType = this.GetContextType();
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenFuncType FuncType = this.LookupTypeFunc(Node.ReturnType, Node.ArgumentList);
		if(ContextType instanceof ZenFuncType) {
			FuncType = this.CheckFunctionType(FuncType, ContextType);
			if(FuncType == null) {
				//TODO Error;
			}
		}
		ZenFunc DefinedFunc = this.Define(NameSpace, "", FuncType);
		ZenFunc UpperFunc = this.SetFuncParamType(NameSpace, DefinedFunc, Node.ArgumentList);
		Node.BodyNode = this.TypeCheck(Node.BodyNode, NameSpace, ZenSystem.VarType, 0);
		//this.UpdateParamType(FuncType);
		this.PopFunc(UpperFunc);
		this.TypedNode(Node, FuncType);
	}

	@Override public void VisitFuncDeclNode(GtFuncDeclNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenFuncType FuncType = this.LookupTypeFunc(Node.ReturnType, Node.ArgumentList);
		this.CheckErrorNode(this.CanDefineFunc(NameSpace, Node.FuncName, FuncType));
		if(this.IsVisitable()) {
			ZenFunc DefinedFunc = this.Define(NameSpace, Node.FuncName, FuncType);
			if(DefinedFunc.IsLazyDef()) {
				this.TypedNode(Node, ZenSystem.VoidType);
			}
			ZenFunc UpperFunc = this.SetFuncParamType(Node.NameSpace, DefinedFunc, Node.ArgumentList);
			Node.BodyNode = this.TypeCheck(Node.BodyNode, Node.NameSpace, ZenSystem.VarType, 0);
			this.PopFunc(UpperFunc);
		}
		this.TypedNode(Node, ZenSystem.VoidType);
	}

	@Override public void VisitErrorNode(GtErrorNode Node) {
		this.CheckErrorNode(Node);
	}

}
