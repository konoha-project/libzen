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
import zen.deps.Var;
import zen.deps.ZMatchFunction;
import zen.grammar.AndPatternFunction;
import zen.grammar.AnnotationPatternFunction;
import zen.grammar.ApplyPatternFunction;
import zen.grammar.ArrayLiteralPatternFunction;
import zen.grammar.AssertPatternFunction;
import zen.grammar.BinaryPatternFunction;
import zen.grammar.BlockCommentFunction;
import zen.grammar.BlockPatternFunction;
import zen.grammar.BreakPatternFunction;
import zen.grammar.CastPatternFunction;
import zen.grammar.CatchPatternFunction;
import zen.grammar.ClassPatternFunction;
import zen.grammar.ComparatorPatternFunction;
import zen.grammar.ExportPatternFunction;
import zen.grammar.ExpressionPatternFunction;
import zen.grammar.FalsePatternFunction;
import zen.grammar.FieldPatternFunction;
import zen.grammar.FloatLiteralPatternFunction;
import zen.grammar.FunctionPatternFunction;
import zen.grammar.GetIndexPatternFunction;
import zen.grammar.GetterPatternFunction;
import zen.grammar.GroupPatternFunction;
import zen.grammar.IfPatternFunction;
import zen.grammar.InstanceOfPatternFunction;
import zen.grammar.IntLiteralPatternFunction;
import zen.grammar.LetPatternFunction;
import zen.grammar.MapEntryPatternFunction;
import zen.grammar.MapLiteralPatternFunction;
import zen.grammar.MethodCallPatternFunction;
import zen.grammar.NamePatternFunction;
import zen.grammar.NameTokenFunction;
import zen.grammar.NewLineTokenFunction;
import zen.grammar.NewObjectPatternFunction;
import zen.grammar.NotPatternFunction;
import zen.grammar.NullPatternFunction;
import zen.grammar.NumberLiteralTokenFunction;
import zen.grammar.OperatorTokenFunction;
import zen.grammar.OrPatternFunction;
import zen.grammar.ParamPatternFunction;
import zen.grammar.PrototypePatternFunction;
import zen.grammar.ReturnPatternFunction;
import zen.grammar.RightExpressionPatternFunction;
import zen.grammar.RightTypePatternFunction;
import zen.grammar.SetIndexPatternFunction;
import zen.grammar.SetterPatternFunction;
import zen.grammar.StatementEndPatternFunction;
import zen.grammar.StatementPatternFunction;
import zen.grammar.StringLiteralPatternFunction;
import zen.grammar.StringLiteralTokenFunction;
import zen.grammar.SymbolExpressionPatternFunction;
import zen.grammar.SymbolStatementPatternFunction;
import zen.grammar.ThrowPatternFunction;
import zen.grammar.TruePatternFunction;
import zen.grammar.TryPatternFunction;
import zen.grammar.TypeAnnotationPatternFunction;
import zen.grammar.TypePatternFunction;
import zen.grammar.UnaryPatternFunction;
import zen.grammar.VarPatternFunction;
import zen.grammar.WhilePatternFunction;
import zen.grammar.WhiteSpaceTokenFunction;
import zen.parser.ZNameSpace;
import zen.type.ZFuncType;
import zen.type.ZGenericType;
import zen.type.ZType;

public class ZenGrammar {
	public static void ImportGrammar(ZNameSpace NameSpace) {
		NameSpace.SetTypeName(ZType.VoidType,  null);
		NameSpace.SetTypeName(ZType.BooleanType, null);
		NameSpace.SetTypeName(ZType.IntType, null);
		NameSpace.SetTypeName(ZType.FloatType, null);
		NameSpace.SetTypeName(ZType.StringType, null);
		NameSpace.SetTypeName(ZType.TypeType, null);
		NameSpace.SetTypeName(ZGenericType._ArrayType, null);
		NameSpace.SetTypeName(ZGenericType._MapType, null);
		NameSpace.SetTypeName(ZFuncType._FuncType, null);

		NameSpace.AppendTokenFunc(" \t", new WhiteSpaceTokenFunction());
		NameSpace.AppendTokenFunc("\n",  new NewLineTokenFunction());
		NameSpace.AppendTokenFunc("{}()[]<>.,;?:+-*/%=&|!@~^$", new OperatorTokenFunction());
		NameSpace.AppendTokenFunc("/", new BlockCommentFunction());  // overloading
		NameSpace.AppendTokenFunc("Aa_", new NameTokenFunction());

		NameSpace.AppendTokenFunc("\"", new StringLiteralTokenFunction());
		NameSpace.AppendTokenFunc("1",  new NumberLiteralTokenFunction());

		@Var ZMatchFunction MatchUnary     = new UnaryPatternFunction();
		@Var ZMatchFunction MatchBinary    = new BinaryPatternFunction();
		@Var ZMatchFunction MatchComparator    = new ComparatorPatternFunction();

		NameSpace.DefineExpression("null", new NullPatternFunction());
		NameSpace.DefineExpression("true", new TruePatternFunction());
		NameSpace.DefineExpression("false", new FalsePatternFunction());

		NameSpace.DefineExpression("+", MatchUnary);
		NameSpace.DefineExpression("-", MatchUnary);
		NameSpace.DefineExpression("~", MatchUnary);
		NameSpace.DefineExpression("!", new NotPatternFunction());
		//		NameSpace.AppendSyntax("++ --", new Incl"));

		NameSpace.DefineRightExpression("* / %", ZenPrecedence._CStyleMUL, MatchBinary);
		NameSpace.DefineRightExpression("+ -", ZenPrecedence._CStyleADD, MatchBinary);

		NameSpace.DefineRightExpression("< <= > >=", ZenPrecedence._CStyleCOMPARE, MatchComparator);
		NameSpace.DefineRightExpression("== !=", ZenPrecedence._CStyleEquals, MatchComparator);

		NameSpace.DefineRightExpression("<< >>", ZenPrecedence._CStyleSHIFT, MatchBinary);
		NameSpace.DefineRightExpression("&", ZenPrecedence._CStyleBITAND, MatchBinary);
		NameSpace.DefineRightExpression("|", ZenPrecedence._CStyleBITOR, MatchBinary);
		NameSpace.DefineRightExpression("^", ZenPrecedence._CStyleBITXOR, MatchBinary);

		//		NameSpace.DefineRightExpression("=", ZenPrecedence.CStyleAssign | ZParserConst.LeftJoin, MatchBinary);

		NameSpace.DefineRightExpression("&&", ZenPrecedence._CStyleAND, new AndPatternFunction());
		NameSpace.DefineRightExpression("||", ZenPrecedence._CStyleOR, new OrPatternFunction());

		NameSpace.DefineExpression("$Type$",new TypePatternFunction());
		NameSpace.DefineExpression("$TypeRight$", new RightTypePatternFunction());
		NameSpace.DefineExpression("$TypeAnnotation$", new TypeAnnotationPatternFunction());

		NameSpace.DefineExpression("$StringLiteral$", new StringLiteralPatternFunction());
		NameSpace.DefineExpression("$IntegerLiteral$", new IntLiteralPatternFunction());
		NameSpace.DefineExpression("$FloatLiteral$", new FloatLiteralPatternFunction());

		NameSpace.DefineRightExpression(".", 0, new GetterPatternFunction());
		NameSpace.DefineRightExpression(".", 0, new SetterPatternFunction());
		NameSpace.DefineRightExpression(".", 0, new MethodCallPatternFunction());

		NameSpace.DefineExpression("(", new GroupPatternFunction());
		NameSpace.DefineExpression("(", new CastPatternFunction());
		NameSpace.DefineRightExpression("(", 0, new ApplyPatternFunction());

		NameSpace.DefineRightExpression("[", 0, new GetIndexPatternFunction());
		NameSpace.DefineRightExpression("[", 0, new SetIndexPatternFunction());
		NameSpace.DefineExpression("[", new ArrayLiteralPatternFunction());
		NameSpace.DefineExpression("$MapEntry$", new MapEntryPatternFunction());
		NameSpace.DefineExpression("{", new MapLiteralPatternFunction());
		NameSpace.DefineExpression("new", new NewObjectPatternFunction());

		NameSpace.DefineStatement(";", new StatementEndPatternFunction());
		NameSpace.DefineExpression("$Block$", new BlockPatternFunction());
		NameSpace.DefineExpression("$Annotation$", new AnnotationPatternFunction());
		NameSpace.DefineExpression("$SymbolExpression$", new SymbolExpressionPatternFunction());
		// don't change DefineStatement for $SymbolStatement$
		NameSpace.DefineExpression("$SymbolStatement$", new SymbolStatementPatternFunction());
		NameSpace.DefineExpression("$Statement$", new StatementPatternFunction());
		NameSpace.DefineExpression("$Expression$", new ExpressionPatternFunction());
		NameSpace.DefineExpression("$RightExpression$", new RightExpressionPatternFunction());

		NameSpace.DefineStatement("if", new IfPatternFunction());
		NameSpace.DefineStatement("return", new ReturnPatternFunction());
		NameSpace.DefineStatement("while", new WhilePatternFunction());
		NameSpace.DefineStatement("break", new BreakPatternFunction());

		NameSpace.DefineExpression("$Name$", new NamePatternFunction());
		NameSpace.DefineStatement("var",  new VarPatternFunction());
		NameSpace.DefineExpression("$Param$", new ParamPatternFunction());
		NameSpace.DefineExpression("function", new PrototypePatternFunction());
		NameSpace.DefineExpression("function", new FunctionPatternFunction());

		NameSpace.DefineStatement("let", new LetPatternFunction());
		NameSpace.DefineStatement("export", new ExportPatternFunction());
		NameSpace.Generator.AppendGrammarInfo("zen-0.1");

		NameSpace.DefineStatement("try", new TryPatternFunction());
		NameSpace.DefineExpression("$Catch$", new CatchPatternFunction());
		NameSpace.DefineStatement("throw", new ThrowPatternFunction());
		NameSpace.Generator.AppendGrammarInfo("zen-trycatch-0.1");

		NameSpace.DefineRightExpression("instanceof", ZenPrecedence._Instanceof, new InstanceOfPatternFunction());
		NameSpace.DefineStatement("class", new ClassPatternFunction());
		NameSpace.DefineExpression("$FieldDecl$", new FieldPatternFunction());

		NameSpace.Generator.AppendGrammarInfo("zen-class-0.1");
		NameSpace.DefineStatement("assert", new AssertPatternFunction());

	}

}
