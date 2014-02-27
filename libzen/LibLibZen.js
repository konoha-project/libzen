var JavaScriptGlobal = Function("return this")();

var __extends = this.__extends || function (d, b) {
   for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
   function __() { this.constructor = d; }
   __.prototype = b.prototype;
   d.prototype = new __();
};

Object.prototype.IsVarType = function (self) {
   return self.HasUnknownType;
};
Object.prototype.IsGreekType = function (self) {
   return self.HasGreekType;
};
var ZTypePool_TypeList_Z17 = [];
var ZTypePool_ClassNameMap_Z18 = {};
var ZTypePool_UniqueTypeSetMap_Z19 = {};

var LibZen = {};

LibZen.NullChar			= 0;
LibZen.UndefinedChar	= 1;
LibZen.DigitChar		= 2;
LibZen.UpperAlphaChar	= 3;
LibZen.LowerAlphaChar	= 4;
LibZen.UnderBarChar		= 5;
LibZen.NewLineChar		= 6;
LibZen.TabChar			= 7;
LibZen.SpaceChar		= 8;
LibZen.OpenParChar		= 9;
LibZen.CloseParChar		= 10;
LibZen.OpenBracketChar	= 11;
LibZen.CloseBracketChar	= 12;
LibZen.OpenBraceChar	= 13;
LibZen.CloseBraceChar	= 14;
LibZen.LessThanChar		= 15;
LibZen.GreaterThanChar	= 16;
LibZen.QuoteChar		= 17;
LibZen.DoubleQuoteChar	= 18;
LibZen.BackQuoteChar	= 19;
LibZen.SurprisedChar	= 20;
LibZen.SharpChar		= 21;
LibZen.DollarChar		= 22;
LibZen.PercentChar		= 23;
LibZen.AndChar			= 24;
LibZen.StarChar			= 25;
LibZen.PlusChar			= 26;
LibZen.CommaChar		= 27;
LibZen.MinusChar		= 28;
LibZen.DotChar			= 29;
LibZen.SlashChar		= 30;
LibZen.ColonChar		= 31;
LibZen.SemiColonChar	= 32;
LibZen.EqualChar		= 33;
LibZen.QuestionChar		= 34;
LibZen.AtmarkChar		= 35;
LibZen.VarChar			= 36;
LibZen.ChilderChar		= 37;
LibZen.BackSlashChar	= 38;
LibZen.HatChar			= 39;
LibZen.UnicodeChar		= 40;
LibZen.MaxSizeOfChars	= 41;

LibZen.CharMatrix = [
		/*nul soh stx etx eot enq ack bel*/
		0, 1, 1, 1, 1, 1, 1, 1,
		/*bs ht nl vt np cr so si  */
		1, LibZen.TabChar, LibZen.NewLineChar, 1, 1, LibZen.NewLineChar, 1, 1,
		/*020 LibZen.dle  021 LibZen.dc1  022 LibZen.dc2  023 LibZen.dc3  024 LibZen.dc4  025 LibZen.nak  026 LibZen.syn  027 LibZen.etb */
		1, 1, 1, 1, 1, 1, 1, 1,
		/*030 LibZen.can  031 LibZen.em   032 LibZen.sub  033 LibZen.esc  034 LibZen.fs   035 LibZen.gs   036 LibZen.rs   037 LibZen.us */
		1, 1, 1, 1, 1, 1, 1, 1,
		/*040 LibZen.sp   041  !   042  "   043  #   044  $   045  %   046  &   047  ' */
		LibZen.SpaceChar, LibZen.SurprisedChar, LibZen.DoubleQuoteChar, LibZen.SharpChar, LibZen.DollarChar, LibZen.PercentChar, LibZen.AndChar, LibZen.QuoteChar,
		/*050  (   051  )   052  *   053  +   054  ,   055  -   056  .   057  / */
		LibZen.OpenParChar, LibZen.CloseParChar, LibZen.StarChar, LibZen.PlusChar, LibZen.CommaChar, LibZen.MinusChar, LibZen.DotChar, LibZen.SlashChar,
		/*060  0   061  1   062  2   063  3   064  4   065  5   066  6   067  7 */
		LibZen.DigitChar, LibZen.DigitChar, LibZen.DigitChar, LibZen.DigitChar, LibZen.DigitChar, LibZen.DigitChar, LibZen.DigitChar, LibZen.DigitChar,
		/*070  8   071  9   072  :   073  ;   074  <   075  =   076  >   077  ? */
		LibZen.DigitChar, LibZen.DigitChar, LibZen.ColonChar, LibZen.SemiColonChar, LibZen.LessThanChar, LibZen.EqualChar, LibZen.GreaterThanChar, LibZen.QuestionChar,
		/*100  @   101  LibZen.A   102  LibZen.B   103  LibZen.C   104  LibZen.D   105  LibZen.E   106  LibZen.F   107  LibZen.G */
		LibZen.AtmarkChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar,
		/*110  LibZen.H   111  LibZen.I   112  LibZen.J   113  LibZen.K   114  LibZen.L   115  LibZen.M   116  LibZen.N   117  LibZen.O */
		LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar,
		/*120  LibZen.P   121  LibZen.Q   122  LibZen.R   123  LibZen.S   124  LibZen.T   125  LibZen.U   126  LibZen.V   127  LibZen.W */
		LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar,
		/*130  LibZen.X   131  LibZen.Y   132  LibZen.Z   133  [   134  \   135  ]   136  ^   137  _ */
		LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.UpperAlphaChar, LibZen.OpenBracketChar, LibZen.BackSlashChar, LibZen.CloseBracketChar, LibZen.HatChar, LibZen.UnderBarChar,
		/*140  `   141  LibZen.a   142  LibZen.b   143  LibZen.c   144  LibZen.d   145  LibZen.e   146  LibZen.f   147  LibZen.g */
		LibZen.BackQuoteChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar,
		/*150  LibZen.h   151  LibZen.i   152  LibZen.j   153  LibZen.k   154  LibZen.l   155  LibZen.m   156  LibZen.n   157  LibZen.o */
		LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar,
		/*160  LibZen.p   161  LibZen.q   162  LibZen.r   163  LibZen.s   164  LibZen.t   165  LibZen.u   166  LibZen.v   167  LibZen.w */
		LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar,
		/*170  LibZen.x   171  LibZen.y   172  LibZen.z   173  {   174  |   175  }   176  ~   177 LibZen.del*/
		LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.LowerAlphaChar, LibZen.OpenBraceChar, LibZen.VarChar, LibZen.CloseBraceChar, LibZen.ChilderChar, 1,
	];

LibZen.GenMap = null;

LibZen.FindGrobalMethodStartsWith = (function(Key){
	var Keys = Object.keys(JavaScriptGlobal);
	for(var i = 0; i < Keys.length; i++){
		if(Keys[i].indexOf(Key) == 0) return JavaScriptGlobal[Keys[i]];
	}
	return undefined;
});

LibZen.LoadGenerator = (function(ClassName, GeneratorClass){
	if(!LibZen.GenMap){
		LibZen.GenMap = {
			//py: PythonGenerator,
			//javascript: JavaScriptSourceGenerator,
			//js: JavaScriptSourceGenerator,
			//ruby: RubySourceGenerator,
			//clisp: CommonLispSourceGenerator,
			c: CSourceGenerator,
			//llvm: LLVMSourceGenerator,
		};
	}
	if(!ClassName){
		ClassName = "js";
	}
	if(!GeneratorClass){
		GeneratorClass = LibZen.GenMap[ClassName];
	}
	if(GeneratorClass){
		var Constructor = LibZen.FindGrobalMethodStartsWith(GeneratorClass.name + "__");
		if(Constructor){
			return Constructor(new GeneratorClass());
		}
	}
	return null;
});

LibZen.ImportGrammar = (function(NameSpace, ClassName){
	try{
		NameSpace.ImportGrammar(ClassName);
		return true;
	}catch(e){
		return false;
	}
});

LibZen.LoadEngine = (function(ClassName, GrammarClass){
	var Generator = LibZen.LoadGenerator(ClassName, null);
	LibZen.ImportGrammar(Generator.RootNameSpace, GrammarClass);
	Generator.ImportLocalGrammar(Generator.RootNameSpace);
	return Generator.GetEngine();
});

LibZen.AnotherName = (function(s){
	var ch = s.charAt(0);
	var chAnother = ch.toLowerCase();
	if(ch == chAnother){
		ch = ch.toUpperCase();
	}
	return ch + s.substring(1);
});

LibZen.ApplyMatchFunc = (function(MatchFunc, ParentNode, TokenContext, LeftNode){
	return MatchFunc(ParentNode, TokenContext, LeftNode);
});

LibZen.ApplyTokenFunc = (function(TokenFunc, SourceContext){
	return TokenFunc(SourceContext);
});

LibZen.ArrayCopy = (function(src, sIndex, dst, dIndex, length){
	for(var i = 0; i < length; i++){
		dst[dIndex + i] = src[sIndex + i];
	}
});

LibZen.Assert = (function(TestResult){
	if (!TestResult) {
		throw new Error("ASSERTION FAILED");
	}
});

LibZen.GetChar = (function(Text, Pos){
	return Text.charCodeAt(Pos);
});

LibZen.GetClassName = (function(Value){
	return Value.constructor.name;
});

LibZen.GetTokenMatrixIndex = (function(c){
	if(c < 128) {
		return LibZen.CharMatrix[c];
	}
	return LibZen.UnicodeChar;
});

LibZen.IsDigit = (function(ch){
	return 48/*0*/ <= ch && ch <= 57/*9*/;
});

LibZen.IsFlag = (function(flag, flag2){
	return ((flag & flag2) == flag2);
});

LibZen.IsLetter = (function(ch){
	if(ch > 90){
		ch -= 0x20;
	}
	return 65/*A*/ <= ch && ch <= 90/*Z*/;
});

LibZen.IsSymbol = (function(ch){
	return LibZen.IsLetter(ch) || ch == 95/*_*/ || ch > 255;
});

LibZen.JoinStrings = (function(Unit, Times){
	var Builder = [];
	for(var i = 0; i < Times; i++){
		Builder.push(Unit);
	}
	return Builder.join("");
});

LibZen.NewNodeArray = (function(Size){
	var a = [];
	a[Size - 1] = null;
	return a;
});

LibZen.NewTokenMatrix = (function(){
	var a = [];
	a[LibZen.MaxSizeOfChars - 1] = null;
	return a;
});

LibZen.NewTypeArray = (function(Size){
	var a = [];
	a[Size - 1] = null;
	return a;
});

LibZen.ParseFloat = (function(Text){
	return parseFloat(Text);
});

LibZen.ParseInt = (function(Text){
	return parseInt(Text);
});

LibZen.PrintDebug = (function(){
	console.log(msg);
});

LibZen.PrintLine = (function(msg){
	console.log(msg);
});

LibZen.QuoteString = (function(Text){
	var sb = [];
	sb.push('"');
	for(var i = 0; i < Text.length(); i = i + 1) {
		var ch = Text.charAt(i);
		if(ch == '\n') {
			sb.push("\\n");
		}
		else if(ch == '\t') {
			sb.push("\\t");
		}
		else if(ch == '"') {
			sb.push("\\\"");
		}
		else if(ch == '\\') {
			sb.push("\\\\");
		}
		else {
			sb.push(ch);
		}
	}
	sb.push('"');
	return sb.join("");
});

LibZen.SourceBuilderToString = (function(Builder, BeginIndex, EndIndex){
	var builder = [];
	if(BeginIndex == undefined){
		BeginIndex = 0;
	}
	if(EndIndex == undefined){
		EndIndex = Builder.SourceList.length();
	}
	for(var i = BeginIndex; i < EndIndex; i = i + 1) {
		builder.push(Builder.SourceList.ArrayValues[i]);
	}
	return builder.join("");
});

LibZen.StringMatrix = [
		"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "0", "4",
		"a", "s", "d", "f", "g", "h", "j", "k", "l", "9", "1", "6",
		"z", "x", "c", "v", "b", "n", "m", "7", "5", "3", "2", "8"
	];

LibZen.Stringfy = (function(number){
	var l = LibZen.StringMatrix.length;
	var d = number % l;
	number = number / l;
	var c = number % l;
	number = number / l;
	return LibZen.StringMatrix[number] + LibZen.StringMatrix[c] + LibZen.StringMatrix[d];
});

LibZen.UnquoteString = (function(Text){
	var sb = []
	var quote = Text.charAt(0);
	var i = 0;
	var Length = Text.length;
	if(quote == '"' || quote == '\'') {
		i = 1;
		Length -= 1;
	}
	else {
		quote = '\0';
	}
	for(; i < Length; i += 1) {
		var ch = Text.charAt(i);
		if(ch == '\\') {
			i++;
			var next = Text.charAt(i);
			switch (next) {
			case 't':
				ch = '\t';
				break;
			case 'n':
				ch = '\n';
				break;
			case '"':
				ch = '"';
				break;
			case '\'':
				ch = '\'';
				break;
			case '\\':
				ch = '\\';
				break;
			default:
				ch = next;
				break;
			}
		}
		sb.push(ch);
	}
	return sb.join("");
});

LibZen.WriteTo = (function(FileName, List){
	if(FileName == null) {
		for(var i = 0; i < List.size(); i++) {
			var Builder = List.ArrayValues[i];
			console.log(Builder.toString());
			Builder.Clear();
		}
	}else{
		throw new Error("Not impremented");
	}
});
