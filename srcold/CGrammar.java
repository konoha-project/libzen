// ***************************************************************************
// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
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
package org.ZenScript;
import grammar.KonohaGrammar;

import java.util.ArrayList;


import parser.ZenUtils;
import parser.ZenClassField;
import parser.ZenFunc;
import parser.ZenNameSpace;
import parser.ZenSourceContext;
import parser.ZenFuncSet;
import parser.ZenSystem;
import parser.ZenSyntaxPattern;
import parser.ZenSyntaxTree;
import parser.ZenToken;
import parser.ZenTokenContext;
import parser.ZenType;
import parser.ZenTypeEnv;
import parser.ast.ZenGetterNode;
import parser.ast.ZenNode;
import parser.ast.ZenSymbolNode;
import parser.deps.LibZen;

public class CGrammar extends ZenUtils {
	
	public static long PreprocesserToken(ZenTokenContext TokenContext, String SourceText, long pos) {
		@Var long start = pos;
		@Var String PresetPattern = null;
		pos += 1;
		while(pos < SourceText.length()) {
			if(!LibZen.IsVariableName(SourceText, pos) && !LibZen.IsDigit(SourceText, pos)) {
				break;
			}
			pos += 1;
		}
		TokenContext.AddNewToken(LibZen.SubString(SourceText, start, pos), NameSymbolTokenFlag, PresetPattern);
		return pos;
	}
	
	public static ZenSyntaxTree ParseGetterP(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		TokenContext.MatchToken("->");
		@Var ZenToken Token = TokenContext.Next();
		if(Token.IsNameSymbol()) {
			@Var ZenSyntaxTree NewTree = new ZenSyntaxTree(Pattern, NameSpace, Token, null);
			NewTree.AppendParsedTree2(LeftTree);
			return NewTree;
		}
		return TokenContext.ReportExpectedMessage(Token, "field name", true);
	}

	public static ZenNode TypeGetterP(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		@Var String Name = ParsedTree.KeyToken.GetText();
		@Var ZenNode ObjectNode = ParsedTree.TypeCheckAt(UnaryTerm, Gamma, ZenSystem.VarType, DefaultTypeCheckPolicy);
		if(ObjectNode.IsErrorNode()) {
			return ObjectNode;
		}
		// 1. To start, check class const such as Math.Pi if base is a type value
		@Var String TypeName = ObjectNode.Type.ShortName;
//		if(ObjectNode instanceof ConstNode && ObjectNode.Type.IsTypeType()) {
//			@Var ZenType ObjectType = (ZenType)((ConstNode)ObjectNode).ConstValue;
//			@Var Object ConstValue = ParsedTree.NameSpace.GetClassSymbol(ObjectType, ClassStaticName(Name), true);
//			if(ConstValue instanceof ZenEnum) {
//				if(ContextType.IsStringType()) {
//					ConstValue = ((ZenEnum)ConstValue).EnumSymbol;
//				}
//				else {
//					ConstValue = ((ZenEnum)ConstValue).EnumValue;
//				}
//			}
//			if(ConstValue != null) {
//				return Gamma.Generator.CreateConstNode(Gamma.Context.GuessType(ConstValue), ParsedTree, ConstValue);
//			}
//			TypeName = ObjectType.ShortName;
//		}
		// 2. find Class method
		@Var ZenFuncSet FuncSet = ParsedTree.NameSpace.GetMethod(ObjectNode.Type, Name, true);
		if(FuncSet.FuncList.size() > 0 && ContextType.IsFuncType()) {
			@Var ZenFunc FirstFunc = FuncSet.FuncList.get(0);
			ZenNode Node = Gamma.Generator.CreateGetterNode(ContextType, ParsedTree, ObjectNode, Name);
			if(Node instanceof ZenSymbolNode) {
				((ZenSymbolNode)Node).ResolvedFunc = FirstFunc;
			}
		}

		// 3. find Class field
		@Var ZenFunc GetterFunc = ParsedTree.NameSpace.GetGetterFunc(ObjectNode.Type, Name, true);
		@Var ZenType ReturnType = (GetterFunc != null) ? GetterFunc.GetReturnType() : ZenSystem.AnyType;
		@Var ZenNode Node = Gamma.Generator.CreateGetterNode(ReturnType, ParsedTree, ObjectNode, Name);
		if(Node instanceof ZenSymbolNode) {
			((ZenGetterNode)Node).ResolvedFunc = GetterFunc;
		}
		if(GetterFunc == null) {
			if(!ObjectNode.Type.IsDynamicType() && ContextType != ZenSystem.FuncType) {
				return Gamma.ReportTypeResult(ParsedTree, Node, TypeErrorLevel, "undefined name: " + Name + " of " + TypeName);
			}
		}
		return Node;
	}
	
	public static ZenSyntaxTree ParseStructDecl2(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		@Var ZenSyntaxTree ClassDeclTree = TokenContext.CreateMatchedSyntaxTree(NameSpace, Pattern, "struct");
		ClassDeclTree.SetMatchedPatternAt(ClassDeclName, NameSpace, TokenContext, "$FuncName$", Required); //$ClassName$ is better
		//if(TokenContext.MatchToken("extends")) {
		//	ClassDeclTree.SetMatchedPatternAt(ClassDeclSuperType, NameSpace, TokenContext, "$Type$", Required);
		//}
		if(ClassDeclTree.IsMismatchedOrError()) {
			return ClassDeclTree;
		}
		// define new class
		@Var ZenNameSpace ClassNameSpace = new ZenNameSpace(NameSpace.Context, NameSpace);
		@Var ZenToken NameToken = ClassDeclTree.GetSyntaxTreeAt(ClassDeclName).KeyToken;
		@Var ZenType SuperType = ZenSystem.TopType;
		//if(ClassDeclTree.HasNodeAt(ClassDeclSuperType)) {
		//	SuperType = ClassDeclTree.GetSyntaxTreeAt(ClassDeclSuperType).GetParsedType();
		//}
		@Var int ClassFlag = KonohaGrammar.ParseClassFlag(0, TokenContext.ParsingAnnotation);
		@Var String ClassName = NameToken.GetText();
		@Var ZenType DefinedType = NameSpace.GetType(ClassName);
		if(DefinedType != null && DefinedType.IsAbstractType()) {
			DefinedType.TypeFlag = ClassFlag;
			DefinedType.SuperType = SuperType;
			NameToken = null; // preventing duplicated symbol message at (A)
		}
		else {
			DefinedType = SuperType.CreateSubType(ClassFlag, ClassName, null, null);
			ClassNameSpace.AppendTypeName(DefinedType, NameToken);  // temporary
		}
		//ClassNameSpace.SetSymbol("This", DefinedType, NameToken);

		ClassDeclTree.SetMatchedPatternAt(ClassDeclBlock, ClassNameSpace, TokenContext, "$Block$", Optional);
		if(ClassDeclTree.HasNodeAt(ClassDeclBlock)) {
			@Var ZenClassField ClassField = new ZenClassField(DefinedType, NameSpace);
			@Var ZenTypeEnv Gamma = new ZenTypeEnv(ClassNameSpace);
			@Var ZenSyntaxTree SubTree = ClassDeclTree.GetSyntaxTreeAt(ClassDeclBlock);
			while(SubTree != null) {
				if(SubTree.Pattern.EqualsName("$VarDecl$")) {
					CGrammar.TypeMemberDecl(Gamma, SubTree, ClassField);
				}
				SubTree = SubTree.NextTree;
			}
			ClassDeclTree.ParsedValue = ClassField;
		}
		if(ClassDeclTree.IsValidSyntax()) {
			NameSpace.AppendTypeName(DefinedType, NameToken);   /* (A) */
		}
		return ClassDeclTree;
	}

	public static ZenNode TypeStructDecl2(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenType ContextType) {
		@Var ZenClassField ClassField = (ZenClassField)ParsedTree.ParsedValue;
		if(ClassField != null) {
			@Var ZenType DefinedType = ClassField.DefinedType;
			DefinedType.SetClassField(ClassField);
			Gamma.Generator.OpenClassField(ParsedTree, DefinedType, ClassField);
			@Var ZenSyntaxTree SubTree = ParsedTree.GetSyntaxTreeAt(ClassDeclBlock);
			@Var ArrayList<ZenFunc> MemberList = new ArrayList<ZenFunc>();
			while(SubTree != null) {
				//if(SubTree.Pattern.EqualsName("$FuncDecl$") || SubTree.Pattern.EqualsName("$Constructor2$")) {
				//	MemberList.add((ZenFunc)SubTree.ParsedValue);
				//}
				if(!SubTree.Pattern.EqualsName("$VarDecl$")) {
					SubTree.TypeCheck(Gamma, ZenSystem.VoidType, DefaultTypeCheckPolicy);
				}
				SubTree = SubTree.NextTree;
			}
			Gamma.Generator.CloseClassField(DefinedType, MemberList);
		}
		return Gamma.Generator.CreateEmptyNode(ZenSystem.VoidType);
	}
	
	private static boolean TypeMemberDecl(ZenTypeEnv Gamma, ZenSyntaxTree ParsedTree, ZenClassField ClassField) {
		@Var int    FieldFlag = KonohaGrammar.ParseVarFlag(0, ParsedTree.Annotation);
		@Var ZenType DeclType = ParsedTree.GetSyntaxTreeAt(VarDeclType).GetParsedType();
		@Var String FieldName = ParsedTree.GetSyntaxTreeAt(VarDeclName).KeyToken.GetText();
		@Var ZenNode InitValueNode = null;
		@Var Object InitValue = null;
		if(ParsedTree.HasNodeAt(VarDeclValue)) {
			InitValueNode = ParsedTree.TypeCheckAt(VarDeclValue, Gamma, DeclType, OnlyConstPolicy | NullablePolicy);
			if(InitValueNode.IsErrorNode()) {
				return false;
			}
			InitValue = InitValueNode.ToConstValue(Gamma.Context, true);
		}
		if(ZenUtils.UseLangStat) {
			Gamma.Context.Stat.VarDecl += 1;
		}/*EndOfStat*/
		if(DeclType.IsVarType()) {
			if(InitValueNode == null) {
				DeclType = ZenSystem.AnyType;
			}
			else {
				DeclType = InitValueNode.Type;
			}
			Gamma.ReportTypeInference(ParsedTree.KeyToken, FieldName, DeclType);
			if(ZenUtils.UseLangStat) {
				Gamma.Context.Stat.VarDeclInfer += 1;
				if(DeclType.IsAnyType()) {
					Gamma.Context.Stat.VarDeclInferAny += 1;
				}
			}/*EndOfStat*/
		}
		if(ZenUtils.UseLangStat) {
			if(DeclType.IsAnyType()) {
				Gamma.Context.Stat.VarDeclAny += 1;
			}
		}/*EndOfStat*/
		if(InitValueNode == null) {
			InitValue = DeclType.DefaultNullValue;
		}
		ClassField.CreateField(FieldFlag, DeclType, FieldName, ParsedTree.GetSyntaxTreeAt(VarDeclName).KeyToken, InitValue);
		return true;
	}

	public static ZenSyntaxTree ParseInclude(ZenNameSpace NameSpace, ZenTokenContext TokenContext, ZenSyntaxTree LeftTree, ZenSyntaxPattern Pattern) {
		TokenContext.Next(); // skipped first token "require";
		while(TokenContext.HasNext()) {
			@Var ZenToken Token = TokenContext.Next();
			if(Token.IsIndent() || Token.IsDelim()) {
				break;
			}
			if(Token.IsNameSymbol()) {
				if(!NameSpace.LoadRequiredLib(Token.GetText())) {
					return TokenContext.NewErrorSyntaxTree(Token, "failed to load required library: " + Token.GetText());
				}
			}
			if(TokenContext.MatchToken(",")) {
				continue;
			}
		}
		return KonohaGrammar.ParseEmpty(NameSpace, TokenContext, LeftTree, Pattern);
	}
	
	//ifdef JAVA
	// this is a new interface used in ImportNativeObject
	public static void ImportGrammar(ZenNameSpace NameSpace, Class<?> GrammarClass) {
		@Var ZenSourceContext SourceContext = NameSpace.Context;
		NameSpace.AppendTokenFunc("#", LoadTokenFunc2(SourceContext, GrammarClass, "PreprocesserToken"));
		NameSpace.AppendExtendedSyntax_OLD("->", 0, LoadParseFunc2(SourceContext, GrammarClass, "ParseGetterP"), LoadTypeFunc2(SourceContext, GrammarClass, "TypeGetterP"));
		NameSpace.AppendSyntax_OLD("struct", LoadParseFunc2(SourceContext, GrammarClass, "ParseStructDecl2"), LoadTypeFunc2(SourceContext, GrammarClass, "TypeStructDecl2"));
		NameSpace.AppendSyntax_OLD("#include", LoadParseFunc2(SourceContext, GrammarClass, "ParseInclude"), null);
	}
	
}
