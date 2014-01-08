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
import zen.ast.ZenNode;
import zen.ast2.GtNewArrayNode;
import zen.ast2.GtNewObjectNode;
import zen.parser.ZenNameSpace;
import zen.parser.ZenUtils;
import zen.parser.ZenVisitor;


abstract class ZenTypeCheckerImpl implements ZenVisitor {
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

	public final ZenNameSpace GetNameSpace() {
		return this.NameSpace_;
	}

	public final ZenType GetContextType() {
		return this.ContextType_;
	}

	public final void ReturnTypedNode(ZenNode Node) {
		this.TypedNode_ = Node;
	}

	public final void ReturnNode(ZenNode Node, ZenType Type) {
		Node.Type = Type;
		this.TypedNode_ = Node;
	}

	public final ZenNode TypeCheck(ZenNode Node, ZenNameSpace NameSpace, ZenType ContextType, int TypeCheckPolicy) {
		ZenNameSpace NameSpace_ = this.NameSpace_;
		ZenType ContextType_ = this.ContextType_;
		ZenNode TypedNode_ = this.TypedNode_;
		this.NameSpace_ = NameSpace;
		this.ContextType_ = ContextType;
		if(Node.Type.IsVarType()) {
			Node.Accept(this);
			Node = this.TypedNode_;
		}
		Node = this.TypeCheckImpl(Node, ContextType, TypeCheckPolicy);
		this.NameSpace_ = NameSpace_;
		this.ContextType_ = ContextType_;
		this.TypedNode_ = TypedNode_;
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
		if(ZenUtils.IsFlag(TypeCheckPolicy, ZenTypeCheckerImpl.AllowVoidPolicy) || Node.Type.IsVoidType()) {
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

}

public abstract class ZenTypeChecker extends ZenTypeCheckerImpl {

	@Override
	public void VisitNullNode(GtNullNode Node) {
		ZenType Type = this.GetContextType();
		if(Type.IsVarType()) {
			Type = ZenSystem.AnyType;
		}
		this.ReturnNode(Node, Type);
	}

	@Override
	public void VisitBooleanNode(GtBooleanNode Node) {
		Node.Type = ZenSystem.BooleanType;
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitIntNode(GtIntNode Node) {
		Node.Type = ZenSystem.IntType;
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitFloatNode(GtFloatNode Node) {
		Node.Type = ZenSystem.FloatType;
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitStringNode(GtStringNode Node) {
		Node.Type = ZenSystem.StringType;
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitConstPoolNode(GtConstPoolNode Node) {
		Node.Type = ZenSystem.GuessType(Node.ConstValue);
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitArrayLiteralNode(GtArrayLiteralNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitMapLiteralNode(GtMapLiteralNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitNewArrayNode(GtNewArrayNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitNewObjectNode(GtNewObjectNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitGetLocalNode(GtGetLocalNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitSetLocalNode(GtSetLocalNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitGetCapturedNode(GtGetCapturedNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitSetCapturedNode(GtSetCapturedNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitGetIndexNode(GtGetIndexNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.RecvNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.RecvNode);
		}

		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitSetIndexNode(GtSetIndexNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitGroupNode(GtGroupNode Node) {
		this.ReturnTypedNode(this.TypeCheck(Node.RecvNode, this.GetNameSpace(), this.GetContextType(), ZenTypeCheckerImpl.DefaultTypeCheckPolicy));
	}

	@Override public void VisitGetterNode(GtGetterNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.RecvNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.RecvNode);
		}
		ZenType FieldType = this.GetFieldType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		Node.Type = FieldType;
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitSetterNode(GtSetterNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenType ContextType = this.GetContextType();
		Node.RecvNode = this.TypeCheck(Node.RecvNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.RecvNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.RecvNode);
		}
		ZenType FieldType = this.GetSetterType(NameSpace, Node.RecvNode.Type, Node.NativeName);
		if(FieldType.IsVoidType()) {
			this.ReturnTypedNode(this.CreateReadOnlyErrorNode(Node, Node.RecvNode.Type, Node.NativeName));
		}
		Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, FieldType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.ValueNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.ValueNode);
		}
		Node.Type = ContextType.IsVoidType() ? ContextType : FieldType;
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitMethodCallNode(GtMethodCallNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitApplyNode(GtApplyNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		int i = 0;
		while(i < Node.ParamList.size()) {
			ZenNode SubNode = Node.ParamList.get(i);
			SubNode = this.TypeCheck(SubNode, NameSpace, ZenSystem.VarType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
			if(SubNode.IsErrorNode()) {
				this.ReturnTypedNode(SubNode);
			}
			Node.ParamList.set(i, SubNode);
			i = i + 1;
		}
		this.ReturnNode(Node, ZenSystem.VarType);
	}

	@Override public void VisitAndNode(GtAndNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.LeftNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.LeftNode);
		}
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.RightNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.RightNode);
		}
		Node.Type = ZenSystem.BooleanType;
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitOrNode(GtOrNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.LeftNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.LeftNode);
		}
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.RightNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.RightNode);
		}
		Node.Type = ZenSystem.BooleanType;
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitUnaryNode(GtUnaryNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitBinaryNode(GtBinaryNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.LeftNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.LeftNode);
		}
		Node.RightNode = this.TypeCheck(Node.RightNode, NameSpace, ZenSystem.VarType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.RightNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.RightNode);
		}
		//		GtType OperatorType = this.GetBinaryOperatorType(Node.LeftNode.Type, Node.SourceToken, Node.RightNode.Type);
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitCastNode(GtCastNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitInstanceOfNode(GtInstanceOfNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.LeftNode = this.TypeCheck(Node.LeftNode, NameSpace, ZenSystem.VarType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.LeftNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.LeftNode);
		}
		this.ReturnNode(Node, ZenSystem.BooleanType);
	}

	@Override
	public void VisitBlockNode(GtBlockNode Node) {
		ZenType ContextType = this.GetContextType();
		int i = 0;
		while(i < Node.StatementList.size() - 1) {
			ZenNode SubNode = Node.StatementList.get(i);
			SubNode = this.TypeCheck(SubNode, Node.NameSpace, ZenSystem.VoidType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
			Node.StatementList.set(i, SubNode);
			i = i + 1;
		}
		if(i < Node.StatementList.size()) {
			ZenNode LastNode = Node.StatementList.get(i);
			LastNode = this.TypeCheck(LastNode, Node.NameSpace, ContextType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
			Node.StatementList.set(i, LastNode);
			if(ContextType.IsVarType()) {
				ContextType = LastNode.Type;
			}
		}
		this.ReturnNode(Node, ContextType);
	}

	@Override
	public void VisitVarDeclNode(GtVarDeclNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override public void VisitIfNode(GtIfNode Node) {
		ZenType ContextType = this.GetContextType();
		ZenNameSpace NameSpace = this.GetNameSpace();
		Node.CondNode = this.TypeCheck(Node.CondNode, NameSpace, ZenSystem.BooleanType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.CondNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.CondNode);
		}
		Node.ThenNode = this.TypeCheck(Node.ThenNode, NameSpace, ContextType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		if(Node.ThenNode.IsErrorNode()) {
			this.ReturnTypedNode(Node.ThenNode);
		}
		if(Node.ElseNode != null) {
			Node.ElseNode = this.TypeCheck(Node.ElseNode, NameSpace, Node.ThenNode.Type, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
		}
		this.ReturnNode(Node, Node.ThenNode.Type);
	}

	@Override public void VisitReturnNode(GtReturnNode Node) {
		ZenNameSpace NameSpace = this.GetNameSpace();
		ZenType ReturnType = this.GetReturnType(NameSpace);
		if(Node.ValueNode != null) {
			Node.ValueNode = this.TypeCheck(Node.ValueNode, NameSpace, ReturnType, ZenTypeCheckerImpl.DefaultTypeCheckPolicy);
			if(Node.ValueNode.IsErrorNode()) {
				this.ReturnTypedNode(Node.ValueNode);
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
		this.ReturnNode(Node, ZenSystem.VoidType);
	}

	@Override
	public void VisitWhileNode(GtWhileNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitBreakNode(GtBreakNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitThrowNode(GtThrowNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitTryNode(GtTryNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitCatchNode(GtCatchNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitParamNode(GtParamNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitFunctionLiteralNode(GtFunctionLiteralNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitFuncDeclNode(GtFuncDeclNode Node) {
		// TODO Auto-generated method stub
		this.ReturnTypedNode(Node);
	}

	@Override
	public void VisitErrorNode(GtErrorNode Node) {
		Node.Type = ZenSystem.VoidType;
		this.ReturnTypedNode(Node);
	}

}

