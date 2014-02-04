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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import zen.ast.ZBinaryNode;
import zen.ast.ZCastNode;
import zen.ast.ZComparatorNode;
import zen.ast.ZFuncCallNode;
import zen.ast.ZGetIndexNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZGetterNode;
import zen.ast.ZGroupNode;
import zen.ast.ZMethodCallNode;
import zen.ast.ZNewObjectNode;
import zen.ast.ZNode;
import zen.ast.ZNotNode;
import zen.ast.ZSetterNode;
import zen.ast.ZStringNode;
import zen.ast.ZUnaryNode;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.lang.ZFunc;
import zen.lang.ZenEngine;
import zen.lang.ZenGamma;
import zen.type.ZTypeChecker;

public class JavaEngine extends ZenEngine {

	private final JavaSolution Solution;
	public JavaEngine(ZTypeChecker TypeChecker, JavaSolution Generator) {
		super(TypeChecker, Generator);
		this.Solution = Generator;
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

	void EvalConstructor(ZNode Node, Constructor<?> jMethod, ZNode[] Nodes) {
		try {
			Object Values[] = new Object[Nodes.length];
			Class<?> P[] = jMethod.getParameterTypes();
			for(int i = 0; i < Nodes.length; i++) {
				Values[i] = this.Eval(Nodes[i]);
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
			}
		} catch (Exception e) {
			this.Logger.ReportInfo(Node.SourceToken, "runtime error: " + e);
			e.printStackTrace();
			this.StopVisitor();
		}
	}

	void EvalStaticMethod(ZNode Node, Method sMethod, ZNode[] Nodes) {
		this.EvalMethod(Node, sMethod, null, Nodes);
	}

	public void VisitJvmFuncNode(JvmFuncNode Node) {
		try {
			Field f = Node.FuncClass.getField("function");
			this.EvaledValue = f.get(null);
		} catch (Exception e) {
			LibNative.FixMe(e);
			this.EvaledValue = null;
		}
	}

	public void VisitStaticFieldNode(StaticFieldNode Node) {
		try {
			Field f = Node.StaticClass.getField(Node.FieldName);
			this.EvaledValue = f.get(null);
		} catch (Exception e) {
			LibNative.FixMe(e);
			this.EvaledValue = null;
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
		this.EvaledValue = this.Eval(Node.RecvNode);
	}

	@Override public void VisitGetterNode(ZGetterNode Node) {
		Method sMethod = JavaMethodTable.GetStaticMethod("GetField");
		ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode});
	}

	@Override public void VisitSetterNode(ZSetterNode Node) {
		Method sMethod = JavaMethodTable.GetStaticMethod("SetField");
		ZNode NameNode = new ZStringNode(Node, null, Node.FieldName);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, NameNode, Node.ValueNode});
	}

	@Override public void VisitGetIndexNode(ZGetIndexNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.RecvNode.Type, "[]", Node.IndexNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode, Node.IndexNode});
	}

	//
	//	@Override public void VisitSetIndexNode(ZSetIndexNode Node) {
	//		this.Unsupported(Node);
	//	}

	@Override public void VisitNewObjectNode(ZNewObjectNode Node) {
		Constructor<?> jMethod = this.Solution.GetConstructor(Node.Type, Node.ParamList);
		if(jMethod != null) {
			this.EvalConstructor(Node, jMethod, this.Solution.PackNodes(null, Node.ParamList));
		}
		else {
			Class<?> jClass = this.Solution.GetJavaClass(Node.Type);
			try {
				jMethod = jClass.getConstructor(int.class);
				this.EvaledValue = jMethod.newInstance(new Object[]{Node.Type.TypeId});
			}
			catch(Exception e) {
				this.Logger.ReportWarning(Node.SourceToken, "runtime error: " + e);
				this.EvaledValue = null;
			}
		}
	}

	@Override public void VisitMethodCallNode(ZMethodCallNode Node) {
		Method jMethod = this.Solution.GetMethod(Node.RecvNode.Type, Node.MethodName, Node.ParamList);
		if(jMethod != null) {
			this.EvalMethod(Node, jMethod, Node.RecvNode, this.Solution.PackNodes(null, Node.ParamList));
		}
		else {
			jMethod = JavaMethodTable.GetStaticMethod("InvokeUnresolvedMethod");
			Object Recv = this.Eval(Node.RecvNode);
			Object Values[] = new Object[Node.ParamList.size()];
			for(int i = 0; i < Node.ParamList.size(); i++) {
				Values[i] = this.Eval(Node.ParamList.get(i));
			}
			if(this.IsVisitable()) {
				try {
					this.EvaledValue = jMethod.invoke(null, Recv, Node.MethodName, Values);
				} catch (IllegalArgumentException e1) {
					LibNative.FixMe(e1);
				} catch (IllegalAccessException e1) {
					LibNative.FixMe(e1);
				} catch (InvocationTargetException e1) {
					this.Logger.ReportWarning(Node.SourceToken, "runtime error: " + e1);
				}
			}
		}
	}


	@Override public void VisitFuncCallNode(ZFuncCallNode Node) {
		if(Node.ResolvedFuncName != null) {
			if(Node.ResolvedFuncType == null) {
				this.Logger.ReportWarning(Node.SourceToken, "function: " + Node.ResolvedFuncName + " is unresolved");
			}
			else {
				ZFunc Func = ZenGamma.LookupFunc(this.Generator.RootNameSpace, Node.ResolvedFuncName, Node.ResolvedFuncType.GetRecvType(), Node.ResolvedFuncType.GetFuncParamSize());
				Method sMethod = this.Solution.GetStaticFuncMethod(Func.GetSignature());
				this.EvalStaticMethod(Node, sMethod, this.Solution.PackNodes(null, Node.ParamList));
			}
		}
		else {
			Method sMethod = JavaMethodTable.GetStaticMethod("InvokeFunc");
			this.EvalStaticMethod(Node, sMethod, this.Solution.PackNodes(Node.FuncNode, Node.ParamList));
		}
	}

	@Override public void VisitUnaryNode(ZUnaryNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.GetText(), Node.RecvNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitNotNode(ZNotNode Node) {
		Method sMethod = JavaMethodTable.GetUnaryStaticMethod(Node.SourceToken.GetText(), Node.RecvNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.RecvNode});
	}

	@Override public void VisitCastNode(ZCastNode Node) {
		this.EvaledValue = this.Eval(Node.ExprNode);
		if(!Node.Type.IsVoidType()) {

		}
	}

	//	@Override
	//	public void VisitInstanceOfNode(ZInstanceOfNode Node) {
	//		this.Unsupported(Node);
	//
	//	}

	@Override public void VisitBinaryNode(ZBinaryNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.GetText(), Node.RightNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

	@Override public void VisitComparatorNode(ZComparatorNode Node) {
		Method sMethod = JavaMethodTable.GetBinaryStaticMethod(Node.LeftNode.Type, Node.SourceToken.GetText(), Node.RightNode.Type);
		this.EvalStaticMethod(Node, sMethod, new ZNode[] {Node.LeftNode, Node.RightNode});
	}

}
