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

package zen.obsolete;

import java.util.ArrayList;

import zen.lang.ZenFunc;
import zen.lang.ZenType;
import zen.parser.ZenGenerator;

public class ZenPolyFunc {
	/*field*/public ZenGenerator Generator;
	/*field*/public ArrayList<ZenFunc> FuncList;

	public ZenPolyFunc/*constructor*/(ZenGenerator Generator, ArrayList<ZenFunc> FuncList) {
		this.Generator = Generator;
		this.FuncList = FuncList == null ? new ArrayList<ZenFunc>() : FuncList;
	}

	@Override public String toString() { // this is used in an error message
		/*local*/String s = "";
		/*local*/int i = 0;
		while(i < this.FuncList.size()) {
			if(i > 0) {
				s = s + ", ";
			}
			s = s + this.FuncList.get(i);
			i = i + 1;
		}
		return s;
	}

	//	public final ZenPolyFunc Append(ZenFunc Func, ZenToken SourceToken) {
	//		if(SourceToken != null) {
	//			/*local*/int i = 0;
	//			while(i < this.FuncList.size()) {
	//				/*local*/ZenFunc ListedFunc = this.FuncList.get(i);
	//				if(ListedFunc == Func) {
	//					/*return this;*/ /* same function */
	//				}
	//				if(Func.EqualsType(ListedFunc)) {
	//					this.Generator.Logger.ReportWarning(SourceToken, "duplicated symbol: " + SourceToken.ParsedText);
	//					break;
	//				}
	//				i = i + 1;
	//			}
	//		}
	//		this.FuncList.add(Func);
	//		return this;
	//	}

	public ZenFunc ResolveUnaryMethod(ZenType Type) {
		/*local*/int i = 0;
		while(i < this.FuncList.size()) {
			/*local*/ZenFunc Func = this.FuncList.get(i);
			if(Func.GetFuncParamSize() == 1) {
				return Func;
			}
			i = i + 1;
		}
		return null;
	}

	//	public final boolean CheckIncrementalTyping(ZenNameSpace NameSpace, int FuncParamSize, ArrayList<ZenNode> ParamList, ZenResolvedFunc ResolvedFunc) {
	//		/*local*/ZenFunc FoundFunc = null;
	//		/*local*/ZenNameSpace GenericNameSpace = null;
	//		/*local*/int i = 0;
	//		while(i < this.FuncList.size()) {
	//			/*local*/ZenFunc Func = this.FuncList.get(i);
	//			if(Func.GetFuncParamSize() == FuncParamSize) {
	//				GenericNameSpace = Func.GetGenericNameSpace(NameSpace, ParamList, 0);
	//				/*local*/int p = 0;
	//				while(p < ParamList.size()) {
	//					/*local*/ZenNode Node = ParamList.get(p);
	//					if(!Func.Types[p + 1].Match(GenericNameSpace, Node.Type)) {
	//						Func = null;
	//						break;
	//					}
	//					p = p + 1;
	//				}
	//				if(Func != null) {
	//					if(ParamList.size() == FuncParamSize) {
	//						// when paramsize matched, unnecessary to check others
	//						ResolvedFunc.Func = Func;
	//						return true;
	//					}
	//					if(FoundFunc != null) {
	//						ResolvedFunc.Func = null;
	//						return false; // two more func
	//					}
	//					FoundFunc = Func;
	//				}
	//			}
	//			i = i + 1;
	//		}
	//		ResolvedFunc.Func = FoundFunc;
	//		ResolvedFunc.GenericNameSpace = GenericNameSpace;
	//		return true;
	//	}

	//	public ZenFunc CheckParamWithCoercion(ZenNameSpace GenericNameSpace, ZenFunc Func, ArrayList<ZenNode> ParamList) {
	//		/*local*/int p = 0;
	//		/*local*/ZenNode[] ConvertedNodes = null;
	//		while(p < ParamList.size()) {
	//			/*local*/ZenType ParamType = Func.Types[p + 1];
	//			/*local*/ZenNode Node = ParamList.get(p);
	//			ParamType = ParamType.RealType(GenericNameSpace, Node.Type);
	//			if(!ParamType.Accept(Node.Type)) {
	//				/*local*/ZenFunc TypeCoercion = GenericNameSpace.GetConverterFunc(Node.Type, ParamType, true);
	//				if(TypeCoercion != null && TypeCoercion.Is(CoercionFunc)) {
	//					if(ConvertedNodes == null) {
	//						ConvertedNodes = new ZenNode[ParamList.size()];
	//					}
	//					ConvertedNodes[p] = GenericNameSpace.Context.Generator.CreateCoercionNode(ParamType, GenericNameSpace, TypeCoercion, Node);
	//				}
	//				else {
	//					return null;
	//				}
	//			}
	//			p = p + 1;
	//		}
	//		if(ConvertedNodes != null) {
	//			p = 1;
	//			while(p < ConvertedNodes.length) {
	//				if(ConvertedNodes[p] != null) {
	//					ParamList.set(p, ConvertedNodes[p]);
	//				}
	//				p = p + 1;
	//			}
	//		}
	//		return Func;
	//	}

	//	public ZenFunc CheckParamAsVarArg(ZenNameSpace GenericNameSpace, ZenFunc Func, ZenType VargType, ArrayList<ZenNode> ParamList) {
	//		/*local*/int p = 0;
	//		/*local*/ZenNode ConvertedNodes[] = null;
	//		while(p < ParamList.size()) {
	//			/*local*/ZenType ParamType = (p + 1 < Func.Types.length - 1) ? Func.Types[p + 1] : VargType;
	//			/*local*/ZenNode Node = ParamList.get(p);
	//			/*local*/ZenType RealType = ParamType.RealType(GenericNameSpace, Node.Type);
	//			if(RealType == null) {
	//				return null;
	//			}
	//			if(!ParamType.Accept(RealType)) {
	//				/*local*/ZenFunc TypeCoercion = GenericNameSpace.GetConverterFunc(RealType, ParamType, true);
	//				if(TypeCoercion != null && TypeCoercion.Is(CoercionFunc)) {
	//					if(ConvertedNodes == null) {
	//						ConvertedNodes = new ZenNode[ParamList.size()];
	//					}
	//					ConvertedNodes[p] = GenericNameSpace.Context.Generator.CreateCoercionNode(ParamType, GenericNameSpace, TypeCoercion, Node);
	//				}
	//				else {
	//					return null;
	//				}
	//			}
	//			p = p + 1;
	//		}
	//		if(ConvertedNodes != null) {
	//			p = 1;
	//			while(p < ConvertedNodes.length) {
	//				if(ConvertedNodes[p] != null) {
	//					ParamList.set(p, ConvertedNodes[p]);
	//				}
	//				p = p + 1;
	//			}
	//			ConvertedNodes = null;
	//		}
	//		if(!Func.Is(NativeVariadicFunc)) {
	//			/*local*/ZenType ArrayType = Func.Types[Func.Types.length - 1];
	//			/*local*/ZenNode ArrayNode = GenericNameSpace.Context.Generator.CreateArrayLiteralNode(ArrayType, null);
	//			p = Func.Types.length - 1;
	//			while(p < ParamList.size()) {
	//				ArrayNode.Append(ParamList.get(p));
	//			}
	//			while(Func.Types.length - 1 < ParamList.size()) {
	//				ParamList.remove(ParamList.size() - 1);
	//			}
	//			ParamList.add(ArrayNode);
	//		}
	//		return Func;
	//	}

	//	public ZenResolvedFunc GetAcceptableFunc(ZenTypeEnv Gamma, int FuncParamSize, ArrayList<ZenNode> ParamList, ZenResolvedFunc ResolvedFunc) {
	//		/*local*/int i = 0;
	//		while(i < this.FuncList.size()) {
	//			/*local*/ZenFunc Func = this.FuncList.get(i);
	//			if(Func.GetFuncParamSize() == FuncParamSize) {
	//				/*local*/ZenNameSpace GenericNameSpace = Func.GetGenericNameSpace(Gamma.NameSpace, ParamList, 0);
	//				Func = this.CheckParamWithCoercion(GenericNameSpace, Func, ParamList);
	//				if(Func != null) {
	//					return ResolvedFunc.UpdateFunc(Func, GenericNameSpace);
	//				}
	//			}
	//			i = i + 1;
	//		}
	//		i = 0;
	//		while(i < this.FuncList.size()) {
	//			/*local*/ZenFunc Func = this.FuncList.get(i);
	//			/*local*/ZenType VargType = Func.GetVargType();
	//			if(VargType != null && Func.GetFuncParamSize() <= FuncParamSize) {
	//				/*local*/ZenNameSpace GenericNameSpace = Func.GetGenericNameSpace(Gamma.NameSpace, ParamList, 0);
	//				Func = this.CheckParamAsVarArg(GenericNameSpace, Func, VargType, ParamList);
	//				if(Func != null) {
	//					return ResolvedFunc.UpdateFunc(Func, GenericNameSpace);
	//				}
	//			}
	//			i = i + 1;
	//		}
	//		return ResolvedFunc;
	//	}

	//	public ZenResolvedFunc ResolveFunc(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, int TreeIndex, ArrayList<ZenNode> ParamList) {
	//		/*local*/int FuncParamSize = LibZen.ListSize(ParsedTree.SubTreeList) - TreeIndex + ParamList.size();
	//		//System.err.println("*** FuncParamSize=" + FuncParamSize + ", resolved_size=" + ParamList.size());
	//		//System.err.println("*** FuncList=" + this);
	//		/*local*/ZenResolvedFunc ResolvedFunc = new ZenResolvedFunc(Gamma.NameSpace);
	//		while(!this.CheckIncrementalTyping(Gamma.NameSpace, FuncParamSize, ParamList, ResolvedFunc) && TreeIndex < LibZen.ListSize(ParsedTree.SubTreeList)) {
	//			/*local*/ZenNode Node = ParsedTree.TypeCheckAt(TreeIndex, Gamma, ZenStaticTable.VarType, DefaultTypeCheckPolicy);
	//			if(Node.IsErrorNode()) {
	//				ResolvedFunc.ErrorNode = Node;
	//				return ResolvedFunc;
	//			}
	//			ParamList.add(Node);
	//			TreeIndex = TreeIndex + 1;
	//		}
	//		if(ResolvedFunc.Func != null) {
	//			/*local*/ZenNameSpace GenericNameSpace = ResolvedFunc.GenericNameSpace;
	//			while(TreeIndex < LibZen.ListSize(ParsedTree.SubTreeList)) {
	//				/*local*/ZenType ContextType = ResolvedFunc.Func.GetFuncParamType(ParamList.size()/*ResolvedSize*/);
	//				ContextType = ContextType.RealType(GenericNameSpace, ZenStaticTable.VarType);
	//				//System.err.println("TreeIndex="+ TreeIndex+" NodeSize="+ParamList.size()+" ContextType="+ContextType);
	//				/*local*/ZenNode Node = ParsedTree.TypeCheckAt(TreeIndex, Gamma, ContextType, DefaultTypeCheckPolicy);
	//				if(Node.IsErrorNode()) {
	//					ResolvedFunc.ErrorNode = Node;
	//					return ResolvedFunc;
	//				}
	//				if(ContextType.IsVarType()) {
	//					ResolvedFunc.Func.Types[TreeIndex+1].Match(GenericNameSpace, Node.Type);
	//				}
	//				ParamList.add(Node);
	//				TreeIndex = TreeIndex + 1;
	//			}
	//			return ResolvedFunc.UpdateFunc(ResolvedFunc.Func, GenericNameSpace);
	//		}
	//		return this.GetAcceptableFunc(Gamma, FuncParamSize, ParamList, ResolvedFunc);
	//	}

	//	private boolean CheckArguments(ZenNameSpace NameSpace, ZenFunc Func, Object[] Arguments, Object[] ConvertedArguments, ArrayList<ZenType> TypeList) {
	//		/*local*/int p = 0;
	//		while(p < Arguments.length) {
	//			/*local*/ZenType DefinedType = Func.Types[p + 1];
	//			/*local*/ZenType GivenType = TypeList.get(p);
	//			if(DefinedType.Accept(GivenType)) {
	//				ConvertedArguments[p] = Arguments[p];
	//			}
	//			else {
	//				/*local*/ZenFunc TypeCoercion = NameSpace.GetConverterFunc(GivenType, DefinedType, true);
	//				if(TypeCoercion != null && TypeCoercion.Is(CoercionFunc)) {
	//					ConvertedArguments[p] = LibZen.DynamicConvertTo(DefinedType, Arguments[p]);
	//				}
	//				else {
	//					return false;
	//				}
	//			}
	//			p = p + 1;
	//		}
	//		return true;
	//	}
	//
	//	public ZenFunc GetMatchedFunc(ZenNameSpace NameSpace, Object[] Arguments) {
	//		/*local*/Object[] OriginalArguments = new Object[Arguments.length];
	//		LibZen.ArrayCopy(Arguments, 0, OriginalArguments, 0, Arguments.length);
	//		/*local*/ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
	//		/*local*/int i = 0;
	//		while(i < Arguments.length) {
	//			TypeList.add(ZenStaticTable.GuessType(Arguments[i]));
	//			i = i + 1;
	//		}
	//		i = 0;
	//		while(i < this.FuncList.size()) {
	//			/*local*/ZenFunc Func = this.FuncList.get(i);
	//			if(Func.GetFuncParamSize() == Arguments.length) {
	//				/*local*/ZenNameSpace GenericNameSpace = Func.GetGenericNameSpaceT(NameSpace, TypeList, 0);
	//				if(this.CheckArguments(GenericNameSpace, Func, OriginalArguments, Arguments, TypeList)) {
	//					return Func;
	//				}
	//			}
	////			/*local*/ZenType VargType = Func.GetVargType();
	////			if(VargType != null && Func.GetFuncParamSize() <= FuncParamSize) {
	////				/*local*/ZenNameSpace GenericNameSpace = Func.GetGenericNameSpace(Gamma.NameSpace, ParamList, 0);
	////				Func = this.CheckMethodArguments(GenericNameSpace, Func, Arguments);
	////				if(Func != null) {
	////					return Func;
	////				}
	////			}
	//			i = i + 1;
	//		}
	//		return null;
	//	}
	//
	//	public ZenResolvedFunc ResolveConstructor(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, int TreeIndex, ArrayList<ZenNode> NodeList) {
	//		/*local*/int FuncParamSize = LibZen.ListSize(ParsedTree.SubTreeList) - TreeIndex + NodeList.size();
	////		System.err.println("*** FuncParamSize=" + FuncParamSize + " resolved_size=" + NodeList.size());
	////		System.err.println("*** FuncList=" + this);
	//		/*local*/ZenResolvedFunc ResolvedFunc = this.ResolveFunc(Gamma, ParsedTree, TreeIndex, NodeList);
	//		if(ResolvedFunc.Func == null  && FuncParamSize == 1) {
	//
	//		}
	//		return ResolvedFunc;
	//	}

	public boolean IsEmpty() {
		return this.FuncList.size() == 0;
	}

	//	public String FormatTypeErrorMessage(String FuncType, ZenType ClassType, String MethodName) {
	//		if(ClassType != null) {
	//			if(LibZen.EqualsString(MethodName, "")) {
	//				MethodName = ClassType.toString();
	//			}
	//			else {
	//				MethodName = MethodName + " of " + ClassType;
	//			}
	//		}
	//		if(this.FuncList.size() == 0) {
	//			return "undefined " + FuncType + ": " + MethodName;
	//		}
	//		else {
	//			return "mismatched " + FuncType + "s: " + this;
	//		}
	//	}
	//
	//	public ZenNode CreateTypeErrorNode(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, String FuncType, ZenType ClassType, String MethodName) {
	//		return Gamma.CreateSyntaxErrorNode(ParsedTree, this.FormatTypeErrorMessage(FuncType, ClassType, MethodName));
	//	}


}