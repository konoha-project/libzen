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

package zen.lang;

import java.util.ArrayList;

import zen.deps.Field;
import zen.deps.Var;
import zen.parser.ZLogger;
import zen.parser.ZToken;

public class ZenFuncSet {
	@Field public ArrayList<ZenFunc> FuncList;

	public ZenFuncSet(ZenFunc Func) {
		this.FuncList = new ArrayList<ZenFunc>();
		if(Func != null) {
			this.FuncList.add(Func);
		}
	}

	public boolean IsEmpty() {
		return this.FuncList.size() == 0;
	}

	@Override public String toString() { // this is used in an error message
		@Var String s = "";
		@Var int i = 0;
		while(i < this.FuncList.size()) {
			if(i > 0) {
				s = s + ", ";
			}
			s = s + this.FuncList.get(i);
			i = i + 1;
		}
		return s;
	}

	public void Append(ZenFunc Func, ZLogger Logger, ZToken SourceToken) {
		if(SourceToken != null) {
			@Var int i = 0;
			while(i < this.FuncList.size()) {
				@Var ZenFunc ListedFunc = this.FuncList.get(i);
				if(ListedFunc == Func) {
					/*return this;*/ /* same function */
				}
				if(Func.FuncType.Equals(ListedFunc.FuncType)) {
					Logger.ReportWarning(SourceToken, "duplicated function symbol: " + SourceToken.ParsedText);
					this.FuncList.set(i, Func);
				}
				i = i + 1;
			}
		}
		this.FuncList.add(Func);
	}

	//	public final ZenFunc ResolveFunc(ArrayList<ZenType> TypeList, int ResolvedSize, int FuncParamSize) {
	//
	//	}
	//
	//
	//
	//	public ZenFunc ResolveUnaryMethod(ZenType Type) {
	//		@Var int i = 0;
	//		while(i < this.FuncList.size()) {
	//			@Var ZenFunc Func = this.FuncList.get(i);
	//			if(Func.GetFuncParamSize() == 1) {
	//				return Func;
	//			}
	//			i = i + 1;
	//		}
	//		return null;
	//	}
	//
	//	public final boolean CheckIncrementalTyping(ZenNameSpace NameSpace, int FuncParamSize, ArrayList<ZenNode> ParamList, ZenResolvedFunc ResolvedFunc) {
	//		@Var ZenFunc FoundFunc = null;
	//		@Var ZenNameSpace GenericNameSpace = null;
	//		@Var int i = 0;
	//		while(i < this.FuncList.size()) {
	//			@Var ZenFunc Func = this.FuncList.get(i);
	//			if(Func.GetFuncParamSize() == FuncParamSize) {
	//				GenericNameSpace = Func.GetGenericNameSpace(NameSpace, ParamList, 0);
	//				@Var int p = 0;
	//				while(p < ParamList.size()) {
	//					@Var ZenNode Node = ParamList.get(p);
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
	//		@Var int p = 0;
	//		@Var ZenNode[] ConvertedNodes = null;
	//		while(p < ParamList.size()) {
	//			@Var ZenType ParamType = Func.Types[p + 1];
	//			@Var ZenNode Node = ParamList.get(p);
	//			ParamType = ParamType.RealType(GenericNameSpace, Node.Type);
	//			if(!ParamType.Accept(Node.Type)) {
	//				@Var ZenFunc TypeCoercion = GenericNameSpace.GetConverterFunc(Node.Type, ParamType, true);
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
	//		@Var int p = 0;
	//		@Var ZenNode ConvertedNodes[] = null;
	//		while(p < ParamList.size()) {
	//			@Var ZenType ParamType = (p + 1 < Func.Types.length - 1) ? Func.Types[p + 1] : VargType;
	//			@Var ZenNode Node = ParamList.get(p);
	//			@Var ZenType RealType = ParamType.RealType(GenericNameSpace, Node.Type);
	//			if(RealType == null) {
	//				return null;
	//			}
	//			if(!ParamType.Accept(RealType)) {
	//				@Var ZenFunc TypeCoercion = GenericNameSpace.GetConverterFunc(RealType, ParamType, true);
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
	//			@Var ZenType ArrayType = Func.Types[Func.Types.length - 1];
	//			@Var ZenNode ArrayNode = GenericNameSpace.Context.Generator.CreateArrayLiteralNode(ArrayType, null);
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
	//		@Var int i = 0;
	//		while(i < this.FuncList.size()) {
	//			@Var ZenFunc Func = this.FuncList.get(i);
	//			if(Func.GetFuncParamSize() == FuncParamSize) {
	//				@Var ZenNameSpace GenericNameSpace = Func.GetGenericNameSpace(Gamma.NameSpace, ParamList, 0);
	//				Func = this.CheckParamWithCoercion(GenericNameSpace, Func, ParamList);
	//				if(Func != null) {
	//					return ResolvedFunc.UpdateFunc(Func, GenericNameSpace);
	//				}
	//			}
	//			i = i + 1;
	//		}
	//		i = 0;
	//		while(i < this.FuncList.size()) {
	//			@Var ZenFunc Func = this.FuncList.get(i);
	//			@Var ZenType VargType = Func.GetVargType();
	//			if(VargType != null && Func.GetFuncParamSize() <= FuncParamSize) {
	//				@Var ZenNameSpace GenericNameSpace = Func.GetGenericNameSpace(Gamma.NameSpace, ParamList, 0);
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
	//		@Var int FuncParamSize = LibZen.ListSize(ParsedTree.SubTreeList) - TreeIndex + ParamList.size();
	//		//System.err.println("*** FuncParamSize=" + FuncParamSize + ", resolved_size=" + ParamList.size());
	//		//System.err.println("*** FuncList=" + this);
	//		@Var ZenResolvedFunc ResolvedFunc = new ZenResolvedFunc(Gamma.NameSpace);
	//		while(!this.CheckIncrementalTyping(Gamma.NameSpace, FuncParamSize, ParamList, ResolvedFunc) && TreeIndex < LibZen.ListSize(ParsedTree.SubTreeList)) {
	//			@Var ZenNode Node = ParsedTree.TypeCheckAt(TreeIndex, Gamma, ZenSystem.VarType, DefaultTypeCheckPolicy);
	//			if(Node.IsErrorNode()) {
	//				ResolvedFunc.ErrorNode = Node;
	//				return ResolvedFunc;
	//			}
	//			ParamList.add(Node);
	//			TreeIndex = TreeIndex + 1;
	//		}
	//		if(ResolvedFunc.Func != null) {
	//			@Var ZenNameSpace GenericNameSpace = ResolvedFunc.GenericNameSpace;
	//			while(TreeIndex < LibZen.ListSize(ParsedTree.SubTreeList)) {
	//				@Var ZenType ContextType = ResolvedFunc.Func.GetFuncParamType(ParamList.size()/*ResolvedSize*/);
	//				ContextType = ContextType.RealType(GenericNameSpace, ZenSystem.VarType);
	//				//System.err.println("TreeIndex="+ TreeIndex+" NodeSize="+ParamList.size()+" ContextType="+ContextType);
	//				@Var ZenNode Node = ParsedTree.TypeCheckAt(TreeIndex, Gamma, ContextType, DefaultTypeCheckPolicy);
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
	//		@Var int p = 0;
	//		while(p < Arguments.length) {
	//			@Var ZenType DefinedType = Func.Types[p + 1];
	//			@Var ZenType GivenType = TypeList.get(p);
	//			if(DefinedType.Accept(GivenType)) {
	//				ConvertedArguments[p] = Arguments[p];
	//			}
	//			else {
	//				@Var ZenFunc TypeCoercion = NameSpace.GetConverterFunc(GivenType, DefinedType, true);
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
	//		@Var Object[] OriginalArguments = new Object[Arguments.length];
	//		LibZen.ArrayCopy(Arguments, 0, OriginalArguments, 0, Arguments.length);
	//		@Var ArrayList<ZenType> TypeList = new ArrayList<ZenType>();
	//		@Var int i = 0;
	//		while(i < Arguments.length) {
	//			TypeList.add(ZenSystem.GuessType(Arguments[i]));
	//			i = i + 1;
	//		}
	//		i = 0;
	//		while(i < this.FuncList.size()) {
	//			@Var ZenFunc Func = this.FuncList.get(i);
	//			if(Func.GetFuncParamSize() == Arguments.length) {
	//				@Var ZenNameSpace GenericNameSpace = Func.GetGenericNameSpaceT(NameSpace, TypeList, 0);
	//				if(this.CheckArguments(GenericNameSpace, Func, OriginalArguments, Arguments, TypeList)) {
	//					return Func;
	//				}
	//			}
	////			@Var ZenType VargType = Func.GetVargType();
	////			if(VargType != null && Func.GetFuncParamSize() <= FuncParamSize) {
	////				@Var ZenNameSpace GenericNameSpace = Func.GetGenericNameSpace(Gamma.NameSpace, ParamList, 0);
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
	//		@Var int FuncParamSize = LibZen.ListSize(ParsedTree.SubTreeList) - TreeIndex + NodeList.size();
	////		System.err.println("*** FuncParamSize=" + FuncParamSize + " resolved_size=" + NodeList.size());
	////		System.err.println("*** FuncList=" + this);
	//		@Var ZenResolvedFunc ResolvedFunc = this.ResolveFunc(Gamma, ParsedTree, TreeIndex, NodeList);
	//		if(ResolvedFunc.Func == null  && FuncParamSize == 1) {
	//
	//		}
	//		return ResolvedFunc;
	//	}

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