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
import libzen.grammar.AndPattern;
import libzen.grammar.AnnotationPattern;
import libzen.grammar.ApplyPattern;
import libzen.grammar.ArrayLiteralPattern;
import libzen.grammar.AssertPattern;
import libzen.grammar.BinaryPattern;
import libzen.grammar.BlockComment;
import libzen.grammar.BlockPattern;
import libzen.grammar.BreakPattern;
import libzen.grammar.CastPattern;
import libzen.grammar.CatchPattern;
import libzen.grammar.ClassPattern;
import libzen.grammar.ComparatorPattern;
import libzen.grammar.ExpressionPattern;
import libzen.grammar.FalsePattern;
import libzen.grammar.FieldPattern;
import libzen.grammar.FloatLiteralPattern;
import libzen.grammar.FunctionPattern;
import libzen.grammar.GetIndexPattern;
import libzen.grammar.GetterPattern;
import libzen.grammar.GroupPattern;
import libzen.grammar.IfPattern;
import libzen.grammar.ImportPattern;
import libzen.grammar.InstanceOfPattern;
import libzen.grammar.IntLiteralPattern;
import libzen.grammar.LetPattern;
import libzen.grammar.MapEntryPattern;
import libzen.grammar.MapLiteralPattern;
import libzen.grammar.MethodCallPattern;
import libzen.grammar.NamePattern;
import libzen.grammar.NameToken;
import libzen.grammar.NewLineToken;
import libzen.grammar.NewObjectPattern;
import libzen.grammar.NotPattern;
import libzen.grammar.NullPattern;
import libzen.grammar.NumberLiteralToken;
import libzen.grammar.OperatorToken;
import libzen.grammar.OrPattern;
import libzen.grammar.ParamPattern;
import libzen.grammar.PathPattern;
import libzen.grammar.ReturnPattern;
import libzen.grammar.RightExpressionPattern;
import libzen.grammar.RightTypePattern;
import libzen.grammar.SetIndexPattern;
import libzen.grammar.SetterPattern;
import libzen.grammar.StatementEndPattern;
import libzen.grammar.StatementPattern;
import libzen.grammar.StringLiteralPattern;
import libzen.grammar.StringLiteralToken;
import libzen.grammar.SymbolExpressionPattern;
import libzen.grammar.SymbolStatementPattern;
import libzen.grammar.ThrowPattern;
import libzen.grammar.TruePattern;
import libzen.grammar.TryPattern;
import libzen.grammar.TypeAnnotationPattern;
import libzen.grammar.TypePattern;
import libzen.grammar.UnaryPattern;
import libzen.grammar.VarPattern;
import libzen.grammar.WhilePattern;
import libzen.grammar.WhiteSpaceToken;
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
		NameSpace.DefineStatement("import", new ImportPattern());
		NameSpace.DefineExpression("$Path$", new PathPattern());

		NameSpace.Generator.AppendGrammarInfo("zen-class-0.1");

		NameSpace.DefineStatement("assert", new AssertPattern());

	}

}
