
var ZClassField = (function() {
   function ZClassField(){
      this.FieldFlag = 0;
      this.ClassType = null;
      this.FieldType = null;
      this.FieldName = null;
      this.FieldNativeIndex = 0;
      this.SourceToken = null;
}
   return ZClassField;
})();

var ZFunc = (function() {
   function ZFunc(){
      this.FuncFlag = 0;
      this.FuncName = null;
      this.FuncType = null;
}
   return ZFunc;
})();

var ZPrototype = (function(_super) {
   __extends(_super, ZPrototype);
   function ZPrototype(){
      this.DefinedCount = 0;
      this.UsedCount = 0;
}
   return ZPrototype;
})(ZFunc);

var ZType = (function() {
   function ZType(){
      this.TypeFlag = 0;
      this.TypeId = 0;
      this.ShortName = null;
      this.RefType = null;
      this.GetRealType = null;
      this.GetSuperType = null;
      this.GetBaseType = null;
      this.GetParamSize = null;
      this.GetParamType = null;
      this.IsGreekType = null;
      this.GetGreekRealType = null;
      this.AcceptValueType = null;
      this.IsVarType = null;
}
   return ZType;
})();

var ZTypePool = (function() {
   function ZTypePool(){
}
   return ZTypePool;
})();

var ZVarScope = (function() {
   function ZVarScope(){
      this.Parent = null;
      this.Logger = null;
      this.VarList = null;
      this.VarNodeCount = 0;
      this.UnresolvedSymbolCount = 0;
}
   return ZVarScope;
})();

var ZVarType = (function(_super) {
   __extends(_super, ZVarType);
   function ZVarType(){
      this.VarList = null;
      this.SourceToken = null;
      this.GreekId = 0;
}
   return ZVarType;
})(ZType);

var ZNode = (function() {
   function ZNode(){
      this.ParentNode = null;
      this.SourceToken = null;
      this.AST = null;
      this.Type = ZTypeVarType;
      this.HasUntypedNode = true;
      this.SetNameInfo = null;
      this.SetTypeInfo = null;
      this.IsBreakingBlock = null;
      this.DeSugar = null;
      this.Accept = null;
}
   return ZNode;
})();

var ZParamNode = (function(_super) {
   __extends(_super, ZParamNode);
   function ZParamNode(){
      this.Name = null;
      this.NameToken = null;
      this.ParamIndex = 0;
}
   return ZParamNode;
})(ZNode);

var ZReturnNode = (function(_super) {
   __extends(_super, ZReturnNode);
   function ZReturnNode(){
}
   return ZReturnNode;
})(ZNode);

var ZSetIndexNode = (function(_super) {
   __extends(_super, ZSetIndexNode);
   function ZSetIndexNode(){
}
   return ZSetIndexNode;
})(ZNode);

var ZSetNameNode = (function(_super) {
   __extends(_super, ZSetNameNode);
   function ZSetNameNode(){
      this.VarName = null;
      this.VarIndex = 0;
      this.IsCaptured = false;
}
   return ZSetNameNode;
})(ZNode);

var ZSetterNode = (function(_super) {
   __extends(_super, ZSetterNode);
   function ZSetterNode(){
      this.FieldName = null;
      this.NameToken = null;
}
   return ZSetterNode;
})(ZNode);

var ZSugarNode = (function(_super) {
   __extends(_super, ZSugarNode);
   function ZSugarNode(){
      this.SugarNode = null;
}
   return ZSugarNode;
})(ZNode);

var ZThrowNode = (function(_super) {
   __extends(_super, ZThrowNode);
   function ZThrowNode(){
}
   return ZThrowNode;
})(ZNode);

var ZTryNode = (function(_super) {
   __extends(_super, ZTryNode);
   function ZTryNode(){
}
   return ZTryNode;
})(ZNode);

var ZUnaryNode = (function(_super) {
   __extends(_super, ZUnaryNode);
   function ZUnaryNode(){
}
   return ZUnaryNode;
})(ZNode);

var ZWhileNode = (function(_super) {
   __extends(_super, ZWhileNode);
   function ZWhileNode(){
}
   return ZWhileNode;
})(ZNode);

var ZEmptyValue = (function() {
   function ZEmptyValue(){
}
   return ZEmptyValue;
})();

var ZLogger = (function() {
   function ZLogger(){
      this.ReportedErrorList = [];
}
   return ZLogger;
})();

var ZMacroFunc = (function(_super) {
   __extends(_super, ZMacroFunc);
   function ZMacroFunc(){
}
   return ZMacroFunc;
})(ZFunc);

var ZNameSpace = (function() {
   function ZNameSpace(){
      this.ParentNameSpace = null;
      this.Generator = null;
      this.SerialId = 0;
      this.TokenMatrix = null;
      this.SyntaxTable = null;
      this.SymbolTable = null;
}
   return ZNameSpace;
})();

var ZParserConst = (function() {
   function ZParserConst(){
}
   return ZParserConst;
})();

var ZSource = (function() {
   function ZSource(){
      this.TokenContext = null;
      this.Logger = null;
      this.FileName = null;
      this.LineNumber = 0;
      this.SourceText = null;
}
   return ZSource;
})();

var ZSourceBuilder = (function() {
   function ZSourceBuilder(){
      this.Template = null;
      this.SourceList = [];
      this.Parent = null;
      this.IndentLevel = 0;
      this.CurrentIndentString = "";
      this.BufferedLineComment = "";
}
   return ZSourceBuilder;
})();

var ZSourceContext = (function(_super) {
   __extends(_super, ZSourceContext);
   function ZSourceContext(){
      this.SourcePosition = 0;
}
   return ZSourceContext;
})(ZSource);

var ZSourceMacro = (function(_super) {
   __extends(_super, ZSourceMacro);
   function ZSourceMacro(){
      this.Macro = null;
}
   return ZSourceMacro;
})(ZMacroFunc);

var ZSymbolEntry = (function() {
   function ZSymbolEntry(){
      this.Parent = null;
      this.Node = null;
      this.IsDisabled = false;
}
   return ZSymbolEntry;
})();

var ZSyntax = (function() {
   function ZSyntax(){
      this.PackageNameSpace = null;
      this.PatternName = null;
      this.MatchFunc = null;
      this.SyntaxFlag = 0;
      this.ParentPattern = null;
      this.IsDisabled = false;
      this.IsStatement = false;
}
   return ZSyntax;
})();

var ZToken = (function() {
   function ZToken(){
      this.Source = null;
      this.StartIndex = 0;
      this.EndIndex = 0;
}
   return ZToken;
})();

var ZTokenContext = (function() {
   function ZTokenContext(){
      this.Generator = null;
      this.NameSpace = null;
      this.Source = null;
      this.TokenList = [];
      this.CurrentPosition = 0;
      this.IsAllowSkipIndent = false;
      this.LatestToken = null;
      this.ApplyingPattern = null;
}
   return ZTokenContext;
})();

var ZTokenFunc = (function() {
   function ZTokenFunc(){
      this.Func = null;
      this.ParentFunc = null;
}
   return ZTokenFunc;
})();

var ZVariable = (function(_super) {
   __extends(_super, ZVariable);
   function ZVariable(){
      this.VarFlag = 0;
      this.VarType = null;
      this.VarName = null;
      this.VarUniqueIndex = 0;
      this.SourceToken = null;
      this.DefCount = 0;
      this.UsedCount = 0;
}
   return ZVariable;
})(ZSymbolEntry);

var ZVisitor = (function() {
   function ZVisitor(){
      this.VisitNullNode = null;
      this.VisitBooleanNode = null;
      this.VisitIntNode = null;
      this.VisitFloatNode = null;
      this.VisitStringNode = null;
      this.VisitArrayLiteralNode = null;
      this.VisitMapLiteralNode = null;
      this.VisitNewObjectNode = null;
      this.VisitGlobalNameNode = null;
      this.VisitGetNameNode = null;
      this.VisitSetNameNode = null;
      this.VisitGroupNode = null;
      this.VisitGetterNode = null;
      this.VisitSetterNode = null;
      this.VisitGetIndexNode = null;
      this.VisitSetIndexNode = null;
      this.VisitMethodCallNode = null;
      this.VisitFuncCallNode = null;
      this.VisitMacroNode = null;
      this.VisitUnaryNode = null;
      this.VisitNotNode = null;
      this.VisitCastNode = null;
      this.VisitInstanceOfNode = null;
      this.VisitBinaryNode = null;
      this.VisitComparatorNode = null;
      this.VisitAndNode = null;
      this.VisitOrNode = null;
      this.VisitBlockNode = null;
      this.VisitVarNode = null;
      this.VisitIfNode = null;
      this.VisitReturnNode = null;
      this.VisitWhileNode = null;
      this.VisitBreakNode = null;
      this.VisitThrowNode = null;
      this.VisitTryNode = null;
      this.VisitLetNode = null;
      this.VisitFunctionNode = null;
      this.VisitClassNode = null;
      this.VisitErrorNode = null;
      this.VisitExtendedNode = null;
      this.VisitSugarNode = null;
      this.EnableVisitor = null;
      this.StopVisitor = null;
      this.IsVisitable = null;
}
   return ZVisitor;
})();

var ZClassType = (function(_super) {
   __extends(_super, ZClassType);
   function ZClassType(){
      this.FieldList = null;
}
   return ZClassType;
})(ZType);

var ZFuncType = (function(_super) {
   __extends(_super, ZFuncType);
   function ZFuncType(){
      this.TypeParams = null;
      this.HasUnknownType = false;
      this.HasGreekType = false;
}
   return ZFuncType;
})(ZType);

var ZGeneric1Type = (function(_super) {
   __extends(_super, ZGeneric1Type);
   function ZGeneric1Type(){
      this.BaseType = null;
      this.ParamType = null;
}
   return ZGeneric1Type;
})(ZType);

var ZGreekType = (function(_super) {
   __extends(_super, ZGreekType);
   function ZGreekType(){
      this.GreekId = 0;
}
   return ZGreekType;
})(ZType);

var ZAnnotationNode = (function(_super) {
   __extends(_super, ZAnnotationNode);
   function ZAnnotationNode(){
      this.AnnotatedNode = null;
}
   return ZAnnotationNode;
})(ZNode);

var ZAssertNode = (function(_super) {
   __extends(_super, ZAssertNode);
   function ZAssertNode(){
}
   return ZAssertNode;
})(ZNode);

var ZBinaryNode = (function(_super) {
   __extends(_super, ZBinaryNode);
   function ZBinaryNode(){
      this.Pattern = null;
}
   return ZBinaryNode;
})(ZNode);

var ZBreakNode = (function(_super) {
   __extends(_super, ZBreakNode);
   function ZBreakNode(){
}
   return ZBreakNode;
})(ZNode);

var ZCastNode = (function(_super) {
   __extends(_super, ZCastNode);
   function ZCastNode(){
}
   return ZCastNode;
})(ZNode);

var ZCatchNode = (function(_super) {
   __extends(_super, ZCatchNode);
   function ZCatchNode(){
      this.ExceptionType = ZTypeVarType;
      this.ExceptionName = null;
      this.NameToken = null;
}
   return ZCatchNode;
})(ZNode);

var ZComparatorNode = (function(_super) {
   __extends(_super, ZComparatorNode);
   function ZComparatorNode(){
}
   return ZComparatorNode;
})(ZBinaryNode);

var ZConstNode = (function(_super) {
   __extends(_super, ZConstNode);
   function ZConstNode(){
}
   return ZConstNode;
})(ZNode);

var ZEmptyNode = (function(_super) {
   __extends(_super, ZEmptyNode);
   function ZEmptyNode(){
}
   return ZEmptyNode;
})(ZNode);

var ZErrorNode = (function(_super) {
   __extends(_super, ZErrorNode);
   function ZErrorNode(){
      this.ErrorMessage = null;
}
   return ZErrorNode;
})(ZConstNode);

var ZFieldNode = (function(_super) {
   __extends(_super, ZFieldNode);
   function ZFieldNode(){
      this.ClassType = null;
      this.DeclType = ZTypeVarType;
      this.FieldName = null;
      this.NameToken = null;
}
   return ZFieldNode;
})(ZNode);

var ZFloatNode = (function(_super) {
   __extends(_super, ZFloatNode);
   function ZFloatNode(){
      this.FloatValue = 0.0;
}
   return ZFloatNode;
})(ZConstNode);

var ZGetIndexNode = (function(_super) {
   __extends(_super, ZGetIndexNode);
   function ZGetIndexNode(){
}
   return ZGetIndexNode;
})(ZNode);

var ZGetNameNode = (function(_super) {
   __extends(_super, ZGetNameNode);
   function ZGetNameNode(){
      this.IsCaptured = false;
      this.VarName = null;
      this.VarIndex = 0;
}
   return ZGetNameNode;
})(ZNode);

var ZGetterNode = (function(_super) {
   __extends(_super, ZGetterNode);
   function ZGetterNode(){
      this.FieldName = null;
      this.NameToken = null;
}
   return ZGetterNode;
})(ZNode);

var ZGlobalNameNode = (function(_super) {
   __extends(_super, ZGlobalNameNode);
   function ZGlobalNameNode(){
      this.GlobalName = null;
      this.IsStaticFuncName = false;
}
   return ZGlobalNameNode;
})(ZNode);

var ZGroupNode = (function(_super) {
   __extends(_super, ZGroupNode);
   function ZGroupNode(){
}
   return ZGroupNode;
})(ZNode);

var ZIfNode = (function(_super) {
   __extends(_super, ZIfNode);
   function ZIfNode(){
}
   return ZIfNode;
})(ZNode);

var ZImportNode = (function(_super) {
   __extends(_super, ZImportNode);
   function ZImportNode(){
      this.ResourcePath = null;
      this.Alias = null;
      this.ResourceToken = null;
      this.Import = null;
}
   return ZImportNode;
})(ZNode);

var ZInstanceOfNode = (function(_super) {
   __extends(_super, ZInstanceOfNode);
   function ZInstanceOfNode(){
      this.TargetType = null;
}
   return ZInstanceOfNode;
})(ZNode);

var ZIntNode = (function(_super) {
   __extends(_super, ZIntNode);
   function ZIntNode(){
      this.IntValue = 0;
}
   return ZIntNode;
})(ZConstNode);

var ZLetNode = (function(_super) {
   __extends(_super, ZLetNode);
   function ZLetNode(){
      this.Symbol = null;
      this.SymbolToken = null;
      this.SymbolType = ZTypeVarType;
      this.GlobalName = null;
}
   return ZLetNode;
})(ZNode);

var ZListNode = (function(_super) {
   __extends(_super, ZListNode);
   function ZListNode(){
      this.ListStartIndex = 0;
}
   return ZListNode;
})(ZNode);

var ZMacroNode = (function(_super) {
   __extends(_super, ZMacroNode);
   function ZMacroNode(){
      this.MacroFunc = null;
}
   return ZMacroNode;
})(ZListNode);

var ZMapEntryNode = (function(_super) {
   __extends(_super, ZMapEntryNode);
   function ZMapEntryNode(){
      this.Name = null;
}
   return ZMapEntryNode;
})(ZNode);

var ZMapLiteralNode = (function(_super) {
   __extends(_super, ZMapLiteralNode);
   function ZMapLiteralNode(){
}
   return ZMapLiteralNode;
})(ZListNode);

var ZMethodCallNode = (function(_super) {
   __extends(_super, ZMethodCallNode);
   function ZMethodCallNode(){
      this.MethodName = null;
      this.MethodToken = null;
}
   return ZMethodCallNode;
})(ZListNode);

var ZNewArrayNode = (function(_super) {
   __extends(_super, ZNewArrayNode);
   function ZNewArrayNode(){
}
   return ZNewArrayNode;
})(ZListNode);

var ZNewObjectNode = (function(_super) {
   __extends(_super, ZNewObjectNode);
   function ZNewObjectNode(){
}
   return ZNewObjectNode;
})(ZListNode);

var ZNotNode = (function(_super) {
   __extends(_super, ZNotNode);
   function ZNotNode(){
}
   return ZNotNode;
})(ZUnaryNode);

var ZNullNode = (function(_super) {
   __extends(_super, ZNullNode);
   function ZNullNode(){
}
   return ZNullNode;
})(ZConstNode);

var ZOrNode = (function(_super) {
   __extends(_super, ZOrNode);
   function ZOrNode(){
}
   return ZOrNode;
})(ZBinaryNode);

var ZPrototypeNode = (function(_super) {
   __extends(_super, ZPrototypeNode);
   function ZPrototypeNode(){
      this.ReturnType = ZTypeVarType;
      this.FuncName = null;
      this.NameToken = null;
}
   return ZPrototypeNode;
})(ZListNode);

var ZStringNode = (function(_super) {
   __extends(_super, ZStringNode);
   function ZStringNode(){
      this.StringValue = null;
}
   return ZStringNode;
})(ZConstNode);

var ZStupidCastErrorNode = (function(_super) {
   __extends(_super, ZStupidCastErrorNode);
   function ZStupidCastErrorNode(){
      this.ErrorNode = null;
}
   return ZStupidCastErrorNode;
})(ZErrorNode);

var ZTypeNode = (function(_super) {
   __extends(_super, ZTypeNode);
   function ZTypeNode(){
}
   return ZTypeNode;
})(ZConstNode);

var ZGenerator = (function(_super) {
   __extends(_super, ZGenerator);
   function ZGenerator(){
      this.GrammarInfo = null;
      this.LanguageExtention = null;
      this.TargetVersion = null;
      this.RootNameSpace = null;
      this.UniqueNumber = 0;
      this.OutputFile = null;
      this.Logger = null;
      this.DefinedFuncMap = ;
      this.StoppedVisitor = false;
      this.GetEngine = null;
      this.ImportLocalGrammar = null;
      this.WriteTo = null;
      this.NameOutputFile = null;
      this.StartCodeGeneration = null;
      this.GetFieldType = null;
      this.GetSetterType = null;
      this.GetConstructorFuncType = null;
      this.GetMethodFuncType = null;
}
   return ZGenerator;
})(ZVisitor);

var ZIndentToken = (function(_super) {
   __extends(_super, ZIndentToken);
   function ZIndentToken(){
}
   return ZIndentToken;
})(ZToken);

var ZPatternToken = (function(_super) {
   __extends(_super, ZPatternToken);
   function ZPatternToken(){
      this.PresetPattern = null;
}
   return ZPatternToken;
})(ZToken);

var ZSourceEngine = (function(_super) {
   __extends(_super, ZSourceEngine);
   function ZSourceEngine(){
      this.TypeChecker = null;
      this.Generator = null;
      this.Logger = null;
      this.InteractiveContext = false;
      this.IsVisitable = true;
}
   return ZSourceEngine;
})(ZVisitor);

var ZSourceGenerator = (function(_super) {
   __extends(_super, ZSourceGenerator);
   function ZSourceGenerator(){
      this.NativeTypeMap = ;
      this.ReservedNameMap = ;
      this.BuilderList = [];
      this.HeaderBuilder = null;
      this.CurrentBuilder = null;
      this.Tab = null;
      this.LineFeed = null;
      this.LineComment = null;
      this.BeginComment = null;
      this.EndComment = null;
      this.SemiColon = null;
      this.Camma = null;
      this.TrueLiteral = null;
      this.FalseLiteral = null;
      this.NullLiteral = null;
      this.NotOperator = null;
      this.AndOperator = null;
      this.OrOperator = null;
      this.TopType = null;
      this.InitBuilderList = null;
      this.GenerateCode = null;
}
   return ZSourceGenerator;
})(ZGenerator);

var ZTypeChecker = (function(_super) {
   __extends(_super, ZTypeChecker);
   function ZTypeChecker(){
      this.StackedContextType = null;
      this.ReturnedNode = null;
      this.Generator = null;
      this.Logger = null;
      this.StoppedVisitor = false;
      this.VarScope = null;
      this.DefineFunction = null;
}
   return ZTypeChecker;
})(ZVisitor);

var ZArrayType = (function(_super) {
   __extends(_super, ZArrayType);
   function ZArrayType(){
}
   return ZArrayType;
})(ZGeneric1Type);

var ZAndNode = (function(_super) {
   __extends(_super, ZAndNode);
   function ZAndNode(){
}
   return ZAndNode;
})(ZBinaryNode);

var ZArrayLiteralNode = (function(_super) {
   __extends(_super, ZArrayLiteralNode);
   function ZArrayLiteralNode(){
}
   return ZArrayLiteralNode;
})(ZListNode);

var ZBlockNode = (function(_super) {
   __extends(_super, ZBlockNode);
   function ZBlockNode(){
      this.NameSpace = null;
}
   return ZBlockNode;
})(ZListNode);

var ZBooleanNode = (function(_super) {
   __extends(_super, ZBooleanNode);
   function ZBooleanNode(){
      this.BooleanValue = false;
}
   return ZBooleanNode;
})(ZConstNode);

var ZClassNode = (function(_super) {
   __extends(_super, ZClassNode);
   function ZClassNode(){
      this.ClassName = null;
      this.ClassType = null;
      this.SuperType = null;
      this.NameToken = null;
      this.SuperToken = null;
}
   return ZClassNode;
})(ZListNode);

var ZFuncCallNode = (function(_super) {
   __extends(_super, ZFuncCallNode);
   function ZFuncCallNode(){
}
   return ZFuncCallNode;
})(ZListNode);

var ZFunctionNode = (function(_super) {
   __extends(_super, ZFunctionNode);
   function ZFunctionNode(){
      this.ReturnType = ZTypeVarType;
      this.FuncName = null;
      this.NameToken = null;
      this.ParentFunctionNode = null;
      this.ResolvedFuncType = null;
      this.VarIndex = 0;
}
   return ZFunctionNode;
})(ZListNode);

var ZVarNode = (function(_super) {
   __extends(_super, ZVarNode);
   function ZVarNode(){
      this.DeclType = ZTypeVarType;
      this.NativeName = null;
      this.TypeToken = null;
      this.NameToken = null;
}
   return ZVarNode;
})(ZBlockNode);

var ZFunc_NativeNameConnector_Z0 = "__";
var ZFunc_CoercionFunc_Z1 = (1 << 17) | ZFunc_ConverterFunc;
var ZFunc_ConverterFunc_Z2 = 1 << 16;
function ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize__1, RecvType__2) {
   return ((FuncName + "__") + (FuncParamSize__1).toString()) + GetUniqueName__1qwz(RecvType__2);
}

var ZTypeUniqueTypeFlag_Z3 = 1 << 16;
var ZTypeUnboxTypeFlag_Z4 = 1 << 10;
var ZTypeOpenTypeFlag_Z5 = 1 << 9;
var ZTypeVarType_Z6 = ZType__4qwz(new ZType(), 1 << 16, "var", null);
var ZTypeVoidType_Z7 = ZType__4qwz(new ZType(), 1 << 16, "void", null);
var ZTypeBooleanType_Z8 = ZType__4qwz(new ZType(), 1 << 16, "boolean", ZType__4qwz(new ZType(), 1 << 16, "var", null));
var ZTypeIntType_Z9 = ZType__4qwz(new ZType(), 1 << 16, "int", ZType__4qwz(new ZType(), 1 << 16, "var", null));
var ZTypeFloatType_Z10 = ZType__4qwz(new ZType(), 1 << 16, "float", ZType__4qwz(new ZType(), 1 << 16, "var", null));
var ZTypeStringType_Z11 = ZType__4qwz(new ZType(), 1 << 16, "String", ZType__4qwz(new ZType(), 1 << 16, "var", null));
var ZTypeTypeType_Z12 = ZType__4qwz(new ZType(), 1 << 16, "Type", ZType__4qwz(new ZType(), 1 << 16, "var", null));
var ZTypeArrayType_Z13 = ZGeneric1Type__5qi7(new ZGeneric1Type(), 1 << 16, "Array", null, ZType__4qwz(new ZType(), 1 << 16, "var", null));
var ZTypeMapType_Z14 = ZGeneric1Type__5qi7(new ZGeneric1Type(), 1 << 16, "Map", null, ZType__4qwz(new ZType(), 1 << 16, "var", null));
var ZTypeFuncType_Z15 = ZFuncType__3qw5(new ZFuncType(), "Func", null);
var ZTypePool_TypeList_Z16 = [];
var null = ZGreekType_NewGreekTypes(null);
function ZTypePool_NewTypeId__1qwz(T) {
   var TypeId = ([]).length;
   [].add(T);
   return TypeId__1;
}

function TypeOf__1qqr(TypeId) {
   if (TypeId == 0) {
      return ZType__4qwz(new ZType(), 1 << 16, "var", null);
   };
   if (TypeId < ([]).length) {
      return [][TypeId];
   };
   return ZType__4qwz(new ZType(), 1 << 16, "var", null);
}

function GetGreekType__1qqr(GreekId) {
   if (ZTypePool_GreekTypes[GreekId] == null) {
      ZTypePool_GreekTypes[GreekId] = ZGreekType__2qor(new ZGreekType(), GreekId);
   };
   return ZTypePool_GreekTypes[GreekId];
}

var ZTypePool_ClassNameMap_Z17 = ;
var ZTypePool_UniqueTypeSetMap_Z18 = ;
function ZTypePool_MangleType2__2qwz(Type1, Type2__1) {
   return ((":" + (Type1.TypeId).toString()) + ":") + (Type2__1.TypeId).toString();
}

function ZTypePool_MangleTypes__1qwx(TypeList) {
   var s = "";
   var i = 0;
   while (i__2 < (TypeList).length) {
      var Type = TypeList[i__2];
      s__1 = (s__1 + ":") + (Type__3.TypeId).toString();
      i__2 = i__2 + 1;
   };
   return s__1;
}

function ZTypePool_UniqueTypes__1qwx(TypeList) {
   var MangleName = "[]" + ZTypePool_MangleTypes__1qwx(TypeList);
   var Types = [MangleName__1];
   if (Types__2 == null) {
      Types__6 = TypeList.CompactArray();
      [MangleName__1] = Types__2;
   };
   return Types__2;
}

function ZTypePool_GetGenericType1__2qwz(BaseType, ParamType__1) {
   var MangleName = ZTypePool_MangleType2__2qwz(BaseType, ParamType__1);
   var GenericType = [MangleName__2];
   if (GenericType__3 == null) {
      var Name = ((BaseType.ShortName + "<") + ParamType__1) + ">";
      if (IsArrayType__1qwz(BaseType)) {
         Name__4 = ((BaseType.ShortName + "<") + ParamType__1) + ">";
      };
      GenericType__3 = ZGeneric1Type__5qi7(new ZGeneric1Type(), 1 << 16, Name__4, BaseType, ParamType__1);
      [MangleName__2] = GenericType__3;
   };
   return GenericType__3;
}

function ZTypePool_GetGenericType__3qwz(BaseType, TypeList__1, IsCreation__2) {
   console.assert(BaseType.GetParamSize(BaseType) > 0, "(sample/libzen.zen:1228)");
   if ((TypeList__1).length == 1 && !IsFuncType__1qwz(BaseType)) {
      return ZTypePool_GetGenericType1__2qwz(BaseType, TypeList__1[0]);
   };
   var MangleName = (":" + (BaseType.TypeId).toString()) + ZTypePool_MangleTypes__1qwx(TypeList__1);
   var GenericType = [MangleName__3];
   if ((GenericType__4 == null) && IsCreation__2) {
      var ShortName = BaseType.ShortName + "<";
      var i = 0;
      while (i__6 < LibZen_Size__1qqq(TypeList__1)) {
         ShortName__9 = ShortName__5 + TypeList__1[i__6].GetRealType(TypeList__1[i__6]).ShortName;
         if ((i__6 + 1) == LibZen_Size__1qqq(TypeList__1)) {
            ShortName__5 = ShortName__5 + ">";
         } else {
            ShortName__5 = ShortName__5 + ",";
         };
         i__6 = i__6 + 1;
      };
      if (IsFuncType__1qwz(BaseType)) {
         GenericType__4 = ZFuncType__3qw5(new ZFuncType(), ShortName__5, ZTypePool_UniqueTypes__1qwx(TypeList__1));
      } else {
      };
      [MangleName__3] = GenericType__4;
   };
   return GenericType__4;
}

function ZTypePool_LookupFuncType__1qwx(TypeList) {
   var FuncType = ZTypePool_GetGenericType__3qwz(ZFuncType__3qw5(new ZFuncType(), "Func", null), TypeList, true);
   if (FuncType__1 instanceof ZFuncType) {
      return FuncType__1;
   };
   return null;
}

function ZTypePool_LookupFuncType__1qwz(R) {
   var TypeList = [];
   TypeList__1.add(R);
   return ZTypePool_LookupFuncType__1qwx(TypeList__1);
}

function ZTypePool_LookupFuncType__2qwz(R, P1__1) {
   var TypeList = [];
   TypeList__2.add(R);
   TypeList__2.add(P1__1);
   return ZTypePool_LookupFuncType__1qwx(TypeList__2);
}

function ZTypePool_LookupFuncType__3qwz(R, P1__1, P2__2) {
   var TypeList = [];
   TypeList__3.add(R);
   TypeList__3.add(P1__1);
   TypeList__3.add(P2__2);
   return ZTypePool_LookupFuncType__1qwx(TypeList__3);
}

var ZNode_Nop_Z19 = -1;
var ZNode_NameInfo_Z20 = -2;
var ZNode_TypeInfo_Z21 = -3;
var ZNode_AppendIndex_Z22 = -4;
var ZNode_NestedAppendIndex_Z23 = -5;
var ZReturnNode_Expr_Z24 = 0;
var ZSetIndexNode_Recv_Z25 = 0;
var ZSetIndexNode_Index_Z26 = 1;
var ZSetIndexNode_Expr_Z27 = 2;
var ZSetNameNode_Expr_Z28 = 0;
var ZSetterNode_Recv_Z29 = 0;
var ZSetterNode_Expr_Z30 = 1;
var ZSugarNode_DeSugar_Z31 = 0;
var ZThrowNode_Expr_Z32 = 0;
var ZTryNode_Try_Z33 = 0;
var ZTryNode_Catch_Z34 = 1;
var ZTryNode_Finally_Z35 = 2;
var ZUnaryNode_Recv_Z36 = 0;
var ZWhileNode_Cond_Z37 = 0;
var ZWhileNode_Block_Z38 = 1;
var ZEmptyValue_TrueEmpty_Z39 = new ZEmptyValue();
var ZEmptyValue_FalseEmpty_Z40 = new ZEmptyValue();
function ZLogger_LogError__2qwn(Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qy6(Token.Source, "error", Token.StartIndex, Message__1);
      Report__2qeb(Token.Source.Logger, Message__1);
   };
   return Message__1;
}

function ZLogger_LogWarning__2qwn(Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qy6(Token.Source, "warning", Token.StartIndex, Message__1);
      Report__2qeb(Token.Source.Logger, Message__1);
   };
   return;
}

function ZLogger_LogInfo__2qwn(Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qy6(Token.Source, "info", Token.StartIndex, Message__1);
      Report__2qeb(Token.Source.Logger, Message__1);
   };
   return;
}

function ZLogger_LogDebug__2qwn(Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qy6(Token.Source, "debug", Token.StartIndex, Message__1);
      Report__2qeb(Token.Source.Logger, Message__1);
   };
   return;
}

function ZNameSpace_RightPatternSymbol__1qqy(PatternName) {
   return "\t" + PatternName;
}

var ProgName_Z41 = "LibZen";
var CodeName_Z42 = "Reference Implementation of D-Script";
var MajorVersion_Z43 = 0;
var MinerVersion_Z44 = 1;
var PatchLevel_Z45 = 0;
var Version_Z46 = "0.1";
var Copyright_Z47 = "Copyright (c) 2013-2014, Konoha project authors";
var License_Z48 = "BSD-Style Open Source";
var ZSyntax_LeftJoin_Z49 = 1 << 1;
var ZSyntax_BinaryOperator_Z50 = 1;
function MergeSyntaxPattern__2qyy(Pattern, Parent__1) {
   if (Parent__1 == null) {
      return Pattern;
   };
   var MergedPattern = ZSyntax__4qyy(new ZSyntax(), Pattern.PackageNameSpace, Pattern.PatternName, Pattern.MatchFunc);
   MergedPattern__2.ParentPattern = Parent__1;
   return MergedPattern__2;
}

var ZToken_NullToken_Z51 = ZToken__4qwn(new ZToken(), null, 0, 0);
var ZTokenContext_Required_Z52 = true;
var ZTokenContext_Optional_Z53 = false;
var ZTokenContext_AllowSkipIndent_Z54 = true;
var ZTokenContext_NotAllowSkipIndent_Z55 = false;
var ZTokenContext_AllowNewLine_Z56 = true;
var ZTokenContext_MoveNext_Z57 = true;
function ZGreekType_NewGreekTypes__1qwx(GreekTypes) {
   if (GreekTypes == null) {
      return LibZen_NewTypeArray(LibZen_Size__1qqq(LibZen_GreekNames));
   } else {
      var i = 0;
      while (i__1 < LibZen_Size__1qqq(GreekTypes)) {
         GreekTypes[i__1] = null;
         i__1 = i__1 + 1;
      };
      return GreekTypes;
   };
}

var ZAssertNode_Expr_Z58 = 0;
var ZBinaryNode_Left_Z59 = 0;
var ZBinaryNode_Right_Z60 = 1;
var ZCastNode_Expr_Z61 = 0;
var ZCatchNode_Block_Z62 = 0;
var ZFieldNode_InitValue_Z63 = 0;
var ZGetIndexNode_Recv_Z64 = 0;
var ZGetIndexNode_Index_Z65 = 1;
var ZGetterNode_Recv_Z66 = 0;
var ZGroupNode_Expr_Z67 = 0;
var ZIfNode_Cond_Z68 = 0;
var ZIfNode_Then_Z69 = 1;
var ZIfNode_Else_Z70 = 2;
var ZInstanceOfNode_Left_Z71 = 0;
var ZLetNode_InitValue_Z72 = 0;
var ZMapEntryNode_Key_Z73 = 0;
var ZMapEntryNode_Value_Z74 = 1;
var ZMethodCallNode_Recv_Z75 = 0;
var ZTypeChecker_DefaultTypeCheckPolicy_Z76 = 0;
var ZTypeChecker_NoCheckPolicy_Z77 = 1;
var ZFuncCallNode_Func_Z78 = 0;
var ZFunctionNode_Block_Z79 = 0;
var ZVarNode_InitValue_Z80 = 0;
function ExpressionPattern_GetRightPattern__2qwo(NameSpace, TokenContext__1) {
   var Token = GetToken__1qwf(TokenContext__1);
   if (Token__2 != ZToken__4qwn(new ZToken(), null, 0, 0)) {
      var Pattern = GetRightSyntaxPattern__2qwo(NameSpace, GetText__1qwn(Token__2));
      return Pattern__3;
   };
   return null;
}

function ExpressionPattern_DispatchPattern__5qwd(ParentNode, TokenContext__1, LeftNode__2, AllowStatement__3, AllowBinary__4) {
   var Token = GetToken__1qwf(TokenContext__1);
   var Pattern = null;
   var NameSpace = GetNameSpace__1qwd(ParentNode);
   if (Token__5 instanceof ZPatternToken) {
      Pattern__6 = (Token__5).PresetPattern;
   } else {
      Pattern__6 = GetSyntaxPattern__2qwo(NameSpace__7, GetText__1qwn(Token__5));
   };
   if (Pattern__6 != null) {
      if (Pattern__6.IsStatement && !AllowStatement__3) {
         return ZErrorNode__4qpu(new ZErrorNode(), ParentNode, Token__5, GetText__1qwn(Token__5) + " statement is not here");
      };
      LeftNode__2 = ApplyMatchPattern__5qwf(TokenContext__1, ParentNode, LeftNode__2, Pattern__6, true);
   } else {
      if (IsNameSymbol__1qwn(Token__5)) {
         if (AllowStatement__3) {
            Pattern__6 = GetSyntaxPattern__2qwo(NameSpace__7, "$SymbolStatement$");
         } else {
            Pattern__6 = GetSyntaxPattern__2qwo(NameSpace__7, "$SymbolExpression$");
         };
         LeftNode__2 = ApplyMatchPattern__5qwf(TokenContext__1, ParentNode, LeftNode__2, Pattern__6, true);
      } else {
         if (AllowStatement__3) {
            return CreateExpectedErrorNode__3qwf(TokenContext__1, Token__5, "statement");
         } else {
            return CreateExpectedErrorNode__3qwf(TokenContext__1, Token__5, "expression");
         };
      };
   };
   if (!Pattern__6.IsStatement) {
      while (LeftNode__2 != null && !IsErrorNode__1qwd(LeftNode__2)) {
         var RightPattern = ExpressionPattern_GetRightPattern__2qwo(NameSpace__7, TokenContext__1);
         if (RightPattern__8 == null) {
            break;
         };
         if (!AllowBinary__4 && IsBinaryOperator__1qyy(RightPattern__8)) {
            break;
         };
         LeftNode__2 = ApplyMatchPattern__5qwf(TokenContext__1, ParentNode, LeftNode__2, RightPattern__8, true);
      };
   };
   return LeftNode__2;
}

function NumberLiteralToken_ParseDigit__1qw4(SourceContext) {
   var ch = 0;
   while (HasChar__1qw4(SourceContext)) {
      ch__1 = GetCurrentChar__1qw4(SourceContext);
      if (!LibZen_IsDigit__1qqy(ch__1)) {
         break;
      };
      MoveNext__1qw4(SourceContext);
   };
   return ch__1;
}

function ZClassField__5qwv(self, ClassType__1, FieldName__2, FieldType__3, SourceToken__4) {
   self.ClassType = ClassType__1;
   self.FieldType = FieldType__3;
   self.FieldName = FieldName__2;
   self.SourceToken = SourceToken__4;
   return null;
}

function ZFunc__4qw7(self, FuncFlag__1, FuncName__2, FuncType__3) {
   self.FuncFlag = FuncFlag__1;
   self.FuncName = FuncName__2;
   self.FuncType = FuncType__3;
   return null;
}

function GetFuncType__1qw7(self) {
   return self.FuncType;
}

function toString__1qw7(self) {
   return (self.FuncName + ": ") + self.FuncType;
}

function IsConverterFunc__1qw7(self) {
   return LibZen_IsFlag__2qqr(self.FuncFlag, 1 << 16);
}

function IsCoercionFunc__1qw7(self) {
   return LibZen_IsFlag__2qqr(self.FuncFlag, (1 << 17) | ZFunc_ConverterFunc);
}

function Is__2qw7(self, Flag__1) {
   return LibZen_IsFlag__2qqr(self.FuncFlag, Flag__1);
}

function GetSignature__1qw7(self) {
   return StringfySignature__2qw5(self.FuncType, self.FuncName);
}

function ZPrototype__5qer(self, FuncFlag__1, FuncName__2, FuncType__3, SourceToken__4) {
   ZFunc__4qw7(self, FuncFlag__1, FuncName__2, FuncType__3);
   self.DefinedCount = 0;
   self.UsedCount = 0;
   return null;
}

function Used__1qer(self) {
   self.UsedCount = self.UsedCount + 1;
   return;
}

function Defined__1qer(self) {
   self.DefinedCount = self.DefinedCount + 1;
   return;
}

function ZType__4qwz(self, TypeFlag__1, ShortName__2, RefType__3) {
   self.TypeFlag = TypeFlag__1;
   self.ShortName = ShortName__2;
   self.RefType = RefType__3;
   if (LibZen_IsFlag__2qqr(TypeFlag__1, 1 << 16)) {
      self.TypeId = ZTypePool_NewTypeId__1qwz(self);
   };
   return null;
}

function GetRealType__1qwz(self) {
   return self;
}

function GetSuperType__1qwz(self) {
   return self.RefType;
}

function GetBaseType__1qwz(self) {
   return self;
}

function GetParamSize__1qwz(self) {
   return 0;
}

function GetParamType__2qwz(self, Index__1) {
   return ZType__4qwz(new ZType(), 1 << 16, "var", null);
}

function Equals__2qwz(self, Type__1) {
   return (self.GetRealType(self) == Type__1.GetRealType(Type__1));
}

function Accept__2qwz(self, Type__1) {
   var ThisType = self.GetRealType(self);
   if (ThisType__2 == Type__1.GetRealType(Type__1)) {
      return true;
   };
   var SuperClass = Type__1.GetSuperType(Type__1);
   while (SuperClass__3 != null) {
      if (SuperClass__3 == ThisType__2) {
         return true;
      };
      SuperClass__3 = SuperClass__3.GetSuperType(SuperClass__3);
   };
   return false;
}

function IsGreekType__1qwz(self) {
   return false;
}

function GetGreekRealType__2qwz(self, Greek__1) {
   return self.GetRealType(self);
}

function AcceptValueType__4qwz(self, ValueType__1, ExactMatch__2, Greek__3) {
   if (self.GetRealType(self) != ValueType__1 && !ValueType__1.IsVarType(ValueType__1)) {
      if (ExactMatch__2 && !Accept__2qwz(self, ValueType__1)) {
         return false;
      };
   };
   return true;
}

function IsVoidType__1qwz(self) {
   return (self.GetRealType(self) == ZType__4qwz(new ZType(), 1 << 16, "void", null));
}

function IsVarType__1qwz(self) {
   return (self.GetRealType(self) == ZType__4qwz(new ZType(), 1 << 16, "var", null));
}

function IsInferrableType__1qwz(self) {
   return (!self.IsVarType(self) && !IsVoidType__1qwz(self));
}

function IsTypeType__1qwz(self) {
   return (self.GetRealType(self) == ZType__4qwz(new ZType(), 1 << 16, "Type", ZType__4qwz(new ZType(), 1 << 16, "var", null)));
}

function IsBooleanType__1qwz(self) {
   return (self.GetRealType(self) == ZType__4qwz(new ZType(), 1 << 16, "boolean", ZType__4qwz(new ZType(), 1 << 16, "var", null)));
}

function IsIntType__1qwz(self) {
   return (self.GetRealType(self) == ZType__4qwz(new ZType(), 1 << 16, "int", ZType__4qwz(new ZType(), 1 << 16, "var", null)));
}

function IsFloatType__1qwz(self) {
   return (self.GetRealType(self) == ZType__4qwz(new ZType(), 1 << 16, "float", ZType__4qwz(new ZType(), 1 << 16, "var", null)));
}

function IsNumberType__1qwz(self) {
   return (IsIntType__1qwz(self) || IsFloatType__1qwz(self));
}

function IsStringType__1qwz(self) {
   return (self.GetRealType(self) == ZType__4qwz(new ZType(), 1 << 16, "String", ZType__4qwz(new ZType(), 1 << 16, "var", null)));
}

function IsArrayType__1qwz(self) {
   return (self.GetBaseType(self) == ZGeneric1Type__5qi7(new ZGeneric1Type(), 1 << 16, "Array", null, ZType__4qwz(new ZType(), 1 << 16, "var", null)));
}

function IsMapType__1qwz(self) {
   return (self.GetBaseType(self) == ZGeneric1Type__5qi7(new ZGeneric1Type(), 1 << 16, "Map", null, ZType__4qwz(new ZType(), 1 << 16, "var", null)));
}

function IsOpenType__1qwz(self) {
   return LibZen_IsFlag__2qqr(self.TypeFlag, 1 << 9);
}

function IsImmutableType__1qwz(self) {
   return false;
}

function IsNullableType__1qwz(self) {
   return true;
}

function toString__1qwz(self) {
   return self.ShortName;
}

function GetAsciiName__1qwz(self) {
   return self.ShortName;
}

function StringfyClassMember__2qwz(self, Name__1) {
   return (Name__1 + " of ") + self.ShortName;
}

function GetUniqueName__1qwz(self) {
   return LibZen_Stringfy__1qqr(self.TypeId);
}

function IsFuncType__1qwz(self) {
   return (self.GetRealType(self) instanceof ZFuncType);
}

function StringfySignature__2qwz(self, FuncName__1) {
   return FuncName__1;
}

function Maybe__3qwz(self, T__1, SourceToken__2) {
   return;
}

function ZVarScope__4qev(self, Parent__1, Logger__2, VarList__3) {
   self.Parent = Parent__1;
   self.Logger = Logger__2;
   self.VarList = VarList__3;
   if (self.VarList == null) {
      self.VarList = [];
   };
   return null;
}

function NewVarType__4qev(self, VarType__1, Name__2, SourceToken__3) {
   if (!(VarType__1 instanceof ZVarType) && VarType__1.IsVarType(VarType__1)) {
      VarType__1 = ZVarType__4qen(new ZVarType(), self.VarList, Name__2, SourceToken__3);
   };
   return VarType__1;
}

function FoundUnresolvedSymbol__2qev(self, FuncName__1) {
   System.out.println("unresolved name: " + FuncName__1);
   self.UnresolvedSymbolCount = self.UnresolvedSymbolCount + 1;
   return;
}

function CheckVarNode__3qev(self, ContextType__1, Node__2) {
   if (IsUntyped__1qwd(Node__2)) {
      self.VarNodeCount = self.VarNodeCount + 1;
   };
   if (IsInferrableType__1qwz(ContextType__1) && Node__2.Type instanceof ZVarType) {
      Infer__3qen((Node__2.Type), ContextType__1, Node__2.SourceToken);
      Node__2.Type = ContextType__1;
   };
   if (ContextType__1 instanceof ZVarType && !IsUntyped__1qwd(Node__2)) {
      Infer__3qen((ContextType__1), Node__2.Type, Node__2.SourceToken);
   };
   return;
}

function TypeCheckStmtList__3qev(self, TypeSafer__1, StmtList__2) {
   var PrevCount = -1;
   while (true) {
      var i = 0;
      self.VarNodeCount = 0;
      self.UnresolvedSymbolCount = 0;
      while (i__4 < (StmtList__2).length) {
         StmtList__2[i__4] = CheckType__3qe8(TypeSafer__1, StmtList__2[i__4], ZType__4qwz(new ZType(), 1 << 16, "void", null));
         i__4 = i__4 + 1;
      };
      if (self.VarNodeCount == 0 || PrevCount__3 == self.VarNodeCount) {
         break;
      };
      PrevCount__3 = self.VarNodeCount;
   };
   if (self.VarNodeCount == 0) {
      return true;
   };
   return false;
}

function TypeCheckFuncBlock__3qev(self, TypeSafer__1, FunctionNode__2) {
   var PrevCount = -1;
   while (true) {
      self.VarNodeCount = 0;
      self.UnresolvedSymbolCount = 0;
      TypeSafer__1.DefineFunction(TypeSafer__1, FunctionNode__2, false);
      FunctionNode__2.AST[0] = CheckType__3qe8(TypeSafer__1, FunctionNode__2.AST[0], ZType__4qwz(new ZType(), 1 << 16, "void", null));
      if (self.VarNodeCount == 0 || PrevCount__3 == self.VarNodeCount) {
         break;
      };
      PrevCount__3 = self.VarNodeCount;
   };
   if (self.UnresolvedSymbolCount == 0) {
      TypeSafer__1.DefineFunction(TypeSafer__1, FunctionNode__2, true);
   } else {
      TypeSafer__1.DefineFunction(TypeSafer__1, FunctionNode__2, false);
      if (self.Parent != null) {
         self.Parent.UnresolvedSymbolCount = self.UnresolvedSymbolCount + self.Parent.UnresolvedSymbolCount;
      };
   };
   return;
}

function ZVarType__4qen(self, VarList__1, Name__2, SourceToken__3) {
   ZType__4qwz(self, 0, Name__2, ZType__4qwz(new ZType(), 1 << 16, "var", null));
   self.VarList = VarList__1;
   self.SourceToken = SourceToken__3;
   self.GreekId = (VarList__1).length;
   VarList__1.add(self);
   self.TypeId = self.RefType.TypeId;
   return null;
}

function GetRealType__1qen(self) {
   return self.RefType;
}

function GetParamSize__1qen(self) {
   return self.RefType.GetParamSize(self.RefType);
}

function GetParamType__2qen(self, Index__1) {
   return self.RefType.GetParamType(self.RefType, Index__1);
}

function IsFuncType__1qen(self) {
   return IsFuncType__1qwz(self.RefType);
}

function IsVarType__1qen(self) {
   return self.RefType.IsVarType(self.RefType);
}

function Infer__3qen(self, ContextType__1, SourceToken__2) {
   if (self.RefType.IsVarType(self.RefType)) {
      if (ContextType__1 instanceof ZVarType && ContextType__1.IsVarType(ContextType__1)) {
         var VarType = ContextType__1;
         if (self.GreekId < VarType__3.GreekId) {
            VarType__3.GreekId = self.GreekId;
         } else {
            self.GreekId = VarType__3.GreekId;
         };
      } else {
         self.RefType = ContextType__1.GetRealType(ContextType__1);
         self.SourceToken = SourceToken__2;
         self.TypeId = self.RefType.TypeId;
         self.TypeFlag = self.RefType.TypeFlag;
      };
   };
   return;
}

function Maybe__3qen(self, T__1, SourceToken__2) {
   if (self.RefType.IsVarType(self.RefType)) {
      if (T__1 instanceof ZVarType && T__1.IsVarType(T__1)) {
         var VarType = T__1;
         if (self.GreekId < VarType__3.GreekId) {
            VarType__3.GreekId = self.GreekId;
         } else {
            self.GreekId = VarType__3.GreekId;
         };
      } else {
         self.RefType = T__1.GetRealType(T__1);
         self.SourceToken = SourceToken__2;
         self.TypeId = T__1.TypeId;
         self.TypeFlag = T__1.TypeFlag;
      };
   };
   return;
}

function ZNode__4qwd(self, ParentNode__1, SourceToken__2, Size__3) {
   console.assert(self != ParentNode__1, "(sample/libzen.zen:1807)");
   self.ParentNode = ParentNode__1;
   self.SourceToken = SourceToken__2;
   if (Size__3 > 0) {
      self.AST = LibZen_NewNodeArray(Size__3);
   } else {
      self.AST = null;
   };
   return null;
}

function SetChild__2qwd(self, Node__1) {
   console.assert(Node__1 != null, "(sample/libzen.zen:1819)");
   if (Node__1 != null) {
      console.assert(self != Node__1, "(sample/libzen.zen:1821)");
      Node__1.ParentNode = self;
   };
   return Node__1;
}

function SetNameInfo__3qwd(self, NameToken__1, Name__2) {
   console.assert(Name__2 == null, "(sample/libzen.zen:1828)");
   return;
}

function SetTypeInfo__3qwd(self, TypeToken__1, Type__2) {
   self.Type = Type__2;
   return;
}

function Set__3qwd(self, Index__1, Node__2) {
   if (Index__1 >= 0) {
      self.AST[Index__1] = SetChild__2qwd(self, Node__2);
   } else if (Index__1 == -4) {
      var ListNode = self;
      if (ListNode__3 instanceof ZListNode) {
         Append__2quq((ListNode__3), Node__2);
      } else {
         console.assert(ListNode__3 instanceof ZListNode, "(sample/libzen.zen:1845)");
      };
   } else if (Index__1 == -2) {
      self.SetNameInfo(self, Node__2.SourceToken, GetText__1qwn(Node__2.SourceToken));
      self.SourceToken = Node__2.SourceToken;
      return;
   } else if (Index__1 == -3) {
      self.SetTypeInfo(self, Node__2.SourceToken, Node__2.Type);
      return;
   };
   return;
}

function GetAstSize__1qwd(self) {
   if (self.AST == null) {
      return 0;
   };
   return self.AST.length;
}

function HasAst__2qwd(self, Index__1) {
   if (self.AST != null && Index__1 < self.AST.length) {
      return self.AST[Index__1] != null;
   };
   return false;
}

function GetAstType__2qwd(self, Index__1) {
   return self.AST[Index__1].Type.GetRealType(self.AST[Index__1].Type);
}

function GetSourceLocation__1qwd(self) {
   if (self.SourceToken != null) {
      return ((("(" + GetFileName__1qwn(self.SourceToken)) + ":") + (GetLineNumber__1qwn(self.SourceToken)).toString()) + ")";
   };
   return null;
}

function toString__1qwd(self) {
   var Self = "#" + LibZen_GetClassName(self);
   if (!self.Type.IsVarType(self.Type)) {
      Self__1 = (Self__1 + ":") + self.Type;
   } else {
      Self__1 = Self__1 + ":?";
   };
   if (self.AST != null) {
      var i = 0;
      Self__1 = Self__1 + "[";
      while (i__2 < self.AST.length) {
         if (i__2 > 0) {
            Self__1 = Self__1 + ",";
         };
         if (self.AST[i__2] == null) {
            Self__1 = Self__1 + "null";
         } else {
            Self__1 = Self__1 + toString__1qwd(self.AST[i__2]);
         };
         i__2 = i__2 + 1;
      };
      Self__1 = Self__1 + "]";
   };
   return Self__1;
}

function GetScopeBlockNode__1qwd(self) {
   var Node = self;
   while (Node__1 != null) {
      if (Node__1 instanceof ZBlockNode) {
         return Node__1;
      };
      if (Node__1 == Node__1.ParentNode) {
         throw new var("serious error: parent node is same: " + Node__1);
      };
      Node__1 = Node__1.ParentNode;
   };
   return null;
}

function GetNameSpace__1qwd(self) {
   var BlockNode = GetScopeBlockNode__1qwd(self);
   return BlockNode__1.NameSpace;
}

function IsErrorNode__1qwd(self) {
   return (self instanceof ZErrorNode);
}

function IsBreakingBlock__1qwd(self) {
   return false;
}

function DeSugar__2qwd(self, Generator__1) {
   return ZSugarNode__3qr6(new ZSugarNode(), self, ZErrorNode__3qpu(new ZErrorNode(), self.ParentNode, "undefined code generation: " + self));
}

function Accept__2qwd(self, Visitor__1) {
   Visitor__1.VisitExtendedNode(Visitor__1, self);
   return;
}

function IsUntyped__1qwd(self) {
   return self.Type.IsVarType(self.Type);
}

function HasUntypedNode__1qwd(self) {
   if (self.HasUntypedNode) {
      if (!IsUntyped__1qwd(self)) {
         var i = 0;
         while (i__1 < GetAstSize__1qwd(self)) {
            if (self.AST[i__1] != null && HasUntypedNode__1qwd(self.AST[i__1])) {
               return true;
            };
            i__1 = i__1 + 1;
         };
         self.HasUntypedNode = false;
         return false;
      };
   };
   return self.HasUntypedNode;
}

function VisitTypeChecker__3qwd(self, TypeChecker__1, ContextType__2) {
   return VisitTypeChecker__3qe8(TypeChecker__1, self, ContextType__2);
}

function ToReturnNode__1qwd(self) {
   return null;
}

function ZParamNode__2qrm(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 0);
   return null;
}

function SetNameInfo__3qrm(self, NameToken__1, Name__2) {
   self.Name = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function ZReturnNode__2qrb(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   return null;
}

function Accept__2qrb(self, Visitor__1) {
   Visitor__1.VisitReturnNode(Visitor__1, self);
   return;
}

function ToReturnNode__1qrb(self) {
   return self;
}

function ZSetIndexNode__3qtq(self, ParentNode__1, LeftNode__2) {
   ZNode__4qwd(self, ParentNode__1, null, 3);
   Set__3qwd(self, 0, LeftNode__2);
   return null;
}

function Accept__2qtq(self, Visitor__1) {
   Visitor__1.VisitSetIndexNode(Visitor__1, self);
   return;
}

function ZSetNameNode__4qtr(self, ParentNode__1, Token__2, VarName__3) {
   ZNode__4qwd(self, ParentNode__1, Token__2, 1);
   self.VarName = VarName__3;
   return null;
}

function Accept__2qtr(self, Visitor__1) {
   Visitor__1.VisitSetNameNode(Visitor__1, self);
   return;
}

function ZSetterNode__3qtu(self, ParentNode__1, RecvNode__2) {
   ZNode__4qwd(self, ParentNode__1, null, 2);
   Set__3qwd(self, 0, RecvNode__2);
   return null;
}

function SetNameInfo__3qtu(self, NameToken__1, Name__2) {
   self.FieldName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function Accept__2qtu(self, Visitor__1) {
   Visitor__1.VisitSetterNode(Visitor__1, self);
   return;
}

function IsStaticField__1qtu(self) {
   return self.AST[0] instanceof ZTypeNode;
}

function ZSugarNode__3qr6(self, SugarNode__1, DeSugarNode__2) {
   ZNode__4qwd(self, SugarNode__1.ParentNode, null, 1);
   self.SugarNode = SugarNode__1;
   SugarNode__1.ParentNode = self;
   Set__3qwd(self, 0, DeSugarNode__2);
   DeSugarNode__2.ParentNode = self;
   return null;
}

function Accept__2qr6(self, Visitor__1) {
   Visitor__1.VisitSugarNode(Visitor__1, self);
   return;
}

function ZThrowNode__2qts(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   return null;
}

function Accept__2qts(self, Visitor__1) {
   Visitor__1.VisitThrowNode(Visitor__1, self);
   return;
}

function ZTryNode__2qtg(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 3);
   return null;
}

function Accept__2qtg(self, Visitor__1) {
   Visitor__1.VisitTryNode(Visitor__1, self);
   return;
}

function ZUnaryNode__3qtk(self, ParentNode__1, Token__2) {
   ZNode__4qwd(self, ParentNode__1, Token__2, 1);
   return null;
}

function Accept__2qtk(self, Visitor__1) {
   Visitor__1.VisitUnaryNode(Visitor__1, self);
   return;
}

function ZWhileNode__2qt1(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 2);
   return null;
}

function Accept__2qt1(self, Visitor__1) {
   Visitor__1.VisitWhileNode(Visitor__1, self);
   return;
}

function toString__1qtx(self) {
   return "";
}

function Report__2qeb(self, Message__1) {
   self.ReportedErrorList.add(Message__1);
   return;
}

function GetReportedErrors__1qeb(self) {
   var List = self.ReportedErrorList;
   self.ReportedErrorList = [];
   return List__1.CompactArray();
}

function ShowErrors__1qeb(self) {
   var Messages = GetReportedErrors__1qeb(self);
   var i = 0;
   while (i__2 < Messages__1.length) {
      LibZen_PrintLine(Messages__1[i__2]);
      i__2 = i__2 + 1;
   };
   return;
}

function ZMacroFunc__3qt3(self, FuncName__1, FuncType__2) {
   ZFunc__4qw7(self, 0, FuncName__1, FuncType__2);
   return null;
}

function ZNameSpace__3qwo(self, Generator__1, ParentNameSpace__2) {
   self.ParentNameSpace = ParentNameSpace__2;
   if (ParentNameSpace__2 == null) {
      self.Generator = Generator__1;
   } else {
      self.Generator = ParentNameSpace__2.Generator;
   };
   self.SerialId = 0;
   return null;
}

function toString__1qwo(self) {
   return ("NS[" + (self.SerialId).toString()) + "]";
}

function CreateSubNameSpace__1qwo(self) {
   return ZNameSpace__3qwo(new ZNameSpace(), null, self);
}

function GetRootNameSpace__1qwo(self) {
   return self.Generator.RootNameSpace;
}

function GetTokenFunc__2qwo(self, ZenChar__1) {
   if (self.TokenMatrix == null) {
      return GetTokenFunc__2qwo(self.ParentNameSpace, ZenChar__1);
   };
   return self.TokenMatrix[ZenChar__1];
}

function JoinParentFunc__3qwo(self, Func__1, Parent__2) {
   if (Parent__2 != null && Parent__2.Func == Func__1) {
      return Parent__2;
   };
   return ZTokenFunc__3qqn(new ZTokenFunc(), Func__1, Parent__2);
}

function AppendTokenFunc__3qwo(self, keys__1, TokenFunc__2) {
   if (self.TokenMatrix == null) {
      self.TokenMatrix = LibZen_NewTokenMatrix__0qqw();
      if (self.ParentNameSpace != null) {
         var i = 0;
         while (i__3 < self.TokenMatrix.length) {
            self.TokenMatrix[i__3] = GetTokenFunc__2qwo(self.ParentNameSpace, i__3);
            i__3 = i__3 + 1;
         };
      };
   };
   var i = 0;
   while (i__4 < keys__1.length()) {
      var kchar = LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(keys__1, i__4));
      self.TokenMatrix[kchar__5] = JoinParentFunc__3qwo(self, TokenFunc__2, self.TokenMatrix[kchar__5]);
      i__4 = i__4 + 1;
   };
   return;
}

function GetSyntaxPattern__2qwo(self, PatternName__1) {
   var NameSpace = self;
   while (NameSpace__2 != null) {
      if (NameSpace__2.SyntaxTable != null) {
         return NameSpace__2.SyntaxTable[PatternName__1];
      };
      NameSpace__2 = NameSpace__2.ParentNameSpace;
   };
   return null;
}

function SetSyntaxPattern__3qwo(self, PatternName__1, Syntax__2) {
   if (self.SyntaxTable == null) {
      self.SyntaxTable = ;
   };
   self.SyntaxTable[PatternName__1] = Syntax__2;
   return;
}

function GetRightSyntaxPattern__2qwo(self, PatternName__1) {
   return GetSyntaxPattern__2qwo(self, ZNameSpace_RightPatternSymbol__1qqy(PatternName__1));
}

function AppendSyntaxPattern__3qwo(self, PatternName__1, NewPattern__2) {
   LibZen_Assert__1qqe(NewPattern__2.ParentPattern == null);
   var ParentPattern = GetSyntaxPattern__2qwo(self, PatternName__1);
   NewPattern__2.ParentPattern = ParentPattern__3;
   SetSyntaxPattern__3qwo(self, PatternName__1, NewPattern__2);
   return;
}

function DefineStatement__3qwo(self, PatternName__1, MatchFunc__2) {
   var Alias = PatternName__1.indexOf(" ");
   var Name = PatternName__1;
   if (Alias__3 != -1) {
      Name__10 = PatternName__1.substring(0, Alias);
   };
   var Pattern = ZSyntax__4qyy(new ZSyntax(), self, Name__4, MatchFunc__2);
   Pattern__5.IsStatement = true;
   AppendSyntaxPattern__3qwo(self, Name__4, Pattern__5);
   if (Alias__3 != -1) {
      DefineStatement__3qwo(self, PatternName__1.substring(Alias + 1), MatchFunc__2);
   };
   return;
}

function DefineExpression__3qwo(self, PatternName__1, MatchFunc__2) {
   var Alias = PatternName__1.indexOf(" ");
   var Name = PatternName__1;
   if (Alias__3 != -1) {
      Name__10 = PatternName__1.substring(0, Alias);
   };
   var Pattern = ZSyntax__4qyy(new ZSyntax(), self, Name__4, MatchFunc__2);
   AppendSyntaxPattern__3qwo(self, Name__4, Pattern__5);
   if (Alias__3 != -1) {
      DefineExpression__3qwo(self, PatternName__1.substring(Alias + 1), MatchFunc__2);
   };
   return;
}

function DefineRightExpression__4qwo(self, PatternName__1, SyntaxFlag__2, MatchFunc__3) {
   var Alias = PatternName__1.indexOf(" ");
   var Name = PatternName__1;
   if (Alias__4 != -1) {
      Name__8 = PatternName__1.substring(0, Alias);
   };
   var Pattern = ZSyntax__4qyy(new ZSyntax(), self, Name__5, MatchFunc__3);
   Pattern__6.SyntaxFlag = SyntaxFlag__2;
   AppendSyntaxPattern__3qwo(self, ZNameSpace_RightPatternSymbol__1qqy(Name__5), Pattern__6);
   if (Alias__4 != -1) {
      DefineRightExpression__4qwo(self, PatternName__1.substring(Alias + 1), SyntaxFlag__2, MatchFunc__3);
   };
   return;
}

function GetSymbol__2qwo(self, Symbol__1) {
   var NameSpace = self;
   while (NameSpace__2 != null) {
      if (NameSpace__2.SymbolTable != null) {
         var Entry = NameSpace__2.SymbolTable[Symbol__1];
         if (Entry__3 != null) {
            if (Entry__3.IsDisabled) {
               return null;
            };
            return Entry__3;
         };
      };
      NameSpace__2 = NameSpace__2.ParentNameSpace;
   };
   return null;
}

function GetSymbolNode__2qwo(self, Symbol__1) {
   var Entry = GetSymbol__2qwo(self, Symbol__1);
   if (Entry__2 != null) {
      return Entry__2.Node;
   };
   return null;
}

function SetLocalSymbolEntry__3qwo(self, Symbol__1, Entry__2) {
   if (self.SymbolTable == null) {
      self.SymbolTable = ;
   };
   self.SymbolTable[Symbol__1] = Entry__2;
   return;
}

function SetLocalSymbol__3qwo(self, Symbol__1, Node__2) {
   var Parent = GetSymbol__2qwo(self, Symbol__1);
   Node__2.ParentNode = null;
   SetLocalSymbolEntry__3qwo(self, Symbol__1, ZSymbolEntry__3qy0(new ZSymbolEntry(), Parent__3, Node__2));
   return Parent__3;
}

function SetGlobalSymbol__3qwo(self, Symbol__1, Node__2) {
   return SetLocalSymbol__3qwo(GetRootNameSpace__1qwo(self), Symbol__1, Node__2);
}

function GetLocalVariable__2qwo(self, VarName__1) {
   var Entry = GetSymbol__2qwo(self, VarName__1);
   if (Entry__2 instanceof ZVariable) {
      return Entry__2;
   };
   return null;
}

function SetLocalVariable__5qwo(self, FunctionNode__1, VarType__2, VarName__3, SourceToken__4) {
   var Parent = GetSymbol__2qwo(self, VarName__3);
   var VarInfo = ZVariable__7qyf(new ZVariable(), Parent__5, FunctionNode__1, 0, VarType__2, VarName__3, SourceToken__4);
   SetLocalSymbolEntry__3qwo(self, VarName__3, VarInfo__6);
   return;
}

function SetTypeName__4qwo(self, Name__1, Type__2, SourceToken__3) {
   var Node = ZTypeNode__4qyl(new ZTypeNode(), null, SourceToken__3, Type__2);
   SetLocalSymbol__3qwo(self, Name__1, Node__4);
   return;
}

function SetTypeName__3qwo(self, Type__1, SourceToken__2) {
   SetTypeName__4qwo(self, Type__1.ShortName, Type__1, SourceToken__2);
   return;
}

function GetTypeNode__3qwo(self, TypeName__1, SourceToken__2) {
   var Node = GetSymbolNode__2qwo(self, TypeName__1);
   if (Node__3 instanceof ZTypeNode) {
      return Node__3;
   };
   if (Node__3 == null && SourceToken__2 != null) {
      var Type = ZClassType__3qwb(new ZClassType(), TypeName__1, ZType__4qwz(new ZType(), 1 << 16, "var", null));
      SetTypeName__4qwo(GetRootNameSpace__1qwo(self), TypeName__1, Type__4, SourceToken__2);
      return GetTypeNode__3qwo(self, TypeName__1, null);
   };
   return null;
}

function GetType__3qwo(self, TypeName__1, SourceToken__2) {
   var TypeNode = GetTypeNode__3qwo(self, TypeName__1, SourceToken__2);
   if (TypeNode__3 != null) {
      return TypeNode__3.Type;
   };
   return null;
}

function ZSource__5qy6(self, FileName__1, LineNumber__2, Source__3, TokenContext__4) {
   self.FileName = FileName__1;
   self.LineNumber = LineNumber__2;
   self.TokenContext = TokenContext__4;
   self.SourceText = Source__3;
   self.Logger = TokenContext__4.Generator.Logger;
   return null;
}

function GetLineNumber__2qy6(self, Position__1) {
   var LineNumber = self.LineNumber;
   var i = 0;
   while (i__3 < Position__1) {
      var ch = LibZen_GetChar__2qqy(self.SourceText, i__3);
      if (ch__4 == "\n") {
         LineNumber__2 = LineNumber__2 + 1;
      };
      i__3 = i__3 + 1;
   };
   return LineNumber__2;
}

function GetLineHeadPosition__2qy6(self, Position__1) {
   var s = self.SourceText;
   var StartIndex = 0;
   var i = Position__1;
   if (!(i__4 < s__2.length())) {
      i__11 = s__2.length() - 1;
   };
   while (i__4 >= 0) {
      var ch = LibZen_GetChar__2qqy(s__2, i__4);
      if (ch__5 == "\n") {
         StartIndex__3 = i__4 + 1;
         break;
      };
      i__4 = i__4 - 1;
   };
   return StartIndex__3;
}

function CountIndentSize__2qy6(self, Position__1) {
   var s = self.SourceText;
   var length = 0;
   var i = Position__1;
   while (i__4 < s__2.length()) {
      var ch = LibZen_GetChar__2qqy(s__2, i__4);
      if (ch__5 == "\t") {
         length__3 = length__3 + 8;
      } else if (ch__5 == " ") {
         length__3 = length__3 + 1;
      } else {
         break;
      };
      i__4 = i__4 + 1;
   };
   return length__3;
}

function GetLineText__2qy6(self, Position__1) {
   var s = self.SourceText;
   var StartIndex = 0;
   var EndIndex = s__2.length();
   var i = Position__1;
   if (!(i__5 < s__2.length())) {
      i__15 = s__2.length() - 1;
   };
   while (i__5 >= 0) {
      var ch = LibZen_GetChar__2qqy(s__2, i__5);
      if (ch__6 == "\n") {
         StartIndex__3 = i__5 + 1;
         break;
      };
      i__5 = i__5 - 1;
   };
   i__5 = Position__1;
   while (i__5 < s__2.length()) {
      var ch = LibZen_GetChar__2qqy(s__2, i__5);
      if (ch__7 == "\n") {
         EndIndex__4 = i__5;
         break;
      };
      i__5 = i__5 + 1;
   };
   return s__2.substring(StartIndex, EndIndex);
}

function GetLineMarker__2qy6(self, Position__1) {
   var s = self.SourceText;
   var StartIndex = 0;
   var i = Position__1;
   if (!(i__4 < s__2.length())) {
      i__13 = s__2.length() - 1;
   };
   while (i__4 >= 0) {
      var ch = LibZen_GetChar__2qqy(s__2, i__4);
      if (ch__5 == "\n") {
         StartIndex__3 = i__4 + 1;
         break;
      };
      i__4 = i__4 - 1;
   };
   var Line = "";
   i__4 = StartIndex__3;
   while (i__4 < Position__1) {
      var ch = LibZen_GetChar__2qqy(s__2, i__4);
      if (ch__7 == "\n") {
         break;
      };
      if (ch__7 == "\t") {
         Line__6 = Line__6 + "\t";
      } else {
         Line__6 = Line__6 + " ";
      };
      i__4 = i__4 + 1;
   };
   return Line__6 + "^";
}

function FormatErrorHeader__4qy6(self, Error__1, Position__2, Message__3) {
   return (((((("(" + self.FileName) + ":") + (GetLineNumber__2qy6(self, Position__2)).toString()) + ") [") + Error__1) + "] ") + Message__3;
}

function FormatErrorMarker__4qy6(self, Error__1, Position__2, Message__3) {
   var Line = GetLineText__2qy6(self, Position__2);
   var Delim = "\n\t";
   if (Line__4.startsWith("\t") || Line__4.startsWith(" ")) {
      Delim__5 = "\n";
   };
   var Header = FormatErrorHeader__4qy6(self, Error__1, Position__2, Message__3);
   var Marker = GetLineMarker__2qy6(self, Position__2);
   Message__3 = (((Header__6 + Delim__5) + Line__4) + Delim__5) + Marker__7;
   return Message__3;
}

function GetCharAt__2qy6(self, n__1) {
   if (0 <= n__1 && n__1 < self.SourceText.length()) {
      return LibZen_GetChar__2qqy(self.SourceText, n__1);
   };
   return "0";
}

function ZSourceBuilder__3qwe(self, Template__1, Parent__2) {
   self.Template = Template__1;
   self.Parent = Parent__2;
   return null;
}

function Pop__1qwe(self) {
   return self.Parent;
}

function Clear__1qwe(self) {
   self.SourceList.clear(0);
   return;
}

function GetPosition__1qwe(self) {
   return (self.SourceList).length;
}

function CopyString__3qwe(self, BeginIndex__1, EndIndex__2) {
   return LibZen_SourceBuilderToString__3qwe(self, BeginIndex__1, EndIndex__2);
}

function Append__2qwe(self, Text__1) {
   self.SourceList.add(Text__1);
   return;
}

function AppendInt__2qwe(self, Value__1) {
   self.SourceList.add("" + (Value__1).toString());
   return;
}

function AppendLineFeed__1qwe(self) {
   if (self.BufferedLineComment.length() > 0) {
      self.SourceList.add(self.BufferedLineComment);
      self.BufferedLineComment = "";
   };
   self.SourceList.add(self.Template.LineFeed);
   return;
}

function AppendLineFeed__2qwe(self, AppendIndent__1) {
   if (self.BufferedLineComment.length() > 0) {
      self.SourceList.add(self.BufferedLineComment);
      self.BufferedLineComment = "";
   };
   self.SourceList.add(self.Template.LineFeed);
   if (AppendIndent__1) {
      AppendIndent__1qwe(self);
   };
   return;
}

function AppendWhiteSpace__1qwe(self) {
   var Size = (self.SourceList).length;
   if (Size__1 > 0) {
      var Last = self.SourceList[Size__1 - 1];
      if (Last__2 != null && (Last__2.endsWith(" ") || Last__2.endsWith("\n") || Last__2.endsWith("\t"))) {
         return;
      };
   };
   self.SourceList.add(" ");
   return;
}

function AppendToken__2qwe(self, Text__1) {
   AppendWhiteSpace__1qwe(self);
   self.SourceList.add(Text__1);
   AppendWhiteSpace__1qwe(self);
   return;
}

function AppendBlockComment__2qwe(self, Text__1) {
   if (self.Template.BeginComment != null) {
      self.SourceList.add(self.Template.BeginComment);
      self.SourceList.add(Text__1);
      self.SourceList.add(self.Template.EndComment);
   } else if (self.Template.LineComment != null) {
      self.BufferedLineComment = (self.BufferedLineComment + self.Template.LineComment) + Text__1;
   };
   return;
}

function AppendCommentLine__2qwe(self, Text__1) {
   if (self.Template.LineComment == null) {
      self.SourceList.add(self.Template.BeginComment);
      self.SourceList.add(Text__1);
      self.SourceList.add(self.Template.EndComment);
   } else {
      self.SourceList.add(self.Template.LineComment);
      self.SourceList.add(Text__1);
   };
   self.SourceList.add(self.Template.LineFeed);
   return;
}

function Indent__1qwe(self) {
   self.IndentLevel = self.IndentLevel + 1;
   self.CurrentIndentString = null;
   return;
}

function UnIndent__1qwe(self) {
   self.IndentLevel = self.IndentLevel - 1;
   self.CurrentIndentString = null;
   LibZen_Assert__1qqe(self.IndentLevel >= 0);
   return;
}

function GetIndentString__1qwe(self) {
   if (self.CurrentIndentString == null) {
      self.CurrentIndentString = LibZen_JoinStrings__2qqy(self.Template.Tab, self.IndentLevel);
   };
   return self.CurrentIndentString;
}

function AppendIndent__1qwe(self) {
   self.SourceList.add(GetIndentString__1qwe(self));
   return;
}

function AppendLineFeedIndent__1qwe(self) {
   self.SourceList.add(self.Template.LineFeed);
   self.SourceList.add(GetIndentString__1qwe(self));
   return;
}

function IndentAndAppend__2qwe(self, Text__1) {
   self.SourceList.add(GetIndentString__1qwe(self));
   self.SourceList.add(Text__1);
   return;
}

function AppendParamList__4qwe(self, ParamList__1, BeginIdx__2, EndIdx__3) {
   var i = BeginIdx__2;
   while (i__4 < EndIdx__3) {
      if (i__4 > BeginIdx__2) {
         Append__2qwe(self, self.Template.Camma);
      };
      GetListAt__2quq(ParamList__1, i__4).Accept(GetListAt__2quq(ParamList__1, i__4), self.Template);
      i__4 = i__4 + 1;
   };
   return;
}

function toString__1qwe(self) {
   return LibZen_SourceBuilderToString__1qwe(self);
}

function AppendLine__2qwe(self, Text__1) {
   Append__2qwe(self, Text__1);
   AppendLineFeed__1qwe(self);
   return;
}

function ZSourceContext__5qw4(self, FileName__1, LineNumber__2, Source__3, TokenContext__4) {
   ZSource__5qy6(self, FileName__1, LineNumber__2, Source__3, TokenContext__4);
   return null;
}

function GetCharCode__1qw4(self) {
   return LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(self.SourceText, self.SourcePosition));
}

function GetPosition__1qw4(self) {
   return self.SourcePosition;
}

function HasChar__1qw4(self) {
   return (self.SourceText.length() - self.SourcePosition) > 0;
}

function GetCurrentChar__1qw4(self) {
   return LibZen_GetChar__2qqy(self.SourceText, self.SourcePosition);
}

function GetCharAtFromCurrentPosition__2qw4(self, n__1) {
   if ((self.SourcePosition + n__1) < self.SourceText.length()) {
      return LibZen_GetChar__2qqy(self.SourceText, self.SourcePosition + n__1);
   };
   return "0";
}

function MoveNext__1qw4(self) {
   self.SourcePosition = self.SourcePosition + 1;
   return;
}

function SkipWhiteSpace__1qw4(self) {
   while (HasChar__1qw4(self)) {
      var ch = GetCurrentChar__1qw4(self);
      if (ch__1 != " " && ch__1 != "\t") {
         break;
      };
      MoveNext__1qw4(self);
   };
   return;
}

function FoundIndent__3qw4(self, StartIndex__1, EndIndex__2) {
   var Token = ZIndentToken__4qa1(new ZIndentToken(), self, StartIndex__1, EndIndex__2);
   self.SourcePosition = EndIndex__2;
   self.TokenContext.TokenList.add(Token__3);
   return;
}

function Tokenize__3qw4(self, StartIndex__1, EndIndex__2) {
   self.SourcePosition = EndIndex__2;
   if (StartIndex__1 < EndIndex__2 && EndIndex__2 <= self.SourceText.length()) {
      var Token = ZToken__4qwn(new ZToken(), self, StartIndex__1, EndIndex__2);
      self.TokenContext.TokenList.add(Token__3);
   };
   return;
}

function Tokenize__4qw4(self, PatternName__1, StartIndex__2, EndIndex__3) {
   self.SourcePosition = EndIndex__3;
   if (StartIndex__2 <= EndIndex__3 && EndIndex__3 <= self.SourceText.length()) {
      var Pattern = GetSyntaxPattern__2qwo(self.TokenContext.NameSpace, PatternName__1);
      if (Pattern__4 == null) {
         var Token = ZToken__4qwn(new ZToken(), self, StartIndex__2, EndIndex__3);
         ZLogger_LogInfo__2qwn(Token__5, "unregistered token pattern: " + PatternName__1);
         self.TokenContext.TokenList.add(Token__5);
      } else {
         var Token = ZPatternToken__5qaz(new ZPatternToken(), self, StartIndex__2, EndIndex__3, Pattern__4);
         self.TokenContext.TokenList.add(Token__6);
      };
   };
   return;
}

function IsDefinedSyntax__3qw4(self, StartIndex__1, EndIndex__2) {
   if (EndIndex__2 < self.SourceText.length()) {
      var NameSpace = self.TokenContext.NameSpace;
      var Token = self.SourceText.substring(StartIndex, EndIndex);
      var Pattern = GetRightSyntaxPattern__2qwo(NameSpace__3, Token__4);
      if (Pattern__5 != null) {
         return true;
      };
   };
   return false;
}

function TokenizeDefinedSymbol__2qw4(self, StartIndex__1) {
   var EndIndex = StartIndex__1 + 2;
   while (IsDefinedSyntax__3qw4(self, StartIndex__1, EndIndex__2)) {
      EndIndex__2 = EndIndex__2 + 1;
   };
   Tokenize__3qw4(self, StartIndex__1, EndIndex__2 - 1);
   return;
}

function ApplyTokenFunc__2qw4(self, TokenFunc__1) {
   var RollbackPosition = self.SourcePosition;
   while (TokenFunc__1 != null) {
      self.SourcePosition = RollbackPosition__2;
      if (LibZen.ApplyTokenFunc(TokenFunc__1.Func, self)) {
         return;
      };
      TokenFunc__1 = TokenFunc__1.ParentFunc;
   };
   TokenizeDefinedSymbol__2qw4(self, RollbackPosition__2);
   return;
}

function DoTokenize__1qw4(self) {
   var TokenSize = (self.TokenContext.TokenList).length;
   var CheckPosition = self.SourcePosition;
   while (HasChar__1qw4(self)) {
      var CharCode = GetCharCode__1qw4(self);
      var TokenFunc = GetTokenFunc__2qwo(self.TokenContext.NameSpace, CharCode__3);
      ApplyTokenFunc__2qw4(self, TokenFunc__4);
      if ((self.TokenContext.TokenList).length > TokenSize__1) {
         break;
      };
      if (self.SourcePosition == CheckPosition__2) {
         LibZen_PrintLine("Buggy TokenFunc: " + TokenFunc__4);
         MoveNext__1qw4(self);
      };
   };
   if ((self.TokenContext.TokenList).length > TokenSize__1) {
      return true;
   };
   return false;
}

function LogWarning__3qw4(self, Position__1, Message__2) {
   Report__2qeb(self.Logger, FormatErrorMarker__4qy6(self, "warning", Position__1, Message__2));
   return;
}

function ZSourceMacro__4qud(self, FuncName__1, FuncType__2, Macro__3) {
   ZMacroFunc__3qt3(self, FuncName__1, FuncType__2);
   self.Macro = Macro__3;
   return null;
}

function ZSymbolEntry__3qy0(self, Parent__1, Node__2) {
   self.Parent = Parent__1;
   self.Node = Node__2;
   return null;
}

function ZSyntax__4qyy(self, NameSpace__1, PatternName__2, MatchFunc__3) {
   self.PackageNameSpace = NameSpace__1;
   self.PatternName = PatternName__2;
   self.MatchFunc = MatchFunc__3;
   return null;
}

function toString__1qyy(self) {
   return ((self.PatternName + "{") + self.MatchFunc) + "}";
}

function IsBinaryOperator__1qyy(self) {
   return LibZen_IsFlag__2qqr(self.SyntaxFlag, 1);
}

function IsRightJoin__2qyy(self, Right__1) {
   var left = self.SyntaxFlag;
   var right = Right__1.SyntaxFlag;
   return (left__2 < right__3 || (left__2 == right__3 && !LibZen_IsFlag__2qqr(left__2, 1 << 1) && !LibZen_IsFlag__2qqr(right__3, 1 << 1)));
}

function EqualsName__2qyy(self, Name__1) {
   return LibZen_EqualsString__2qqy(self.PatternName, Name__1);
}

function ZToken__4qwn(self, Source__1, StartIndex__2, EndIndex__3) {
   self.Source = Source__1;
   self.StartIndex = StartIndex__2;
   self.EndIndex = EndIndex__3;
   return null;
}

function GetFileName__1qwn(self) {
   return self.Source.FileName;
}

function GetLineNumber__1qwn(self) {
   return GetLineNumber__2qy6(self.Source, self.StartIndex);
}

function GetChar__1qwn(self) {
   if (self.Source != null) {
      return LibZen_GetChar__2qqy(self.Source.SourceText, self.StartIndex);
   };
   return "0";
}

function GetText__1qwn(self) {
   if (self.Source != null) {
      return self.Source.SourceText.substring(self.StartIndex, self.EndIndex);
   };
   return "";
}

function toString__1qwn(self) {
   var ch = GetCharAt__2qy6(self.Source, self.StartIndex - 1);
   if (ch__1 == "\"") {
      return ("\"" + GetText__1qwn(self)) + "\"";
   };
   return GetText__1qwn(self);
}

function EqualsText__2qwn(self, Text__1) {
   if (Text__1.length() == (self.EndIndex - self.StartIndex)) {
      var s = self.Source.SourceText;
      var i = 0;
      while (i__3 < Text__1.length()) {
         if (LibZen_GetChar__2qqy(s__2, self.StartIndex + i__3) != LibZen_GetChar__2qqy(Text__1, i__3)) {
            return false;
         };
         i__3 = i__3 + 1;
      };
      return true;
   };
   return false;
}

function StartsWith__2qwn(self, Text__1) {
   if (Text__1.length() <= (self.EndIndex - self.StartIndex)) {
      var s = self.Source.SourceText;
      var i = 0;
      while (i__3 < Text__1.length()) {
         if (LibZen_GetChar__2qqy(s__2, self.StartIndex + i__3) != LibZen_GetChar__2qqy(Text__1, i__3)) {
            return false;
         };
         i__3 = i__3 + 1;
      };
      return true;
   };
   return false;
}

function IsNull__1qwn(self) {
   return (self == ZToken__4qwn(new ZToken(), null, 0, 0));
}

function IsIndent__1qwn(self) {
   return self instanceof ZIndentToken;
}

function IsNextWhiteSpace__1qwn(self) {
   var ch = GetCharAt__2qy6(self.Source, self.EndIndex);
   if (ch__1 == " " || ch__1 == "\t" || ch__1 == "\n") {
      return true;
   };
   return false;
}

function IsNameSymbol__1qwn(self) {
   var ch = GetCharAt__2qy6(self.Source, self.StartIndex);
   return LibZen_IsSymbol__1qqy(ch__1);
}

function GetIndentSize__1qwn(self) {
   if (self.Source != null) {
      return CountIndentSize__2qy6(self.Source, GetLineHeadPosition__2qy6(self.Source, self.StartIndex));
   };
   return 0;
}

function ZTokenContext__6qwf(self, Generator__1, NameSpace__2, FileName__3, LineNumber__4, SourceText__5) {
   self.Generator = Generator__1;
   self.NameSpace = NameSpace__2;
   self.Source = ZSourceContext__5qw4(new ZSourceContext(), FileName__3, LineNumber__4, SourceText__5, self);
   return null;
}

function SetParseFlag__2qwf(self, AllowSkipIndent__1) {
   var OldFlag = self.IsAllowSkipIndent;
   self.IsAllowSkipIndent = AllowSkipIndent__1;
   return OldFlag__2;
}

function GetBeforeToken__1qwf(self) {
   var MovingPos = self.CurrentPosition - 1;
   while (MovingPos__1 >= 0 && MovingPos__1 < (self.TokenList).length) {
      var Token = self.TokenList[MovingPos__1];
      if (!IsIndent__1qwn(Token__2)) {
         return Token__2;
      };
      MovingPos__1 = MovingPos__1 - 1;
   };
   return self.LatestToken;
}

function CreateExpectedErrorNode__3qwf(self, SourceToken__1, ExpectedTokenText__2) {
   if (SourceToken__1 == null || IsNull__1qwn(SourceToken__1)) {
      SourceToken__1 = GetBeforeToken__1qwf(self);
      SourceToken__1 = ZToken__4qwn(new ZToken(), SourceToken__1.Source, SourceToken__1.EndIndex, SourceToken__1.EndIndex);
      return ZErrorNode__4qpu(new ZErrorNode(), null, SourceToken__1, ExpectedTokenText__2 + " is expected");
   };
   return ZErrorNode__4qpu(new ZErrorNode(), null, SourceToken__1, ExpectedTokenText__2 + " is expected");
}

function Vacume__1qwf(self) {
   return;
}

function MoveNext__1qwf(self) {
   self.CurrentPosition = self.CurrentPosition + 1;
   return;
}

function GetToken__2qwf(self, EnforceMoveNext__1) {
   while (true) {
      if (!(self.CurrentPosition < (self.TokenList).length)) {
         if (!DoTokenize__1qw4(self.Source)) {
            break;
         };
      };
      var Token = self.TokenList[self.CurrentPosition];
      if ((self.IsAllowSkipIndent) && IsIndent__1qwn(Token__2)) {
         self.CurrentPosition = self.CurrentPosition + 1;
      } else {
         self.LatestToken = Token__2;
         if (EnforceMoveNext__1) {
            self.CurrentPosition = self.CurrentPosition + 1;
         };
         return Token__2;
      };
   };
   return ZToken__4qwn(new ZToken(), null, 0, 0);
}

function GetToken__1qwf(self) {
   return GetToken__2qwf(self, false);
}

function HasNext__1qwf(self) {
   return (GetToken__1qwf(self) != ZToken__4qwn(new ZToken(), null, 0, 0));
}

function SkipIndent__1qwf(self) {
   var Token = GetToken__1qwf(self);
   while (IsIndent__1qwn(Token__1)) {
      self.CurrentPosition = self.CurrentPosition + 1;
      Token__1 = GetToken__1qwf(self);
   };
   return;
}

function SkipError__2qwf(self, ErrorToken__1) {
   var StartIndex = ErrorToken__1.StartIndex;
   var EndIndex = ErrorToken__1.EndIndex;
   var length = GetIndentSize__1qwn(ErrorToken__1);
   while (HasNext__1qwf(self)) {
      var Token = GetToken__1qwf(self);
      EndIndex__3 = Token__5.EndIndex;
      self.CurrentPosition = self.CurrentPosition + 1;
      if (Token__5 instanceof ZIndentToken) {
         var ilength = GetIndentSize__1qwn(Token__5);
         if (ilength__6 <= length__4) {
            break;
         };
      };
   };
   if (StartIndex__2 < EndIndex__3) {
      LibZen_PrintDebug__1qqy((("StartIdx=" + (StartIndex__2).toString()) + ", EndIndex=") + (EndIndex__3).toString());
      LibZen_PrintDebug__1qqy("skipped: \t" + ErrorToken__1.Source.SourceText.subSequence(StartIndex, EndIndex));
   };
   return;
}

function IsToken__2qwf(self, TokenText__1) {
   var Token = GetToken__1qwf(self);
   if (EqualsText__2qwn(Token__2, TokenText__1)) {
      return true;
   };
   return false;
}

function IsNewLineToken__2qwf(self, TokenText__1) {
   var RollbackPos = self.CurrentPosition;
   SkipIndent__1qwf(self);
   var Token = GetToken__1qwf(self);
   if (EqualsText__2qwn(Token__3, TokenText__1)) {
      return true;
   };
   self.CurrentPosition = RollbackPos__2;
   return false;
}

function MatchToken__2qwf(self, TokenText__1) {
   var RollbackPos = self.CurrentPosition;
   var Token = GetToken__2qwf(self, true);
   if (EqualsText__2qwn(Token__3, TokenText__1)) {
      return true;
   };
   self.CurrentPosition = RollbackPos__2;
   return false;
}

function MatchNewLineToken__2qwf(self, TokenText__1) {
   var RollbackPos = self.CurrentPosition;
   SkipIndent__1qwf(self);
   var Token = GetToken__2qwf(self, true);
   if (EqualsText__2qwn(Token__3, TokenText__1)) {
      return true;
   };
   self.CurrentPosition = RollbackPos__2;
   return false;
}

function ParseLargeToken__1qwf(self) {
   var Token = GetToken__2qwf(self, true);
   if (IsNextWhiteSpace__1qwn(Token__1)) {
      return Token__1;
   };
   var StartIndex = Token__1.StartIndex;
   var EndIndex = Token__1.EndIndex;
   while (HasNext__1qwf(self) && !IsNextWhiteSpace__1qwn(Token__1)) {
      var RollbackPosition = self.CurrentPosition;
      Token__1 = GetToken__2qwf(self, true);
      if (IsIndent__1qwn(Token__1) || EqualsText__2qwn(Token__1, ";") || EqualsText__2qwn(Token__1, ",")) {
         self.CurrentPosition = RollbackPosition__4;
         break;
      };
      EndIndex__3 = Token__1.EndIndex;
   };
   return ZToken__4qwn(new ZToken(), Token__1.Source, StartIndex__2, EndIndex__3);
}

function MatchToken__4qwf(self, ParentNode__1, TokenText__2, IsRequired__3) {
   if (!IsErrorNode__1qwd(ParentNode__1)) {
      var RollbackPosition = self.CurrentPosition;
      var Token = GetToken__2qwf(self, true);
      if (EqualsText__2qwn(Token__5, TokenText__2)) {
         if (ParentNode__1.SourceToken == null) {
            ParentNode__1.SourceToken = Token__5;
         };
      } else {
         if (IsRequired__3) {
            return CreateExpectedErrorNode__3qwf(self, Token__5, TokenText__2);
         } else {
            self.CurrentPosition = RollbackPosition__4;
         };
      };
   };
   return ParentNode__1;
}

function GetApplyingSyntax__1qwf(self) {
   return self.ApplyingPattern;
}

function ApplyMatchPattern__5qwf(self, ParentNode__1, LeftNode__2, Pattern__3, IsRequired__4) {
   var RollbackPosition = self.CurrentPosition;
   var CurrentPattern = Pattern__3;
   var TopToken = GetToken__1qwf(self);
   var ParsedNode = null;
   while (CurrentPattern__6 != null) {
      var Remembered = self.IsAllowSkipIndent;
      self.CurrentPosition = RollbackPosition__5;
      self.ApplyingPattern = CurrentPattern__6;
      ParsedNode__13 = LibZen.ApplyMatchFunc(CurrentPattern__6.MatchFunc, ParentNode__1, self, LeftNode__2);
      console.assert(ParsedNode__8 != ParentNode__1, "(sample/libzen.zen:3046)");
      self.ApplyingPattern = null;
      self.IsAllowSkipIndent = Remembered__9;
      if (ParsedNode__8 != null && !IsErrorNode__1qwd(ParsedNode__8)) {
         return ParsedNode__8;
      };
      CurrentPattern__6 = CurrentPattern__6.ParentPattern;
   };
   if (!IsRequired__4) {
      self.CurrentPosition = RollbackPosition__5;
      return null;
   };
   if (self.CurrentPosition == RollbackPosition__5) {
      System.out.println((((("infinite looping" + (RollbackPosition__5).toString()) + " Token=") + TopToken__7) + " ParsedNode=") + ParsedNode__8);
      console.assert(self.CurrentPosition != RollbackPosition__5, "(sample/libzen.zen:3060)");
   };
   if (ParsedNode__8 == null) {
      ParsedNode__8 = CreateExpectedErrorNode__3qwf(self, TopToken__7, Pattern__3.PatternName);
   };
   return ParsedNode__8;
}

function ParsePatternAfter__5qwf(self, ParentNode__1, LeftNode__2, PatternName__3, IsRequired__4) {
   var Pattern = GetSyntaxPattern__2qwo(self.NameSpace, PatternName__3);
   var ParsedNode = ApplyMatchPattern__5qwf(self, ParentNode__1, LeftNode__2, Pattern__5, IsRequired__4);
   return ParsedNode__6;
}

function ParsePattern__4qwf(self, ParentNode__1, PatternName__2, IsRequired__3) {
   return ParsePatternAfter__5qwf(self, ParentNode__1, null, PatternName__2, IsRequired__3);
}

function MatchPattern__6qwf(self, ParentNode__1, Index__2, PatternName__3, IsRequired__4, AllowSkipIndent__5) {
   if (!IsErrorNode__1qwd(ParentNode__1)) {
      var Rememberd = SetParseFlag__2qwf(self, AllowSkipIndent__5);
      var ParsedNode = ParsePattern__4qwf(self, ParentNode__1, PatternName__3, IsRequired__4);
      SetParseFlag__2qwf(self, Rememberd__6);
      if (ParsedNode__7 != null) {
         if (Index__2 == -5) {
            if (!(ParsedNode__7 instanceof ZEmptyNode)) {
               Set__3qwd(ParentNode__1, -4, ParsedNode__7);
            };
            if (ParsedNode__7 instanceof ZBlockNode || IsErrorNode__1qwd(ParsedNode__7)) {
               return ParsedNode__7;
            };
         };
         if (IsErrorNode__1qwd(ParsedNode__7)) {
            return ParsedNode__7;
         } else {
            if (!(ParsedNode__7 instanceof ZEmptyNode)) {
               Set__3qwd(ParentNode__1, Index__2, ParsedNode__7);
            };
         };
      };
   };
   return ParentNode__1;
}

function MatchPattern__5qwf(self, ParentNode__1, Index__2, PatternName__3, IsRequired__4) {
   return MatchPattern__6qwf(self, ParentNode__1, Index__2, PatternName__3, IsRequired__4, false);
}

function MatchOptionaPattern__6qwf(self, ParentNode__1, Index__2, AllowNewLine__3, TokenText__4, PatternName__5) {
   if (!IsErrorNode__1qwd(ParentNode__1)) {
      if (MatchToken__2qwf(self, TokenText__4)) {
         return MatchPattern__6qwf(self, ParentNode__1, Index__2, PatternName__5, false, false);
      };
   };
   return ParentNode__1;
}

function MatchNtimes__6qwf(self, ParentNode__1, StartToken__2, PatternName__3, DelimToken__4, StopToken__5) {
   var Rememberd = SetParseFlag__2qwf(self, true);
   var IsRequired = false;
   if (StartToken__2 != null) {
      ParentNode__1 = MatchToken__4qwf(self, ParentNode__1, StartToken__2, true);
   };
   while (!IsErrorNode__1qwd(ParentNode__1)) {
      if (StopToken__5 != null) {
         var Token = GetToken__1qwf(self);
         if (EqualsText__2qwn(Token__8, StopToken__5)) {
            break;
         };
         IsRequired__7 = true;
      };
      var ParsedNode = ParsePattern__4qwf(self, ParentNode__1, PatternName__3, IsRequired__7);
      if (ParsedNode__9 == null) {
         break;
      };
      if (IsErrorNode__1qwd(ParsedNode__9)) {
         return ParsedNode__9;
      };
      if (!(ParsedNode__9 instanceof ZEmptyNode)) {
         Set__3qwd(ParentNode__1, -4, ParsedNode__9);
      };
      if (DelimToken__4 != null) {
         if (!MatchToken__2qwf(self, DelimToken__4)) {
            break;
         };
      };
   };
   if (StopToken__5 != null) {
      ParentNode__1 = MatchToken__4qwf(self, ParentNode__1, StopToken__5, true);
   };
   SetParseFlag__2qwf(self, Rememberd__6);
   return ParentNode__1;
}

function StartsWithToken__2qwf(self, TokenText__1) {
   var Token = GetToken__1qwf(self);
   if (EqualsText__2qwn(Token__2, TokenText__1)) {
      self.CurrentPosition = self.CurrentPosition + 1;
      return true;
   };
   if (StartsWith__2qwn(Token__2, TokenText__1)) {
      Token__3 = ZToken__4qwn(new ZToken(), Token__2.Source, Token__2.StartIndex + TokenText__1.length(), Token__2.EndIndex);
      self.CurrentPosition = self.CurrentPosition + 1;
      self.TokenList.add(self.CurrentPosition, Token);
      return true;
   };
   return false;
}

function SkipEmptyStatement__1qwf(self) {
   while (HasNext__1qwf(self)) {
      var Token = GetToken__1qwf(self);
      if (IsIndent__1qwn(Token__1) || EqualsText__2qwn(Token__1, ";")) {
         self.CurrentPosition = self.CurrentPosition + 1;
         continue;
      };
      break;
   };
   return;
}

function Dump__1qwf(self) {
   var Position = self.CurrentPosition;
   while (Position__1 < (self.TokenList).length) {
      var Token = self.TokenList[Position__1];
      var DumpedToken = "[";
      DumpedToken__3 = ((DumpedToken__3 + (Position__1).toString()) + "] ") + toString__1qwn(Token__2);
      LibZen_PrintDebug__1qqy(DumpedToken__3);
      Position__1 = Position__1 + 1;
   };
   return;
}

function ZTokenFunc__3qqn(self, Func__1, Parent__2) {
   self.Func = Func__1;
   self.ParentFunc = Parent__2;
   return null;
}

function toString__1qqn(self) {
   return self.Func.toString();
}

function ZVariable__7qyf(self, Parent__1, FuncNode__2, VarFlag__3, VarType__4, VarName__5, SourceToken__6) {
   ZSymbolEntry__3qy0(self, Parent__1, FuncNode__2);
   self.VarFlag = VarFlag__3;
   self.VarType = VarType__4;
   self.VarName = VarName__5;
   self.SourceToken = SourceToken__6;
   self.VarUniqueIndex = GetVarIndex__1qre(FuncNode__2);
   self.UsedCount = 0;
   self.DefCount = 1;
   return null;
}

function IsCaptured__2qyf(self, CurrentFunctionNode__1) {
   if (CurrentFunctionNode__1 == self.Node) {
      return false;
   };
   return true;
}

function Defined__1qyf(self) {
   self.DefCount = self.DefCount + 1;
   return;
}

function Used__1qyf(self) {
   self.UsedCount = self.UsedCount + 1;
   return;
}

function ZClassType__3qwb(self, ShortName__1, RefType__2) {
   ZType__4qwz(self, (1 << 9) | (1 << 16), ShortName__1, RefType__2);
   if (RefType__2 instanceof ZClassType) {
      ResetSuperType__2qwb(self, RefType__2);
   };
   return null;
}

function ResetSuperType__2qwb(self, SuperClass__1) {
   self.RefType = SuperClass__1;
   if (SuperClass__1.FieldList != null) {
      self.FieldList = [];
      var i = 0;
      while (i__2 < (SuperClass__1.FieldList).length) {
         var Field = SuperClass__1.FieldList[i__2];
         self.FieldList.add(Field__3);
         i__2 = i__2 + 1;
      };
   };
   return;
}

function GetFieldSize__1qwb(self) {
   if (self.FieldList != null) {
      return (self.FieldList).length;
   };
   return 0;
}

function GetFieldAt__2qwb(self, Index__1) {
   return self.FieldList[Index__1];
}

function HasField__2qwb(self, FieldName__1) {
   if (self.FieldList != null) {
      var i = 0;
      while (i__2 < (self.FieldList).length) {
         if (LibZen_EqualsString__2qqy(FieldName__1, self.FieldList[i__2].FieldName)) {
            return true;
         };
         i__2 = i__2 + 1;
      };
   };
   return false;
}

function GetFieldType__3qwb(self, FieldName__1, DefaultType__2) {
   if (self.FieldList != null) {
      var i = 0;
      while (i__3 < (self.FieldList).length) {
         var Field = self.FieldList[i__3];
         if (LibZen_EqualsString__2qqy(FieldName__1, Field__4.FieldName)) {
            return Field__4.FieldType;
         };
         i__3 = i__3 + 1;
      };
   };
   return DefaultType__2;
}

function AppendField__4qwb(self, FieldType__1, FieldName__2, SourceToken__3) {
   console.assert(!FieldType__1.IsVarType(FieldType__1), "(sample/libzen.zen:3286)");
   if (self.FieldList == null) {
      self.FieldList = [];
   };
   var ClassField = ZClassField__5qwv(new ZClassField(), self, FieldName__2, FieldType__1, SourceToken__3);
   self.FieldList.add(ClassField__4);
   return ClassField__4;
}

function ZFuncType__3qw5(self, ShortName__1, UniqueTypeParams__2) {
   ZType__4qwz(self, 1 << 16, ShortName__1, ZType__4qwz(new ZType(), 1 << 16, "var", null));
   if (UniqueTypeParams__2 == null) {
      self.TypeParams = LibZen_NewTypeArray(1);
      self.TypeParams[0] = ZType__4qwz(new ZType(), 1 << 16, "var", null);
   } else {
      self.TypeParams = UniqueTypeParams__2;
   };
   var i = 0;
   while (i__3 < LibZen_Size__1qqq(self.TypeParams)) {
      if (self.TypeParams[i__3].IsVarType(self.TypeParams[i__3])) {
         self.HasUnknownType = true;
      };
      if (self.TypeParams[i__3].IsGreekType(self.TypeParams[i__3])) {
         self.HasGreekType = true;
      };
      i__3 = i__3 + 1;
   };
   return null;
}

function IsFuncType__1qw5(self) {
   return true;
}

function IsVarType__1qw5(self) {
   return self.HasUnknownType;
}

function IsGreekType__1qw5(self) {
   return self.HasGreekType;
}

function GetGreekRealType__2qw5(self, Greek__1) {
   if (self.HasGreekType) {
      var TypeList = [];
      var i = 0;
      while (i__3 < LibZen_Size__1qqq(self.TypeParams)) {
         TypeList__2.add(self.TypeParams[i__3].GetGreekRealType(self.TypeParams[i__3], Greek__1));
         i__3 = i__3 + 1;
      };
      return ZTypePool_LookupFuncType__1qwx(TypeList__2);
   };
   return self;
}

function AcceptValueType__4qw5(self, ValueType__1, ExactMatch__2, Greek__3) {
   if (IsFuncType__1qwz(ValueType__1) && ValueType__1.GetParamSize(ValueType__1) == self.GetParamSize(self)) {
      var i = 0;
      while (i__4 < LibZen_Size__1qqq(self.TypeParams)) {
         if (!self.TypeParams[i__4].AcceptValueType(self.TypeParams[i__4], ValueType__1.GetParamType(ValueType__1, i__4), true, Greek__3)) {
            return false;
         };
         i__4 = i__4 + 1;
      };
      return true;
   };
   return false;
}

function StringfySignature__2qw5(self, FuncName__1) {
   return ZFunc_StringfySignature__3qqy(FuncName__1, GetFuncParamSize__1qw5(self), GetRecvType__1qw5(self));
}

function GetBaseType__1qw5(self) {
   return ZFuncType__3qw5(new ZFuncType(), "Func", null);
}

function GetParamSize__1qw5(self) {
   return LibZen_Size__1qqq(self.TypeParams);
}

function GetParamType__2qw5(self, Index__1) {
   return self.TypeParams[Index__1];
}

function GetReturnType__1qw5(self) {
   return self.TypeParams[0];
}

function GetFuncParamSize__1qw5(self) {
   return LibZen_Size__1qqq(self.TypeParams) - 1;
}

function GetRecvType__1qw5(self) {
   if (LibZen_Size__1qqq(self.TypeParams) == 1) {
      return ZType__4qwz(new ZType(), 1 << 16, "void", null);
   };
   return self.TypeParams[1];
}

function GetFuncParamType__2qw5(self, Index__1) {
   return self.TypeParams[Index__1 + 1];
}

function NewMethodFuncType__2qw5(self, RecvType__1) {
   var TypeList = [];
   TypeList__2.add(GetReturnType__1qw5(self));
   TypeList__2.add(RecvType__1);
   var i = 0;
   while (i__3 < GetFuncParamSize__1qw5(self)) {
      TypeList__2.add(GetFuncParamType__2qw5(self, i__3));
      i__3 = i__3 + 1;
   };
   return ZTypePool_LookupFuncType__1qwx(TypeList__2);
}

function AcceptAsFieldFunc__2qw5(self, FuncType__1) {
   if (GetFuncParamSize__1qw5(FuncType__1) == GetFuncParamSize__1qw5(self) && Equals__2qwz(GetReturnType__1qw5(FuncType__1), GetReturnType__1qw5(self))) {
      var i = 1;
      while (i__2 < GetFuncParamSize__1qw5(FuncType__1)) {
         if (!Equals__2qwz(GetFuncParamType__2qw5(FuncType__1, i__2), GetFuncParamType__2qw5(self, i__2))) {
            return false;
         };
         i__2 = i__2 + 1;
      };
   };
   return true;
}

function ZGeneric1Type__5qi7(self, TypeFlag__1, ShortName__2, BaseType__3, ParamType__4) {
   ZType__4qwz(self, TypeFlag__1, ShortName__2, ZType__4qwz(new ZType(), 1 << 16, "var", null));
   self.BaseType = BaseType__3;
   if (self.BaseType == null) {
      self.BaseType = self;
   };
   self.ParamType = ParamType__4;
   return null;
}

function GetSuperType__1qi7(self) {
   if (self.BaseType == self) {
      return self.RefType;
   };
   return self.BaseType;
}

function GetBaseType__1qi7(self) {
   return self.BaseType;
}

function GetParamSize__1qi7(self) {
   return 1;
}

function GetParamType__2qi7(self, Index__1) {
   if (Index__1 == 0) {
      return self.ParamType;
   };
   return null;
}

function IsGreekType__1qi7(self) {
   return (self.ParamType.IsGreekType());
}

function GetGreekRealType__2qi7(self, Greek__1) {
   if (self.ParamType.IsGreekType(self.ParamType)) {
      return ZTypePool_GetGenericType1__2qwz(self.BaseType, self.ParamType.GetGreekRealType(self.ParamType, Greek__1));
   };
   return self.GetRealType(self);
}

function AcceptValueType__4qi7(self, ValueType__1, ExactMatch__2, Greek__3) {
   if (self.BaseType == ValueType__1.GetBaseType(ValueType__1) && ValueType__1.GetParamSize(ValueType__1) == 1) {
      return self.ParamType.AcceptValueType(self.ParamType, ValueType__1.GetParamType(ValueType__1, 0), true, Greek__3);
   };
   return false;
}

function ZGreekType__2qor(self, GreekId__1) {
   ZType__4qwz(self, 1 << 16, LibZen_GreekNames[GreekId__1], ZType__4qwz(new ZType(), 1 << 16, "var", null));
   self.GreekId = GreekId__1;
   return null;
}

function IsGreekType__1qor(self) {
   return true;
}

function GetGreekRealType__2qor(self, Greek__1) {
   if (Greek__1[self.GreekId] == null) {
      return ZType__4qwz(new ZType(), 1 << 16, "var", null);
   };
   return Greek__1[self.GreekId];
}

function AcceptValueType__4qor(self, ValueType__1, ExactMatch__2, Greek__3) {
   if (Greek__3[self.GreekId] == null) {
      if (ValueType__1.IsVarType(ValueType__1)) {
         return true;
      };
      Greek__3[self.GreekId] = ValueType__1;
      return true;
   } else {
      return Greek__3[self.GreekId].AcceptValueType(Greek__3[self.GreekId], ValueType__1, ExactMatch__2, Greek__3);
   };
}

function ZAnnotationNode__4qoo(self, ParentNode__1, Token__2, Anno__3) {
   ZNode__4qwd(self, ParentNode__1, Token__2, 0);
   return null;
}

function IsBreakingBlock__1qoo(self) {
   return self.AnnotatedNode.IsBreakingBlock(self.AnnotatedNode);
}

function Accept__2qoo(self, Visitor__1) {
   self.AnnotatedNode.Accept(self.AnnotatedNode, Visitor__1);
   return;
}

function ZAssertNode__2qod(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   return null;
}

function DeSugar__2qod(self, Generator__1) {
   var Func = GetMacroFunc__4qwh(Generator__1, "assert", ZType__4qwz(new ZType(), 1 << 16, "boolean", ZType__4qwz(new ZType(), 1 << 16, "var", null)), 2);
   if (Func__2 != null) {
      var MacroNode = ZMacroNode__4q0c(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__2);
      Append__2quq(MacroNode__3, self.AST[0]);
      Append__2quq(MacroNode__3, ZStringNode__4q4n(new ZStringNode(), MacroNode__3, null, GetSourceLocation__1qwd(self)));
      return ZSugarNode__3qr6(new ZSugarNode(), self, MacroNode__3);
   } else {
      var MacroNode = ZFuncCallNode__4q4y(new ZFuncCallNode(), self.ParentNode, "assert", ZType__4qwz(new ZType(), 1 << 16, "var", null));
      Append__2quq(MacroNode__4, self.AST[0]);
      return ZSugarNode__3qr6(new ZSugarNode(), self, MacroNode__4);
   };
}

function ZBinaryNode__5qoh(self, ParentNode__1, SourceToken__2, Left__3, Pattern__4) {
   ZNode__4qwd(self, ParentNode__1, SourceToken__2, 2);
   Set__3qwd(self, 0, Left__3);
   console.assert(Pattern__4 != null, "(sample/libzen.zen:3527)");
   self.Pattern = Pattern__4;
   return null;
}

function IsRightJoin__2qoh(self, Node__1) {
   if (Node__1 instanceof ZBinaryNode) {
      return IsRightJoin__2qyy(self.Pattern, (Node__1).Pattern);
   };
   return false;
}

function RightJoin__3qoh(self, ParentNode__1, RightNode__2) {
   var RightLeftNode = RightNode__2.AST[0];
   if (IsRightJoin__2qoh(self, RightLeftNode__3)) {
      Set__3qwd(RightNode__2, 0, RightJoin__3qoh(self, ParentNode__1, RightLeftNode__3));
   } else {
      Set__3qwd(RightNode__2, 0, self);
      Set__3qwd(self, 1, RightLeftNode__3);
   };
   return RightNode__2;
}

function AppendParsedRightNode__3qoh(self, ParentNode__1, TokenContext__2) {
   var RightNode = ParsePattern__4qwf(TokenContext__2, ParentNode__1, "$Expression$", true);
   if (IsErrorNode__1qwd(RightNode__3)) {
      return RightNode__3;
   };
   if (IsRightJoin__2qoh(self, RightNode__3)) {
      return RightJoin__3qoh(self, ParentNode__1, RightNode__3);
   };
   Set__3qwd(self, 1, RightNode__3);
   return self;
}

function TryMacroNode__2qoh(self, Generator__1) {
   if (!GetAstType__2qwd(self, 0).IsVarType(GetAstType__2qwd(self, 0)) && !GetAstType__2qwd(self, 1).IsVarType(GetAstType__2qwd(self, 1))) {
      var Op = GetText__1qwn(self.SourceToken);
      var Func = GetDefinedFunc__4qwh(Generator__1, Op__2, GetAstType__2qwd(self, 0), 2);
      if (Func__3 instanceof ZMacroFunc) {
         var MacroNode = ZMacroNode__4q0c(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__3);
         Append__2quq(MacroNode__4, self.AST[0]);
         Append__2quq(MacroNode__4, self.AST[1]);
         return MacroNode__4;
      };
   };
   return self;
}

function Accept__2qoh(self, Visitor__1) {
   Visitor__1.VisitBinaryNode(Visitor__1, self);
   return;
}

function ZBreakNode__2qoz(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 0);
   return null;
}

function Accept__2qoz(self, Visitor__1) {
   Visitor__1.VisitBreakNode(Visitor__1, self);
   return;
}

function ZCastNode__4qov(self, ParentNode__1, CastType__2, Node__3) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   self.Type = CastType__2;
   if (Node__3 != null) {
      Set__3qwd(self, 0, Node__3);
   };
   return null;
}

function Accept__2qov(self, Visitor__1) {
   Visitor__1.VisitCastNode(Visitor__1, self);
   return;
}

function ToFuncCallNode__2qov(self, Func__1) {
   if (Func__1 instanceof ZMacroFunc) {
      var FuncNode = ZMacroNode__4q0c(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__1);
      Append__2quq(FuncNode__2, self.AST[0]);
      return FuncNode__2;
   } else {
      var FuncNode = ZFuncCallNode__4q4y(new ZFuncCallNode(), self.ParentNode, Func__1.FuncName, GetFuncType__1qw7(Func__1));
      FuncNode__3.SourceToken = self.SourceToken;
      Append__2quq(FuncNode__3, self.AST[0]);
      return FuncNode__3;
   };
}

function ZCatchNode__2qo7(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   return null;
}

function SetTypeInfo__3qo7(self, TypeToken__1, Type__2) {
   self.ExceptionType = Type__2;
   return;
}

function SetNameInfo__3qo7(self, NameToken__1, Name__2) {
   self.ExceptionName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function ZComparatorNode__5qo8(self, ParentNode__1, SourceToken__2, Left__3, Pattern__4) {
   ZBinaryNode__5qoh(self, ParentNode__1, SourceToken__2, Left__3, Pattern__4);
   return null;
}

function Accept__2qo8(self, Visitor__1) {
   Visitor__1.VisitComparatorNode(Visitor__1, self);
   return;
}

function ZConstNode__3qpe(self, ParentNode__1, SourceToken__2) {
   ZNode__4qwd(self, ParentNode__1, SourceToken__2, 0);
   return null;
}

function ZEmptyNode__3qpt(self, ParentNode__1, Token__2) {
   ZNode__4qwd(self, ParentNode__1, Token__2, 0);
   return null;
}

function ZErrorNode__4qpu(self, ParentNode__1, SourceToken__2, ErrorMessage__3) {
   ZConstNode__3qpe(self, ParentNode__1, SourceToken__2);
   self.ErrorMessage = ErrorMessage__3;
   return null;
}

function ZErrorNode__3qpu(self, Node__1, ErrorMessage__2) {
   ZConstNode__3qpe(self, Node__1.ParentNode, Node__1.SourceToken);
   self.ErrorMessage = ErrorMessage__2;
   return null;
}

function Accept__2qpu(self, Visitor__1) {
   Visitor__1.VisitErrorNode(Visitor__1, self);
   return;
}

function ZFieldNode__2qp0(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   return null;
}

function SetTypeInfo__3qp0(self, TypeToken__1, Type__2) {
   self.DeclType = Type__2;
   return;
}

function SetNameInfo__3qp0(self, NameToken__1, Name__2) {
   self.FieldName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function ZFloatNode__4qpd(self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qpe(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwz(new ZType(), 1 << 16, "float", ZType__4qwz(new ZType(), 1 << 16, "var", null));
   self.FloatValue = Value__3;
   return null;
}

function Accept__2qpd(self, Visitor__1) {
   Visitor__1.VisitFloatNode(Visitor__1, self);
   return;
}

function ZGetIndexNode__3qph(self, ParentNode__1, RecvNode__2) {
   ZNode__4qwd(self, ParentNode__1, null, 2);
   self.AST[0] = SetChild__2qwd(self, RecvNode__2);
   return null;
}

function Accept__2qph(self, Visitor__1) {
   Visitor__1.VisitGetIndexNode(Visitor__1, self);
   return;
}

function ZGetNameNode__4qpl(self, ParentNode__1, Token__2, NativeName__3) {
   ZNode__4qwd(self, ParentNode__1, Token__2, 0);
   self.VarName = NativeName__3;
   return null;
}

function ZGetNameNode__3qpl(self, ParentNode__1, ResolvedFunc__2) {
   ZNode__4qwd(self, ParentNode__1, null, 0);
   self.VarName = ResolvedFunc__2.FuncName;
   self.Type = GetFuncType__1qw7(ResolvedFunc__2);
   return null;
}

function Accept__2qpl(self, Visitor__1) {
   Visitor__1.VisitGetNameNode(Visitor__1, self);
   return;
}

function ToGlobalNameNode__1qpl(self) {
   return ZGlobalNameNode__6qpm(new ZGlobalNameNode(), self.ParentNode, self.SourceToken, self.Type, self.VarName, false);
}

function ZGetterNode__3qpx(self, ParentNode__1, RecvNode__2) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   Set__3qwd(self, 0, RecvNode__2);
   return null;
}

function SetNameInfo__3qpx(self, NameToken__1, Name__2) {
   self.FieldName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function Accept__2qpx(self, Visitor__1) {
   Visitor__1.VisitGetterNode(Visitor__1, self);
   return;
}

function IsStaticField__1qpx(self) {
   return self.AST[0] instanceof ZTypeNode;
}

function ZGlobalNameNode__6qpm(self, ParentNode__1, SourceToken__2, Type__3, GlobalName__4, IsStaticFuncName__5) {
   ZNode__4qwd(self, ParentNode__1, SourceToken__2, 0);
   self.GlobalName = GlobalName__4;
   self.Type = Type__3;
   self.IsStaticFuncName = IsStaticFuncName__5;
   return null;
}

function IsGivenName__1qpm(self) {
   return (!self.IsStaticFuncName);
}

function Accept__2qpm(self, Visitor__1) {
   Visitor__1.VisitGlobalNameNode(Visitor__1, self);
   return;
}

function ZGroupNode__2qp2(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   return null;
}

function Accept__2qp2(self, Visitor__1) {
   Visitor__1.VisitGroupNode(Visitor__1, self);
   return;
}

function ZIfNode__2q0w(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 3);
   return null;
}

function Accept__2q0w(self, Visitor__1) {
   Visitor__1.VisitIfNode(Visitor__1, self);
   return;
}

function ZImportNode__2q0t(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 0);
   return null;
}

function SetNameInfo__3q0t(self, NameToken__1, Name__2) {
   if (self.ResourcePath == null) {
      self.ResourcePath = Name__2;
      self.ResourceToken = NameToken__1;
   } else {
      self.Alias = Name__2;
   };
   return;
}

function ZInstanceOfNode__4q0i(self, ParentNode__1, Token__2, LeftNode__3) {
   ZNode__4qwd(self, ParentNode__1, Token__2, 1);
   Set__3qwd(self, 0, LeftNode__3);
   return null;
}

function SetTypeInfo__3q0i(self, TypeToken__1, Type__2) {
   self.TargetType = Type__2;
   return;
}

function Accept__2q0i(self, Visitor__1) {
   Visitor__1.VisitInstanceOfNode(Visitor__1, self);
   return;
}

function ZIntNode__4q04(self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qpe(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwz(new ZType(), 1 << 16, "int", ZType__4qwz(new ZType(), 1 << 16, "var", null));
   self.IntValue = Value__3;
   return null;
}

function Accept__2q04(self, Visitor__1) {
   Visitor__1.VisitIntNode(Visitor__1, self);
   return;
}

function ZLetNode__2q0d(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 1);
   return null;
}

function SetNameInfo__3q0d(self, NameToken__1, Name__2) {
   self.Symbol = Name__2;
   self.SymbolToken = NameToken__1;
   return;
}

function SetTypeInfo__3q0d(self, TypeToken__1, Type__2) {
   self.SymbolType = Type__2;
   return;
}

function Accept__2q0d(self, Visitor__1) {
   Visitor__1.VisitLetNode(Visitor__1, self);
   return;
}

function ToGlobalNameNode__1q0d(self) {
   return ZGlobalNameNode__6qpm(new ZGlobalNameNode(), null, self.SymbolToken, GetAstType__2qwd(self, 0), self.GlobalName, false);
}

function ZListNode__4quq(self, ParentNode__1, SourceToken__2, Size__3) {
   ZNode__4qwd(self, ParentNode__1, SourceToken__2, Size__3);
   self.ListStartIndex = Size__3;
   return null;
}

function Append__2quq(self, Node__1) {
   if (self.AST == null) {
      self.AST = LibZen_NewNodeArray(1);
      Set__3qwd(self, 0, Node__1);
   } else {
      var newAST = LibZen_NewNodeArray(self.AST.length + 1);
      LibZen_ArrayCopy(self.AST, 0, newAST__2, 0, self.AST.length);
      self.AST = newAST__2;
      Set__3qwd(self, self.AST.length - 1, Node__1);
   };
   return;
}

function GetListSize__1quq(self) {
   return GetAstSize__1qwd(self) - self.ListStartIndex;
}

function GetListAt__2quq(self, Index__1) {
   return self.AST[self.ListStartIndex + Index__1];
}

function SetListAt__3quq(self, Index__1, Node__2) {
   Set__3qwd(self, Index__1 + self.ListStartIndex, Node__2);
   return;
}

function InsertListAt__3quq(self, Index__1, Node__2) {
   if (self.AST == null || Index__1 < 0 || self.AST.length == Index__1) {
      Append__2quq(self, Node__2);
   } else {
      var newAST = LibZen_NewNodeArray(self.AST.length + 1);
      Index__1 = self.ListStartIndex + Index__1;
      LibZen_ArrayCopy(self.AST, 0, newAST__3, 0, Index__1);
      Set__3qwd(self, Index__1, Node__2);
      LibZen_ArrayCopy(self.AST, Index__1, newAST__3, Index__1 + 1, self.AST.length - Index__1);
      self.AST = newAST__3;
   };
   return;
}

function RemoveListAt__2quq(self, Index__1) {
   var Removed = GetListAt__2quq(self, Index__1);
   var newAST = LibZen_NewNodeArray(self.AST.length - 1);
   var RemovedIndex = self.ListStartIndex + Index__1;
   LibZen_ArrayCopy(self.AST, 0, newAST__3, 0, RemovedIndex__4);
   LibZen_ArrayCopy(self.AST, RemovedIndex__4 + 1, newAST__3, RemovedIndex__4, self.AST.length - (RemovedIndex__4 + 1));
   self.AST = newAST__3;
   return Removed__2;
}

function ClearListAfter__2quq(self, Size__1) {
   if (Size__1 < GetListSize__1quq(self)) {
      var newsize = self.ListStartIndex + Size__1;
      if (newsize__2 == 0) {
         self.AST = null;
      } else {
         var newAST = LibZen_NewNodeArray(newsize__2);
         LibZen_ArrayCopy(self.AST, 0, newAST__3, 0, newsize__2);
         self.AST = newAST__3;
      };
   };
   return;
}

function ZMacroNode__4q0c(self, ParentNode__1, SourceToken__2, MacroFunc__3) {
   ZListNode__4quq(self, ParentNode__1, SourceToken__2, 0);
   self.MacroFunc = MacroFunc__3;
   console.assert(MacroFunc__3 != null, "(sample/libzen.zen:3885)");
   return null;
}

function GetFuncType__1q0c(self) {
   return GetFuncType__1qw7(self.MacroFunc);
}

function GetMacroText__1q0c(self) {
   var Func = self.MacroFunc;
   if (Func__1 instanceof ZSourceMacro) {
      return (Func__1).Macro;
   };
   return "";
}

function Accept__2q0c(self, Visitor__1) {
   Visitor__1.VisitMacroNode(Visitor__1, self);
   return;
}

function ZMapEntryNode__2q07(self, ParentNode__1) {
   ZNode__4qwd(self, ParentNode__1, null, 2);
   return null;
}

function ZMapLiteralNode__2q03(self, ParentNode__1) {
   ZListNode__4quq(self, ParentNode__1, null, 0);
   return null;
}

function GetMapEntryNode__2q03(self, Index__1) {
   var Node = GetListAt__2quq(self, Index__1);
   if (Node__2 instanceof ZMapEntryNode) {
      return Node__2;
   };
   return null;
}

function Accept__2q03(self, Visitor__1) {
   Visitor__1.VisitMapLiteralNode(Visitor__1, self);
   return;
}

function ZMethodCallNode__3q4w(self, ParentNode__1, RecvNode__2) {
   ZListNode__4quq(self, ParentNode__1, null, 1);
   Set__3qwd(self, 0, RecvNode__2);
   return null;
}

function SetNameInfo__3q4w(self, NameToken__1, Name__2) {
   self.MethodName = Name__2;
   self.MethodToken = NameToken__1;
   return;
}

function Accept__2q4w(self, Visitor__1) {
   Visitor__1.VisitMethodCallNode(Visitor__1, self);
   return;
}

function ToGetterFuncCall__1q4w(self) {
   var Getter = ZGetterNode__3qpx(new ZGetterNode(), null, self.AST[0]);
   Getter__1.SetNameInfo(Getter__1, self.MethodToken, self.MethodName);
   var FuncNode = ZFuncCallNode__3q4y(new ZFuncCallNode(), self.ParentNode, Getter__1);
   FuncNode__2.SourceToken = self.SourceToken;
   Append__2quq(FuncNode__2, self.AST[0]);
   var i = 0;
   while (i__3 < GetListSize__1quq(self)) {
      Append__2quq(FuncNode__2, GetListAt__2quq(self, i__3));
      i__3 = i__3 + 1;
   };
   return FuncNode__2;
}

function ToFuncCallNode__2q4w(self, Func__1) {
   if (Func__1 instanceof ZMacroFunc) {
      var MacroNode = ZMacroNode__4q0c(new ZMacroNode(), self.ParentNode, self.MethodToken, Func__1);
      Append__2quq(MacroNode__2, self.AST[0]);
      var i = 0;
      while (i__3 < GetListSize__1quq(self)) {
         Append__2quq(MacroNode__2, GetListAt__2quq(self, i__3));
         i__3 = i__3 + 1;
      };
      return MacroNode__2;
   } else {
      var FuncNode = ZFuncCallNode__4q4y(new ZFuncCallNode(), self.ParentNode, Func__1.FuncName, GetFuncType__1qw7(Func__1));
      FuncNode__4.SourceToken = self.MethodToken;
      Append__2quq(FuncNode__4, self.AST[0]);
      var i = 0;
      while (i__5 < GetListSize__1quq(self)) {
         Append__2quq(FuncNode__4, GetListAt__2quq(self, i__5));
         i__5 = i__5 + 1;
      };
      return FuncNode__4;
   };
}

function ZNewArrayNode__4q4o(self, ParentNode__1, Type__2, Token__3) {
   ZListNode__4quq(self, ParentNode__1, null, 0);
   return null;
}

function ZNewObjectNode__2q40(self, ParentNode__1) {
   ZListNode__4quq(self, ParentNode__1, null, 0);
   return null;
}

function Accept__2q40(self, Visitor__1) {
   Visitor__1.VisitNewObjectNode(Visitor__1, self);
   return;
}

function ToFuncCallNode__2q40(self, Func__1) {
   var FuncNode = null;
   if (Func__1 instanceof ZMacroFunc) {
      FuncNode__2 = ZMacroNode__4q0c(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__1);
   } else {
      FuncNode__2 = ZFuncCallNode__4q4y(new ZFuncCallNode(), self.ParentNode, Func__1.FuncName, GetFuncType__1qw7(Func__1));
      FuncNode__2.SourceToken = self.SourceToken;
   };
   Append__2quq(FuncNode__2, self);
   var i = 0;
   while (i__3 < GetListSize__1quq(self)) {
      Append__2quq(FuncNode__2, GetListAt__2quq(self, i__3));
      i__3 = i__3 + 1;
   };
   ClearListAfter__2quq(self, 0);
   return FuncNode__2;
}

function ZNotNode__3q4d(self, ParentNode__1, Token__2) {
   ZUnaryNode__3qtk(self, ParentNode__1, Token__2);
   return null;
}

function Accept__2q4d(self, Visitor__1) {
   Visitor__1.VisitNotNode(Visitor__1, self);
   return;
}

function ZNullNode__3q4h(self, ParentNode__1, SourceToken__2) {
   ZConstNode__3qpe(self, ParentNode__1, SourceToken__2);
   return null;
}

function Accept__2q4h(self, Visitor__1) {
   Visitor__1.VisitNullNode(Visitor__1, self);
   return;
}

function ZOrNode__5q4l(self, ParentNode__1, Token__2, Left__3, Pattern__4) {
   ZBinaryNode__5qoh(self, ParentNode__1, Token__2, Left__3, Pattern__4);
   return null;
}

function Accept__2q4l(self, Visitor__1) {
   Visitor__1.VisitOrNode(Visitor__1, self);
   return;
}

function ZPrototypeNode__2q46(self, ParentNode__1) {
   ZListNode__4quq(self, ParentNode__1, null, 0);
   return null;
}

function SetTypeInfo__3q46(self, TypeToken__1, Type__2) {
   self.ReturnType = Type__2;
   return;
}

function SetNameInfo__3q46(self, NameToken__1, Name__2) {
   self.FuncName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function GetParamNode__2q46(self, Index__1) {
   var Node = GetListAt__2quq(self, Index__1);
   if (Node__2 instanceof ZParamNode) {
      return Node__2;
   };
   return null;
}

function GetFuncType__1q46(self) {
   var TypeList = [];
   TypeList__1.add(self.ReturnType.GetRealType(self.ReturnType));
   var i = 0;
   while (i__2 < GetListSize__1quq(self)) {
      var Node = GetParamNode__2q46(self, i__2);
      var ParamType = Node__3.Type.GetRealType(Node__3.Type);
      TypeList__1.add(ParamType__4);
      i__2 = i__2 + 1;
   };
   return ZTypePool_LookupFuncType__1qwx(TypeList__1);
}

function ZStringNode__4q4n(self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qpe(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwz(new ZType(), 1 << 16, "String", ZType__4qwz(new ZType(), 1 << 16, "var", null));
   self.StringValue = Value__3;
   return null;
}

function Accept__2q4n(self, Visitor__1) {
   Visitor__1.VisitStringNode(Visitor__1, self);
   return;
}

function ZStupidCastErrorNode__3q45(self, Node__1, ErrorMessage__2) {
   ZErrorNode__3qpu(self, Node__1, ErrorMessage__2);
   self.ErrorNode = Node__1;
   return null;
}

function ZTypeNode__4qyl(self, ParentNode__1, SourceToken__2, ParsedType__3) {
   ZConstNode__3qpe(self, ParentNode__1, SourceToken__2);
   self.Type = ParsedType__3;
   return null;
}

function ZGenerator__3qwh(self, LanguageExtension__1, TargetVersion__2) {
   LibZen.ThrowError("undefined code generation: #ZTypeNode:ZVisitor")(self);
   self.RootNameSpace = ZNameSpace__3qwo(new ZNameSpace(), self, null);
   self.GrammarInfo = "";
   self.LanguageExtention = LanguageExtension__1;
   self.TargetVersion = TargetVersion__2;
   self.OutputFile = null;
   self.Logger = new ZLogger();
   self.StoppedVisitor = false;
   return null;
}

function ImportLocalGrammar__2qwh(self, NameSpace__1) {
   return;
}

function WriteTo__2qwh(self, FileName__1) {
   return;
}

function NameOutputFile__2qwh(self, FileName__1) {
   if (FileName__1 != null) {
      return (FileName__1 + ".") + self.LanguageExtention;
   };
   return FileName__1;
}

function EnableVisitor__1qwh(self) {
   self.StoppedVisitor = false;
   return;
}

function StopVisitor__1qwh(self) {
   self.StoppedVisitor = true;
   return;
}

function IsVisitable__1qwh(self) {
   return !self.StoppedVisitor;
}

function GetGrammarInfo__1qwh(self) {
   return self.GrammarInfo.trim();
}

function AppendGrammarInfo__2qwh(self, GrammarInfo__1) {
   self.GrammarInfo = (self.GrammarInfo + GrammarInfo__1) + " ";
   return;
}

function GetTargetLangInfo__1qwh(self) {
   return self.LanguageExtention + self.TargetVersion;
}

function GetFieldType__3qwh(self, BaseType__1, Name__2) {
   return ZType__4qwz(new ZType(), 1 << 16, "var", null);
}

function GetSetterType__3qwh(self, BaseType__1, Name__2) {
   return ZType__4qwz(new ZType(), 1 << 16, "var", null);
}

function GetConstructorFuncType__3qwh(self, ClassType__1, List__2) {
   return ZFuncType__3qw5(new ZFuncType(), "Func", null);
}

function GetMethodFuncType__4qwh(self, RecvType__1, MethodName__2, List__3) {
   return ZFuncType__3qw5(new ZFuncType(), "Func", null);
}

function GetUniqueNumber__1qwh(self) {
   var UniqueNumber = self.UniqueNumber;
   self.UniqueNumber = self.UniqueNumber + 1;
   return UniqueNumber__1;
}

function NameGlobalSymbol__2qwh(self, Symbol__1) {
   return (Symbol__1 + "_Z") + (GetUniqueNumber__1qwh(self)).toString();
}

function NameClass__2qwh(self, ClassType__1) {
   return (ClassType__1.ShortName + "") + (ClassType__1.TypeId).toString();
}

function SetDefinedFunc__2qwh(self, Func__1) {
   self.DefinedFuncMap[GetSignature__1qw7(Func__1)] = Func__1;
   return;
}

function SetPrototype__4qwh(self, Node__1, FuncName__2, FuncType__3) {
   var Func = GetDefinedFunc__3qwh(self, FuncName__2, FuncType__3);
   if (Func__4 != null) {
      if (!Equals__2qwz(FuncType__3, GetFuncType__1qw7(Func__4))) {
         ZLogger_LogError__2qwn(Node__1.SourceToken, "function has been defined diffrently: " + GetFuncType__1qw7(Func__4));
         return null;
      };
      if (Func__4 instanceof ZPrototype) {
         return Func__4;
      };
      ZLogger_LogError__2qwn(Node__1.SourceToken, "function has been defined as macro" + Func__4);
      return null;
   };
   var Proto = ZPrototype__5qer(new ZPrototype(), 0, FuncName__2, FuncType__3, Node__1.SourceToken);
   self.DefinedFuncMap[GetSignature__1qw7(Proto__5)] = Proto__5;
   return Proto__5;
}

function GetDefinedFunc__2qwh(self, GlobalName__1) {
   var Func = self.DefinedFuncMap[GlobalName__1];
   if (Func__2 == null && LibZen_IsLetter__1qqy(LibZen_GetChar__2qqy(GlobalName__1, 0))) {
      Func__2 = self.DefinedFuncMap[LibZen_AnotherName__1qqy(GlobalName__1)];
   };
   return Func__2;
}

function GetDefinedFunc__3qwh(self, FuncName__1, FuncType__2) {
   return GetDefinedFunc__2qwh(self, StringfySignature__2qw5(FuncType__2, FuncName__1));
}

function GetDefinedFunc__4qwh(self, FuncName__1, RecvType__2, FuncParamSize__3) {
   return GetDefinedFunc__2qwh(self, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
}

function GetMacroFunc__4qwh(self, FuncName__1, RecvType__2, FuncParamSize__3) {
   var Func = GetDefinedFunc__2qwh(self, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
   if (Func__4 instanceof ZMacroFunc) {
      return (Func__4);
   };
   return null;
}

function NameConverterFunc__3qwh(self, FromType__1, ToType__2) {
   return (GetUniqueName__1qwz(FromType__1) + "T") + GetUniqueName__1qwz(ToType__2);
}

function SetConverterFunc__4qwh(self, FromType__1, ToType__2, Func__3) {
   self.DefinedFuncMap[NameConverterFunc__3qwh(self, FromType__1, ToType__2)] = Func__3;
   return;
}

function GetConverterFunc__3qwh(self, FromType__1, ToType__2) {
   while (FromType__1 != null) {
      var Func = self.DefinedFuncMap[NameConverterFunc__3qwh(self, FromType__1, ToType__2)];
      if (Func__3 != null) {
         return Func__3;
      };
      FromType__1 = FromType__1.GetSuperType(FromType__1);
   };
   return null;
}

function GetCoercionFunc__3qwh(self, FromType__1, ToType__2) {
   while (FromType__1 != null) {
      var Func = self.DefinedFuncMap[NameConverterFunc__3qwh(self, FromType__1, ToType__2)];
      if (Func__3 != null && IsCoercionFunc__1qw7(Func__3)) {
         return Func__3;
      };
      FromType__1 = FromType__1.GetSuperType(FromType__1);
   };
   return null;
}

function VisitExtendedNode__2qwh(self, Node__1) {
   var DeNode = Node__1.DeSugar(Node__1, self);
   DeNode__2.Accept(DeNode__2, self);
   return;
}

function VisitSugarNode__2qwh(self, Node__1) {
   Node__1.AST[0].Accept(Node__1.AST[0], self);
   return;
}

function ZIndentToken__4qa1(self, Source__1, StartIndex__2, EndIndex__3) {
   ZToken__4qwn(self, Source__1, StartIndex__2, EndIndex__3);
   return null;
}

function ZPatternToken__5qaz(self, Source__1, StartIndex__2, EndIndex__3, PresetPattern__4) {
   ZToken__4qwn(self, Source__1, StartIndex__2, EndIndex__3);
   self.PresetPattern = PresetPattern__4;
   return null;
}

function ZSourceEngine__3qwk(self, TypeChecker__1, Generator__2) {
   self.TypeChecker = TypeChecker__1;
   self.Generator = Generator__2;
   self.Logger = Generator__2.Logger;
   return null;
}

function IsVisitable__1qwk(self) {
   return self.IsVisitable;
}

function EnableVisitor__1qwk(self) {
   self.IsVisitable = true;
   return;
}

function StopVisitor__1qwk(self) {
   self.IsVisitable = false;
   return;
}

function Eval__2qwk(self, Node__1) {
   if (self.IsVisitable(self)) {
      Node__1.Accept(Node__1, self);
   };
   return new ZEmptyValue();
}

function VisitPrototypeNode__2qwk(self, Node__1) {
   var FuncType = GetFuncType__1q46(Node__1);
   SetPrototype__4qwh(self.Generator, Node__1, Node__1.FuncName, FuncType__2);
   return;
}

function VisitImportNode__2qwk(self, Node__1) {
   Node__1.Import(Node__1);
   return;
}

function Exec__3qwk(self, Node__1, IsInteractive__2) {
   self.InteractiveContext = IsInteractive__2;
   self.EnableVisitor(self);
   if (Node__1 instanceof ZPrototypeNode) {
      VisitPrototypeNode__2qwk(self, Node__1);
      return new ZEmptyValue();
   } else if (Node__1 instanceof ZImportNode) {
      VisitImportNode__2qwk(self, Node__1);
      return new ZEmptyValue();
   } else {
      Node__1 = CheckType__3qe8(self.TypeChecker, Node__1, ZType__4qwz(new ZType(), 1 << 16, "void", null));
      var ResultValue = Eval__2qwk(self, Node__1);
      return ResultValue__3;
   };
}

function Eval__6qwk(self, NameSpace__1, ScriptText__2, FileName__3, LineNumber__4, IsInteractive__5) {
   var ResultValue = new ZEmptyValue();
   var TopBlockNode = ZBlockNode__2qrk(new ZBlockNode(), NameSpace__1);
   var TokenContext = ZTokenContext__6qwf(new ZTokenContext(), self.Generator, NameSpace__1, FileName__3, LineNumber__4, ScriptText__2);
   SkipEmptyStatement__1qwf(TokenContext__8);
   var SkipToken = GetToken__1qwf(TokenContext__8);
   while (HasNext__1qwf(TokenContext__8)) {
      SetParseFlag__2qwf(TokenContext__8, false);
      ClearListAfter__2quq(TopBlockNode__7, 0);
      SkipToken__9 = GetToken__1qwf(TokenContext__8);
      var ParsedNode = ParsePattern__4qwf(TokenContext__8, TopBlockNode__7, "$Statement$", true);
      if (IsErrorNode__1qwd(ParsedNode__10)) {
         SkipError__2qwf(TokenContext__8, SkipToken__9);
      };
      ResultValue__6 = Exec__3qwk(self, ParsedNode__10, IsInteractive__5);
      if (ResultValue__6 == new ZEmptyValue()) {
         break;
      };
      SkipEmptyStatement__1qwf(TokenContext__8);
      Vacume__1qwf(TokenContext__8);
   };
   if (HasNext__1qwf(TokenContext__8) && !IsInteractive__5) {
      ZLogger_LogInfo__2qwn(SkipToken__9, "stopped script at this line");
   };
   return ResultValue__6;
}

function Eval__5qwk(self, ScriptText__1, FileName__2, LineNumber__3, IsInteractive__4) {
   return Eval__6qwk(self, self.Generator.RootNameSpace, ScriptText__1, FileName__2, LineNumber__3, IsInteractive__4);
}

function Load__2qwk(self, FileName__1) {
   var ScriptText = LibZen.LoadTextFile(FileName__1);
   if (ScriptText__2 == null) {
      LibZen_Exit__2qqr(1, "file not found: " + FileName__1);
      return false;
   };
   var ResultValue = Eval__5qwk(self, ScriptText__2, FileName__1, 1, false);
   ShowErrors__1qeb(self.Logger);
   if (ResultValue__3 == new ZEmptyValue()) {
      return false;
   };
   return true;
}

function Unsupported__2qwk(self, Node__1) {
   if (self.InteractiveContext) {
      self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   } else {
      ZLogger_LogError__2qwn(Node__1.SourceToken, "unsupported at top level");
      self.StopVisitor(self);
   };
   return;
}

function VisitNullNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitBooleanNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitIntNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitFloatNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitStringNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitArrayLiteralNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitMapLiteralNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitNewObjectNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitGlobalNameNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitGetNameNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitSetNameNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitGroupNode__2qwk(self, Node__1) {
   Eval__2qwk(self, Node__1.AST[0]);
   return;
}

function VisitGetterNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitSetterNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitGetIndexNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitSetIndexNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitMacroNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitFuncCallNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitMethodCallNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitUnaryNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitNotNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitCastNode__2qwk(self, Node__1) {
   if (IsVoidType__1qwz(Node__1.Type)) {
      Eval__2qwk(self, Node__1.AST[0]);
      Node__1.Type = Node__1.AST[0].Type;
   } else {
      Unsupported__2qwk(self, Node__1);
   };
   return;
}

function VisitInstanceOfNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitBinaryNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitComparatorNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitAndNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitOrNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitBlockNode__2qwk(self, Node__1) {
   var i = 1;
   while (i__2 < GetListSize__1quq(Node__1) && self.IsVisitable(self)) {
      var StmtNode = GetListAt__2quq(Node__1, i__2);
      Eval__2qwk(self, StmtNode__3);
      if (StmtNode__3.IsBreakingBlock(StmtNode__3)) {
         break;
      };
   };
   return;
}

function VisitVarNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitIfNode__2qwk(self, Node__1) {
   var BooleanValue = Eval__2qwk(self, Node__1.AST[0]);
   if (BooleanValue__2 instanceof Boolean) {
      if (BooleanValue__2) {
         Eval__2qwk(self, Node__1.AST[1]);
      } else if (Node__1.AST[2] != null) {
         Eval__2qwk(self, Node__1.AST[1]);
      };
   };
   return;
}

function VisitReturnNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitWhileNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitBreakNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitThrowNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitTryNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitLetNode__2qwk(self, Node__1) {
   if (HasUntypedNode__1qwd(Node__1)) {
      LibZen_PrintDebug__1qqy((("HasUntypedNode: " + HasUntypedNode__1qwd(Node__1)) + "\n") + Node__1);
   };
   self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   return;
}

function VisitFunctionNode__2qwk(self, Node__1) {
   if (HasUntypedNode__1qwd(Node__1)) {
      LibZen_PrintDebug__1qqy((("HasUntypedNode: " + HasUntypedNode__1qwd(Node__1)) + "\nLAZY: ") + Node__1);
   };
   self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   return;
}

function VisitClassNode__2qwk(self, Node__1) {
   if (HasUntypedNode__1qwd(Node__1)) {
      LibZen_PrintDebug__1qqy((("HasUntypedNode: " + HasUntypedNode__1qwd(Node__1)) + "\n") + Node__1);
   };
   self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   return;
}

function VisitErrorNode__2qwk(self, Node__1) {
   ZLogger_LogError__2qwn(Node__1.SourceToken, Node__1.ErrorMessage);
   self.StopVisitor(self);
   return;
}

function VisitTypeNode__2qwk(self, Node__1) {
   Unsupported__2qwk(self, Node__1);
   return;
}

function VisitExtendedNode__2qwk(self, Node__1) {
   if (Node__1 instanceof ZTypeNode) {
      VisitTypeNode__2qwk(self, Node__1);
   } else {
      var SugarNode = Node__1.DeSugar(Node__1, self.Generator);
      SugarNode__2.Accept(SugarNode__2, self);
   };
   return;
}

function VisitSugarNode__2qwk(self, Node__1) {
   Eval__2qwk(self, Node__1.AST[0]);
   return;
}

function WriteTo__2qwk(self, OutputFile__1) {
   self.Generator.WriteTo(self.Generator, OutputFile__1);
   ShowErrors__1qeb(self.Generator.Logger);
   return;
}

function ZSourceGenerator__3qyb(self, TargetCode__1, TargetVersion__2) {
   ZGenerator__3qwh(self, TargetCode__1, TargetVersion__2);
   self.InitBuilderList(self);
   self.LineFeed = "\n";
   self.Tab = "   ";
   self.LineComment = "//";
   self.BeginComment = "/*";
   self.EndComment = "*/";
   self.Camma = ", ";
   self.SemiColon = ";";
   self.TrueLiteral = "true";
   self.FalseLiteral = "false";
   self.NullLiteral = "null";
   self.AndOperator = "&&";
   self.OrOperator = "||";
   self.NotOperator = "!";
   self.TopType = "var";
   return null;
}

function InitBuilderList__1qyb(self) {
   self.CurrentBuilder = null;
   self.BuilderList.clear(0);
   self.HeaderBuilder = AppendNewSourceBuilder__1qyb(self);
   self.CurrentBuilder = AppendNewSourceBuilder__1qyb(self);
   return;
}

function GetEngine__1qyb(self) {
   LibZen_PrintLine("FIXME: Overide GetEngine in each generator!!");
   return ZSourceEngine__3qwk(new ZSourceEngine(), ZTypeChecker__2qe8(new ZTypeChecker(), self), self);
}

function AppendNewSourceBuilder__1qyb(self) {
   var Builder = ZSourceBuilder__3qwe(new ZSourceBuilder(), self, self.CurrentBuilder);
   self.BuilderList.add(Builder__1);
   return Builder__1;
}

function InsertNewSourceBuilder__1qyb(self) {
   var Builder = ZSourceBuilder__3qwe(new ZSourceBuilder(), self, self.CurrentBuilder);
   var i = 0;
   while (i__2 < (self.BuilderList).length) {
      if (self.BuilderList[i__2] == self.CurrentBuilder) {
         self.BuilderList.add(i, Builder);
         return Builder__1;
      };
      i__2 = i__2 + 1;
   };
   self.BuilderList.add(Builder__1);
   return Builder__1;
}

function SetNativeType__3qyb(self, Type__1, TypeName__2) {
   var Key = "" + (Type__1.TypeId).toString();
   self.NativeTypeMap[Key__3] = TypeName__2;
   return;
}

function GetNativeType__2qyb(self, Type__1) {
   var Key = "" + (Type__1.TypeId).toString();
   var TypeName = self.NativeTypeMap[Key__2];
   if (TypeName__3 == null) {
      return Type__1.ShortName;
   };
   return TypeName__3;
}

function SetReservedName__3qyb(self, Keyword__1, AnotherName__2) {
   if (AnotherName__2 == null) {
      AnotherName__2 = "_" + Keyword__1;
   };
   self.ReservedNameMap[Keyword__1] = AnotherName__2;
   return;
}

function SafeName__3qyb(self, Name__1, Index__2) {
   if (Index__2 == 0) {
      var SafeName = self.ReservedNameMap[Name__1];
      if (SafeName__3 == null) {
         SafeName__3 = Name__1;
      };
      return SafeName__3;
   };
   return (Name__1 + "__") + (Index__2).toString();
}

function SetMacro__4qyb(self, FuncName__1, Macro__2, ReturnType__3) {
   var FuncType = ZTypePool_LookupFuncType__1qwz(ReturnType__3);
   SetDefinedFunc__2qwh(self, ZSourceMacro__4qud(new ZSourceMacro(), FuncName__1, FuncType__4, Macro__2));
   return;
}

function SetMacro__5qyb(self, FuncName__1, Macro__2, ReturnType__3, P1__4) {
   var FuncType = ZTypePool_LookupFuncType__2qwz(ReturnType__3, P1__4);
   SetDefinedFunc__2qwh(self, ZSourceMacro__4qud(new ZSourceMacro(), FuncName__1, FuncType__5, Macro__2));
   return;
}

function SetMacro__6qyb(self, FuncName__1, Macro__2, ReturnType__3, P1__4, P2__5) {
   var FuncType = ZTypePool_LookupFuncType__3qwz(ReturnType__3, P1__4, P2__5);
   SetDefinedFunc__2qwh(self, ZSourceMacro__4qud(new ZSourceMacro(), FuncName__1, FuncType__6, Macro__2));
   return;
}

function SetConverterMacro__4qyb(self, Macro__1, ReturnType__2, P1__3) {
   var FuncType = ZTypePool_LookupFuncType__2qwz(ReturnType__2, P1__3);
   SetConverterFunc__4qwh(self, P1__3, ReturnType__2, ZSourceMacro__4qud(new ZSourceMacro(), "to" + NameClass__2qwh(self, ReturnType__2), FuncType__4, Macro__1));
   return;
}

function WriteTo__2qyb(self, FileName__1) {
   LibZen_WriteTo__2qqy(self.NameOutputFile(self, FileName__1), self.BuilderList);
   self.InitBuilderList(self);
   return;
}

function StartCodeGeneration__3qyb(self, Node__1, IsInteractive__2) {
   Node__1.Accept(Node__1, self);
   if (IsInteractive__2) {
      var i = 0;
      LibZen_PrintLine("---");
      while (i__3 < (self.BuilderList).length) {
         var Builder = self.BuilderList[i__3];
         LibZen_PrintLine(toString__1qwe(Builder__4));
         Clear__1qwe(Builder__4);
         i__3 = i__3 + 1;
      };
      self.InitBuilderList(self);
   };
   return true;
}

function GenerateCode__3qyb(self, ContextType__1, Node__2) {
   Node__2.Accept(Node__2, self);
   return;
}

function IsNeededSurroud__2qyb(self, Node__1) {
   if (Node__1 instanceof ZBinaryNode) {
      return true;
   };
   return false;
}

function GenerateSurroundCode__2qyb(self, Node__1) {
   if (IsNeededSurroud__2qyb(self, Node__1)) {
      Append__2qwe(self.CurrentBuilder, "(");
      self.GenerateCode(self, null, Node__1);
      Append__2qwe(self.CurrentBuilder, ")");
   } else {
      self.GenerateCode(self, null, Node__1);
   };
   return;
}

function AppendCode__2qyb(self, RawSource__1) {
   Append__2qwe(self.CurrentBuilder, RawSource__1);
   return;
}

function VisitStmtList__2qyb(self, BlockNode__1) {
   var i = 0;
   while (i__2 < GetListSize__1quq(BlockNode__1)) {
      var SubNode = GetListAt__2quq(BlockNode__1, i__2);
      AppendLineFeed__1qwe(self.CurrentBuilder);
      AppendIndent__1qwe(self.CurrentBuilder);
      self.GenerateCode(self, null, SubNode__3);
      i__2 = i__2 + 1;
      if (i__2 < GetListSize__1quq(BlockNode__1)) {
         Append__2qwe(self.CurrentBuilder, self.SemiColon);
      };
   };
   return;
}

function VisitBlockNode__2qyb(self, Node__1) {
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   Append__2qwe(self.CurrentBuilder, "{");
   Indent__1qwe(self.CurrentBuilder);
   VisitStmtList__2qyb(self, Node__1);
   if (GetListSize__1quq(Node__1) > 0) {
      Append__2qwe(self.CurrentBuilder, self.SemiColon);
   };
   UnIndent__1qwe(self.CurrentBuilder);
   AppendLineFeed__1qwe(self.CurrentBuilder);
   AppendIndent__1qwe(self.CurrentBuilder);
   Append__2qwe(self.CurrentBuilder, "}");
   return;
}

function VisitNullNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, self.NullLiteral);
   return;
}

function VisitBooleanNode__2qyb(self, Node__1) {
   if (Node__1.BooleanValue) {
      Append__2qwe(self.CurrentBuilder, self.TrueLiteral);
   } else {
      Append__2qwe(self.CurrentBuilder, self.FalseLiteral);
   };
   return;
}

function VisitIntNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, LibZen.ThrowError("undefined code generation: #ZTypeNode:String").valueOf(Node.IntValue));
   return;
}

function VisitFloatNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, LibZen.ThrowError("undefined code generation: #ZTypeNode:String").valueOf(Node.FloatValue));
   return;
}

function VisitStringNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, LibZen_QuoteString__1qqy(Node__1.StringValue));
   return;
}

function VisitArrayLiteralNode__2qyb(self, Node__1) {
   VisitListNode__4qyb(self, "[", Node__1, "]");
   return;
}

function VisitMapLiteralNode__2qyb(self, Node__1) {
   return;
}

function VisitNewObjectNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "new");
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   GenerateTypeName__2qyb(self, Node__1.Type);
   VisitListNode__4qyb(self, "(", Node__1, ")");
   return;
}

function VisitGroupNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "(");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, ")");
   return;
}

function VisitGetIndexNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, "[");
   self.GenerateCode(self, null, Node__1.AST[1]);
   Append__2qwe(self.CurrentBuilder, "]");
   return;
}

function VisitSetIndexNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, "[");
   self.GenerateCode(self, null, Node__1.AST[1]);
   Append__2qwe(self.CurrentBuilder, "]");
   AppendToken__2qwe(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[2]);
   return;
}

function VisitGlobalNameNode__2qyb(self, Node__1) {
   if (IsUntyped__1qwd(Node__1)) {
      ZLogger_LogError__2qwn(Node__1.SourceToken, "undefined symbol: " + Node__1.GlobalName);
   };
   if (Node__1.IsStaticFuncName) {
      Append__2qwe(self.CurrentBuilder, StringfySignature__2qwz(Node__1.Type, Node__1.GlobalName));
   } else {
      Append__2qwe(self.CurrentBuilder, Node__1.GlobalName);
   };
   return;
}

function VisitGetNameNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, SafeName__3qyb(self, Node__1.VarName, Node__1.VarIndex));
   return;
}

function VisitSetNameNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, SafeName__3qyb(self, Node__1.VarName, Node__1.VarIndex));
   AppendToken__2qwe(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
}

function VisitGetterNode__2qyb(self, Node__1) {
   GenerateSurroundCode__2qyb(self, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, ".");
   Append__2qwe(self.CurrentBuilder, Node__1.FieldName);
   return;
}

function VisitSetterNode__2qyb(self, Node__1) {
   GenerateSurroundCode__2qyb(self, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, ".");
   Append__2qwe(self.CurrentBuilder, Node__1.FieldName);
   AppendToken__2qwe(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
}

function VisitMethodCallNode__2qyb(self, Node__1) {
   GenerateSurroundCode__2qyb(self, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, ".");
   Append__2qwe(self.CurrentBuilder, Node__1.MethodName);
   VisitListNode__4qyb(self, "(", Node__1, ")");
   return;
}

function VisitMacroNode__2qyb(self, Node__1) {
   var Macro = GetMacroText__1q0c(Node__1);
   var FuncType = GetFuncType__1q0c(Node__1);
   var fromIndex = 0;
   var BeginNum = Macro__2.indexOf("$[", fromIndex);
   while (BeginNum__5 != -1) {
      var EndNum = Macro__2.indexOf("]", BeginNum + 2);
      if (EndNum__6 == -1) {
         break;
      };
      Append__2qwe(self.CurrentBuilder, Macro__2.substring(fromIndex, BeginNum));
      var Index = LibZen_ParseInt(Macro__2.substring(BeginNum + 2, EndNum));
      if (HasAst__2qwd(Node__1, Index__7)) {
         self.GenerateCode(self, GetFuncParamType__2qw5(FuncType__3, Index__7), Node__1.AST[Index__7]);
      };
      fromIndex__4 = EndNum__6 + 1;
      BeginNum__17 = Macro__2.indexOf("$[", fromIndex);
   };
   Append__2qwe(self.CurrentBuilder, Macro__2.substring(fromIndex));
   return;
}

function VisitFuncCallNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   VisitListNode__4qyb(self, "(", Node__1, ")");
   return;
}

function VisitUnaryNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, GetText__1qwn(Node__1.SourceToken));
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
}

function VisitNotNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, self.NotOperator);
   GenerateSurroundCode__2qyb(self, Node__1.AST[0]);
   return;
}

function VisitCastNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "(");
   GenerateTypeName__2qyb(self, Node__1.Type);
   Append__2qwe(self.CurrentBuilder, ")");
   GenerateSurroundCode__2qyb(self, Node__1.AST[0]);
   return;
}

function VisitInstanceOfNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qwe(self.CurrentBuilder, "instanceof");
   GenerateTypeName__2qyb(self, Node__1.AST[1].Type);
   return;
}

function VisitBinaryNode__2qyb(self, Node__1) {
   if (Node__1.ParentNode instanceof ZBinaryNode) {
      Append__2qwe(self.CurrentBuilder, "(");
   };
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qwe(self.CurrentBuilder, GetText__1qwn(Node__1.SourceToken));
   self.GenerateCode(self, null, Node__1.AST[1]);
   if (Node__1.ParentNode instanceof ZBinaryNode) {
      Append__2qwe(self.CurrentBuilder, ")");
   };
   return;
}

function VisitComparatorNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qwe(self.CurrentBuilder, GetText__1qwn(Node__1.SourceToken));
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
}

function VisitAndNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qwe(self.CurrentBuilder, self.AndOperator);
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
}

function VisitOrNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qwe(self.CurrentBuilder, self.OrOperator);
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
}

function VisitIfNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "if (");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, ")");
   self.GenerateCode(self, null, Node__1.AST[1]);
   if (Node__1.AST[2] != null) {
      AppendToken__2qwe(self.CurrentBuilder, "else");
      self.GenerateCode(self, null, Node__1.AST[2]);
   };
   return;
}

function VisitReturnNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "return");
   if (Node__1.AST[0] != null) {
      AppendWhiteSpace__1qwe(self.CurrentBuilder);
      self.GenerateCode(self, null, Node__1.AST[0]);
   };
   return;
}

function VisitWhileNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "while (");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, ")");
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
}

function VisitBreakNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "break");
   return;
}

function VisitThrowNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "throw");
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
}

function VisitTryNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "try");
   self.GenerateCode(self, null, Node__1.AST[0]);
   if (Node__1.AST[1] != null) {
      self.GenerateCode(self, null, Node__1.AST[1]);
   };
   if (Node__1.AST[2] != null) {
      Append__2qwe(self.CurrentBuilder, "finally");
      self.GenerateCode(self, null, Node__1.AST[2]);
   };
   return;
}

function VisitCatchNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "catch (");
   Append__2qwe(self.CurrentBuilder, Node__1.ExceptionName);
   VisitTypeAnnotation__2qyb(self, Node__1.ExceptionType);
   Append__2qwe(self.CurrentBuilder, ")");
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
}

function VisitVarNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "var");
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   Append__2qwe(self.CurrentBuilder, Node__1.NativeName);
   VisitTypeAnnotation__2qyb(self, Node__1.DeclType);
   AppendToken__2qwe(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qwe(self.CurrentBuilder, self.SemiColon);
   VisitStmtList__2qyb(self, Node__1);
   return;
}

function VisitTypeAnnotation__2qyb(self, Type__1) {
   Append__2qwe(self.CurrentBuilder, ": ");
   GenerateTypeName__2qyb(self, Type__1);
   return;
}

function VisitLetNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "let");
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   Append__2qwe(self.CurrentBuilder, Node__1.GlobalName);
   AppendToken__2qwe(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
}

function VisitParamNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, SafeName__3qyb(self, Node__1.Name, Node__1.ParamIndex));
   VisitTypeAnnotation__2qyb(self, Node__1.Type);
   return;
}

function VisitFunctionNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "function");
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   if (Node__1.FuncName != null) {
      Append__2qwe(self.CurrentBuilder, Node__1.FuncName);
   };
   VisitListNode__4qyb(self, "(", Node__1, ")");
   VisitTypeAnnotation__2qyb(self, Node__1.ReturnType);
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
}

function VisitClassNode__2qyb(self, Node__1) {
   Append__2qwe(self.CurrentBuilder, "class");
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   Append__2qwe(self.CurrentBuilder, Node__1.ClassName);
   if (Node__1.SuperType != null) {
      AppendToken__2qwe(self.CurrentBuilder, "extends");
      GenerateTypeName__2qyb(self, Node__1.SuperType);
   };
   AppendWhiteSpace__1qwe(self.CurrentBuilder);
   Append__2qwe(self.CurrentBuilder, "{");
   Indent__1qwe(self.CurrentBuilder);
   var i = 0;
   while (i__2 < GetListSize__1quq(Node__1)) {
      var FieldNode = GetFieldNode__2qdu(Node__1, i__2);
      AppendLineFeed__1qwe(self.CurrentBuilder);
      AppendIndent__1qwe(self.CurrentBuilder);
      Append__2qwe(self.CurrentBuilder, "var");
      AppendWhiteSpace__1qwe(self.CurrentBuilder);
      Append__2qwe(self.CurrentBuilder, FieldNode__3.FieldName);
      VisitTypeAnnotation__2qyb(self, FieldNode__3.DeclType);
      if (HasAst__2qwd(FieldNode__3, 0)) {
         AppendToken__2qwe(self.CurrentBuilder, "=");
         self.GenerateCode(self, null, FieldNode__3.AST[0]);
      };
      Append__2qwe(self.CurrentBuilder, self.SemiColon);
      i__2 = i__2 + 1;
   };
   UnIndent__1qwe(self.CurrentBuilder);
   AppendLineFeed__1qwe(self.CurrentBuilder);
   AppendIndent__1qwe(self.CurrentBuilder);
   Append__2qwe(self.CurrentBuilder, "}");
   return;
}

function VisitErrorNode__2qyb(self, Node__1) {
   ZLogger_LogError__2qwn(Node__1.SourceToken, Node__1.ErrorMessage);
   Append__2qwe(self.CurrentBuilder, "ThrowError(");
   Append__2qwe(self.CurrentBuilder, LibZen_QuoteString__1qqy(Node__1.ErrorMessage));
   Append__2qwe(self.CurrentBuilder, ")");
   return;
}

function VisitExtendedNode__2qyb(self, Node__1) {
   if (Node__1 instanceof ZParamNode) {
      VisitParamNode__2qyb(self, Node__1);
   } else {
      var SugarNode = Node__1.DeSugar(Node__1, self);
      self.VisitSugarNode(self, SugarNode__2);
   };
   return;
}

function VisitSugarNode__2qyb(self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
}

function GenerateTypeName__2qyb(self, Type__1) {
   Append__2qwe(self.CurrentBuilder, GetNativeType__2qyb(self, Type__1.GetRealType(Type__1)));
   return;
}

function VisitListNode__5qyb(self, OpenToken__1, VargNode__2, DelimToken__3, CloseToken__4) {
   Append__2qwe(self.CurrentBuilder, OpenToken__1);
   var i = 0;
   while (i__5 < GetListSize__1quq(VargNode__2)) {
      var ParamNode = GetListAt__2quq(VargNode__2, i__5);
      if (i__5 > 0) {
         Append__2qwe(self.CurrentBuilder, DelimToken__3);
      };
      self.GenerateCode(self, null, ParamNode__6);
      i__5 = i__5 + 1;
   };
   Append__2qwe(self.CurrentBuilder, CloseToken__4);
   return;
}

function VisitListNode__4qyb(self, OpenToken__1, VargNode__2, CloseToken__3) {
   VisitListNode__5qyb(self, OpenToken__1, VargNode__2, ", ", CloseToken__3);
   return;
}

function ZTypeChecker__2qe8(self, Generator__1) {
   self.Generator = Generator__1;
   self.Logger = Generator__1.Logger;
   self.StackedContextType = null;
   self.ReturnedNode = null;
   self.StoppedVisitor = false;
   self.VarScope = ZVarScope__4qev(new ZVarScope(), null, self.Logger, null);
   return null;
}

function EnableVisitor__1qe8(self) {
   self.StoppedVisitor = false;
   return;
}

function StopVisitor__1qe8(self) {
   self.StoppedVisitor = true;
   return;
}

function IsVisitable__1qe8(self) {
   return !self.StoppedVisitor;
}

function GetContextType__1qe8(self) {
   return self.StackedContextType;
}

function VisitTypeChecker__3qe8(self, Node__1, ContextType__2) {
   var ParentNode = Node__1.ParentNode;
   self.StackedContextType = ContextType__2;
   self.ReturnedNode = null;
   Node__1.Accept(Node__1, self);
   if (self.ReturnedNode == null) {
      LibZen_PrintDebug__1qqy("!! returns no value: " + Node__1);
   } else {
      Node__1 = self.ReturnedNode;
   };
   if (ParentNode__3 != Node__1.ParentNode && ParentNode__3 != null) {
      SetChild__2qwd(ParentNode__3, Node__1);
   };
   CheckVarNode__3qev(self.VarScope, ContextType__2, Node__1);
   return Node__1;
}

function CreateStupidCastNode__3qe8(self, Requested__1, Node__2) {
   var ErrorNode = ZStupidCastErrorNode__3q45(new ZStupidCastErrorNode(), Node__2, (("type error: requested = " + Requested__1) + ", given = ") + Node__2.Type);
   ErrorNode__3.Type = Requested__1;
   return ErrorNode__3;
}

function EnforceNodeType__3qe8(self, Node__1, EnforceType__2) {
   var Func = GetConverterFunc__3qwh(self.Generator, Node__1.Type, ZType__4qwz(new ZType(), 1 << 16, "String", ZType__4qwz(new ZType(), 1 << 16, "var", null)));
   if (Func__3 instanceof ZMacroFunc) {
      var MacroNode = ZMacroNode__4q0c(new ZMacroNode(), Node__1.ParentNode, null, Func__3);
      Append__2quq(MacroNode__4, Node__1);
      MacroNode__4.Type = EnforceType__2;
      return MacroNode__4;
   } else if (Func__3 != null) {
      var MacroNode = ZFuncCallNode__4q4y(new ZFuncCallNode(), Node__1.ParentNode, Func__3.FuncName, GetFuncType__1qw7(Func__3));
      Append__2quq(MacroNode__5, Node__1);
      MacroNode__5.Type = EnforceType__2;
      return MacroNode__5;
   };
   return CreateStupidCastNode__3qe8(self, EnforceType__2, Node__1);
}

function TypeCheckImpl__4qe8(self, Node__1, ContextType__2, TypeCheckPolicy__3) {
   if (IsErrorNode__1qwd(Node__1)) {
      if (!ContextType__2.IsVarType(ContextType__2)) {
         Node__1.Type = ContextType__2;
      };
      return Node__1;
   };
   if (IsUntyped__1qwd(Node__1) || ContextType__2.IsVarType(ContextType__2) || LibZen_IsFlag__2qqr(TypeCheckPolicy__3, _NoCheckPolicy)) {
      return Node__1;
   };
   if (Node__1.Type == ContextType__2 || Accept__2qwz(ContextType__2, Node__1.Type)) {
      return Node__1;
   };
   if (IsVoidType__1qwz(ContextType__2) && !IsVoidType__1qwz(Node__1.Type)) {
      return ZCastNode__4qov(new ZCastNode(), Node__1.ParentNode, ZType__4qwz(new ZType(), 1 << 16, "void", null), Node__1);
   };
   if (IsFloatType__1qwz(ContextType__2) && IsIntType__1qwz(Node__1.Type)) {
      return EnforceNodeType__3qe8(self, Node__1, ContextType__2);
   };
   if (IsIntType__1qwz(ContextType__2) && IsFloatType__1qwz(Node__1.Type)) {
      return EnforceNodeType__3qe8(self, Node__1, ContextType__2);
   };
   return CreateStupidCastNode__3qe8(self, ContextType__2, Node__1);
}

function VisitTypeChecker__4qe8(self, Node__1, ContextType__2, TypeCheckPolicy__3) {
   if (self.IsVisitable(self) && Node__1 != null) {
      if (HasUntypedNode__1qwd(Node__1)) {
         Node__1 = VisitTypeChecker__3qwd(Node__1, self, ContextType__2);
      };
      Node__1 = TypeCheckImpl__4qe8(self, Node__1, ContextType__2, TypeCheckPolicy__3);
      CheckVarNode__3qev(self.VarScope, ContextType__2, Node__1);
   };
   self.ReturnedNode = null;
   return Node__1;
}

function TryType__3qe8(self, Node__1, ContextType__2) {
   return VisitTypeChecker__4qe8(self, Node__1, ContextType__2, _NoCheckPolicy);
}

function TryTypeAt__4qe8(self, Node__1, Index__2, ContextType__3) {
   Set__3qwd(Node__1, Index__2, VisitTypeChecker__4qe8(self, Node__1.AST[Index__2], ContextType__3, _NoCheckPolicy));
   return;
}

function CheckType__3qe8(self, Node__1, ContextType__2) {
   return VisitTypeChecker__4qe8(self, Node__1, ContextType__2, _DefaultTypeCheckPolicy);
}

function CheckTypeAt__4qe8(self, Node__1, Index__2, ContextType__3) {
   Set__3qwd(Node__1, Index__2, VisitTypeChecker__4qe8(self, Node__1.AST[Index__2], ContextType__3, _DefaultTypeCheckPolicy));
   return;
}

function TypeCheckNodeList__2qe8(self, List__1) {
   if (self.IsVisitable(self)) {
      var AllTyped = true;
      var i = 0;
      while (i__3 < GetListSize__1quq(List__1)) {
         var SubNode = GetListAt__2quq(List__1, i__3);
         SubNode__4 = CheckType__3qe8(self, SubNode__4, ZType__4qwz(new ZType(), 1 << 16, "var", null));
         SetListAt__3quq(List__1, i__3, SubNode__4);
         if (IsUntyped__1qwd(SubNode__4)) {
            AllTyped__2 = false;
         };
         i__3 = i__3 + 1;
      };
      return AllTyped__2;
   };
   return false;
}

function Return__2qe8(self, Node__1) {
   if (self.ReturnedNode != null) {
      LibZen_PrintDebug__1qqy("previous returned node " + Node__1);
   };
   self.ReturnedNode = Node__1;
   return;
}

function TypedNode__3qe8(self, Node__1, Type__2) {
   Node__1.Type = Type__2.GetRealType(Type__2);
   if (self.ReturnedNode != null) {
      LibZen_PrintDebug__1qqy("previous returned node " + Node__1);
   };
   self.ReturnedNode = Node__1;
   return;
}

function ReturnErrorNode__4qe8(self, Node__1, ErrorToken__2, Message__3) {
   if (ErrorToken__2 == null) {
      ErrorToken__2 = Node__1.SourceToken;
   };
   Return__2qe8(self, ZErrorNode__4qpu(new ZErrorNode(), Node__1.ParentNode, ErrorToken__2, Message__3));
   return;
}

function VisitErrorNode__2qe8(self, Node__1) {
   var ContextType = GetContextType__1qe8(self);
   if (!ContextType__2.IsVarType(ContextType__2)) {
      TypedNode__3qe8(self, Node__1, ContextType__2);
   } else {
      Return__2qe8(self, Node__1);
   };
   return;
}

function VisitExtendedNode__2qe8(self, Node__1) {
   var ContextType = GetContextType__1qe8(self);
   var DeNode = Node__1.DeSugar(Node__1, self.Generator);
   if (!IsErrorNode__1qwd(DeNode__3)) {
      Return__2qe8(self, CheckType__3qe8(self, DeNode__3, ContextType__2));
   } else {
      TypedNode__3qe8(self, DeNode__3, ContextType__2);
   };
   return;
}

function VisitSugarNode__2qe8(self, Node__1) {
   var ContextType = GetContextType__1qe8(self);
   CheckTypeAt__4qe8(self, Node__1, 0, ContextType__2);
   TypedNode__3qe8(self, Node__1, GetAstType__2qwd(Node__1, 0));
   return;
}

function ZArrayType__3qgg(self, TypeFlag__1, ParamType__2) {
   ZGeneric1Type__5qi7(self, TypeFlag__1, ParamType__2 + "[]", ZGeneric1Type__5qi7(new ZGeneric1Type(), 1 << 16, "Array", null, ZType__4qwz(new ZType(), 1 << 16, "var", null)), ParamType__2);
   return null;
}

function ZAndNode__5qsb(self, ParentNode__1, Token__2, Left__3, Pattern__4) {
   ZBinaryNode__5qoh(self, ParentNode__1, Token__2, Left__3, Pattern__4);
   return null;
}

function Accept__2qsb(self, Visitor__1) {
   Visitor__1.VisitAndNode(Visitor__1, self);
   return;
}

function ZArrayLiteralNode__2qsi(self, ParentNode__1) {
   ZListNode__4quq(self, ParentNode__1, null, 0);
   return null;
}

function Accept__2qsi(self, Visitor__1) {
   Visitor__1.VisitArrayLiteralNode(Visitor__1, self);
   return;
}

function ZBlockNode__2qrk(self, NameSpace__1) {
   ZListNode__4quq(self, null, null, 0);
   self.NameSpace = NameSpace__1;
   return null;
}

function ZBlockNode__3qrk(self, ParentNode__1, Init__2) {
   ZListNode__4quq(self, ParentNode__1, null, Init__2);
   self.NameSpace = CreateSubNameSpace__1qwo(GetNameSpace__1qwd(ParentNode__1));
   return null;
}

function Accept__2qrk(self, Visitor__1) {
   Visitor__1.VisitBlockNode(Visitor__1, self);
   return;
}

function ToReturnNode__1qrk(self) {
   if (GetListSize__1quq(self) == 1) {
      return ToReturnNode__1qwd(GetListAt__2quq(self, 0));
   };
   return null;
}

function IndexOf__2qrk(self, ChildNode__1) {
   var i = 0;
   while (i__2 < GetListSize__1quq(self)) {
      if (GetListAt__2quq(self, i__2) == ChildNode__1) {
         return i__2;
      };
      i__2 = i__2 + 1;
   };
   return -1;
}

function CopyTo__3qrk(self, Index__1, BlockNode__2) {
   var i = Index__1;
   while (i__3 < GetListSize__1quq(self)) {
      Append__2quq(BlockNode__2, GetListAt__2quq(self, i__3));
      i__3 = i__3 + 1;
   };
   return;
}

function ZBooleanNode__4qse(self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qpe(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwz(new ZType(), 1 << 16, "boolean", ZType__4qwz(new ZType(), 1 << 16, "var", null));
   self.BooleanValue = Value__3;
   return null;
}

function Accept__2qse(self, Visitor__1) {
   Visitor__1.VisitBooleanNode(Visitor__1, self);
   return;
}

function ZClassNode__2qdu(self, ParentNode__1) {
   ZListNode__4quq(self, ParentNode__1, null, 0);
   return null;
}

function SetTypeInfo__3qdu(self, TypeToken__1, Type__2) {
   self.SuperType = Type__2;
   self.SuperToken = TypeToken__1;
   return;
}

function SetNameInfo__3qdu(self, NameToken__1, Name__2) {
   self.ClassName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function GetFieldNode__2qdu(self, Index__1) {
   var Node = GetListAt__2quq(self, Index__1);
   if (Node__2 instanceof ZFieldNode) {
      return Node__2;
   };
   return null;
}

function Accept__2qdu(self, Visitor__1) {
   Visitor__1.VisitClassNode(Visitor__1, self);
   return;
}

function ZFuncCallNode__3q4y(self, ParentNode__1, FuncNode__2) {
   ZListNode__4quq(self, ParentNode__1, null, 1);
   Set__3qwd(self, 0, FuncNode__2);
   return null;
}

function ZFuncCallNode__4q4y(self, ParentNode__1, FuncName__2, FuncType__3) {
   ZListNode__4quq(self, ParentNode__1, null, 1);
   var FuncNode = ZGlobalNameNode__6qpm(new ZGlobalNameNode(), self, null, FuncType__3, FuncName__2, true);
   Set__3qwd(self, 0, FuncNode__4);
   return null;
}

function Accept__2q4y(self, Visitor__1) {
   Visitor__1.VisitFuncCallNode(Visitor__1, self);
   return;
}

function GetRecvType__1q4y(self) {
   if (GetListSize__1quq(self) > 0) {
      return GetListAt__2quq(self, 0).Type.GetRealType(GetListAt__2quq(self, 0).Type);
   };
   return ZType__4qwz(new ZType(), 1 << 16, "void", null);
}

function GetFuncName__1q4y(self) {
   var FNode = self.AST[0];
   if (FNode__1 instanceof ZGlobalNameNode) {
      return (FNode__1).GlobalName;
   };
   return null;
}

function GetFuncType__1q4y(self) {
   var FType = self.AST[0].Type;
   if (FType__1 instanceof ZFuncType) {
      return FType__1;
   };
   return null;
}

function ToMacroNode__2q4y(self, MacroFunc__1) {
   var MacroNode = ZMacroNode__4q0c(new ZMacroNode(), self.ParentNode, self.AST[0].SourceToken, MacroFunc__1);
   var i = 0;
   while (i__3 < GetListSize__1quq(self)) {
      Append__2quq(MacroNode__2, GetListAt__2quq(self, i__3));
      i__3 = i__3 + 1;
   };
   return MacroNode__2;
}

function ZFunctionNode__2qre(self, ParentNode__1) {
   ZListNode__4quq(self, ParentNode__1, null, 1);
   return null;
}

function SetTypeInfo__3qre(self, TypeToken__1, Type__2) {
   self.ReturnType = Type__2;
   return;
}

function SetNameInfo__3qre(self, NameToken__1, Name__2) {
   self.FuncName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function Accept__2qre(self, Visitor__1) {
   Visitor__1.VisitFunctionNode(Visitor__1, self);
   return;
}

function GetParamNode__2qre(self, Index__1) {
   var Node = GetListAt__2quq(self, Index__1);
   if (Node__2 instanceof ZParamNode) {
      return Node__2;
   };
   return null;
}

function GetFuncType__2qre(self, ContextType__1) {
   if (self.ResolvedFuncType == null) {
      var FuncType = null;
      if (ContextType__1 instanceof ZFuncType) {
         FuncType__2 = ContextType__1;
      };
      var TypeList = [];
      if (self.ReturnType.IsVarType(self.ReturnType) && FuncType__2 != null) {
         self.ReturnType = FuncType__2.GetParamType(FuncType__2, 0);
      };
      TypeList__3.add(self.ReturnType.GetRealType(self.ReturnType));
      var i = 0;
      while (i__4 < GetListSize__1quq(self)) {
         var Node = GetParamNode__2qre(self, i__4);
         var ParamType = Node__5.Type.GetRealType(Node__5.Type);
         if (ParamType__6.IsVarType(ParamType__6) && FuncType__2 != null) {
            ParamType__11 = FuncType__2.GetParamType(FuncType__2, i__4 + 1);
         };
         TypeList__3.add(ParamType__6);
         i__4 = i__4 + 1;
      };
      FuncType__2 = ZTypePool_LookupFuncType__1qwx(TypeList__3);
      if (!FuncType__2.IsVarType(FuncType__2)) {
         self.ResolvedFuncType = FuncType__2;
      };
      return FuncType__2;
   };
   return self.ResolvedFuncType;
}

function GetSignature__2qre(self, Generator__1) {
   var FuncType = GetFuncType__2qre(self, null);
   if (self.FuncName == null) {
      self.FuncName = "f_Z" + (GetUniqueNumber__1qwh(Generator__1)).toString();
   };
   return StringfySignature__2qw5(FuncType__2, self.FuncName);
}

function Push__2qre(self, Parent__1) {
   self.ParentFunctionNode = Parent__1;
   return self;
}

function Pop__1qre(self) {
   return self.ParentFunctionNode;
}

function IsTopLevel__1qre(self) {
   return self.ParentFunctionNode == null;
}

function GetVarIndex__1qre(self) {
   var Index = self.VarIndex;
   self.VarIndex = self.VarIndex + 1;
   return Index__1;
}

function ZVarNode__2qs5(self, ParentNode__1) {
   ZBlockNode__3qrk(self, ParentNode__1, 1);
   return null;
}

function SetNameInfo__3qs5(self, NameToken__1, Name__2) {
   self.NativeName = Name__2;
   self.NameToken = NameToken__1;
   return;
}

function SetTypeInfo__3qs5(self, TypeToken__1, Type__2) {
   self.DeclType = Type__2;
   self.TypeToken = TypeToken__1;
   return;
}

function Accept__2qs5(self, Visitor__1) {
   Visitor__1.VisitVarNode(Visitor__1, self);
   return;
}

function AndPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var BinaryNode = ZAndNode__5qsb(new ZAndNode(), ParentNode, GetToken__2qwf(TokenContext__1, true), LeftNode__2, GetApplyingSyntax__1qwf(TokenContext__1));
   return AppendParsedRightNode__3qoh(BinaryNode__3, ParentNode, TokenContext__1);
}

function AnnotationPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   return null;
}

function ApplyPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var ApplyNode = ZFuncCallNode__3q4y(new ZFuncCallNode(), ParentNode, LeftNode__2);
   ApplyNode__3 = MatchNtimes__6qwf(TokenContext__1, ApplyNode__3, "(", "$Expression$", ",", ")");
   return ApplyNode__3;
}

function ArrayLiteralPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode = ZArrayLiteralNode__2qsi(new ZArrayLiteralNode(), ParentNode);
   LiteralNode__3 = MatchNtimes__6qwf(TokenContext__1, LiteralNode__3, "[", "$Expression$", ",", "]");
   return LiteralNode__3;
}

function AssertPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var AssertNode = ZAssertNode__2qod(new ZAssertNode(), ParentNode);
   AssertNode__3 = MatchToken__4qwf(TokenContext__1, AssertNode__3, "assert", true);
   AssertNode__3 = MatchToken__4qwf(TokenContext__1, AssertNode__3, "(", true);
   AssertNode__3 = MatchPattern__6qwf(TokenContext__1, AssertNode__3, 0, "$Expression$", true, true);
   AssertNode__3 = MatchToken__4qwf(TokenContext__1, AssertNode__3, ")", true);
   return AssertNode__3;
}

function AssignPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   return null;
}

function BinaryPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Token = GetToken__2qwf(TokenContext__1, true);
   var BinaryNode = ZBinaryNode__5qoh(new ZBinaryNode(), ParentNode, Token__3, LeftNode__2, GetApplyingSyntax__1qwf(TokenContext__1));
   return AppendParsedRightNode__3qoh(BinaryNode__4, ParentNode, TokenContext__1);
}

function BlockComment__1qw4(SourceContext) {
   var StartIndex = GetPosition__1qw4(SourceContext);
   var NextChar = GetCharAtFromCurrentPosition__2qw4(SourceContext, +1);
   if (NextChar__2 != "/" && NextChar__2 != "*") {
      return false;
   };
   if (NextChar__2 == "/") {
      while (HasChar__1qw4(SourceContext)) {
         var ch = GetCurrentChar__1qw4(SourceContext);
         if (ch__3 == "\n") {
            break;
         };
         MoveNext__1qw4(SourceContext);
      };
      return true;
   };
   var NestedLevel = 0;
   var PrevChar = "0";
   while (HasChar__1qw4(SourceContext)) {
      NextChar__2 = GetCurrentChar__1qw4(SourceContext);
      if (PrevChar__5 == "*" && NextChar__2 == "/") {
         NestedLevel__4 = NestedLevel__4 - 1;
         if (NestedLevel__4 == 0) {
            MoveNext__1qw4(SourceContext);
            return true;
         };
      };
      if (PrevChar__5 == "/" && NextChar__2 == "*") {
         NestedLevel__4 = NestedLevel__4 + 1;
      };
      MoveNext__1qw4(SourceContext);
      PrevChar__5 = NextChar__2;
   };
   LogWarning__3qw4(SourceContext, StartIndex__1, "unfound */");
   return true;
}

function BlockPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var BlockNode = ZBlockNode__3qrk(new ZBlockNode(), ParentNode, 0);
   var SkipToken = GetToken__1qwf(TokenContext__1);
   BlockNode__3 = MatchToken__4qwf(TokenContext__1, BlockNode__3, "{", true);
   if (!IsErrorNode__1qwd(BlockNode__3)) {
      var Remembered = SetParseFlag__2qwf(TokenContext__1, true);
      var NestedBlockNode = BlockNode__3;
      while (HasNext__1qwf(TokenContext__1)) {
         if (MatchToken__2qwf(TokenContext__1, "}")) {
            break;
         };
         NestedBlockNode__6 = MatchPattern__5qwf(TokenContext__1, NestedBlockNode__6, -5, "$Statement$", true);
         if (IsErrorNode__1qwd(NestedBlockNode__6)) {
            SkipError__2qwf(TokenContext__1, SkipToken__4);
            MatchToken__2qwf(TokenContext__1, "}");
            break;
         };
      };
      SetParseFlag__2qwf(TokenContext__1, Remembered__5);
   };
   return BlockNode__3;
}

function BreakPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var BreakNode = ZBreakNode__2qoz(new ZBreakNode(), ParentNode);
   BreakNode__3 = MatchToken__4qwf(TokenContext__1, BreakNode__3, "break", true);
   return BreakNode__3;
}

function CLineComment__1qw4(SourceContext) {
   return false;
}

function CastPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var CastNode = ZCastNode__4qov(new ZCastNode(), ParentNode, ZType__4qwz(new ZType(), 1 << 16, "var", null), null);
   CastNode__3 = MatchToken__4qwf(TokenContext__1, CastNode__3, "(", true);
   CastNode__3 = MatchPattern__5qwf(TokenContext__1, CastNode__3, -3, "$Type$", true);
   CastNode__3 = MatchToken__4qwf(TokenContext__1, CastNode__3, ")", true);
   CastNode__3 = MatchPattern__5qwf(TokenContext__1, CastNode__3, 0, "$RightExpression$", true);
   return CastNode__3;
}

function CatchPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var CatchNode = ZCatchNode__2qo7(new ZCatchNode(), ParentNode);
   CatchNode__3 = MatchToken__4qwf(TokenContext__1, CatchNode__3, "catch", true);
   CatchNode__3 = MatchToken__4qwf(TokenContext__1, CatchNode__3, "(", true);
   CatchNode__3 = MatchPattern__5qwf(TokenContext__1, CatchNode__3, -2, "$Name$", true);
   CatchNode__3 = MatchToken__4qwf(TokenContext__1, CatchNode__3, ")", true);
   CatchNode__3 = MatchPattern__5qwf(TokenContext__1, CatchNode__3, 0, "$Block$", true);
   return CatchNode__3;
}

function ClassPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var ClassNode = ZClassNode__2qdu(new ZClassNode(), ParentNode);
   ClassNode__3 = MatchToken__4qwf(TokenContext__1, ClassNode__3, "class", true);
   ClassNode__3 = MatchPattern__5qwf(TokenContext__1, ClassNode__3, -2, "$Name$", true);
   if (MatchNewLineToken__2qwf(TokenContext__1, "extends")) {
      ClassNode__3 = MatchPattern__5qwf(TokenContext__1, ClassNode__3, -3, "$Type$", true);
   };
   ClassNode__3 = MatchNtimes__6qwf(TokenContext__1, ClassNode__3, "{", "$FieldDecl$", null, "}");
   return ClassNode__3;
}

function ComparatorPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Token = GetToken__2qwf(TokenContext__1, true);
   var BinaryNode = ZComparatorNode__5qo8(new ZComparatorNode(), ParentNode, Token__3, LeftNode__2, GetApplyingSyntax__1qwf(TokenContext__1));
   return AppendParsedRightNode__3qoh(BinaryNode__4, ParentNode, TokenContext__1);
}

function ExpressionPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   return ExpressionPattern_DispatchPattern__5qwd(ParentNode, TokenContext__1, LeftNode__2, false, true);
}

function FalsePattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   return ZBooleanNode__4qse(new ZBooleanNode(), ParentNode, GetToken__2qwf(TokenContext__1, true), false);
}

function FieldPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Rememberd = SetParseFlag__2qwf(TokenContext__1, false);
   var FieldNode = ZFieldNode__2qp0(new ZFieldNode(), ParentNode);
   FieldNode__4 = MatchToken__4qwf(TokenContext__1, FieldNode__4, "var", true);
   FieldNode__4 = MatchPattern__5qwf(TokenContext__1, FieldNode__4, -2, "$Name$", true);
   FieldNode__4 = MatchPattern__5qwf(TokenContext__1, FieldNode__4, -3, "$TypeAnnotation$", false);
   if (MatchToken__2qwf(TokenContext__1, "=")) {
      FieldNode__4 = MatchPattern__5qwf(TokenContext__1, FieldNode__4, 0, "$Expression$", true);
   };
   FieldNode__4 = MatchPattern__5qwf(TokenContext__1, FieldNode__4, -1, ";", true);
   SetParseFlag__2qwf(TokenContext__1, Rememberd__3);
   return FieldNode__4;
}

function FloatLiteralPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Token = GetToken__2qwf(TokenContext__1, true);
   return ZFloatNode__4qpd(new ZFloatNode(), ParentNode, Token__3, LibZen_ParseFloat__1qqy(GetText__1qwn(Token__3)));
}

function FunctionPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var FuncNode = ZFunctionNode__2qre(new ZFunctionNode(), ParentNode);
   FuncNode__3 = MatchToken__4qwf(TokenContext__1, FuncNode__3, "function", true);
   FuncNode__3 = MatchPattern__5qwf(TokenContext__1, FuncNode__3, -2, "$Name$", false);
   FuncNode__3 = MatchNtimes__6qwf(TokenContext__1, FuncNode__3, "(", "$Param$", ",", ")");
   FuncNode__3 = MatchPattern__5qwf(TokenContext__1, FuncNode__3, -3, "$TypeAnnotation$", false);
   FuncNode__3 = MatchPattern__5qwf(TokenContext__1, FuncNode__3, 0, "$Block$", true);
   return FuncNode__3;
}

function GetIndexPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var IndexerNode = ZGetIndexNode__3qph(new ZGetIndexNode(), ParentNode, LeftNode__2);
   IndexerNode__3 = MatchToken__4qwf(TokenContext__1, IndexerNode__3, "[", true);
   IndexerNode__3 = MatchPattern__6qwf(TokenContext__1, IndexerNode__3, 1, "$Expression$", true, true);
   IndexerNode__3 = MatchToken__4qwf(TokenContext__1, IndexerNode__3, "]", true);
   return IndexerNode__3;
}

function GetterPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var GetterNode = ZGetterNode__3qpx(new ZGetterNode(), ParentNode, LeftNode__2);
   GetterNode__3 = MatchToken__4qwf(TokenContext__1, GetterNode__3, ".", true);
   GetterNode__3 = MatchPattern__5qwf(TokenContext__1, GetterNode__3, -2, "$Name$", true);
   return GetterNode__3;
}

function GroupPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var GroupNode = ZGroupNode__2qp2(new ZGroupNode(), ParentNode);
   GroupNode__3 = MatchToken__4qwf(TokenContext__1, GroupNode__3, "(", true);
   GroupNode__3 = MatchPattern__6qwf(TokenContext__1, GroupNode__3, 0, "$Expression$", true, true);
   GroupNode__3 = MatchToken__4qwf(TokenContext__1, GroupNode__3, ")", true);
   return GroupNode__3;
}

function IfPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var IfNode = ZIfNode__2q0w(new ZIfNode(), ParentNode);
   IfNode__3 = MatchToken__4qwf(TokenContext__1, IfNode__3, "if", true);
   IfNode__3 = MatchToken__4qwf(TokenContext__1, IfNode__3, "(", true);
   IfNode__3 = MatchPattern__6qwf(TokenContext__1, IfNode__3, 0, "$Expression$", true, true);
   IfNode__3 = MatchToken__4qwf(TokenContext__1, IfNode__3, ")", true);
   IfNode__3 = MatchPattern__5qwf(TokenContext__1, IfNode__3, 1, "$Block$", true);
   if (MatchNewLineToken__2qwf(TokenContext__1, "else")) {
      var PatternName = "$Block$";
      if (IsNewLineToken__2qwf(TokenContext__1, "if")) {
         PatternName__4 = "if";
      };
      IfNode__3 = MatchPattern__5qwf(TokenContext__1, IfNode__3, 2, PatternName__4, true);
   };
   return IfNode__3;
}

function InstanceOfPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var BinaryNode = ZInstanceOfNode__4q0i(new ZInstanceOfNode(), ParentNode, GetToken__2qwf(TokenContext__1, true), LeftNode__2);
   BinaryNode__3 = MatchPattern__5qwf(TokenContext__1, BinaryNode__3, -3, "$Type$", true);
   return BinaryNode__3;
}

function IntLiteralPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Token = GetToken__2qwf(TokenContext__1, true);
   return ZIntNode__4q04(new ZIntNode(), ParentNode, Token__3, LibZen_ParseInt__1qqy(GetText__1qwn(Token__3)));
}

function LetPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var LetNode = ZLetNode__2q0d(new ZLetNode(), ParentNode);
   LetNode__3 = MatchToken__4qwf(TokenContext__1, LetNode__3, "let", true);
   LetNode__3 = MatchPattern__5qwf(TokenContext__1, LetNode__3, -2, "$Name$", true);
   LetNode__3 = MatchPattern__5qwf(TokenContext__1, LetNode__3, -3, "$TypeAnnotation$", false);
   LetNode__3 = MatchToken__4qwf(TokenContext__1, LetNode__3, "=", true);
   LetNode__3 = MatchPattern__5qwf(TokenContext__1, LetNode__3, 0, "$Expression$", true);
   return LetNode__3;
}

function MapEntryPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode = ZMapEntryNode__2q07(new ZMapEntryNode(), ParentNode);
   LiteralNode__3 = MatchPattern__5qwf(TokenContext__1, LiteralNode__3, 0, "$Expression$", true);
   LiteralNode__3 = MatchToken__4qwf(TokenContext__1, LiteralNode__3, ":", true);
   LiteralNode__3 = MatchPattern__5qwf(TokenContext__1, LiteralNode__3, 1, "$Expression$", true);
   return LiteralNode__3;
}

function MapLiteralPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode = ZMapLiteralNode__2q03(new ZMapLiteralNode(), ParentNode);
   LiteralNode__3 = MatchNtimes__6qwf(TokenContext__1, LiteralNode__3, "{", "$MapEntry$", ",", "}");
   return LiteralNode__3;
}

function MethodCallPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var MethodCallNode = ZMethodCallNode__3q4w(new ZMethodCallNode(), ParentNode, LeftNode__2);
   MethodCallNode__3 = MatchToken__4qwf(TokenContext__1, MethodCallNode__3, ".", true);
   MethodCallNode__3 = MatchPattern__5qwf(TokenContext__1, MethodCallNode__3, -2, "$Name$", true);
   MethodCallNode__3 = MatchNtimes__6qwf(TokenContext__1, MethodCallNode__3, "(", "$Expression$", ",", ")");
   return MethodCallNode__3;
}

function NamePattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Token = GetToken__2qwf(TokenContext__1, true);
   if (LibZen_IsSymbol__1qqy(GetChar__1qwn(Token__3))) {
      return ZGetNameNode__4qpl(new ZGetNameNode(), ParentNode, Token__3, GetText__1qwn(Token__3));
   };
   return ZErrorNode__4qpu(new ZErrorNode(), ParentNode, Token__3, ("illegal name: \"" + GetText__1qwn(Token__3)) + "\"");
}

function NameToken__1qw4(SourceContext) {
   var StartIndex = GetPosition__1qw4(SourceContext);
   while (HasChar__1qw4(SourceContext)) {
      var ch = GetCurrentChar__1qw4(SourceContext);
      if (!LibZen_IsSymbol__1qqy(ch__2) && !LibZen_IsDigit__1qqy(ch__2)) {
         break;
      };
      MoveNext__1qw4(SourceContext);
   };
   Tokenize__3qw4(SourceContext, StartIndex__1, GetPosition__1qw4(SourceContext));
   return true;
}

function NewLineToken__1qw4(SourceContext) {
   var StartIndex = GetPosition__1qw4(SourceContext) + 1;
   MoveNext__1qw4(SourceContext);
   SkipWhiteSpace__1qw4(SourceContext);
   FoundIndent__3qw4(SourceContext, StartIndex__1, GetPosition__1qw4(SourceContext));
   return true;
}

function NewObjectPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode = ZNewObjectNode__2q40(new ZNewObjectNode(), ParentNode);
   LiteralNode__3 = MatchToken__4qwf(TokenContext__1, LiteralNode__3, "new", true);
   LiteralNode__3 = MatchPattern__5qwf(TokenContext__1, LiteralNode__3, -3, "$Type$", false);
   LiteralNode__3 = MatchNtimes__6qwf(TokenContext__1, LiteralNode__3, "(", "$Expression$", ",", ")");
   return LiteralNode__3;
}

function NotPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var UnaryNode = ZNotNode__3q4d(new ZNotNode(), ParentNode, GetToken__2qwf(TokenContext__1, true));
   UnaryNode__3 = MatchPattern__5qwf(TokenContext__1, UnaryNode__3, 0, "$RightExpression$", true);
   return UnaryNode__3;
}

function NullPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   return ZNullNode__3q4h(new ZNullNode(), ParentNode, GetToken__2qwf(TokenContext__1, true));
}

function NumberLiteralToken__1qw4(SourceContext) {
   var StartIndex = GetPosition__1qw4(SourceContext);
   var ch = NumberLiteralToken_ParseDigit__1qw4(SourceContext);
   if (ch__2 == ".") {
      MoveNext__1qw4(SourceContext);
      ch__2 = NumberLiteralToken_ParseDigit__1qw4(SourceContext);
      if (ch__2 == "e" || ch__2 == "E") {
         MoveNext__1qw4(SourceContext);
         if (HasChar__1qw4(SourceContext)) {
            ch__2 = GetCurrentChar__1qw4(SourceContext);
            if (ch__2 == "+" || ch__2 == "-") {
               MoveNext__1qw4(SourceContext);
            };
         };
         NumberLiteralToken_ParseDigit__1qw4(SourceContext);
      };
      Tokenize__4qw4(SourceContext, "$FloatLiteral$", StartIndex__1, GetPosition__1qw4(SourceContext));
   } else {
      Tokenize__4qw4(SourceContext, "$IntegerLiteral$", StartIndex__1, GetPosition__1qw4(SourceContext));
   };
   return true;
}

function OperatorToken__1qw4(SourceContext) {
   TokenizeDefinedSymbol__2qw4(SourceContext, GetPosition__1qw4(SourceContext));
   return true;
}

function OrPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var BinaryNode = ZOrNode__5q4l(new ZOrNode(), ParentNode, GetToken__2qwf(TokenContext__1, true), LeftNode__2, GetApplyingSyntax__1qwf(TokenContext__1));
   return AppendParsedRightNode__3qoh(BinaryNode__3, ParentNode, TokenContext__1);
}

function ParamPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var ParamNode = ZParamNode__2qrm(new ZParamNode(), ParentNode);
   ParamNode__3 = MatchPattern__5qwf(TokenContext__1, ParamNode__3, -2, "$Name$", true);
   ParamNode__3 = MatchPattern__5qwf(TokenContext__1, ParamNode__3, -3, "$TypeAnnotation$", false);
   return ParamNode__3;
}

function PrototypePattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var FuncNode = ZPrototypeNode__2q46(new ZPrototypeNode(), ParentNode);
   FuncNode__3 = MatchToken__4qwf(TokenContext__1, FuncNode__3, "function", true);
   FuncNode__3 = MatchPattern__5qwf(TokenContext__1, FuncNode__3, -2, "$Name$", true);
   FuncNode__3 = MatchNtimes__6qwf(TokenContext__1, FuncNode__3, "(", "$Param$", ",", ")");
   FuncNode__3 = MatchPattern__5qwf(TokenContext__1, FuncNode__3, -3, "$TypeAnnotation$", true);
   return FuncNode__3;
}

function ReturnPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var ReturnNode = ZReturnNode__2qrb(new ZReturnNode(), ParentNode);
   ReturnNode__3 = MatchToken__4qwf(TokenContext__1, ReturnNode__3, "return", true);
   ReturnNode__3 = MatchPattern__5qwf(TokenContext__1, ReturnNode__3, 0, "$Expression$", false);
   return ReturnNode__3;
}

function RightExpressionPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   return ExpressionPattern_DispatchPattern__5qwd(ParentNode, TokenContext__1, LeftNode__2, false, false);
}

function RightTypePattern__3qwd(ParentNode, TokenContext__1, LeftTypeNode__2) {
   var SourceToken = GetToken__1qwf(TokenContext__1);
   if (LeftTypeNode__2.Type.GetParamSize(LeftTypeNode__2.Type) > 0) {
      if (MatchToken__2qwf(TokenContext__1, "<")) {
         var TypeList = [];
         while (!StartsWithToken__2qwf(TokenContext__1, ">")) {
            if ((TypeList__4).length > 0 && !MatchToken__2qwf(TokenContext__1, ",")) {
               return null;
            };
            var ParamTypeNode = ParsePattern__4qwf(TokenContext__1, ParentNode, "$Type$", false);
            if (ParamTypeNode__5 == null) {
               return LeftTypeNode__2;
            };
            TypeList__4.add(ParamTypeNode__5.Type);
         };
         LeftTypeNode__2 = ZTypeNode__4qyl(new ZTypeNode(), ParentNode, SourceToken__3, ZTypePool_GetGenericType__3qwz(LeftTypeNode__2.Type, TypeList__4, true));
      };
   };
   while (MatchToken__2qwf(TokenContext__1, "[")) {
      if (!MatchToken__2qwf(TokenContext__1, "]")) {
         return null;
      };
      LeftTypeNode__2 = ZTypeNode__4qyl(new ZTypeNode(), ParentNode, SourceToken__3, ZTypePool_GetGenericType1__2qwz(ZGeneric1Type__5qi7(new ZGeneric1Type(), 1 << 16, "Array", null, ZType__4qwz(new ZType(), 1 << 16, "var", null)), LeftTypeNode__2.Type));
   };
   return LeftTypeNode__2;
}

function SetIndexPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var IndexerNode = ZSetIndexNode__3qtq(new ZSetIndexNode(), ParentNode, LeftNode__2);
   IndexerNode__3 = MatchToken__4qwf(TokenContext__1, IndexerNode__3, "[", true);
   IndexerNode__3 = MatchPattern__6qwf(TokenContext__1, IndexerNode__3, 1, "$Expression$", true, true);
   IndexerNode__3 = MatchToken__4qwf(TokenContext__1, IndexerNode__3, "]", true);
   IndexerNode__3 = MatchToken__4qwf(TokenContext__1, IndexerNode__3, "=", true);
   IndexerNode__3 = MatchPattern__5qwf(TokenContext__1, IndexerNode__3, 2, "$Expression$", true);
   return IndexerNode__3;
}

function SetterPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var SetterNode = ZSetterNode__3qtu(new ZSetterNode(), ParentNode, LeftNode__2);
   SetterNode__3 = MatchToken__4qwf(TokenContext__1, SetterNode__3, ".", true);
   SetterNode__3 = MatchPattern__5qwf(TokenContext__1, SetterNode__3, -2, "$Name$", true);
   SetterNode__3 = MatchToken__4qwf(TokenContext__1, SetterNode__3, "=", true);
   SetterNode__3 = MatchPattern__5qwf(TokenContext__1, SetterNode__3, 1, "$Expression$", true);
   return SetterNode__3;
}

function StatementEndPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var ContextAllowance = SetParseFlag__2qwf(TokenContext__1, false);
   var Token = null;
   if (HasNext__1qwf(TokenContext__1)) {
      Token__4 = GetToken__1qwf(TokenContext__1);
      if (!EqualsText__2qwn(Token__4, ";") && !IsIndent__1qwn(Token__4)) {
         SetParseFlag__2qwf(TokenContext__1, ContextAllowance__3);
         return CreateExpectedErrorNode__3qwf(TokenContext__1, Token__4, ";");
      };
      MoveNext__1qwf(TokenContext__1);
      while (HasNext__1qwf(TokenContext__1)) {
         Token__4 = GetToken__1qwf(TokenContext__1);
         if (!EqualsText__2qwn(Token__4, ";") && !IsIndent__1qwn(Token__4)) {
            break;
         };
         MoveNext__1qwf(TokenContext__1);
      };
   };
   SetParseFlag__2qwf(TokenContext__1, ContextAllowance__3);
   return ZEmptyNode__3qpt(new ZEmptyNode(), ParentNode, Token__4);
}

function StatementPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Rememberd = SetParseFlag__2qwf(TokenContext__1, true);
   SetParseFlag__2qwf(TokenContext__1, false);
   var StmtNode = ExpressionPattern_DispatchPattern__5qwd(ParentNode, TokenContext__1, null, true, true);
   StmtNode__4 = MatchPattern__5qwf(TokenContext__1, StmtNode__4, -1, ";", true);
   SetParseFlag__2qwf(TokenContext__1, Rememberd__3);
   return StmtNode__4;
}

function StringLiteralPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Token = GetToken__2qwf(TokenContext__1, true);
   return ZStringNode__4q4n(new ZStringNode(), ParentNode, Token__3, LibZen_UnquoteString__1qqy(GetText__1qwn(Token__3)));
}

function StringLiteralToken__1qw4(SourceContext) {
   var StartIndex = GetPosition__1qw4(SourceContext);
   MoveNext__1qw4(SourceContext);
   while (HasChar__1qw4(SourceContext)) {
      var ch = GetCurrentChar__1qw4(SourceContext);
      if (ch__2 == "\"") {
         MoveNext__1qw4(SourceContext);
         Tokenize__4qw4(SourceContext, "$StringLiteral$", StartIndex__1, GetPosition__1qw4(SourceContext));
         return true;
      };
      if (ch__2 == "\n") {
         break;
      };
      if (ch__2 == "\\") {
         MoveNext__1qw4(SourceContext);
      };
      MoveNext__1qw4(SourceContext);
   };
   LogWarning__3qw4(SourceContext, StartIndex__1, "unclosed \"");
   Tokenize__4qw4(SourceContext, "$StringLiteral$", StartIndex__1, GetPosition__1qw4(SourceContext));
   return false;
}

function SymbolExpressionPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var NameToken = GetToken__2qwf(TokenContext__1, true);
   if (IsToken__2qwf(TokenContext__1, "=")) {
      return ZErrorNode__4qpu(new ZErrorNode(), ParentNode, GetToken__1qwf(TokenContext__1), "assignment is not en expression");
   } else {
      return ZGetNameNode__4qpl(new ZGetNameNode(), ParentNode, NameToken__3, GetText__1qwn(NameToken__3));
   };
}

function SymbolStatementPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var NameToken = GetToken__2qwf(TokenContext__1, true);
   if (MatchToken__2qwf(TokenContext__1, "=")) {
      var AssignedNode = ZSetNameNode__4qtr(new ZSetNameNode(), ParentNode, NameToken__3, GetText__1qwn(NameToken__3));
      AssignedNode__4 = MatchPattern__5qwf(TokenContext__1, AssignedNode__4, 0, "$Expression$", true);
      return AssignedNode__4;
   } else {
      return ZGetNameNode__4qpl(new ZGetNameNode(), ParentNode, NameToken__3, GetText__1qwn(NameToken__3));
   };
}

function ThrowPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var ThrowNode = ZThrowNode__2qts(new ZThrowNode(), ParentNode);
   ThrowNode__3 = MatchToken__4qwf(TokenContext__1, ThrowNode__3, "throw", true);
   ThrowNode__3 = MatchPattern__5qwf(TokenContext__1, ThrowNode__3, 0, "$Expression$", true);
   return ThrowNode__3;
}

function TruePattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   return ZBooleanNode__4qse(new ZBooleanNode(), ParentNode, GetToken__2qwf(TokenContext__1, true), true);
}

function TryPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var TryNode = ZTryNode__2qtg(new ZTryNode(), ParentNode);
   TryNode__3 = MatchToken__4qwf(TokenContext__1, TryNode__3, "try", true);
   TryNode__3 = MatchPattern__5qwf(TokenContext__1, TryNode__3, 0, "$Block$", true);
   var count = 0;
   if (IsNewLineToken__2qwf(TokenContext__1, "catch")) {
      TryNode__3 = MatchPattern__5qwf(TokenContext__1, TryNode__3, 1, "$Catch$", true);
      count__4 = count__4 + 1;
   };
   if (MatchNewLineToken__2qwf(TokenContext__1, "finally")) {
      TryNode__3 = MatchPattern__5qwf(TokenContext__1, TryNode__3, 2, "$Block$", true);
      count__4 = count__4 + 1;
   };
   if (count__4 == 0 && !IsErrorNode__1qwd(TryNode__3)) {
      return TryNode__3.AST[0];
   };
   return TryNode__3;
}

function TypeAnnotationPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   if (MatchToken__2qwf(TokenContext__1, ":")) {
      return ParsePattern__4qwf(TokenContext__1, ParentNode, "$Type$", true);
   };
   return null;
}

function TypePattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var Token = GetToken__2qwf(TokenContext__1, true);
   var TypeNode = GetTypeNode__3qwo(GetNameSpace__1qwd(ParentNode), GetText__1qwn(Token__3), Token__3);
   if (TypeNode__4 != null) {
      return ParsePatternAfter__5qwf(TokenContext__1, ParentNode, TypeNode__4, "$TypeRight$", false);
   };
   return null;
}

function UnaryPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var UnaryNode = ZUnaryNode__3qtk(new ZUnaryNode(), ParentNode, GetToken__2qwf(TokenContext__1, true));
   return MatchPattern__5qwf(TokenContext__1, UnaryNode__3, 0, "$RightExpression$", true);
}

function VarPattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var VarNode = ZVarNode__2qs5(new ZVarNode(), ParentNode);
   VarNode__3 = MatchToken__4qwf(TokenContext__1, VarNode__3, "var", true);
   VarNode__3 = MatchPattern__5qwf(TokenContext__1, VarNode__3, -2, "$Name$", true);
   VarNode__3 = MatchPattern__5qwf(TokenContext__1, VarNode__3, -3, "$TypeAnnotation$", false);
   VarNode__3 = MatchToken__4qwf(TokenContext__1, VarNode__3, "=", true);
   VarNode__3 = MatchPattern__5qwf(TokenContext__1, VarNode__3, 0, "$Expression$", true);
   return VarNode__3;
}

function WhilePattern__3qwd(ParentNode, TokenContext__1, LeftNode__2) {
   var WhileNode = ZWhileNode__2qt1(new ZWhileNode(), ParentNode);
   WhileNode__3 = MatchToken__4qwf(TokenContext__1, WhileNode__3, "while", true);
   WhileNode__3 = MatchToken__4qwf(TokenContext__1, WhileNode__3, "(", true);
   WhileNode__3 = MatchPattern__6qwf(TokenContext__1, WhileNode__3, 0, "$Expression$", true, true);
   WhileNode__3 = MatchToken__4qwf(TokenContext__1, WhileNode__3, ")", true);
   WhileNode__3 = MatchPattern__5qwf(TokenContext__1, WhileNode__3, 1, "$Block$", true);
   return WhileNode__3;
}

function WhiteSpaceToken__1qw4(SourceContext) {
   SkipWhiteSpace__1qw4(SourceContext);
   return true;
}


