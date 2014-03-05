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

package zen.codegen.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import zen.ast.ZAndNode;
import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZBlockNode;
import zen.ast.ZBooleanNode;
import zen.ast.ZCastNode;
import zen.ast.ZClassNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZIfNode;
import zen.ast.ZIntNode;
import zen.ast.ZLetNode;
import zen.ast.ZListNode;
import zen.ast.ZMacroNode;
import zen.ast.ZMapEntryNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZNullNode;
import zen.ast.ZOrNode;
import zen.ast.ZSetIndexNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZSugarNode;
import zen.ast.ZTypeNode;
import zen.ast.ZUnaryNode;
import zen.parser.ZEmptyValue;
import zen.parser.ZLogger;
import zen.parser.ZSourceEngine;
import zen.parser.ZTypeChecker;
import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.util.LibZen;
import zen.util.Var;
import zen.util.ZFloatArray;
import zen.util.ZIntArray;
import zen.util.ZObjectArray;
import zen.util.ZStringArray;
import zen.util.ZenMap;

public class JavaEngine extends ZSourceEngine {

	protected final JavaAsmGenerator Solution;
	protected Object EvaledValue = null;

	public JavaEngine(ZTypeChecker TypeChecker, JavaAsmGenerator Generator) {
		super(TypeChecker, Generator);
		this.Solution = Generator;
	}

	@Override public final void EnableVisitor() {
		this.EvaledValue = ZEmptyValue._TrueEmpty;
		super.EnableVisitor();
	}

	@Override public final void StopVisitor() {
		this.EvaledValue = ZEmptyValue._FalseEmpty;
		super.StopVisitor();
	}

	@Override protected final Object Eval(ZNode Node) {
		if(this.IsVisitable()) {
			Node.Accept(this);
		}
		return this.EvaledValue;
	}

	protected ZNode[] PackNodes(ZNode Node, ZListNode List) {
		int Start = 0;
		ZNode[] Nodes = new ZNode[List.GetListSize() + Start];
		if(Node != null) {
			Start = 1;
			Nodes[0] = Node;
		}
		for(int i = 0; i < Nodes.length; i++) {
			Nodes[i+Start] = List.GetListAt(i);
		}
		return Nodes;
	}

	Object NumberCast(Class<?> T, Number Value) {
		if(T == int.class || T == Integer.class) {
			return Value.intValue();
		}
		if(T == long.class || T == Long.class) {
			return Value.longValue();
		}
		if(T == double.class || T == Double.class) {
			return Value.longValue();
		}
		if(T == short.class || T == Short.class) {
			return Value.shortValue();
		}
		if(T == float.class || T == Float.class) {
			return Value.floatValue();
		}
		if(T == byte.class || T == Byte.class) {
			return Value.byteValue();
		}
		return Value;
	}

	void EvalConstructor(ZNode Node, Constructor<?> jMethod, ZListNode ListNode) {
		try {
			Object Values[] = new Object[ListNode.GetListSize()];
			Class<?> P[] = jMethod.getParameterTypes();
			for(int i = 0; i < ListNode.GetListSize(); i++) {
				Values[i] = this.Eval(ListNode.GetListAt(i));
				if(Values[i] instanceof Number) {
					Values[i] = this.NumberCast(P[i], (Number)Values[i]);
				}
			}
			if(this.IsVisitable()) {
				this.EvaledValue = jMethod.newInstance(Values);
			}
		} catch (Exception e) {
			ZLogger._LogError(Node.SourceToken, "runtime error: " + e);
			e.printStackTrace();
			this.StopVisitor();
		}
	}

	void EvalMethod(ZNode Node, Method jMethod, ZNode RecvNode, ZNode[] Nodes) {
		try {
			Object Recv = null;
			if(RecvNode != null && !Modifier.isStatic(jMethod.getModifiers())) {
				Recv = this.Eval(RecvNode);
			}
			Object Values[] = new Object[Nodes.length];
			Class<?> P[] = jMethod.getParameterTypes();
			for(int i = 0; i < Nodes.length; i++) {
				Values[i] = this.Eval(Nodes[i]);
				if(Values[i] instanceof Number) {
					Values[i] = this.NumberCast(P[i], (Number)Values[i]);
				}
			}
			if(this.IsVisitable()) {
				this.EvaledValue = jMethod.invoke(Recv, Values);
				if(jMethod.getReturnType() == void.class) {
					this.EvaledValue = ZEmptyValue._TrueEmpty;
				}
			}
		}
		catch(java.lang.reflect.InvocationTargetException e) {
			Throwable te = e.getCause();
			ZLogger._LogError(Node.SourceToken, "runtime error: " + te);
			te.printStackTrace();
			this.StopVisitor();
		}
		catch (Exception e) {
			ZLogger._LogInfo(Node.SourceToken, "runtime error: " + e);
			e.printStackTrace();
			this.StopVisitor();
		}
	}

	void EvalStaticMethod(ZNode Node, Method sMethod, ZNode[] Nodes) {
		this.EvalMethod(Node, sMethod, null, Nodes);
	}

	Method GetInvokeMethod(Object Recv) {
		Method[] m = Recv.getClass().getMethods();
		for(int i=0; i < m.length;i++) {
			if(m[i].getName().equals("Invoke")) {
				return m[i];
			}
		}
		return null;
	}

	void InvokeMethod(ZNode Node, Object Recv, ZListNode ListNode) {
		try {
			Method jMethod = this.GetInvokeMethod(Recv);
			//System.out.println("Recv="+Recv.getClass() + ", jMethod="+jMethod + "params=" + ListNode.GetListSize());
			Object Values[] = new Object[ListNode.GetListSize()];
			Class<?> P[] = jMethod.getParameterTypes();
			for(int i = 0; i < ListNode.GetListSize(); i++) {
				Values[i] = this.Eval(ListNode.GetListAt(i));
				if(Values[i] instanceof Number) {
					Values[i] = this.NumberCast(P[i], (Number)Values[i]);
				}
			}
			if(this.IsVisitable()) {
				this.EvaledValue = jMethod.invoke(Recv, Values);
				if(jMethod.getReturnType() == void.class) {
					this.EvaledValue = ZEmptyValue._TrueEmpty;
				}
			}
		} catch(java.lang.reflect.InvocationTargetException e) {
			Throwable te = e.getCause();
			ZLogger._LogError(Node.SourceToken, "invocation error: " + te);
			this.StopVisitor();
		} catch (Exception e) {
			ZLogger._LogError(Node.SourceToken, "invocation error: " + e);
			this.StopVisitor();
		}
	}



	@Override public void VisitNullNode(ZNullNode Node) {
		this.EvaledValue = null;
	}

	@Override public void VisitBooleanNode(ZBooleanNode Node) {
		this.EvaledValue = Node.BooleanValue;
	}

	@Override public void VisitIntNode(ZIntNode Node) {
		this.EvaledValue = Node.IntValue;
	}

	@Override public void VisitFloatNode(ZFloatNode Node) {
		this.EvaledValue = Node.FloatValue;
	}

	@Override public void VisitStringNode(ZStringNode Node) {
		this.EvaledValue = Node.StringValue;
	}

	@Override public void VisitTypeNode(ZTypeNode Node) {
		this.EvaledValue = Node.Type;
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		@Var ZNode Node1 = Node.GetNameSpace().GetSymbolNode(Node.VarName);
		if(Node1 != null) {
			this.EvaledValue = this.Eval(Node1);
		}
		else {
			ZLogger._LogError(Node.SourceToken, "undefined symbol: " + Node.VarName);
			this.StopVisitor();
		}
	}

	@Override public void VisitGroupNode(ZGroupNode Node) {
		this.EvaledValue = this.Eval(Node.AST[ZGroupNode._Expr]);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		Method sMethod = JavaMethodTable.GetStaticMethod("GetField");
		ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetterNode._Recv], NameNode});
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		Method sMethod = JavaMethodTable.GetStaticMethod("SetField");
		ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZSetterNode._Recv], NameNode, Node.AST[ZSetterNode._Expr]});
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.GetAstType(ZGetIndexNode._Recv), "[]", Node.GetAstType(ZGetIndexNode._Index));
		if(sMethod == null) {
			ZLogger._LogError(Node.SourceToken, "type error");
			return ;
		}
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetIndexNode._Recv], Node.AST[ZGetIndexNode._Index]});
	}

	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.GetAstType(ZSetIndexNode._Recv), "[]", Node.GetAstType(ZSetIndexNode._Index));
		if(sMethod == null) {
			ZLogger._LogError(Node.SourceToken, "type error");
			return ;
		}
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZSetIndexNode._Recv], Node.AST[ZSetIndexNode._Index], Node.AST[ZSetIndexNode._Expr]});
	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		if(Node.IsUntyped()) {
			ZLogger._LogError(Node.SourceToken, "ambigious array");
			this.StopVisitor();
		}
		else if(Node.Type.GetParamType(0).IsIntType()) {
			long Values[] = new long[Node.GetListSize()];
			for(int i = 0; i < Node.GetListSize(); i++) {
				Object Value = this.Eval(Node.GetListAt(i));
				if(Value instanceof Number) {
					Values[i] = ((Number)Value).longValue();
				}
			}
			if(this.IsVisitable()) {
				this.EvaledValue = new ZIntArray(Node.Type.TypeId, Values);
			}
		}
		else if(Node.Type.GetParamType(0).IsFloatType()) {
			double Values[] = new double[Node.GetListSize()];
			for(int i = 0; i < Node.GetListSize(); i++) {
				Object Value = this.Eval(Node.GetListAt(i));
				if(Value instanceof Number) {
					Values[i] = ((Number)Value).doubleValue();
				}
			}
			if(this.IsVisitable()) {
				this.EvaledValue = new ZFloatArray(Node.Type.TypeId, Values);
			}
		}
		else if(Node.Type.GetParamType(0).IsIntType()) {
			String Values[] = new String[Node.GetListSize()];
			for(int i = 0; i < Node.GetListSize(); i++) {
				Object Value = this.Eval(Node.GetListAt(i));
				if(Value instanceof String) {
					Values[i] = (String)Value;
				}
			}
			if(this.IsVisitable()) {
				this.EvaledValue = new ZStringArray(Node.Type.TypeId, Values);
			}
		}
		else {
			Object Values[] = new Object[Node.GetListSize()];
			for(int i = 0; i < Node.GetListSize(); i++) {
				Values[i] = this.Eval(Node.GetListAt(i));
			}
			if(this.IsVisitable()) {
				this.EvaledValue = new ZObjectArray(Node.Type.TypeId, Values);
			}
		}
	}

	@Override public void VisitMapLiteralNode(ZMapLiteralNode Node) {
		if(Node.IsUntyped()) {
			ZLogger._LogError(Node.SourceToken, "ambigious map");
			this.StopVisitor();
		}
		else {
			Object Values[] = new Object[Node.GetListSize()*2];
			for(int i = 0; i < Node.GetListSize(); i = i + 2) {
				ZMapEntryNode EntryNode = Node.GetMapEntryNode(i);
				Values[i*2] = EntryNode.Name;
				Values[i*2+1] = this.Eval(EntryNode.AST[ZMapEntryNode._Value]);
			}
			if(this.IsVisitable()) {
				this.EvaledValue = new ZenMap<Object>(Node.Type.TypeId, Values);
			}
		}
	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		Constructor<?> jMethod = this.Solution.GetConstructor(Node.Type, Node);
		if(jMethod != null) {
			this.EvalConstructor(Node, jMethod, Node);
		}
		else {
			ZLogger._LogError(Node.SourceToken, "no constructor: " + Node.Type);
			this.StopVisitor();
		}
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Method jMethod = this.Solution.GetMethod(Node.AST[ZMethodCallNode._Recv].Type, Node.MethodName, Node);
		if(jMethod != null) {
			this.EvalMethod(Node, jMethod, Node.AST[ZMethodCallNode._Recv], this.PackNodes(null, Node));
		}
		else {
			ZLogger._LogError(Node.SourceToken, "no method: " + Node.MethodName + " of " + Node.AST[ZMethodCallNode._Recv].Type);
			this.StopVisitor();
		}
	}

	@Override public void VisitMacroNode(ZMacroNode Node) {
		this.EvalStaticMethod(Node, ((JavaStaticFunc)Node.MacroFunc).StaticFunc, this.PackNodes(null, Node));
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		@Var ZFuncType FuncType = Node.GetFuncType();
		if(FuncType == null) {
			ZLogger._LogError(Node.SourceToken, "not function");
			this.StopVisitor();
		}
		else {
			@Var String FuncName = Node.GetFuncName();
			if(FuncName != null) {
				this.Solution.LazyBuild(FuncType.StringfySignature(FuncName));
				Class<?> FunctionClass = this.Solution.GetDefinedFunctionClass(FuncName, FuncType);
				Node.Set(ZFuncCallNode._Func, new JavaStaticFieldNode(Node, FunctionClass, FuncType, "function"));
			}
		}
		Object Recv = this.Eval(Node.AST[ZFuncCallNode._Func]);
		if(this.IsVisitable()) {
			this.InvokeMethod(Node, Recv, Node);
		}
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.GetText(), Node.AST[ZUnaryNode._Recv].Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZUnaryNode._Recv]});
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.GetText(), Node.AST[ZNotNode._Recv].Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZNotNode._Recv]});
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		if(Node.Type.IsVoidType()) {
			this.EvaledValue = this.Eval(Node.AST[ZCastNode._Expr]);
		}
		else {
			ZFunc Func = this.Generator.LookupConverterFunc(Node.AST[ZCastNode._Expr].Type, Node.Type);
			if(Func instanceof JavaStaticFunc) {
				this.EvalStaticMethod(Node, ((JavaStaticFunc)Func).StaticFunc, new ZNode[] {Node.AST[ZCastNode._Expr]});
				return;
			}
			this.EvaledValue = this.Eval(Node.AST[ZCastNode._Expr]);
			if(this.EvaledValue == null) {
				return;
			}
			if(this.IsVisitable()) {
				Class<?> CastClass = this.Solution.GetJavaClass(Node.Type);
				if(CastClass.isAssignableFrom(this.EvaledValue.getClass())) {
					return ;
				}
				else {
					ZLogger._LogError(Node.SourceToken, "no type coercion: " + Node.AST[ZCastNode._Expr].Type + " to " + Node.Type);
					this.StopVisitor();
				}
			}
		}
	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.AST[ZBinaryNode._Left].Type, Node.SourceToken.GetText(), Node.AST[ZBinaryNode._Right].Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZBinaryNode._Left], Node.AST[ZBinaryNode._Right]});
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.AST[ZBinaryNode._Left].Type, Node.SourceToken.GetText(), Node.AST[ZBinaryNode._Right].Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZBinaryNode._Left], Node.AST[ZBinaryNode._Right]});
	}

	@Override public void VisitAndNode(ZAndNode Node) {
		@Var Object BooleanValue = this.Eval(Node.AST[ZBinaryNode._Left]);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.AST[ZBinaryNode._Right]);
			}
			else {
				this.EvaledValue = false;
			}
		}
	}

	@Override public void VisitOrNode(ZOrNode Node) {
		@Var Object BooleanValue = this.Eval(Node.AST[ZBinaryNode._Left]);
		if(BooleanValue instanceof Boolean) {
			if(!(Boolean)BooleanValue) {
				this.EvaledValue = this.Eval(Node.AST[ZBinaryNode._Right]);
			}
			else {
				this.EvaledValue = true;
			}
		}
	}

	@Override public void VisitBlockNode(ZBlockNode Node) {
		@Var int i = 1;
		while(i < Node.GetListSize() && this.IsVisitable()) {
			ZNode StmtNode = Node.GetListAt(i);
			this.Eval(StmtNode);
			if(StmtNode.IsBreakingBlock()) {
				break;
			}
		}
		if(this.IsVisitable()) {
			this.EvaledValue = ZEmptyValue._TrueEmpty;
		}
	}

	@Override public void VisitIfNode(ZIfNode Node) {
		Object BooleanValue = this.Eval(Node.AST[ZIfNode._Cond]);
		if(BooleanValue instanceof Boolean) {
			if((Boolean)BooleanValue) {
				this.Eval(Node.AST[ZIfNode._Then]);
			}
			else if(Node.AST[ZIfNode._Else] != null) {
				this.Eval(Node.AST[ZIfNode._Then]);
			}
		}
		if(this.IsVisitable()) {
			this.EvaledValue = ZEmptyValue._TrueEmpty;
		}
	}


	@Override public void VisitLetNode(ZLetNode Node) {
		if(Node.HasUntypedNode()) {
			LibZen._PrintDebug("HasUntypedNode: " + Node.HasUntypedNode() + "\n" + Node);
		}
		this.Solution.StartCodeGeneration(Node, false);
	}

	@Override public void VisitFunctionNode(ZFunctionNode Node) {
		if(Node.HasUntypedNode()) {
			LibZen._PrintDebug("HasUntypedNode: " + Node.HasUntypedNode() + "\nLAZY: " + Node);
			this.Solution.LazyBuild(Node);
		}
		else {
			this.Solution.StartCodeGeneration(Node, false);
		}
	}

	@Override public void VisitClassNode(ZClassNode Node) {
		if(Node.HasUntypedNode()) {
			LibZen._PrintDebug("HasUntypedNode: " + Node.HasUntypedNode() + "\n" + Node);
		}
		this.Solution.StartCodeGeneration(Node, false);
	}

	private void VisitStaticFieldNode(JavaStaticFieldNode Node) {
		try {
			Field f = Node.StaticClass.getField(Node.FieldName);
			this.EvaledValue = f.get(null);
		} catch (Exception e) {
			ZLogger._LogError(Node.SourceToken, "unresolved symbol: " + e);
			this.StopVisitor();
		}
	}

	@Override public void VisitExtendedNode(ZNode Node) {
		if(Node instanceof JavaStaticFieldNode) {
			this.VisitStaticFieldNode((JavaStaticFieldNode)Node);
		}
		else {
			super.VisitExtendedNode(Node);
		}
	}

	@Override public void VisitSugarNode(ZSugarNode Node) {
		this.EvaledValue = this.Eval(Node.AST[ZSugarNode._DeSugar]);
	}

	@Override public void ExecMain() {
		this.Generator.Logger.ShowErrors();
		if(this.Solution.MainFuncNode != null) {
			@Var JavaStaticFieldNode MainFunc = this.Solution.MainFuncNode;
			try {
				Method Method = MainFunc.StaticClass.getMethod("f");
				Method.invoke(null);
			}
			catch(NoSuchMethodException e) {
				System.out.println(e);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
