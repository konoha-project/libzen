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

package zen.codegen.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import zen.ast.ZArrayLiteralNode;
import zen.ast.ZBinaryNode;
import zen.ast.ZCastNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZListNode;
import zen.ast.ZMapEntryNode;
import zen.ast.ZMapLiteralNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZUnaryNode;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.deps.ZFloatArray;
import zen.deps.ZIntArray;
import zen.deps.ZObjectArray;
import zen.deps.ZStringArray;
import zen.deps.ZenMap;
import zen.parser.ZEmptyValue;
import zen.parser.ZScriptEngine;
import zen.type.ZFunc;
import zen.type.ZFuncType;
import zen.type.ZTypeChecker;

public class JavaEngine extends ZScriptEngine {

	private final JavaGenerator Solution;

	public JavaEngine(ZTypeChecker TypeChecker, JavaGenerator Generator) {
		super(TypeChecker, Generator);
		this.Solution = Generator;
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
			this.Logger.ReportInfo(Node.SourceToken, "runtime error: " + e);
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
					this.EvaledValue = ZEmptyValue.TrueEmpty;
				}
			}
		}
		catch(java.lang.reflect.InvocationTargetException e) {
			Throwable te = e.getCause();
			this.Logger.ReportError2(Node, "runtime error: " + te);
			te.printStackTrace();
			this.StopVisitor();
		}
		catch (Exception e) {
			this.Logger.ReportInfo(Node.SourceToken, "runtime error: " + e);
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
					this.EvaledValue = ZEmptyValue.TrueEmpty;
				}
			}
		} catch(java.lang.reflect.InvocationTargetException e) {
			Throwable te = e.getCause();
			this.Logger.ReportError(Node.SourceToken, "invocation error: " + te);
			te.printStackTrace();
			this.StopVisitor();
		} catch (Exception e) {
			this.Logger.ReportError(Node.SourceToken, "invocation error: " + e);
			this.StopVisitor();
		}
	}

	public void VisitStaticFieldNode(JavaStaticFieldNode Node) {
		try {
			Field f = Node.StaticClass.getField(Node.FieldName);
			this.EvaledValue = f.get(null);
		} catch (Exception e) {
			LibZen._FixMe(e);
			this.StopVisitor();
		}
	}

	@Override public void VisitGetNameNode(ZGetNameNode Node) {
		@Var ZNode Node1 = Node.GetNameSpace().GetSymbolNode(Node.VarName);
		if(Node1 != null) {
			this.EvaledValue = this.Eval(Node1);
		}
		else {
			this.Unsupported(Node, "undefined symbol: " + Node.VarName);
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
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.AST[ZGetIndexNode._Recv].Type, "[]", Node.AST[ZGetIndexNode._Index].Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.AST[ZGetIndexNode._Recv], Node.AST[ZGetIndexNode._Index]});
	}

	//	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
	//		this.Unsupported(Node);
	//	}

	@Override public void VisitArrayLiteralNode(ZArrayLiteralNode Node) {
		if(Node.IsUntyped()) {
			this.Logger.ReportError2(Node, "ambigious array");
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
			this.Logger.ReportError2(Node, "ambigious map");
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
			this.Logger.ReportError(Node.SourceToken, "no constructor: " + Node.Type);
			this.StopVisitor();
		}
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Method jMethod = this.Solution.GetMethod(Node.AST[ZMethodCallNode._Recv].Type, Node.MethodName, Node);
		if(jMethod != null) {
			this.EvalMethod(Node, jMethod, Node.AST[ZMethodCallNode._Recv], this.PackNodes(null, Node));
		}
		else {
			this.Logger.ReportError(Node.SourceToken, "no method: " + Node.MethodName + " of " + Node.AST[ZMethodCallNode._Recv].Type);
			this.StopVisitor();
		}
	}

	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		if(Node.ResolvedFunc instanceof JavaStaticFunc) {
			this.EvalStaticMethod(Node, ((JavaStaticFunc)Node.ResolvedFunc).StaticFunc, this.PackNodes(null, Node));
			return;
		}
		if(Node.ResolvedFuncName != null && Node.ResolvedFunc == null) {
			this.Logger.ReportError(Node.SourceToken, "undefined function: " + Node.ResolvedFuncName);
			this.StopVisitor();
			return;
		}
		if(Node.ResolvedFunc != null) {
			ZFuncType FuncType = Node.ResolvedFunc.GetFuncType();
			Class<?> FunctionClass = this.Solution.GetDefinedFunctionClass(Node.ResolvedFuncName, FuncType);
			Node.Set(ZFuncCallNode._Func, new JavaStaticFieldNode(Node, FunctionClass, FuncType, "function"));
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
			ZFunc Func = this.Generator.GetConverterFunc(Node.AST[ZCastNode._Expr].Type, Node.Type);
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
					this.Logger.ReportError(Node.SourceToken, "no type coercion: " + Node.AST[ZCastNode._Expr].Type + " to " + Node.Type);
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

}
