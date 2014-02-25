LibZen = {};
LibZen.AnotherName = (function(s){
	var ch = s.charAt(0);
	var chAnother = ch.toLowerCase();
	if(ch == chAnother){
		ch = ch.toUpperCase();
	}
	return ch + s.substring(1);
});

LibZen.ApplyMatchFunc = (function(MatchFunc, ParentNode, TokenContext, LeftNode){
	return MatchFunc.call(ParentNode, TokenContext, LeftNode);
});

LibZen.ApplyTokenFunc = (function(TokenFunc, SourceContext){
	return TokenFunc.call(SourceContext);
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

LibZen.GetTokenMatrixIndex = (function(){
	throw new Error("Not impremented");
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

LibZen.NewMap = (function(){
	throw new Error("Not impremented");
});

LibZen.NewNodeArray = (function(){
	throw new Error("Not impremented");
});

LibZen.NewTokenMatrix = (function(){
	throw new Error("Not impremented");
});

LibZen.NewTypeArray = (function(){
	throw new Error("Not impremented");
});

LibZen.ParseFloat = (function(){
	throw new Error("Not impremented");
});

LibZen.ParseInt = (function(){
	throw new Error("Not impremented");
});

LibZen.PrintDebug = (function(){
	throw new Error("Not impremented");
});

LibZen.PrintLine = (function(){
	throw new Error("Not impremented");
});

LibZen.QuoteString = (function(){
	throw new Error("Not impremented");
});

LibZen.SourceBuilderToString = (function(){
	throw new Error("Not impremented");
});

LibZen.Stringfy = (function(){
	throw new Error("Not impremented");
});

LibZen.UnquoteString = (function(){
	throw new Error("Not impremented");
});

LibZen.WriteTo = (function(){
	throw new Error("Not impremented");
});

LibZen_ArrayAdd = (function(){
	throw new Error("Not impremented");
});

LibZen_ArrayAdd2 = (function(){
	throw new Error("Not impremented");
});

LibZen_ArrayClear = (function(){
	throw new Error("Not impremented");
});

LibZen_ArraySize = (function(){
	throw new Error("Not impremented");
});

LibZen_Assert = (function(){
	throw new Error("Not impremented");
});

LibZen_BooleanToString = (function(){
	throw new Error("Not impremented");
});

LibZen_EndWidth = (function(){
	throw new Error("Not impremented");
});

LibZen_EqualsString = (function(){
	throw new Error("Not impremented");
});

LibZen_FloatToString = (function(){
	throw new Error("Not impremented");
});

LibZen_GreekNames_Z0 = (function(){
	throw new Error("Not impremented");
});

LibZen_IndexOf = (function(){
	throw new Error("Not impremented");
});

LibZen_IndexOf2 = (function(){
	throw new Error("Not impremented");
});

LibZen_IntToString = (function(){
	throw new Error("Not impremented");
});

LibZen_Is = (function(){
	throw new Error("Not impremented");
});

LibZen_NewArray = (function(){
	throw new Error("Not impremented");
});

LibZen_NewFloatArray = (function(){
	throw new Error("Not impremented");
});

LibZen_NewFloatMap = (function(){
	throw new Error("Not impremented");
});

LibZen_NewIntArray = (function(){
	throw new Error("Not impremented");
});

LibZen_NewIntMap = (function(){
	throw new Error("Not impremented");
});

LibZen_NewMap = (function(){
	throw new Error("Not impremented");
});

LibZen_NewStringArray = (function(){
	throw new Error("Not impremented");
});

LibZen_NewStringMap = (function(){
	throw new Error("Not impremented");
});

LibZen_ParseInt = (function(){
	throw new Error("Not impremented");
});

LibZen_Print = (function(){
	throw new Error("Not impremented");
});

LibZen_PrintLine = (function(){
	throw new Error("Not impremented");
});

LibZen_StartsWith = (function(){
	throw new Error("Not impremented");
});

LibZen_StrCat = (function(){
	throw new Error("Not impremented");
});

LibZen_StringSize = (function(){
	throw new Error("Not impremented");
});

LibZen_SubString = (function(){
	throw new Error("Not impremented");
});

LibZen_SubString2 = (function(){
	throw new Error("Not impremented");
});
