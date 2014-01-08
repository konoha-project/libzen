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
import zen.ast.GtBinaryNode;
import zen.ast.GtCastNode;
import zen.ast.GtOrNode;
import zen.ast.GtUnaryNode;
import zen.ast.ZenNode;
import zen.parser.ZenNameSpace;
import zen.parser.ZenVisitor;

public abstract class ZenEvaluator implements ZenVisitor {
	/*field*/private ZenNameSpace NameSpace_;
	/*field*/private boolean IsEnforced_;
	/*field*/private Object EvaledValue_;

	public final Object Eval(ZenNode Node, ZenNameSpace NameSpace, boolean IsEnforced) {
		this.NameSpace_ = NameSpace;
		this.IsEnforced_ = IsEnforced;
		Node.Accept(this);
		return this.EvaledValue_;
	}


	@Override
	public void VisitAndNode(GtAndNode Node) {
		//		@Override public Object Eval(GtNameSpace NameSpace, boolean EnforceConst)  {
		//			/*local*/Object LeftValue = this.LeftNode.Eval(NameSpace, EnforceConst) ;
		//			if((LeftValue instanceof Boolean) && LibZen.booleanValue(LeftValue)) {
		//				return this.RightNode.Eval(NameSpace, EnforceConst) ;
		//			}
		//			return null;
		//		}

		// TODO Auto-generated method stub
	}

	@Override
	public void VisitOrNode(GtOrNode Node) {
		//		@Override public Object Eval(GtNameSpace NameSpace, boolean EnforceConst)  {
		//			/*local*/Object LeftValue = this.LeftNode.Eval(NameSpace, EnforceConst) ;
		//			if(LeftValue instanceof Boolean) {
		//				if(LibZen.booleanValue(LeftValue)) {
		//					return LeftValue;
		//				}
		//				else {
		//					return this.RightNode.Eval(NameSpace, EnforceConst) ;
		//				}
		//			}
		//			return null;
		//		}
	}

	//	public static Object EvalUnary(ZenType Type, String Operator, Object Value) {
	//		if(Value instanceof Boolean) {
	//			if(Operator.equals("!") || Operator.equals("not")) {
	//				return DynamicCast(Type, !((Boolean)Value).booleanValue());
	//			}
	//			return null;
	//		}
	//		if(Value instanceof Long || Value instanceof Integer  || Value instanceof Short) {
	//			if(Operator.equals("-")) {
	//				return DynamicCast(Type, -((Number)Value).longValue());
	//			}
	//			if(Operator.equals("+")) {
	//				return DynamicCast(Type, +((Number)Value).longValue());
	//			}
	//			if(Operator.equals("~")) {
	//				return DynamicCast(Type, ~((Number)Value).longValue());
	//			}
	//			return null;
	//		}
	//		return null;
	//	}
	//
	//	public static Object EvalSuffix(ZenType Type, Object Value, String Operator) {
	//		return null;
	//	}

	//	@Override public Object ToConstValue(GtParserContext Context, boolean EnforceConst)  {
	//	/*local*/Object LeftValue = this.LeftNode.ToConstValue(Context, EnforceConst) ;
	//	if(LeftValue != null) {
	//		/*local*/Object RightValue = this.RightNode.ToConstValue(Context, EnforceConst) ;
	//		if(RightValue != null) {
	//			return LibZen.EvalBinary(this.Type, LeftValue, this.Token.ParsedText, RightValue);
	//		}
	//	}
	//	return null;
	//}

	//	public static Object EvalBinary(ZenType Type, Object LeftValue, String Operator, Object RightValue) {
	//		//System.err.println("***" + LeftValue.getClass() + ", " + RightValue.getClass());
	//		if(LeftValue == null || RightValue == null) {
	//			return null;
	//		}
	//		if(LeftValue instanceof String || RightValue instanceof String) {
	//			String left = DynamicCast(ZenSystem.StringType, LeftValue).toString();
	//			String right = DynamicCast(ZenSystem.StringType, RightValue).toString();
	//			if(Operator.equals("+")) {
	//				return  DynamicCast(Type, left + right);
	//			}
	//		}
	//		if(LeftValue instanceof String && RightValue instanceof String) {
	//			String left = DynamicCast(ZenSystem.StringType, LeftValue).toString();
	//			String right = DynamicCast(ZenSystem.StringType, RightValue).toString();
	//			if(Operator.equals("==")) {
	//				return  DynamicCast(Type, left.equals(right));
	//			}
	//			if(Operator.equals("!=")) {
	//				return DynamicCast(Type, !left.equals(right));
	//			}
	//			if(Operator.equals("<")) {
	//				return DynamicCast(Type, left.compareTo(right) < 0);
	//			}
	//			if(Operator.equals("<=")) {
	//				return DynamicCast(Type, left.compareTo(right) <= 0);
	//			}
	//			if(Operator.equals(">")) {
	//				return DynamicCast(Type, left.compareTo(right) > 0);
	//			}
	//			if(Operator.equals(">=")) {
	//				return DynamicCast(Type, left.compareTo(right) >= 0);
	//			}
	//			return null;
	//		}
	//		if(LeftValue instanceof Double || LeftValue instanceof Float || RightValue instanceof Double || RightValue instanceof Float) {
	//			try {
	//				double left = ((Number)LeftValue).doubleValue();
	//				double right = ((Number)RightValue).doubleValue();
	//				if(Operator.equals("+")) {
	//					return DynamicCast(Type, left + right);
	//				}
	//				if(Operator.equals("-")) {
	//					return DynamicCast(Type, left - right);
	//				}
	//				if(Operator.equals("*")) {
	//					return DynamicCast(Type, left * right);
	//				}
	//				if(Operator.equals("/")) {
	//					return DynamicCast(Type, left / right);
	//				}
	//				if(Operator.equals("%") || Operator.equals("mod")) {
	//					return DynamicCast(Type, left % right);
	//				}
	//				if(Operator.equals("==")) {
	//					return DynamicCast(Type, left == right);
	//				}
	//				if(Operator.equals("!=")) {
	//					return DynamicCast(Type, left != right);
	//				}
	//				if(Operator.equals("<")) {
	//					return DynamicCast(Type, left < right);
	//				}
	//				if(Operator.equals("<=")) {
	//					return DynamicCast(Type, left <= right);
	//				}
	//				if(Operator.equals(">")) {
	//					return DynamicCast(Type, left > right);
	//				}
	//				if(Operator.equals(">=")) {
	//					return DynamicCast(Type, left >= right);
	//				}
	//			}
	//			catch(ClassCastException e) {
	//			}
	//			return null;
	//		}
	//		if(LeftValue instanceof Boolean && RightValue instanceof Boolean) {
	//			boolean left = (Boolean)LeftValue;
	//			boolean right = (Boolean)RightValue;
	//			if(Operator.equals("==")) {
	//				return DynamicCast(Type, left == right);
	//			}
	//			if(Operator.equals("!=")) {
	//				return DynamicCast(Type, left != right);
	//			}
	//			return null;
	//		}
	//		try {
	//			long left = ((Number)LeftValue).longValue();
	//			long right = ((Number)RightValue).longValue();
	//			if(Operator.equals("+")) {
	//				return DynamicCast(Type, left + right);
	//			}
	//			if(Operator.equals("-")) {
	//				return DynamicCast(Type, left - right);
	//			}
	//			if(Operator.equals("*")) {
	//				return DynamicCast(Type, left * right);
	//			}
	//			if(Operator.equals("/")) {
	//				return DynamicCast(Type, left / right);
	//			}
	//			if(Operator.equals("%") || Operator.equals("mod")) {
	//				return DynamicCast(Type, left % right);
	//			}
	//			if(Operator.equals("==")) {
	//				return DynamicCast(Type, left == right);
	//			}
	//			if(Operator.equals("!=")) {
	//				return DynamicCast(Type, left != right);
	//			}
	//			if(Operator.equals("<")) {
	//				return DynamicCast(Type, left < right);
	//			}
	//			if(Operator.equals("<=")) {
	//				return DynamicCast(Type, left <= right);
	//			}
	//			if(Operator.equals(">")) {
	//				return DynamicCast(Type, left > right);
	//			}
	//			if(Operator.equals(">=")) {
	//				return DynamicCast(Type, left >= right);
	//			}
	//			if(Operator.equals("|")) {
	//				return DynamicCast(Type, left | right);
	//			}
	//			if(Operator.equals("&")) {
	//				return DynamicCast(Type, left & right);
	//			}
	//			if(Operator.equals("<<")) {
	//				return DynamicCast(Type, left << right);
	//			}
	//			if(Operator.equals(">>")) {
	//				return DynamicCast(Type, left >> right);
	//			}
	//			if(Operator.equals("^")) {
	//				return DynamicCast(Type, left ^ right);
	//			}
	//		}
	//		catch(ClassCastException e) {
	//		}
	//		return null;
	//	}

	@Override
	public void VisitUnaryNode(GtUnaryNode Node) {
		//		@Override public Object Eval(GtNameSpace NameSpace, boolean EnforceConst)  {
		//			/*local*/Object Value = this.RecvNode.Eval(NameSpace, EnforceConst) ;
		//			if(Value != null) {
		//				return LibZen.EvalUnary(this.Type, this.SourceToken.ParsedText, Value);
		//			}
		//			return Value;
		//		}
	}

	@Override
	public void VisitBinaryNode(GtBinaryNode Node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void VisitCastNode(GtCastNode Node) {
		//		@Override public Object Eval(GtNameSpace NameSpace, boolean EnforceConst)  {
		//			/*local*/Object Value = this.ExprNode.Eval(NameSpace, EnforceConst) ;
		//			if(Value != null) {
		//				return LibZen.DynamicCast(this.Type, Value);
		//			}
		//			return Value;
		//		}
	}

}
