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
package zen.deps;
import zen.grammar.AndPattern;
import zen.grammar.AnnotationPattern;
import zen.grammar.ApplyPattern;
import zen.grammar.ArrayLiteralPattern;
import zen.grammar.AssertPattern;
import zen.grammar.BinaryPattern;
import zen.grammar.BlockComment;
import zen.grammar.BlockPattern;
import zen.grammar.BreakPattern;
import zen.grammar.CastPattern;
import zen.grammar.CatchPattern;
import zen.grammar.ClassPattern;
import zen.grammar.ComparatorPattern;
import zen.grammar.ExpressionPattern;
import zen.grammar.FalsePattern;
import zen.grammar.FieldPattern;
import zen.grammar.FloatLiteralPattern;
import zen.grammar.FunctionPattern;
import zen.grammar.GetIndexPattern;
import zen.grammar.GetterPattern;
import zen.grammar.GroupPattern;
import zen.grammar.IfPattern;
import zen.grammar.InstanceOfPattern;
import zen.grammar.IntLiteralPattern;
import zen.grammar.LetPattern;
import zen.grammar.MapEntryPattern;
import zen.grammar.MapLiteralPattern;
import zen.grammar.MethodCallPattern;
import zen.grammar.NamePattern;
import zen.grammar.NameToken;
import zen.grammar.NewLineToken;
import zen.grammar.NewObjectPattern;
import zen.grammar.NotPattern;
import zen.grammar.NullPattern;
import zen.grammar.NumberLiteralToken;
import zen.grammar.OperatorToken;
import zen.grammar.OrPattern;
import zen.grammar.ParamPattern;
import zen.grammar.PrototypePattern;
import zen.grammar.ReturnPattern;
import zen.grammar.RightExpressionPattern;
import zen.grammar.RightTypePattern;
import zen.grammar.SetIndexPattern;
import zen.grammar.SetterPattern;
import zen.grammar.StatementEndPattern;
import zen.grammar.StatementPattern;
import zen.grammar.StringLiteralPattern;
import zen.grammar.StringLiteralToken;
import zen.grammar.SymbolExpressionPattern;
import zen.grammar.SymbolStatementPattern;
import zen.grammar.ThrowPattern;
import zen.grammar.TruePattern;
import zen.grammar.TryPattern;
import zen.grammar.TypeAnnotationPattern;
import zen.grammar.TypePattern;
import zen.grammar.UnaryPattern;
import zen.grammar.VarPattern;
import zen.grammar.WhilePattern;
import zen.grammar.WhiteSpaceToken;
import zen.lang.ZenPrecedence;
import zen.parser.ZNameSpace;
import zen.type.ZType;

public class KonohaGrammar {
	public static void ImportGrammar(ZNameSpace NameSpace, Class<?> Grammar) {
		NameSpace.SetTypeName(ZType.VoidType,  null);
		NameSpace.SetTypeName(ZType.BooleanType, null);
		NameSpace.SetTypeName(ZType.IntType, null);
		NameSpace.SetTypeName(ZType.FloatType, null);
		NameSpace.SetTypeName(ZType.StringType, null);
		NameSpace.SetTypeName(ZType.TypeType, null);
		NameSpace.SetTypeName(ZType.ArrayType, null);
		NameSpace.SetTypeName(ZType.MapType, null);
		NameSpace.SetTypeName(ZType.FuncType, null);

		NameSpace.AppendTokenFunc(" \t", new WhiteSpaceToken());
		NameSpace.AppendTokenFunc("\n",  new NewLineToken());
		NameSpace.AppendTokenFunc("{}()[]<>.,;?:+-*/%=&|!@~^$", new OperatorToken());
		NameSpace.AppendTokenFunc("/", new BlockComment());  // overloading
		NameSpace.AppendTokenFunc("Aa_", new NameToken());

		NameSpace.AppendTokenFunc("\"", new StringLiteralToken());
		NameSpace.AppendTokenFunc("1",  new NumberLiteralToken());

		@Var ZMatchFunction MatchUnary     = new UnaryPattern();
		@Var ZMatchFunction MatchBinary    = new BinaryPattern();
		@Var ZMatchFunction MatchComparator    = new ComparatorPattern();

		NameSpace.DefineExpression("null", new NullPattern());
		NameSpace.DefineExpression("true", new TruePattern());
		NameSpace.DefineExpression("false", new FalsePattern());

		NameSpace.DefineExpression("+", MatchUnary);
		NameSpace.DefineExpression("-", MatchUnary);
		NameSpace.DefineExpression("~", MatchUnary);
		NameSpace.DefineExpression("!", new NotPattern());
		//		NameSpace.AppendSyntax("++ --", new Incl"));

		NameSpace.DefineRightExpression("* / %", ZenPrecedence.CStyleMUL, MatchBinary);
		NameSpace.DefineRightExpression("+ -", ZenPrecedence.CStyleADD, MatchBinary);

		NameSpace.DefineRightExpression("< <= > >=", ZenPrecedence.CStyleCOMPARE, MatchComparator);
		NameSpace.DefineRightExpression("== !=", ZenPrecedence.CStyleEquals, MatchComparator);

		NameSpace.DefineRightExpression("<< >>", ZenPrecedence.CStyleSHIFT, MatchBinary);
		NameSpace.DefineRightExpression("&", ZenPrecedence.CStyleBITAND, MatchBinary);
		NameSpace.DefineRightExpression("|", ZenPrecedence.CStyleBITOR, MatchBinary);
		NameSpace.DefineRightExpression("^", ZenPrecedence.CStyleBITXOR, MatchBinary);

		//		NameSpace.DefineRightExpression("=", ZenPrecedence.CStyleAssign | ZParserConst.LeftJoin, MatchBinary);

		NameSpace.DefineRightExpression("&&", ZenPrecedence.CStyleAND, new AndPattern());
		NameSpace.DefineRightExpression("||", ZenPrecedence.CStyleOR, new OrPattern());

		NameSpace.DefineExpression("$Type$",new TypePattern());
		NameSpace.DefineExpression("$TypeRight$", new RightTypePattern());
		NameSpace.DefineExpression("$TypeAnnotation$", new TypeAnnotationPattern());

		NameSpace.DefineExpression("$StringLiteral$", new StringLiteralPattern());
		NameSpace.DefineExpression("$IntegerLiteral$", new IntLiteralPattern());
		NameSpace.DefineExpression("$FloatLiteral$", new FloatLiteralPattern());

		NameSpace.DefineRightExpression(".", 0, new GetterPattern());
		NameSpace.DefineRightExpression(".", 0, new SetterPattern());
		NameSpace.DefineRightExpression(".", 0, new MethodCallPattern());

		NameSpace.DefineExpression("(", new GroupPattern());
		NameSpace.DefineExpression("(", new CastPattern());
		NameSpace.DefineRightExpression("(", 0, new ApplyPattern());

		NameSpace.DefineRightExpression("[", 0, new GetIndexPattern());
		NameSpace.DefineRightExpression("[", 0, new SetIndexPattern());
		NameSpace.DefineExpression("[", new ArrayLiteralPattern());
		NameSpace.DefineExpression("$MapEntry$", new MapEntryPattern());
		NameSpace.DefineExpression("{", new MapLiteralPattern());
		NameSpace.DefineExpression("new", new NewObjectPattern());

		NameSpace.DefineStatement(";", new StatementEndPattern());
		NameSpace.DefineExpression("$Block$", new BlockPattern());
		NameSpace.DefineExpression("$Annotation$", new AnnotationPattern());
		NameSpace.DefineExpression("$SymbolExpression$", new SymbolExpressionPattern());
		// don't change DefineStatement for $SymbolStatement$
		NameSpace.DefineExpression("$SymbolStatement$", new SymbolStatementPattern());
		NameSpace.DefineExpression("$Statement$", new StatementPattern());
		NameSpace.DefineExpression("$Expression$", new ExpressionPattern());
		NameSpace.DefineExpression("$RightExpression$", new RightExpressionPattern());

		NameSpace.DefineStatement("if", new IfPattern());
		NameSpace.DefineStatement("return", new ReturnPattern());
		NameSpace.DefineStatement("while", new WhilePattern());
		NameSpace.DefineStatement("break", new BreakPattern());

		NameSpace.DefineExpression("$Name$", new NamePattern());
		NameSpace.DefineStatement("var",  new VarPattern());
		NameSpace.DefineExpression("$Param$", new ParamPattern());
		NameSpace.DefineExpression("function", new PrototypePattern());
		NameSpace.DefineExpression("function", new FunctionPattern());

		NameSpace.DefineStatement("let", new LetPattern());
		NameSpace.Generator.AppendGrammarInfo("zen-0.1");

		NameSpace.DefineStatement("try", new TryPattern());
		NameSpace.DefineExpression("$Catch$", new CatchPattern());
		NameSpace.DefineStatement("throw", new ThrowPattern());
		NameSpace.Generator.AppendGrammarInfo("zen-trycatch-0.1");

		NameSpace.DefineRightExpression("instanceof", ZenPrecedence.Instanceof, new InstanceOfPattern());
		NameSpace.DefineStatement("class", new ClassPattern());
		NameSpace.DefineExpression("$FieldDecl$", new FieldPattern());

		NameSpace.Generator.AppendGrammarInfo("zen-class-0.1");

		NameSpace.DefineStatement("assert", new AssertPattern());

	}

}
