static struct ZType60 * ZType__4qwz(struct ZType60 * this, long TypeFlag__1, const char * ShortName__2, struct ZType60 * RefType__3);
static struct ZType60 * GetRealType__1qwz(struct ZType60 * this);
#define _ZType60_GetRealType
static struct ZType60 * GetSuperType__1qwz(struct ZType60 * this);
#define _ZType60_GetSuperType
static struct ZType60 * GetBaseType__1qwz(struct ZType60 * this);
#define _ZType60_GetBaseType
static long GetParamSize__1qwz(struct ZType60 * this);
#define _ZType60_GetParamSize
static struct ZType60 * GetParamType__2qwz(struct ZType60 * this, long Index__1);
#define _ZType60_GetParamType
static int Equals__2qwz(struct ZType60 * this, struct ZType60 * Type__1);
static int Accept__2qwz(struct ZType60 * this, struct ZType60 * Type__1);
static int IsGreekType__1qwz(struct ZType60 * this);
#define _ZType60_IsGreekType
static struct ZType60 * GetGreekRealType__2qwz(struct ZType60 * this, ArrayOfZType * Greek__1);
#define _ZType60_GetGreekRealType
static int AcceptValueType__4qwz(struct ZType60 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZType60_AcceptValueType
static int IsVoidType__1qwz(struct ZType60 * this);
static int IsVarType__1qwz(struct ZType60 * this);
#define _ZType60_IsVarType
static int IsInferrableType__1qwz(struct ZType60 * this);
static int IsTypeType__1qwz(struct ZType60 * this);
static int IsBooleanType__1qwz(struct ZType60 * this);
static int IsIntType__1qwz(struct ZType60 * this);
static int IsFloatType__1qwz(struct ZType60 * this);
static int IsNumberType__1qwz(struct ZType60 * this);
static int IsStringType__1qwz(struct ZType60 * this);
static int IsArrayType__1qwz(struct ZType60 * this);
static int IsMapType__1qwz(struct ZType60 * this);
static int IsOpenType__1qwz(struct ZType60 * this);
static int IsImmutableType__1qwz(struct ZType60 * this);
static int IsNullableType__1qwz(struct ZType60 * this);
static const char * toString__1qwz(struct ZType60 * this);
static const char * GetAsciiName__1qwz(struct ZType60 * this);
static const char * StringfyClassMember__2qwz(struct ZType60 * this, const char * Name__1);
static const char * GetUniqueName__1qwz(struct ZType60 * this);
static int IsFuncType__1qwz(struct ZType60 * this);
static const char * StringfySignature__2qwz(struct ZType60 * this, const char * FuncName__1);
static void Maybe__3qwz(struct ZType60 * this, struct ZType60 * T__1, struct ZToken77 * SourceToken__2);
static struct ZClassField79 * ZClassField__5qei(struct ZClassField79 * this, struct ZClassType80 * ClassType__1, const char * FieldName__2, struct ZType60 * FieldType__3, struct ZToken77 * SourceToken__4);
static struct ZClassType80 * ZClassType__3qeo(struct ZClassType80 * this, const char * ShortName__1, struct ZType60 * RefType__2);
static void ResetSuperType__2qeo(struct ZClassType80 * this, struct ZClassType80 * SuperClass__1);
static long GetFieldSize__1qeo(struct ZClassType80 * this);
static struct ZClassField79 * GetFieldAt__2qeo(struct ZClassType80 * this, long Index__1);
static int HasField__2qeo(struct ZClassType80 * this, const char * FieldName__1);
static struct ZType60 * GetFieldType__3qeo(struct ZClassType80 * this, const char * FieldName__1, struct ZType60 * DefaultType__2);
static struct ZClassField79 * AppendField__4qeo(struct ZClassType80 * this, struct ZType60 * FieldType__1, const char * FieldName__2, struct ZToken77 * SourceToken__3);
static const char * ZFunc_StringfySignature__3qqy(const char * FuncName, long FuncParamSize__1, struct ZType60 * RecvType__2);
static struct ZFunc89 * ZFunc__4qeh(struct ZFunc89 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3);
static struct ZFuncType90 * GetFuncType__1qeh(struct ZFunc89 * this);
static const char * toString__1qeh(struct ZFunc89 * this);
static int IsConverterFunc__1qeh(struct ZFunc89 * this);
static int IsCoercionFunc__1qeh(struct ZFunc89 * this);
static int Is__2qeh(struct ZFunc89 * this, long Flag__1);
static const char * GetSignature__1qeh(struct ZFunc89 * this);
static struct ZFuncType90 * ZFuncType__3qej(struct ZFuncType90 * this, const char * ShortName__1, ArrayOfZType * UniqueTypeParams__2);
static int IsFuncType__1qej(struct ZFuncType90 * this);
static int IsVarType__1qej(struct ZFuncType90 * this);
#define _ZFuncType90_IsVarType
static int IsGreekType__1qej(struct ZFuncType90 * this);
#define _ZFuncType90_IsGreekType
static struct ZType60 * GetGreekRealType__2qej(struct ZFuncType90 * this, ArrayOfZType * Greek__1);
#define _ZFuncType90_GetGreekRealType
static int AcceptValueType__4qej(struct ZFuncType90 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZFuncType90_AcceptValueType
static const char * StringfySignature__2qej(struct ZFuncType90 * this, const char * FuncName__1);
static struct ZType60 * GetBaseType__1qej(struct ZFuncType90 * this);
#define _ZFuncType90_GetBaseType
static long GetParamSize__1qej(struct ZFuncType90 * this);
#define _ZFuncType90_GetParamSize
static struct ZType60 * GetParamType__2qej(struct ZFuncType90 * this, long Index__1);
#define _ZFuncType90_GetParamType
static struct ZType60 * GetReturnType__1qej(struct ZFuncType90 * this);
static long GetFuncParamSize__1qej(struct ZFuncType90 * this);
static struct ZType60 * GetRecvType__1qej(struct ZFuncType90 * this);
static struct ZType60 * GetFuncParamType__2qej(struct ZFuncType90 * this, long Index__1);
static struct ZFuncType90 * NewMethodFuncType__2qej(struct ZFuncType90 * this, struct ZType60 * RecvType__1);
static int AcceptAsFieldFunc__2qej(struct ZFuncType90 * this, struct ZFuncType90 * FuncType__1);
static struct ZGenericType107 * ZGenericType__5qe8(struct ZGenericType107 * this, long TypeFlag__1, const char * ShortName__2, struct ZType60 * BaseType__3, struct ZType60 * ParamType__4);
static struct ZType60 * GetSuperType__1qe8(struct ZGenericType107 * this);
#define _ZGenericType107_GetSuperType
static struct ZType60 * GetBaseType__1qe8(struct ZGenericType107 * this);
#define _ZGenericType107_GetBaseType
static long GetParamSize__1qe8(struct ZGenericType107 * this);
#define _ZGenericType107_GetParamSize
static struct ZType60 * GetParamType__2qe8(struct ZGenericType107 * this, long Index__1);
#define _ZGenericType107_GetParamType
static int IsGreekType__1qe8(struct ZGenericType107 * this);
#define _ZGenericType107_IsGreekType
static struct ZType60 * GetGreekRealType__2qe8(struct ZGenericType107 * this, ArrayOfZType * Greek__1);
#define _ZGenericType107_GetGreekRealType
static int AcceptValueType__4qe8(struct ZGenericType107 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZGenericType107_AcceptValueType
static ArrayOfZType * ZGreekType_NewGreekTypes__1qwx(ArrayOfZType * GreekTypes);
static struct ZGreekType115 * ZGreekType__2qri(struct ZGreekType115 * this, long GreekId__1);
static int IsGreekType__1qri(struct ZGreekType115 * this);
#define _ZGreekType115_IsGreekType
static struct ZType60 * GetGreekRealType__2qri(struct ZGreekType115 * this, ArrayOfZType * Greek__1);
#define _ZGreekType115_GetGreekRealType
static int AcceptValueType__4qri(struct ZGreekType115 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZGreekType115_AcceptValueType
static struct ZPrototype121 * ZPrototype__5qrs(struct ZPrototype121 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3, struct ZToken77 * SourceToken__4);
static void Used__1qrs(struct ZPrototype121 * this);
static void Defined__1qrs(struct ZPrototype121 * this);
static long ZTypePool_NewTypeId__1qwz(struct ZType60 * T);
static struct ZType60 * TypeOf__1qqr(long TypeId);
static const char * ZTypePool_MangleType2__2qwz(struct ZType60 * Type1, struct ZType60 * Type2__1);
static const char * ZTypePool_MangleTypes__1qwx(ArrayOfZType * TypeList);
static ArrayOfZType * ZTypePool_UniqueTypes__1qwx(ArrayOfZType * TypeList);
static struct ZType60 * ZTypePool_GetGenericType1__2qwz(struct ZType60 * BaseType, struct ZType60 * ParamType__1);
static struct ZType60 * ZTypePool_GetGenericType__3qwz(struct ZType60 * BaseType, ArrayOfZType * TypeList__1, int IsCreation__2);
static struct ZFuncType90 * ZTypePool_LookupFuncType__1qwx(ArrayOfZType * TypeList);
static struct ZFuncType90 * ZTypePool_LookupFuncType__1qwz(struct ZType60 * R);
static struct ZFuncType90 * ZTypePool_LookupFuncType__2qwz(struct ZType60 * R, struct ZType60 * P1__1);
static struct ZFuncType90 * ZTypePool_LookupFuncType__3qwz(struct ZType60 * R, struct ZType60 * P1__1, struct ZType60 * P2__2);
static struct ZFuncType90 * ZTypePool_LookupFuncType__4qwz(struct ZType60 * R, struct ZType60 * P1__1, struct ZType60 * P2__2, struct ZType60 * P3__3);
static struct ZVarScope134 * ZVarScope__4qrc(struct ZVarScope134 * this, struct ZVarScope134 * Parent__1, struct ZLogger135 * Logger__2, ArrayOfZVarType * VarList__3);
static struct ZType60 * NewVarType__4qrc(struct ZVarScope134 * this, struct ZType60 * VarType__1, const char * Name__2, struct ZToken77 * SourceToken__3);
static void FoundUnresolvedSymbol__2qrc(struct ZVarScope134 * this, const char * FuncName__1);
static void CheckVarNode__3qrc(struct ZVarScope134 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2);
static int TypeCheckStmtList__3qrc(struct ZVarScope134 * this, struct ZTypeChecker142 * TypeSafer__1, ArrayOfZNode * StmtList__2);
static void TypeCheckFuncBlock__3qrc(struct ZVarScope134 * this, struct ZTypeChecker142 * TypeSafer__1, struct ZFunctionNode144 * FunctionNode__2);
static struct ZVarType136 * ZVarType__4qrb(struct ZVarType136 * this, ArrayOfZVarType * VarList__1, const char * Name__2, struct ZToken77 * SourceToken__3);
static struct ZType60 * GetRealType__1qrb(struct ZVarType136 * this);
#define _ZVarType136_GetRealType
static long GetParamSize__1qrb(struct ZVarType136 * this);
#define _ZVarType136_GetParamSize
static struct ZType60 * GetParamType__2qrb(struct ZVarType136 * this, long Index__1);
#define _ZVarType136_GetParamType
static int IsFuncType__1qrb(struct ZVarType136 * this);
static int IsVarType__1qrb(struct ZVarType136 * this);
#define _ZVarType136_IsVarType
static void Infer__3qrb(struct ZVarType136 * this, struct ZType60 * ContextType__1, struct ZToken77 * SourceToken__2);
static void Maybe__3qrb(struct ZVarType136 * this, struct ZType60 * T__1, struct ZToken77 * SourceToken__2);
static struct ZNode52 * ZNode__4qwg(struct ZNode52 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, long Size__3);
static struct ZNode52 * SetChild__2qwg(struct ZNode52 * this, struct ZNode52 * Node__1);
static void SetNameInfo__3qwg(struct ZNode52 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZNode52_SetNameInfo
static void SetTypeInfo__3qwg(struct ZNode52 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZNode52_SetTypeInfo
static void Set__3qwg(struct ZNode52 * this, long Index__1, struct ZNode52 * Node__2);
static long GetAstSize__1qwg(struct ZNode52 * this);
static int HasAst__2qwg(struct ZNode52 * this, long Index__1);
static struct ZType60 * GetAstType__2qwg(struct ZNode52 * this, long Index__1);
static const char * GetSourceLocation__1qwg(struct ZNode52 * this);
static const char * toString__1qwg(struct ZNode52 * this);
static struct ZBlockNode161 * GetScopeBlockNode__1qwg(struct ZNode52 * this);
static struct ZNameSpace48 * GetNameSpace__1qwg(struct ZNode52 * this);
static int IsErrorNode__1qwg(struct ZNode52 * this);
static int IsBreakingBlock__1qwg(struct ZNode52 * this);
#define _ZNode52_IsBreakingBlock
static struct ZSugarNode165 * DeSugar__2qwg(struct ZNode52 * this, struct ZGenerator55 * Generator__1);
#define _ZNode52_DeSugar
static void Accept__2qwg(struct ZNode52 * this, struct ZVisitor167 * Visitor__1);
#define _ZNode52_Accept
static int IsUntyped__1qwg(struct ZNode52 * this);
static int HasUntypedNode__1qwg(struct ZNode52 * this);
static struct ZNode52 * VisitTypeChecker__3qwg(struct ZNode52 * this, struct ZTypeChecker142 * TypeChecker__1, struct ZType60 * ContextType__2);
static struct ZReturnNode170 * ToReturnNode__1qwg(struct ZNode52 * this);
static struct ZParamNode172 * ZParamNode__2qtb(struct ZParamNode172 * this, struct ZNode52 * ParentNode__1);
static void SetNameInfo__3qtb(struct ZParamNode172 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZParamNode172_SetNameInfo
static struct ZReturnNode170 * ZReturnNode__2qtc(struct ZReturnNode170 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qtc(struct ZReturnNode170 * this, struct ZVisitor167 * Visitor__1);
#define _ZReturnNode170_Accept
static struct ZReturnNode170 * ToReturnNode__1qtc(struct ZReturnNode170 * this);
static struct ZSetIndexNode178 * ZSetIndexNode__3qt2(struct ZSetIndexNode178 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2);
static void Accept__2qt2(struct ZSetIndexNode178 * this, struct ZVisitor167 * Visitor__1);
#define _ZSetIndexNode178_Accept
static struct ZSetNameNode181 * ZSetNameNode__4qyw(struct ZSetNameNode181 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * VarName__3);
static void Accept__2qyw(struct ZSetNameNode181 * this, struct ZVisitor167 * Visitor__1);
#define _ZSetNameNode181_Accept
static struct ZSetterNode184 * ZSetterNode__3qyt(struct ZSetterNode184 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2);
static void SetNameInfo__3qyt(struct ZSetterNode184 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZSetterNode184_SetNameInfo
static void Accept__2qyt(struct ZSetterNode184 * this, struct ZVisitor167 * Visitor__1);
#define _ZSetterNode184_Accept
static int IsStaticField__1qyt(struct ZSetterNode184 * this);
static struct ZSugarNode165 * ZSugarNode__3qt9(struct ZSugarNode165 * this, struct ZNode52 * SugarNode__1, struct ZNode52 * DeSugarNode__2);
static void Accept__2qt9(struct ZSugarNode165 * this, struct ZVisitor167 * Visitor__1);
#define _ZSugarNode165_Accept
static struct ZThrowNode191 * ZThrowNode__2qy4(struct ZThrowNode191 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qy4(struct ZThrowNode191 * this, struct ZVisitor167 * Visitor__1);
#define _ZThrowNode191_Accept
static struct ZTryNode194 * ZTryNode__2qyd(struct ZTryNode194 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qyd(struct ZTryNode194 * this, struct ZVisitor167 * Visitor__1);
#define _ZTryNode194_Accept
static struct ZUnaryNode197 * ZUnaryNode__3qyh(struct ZUnaryNode197 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2);
static void Accept__2qyh(struct ZUnaryNode197 * this, struct ZVisitor167 * Visitor__1);
#define _ZUnaryNode197_Accept
static struct ZWhileNode200 * ZWhileNode__2qyl(struct ZWhileNode200 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qyl(struct ZWhileNode200 * this, struct ZVisitor167 * Visitor__1);
#define _ZWhileNode200_Accept
static const char * toString__1qy6(struct ZEmptyValue203 * this);
static const char * ZLogger_LogError__2qey(struct ZToken77 * Token, const char * Message__1);
static void ZLogger_LogWarning__2qey(struct ZToken77 * Token, const char * Message__1);
static void ZLogger_LogInfo__2qey(struct ZToken77 * Token, const char * Message__1);
static void ZLogger_LogDebug__2qey(struct ZToken77 * Token, const char * Message__1);
static void Report__2qrv(struct ZLogger135 * this, const char * Message__1);
static ArrayOfString * GetReportedErrors__1qrv(struct ZLogger135 * this);
static void ShowErrors__1qrv(struct ZLogger135 * this);
static struct ZMacroFunc210 * ZMacroFunc__3qym(struct ZMacroFunc210 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2);
static const char * ZNameSpace_RightPatternSymbol__1qqy(const char * PatternName);
static struct ZNameSpace48 * ZNameSpace__3qwa(struct ZNameSpace48 * this, struct ZGenerator55 * Generator__1, struct ZNameSpace48 * ParentNameSpace__2);
static const char * toString__1qwa(struct ZNameSpace48 * this);
static struct ZNameSpace48 * CreateSubNameSpace__1qwa(struct ZNameSpace48 * this);
static struct ZNameSpace48 * GetRootNameSpace__1qwa(struct ZNameSpace48 * this);
static struct ZTokenFunc35 * GetTokenFunc__2qwa(struct ZNameSpace48 * this, long ZenChar__1);
static struct ZTokenFunc35 * JoinParentFunc__3qwa(struct ZNameSpace48 * this, struct ZTokenFunction216 * Func__1, struct ZTokenFunc35 * Parent__2);
static void AppendTokenFunc__3qwa(struct ZNameSpace48 * this, const char * keys__1, struct ZTokenFunction216 * TokenFunc__2);
static struct ZSyntax219 * GetSyntaxPattern__2qwa(struct ZNameSpace48 * this, const char * PatternName__1);
static void SetSyntaxPattern__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZSyntax219 * Syntax__2);
static struct ZSyntax219 * GetRightSyntaxPattern__2qwa(struct ZNameSpace48 * this, const char * PatternName__1);
static void AppendSyntaxPattern__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZSyntax219 * NewPattern__2);
static void DefineStatement__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZMatchFunction222 * MatchFunc__2);
static void DefineExpression__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZMatchFunction222 * MatchFunc__2);
static void DefineRightExpression__4qwa(struct ZNameSpace48 * this, const char * PatternName__1, long SyntaxFlag__2, struct ZMatchFunction222 * MatchFunc__3);
static struct ZSymbolEntry225 * GetSymbol__2qwa(struct ZNameSpace48 * this, const char * Symbol__1);
static struct ZNode52 * GetSymbolNode__2qwa(struct ZNameSpace48 * this, const char * Symbol__1);
static void SetLocalSymbolEntry__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZSymbolEntry225 * Entry__2);
static struct ZSymbolEntry225 * SetLocalSymbol__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZNode52 * Node__2);
static struct ZSymbolEntry225 * SetGlobalSymbol__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZNode52 * Node__2);
static struct ZVariable230 * GetLocalVariable__2qwa(struct ZNameSpace48 * this, const char * VarName__1);
static long SetLocalVariable__5qwa(struct ZNameSpace48 * this, struct ZFunctionNode144 * FunctionNode__1, struct ZType60 * VarType__2, const char * VarName__3, struct ZToken77 * SourceToken__4);
static void SetTypeName__4qwa(struct ZNameSpace48 * this, const char * Name__1, struct ZType60 * Type__2, struct ZToken77 * SourceToken__3);
static void SetTypeName__3qwa(struct ZNameSpace48 * this, struct ZType60 * Type__1, struct ZToken77 * SourceToken__2);
static struct ZTypeNode235 * GetTypeNode__3qwa(struct ZNameSpace48 * this, const char * TypeName__1, struct ZToken77 * SourceToken__2);
static struct ZType60 * GetType__3qwa(struct ZNameSpace48 * this, const char * TypeName__1, struct ZToken77 * SourceToken__2);
static struct ZSource238 * ZSource__5qu1(struct ZSource238 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext53 * TokenContext__4);
static long GetLineNumber__2qu1(struct ZSource238 * this, long Position__1);
static long GetLineHeadPosition__2qu1(struct ZSource238 * this, long Position__1);
static long CountIndentSize__2qu1(struct ZSource238 * this, long Position__1);
static const char * GetLineText__2qu1(struct ZSource238 * this, long Position__1);
static const char * GetLineMarker__2qu1(struct ZSource238 * this, long Position__1);
static const char * FormatErrorHeader__4qu1(struct ZSource238 * this, const char * Error__1, long Position__2, const char * Message__3);
static const char * FormatErrorMarker__4qu1(struct ZSource238 * this, const char * Error__1, long Position__2, const char * Message__3);
static const char * GetCharAt__2qu1(struct ZSource238 * this, long n__1);
static struct ZSourceBuilder42 * ZSourceBuilder__3qwu(struct ZSourceBuilder42 * this, struct ZSourceGenerator243 * Template__1, struct ZSourceBuilder42 * Parent__2);
static struct ZSourceBuilder42 * Pop__1qwu(struct ZSourceBuilder42 * this);
static void Clear__1qwu(struct ZSourceBuilder42 * this);
static long GetPosition__1qwu(struct ZSourceBuilder42 * this);
static const char * CopyString__3qwu(struct ZSourceBuilder42 * this, long BeginIndex__1, long EndIndex__2);
static void Append__2qwu(struct ZSourceBuilder42 * this, const char * Text__1);
static void AppendInt__2qwu(struct ZSourceBuilder42 * this, long Value__1);
static void AppendLineFeed__1qwu(struct ZSourceBuilder42 * this);
static void AppendLineFeed__2qwu(struct ZSourceBuilder42 * this, int AppendIndent__1);
static void AppendWhiteSpace__1qwu(struct ZSourceBuilder42 * this);
static void AppendToken__2qwu(struct ZSourceBuilder42 * this, const char * Text__1);
static void AppendBlockComment__2qwu(struct ZSourceBuilder42 * this, const char * Text__1);
static void AppendCommentLine__2qwu(struct ZSourceBuilder42 * this, const char * Text__1);
static void Indent__1qwu(struct ZSourceBuilder42 * this);
static void UnIndent__1qwu(struct ZSourceBuilder42 * this);
static const char * GetIndentString__1qwu(struct ZSourceBuilder42 * this);
static void AppendIndent__1qwu(struct ZSourceBuilder42 * this);
static void AppendLineFeedIndent__1qwu(struct ZSourceBuilder42 * this);
static void IndentAndAppend__2qwu(struct ZSourceBuilder42 * this, const char * Text__1);
static void AppendParamList__4qwu(struct ZSourceBuilder42 * this, struct ZListNode251 * ParamList__1, long BeginIdx__2, long EndIdx__3);
static const char * toString__1qwu(struct ZSourceBuilder42 * this);
static void AppendLine__2qwu(struct ZSourceBuilder42 * this, const char * Text__1);
static struct ZSourceContext50 * ZSourceContext__5qwd(struct ZSourceContext50 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext53 * TokenContext__4);
static long GetCharCode__1qwd(struct ZSourceContext50 * this);
static long GetPosition__1qwd(struct ZSourceContext50 * this);
static int HasChar__1qwd(struct ZSourceContext50 * this);
static const char * GetCurrentChar__1qwd(struct ZSourceContext50 * this);
static const char * GetCharAtFromCurrentPosition__2qwd(struct ZSourceContext50 * this, long n__1);
static void MoveNext__1qwd(struct ZSourceContext50 * this);
static void SkipWhiteSpace__1qwd(struct ZSourceContext50 * this);
static void FoundIndent__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2);
static void Tokenize__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2);
static void Tokenize__4qwd(struct ZSourceContext50 * this, const char * PatternName__1, long StartIndex__2, long EndIndex__3);
static int IsDefinedSyntax__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2);
static void TokenizeDefinedSymbol__2qwd(struct ZSourceContext50 * this, long StartIndex__1);
static void ApplyTokenFunc__2qwd(struct ZSourceContext50 * this, struct ZTokenFunc35 * TokenFunc__1);
static int DoTokenize__1qwd(struct ZSourceContext50 * this);
static void LogWarning__3qwd(struct ZSourceContext50 * this, long Position__1, const char * Message__2);
static struct ZSourceMacro265 * ZSourceMacro__4qis(struct ZSourceMacro265 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2, const char * Macro__3);
static struct ZSymbolEntry225 * ZSymbolEntry__3qup(struct ZSymbolEntry225 * this, struct ZSymbolEntry225 * Parent__1, struct ZNode52 * Node__2);
static struct ZSyntax219 * MergeSyntaxPattern__2qur(struct ZSyntax219 * Pattern, struct ZSyntax219 * Parent__1);
static struct ZSyntax219 * ZSyntax__4qur(struct ZSyntax219 * this, struct ZNameSpace48 * NameSpace__1, const char * PatternName__2, struct ZMatchFunction222 * MatchFunc__3);
static const char * toString__1qur(struct ZSyntax219 * this);
static int IsBinaryOperator__1qur(struct ZSyntax219 * this);
static int IsRightJoin__2qur(struct ZSyntax219 * this, struct ZSyntax219 * Right__1);
static struct ZToken77 * ZToken__4qey(struct ZToken77 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3);
static const char * GetFileName__1qey(struct ZToken77 * this);
static long GetLineNumber__1qey(struct ZToken77 * this);
static const char * GetChar__1qey(struct ZToken77 * this);
static const char * GetText__1qey(struct ZToken77 * this);
static const char * toString__1qey(struct ZToken77 * this);
static int EqualsText__2qey(struct ZToken77 * this, const char * Text__1);
static int StartsWith__2qey(struct ZToken77 * this, const char * Text__1);
static int IsNull__1qey(struct ZToken77 * this);
static int IsIndent__1qey(struct ZToken77 * this);
static int IsNextWhiteSpace__1qey(struct ZToken77 * this);
static int IsNameSymbol__1qey(struct ZToken77 * this);
static long GetIndentSize__1qey(struct ZToken77 * this);
static struct ZTokenContext53 * ZTokenContext__6qwh(struct ZTokenContext53 * this, struct ZGenerator55 * Generator__1, struct ZNameSpace48 * NameSpace__2, const char * FileName__3, long LineNumber__4, const char * SourceText__5);
static int SetParseFlag__2qwh(struct ZTokenContext53 * this, int AllowSkipIndent__1);
static struct ZToken77 * GetBeforeToken__1qwh(struct ZTokenContext53 * this);
static struct ZNode52 * CreateExpectedErrorNode__3qwh(struct ZTokenContext53 * this, struct ZToken77 * SourceToken__1, const char * ExpectedTokenText__2);
static void Vacume__1qwh(struct ZTokenContext53 * this);
static void MoveNext__1qwh(struct ZTokenContext53 * this);
static struct ZToken77 * GetToken__2qwh(struct ZTokenContext53 * this, int EnforceMoveNext__1);
static struct ZToken77 * GetToken__1qwh(struct ZTokenContext53 * this);
static int HasNext__1qwh(struct ZTokenContext53 * this);
static void SkipIndent__1qwh(struct ZTokenContext53 * this);
static void SkipError__2qwh(struct ZTokenContext53 * this, struct ZToken77 * ErrorToken__1);
static int IsToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1);
static int IsNewLineToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1);
static int MatchToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1);
static int MatchNewLineToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1);
static struct ZToken77 * ParseLargeToken__1qwh(struct ZTokenContext53 * this);
static struct ZNode52 * MatchToken__4qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * TokenText__2, int IsRequired__3);
static struct ZSyntax219 * GetApplyingSyntax__1qwh(struct ZTokenContext53 * this);
static struct ZNode52 * ApplyMatchPattern__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2, struct ZSyntax219 * Pattern__3, int IsRequired__4);
static struct ZNode52 * ParsePatternAfter__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2, const char * PatternName__3, int IsRequired__4);
static struct ZNode52 * ParsePattern__4qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * PatternName__2, int IsRequired__3);
static struct ZNode52 * MatchPattern__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4, int AllowSkipIndent__5);
static struct ZNode52 * MatchPattern__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4);
static struct ZNode52 * MatchOptionaPattern__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, int AllowNewLine__3, const char * TokenText__4, const char * PatternName__5);
static struct ZNode52 * MatchNtimes__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * StartToken__2, const char * PatternName__3, const char * DelimToken__4, const char * StopToken__5);
static int StartsWithToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1);
static void SkipEmptyStatement__1qwh(struct ZTokenContext53 * this);
static void Dump__1qwh(struct ZTokenContext53 * this);
static struct ZTokenFunc35 * ZTokenFunc__3qq8(struct ZTokenFunc35 * this, struct ZTokenFunction216 * Func__1, struct ZTokenFunc35 * Parent__2);
static struct ZVariable230 * ZVariable__7qud(struct ZVariable230 * this, struct ZSymbolEntry225 * Parent__1, struct ZFunctionNode144 * FuncNode__2, long VarFlag__3, struct ZType60 * VarType__4, const char * VarName__5, struct ZToken77 * SourceToken__6);
static int IsCaptured__2qud(struct ZVariable230 * this, struct ZFunctionNode144 * CurrentFunctionNode__1);
static void Defined__1qud(struct ZVariable230 * this);
static void Used__1qud(struct ZVariable230 * this);
static struct ZArrayType299 * ZArrayType__3qo4(struct ZArrayType299 * this, long TypeFlag__1, struct ZType60 * ParamType__2);
static struct ZAnnotationNode301 * ZAnnotationNode__4qos(struct ZAnnotationNode301 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, MapOfObject * Anno__3);
static int IsBreakingBlock__1qos(struct ZAnnotationNode301 * this);
#define _ZAnnotationNode301_IsBreakingBlock
static void Accept__2qos(struct ZAnnotationNode301 * this, struct ZVisitor167 * Visitor__1);
#define _ZAnnotationNode301_Accept
static struct ZAssertNode307 * ZAssertNode__2qok(struct ZAssertNode307 * this, struct ZNode52 * ParentNode__1);
static struct ZSugarNode165 * DeSugar__2qok(struct ZAssertNode307 * this, struct ZGenerator55 * Generator__1);
#define _ZAssertNode307_DeSugar
static struct ZBinaryNode310 * ZBinaryNode__5qo1(struct ZBinaryNode310 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static int IsRightJoin__2qo1(struct ZBinaryNode310 * this, struct ZNode52 * Node__1);
static struct ZNode52 * RightJoin__3qo1(struct ZBinaryNode310 * this, struct ZNode52 * ParentNode__1, struct ZBinaryNode310 * RightNode__2);
static struct ZNode52 * AppendParsedRightNode__3qo1(struct ZBinaryNode310 * this, struct ZNode52 * ParentNode__1, struct ZTokenContext53 * TokenContext__2);
static struct ZNode52 * TryMacroNode__2qo1(struct ZBinaryNode310 * this, struct ZGenerator55 * Generator__1);
static void Accept__2qo1(struct ZBinaryNode310 * this, struct ZVisitor167 * Visitor__1);
#define _ZBinaryNode310_Accept
static struct ZBreakNode317 * ZBreakNode__2qon(struct ZBreakNode317 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qon(struct ZBreakNode317 * this, struct ZVisitor167 * Visitor__1);
#define _ZBreakNode317_Accept
static struct ZCastNode320 * ZCastNode__4qo5(struct ZCastNode320 * this, struct ZNode52 * ParentNode__1, struct ZType60 * CastType__2, struct ZNode52 * Node__3);
static void Accept__2qo5(struct ZCastNode320 * this, struct ZVisitor167 * Visitor__1);
#define _ZCastNode320_Accept
static struct ZListNode251 * ToFuncCallNode__2qo5(struct ZCastNode320 * this, struct ZFunc89 * Func__1);
static struct ZCatchNode324 * ZCatchNode__2qpq(struct ZCatchNode324 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3qpq(struct ZCatchNode324 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZCatchNode324_SetTypeInfo
static void SetNameInfo__3qpq(struct ZCatchNode324 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZCatchNode324_SetNameInfo
static struct ZComparatorNode328 * ZComparatorNode__5qpt(struct ZComparatorNode328 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static void Accept__2qpt(struct ZComparatorNode328 * this, struct ZVisitor167 * Visitor__1);
#define _ZComparatorNode328_Accept
static struct ZConstNode331 * ZConstNode__3qpi(struct ZConstNode331 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2);
static struct ZEmptyNode333 * ZEmptyNode__3qpp(struct ZEmptyNode333 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2);
static struct ZErrorNode335 * ZErrorNode__4qp4(struct ZErrorNode335 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, const char * ErrorMessage__3);
static struct ZErrorNode335 * ZErrorNode__3qp4(struct ZErrorNode335 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2);
static void Accept__2qp4(struct ZErrorNode335 * this, struct ZVisitor167 * Visitor__1);
#define _ZErrorNode335_Accept
static struct ZFieldNode339 * ZFieldNode__2qpf(struct ZFieldNode339 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3qpf(struct ZFieldNode339 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZFieldNode339_SetTypeInfo
static void SetNameInfo__3qpf(struct ZFieldNode339 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZFieldNode339_SetNameInfo
static struct ZFloatNode343 * ZFloatNode__4qpk(struct ZFloatNode343 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, double Value__3);
static void Accept__2qpk(struct ZFloatNode343 * this, struct ZVisitor167 * Visitor__1);
#define _ZFloatNode343_Accept
static struct ZGetIndexNode346 * ZGetIndexNode__3qp1(struct ZGetIndexNode346 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2);
static void Accept__2qp1(struct ZGetIndexNode346 * this, struct ZVisitor167 * Visitor__1);
#define _ZGetIndexNode346_Accept
static struct ZGetNameNode349 * ZGetNameNode__4qpx(struct ZGetNameNode349 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * NativeName__3);
static struct ZGetNameNode349 * ZGetNameNode__3qpx(struct ZGetNameNode349 * this, struct ZNode52 * ParentNode__1, struct ZFunc89 * ResolvedFunc__2);
static void Accept__2qpx(struct ZGetNameNode349 * this, struct ZVisitor167 * Visitor__1);
#define _ZGetNameNode349_Accept
static struct ZNode52 * ToGlobalNameNode__1qpx(struct ZGetNameNode349 * this);
static struct ZGetterNode354 * ZGetterNode__3qpm(struct ZGetterNode354 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2);
static void SetNameInfo__3qpm(struct ZGetterNode354 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZGetterNode354_SetNameInfo
static void Accept__2qpm(struct ZGetterNode354 * this, struct ZVisitor167 * Visitor__1);
#define _ZGetterNode354_Accept
static int IsStaticField__1qpm(struct ZGetterNode354 * this);
static struct ZGlobalNameNode359 * ZGlobalNameNode__6qp8(struct ZGlobalNameNode359 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5);
static int IsGivenName__1qp8(struct ZGlobalNameNode359 * this);
static void Accept__2qp8(struct ZGlobalNameNode359 * this, struct ZVisitor167 * Visitor__1);
#define _ZGlobalNameNode359_Accept
static struct ZGroupNode363 * ZGroupNode__2q0r(struct ZGroupNode363 * this, struct ZNode52 * ParentNode__1);
static void Accept__2q0r(struct ZGroupNode363 * this, struct ZVisitor167 * Visitor__1);
#define _ZGroupNode363_Accept
static struct ZIfNode366 * ZIfNode__2q0u(struct ZIfNode366 * this, struct ZNode52 * ParentNode__1);
static void Accept__2q0u(struct ZIfNode366 * this, struct ZVisitor167 * Visitor__1);
#define _ZIfNode366_Accept
static struct ZImportNode369 * ZImportNode__2q0p(struct ZImportNode369 * this, struct ZNode52 * ParentNode__1);
static void SetNameInfo__3q0p(struct ZImportNode369 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZImportNode369_SetNameInfo
static struct ZInstanceOfNode372 * ZInstanceOfNode__4q0a(struct ZInstanceOfNode372 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * LeftNode__3);
static void SetTypeInfo__3q0a(struct ZInstanceOfNode372 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZInstanceOfNode372_SetTypeInfo
static void Accept__2q0a(struct ZInstanceOfNode372 * this, struct ZVisitor167 * Visitor__1);
#define _ZInstanceOfNode372_Accept
static struct ZIntNode376 * ZIntNode__4q0g(struct ZIntNode376 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, long Value__3);
static void Accept__2q0g(struct ZIntNode376 * this, struct ZVisitor167 * Visitor__1);
#define _ZIntNode376_Accept
static struct ZLetNode379 * ZLetNode__2q0k(struct ZLetNode379 * this, struct ZNode52 * ParentNode__1);
static void SetNameInfo__3q0k(struct ZLetNode379 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZLetNode379_SetNameInfo
static void SetTypeInfo__3q0k(struct ZLetNode379 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZLetNode379_SetTypeInfo
static void Accept__2q0k(struct ZLetNode379 * this, struct ZVisitor167 * Visitor__1);
#define _ZLetNode379_Accept
static struct ZGlobalNameNode359 * ToGlobalNameNode__1q0k(struct ZLetNode379 * this);
static struct ZListNode251 * ZListNode__4qu8(struct ZListNode251 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, long Size__3);
static void Append__2qu8(struct ZListNode251 * this, struct ZNode52 * Node__1);
static long GetListSize__1qu8(struct ZListNode251 * this);
static struct ZNode52 * GetListAt__2qu8(struct ZListNode251 * this, long Index__1);
static void SetListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2);
static void InsertListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2);
static struct ZNode52 * RemoveListAt__2qu8(struct ZListNode251 * this, long Index__1);
static void ClearListAfter__2qu8(struct ZListNode251 * this, long Size__1);
static struct ZMacroNode391 * ZMacroNode__4q07(struct ZMacroNode391 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZMacroFunc210 * MacroFunc__3);
static struct ZFuncType90 * GetFuncType__1q07(struct ZMacroNode391 * this);
static const char * GetMacroText__1q07(struct ZMacroNode391 * this);
static void Accept__2q07(struct ZMacroNode391 * this, struct ZVisitor167 * Visitor__1);
#define _ZMacroNode391_Accept
static struct ZMapEntryNode396 * ZMapEntryNode__2q4q(struct ZMapEntryNode396 * this, struct ZNode52 * ParentNode__1);
static struct ZMapLiteralNode398 * ZMapLiteralNode__2q4e(struct ZMapLiteralNode398 * this, struct ZNode52 * ParentNode__1);
static struct ZMapEntryNode396 * GetMapEntryNode__2q4e(struct ZMapLiteralNode398 * this, long Index__1);
static void Accept__2q4e(struct ZMapLiteralNode398 * this, struct ZVisitor167 * Visitor__1);
#define _ZMapLiteralNode398_Accept
static struct ZMethodCallNode402 * ZMethodCallNode__3q4u(struct ZMethodCallNode402 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2);
static void SetNameInfo__3q4u(struct ZMethodCallNode402 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZMethodCallNode402_SetNameInfo
static void Accept__2q4u(struct ZMethodCallNode402 * this, struct ZVisitor167 * Visitor__1);
#define _ZMethodCallNode402_Accept
static struct ZFuncCallNode406 * ToGetterFuncCall__1q4u(struct ZMethodCallNode402 * this);
static struct ZListNode251 * ToFuncCallNode__2q4u(struct ZMethodCallNode402 * this, struct ZFunc89 * Func__1);
static struct ZNewArrayNode409 * ZNewArrayNode__4q4s(struct ZNewArrayNode409 * this, struct ZNode52 * ParentNode__1, struct ZType60 * Type__2, struct ZToken77 * Token__3);
static struct ZNewObjectNode411 * ZNewObjectNode__2q4f(struct ZNewObjectNode411 * this, struct ZNode52 * ParentNode__1);
static void Accept__2q4f(struct ZNewObjectNode411 * this, struct ZVisitor167 * Visitor__1);
#define _ZNewObjectNode411_Accept
static struct ZListNode251 * ToFuncCallNode__2q4f(struct ZNewObjectNode411 * this, struct ZFunc89 * Func__1);
static struct ZNotNode415 * ZNotNode__3q4k(struct ZNotNode415 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2);
static void Accept__2q4k(struct ZNotNode415 * this, struct ZVisitor167 * Visitor__1);
#define _ZNotNode415_Accept
static struct ZNullNode418 * ZNullNode__3q41(struct ZNullNode418 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2);
static void Accept__2q41(struct ZNullNode418 * this, struct ZVisitor167 * Visitor__1);
#define _ZNullNode418_Accept
static struct ZOrNode421 * ZOrNode__5q4x(struct ZOrNode421 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static void Accept__2q4x(struct ZOrNode421 * this, struct ZVisitor167 * Visitor__1);
#define _ZOrNode421_Accept
static struct ZPrototypeNode424 * ZPrototypeNode__2q4b(struct ZPrototypeNode424 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3q4b(struct ZPrototypeNode424 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZPrototypeNode424_SetTypeInfo
static void SetNameInfo__3q4b(struct ZPrototypeNode424 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZPrototypeNode424_SetNameInfo
static struct ZParamNode172 * GetParamNode__2q4b(struct ZPrototypeNode424 * this, long Index__1);
static struct ZFuncType90 * GetFuncType__1q4b(struct ZPrototypeNode424 * this);
static struct ZStringNode430 * ZStringNode__4q42(struct ZStringNode430 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * Value__3);
static void Accept__2q42(struct ZStringNode430 * this, struct ZVisitor167 * Visitor__1);
#define _ZStringNode430_Accept
static struct ZStupidCastErrorNode433 * ZStupidCastErrorNode__3qaw(struct ZStupidCastErrorNode433 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2);
static struct ZTypeNode235 * ZTypeNode__4quk(struct ZTypeNode235 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * ParsedType__3);
static struct ZGenerator55 * ZGenerator__3qwk(struct ZGenerator55 * this, const char * LanguageExtension__1, const char * TargetVersion__2);
static void ImportLocalGrammar__2qwk(struct ZGenerator55 * this, struct ZNameSpace48 * NameSpace__1);
#define _ZGenerator55_ImportLocalGrammar
static void WriteTo__2qwk(struct ZGenerator55 * this, const char * FileName__1);
#define _ZGenerator55_WriteTo
static const char * GetSourceText__1qwk(struct ZGenerator55 * this);
#define _ZGenerator55_GetSourceText
static const char * NameOutputFile__2qwk(struct ZGenerator55 * this, const char * FileName__1);
#define _ZGenerator55_NameOutputFile
static void EnableVisitor__1qwk(struct ZGenerator55 * this);
#define _ZGenerator55_EnableVisitor
static void StopVisitor__1qwk(struct ZGenerator55 * this);
#define _ZGenerator55_StopVisitor
static int IsVisitable__1qwk(struct ZGenerator55 * this);
#define _ZGenerator55_IsVisitable
static const char * GetGrammarInfo__1qwk(struct ZGenerator55 * this);
static void AppendGrammarInfo__2qwk(struct ZGenerator55 * this, const char * GrammarInfo__1);
static const char * GetTargetLangInfo__1qwk(struct ZGenerator55 * this);
static struct ZType60 * GetFieldType__3qwk(struct ZGenerator55 * this, struct ZType60 * BaseType__1, const char * Name__2);
#define _ZGenerator55_GetFieldType
static struct ZType60 * GetSetterType__3qwk(struct ZGenerator55 * this, struct ZType60 * BaseType__1, const char * Name__2);
#define _ZGenerator55_GetSetterType
static struct ZFuncType90 * GetConstructorFuncType__3qwk(struct ZGenerator55 * this, struct ZType60 * ClassType__1, struct ZListNode251 * List__2);
#define _ZGenerator55_GetConstructorFuncType
static struct ZFuncType90 * GetMethodFuncType__4qwk(struct ZGenerator55 * this, struct ZType60 * RecvType__1, const char * MethodName__2, struct ZListNode251 * List__3);
#define _ZGenerator55_GetMethodFuncType
static long GetUniqueNumber__1qwk(struct ZGenerator55 * this);
static const char * NameGlobalSymbol__2qwk(struct ZGenerator55 * this, const char * Symbol__1);
static const char * NameClass__2qwk(struct ZGenerator55 * this, struct ZType60 * ClassType__1);
static void SetDefinedFunc__2qwk(struct ZGenerator55 * this, struct ZFunc89 * Func__1);
static struct ZPrototype121 * SetPrototype__4qwk(struct ZGenerator55 * this, struct ZNode52 * Node__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3);
static struct ZFunc89 * GetDefinedFunc__2qwk(struct ZGenerator55 * this, const char * GlobalName__1);
static struct ZFunc89 * GetDefinedFunc__3qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2);
static struct ZFunc89 * GetDefinedFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3);
static struct ZFunc89 * LookupFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3);
static struct ZMacroFunc210 * GetMacroFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3);
static const char * NameConverterFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2);
static void SetConverterFunc__4qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2, struct ZFunc89 * Func__3);
static struct ZFunc89 * LookupConverterFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2);
static struct ZFunc89 * GetCoercionFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2);
static void VisitExtendedNode__2qwk(struct ZGenerator55 * this, struct ZNode52 * Node__1);
#define _ZGenerator55_VisitExtendedNode
static void VisitSugarNode__2qwk(struct ZGenerator55 * this, struct ZSugarNode165 * Node__1);
#define _ZGenerator55_VisitSugarNode
static struct ZIndentToken459 * ZIndentToken__4qav(struct ZIndentToken459 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3);
static struct ZPatternToken461 * ZPatternToken__5qan(struct ZPatternToken461 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax219 * PresetPattern__4);
static struct ZSourceEngine57 * ZSourceEngine__3qw9(struct ZSourceEngine57 * this, struct ZTypeChecker142 * TypeChecker__1, struct ZGenerator55 * Generator__2);
static int IsVisitable__1qw9(struct ZSourceEngine57 * this);
#define _ZSourceEngine57_IsVisitable
static void EnableVisitor__1qw9(struct ZSourceEngine57 * this);
#define _ZSourceEngine57_EnableVisitor
static void StopVisitor__1qw9(struct ZSourceEngine57 * this);
#define _ZSourceEngine57_StopVisitor
static void Eval2__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1);
static void VisitPrototypeNode__2qw9(struct ZSourceEngine57 * this, struct ZPrototypeNode424 * Node__1);
static void VisitImportNode__2qw9(struct ZSourceEngine57 * this, struct ZImportNode369 * Node__1);
static void Exec2__3qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1, int IsInteractive__2);
static const char * Translate__4qw9(struct ZSourceEngine57 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3);
static void Unsupported__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1);
static void VisitNullNode__2qw9(struct ZSourceEngine57 * this, struct ZNullNode418 * Node__1);
#define _ZSourceEngine57_VisitNullNode
static void VisitBooleanNode__2qw9(struct ZSourceEngine57 * this, struct ZBooleanNode472 * Node__1);
#define _ZSourceEngine57_VisitBooleanNode
static void VisitIntNode__2qw9(struct ZSourceEngine57 * this, struct ZIntNode376 * Node__1);
#define _ZSourceEngine57_VisitIntNode
static void VisitFloatNode__2qw9(struct ZSourceEngine57 * this, struct ZFloatNode343 * Node__1);
#define _ZSourceEngine57_VisitFloatNode
static void VisitStringNode__2qw9(struct ZSourceEngine57 * this, struct ZStringNode430 * Node__1);
#define _ZSourceEngine57_VisitStringNode
static void VisitArrayLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZArrayLiteralNode477 * Node__1);
#define _ZSourceEngine57_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZMapLiteralNode398 * Node__1);
#define _ZSourceEngine57_VisitMapLiteralNode
static void VisitNewObjectNode__2qw9(struct ZSourceEngine57 * this, struct ZNewObjectNode411 * Node__1);
#define _ZSourceEngine57_VisitNewObjectNode
static void VisitGlobalNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGlobalNameNode359 * Node__1);
#define _ZSourceEngine57_VisitGlobalNameNode
static void VisitGetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGetNameNode349 * Node__1);
#define _ZSourceEngine57_VisitGetNameNode
static void VisitSetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZSetNameNode181 * Node__1);
#define _ZSourceEngine57_VisitSetNameNode
static void VisitGroupNode__2qw9(struct ZSourceEngine57 * this, struct ZGroupNode363 * Node__1);
#define _ZSourceEngine57_VisitGroupNode
static void VisitGetterNode__2qw9(struct ZSourceEngine57 * this, struct ZGetterNode354 * Node__1);
#define _ZSourceEngine57_VisitGetterNode
static void VisitSetterNode__2qw9(struct ZSourceEngine57 * this, struct ZSetterNode184 * Node__1);
#define _ZSourceEngine57_VisitSetterNode
static void VisitGetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZGetIndexNode346 * Node__1);
#define _ZSourceEngine57_VisitGetIndexNode
static void VisitSetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZSetIndexNode178 * Node__1);
#define _ZSourceEngine57_VisitSetIndexNode
static void VisitMacroNode__2qw9(struct ZSourceEngine57 * this, struct ZMacroNode391 * Node__1);
#define _ZSourceEngine57_VisitMacroNode
static void VisitFuncCallNode__2qw9(struct ZSourceEngine57 * this, struct ZFuncCallNode406 * Node__1);
#define _ZSourceEngine57_VisitFuncCallNode
static void VisitMethodCallNode__2qw9(struct ZSourceEngine57 * this, struct ZMethodCallNode402 * Node__1);
#define _ZSourceEngine57_VisitMethodCallNode
static void VisitUnaryNode__2qw9(struct ZSourceEngine57 * this, struct ZUnaryNode197 * Node__1);
#define _ZSourceEngine57_VisitUnaryNode
static void VisitNotNode__2qw9(struct ZSourceEngine57 * this, struct ZNotNode415 * Node__1);
#define _ZSourceEngine57_VisitNotNode
static void VisitCastNode__2qw9(struct ZSourceEngine57 * this, struct ZCastNode320 * Node__1);
#define _ZSourceEngine57_VisitCastNode
static void VisitInstanceOfNode__2qw9(struct ZSourceEngine57 * this, struct ZInstanceOfNode372 * Node__1);
#define _ZSourceEngine57_VisitInstanceOfNode
static void VisitBinaryNode__2qw9(struct ZSourceEngine57 * this, struct ZBinaryNode310 * Node__1);
#define _ZSourceEngine57_VisitBinaryNode
static void VisitComparatorNode__2qw9(struct ZSourceEngine57 * this, struct ZComparatorNode328 * Node__1);
#define _ZSourceEngine57_VisitComparatorNode
static void VisitAndNode__2qw9(struct ZSourceEngine57 * this, struct ZAndNode498 * Node__1);
#define _ZSourceEngine57_VisitAndNode
static void VisitOrNode__2qw9(struct ZSourceEngine57 * this, struct ZOrNode421 * Node__1);
#define _ZSourceEngine57_VisitOrNode
static void VisitBlockNode__2qw9(struct ZSourceEngine57 * this, struct ZBlockNode161 * Node__1);
#define _ZSourceEngine57_VisitBlockNode
static void VisitVarNode__2qw9(struct ZSourceEngine57 * this, struct ZVarNode502 * Node__1);
#define _ZSourceEngine57_VisitVarNode
static void VisitIfNode__2qw9(struct ZSourceEngine57 * this, struct ZIfNode366 * Node__1);
#define _ZSourceEngine57_VisitIfNode
static void VisitReturnNode__2qw9(struct ZSourceEngine57 * this, struct ZReturnNode170 * Node__1);
#define _ZSourceEngine57_VisitReturnNode
static void VisitWhileNode__2qw9(struct ZSourceEngine57 * this, struct ZWhileNode200 * Node__1);
#define _ZSourceEngine57_VisitWhileNode
static void VisitBreakNode__2qw9(struct ZSourceEngine57 * this, struct ZBreakNode317 * Node__1);
#define _ZSourceEngine57_VisitBreakNode
static void VisitThrowNode__2qw9(struct ZSourceEngine57 * this, struct ZThrowNode191 * Node__1);
#define _ZSourceEngine57_VisitThrowNode
static void VisitTryNode__2qw9(struct ZSourceEngine57 * this, struct ZTryNode194 * Node__1);
#define _ZSourceEngine57_VisitTryNode
static void VisitLetNode__2qw9(struct ZSourceEngine57 * this, struct ZLetNode379 * Node__1);
#define _ZSourceEngine57_VisitLetNode
static void VisitFunctionNode__2qw9(struct ZSourceEngine57 * this, struct ZFunctionNode144 * Node__1);
#define _ZSourceEngine57_VisitFunctionNode
static void VisitClassNode__2qw9(struct ZSourceEngine57 * this, struct ZClassNode512 * Node__1);
#define _ZSourceEngine57_VisitClassNode
static void VisitErrorNode__2qw9(struct ZSourceEngine57 * this, struct ZErrorNode335 * Node__1);
#define _ZSourceEngine57_VisitErrorNode
static void VisitTypeNode__2qw9(struct ZSourceEngine57 * this, struct ZTypeNode235 * Node__1);
static void VisitExtendedNode__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1);
#define _ZSourceEngine57_VisitExtendedNode
static void VisitSugarNode__2qw9(struct ZSourceEngine57 * this, struct ZSugarNode165 * Node__1);
#define _ZSourceEngine57_VisitSugarNode
static void WriteTo__2qw9(struct ZSourceEngine57 * this, const char * OutputFile__1);
static struct ZSourceGenerator243 * ZSourceGenerator__3quv(struct ZSourceGenerator243 * this, const char * TargetCode__1, const char * TargetVersion__2);
static void InitBuilderList__1quv(struct ZSourceGenerator243 * this);
#define _ZSourceGenerator243_InitBuilderList
static struct ZSourceEngine57 * GetEngine__1quv(struct ZSourceGenerator243 * this);
#define _ZSourceGenerator243_GetEngine
static struct ZSourceBuilder42 * AppendNewSourceBuilder__1quv(struct ZSourceGenerator243 * this);
static struct ZSourceBuilder42 * InsertNewSourceBuilder__1quv(struct ZSourceGenerator243 * this);
static void SetNativeType__3quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1, const char * TypeName__2);
static const char * GetNativeTypeName__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1);
static void SetReservedName__3quv(struct ZSourceGenerator243 * this, const char * Keyword__1, const char * AnotherName__2);
static const char * SafeName__3quv(struct ZSourceGenerator243 * this, const char * Name__1, long Index__2);
static void SetMacro__4quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3);
static void SetMacro__5quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4);
static void SetMacro__6quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5);
static void SetMacro__7quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5, struct ZType60 * P3__6);
static void SetConverterMacro__4quv(struct ZSourceGenerator243 * this, const char * Macro__1, struct ZType60 * ReturnType__2, struct ZType60 * P1__3);
static void WriteTo__2quv(struct ZSourceGenerator243 * this, const char * FileName__1);
#define _ZSourceGenerator243_WriteTo
static const char * GetSourceText__1quv(struct ZSourceGenerator243 * this);
#define _ZSourceGenerator243_GetSourceText
static int StartCodeGeneration__3quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1, int IsInteractive__2);
#define _ZSourceGenerator243_StartCodeGeneration
static void GenerateCode__3quv(struct ZSourceGenerator243 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2);
#define _ZSourceGenerator243_GenerateCode
static int IsNeededSurroud__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1);
static void GenerateSurroundCode__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1);
static void AppendCode__2quv(struct ZSourceGenerator243 * this, const char * RawSource__1);
static void VisitStmtList__2quv(struct ZSourceGenerator243 * this, struct ZBlockNode161 * BlockNode__1);
static void VisitBlockNode__2quv(struct ZSourceGenerator243 * this, struct ZBlockNode161 * Node__1);
#define _ZSourceGenerator243_VisitBlockNode
static void VisitNullNode__2quv(struct ZSourceGenerator243 * this, struct ZNullNode418 * Node__1);
#define _ZSourceGenerator243_VisitNullNode
static void VisitBooleanNode__2quv(struct ZSourceGenerator243 * this, struct ZBooleanNode472 * Node__1);
#define _ZSourceGenerator243_VisitBooleanNode
static void VisitIntNode__2quv(struct ZSourceGenerator243 * this, struct ZIntNode376 * Node__1);
#define _ZSourceGenerator243_VisitIntNode
static void VisitFloatNode__2quv(struct ZSourceGenerator243 * this, struct ZFloatNode343 * Node__1);
#define _ZSourceGenerator243_VisitFloatNode
static void VisitStringNode__2quv(struct ZSourceGenerator243 * this, struct ZStringNode430 * Node__1);
#define _ZSourceGenerator243_VisitStringNode
static void VisitArrayLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZArrayLiteralNode477 * Node__1);
#define _ZSourceGenerator243_VisitArrayLiteralNode
static void VisitMapLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZMapLiteralNode398 * Node__1);
#define _ZSourceGenerator243_VisitMapLiteralNode
static void VisitNewObjectNode__2quv(struct ZSourceGenerator243 * this, struct ZNewObjectNode411 * Node__1);
#define _ZSourceGenerator243_VisitNewObjectNode
static void VisitGroupNode__2quv(struct ZSourceGenerator243 * this, struct ZGroupNode363 * Node__1);
#define _ZSourceGenerator243_VisitGroupNode
static void VisitGetIndexNode__2quv(struct ZSourceGenerator243 * this, struct ZGetIndexNode346 * Node__1);
#define _ZSourceGenerator243_VisitGetIndexNode
static void VisitSetIndexNode__2quv(struct ZSourceGenerator243 * this, struct ZSetIndexNode178 * Node__1);
#define _ZSourceGenerator243_VisitSetIndexNode
static void VisitGlobalNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGlobalNameNode359 * Node__1);
#define _ZSourceGenerator243_VisitGlobalNameNode
static void VisitGetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGetNameNode349 * Node__1);
#define _ZSourceGenerator243_VisitGetNameNode
static void VisitSetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZSetNameNode181 * Node__1);
#define _ZSourceGenerator243_VisitSetNameNode
static void VisitGetterNode__2quv(struct ZSourceGenerator243 * this, struct ZGetterNode354 * Node__1);
#define _ZSourceGenerator243_VisitGetterNode
static void VisitSetterNode__2quv(struct ZSourceGenerator243 * this, struct ZSetterNode184 * Node__1);
#define _ZSourceGenerator243_VisitSetterNode
static void VisitMethodCallNode__2quv(struct ZSourceGenerator243 * this, struct ZMethodCallNode402 * Node__1);
#define _ZSourceGenerator243_VisitMethodCallNode
static void VisitMacroNode__2quv(struct ZSourceGenerator243 * this, struct ZMacroNode391 * Node__1);
#define _ZSourceGenerator243_VisitMacroNode
static void VisitFuncCallNode__2quv(struct ZSourceGenerator243 * this, struct ZFuncCallNode406 * Node__1);
#define _ZSourceGenerator243_VisitFuncCallNode
static void VisitUnaryNode__2quv(struct ZSourceGenerator243 * this, struct ZUnaryNode197 * Node__1);
#define _ZSourceGenerator243_VisitUnaryNode
static void VisitNotNode__2quv(struct ZSourceGenerator243 * this, struct ZNotNode415 * Node__1);
#define _ZSourceGenerator243_VisitNotNode
static void VisitCastNode__2quv(struct ZSourceGenerator243 * this, struct ZCastNode320 * Node__1);
#define _ZSourceGenerator243_VisitCastNode
static void VisitInstanceOfNode__2quv(struct ZSourceGenerator243 * this, struct ZInstanceOfNode372 * Node__1);
#define _ZSourceGenerator243_VisitInstanceOfNode
static void VisitBinaryNode__2quv(struct ZSourceGenerator243 * this, struct ZBinaryNode310 * Node__1);
#define _ZSourceGenerator243_VisitBinaryNode
static void VisitComparatorNode__2quv(struct ZSourceGenerator243 * this, struct ZComparatorNode328 * Node__1);
#define _ZSourceGenerator243_VisitComparatorNode
static void VisitAndNode__2quv(struct ZSourceGenerator243 * this, struct ZAndNode498 * Node__1);
#define _ZSourceGenerator243_VisitAndNode
static void VisitOrNode__2quv(struct ZSourceGenerator243 * this, struct ZOrNode421 * Node__1);
#define _ZSourceGenerator243_VisitOrNode
static void VisitIfNode__2quv(struct ZSourceGenerator243 * this, struct ZIfNode366 * Node__1);
#define _ZSourceGenerator243_VisitIfNode
static void VisitReturnNode__2quv(struct ZSourceGenerator243 * this, struct ZReturnNode170 * Node__1);
#define _ZSourceGenerator243_VisitReturnNode
static void VisitWhileNode__2quv(struct ZSourceGenerator243 * this, struct ZWhileNode200 * Node__1);
#define _ZSourceGenerator243_VisitWhileNode
static void VisitBreakNode__2quv(struct ZSourceGenerator243 * this, struct ZBreakNode317 * Node__1);
#define _ZSourceGenerator243_VisitBreakNode
static void VisitThrowNode__2quv(struct ZSourceGenerator243 * this, struct ZThrowNode191 * Node__1);
#define _ZSourceGenerator243_VisitThrowNode
static void VisitTryNode__2quv(struct ZSourceGenerator243 * this, struct ZTryNode194 * Node__1);
#define _ZSourceGenerator243_VisitTryNode
static void VisitCatchNode__2quv(struct ZSourceGenerator243 * this, struct ZCatchNode324 * Node__1);
static void VisitVarNode__2quv(struct ZSourceGenerator243 * this, struct ZVarNode502 * Node__1);
#define _ZSourceGenerator243_VisitVarNode
static void VisitTypeAnnotation__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1);
static void VisitLetNode__2quv(struct ZSourceGenerator243 * this, struct ZLetNode379 * Node__1);
#define _ZSourceGenerator243_VisitLetNode
static void VisitParamNode__2quv(struct ZSourceGenerator243 * this, struct ZParamNode172 * Node__1);
static void VisitFunctionNode__2quv(struct ZSourceGenerator243 * this, struct ZFunctionNode144 * Node__1);
#define _ZSourceGenerator243_VisitFunctionNode
static void VisitClassNode__2quv(struct ZSourceGenerator243 * this, struct ZClassNode512 * Node__1);
#define _ZSourceGenerator243_VisitClassNode
static void VisitErrorNode__2quv(struct ZSourceGenerator243 * this, struct ZErrorNode335 * Node__1);
#define _ZSourceGenerator243_VisitErrorNode
static void VisitExtendedNode__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1);
#define _ZSourceGenerator243_VisitExtendedNode
static void VisitSugarNode__2quv(struct ZSourceGenerator243 * this, struct ZSugarNode165 * Node__1);
#define _ZSourceGenerator243_VisitSugarNode
static void GenerateTypeName__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1);
static void VisitListNode__5quv(struct ZSourceGenerator243 * this, const char * OpenToken__1, struct ZListNode251 * VargNode__2, const char * DelimToken__3, const char * CloseToken__4);
static void VisitListNode__4quv(struct ZSourceGenerator243 * this, const char * OpenToken__1, struct ZListNode251 * VargNode__2, const char * CloseToken__3);
static struct ZTypeChecker142 * ZTypeChecker__2qr2(struct ZTypeChecker142 * this, struct ZGenerator55 * Generator__1);
static void EnableVisitor__1qr2(struct ZTypeChecker142 * this);
#define _ZTypeChecker142_EnableVisitor
static void StopVisitor__1qr2(struct ZTypeChecker142 * this);
#define _ZTypeChecker142_StopVisitor
static int IsVisitable__1qr2(struct ZTypeChecker142 * this);
#define _ZTypeChecker142_IsVisitable
static struct ZType60 * GetContextType__1qr2(struct ZTypeChecker142 * this);
static struct ZNode52 * VisitTypeChecker__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2);
static struct ZNode52 * CreateStupidCastNode__3qr2(struct ZTypeChecker142 * this, struct ZType60 * Requested__1, struct ZNode52 * Node__2);
static struct ZNode52 * EnforceNodeType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * EnforcedType__2);
static struct ZNode52 * TypeCheckImpl__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2, long TypeCheckPolicy__3);
static struct ZNode52 * VisitTypeChecker__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2, long TypeCheckPolicy__3);
static struct ZNode52 * TryType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2);
static void TryTypeAt__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, long Index__2, struct ZType60 * ContextType__3);
static struct ZNode52 * CheckType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2);
static void CheckTypeAt__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, long Index__2, struct ZType60 * ContextType__3);
static int TypeCheckNodeList__2qr2(struct ZTypeChecker142 * this, struct ZListNode251 * List__1);
static void Return__2qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1);
static void TypedNode__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * Type__2);
static void ReturnErrorNode__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZToken77 * ErrorToken__2, const char * Message__3);
static void VisitErrorNode__2qr2(struct ZTypeChecker142 * this, struct ZErrorNode335 * Node__1);
#define _ZTypeChecker142_VisitErrorNode
static void VisitExtendedNode__2qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1);
#define _ZTypeChecker142_VisitExtendedNode
static void VisitSugarNode__2qr2(struct ZTypeChecker142 * this, struct ZSugarNode165 * Node__1);
#define _ZTypeChecker142_VisitSugarNode
static struct CSourceGenerator596 * CSourceGenerator__1qgl(struct CSourceGenerator596 * this);
static struct ZSourceEngine57 * GetEngine__1qgl(struct CSourceGenerator596 * this);
#define _CSourceGenerator596_GetEngine
static void GenerateCode__3qgl(struct CSourceGenerator596 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2);
#define _CSourceGenerator596_GenerateCode
static void VisitArrayLiteralNode__2qgl(struct CSourceGenerator596 * this, struct ZArrayLiteralNode477 * Node__1);
#define _CSourceGenerator596_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qgl(struct CSourceGenerator596 * this, struct ZMapLiteralNode398 * Node__1);
#define _CSourceGenerator596_VisitMapLiteralNode
static void VisitNewObjectNode__2qgl(struct CSourceGenerator596 * this, struct ZNewObjectNode411 * Node__1);
#define _CSourceGenerator596_VisitNewObjectNode
static const char * BaseName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * RecvType__1);
static void VisitGetIndexNode__2qgl(struct CSourceGenerator596 * this, struct ZGetIndexNode346 * Node__1);
#define _CSourceGenerator596_VisitGetIndexNode
static void VisitSetIndexNode__2qgl(struct CSourceGenerator596 * this, struct ZSetIndexNode178 * Node__1);
#define _CSourceGenerator596_VisitSetIndexNode
static void VisitGetNameNode__2qgl(struct CSourceGenerator596 * this, struct ZGetNameNode349 * Node__1);
#define _CSourceGenerator596_VisitGetNameNode
static void VisitSetNameNode__2qgl(struct CSourceGenerator596 * this, struct ZSetNameNode181 * Node__1);
#define _CSourceGenerator596_VisitSetNameNode
static void VisitGetterNode__2qgl(struct CSourceGenerator596 * this, struct ZGetterNode354 * Node__1);
#define _CSourceGenerator596_VisitGetterNode
static void VisitSetterNode__2qgl(struct CSourceGenerator596 * this, struct ZSetterNode184 * Node__1);
#define _CSourceGenerator596_VisitSetterNode
static void VisitMethodCallNode__2qgl(struct CSourceGenerator596 * this, struct ZMethodCallNode402 * Node__1);
#define _CSourceGenerator596_VisitMethodCallNode
static void VisitFuncCallNode__2qgl(struct CSourceGenerator596 * this, struct ZFuncCallNode406 * Node__1);
#define _CSourceGenerator596_VisitFuncCallNode
static void VisitThrowNode__2qgl(struct CSourceGenerator596 * this, struct ZThrowNode191 * Node__1);
#define _CSourceGenerator596_VisitThrowNode
static void VisitTryNode__2qgl(struct CSourceGenerator596 * this, struct ZTryNode194 * Node__1);
#define _CSourceGenerator596_VisitTryNode
static void VisitCatchNode__2qgl(struct CSourceGenerator596 * this, struct ZCatchNode324 * Node__1);
static const char * ParamTypeName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1);
static const char * GetCTypeName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1);
static void GenerateFuncTypeName__3qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1, const char * FuncName__2);
static void GenerateTypeName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1);
static void VisitVarNode__2qgl(struct CSourceGenerator596 * this, struct ZVarNode502 * Node__1);
#define _CSourceGenerator596_VisitVarNode
static void VisitParamNode__2qgl(struct CSourceGenerator596 * this, struct ZParamNode172 * Node__1);
static void SetMethod__3qgl(struct CSourceGenerator596 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2);
static void VisitInstanceOfNode__2qgl(struct CSourceGenerator596 * this, struct ZInstanceOfNode372 * Node__1);
#define _CSourceGenerator596_VisitInstanceOfNode
static void GenerateCField__3qgl(struct CSourceGenerator596 * this, const char * CType__1, const char * FieldName__2);
static void GenerateField__3qgl(struct CSourceGenerator596 * this, struct ZType60 * DeclType__1, const char * FieldName__2);
static void GenerateFields__3qgl(struct CSourceGenerator596 * this, struct ZClassType80 * ClassType__1, struct ZType60 * ThisType__2);
static void VisitErrorNode__2qgl(struct CSourceGenerator596 * this, struct ZErrorNode335 * Node__1);
#define _CSourceGenerator596_VisitErrorNode
static struct ZAndNode498 * ZAndNode__5qsm(struct ZAndNode498 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static void Accept__2qsm(struct ZAndNode498 * this, struct ZVisitor167 * Visitor__1);
#define _ZAndNode498_Accept
static struct ZArrayLiteralNode477 * ZArrayLiteralNode__2qsp(struct ZArrayLiteralNode477 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qsp(struct ZArrayLiteralNode477 * this, struct ZVisitor167 * Visitor__1);
#define _ZArrayLiteralNode477_Accept
static struct ZBlockNode161 * ZBlockNode__2qth(struct ZBlockNode161 * this, struct ZNameSpace48 * NameSpace__1);
static struct ZBlockNode161 * ZBlockNode__3qth(struct ZBlockNode161 * this, struct ZNode52 * ParentNode__1, long Init__2);
static void Accept__2qth(struct ZBlockNode161 * this, struct ZVisitor167 * Visitor__1);
#define _ZBlockNode161_Accept
static struct ZReturnNode170 * ToReturnNode__1qth(struct ZBlockNode161 * this);
static long IndexOf__2qth(struct ZBlockNode161 * this, struct ZNode52 * ChildNode__1);
static void CopyTo__3qth(struct ZBlockNode161 * this, long Index__1, struct ZBlockNode161 * BlockNode__2);
static struct ZBooleanNode472 * ZBooleanNode__4qst(struct ZBooleanNode472 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, int Value__3);
static void Accept__2qst(struct ZBooleanNode472 * this, struct ZVisitor167 * Visitor__1);
#define _ZBooleanNode472_Accept
static struct ZClassNode512 * ZClassNode__2qdo(struct ZClassNode512 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3qdo(struct ZClassNode512 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZClassNode512_SetTypeInfo
static void SetNameInfo__3qdo(struct ZClassNode512 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZClassNode512_SetNameInfo
static struct ZFieldNode339 * GetFieldNode__2qdo(struct ZClassNode512 * this, long Index__1);
static void Accept__2qdo(struct ZClassNode512 * this, struct ZVisitor167 * Visitor__1);
#define _ZClassNode512_Accept
static struct ZFuncCallNode406 * ZFuncCallNode__3q40(struct ZFuncCallNode406 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * FuncNode__2);
static struct ZFuncCallNode406 * ZFuncCallNode__4q40(struct ZFuncCallNode406 * this, struct ZNode52 * ParentNode__1, const char * FuncName__2, struct ZType60 * FuncType__3);
static void Accept__2q40(struct ZFuncCallNode406 * this, struct ZVisitor167 * Visitor__1);
#define _ZFuncCallNode406_Accept
static struct ZType60 * GetRecvType__1q40(struct ZFuncCallNode406 * this);
static const char * GetFuncName__1q40(struct ZFuncCallNode406 * this);
static struct ZFuncType90 * GetFuncType__1q40(struct ZFuncCallNode406 * this);
static struct ZMacroNode391 * ToMacroNode__2q40(struct ZFuncCallNode406 * this, struct ZMacroFunc210 * MacroFunc__1);
static struct ZFunctionNode144 * ZFunctionNode__2qtq(struct ZFunctionNode144 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3qtq(struct ZFunctionNode144 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZFunctionNode144_SetTypeInfo
static void SetNameInfo__3qtq(struct ZFunctionNode144 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZFunctionNode144_SetNameInfo
static void Accept__2qtq(struct ZFunctionNode144 * this, struct ZVisitor167 * Visitor__1);
#define _ZFunctionNode144_Accept
static struct ZParamNode172 * GetParamNode__2qtq(struct ZFunctionNode144 * this, long Index__1);
static struct ZFuncType90 * GetFuncType__2qtq(struct ZFunctionNode144 * this, struct ZType60 * ContextType__1);
static const char * GetSignature__2qtq(struct ZFunctionNode144 * this, struct ZGenerator55 * Generator__1);
static struct ZFunctionNode144 * Push__2qtq(struct ZFunctionNode144 * this, struct ZFunctionNode144 * Parent__1);
static struct ZFunctionNode144 * Pop__1qtq(struct ZFunctionNode144 * this);
static int IsTopLevel__1qtq(struct ZFunctionNode144 * this);
static long GetVarIndex__1qtq(struct ZFunctionNode144 * this);
static struct ZVarNode502 * ZVarNode__2qs2(struct ZVarNode502 * this, struct ZNode52 * ParentNode__1);
static void SetNameInfo__3qs2(struct ZVarNode502 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZVarNode502_SetNameInfo
static void SetTypeInfo__3qs2(struct ZVarNode502 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZVarNode502_SetTypeInfo
static void Accept__2qs2(struct ZVarNode502 * this, struct ZVisitor167 * Visitor__1);
#define _ZVarNode502_Accept
static struct ZSyntax219 * ExpressionPattern_GetRightPattern__2qwa(struct ZNameSpace48 * NameSpace, struct ZTokenContext53 * TokenContext__1);
static struct ZNode52 * ExpressionPattern_DispatchPattern__5qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2, int AllowStatement__3, int AllowBinary__4);
static const char * NumberLiteralToken_ParseDigit__1qwd(struct ZSourceContext50 * SourceContext);

static struct ZNode52 * f83(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZBinaryNode310 * BinaryNode__3 = ZAndNode__5qsm(_NewZAndNode498(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58), LeftNode__2, GetApplyingSyntax__1qwh(TokenContext__1));
	return AppendParsedRightNode__3qo1(BinaryNode__3, ParentNode, TokenContext__1);
}

static struct ZNode52 * f85(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return NULL;
}

static struct ZNode52 * f87(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ApplyNode__3 = ZFuncCallNode__3q40(_NewZFuncCallNode406(), ParentNode, LeftNode__2);
	ApplyNode__3 = MatchNtimes__6qwh(TokenContext__1, ApplyNode__3, "(", "$Expression$", ",", ")");
	return ApplyNode__3;
}

static struct ZNode52 * f89(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode__3 = ZArrayLiteralNode__2qsp(_NewZArrayLiteralNode477(), ParentNode);
	LiteralNode__3 = MatchNtimes__6qwh(TokenContext__1, LiteralNode__3, "[", "$Expression$", ",", "]");
	return LiteralNode__3;
}

static struct ZNode52 * f91(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * AssertNode__3 = ZAssertNode__2qok(_NewZAssertNode307(), ParentNode);
	AssertNode__3 = MatchToken__4qwh(TokenContext__1, AssertNode__3, "assert", ZTokenContext_Required_Z53);
	AssertNode__3 = MatchToken__4qwh(TokenContext__1, AssertNode__3, "(", ZTokenContext_Required_Z53);
	AssertNode__3 = MatchPattern__6qwh(TokenContext__1, AssertNode__3, ZThrowNode_Expr_Z33, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	AssertNode__3 = MatchToken__4qwh(TokenContext__1, AssertNode__3, ")", ZTokenContext_Required_Z53);
	return AssertNode__3;
}

static struct ZNode52 * f93(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return NULL;
}

static struct ZNode52 * f95(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	struct ZBinaryNode310 * BinaryNode__4 = ZBinaryNode__5qo1(_NewZBinaryNode310(), ParentNode, Token__3, LeftNode__2, GetApplyingSyntax__1qwh(TokenContext__1));
	return AppendParsedRightNode__3qo1(BinaryNode__4, ParentNode, TokenContext__1);
}

static int f97(struct ZSourceContext50 * SourceContext) {
	long StartIndex__1 = GetPosition__1qwd(SourceContext);
	const char * NextChar__2 = GetCharAtFromCurrentPosition__2qwd(SourceContext, +1);
	if (NextChar__2 != "/" && NextChar__2 != "*") {
		return 0/*false*/;
	};
	if (NextChar__2 == "/") {
		while (HasChar__1qwd(SourceContext)) {
			const char * ch__3 = GetCurrentChar__1qwd(SourceContext);
			if (ch__3 == "\n") {
				break;
			};
			MoveNext__1qwd(SourceContext);
		};
		return 1/*true*/;
	};
	long NestedLevel__4 = 0;
	const char * PrevChar__5 = "0";
	while (HasChar__1qwd(SourceContext)) {
		NextChar__2 = GetCurrentChar__1qwd(SourceContext);
		if (PrevChar__5 == "*" && NextChar__2 == "/") {
			NestedLevel__4 = NestedLevel__4 - 1;
			if (NestedLevel__4 == 0) {
				MoveNext__1qwd(SourceContext);
				return 1/*true*/;
			};
		};
		if (PrevChar__5 == "/" && NextChar__2 == "*") {
			NestedLevel__4 = NestedLevel__4 + 1;
		};
		MoveNext__1qwd(SourceContext);
		PrevChar__5 = NextChar__2;
	};
	LogWarning__3qwd(SourceContext, StartIndex__1, "unfound */");
	return 1/*true*/;
}

static struct ZNode52 * f99(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * BlockNode__3 = ZBlockNode__3qth(_NewZBlockNode161(), ParentNode, 0);
	struct ZToken77 * SkipToken__4 = GetToken__1qwh(TokenContext__1);
	BlockNode__3 = MatchToken__4qwh(TokenContext__1, BlockNode__3, "{", ZTokenContext_Required_Z53);
	if (!IsErrorNode__1qwg(BlockNode__3)) {
		int Remembered__5 = SetParseFlag__2qwh(TokenContext__1, ZTokenContext_AllowSkipIndent_Z55);
		struct ZNode52 * NestedBlockNode__6 = BlockNode__3;
		while (HasNext__1qwh(TokenContext__1)) {
			if (MatchToken__2qwh(TokenContext__1, "}")) {
				break;
			};
			NestedBlockNode__6 = MatchPattern__5qwh(TokenContext__1, NestedBlockNode__6, ZNode_NestedAppendIndex_Z24, "$Statement$", ZTokenContext_Required_Z53);
			if (IsErrorNode__1qwg(NestedBlockNode__6)) {
				SkipError__2qwh(TokenContext__1, SkipToken__4);
				(void)MatchToken__2qwh(TokenContext__1, "}");
				break;
			};
		};
		(void)SetParseFlag__2qwh(TokenContext__1, Remembered__5);
	};
	return BlockNode__3;
}

static struct ZNode52 * f101(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * BreakNode__3 = ZBreakNode__2qon(_NewZBreakNode317(), ParentNode);
	BreakNode__3 = MatchToken__4qwh(TokenContext__1, BreakNode__3, "break", ZTokenContext_Required_Z53);
	return BreakNode__3;
}

static int f103(struct ZSourceContext50 * SourceContext) {
	return 0/*false*/;
}

static struct ZNode52 * f105(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * CastNode__3 = ZCastNode__4qo5(_NewZCastNode320(), ParentNode, ZTypeVarType_Z4, NULL);
	CastNode__3 = MatchToken__4qwh(TokenContext__1, CastNode__3, "(", ZTokenContext_Required_Z53);
	CastNode__3 = MatchPattern__5qwh(TokenContext__1, CastNode__3, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Required_Z53);
	CastNode__3 = MatchToken__4qwh(TokenContext__1, CastNode__3, ")", ZTokenContext_Required_Z53);
	CastNode__3 = MatchPattern__5qwh(TokenContext__1, CastNode__3, ZCastNode_Expr_Z62, "$RightExpression$", ZTokenContext_Required_Z53);
	return CastNode__3;
}

static struct ZNode52 * f107(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * CatchNode__3 = ZCatchNode__2qpq(_NewZCatchNode324(), ParentNode);
	CatchNode__3 = MatchToken__4qwh(TokenContext__1, CatchNode__3, "catch", ZTokenContext_Required_Z53);
	CatchNode__3 = MatchToken__4qwh(TokenContext__1, CatchNode__3, "(", ZTokenContext_Required_Z53);
	CatchNode__3 = MatchPattern__5qwh(TokenContext__1, CatchNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	CatchNode__3 = MatchToken__4qwh(TokenContext__1, CatchNode__3, ")", ZTokenContext_Required_Z53);
	CatchNode__3 = MatchPattern__5qwh(TokenContext__1, CatchNode__3, ZCatchNode_Block_Z63, "$Block$", ZTokenContext_Required_Z53);
	return CatchNode__3;
}

static struct ZNode52 * f109(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ClassNode__3 = ZClassNode__2qdo(_NewZClassNode512(), ParentNode);
	ClassNode__3 = MatchToken__4qwh(TokenContext__1, ClassNode__3, "class", ZTokenContext_Required_Z53);
	ClassNode__3 = MatchPattern__5qwh(TokenContext__1, ClassNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	if (MatchNewLineToken__2qwh(TokenContext__1, "extends")) {
		ClassNode__3 = MatchPattern__5qwh(TokenContext__1, ClassNode__3, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Required_Z53);
	};
	ClassNode__3 = MatchNtimes__6qwh(TokenContext__1, ClassNode__3, "{", "$FieldDecl$", NULL, "}");
	return ClassNode__3;
}

static struct ZNode52 * f111(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	struct ZBinaryNode310 * BinaryNode__4 = ZComparatorNode__5qpt(_NewZComparatorNode328(), ParentNode, Token__3, LeftNode__2, GetApplyingSyntax__1qwh(TokenContext__1));
	return AppendParsedRightNode__3qo1(BinaryNode__4, ParentNode, TokenContext__1);
}

static struct ZNode52 * f113(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qwg(ParentNode, TokenContext__1, LeftNode__2, 0/*false*/, 1/*true*/);
}

static struct ZNode52 * f115(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ZBooleanNode__4qst(_NewZBooleanNode472(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58), 0/*false*/);
}

static struct ZNode52 * f117(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	int Rememberd__3 = SetParseFlag__2qwh(TokenContext__1, 0/*false*/);
	struct ZNode52 * FieldNode__4 = ZFieldNode__2qpf(_NewZFieldNode339(), ParentNode);
	FieldNode__4 = MatchToken__4qwh(TokenContext__1, FieldNode__4, "var", ZTokenContext_Required_Z53);
	FieldNode__4 = MatchPattern__5qwh(TokenContext__1, FieldNode__4, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	FieldNode__4 = MatchPattern__5qwh(TokenContext__1, FieldNode__4, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	if (MatchToken__2qwh(TokenContext__1, "=")) {
		FieldNode__4 = MatchPattern__5qwh(TokenContext__1, FieldNode__4, ZFieldNode_InitValue_Z64, "$Expression$", ZTokenContext_Required_Z53);
	};
	FieldNode__4 = MatchPattern__5qwh(TokenContext__1, FieldNode__4, ZNode_Nop_Z20, ";", ZTokenContext_Required_Z53);
	(void)SetParseFlag__2qwh(TokenContext__1, Rememberd__3);
	return FieldNode__4;
}

static struct ZNode52 * f119(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	return ZFloatNode__4qpk(_NewZFloatNode343(), ParentNode, Token__3, LibZen_ParseFloat__1qqy(GetText__1qey(Token__3)));
}

static struct ZNode52 * f121(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * FuncNode__3 = ZFunctionNode__2qtq(_NewZFunctionNode144(), ParentNode);
	FuncNode__3 = MatchToken__4qwh(TokenContext__1, FuncNode__3, "function", ZTokenContext_Required_Z53);
	FuncNode__3 = MatchPattern__5qwh(TokenContext__1, FuncNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Optional_Z54);
	FuncNode__3 = MatchNtimes__6qwh(TokenContext__1, FuncNode__3, "(", "$Param$", ",", ")");
	FuncNode__3 = MatchPattern__5qwh(TokenContext__1, FuncNode__3, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	FuncNode__3 = MatchPattern__5qwh(TokenContext__1, FuncNode__3, ZFunctionNode_Block_Z80, "$Block$", ZTokenContext_Required_Z53);
	return FuncNode__3;
}

static struct ZNode52 * f123(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * IndexerNode__3 = ZGetIndexNode__3qp1(_NewZGetIndexNode346(), ParentNode, LeftNode__2);
	IndexerNode__3 = MatchToken__4qwh(TokenContext__1, IndexerNode__3, "[", ZTokenContext_Required_Z53);
	IndexerNode__3 = MatchPattern__6qwh(TokenContext__1, IndexerNode__3, ZGetIndexNode_Index_Z66, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	IndexerNode__3 = MatchToken__4qwh(TokenContext__1, IndexerNode__3, "]", ZTokenContext_Required_Z53);
	return IndexerNode__3;
}

static struct ZNode52 * f125(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * GetterNode__3 = ZGetterNode__3qpm(_NewZGetterNode354(), ParentNode, LeftNode__2);
	GetterNode__3 = MatchToken__4qwh(TokenContext__1, GetterNode__3, ".", ZTokenContext_Required_Z53);
	GetterNode__3 = MatchPattern__5qwh(TokenContext__1, GetterNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	return GetterNode__3;
}

static struct ZNode52 * f127(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * GroupNode__3 = ZGroupNode__2q0r(_NewZGroupNode363(), ParentNode);
	GroupNode__3 = MatchToken__4qwh(TokenContext__1, GroupNode__3, "(", ZTokenContext_Required_Z53);
	GroupNode__3 = MatchPattern__6qwh(TokenContext__1, GroupNode__3, ZGroupNode_Expr_Z68, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	GroupNode__3 = MatchToken__4qwh(TokenContext__1, GroupNode__3, ")", ZTokenContext_Required_Z53);
	return GroupNode__3;
}

static struct ZNode52 * f129(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * IfNode__3 = ZIfNode__2q0u(_NewZIfNode366(), ParentNode);
	IfNode__3 = MatchToken__4qwh(TokenContext__1, IfNode__3, "if", ZTokenContext_Required_Z53);
	IfNode__3 = MatchToken__4qwh(TokenContext__1, IfNode__3, "(", ZTokenContext_Required_Z53);
	IfNode__3 = MatchPattern__6qwh(TokenContext__1, IfNode__3, ZIfNode_Cond_Z69, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowNewLine_Z57);
	IfNode__3 = MatchToken__4qwh(TokenContext__1, IfNode__3, ")", ZTokenContext_Required_Z53);
	IfNode__3 = MatchPattern__5qwh(TokenContext__1, IfNode__3, ZIfNode_Then_Z70, "$Block$", ZTokenContext_Required_Z53);
	if (MatchNewLineToken__2qwh(TokenContext__1, "else")) {
		const char * PatternName__4 = "$Block$";
		if (IsNewLineToken__2qwh(TokenContext__1, "if")) {
			PatternName__4 = "if";
		};
		IfNode__3 = MatchPattern__5qwh(TokenContext__1, IfNode__3, ZIfNode_Else_Z71, PatternName__4, ZTokenContext_Required_Z53);
	};
	return IfNode__3;
}

static struct ZNode52 * f131(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * BinaryNode__3 = ZInstanceOfNode__4q0a(_NewZInstanceOfNode372(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58), LeftNode__2);
	BinaryNode__3 = MatchPattern__5qwh(TokenContext__1, BinaryNode__3, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Required_Z53);
	return BinaryNode__3;
}

static struct ZNode52 * f133(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	return ZIntNode__4q0g(_NewZIntNode376(), ParentNode, Token__3, LibZen_ParseInt__1qqy(GetText__1qey(Token__3)));
}

static struct ZNode52 * f135(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LetNode__3 = ZLetNode__2q0k(_NewZLetNode379(), ParentNode);
	LetNode__3 = MatchToken__4qwh(TokenContext__1, LetNode__3, "let", ZTokenContext_Required_Z53);
	LetNode__3 = MatchPattern__5qwh(TokenContext__1, LetNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	LetNode__3 = MatchPattern__5qwh(TokenContext__1, LetNode__3, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	LetNode__3 = MatchToken__4qwh(TokenContext__1, LetNode__3, "=", ZTokenContext_Required_Z53);
	LetNode__3 = MatchPattern__5qwh(TokenContext__1, LetNode__3, ZLetNode_InitValue_Z73, "$Expression$", ZTokenContext_Required_Z53);
	return LetNode__3;
}

static struct ZNode52 * f137(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode__3 = ZMapEntryNode__2q4q(_NewZMapEntryNode396(), ParentNode);
	LiteralNode__3 = MatchPattern__5qwh(TokenContext__1, LiteralNode__3, ZMapEntryNode_Key_Z74, "$Expression$", ZTokenContext_Required_Z53);
	LiteralNode__3 = MatchToken__4qwh(TokenContext__1, LiteralNode__3, ":", ZTokenContext_Required_Z53);
	LiteralNode__3 = MatchPattern__5qwh(TokenContext__1, LiteralNode__3, ZMapEntryNode_Value_Z75, "$Expression$", ZTokenContext_Required_Z53);
	return LiteralNode__3;
}

static struct ZNode52 * f139(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode__3 = ZMapLiteralNode__2q4e(_NewZMapLiteralNode398(), ParentNode);
	LiteralNode__3 = MatchNtimes__6qwh(TokenContext__1, LiteralNode__3, "{", "$MapEntry$", ",", "}");
	return LiteralNode__3;
}

static struct ZNode52 * f141(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * MethodCallNode__3 = ZMethodCallNode__3q4u(_NewZMethodCallNode402(), ParentNode, LeftNode__2);
	MethodCallNode__3 = MatchToken__4qwh(TokenContext__1, MethodCallNode__3, ".", ZTokenContext_Required_Z53);
	MethodCallNode__3 = MatchPattern__5qwh(TokenContext__1, MethodCallNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	MethodCallNode__3 = MatchNtimes__6qwh(TokenContext__1, MethodCallNode__3, "(", "$Expression$", ",", ")");
	return MethodCallNode__3;
}

static struct ZNode52 * f143(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	if (LibZen_IsSymbol__1qqy(GetChar__1qey(Token__3))) {
		return ZGetNameNode__4qpx(_NewZGetNameNode349(), ParentNode, Token__3, GetText__1qey(Token__3));
	};
	return ZErrorNode__4qp4(_NewZErrorNode335(), ParentNode, Token__3, LibZen_StrCat(LibZen_StrCat("illegal name: \"", GetText__1qey(Token__3)), "\""));
}

static int f145(struct ZSourceContext50 * SourceContext) {
	long StartIndex__1 = GetPosition__1qwd(SourceContext);
	while (HasChar__1qwd(SourceContext)) {
		const char * ch__2 = GetCurrentChar__1qwd(SourceContext);
		if (!LibZen_IsSymbol__1qqy(ch__2) && !LibZen_IsDigit__1qqy(ch__2)) {
			break;
		};
		MoveNext__1qwd(SourceContext);
	};
	Tokenize__3qwd(SourceContext, StartIndex__1, GetPosition__1qwd(SourceContext));
	return 1/*true*/;
}

static int f147(struct ZSourceContext50 * SourceContext) {
	long StartIndex__1 = GetPosition__1qwd(SourceContext) + 1;
	MoveNext__1qwd(SourceContext);
	SkipWhiteSpace__1qwd(SourceContext);
	FoundIndent__3qwd(SourceContext, StartIndex__1, GetPosition__1qwd(SourceContext));
	return 1/*true*/;
}

static struct ZNode52 * f149(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode__3 = ZNewObjectNode__2q4f(_NewZNewObjectNode411(), ParentNode);
	LiteralNode__3 = MatchToken__4qwh(TokenContext__1, LiteralNode__3, "new", ZTokenContext_Required_Z53);
	LiteralNode__3 = MatchPattern__5qwh(TokenContext__1, LiteralNode__3, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Optional_Z54);
	LiteralNode__3 = MatchNtimes__6qwh(TokenContext__1, LiteralNode__3, "(", "$Expression$", ",", ")");
	return LiteralNode__3;
}

static struct ZNode52 * f151(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * UnaryNode__3 = ZNotNode__3q4k(_NewZNotNode415(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58));
	UnaryNode__3 = MatchPattern__5qwh(TokenContext__1, UnaryNode__3, ZUnaryNode_Recv_Z37, "$RightExpression$", ZTokenContext_Required_Z53);
	return UnaryNode__3;
}

static struct ZNode52 * f153(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ZNullNode__3q41(_NewZNullNode418(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58));
}

static int f155(struct ZSourceContext50 * SourceContext) {
	long StartIndex__1 = GetPosition__1qwd(SourceContext);
	const char * ch__2 = NumberLiteralToken_ParseDigit__1qwd(SourceContext);
	if (ch__2 == ".") {
		MoveNext__1qwd(SourceContext);
		ch__2 = NumberLiteralToken_ParseDigit__1qwd(SourceContext);
		if (ch__2 == "e" || ch__2 == "E") {
			MoveNext__1qwd(SourceContext);
			if (HasChar__1qwd(SourceContext)) {
				ch__2 = GetCurrentChar__1qwd(SourceContext);
				if (ch__2 == "+" || ch__2 == "-") {
					MoveNext__1qwd(SourceContext);
				};
			};
			(void)NumberLiteralToken_ParseDigit__1qwd(SourceContext);
		};
		Tokenize__4qwd(SourceContext, "$FloatLiteral$", StartIndex__1, GetPosition__1qwd(SourceContext));
	} else {
		Tokenize__4qwd(SourceContext, "$IntegerLiteral$", StartIndex__1, GetPosition__1qwd(SourceContext));
	};
	return 1/*true*/;
}

static int f157(struct ZSourceContext50 * SourceContext) {
	TokenizeDefinedSymbol__2qwd(SourceContext, GetPosition__1qwd(SourceContext));
	return 1/*true*/;
}

static struct ZNode52 * f159(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZBinaryNode310 * BinaryNode__3 = ZOrNode__5q4x(_NewZOrNode421(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58), LeftNode__2, GetApplyingSyntax__1qwh(TokenContext__1));
	return AppendParsedRightNode__3qo1(BinaryNode__3, ParentNode, TokenContext__1);
}

static struct ZNode52 * f161(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ParamNode__3 = ZParamNode__2qtb(_NewZParamNode172(), ParentNode);
	ParamNode__3 = MatchPattern__5qwh(TokenContext__1, ParamNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	ParamNode__3 = MatchPattern__5qwh(TokenContext__1, ParamNode__3, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	return ParamNode__3;
}

static struct ZNode52 * f163(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * FuncNode__3 = ZPrototypeNode__2q4b(_NewZPrototypeNode424(), ParentNode);
	FuncNode__3 = MatchToken__4qwh(TokenContext__1, FuncNode__3, "function", ZTokenContext_Required_Z53);
	FuncNode__3 = MatchPattern__5qwh(TokenContext__1, FuncNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	FuncNode__3 = MatchNtimes__6qwh(TokenContext__1, FuncNode__3, "(", "$Param$", ",", ")");
	FuncNode__3 = MatchPattern__5qwh(TokenContext__1, FuncNode__3, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Required_Z53);
	return FuncNode__3;
}

static struct ZNode52 * f165(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ReturnNode__3 = ZReturnNode__2qtc(_NewZReturnNode170(), ParentNode);
	ReturnNode__3 = MatchToken__4qwh(TokenContext__1, ReturnNode__3, "return", ZTokenContext_Required_Z53);
	ReturnNode__3 = MatchPattern__5qwh(TokenContext__1, ReturnNode__3, ZReturnNode_Expr_Z25, "$Expression$", ZTokenContext_Optional_Z54);
	return ReturnNode__3;
}

static struct ZNode52 * f167(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qwg(ParentNode, TokenContext__1, LeftNode__2, 0/*false*/, 0/*false*/);
}

static struct ZNode52 * f169(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftTypeNode__2) {
	struct ZToken77 * SourceToken__6 = GetToken__1qwh(TokenContext__1);
	if (LeftTypeNode__2->Type->GetParamSize(LeftTypeNode__2->Type) > 0) {
		if (MatchToken__2qwh(TokenContext__1, "<")) {
			ArrayOfZType * TypeList__4 = LibZen_NewArray(0);
			while (!StartsWithToken__2qwh(TokenContext__1, ">")) {
				if (LibZen_ArraySize((ArrayOfVar *)TypeList__4) > 0 && !MatchToken__2qwh(TokenContext__1, ",")) {
					return NULL;
				};
				struct ZTypeNode235 * ParamTypeNode__5 = (struct ZTypeNode235 *)ParsePattern__4qwh(TokenContext__1, ParentNode, "$Type$", ZTokenContext_Optional_Z54);
				if (ParamTypeNode__5 == NULL) {
					return LeftTypeNode__2;
				};
				LibZen_ArrayAdd((ArrayOfVar *)TypeList__4, (var)ParamTypeNode__5->Type);
			};
			LeftTypeNode__2 = ZTypeNode__4quk(_NewZTypeNode235(), ParentNode, SourceToken__3, ZTypePool_GetGenericType__3qwz(LeftTypeNode__2->Type, TypeList__4, 1/*true*/));
		};
	};
	while (MatchToken__2qwh(TokenContext__1, "[")) {
		if (!MatchToken__2qwh(TokenContext__1, "]")) {
			return NULL;
		};
		LeftTypeNode__2 = ZTypeNode__4quk(_NewZTypeNode235(), ParentNode, SourceToken__3, ZTypePool_GetGenericType1__2qwz(ZGenericType_ArrayType_Z15, LeftTypeNode__2->Type));
	};
	return LeftTypeNode__2;
}

static struct ZNode52 * f171(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * IndexerNode__3 = ZSetIndexNode__3qt2(_NewZSetIndexNode178(), ParentNode, LeftNode__2);
	IndexerNode__3 = MatchToken__4qwh(TokenContext__1, IndexerNode__3, "[", ZTokenContext_Required_Z53);
	IndexerNode__3 = MatchPattern__6qwh(TokenContext__1, IndexerNode__3, ZSetIndexNode_Index_Z27, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	IndexerNode__3 = MatchToken__4qwh(TokenContext__1, IndexerNode__3, "]", ZTokenContext_Required_Z53);
	IndexerNode__3 = MatchToken__4qwh(TokenContext__1, IndexerNode__3, "=", ZTokenContext_Required_Z53);
	IndexerNode__3 = MatchPattern__5qwh(TokenContext__1, IndexerNode__3, ZSetIndexNode_Expr_Z28, "$Expression$", ZTokenContext_Required_Z53);
	return IndexerNode__3;
}

static struct ZNode52 * f173(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * SetterNode__3 = ZSetterNode__3qyt(_NewZSetterNode184(), ParentNode, LeftNode__2);
	SetterNode__3 = MatchToken__4qwh(TokenContext__1, SetterNode__3, ".", ZTokenContext_Required_Z53);
	SetterNode__3 = MatchPattern__5qwh(TokenContext__1, SetterNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	SetterNode__3 = MatchToken__4qwh(TokenContext__1, SetterNode__3, "=", ZTokenContext_Required_Z53);
	SetterNode__3 = MatchPattern__5qwh(TokenContext__1, SetterNode__3, ZSetterNode_Expr_Z31, "$Expression$", ZTokenContext_Required_Z53);
	return SetterNode__3;
}

static struct ZNode52 * f175(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	int ContextAllowance__3 = SetParseFlag__2qwh(TokenContext__1, 0/*false*/);
	struct ZToken77 * Token__4 = NULL;
	if (HasNext__1qwh(TokenContext__1)) {
		Token__4 = GetToken__1qwh(TokenContext__1);
		if (!EqualsText__2qey(Token__4, ";") && !IsIndent__1qey(Token__4)) {
			(void)SetParseFlag__2qwh(TokenContext__1, ContextAllowance__3);
			return CreateExpectedErrorNode__3qwh(TokenContext__1, Token__4, ";");
		};
		MoveNext__1qwh(TokenContext__1);
		while (HasNext__1qwh(TokenContext__1)) {
			Token__4 = GetToken__1qwh(TokenContext__1);
			if (!EqualsText__2qey(Token__4, ";") && !IsIndent__1qey(Token__4)) {
				break;
			};
			MoveNext__1qwh(TokenContext__1);
		};
	};
	(void)SetParseFlag__2qwh(TokenContext__1, ContextAllowance__3);
	return ZEmptyNode__3qpp(_NewZEmptyNode333(), ParentNode, Token__4);
}

static struct ZNode52 * f177(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	int Rememberd__3 = SetParseFlag__2qwh(TokenContext__1, ZTokenContext_AllowSkipIndent_Z55);
	(void)SetParseFlag__2qwh(TokenContext__1, ZTokenContext_NotAllowSkipIndent_Z56);
	struct ZNode52 * StmtNode__4 = ExpressionPattern_DispatchPattern__5qwg(ParentNode, TokenContext__1, NULL, 1/*true*/, 1/*true*/);
	StmtNode__4 = MatchPattern__5qwh(TokenContext__1, StmtNode__4, ZNode_Nop_Z20, ";", ZTokenContext_Required_Z53);
	(void)SetParseFlag__2qwh(TokenContext__1, Rememberd__3);
	return StmtNode__4;
}

static struct ZNode52 * f179(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	return ZStringNode__4q42(_NewZStringNode430(), ParentNode, Token__3, LibZen_UnquoteString__1qqy(GetText__1qey(Token__3)));
}

static int f181(struct ZSourceContext50 * SourceContext) {
	long StartIndex__1 = GetPosition__1qwd(SourceContext);
	MoveNext__1qwd(SourceContext);
	while (HasChar__1qwd(SourceContext)) {
		const char * ch__2 = GetCurrentChar__1qwd(SourceContext);
		if (ch__2 == "\"") {
			MoveNext__1qwd(SourceContext);
			Tokenize__4qwd(SourceContext, "$StringLiteral$", StartIndex__1, GetPosition__1qwd(SourceContext));
			return 1/*true*/;
		};
		if (ch__2 == "\n") {
			break;
		};
		if (ch__2 == "\\") {
			MoveNext__1qwd(SourceContext);
		};
		MoveNext__1qwd(SourceContext);
	};
	LogWarning__3qwd(SourceContext, StartIndex__1, "unclosed \"");
	Tokenize__4qwd(SourceContext, "$StringLiteral$", StartIndex__1, GetPosition__1qwd(SourceContext));
	return 0/*false*/;
}

static struct ZNode52 * f183(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * NameToken__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	if (IsToken__2qwh(TokenContext__1, "=")) {
		return ZErrorNode__4qp4(_NewZErrorNode335(), ParentNode, GetToken__1qwh(TokenContext__1), "assignment is not en expression");
	} else {
		return ZGetNameNode__4qpx(_NewZGetNameNode349(), ParentNode, NameToken__3, GetText__1qey(NameToken__3));
	};
}

static struct ZNode52 * f185(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * NameToken__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	if (MatchToken__2qwh(TokenContext__1, "=")) {
		struct ZNode52 * AssignedNode__4 = ZSetNameNode__4qyw(_NewZSetNameNode181(), ParentNode, NameToken__3, GetText__1qey(NameToken__3));
		AssignedNode__4 = MatchPattern__5qwh(TokenContext__1, AssignedNode__4, ZSetNameNode_Expr_Z29, "$Expression$", ZTokenContext_Required_Z53);
		return AssignedNode__4;
	} else {
		return ZGetNameNode__4qpx(_NewZGetNameNode349(), ParentNode, NameToken__3, GetText__1qey(NameToken__3));
	};
}

static struct ZNode52 * f187(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ThrowNode__3 = ZThrowNode__2qy4(_NewZThrowNode191(), ParentNode);
	ThrowNode__3 = MatchToken__4qwh(TokenContext__1, ThrowNode__3, "throw", ZTokenContext_Required_Z53);
	ThrowNode__3 = MatchPattern__5qwh(TokenContext__1, ThrowNode__3, ZThrowNode_Expr_Z33, "$Expression$", ZTokenContext_Required_Z53);
	return ThrowNode__3;
}

static struct ZNode52 * f189(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ZBooleanNode__4qst(_NewZBooleanNode472(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58), 1/*true*/);
}

static struct ZNode52 * f191(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * TryNode__3 = ZTryNode__2qyd(_NewZTryNode194(), ParentNode);
	TryNode__3 = MatchToken__4qwh(TokenContext__1, TryNode__3, "try", ZTokenContext_Required_Z53);
	TryNode__3 = MatchPattern__5qwh(TokenContext__1, TryNode__3, ZTryNode_Try_Z34, "$Block$", ZTokenContext_Required_Z53);
	long count__4 = 0;
	if (IsNewLineToken__2qwh(TokenContext__1, "catch")) {
		TryNode__3 = MatchPattern__5qwh(TokenContext__1, TryNode__3, ZTryNode_Catch_Z35, "$Catch$", ZTokenContext_Required_Z53);
		count__4 = count__4 + 1;
	};
	if (MatchNewLineToken__2qwh(TokenContext__1, "finally")) {
		TryNode__3 = MatchPattern__5qwh(TokenContext__1, TryNode__3, ZTryNode_Finally_Z36, "$Block$", ZTokenContext_Required_Z53);
		count__4 = count__4 + 1;
	};
	if (count__4 == 0 && !IsErrorNode__1qwg(TryNode__3)) {
		return Array<ZNode>GetIndex(ZTryNode_Try_Z34);
	};
	return TryNode__3;
}

static struct ZNode52 * f193(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	if (MatchToken__2qwh(TokenContext__1, ":")) {
		return ParsePattern__4qwh(TokenContext__1, ParentNode, "$Type$", ZTokenContext_Required_Z53);
	};
	return NULL;
}

static struct ZNode52 * f195(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token__3 = GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58);
	struct ZTypeNode235 * TypeNode__4 = GetTypeNode__3qwa(GetNameSpace__1qwg(ParentNode), GetText__1qey(Token__3), Token__3);
	if (TypeNode__4 != NULL) {
		return ParsePatternAfter__5qwh(TokenContext__1, ParentNode, TypeNode__4, "$TypeRight$", ZTokenContext_Optional_Z54);
	};
	return NULL;
}

static struct ZNode52 * f197(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * UnaryNode__3 = ZUnaryNode__3qyh(_NewZUnaryNode197(), ParentNode, GetToken__2qwh(TokenContext__1, ZTokenContext_MoveNext_Z58));
	return MatchPattern__5qwh(TokenContext__1, UnaryNode__3, ZUnaryNode_Recv_Z37, "$RightExpression$", ZTokenContext_Required_Z53);
}

static struct ZNode52 * f199(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * VarNode__3 = ZVarNode__2qs2(_NewZVarNode502(), ParentNode);
	VarNode__3 = MatchToken__4qwh(TokenContext__1, VarNode__3, "var", ZTokenContext_Required_Z53);
	VarNode__3 = MatchPattern__5qwh(TokenContext__1, VarNode__3, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	VarNode__3 = MatchPattern__5qwh(TokenContext__1, VarNode__3, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	VarNode__3 = MatchToken__4qwh(TokenContext__1, VarNode__3, "=", ZTokenContext_Required_Z53);
	VarNode__3 = MatchPattern__5qwh(TokenContext__1, VarNode__3, ZVarNode_InitValue_Z81, "$Expression$", ZTokenContext_Required_Z53);
	return VarNode__3;
}

static struct ZNode52 * f201(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * WhileNode__3 = ZWhileNode__2qyl(_NewZWhileNode200(), ParentNode);
	WhileNode__3 = MatchToken__4qwh(TokenContext__1, WhileNode__3, "while", ZTokenContext_Required_Z53);
	WhileNode__3 = MatchToken__4qwh(TokenContext__1, WhileNode__3, "(", ZTokenContext_Required_Z53);
	WhileNode__3 = MatchPattern__6qwh(TokenContext__1, WhileNode__3, ZWhileNode_Cond_Z38, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	WhileNode__3 = MatchToken__4qwh(TokenContext__1, WhileNode__3, ")", ZTokenContext_Required_Z53);
	WhileNode__3 = MatchPattern__5qwh(TokenContext__1, WhileNode__3, ZWhileNode_Block_Z39, "$Block$", ZTokenContext_Required_Z53);
	return WhileNode__3;
}

static int f203(struct ZSourceContext50 * SourceContext) {
	SkipWhiteSpace__1qwd(SourceContext);
	return 1/*true*/;
}

static ArrayOfString * LibZen_GreekNames_Z0 = LibZen_NewStringArray(3, "a", "b", "c");
struct ZType60 {
	int _classId60;
	int _delta60;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType60 * RefType;
	struct ZType60 * (*)(struct ZType60 *) GetRealType;
	struct ZType60 * (*)(struct ZType60 *) GetSuperType;
	struct ZType60 * (*)(struct ZType60 *) GetBaseType;
	long (*)(struct ZType60 *) GetParamSize;
	struct ZType60 * (*)(struct ZType60 *,long) GetParamType;
	int (*)(struct ZType60 *) IsGreekType;
	struct ZType60 * (*)(struct ZType60 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType60 *,struct ZType60 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType60 *) IsVarType;
	int _nextId;
};

static void _InitZType60(struct ZType60 * o) {
	o->_classId60 = 60;
	o->_delta60 = sizeof(struct ZType60) - sizeof(int);
	o->TypeFlag = 0;
	o->TypeId = 0;
	o->ShortName = NULL;
	o->RefType = NULL;
	o->GetRealType = NULL;
	o->GetSuperType = NULL;
	o->GetBaseType = NULL;
	o->GetParamSize = NULL;
	o->GetParamType = NULL;
	o->IsGreekType = NULL;
	o->GetGreekRealType = NULL;
	o->AcceptValueType = NULL;
	o->IsVarType = NULL;
#ifdef _ZType60_GetRealType
	o->GetRealType = GetRealType__1qwz
#endif
#ifdef _ZType60_GetSuperType
	o->GetSuperType = GetSuperType__1qwz
#endif
#ifdef _ZType60_GetBaseType
	o->GetBaseType = GetBaseType__1qwz
#endif
#ifdef _ZType60_GetParamSize
	o->GetParamSize = GetParamSize__1qwz
#endif
#ifdef _ZType60_GetParamType
	o->GetParamType = GetParamType__2qwz
#endif
#ifdef _ZType60_IsGreekType
	o->IsGreekType = IsGreekType__1qwz
#endif
#ifdef _ZType60_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qwz
#endif
#ifdef _ZType60_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qwz
#endif
#ifdef _ZType60_IsVarType
	o->IsVarType = IsVarType__1qwz
#endif
	o->_nextId = 0;
}

static struct ZType60 * _NewZType60(void) {
	struct ZType60 *o = LibZen_Malloc(sizeof(struct ZType60));
	_InitZType60(o);
	return o;
}

static long ZTypeUniqueTypeFlag_Z1 = 1 << 16;
static long ZTypeUnboxTypeFlag_Z2 = 1 << 10;
static long ZTypeOpenTypeFlag_Z3 = 1 << 9;
static struct ZType60 * ZTypeVarType_Z4 = ZType__4qwz(_NewZType60(), ZTypeUniqueTypeFlag_Z1, "var", NULL);
static struct ZType60 * ZTypeVoidType_Z5 = ZType__4qwz(_NewZType60(), ZTypeUniqueTypeFlag_Z1, "void", NULL);
static struct ZType60 * ZTypeBooleanType_Z6 = ZType__4qwz(_NewZType60(), ZTypeUniqueTypeFlag_Z1, "boolean", ZTypeVarType_Z4);
static struct ZType60 * ZTypeIntType_Z7 = ZType__4qwz(_NewZType60(), ZTypeUniqueTypeFlag_Z1, "int", ZTypeVarType_Z4);
static struct ZType60 * ZTypeFloatType_Z8 = ZType__4qwz(_NewZType60(), ZTypeUniqueTypeFlag_Z1, "float", ZTypeVarType_Z4);
static struct ZType60 * ZTypeStringType_Z9 = ZType__4qwz(_NewZType60(), ZTypeUniqueTypeFlag_Z1, "String", ZTypeVarType_Z4);
static struct ZType60 * ZTypeTypeType_Z10 = ZType__4qwz(_NewZType60(), ZTypeUniqueTypeFlag_Z1, "Type", ZTypeVarType_Z4);
struct ZClassField79 {
	int _classId79;
	int _delta79;
	long FieldFlag;
	struct ZClassType80 * ClassType;
	struct ZType60 * FieldType;
	const char * FieldName;
	long FieldNativeIndex;
	struct ZToken77 * SourceToken;
	int _nextId;
};

static void _InitZClassField79(struct ZClassField79 * o) {
	o->_classId79 = 79;
	o->_delta79 = sizeof(struct ZClassField79) - sizeof(int);
	o->FieldFlag = 0;
	o->ClassType = NULL;
	o->FieldType = NULL;
	o->FieldName = NULL;
	o->FieldNativeIndex = 0;
	o->SourceToken = NULL;
	o->_nextId = 0;
}

static struct ZClassField79 * _NewZClassField79(void) {
	struct ZClassField79 *o = LibZen_Malloc(sizeof(struct ZClassField79));
	_InitZClassField79(o);
	return o;
}

struct ZClassType80 {
	int _classId60;
	int _delta60;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType60 * RefType;
	struct ZType60 * (*)(struct ZType60 *) GetRealType;
	struct ZType60 * (*)(struct ZType60 *) GetSuperType;
	struct ZType60 * (*)(struct ZType60 *) GetBaseType;
	long (*)(struct ZType60 *) GetParamSize;
	struct ZType60 * (*)(struct ZType60 *,long) GetParamType;
	int (*)(struct ZType60 *) IsGreekType;
	struct ZType60 * (*)(struct ZType60 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType60 *,struct ZType60 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType60 *) IsVarType;
	int _classId80;
	int _delta80;
	ArrayOfZClassField * FieldList;
	int _nextId;
};

static void _InitZClassType80(struct ZClassType80 * o) {
	_InitZType60((struct ZType60 *)o);
	o->_classId80 = 80;
	o->_delta80 = sizeof(struct ZClassType80) - sizeof(struct ZType60);
	o->FieldList = NULL;
#ifdef _ZClassType80_GetRealType
	o->GetRealType = GetRealType__1qeo
#endif
#ifdef _ZClassType80_GetSuperType
	o->GetSuperType = GetSuperType__1qeo
#endif
#ifdef _ZClassType80_GetBaseType
	o->GetBaseType = GetBaseType__1qeo
#endif
#ifdef _ZClassType80_GetParamSize
	o->GetParamSize = GetParamSize__1qeo
#endif
#ifdef _ZClassType80_GetParamType
	o->GetParamType = GetParamType__2qeo
#endif
#ifdef _ZClassType80_IsGreekType
	o->IsGreekType = IsGreekType__1qeo
#endif
#ifdef _ZClassType80_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qeo
#endif
#ifdef _ZClassType80_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qeo
#endif
#ifdef _ZClassType80_IsVarType
	o->IsVarType = IsVarType__1qeo
#endif
	o->_nextId = 0;
}

static struct ZClassType80 * _NewZClassType80(void) {
	struct ZClassType80 *o = LibZen_Malloc(sizeof(struct ZClassType80));
	_InitZClassType80(o);
	return o;
}

struct ZFunc89 {
	int _classId89;
	int _delta89;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType90 * FuncType;
	int _nextId;
};

static void _InitZFunc89(struct ZFunc89 * o) {
	o->_classId89 = 89;
	o->_delta89 = sizeof(struct ZFunc89) - sizeof(int);
	o->FuncFlag = 0;
	o->FuncName = NULL;
	o->FuncType = NULL;
	o->_nextId = 0;
}

static struct ZFunc89 * _NewZFunc89(void) {
	struct ZFunc89 *o = LibZen_Malloc(sizeof(struct ZFunc89));
	_InitZFunc89(o);
	return o;
}

static const char * ZFunc_NativeNameConnector_Z11 = "__";
static long ZFunc_ConverterFunc_Z12 = 1 << 16;
static long ZFunc_CoercionFunc_Z13 = (1 << 17) | ZFunc_ConverterFunc_Z12;
struct ZFuncType90 {
	int _classId60;
	int _delta60;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType60 * RefType;
	struct ZType60 * (*)(struct ZType60 *) GetRealType;
	struct ZType60 * (*)(struct ZType60 *) GetSuperType;
	struct ZType60 * (*)(struct ZType60 *) GetBaseType;
	long (*)(struct ZType60 *) GetParamSize;
	struct ZType60 * (*)(struct ZType60 *,long) GetParamType;
	int (*)(struct ZType60 *) IsGreekType;
	struct ZType60 * (*)(struct ZType60 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType60 *,struct ZType60 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType60 *) IsVarType;
	int _classId90;
	int _delta90;
	ArrayOfZType * TypeParams;
	int HasUnknownType;
	int HasGreekType;
	int _nextId;
};

static void _InitZFuncType90(struct ZFuncType90 * o) {
	_InitZType60((struct ZType60 *)o);
	o->_classId90 = 90;
	o->_delta90 = sizeof(struct ZFuncType90) - sizeof(struct ZType60);
	o->TypeParams = NULL;
	o->HasUnknownType = 0/*false*/;
	o->HasGreekType = 0/*false*/;
#ifdef _ZFuncType90_GetRealType
	o->GetRealType = GetRealType__1qej
#endif
#ifdef _ZFuncType90_GetSuperType
	o->GetSuperType = GetSuperType__1qej
#endif
#ifdef _ZFuncType90_GetBaseType
	o->GetBaseType = GetBaseType__1qej
#endif
#ifdef _ZFuncType90_GetParamSize
	o->GetParamSize = GetParamSize__1qej
#endif
#ifdef _ZFuncType90_GetParamType
	o->GetParamType = GetParamType__2qej
#endif
#ifdef _ZFuncType90_IsGreekType
	o->IsGreekType = IsGreekType__1qej
#endif
#ifdef _ZFuncType90_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qej
#endif
#ifdef _ZFuncType90_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qej
#endif
#ifdef _ZFuncType90_IsVarType
	o->IsVarType = IsVarType__1qej
#endif
	o->_nextId = 0;
}

static struct ZFuncType90 * _NewZFuncType90(void) {
	struct ZFuncType90 *o = LibZen_Malloc(sizeof(struct ZFuncType90));
	_InitZFuncType90(o);
	return o;
}

static struct ZFuncType90 * ZFuncType_FuncType_Z14 = ZFuncType__3qej(_NewZFuncType90(), "Func", NULL);
struct ZGenericType107 {
	int _classId60;
	int _delta60;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType60 * RefType;
	struct ZType60 * (*)(struct ZType60 *) GetRealType;
	struct ZType60 * (*)(struct ZType60 *) GetSuperType;
	struct ZType60 * (*)(struct ZType60 *) GetBaseType;
	long (*)(struct ZType60 *) GetParamSize;
	struct ZType60 * (*)(struct ZType60 *,long) GetParamType;
	int (*)(struct ZType60 *) IsGreekType;
	struct ZType60 * (*)(struct ZType60 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType60 *,struct ZType60 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType60 *) IsVarType;
	int _classId107;
	int _delta107;
	struct ZType60 * BaseType;
	struct ZType60 * ParamType;
	int _nextId;
};

static void _InitZGenericType107(struct ZGenericType107 * o) {
	_InitZType60((struct ZType60 *)o);
	o->_classId107 = 107;
	o->_delta107 = sizeof(struct ZGenericType107) - sizeof(struct ZType60);
	o->BaseType = NULL;
	o->ParamType = NULL;
#ifdef _ZGenericType107_GetRealType
	o->GetRealType = GetRealType__1qe8
#endif
#ifdef _ZGenericType107_GetSuperType
	o->GetSuperType = GetSuperType__1qe8
#endif
#ifdef _ZGenericType107_GetBaseType
	o->GetBaseType = GetBaseType__1qe8
#endif
#ifdef _ZGenericType107_GetParamSize
	o->GetParamSize = GetParamSize__1qe8
#endif
#ifdef _ZGenericType107_GetParamType
	o->GetParamType = GetParamType__2qe8
#endif
#ifdef _ZGenericType107_IsGreekType
	o->IsGreekType = IsGreekType__1qe8
#endif
#ifdef _ZGenericType107_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qe8
#endif
#ifdef _ZGenericType107_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qe8
#endif
#ifdef _ZGenericType107_IsVarType
	o->IsVarType = IsVarType__1qe8
#endif
	o->_nextId = 0;
}

static struct ZGenericType107 * _NewZGenericType107(void) {
	struct ZGenericType107 *o = LibZen_Malloc(sizeof(struct ZGenericType107));
	_InitZGenericType107(o);
	return o;
}

static struct ZGenericType107 * ZGenericType_ArrayType_Z15 = ZGenericType__5qe8(_NewZGenericType107(), ZTypeUniqueTypeFlag_Z1, "Array", NULL, ZTypeVarType_Z4);
static struct ZGenericType107 * ZGenericType_MapType_Z16 = ZGenericType__5qe8(_NewZGenericType107(), ZTypeUniqueTypeFlag_Z1, "Map", NULL, ZTypeVarType_Z4);
struct ZGreekType115 {
	int _classId60;
	int _delta60;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType60 * RefType;
	struct ZType60 * (*)(struct ZType60 *) GetRealType;
	struct ZType60 * (*)(struct ZType60 *) GetSuperType;
	struct ZType60 * (*)(struct ZType60 *) GetBaseType;
	long (*)(struct ZType60 *) GetParamSize;
	struct ZType60 * (*)(struct ZType60 *,long) GetParamType;
	int (*)(struct ZType60 *) IsGreekType;
	struct ZType60 * (*)(struct ZType60 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType60 *,struct ZType60 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType60 *) IsVarType;
	int _classId115;
	int _delta115;
	long GreekId;
	int _nextId;
};

static void _InitZGreekType115(struct ZGreekType115 * o) {
	_InitZType60((struct ZType60 *)o);
	o->_classId115 = 115;
	o->_delta115 = sizeof(struct ZGreekType115) - sizeof(struct ZType60);
	o->GreekId = 0;
#ifdef _ZGreekType115_GetRealType
	o->GetRealType = GetRealType__1qri
#endif
#ifdef _ZGreekType115_GetSuperType
	o->GetSuperType = GetSuperType__1qri
#endif
#ifdef _ZGreekType115_GetBaseType
	o->GetBaseType = GetBaseType__1qri
#endif
#ifdef _ZGreekType115_GetParamSize
	o->GetParamSize = GetParamSize__1qri
#endif
#ifdef _ZGreekType115_GetParamType
	o->GetParamType = GetParamType__2qri
#endif
#ifdef _ZGreekType115_IsGreekType
	o->IsGreekType = IsGreekType__1qri
#endif
#ifdef _ZGreekType115_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qri
#endif
#ifdef _ZGreekType115_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qri
#endif
#ifdef _ZGreekType115_IsVarType
	o->IsVarType = IsVarType__1qri
#endif
	o->_nextId = 0;
}

static struct ZGreekType115 * _NewZGreekType115(void) {
	struct ZGreekType115 *o = LibZen_Malloc(sizeof(struct ZGreekType115));
	_InitZGreekType115(o);
	return o;
}

struct ZPrototype121 {
	int _classId89;
	int _delta89;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType90 * FuncType;
	int _classId121;
	int _delta121;
	long DefinedCount;
	long UsedCount;
	int _nextId;
};

static void _InitZPrototype121(struct ZPrototype121 * o) {
	_InitZFunc89((struct ZFunc89 *)o);
	o->_classId121 = 121;
	o->_delta121 = sizeof(struct ZPrototype121) - sizeof(struct ZFunc89);
	o->DefinedCount = 0;
	o->UsedCount = 0;
	o->_nextId = 0;
}

static struct ZPrototype121 * _NewZPrototype121(void) {
	struct ZPrototype121 *o = LibZen_Malloc(sizeof(struct ZPrototype121));
	_InitZPrototype121(o);
	return o;
}

struct ZTypePool670 {
	int _classId670;
	int _delta670;
	int _nextId;
};

static void _InitZTypePool670(struct ZTypePool670 * o) {
	o->_classId670 = 670;
	o->_delta670 = sizeof(struct ZTypePool670) - sizeof(int);
	o->_nextId = 0;
}

static struct ZTypePool670 * _NewZTypePool670(void) {
	struct ZTypePool670 *o = LibZen_Malloc(sizeof(struct ZTypePool670));
	_InitZTypePool670(o);
	return o;
}

static ArrayOfZType * ZTypePool_TypeList_Z17 = LibZen_NewArray(0);
static MapOfZType * ZTypePool_ClassNameMap_Z18 = LibZen_NewMap(0);
static MapOfArrayOfZType * ZTypePool_UniqueTypeSetMap_Z19 = LibZen_NewMap(0);
struct ZVarScope134 {
	int _classId134;
	int _delta134;
	struct ZVarScope134 * Parent;
	struct ZLogger135 * Logger;
	ArrayOfZVarType * VarList;
	long VarNodeCount;
	long UnresolvedSymbolCount;
	int _nextId;
};

static void _InitZVarScope134(struct ZVarScope134 * o) {
	o->_classId134 = 134;
	o->_delta134 = sizeof(struct ZVarScope134) - sizeof(int);
	o->Parent = NULL;
	o->Logger = NULL;
	o->VarList = NULL;
	o->VarNodeCount = 0;
	o->UnresolvedSymbolCount = 0;
	o->_nextId = 0;
}

static struct ZVarScope134 * _NewZVarScope134(void) {
	struct ZVarScope134 *o = LibZen_Malloc(sizeof(struct ZVarScope134));
	_InitZVarScope134(o);
	return o;
}

struct ZVarType136 {
	int _classId60;
	int _delta60;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType60 * RefType;
	struct ZType60 * (*)(struct ZType60 *) GetRealType;
	struct ZType60 * (*)(struct ZType60 *) GetSuperType;
	struct ZType60 * (*)(struct ZType60 *) GetBaseType;
	long (*)(struct ZType60 *) GetParamSize;
	struct ZType60 * (*)(struct ZType60 *,long) GetParamType;
	int (*)(struct ZType60 *) IsGreekType;
	struct ZType60 * (*)(struct ZType60 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType60 *,struct ZType60 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType60 *) IsVarType;
	int _classId136;
	int _delta136;
	ArrayOfZVarType * VarList;
	struct ZToken77 * SourceToken;
	long GreekId;
	int _nextId;
};

static void _InitZVarType136(struct ZVarType136 * o) {
	_InitZType60((struct ZType60 *)o);
	o->_classId136 = 136;
	o->_delta136 = sizeof(struct ZVarType136) - sizeof(struct ZType60);
	o->VarList = NULL;
	o->SourceToken = NULL;
	o->GreekId = 0;
#ifdef _ZVarType136_GetRealType
	o->GetRealType = GetRealType__1qrb
#endif
#ifdef _ZVarType136_GetSuperType
	o->GetSuperType = GetSuperType__1qrb
#endif
#ifdef _ZVarType136_GetBaseType
	o->GetBaseType = GetBaseType__1qrb
#endif
#ifdef _ZVarType136_GetParamSize
	o->GetParamSize = GetParamSize__1qrb
#endif
#ifdef _ZVarType136_GetParamType
	o->GetParamType = GetParamType__2qrb
#endif
#ifdef _ZVarType136_IsGreekType
	o->IsGreekType = IsGreekType__1qrb
#endif
#ifdef _ZVarType136_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qrb
#endif
#ifdef _ZVarType136_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qrb
#endif
#ifdef _ZVarType136_IsVarType
	o->IsVarType = IsVarType__1qrb
#endif
	o->_nextId = 0;
}

static struct ZVarType136 * _NewZVarType136(void) {
	struct ZVarType136 *o = LibZen_Malloc(sizeof(struct ZVarType136));
	_InitZVarType136(o);
	return o;
}

struct ZNode52 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _nextId;
};

static void _InitZNode52(struct ZNode52 * o) {
	o->_classId52 = 52;
	o->_delta52 = sizeof(struct ZNode52) - sizeof(int);
	o->ParentNode = NULL;
	o->SourceToken = NULL;
	o->AST = NULL;
	o->Type = ZTypeVarType_Z4;
	o->HasUntypedNode = 1/*true*/;
	o->SetNameInfo = NULL;
	o->SetTypeInfo = NULL;
	o->IsBreakingBlock = NULL;
	o->DeSugar = NULL;
	o->Accept = NULL;
#ifdef _ZNode52_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qwg
#endif
#ifdef _ZNode52_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qwg
#endif
#ifdef _ZNode52_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qwg
#endif
#ifdef _ZNode52_DeSugar
	o->DeSugar = DeSugar__2qwg
#endif
#ifdef _ZNode52_Accept
	o->Accept = Accept__2qwg
#endif
	o->_nextId = 0;
}

static struct ZNode52 * _NewZNode52(void) {
	struct ZNode52 *o = LibZen_Malloc(sizeof(struct ZNode52));
	_InitZNode52(o);
	return o;
}

static long ZNode_Nop_Z20 = -1;
static long ZNode_NameInfo_Z21 = -2;
static long ZNode_TypeInfo_Z22 = -3;
static long ZNode_AppendIndex_Z23 = -4;
static long ZNode_NestedAppendIndex_Z24 = -5;
struct ZParamNode172 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId172;
	int _delta172;
	const char * Name;
	struct ZToken77 * NameToken;
	long ParamIndex;
	int _nextId;
};

static void _InitZParamNode172(struct ZParamNode172 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId172 = 172;
	o->_delta172 = sizeof(struct ZParamNode172) - sizeof(struct ZNode52);
	o->Name = NULL;
	o->NameToken = NULL;
	o->ParamIndex = 0;
#ifdef _ZParamNode172_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtb
#endif
#ifdef _ZParamNode172_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtb
#endif
#ifdef _ZParamNode172_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtb
#endif
#ifdef _ZParamNode172_DeSugar
	o->DeSugar = DeSugar__2qtb
#endif
#ifdef _ZParamNode172_Accept
	o->Accept = Accept__2qtb
#endif
	o->_nextId = 0;
}

static struct ZParamNode172 * _NewZParamNode172(void) {
	struct ZParamNode172 *o = LibZen_Malloc(sizeof(struct ZParamNode172));
	_InitZParamNode172(o);
	return o;
}

struct ZReturnNode170 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId170;
	int _delta170;
	int _nextId;
};

static void _InitZReturnNode170(struct ZReturnNode170 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId170 = 170;
	o->_delta170 = sizeof(struct ZReturnNode170) - sizeof(struct ZNode52);
#ifdef _ZReturnNode170_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtc
#endif
#ifdef _ZReturnNode170_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtc
#endif
#ifdef _ZReturnNode170_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtc
#endif
#ifdef _ZReturnNode170_DeSugar
	o->DeSugar = DeSugar__2qtc
#endif
#ifdef _ZReturnNode170_Accept
	o->Accept = Accept__2qtc
#endif
	o->_nextId = 0;
}

static struct ZReturnNode170 * _NewZReturnNode170(void) {
	struct ZReturnNode170 *o = LibZen_Malloc(sizeof(struct ZReturnNode170));
	_InitZReturnNode170(o);
	return o;
}

static long ZReturnNode_Expr_Z25 = 0;
struct ZSetIndexNode178 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId178;
	int _delta178;
	int _nextId;
};

static void _InitZSetIndexNode178(struct ZSetIndexNode178 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId178 = 178;
	o->_delta178 = sizeof(struct ZSetIndexNode178) - sizeof(struct ZNode52);
#ifdef _ZSetIndexNode178_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qt2
#endif
#ifdef _ZSetIndexNode178_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qt2
#endif
#ifdef _ZSetIndexNode178_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qt2
#endif
#ifdef _ZSetIndexNode178_DeSugar
	o->DeSugar = DeSugar__2qt2
#endif
#ifdef _ZSetIndexNode178_Accept
	o->Accept = Accept__2qt2
#endif
	o->_nextId = 0;
}

static struct ZSetIndexNode178 * _NewZSetIndexNode178(void) {
	struct ZSetIndexNode178 *o = LibZen_Malloc(sizeof(struct ZSetIndexNode178));
	_InitZSetIndexNode178(o);
	return o;
}

static long ZSetIndexNode_Recv_Z26 = 0;
static long ZSetIndexNode_Index_Z27 = 1;
static long ZSetIndexNode_Expr_Z28 = 2;
struct ZSetNameNode181 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId181;
	int _delta181;
	const char * VarName;
	long VarIndex;
	int IsCaptured;
	int _nextId;
};

static void _InitZSetNameNode181(struct ZSetNameNode181 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId181 = 181;
	o->_delta181 = sizeof(struct ZSetNameNode181) - sizeof(struct ZNode52);
	o->VarName = NULL;
	o->VarIndex = 0;
	o->IsCaptured = 0/*false*/;
#ifdef _ZSetNameNode181_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyw
#endif
#ifdef _ZSetNameNode181_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyw
#endif
#ifdef _ZSetNameNode181_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyw
#endif
#ifdef _ZSetNameNode181_DeSugar
	o->DeSugar = DeSugar__2qyw
#endif
#ifdef _ZSetNameNode181_Accept
	o->Accept = Accept__2qyw
#endif
	o->_nextId = 0;
}

static struct ZSetNameNode181 * _NewZSetNameNode181(void) {
	struct ZSetNameNode181 *o = LibZen_Malloc(sizeof(struct ZSetNameNode181));
	_InitZSetNameNode181(o);
	return o;
}

static long ZSetNameNode_Expr_Z29 = 0;
struct ZSetterNode184 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId184;
	int _delta184;
	const char * FieldName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZSetterNode184(struct ZSetterNode184 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId184 = 184;
	o->_delta184 = sizeof(struct ZSetterNode184) - sizeof(struct ZNode52);
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZSetterNode184_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyt
#endif
#ifdef _ZSetterNode184_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyt
#endif
#ifdef _ZSetterNode184_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyt
#endif
#ifdef _ZSetterNode184_DeSugar
	o->DeSugar = DeSugar__2qyt
#endif
#ifdef _ZSetterNode184_Accept
	o->Accept = Accept__2qyt
#endif
	o->_nextId = 0;
}

static struct ZSetterNode184 * _NewZSetterNode184(void) {
	struct ZSetterNode184 *o = LibZen_Malloc(sizeof(struct ZSetterNode184));
	_InitZSetterNode184(o);
	return o;
}

static long ZSetterNode_Recv_Z30 = 0;
static long ZSetterNode_Expr_Z31 = 1;
struct ZSugarNode165 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId165;
	int _delta165;
	struct ZNode52 * SugarNode;
	int _nextId;
};

static void _InitZSugarNode165(struct ZSugarNode165 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId165 = 165;
	o->_delta165 = sizeof(struct ZSugarNode165) - sizeof(struct ZNode52);
	o->SugarNode = NULL;
#ifdef _ZSugarNode165_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qt9
#endif
#ifdef _ZSugarNode165_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qt9
#endif
#ifdef _ZSugarNode165_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qt9
#endif
#ifdef _ZSugarNode165_DeSugar
	o->DeSugar = DeSugar__2qt9
#endif
#ifdef _ZSugarNode165_Accept
	o->Accept = Accept__2qt9
#endif
	o->_nextId = 0;
}

static struct ZSugarNode165 * _NewZSugarNode165(void) {
	struct ZSugarNode165 *o = LibZen_Malloc(sizeof(struct ZSugarNode165));
	_InitZSugarNode165(o);
	return o;
}

static long ZSugarNode_DeSugar_Z32 = 0;
struct ZThrowNode191 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId191;
	int _delta191;
	int _nextId;
};

static void _InitZThrowNode191(struct ZThrowNode191 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId191 = 191;
	o->_delta191 = sizeof(struct ZThrowNode191) - sizeof(struct ZNode52);
#ifdef _ZThrowNode191_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qy4
#endif
#ifdef _ZThrowNode191_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qy4
#endif
#ifdef _ZThrowNode191_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qy4
#endif
#ifdef _ZThrowNode191_DeSugar
	o->DeSugar = DeSugar__2qy4
#endif
#ifdef _ZThrowNode191_Accept
	o->Accept = Accept__2qy4
#endif
	o->_nextId = 0;
}

static struct ZThrowNode191 * _NewZThrowNode191(void) {
	struct ZThrowNode191 *o = LibZen_Malloc(sizeof(struct ZThrowNode191));
	_InitZThrowNode191(o);
	return o;
}

static long ZThrowNode_Expr_Z33 = 0;
struct ZTryNode194 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId194;
	int _delta194;
	int _nextId;
};

static void _InitZTryNode194(struct ZTryNode194 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId194 = 194;
	o->_delta194 = sizeof(struct ZTryNode194) - sizeof(struct ZNode52);
#ifdef _ZTryNode194_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyd
#endif
#ifdef _ZTryNode194_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyd
#endif
#ifdef _ZTryNode194_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyd
#endif
#ifdef _ZTryNode194_DeSugar
	o->DeSugar = DeSugar__2qyd
#endif
#ifdef _ZTryNode194_Accept
	o->Accept = Accept__2qyd
#endif
	o->_nextId = 0;
}

static struct ZTryNode194 * _NewZTryNode194(void) {
	struct ZTryNode194 *o = LibZen_Malloc(sizeof(struct ZTryNode194));
	_InitZTryNode194(o);
	return o;
}

static long ZTryNode_Try_Z34 = 0;
static long ZTryNode_Catch_Z35 = 1;
static long ZTryNode_Finally_Z36 = 2;
struct ZUnaryNode197 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId197;
	int _delta197;
	int _nextId;
};

static void _InitZUnaryNode197(struct ZUnaryNode197 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId197 = 197;
	o->_delta197 = sizeof(struct ZUnaryNode197) - sizeof(struct ZNode52);
#ifdef _ZUnaryNode197_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyh
#endif
#ifdef _ZUnaryNode197_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyh
#endif
#ifdef _ZUnaryNode197_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyh
#endif
#ifdef _ZUnaryNode197_DeSugar
	o->DeSugar = DeSugar__2qyh
#endif
#ifdef _ZUnaryNode197_Accept
	o->Accept = Accept__2qyh
#endif
	o->_nextId = 0;
}

static struct ZUnaryNode197 * _NewZUnaryNode197(void) {
	struct ZUnaryNode197 *o = LibZen_Malloc(sizeof(struct ZUnaryNode197));
	_InitZUnaryNode197(o);
	return o;
}

static long ZUnaryNode_Recv_Z37 = 0;
struct ZWhileNode200 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId200;
	int _delta200;
	int _nextId;
};

static void _InitZWhileNode200(struct ZWhileNode200 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId200 = 200;
	o->_delta200 = sizeof(struct ZWhileNode200) - sizeof(struct ZNode52);
#ifdef _ZWhileNode200_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyl
#endif
#ifdef _ZWhileNode200_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyl
#endif
#ifdef _ZWhileNode200_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyl
#endif
#ifdef _ZWhileNode200_DeSugar
	o->DeSugar = DeSugar__2qyl
#endif
#ifdef _ZWhileNode200_Accept
	o->Accept = Accept__2qyl
#endif
	o->_nextId = 0;
}

static struct ZWhileNode200 * _NewZWhileNode200(void) {
	struct ZWhileNode200 *o = LibZen_Malloc(sizeof(struct ZWhileNode200));
	_InitZWhileNode200(o);
	return o;
}

static long ZWhileNode_Cond_Z38 = 0;
static long ZWhileNode_Block_Z39 = 1;
struct ZEmptyValue203 {
	int _classId203;
	int _delta203;
	int _nextId;
};

static void _InitZEmptyValue203(struct ZEmptyValue203 * o) {
	o->_classId203 = 203;
	o->_delta203 = sizeof(struct ZEmptyValue203) - sizeof(int);
	o->_nextId = 0;
}

static struct ZEmptyValue203 * _NewZEmptyValue203(void) {
	struct ZEmptyValue203 *o = LibZen_Malloc(sizeof(struct ZEmptyValue203));
	_InitZEmptyValue203(o);
	return o;
}

static struct ZEmptyValue203 * ZEmptyValue_TrueEmpty_Z40 = _NewZEmptyValue203();
static struct ZEmptyValue203 * ZEmptyValue_FalseEmpty_Z41 = _NewZEmptyValue203();
struct ZLogger135 {
	int _classId135;
	int _delta135;
	ArrayOfString * ReportedErrorList;
	int _nextId;
};

static void _InitZLogger135(struct ZLogger135 * o) {
	o->_classId135 = 135;
	o->_delta135 = sizeof(struct ZLogger135) - sizeof(int);
	o->ReportedErrorList = LibZen_NewStringArray(0);
	o->_nextId = 0;
}

static struct ZLogger135 * _NewZLogger135(void) {
	struct ZLogger135 *o = LibZen_Malloc(sizeof(struct ZLogger135));
	_InitZLogger135(o);
	return o;
}

struct ZMacroFunc210 {
	int _classId89;
	int _delta89;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType90 * FuncType;
	int _classId210;
	int _delta210;
	int _nextId;
};

static void _InitZMacroFunc210(struct ZMacroFunc210 * o) {
	_InitZFunc89((struct ZFunc89 *)o);
	o->_classId210 = 210;
	o->_delta210 = sizeof(struct ZMacroFunc210) - sizeof(struct ZFunc89);
	o->_nextId = 0;
}

static struct ZMacroFunc210 * _NewZMacroFunc210(void) {
	struct ZMacroFunc210 *o = LibZen_Malloc(sizeof(struct ZMacroFunc210));
	_InitZMacroFunc210(o);
	return o;
}

struct ZNameSpace48 {
	int _classId48;
	int _delta48;
	struct ZNameSpace48 * ParentNameSpace;
	struct ZGenerator55 * Generator;
	long SerialId;
	ArrayOfZTokenFunc * TokenMatrix;
	MapOfZSyntax * SyntaxTable;
	MapOfZSymbolEntry * SymbolTable;
	int _nextId;
};

static void _InitZNameSpace48(struct ZNameSpace48 * o) {
	o->_classId48 = 48;
	o->_delta48 = sizeof(struct ZNameSpace48) - sizeof(int);
	o->ParentNameSpace = NULL;
	o->Generator = NULL;
	o->SerialId = 0;
	o->TokenMatrix = NULL;
	o->SyntaxTable = NULL;
	o->SymbolTable = NULL;
	o->_nextId = 0;
}

static struct ZNameSpace48 * _NewZNameSpace48(void) {
	struct ZNameSpace48 *o = LibZen_Malloc(sizeof(struct ZNameSpace48));
	_InitZNameSpace48(o);
	return o;
}

struct ZParserConst675 {
	int _classId675;
	int _delta675;
	int _nextId;
};

static void _InitZParserConst675(struct ZParserConst675 * o) {
	o->_classId675 = 675;
	o->_delta675 = sizeof(struct ZParserConst675) - sizeof(int);
	o->_nextId = 0;
}

static struct ZParserConst675 * _NewZParserConst675(void) {
	struct ZParserConst675 *o = LibZen_Malloc(sizeof(struct ZParserConst675));
	_InitZParserConst675(o);
	return o;
}

static const char * ProgName_Z42 = "LibZen";
static const char * CodeName_Z43 = "Reference Implementation of D-Script";
static long MajorVersion_Z44 = 0;
static long MinerVersion_Z45 = 1;
static long PatchLevel_Z46 = 0;
static const char * Version_Z47 = "0.1";
static const char * Copyright_Z48 = "Copyright (c) 2013-2014, Konoha project authors";
static const char * License_Z49 = "BSD-Style Open Source";
struct ZSource238 {
	int _classId238;
	int _delta238;
	struct ZTokenContext53 * TokenContext;
	struct ZLogger135 * Logger;
	const char * FileName;
	long LineNumber;
	const char * SourceText;
	int _nextId;
};

static void _InitZSource238(struct ZSource238 * o) {
	o->_classId238 = 238;
	o->_delta238 = sizeof(struct ZSource238) - sizeof(int);
	o->TokenContext = NULL;
	o->Logger = NULL;
	o->FileName = NULL;
	o->LineNumber = 0;
	o->SourceText = NULL;
	o->_nextId = 0;
}

static struct ZSource238 * _NewZSource238(void) {
	struct ZSource238 *o = LibZen_Malloc(sizeof(struct ZSource238));
	_InitZSource238(o);
	return o;
}

struct ZSourceBuilder42 {
	int _classId42;
	int _delta42;
	struct ZSourceGenerator243 * Template;
	ArrayOfString * SourceList;
	struct ZSourceBuilder42 * Parent;
	long IndentLevel;
	const char * CurrentIndentString;
	const char * BufferedLineComment;
	int _nextId;
};

static void _InitZSourceBuilder42(struct ZSourceBuilder42 * o) {
	o->_classId42 = 42;
	o->_delta42 = sizeof(struct ZSourceBuilder42) - sizeof(int);
	o->Template = NULL;
	o->SourceList = LibZen_NewStringArray(0);
	o->Parent = NULL;
	o->IndentLevel = 0;
	o->CurrentIndentString = "";
	o->BufferedLineComment = "";
	o->_nextId = 0;
}

static struct ZSourceBuilder42 * _NewZSourceBuilder42(void) {
	struct ZSourceBuilder42 *o = LibZen_Malloc(sizeof(struct ZSourceBuilder42));
	_InitZSourceBuilder42(o);
	return o;
}

struct ZSourceContext50 {
	int _classId238;
	int _delta238;
	struct ZTokenContext53 * TokenContext;
	struct ZLogger135 * Logger;
	const char * FileName;
	long LineNumber;
	const char * SourceText;
	int _classId50;
	int _delta50;
	long SourcePosition;
	int _nextId;
};

static void _InitZSourceContext50(struct ZSourceContext50 * o) {
	_InitZSource238((struct ZSource238 *)o);
	o->_classId50 = 50;
	o->_delta50 = sizeof(struct ZSourceContext50) - sizeof(struct ZSource238);
	o->SourcePosition = 0;
	o->_nextId = 0;
}

static struct ZSourceContext50 * _NewZSourceContext50(void) {
	struct ZSourceContext50 *o = LibZen_Malloc(sizeof(struct ZSourceContext50));
	_InitZSourceContext50(o);
	return o;
}

struct ZSourceMacro265 {
	int _classId89;
	int _delta89;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType90 * FuncType;
	int _classId210;
	int _delta210;
	int _classId265;
	int _delta265;
	const char * Macro;
	int _nextId;
};

static void _InitZSourceMacro265(struct ZSourceMacro265 * o) {
	_InitZMacroFunc210((struct ZMacroFunc210 *)o);
	o->_classId265 = 265;
	o->_delta265 = sizeof(struct ZSourceMacro265) - sizeof(struct ZMacroFunc210);
	o->Macro = NULL;
	o->_nextId = 0;
}

static struct ZSourceMacro265 * _NewZSourceMacro265(void) {
	struct ZSourceMacro265 *o = LibZen_Malloc(sizeof(struct ZSourceMacro265));
	_InitZSourceMacro265(o);
	return o;
}

struct ZSymbolEntry225 {
	int _classId225;
	int _delta225;
	struct ZSymbolEntry225 * Parent;
	struct ZNode52 * Node;
	int IsDisabled;
	int _nextId;
};

static void _InitZSymbolEntry225(struct ZSymbolEntry225 * o) {
	o->_classId225 = 225;
	o->_delta225 = sizeof(struct ZSymbolEntry225) - sizeof(int);
	o->Parent = NULL;
	o->Node = NULL;
	o->IsDisabled = 0/*false*/;
	o->_nextId = 0;
}

static struct ZSymbolEntry225 * _NewZSymbolEntry225(void) {
	struct ZSymbolEntry225 *o = LibZen_Malloc(sizeof(struct ZSymbolEntry225));
	_InitZSymbolEntry225(o);
	return o;
}

struct ZSyntax219 {
	int _classId219;
	int _delta219;
	struct ZNameSpace48 * PackageNameSpace;
	const char * PatternName;
	struct ZMatchFunction222 * MatchFunc;
	long SyntaxFlag;
	struct ZSyntax219 * ParentPattern;
	int IsDisabled;
	int IsStatement;
	int _nextId;
};

static void _InitZSyntax219(struct ZSyntax219 * o) {
	o->_classId219 = 219;
	o->_delta219 = sizeof(struct ZSyntax219) - sizeof(int);
	o->PackageNameSpace = NULL;
	o->PatternName = NULL;
	o->MatchFunc = NULL;
	o->SyntaxFlag = 0;
	o->ParentPattern = NULL;
	o->IsDisabled = 0/*false*/;
	o->IsStatement = 0/*false*/;
	o->_nextId = 0;
}

static struct ZSyntax219 * _NewZSyntax219(void) {
	struct ZSyntax219 *o = LibZen_Malloc(sizeof(struct ZSyntax219));
	_InitZSyntax219(o);
	return o;
}

static long ZSyntax_BinaryOperator_Z50 = 1;
static long ZSyntax_LeftJoin_Z51 = 1 << 1;
struct ZToken77 {
	int _classId77;
	int _delta77;
	struct ZSource238 * Source;
	long StartIndex;
	long EndIndex;
	int _nextId;
};

static void _InitZToken77(struct ZToken77 * o) {
	o->_classId77 = 77;
	o->_delta77 = sizeof(struct ZToken77) - sizeof(int);
	o->Source = NULL;
	o->StartIndex = 0;
	o->EndIndex = 0;
	o->_nextId = 0;
}

static struct ZToken77 * _NewZToken77(void) {
	struct ZToken77 *o = LibZen_Malloc(sizeof(struct ZToken77));
	_InitZToken77(o);
	return o;
}

static struct ZToken77 * ZToken_NullToken_Z52 = ZToken__4qey(_NewZToken77(), NULL, 0, 0);
struct ZTokenContext53 {
	int _classId53;
	int _delta53;
	struct ZGenerator55 * Generator;
	struct ZNameSpace48 * NameSpace;
	struct ZSourceContext50 * Source;
	ArrayOfZToken * TokenList;
	long CurrentPosition;
	int IsAllowSkipIndent;
	struct ZToken77 * LatestToken;
	struct ZSyntax219 * ApplyingPattern;
	int _nextId;
};

static void _InitZTokenContext53(struct ZTokenContext53 * o) {
	o->_classId53 = 53;
	o->_delta53 = sizeof(struct ZTokenContext53) - sizeof(int);
	o->Generator = NULL;
	o->NameSpace = NULL;
	o->Source = NULL;
	o->TokenList = LibZen_NewArray(0);
	o->CurrentPosition = 0;
	o->IsAllowSkipIndent = 0/*false*/;
	o->LatestToken = NULL;
	o->ApplyingPattern = NULL;
	o->_nextId = 0;
}

static struct ZTokenContext53 * _NewZTokenContext53(void) {
	struct ZTokenContext53 *o = LibZen_Malloc(sizeof(struct ZTokenContext53));
	_InitZTokenContext53(o);
	return o;
}

static int ZTokenContext_Required_Z53 = 1/*true*/;
static int ZTokenContext_Optional_Z54 = 0/*false*/;
static int ZTokenContext_AllowSkipIndent_Z55 = 1/*true*/;
static int ZTokenContext_NotAllowSkipIndent_Z56 = 0/*false*/;
static int ZTokenContext_AllowNewLine_Z57 = 1/*true*/;
static int ZTokenContext_MoveNext_Z58 = 1/*true*/;
struct ZTokenFunc35 {
	int _classId35;
	int _delta35;
	struct ZTokenFunction216 * Func;
	struct ZTokenFunc35 * ParentFunc;
	int _nextId;
};

static void _InitZTokenFunc35(struct ZTokenFunc35 * o) {
	o->_classId35 = 35;
	o->_delta35 = sizeof(struct ZTokenFunc35) - sizeof(int);
	o->Func = NULL;
	o->ParentFunc = NULL;
	o->_nextId = 0;
}

static struct ZTokenFunc35 * _NewZTokenFunc35(void) {
	struct ZTokenFunc35 *o = LibZen_Malloc(sizeof(struct ZTokenFunc35));
	_InitZTokenFunc35(o);
	return o;
}

struct ZVariable230 {
	int _classId225;
	int _delta225;
	struct ZSymbolEntry225 * Parent;
	struct ZNode52 * Node;
	int IsDisabled;
	int _classId230;
	int _delta230;
	long VarFlag;
	struct ZType60 * VarType;
	const char * VarName;
	long VarUniqueIndex;
	struct ZToken77 * SourceToken;
	long DefCount;
	long UsedCount;
	int _nextId;
};

static void _InitZVariable230(struct ZVariable230 * o) {
	_InitZSymbolEntry225((struct ZSymbolEntry225 *)o);
	o->_classId230 = 230;
	o->_delta230 = sizeof(struct ZVariable230) - sizeof(struct ZSymbolEntry225);
	o->VarFlag = 0;
	o->VarType = NULL;
	o->VarName = NULL;
	o->VarUniqueIndex = 0;
	o->SourceToken = NULL;
	o->DefCount = 0;
	o->UsedCount = 0;
	o->_nextId = 0;
}

static struct ZVariable230 * _NewZVariable230(void) {
	struct ZVariable230 *o = LibZen_Malloc(sizeof(struct ZVariable230));
	_InitZVariable230(o);
	return o;
}

struct ZVisitor167 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode418 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode472 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode376 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode343 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode430 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode477 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode398 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode411 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode359 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode349 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode363 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode354 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode346 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode402 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode406 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode391 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode415 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode320 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode372 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode310 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode328 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode498 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode421 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode502 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode366 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode317 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode379 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode512 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode335 *) VisitErrorNode;
	void (*)(struct ZVisitor167 *,struct ZNode52 *) VisitExtendedNode;
	void (*)(struct ZVisitor167 *,struct ZSugarNode165 *) VisitSugarNode;
	void (*)(struct ZVisitor167 *) EnableVisitor;
	void (*)(struct ZVisitor167 *) StopVisitor;
	int (*)(struct ZVisitor167 *) IsVisitable;
	int _nextId;
};

static void _InitZVisitor167(struct ZVisitor167 * o) {
	o->_classId167 = 167;
	o->_delta167 = sizeof(struct ZVisitor167) - sizeof(int);
	o->VisitNullNode = NULL;
	o->VisitBooleanNode = NULL;
	o->VisitIntNode = NULL;
	o->VisitFloatNode = NULL;
	o->VisitStringNode = NULL;
	o->VisitArrayLiteralNode = NULL;
	o->VisitMapLiteralNode = NULL;
	o->VisitNewObjectNode = NULL;
	o->VisitGlobalNameNode = NULL;
	o->VisitGetNameNode = NULL;
	o->VisitSetNameNode = NULL;
	o->VisitGroupNode = NULL;
	o->VisitGetterNode = NULL;
	o->VisitSetterNode = NULL;
	o->VisitGetIndexNode = NULL;
	o->VisitSetIndexNode = NULL;
	o->VisitMethodCallNode = NULL;
	o->VisitFuncCallNode = NULL;
	o->VisitMacroNode = NULL;
	o->VisitUnaryNode = NULL;
	o->VisitNotNode = NULL;
	o->VisitCastNode = NULL;
	o->VisitInstanceOfNode = NULL;
	o->VisitBinaryNode = NULL;
	o->VisitComparatorNode = NULL;
	o->VisitAndNode = NULL;
	o->VisitOrNode = NULL;
	o->VisitBlockNode = NULL;
	o->VisitVarNode = NULL;
	o->VisitIfNode = NULL;
	o->VisitReturnNode = NULL;
	o->VisitWhileNode = NULL;
	o->VisitBreakNode = NULL;
	o->VisitThrowNode = NULL;
	o->VisitTryNode = NULL;
	o->VisitLetNode = NULL;
	o->VisitFunctionNode = NULL;
	o->VisitClassNode = NULL;
	o->VisitErrorNode = NULL;
	o->VisitExtendedNode = NULL;
	o->VisitSugarNode = NULL;
	o->EnableVisitor = NULL;
	o->StopVisitor = NULL;
	o->IsVisitable = NULL;
#ifdef _ZVisitor167_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qt6
#endif
#ifdef _ZVisitor167_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qt6
#endif
#ifdef _ZVisitor167_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qt6
#endif
#ifdef _ZVisitor167_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qt6
#endif
#ifdef _ZVisitor167_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qt6
#endif
#ifdef _ZVisitor167_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qt6
#endif
#ifdef _ZVisitor167_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qt6
#endif
#ifdef _ZVisitor167_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qt6
#endif
#ifdef _ZVisitor167_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qt6
#endif
#ifdef _ZVisitor167_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qt6
#endif
#ifdef _ZVisitor167_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qt6
#endif
#ifdef _ZVisitor167_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qt6
#endif
#ifdef _ZVisitor167_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qt6
#endif
#ifdef _ZVisitor167_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qt6
#endif
#ifdef _ZVisitor167_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qt6
#endif
#ifdef _ZVisitor167_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qt6
#endif
#ifdef _ZVisitor167_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qt6
#endif
#ifdef _ZVisitor167_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qt6
#endif
#ifdef _ZVisitor167_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qt6
#endif
#ifdef _ZVisitor167_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qt6
#endif
#ifdef _ZVisitor167_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qt6
#endif
#ifdef _ZVisitor167_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qt6
#endif
#ifdef _ZVisitor167_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qt6
#endif
#ifdef _ZVisitor167_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qt6
#endif
#ifdef _ZVisitor167_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qt6
#endif
#ifdef _ZVisitor167_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qt6
#endif
#ifdef _ZVisitor167_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qt6
#endif
#ifdef _ZVisitor167_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qt6
#endif
#ifdef _ZVisitor167_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qt6
#endif
#ifdef _ZVisitor167_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qt6
#endif
#ifdef _ZVisitor167_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qt6
#endif
#ifdef _ZVisitor167_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qt6
#endif
#ifdef _ZVisitor167_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qt6
#endif
#ifdef _ZVisitor167_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qt6
#endif
#ifdef _ZVisitor167_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qt6
#endif
#ifdef _ZVisitor167_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qt6
#endif
#ifdef _ZVisitor167_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qt6
#endif
#ifdef _ZVisitor167_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qt6
#endif
#ifdef _ZVisitor167_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qt6
#endif
#ifdef _ZVisitor167_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qt6
#endif
#ifdef _ZVisitor167_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qt6
#endif
#ifdef _ZVisitor167_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qt6
#endif
#ifdef _ZVisitor167_StopVisitor
	o->StopVisitor = StopVisitor__1qt6
#endif
#ifdef _ZVisitor167_IsVisitable
	o->IsVisitable = IsVisitable__1qt6
#endif
	o->_nextId = 0;
}

static struct ZVisitor167 * _NewZVisitor167(void) {
	struct ZVisitor167 *o = LibZen_Malloc(sizeof(struct ZVisitor167));
	_InitZVisitor167(o);
	return o;
}

struct ZArrayType299 {
	int _classId60;
	int _delta60;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType60 * RefType;
	struct ZType60 * (*)(struct ZType60 *) GetRealType;
	struct ZType60 * (*)(struct ZType60 *) GetSuperType;
	struct ZType60 * (*)(struct ZType60 *) GetBaseType;
	long (*)(struct ZType60 *) GetParamSize;
	struct ZType60 * (*)(struct ZType60 *,long) GetParamType;
	int (*)(struct ZType60 *) IsGreekType;
	struct ZType60 * (*)(struct ZType60 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType60 *,struct ZType60 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType60 *) IsVarType;
	int _classId107;
	int _delta107;
	struct ZType60 * BaseType;
	struct ZType60 * ParamType;
	int _classId299;
	int _delta299;
	int _nextId;
};

static void _InitZArrayType299(struct ZArrayType299 * o) {
	_InitZGenericType107((struct ZGenericType107 *)o);
	o->_classId299 = 299;
	o->_delta299 = sizeof(struct ZArrayType299) - sizeof(struct ZGenericType107);
#ifdef _ZArrayType299_GetRealType
	o->GetRealType = GetRealType__1qo4
#endif
#ifdef _ZArrayType299_GetSuperType
	o->GetSuperType = GetSuperType__1qo4
#endif
#ifdef _ZArrayType299_GetBaseType
	o->GetBaseType = GetBaseType__1qo4
#endif
#ifdef _ZArrayType299_GetParamSize
	o->GetParamSize = GetParamSize__1qo4
#endif
#ifdef _ZArrayType299_GetParamType
	o->GetParamType = GetParamType__2qo4
#endif
#ifdef _ZArrayType299_IsGreekType
	o->IsGreekType = IsGreekType__1qo4
#endif
#ifdef _ZArrayType299_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qo4
#endif
#ifdef _ZArrayType299_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qo4
#endif
#ifdef _ZArrayType299_IsVarType
	o->IsVarType = IsVarType__1qo4
#endif
	o->_nextId = 0;
}

static struct ZArrayType299 * _NewZArrayType299(void) {
	struct ZArrayType299 *o = LibZen_Malloc(sizeof(struct ZArrayType299));
	_InitZArrayType299(o);
	return o;
}

struct ZAnnotationNode301 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId301;
	int _delta301;
	struct ZNode52 * AnnotatedNode;
	int _nextId;
};

static void _InitZAnnotationNode301(struct ZAnnotationNode301 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId301 = 301;
	o->_delta301 = sizeof(struct ZAnnotationNode301) - sizeof(struct ZNode52);
	o->AnnotatedNode = NULL;
#ifdef _ZAnnotationNode301_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qos
#endif
#ifdef _ZAnnotationNode301_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qos
#endif
#ifdef _ZAnnotationNode301_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qos
#endif
#ifdef _ZAnnotationNode301_DeSugar
	o->DeSugar = DeSugar__2qos
#endif
#ifdef _ZAnnotationNode301_Accept
	o->Accept = Accept__2qos
#endif
	o->_nextId = 0;
}

static struct ZAnnotationNode301 * _NewZAnnotationNode301(void) {
	struct ZAnnotationNode301 *o = LibZen_Malloc(sizeof(struct ZAnnotationNode301));
	_InitZAnnotationNode301(o);
	return o;
}

struct ZAssertNode307 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId307;
	int _delta307;
	int _nextId;
};

static void _InitZAssertNode307(struct ZAssertNode307 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId307 = 307;
	o->_delta307 = sizeof(struct ZAssertNode307) - sizeof(struct ZNode52);
#ifdef _ZAssertNode307_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qok
#endif
#ifdef _ZAssertNode307_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qok
#endif
#ifdef _ZAssertNode307_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qok
#endif
#ifdef _ZAssertNode307_DeSugar
	o->DeSugar = DeSugar__2qok
#endif
#ifdef _ZAssertNode307_Accept
	o->Accept = Accept__2qok
#endif
	o->_nextId = 0;
}

static struct ZAssertNode307 * _NewZAssertNode307(void) {
	struct ZAssertNode307 *o = LibZen_Malloc(sizeof(struct ZAssertNode307));
	_InitZAssertNode307(o);
	return o;
}

static long ZAssertNode_Expr_Z59 = 0;
struct ZBinaryNode310 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId310;
	int _delta310;
	struct ZSyntax219 * Pattern;
	int _nextId;
};

static void _InitZBinaryNode310(struct ZBinaryNode310 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId310 = 310;
	o->_delta310 = sizeof(struct ZBinaryNode310) - sizeof(struct ZNode52);
	o->Pattern = NULL;
#ifdef _ZBinaryNode310_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo1
#endif
#ifdef _ZBinaryNode310_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo1
#endif
#ifdef _ZBinaryNode310_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo1
#endif
#ifdef _ZBinaryNode310_DeSugar
	o->DeSugar = DeSugar__2qo1
#endif
#ifdef _ZBinaryNode310_Accept
	o->Accept = Accept__2qo1
#endif
	o->_nextId = 0;
}

static struct ZBinaryNode310 * _NewZBinaryNode310(void) {
	struct ZBinaryNode310 *o = LibZen_Malloc(sizeof(struct ZBinaryNode310));
	_InitZBinaryNode310(o);
	return o;
}

static long ZBinaryNode_Left_Z60 = 0;
static long ZBinaryNode_Right_Z61 = 1;
struct ZBreakNode317 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId317;
	int _delta317;
	int _nextId;
};

static void _InitZBreakNode317(struct ZBreakNode317 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId317 = 317;
	o->_delta317 = sizeof(struct ZBreakNode317) - sizeof(struct ZNode52);
#ifdef _ZBreakNode317_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qon
#endif
#ifdef _ZBreakNode317_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qon
#endif
#ifdef _ZBreakNode317_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qon
#endif
#ifdef _ZBreakNode317_DeSugar
	o->DeSugar = DeSugar__2qon
#endif
#ifdef _ZBreakNode317_Accept
	o->Accept = Accept__2qon
#endif
	o->_nextId = 0;
}

static struct ZBreakNode317 * _NewZBreakNode317(void) {
	struct ZBreakNode317 *o = LibZen_Malloc(sizeof(struct ZBreakNode317));
	_InitZBreakNode317(o);
	return o;
}

struct ZCastNode320 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId320;
	int _delta320;
	int _nextId;
};

static void _InitZCastNode320(struct ZCastNode320 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId320 = 320;
	o->_delta320 = sizeof(struct ZCastNode320) - sizeof(struct ZNode52);
#ifdef _ZCastNode320_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo5
#endif
#ifdef _ZCastNode320_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo5
#endif
#ifdef _ZCastNode320_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo5
#endif
#ifdef _ZCastNode320_DeSugar
	o->DeSugar = DeSugar__2qo5
#endif
#ifdef _ZCastNode320_Accept
	o->Accept = Accept__2qo5
#endif
	o->_nextId = 0;
}

static struct ZCastNode320 * _NewZCastNode320(void) {
	struct ZCastNode320 *o = LibZen_Malloc(sizeof(struct ZCastNode320));
	_InitZCastNode320(o);
	return o;
}

static long ZCastNode_Expr_Z62 = 0;
struct ZCatchNode324 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId324;
	int _delta324;
	struct ZType60 * ExceptionType;
	const char * ExceptionName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZCatchNode324(struct ZCatchNode324 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId324 = 324;
	o->_delta324 = sizeof(struct ZCatchNode324) - sizeof(struct ZNode52);
	o->ExceptionType = ZTypeVarType_Z4;
	o->ExceptionName = NULL;
	o->NameToken = NULL;
#ifdef _ZCatchNode324_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpq
#endif
#ifdef _ZCatchNode324_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpq
#endif
#ifdef _ZCatchNode324_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpq
#endif
#ifdef _ZCatchNode324_DeSugar
	o->DeSugar = DeSugar__2qpq
#endif
#ifdef _ZCatchNode324_Accept
	o->Accept = Accept__2qpq
#endif
	o->_nextId = 0;
}

static struct ZCatchNode324 * _NewZCatchNode324(void) {
	struct ZCatchNode324 *o = LibZen_Malloc(sizeof(struct ZCatchNode324));
	_InitZCatchNode324(o);
	return o;
}

static long ZCatchNode_Block_Z63 = 0;
struct ZComparatorNode328 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId310;
	int _delta310;
	struct ZSyntax219 * Pattern;
	int _classId328;
	int _delta328;
	int _nextId;
};

static void _InitZComparatorNode328(struct ZComparatorNode328 * o) {
	_InitZBinaryNode310((struct ZBinaryNode310 *)o);
	o->_classId328 = 328;
	o->_delta328 = sizeof(struct ZComparatorNode328) - sizeof(struct ZBinaryNode310);
#ifdef _ZComparatorNode328_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpt
#endif
#ifdef _ZComparatorNode328_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpt
#endif
#ifdef _ZComparatorNode328_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpt
#endif
#ifdef _ZComparatorNode328_DeSugar
	o->DeSugar = DeSugar__2qpt
#endif
#ifdef _ZComparatorNode328_Accept
	o->Accept = Accept__2qpt
#endif
	o->_nextId = 0;
}

static struct ZComparatorNode328 * _NewZComparatorNode328(void) {
	struct ZComparatorNode328 *o = LibZen_Malloc(sizeof(struct ZComparatorNode328));
	_InitZComparatorNode328(o);
	return o;
}

struct ZConstNode331 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _nextId;
};

static void _InitZConstNode331(struct ZConstNode331 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId331 = 331;
	o->_delta331 = sizeof(struct ZConstNode331) - sizeof(struct ZNode52);
#ifdef _ZConstNode331_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpi
#endif
#ifdef _ZConstNode331_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpi
#endif
#ifdef _ZConstNode331_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpi
#endif
#ifdef _ZConstNode331_DeSugar
	o->DeSugar = DeSugar__2qpi
#endif
#ifdef _ZConstNode331_Accept
	o->Accept = Accept__2qpi
#endif
	o->_nextId = 0;
}

static struct ZConstNode331 * _NewZConstNode331(void) {
	struct ZConstNode331 *o = LibZen_Malloc(sizeof(struct ZConstNode331));
	_InitZConstNode331(o);
	return o;
}

struct ZEmptyNode333 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId333;
	int _delta333;
	int _nextId;
};

static void _InitZEmptyNode333(struct ZEmptyNode333 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId333 = 333;
	o->_delta333 = sizeof(struct ZEmptyNode333) - sizeof(struct ZNode52);
#ifdef _ZEmptyNode333_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpp
#endif
#ifdef _ZEmptyNode333_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpp
#endif
#ifdef _ZEmptyNode333_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpp
#endif
#ifdef _ZEmptyNode333_DeSugar
	o->DeSugar = DeSugar__2qpp
#endif
#ifdef _ZEmptyNode333_Accept
	o->Accept = Accept__2qpp
#endif
	o->_nextId = 0;
}

static struct ZEmptyNode333 * _NewZEmptyNode333(void) {
	struct ZEmptyNode333 *o = LibZen_Malloc(sizeof(struct ZEmptyNode333));
	_InitZEmptyNode333(o);
	return o;
}

struct ZErrorNode335 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId335;
	int _delta335;
	const char * ErrorMessage;
	int _nextId;
};

static void _InitZErrorNode335(struct ZErrorNode335 * o) {
	_InitZConstNode331((struct ZConstNode331 *)o);
	o->_classId335 = 335;
	o->_delta335 = sizeof(struct ZErrorNode335) - sizeof(struct ZConstNode331);
	o->ErrorMessage = NULL;
#ifdef _ZErrorNode335_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp4
#endif
#ifdef _ZErrorNode335_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp4
#endif
#ifdef _ZErrorNode335_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp4
#endif
#ifdef _ZErrorNode335_DeSugar
	o->DeSugar = DeSugar__2qp4
#endif
#ifdef _ZErrorNode335_Accept
	o->Accept = Accept__2qp4
#endif
	o->_nextId = 0;
}

static struct ZErrorNode335 * _NewZErrorNode335(void) {
	struct ZErrorNode335 *o = LibZen_Malloc(sizeof(struct ZErrorNode335));
	_InitZErrorNode335(o);
	return o;
}

struct ZFieldNode339 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId339;
	int _delta339;
	struct ZClassType80 * ClassType;
	struct ZType60 * DeclType;
	const char * FieldName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZFieldNode339(struct ZFieldNode339 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId339 = 339;
	o->_delta339 = sizeof(struct ZFieldNode339) - sizeof(struct ZNode52);
	o->ClassType = NULL;
	o->DeclType = ZTypeVarType_Z4;
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZFieldNode339_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpf
#endif
#ifdef _ZFieldNode339_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpf
#endif
#ifdef _ZFieldNode339_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpf
#endif
#ifdef _ZFieldNode339_DeSugar
	o->DeSugar = DeSugar__2qpf
#endif
#ifdef _ZFieldNode339_Accept
	o->Accept = Accept__2qpf
#endif
	o->_nextId = 0;
}

static struct ZFieldNode339 * _NewZFieldNode339(void) {
	struct ZFieldNode339 *o = LibZen_Malloc(sizeof(struct ZFieldNode339));
	_InitZFieldNode339(o);
	return o;
}

static long ZFieldNode_InitValue_Z64 = 0;
struct ZFloatNode343 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId343;
	int _delta343;
	double FloatValue;
	int _nextId;
};

static void _InitZFloatNode343(struct ZFloatNode343 * o) {
	_InitZConstNode331((struct ZConstNode331 *)o);
	o->_classId343 = 343;
	o->_delta343 = sizeof(struct ZFloatNode343) - sizeof(struct ZConstNode331);
	o->FloatValue = 0.0;
#ifdef _ZFloatNode343_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpk
#endif
#ifdef _ZFloatNode343_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpk
#endif
#ifdef _ZFloatNode343_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpk
#endif
#ifdef _ZFloatNode343_DeSugar
	o->DeSugar = DeSugar__2qpk
#endif
#ifdef _ZFloatNode343_Accept
	o->Accept = Accept__2qpk
#endif
	o->_nextId = 0;
}

static struct ZFloatNode343 * _NewZFloatNode343(void) {
	struct ZFloatNode343 *o = LibZen_Malloc(sizeof(struct ZFloatNode343));
	_InitZFloatNode343(o);
	return o;
}

struct ZGetIndexNode346 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId346;
	int _delta346;
	int _nextId;
};

static void _InitZGetIndexNode346(struct ZGetIndexNode346 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId346 = 346;
	o->_delta346 = sizeof(struct ZGetIndexNode346) - sizeof(struct ZNode52);
#ifdef _ZGetIndexNode346_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp1
#endif
#ifdef _ZGetIndexNode346_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp1
#endif
#ifdef _ZGetIndexNode346_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp1
#endif
#ifdef _ZGetIndexNode346_DeSugar
	o->DeSugar = DeSugar__2qp1
#endif
#ifdef _ZGetIndexNode346_Accept
	o->Accept = Accept__2qp1
#endif
	o->_nextId = 0;
}

static struct ZGetIndexNode346 * _NewZGetIndexNode346(void) {
	struct ZGetIndexNode346 *o = LibZen_Malloc(sizeof(struct ZGetIndexNode346));
	_InitZGetIndexNode346(o);
	return o;
}

static long ZGetIndexNode_Recv_Z65 = 0;
static long ZGetIndexNode_Index_Z66 = 1;
struct ZGetNameNode349 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId349;
	int _delta349;
	int IsCaptured;
	const char * VarName;
	long VarIndex;
	int _nextId;
};

static void _InitZGetNameNode349(struct ZGetNameNode349 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId349 = 349;
	o->_delta349 = sizeof(struct ZGetNameNode349) - sizeof(struct ZNode52);
	o->IsCaptured = 0/*false*/;
	o->VarName = NULL;
	o->VarIndex = 0;
#ifdef _ZGetNameNode349_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpx
#endif
#ifdef _ZGetNameNode349_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpx
#endif
#ifdef _ZGetNameNode349_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpx
#endif
#ifdef _ZGetNameNode349_DeSugar
	o->DeSugar = DeSugar__2qpx
#endif
#ifdef _ZGetNameNode349_Accept
	o->Accept = Accept__2qpx
#endif
	o->_nextId = 0;
}

static struct ZGetNameNode349 * _NewZGetNameNode349(void) {
	struct ZGetNameNode349 *o = LibZen_Malloc(sizeof(struct ZGetNameNode349));
	_InitZGetNameNode349(o);
	return o;
}

struct ZGetterNode354 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId354;
	int _delta354;
	const char * FieldName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZGetterNode354(struct ZGetterNode354 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId354 = 354;
	o->_delta354 = sizeof(struct ZGetterNode354) - sizeof(struct ZNode52);
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZGetterNode354_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpm
#endif
#ifdef _ZGetterNode354_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpm
#endif
#ifdef _ZGetterNode354_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpm
#endif
#ifdef _ZGetterNode354_DeSugar
	o->DeSugar = DeSugar__2qpm
#endif
#ifdef _ZGetterNode354_Accept
	o->Accept = Accept__2qpm
#endif
	o->_nextId = 0;
}

static struct ZGetterNode354 * _NewZGetterNode354(void) {
	struct ZGetterNode354 *o = LibZen_Malloc(sizeof(struct ZGetterNode354));
	_InitZGetterNode354(o);
	return o;
}

static long ZGetterNode_Recv_Z67 = 0;
struct ZGlobalNameNode359 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId359;
	int _delta359;
	const char * GlobalName;
	int IsStaticFuncName;
	int _nextId;
};

static void _InitZGlobalNameNode359(struct ZGlobalNameNode359 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId359 = 359;
	o->_delta359 = sizeof(struct ZGlobalNameNode359) - sizeof(struct ZNode52);
	o->GlobalName = NULL;
	o->IsStaticFuncName = 0/*false*/;
#ifdef _ZGlobalNameNode359_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp8
#endif
#ifdef _ZGlobalNameNode359_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp8
#endif
#ifdef _ZGlobalNameNode359_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp8
#endif
#ifdef _ZGlobalNameNode359_DeSugar
	o->DeSugar = DeSugar__2qp8
#endif
#ifdef _ZGlobalNameNode359_Accept
	o->Accept = Accept__2qp8
#endif
	o->_nextId = 0;
}

static struct ZGlobalNameNode359 * _NewZGlobalNameNode359(void) {
	struct ZGlobalNameNode359 *o = LibZen_Malloc(sizeof(struct ZGlobalNameNode359));
	_InitZGlobalNameNode359(o);
	return o;
}

struct ZGroupNode363 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId363;
	int _delta363;
	int _nextId;
};

static void _InitZGroupNode363(struct ZGroupNode363 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId363 = 363;
	o->_delta363 = sizeof(struct ZGroupNode363) - sizeof(struct ZNode52);
#ifdef _ZGroupNode363_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0r
#endif
#ifdef _ZGroupNode363_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0r
#endif
#ifdef _ZGroupNode363_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0r
#endif
#ifdef _ZGroupNode363_DeSugar
	o->DeSugar = DeSugar__2q0r
#endif
#ifdef _ZGroupNode363_Accept
	o->Accept = Accept__2q0r
#endif
	o->_nextId = 0;
}

static struct ZGroupNode363 * _NewZGroupNode363(void) {
	struct ZGroupNode363 *o = LibZen_Malloc(sizeof(struct ZGroupNode363));
	_InitZGroupNode363(o);
	return o;
}

static long ZGroupNode_Expr_Z68 = 0;
struct ZIfNode366 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId366;
	int _delta366;
	int _nextId;
};

static void _InitZIfNode366(struct ZIfNode366 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId366 = 366;
	o->_delta366 = sizeof(struct ZIfNode366) - sizeof(struct ZNode52);
#ifdef _ZIfNode366_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0u
#endif
#ifdef _ZIfNode366_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0u
#endif
#ifdef _ZIfNode366_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0u
#endif
#ifdef _ZIfNode366_DeSugar
	o->DeSugar = DeSugar__2q0u
#endif
#ifdef _ZIfNode366_Accept
	o->Accept = Accept__2q0u
#endif
	o->_nextId = 0;
}

static struct ZIfNode366 * _NewZIfNode366(void) {
	struct ZIfNode366 *o = LibZen_Malloc(sizeof(struct ZIfNode366));
	_InitZIfNode366(o);
	return o;
}

static long ZIfNode_Cond_Z69 = 0;
static long ZIfNode_Then_Z70 = 1;
static long ZIfNode_Else_Z71 = 2;
struct ZImportNode369 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId369;
	int _delta369;
	const char * ResourcePath;
	const char * Alias;
	struct ZToken77 * ResourceToken;
	struct ZNode52 * (*)(struct ZImportNode369 *) Import;
	int _nextId;
};

static void _InitZImportNode369(struct ZImportNode369 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId369 = 369;
	o->_delta369 = sizeof(struct ZImportNode369) - sizeof(struct ZNode52);
	o->ResourcePath = NULL;
	o->Alias = NULL;
	o->ResourceToken = NULL;
	o->Import = NULL;
#ifdef _ZImportNode369_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0p
#endif
#ifdef _ZImportNode369_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0p
#endif
#ifdef _ZImportNode369_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0p
#endif
#ifdef _ZImportNode369_DeSugar
	o->DeSugar = DeSugar__2q0p
#endif
#ifdef _ZImportNode369_Accept
	o->Accept = Accept__2q0p
#endif
#ifdef _ZImportNode369_Import
	o->Import = Import__1q0p
#endif
	o->_nextId = 0;
}

static struct ZImportNode369 * _NewZImportNode369(void) {
	struct ZImportNode369 *o = LibZen_Malloc(sizeof(struct ZImportNode369));
	_InitZImportNode369(o);
	return o;
}

struct ZInstanceOfNode372 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId372;
	int _delta372;
	struct ZType60 * TargetType;
	int _nextId;
};

static void _InitZInstanceOfNode372(struct ZInstanceOfNode372 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId372 = 372;
	o->_delta372 = sizeof(struct ZInstanceOfNode372) - sizeof(struct ZNode52);
	o->TargetType = NULL;
#ifdef _ZInstanceOfNode372_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0a
#endif
#ifdef _ZInstanceOfNode372_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0a
#endif
#ifdef _ZInstanceOfNode372_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0a
#endif
#ifdef _ZInstanceOfNode372_DeSugar
	o->DeSugar = DeSugar__2q0a
#endif
#ifdef _ZInstanceOfNode372_Accept
	o->Accept = Accept__2q0a
#endif
	o->_nextId = 0;
}

static struct ZInstanceOfNode372 * _NewZInstanceOfNode372(void) {
	struct ZInstanceOfNode372 *o = LibZen_Malloc(sizeof(struct ZInstanceOfNode372));
	_InitZInstanceOfNode372(o);
	return o;
}

static long ZInstanceOfNode_Left_Z72 = 0;
struct ZIntNode376 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId376;
	int _delta376;
	long IntValue;
	int _nextId;
};

static void _InitZIntNode376(struct ZIntNode376 * o) {
	_InitZConstNode331((struct ZConstNode331 *)o);
	o->_classId376 = 376;
	o->_delta376 = sizeof(struct ZIntNode376) - sizeof(struct ZConstNode331);
	o->IntValue = 0;
#ifdef _ZIntNode376_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0g
#endif
#ifdef _ZIntNode376_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0g
#endif
#ifdef _ZIntNode376_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0g
#endif
#ifdef _ZIntNode376_DeSugar
	o->DeSugar = DeSugar__2q0g
#endif
#ifdef _ZIntNode376_Accept
	o->Accept = Accept__2q0g
#endif
	o->_nextId = 0;
}

static struct ZIntNode376 * _NewZIntNode376(void) {
	struct ZIntNode376 *o = LibZen_Malloc(sizeof(struct ZIntNode376));
	_InitZIntNode376(o);
	return o;
}

struct ZLetNode379 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId379;
	int _delta379;
	const char * Symbol;
	struct ZToken77 * SymbolToken;
	struct ZType60 * SymbolType;
	const char * GlobalName;
	int _nextId;
};

static void _InitZLetNode379(struct ZLetNode379 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId379 = 379;
	o->_delta379 = sizeof(struct ZLetNode379) - sizeof(struct ZNode52);
	o->Symbol = NULL;
	o->SymbolToken = NULL;
	o->SymbolType = ZTypeVarType_Z4;
	o->GlobalName = NULL;
#ifdef _ZLetNode379_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0k
#endif
#ifdef _ZLetNode379_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0k
#endif
#ifdef _ZLetNode379_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0k
#endif
#ifdef _ZLetNode379_DeSugar
	o->DeSugar = DeSugar__2q0k
#endif
#ifdef _ZLetNode379_Accept
	o->Accept = Accept__2q0k
#endif
	o->_nextId = 0;
}

static struct ZLetNode379 * _NewZLetNode379(void) {
	struct ZLetNode379 *o = LibZen_Malloc(sizeof(struct ZLetNode379));
	_InitZLetNode379(o);
	return o;
}

static long ZLetNode_InitValue_Z73 = 0;
struct ZListNode251 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _nextId;
};

static void _InitZListNode251(struct ZListNode251 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId251 = 251;
	o->_delta251 = sizeof(struct ZListNode251) - sizeof(struct ZNode52);
	o->ListStartIndex = 0;
#ifdef _ZListNode251_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qu8
#endif
#ifdef _ZListNode251_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qu8
#endif
#ifdef _ZListNode251_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qu8
#endif
#ifdef _ZListNode251_DeSugar
	o->DeSugar = DeSugar__2qu8
#endif
#ifdef _ZListNode251_Accept
	o->Accept = Accept__2qu8
#endif
	o->_nextId = 0;
}

static struct ZListNode251 * _NewZListNode251(void) {
	struct ZListNode251 *o = LibZen_Malloc(sizeof(struct ZListNode251));
	_InitZListNode251(o);
	return o;
}

struct ZMacroNode391 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId391;
	int _delta391;
	struct ZMacroFunc210 * MacroFunc;
	int _nextId;
};

static void _InitZMacroNode391(struct ZMacroNode391 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId391 = 391;
	o->_delta391 = sizeof(struct ZMacroNode391) - sizeof(struct ZListNode251);
	o->MacroFunc = NULL;
#ifdef _ZMacroNode391_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q07
#endif
#ifdef _ZMacroNode391_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q07
#endif
#ifdef _ZMacroNode391_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q07
#endif
#ifdef _ZMacroNode391_DeSugar
	o->DeSugar = DeSugar__2q07
#endif
#ifdef _ZMacroNode391_Accept
	o->Accept = Accept__2q07
#endif
	o->_nextId = 0;
}

static struct ZMacroNode391 * _NewZMacroNode391(void) {
	struct ZMacroNode391 *o = LibZen_Malloc(sizeof(struct ZMacroNode391));
	_InitZMacroNode391(o);
	return o;
}

struct ZMapEntryNode396 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId396;
	int _delta396;
	const char * Name;
	int _nextId;
};

static void _InitZMapEntryNode396(struct ZMapEntryNode396 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId396 = 396;
	o->_delta396 = sizeof(struct ZMapEntryNode396) - sizeof(struct ZNode52);
	o->Name = NULL;
#ifdef _ZMapEntryNode396_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4q
#endif
#ifdef _ZMapEntryNode396_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4q
#endif
#ifdef _ZMapEntryNode396_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4q
#endif
#ifdef _ZMapEntryNode396_DeSugar
	o->DeSugar = DeSugar__2q4q
#endif
#ifdef _ZMapEntryNode396_Accept
	o->Accept = Accept__2q4q
#endif
	o->_nextId = 0;
}

static struct ZMapEntryNode396 * _NewZMapEntryNode396(void) {
	struct ZMapEntryNode396 *o = LibZen_Malloc(sizeof(struct ZMapEntryNode396));
	_InitZMapEntryNode396(o);
	return o;
}

static long ZMapEntryNode_Key_Z74 = 0;
static long ZMapEntryNode_Value_Z75 = 1;
struct ZMapLiteralNode398 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId398;
	int _delta398;
	int _nextId;
};

static void _InitZMapLiteralNode398(struct ZMapLiteralNode398 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId398 = 398;
	o->_delta398 = sizeof(struct ZMapLiteralNode398) - sizeof(struct ZListNode251);
#ifdef _ZMapLiteralNode398_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4e
#endif
#ifdef _ZMapLiteralNode398_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4e
#endif
#ifdef _ZMapLiteralNode398_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4e
#endif
#ifdef _ZMapLiteralNode398_DeSugar
	o->DeSugar = DeSugar__2q4e
#endif
#ifdef _ZMapLiteralNode398_Accept
	o->Accept = Accept__2q4e
#endif
	o->_nextId = 0;
}

static struct ZMapLiteralNode398 * _NewZMapLiteralNode398(void) {
	struct ZMapLiteralNode398 *o = LibZen_Malloc(sizeof(struct ZMapLiteralNode398));
	_InitZMapLiteralNode398(o);
	return o;
}

struct ZMethodCallNode402 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId402;
	int _delta402;
	const char * MethodName;
	struct ZToken77 * MethodToken;
	int _nextId;
};

static void _InitZMethodCallNode402(struct ZMethodCallNode402 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId402 = 402;
	o->_delta402 = sizeof(struct ZMethodCallNode402) - sizeof(struct ZListNode251);
	o->MethodName = NULL;
	o->MethodToken = NULL;
#ifdef _ZMethodCallNode402_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4u
#endif
#ifdef _ZMethodCallNode402_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4u
#endif
#ifdef _ZMethodCallNode402_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4u
#endif
#ifdef _ZMethodCallNode402_DeSugar
	o->DeSugar = DeSugar__2q4u
#endif
#ifdef _ZMethodCallNode402_Accept
	o->Accept = Accept__2q4u
#endif
	o->_nextId = 0;
}

static struct ZMethodCallNode402 * _NewZMethodCallNode402(void) {
	struct ZMethodCallNode402 *o = LibZen_Malloc(sizeof(struct ZMethodCallNode402));
	_InitZMethodCallNode402(o);
	return o;
}

static long ZMethodCallNode_Recv_Z76 = 0;
struct ZNewArrayNode409 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId409;
	int _delta409;
	int _nextId;
};

static void _InitZNewArrayNode409(struct ZNewArrayNode409 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId409 = 409;
	o->_delta409 = sizeof(struct ZNewArrayNode409) - sizeof(struct ZListNode251);
#ifdef _ZNewArrayNode409_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4s
#endif
#ifdef _ZNewArrayNode409_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4s
#endif
#ifdef _ZNewArrayNode409_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4s
#endif
#ifdef _ZNewArrayNode409_DeSugar
	o->DeSugar = DeSugar__2q4s
#endif
#ifdef _ZNewArrayNode409_Accept
	o->Accept = Accept__2q4s
#endif
	o->_nextId = 0;
}

static struct ZNewArrayNode409 * _NewZNewArrayNode409(void) {
	struct ZNewArrayNode409 *o = LibZen_Malloc(sizeof(struct ZNewArrayNode409));
	_InitZNewArrayNode409(o);
	return o;
}

struct ZNewObjectNode411 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId411;
	int _delta411;
	int _nextId;
};

static void _InitZNewObjectNode411(struct ZNewObjectNode411 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId411 = 411;
	o->_delta411 = sizeof(struct ZNewObjectNode411) - sizeof(struct ZListNode251);
#ifdef _ZNewObjectNode411_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4f
#endif
#ifdef _ZNewObjectNode411_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4f
#endif
#ifdef _ZNewObjectNode411_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4f
#endif
#ifdef _ZNewObjectNode411_DeSugar
	o->DeSugar = DeSugar__2q4f
#endif
#ifdef _ZNewObjectNode411_Accept
	o->Accept = Accept__2q4f
#endif
	o->_nextId = 0;
}

static struct ZNewObjectNode411 * _NewZNewObjectNode411(void) {
	struct ZNewObjectNode411 *o = LibZen_Malloc(sizeof(struct ZNewObjectNode411));
	_InitZNewObjectNode411(o);
	return o;
}

struct ZNotNode415 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId197;
	int _delta197;
	int _classId415;
	int _delta415;
	int _nextId;
};

static void _InitZNotNode415(struct ZNotNode415 * o) {
	_InitZUnaryNode197((struct ZUnaryNode197 *)o);
	o->_classId415 = 415;
	o->_delta415 = sizeof(struct ZNotNode415) - sizeof(struct ZUnaryNode197);
#ifdef _ZNotNode415_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4k
#endif
#ifdef _ZNotNode415_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4k
#endif
#ifdef _ZNotNode415_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4k
#endif
#ifdef _ZNotNode415_DeSugar
	o->DeSugar = DeSugar__2q4k
#endif
#ifdef _ZNotNode415_Accept
	o->Accept = Accept__2q4k
#endif
	o->_nextId = 0;
}

static struct ZNotNode415 * _NewZNotNode415(void) {
	struct ZNotNode415 *o = LibZen_Malloc(sizeof(struct ZNotNode415));
	_InitZNotNode415(o);
	return o;
}

struct ZNullNode418 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId418;
	int _delta418;
	int _nextId;
};

static void _InitZNullNode418(struct ZNullNode418 * o) {
	_InitZConstNode331((struct ZConstNode331 *)o);
	o->_classId418 = 418;
	o->_delta418 = sizeof(struct ZNullNode418) - sizeof(struct ZConstNode331);
#ifdef _ZNullNode418_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q41
#endif
#ifdef _ZNullNode418_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q41
#endif
#ifdef _ZNullNode418_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q41
#endif
#ifdef _ZNullNode418_DeSugar
	o->DeSugar = DeSugar__2q41
#endif
#ifdef _ZNullNode418_Accept
	o->Accept = Accept__2q41
#endif
	o->_nextId = 0;
}

static struct ZNullNode418 * _NewZNullNode418(void) {
	struct ZNullNode418 *o = LibZen_Malloc(sizeof(struct ZNullNode418));
	_InitZNullNode418(o);
	return o;
}

struct ZOrNode421 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId310;
	int _delta310;
	struct ZSyntax219 * Pattern;
	int _classId421;
	int _delta421;
	int _nextId;
};

static void _InitZOrNode421(struct ZOrNode421 * o) {
	_InitZBinaryNode310((struct ZBinaryNode310 *)o);
	o->_classId421 = 421;
	o->_delta421 = sizeof(struct ZOrNode421) - sizeof(struct ZBinaryNode310);
#ifdef _ZOrNode421_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4x
#endif
#ifdef _ZOrNode421_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4x
#endif
#ifdef _ZOrNode421_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4x
#endif
#ifdef _ZOrNode421_DeSugar
	o->DeSugar = DeSugar__2q4x
#endif
#ifdef _ZOrNode421_Accept
	o->Accept = Accept__2q4x
#endif
	o->_nextId = 0;
}

static struct ZOrNode421 * _NewZOrNode421(void) {
	struct ZOrNode421 *o = LibZen_Malloc(sizeof(struct ZOrNode421));
	_InitZOrNode421(o);
	return o;
}

struct ZPrototypeNode424 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId424;
	int _delta424;
	struct ZType60 * ReturnType;
	const char * FuncName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZPrototypeNode424(struct ZPrototypeNode424 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId424 = 424;
	o->_delta424 = sizeof(struct ZPrototypeNode424) - sizeof(struct ZListNode251);
	o->ReturnType = ZTypeVarType_Z4;
	o->FuncName = NULL;
	o->NameToken = NULL;
#ifdef _ZPrototypeNode424_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4b
#endif
#ifdef _ZPrototypeNode424_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4b
#endif
#ifdef _ZPrototypeNode424_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4b
#endif
#ifdef _ZPrototypeNode424_DeSugar
	o->DeSugar = DeSugar__2q4b
#endif
#ifdef _ZPrototypeNode424_Accept
	o->Accept = Accept__2q4b
#endif
	o->_nextId = 0;
}

static struct ZPrototypeNode424 * _NewZPrototypeNode424(void) {
	struct ZPrototypeNode424 *o = LibZen_Malloc(sizeof(struct ZPrototypeNode424));
	_InitZPrototypeNode424(o);
	return o;
}

struct ZStringNode430 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId430;
	int _delta430;
	const char * StringValue;
	int _nextId;
};

static void _InitZStringNode430(struct ZStringNode430 * o) {
	_InitZConstNode331((struct ZConstNode331 *)o);
	o->_classId430 = 430;
	o->_delta430 = sizeof(struct ZStringNode430) - sizeof(struct ZConstNode331);
	o->StringValue = NULL;
#ifdef _ZStringNode430_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q42
#endif
#ifdef _ZStringNode430_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q42
#endif
#ifdef _ZStringNode430_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q42
#endif
#ifdef _ZStringNode430_DeSugar
	o->DeSugar = DeSugar__2q42
#endif
#ifdef _ZStringNode430_Accept
	o->Accept = Accept__2q42
#endif
	o->_nextId = 0;
}

static struct ZStringNode430 * _NewZStringNode430(void) {
	struct ZStringNode430 *o = LibZen_Malloc(sizeof(struct ZStringNode430));
	_InitZStringNode430(o);
	return o;
}

struct ZStupidCastErrorNode433 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId335;
	int _delta335;
	const char * ErrorMessage;
	int _classId433;
	int _delta433;
	struct ZNode52 * ErrorNode;
	int _nextId;
};

static void _InitZStupidCastErrorNode433(struct ZStupidCastErrorNode433 * o) {
	_InitZErrorNode335((struct ZErrorNode335 *)o);
	o->_classId433 = 433;
	o->_delta433 = sizeof(struct ZStupidCastErrorNode433) - sizeof(struct ZErrorNode335);
	o->ErrorNode = NULL;
#ifdef _ZStupidCastErrorNode433_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qaw
#endif
#ifdef _ZStupidCastErrorNode433_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qaw
#endif
#ifdef _ZStupidCastErrorNode433_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qaw
#endif
#ifdef _ZStupidCastErrorNode433_DeSugar
	o->DeSugar = DeSugar__2qaw
#endif
#ifdef _ZStupidCastErrorNode433_Accept
	o->Accept = Accept__2qaw
#endif
	o->_nextId = 0;
}

static struct ZStupidCastErrorNode433 * _NewZStupidCastErrorNode433(void) {
	struct ZStupidCastErrorNode433 *o = LibZen_Malloc(sizeof(struct ZStupidCastErrorNode433));
	_InitZStupidCastErrorNode433(o);
	return o;
}

struct ZTypeNode235 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId235;
	int _delta235;
	int _nextId;
};

static void _InitZTypeNode235(struct ZTypeNode235 * o) {
	_InitZConstNode331((struct ZConstNode331 *)o);
	o->_classId235 = 235;
	o->_delta235 = sizeof(struct ZTypeNode235) - sizeof(struct ZConstNode331);
#ifdef _ZTypeNode235_SetNameInfo
	o->SetNameInfo = SetNameInfo__3quk
#endif
#ifdef _ZTypeNode235_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3quk
#endif
#ifdef _ZTypeNode235_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1quk
#endif
#ifdef _ZTypeNode235_DeSugar
	o->DeSugar = DeSugar__2quk
#endif
#ifdef _ZTypeNode235_Accept
	o->Accept = Accept__2quk
#endif
	o->_nextId = 0;
}

static struct ZTypeNode235 * _NewZTypeNode235(void) {
	struct ZTypeNode235 *o = LibZen_Malloc(sizeof(struct ZTypeNode235));
	_InitZTypeNode235(o);
	return o;
}

struct ZGenerator55 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode418 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode472 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode376 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode343 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode430 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode477 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode398 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode411 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode359 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode349 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode363 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode354 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode346 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode402 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode406 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode391 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode415 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode320 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode372 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode310 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode328 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode498 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode421 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode502 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode366 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode317 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode379 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode512 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode335 *) VisitErrorNode;
	void (*)(struct ZVisitor167 *,struct ZNode52 *) VisitExtendedNode;
	void (*)(struct ZVisitor167 *,struct ZSugarNode165 *) VisitSugarNode;
	void (*)(struct ZVisitor167 *) EnableVisitor;
	void (*)(struct ZVisitor167 *) StopVisitor;
	int (*)(struct ZVisitor167 *) IsVisitable;
	int _classId55;
	int _delta55;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace48 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger135 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine57 * (*)(struct ZGenerator55 *) GetEngine;
	void (*)(struct ZGenerator55 *,struct ZNameSpace48 *) ImportLocalGrammar;
	void (*)(struct ZGenerator55 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator55 *) GetSourceText;
	const char * (*)(struct ZGenerator55 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator55 *,struct ZNode52 *,int) StartCodeGeneration;
	struct ZType60 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *) GetFieldType;
	struct ZType60 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *) GetSetterType;
	struct ZFuncType90 * (*)(struct ZGenerator55 *,struct ZType60 *,struct ZListNode251 *) GetConstructorFuncType;
	struct ZFuncType90 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *,struct ZListNode251 *) GetMethodFuncType;
	int _nextId;
};

static void _InitZGenerator55(struct ZGenerator55 * o) {
	_InitZVisitor167((struct ZVisitor167 *)o);
	o->_classId55 = 55;
	o->_delta55 = sizeof(struct ZGenerator55) - sizeof(struct ZVisitor167);
	o->GrammarInfo = NULL;
	o->LanguageExtention = NULL;
	o->TargetVersion = NULL;
	o->RootNameSpace = NULL;
	o->UniqueNumber = 0;
	o->OutputFile = NULL;
	o->Logger = NULL;
	o->DefinedFuncMap = LibZen_NewMap(0);
	o->StoppedVisitor = 0/*false*/;
	o->GetEngine = NULL;
	o->ImportLocalGrammar = NULL;
	o->WriteTo = NULL;
	o->GetSourceText = NULL;
	o->NameOutputFile = NULL;
	o->StartCodeGeneration = NULL;
	o->GetFieldType = NULL;
	o->GetSetterType = NULL;
	o->GetConstructorFuncType = NULL;
	o->GetMethodFuncType = NULL;
#ifdef _ZGenerator55_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qwk
#endif
#ifdef _ZGenerator55_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qwk
#endif
#ifdef _ZGenerator55_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qwk
#endif
#ifdef _ZGenerator55_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qwk
#endif
#ifdef _ZGenerator55_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qwk
#endif
#ifdef _ZGenerator55_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qwk
#endif
#ifdef _ZGenerator55_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qwk
#endif
#ifdef _ZGenerator55_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qwk
#endif
#ifdef _ZGenerator55_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qwk
#endif
#ifdef _ZGenerator55_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qwk
#endif
#ifdef _ZGenerator55_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qwk
#endif
#ifdef _ZGenerator55_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qwk
#endif
#ifdef _ZGenerator55_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qwk
#endif
#ifdef _ZGenerator55_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qwk
#endif
#ifdef _ZGenerator55_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qwk
#endif
#ifdef _ZGenerator55_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qwk
#endif
#ifdef _ZGenerator55_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qwk
#endif
#ifdef _ZGenerator55_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qwk
#endif
#ifdef _ZGenerator55_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qwk
#endif
#ifdef _ZGenerator55_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qwk
#endif
#ifdef _ZGenerator55_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qwk
#endif
#ifdef _ZGenerator55_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qwk
#endif
#ifdef _ZGenerator55_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qwk
#endif
#ifdef _ZGenerator55_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qwk
#endif
#ifdef _ZGenerator55_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qwk
#endif
#ifdef _ZGenerator55_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qwk
#endif
#ifdef _ZGenerator55_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qwk
#endif
#ifdef _ZGenerator55_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qwk
#endif
#ifdef _ZGenerator55_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qwk
#endif
#ifdef _ZGenerator55_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qwk
#endif
#ifdef _ZGenerator55_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qwk
#endif
#ifdef _ZGenerator55_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qwk
#endif
#ifdef _ZGenerator55_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qwk
#endif
#ifdef _ZGenerator55_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qwk
#endif
#ifdef _ZGenerator55_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qwk
#endif
#ifdef _ZGenerator55_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qwk
#endif
#ifdef _ZGenerator55_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qwk
#endif
#ifdef _ZGenerator55_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qwk
#endif
#ifdef _ZGenerator55_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qwk
#endif
#ifdef _ZGenerator55_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qwk
#endif
#ifdef _ZGenerator55_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qwk
#endif
#ifdef _ZGenerator55_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qwk
#endif
#ifdef _ZGenerator55_StopVisitor
	o->StopVisitor = StopVisitor__1qwk
#endif
#ifdef _ZGenerator55_IsVisitable
	o->IsVisitable = IsVisitable__1qwk
#endif
#ifdef _ZGenerator55_GetEngine
	o->GetEngine = GetEngine__1qwk
#endif
#ifdef _ZGenerator55_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qwk
#endif
#ifdef _ZGenerator55_WriteTo
	o->WriteTo = WriteTo__2qwk
#endif
#ifdef _ZGenerator55_GetSourceText
	o->GetSourceText = GetSourceText__1qwk
#endif
#ifdef _ZGenerator55_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qwk
#endif
#ifdef _ZGenerator55_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qwk
#endif
#ifdef _ZGenerator55_GetFieldType
	o->GetFieldType = GetFieldType__3qwk
#endif
#ifdef _ZGenerator55_GetSetterType
	o->GetSetterType = GetSetterType__3qwk
#endif
#ifdef _ZGenerator55_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qwk
#endif
#ifdef _ZGenerator55_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qwk
#endif
	o->_nextId = 0;
}

static struct ZGenerator55 * _NewZGenerator55(void) {
	struct ZGenerator55 *o = LibZen_Malloc(sizeof(struct ZGenerator55));
	_InitZGenerator55(o);
	return o;
}

struct ZIndentToken459 {
	int _classId77;
	int _delta77;
	struct ZSource238 * Source;
	long StartIndex;
	long EndIndex;
	int _classId459;
	int _delta459;
	int _nextId;
};

static void _InitZIndentToken459(struct ZIndentToken459 * o) {
	_InitZToken77((struct ZToken77 *)o);
	o->_classId459 = 459;
	o->_delta459 = sizeof(struct ZIndentToken459) - sizeof(struct ZToken77);
	o->_nextId = 0;
}

static struct ZIndentToken459 * _NewZIndentToken459(void) {
	struct ZIndentToken459 *o = LibZen_Malloc(sizeof(struct ZIndentToken459));
	_InitZIndentToken459(o);
	return o;
}

struct ZPatternToken461 {
	int _classId77;
	int _delta77;
	struct ZSource238 * Source;
	long StartIndex;
	long EndIndex;
	int _classId461;
	int _delta461;
	struct ZSyntax219 * PresetPattern;
	int _nextId;
};

static void _InitZPatternToken461(struct ZPatternToken461 * o) {
	_InitZToken77((struct ZToken77 *)o);
	o->_classId461 = 461;
	o->_delta461 = sizeof(struct ZPatternToken461) - sizeof(struct ZToken77);
	o->PresetPattern = NULL;
	o->_nextId = 0;
}

static struct ZPatternToken461 * _NewZPatternToken461(void) {
	struct ZPatternToken461 *o = LibZen_Malloc(sizeof(struct ZPatternToken461));
	_InitZPatternToken461(o);
	return o;
}

struct ZSourceEngine57 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode418 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode472 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode376 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode343 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode430 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode477 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode398 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode411 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode359 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode349 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode363 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode354 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode346 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode402 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode406 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode391 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode415 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode320 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode372 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode310 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode328 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode498 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode421 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode502 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode366 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode317 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode379 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode512 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode335 *) VisitErrorNode;
	void (*)(struct ZVisitor167 *,struct ZNode52 *) VisitExtendedNode;
	void (*)(struct ZVisitor167 *,struct ZSugarNode165 *) VisitSugarNode;
	void (*)(struct ZVisitor167 *) EnableVisitor;
	void (*)(struct ZVisitor167 *) StopVisitor;
	int (*)(struct ZVisitor167 *) IsVisitable;
	int _classId57;
	int _delta57;
	struct ZTypeChecker142 * TypeChecker;
	struct ZGenerator55 * Generator;
	struct ZLogger135 * Logger;
	int InteractiveContext;
	int IsVisitableFlag;
	int _nextId;
};

static void _InitZSourceEngine57(struct ZSourceEngine57 * o) {
	_InitZVisitor167((struct ZVisitor167 *)o);
	o->_classId57 = 57;
	o->_delta57 = sizeof(struct ZSourceEngine57) - sizeof(struct ZVisitor167);
	o->TypeChecker = NULL;
	o->Generator = NULL;
	o->Logger = NULL;
	o->InteractiveContext = 0/*false*/;
	o->IsVisitableFlag = 1/*true*/;
#ifdef _ZSourceEngine57_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qw9
#endif
#ifdef _ZSourceEngine57_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qw9
#endif
#ifdef _ZSourceEngine57_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qw9
#endif
#ifdef _ZSourceEngine57_StopVisitor
	o->StopVisitor = StopVisitor__1qw9
#endif
#ifdef _ZSourceEngine57_IsVisitable
	o->IsVisitable = IsVisitable__1qw9
#endif
	o->_nextId = 0;
}

static struct ZSourceEngine57 * _NewZSourceEngine57(void) {
	struct ZSourceEngine57 *o = LibZen_Malloc(sizeof(struct ZSourceEngine57));
	_InitZSourceEngine57(o);
	return o;
}

struct ZSourceGenerator243 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode418 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode472 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode376 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode343 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode430 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode477 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode398 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode411 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode359 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode349 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode363 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode354 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode346 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode402 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode406 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode391 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode415 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode320 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode372 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode310 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode328 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode498 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode421 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode502 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode366 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode317 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode379 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode512 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode335 *) VisitErrorNode;
	void (*)(struct ZVisitor167 *,struct ZNode52 *) VisitExtendedNode;
	void (*)(struct ZVisitor167 *,struct ZSugarNode165 *) VisitSugarNode;
	void (*)(struct ZVisitor167 *) EnableVisitor;
	void (*)(struct ZVisitor167 *) StopVisitor;
	int (*)(struct ZVisitor167 *) IsVisitable;
	int _classId55;
	int _delta55;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace48 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger135 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine57 * (*)(struct ZGenerator55 *) GetEngine;
	void (*)(struct ZGenerator55 *,struct ZNameSpace48 *) ImportLocalGrammar;
	void (*)(struct ZGenerator55 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator55 *) GetSourceText;
	const char * (*)(struct ZGenerator55 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator55 *,struct ZNode52 *,int) StartCodeGeneration;
	struct ZType60 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *) GetFieldType;
	struct ZType60 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *) GetSetterType;
	struct ZFuncType90 * (*)(struct ZGenerator55 *,struct ZType60 *,struct ZListNode251 *) GetConstructorFuncType;
	struct ZFuncType90 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *,struct ZListNode251 *) GetMethodFuncType;
	int _classId243;
	int _delta243;
	MapOfString * NativeTypeMap;
	MapOfString * ReservedNameMap;
	ArrayOfZSourceBuilder * BuilderList;
	struct ZSourceBuilder42 * HeaderBuilder;
	struct ZSourceBuilder42 * CurrentBuilder;
	const char * Tab;
	const char * LineFeed;
	const char * LineComment;
	const char * BeginComment;
	const char * EndComment;
	const char * SemiColon;
	const char * Camma;
	const char * TrueLiteral;
	const char * FalseLiteral;
	const char * NullLiteral;
	const char * NotOperator;
	const char * AndOperator;
	const char * OrOperator;
	const char * TopType;
	void (*)(struct ZSourceGenerator243 *) InitBuilderList;
	void (*)(struct ZSourceGenerator243 *,struct ZType60 *,struct ZNode52 *) GenerateCode;
	int _nextId;
};

static void _InitZSourceGenerator243(struct ZSourceGenerator243 * o) {
	_InitZGenerator55((struct ZGenerator55 *)o);
	o->_classId243 = 243;
	o->_delta243 = sizeof(struct ZSourceGenerator243) - sizeof(struct ZGenerator55);
	o->NativeTypeMap = LibZen_NewStringMap(0);
	o->ReservedNameMap = LibZen_NewStringMap(0);
	o->BuilderList = LibZen_NewArray(0);
	o->HeaderBuilder = NULL;
	o->CurrentBuilder = NULL;
	o->Tab = NULL;
	o->LineFeed = NULL;
	o->LineComment = NULL;
	o->BeginComment = NULL;
	o->EndComment = NULL;
	o->SemiColon = NULL;
	o->Camma = NULL;
	o->TrueLiteral = NULL;
	o->FalseLiteral = NULL;
	o->NullLiteral = NULL;
	o->NotOperator = NULL;
	o->AndOperator = NULL;
	o->OrOperator = NULL;
	o->TopType = NULL;
	o->InitBuilderList = NULL;
	o->GenerateCode = NULL;
#ifdef _ZSourceGenerator243_VisitNullNode
	o->VisitNullNode = VisitNullNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitIntNode
	o->VisitIntNode = VisitIntNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitStringNode
	o->VisitStringNode = VisitStringNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitNotNode
	o->VisitNotNode = VisitNotNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitCastNode
	o->VisitCastNode = VisitCastNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitAndNode
	o->VisitAndNode = VisitAndNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitOrNode
	o->VisitOrNode = VisitOrNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitVarNode
	o->VisitVarNode = VisitVarNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitIfNode
	o->VisitIfNode = VisitIfNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitTryNode
	o->VisitTryNode = VisitTryNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitLetNode
	o->VisitLetNode = VisitLetNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitClassNode
	o->VisitClassNode = VisitClassNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2quv
#endif
#ifdef _ZSourceGenerator243_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2quv
#endif
#ifdef _ZSourceGenerator243_EnableVisitor
	o->EnableVisitor = EnableVisitor__1quv
#endif
#ifdef _ZSourceGenerator243_StopVisitor
	o->StopVisitor = StopVisitor__1quv
#endif
#ifdef _ZSourceGenerator243_IsVisitable
	o->IsVisitable = IsVisitable__1quv
#endif
#ifdef _ZSourceGenerator243_GetEngine
	o->GetEngine = GetEngine__1quv
#endif
#ifdef _ZSourceGenerator243_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2quv
#endif
#ifdef _ZSourceGenerator243_WriteTo
	o->WriteTo = WriteTo__2quv
#endif
#ifdef _ZSourceGenerator243_GetSourceText
	o->GetSourceText = GetSourceText__1quv
#endif
#ifdef _ZSourceGenerator243_NameOutputFile
	o->NameOutputFile = NameOutputFile__2quv
#endif
#ifdef _ZSourceGenerator243_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3quv
#endif
#ifdef _ZSourceGenerator243_GetFieldType
	o->GetFieldType = GetFieldType__3quv
#endif
#ifdef _ZSourceGenerator243_GetSetterType
	o->GetSetterType = GetSetterType__3quv
#endif
#ifdef _ZSourceGenerator243_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3quv
#endif
#ifdef _ZSourceGenerator243_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4quv
#endif
#ifdef _ZSourceGenerator243_InitBuilderList
	o->InitBuilderList = InitBuilderList__1quv
#endif
#ifdef _ZSourceGenerator243_GenerateCode
	o->GenerateCode = GenerateCode__3quv
#endif
	o->_nextId = 0;
}

static struct ZSourceGenerator243 * _NewZSourceGenerator243(void) {
	struct ZSourceGenerator243 *o = LibZen_Malloc(sizeof(struct ZSourceGenerator243));
	_InitZSourceGenerator243(o);
	return o;
}

struct ZTypeChecker142 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode418 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode472 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode376 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode343 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode430 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode477 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode398 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode411 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode359 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode349 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode363 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode354 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode346 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode402 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode406 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode391 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode415 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode320 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode372 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode310 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode328 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode498 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode421 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode502 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode366 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode317 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode379 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode512 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode335 *) VisitErrorNode;
	void (*)(struct ZVisitor167 *,struct ZNode52 *) VisitExtendedNode;
	void (*)(struct ZVisitor167 *,struct ZSugarNode165 *) VisitSugarNode;
	void (*)(struct ZVisitor167 *) EnableVisitor;
	void (*)(struct ZVisitor167 *) StopVisitor;
	int (*)(struct ZVisitor167 *) IsVisitable;
	int _classId142;
	int _delta142;
	struct ZType60 * StackedContextType;
	struct ZNode52 * ReturnedNode;
	struct ZGenerator55 * Generator;
	struct ZLogger135 * Logger;
	int StoppedVisitor;
	struct ZVarScope134 * VarScope;
	void (*)(struct ZTypeChecker142 *,struct ZFunctionNode144 *,int) DefineFunction;
	int _nextId;
};

static void _InitZTypeChecker142(struct ZTypeChecker142 * o) {
	_InitZVisitor167((struct ZVisitor167 *)o);
	o->_classId142 = 142;
	o->_delta142 = sizeof(struct ZTypeChecker142) - sizeof(struct ZVisitor167);
	o->StackedContextType = NULL;
	o->ReturnedNode = NULL;
	o->Generator = NULL;
	o->Logger = NULL;
	o->StoppedVisitor = 0/*false*/;
	o->VarScope = NULL;
	o->DefineFunction = NULL;
#ifdef _ZTypeChecker142_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qr2
#endif
#ifdef _ZTypeChecker142_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qr2
#endif
#ifdef _ZTypeChecker142_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qr2
#endif
#ifdef _ZTypeChecker142_StopVisitor
	o->StopVisitor = StopVisitor__1qr2
#endif
#ifdef _ZTypeChecker142_IsVisitable
	o->IsVisitable = IsVisitable__1qr2
#endif
#ifdef _ZTypeChecker142_DefineFunction
	o->DefineFunction = DefineFunction__3qr2
#endif
	o->_nextId = 0;
}

static struct ZTypeChecker142 * _NewZTypeChecker142(void) {
	struct ZTypeChecker142 *o = LibZen_Malloc(sizeof(struct ZTypeChecker142));
	_InitZTypeChecker142(o);
	return o;
}

static long ZTypeChecker_DefaultTypeCheckPolicy_Z77 = 0;
static long ZTypeChecker_NoCheckPolicy_Z78 = 1;
struct CSourceGenerator596 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode418 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode472 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode376 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode343 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode430 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode477 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode398 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode411 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode359 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode349 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode363 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode354 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode346 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode402 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode406 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode391 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode415 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode320 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode372 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode310 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode328 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode498 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode421 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode502 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode366 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode317 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode379 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode512 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode335 *) VisitErrorNode;
	void (*)(struct ZVisitor167 *,struct ZNode52 *) VisitExtendedNode;
	void (*)(struct ZVisitor167 *,struct ZSugarNode165 *) VisitSugarNode;
	void (*)(struct ZVisitor167 *) EnableVisitor;
	void (*)(struct ZVisitor167 *) StopVisitor;
	int (*)(struct ZVisitor167 *) IsVisitable;
	int _classId55;
	int _delta55;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace48 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger135 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine57 * (*)(struct ZGenerator55 *) GetEngine;
	void (*)(struct ZGenerator55 *,struct ZNameSpace48 *) ImportLocalGrammar;
	void (*)(struct ZGenerator55 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator55 *) GetSourceText;
	const char * (*)(struct ZGenerator55 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator55 *,struct ZNode52 *,int) StartCodeGeneration;
	struct ZType60 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *) GetFieldType;
	struct ZType60 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *) GetSetterType;
	struct ZFuncType90 * (*)(struct ZGenerator55 *,struct ZType60 *,struct ZListNode251 *) GetConstructorFuncType;
	struct ZFuncType90 * (*)(struct ZGenerator55 *,struct ZType60 *,const char *,struct ZListNode251 *) GetMethodFuncType;
	int _classId243;
	int _delta243;
	MapOfString * NativeTypeMap;
	MapOfString * ReservedNameMap;
	ArrayOfZSourceBuilder * BuilderList;
	struct ZSourceBuilder42 * HeaderBuilder;
	struct ZSourceBuilder42 * CurrentBuilder;
	const char * Tab;
	const char * LineFeed;
	const char * LineComment;
	const char * BeginComment;
	const char * EndComment;
	const char * SemiColon;
	const char * Camma;
	const char * TrueLiteral;
	const char * FalseLiteral;
	const char * NullLiteral;
	const char * NotOperator;
	const char * AndOperator;
	const char * OrOperator;
	const char * TopType;
	void (*)(struct ZSourceGenerator243 *) InitBuilderList;
	void (*)(struct ZSourceGenerator243 *,struct ZType60 *,struct ZNode52 *) GenerateCode;
	int _classId596;
	int _delta596;
	int _nextId;
};

static void _InitCSourceGenerator596(struct CSourceGenerator596 * o) {
	_InitZSourceGenerator243((struct ZSourceGenerator243 *)o);
	o->_classId596 = 596;
	o->_delta596 = sizeof(struct CSourceGenerator596) - sizeof(struct ZSourceGenerator243);
#ifdef _CSourceGenerator596_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qgl
#endif
#ifdef _CSourceGenerator596_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qgl
#endif
#ifdef _CSourceGenerator596_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qgl
#endif
#ifdef _CSourceGenerator596_StopVisitor
	o->StopVisitor = StopVisitor__1qgl
#endif
#ifdef _CSourceGenerator596_IsVisitable
	o->IsVisitable = IsVisitable__1qgl
#endif
#ifdef _CSourceGenerator596_GetEngine
	o->GetEngine = GetEngine__1qgl
#endif
#ifdef _CSourceGenerator596_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qgl
#endif
#ifdef _CSourceGenerator596_WriteTo
	o->WriteTo = WriteTo__2qgl
#endif
#ifdef _CSourceGenerator596_GetSourceText
	o->GetSourceText = GetSourceText__1qgl
#endif
#ifdef _CSourceGenerator596_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qgl
#endif
#ifdef _CSourceGenerator596_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qgl
#endif
#ifdef _CSourceGenerator596_GetFieldType
	o->GetFieldType = GetFieldType__3qgl
#endif
#ifdef _CSourceGenerator596_GetSetterType
	o->GetSetterType = GetSetterType__3qgl
#endif
#ifdef _CSourceGenerator596_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qgl
#endif
#ifdef _CSourceGenerator596_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qgl
#endif
#ifdef _CSourceGenerator596_InitBuilderList
	o->InitBuilderList = InitBuilderList__1qgl
#endif
#ifdef _CSourceGenerator596_GenerateCode
	o->GenerateCode = GenerateCode__3qgl
#endif
	o->_nextId = 0;
}

static struct CSourceGenerator596 * _NewCSourceGenerator596(void) {
	struct CSourceGenerator596 *o = LibZen_Malloc(sizeof(struct CSourceGenerator596));
	_InitCSourceGenerator596(o);
	return o;
}

struct ZAndNode498 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId310;
	int _delta310;
	struct ZSyntax219 * Pattern;
	int _classId498;
	int _delta498;
	int _nextId;
};

static void _InitZAndNode498(struct ZAndNode498 * o) {
	_InitZBinaryNode310((struct ZBinaryNode310 *)o);
	o->_classId498 = 498;
	o->_delta498 = sizeof(struct ZAndNode498) - sizeof(struct ZBinaryNode310);
#ifdef _ZAndNode498_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qsm
#endif
#ifdef _ZAndNode498_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qsm
#endif
#ifdef _ZAndNode498_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qsm
#endif
#ifdef _ZAndNode498_DeSugar
	o->DeSugar = DeSugar__2qsm
#endif
#ifdef _ZAndNode498_Accept
	o->Accept = Accept__2qsm
#endif
	o->_nextId = 0;
}

static struct ZAndNode498 * _NewZAndNode498(void) {
	struct ZAndNode498 *o = LibZen_Malloc(sizeof(struct ZAndNode498));
	_InitZAndNode498(o);
	return o;
}

struct ZArrayLiteralNode477 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId477;
	int _delta477;
	int _nextId;
};

static void _InitZArrayLiteralNode477(struct ZArrayLiteralNode477 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId477 = 477;
	o->_delta477 = sizeof(struct ZArrayLiteralNode477) - sizeof(struct ZListNode251);
#ifdef _ZArrayLiteralNode477_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qsp
#endif
#ifdef _ZArrayLiteralNode477_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qsp
#endif
#ifdef _ZArrayLiteralNode477_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qsp
#endif
#ifdef _ZArrayLiteralNode477_DeSugar
	o->DeSugar = DeSugar__2qsp
#endif
#ifdef _ZArrayLiteralNode477_Accept
	o->Accept = Accept__2qsp
#endif
	o->_nextId = 0;
}

static struct ZArrayLiteralNode477 * _NewZArrayLiteralNode477(void) {
	struct ZArrayLiteralNode477 *o = LibZen_Malloc(sizeof(struct ZArrayLiteralNode477));
	_InitZArrayLiteralNode477(o);
	return o;
}

struct ZBlockNode161 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId161;
	int _delta161;
	struct ZNameSpace48 * NameSpace;
	int _nextId;
};

static void _InitZBlockNode161(struct ZBlockNode161 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId161 = 161;
	o->_delta161 = sizeof(struct ZBlockNode161) - sizeof(struct ZListNode251);
	o->NameSpace = NULL;
#ifdef _ZBlockNode161_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qth
#endif
#ifdef _ZBlockNode161_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qth
#endif
#ifdef _ZBlockNode161_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qth
#endif
#ifdef _ZBlockNode161_DeSugar
	o->DeSugar = DeSugar__2qth
#endif
#ifdef _ZBlockNode161_Accept
	o->Accept = Accept__2qth
#endif
	o->_nextId = 0;
}

static struct ZBlockNode161 * _NewZBlockNode161(void) {
	struct ZBlockNode161 *o = LibZen_Malloc(sizeof(struct ZBlockNode161));
	_InitZBlockNode161(o);
	return o;
}

struct ZBooleanNode472 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId331;
	int _delta331;
	int _classId472;
	int _delta472;
	int BooleanValue;
	int _nextId;
};

static void _InitZBooleanNode472(struct ZBooleanNode472 * o) {
	_InitZConstNode331((struct ZConstNode331 *)o);
	o->_classId472 = 472;
	o->_delta472 = sizeof(struct ZBooleanNode472) - sizeof(struct ZConstNode331);
	o->BooleanValue = 0/*false*/;
#ifdef _ZBooleanNode472_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qst
#endif
#ifdef _ZBooleanNode472_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qst
#endif
#ifdef _ZBooleanNode472_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qst
#endif
#ifdef _ZBooleanNode472_DeSugar
	o->DeSugar = DeSugar__2qst
#endif
#ifdef _ZBooleanNode472_Accept
	o->Accept = Accept__2qst
#endif
	o->_nextId = 0;
}

static struct ZBooleanNode472 * _NewZBooleanNode472(void) {
	struct ZBooleanNode472 *o = LibZen_Malloc(sizeof(struct ZBooleanNode472));
	_InitZBooleanNode472(o);
	return o;
}

struct ZClassNode512 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId512;
	int _delta512;
	const char * ClassName;
	struct ZClassType80 * ClassType;
	struct ZType60 * SuperType;
	struct ZToken77 * NameToken;
	struct ZToken77 * SuperToken;
	int _nextId;
};

static void _InitZClassNode512(struct ZClassNode512 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId512 = 512;
	o->_delta512 = sizeof(struct ZClassNode512) - sizeof(struct ZListNode251);
	o->ClassName = NULL;
	o->ClassType = NULL;
	o->SuperType = NULL;
	o->NameToken = NULL;
	o->SuperToken = NULL;
#ifdef _ZClassNode512_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qdo
#endif
#ifdef _ZClassNode512_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qdo
#endif
#ifdef _ZClassNode512_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qdo
#endif
#ifdef _ZClassNode512_DeSugar
	o->DeSugar = DeSugar__2qdo
#endif
#ifdef _ZClassNode512_Accept
	o->Accept = Accept__2qdo
#endif
	o->_nextId = 0;
}

static struct ZClassNode512 * _NewZClassNode512(void) {
	struct ZClassNode512 *o = LibZen_Malloc(sizeof(struct ZClassNode512));
	_InitZClassNode512(o);
	return o;
}

struct ZFuncCallNode406 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId406;
	int _delta406;
	int _nextId;
};

static void _InitZFuncCallNode406(struct ZFuncCallNode406 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId406 = 406;
	o->_delta406 = sizeof(struct ZFuncCallNode406) - sizeof(struct ZListNode251);
#ifdef _ZFuncCallNode406_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q40
#endif
#ifdef _ZFuncCallNode406_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q40
#endif
#ifdef _ZFuncCallNode406_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q40
#endif
#ifdef _ZFuncCallNode406_DeSugar
	o->DeSugar = DeSugar__2q40
#endif
#ifdef _ZFuncCallNode406_Accept
	o->Accept = Accept__2q40
#endif
	o->_nextId = 0;
}

static struct ZFuncCallNode406 * _NewZFuncCallNode406(void) {
	struct ZFuncCallNode406 *o = LibZen_Malloc(sizeof(struct ZFuncCallNode406));
	_InitZFuncCallNode406(o);
	return o;
}

static long ZFuncCallNode_Func_Z79 = 0;
struct ZFunctionNode144 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId144;
	int _delta144;
	struct ZType60 * ReturnType;
	const char * FuncName;
	struct ZToken77 * NameToken;
	struct ZFunctionNode144 * ParentFunctionNode;
	struct ZFuncType90 * ResolvedFuncType;
	long VarIndex;
	int _nextId;
};

static void _InitZFunctionNode144(struct ZFunctionNode144 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId144 = 144;
	o->_delta144 = sizeof(struct ZFunctionNode144) - sizeof(struct ZListNode251);
	o->ReturnType = ZTypeVarType_Z4;
	o->FuncName = NULL;
	o->NameToken = NULL;
	o->ParentFunctionNode = NULL;
	o->ResolvedFuncType = NULL;
	o->VarIndex = 0;
#ifdef _ZFunctionNode144_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtq
#endif
#ifdef _ZFunctionNode144_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtq
#endif
#ifdef _ZFunctionNode144_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtq
#endif
#ifdef _ZFunctionNode144_DeSugar
	o->DeSugar = DeSugar__2qtq
#endif
#ifdef _ZFunctionNode144_Accept
	o->Accept = Accept__2qtq
#endif
	o->_nextId = 0;
}

static struct ZFunctionNode144 * _NewZFunctionNode144(void) {
	struct ZFunctionNode144 *o = LibZen_Malloc(sizeof(struct ZFunctionNode144));
	_InitZFunctionNode144(o);
	return o;
}

static long ZFunctionNode_Block_Z80 = 0;
struct ZVarNode502 {
	int _classId52;
	int _delta52;
	struct ZNode52 * ParentNode;
	struct ZToken77 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType60 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode52 *,struct ZToken77 *,const char *) SetNameInfo;
	void (*)(struct ZNode52 *,struct ZToken77 *,struct ZType60 *) SetTypeInfo;
	int (*)(struct ZNode52 *) IsBreakingBlock;
	struct ZSugarNode165 * (*)(struct ZNode52 *,struct ZGenerator55 *) DeSugar;
	void (*)(struct ZNode52 *,struct ZVisitor167 *) Accept;
	int _classId251;
	int _delta251;
	long ListStartIndex;
	int _classId161;
	int _delta161;
	struct ZNameSpace48 * NameSpace;
	int _classId502;
	int _delta502;
	struct ZType60 * DeclType;
	const char * NativeName;
	long VarIndex;
	struct ZToken77 * TypeToken;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZVarNode502(struct ZVarNode502 * o) {
	_InitZBlockNode161((struct ZBlockNode161 *)o);
	o->_classId502 = 502;
	o->_delta502 = sizeof(struct ZVarNode502) - sizeof(struct ZBlockNode161);
	o->DeclType = ZTypeVarType_Z4;
	o->NativeName = NULL;
	o->VarIndex = 0;
	o->TypeToken = NULL;
	o->NameToken = NULL;
#ifdef _ZVarNode502_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qs2
#endif
#ifdef _ZVarNode502_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qs2
#endif
#ifdef _ZVarNode502_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qs2
#endif
#ifdef _ZVarNode502_DeSugar
	o->DeSugar = DeSugar__2qs2
#endif
#ifdef _ZVarNode502_Accept
	o->Accept = Accept__2qs2
#endif
	o->_nextId = 0;
}

static struct ZVarNode502 * _NewZVarNode502(void) {
	struct ZVarNode502 *o = LibZen_Malloc(sizeof(struct ZVarNode502));
	_InitZVarNode502(o);
	return o;
}

static long ZVarNode_InitValue_Z81 = 0;
static struct ZType60 * ZType__4qwz(struct ZType60 * this, long TypeFlag__1, const char * ShortName__2, struct ZType60 * RefType__3) {
	this->TypeFlag = TypeFlag__1;
	this->ShortName = ShortName__2;
	this->RefType = RefType__3;
	if (LibZen_IsFlag__2qqr(TypeFlag__1, ZTypeUniqueTypeFlag_Z1)) {
		this->TypeId = ZTypePool_NewTypeId__1qwz(this);
	};
	return NULL;
}
static struct ZType60 * GetRealType__1qwz(struct ZType60 * this) {
	return this;
}
static struct ZType60 * GetSuperType__1qwz(struct ZType60 * this) {
	return this->RefType;
}
static struct ZType60 * GetBaseType__1qwz(struct ZType60 * this) {
	return this;
}
static long GetParamSize__1qwz(struct ZType60 * this) {
	return 0;
}
static struct ZType60 * GetParamType__2qwz(struct ZType60 * this, long Index__1) {
	return ZTypeVarType_Z4;
}
static int Equals__2qwz(struct ZType60 * this, struct ZType60 * Type__1) {
	return (/*untyped*/NULL(this) == /*untyped*/NULL(Type__1));
}
static int Accept__2qwz(struct ZType60 * this, struct ZType60 * Type__1) {
	struct ZType60 * ThisType__2 = /*untyped*/NULL(this);
	if (ThisType__2 == /*untyped*/NULL(Type__1)) {
		return 1/*true*/;
	};
	struct ZType60 * SuperClass__3 = /*untyped*/NULL(Type__1);
	while (SuperClass__3 != NULL) {
		if (SuperClass__3 == ThisType__2) {
			return 1/*true*/;
		};
		SuperClass__3 = /*untyped*/NULL(SuperClass__3);
	};
	return 0/*false*/;
}
static int IsGreekType__1qwz(struct ZType60 * this) {
	return 0/*false*/;
}
static struct ZType60 * GetGreekRealType__2qwz(struct ZType60 * this, ArrayOfZType * Greek__1) {
	return /*untyped*/NULL(this);
}
static int AcceptValueType__4qwz(struct ZType60 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (/*untyped*/NULL(this) != ValueType__1 && !/*untyped*/NULL(ValueType__1)) {
		if (ExactMatch__2 && !Accept__2qwz(this, ValueType__1)) {
			return 0/*false*/;
		};
	};
	return 1/*true*/;
}
static int IsVoidType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZTypeVoidType_Z5);
}
static int IsVarType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZTypeVarType_Z4);
}
static int IsInferrableType__1qwz(struct ZType60 * this) {
	return (!/*untyped*/NULL(this) && !IsVoidType__1qwz(this));
}
static int IsTypeType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZTypeTypeType_Z10);
}
static int IsBooleanType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZTypeBooleanType_Z6);
}
static int IsIntType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZTypeIntType_Z7);
}
static int IsFloatType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZTypeFloatType_Z8);
}
static int IsNumberType__1qwz(struct ZType60 * this) {
	return (IsIntType__1qwz(this) || IsFloatType__1qwz(this));
}
static int IsStringType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZTypeStringType_Z9);
}
static int IsArrayType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZGenericType_ArrayType_Z15);
}
static int IsMapType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ZGenericType_MapType_Z16);
}
static int IsOpenType__1qwz(struct ZType60 * this) {
	return LibZen_IsFlag__2qqr(this->TypeFlag, ZTypeOpenTypeFlag_Z3);
}
static int IsImmutableType__1qwz(struct ZType60 * this) {
	return 0/*false*/;
}
static int IsNullableType__1qwz(struct ZType60 * this) {
	return 1/*true*/;
}
static const char * toString__1qwz(struct ZType60 * this) {
	return this->ShortName;
}
static const char * GetAsciiName__1qwz(struct ZType60 * this) {
	return this->ShortName;
}
static const char * StringfyClassMember__2qwz(struct ZType60 * this, const char * Name__1) {
	return LibZen_StrCat(LibZen_StrCat(Name__1, " of "), this->ShortName);
}
static const char * GetUniqueName__1qwz(struct ZType60 * this) {
	return LibZen_Stringfy__1qqr(this->TypeId);
}
static int IsFuncType__1qwz(struct ZType60 * this) {
	return (LibZen_Is(/*untyped*/NULL(this), 90));
}
static const char * StringfySignature__2qwz(struct ZType60 * this, const char * FuncName__1) {
	return FuncName__1;
}
static void Maybe__3qwz(struct ZType60 * this, struct ZType60 * T__1, struct ZToken77 * SourceToken__2) {
	return;
}
static struct ZClassField79 * ZClassField__5qei(struct ZClassField79 * this, struct ZClassType80 * ClassType__1, const char * FieldName__2, struct ZType60 * FieldType__3, struct ZToken77 * SourceToken__4) {
	this->ClassType = ClassType__1;
	this->FieldType = FieldType__3;
	this->FieldName = FieldName__2;
	this->SourceToken = SourceToken__4;
	return NULL;
}
static struct ZClassType80 * ZClassType__3qeo(struct ZClassType80 * this, const char * ShortName__1, struct ZType60 * RefType__2) {
	(void)ZType__4qwz(this, ZTypeOpenTypeFlag_Z3 | ZTypeUniqueTypeFlag_Z1, ShortName__1, RefType__2);
	if (LibZen_Is(RefType__2, 80)) {
		ResetSuperType__2qeo(this, (struct ZClassType80 *)RefType__2);
	};
	return NULL;
}
static void ResetSuperType__2qeo(struct ZClassType80 * this, struct ZClassType80 * SuperClass__1) {
	this->RefType = SuperClass__1;
	if (SuperClass__1->FieldList != NULL) {
		this->FieldList = LibZen_NewArray(0);
		long i__2 = 0;
		while (i__2 < LibZen_ArraySize((ArrayOfVar *)SuperClass__1->FieldList)) {
			struct ZClassField79 * Field__3 = Array<ZClassField>GetIndex(i__2);
			LibZen_ArrayAdd((ArrayOfVar *)this->FieldList, (var)Field__3);
			i__2 = i__2 + 1;
		};
	};
	return;
}
static long GetFieldSize__1qeo(struct ZClassType80 * this) {
	if (this->FieldList != NULL) {
		return LibZen_ArraySize((ArrayOfVar *)this->FieldList);
	};
	return 0;
}
static struct ZClassField79 * GetFieldAt__2qeo(struct ZClassType80 * this, long Index__1) {
	return Array<ZClassField>GetIndex(Index__1);
}
static int HasField__2qeo(struct ZClassType80 * this, const char * FieldName__1) {
	if (this->FieldList != NULL) {
		long i__2 = 0;
		while (i__2 < LibZen_ArraySize((ArrayOfVar *)this->FieldList)) {
			if (LibZen_EqualsString(FieldName__1, Array<ZClassField>GetIndex(i__2)->FieldName)) {
				return 1/*true*/;
			};
			i__2 = i__2 + 1;
		};
	};
	return 0/*false*/;
}
static struct ZType60 * GetFieldType__3qeo(struct ZClassType80 * this, const char * FieldName__1, struct ZType60 * DefaultType__2) {
	if (this->FieldList != NULL) {
		long i__3 = 0;
		while (i__3 < LibZen_ArraySize((ArrayOfVar *)this->FieldList)) {
			struct ZClassField79 * Field__4 = Array<ZClassField>GetIndex(i__3);
			if (LibZen_EqualsString(FieldName__1, Field__4->FieldName)) {
				return Field__4->FieldType;
			};
			i__3 = i__3 + 1;
		};
	};
	return DefaultType__2;
}
static struct ZClassField79 * AppendField__4qeo(struct ZClassType80 * this, struct ZType60 * FieldType__1, const char * FieldName__2, struct ZToken77 * SourceToken__3) {
	LibZen_Assert(!/*untyped*/NULL(FieldType__1), "(libzen/libzen.zen:1423)");
	if (this->FieldList == NULL) {
		this->FieldList = LibZen_NewArray(0);
	};
	struct ZClassField79 * ClassField__4 = ZClassField__5qei(_NewZClassField79(), this, FieldName__2, FieldType__1, SourceToken__3);
	LibZen_ArrayAdd((ArrayOfVar *)this->FieldList, (var)ClassField__4);
	return ClassField__4;
}
static const char * ZFunc_StringfySignature__3qqy(const char * FuncName, long FuncParamSize__1, struct ZType60 * RecvType__2) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(FuncName, "__"), LibZen_IntToString(FuncParamSize__1)), GetUniqueName__1qwz(RecvType__2));
}
static struct ZFunc89 * ZFunc__4qeh(struct ZFunc89 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3) {
	this->FuncFlag = FuncFlag__1;
	this->FuncName = FuncName__2;
	this->FuncType = FuncType__3;
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1qeh(struct ZFunc89 * this) {
	return this->FuncType;
}
static const char * toString__1qeh(struct ZFunc89 * this) {
	return LibZen_StrCat(LibZen_StrCat(this->FuncName, ": "), toString__1qwz(this->FuncType));
}
static int IsConverterFunc__1qeh(struct ZFunc89 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_ConverterFunc_Z12);
}
static int IsCoercionFunc__1qeh(struct ZFunc89 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_CoercionFunc_Z13);
}
static int Is__2qeh(struct ZFunc89 * this, long Flag__1) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, Flag__1);
}
static const char * GetSignature__1qeh(struct ZFunc89 * this) {
	return StringfySignature__2qej(this->FuncType, this->FuncName);
}
static struct ZFuncType90 * ZFuncType__3qej(struct ZFuncType90 * this, const char * ShortName__1, ArrayOfZType * UniqueTypeParams__2) {
	(void)ZType__4qwz(this, ZTypeUniqueTypeFlag_Z1, ShortName__1, ZTypeVarType_Z4);
	if (UniqueTypeParams__2 == NULL) {
		this->TypeParams = LibZen_NewTypeArray__1qqr(1);
		Array<ZType>SetIndex(0, ZTypeVarType_Z4);
	} else {
		this->TypeParams = UniqueTypeParams__2;
	};
	long i__4 = 0;
	while (i__3 < LibZen_ArraySize((ArrayOfVar *)this->TypeParams)) {
		if (Array<ZType>GetIndex(i__3)->IsVarType(Array<ZType>GetIndex(i__3))) {
			this->HasUnknownType = 1/*true*/;
		};
		if (Array<ZType>GetIndex(i__3)->IsGreekType(Array<ZType>GetIndex(i__3))) {
			this->HasGreekType = 1/*true*/;
		};
		i__3 = i__3 + 1;
	};
	return NULL;
}
static int IsFuncType__1qej(struct ZFuncType90 * this) {
	return 1/*true*/;
}
static int IsVarType__1qej(struct ZFuncType90 * this) {
	return this->HasUnknownType;
}
static int IsGreekType__1qej(struct ZFuncType90 * this) {
	return this->HasGreekType;
}
static struct ZType60 * GetGreekRealType__2qej(struct ZFuncType90 * this, ArrayOfZType * Greek__1) {
	if (this->HasGreekType) {
		ArrayOfZType * TypeList__4 = LibZen_NewArray(0);
		long i__5 = 0;
		while (i__3 < LibZen_ArraySize((ArrayOfVar *)this->TypeParams)) {
			LibZen_ArrayAdd((ArrayOfVar *)TypeList__2, (var)Array<ZType>GetIndex(i__3)->GetGreekRealType(Array<ZType>GetIndex(i__3), Greek__1));
			i__3 = i__3 + 1;
		};
		return ZTypePool_LookupFuncType__1qwx(TypeList__2);
	};
	return this;
}
static int AcceptValueType__4qej(struct ZFuncType90 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (IsFuncType__1qwz(ValueType__1) && /*untyped*/NULL(ValueType__1) == /*untyped*/NULL(this)) {
		long i__4 = 0;
		while (i__4 < LibZen_ArraySize((ArrayOfVar *)this->TypeParams)) {
			if (!/*untyped*/NULL(Array<ZType>GetIndex(i__4), /*untyped*/NULL(ValueType__1, i__4), 1/*true*/, Greek__3)) {
				return 0/*false*/;
			};
			i__4 = i__4 + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static const char * StringfySignature__2qej(struct ZFuncType90 * this, const char * FuncName__1) {
	return ZFunc_StringfySignature__3qqy(FuncName__1, GetFuncParamSize__1qej(this), GetRecvType__1qej(this));
}
static struct ZType60 * GetBaseType__1qej(struct ZFuncType90 * this) {
	return ZFuncType_FuncType_Z14;
}
static long GetParamSize__1qej(struct ZFuncType90 * this) {
	return LibZen_ArraySize((ArrayOfVar *)this->TypeParams);
}
static struct ZType60 * GetParamType__2qej(struct ZFuncType90 * this, long Index__1) {
	return Array<ZType>GetIndex(Index__1);
}
static struct ZType60 * GetReturnType__1qej(struct ZFuncType90 * this) {
	return Array<ZType>GetIndex(0);
}
static long GetFuncParamSize__1qej(struct ZFuncType90 * this) {
	return LibZen_ArraySize((ArrayOfVar *)this->TypeParams) - 1;
}
static struct ZType60 * GetRecvType__1qej(struct ZFuncType90 * this) {
	if (LibZen_ArraySize((ArrayOfVar *)this->TypeParams) == 1) {
		return ZTypeVoidType_Z5;
	};
	return Array<ZType>GetIndex(1);
}
static struct ZType60 * GetFuncParamType__2qej(struct ZFuncType90 * this, long Index__1) {
	return Array<ZType>GetIndex(Index__1 + 1);
}
static struct ZFuncType90 * NewMethodFuncType__2qej(struct ZFuncType90 * this, struct ZType60 * RecvType__1) {
	ArrayOfZType * TypeList__2 = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__2, (var)GetReturnType__1qej(this));
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__2, (var)RecvType__1);
	long i__3 = 0;
	while (i__3 < GetFuncParamSize__1qej(this)) {
		LibZen_ArrayAdd((ArrayOfVar *)TypeList__2, (var)GetFuncParamType__2qej(this, i__3));
		i__3 = i__3 + 1;
	};
	return ZTypePool_LookupFuncType__1qwx(TypeList__2);
}
static int AcceptAsFieldFunc__2qej(struct ZFuncType90 * this, struct ZFuncType90 * FuncType__1) {
	if (GetFuncParamSize__1qej(FuncType__1) == GetFuncParamSize__1qej(this) && Equals__2qwz(GetReturnType__1qej(FuncType__1), GetReturnType__1qej(this))) {
		long i__2 = 1;
		while (i__2 < GetFuncParamSize__1qej(FuncType__1)) {
			if (!Equals__2qwz(GetFuncParamType__2qej(FuncType__1, i__2), GetFuncParamType__2qej(this, i__2))) {
				return 0/*false*/;
			};
			i__2 = i__2 + 1;
		};
	};
	return 1/*true*/;
}
static struct ZGenericType107 * ZGenericType__5qe8(struct ZGenericType107 * this, long TypeFlag__1, const char * ShortName__2, struct ZType60 * BaseType__3, struct ZType60 * ParamType__4) {
	(void)ZType__4qwz(this, TypeFlag__1, ShortName__2, ZTypeVarType_Z4);
	this->BaseType = BaseType__3;
	if (this->BaseType == NULL) {
		this->BaseType = this;
	};
	this->ParamType = ParamType__4;
	return NULL;
}
static struct ZType60 * GetSuperType__1qe8(struct ZGenericType107 * this) {
	if (this->BaseType == this) {
		return this->RefType;
	};
	return this->BaseType;
}
static struct ZType60 * GetBaseType__1qe8(struct ZGenericType107 * this) {
	return this->BaseType;
}
static long GetParamSize__1qe8(struct ZGenericType107 * this) {
	return 1;
}
static struct ZType60 * GetParamType__2qe8(struct ZGenericType107 * this, long Index__1) {
	if (Index__1 == 0) {
		return this->ParamType;
	};
	return NULL;
}
static int IsGreekType__1qe8(struct ZGenericType107 * this) {
	return (/*untyped*/NULL(this->ParamType));
}
static struct ZType60 * GetGreekRealType__2qe8(struct ZGenericType107 * this, ArrayOfZType * Greek__1) {
	if (this->ParamType->IsGreekType(this->ParamType)) {
		return ZTypePool_GetGenericType1__2qwz(this->BaseType, this->ParamType->GetGreekRealType(this->ParamType, Greek__1));
	};
	return this->GetRealType(this);
}
static int AcceptValueType__4qe8(struct ZGenericType107 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (this->BaseType == /*untyped*/NULL(ValueType__1) && /*untyped*/NULL(ValueType__1) == 1) {
		return /*untyped*/NULL(this->ParamType, /*untyped*/NULL(ValueType__1, 0), 1/*true*/, Greek__3);
	};
	return 0/*false*/;
}
static ArrayOfZType * ZGreekType_NewGreekTypes__1qwx(ArrayOfZType * GreekTypes) {
	if (GreekTypes == NULL) {
		return LibZen_NewTypeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)LibZen_GreekNames_Z0));
	} else {
		long i__1 = 0;
		while (i__1 < LibZen_ArraySize((ArrayOfVar *)GreekTypes)) {
			Array<ZType>SetIndex(i__1, NULL);
			i__1 = i__1 + 1;
		};
		return GreekTypes;
	};
}
static struct ZGreekType115 * ZGreekType__2qri(struct ZGreekType115 * this, long GreekId__1) {
	(void)ZType__4qwz(this, ZTypeUniqueTypeFlag_Z1, Array<String>GetIndex(GreekId__1), ZTypeVarType_Z4);
	this->GreekId = GreekId__1;
	return NULL;
}
static int IsGreekType__1qri(struct ZGreekType115 * this) {
	return 1/*true*/;
}
static struct ZType60 * GetGreekRealType__2qri(struct ZGreekType115 * this, ArrayOfZType * Greek__1) {
	if (Array<ZType>GetIndex(this->GreekId) == NULL) {
		return ZTypeVarType_Z4;
	};
	return Array<ZType>GetIndex(this->GreekId);
}
static int AcceptValueType__4qri(struct ZGreekType115 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (Array<ZType>GetIndex(this->GreekId) == NULL) {
		if (/*untyped*/NULL(ValueType__1)) {
			return 1/*true*/;
		};
		Array<ZType>SetIndex(this->GreekId, ValueType__1);
		return 1/*true*/;
	} else {
		return /*untyped*/NULL(Array<ZType>GetIndex(this->GreekId), ValueType__1, ExactMatch__2, Greek__3);
	};
}
static struct ZPrototype121 * ZPrototype__5qrs(struct ZPrototype121 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3, struct ZToken77 * SourceToken__4) {
	(void)ZFunc__4qeh(this, FuncFlag__1, FuncName__2, FuncType__3);
	this->DefinedCount = 0;
	this->UsedCount = 0;
	return NULL;
}
static void Used__1qrs(struct ZPrototype121 * this) {
	this->UsedCount = this->UsedCount + 1;
	return;
}
static void Defined__1qrs(struct ZPrototype121 * this) {
	this->DefinedCount = this->DefinedCount + 1;
	return;
}
static long ZTypePool_NewTypeId__1qwz(struct ZType60 * T) {
	long TypeId__1 = LibZen_ArraySize((ArrayOfVar *)ZTypePool_TypeList_Z17);
	LibZen_ArrayAdd((ArrayOfVar *)ZTypePool_TypeList_Z17, (var)T);
	return TypeId__1;
}
static struct ZType60 * TypeOf__1qqr(long TypeId) {
	if (TypeId == 0) {
		return ZTypeVarType_Z4;
	};
	if (TypeId < LibZen_ArraySize((ArrayOfVar *)ZTypePool_TypeList_Z17)) {
		return Array<ZType>GetIndex(TypeId);
	};
	return ZTypeVarType_Z4;
}
static const char * ZTypePool_MangleType2__2qwz(struct ZType60 * Type1, struct ZType60 * Type2__1) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(Type1->TypeId)), ":"), LibZen_IntToString(Type2__1->TypeId));
}
static const char * ZTypePool_MangleTypes__1qwx(ArrayOfZType * TypeList) {
	const char * s__1 = "";
	long i__2 = 0;
	while (i__2 < LibZen_ArraySize((ArrayOfVar *)TypeList)) {
		struct ZType60 * Type__3 = Array<ZType>GetIndex(i__2);
		s__1 = LibZen_StrCat(LibZen_StrCat(s__1, ":"), LibZen_IntToString(Type__3->TypeId));
		i__2 = i__2 + 1;
	};
	return s__1;
}
static ArrayOfZType * ZTypePool_UniqueTypes__1qwx(ArrayOfZType * TypeList) {
	const char * MangleName__1 = LibZen_StrCat("[]", ZTypePool_MangleTypes__1qwx(TypeList));
	ArrayOfZType * Types__2 = Map<Array<ZType>>GetIndex(MangleName__1);
	if (Types__2 == NULL) {
		Types__2 = TypeList;
		Map<Array<ZType>>SetIndex(MangleName__1, Types__2);
	};
	return Types__2;
}
static struct ZType60 * ZTypePool_GetGenericType1__2qwz(struct ZType60 * BaseType, struct ZType60 * ParamType__1) {
	const char * MangleName__2 = ZTypePool_MangleType2__2qwz(BaseType, ParamType__1);
	struct ZType60 * GenericType__3 = Map<ZType>GetIndex(MangleName__2);
	if (GenericType__3 == NULL) {
		const char * Name__4 = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), toString__1qwz(ParamType__1)), ">");
		if (IsArrayType__1qwz(BaseType)) {
			Name__4 = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), toString__1qwz(ParamType__1)), ">");
		};
		GenericType__3 = ZGenericType__5qe8(_NewZGenericType107(), ZTypeUniqueTypeFlag_Z1, Name__4, BaseType, ParamType__1);
		Map<ZType>SetIndex(MangleName__2, GenericType__3);
	};
	return GenericType__3;
}
static struct ZType60 * ZTypePool_GetGenericType__3qwz(struct ZType60 * BaseType, ArrayOfZType * TypeList__1, int IsCreation__2) {
	LibZen_Assert(BaseType->GetParamSize(BaseType) > 0, "(libzen/libzen.zen:1740)");
	if (LibZen_ArraySize((ArrayOfVar *)TypeList__1) == 1 && !IsFuncType__1qwz(BaseType)) {
		return ZTypePool_GetGenericType1__2qwz(BaseType, Array<ZType>GetIndex(0));
	};
	const char * MangleName__7 = LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(BaseType->TypeId)), ZTypePool_MangleTypes__1qwx(TypeList__1));
	struct ZType60 * GenericType__8 = Map<ZType>GetIndex(MangleName__3);
	if ((GenericType__4 == NULL) && IsCreation__2) {
		const char * ShortName__9 = LibZen_StrCat(BaseType->ShortName, "<");
		long i__10 = 0;
		while (i__6 < LibZen_ArraySize((ArrayOfVar *)TypeList__1)) {
			ShortName__9 = LibZen_StrCat(ShortName__5, Array<ZType>GetIndex(i__6)->GetRealType(Array<ZType>GetIndex(i__6))->ShortName);
			if ((i__6 + 1) == LibZen_ArraySize((ArrayOfVar *)TypeList__1)) {
				ShortName__5 = LibZen_StrCat(ShortName__5, ">");
			} else {
				ShortName__5 = LibZen_StrCat(ShortName__5, ",");
			};
			i__6 = i__6 + 1;
		};
		if (IsFuncType__1qwz(BaseType)) {
			GenericType__4 = ZFuncType__3qej(_NewZFuncType90(), ShortName__5, ZTypePool_UniqueTypes__1qwx(TypeList__1));
		} else {
		};
		Map<ZType>SetIndex(MangleName__3, GenericType__4);
	};
	return GenericType__4;
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__1qwx(ArrayOfZType * TypeList) {
	struct ZType60 * FuncType__1 = ZTypePool_GetGenericType__3qwz(ZFuncType_FuncType_Z14, TypeList, 1/*true*/);
	if (LibZen_Is(FuncType__1, 90)) {
		return (struct ZFuncType90 *)FuncType__1;
	};
	return NULL;
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__1qwz(struct ZType60 * R) {
	ArrayOfZType * TypeList__1 = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__1, (var)R);
	return ZTypePool_LookupFuncType__1qwx(TypeList__1);
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__2qwz(struct ZType60 * R, struct ZType60 * P1__1) {
	ArrayOfZType * TypeList__2 = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__2, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__2, (var)P1__1);
	return ZTypePool_LookupFuncType__1qwx(TypeList__2);
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__3qwz(struct ZType60 * R, struct ZType60 * P1__1, struct ZType60 * P2__2) {
	ArrayOfZType * TypeList__3 = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__3, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__3, (var)P1__1);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__3, (var)P2__2);
	return ZTypePool_LookupFuncType__1qwx(TypeList__3);
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__4qwz(struct ZType60 * R, struct ZType60 * P1__1, struct ZType60 * P2__2, struct ZType60 * P3__3) {
	ArrayOfZType * TypeList__4 = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__4, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__4, (var)P1__1);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__4, (var)P2__2);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__4, (var)P3__3);
	return ZTypePool_LookupFuncType__1qwx(TypeList__4);
}
static struct ZVarScope134 * ZVarScope__4qrc(struct ZVarScope134 * this, struct ZVarScope134 * Parent__1, struct ZLogger135 * Logger__2, ArrayOfZVarType * VarList__3) {
	this->Parent = Parent__1;
	this->Logger = Logger__2;
	this->VarList = VarList__3;
	if (this->VarList == NULL) {
		this->VarList = LibZen_NewArray(0);
	};
	return NULL;
}
static struct ZType60 * NewVarType__4qrc(struct ZVarScope134 * this, struct ZType60 * VarType__1, const char * Name__2, struct ZToken77 * SourceToken__3) {
	if (!(LibZen_Is(VarType__1, 136)) && /*untyped*/NULL(VarType__1)) {
		VarType__1 = ZVarType__4qrb(_NewZVarType136(), this->VarList, Name__2, SourceToken__3);
	};
	return VarType__1;
}
static void FoundUnresolvedSymbol__2qrc(struct ZVarScope134 * this, const char * FuncName__1) {
	this->UnresolvedSymbolCount = this->UnresolvedSymbolCount + 1;
	return;
}
static void CheckVarNode__3qrc(struct ZVarScope134 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2) {
	if (IsUntyped__1qwg(Node__2)) {
		this->VarNodeCount = this->VarNodeCount + 1;
	};
	if (IsInferrableType__1qwz(ContextType__1) && LibZen_Is(Node__2->Type, 136)) {
		Infer__3qrb(((struct ZVarType136 *)Node__2->Type), ContextType__1, Node__2->SourceToken);
		Node__2->Type = ContextType__1;
	};
	if (LibZen_Is(ContextType__1, 136) && !IsUntyped__1qwg(Node__2)) {
		Infer__3qrb(((struct ZVarType136 *)ContextType__1), Node__2->Type, Node__2->SourceToken);
	};
	return;
}
static int TypeCheckStmtList__3qrc(struct ZVarScope134 * this, struct ZTypeChecker142 * TypeSafer__1, ArrayOfZNode * StmtList__2) {
	long PrevCount__3 = -1;
	while (1/*true*/) {
		long i__4 = 0;
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		while (i__4 < LibZen_ArraySize((ArrayOfVar *)StmtList__2)) {
			Array<ZNode>SetIndex(i__4, CheckType__3qr2(TypeSafer__1, Array<ZNode>GetIndex(i__4), ZTypeVoidType_Z5));
			i__4 = i__4 + 1;
		};
		if (this->VarNodeCount == 0 || PrevCount__3 == this->VarNodeCount) {
			break;
		};
		PrevCount__3 = this->VarNodeCount;
	};
	if (this->VarNodeCount == 0) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void TypeCheckFuncBlock__3qrc(struct ZVarScope134 * this, struct ZTypeChecker142 * TypeSafer__1, struct ZFunctionNode144 * FunctionNode__2) {
	long PrevCount__3 = -1;
	while (1/*true*/) {
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		/*untyped*/NULL(TypeSafer__1, FunctionNode__2, 0/*false*/);
		Array<ZNode>SetIndex(ZFunctionNode_Block_Z80, CheckType__3qr2(TypeSafer__1, Array<ZNode>GetIndex(ZFunctionNode_Block_Z80), ZTypeVoidType_Z5));
		if (this->VarNodeCount == 0 || PrevCount__3 == this->VarNodeCount) {
			break;
		};
		PrevCount__3 = this->VarNodeCount;
	};
	if (this->UnresolvedSymbolCount == 0) {
		/*untyped*/NULL(TypeSafer__1, FunctionNode__2, 1/*true*/);
	} else {
		/*untyped*/NULL(TypeSafer__1, FunctionNode__2, 0/*false*/);
		if (this->Parent != NULL) {
			this->Parent->UnresolvedSymbolCount = this->UnresolvedSymbolCount + this->Parent->UnresolvedSymbolCount;
		};
	};
	return;
}
static struct ZVarType136 * ZVarType__4qrb(struct ZVarType136 * this, ArrayOfZVarType * VarList__1, const char * Name__2, struct ZToken77 * SourceToken__3) {
	(void)ZType__4qwz(this, 0, Name__2, ZTypeVarType_Z4);
	this->VarList = VarList__1;
	this->SourceToken = SourceToken__3;
	this->GreekId = LibZen_ArraySize((ArrayOfVar *)VarList__1);
	LibZen_ArrayAdd((ArrayOfVar *)VarList__1, (var)this);
	this->TypeId = this->RefType->TypeId;
	return NULL;
}
static struct ZType60 * GetRealType__1qrb(struct ZVarType136 * this) {
	return this->RefType;
}
static long GetParamSize__1qrb(struct ZVarType136 * this) {
	return /*untyped*/NULL(this->RefType);
}
static struct ZType60 * GetParamType__2qrb(struct ZVarType136 * this, long Index__1) {
	return /*untyped*/NULL(this->RefType, Index__1);
}
static int IsFuncType__1qrb(struct ZVarType136 * this) {
	return IsFuncType__1qwz(this->RefType);
}
static int IsVarType__1qrb(struct ZVarType136 * this) {
	return /*untyped*/NULL(this->RefType);
}
static void Infer__3qrb(struct ZVarType136 * this, struct ZType60 * ContextType__1, struct ZToken77 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(ContextType__1, 136) && /*untyped*/NULL(ContextType__1)) {
			struct ZVarType136 * VarType__3 = (struct ZVarType136 *)ContextType__1;
			if (this->GreekId < VarType__3->GreekId) {
				VarType__3->GreekId = this->GreekId;
			} else {
				this->GreekId = VarType__3->GreekId;
			};
		} else {
			this->RefType = /*untyped*/NULL(ContextType__1);
			this->SourceToken = SourceToken__2;
			this->TypeId = this->RefType->TypeId;
			this->TypeFlag = this->RefType->TypeFlag;
		};
	};
	return;
}
static void Maybe__3qrb(struct ZVarType136 * this, struct ZType60 * T__1, struct ZToken77 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(T__1, 136) && /*untyped*/NULL(T__1)) {
			struct ZVarType136 * VarType__3 = (struct ZVarType136 *)T__1;
			if (this->GreekId < VarType__3->GreekId) {
				VarType__3->GreekId = this->GreekId;
			} else {
				this->GreekId = VarType__3->GreekId;
			};
		} else {
			this->RefType = /*untyped*/NULL(T__1);
			this->SourceToken = SourceToken__2;
			this->TypeId = T__1->TypeId;
			this->TypeFlag = T__1->TypeFlag;
		};
	};
	return;
}
static struct ZNode52 * ZNode__4qwg(struct ZNode52 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, long Size__3) {
	LibZen_Assert(this != ParentNode__1, "(libzen/libzen.zen:1948)");
	this->ParentNode = ParentNode__1;
	this->SourceToken = SourceToken__2;
	if (Size__3 > 0) {
		this->AST = LibZen_NewNodeArray__1qqr(Size__3);
	} else {
		this->AST = NULL;
	};
	return NULL;
}
static struct ZNode52 * SetChild__2qwg(struct ZNode52 * this, struct ZNode52 * Node__1) {
	LibZen_Assert(Node__1 != NULL, "(libzen/libzen.zen:1960)");
	if (Node__1 != NULL) {
		LibZen_Assert(this != Node__1, "(libzen/libzen.zen:1962)");
		Node__1->ParentNode = this;
	};
	return Node__1;
}
static void SetNameInfo__3qwg(struct ZNode52 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	LibZen_Assert(Name__2 == NULL, "(libzen/libzen.zen:1969)");
	return;
}
static void SetTypeInfo__3qwg(struct ZNode52 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->Type = Type__2;
	return;
}
static void Set__3qwg(struct ZNode52 * this, long Index__1, struct ZNode52 * Node__2) {
	if (Index__1 >= 0) {
		Array<ZNode>SetIndex(Index__1, SetChild__2qwg(this, Node__2));
	} else if (Index__1 == ZNode_AppendIndex_Z23) {
		struct ZNode52 * ListNode__3 = this;
		if (LibZen_Is(ListNode__3, 251)) {
			Append__2qu8(((struct ZListNode251 *)ListNode__3), Node__2);
		} else {
			LibZen_Assert(LibZen_Is(ListNode__3, 251), "(libzen/libzen.zen:1986)");
		};
	} else if (Index__1 == ZNode_NameInfo_Z21) {
		/*untyped*/NULL(this, Node__2->SourceToken, GetText__1qey(Node__2->SourceToken));
		this->SourceToken = Node__2->SourceToken;
		return;
	} else if (Index__1 == ZNode_TypeInfo_Z22) {
		/*untyped*/NULL(this, Node__2->SourceToken, Node__2->Type);
		return;
	};
	return;
}
static long GetAstSize__1qwg(struct ZNode52 * this) {
	if (this->AST == NULL) {
		return 0;
	};
	return LibZen_ArraySize((ArrayOfVar *)this->AST);
}
static int HasAst__2qwg(struct ZNode52 * this, long Index__1) {
	if (this->AST != NULL && Index__1 < LibZen_ArraySize((ArrayOfVar *)this->AST)) {
		return Array<ZNode>GetIndex(Index__1) != NULL;
	};
	return 0/*false*/;
}
static struct ZType60 * GetAstType__2qwg(struct ZNode52 * this, long Index__1) {
	return /*untyped*/NULL(Array<ZNode>GetIndex(Index__1)->Type);
}
static const char * GetSourceLocation__1qwg(struct ZNode52 * this) {
	if (this->SourceToken != NULL) {
		return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", GetFileName__1qey(this->SourceToken)), ":"), LibZen_IntToString(GetLineNumber__1qey(this->SourceToken))), ")");
	};
	return NULL;
}
static const char * toString__1qwg(struct ZNode52 * this) {
	const char * Self__3 = LibZen_StrCat("#", LibZen_GetClassName__1qqq(this));
	if (!this->Type->IsVarType(this->Type)) {
		Self__1 = LibZen_StrCat(LibZen_StrCat(Self__1, ":"), toString__1qwz(this->Type));
	} else {
		Self__1 = LibZen_StrCat(Self__1, ":?");
	};
	if (this->AST != NULL) {
		long i__2 = 0;
		Self__1 = LibZen_StrCat(Self__1, "[");
		while (i__2 < LibZen_ArraySize((ArrayOfVar *)this->AST)) {
			if (i__2 > 0) {
				Self__1 = LibZen_StrCat(Self__1, ",");
			};
			if (Array<ZNode>GetIndex(i__2) == NULL) {
				Self__1 = LibZen_StrCat(Self__1, "null");
			} else {
				Self__1 = LibZen_StrCat(Self__1, toString__1qwg(Array<ZNode>GetIndex(i__2)));
			};
			i__2 = i__2 + 1;
		};
		Self__1 = LibZen_StrCat(Self__1, "]");
	};
	return Self__1;
}
static struct ZBlockNode161 * GetScopeBlockNode__1qwg(struct ZNode52 * this) {
	struct ZNode52 * Node__1 = this;
	while (Node__1 != NULL) {
		if (LibZen_Is(Node__1, 161)) {
			return (struct ZBlockNode161 *)Node__1;
		};
		LibZen_Assert(!(Node__1 == Node__1->ParentNode), "(libzen/libzen.zen:2059)");
		Node__1 = Node__1->ParentNode;
	};
	return NULL;
}
static struct ZNameSpace48 * GetNameSpace__1qwg(struct ZNode52 * this) {
	struct ZBlockNode161 * BlockNode__1 = GetScopeBlockNode__1qwg(this);
	return BlockNode__1->NameSpace;
}
static int IsErrorNode__1qwg(struct ZNode52 * this) {
	return (LibZen_Is(this, 335));
}
static int IsBreakingBlock__1qwg(struct ZNode52 * this) {
	return 0/*false*/;
}
static struct ZSugarNode165 * DeSugar__2qwg(struct ZNode52 * this, struct ZGenerator55 * Generator__1) {
	return ZSugarNode__3qt9(_NewZSugarNode165(), this, ZErrorNode__3qp4(_NewZErrorNode335(), this->ParentNode, LibZen_StrCat("undefined code generation: ", toString__1qwg(this))));
}
static void Accept__2qwg(struct ZNode52 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static int IsUntyped__1qwg(struct ZNode52 * this) {
	return !(LibZen_Is(this->Type, 90)) && /*untyped*/NULL(this->Type);
}
static int HasUntypedNode__1qwg(struct ZNode52 * this) {
	if (this->HasUntypedNode) {
		if (!IsUntyped__1qwg(this)) {
			long i__1 = 0;
			while (i__1 < GetAstSize__1qwg(this)) {
				if (Array<ZNode>GetIndex(i__1) != NULL && HasUntypedNode__1qwg(Array<ZNode>GetIndex(i__1))) {
					return 1/*true*/;
				};
				i__1 = i__1 + 1;
			};
			this->HasUntypedNode = 0/*false*/;
			return 0/*false*/;
		};
	};
	return this->HasUntypedNode;
}
static struct ZNode52 * VisitTypeChecker__3qwg(struct ZNode52 * this, struct ZTypeChecker142 * TypeChecker__1, struct ZType60 * ContextType__2) {
	return VisitTypeChecker__3qr2(TypeChecker__1, this, ContextType__2);
}
static struct ZReturnNode170 * ToReturnNode__1qwg(struct ZNode52 * this) {
	return NULL;
}
static struct ZParamNode172 * ZParamNode__2qtb(struct ZParamNode172 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 0);
	return NULL;
}
static void SetNameInfo__3qtb(struct ZParamNode172 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->Name = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static struct ZReturnNode170 * ZReturnNode__2qtc(struct ZReturnNode170 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	return NULL;
}
static void Accept__2qtc(struct ZReturnNode170 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZReturnNode170 * ToReturnNode__1qtc(struct ZReturnNode170 * this) {
	return this;
}
static struct ZSetIndexNode178 * ZSetIndexNode__3qt2(struct ZSetIndexNode178 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 3);
	Set__3qwg(this, ZSetIndexNode_Recv_Z26, LeftNode__2);
	return NULL;
}
static void Accept__2qt2(struct ZSetIndexNode178 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZSetNameNode181 * ZSetNameNode__4qyw(struct ZSetNameNode181 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * VarName__3) {
	(void)ZNode__4qwg(this, ParentNode__1, Token__2, 1);
	this->VarName = VarName__3;
	return NULL;
}
static void Accept__2qyw(struct ZSetNameNode181 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZSetterNode184 * ZSetterNode__3qyt(struct ZSetterNode184 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 2);
	Set__3qwg(this, ZSetterNode_Recv_Z30, RecvNode__2);
	return NULL;
}
static void SetNameInfo__3qyt(struct ZSetterNode184 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FieldName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static void Accept__2qyt(struct ZSetterNode184 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static int IsStaticField__1qyt(struct ZSetterNode184 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZSetterNode_Recv_Z30), 235);
}
static struct ZSugarNode165 * ZSugarNode__3qt9(struct ZSugarNode165 * this, struct ZNode52 * SugarNode__1, struct ZNode52 * DeSugarNode__2) {
	(void)ZNode__4qwg(this, SugarNode__1->ParentNode, NULL, 1);
	this->SugarNode = SugarNode__1;
	SugarNode__1->ParentNode = this;
	Set__3qwg(this, ZSugarNode_DeSugar_Z32, DeSugarNode__2);
	DeSugarNode__2->ParentNode = this;
	return NULL;
}
static void Accept__2qt9(struct ZSugarNode165 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZThrowNode191 * ZThrowNode__2qy4(struct ZThrowNode191 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	return NULL;
}
static void Accept__2qy4(struct ZThrowNode191 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZTryNode194 * ZTryNode__2qyd(struct ZTryNode194 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 3);
	return NULL;
}
static void Accept__2qyd(struct ZTryNode194 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZUnaryNode197 * ZUnaryNode__3qyh(struct ZUnaryNode197 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2) {
	(void)ZNode__4qwg(this, ParentNode__1, Token__2, 1);
	return NULL;
}
static void Accept__2qyh(struct ZUnaryNode197 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZWhileNode200 * ZWhileNode__2qyl(struct ZWhileNode200 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 2);
	return NULL;
}
static void Accept__2qyl(struct ZWhileNode200 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static const char * toString__1qy6(struct ZEmptyValue203 * this) {
	return "";
}
static const char * ZLogger_LogError__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message__1 = FormatErrorMarker__4qu1(Token->Source, "error", Token->StartIndex, Message__1);
		Report__2qrv(Token->Source->Logger, Message__1);
	};
	return Message__1;
}
static void ZLogger_LogWarning__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message__1 = FormatErrorMarker__4qu1(Token->Source, "warning", Token->StartIndex, Message__1);
		Report__2qrv(Token->Source->Logger, Message__1);
	};
	return;
}
static void ZLogger_LogInfo__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message__1 = FormatErrorMarker__4qu1(Token->Source, "info", Token->StartIndex, Message__1);
		Report__2qrv(Token->Source->Logger, Message__1);
	};
	return;
}
static void ZLogger_LogDebug__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message__1 = FormatErrorMarker__4qu1(Token->Source, "debug", Token->StartIndex, Message__1);
		Report__2qrv(Token->Source->Logger, Message__1);
	};
	return;
}
static void Report__2qrv(struct ZLogger135 * this, const char * Message__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->ReportedErrorList, (var)Message__1);
	return;
}
static ArrayOfString * GetReportedErrors__1qrv(struct ZLogger135 * this) {
	ArrayOfString * List__1 = this->ReportedErrorList;
	this->ReportedErrorList = LibZen_NewStringArray(0);
	return List__1;
}
static void ShowErrors__1qrv(struct ZLogger135 * this) {
	ArrayOfString * Messages__1 = GetReportedErrors__1qrv(this);
	long i__2 = 0;
	while (i__2 < LibZen_ArraySize((ArrayOfVar *)Messages__1)) {
		LibZen_PrintLine__1qqy(Array<String>GetIndex(i__2));
		i__2 = i__2 + 1;
	};
	return;
}
static struct ZMacroFunc210 * ZMacroFunc__3qym(struct ZMacroFunc210 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2) {
	(void)ZFunc__4qeh(this, 0, FuncName__1, FuncType__2);
	return NULL;
}
static const char * ZNameSpace_RightPatternSymbol__1qqy(const char * PatternName) {
	return LibZen_StrCat("\t", PatternName);
}
static struct ZNameSpace48 * ZNameSpace__3qwa(struct ZNameSpace48 * this, struct ZGenerator55 * Generator__1, struct ZNameSpace48 * ParentNameSpace__2) {
	this->ParentNameSpace = ParentNameSpace__2;
	if (ParentNameSpace__2 == NULL) {
		this->Generator = Generator__1;
	} else {
		this->Generator = ParentNameSpace__2->Generator;
	};
	this->SerialId = 0;
	return NULL;
}
static const char * toString__1qwa(struct ZNameSpace48 * this) {
	return LibZen_StrCat(LibZen_StrCat("NS[", LibZen_IntToString(this->SerialId)), "]");
}
static struct ZNameSpace48 * CreateSubNameSpace__1qwa(struct ZNameSpace48 * this) {
	return ZNameSpace__3qwa(_NewZNameSpace48(), NULL, this);
}
static struct ZNameSpace48 * GetRootNameSpace__1qwa(struct ZNameSpace48 * this) {
	return this->Generator->RootNameSpace;
}
static struct ZTokenFunc35 * GetTokenFunc__2qwa(struct ZNameSpace48 * this, long ZenChar__1) {
	if (this->TokenMatrix == NULL) {
		return GetTokenFunc__2qwa(this->ParentNameSpace, ZenChar__1);
	};
	return Array<ZTokenFunc>GetIndex(ZenChar__1);
}
static struct ZTokenFunc35 * JoinParentFunc__3qwa(struct ZNameSpace48 * this, struct ZTokenFunction216 * Func__1, struct ZTokenFunc35 * Parent__2) {
	if (Parent__2 != NULL && Parent__2->Func == Func__1) {
		return Parent__2;
	};
	return ZTokenFunc__3qq8(_NewZTokenFunc35(), Func__1, Parent__2);
}
static void AppendTokenFunc__3qwa(struct ZNameSpace48 * this, const char * keys__1, struct ZTokenFunction216 * TokenFunc__2) {
	if (this->TokenMatrix == NULL) {
		this->TokenMatrix = LibZen_NewTokenMatrix__0qqw();
		if (this->ParentNameSpace != NULL) {
			long i__3 = 0;
			while (i__3 < LibZen_ArraySize((ArrayOfVar *)this->TokenMatrix)) {
				Array<ZTokenFunc>SetIndex(i__3, GetTokenFunc__2qwa(this->ParentNameSpace, i__3));
				i__3 = i__3 + 1;
			};
		};
	};
	long i__4 = 0;
	while (i__4 < LibZen_StringSize(keys__1)) {
		long kchar__5 = LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(keys__1, i__4));
		Array<ZTokenFunc>SetIndex(kchar__5, JoinParentFunc__3qwa(this, TokenFunc__2, Array<ZTokenFunc>GetIndex(kchar__5)));
		i__4 = i__4 + 1;
	};
	return;
}
static struct ZSyntax219 * GetSyntaxPattern__2qwa(struct ZNameSpace48 * this, const char * PatternName__1) {
	struct ZNameSpace48 * NameSpace__2 = this;
	while (NameSpace__2 != NULL) {
		if (NameSpace__2->SyntaxTable != NULL) {
			return Map<ZSyntax>GetIndex(PatternName__1);
		};
		NameSpace__2 = NameSpace__2->ParentNameSpace;
	};
	return NULL;
}
static void SetSyntaxPattern__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZSyntax219 * Syntax__2) {
	if (this->SyntaxTable == NULL) {
		this->SyntaxTable = LibZen_NewMap(0);
	};
	Map<ZSyntax>SetIndex(PatternName__1, Syntax__2);
	return;
}
static struct ZSyntax219 * GetRightSyntaxPattern__2qwa(struct ZNameSpace48 * this, const char * PatternName__1) {
	return GetSyntaxPattern__2qwa(this, ZNameSpace_RightPatternSymbol__1qqy(PatternName__1));
}
static void AppendSyntaxPattern__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZSyntax219 * NewPattern__2) {
	LibZen_Assert__1qqe(NewPattern__2->ParentPattern == NULL);
	struct ZSyntax219 * ParentPattern__3 = GetSyntaxPattern__2qwa(this, PatternName__1);
	NewPattern__2->ParentPattern = ParentPattern__3;
	SetSyntaxPattern__3qwa(this, PatternName__1, NewPattern__2);
	return;
}
static void DefineStatement__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZMatchFunction222 * MatchFunc__2) {
	long Alias__3 = LibZen_IndexOf(PatternName__1, " ");
	const char * Name__4 = PatternName__1;
	if (Alias__3 != -1) {
		Name__4 = LibZen_SubString2(PatternName__1, 0);
	};
	struct ZSyntax219 * Pattern__5 = ZSyntax__4qur(_NewZSyntax219(), this, Name__4, MatchFunc__2);
	Pattern__5->IsStatement = 1/*true*/;
	AppendSyntaxPattern__3qwa(this, Name__4, Pattern__5);
	if (Alias__3 != -1) {
		DefineStatement__3qwa(this, LibZen_SubString(PatternName__1, Alias__3 + 1), MatchFunc__2);
	};
	return;
}
static void DefineExpression__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZMatchFunction222 * MatchFunc__2) {
	long Alias__3 = LibZen_IndexOf(PatternName__1, " ");
	const char * Name__4 = PatternName__1;
	if (Alias__3 != -1) {
		Name__4 = LibZen_SubString2(PatternName__1, 0);
	};
	struct ZSyntax219 * Pattern__5 = ZSyntax__4qur(_NewZSyntax219(), this, Name__4, MatchFunc__2);
	AppendSyntaxPattern__3qwa(this, Name__4, Pattern__5);
	if (Alias__3 != -1) {
		DefineExpression__3qwa(this, LibZen_SubString(PatternName__1, Alias__3 + 1), MatchFunc__2);
	};
	return;
}
static void DefineRightExpression__4qwa(struct ZNameSpace48 * this, const char * PatternName__1, long SyntaxFlag__2, struct ZMatchFunction222 * MatchFunc__3) {
	long Alias__4 = LibZen_IndexOf(PatternName__1, " ");
	const char * Name__5 = PatternName__1;
	if (Alias__4 != -1) {
		Name__5 = LibZen_SubString2(PatternName__1, 0);
	};
	struct ZSyntax219 * Pattern__6 = ZSyntax__4qur(_NewZSyntax219(), this, Name__5, MatchFunc__3);
	Pattern__6->SyntaxFlag = SyntaxFlag__2;
	AppendSyntaxPattern__3qwa(this, ZNameSpace_RightPatternSymbol__1qqy(Name__5), Pattern__6);
	if (Alias__4 != -1) {
		DefineRightExpression__4qwa(this, LibZen_SubString(PatternName__1, Alias__4 + 1), SyntaxFlag__2, MatchFunc__3);
	};
	return;
}
static struct ZSymbolEntry225 * GetSymbol__2qwa(struct ZNameSpace48 * this, const char * Symbol__1) {
	struct ZNameSpace48 * NameSpace__2 = this;
	while (NameSpace__2 != NULL) {
		if (NameSpace__2->SymbolTable != NULL) {
			struct ZSymbolEntry225 * Entry__3 = Map<ZSymbolEntry>GetIndex(Symbol__1);
			if (Entry__3 != NULL) {
				if (Entry__3->IsDisabled) {
					return NULL;
				};
				return Entry__3;
			};
		};
		NameSpace__2 = NameSpace__2->ParentNameSpace;
	};
	return NULL;
}
static struct ZNode52 * GetSymbolNode__2qwa(struct ZNameSpace48 * this, const char * Symbol__1) {
	struct ZSymbolEntry225 * Entry__2 = GetSymbol__2qwa(this, Symbol__1);
	if (Entry__2 != NULL) {
		return Entry__2->Node;
	};
	return NULL;
}
static void SetLocalSymbolEntry__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZSymbolEntry225 * Entry__2) {
	if (this->SymbolTable == NULL) {
		this->SymbolTable = LibZen_NewMap(0);
	};
	Map<ZSymbolEntry>SetIndex(Symbol__1, Entry__2);
	return;
}
static struct ZSymbolEntry225 * SetLocalSymbol__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZNode52 * Node__2) {
	struct ZSymbolEntry225 * Parent__3 = GetSymbol__2qwa(this, Symbol__1);
	Node__2->ParentNode = NULL;
	SetLocalSymbolEntry__3qwa(this, Symbol__1, ZSymbolEntry__3qup(_NewZSymbolEntry225(), Parent__3, Node__2));
	return Parent__3;
}
static struct ZSymbolEntry225 * SetGlobalSymbol__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZNode52 * Node__2) {
	return SetLocalSymbol__3qwa(GetRootNameSpace__1qwa(this), Symbol__1, Node__2);
}
static struct ZVariable230 * GetLocalVariable__2qwa(struct ZNameSpace48 * this, const char * VarName__1) {
	struct ZSymbolEntry225 * Entry__2 = GetSymbol__2qwa(this, VarName__1);
	if (LibZen_Is(Entry__2, 230)) {
		return (struct ZVariable230 *)Entry__2;
	};
	return NULL;
}
static long SetLocalVariable__5qwa(struct ZNameSpace48 * this, struct ZFunctionNode144 * FunctionNode__1, struct ZType60 * VarType__2, const char * VarName__3, struct ZToken77 * SourceToken__4) {
	struct ZSymbolEntry225 * Parent__5 = GetSymbol__2qwa(this, VarName__3);
	struct ZVariable230 * VarInfo__6 = ZVariable__7qud(_NewZVariable230(), Parent__5, FunctionNode__1, 0, VarType__2, VarName__3, SourceToken__4);
	SetLocalSymbolEntry__3qwa(this, VarName__3, VarInfo__6);
	return VarInfo__6->VarUniqueIndex;
}
static void SetTypeName__4qwa(struct ZNameSpace48 * this, const char * Name__1, struct ZType60 * Type__2, struct ZToken77 * SourceToken__3) {
	struct ZTypeNode235 * Node__4 = ZTypeNode__4quk(_NewZTypeNode235(), NULL, SourceToken__3, Type__2);
	(void)SetLocalSymbol__3qwa(this, Name__1, Node__4);
	return;
}
static void SetTypeName__3qwa(struct ZNameSpace48 * this, struct ZType60 * Type__1, struct ZToken77 * SourceToken__2) {
	SetTypeName__4qwa(this, Type__1->ShortName, Type__1, SourceToken__2);
	return;
}
static struct ZTypeNode235 * GetTypeNode__3qwa(struct ZNameSpace48 * this, const char * TypeName__1, struct ZToken77 * SourceToken__2) {
	struct ZNode52 * Node__3 = GetSymbolNode__2qwa(this, TypeName__1);
	if (LibZen_Is(Node__3, 235)) {
		return (struct ZTypeNode235 *)Node__3;
	};
	if (Node__3 == NULL && SourceToken__2 != NULL) {
		struct ZType60 * Type__4 = ZClassType__3qeo(_NewZClassType80(), TypeName__1, ZTypeVarType_Z4);
		SetTypeName__4qwa(GetRootNameSpace__1qwa(this), TypeName__1, Type__4, SourceToken__2);
		return GetTypeNode__3qwa(this, TypeName__1, NULL);
	};
	return NULL;
}
static struct ZType60 * GetType__3qwa(struct ZNameSpace48 * this, const char * TypeName__1, struct ZToken77 * SourceToken__2) {
	struct ZTypeNode235 * TypeNode__3 = GetTypeNode__3qwa(this, TypeName__1, SourceToken__2);
	if (TypeNode__3 != NULL) {
		return TypeNode__3->Type;
	};
	return NULL;
}
static struct ZSource238 * ZSource__5qu1(struct ZSource238 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext53 * TokenContext__4) {
	this->FileName = FileName__1;
	this->LineNumber = LineNumber__2;
	this->TokenContext = TokenContext__4;
	this->SourceText = Source__3;
	this->Logger = TokenContext__4->Generator->Logger;
	return NULL;
}
static long GetLineNumber__2qu1(struct ZSource238 * this, long Position__1) {
	long LineNumber__2 = this->LineNumber;
	long i__3 = 0;
	while (i__3 < Position__1) {
		const char * ch__4 = LibZen_GetChar__2qqy(this->SourceText, i__3);
		if (ch__4 == "\n") {
			LineNumber__2 = LineNumber__2 + 1;
		};
		i__3 = i__3 + 1;
	};
	return LineNumber__2;
}
static long GetLineHeadPosition__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s__2 = this->SourceText;
	long StartIndex__3 = 0;
	long i__4 = Position__1;
	if (!(i__4 < LibZen_StringSize(s__2))) {
		i__4 = LibZen_StringSize(s__2) - 1;
	};
	while (i__4 >= 0) {
		const char * ch__5 = LibZen_GetChar__2qqy(s__2, i__4);
		if (ch__5 == "\n") {
			StartIndex__3 = i__4 + 1;
			break;
		};
		i__4 = i__4 - 1;
	};
	return StartIndex__3;
}
static long CountIndentSize__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s__2 = this->SourceText;
	long length__3 = 0;
	long i__4 = Position__1;
	while (i__4 < LibZen_StringSize(s__2)) {
		const char * ch__5 = LibZen_GetChar__2qqy(s__2, i__4);
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
static const char * GetLineText__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s__2 = this->SourceText;
	long StartIndex__3 = 0;
	long EndIndex__4 = LibZen_StringSize(s__2);
	long i__5 = Position__1;
	if (!(i__5 < LibZen_StringSize(s__2))) {
		i__5 = LibZen_StringSize(s__2) - 1;
	};
	while (i__5 >= 0) {
		const char * ch__6 = LibZen_GetChar__2qqy(s__2, i__5);
		if (ch__6 == "\n") {
			StartIndex__3 = i__5 + 1;
			break;
		};
		i__5 = i__5 - 1;
	};
	i__5 = Position__1;
	while (i__5 < LibZen_StringSize(s__2)) {
		const char * ch__7 = LibZen_GetChar__2qqy(s__2, i__5);
		if (ch__7 == "\n") {
			EndIndex__4 = i__5;
			break;
		};
		i__5 = i__5 + 1;
	};
	return LibZen_SubString2(s__2, StartIndex__3);
}
static const char * GetLineMarker__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s__2 = this->SourceText;
	long StartIndex__3 = 0;
	long i__4 = Position__1;
	if (!(i__4 < LibZen_StringSize(s__2))) {
		i__4 = LibZen_StringSize(s__2) - 1;
	};
	while (i__4 >= 0) {
		const char * ch__5 = LibZen_GetChar__2qqy(s__2, i__4);
		if (ch__5 == "\n") {
			StartIndex__3 = i__4 + 1;
			break;
		};
		i__4 = i__4 - 1;
	};
	const char * Line__6 = "";
	i__4 = StartIndex__3;
	while (i__4 < Position__1) {
		const char * ch__7 = LibZen_GetChar__2qqy(s__2, i__4);
		if (ch__7 == "\n") {
			break;
		};
		if (ch__7 == "\t") {
			Line__6 = LibZen_StrCat(Line__6, "\t");
		} else {
			Line__6 = LibZen_StrCat(Line__6, " ");
		};
		i__4 = i__4 + 1;
	};
	return LibZen_StrCat(Line__6, "^");
}
static const char * FormatErrorHeader__4qu1(struct ZSource238 * this, const char * Error__1, long Position__2, const char * Message__3) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", this->FileName), ":"), LibZen_IntToString(GetLineNumber__2qu1(this, Position__2))), ") ["), Error__1), "] "), Message__3);
}
static const char * FormatErrorMarker__4qu1(struct ZSource238 * this, const char * Error__1, long Position__2, const char * Message__3) {
	const char * Line__4 = GetLineText__2qu1(this, Position__2);
	const char * Delim__5 = "\n\t";
	if (LibZen_StartsWith(Line__4, "\t") || LibZen_StartsWith(Line__4, " ")) {
		Delim__5 = "\n";
	};
	const char * Header__6 = FormatErrorHeader__4qu1(this, Error__1, Position__2, Message__3);
	const char * Marker__7 = GetLineMarker__2qu1(this, Position__2);
	Message__3 = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(Header__6, Delim__5), Line__4), Delim__5), Marker__7);
	return Message__3;
}
static const char * GetCharAt__2qu1(struct ZSource238 * this, long n__1) {
	if (0 <= n__1 && n__1 < LibZen_StringSize(this->SourceText)) {
		return LibZen_GetChar__2qqy(this->SourceText, n__1);
	};
	return "0";
}
static struct ZSourceBuilder42 * ZSourceBuilder__3qwu(struct ZSourceBuilder42 * this, struct ZSourceGenerator243 * Template__1, struct ZSourceBuilder42 * Parent__2) {
	this->Template = Template__1;
	this->Parent = Parent__2;
	return NULL;
}
static struct ZSourceBuilder42 * Pop__1qwu(struct ZSourceBuilder42 * this) {
	return this->Parent;
}
static void Clear__1qwu(struct ZSourceBuilder42 * this) {
	LibZen_ArrayClear((ArrayOfVar *)this->SourceList);
	return;
}
static long GetPosition__1qwu(struct ZSourceBuilder42 * this) {
	return LibZen_ArraySize((ArrayOfVar *)this->SourceList);
}
static const char * CopyString__3qwu(struct ZSourceBuilder42 * this, long BeginIndex__1, long EndIndex__2) {
	return LibZen_SourceBuilderToString__3qwu(this, BeginIndex__1, EndIndex__2);
}
static void Append__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text__1);
	return;
}
static void AppendInt__2qwu(struct ZSourceBuilder42 * this, long Value__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)LibZen_StrCat("", LibZen_IntToString(Value__1)));
	return;
}
static void AppendLineFeed__1qwu(struct ZSourceBuilder42 * this) {
	if (LibZen_StringSize(this->BufferedLineComment) > 0) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->BufferedLineComment);
		this->BufferedLineComment = "";
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineFeed);
	return;
}
static void AppendLineFeed__2qwu(struct ZSourceBuilder42 * this, int AppendIndent__1) {
	if (LibZen_StringSize(this->BufferedLineComment) > 0) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->BufferedLineComment);
		this->BufferedLineComment = "";
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineFeed);
	if (AppendIndent__1) {
		AppendIndent__1qwu(this);
	};
	return;
}
static void AppendWhiteSpace__1qwu(struct ZSourceBuilder42 * this) {
	long Size__1 = LibZen_ArraySize((ArrayOfVar *)this->SourceList);
	if (Size__1 > 0) {
		const char * Last__2 = Array<String>GetIndex(Size__1 - 1);
		if (Last__2 != NULL && (LibZen_EndWidth(Last__2, " ") || LibZen_EndWidth(Last__2, "\n") || LibZen_EndWidth(Last__2, "\t"))) {
			return;
		};
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)" ");
	return;
}
static void AppendToken__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	AppendWhiteSpace__1qwu(this);
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text__1);
	AppendWhiteSpace__1qwu(this);
	return;
}
static void AppendBlockComment__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	if (this->Template->BeginComment != NULL) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->BeginComment);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text__1);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->EndComment);
	} else if (this->Template->LineComment != NULL) {
		this->BufferedLineComment = LibZen_StrCat(LibZen_StrCat(this->BufferedLineComment, this->Template->LineComment), Text__1);
	};
	return;
}
static void AppendCommentLine__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	if (this->Template->LineComment == NULL) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->BeginComment);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text__1);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->EndComment);
	} else {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineComment);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text__1);
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineFeed);
	return;
}
static void Indent__1qwu(struct ZSourceBuilder42 * this) {
	this->IndentLevel = this->IndentLevel + 1;
	this->CurrentIndentString = NULL;
	return;
}
static void UnIndent__1qwu(struct ZSourceBuilder42 * this) {
	this->IndentLevel = this->IndentLevel - 1;
	this->CurrentIndentString = NULL;
	LibZen_Assert__1qqe(this->IndentLevel >= 0);
	return;
}
static const char * GetIndentString__1qwu(struct ZSourceBuilder42 * this) {
	if (this->CurrentIndentString == NULL) {
		this->CurrentIndentString = LibZen_JoinStrings__2qqy(this->Template->Tab, this->IndentLevel);
	};
	return this->CurrentIndentString;
}
static void AppendIndent__1qwu(struct ZSourceBuilder42 * this) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)GetIndentString__1qwu(this));
	return;
}
static void AppendLineFeedIndent__1qwu(struct ZSourceBuilder42 * this) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineFeed);
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)GetIndentString__1qwu(this));
	return;
}
static void IndentAndAppend__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)GetIndentString__1qwu(this));
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text__1);
	return;
}
static void AppendParamList__4qwu(struct ZSourceBuilder42 * this, struct ZListNode251 * ParamList__1, long BeginIdx__2, long EndIdx__3) {
	long i__4 = BeginIdx__2;
	while (i__4 < EndIdx__3) {
		if (i__4 > BeginIdx__2) {
			Append__2qwu(this, this->Template->Camma);
		};
		/*untyped*/NULL(GetListAt__2qu8(ParamList__1, i__4), this->Template);
		i__4 = i__4 + 1;
	};
	return;
}
static const char * toString__1qwu(struct ZSourceBuilder42 * this) {
	return LibZen_SourceBuilderToString__1qwu(this);
}
static void AppendLine__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	Append__2qwu(this, Text__1);
	AppendLineFeed__1qwu(this);
	return;
}
static struct ZSourceContext50 * ZSourceContext__5qwd(struct ZSourceContext50 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext53 * TokenContext__4) {
	(void)ZSource__5qu1(this, FileName__1, LineNumber__2, Source__3, TokenContext__4);
	return NULL;
}
static long GetCharCode__1qwd(struct ZSourceContext50 * this) {
	return LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition));
}
static long GetPosition__1qwd(struct ZSourceContext50 * this) {
	return this->SourcePosition;
}
static int HasChar__1qwd(struct ZSourceContext50 * this) {
	return (LibZen_StringSize(this->SourceText) - this->SourcePosition) > 0;
}
static const char * GetCurrentChar__1qwd(struct ZSourceContext50 * this) {
	return LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition);
}
static const char * GetCharAtFromCurrentPosition__2qwd(struct ZSourceContext50 * this, long n__1) {
	if ((this->SourcePosition + n__1) < LibZen_StringSize(this->SourceText)) {
		return LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition + n__1);
	};
	return "0";
}
static void MoveNext__1qwd(struct ZSourceContext50 * this) {
	this->SourcePosition = this->SourcePosition + 1;
	return;
}
static void SkipWhiteSpace__1qwd(struct ZSourceContext50 * this) {
	while (HasChar__1qwd(this)) {
		const char * ch__1 = GetCurrentChar__1qwd(this);
		if (ch__1 != " " && ch__1 != "\t") {
			break;
		};
		MoveNext__1qwd(this);
	};
	return;
}
static void FoundIndent__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2) {
	struct ZToken77 * Token__3 = ZIndentToken__4qav(_NewZIndentToken459(), this, StartIndex__1, EndIndex__2);
	this->SourcePosition = EndIndex__2;
	LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token__3);
	return;
}
static void Tokenize__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2) {
	this->SourcePosition = EndIndex__2;
	if (StartIndex__1 < EndIndex__2 && EndIndex__2 <= LibZen_StringSize(this->SourceText)) {
		struct ZToken77 * Token__3 = ZToken__4qey(_NewZToken77(), this, StartIndex__1, EndIndex__2);
		LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token__3);
	};
	return;
}
static void Tokenize__4qwd(struct ZSourceContext50 * this, const char * PatternName__1, long StartIndex__2, long EndIndex__3) {
	this->SourcePosition = EndIndex__3;
	if (StartIndex__2 <= EndIndex__3 && EndIndex__3 <= LibZen_StringSize(this->SourceText)) {
		struct ZSyntax219 * Pattern__4 = GetSyntaxPattern__2qwa(this->TokenContext->NameSpace, PatternName__1);
		if (Pattern__4 == NULL) {
			struct ZToken77 * Token__5 = ZToken__4qey(_NewZToken77(), this, StartIndex__2, EndIndex__3);
			ZLogger_LogInfo__2qey(Token__5, LibZen_StrCat("unregistered token pattern: ", PatternName__1));
			LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token__5);
		} else {
			struct ZToken77 * Token__6 = ZPatternToken__5qan(_NewZPatternToken461(), this, StartIndex__2, EndIndex__3, Pattern__4);
			LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token__6);
		};
	};
	return;
}
static int IsDefinedSyntax__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2) {
	if (EndIndex__2 < LibZen_StringSize(this->SourceText)) {
		struct ZNameSpace48 * NameSpace__3 = this->TokenContext->NameSpace;
		const char * Token__4 = LibZen_SubString2(this->SourceText, StartIndex__1);
		struct ZSyntax219 * Pattern__5 = GetRightSyntaxPattern__2qwa(NameSpace__3, Token__4);
		if (Pattern__5 != NULL) {
			return 1/*true*/;
		};
	};
	return 0/*false*/;
}
static void TokenizeDefinedSymbol__2qwd(struct ZSourceContext50 * this, long StartIndex__1) {
	long EndIndex__2 = StartIndex__1 + 2;
	while (IsDefinedSyntax__3qwd(this, StartIndex__1, EndIndex__2)) {
		EndIndex__2 = EndIndex__2 + 1;
	};
	Tokenize__3qwd(this, StartIndex__1, EndIndex__2 - 1);
	return;
}
static void ApplyTokenFunc__2qwd(struct ZSourceContext50 * this, struct ZTokenFunc35 * TokenFunc__1) {
	long RollbackPosition__2 = this->SourcePosition;
	while (TokenFunc__1 != NULL) {
		this->SourcePosition = RollbackPosition__2;
		if (LibZen_ApplyTokenFunc__2qqq(TokenFunc__1->Func, this)) {
			return;
		};
		TokenFunc__1 = TokenFunc__1->ParentFunc;
	};
	TokenizeDefinedSymbol__2qwd(this, RollbackPosition__2);
	return;
}
static int DoTokenize__1qwd(struct ZSourceContext50 * this) {
	long TokenSize__1 = LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList);
	long CheckPosition__2 = this->SourcePosition;
	while (HasChar__1qwd(this)) {
		long CharCode__3 = GetCharCode__1qwd(this);
		struct ZTokenFunc35 * TokenFunc__4 = GetTokenFunc__2qwa(this->TokenContext->NameSpace, CharCode__3);
		ApplyTokenFunc__2qwd(this, TokenFunc__4);
		if (LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList) > TokenSize__1) {
			break;
		};
		if (this->SourcePosition == CheckPosition__2) {
			MoveNext__1qwd(this);
		};
	};
	if (LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList) > TokenSize__1) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void LogWarning__3qwd(struct ZSourceContext50 * this, long Position__1, const char * Message__2) {
	Report__2qrv(this->Logger, FormatErrorMarker__4qu1(this, "warning", Position__1, Message__2));
	return;
}
static struct ZSourceMacro265 * ZSourceMacro__4qis(struct ZSourceMacro265 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2, const char * Macro__3) {
	(void)ZMacroFunc__3qym(this, FuncName__1, FuncType__2);
	this->Macro = Macro__3;
	return NULL;
}
static struct ZSymbolEntry225 * ZSymbolEntry__3qup(struct ZSymbolEntry225 * this, struct ZSymbolEntry225 * Parent__1, struct ZNode52 * Node__2) {
	this->Parent = Parent__1;
	this->Node = Node__2;
	return NULL;
}
static struct ZSyntax219 * MergeSyntaxPattern__2qur(struct ZSyntax219 * Pattern, struct ZSyntax219 * Parent__1) {
	if (Parent__1 == NULL) {
		return Pattern;
	};
	struct ZSyntax219 * MergedPattern__2 = ZSyntax__4qur(_NewZSyntax219(), Pattern->PackageNameSpace, Pattern->PatternName, Pattern->MatchFunc);
	MergedPattern__2->ParentPattern = Parent__1;
	return MergedPattern__2;
}
static struct ZSyntax219 * ZSyntax__4qur(struct ZSyntax219 * this, struct ZNameSpace48 * NameSpace__1, const char * PatternName__2, struct ZMatchFunction222 * MatchFunc__3) {
	this->PackageNameSpace = NameSpace__1;
	this->PatternName = PatternName__2;
	this->MatchFunc = MatchFunc__3;
	return NULL;
}
static const char * toString__1qur(struct ZSyntax219 * this) {
	return this->PatternName;
}
static int IsBinaryOperator__1qur(struct ZSyntax219 * this) {
	return LibZen_IsFlag__2qqr(this->SyntaxFlag, ZSyntax_BinaryOperator_Z50);
}
static int IsRightJoin__2qur(struct ZSyntax219 * this, struct ZSyntax219 * Right__1) {
	long left__2 = this->SyntaxFlag;
	long right__3 = Right__1->SyntaxFlag;
	return (left__2 < right__3 || (left__2 == right__3 && !LibZen_IsFlag__2qqr(left__2, ZSyntax_LeftJoin_Z51) && !LibZen_IsFlag__2qqr(right__3, ZSyntax_LeftJoin_Z51)));
}
static struct ZToken77 * ZToken__4qey(struct ZToken77 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3) {
	this->Source = Source__1;
	this->StartIndex = StartIndex__2;
	this->EndIndex = EndIndex__3;
	return NULL;
}
static const char * GetFileName__1qey(struct ZToken77 * this) {
	return this->Source->FileName;
}
static long GetLineNumber__1qey(struct ZToken77 * this) {
	return GetLineNumber__2qu1(this->Source, this->StartIndex);
}
static const char * GetChar__1qey(struct ZToken77 * this) {
	if (this->Source != NULL) {
		return LibZen_GetChar__2qqy(this->Source->SourceText, this->StartIndex);
	};
	return "0";
}
static const char * GetText__1qey(struct ZToken77 * this) {
	if (this->Source != NULL) {
		return LibZen_SubString2(this->Source->SourceText, this->StartIndex);
	};
	return "";
}
static const char * toString__1qey(struct ZToken77 * this) {
	const char * ch__1 = GetCharAt__2qu1(this->Source, this->StartIndex - 1);
	if (ch__1 == "\"") {
		return LibZen_StrCat(LibZen_StrCat("\"", GetText__1qey(this)), "\"");
	};
	return GetText__1qey(this);
}
static int EqualsText__2qey(struct ZToken77 * this, const char * Text__1) {
	if (LibZen_StringSize(Text__1) == (this->EndIndex - this->StartIndex)) {
		const char * s__2 = this->Source->SourceText;
		long i__3 = 0;
		while (i__3 < LibZen_StringSize(Text__1)) {
			if (LibZen_GetChar__2qqy(s__2, this->StartIndex + i__3) != LibZen_GetChar__2qqy(Text__1, i__3)) {
				return 0/*false*/;
			};
			i__3 = i__3 + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int StartsWith__2qey(struct ZToken77 * this, const char * Text__1) {
	if (LibZen_StringSize(Text__1) <= (this->EndIndex - this->StartIndex)) {
		const char * s__2 = this->Source->SourceText;
		long i__3 = 0;
		while (i__3 < LibZen_StringSize(Text__1)) {
			if (LibZen_GetChar__2qqy(s__2, this->StartIndex + i__3) != LibZen_GetChar__2qqy(Text__1, i__3)) {
				return 0/*false*/;
			};
			i__3 = i__3 + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNull__1qey(struct ZToken77 * this) {
	return (this == ZToken_NullToken_Z52);
}
static int IsIndent__1qey(struct ZToken77 * this) {
	return LibZen_Is(this, 459);
}
static int IsNextWhiteSpace__1qey(struct ZToken77 * this) {
	const char * ch__1 = GetCharAt__2qu1(this->Source, this->EndIndex);
	if (ch__1 == " " || ch__1 == "\t" || ch__1 == "\n") {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNameSymbol__1qey(struct ZToken77 * this) {
	const char * ch__1 = GetCharAt__2qu1(this->Source, this->StartIndex);
	return LibZen_IsSymbol__1qqy(ch__1);
}
static long GetIndentSize__1qey(struct ZToken77 * this) {
	if (this->Source != NULL) {
		return CountIndentSize__2qu1(this->Source, GetLineHeadPosition__2qu1(this->Source, this->StartIndex));
	};
	return 0;
}
static struct ZTokenContext53 * ZTokenContext__6qwh(struct ZTokenContext53 * this, struct ZGenerator55 * Generator__1, struct ZNameSpace48 * NameSpace__2, const char * FileName__3, long LineNumber__4, const char * SourceText__5) {
	this->Generator = Generator__1;
	this->NameSpace = NameSpace__2;
	this->Source = ZSourceContext__5qwd(_NewZSourceContext50(), FileName__3, LineNumber__4, SourceText__5, this);
	return NULL;
}
static int SetParseFlag__2qwh(struct ZTokenContext53 * this, int AllowSkipIndent__1) {
	int OldFlag__2 = this->IsAllowSkipIndent;
	this->IsAllowSkipIndent = AllowSkipIndent__1;
	return OldFlag__2;
}
static struct ZToken77 * GetBeforeToken__1qwh(struct ZTokenContext53 * this) {
	long MovingPos__1 = this->CurrentPosition - 1;
	while (MovingPos__1 >= 0 && MovingPos__1 < LibZen_ArraySize((ArrayOfVar *)this->TokenList)) {
		struct ZToken77 * Token__2 = Array<ZToken>GetIndex(MovingPos__1);
		if (!IsIndent__1qey(Token__2)) {
			return Token__2;
		};
		MovingPos__1 = MovingPos__1 - 1;
	};
	return this->LatestToken;
}
static struct ZNode52 * CreateExpectedErrorNode__3qwh(struct ZTokenContext53 * this, struct ZToken77 * SourceToken__1, const char * ExpectedTokenText__2) {
	if (SourceToken__1 == NULL || IsNull__1qey(SourceToken__1)) {
		SourceToken__1 = GetBeforeToken__1qwh(this);
		SourceToken__1 = ZToken__4qey(_NewZToken77(), SourceToken__1->Source, SourceToken__1->EndIndex, SourceToken__1->EndIndex);
		return ZErrorNode__4qp4(_NewZErrorNode335(), NULL, SourceToken__1, LibZen_StrCat(ExpectedTokenText__2, " is expected"));
	};
	return ZErrorNode__4qp4(_NewZErrorNode335(), NULL, SourceToken__1, LibZen_StrCat(ExpectedTokenText__2, " is expected"));
}
static void Vacume__1qwh(struct ZTokenContext53 * this) {
	return;
}
static void MoveNext__1qwh(struct ZTokenContext53 * this) {
	this->CurrentPosition = this->CurrentPosition + 1;
	return;
}
static struct ZToken77 * GetToken__2qwh(struct ZTokenContext53 * this, int EnforceMoveNext__1) {
	while (1/*true*/) {
		if (!(this->CurrentPosition < LibZen_ArraySize((ArrayOfVar *)this->TokenList))) {
			if (!DoTokenize__1qwd(this->Source)) {
				break;
			};
		};
		struct ZToken77 * Token__2 = Array<ZToken>GetIndex(this->CurrentPosition);
		if ((this->IsAllowSkipIndent) && IsIndent__1qey(Token__2)) {
			this->CurrentPosition = this->CurrentPosition + 1;
		} else {
			this->LatestToken = Token__2;
			if (EnforceMoveNext__1) {
				this->CurrentPosition = this->CurrentPosition + 1;
			};
			return Token__2;
		};
	};
	return ZToken_NullToken_Z52;
}
static struct ZToken77 * GetToken__1qwh(struct ZTokenContext53 * this) {
	return GetToken__2qwh(this, 0/*false*/);
}
static int HasNext__1qwh(struct ZTokenContext53 * this) {
	return (GetToken__1qwh(this) != ZToken_NullToken_Z52);
}
static void SkipIndent__1qwh(struct ZTokenContext53 * this) {
	struct ZToken77 * Token__1 = GetToken__1qwh(this);
	while (IsIndent__1qey(Token__1)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		Token__1 = GetToken__1qwh(this);
	};
	return;
}
static void SkipError__2qwh(struct ZTokenContext53 * this, struct ZToken77 * ErrorToken__1) {
	long StartIndex__2 = ErrorToken__1->StartIndex;
	long EndIndex__3 = ErrorToken__1->EndIndex;
	long length__4 = GetIndentSize__1qey(ErrorToken__1);
	while (HasNext__1qwh(this)) {
		struct ZToken77 * Token__5 = GetToken__1qwh(this);
		EndIndex__3 = Token__5->EndIndex;
		this->CurrentPosition = this->CurrentPosition + 1;
		if (LibZen_Is(Token__5, 459)) {
			long ilength__6 = GetIndentSize__1qey(Token__5);
			if (ilength__6 <= length__4) {
				break;
			};
		};
	};
	if (StartIndex__2 < EndIndex__3) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("StartIdx=", LibZen_IntToString(StartIndex__2)), ", EndIndex="), LibZen_IntToString(EndIndex__3)));
		LibZen_PrintDebug__1qqy(LibZen_StrCat("skipped: \t", LibZen_SubString2(ErrorToken__1->Source->SourceText, StartIndex__2)));
	};
	return;
}
static int IsToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	struct ZToken77 * Token__2 = GetToken__1qwh(this);
	if (EqualsText__2qey(Token__2, TokenText__1)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNewLineToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	long RollbackPos__2 = this->CurrentPosition;
	SkipIndent__1qwh(this);
	struct ZToken77 * Token__3 = GetToken__1qwh(this);
	if (EqualsText__2qey(Token__3, TokenText__1)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos__2;
	return 0/*false*/;
}
static int MatchToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	long RollbackPos__2 = this->CurrentPosition;
	struct ZToken77 * Token__3 = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
	if (EqualsText__2qey(Token__3, TokenText__1)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos__2;
	return 0/*false*/;
}
static int MatchNewLineToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	long RollbackPos__2 = this->CurrentPosition;
	SkipIndent__1qwh(this);
	struct ZToken77 * Token__3 = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
	if (EqualsText__2qey(Token__3, TokenText__1)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos__2;
	return 0/*false*/;
}
static struct ZToken77 * ParseLargeToken__1qwh(struct ZTokenContext53 * this) {
	struct ZToken77 * Token__1 = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
	if (IsNextWhiteSpace__1qey(Token__1)) {
		return Token__1;
	};
	long StartIndex__2 = Token__1->StartIndex;
	long EndIndex__3 = Token__1->EndIndex;
	while (HasNext__1qwh(this) && !IsNextWhiteSpace__1qey(Token__1)) {
		long RollbackPosition__4 = this->CurrentPosition;
		Token__1 = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
		if (IsIndent__1qey(Token__1) || EqualsText__2qey(Token__1, ";") || EqualsText__2qey(Token__1, ",")) {
			this->CurrentPosition = RollbackPosition__4;
			break;
		};
		EndIndex__3 = Token__1->EndIndex;
	};
	return ZToken__4qey(_NewZToken77(), Token__1->Source, StartIndex__2, EndIndex__3);
}
static struct ZNode52 * MatchToken__4qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * TokenText__2, int IsRequired__3) {
	if (!IsErrorNode__1qwg(ParentNode__1)) {
		long RollbackPosition__4 = this->CurrentPosition;
		struct ZToken77 * Token__5 = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
		if (EqualsText__2qey(Token__5, TokenText__2)) {
			if (ParentNode__1->SourceToken == NULL) {
				ParentNode__1->SourceToken = Token__5;
			};
		} else {
			if (IsRequired__3) {
				return CreateExpectedErrorNode__3qwh(this, Token__5, TokenText__2);
			} else {
				this->CurrentPosition = RollbackPosition__4;
			};
		};
	};
	return ParentNode__1;
}
static struct ZSyntax219 * GetApplyingSyntax__1qwh(struct ZTokenContext53 * this) {
	return this->ApplyingPattern;
}
static struct ZNode52 * ApplyMatchPattern__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2, struct ZSyntax219 * Pattern__3, int IsRequired__4) {
	long RollbackPosition__5 = this->CurrentPosition;
	struct ZSyntax219 * CurrentPattern__6 = Pattern__3;
	struct ZToken77 * TopToken__7 = GetToken__1qwh(this);
	struct ZNode52 * ParsedNode__8 = NULL;
	while (CurrentPattern__6 != NULL) {
		int Remembered__9 = this->IsAllowSkipIndent;
		this->CurrentPosition = RollbackPosition__5;
		this->ApplyingPattern = CurrentPattern__6;
		ParsedNode__8 = LibZen_ApplyMatchFunc__4qqq(CurrentPattern__6->MatchFunc, ParentNode__1, this, LeftNode__2);
		LibZen_Assert(ParsedNode__8 != ParentNode__1, "(libzen/libzen.zen:3217)");
		this->ApplyingPattern = NULL;
		this->IsAllowSkipIndent = Remembered__9;
		if (ParsedNode__8 != NULL && !IsErrorNode__1qwg(ParsedNode__8)) {
			return ParsedNode__8;
		};
		CurrentPattern__6 = CurrentPattern__6->ParentPattern;
	};
	if (!IsRequired__4) {
		this->CurrentPosition = RollbackPosition__5;
		return NULL;
	};
	if (this->CurrentPosition == RollbackPosition__5) {
		LibZen_PrintLine__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("DEBUG infinite looping", LibZen_IntToString(RollbackPosition__5)), " Token="), toString__1qey(TopToken__7)), " ParsedNode="), toString__1qwg(ParsedNode__8)));
		LibZen_Assert(this->CurrentPosition != RollbackPosition__5, "(libzen/libzen.zen:3231)");
	};
	if (ParsedNode__8 == NULL) {
		ParsedNode__8 = CreateExpectedErrorNode__3qwh(this, TopToken__7, Pattern__3->PatternName);
	};
	return ParsedNode__8;
}
static struct ZNode52 * ParsePatternAfter__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2, const char * PatternName__3, int IsRequired__4) {
	struct ZSyntax219 * Pattern__5 = GetSyntaxPattern__2qwa(this->NameSpace, PatternName__3);
	struct ZNode52 * ParsedNode__6 = ApplyMatchPattern__5qwh(this, ParentNode__1, LeftNode__2, Pattern__5, IsRequired__4);
	return ParsedNode__6;
}
static struct ZNode52 * ParsePattern__4qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * PatternName__2, int IsRequired__3) {
	return ParsePatternAfter__5qwh(this, ParentNode__1, NULL, PatternName__2, IsRequired__3);
}
static struct ZNode52 * MatchPattern__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4, int AllowSkipIndent__5) {
	if (!IsErrorNode__1qwg(ParentNode__1)) {
		int Rememberd__6 = SetParseFlag__2qwh(this, AllowSkipIndent__5);
		struct ZNode52 * ParsedNode__7 = ParsePattern__4qwh(this, ParentNode__1, PatternName__3, IsRequired__4);
		(void)SetParseFlag__2qwh(this, Rememberd__6);
		if (ParsedNode__7 != NULL) {
			if (Index__2 == ZNode_NestedAppendIndex_Z24) {
				if (!(LibZen_Is(ParsedNode__7, 333))) {
					Set__3qwg(ParentNode__1, ZNode_AppendIndex_Z23, ParsedNode__7);
				};
				if (LibZen_Is(ParsedNode__7, 161) || IsErrorNode__1qwg(ParsedNode__7)) {
					return ParsedNode__7;
				};
			};
			if (IsErrorNode__1qwg(ParsedNode__7)) {
				return ParsedNode__7;
			} else {
				if (!(LibZen_Is(ParsedNode__7, 333))) {
					Set__3qwg(ParentNode__1, Index__2, ParsedNode__7);
				};
			};
		};
	};
	return ParentNode__1;
}
static struct ZNode52 * MatchPattern__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4) {
	return MatchPattern__6qwh(this, ParentNode__1, Index__2, PatternName__3, IsRequired__4, ZTokenContext_NotAllowSkipIndent_Z56);
}
static struct ZNode52 * MatchOptionaPattern__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, int AllowNewLine__3, const char * TokenText__4, const char * PatternName__5) {
	if (!IsErrorNode__1qwg(ParentNode__1)) {
		if (MatchToken__2qwh(this, TokenText__4)) {
			return MatchPattern__6qwh(this, ParentNode__1, Index__2, PatternName__5, ZTokenContext_Optional_Z54, ZTokenContext_NotAllowSkipIndent_Z56);
		};
	};
	return ParentNode__1;
}
static struct ZNode52 * MatchNtimes__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * StartToken__2, const char * PatternName__3, const char * DelimToken__4, const char * StopToken__5) {
	int Rememberd__6 = SetParseFlag__2qwh(this, 1/*true*/);
	int IsRequired__7 = ZTokenContext_Optional_Z54;
	if (StartToken__2 != NULL) {
		ParentNode__1 = MatchToken__4qwh(this, ParentNode__1, StartToken__2, ZTokenContext_Required_Z53);
	};
	while (!IsErrorNode__1qwg(ParentNode__1)) {
		if (StopToken__5 != NULL) {
			struct ZToken77 * Token__8 = GetToken__1qwh(this);
			if (EqualsText__2qey(Token__8, StopToken__5)) {
				break;
			};
			IsRequired__7 = ZTokenContext_Required_Z53;
		};
		struct ZNode52 * ParsedNode__9 = ParsePattern__4qwh(this, ParentNode__1, PatternName__3, IsRequired__7);
		if (ParsedNode__9 == NULL) {
			break;
		};
		if (IsErrorNode__1qwg(ParsedNode__9)) {
			return ParsedNode__9;
		};
		if (!(LibZen_Is(ParsedNode__9, 333))) {
			Set__3qwg(ParentNode__1, ZNode_AppendIndex_Z23, ParsedNode__9);
		};
		if (DelimToken__4 != NULL) {
			if (!MatchToken__2qwh(this, DelimToken__4)) {
				break;
			};
		};
	};
	if (StopToken__5 != NULL) {
		ParentNode__1 = MatchToken__4qwh(this, ParentNode__1, StopToken__5, ZTokenContext_Required_Z53);
	};
	(void)SetParseFlag__2qwh(this, Rememberd__6);
	return ParentNode__1;
}
static int StartsWithToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	struct ZToken77 * Token__2 = GetToken__1qwh(this);
	if (EqualsText__2qey(Token__2, TokenText__1)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		return 1/*true*/;
	};
	if (StartsWith__2qey(Token__2, TokenText__1)) {
		Token__2 = ZToken__4qey(_NewZToken77(), Token__2->Source, Token__2->StartIndex + LibZen_StringSize(TokenText__1), Token__2->EndIndex);
		this->CurrentPosition = this->CurrentPosition + 1;
		LibZen_ArrayAdd2((ArrayOfVar *)this->TokenList, this->CurrentPosition, (var)Token__2);
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void SkipEmptyStatement__1qwh(struct ZTokenContext53 * this) {
	while (HasNext__1qwh(this)) {
		struct ZToken77 * Token__1 = GetToken__1qwh(this);
		if (IsIndent__1qey(Token__1) || EqualsText__2qey(Token__1, ";")) {
			this->CurrentPosition = this->CurrentPosition + 1;
		} else {
			break;
		};
	};
	return;
}
static void Dump__1qwh(struct ZTokenContext53 * this) {
	long Position__1 = this->CurrentPosition;
	while (Position__1 < LibZen_ArraySize((ArrayOfVar *)this->TokenList)) {
		struct ZToken77 * Token__2 = Array<ZToken>GetIndex(Position__1);
		const char * DumpedToken__3 = "[";
		DumpedToken__3 = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(DumpedToken__3, LibZen_IntToString(Position__1)), "] "), toString__1qey(Token__2));
		LibZen_PrintDebug__1qqy(DumpedToken__3);
		Position__1 = Position__1 + 1;
	};
	return;
}
static struct ZTokenFunc35 * ZTokenFunc__3qq8(struct ZTokenFunc35 * this, struct ZTokenFunction216 * Func__1, struct ZTokenFunc35 * Parent__2) {
	this->Func = Func__1;
	this->ParentFunc = Parent__2;
	return NULL;
}
static struct ZVariable230 * ZVariable__7qud(struct ZVariable230 * this, struct ZSymbolEntry225 * Parent__1, struct ZFunctionNode144 * FuncNode__2, long VarFlag__3, struct ZType60 * VarType__4, const char * VarName__5, struct ZToken77 * SourceToken__6) {
	(void)ZSymbolEntry__3qup(this, Parent__1, FuncNode__2);
	this->VarFlag = VarFlag__3;
	this->VarType = VarType__4;
	this->VarName = VarName__5;
	this->SourceToken = SourceToken__6;
	this->VarUniqueIndex = GetVarIndex__1qtq(FuncNode__2);
	this->UsedCount = 0;
	this->DefCount = 1;
	return NULL;
}
static int IsCaptured__2qud(struct ZVariable230 * this, struct ZFunctionNode144 * CurrentFunctionNode__1) {
	if (CurrentFunctionNode__1 == this->Node) {
		return 0/*false*/;
	};
	return 1/*true*/;
}
static void Defined__1qud(struct ZVariable230 * this) {
	this->DefCount = this->DefCount + 1;
	return;
}
static void Used__1qud(struct ZVariable230 * this) {
	this->UsedCount = this->UsedCount + 1;
	return;
}
static struct ZArrayType299 * ZArrayType__3qo4(struct ZArrayType299 * this, long TypeFlag__1, struct ZType60 * ParamType__2) {
	(void)ZGenericType__5qe8(this, TypeFlag__1, LibZen_StrCat(toString__1qwz(ParamType__2), "[]"), ZGenericType_ArrayType_Z15, ParamType__2);
	return NULL;
}
static struct ZAnnotationNode301 * ZAnnotationNode__4qos(struct ZAnnotationNode301 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, MapOfObject * Anno__3) {
	(void)ZNode__4qwg(this, ParentNode__1, Token__2, 0);
	return NULL;
}
static int IsBreakingBlock__1qos(struct ZAnnotationNode301 * this) {
	return /*untyped*/NULL(this->AnnotatedNode);
}
static void Accept__2qos(struct ZAnnotationNode301 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(this->AnnotatedNode, Visitor__1);
	return;
}
static struct ZAssertNode307 * ZAssertNode__2qok(struct ZAssertNode307 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	return NULL;
}
static struct ZSugarNode165 * DeSugar__2qok(struct ZAssertNode307 * this, struct ZGenerator55 * Generator__1) {
	struct ZMacroFunc210 * Func__2 = GetMacroFunc__4qwk(Generator__1, "assert", ZTypeBooleanType_Z6, 2);
	if (Func__2 != NULL) {
		struct ZMacroNode391 * MacroNode__3 = ZMacroNode__4q07(_NewZMacroNode391(), this->ParentNode, this->SourceToken, Func__2);
		Append__2qu8(MacroNode__3, Array<ZNode>GetIndex(ZAssertNode_Expr_Z59));
		Append__2qu8(MacroNode__3, ZStringNode__4q42(_NewZStringNode430(), MacroNode__3, NULL, GetSourceLocation__1qwg(this)));
		return ZSugarNode__3qt9(_NewZSugarNode165(), this, MacroNode__3);
	} else {
		struct ZFuncCallNode406 * MacroNode__4 = ZFuncCallNode__4q40(_NewZFuncCallNode406(), this->ParentNode, "assert", ZTypeVarType_Z4);
		Append__2qu8(MacroNode__4, Array<ZNode>GetIndex(ZAssertNode_Expr_Z59));
		return ZSugarNode__3qt9(_NewZSugarNode165(), this, MacroNode__4);
	};
}
static struct ZBinaryNode310 * ZBinaryNode__5qo1(struct ZBinaryNode310 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZNode__4qwg(this, ParentNode__1, SourceToken__2, 2);
	Set__3qwg(this, ZBinaryNode_Left_Z60, Left__3);
	LibZen_Assert(Pattern__4 != NULL, "(libzen/libzen.zen:3433)");
	this->Pattern = Pattern__4;
	return NULL;
}
static int IsRightJoin__2qo1(struct ZBinaryNode310 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node__1, 310)) {
		return IsRightJoin__2qur(this->Pattern, ((struct ZBinaryNode310 *)Node__1)->Pattern);
	};
	return 0/*false*/;
}
static struct ZNode52 * RightJoin__3qo1(struct ZBinaryNode310 * this, struct ZNode52 * ParentNode__1, struct ZBinaryNode310 * RightNode__2) {
	struct ZNode52 * RightLeftNode__3 = Array<ZNode>GetIndex(ZBinaryNode_Left_Z60);
	if (IsRightJoin__2qo1(this, RightLeftNode__3)) {
		Set__3qwg(RightNode__2, ZBinaryNode_Left_Z60, RightJoin__3qo1(this, ParentNode__1, (struct ZBinaryNode310 *)RightLeftNode__3));
	} else {
		Set__3qwg(RightNode__2, ZBinaryNode_Left_Z60, this);
		Set__3qwg(this, ZBinaryNode_Right_Z61, RightLeftNode__3);
	};
	return RightNode__2;
}
static struct ZNode52 * AppendParsedRightNode__3qo1(struct ZBinaryNode310 * this, struct ZNode52 * ParentNode__1, struct ZTokenContext53 * TokenContext__2) {
	struct ZNode52 * RightNode__3 = ParsePattern__4qwh(TokenContext__2, ParentNode__1, "$Expression$", ZTokenContext_Required_Z53);
	if (IsErrorNode__1qwg(RightNode__3)) {
		return RightNode__3;
	};
	if (IsRightJoin__2qo1(this, RightNode__3)) {
		return RightJoin__3qo1(this, ParentNode__1, (struct ZBinaryNode310 *)RightNode__3);
	};
	Set__3qwg(this, ZBinaryNode_Right_Z61, RightNode__3);
	return this;
}
static struct ZNode52 * TryMacroNode__2qo1(struct ZBinaryNode310 * this, struct ZGenerator55 * Generator__1) {
	if (!/*untyped*/NULL(GetAstType__2qwg(this, ZBinaryNode_Left_Z60)) && !/*untyped*/NULL(GetAstType__2qwg(this, ZBinaryNode_Right_Z61))) {
		const char * Op__2 = GetText__1qey(this->SourceToken);
		struct ZFunc89 * Func__3 = GetDefinedFunc__4qwk(Generator__1, Op__2, GetAstType__2qwg(this, ZBinaryNode_Left_Z60), 2);
		if (LibZen_Is(Func__3, 210)) {
			struct ZMacroNode391 * MacroNode__4 = ZMacroNode__4q07(_NewZMacroNode391(), this->ParentNode, this->SourceToken, (struct ZMacroFunc210 *)Func__3);
			Append__2qu8(MacroNode__4, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
			Append__2qu8(MacroNode__4, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
			return MacroNode__4;
		};
	};
	return this;
}
static void Accept__2qo1(struct ZBinaryNode310 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZBreakNode317 * ZBreakNode__2qon(struct ZBreakNode317 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 0);
	return NULL;
}
static void Accept__2qon(struct ZBreakNode317 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZCastNode320 * ZCastNode__4qo5(struct ZCastNode320 * this, struct ZNode52 * ParentNode__1, struct ZType60 * CastType__2, struct ZNode52 * Node__3) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	this->Type = CastType__2;
	if (Node__3 != NULL) {
		Set__3qwg(this, ZCastNode_Expr_Z62, Node__3);
	};
	return NULL;
}
static void Accept__2qo5(struct ZCastNode320 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZListNode251 * ToFuncCallNode__2qo5(struct ZCastNode320 * this, struct ZFunc89 * Func__1) {
	if (LibZen_Is(Func__1, 210)) {
		struct ZMacroNode391 * FuncNode__2 = ZMacroNode__4q07(_NewZMacroNode391(), this->ParentNode, this->SourceToken, (struct ZMacroFunc210 *)Func__1);
		Append__2qu8(FuncNode__2, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
		return FuncNode__2;
	} else {
		struct ZFuncCallNode406 * FuncNode__3 = ZFuncCallNode__4q40(_NewZFuncCallNode406(), this->ParentNode, Func__1->FuncName, GetFuncType__1qeh(Func__1));
		FuncNode__3->SourceToken = this->SourceToken;
		Append__2qu8(FuncNode__3, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
		return FuncNode__3;
	};
}
static struct ZCatchNode324 * ZCatchNode__2qpq(struct ZCatchNode324 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qpq(struct ZCatchNode324 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->ExceptionType = Type__2;
	return;
}
static void SetNameInfo__3qpq(struct ZCatchNode324 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->ExceptionName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static struct ZComparatorNode328 * ZComparatorNode__5qpt(struct ZComparatorNode328 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZBinaryNode__5qo1(this, ParentNode__1, SourceToken__2, Left__3, Pattern__4);
	return NULL;
}
static void Accept__2qpt(struct ZComparatorNode328 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZConstNode331 * ZConstNode__3qpi(struct ZConstNode331 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2) {
	(void)ZNode__4qwg(this, ParentNode__1, SourceToken__2, 0);
	return NULL;
}
static struct ZEmptyNode333 * ZEmptyNode__3qpp(struct ZEmptyNode333 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2) {
	(void)ZNode__4qwg(this, ParentNode__1, Token__2, 0);
	return NULL;
}
static struct ZErrorNode335 * ZErrorNode__4qp4(struct ZErrorNode335 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, const char * ErrorMessage__3) {
	(void)ZConstNode__3qpi(this, ParentNode__1, SourceToken__2);
	this->ErrorMessage = ErrorMessage__3;
	return NULL;
}
static struct ZErrorNode335 * ZErrorNode__3qp4(struct ZErrorNode335 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2) {
	(void)ZConstNode__3qpi(this, Node__1->ParentNode, Node__1->SourceToken);
	this->ErrorMessage = ErrorMessage__2;
	return NULL;
}
static void Accept__2qp4(struct ZErrorNode335 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZFieldNode339 * ZFieldNode__2qpf(struct ZFieldNode339 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qpf(struct ZFieldNode339 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->DeclType = Type__2;
	return;
}
static void SetNameInfo__3qpf(struct ZFieldNode339 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FieldName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static struct ZFloatNode343 * ZFloatNode__4qpk(struct ZFloatNode343 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, double Value__3) {
	(void)ZConstNode__3qpi(this, ParentNode__1, Token__2);
	this->Type = ZTypeFloatType_Z8;
	this->FloatValue = Value__3;
	return NULL;
}
static void Accept__2qpk(struct ZFloatNode343 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZGetIndexNode346 * ZGetIndexNode__3qp1(struct ZGetIndexNode346 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 2);
	Array<ZNode>SetIndex(ZGetIndexNode_Recv_Z65, SetChild__2qwg(this, RecvNode__2));
	return NULL;
}
static void Accept__2qp1(struct ZGetIndexNode346 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZGetNameNode349 * ZGetNameNode__4qpx(struct ZGetNameNode349 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * NativeName__3) {
	(void)ZNode__4qwg(this, ParentNode__1, Token__2, 0);
	this->VarName = NativeName__3;
	return NULL;
}
static struct ZGetNameNode349 * ZGetNameNode__3qpx(struct ZGetNameNode349 * this, struct ZNode52 * ParentNode__1, struct ZFunc89 * ResolvedFunc__2) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 0);
	this->VarName = ResolvedFunc__2->FuncName;
	this->Type = GetFuncType__1qeh(ResolvedFunc__2);
	return NULL;
}
static void Accept__2qpx(struct ZGetNameNode349 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZNode52 * ToGlobalNameNode__1qpx(struct ZGetNameNode349 * this) {
	return ZGlobalNameNode__6qp8(_NewZGlobalNameNode359(), this->ParentNode, this->SourceToken, this->Type, this->VarName, 0/*false*/);
}
static struct ZGetterNode354 * ZGetterNode__3qpm(struct ZGetterNode354 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	Set__3qwg(this, ZGetterNode_Recv_Z67, RecvNode__2);
	return NULL;
}
static void SetNameInfo__3qpm(struct ZGetterNode354 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FieldName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static void Accept__2qpm(struct ZGetterNode354 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static int IsStaticField__1qpm(struct ZGetterNode354 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZGetterNode_Recv_Z67), 235);
}
static struct ZGlobalNameNode359 * ZGlobalNameNode__6qp8(struct ZGlobalNameNode359 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5) {
	(void)ZNode__4qwg(this, ParentNode__1, SourceToken__2, 0);
	this->GlobalName = GlobalName__4;
	this->Type = Type__3;
	this->IsStaticFuncName = IsStaticFuncName__5;
	return NULL;
}
static int IsGivenName__1qp8(struct ZGlobalNameNode359 * this) {
	return (!this->IsStaticFuncName);
}
static void Accept__2qp8(struct ZGlobalNameNode359 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZGroupNode363 * ZGroupNode__2q0r(struct ZGroupNode363 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	return NULL;
}
static void Accept__2q0r(struct ZGroupNode363 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZIfNode366 * ZIfNode__2q0u(struct ZIfNode366 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 3);
	return NULL;
}
static void Accept__2q0u(struct ZIfNode366 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZImportNode369 * ZImportNode__2q0p(struct ZImportNode369 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 0);
	return NULL;
}
static void SetNameInfo__3q0p(struct ZImportNode369 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	if (this->ResourcePath == NULL) {
		this->ResourcePath = Name__2;
		this->ResourceToken = NameToken__1;
	} else {
		this->Alias = Name__2;
	};
	return;
}
static struct ZInstanceOfNode372 * ZInstanceOfNode__4q0a(struct ZInstanceOfNode372 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * LeftNode__3) {
	(void)ZNode__4qwg(this, ParentNode__1, Token__2, 1);
	Set__3qwg(this, ZInstanceOfNode_Left_Z72, LeftNode__3);
	return NULL;
}
static void SetTypeInfo__3q0a(struct ZInstanceOfNode372 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->TargetType = Type__2;
	return;
}
static void Accept__2q0a(struct ZInstanceOfNode372 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZIntNode376 * ZIntNode__4q0g(struct ZIntNode376 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, long Value__3) {
	(void)ZConstNode__3qpi(this, ParentNode__1, Token__2);
	this->Type = ZTypeIntType_Z7;
	this->IntValue = Value__3;
	return NULL;
}
static void Accept__2q0g(struct ZIntNode376 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZLetNode379 * ZLetNode__2q0k(struct ZLetNode379 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 1);
	return NULL;
}
static void SetNameInfo__3q0k(struct ZLetNode379 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->Symbol = Name__2;
	this->SymbolToken = NameToken__1;
	return;
}
static void SetTypeInfo__3q0k(struct ZLetNode379 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->SymbolType = Type__2;
	return;
}
static void Accept__2q0k(struct ZLetNode379 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZGlobalNameNode359 * ToGlobalNameNode__1q0k(struct ZLetNode379 * this) {
	return ZGlobalNameNode__6qp8(_NewZGlobalNameNode359(), NULL, this->SymbolToken, GetAstType__2qwg(this, ZLetNode_InitValue_Z73), this->GlobalName, 0/*false*/);
}
static struct ZListNode251 * ZListNode__4qu8(struct ZListNode251 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, long Size__3) {
	(void)ZNode__4qwg(this, ParentNode__1, SourceToken__2, Size__3);
	this->ListStartIndex = Size__3;
	return NULL;
}
static void Append__2qu8(struct ZListNode251 * this, struct ZNode52 * Node__1) {
	if (this->AST == NULL) {
		this->AST = LibZen_NewNodeArray__1qqr(1);
		Set__3qwg(this, 0, Node__1);
	} else {
		ArrayOfZNode * newAST__2 = LibZen_NewNodeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)this->AST) + 1);
		LibZen_ArrayCopy__5qqq(this->AST, 0, newAST__2, 0, LibZen_ArraySize((ArrayOfVar *)this->AST));
		this->AST = newAST__2;
		Set__3qwg(this, LibZen_ArraySize((ArrayOfVar *)this->AST) - 1, Node__1);
	};
	return;
}
static long GetListSize__1qu8(struct ZListNode251 * this) {
	return GetAstSize__1qwg(this) - this->ListStartIndex;
}
static struct ZNode52 * GetListAt__2qu8(struct ZListNode251 * this, long Index__1) {
	return Array<ZNode>GetIndex(this->ListStartIndex + Index__1);
}
static void SetListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2) {
	Set__3qwg(this, Index__1 + this->ListStartIndex, Node__2);
	return;
}
static void InsertListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2) {
	if (this->AST == NULL || Index__1 < 0 || LibZen_ArraySize((ArrayOfVar *)this->AST) == Index__1) {
		Append__2qu8(this, Node__2);
	} else {
		ArrayOfZNode * newAST__3 = LibZen_NewNodeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)this->AST) + 1);
		Index__1 = this->ListStartIndex + Index__1;
		LibZen_ArrayCopy__5qqq(this->AST, 0, newAST__3, 0, Index__1);
		Set__3qwg(this, Index__1, Node__2);
		LibZen_ArrayCopy__5qqq(this->AST, Index__1, newAST__3, Index__1 + 1, LibZen_ArraySize((ArrayOfVar *)this->AST) - Index__1);
		this->AST = newAST__3;
	};
	return;
}
static struct ZNode52 * RemoveListAt__2qu8(struct ZListNode251 * this, long Index__1) {
	struct ZNode52 * Removed__2 = GetListAt__2qu8(this, Index__1);
	ArrayOfZNode * newAST__3 = LibZen_NewNodeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)this->AST) - 1);
	long RemovedIndex__4 = this->ListStartIndex + Index__1;
	LibZen_ArrayCopy__5qqq(this->AST, 0, newAST__3, 0, RemovedIndex__4);
	LibZen_ArrayCopy__5qqq(this->AST, RemovedIndex__4 + 1, newAST__3, RemovedIndex__4, LibZen_ArraySize((ArrayOfVar *)this->AST) - (RemovedIndex__4 + 1));
	this->AST = newAST__3;
	return Removed__2;
}
static void ClearListAfter__2qu8(struct ZListNode251 * this, long Size__1) {
	if (Size__1 < GetListSize__1qu8(this)) {
		long newsize__2 = this->ListStartIndex + Size__1;
		if (newsize__2 == 0) {
			this->AST = NULL;
		} else {
			ArrayOfZNode * newAST__3 = LibZen_NewNodeArray__1qqr(newsize__2);
			LibZen_ArrayCopy__5qqq(this->AST, 0, newAST__3, 0, newsize__2);
			this->AST = newAST__3;
		};
	};
	return;
}
static struct ZMacroNode391 * ZMacroNode__4q07(struct ZMacroNode391 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZMacroFunc210 * MacroFunc__3) {
	(void)ZListNode__4qu8(this, ParentNode__1, SourceToken__2, 0);
	this->MacroFunc = MacroFunc__3;
	LibZen_Assert(MacroFunc__3 != NULL, "(libzen/libzen.zen:3791)");
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1q07(struct ZMacroNode391 * this) {
	return GetFuncType__1qeh(this->MacroFunc);
}
static const char * GetMacroText__1q07(struct ZMacroNode391 * this) {
	struct ZMacroFunc210 * Func__1 = this->MacroFunc;
	if (LibZen_Is(Func__1, 265)) {
		return ((struct ZSourceMacro265 *)Func__1)->Macro;
	};
	return "";
}
static void Accept__2q07(struct ZMacroNode391 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZMapEntryNode396 * ZMapEntryNode__2q4q(struct ZMapEntryNode396 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode__1, NULL, 2);
	return NULL;
}
static struct ZMapLiteralNode398 * ZMapLiteralNode__2q4e(struct ZMapLiteralNode398 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 0);
	return NULL;
}
static struct ZMapEntryNode396 * GetMapEntryNode__2q4e(struct ZMapLiteralNode398 * this, long Index__1) {
	struct ZNode52 * Node__2 = GetListAt__2qu8(this, Index__1);
	if (LibZen_Is(Node__2, 396)) {
		return (struct ZMapEntryNode396 *)Node__2;
	};
	return NULL;
}
static void Accept__2q4e(struct ZMapLiteralNode398 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZMethodCallNode402 * ZMethodCallNode__3q4u(struct ZMethodCallNode402 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 1);
	Set__3qwg(this, ZMethodCallNode_Recv_Z76, RecvNode__2);
	return NULL;
}
static void SetNameInfo__3q4u(struct ZMethodCallNode402 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->MethodName = Name__2;
	this->MethodToken = NameToken__1;
	return;
}
static void Accept__2q4u(struct ZMethodCallNode402 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZFuncCallNode406 * ToGetterFuncCall__1q4u(struct ZMethodCallNode402 * this) {
	struct ZGetterNode354 * Getter__4 = ZGetterNode__3qpm(_NewZGetterNode354(), NULL, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
	Getter__1->SetNameInfo(Getter__1, this->MethodToken, this->MethodName);
	struct ZFuncCallNode406 * FuncNode__2 = ZFuncCallNode__3q40(_NewZFuncCallNode406(), this->ParentNode, Getter__1);
	FuncNode__2->SourceToken = this->SourceToken;
	Append__2qu8(FuncNode__2, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
	long i__3 = 0;
	while (i__3 < GetListSize__1qu8(this)) {
		Append__2qu8(FuncNode__2, GetListAt__2qu8(this, i__3));
		i__3 = i__3 + 1;
	};
	return FuncNode__2;
}
static struct ZListNode251 * ToFuncCallNode__2q4u(struct ZMethodCallNode402 * this, struct ZFunc89 * Func__1) {
	if (LibZen_Is(Func__1, 210)) {
		struct ZMacroNode391 * MacroNode__2 = ZMacroNode__4q07(_NewZMacroNode391(), this->ParentNode, this->MethodToken, (struct ZMacroFunc210 *)Func__1);
		Append__2qu8(MacroNode__2, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
		long i__3 = 0;
		while (i__3 < GetListSize__1qu8(this)) {
			Append__2qu8(MacroNode__2, GetListAt__2qu8(this, i__3));
			i__3 = i__3 + 1;
		};
		return MacroNode__2;
	} else {
		struct ZFuncCallNode406 * FuncNode__4 = ZFuncCallNode__4q40(_NewZFuncCallNode406(), this->ParentNode, Func__1->FuncName, GetFuncType__1qeh(Func__1));
		FuncNode__4->SourceToken = this->MethodToken;
		Append__2qu8(FuncNode__4, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
		long i__5 = 0;
		while (i__5 < GetListSize__1qu8(this)) {
			Append__2qu8(FuncNode__4, GetListAt__2qu8(this, i__5));
			i__5 = i__5 + 1;
		};
		return FuncNode__4;
	};
}
static struct ZNewArrayNode409 * ZNewArrayNode__4q4s(struct ZNewArrayNode409 * this, struct ZNode52 * ParentNode__1, struct ZType60 * Type__2, struct ZToken77 * Token__3) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 0);
	return NULL;
}
static struct ZNewObjectNode411 * ZNewObjectNode__2q4f(struct ZNewObjectNode411 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 0);
	return NULL;
}
static void Accept__2q4f(struct ZNewObjectNode411 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZListNode251 * ToFuncCallNode__2q4f(struct ZNewObjectNode411 * this, struct ZFunc89 * Func__1) {
	struct ZListNode251 * FuncNode__2 = NULL;
	if (LibZen_Is(Func__1, 210)) {
		FuncNode__2 = ZMacroNode__4q07(_NewZMacroNode391(), this->ParentNode, this->SourceToken, (struct ZMacroFunc210 *)Func__1);
	} else {
		FuncNode__2 = ZFuncCallNode__4q40(_NewZFuncCallNode406(), this->ParentNode, Func__1->FuncName, GetFuncType__1qeh(Func__1));
		FuncNode__2->SourceToken = this->SourceToken;
	};
	Append__2qu8(FuncNode__2, this);
	long i__3 = 0;
	while (i__3 < GetListSize__1qu8(this)) {
		Append__2qu8(FuncNode__2, GetListAt__2qu8(this, i__3));
		i__3 = i__3 + 1;
	};
	ClearListAfter__2qu8(this, 0);
	return FuncNode__2;
}
static struct ZNotNode415 * ZNotNode__3q4k(struct ZNotNode415 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2) {
	(void)ZUnaryNode__3qyh(this, ParentNode__1, Token__2);
	return NULL;
}
static void Accept__2q4k(struct ZNotNode415 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZNullNode418 * ZNullNode__3q41(struct ZNullNode418 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2) {
	(void)ZConstNode__3qpi(this, ParentNode__1, SourceToken__2);
	return NULL;
}
static void Accept__2q41(struct ZNullNode418 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZOrNode421 * ZOrNode__5q4x(struct ZOrNode421 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZBinaryNode__5qo1(this, ParentNode__1, Token__2, Left__3, Pattern__4);
	return NULL;
}
static void Accept__2q4x(struct ZOrNode421 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZPrototypeNode424 * ZPrototypeNode__2q4b(struct ZPrototypeNode424 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 0);
	return NULL;
}
static void SetTypeInfo__3q4b(struct ZPrototypeNode424 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->ReturnType = Type__2;
	return;
}
static void SetNameInfo__3q4b(struct ZPrototypeNode424 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FuncName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static struct ZParamNode172 * GetParamNode__2q4b(struct ZPrototypeNode424 * this, long Index__1) {
	struct ZNode52 * Node__2 = GetListAt__2qu8(this, Index__1);
	if (LibZen_Is(Node__2, 172)) {
		return (struct ZParamNode172 *)Node__2;
	};
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1q4b(struct ZPrototypeNode424 * this) {
	ArrayOfZType * TypeList__5 = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList__1, (var)this->ReturnType->GetRealType(this->ReturnType));
	long i__6 = 0;
	while (i__2 < GetListSize__1qu8(this)) {
		struct ZParamNode172 * Node__7 = GetParamNode__2q4b(this, i__2);
		struct ZType60 * ParamType__8 = Node__3->Type->GetRealType(Node__3->Type);
		LibZen_ArrayAdd((ArrayOfVar *)TypeList__1, (var)ParamType__4);
		i__2 = i__2 + 1;
	};
	return ZTypePool_LookupFuncType__1qwx(TypeList__1);
}
static struct ZStringNode430 * ZStringNode__4q42(struct ZStringNode430 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * Value__3) {
	(void)ZConstNode__3qpi(this, ParentNode__1, Token__2);
	this->Type = ZTypeStringType_Z9;
	this->StringValue = Value__3;
	return NULL;
}
static void Accept__2q42(struct ZStringNode430 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZStupidCastErrorNode433 * ZStupidCastErrorNode__3qaw(struct ZStupidCastErrorNode433 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2) {
	(void)ZErrorNode__3qp4(this, Node__1, ErrorMessage__2);
	this->ErrorNode = Node__1;
	return NULL;
}
static struct ZTypeNode235 * ZTypeNode__4quk(struct ZTypeNode235 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * ParsedType__3) {
	(void)ZConstNode__3qpi(this, ParentNode__1, SourceToken__2);
	this->Type = ParsedType__3;
	return NULL;
}
static struct ZGenerator55 * ZGenerator__3qwk(struct ZGenerator55 * this, const char * LanguageExtension__1, const char * TargetVersion__2) {
	this->RootNameSpace = ZNameSpace__3qwa(_NewZNameSpace48(), this, NULL);
	this->GrammarInfo = "";
	this->LanguageExtention = LanguageExtension__1;
	this->TargetVersion = TargetVersion__2;
	this->OutputFile = NULL;
	this->Logger = _NewZLogger135();
	this->StoppedVisitor = 0/*false*/;
	return NULL;
}
static void ImportLocalGrammar__2qwk(struct ZGenerator55 * this, struct ZNameSpace48 * NameSpace__1) {
	return;
}
static void WriteTo__2qwk(struct ZGenerator55 * this, const char * FileName__1) {
	return;
}
static const char * GetSourceText__1qwk(struct ZGenerator55 * this) {
	return NULL;
}
static const char * NameOutputFile__2qwk(struct ZGenerator55 * this, const char * FileName__1) {
	if (FileName__1 != NULL) {
		return LibZen_StrCat(LibZen_StrCat(FileName__1, "."), this->LanguageExtention);
	};
	return FileName__1;
}
static void EnableVisitor__1qwk(struct ZGenerator55 * this) {
	this->StoppedVisitor = 0/*false*/;
	return;
}
static void StopVisitor__1qwk(struct ZGenerator55 * this) {
	this->StoppedVisitor = 1/*true*/;
	return;
}
static int IsVisitable__1qwk(struct ZGenerator55 * this) {
	return !this->StoppedVisitor;
}
static const char * GetGrammarInfo__1qwk(struct ZGenerator55 * this) {
	return this->GrammarInfo;
}
static void AppendGrammarInfo__2qwk(struct ZGenerator55 * this, const char * GrammarInfo__1) {
	this->GrammarInfo = LibZen_StrCat(LibZen_StrCat(this->GrammarInfo, GrammarInfo__1), " ");
	return;
}
static const char * GetTargetLangInfo__1qwk(struct ZGenerator55 * this) {
	return LibZen_StrCat(this->LanguageExtention, this->TargetVersion);
}
static struct ZType60 * GetFieldType__3qwk(struct ZGenerator55 * this, struct ZType60 * BaseType__1, const char * Name__2) {
	return ZTypeVarType_Z4;
}
static struct ZType60 * GetSetterType__3qwk(struct ZGenerator55 * this, struct ZType60 * BaseType__1, const char * Name__2) {
	return ZTypeVarType_Z4;
}
static struct ZFuncType90 * GetConstructorFuncType__3qwk(struct ZGenerator55 * this, struct ZType60 * ClassType__1, struct ZListNode251 * List__2) {
	return ZFuncType_FuncType_Z14;
}
static struct ZFuncType90 * GetMethodFuncType__4qwk(struct ZGenerator55 * this, struct ZType60 * RecvType__1, const char * MethodName__2, struct ZListNode251 * List__3) {
	return ZFuncType_FuncType_Z14;
}
static long GetUniqueNumber__1qwk(struct ZGenerator55 * this) {
	long UniqueNumber__1 = this->UniqueNumber;
	this->UniqueNumber = this->UniqueNumber + 1;
	return UniqueNumber__1;
}
static const char * NameGlobalSymbol__2qwk(struct ZGenerator55 * this, const char * Symbol__1) {
	return LibZen_StrCat(LibZen_StrCat(Symbol__1, "_Z"), LibZen_IntToString(GetUniqueNumber__1qwk(this)));
}
static const char * NameClass__2qwk(struct ZGenerator55 * this, struct ZType60 * ClassType__1) {
	return LibZen_StrCat(LibZen_StrCat(ClassType__1->ShortName, ""), LibZen_IntToString(ClassType__1->TypeId));
}
static void SetDefinedFunc__2qwk(struct ZGenerator55 * this, struct ZFunc89 * Func__1) {
	Map<ZFunc>SetIndex(GetSignature__1qeh(Func__1), Func__1);
	return;
}
static struct ZPrototype121 * SetPrototype__4qwk(struct ZGenerator55 * this, struct ZNode52 * Node__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3) {
	struct ZFunc89 * Func__4 = GetDefinedFunc__3qwk(this, FuncName__2, FuncType__3);
	if (Func__4 != NULL) {
		if (!Equals__2qwz(FuncType__3, GetFuncType__1qeh(Func__4))) {
			(void)ZLogger_LogError__2qey(Node__1->SourceToken, LibZen_StrCat("function has been defined diffrently: ", toString__1qwz(GetFuncType__1qeh(Func__4))));
			return NULL;
		};
		if (LibZen_Is(Func__4, 121)) {
			return (struct ZPrototype121 *)Func__4;
		};
		(void)ZLogger_LogError__2qey(Node__1->SourceToken, LibZen_StrCat("function has been defined as macro", toString__1qeh(Func__4)));
		return NULL;
	};
	struct ZPrototype121 * Proto__5 = ZPrototype__5qrs(_NewZPrototype121(), 0, FuncName__2, FuncType__3, Node__1->SourceToken);
	Map<ZFunc>SetIndex(GetSignature__1qeh(Proto__5), Proto__5);
	return Proto__5;
}
static struct ZFunc89 * GetDefinedFunc__2qwk(struct ZGenerator55 * this, const char * GlobalName__1) {
	struct ZFunc89 * Func__2 = Map<ZFunc>GetIndex(GlobalName__1);
	if (Func__2 == NULL && LibZen_IsLetter__1qqy(LibZen_GetChar__2qqy(GlobalName__1, 0))) {
		Func__2 = Map<ZFunc>GetIndex(LibZen_AnotherName__1qqy(GlobalName__1));
	};
	return Func__2;
}
static struct ZFunc89 * GetDefinedFunc__3qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2) {
	return GetDefinedFunc__2qwk(this, StringfySignature__2qej(FuncType__2, FuncName__1));
}
static struct ZFunc89 * GetDefinedFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3) {
	return GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
}
static struct ZFunc89 * LookupFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3) {
	struct ZFunc89 * Func__5 = GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
	while (Func__4 == NULL) {
		RecvType__2 = RecvType__2->GetSuperType(RecvType__2);
		if (RecvType__2 == NULL) {
			break;
		};
		Func__4 = GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
	};
	return Func__4;
}
static struct ZMacroFunc210 * GetMacroFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3) {
	struct ZFunc89 * Func__4 = GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
	if (LibZen_Is(Func__4, 210)) {
		return ((struct ZMacroFunc210 *)Func__4);
	};
	return NULL;
}
static const char * NameConverterFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2) {
	return LibZen_StrCat(LibZen_StrCat(GetUniqueName__1qwz(FromType__1), "T"), GetUniqueName__1qwz(ToType__2));
}
static void SetConverterFunc__4qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2, struct ZFunc89 * Func__3) {
	Map<ZFunc>SetIndex(NameConverterFunc__3qwk(this, FromType__1, ToType__2), Func__3);
	return;
}
static struct ZFunc89 * LookupConverterFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2) {
	while (FromType__1 != NULL) {
		struct ZFunc89 * Func__3 = Map<ZFunc>GetIndex(NameConverterFunc__3qwk(this, FromType__1, ToType__2));
		if (Func__3 != NULL) {
			return Func__3;
		};
		FromType__1 = /*untyped*/NULL(FromType__1);
	};
	return NULL;
}
static struct ZFunc89 * GetCoercionFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2) {
	while (FromType__1 != NULL) {
		struct ZFunc89 * Func__3 = Map<ZFunc>GetIndex(NameConverterFunc__3qwk(this, FromType__1, ToType__2));
		if (Func__3 != NULL && IsCoercionFunc__1qeh(Func__3)) {
			return Func__3;
		};
		FromType__1 = /*untyped*/NULL(FromType__1);
	};
	return NULL;
}
static void VisitExtendedNode__2qwk(struct ZGenerator55 * this, struct ZNode52 * Node__1) {
	struct ZSugarNode165 * DeNode__2 = /*untyped*/NULL(Node__1, this);
	/*untyped*/NULL(DeNode__2, this);
	return;
}
static void VisitSugarNode__2qwk(struct ZGenerator55 * this, struct ZSugarNode165 * Node__1) {
	/*untyped*/NULL(Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z32), this);
	return;
}
static struct ZIndentToken459 * ZIndentToken__4qav(struct ZIndentToken459 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3) {
	(void)ZToken__4qey(this, Source__1, StartIndex__2, EndIndex__3);
	return NULL;
}
static struct ZPatternToken461 * ZPatternToken__5qan(struct ZPatternToken461 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax219 * PresetPattern__4) {
	(void)ZToken__4qey(this, Source__1, StartIndex__2, EndIndex__3);
	this->PresetPattern = PresetPattern__4;
	return NULL;
}
static struct ZSourceEngine57 * ZSourceEngine__3qw9(struct ZSourceEngine57 * this, struct ZTypeChecker142 * TypeChecker__1, struct ZGenerator55 * Generator__2) {
	this->TypeChecker = TypeChecker__1;
	this->Generator = Generator__2;
	this->Logger = Generator__2->Logger;
	return NULL;
}
static int IsVisitable__1qw9(struct ZSourceEngine57 * this) {
	return this->IsVisitableFlag;
}
static void EnableVisitor__1qw9(struct ZSourceEngine57 * this) {
	this->IsVisitableFlag = 1/*true*/;
	return;
}
static void StopVisitor__1qw9(struct ZSourceEngine57 * this) {
	this->IsVisitableFlag = 0/*false*/;
	return;
}
static void Eval2__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1) {
	if (/*untyped*/NULL(this)) {
		/*untyped*/NULL(Node__1, this);
	};
	return;
}
static void VisitPrototypeNode__2qw9(struct ZSourceEngine57 * this, struct ZPrototypeNode424 * Node__1) {
	struct ZFuncType90 * FuncType__2 = GetFuncType__1q4b(Node__1);
	(void)SetPrototype__4qwk(this->Generator, Node__1, Node__1->FuncName, FuncType__2);
	return;
}
static void VisitImportNode__2qw9(struct ZSourceEngine57 * this, struct ZImportNode369 * Node__1) {
	(void)/*untyped*/NULL(Node__1);
	return;
}
static void Exec2__3qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1, int IsInteractive__2) {
	this->InteractiveContext = IsInteractive__2;
	/*untyped*/NULL(this);
	if (LibZen_Is(Node__1, 424)) {
		VisitPrototypeNode__2qw9(this, (struct ZPrototypeNode424 *)Node__1);
	} else if (LibZen_Is(Node__1, 369)) {
		VisitImportNode__2qw9(this, (struct ZImportNode369 *)Node__1);
	} else {
		Node__1 = CheckType__3qr2(this->TypeChecker, Node__1, ZTypeVoidType_Z5);
		Eval2__2qw9(this, Node__1);
	};
	return;
}
static const char * Translate__4qw9(struct ZSourceEngine57 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3) {
	struct ZBlockNode161 * TopBlockNode__4 = ZBlockNode__2qth(_NewZBlockNode161(), this->Generator->RootNameSpace);
	struct ZTokenContext53 * TokenContext__5 = ZTokenContext__6qwh(_NewZTokenContext53(), this->Generator, this->Generator->RootNameSpace, FileName__2, LineNumber__3, ScriptText__1);
	SkipEmptyStatement__1qwh(TokenContext__5);
	struct ZToken77 * SkipToken__6 = GetToken__1qwh(TokenContext__5);
	while (HasNext__1qwh(TokenContext__5)) {
		(void)SetParseFlag__2qwh(TokenContext__5, ZTokenContext_NotAllowSkipIndent_Z56);
		ClearListAfter__2qu8(TopBlockNode__4, 0);
		SkipToken__6 = GetToken__1qwh(TokenContext__5);
		struct ZNode52 * ParsedNode__7 = ParsePattern__4qwh(TokenContext__5, TopBlockNode__4, "$Statement$", ZTokenContext_Required_Z53);
		if (IsErrorNode__1qwg(ParsedNode__7)) {
			SkipError__2qwh(TokenContext__5, SkipToken__6);
		};
		Exec2__3qw9(this, ParsedNode__7, 0/*false*/);
		SkipEmptyStatement__1qwh(TokenContext__5);
		Vacume__1qwh(TokenContext__5);
	};
	return /*untyped*/NULL(this->Generator);
}
static void Unsupported__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1) {
	if (this->InteractiveContext) {
		(void)this->Generator->StartCodeGeneration(this->Generator, Node__1, this->InteractiveContext);
	} else {
		(void)ZLogger_LogError__2qey(Node__1->SourceToken, "unsupported at top level");
		this->StopVisitor(this);
	};
	return;
}
static void VisitNullNode__2qw9(struct ZSourceEngine57 * this, struct ZNullNode418 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitBooleanNode__2qw9(struct ZSourceEngine57 * this, struct ZBooleanNode472 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitIntNode__2qw9(struct ZSourceEngine57 * this, struct ZIntNode376 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitFloatNode__2qw9(struct ZSourceEngine57 * this, struct ZFloatNode343 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitStringNode__2qw9(struct ZSourceEngine57 * this, struct ZStringNode430 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitArrayLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZArrayLiteralNode477 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitMapLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZMapLiteralNode398 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitNewObjectNode__2qw9(struct ZSourceEngine57 * this, struct ZNewObjectNode411 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitGlobalNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGlobalNameNode359 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitGetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGetNameNode349 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitSetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZSetNameNode181 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitGroupNode__2qw9(struct ZSourceEngine57 * this, struct ZGroupNode363 * Node__1) {
	Eval2__2qw9(this, Array<ZNode>GetIndex(ZGroupNode_Expr_Z68));
	return;
}
static void VisitGetterNode__2qw9(struct ZSourceEngine57 * this, struct ZGetterNode354 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitSetterNode__2qw9(struct ZSourceEngine57 * this, struct ZSetterNode184 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitGetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZGetIndexNode346 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitSetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZSetIndexNode178 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitMacroNode__2qw9(struct ZSourceEngine57 * this, struct ZMacroNode391 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitFuncCallNode__2qw9(struct ZSourceEngine57 * this, struct ZFuncCallNode406 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitMethodCallNode__2qw9(struct ZSourceEngine57 * this, struct ZMethodCallNode402 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitUnaryNode__2qw9(struct ZSourceEngine57 * this, struct ZUnaryNode197 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitNotNode__2qw9(struct ZSourceEngine57 * this, struct ZNotNode415 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitCastNode__2qw9(struct ZSourceEngine57 * this, struct ZCastNode320 * Node__1) {
	if (IsVoidType__1qwz(Node__1->Type)) {
		Eval2__2qw9(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
		Node__1->Type = Array<ZNode>GetIndex(ZCastNode_Expr_Z62)->Type;
	} else {
		Unsupported__2qw9(this, Node__1);
	};
	return;
}
static void VisitInstanceOfNode__2qw9(struct ZSourceEngine57 * this, struct ZInstanceOfNode372 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitBinaryNode__2qw9(struct ZSourceEngine57 * this, struct ZBinaryNode310 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitComparatorNode__2qw9(struct ZSourceEngine57 * this, struct ZComparatorNode328 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitAndNode__2qw9(struct ZSourceEngine57 * this, struct ZAndNode498 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitOrNode__2qw9(struct ZSourceEngine57 * this, struct ZOrNode421 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitBlockNode__2qw9(struct ZSourceEngine57 * this, struct ZBlockNode161 * Node__1) {
	long i__2 = 1;
	while (i__2 < GetListSize__1qu8(Node__1) && /*untyped*/NULL(this)) {
		struct ZNode52 * StmtNode__3 = GetListAt__2qu8(Node__1, i__2);
		Eval2__2qw9(this, StmtNode__3);
		if (/*untyped*/NULL(StmtNode__3)) {
			break;
		};
	};
	return;
}
static void VisitVarNode__2qw9(struct ZSourceEngine57 * this, struct ZVarNode502 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitIfNode__2qw9(struct ZSourceEngine57 * this, struct ZIfNode366 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitReturnNode__2qw9(struct ZSourceEngine57 * this, struct ZReturnNode170 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitWhileNode__2qw9(struct ZSourceEngine57 * this, struct ZWhileNode200 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitBreakNode__2qw9(struct ZSourceEngine57 * this, struct ZBreakNode317 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitThrowNode__2qw9(struct ZSourceEngine57 * this, struct ZThrowNode191 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitTryNode__2qw9(struct ZSourceEngine57 * this, struct ZTryNode194 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitLetNode__2qw9(struct ZSourceEngine57 * this, struct ZLetNode379 * Node__1) {
	if (HasUntypedNode__1qwg(Node__1)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", LibZen_BooleanToString(HasUntypedNode__1qwg(Node__1))), "\n"), toString__1qwg(Node__1)));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node__1, this->InteractiveContext);
	return;
}
static void VisitFunctionNode__2qw9(struct ZSourceEngine57 * this, struct ZFunctionNode144 * Node__1) {
	if (HasUntypedNode__1qwg(Node__1)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", LibZen_BooleanToString(HasUntypedNode__1qwg(Node__1))), "\nLAZY: "), toString__1qwg(Node__1)));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node__1, this->InteractiveContext);
	return;
}
static void VisitClassNode__2qw9(struct ZSourceEngine57 * this, struct ZClassNode512 * Node__1) {
	if (HasUntypedNode__1qwg(Node__1)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", LibZen_BooleanToString(HasUntypedNode__1qwg(Node__1))), "\n"), toString__1qwg(Node__1)));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node__1, this->InteractiveContext);
	return;
}
static void VisitErrorNode__2qw9(struct ZSourceEngine57 * this, struct ZErrorNode335 * Node__1) {
	(void)ZLogger_LogError__2qey(Node__1->SourceToken, Node__1->ErrorMessage);
	this->StopVisitor(this);
	return;
}
static void VisitTypeNode__2qw9(struct ZSourceEngine57 * this, struct ZTypeNode235 * Node__1) {
	Unsupported__2qw9(this, Node__1);
	return;
}
static void VisitExtendedNode__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node__1, 235)) {
		VisitTypeNode__2qw9(this, (struct ZTypeNode235 *)Node__1);
	} else {
		struct ZNode52 * SugarNode__2 = /*untyped*/NULL(Node__1, this->Generator);
		/*untyped*/NULL(SugarNode__2, this);
	};
	return;
}
static void VisitSugarNode__2qw9(struct ZSourceEngine57 * this, struct ZSugarNode165 * Node__1) {
	Eval2__2qw9(this, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z32));
	return;
}
static void WriteTo__2qw9(struct ZSourceEngine57 * this, const char * OutputFile__1) {
	/*untyped*/NULL(this->Generator, OutputFile__1);
	ShowErrors__1qrv(this->Generator->Logger);
	return;
}
static struct ZSourceGenerator243 * ZSourceGenerator__3quv(struct ZSourceGenerator243 * this, const char * TargetCode__1, const char * TargetVersion__2) {
	(void)ZGenerator__3qwk(this, TargetCode__1, TargetVersion__2);
	/*untyped*/NULL(this);
	this->LineFeed = "\n";
	this->Tab = "   ";
	this->LineComment = "//";
	this->BeginComment = "/*";
	this->EndComment = "*/";
	this->Camma = ", ";
	this->SemiColon = ";";
	this->TrueLiteral = "true";
	this->FalseLiteral = "false";
	this->NullLiteral = "null";
	this->AndOperator = "&&";
	this->OrOperator = "||";
	this->NotOperator = "!";
	this->TopType = "var";
	return NULL;
}
static void InitBuilderList__1quv(struct ZSourceGenerator243 * this) {
	this->CurrentBuilder = NULL;
	LibZen_ArrayClear((ArrayOfVar *)this->BuilderList);
	this->HeaderBuilder = AppendNewSourceBuilder__1quv(this);
	this->CurrentBuilder = AppendNewSourceBuilder__1quv(this);
	return;
}
static struct ZSourceEngine57 * GetEngine__1quv(struct ZSourceGenerator243 * this) {
	LibZen_PrintLine__1qqy("FIXME: Overide GetEngine in each generator!!");
	return ZSourceEngine__3qw9(_NewZSourceEngine57(), ZTypeChecker__2qr2(_NewZTypeChecker142(), this), this);
}
static struct ZSourceBuilder42 * AppendNewSourceBuilder__1quv(struct ZSourceGenerator243 * this) {
	struct ZSourceBuilder42 * Builder__1 = ZSourceBuilder__3qwu(_NewZSourceBuilder42(), this, this->CurrentBuilder);
	LibZen_ArrayAdd((ArrayOfVar *)this->BuilderList, (var)Builder__1);
	return Builder__1;
}
static struct ZSourceBuilder42 * InsertNewSourceBuilder__1quv(struct ZSourceGenerator243 * this) {
	struct ZSourceBuilder42 * Builder__1 = ZSourceBuilder__3qwu(_NewZSourceBuilder42(), this, this->CurrentBuilder);
	long i__2 = 0;
	while (i__2 < LibZen_ArraySize((ArrayOfVar *)this->BuilderList)) {
		if (Array<ZSourceBuilder>GetIndex(i__2) == this->CurrentBuilder) {
			LibZen_ArrayAdd2((ArrayOfVar *)this->BuilderList, i__2, (var)Builder__1);
			return Builder__1;
		};
		i__2 = i__2 + 1;
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->BuilderList, (var)Builder__1);
	return Builder__1;
}
static void SetNativeType__3quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1, const char * TypeName__2) {
	const char * Key__3 = LibZen_StrCat("", LibZen_IntToString(Type__1->TypeId));
	Map<String>SetIndex(Key__3, TypeName__2);
	return;
}
static const char * GetNativeTypeName__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1) {
	const char * Key__2 = LibZen_StrCat("", LibZen_IntToString(Type__1->TypeId));
	const char * TypeName__3 = Map<String>GetIndex(Key__2);
	if (TypeName__3 == NULL) {
		return Type__1->ShortName;
	};
	return TypeName__3;
}
static void SetReservedName__3quv(struct ZSourceGenerator243 * this, const char * Keyword__1, const char * AnotherName__2) {
	if (AnotherName__2 == NULL) {
		AnotherName__2 = LibZen_StrCat("_", Keyword__1);
	};
	Map<String>SetIndex(Keyword__1, AnotherName__2);
	return;
}
static const char * SafeName__3quv(struct ZSourceGenerator243 * this, const char * Name__1, long Index__2) {
	if (Index__2 == 0) {
		const char * SafeName__3 = Map<String>GetIndex(Name__1);
		if (SafeName__3 == NULL) {
			SafeName__3 = Name__1;
		};
		return SafeName__3;
	};
	return LibZen_StrCat(LibZen_StrCat(Name__1, "__"), LibZen_IntToString(Index__2));
}
static void SetMacro__4quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3) {
	struct ZFuncType90 * FuncType__4 = ZTypePool_LookupFuncType__1qwz(ReturnType__3);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName__1, FuncType__4, Macro__2));
	return;
}
static void SetMacro__5quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4) {
	struct ZFuncType90 * FuncType__5 = ZTypePool_LookupFuncType__2qwz(ReturnType__3, P1__4);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName__1, FuncType__5, Macro__2));
	return;
}
static void SetMacro__6quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5) {
	struct ZFuncType90 * FuncType__6 = ZTypePool_LookupFuncType__3qwz(ReturnType__3, P1__4, P2__5);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName__1, FuncType__6, Macro__2));
	return;
}
static void SetMacro__7quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5, struct ZType60 * P3__6) {
	struct ZFuncType90 * FuncType__7 = ZTypePool_LookupFuncType__4qwz(ReturnType__3, P1__4, P2__5, P3__6);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName__1, FuncType__7, Macro__2));
	return;
}
static void SetConverterMacro__4quv(struct ZSourceGenerator243 * this, const char * Macro__1, struct ZType60 * ReturnType__2, struct ZType60 * P1__3) {
	struct ZFuncType90 * FuncType__4 = ZTypePool_LookupFuncType__2qwz(ReturnType__2, P1__3);
	SetConverterFunc__4qwk(this, P1__3, ReturnType__2, ZSourceMacro__4qis(_NewZSourceMacro265(), LibZen_StrCat("to", NameClass__2qwk(this, ReturnType__2)), FuncType__4, Macro__1));
	return;
}
static void WriteTo__2quv(struct ZSourceGenerator243 * this, const char * FileName__1) {
	LibZen_WriteTo__2qqy(this->NameOutputFile(this, FileName__1), this->BuilderList);
	this->InitBuilderList(this);
	return;
}
static const char * GetSourceText__1quv(struct ZSourceGenerator243 * this) {
	struct ZSourceBuilder42 * sb__4 = ZSourceBuilder__3qwu(_NewZSourceBuilder42(), this, NULL);
	long i__5 = 0;
	while (i__2 < LibZen_ArraySize((ArrayOfVar *)this->BuilderList)) {
		struct ZSourceBuilder42 * Builder__3 = Array<ZSourceBuilder>GetIndex(i__2);
		Append__2qwu(sb__1, toString__1qwu(Builder__3));
		Clear__1qwu(Builder__3);
		AppendLineFeed__1qwu(sb__1);
		AppendLineFeed__1qwu(sb__1);
		i__2 = i__2 + 1;
	};
	this->InitBuilderList(this);
	return LibZen_SourceBuilderToString__1qwu(sb__1);
}
static int StartCodeGeneration__3quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1, int IsInteractive__2) {
	Node__1->Accept(Node__1, this);
	if (IsInteractive__2) {
		long i__5 = 0;
		LibZen_PrintLine__1qqy("---");
		while (i__3 < LibZen_ArraySize((ArrayOfVar *)this->BuilderList)) {
			struct ZSourceBuilder42 * Builder__4 = Array<ZSourceBuilder>GetIndex(i__3);
			LibZen_PrintLine__1qqy(toString__1qwu(Builder__4));
			Clear__1qwu(Builder__4);
			i__3 = i__3 + 1;
		};
		this->InitBuilderList(this);
	};
	return 1/*true*/;
}
static void GenerateCode__3quv(struct ZSourceGenerator243 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2) {
	/*untyped*/NULL(Node__2, this);
	return;
}
static int IsNeededSurroud__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node__1, 310)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void GenerateSurroundCode__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1) {
	if (IsNeededSurroud__2quv(this, Node__1)) {
		Append__2qwu(this->CurrentBuilder, "(");
		/*untyped*/NULL(this, NULL, Node__1);
		Append__2qwu(this->CurrentBuilder, ")");
	} else {
		/*untyped*/NULL(this, NULL, Node__1);
	};
	return;
}
static void AppendCode__2quv(struct ZSourceGenerator243 * this, const char * RawSource__1) {
	Append__2qwu(this->CurrentBuilder, RawSource__1);
	return;
}
static void VisitStmtList__2quv(struct ZSourceGenerator243 * this, struct ZBlockNode161 * BlockNode__1) {
	long i__2 = 0;
	while (i__2 < GetListSize__1qu8(BlockNode__1)) {
		struct ZNode52 * SubNode__3 = GetListAt__2qu8(BlockNode__1, i__2);
		AppendLineFeed__1qwu(this->CurrentBuilder);
		AppendIndent__1qwu(this->CurrentBuilder);
		/*untyped*/NULL(this, NULL, SubNode__3);
		i__2 = i__2 + 1;
		if (i__2 < GetListSize__1qu8(BlockNode__1)) {
			Append__2qwu(this->CurrentBuilder, this->SemiColon);
		};
	};
	return;
}
static void VisitBlockNode__2quv(struct ZSourceGenerator243 * this, struct ZBlockNode161 * Node__1) {
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "{");
	Indent__1qwu(this->CurrentBuilder);
	VisitStmtList__2quv(this, Node__1);
	if (GetListSize__1qu8(Node__1) > 0) {
		Append__2qwu(this->CurrentBuilder, this->SemiColon);
	};
	UnIndent__1qwu(this->CurrentBuilder);
	AppendLineFeed__1qwu(this->CurrentBuilder);
	AppendIndent__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "}");
	return;
}
static void VisitNullNode__2quv(struct ZSourceGenerator243 * this, struct ZNullNode418 * Node__1) {
	Append__2qwu(this->CurrentBuilder, this->NullLiteral);
	return;
}
static void VisitBooleanNode__2quv(struct ZSourceGenerator243 * this, struct ZBooleanNode472 * Node__1) {
	if (Node__1->BooleanValue) {
		Append__2qwu(this->CurrentBuilder, this->TrueLiteral);
	} else {
		Append__2qwu(this->CurrentBuilder, this->FalseLiteral);
	};
	return;
}
static void VisitIntNode__2quv(struct ZSourceGenerator243 * this, struct ZIntNode376 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", LibZen_IntToString((Node__1->IntValue))));
	return;
}
static void VisitFloatNode__2quv(struct ZSourceGenerator243 * this, struct ZFloatNode343 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", LibZen_FloatToString((Node__1->FloatValue))));
	return;
}
static void VisitStringNode__2quv(struct ZSourceGenerator243 * this, struct ZStringNode430 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node__1->StringValue));
	return;
}
static void VisitArrayLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZArrayLiteralNode477 * Node__1) {
	VisitListNode__4quv(this, "[", Node__1, "]");
	return;
}
static void VisitMapLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZMapLiteralNode398 * Node__1) {
	return;
}
static void VisitNewObjectNode__2quv(struct ZSourceGenerator243 * this, struct ZNewObjectNode411 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "new");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	GenerateTypeName__2quv(this, Node__1->Type);
	VisitListNode__4quv(this, "(", Node__1, ")");
	return;
}
static void VisitGroupNode__2quv(struct ZSourceGenerator243 * this, struct ZGroupNode363 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGroupNode_Expr_Z68));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitGetIndexNode__2quv(struct ZSourceGenerator243 * this, struct ZGetIndexNode346 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Recv_Z65));
	Append__2qwu(this->CurrentBuilder, "[");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Index_Z66));
	Append__2qwu(this->CurrentBuilder, "]");
	return;
}
static void VisitSetIndexNode__2quv(struct ZSourceGenerator243 * this, struct ZSetIndexNode178 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Recv_Z26));
	Append__2qwu(this->CurrentBuilder, "[");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Index_Z27));
	Append__2qwu(this->CurrentBuilder, "]");
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Expr_Z28));
	return;
}
static void VisitGlobalNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGlobalNameNode359 * Node__1) {
	if (IsUntyped__1qwg(Node__1)) {
		(void)ZLogger_LogError__2qey(Node__1->SourceToken, LibZen_StrCat("undefined symbol: ", Node__1->GlobalName));
	};
	if (Node__1->IsStaticFuncName) {
		Append__2qwu(this->CurrentBuilder, StringfySignature__2qwz(Node__1->Type, Node__1->GlobalName));
	} else {
		Append__2qwu(this->CurrentBuilder, Node__1->GlobalName);
	};
	return;
}
static void VisitGetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGetNameNode349 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->VarName, Node__1->VarIndex));
	return;
}
static void VisitSetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZSetNameNode181 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->VarName, Node__1->VarIndex));
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetNameNode_Expr_Z29));
	return;
}
static void VisitGetterNode__2quv(struct ZSourceGenerator243 * this, struct ZGetterNode354 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZGetterNode_Recv_Z67));
	Append__2qwu(this->CurrentBuilder, ".");
	Append__2qwu(this->CurrentBuilder, Node__1->FieldName);
	return;
}
static void VisitSetterNode__2quv(struct ZSourceGenerator243 * this, struct ZSetterNode184 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZSetterNode_Recv_Z30));
	Append__2qwu(this->CurrentBuilder, ".");
	Append__2qwu(this->CurrentBuilder, Node__1->FieldName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetterNode_Expr_Z31));
	return;
}
static void VisitMethodCallNode__2quv(struct ZSourceGenerator243 * this, struct ZMethodCallNode402 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
	Append__2qwu(this->CurrentBuilder, ".");
	Append__2qwu(this->CurrentBuilder, Node__1->MethodName);
	VisitListNode__4quv(this, "(", Node__1, ")");
	return;
}
static void VisitMacroNode__2quv(struct ZSourceGenerator243 * this, struct ZMacroNode391 * Node__1) {
	const char * Macro__8 = GetMacroText__1q07(Node__1);
	struct ZFuncType90 * FuncType__9 = GetFuncType__1q07(Node__1);
	long fromIndex__10 = 0;
	long BeginNum__11 = LibZen_IndexOf2(Macro__2, "$[", fromIndex__4);
	while (BeginNum__5 != -1) {
		long EndNum__12 = LibZen_IndexOf2(Macro__2, "]", BeginNum__5 + 2);
		if (EndNum__6 == -1) {
			break;
		};
		Append__2qwu(this->CurrentBuilder, LibZen_SubString2(Macro__2, fromIndex__4));
		long Index__13 = (long)LibZen_ParseInt__1qqy(LibZen_SubString2(Macro__2, BeginNum__5 + 2));
		if (HasAst__2qwg(Node__1, Index__7)) {
			this->GenerateCode(this, GetFuncParamType__2qej(FuncType__3, Index__7), Array<ZNode>GetIndex(Index__7));
		};
		fromIndex__4 = EndNum__6 + 1;
		BeginNum__5 = LibZen_IndexOf2(Macro__2, "$[", fromIndex__4);
	};
	Append__2qwu(this->CurrentBuilder, LibZen_SubString(Macro__2, fromIndex__4));
	return;
}
static void VisitFuncCallNode__2quv(struct ZSourceGenerator243 * this, struct ZFuncCallNode406 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79));
	VisitListNode__4quv(this, "(", Node__1, ")");
	return;
}
static void VisitUnaryNode__2quv(struct ZSourceGenerator243 * this, struct ZUnaryNode197 * Node__1) {
	Append__2qwu(this->CurrentBuilder, GetText__1qey(Node__1->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z37));
	return;
}
static void VisitNotNode__2quv(struct ZSourceGenerator243 * this, struct ZNotNode415 * Node__1) {
	Append__2qwu(this->CurrentBuilder, this->NotOperator);
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z37));
	return;
}
static void VisitCastNode__2quv(struct ZSourceGenerator243 * this, struct ZCastNode320 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "(");
	GenerateTypeName__2quv(this, Node__1->Type);
	Append__2qwu(this->CurrentBuilder, ")");
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
	return;
}
static void VisitInstanceOfNode__2quv(struct ZSourceGenerator243 * this, struct ZInstanceOfNode372 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, "instanceof");
	GenerateTypeName__2quv(this, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61)->Type);
	return;
}
static void VisitBinaryNode__2quv(struct ZSourceGenerator243 * this, struct ZBinaryNode310 * Node__1) {
	if (LibZen_Is(Node__1->ParentNode, 310)) {
		Append__2qwu(this->CurrentBuilder, "(");
	};
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, GetText__1qey(Node__1->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	if (LibZen_Is(Node__1->ParentNode, 310)) {
		Append__2qwu(this->CurrentBuilder, ")");
	};
	return;
}
static void VisitComparatorNode__2quv(struct ZSourceGenerator243 * this, struct ZComparatorNode328 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, GetText__1qey(Node__1->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	return;
}
static void VisitAndNode__2quv(struct ZSourceGenerator243 * this, struct ZAndNode498 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, this->AndOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	return;
}
static void VisitOrNode__2quv(struct ZSourceGenerator243 * this, struct ZOrNode421 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, this->OrOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	return;
}
static void VisitIfNode__2quv(struct ZSourceGenerator243 * this, struct ZIfNode366 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "if (");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Cond_Z69));
	Append__2qwu(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Then_Z70));
	if (Array<ZNode>GetIndex(ZIfNode_Else_Z71) != NULL) {
		AppendToken__2qwu(this->CurrentBuilder, "else");
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Else_Z71));
	};
	return;
}
static void VisitReturnNode__2quv(struct ZSourceGenerator243 * this, struct ZReturnNode170 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "return");
	if (Array<ZNode>GetIndex(ZReturnNode_Expr_Z25) != NULL) {
		AppendWhiteSpace__1qwu(this->CurrentBuilder);
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZReturnNode_Expr_Z25));
	};
	return;
}
static void VisitWhileNode__2quv(struct ZSourceGenerator243 * this, struct ZWhileNode200 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "while (");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZWhileNode_Cond_Z38));
	Append__2qwu(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZWhileNode_Block_Z39));
	return;
}
static void VisitBreakNode__2quv(struct ZSourceGenerator243 * this, struct ZBreakNode317 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "break");
	return;
}
static void VisitThrowNode__2quv(struct ZSourceGenerator243 * this, struct ZThrowNode191 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "throw");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZThrowNode_Expr_Z33));
	return;
}
static void VisitTryNode__2quv(struct ZSourceGenerator243 * this, struct ZTryNode194 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "try");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Try_Z34));
	if (Array<ZNode>GetIndex(ZTryNode_Catch_Z35) != NULL) {
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Catch_Z35));
	};
	if (Array<ZNode>GetIndex(ZTryNode_Finally_Z36) != NULL) {
		Append__2qwu(this->CurrentBuilder, "finally");
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Finally_Z36));
	};
	return;
}
static void VisitCatchNode__2quv(struct ZSourceGenerator243 * this, struct ZCatchNode324 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "catch (");
	Append__2qwu(this->CurrentBuilder, Node__1->ExceptionName);
	VisitTypeAnnotation__2quv(this, Node__1->ExceptionType);
	Append__2qwu(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZCatchNode_Block_Z63));
	return;
}
static void VisitVarNode__2quv(struct ZSourceGenerator243 * this, struct ZVarNode502 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "var");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->NativeName, Node__1->VarIndex));
	VisitTypeAnnotation__2quv(this, Node__1->DeclType);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZVarNode_InitValue_Z81));
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	VisitStmtList__2quv(this, Node__1);
	return;
}
static void VisitTypeAnnotation__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1) {
	Append__2qwu(this->CurrentBuilder, ": ");
	GenerateTypeName__2quv(this, Type__1);
	return;
}
static void VisitLetNode__2quv(struct ZSourceGenerator243 * this, struct ZLetNode379 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "let");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, Node__1->GlobalName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZLetNode_InitValue_Z73));
	return;
}
static void VisitParamNode__2quv(struct ZSourceGenerator243 * this, struct ZParamNode172 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->Name, Node__1->ParamIndex));
	VisitTypeAnnotation__2quv(this, Node__1->Type);
	return;
}
static void VisitFunctionNode__2quv(struct ZSourceGenerator243 * this, struct ZFunctionNode144 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "function");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	if (Node__1->FuncName != NULL) {
		Append__2qwu(this->CurrentBuilder, Node__1->FuncName);
	};
	VisitListNode__4quv(this, "(", Node__1, ")");
	VisitTypeAnnotation__2quv(this, Node__1->ReturnType);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFunctionNode_Block_Z80));
	return;
}
static void VisitClassNode__2quv(struct ZSourceGenerator243 * this, struct ZClassNode512 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "class");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, Node__1->ClassName);
	if (Node__1->SuperType != NULL) {
		AppendToken__2qwu(this->CurrentBuilder, "extends");
		GenerateTypeName__2quv(this, Node__1->SuperType);
	};
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "{");
	Indent__1qwu(this->CurrentBuilder);
	long i__2 = 0;
	while (i__2 < GetListSize__1qu8(Node__1)) {
		struct ZFieldNode339 * FieldNode__3 = GetFieldNode__2qdo(Node__1, i__2);
		AppendLineFeed__1qwu(this->CurrentBuilder);
		AppendIndent__1qwu(this->CurrentBuilder);
		Append__2qwu(this->CurrentBuilder, "var");
		AppendWhiteSpace__1qwu(this->CurrentBuilder);
		Append__2qwu(this->CurrentBuilder, FieldNode__3->FieldName);
		VisitTypeAnnotation__2quv(this, FieldNode__3->DeclType);
		if (HasAst__2qwg(FieldNode__3, ZFieldNode_InitValue_Z64)) {
			AppendToken__2qwu(this->CurrentBuilder, "=");
			/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFieldNode_InitValue_Z64));
		};
		Append__2qwu(this->CurrentBuilder, this->SemiColon);
		i__2 = i__2 + 1;
	};
	UnIndent__1qwu(this->CurrentBuilder);
	AppendLineFeed__1qwu(this->CurrentBuilder);
	AppendIndent__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "}");
	return;
}
static void VisitErrorNode__2quv(struct ZSourceGenerator243 * this, struct ZErrorNode335 * Node__1) {
	(void)ZLogger_LogError__2qey(Node__1->SourceToken, Node__1->ErrorMessage);
	Append__2qwu(this->CurrentBuilder, "ThrowError(");
	Append__2qwu(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node__1->ErrorMessage));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitExtendedNode__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node__1, 172)) {
		VisitParamNode__2quv(this, (struct ZParamNode172 *)Node__1);
	} else {
		struct ZSugarNode165 * SugarNode__2 = /*untyped*/NULL(Node__1, this);
		/*untyped*/NULL(this, SugarNode__2);
	};
	return;
}
static void VisitSugarNode__2quv(struct ZSourceGenerator243 * this, struct ZSugarNode165 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z32));
	return;
}
static void GenerateTypeName__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1) {
	Append__2qwu(this->CurrentBuilder, GetNativeTypeName__2quv(this, /*untyped*/NULL(Type__1)));
	return;
}
static void VisitListNode__5quv(struct ZSourceGenerator243 * this, const char * OpenToken__1, struct ZListNode251 * VargNode__2, const char * DelimToken__3, const char * CloseToken__4) {
	Append__2qwu(this->CurrentBuilder, OpenToken__1);
	long i__5 = 0;
	while (i__5 < GetListSize__1qu8(VargNode__2)) {
		struct ZNode52 * ParamNode__6 = GetListAt__2qu8(VargNode__2, i__5);
		if (i__5 > 0) {
			Append__2qwu(this->CurrentBuilder, DelimToken__3);
		};
		/*untyped*/NULL(this, NULL, ParamNode__6);
		i__5 = i__5 + 1;
	};
	Append__2qwu(this->CurrentBuilder, CloseToken__4);
	return;
}
static void VisitListNode__4quv(struct ZSourceGenerator243 * this, const char * OpenToken__1, struct ZListNode251 * VargNode__2, const char * CloseToken__3) {
	VisitListNode__5quv(this, OpenToken__1, VargNode__2, ", ", CloseToken__3);
	return;
}
static struct ZTypeChecker142 * ZTypeChecker__2qr2(struct ZTypeChecker142 * this, struct ZGenerator55 * Generator__1) {
	this->Generator = Generator__1;
	this->Logger = Generator__1->Logger;
	this->StackedContextType = NULL;
	this->ReturnedNode = NULL;
	this->StoppedVisitor = 0/*false*/;
	this->VarScope = ZVarScope__4qrc(_NewZVarScope134(), NULL, this->Logger, NULL);
	return NULL;
}
static void EnableVisitor__1qr2(struct ZTypeChecker142 * this) {
	this->StoppedVisitor = 0/*false*/;
	return;
}
static void StopVisitor__1qr2(struct ZTypeChecker142 * this) {
	this->StoppedVisitor = 1/*true*/;
	return;
}
static int IsVisitable__1qr2(struct ZTypeChecker142 * this) {
	return !this->StoppedVisitor;
}
static struct ZType60 * GetContextType__1qr2(struct ZTypeChecker142 * this) {
	return this->StackedContextType;
}
static struct ZNode52 * VisitTypeChecker__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2) {
	struct ZNode52 * ParentNode__4 = Node__1->ParentNode;
	this->StackedContextType = ContextType__2;
	this->ReturnedNode = NULL;
	Node__1->Accept(Node__1, this);
	if (this->ReturnedNode == NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("!! returns no value: ", toString__1qwg(Node__1)));
	} else {
		Node__1 = this->ReturnedNode;
	};
	if (ParentNode__3 != Node__1->ParentNode && ParentNode__3 != NULL) {
		(void)SetChild__2qwg(ParentNode__3, Node__1);
	};
	CheckVarNode__3qrc(this->VarScope, ContextType__2, Node__1);
	return Node__1;
}
static struct ZNode52 * CreateStupidCastNode__3qr2(struct ZTypeChecker142 * this, struct ZType60 * Requested__1, struct ZNode52 * Node__2) {
	struct ZNode52 * ErrorNode__3 = ZStupidCastErrorNode__3qaw(_NewZStupidCastErrorNode433(), Node__2, LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("type error: requested=", toString__1qwz(Requested__1)), ", given="), toString__1qwz(Node__2->Type)));
	ErrorNode__3->Type = Requested__1;
	return ErrorNode__3;
}
static struct ZNode52 * EnforceNodeType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * EnforcedType__2) {
	struct ZFunc89 * Func__3 = LookupConverterFunc__3qwk(this->Generator, Node__1->Type, EnforcedType__2);
	if (Func__3 == NULL && IsStringType__1qwz(EnforcedType__2)) {
		Func__3 = LookupFunc__4qwk(this->Generator, "toString", Node__1->Type, 1);
	};
	if (LibZen_Is(Func__3, 210)) {
		struct ZMacroNode391 * MacroNode__4 = ZMacroNode__4q07(_NewZMacroNode391(), Node__1->ParentNode, NULL, (struct ZMacroFunc210 *)Func__3);
		Append__2qu8(MacroNode__4, Node__1);
		MacroNode__4->Type = EnforcedType__2;
		return MacroNode__4;
	} else if (Func__3 != NULL) {
		struct ZFuncCallNode406 * MacroNode__5 = ZFuncCallNode__4q40(_NewZFuncCallNode406(), Node__1->ParentNode, Func__3->FuncName, GetFuncType__1qeh(Func__3));
		Append__2qu8(MacroNode__5, Node__1);
		MacroNode__5->Type = EnforcedType__2;
		return MacroNode__5;
	};
	return CreateStupidCastNode__3qr2(this, EnforcedType__2, Node__1);
}
static struct ZNode52 * TypeCheckImpl__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2, long TypeCheckPolicy__3) {
	if (IsErrorNode__1qwg(Node__1)) {
		if (!ContextType__2->IsVarType(ContextType__2)) {
			Node__1->Type = ContextType__2;
		};
		return Node__1;
	};
	if (IsUntyped__1qwg(Node__1) || ContextType__2->IsVarType(ContextType__2) || LibZen_IsFlag__2qqr(TypeCheckPolicy__3, ZTypeChecker_NoCheckPolicy_Z78)) {
		return Node__1;
	};
	if (Node__1->Type == ContextType__2 || Accept__2qwz(ContextType__2, Node__1->Type)) {
		return Node__1;
	};
	if (IsVoidType__1qwz(ContextType__2) && !IsVoidType__1qwz(Node__1->Type)) {
		return ZCastNode__4qo5(_NewZCastNode320(), Node__1->ParentNode, ZTypeVoidType_Z5, Node__1);
	};
	if (IsFloatType__1qwz(ContextType__2) && IsIntType__1qwz(Node__1->Type)) {
		return EnforceNodeType__3qr2(this, Node__1, ContextType__2);
	};
	if (IsIntType__1qwz(ContextType__2) && IsFloatType__1qwz(Node__1->Type)) {
		return EnforceNodeType__3qr2(this, Node__1, ContextType__2);
	};
	return CreateStupidCastNode__3qr2(this, ContextType__2, Node__1);
}
static struct ZNode52 * VisitTypeChecker__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2, long TypeCheckPolicy__3) {
	if (/*untyped*/NULL(this) && Node__1 != NULL) {
		if (HasUntypedNode__1qwg(Node__1)) {
			Node__1 = VisitTypeChecker__3qwg(Node__1, this, ContextType__2);
		};
		Node__1 = TypeCheckImpl__4qr2(this, Node__1, ContextType__2, TypeCheckPolicy__3);
		CheckVarNode__3qrc(this->VarScope, ContextType__2, Node__1);
	};
	this->ReturnedNode = NULL;
	return Node__1;
}
static struct ZNode52 * TryType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2) {
	return VisitTypeChecker__4qr2(this, Node__1, ContextType__2, ZTypeChecker_NoCheckPolicy_Z78);
}
static void TryTypeAt__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, long Index__2, struct ZType60 * ContextType__3) {
	Set__3qwg(Node__1, Index__2, VisitTypeChecker__4qr2(this, Array<ZNode>GetIndex(Index__2), ContextType__3, ZTypeChecker_NoCheckPolicy_Z78));
	return;
}
static struct ZNode52 * CheckType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2) {
	return VisitTypeChecker__4qr2(this, Node__1, ContextType__2, ZTypeChecker_DefaultTypeCheckPolicy_Z77);
}
static void CheckTypeAt__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, long Index__2, struct ZType60 * ContextType__3) {
	Set__3qwg(Node__1, Index__2, VisitTypeChecker__4qr2(this, Array<ZNode>GetIndex(Index__2), ContextType__3, ZTypeChecker_DefaultTypeCheckPolicy_Z77));
	return;
}
static int TypeCheckNodeList__2qr2(struct ZTypeChecker142 * this, struct ZListNode251 * List__1) {
	if (/*untyped*/NULL(this)) {
		int AllTyped__2 = 1/*true*/;
		long i__3 = 0;
		while (i__3 < GetListSize__1qu8(List__1)) {
			struct ZNode52 * SubNode__4 = GetListAt__2qu8(List__1, i__3);
			SubNode__4 = CheckType__3qr2(this, SubNode__4, ZTypeVarType_Z4);
			SetListAt__3qu8(List__1, i__3, SubNode__4);
			if (IsUntyped__1qwg(SubNode__4)) {
				AllTyped__2 = 0/*false*/;
			};
			i__3 = i__3 + 1;
		};
		return AllTyped__2;
	};
	return 0/*false*/;
}
static void Return__2qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1) {
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", toString__1qwg(Node__1)));
	};
	this->ReturnedNode = Node__1;
	return;
}
static void TypedNode__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * Type__2) {
	Node__1->Type = Type__2->GetRealType(Type__2);
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", toString__1qwg(Node__1)));
	};
	this->ReturnedNode = Node__1;
	return;
}
static void ReturnErrorNode__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZToken77 * ErrorToken__2, const char * Message__3) {
	if (ErrorToken__2 == NULL) {
		ErrorToken__2 = Node__1->SourceToken;
	};
	Return__2qr2(this, ZErrorNode__4qp4(_NewZErrorNode335(), Node__1->ParentNode, ErrorToken__2, Message__3));
	return;
}
static void VisitErrorNode__2qr2(struct ZTypeChecker142 * this, struct ZErrorNode335 * Node__1) {
	struct ZType60 * ContextType__2 = GetContextType__1qr2(this);
	if (!/*untyped*/NULL(ContextType__2)) {
		TypedNode__3qr2(this, Node__1, ContextType__2);
	} else {
		Return__2qr2(this, Node__1);
	};
	return;
}
static void VisitExtendedNode__2qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1) {
	struct ZType60 * ContextType__2 = GetContextType__1qr2(this);
	struct ZNode52 * DeNode__3 = /*untyped*/NULL(Node__1, this->Generator);
	if (!IsErrorNode__1qwg(DeNode__3)) {
		Return__2qr2(this, CheckType__3qr2(this, DeNode__3, ContextType__2));
	} else {
		TypedNode__3qr2(this, DeNode__3, ContextType__2);
	};
	return;
}
static void VisitSugarNode__2qr2(struct ZTypeChecker142 * this, struct ZSugarNode165 * Node__1) {
	struct ZType60 * ContextType__2 = GetContextType__1qr2(this);
	CheckTypeAt__4qr2(this, Node__1, ZSugarNode_DeSugar_Z32, ContextType__2);
	TypedNode__3qr2(this, Node__1, GetAstType__2qwg(Node__1, ZSugarNode_DeSugar_Z32));
	return;
}
static struct CSourceGenerator596 * CSourceGenerator__1qgl(struct CSourceGenerator596 * this) {
	(void)ZSourceGenerator__3quv(this, "c", "C99");
	this->LineFeed = "\n";
	this->Tab = "\t";
	this->Camma = ", ";
	this->SemiColon = ";";
	this->TrueLiteral = "1/*true*/";
	this->FalseLiteral = "0/*false*/";
	this->NullLiteral = "NULL";
	this->TopType = "void *";
	SetNativeType__3quv(this, ZTypeBooleanType_Z6, "int");
	SetNativeType__3quv(this, ZTypeIntType_Z7, "long");
	SetNativeType__3quv(this, ZTypeFloatType_Z8, "double");
	SetNativeType__3quv(this, ZTypeStringType_Z9, "const char *");
	SetMacro__6quv(this, "assert", "LibZen_Assert($[0], $[1])", ZTypeVoidType_Z5, ZTypeBooleanType_Z6, ZTypeStringType_Z9);
	SetMacro__5quv(this, "print", "LibZen_Print($[0])", ZTypeVoidType_Z5, ZTypeStringType_Z9);
	SetMacro__5quv(this, "println", "LibZen_PrintLine($[0])", ZTypeVoidType_Z5, ZTypeStringType_Z9);
	SetConverterMacro__4quv(this, "(double)($[0])", ZTypeFloatType_Z8, ZTypeIntType_Z7);
	SetConverterMacro__4quv(this, "(long)($[0])", ZTypeIntType_Z7, ZTypeFloatType_Z8);
	SetConverterMacro__4quv(this, "LibZen_BooleanToString($[0])", ZTypeStringType_Z9, ZTypeBooleanType_Z6);
	SetConverterMacro__4quv(this, "LibZen_IntToString($[0])", ZTypeStringType_Z9, ZTypeIntType_Z7);
	SetConverterMacro__4quv(this, "LibZen_FloatToString($[0])", ZTypeStringType_Z9, ZTypeFloatType_Z8);
	SetMacro__6quv(this, "+", "LibZen_StrCat($[0], $[1])", ZTypeStringType_Z9, ZTypeStringType_Z9, ZTypeStringType_Z9);
	SetMacro__5quv(this, "size", "LibZen_StringSize($[0])", ZTypeIntType_Z7, ZTypeStringType_Z9);
	SetMacro__6quv(this, "substring", "LibZen_SubString($[0], $[1])", ZTypeStringType_Z9, ZTypeStringType_Z9, ZTypeIntType_Z7);
	SetMacro__7quv(this, "substring", "LibZen_SubString2($[0], $[1])", ZTypeStringType_Z9, ZTypeStringType_Z9, ZTypeIntType_Z7, ZTypeIntType_Z7);
	SetMacro__6quv(this, "indexOf", "LibZen_IndexOf($[0], $[1])", ZTypeIntType_Z7, ZTypeStringType_Z9, ZTypeStringType_Z9);
	SetMacro__7quv(this, "indexOf", "LibZen_IndexOf2($[0], $[1], $[2])", ZTypeIntType_Z7, ZTypeStringType_Z9, ZTypeStringType_Z9, ZTypeIntType_Z7);
	SetMacro__6quv(this, "equals", "LibZen_EqualsString($[0], $[1])", ZTypeBooleanType_Z6, ZTypeStringType_Z9, ZTypeStringType_Z9);
	SetMacro__6quv(this, "startsWith", "LibZen_StartsWith($[0], $[1])", ZTypeBooleanType_Z6, ZTypeStringType_Z9, ZTypeStringType_Z9);
	SetMacro__6quv(this, "endsWith", "LibZen_EndWidth($[0], $[1])", ZTypeBooleanType_Z6, ZTypeStringType_Z9, ZTypeStringType_Z9);
	SetMacro__5quv(this, "size", "LibZen_ArraySize($[0])", ZTypeIntType_Z7, ZGenericType_ArrayType_Z15);
	SetMacro__6quv(this, "clear", "LibZen_ArrayClear($[0])", ZTypeVoidType_Z5, ZGenericType_ArrayType_Z15, ZTypeIntType_Z7);
	SetMacro__6quv(this, "add", "LibZen_ArrayAdd($[0], $[1])", ZTypeVoidType_Z5, ZGenericType_ArrayType_Z15, ZTypeVarType_Z4);
	SetMacro__7quv(this, "add", "LibZen_ArrayAdd2($[0], $[1], $[2])", ZTypeVoidType_Z5, ZGenericType_ArrayType_Z15, ZTypeIntType_Z7, ZTypeVarType_Z4);
	return NULL;
}
static struct ZSourceEngine57 * GetEngine__1qgl(struct CSourceGenerator596 * this) {
	return ZSourceEngine__3qw9(_NewZSourceEngine57(), ZTypeChecker__2qr2(_NewZTypeChecker142(), this), this);
}
static void GenerateCode__3qgl(struct CSourceGenerator596 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2) {
	if (IsUntyped__1qwg(Node__2) && !IsErrorNode__1qwg(Node__2) && !(LibZen_Is(Node__2, 359))) {
		Append__2qwu(this->CurrentBuilder, LibZen_StrCat("/*untyped*/", this->NullLiteral));
		(void)ZLogger_LogError__2qey(Node__2->SourceToken, LibZen_StrCat("untyped error: ", toString__1qwg(Node__2)));
	} else {
		if (ContextType__1 != NULL && Node__2->Type != ContextType__1) {
			Append__2qwu(this->CurrentBuilder, "(");
			GenerateTypeName__2qgl(this, ContextType__1);
			Append__2qwu(this->CurrentBuilder, ")");
		};
		Node__2->Accept(Node__2, this);
	};
	return;
}
static void VisitArrayLiteralNode__2qgl(struct CSourceGenerator596 * this, struct ZArrayLiteralNode477 * Node__1) {
	struct ZType60 * ParamType__2 = /*untyped*/NULL(Node__1->Type, 0);
	if (IsIntType__1qwz(ParamType__2) || IsBooleanType__1qwz(ParamType__2)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewIntArray(");
	} else if (IsFloatType__1qwz(ParamType__2)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewFloatArray(");
	} else if (IsStringType__1qwz(ParamType__2)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewStringArray(");
	} else {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewArray(");
	};
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", LibZen_IntToString((GetListSize__1qu8(Node__1)))));
	if (GetListSize__1qu8(Node__1) > 0) {
		Append__2qwu(this->CurrentBuilder, this->Camma);
	};
	VisitListNode__4quv(this, "", Node__1, ")");
	return;
}
static void VisitMapLiteralNode__2qgl(struct CSourceGenerator596 * this, struct ZMapLiteralNode398 * Node__1) {
	struct ZType60 * ParamType__2 = /*untyped*/NULL(Node__1->Type, 0);
	if (IsIntType__1qwz(ParamType__2) || IsBooleanType__1qwz(ParamType__2)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewIntMap(");
	} else if (IsFloatType__1qwz(ParamType__2)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewFloatMap(");
	} else if (IsStringType__1qwz(ParamType__2)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewStringMap(");
	} else {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewMap(");
	};
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", LibZen_IntToString((GetListSize__1qu8(Node__1)))));
	if (GetListSize__1qu8(Node__1) > 0) {
		Append__2qwu(this->CurrentBuilder, this->Camma);
	};
	VisitListNode__4quv(this, "", Node__1, ")");
	return;
}
static void VisitNewObjectNode__2qgl(struct CSourceGenerator596 * this, struct ZNewObjectNode411 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("_New", NameClass__2qwk(this, Node__1->Type)));
	VisitListNode__4quv(this, "(", Node__1, ")");
	return;
}
static const char * BaseName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * RecvType__1) {
	return GetAsciiName__1qwz(RecvType__1);
}
static void VisitGetIndexNode__2qgl(struct CSourceGenerator596 * this, struct ZGetIndexNode346 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat(BaseName__2qgl(this, GetAstType__2qwg(Node__1, ZGetIndexNode_Recv_Z65)), "GetIndex"));
	Append__2qwu(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Index_Z66));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitSetIndexNode__2qgl(struct CSourceGenerator596 * this, struct ZSetIndexNode178 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat(BaseName__2qgl(this, GetAstType__2qwg(Node__1, ZGetIndexNode_Recv_Z65)), "SetIndex"));
	Append__2qwu(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Index_Z27));
	Append__2qwu(this->CurrentBuilder, this->Camma);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Expr_Z28));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitGetNameNode__2qgl(struct CSourceGenerator596 * this, struct ZGetNameNode349 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->VarName, Node__1->VarIndex));
	return;
}
static void VisitSetNameNode__2qgl(struct CSourceGenerator596 * this, struct ZSetNameNode181 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->VarName, Node__1->VarIndex));
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetNameNode_Expr_Z29));
	return;
}
static void VisitGetterNode__2qgl(struct CSourceGenerator596 * this, struct ZGetterNode354 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZGetterNode_Recv_Z67));
	Append__2qwu(this->CurrentBuilder, "->");
	Append__2qwu(this->CurrentBuilder, Node__1->FieldName);
	return;
}
static void VisitSetterNode__2qgl(struct CSourceGenerator596 * this, struct ZSetterNode184 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZSetterNode_Recv_Z30));
	Append__2qwu(this->CurrentBuilder, "->");
	Append__2qwu(this->CurrentBuilder, Node__1->FieldName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetterNode_Expr_Z31));
	return;
}
static void VisitMethodCallNode__2qgl(struct CSourceGenerator596 * this, struct ZMethodCallNode402 * Node__1) {
	return;
}
static void VisitFuncCallNode__2qgl(struct CSourceGenerator596 * this, struct ZFuncCallNode406 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79));
	VisitListNode__4quv(this, "(", Node__1, ")");
	return;
}
static void VisitThrowNode__2qgl(struct CSourceGenerator596 * this, struct ZThrowNode191 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZThrowNode_Expr_Z33));
	Append__2qwu(this->CurrentBuilder, "longjump(1)");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	return;
}
static void VisitTryNode__2qgl(struct CSourceGenerator596 * this, struct ZTryNode194 * Node__1) {
	return;
}
static void VisitCatchNode__2qgl(struct CSourceGenerator596 * this, struct ZCatchNode324 * Node__1) {
	return;
}
static const char * ParamTypeName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1) {
	if (IsArrayType__1qwz(Type__1)) {
		return LibZen_StrCat("ArrayOf", ParamTypeName__2qgl(this, /*untyped*/NULL(Type__1, 0)));
	};
	if (IsMapType__1qwz(Type__1)) {
		return LibZen_StrCat("MapOf", ParamTypeName__2qgl(this, /*untyped*/NULL(Type__1, 0)));
	};
	if (IsFuncType__1qwz(Type__1)) {
		const char * s__2 = LibZen_StrCat(LibZen_StrCat("FuncOf", ParamTypeName__2qgl(this, /*untyped*/NULL(Type__1, 0))), "Of");
		long i__3 = 0;
		while (i__3 < /*untyped*/NULL(Type__1)) {
			s__2 = LibZen_StrCat(s__2, ParamTypeName__2qgl(this, /*untyped*/NULL(Type__1, i__3)));
			i__3 = i__3 + 1;
		};
		return s__2;
	};
	if (IsIntType__1qwz(Type__1)) {
		return "Int";
	};
	if (IsFloatType__1qwz(Type__1)) {
		return "Float";
	};
	if (IsVoidType__1qwz(Type__1)) {
		return "Void";
	};
	if (/*untyped*/NULL(Type__1)) {
		return "Var";
	};
	return Type__1->ShortName;
}
static const char * GetCTypeName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1) {
	const char * TypeName__2 = NULL;
	if (IsArrayType__1qwz(Type__1) || IsMapType__1qwz(Type__1)) {
		TypeName__2 = LibZen_StrCat(ParamTypeName__2qgl(this, Type__1), " *");
	};
	if (LibZen_Is(Type__1, 80)) {
		TypeName__2 = LibZen_StrCat(LibZen_StrCat("struct ", NameClass__2qwk(this, Type__1)), " *");
	};
	if (TypeName__2 == NULL) {
		TypeName__2 = GetNativeTypeName__2quv(this, Type__1);
	};
	return TypeName__2;
}
static void GenerateFuncTypeName__3qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1, const char * FuncName__2) {
	GenerateTypeName__2qgl(this, /*untyped*/NULL(Type__1, 0));
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat(LibZen_StrCat(" (*", FuncName__2), ")"));
	long i__3 = 1;
	Append__2qwu(this->CurrentBuilder, "(");
	while (i__3 < /*untyped*/NULL(Type__1)) {
		if (i__3 > 1) {
			Append__2qwu(this->CurrentBuilder, ",");
		};
		GenerateTypeName__2qgl(this, /*untyped*/NULL(Type__1, i__3));
		i__3 = i__3 + 1;
	};
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void GenerateTypeName__2qgl(struct CSourceGenerator596 * this, struct ZType60 * Type__1) {
	if (IsFuncType__1qwz(Type__1)) {
		GenerateFuncTypeName__3qgl(this, Type__1, "");
	} else {
		Append__2qwu(this->CurrentBuilder, GetCTypeName__2qgl(this, /*untyped*/NULL(Type__1)));
	};
	return;
}
static void VisitVarNode__2qgl(struct CSourceGenerator596 * this, struct ZVarNode502 * Node__1) {
	GenerateTypeName__2qgl(this, Node__1->DeclType);
	Append__2qwu(this->CurrentBuilder, " ");
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->NativeName, Node__1->VarIndex));
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZVarNode_InitValue_Z81));
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	VisitStmtList__2quv(this, Node__1);
	return;
}
static void VisitParamNode__2qgl(struct CSourceGenerator596 * this, struct ZParamNode172 * Node__1) {
	if (IsFuncType__1qwz(Node__1->Type)) {
		GenerateFuncTypeName__3qgl(this, Node__1->Type, Node__1->Name);
	} else {
		GenerateTypeName__2qgl(this, Node__1->Type);
		Append__2qwu(this->CurrentBuilder, " ");
		Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node__1->Name, Node__1->ParamIndex));
	};
	return;
}
static void SetMethod__3qgl(struct CSourceGenerator596 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2) {
	struct ZType60 * RecvType__3 = GetRecvType__1qej(FuncType__2);
	if (LibZen_Is(RecvType__3, 80) && FuncName__1 != NULL) {
		struct ZClassType80 * ClassType__4 = (struct ZClassType80 *)RecvType__3;
		struct ZType60 * FieldType__5 = GetFieldType__3qeo(ClassType__4, FuncName__1, NULL);
		if (FieldType__5 == NULL || !IsFuncType__1qwz(FieldType__5)) {
			FuncName__1 = LibZen_AnotherName__1qqy(FuncName__1);
			FieldType__5 = GetFieldType__3qeo(ClassType__4, FuncName__1, NULL);
			if (FieldType__5 == NULL || !IsFuncType__1qwz(FieldType__5)) {
				return;
			};
		};
		if (LibZen_Is(FieldType__5, 90)) {
			if (AcceptAsFieldFunc__2qej(((struct ZFuncType90 *)FieldType__5), FuncType__2)) {
				Append__2qwu(this->HeaderBuilder, LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("#define _", NameClass__2qwk(this, ClassType__4)), "_"), FuncName__1));
				AppendLineFeed__1qwu(this->HeaderBuilder);
			};
		};
	};
	return;
}
static void VisitInstanceOfNode__2qgl(struct CSourceGenerator596 * this, struct ZInstanceOfNode372 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "LibZen_Is(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZInstanceOfNode_Left_Z72));
	Append__2qwu(this->CurrentBuilder, this->Camma);
	AppendInt__2qwu(this->CurrentBuilder, Node__1->TargetType->TypeId);
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void GenerateCField__3qgl(struct CSourceGenerator596 * this, const char * CType__1, const char * FieldName__2) {
	AppendLineFeed__1qwu(this->CurrentBuilder);
	AppendIndent__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, CType__1);
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, FieldName__2);
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	return;
}
static void GenerateField__3qgl(struct CSourceGenerator596 * this, struct ZType60 * DeclType__1, const char * FieldName__2) {
	AppendLineFeedIndent__1qwu(this->CurrentBuilder);
	GenerateTypeName__2qgl(this, DeclType__1);
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, FieldName__2);
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	return;
}
static void GenerateFields__3qgl(struct CSourceGenerator596 * this, struct ZClassType80 * ClassType__1, struct ZType60 * ThisType__2) {
	struct ZType60 * SuperType__3 = /*untyped*/NULL(ThisType__2);
	if (!/*untyped*/NULL(SuperType__3)) {
		GenerateFields__3qgl(this, ClassType__1, SuperType__3);
	};
	long i__4 = 0;
	GenerateCField__3qgl(this, "int", LibZen_StrCat("_classId", LibZen_IntToString(ThisType__2->TypeId)));
	GenerateCField__3qgl(this, "int", LibZen_StrCat("_delta", LibZen_IntToString(ThisType__2->TypeId)));
	while (i__4 < GetFieldSize__1qeo(ClassType__1)) {
		struct ZClassField79 * ClassField__5 = GetFieldAt__2qeo(ClassType__1, i__4);
		if (ClassField__5->ClassType == ThisType__2) {
			GenerateField__3qgl(this, ClassField__5->FieldType, ClassField__5->FieldName);
		};
		i__4 = i__4 + 1;
	};
	return;
}
static void VisitErrorNode__2qgl(struct CSourceGenerator596 * this, struct ZErrorNode335 * Node__1) {
	(void)ZLogger_LogError__2qey(Node__1->SourceToken, Node__1->ErrorMessage);
	Append__2qwu(this->CurrentBuilder, "ThrowError(");
	Append__2qwu(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node__1->ErrorMessage));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static struct ZAndNode498 * ZAndNode__5qsm(struct ZAndNode498 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZBinaryNode__5qo1(this, ParentNode__1, Token__2, Left__3, Pattern__4);
	return NULL;
}
static void Accept__2qsm(struct ZAndNode498 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZArrayLiteralNode477 * ZArrayLiteralNode__2qsp(struct ZArrayLiteralNode477 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 0);
	return NULL;
}
static void Accept__2qsp(struct ZArrayLiteralNode477 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZBlockNode161 * ZBlockNode__2qth(struct ZBlockNode161 * this, struct ZNameSpace48 * NameSpace__1) {
	(void)ZListNode__4qu8(this, NULL, NULL, 0);
	this->NameSpace = NameSpace__1;
	return NULL;
}
static struct ZBlockNode161 * ZBlockNode__3qth(struct ZBlockNode161 * this, struct ZNode52 * ParentNode__1, long Init__2) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, Init__2);
	this->NameSpace = CreateSubNameSpace__1qwa(GetNameSpace__1qwg(ParentNode__1));
	return NULL;
}
static void Accept__2qth(struct ZBlockNode161 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZReturnNode170 * ToReturnNode__1qth(struct ZBlockNode161 * this) {
	if (GetListSize__1qu8(this) == 1) {
		return ToReturnNode__1qwg(GetListAt__2qu8(this, 0));
	};
	return NULL;
}
static long IndexOf__2qth(struct ZBlockNode161 * this, struct ZNode52 * ChildNode__1) {
	long i__2 = 0;
	while (i__2 < GetListSize__1qu8(this)) {
		if (GetListAt__2qu8(this, i__2) == ChildNode__1) {
			return i__2;
		};
		i__2 = i__2 + 1;
	};
	return -1;
}
static void CopyTo__3qth(struct ZBlockNode161 * this, long Index__1, struct ZBlockNode161 * BlockNode__2) {
	long i__3 = Index__1;
	while (i__3 < GetListSize__1qu8(this)) {
		Append__2qu8(BlockNode__2, GetListAt__2qu8(this, i__3));
		i__3 = i__3 + 1;
	};
	return;
}
static struct ZBooleanNode472 * ZBooleanNode__4qst(struct ZBooleanNode472 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, int Value__3) {
	(void)ZConstNode__3qpi(this, ParentNode__1, Token__2);
	this->Type = ZTypeBooleanType_Z6;
	this->BooleanValue = Value__3;
	return NULL;
}
static void Accept__2qst(struct ZBooleanNode472 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZClassNode512 * ZClassNode__2qdo(struct ZClassNode512 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 0);
	return NULL;
}
static void SetTypeInfo__3qdo(struct ZClassNode512 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->SuperType = Type__2;
	this->SuperToken = TypeToken__1;
	return;
}
static void SetNameInfo__3qdo(struct ZClassNode512 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->ClassName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static struct ZFieldNode339 * GetFieldNode__2qdo(struct ZClassNode512 * this, long Index__1) {
	struct ZNode52 * Node__2 = GetListAt__2qu8(this, Index__1);
	if (LibZen_Is(Node__2, 339)) {
		return (struct ZFieldNode339 *)Node__2;
	};
	return NULL;
}
static void Accept__2qdo(struct ZClassNode512 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZFuncCallNode406 * ZFuncCallNode__3q40(struct ZFuncCallNode406 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * FuncNode__2) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 1);
	Set__3qwg(this, ZFuncCallNode_Func_Z79, FuncNode__2);
	return NULL;
}
static struct ZFuncCallNode406 * ZFuncCallNode__4q40(struct ZFuncCallNode406 * this, struct ZNode52 * ParentNode__1, const char * FuncName__2, struct ZType60 * FuncType__3) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 1);
	struct ZGlobalNameNode359 * FuncNode__4 = ZGlobalNameNode__6qp8(_NewZGlobalNameNode359(), this, NULL, FuncType__3, FuncName__2, 1/*true*/);
	Set__3qwg(this, ZFuncCallNode_Func_Z79, FuncNode__4);
	return NULL;
}
static void Accept__2q40(struct ZFuncCallNode406 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZType60 * GetRecvType__1q40(struct ZFuncCallNode406 * this) {
	if (GetListSize__1qu8(this) > 0) {
		return /*untyped*/NULL(GetListAt__2qu8(this, 0)->Type);
	};
	return ZTypeVoidType_Z5;
}
static const char * GetFuncName__1q40(struct ZFuncCallNode406 * this) {
	struct ZNode52 * FNode__1 = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79);
	if (LibZen_Is(FNode__1, 359)) {
		return ((struct ZGlobalNameNode359 *)FNode__1)->GlobalName;
	};
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1q40(struct ZFuncCallNode406 * this) {
	struct ZType60 * FType__1 = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79)->Type;
	if (LibZen_Is(FType__1, 90)) {
		return (struct ZFuncType90 *)FType__1;
	};
	return NULL;
}
static struct ZMacroNode391 * ToMacroNode__2q40(struct ZFuncCallNode406 * this, struct ZMacroFunc210 * MacroFunc__1) {
	struct ZMacroNode391 * MacroNode__2 = ZMacroNode__4q07(_NewZMacroNode391(), this->ParentNode, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79)->SourceToken, MacroFunc__1);
	long i__3 = 0;
	while (i__3 < GetListSize__1qu8(this)) {
		Append__2qu8(MacroNode__2, GetListAt__2qu8(this, i__3));
		i__3 = i__3 + 1;
	};
	return MacroNode__2;
}
static struct ZFunctionNode144 * ZFunctionNode__2qtq(struct ZFunctionNode144 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode__1, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qtq(struct ZFunctionNode144 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->ReturnType = Type__2;
	return;
}
static void SetNameInfo__3qtq(struct ZFunctionNode144 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FuncName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static void Accept__2qtq(struct ZFunctionNode144 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZParamNode172 * GetParamNode__2qtq(struct ZFunctionNode144 * this, long Index__1) {
	struct ZNode52 * Node__2 = GetListAt__2qu8(this, Index__1);
	if (LibZen_Is(Node__2, 172)) {
		return (struct ZParamNode172 *)Node__2;
	};
	return NULL;
}
static struct ZFuncType90 * GetFuncType__2qtq(struct ZFunctionNode144 * this, struct ZType60 * ContextType__1) {
	if (this->ResolvedFuncType == NULL) {
		struct ZFuncType90 * FuncType__7 = NULL;
		if (LibZen_Is(ContextType__1, 90)) {
			FuncType__2 = (struct ZFuncType90 *)ContextType__1;
		};
		ArrayOfZType * TypeList__8 = LibZen_NewArray(0);
		if (this->ReturnType->IsVarType(this->ReturnType) && FuncType__2 != NULL) {
			this->ReturnType = FuncType__2->GetParamType(FuncType__2, 0);
		};
		LibZen_ArrayAdd((ArrayOfVar *)TypeList__3, (var)this->ReturnType->GetRealType(this->ReturnType));
		long i__9 = 0;
		while (i__4 < GetListSize__1qu8(this)) {
			struct ZParamNode172 * Node__10 = GetParamNode__2qtq(this, i__4);
			struct ZType60 * ParamType__11 = Node__5->Type->GetRealType(Node__5->Type);
			if (ParamType__6->IsVarType(ParamType__6) && FuncType__2 != NULL) {
				ParamType__11 = FuncType__2->GetParamType(FuncType__2, i__4 + 1);
			};
			LibZen_ArrayAdd((ArrayOfVar *)TypeList__3, (var)ParamType__6);
			i__4 = i__4 + 1;
		};
		FuncType__2 = ZTypePool_LookupFuncType__1qwx(TypeList__3);
		if (!FuncType__2->IsVarType(FuncType__2)) {
			this->ResolvedFuncType = FuncType__2;
		};
		return FuncType__2;
	};
	return this->ResolvedFuncType;
}
static const char * GetSignature__2qtq(struct ZFunctionNode144 * this, struct ZGenerator55 * Generator__1) {
	struct ZFuncType90 * FuncType__2 = GetFuncType__2qtq(this, NULL);
	if (this->FuncName == NULL) {
		this->FuncName = LibZen_StrCat("f_Z", LibZen_IntToString(GetUniqueNumber__1qwk(Generator__1)));
	};
	return StringfySignature__2qej(FuncType__2, this->FuncName);
}
static struct ZFunctionNode144 * Push__2qtq(struct ZFunctionNode144 * this, struct ZFunctionNode144 * Parent__1) {
	this->ParentFunctionNode = Parent__1;
	return this;
}
static struct ZFunctionNode144 * Pop__1qtq(struct ZFunctionNode144 * this) {
	return this->ParentFunctionNode;
}
static int IsTopLevel__1qtq(struct ZFunctionNode144 * this) {
	return this->ParentFunctionNode == NULL;
}
static long GetVarIndex__1qtq(struct ZFunctionNode144 * this) {
	long Index__1 = this->VarIndex;
	this->VarIndex = this->VarIndex + 1;
	return Index__1;
}
static struct ZVarNode502 * ZVarNode__2qs2(struct ZVarNode502 * this, struct ZNode52 * ParentNode__1) {
	(void)ZBlockNode__3qth(this, ParentNode__1, 1);
	return NULL;
}
static void SetNameInfo__3qs2(struct ZVarNode502 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->NativeName = Name__2;
	this->NameToken = NameToken__1;
	return;
}
static void SetTypeInfo__3qs2(struct ZVarNode502 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->DeclType = Type__2;
	this->TypeToken = TypeToken__1;
	return;
}
static void Accept__2qs2(struct ZVarNode502 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor__1, this);
	return;
}
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) AndPattern_Z82 = f83;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) AnnotationPattern_Z84 = f85;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ApplyPattern_Z86 = f87;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ArrayLiteralPattern_Z88 = f89;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) AssertPattern_Z90 = f91;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) AssignPattern_Z92 = f93;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) BinaryPattern_Z94 = f95;
static int (*)(struct ZSourceContext50 *) BlockComment_Z96 = f97;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) BlockPattern_Z98 = f99;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) BreakPattern_Z100 = f101;
static int (*)(struct ZSourceContext50 *) CLineComment_Z102 = f103;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) CastPattern_Z104 = f105;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) CatchPattern_Z106 = f107;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ClassPattern_Z108 = f109;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ComparatorPattern_Z110 = f111;
static struct ZSyntax219 * ExpressionPattern_GetRightPattern__2qwa(struct ZNameSpace48 * NameSpace, struct ZTokenContext53 * TokenContext__1) {
	struct ZToken77 * Token__2 = GetToken__1qwh(TokenContext__1);
	if (Token__2 != ZToken_NullToken_Z52) {
		struct ZSyntax219 * Pattern__3 = GetRightSyntaxPattern__2qwa(NameSpace, GetText__1qey(Token__2));
		return Pattern__3;
	};
	return NULL;
}
static struct ZNode52 * ExpressionPattern_DispatchPattern__5qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2, int AllowStatement__3, int AllowBinary__4) {
	struct ZToken77 * Token__5 = GetToken__1qwh(TokenContext__1);
	struct ZSyntax219 * Pattern__6 = NULL;
	struct ZNameSpace48 * NameSpace__7 = GetNameSpace__1qwg(ParentNode);
	if (LibZen_Is(Token__5, 461)) {
		Pattern__6 = ((struct ZPatternToken461 *)Token__5)->PresetPattern;
	} else {
		Pattern__6 = GetSyntaxPattern__2qwa(NameSpace__7, GetText__1qey(Token__5));
	};
	if (Pattern__6 != NULL) {
		if (Pattern__6->IsStatement && !AllowStatement__3) {
			return ZErrorNode__4qp4(_NewZErrorNode335(), ParentNode, Token__5, LibZen_StrCat(GetText__1qey(Token__5), " statement is not here"));
		};
		LeftNode__2 = ApplyMatchPattern__5qwh(TokenContext__1, ParentNode, LeftNode__2, Pattern__6, ZTokenContext_Required_Z53);
	} else {
		if (IsNameSymbol__1qey(Token__5)) {
			if (AllowStatement__3) {
				Pattern__6 = GetSyntaxPattern__2qwa(NameSpace__7, "$SymbolStatement$");
			} else {
				Pattern__6 = GetSyntaxPattern__2qwa(NameSpace__7, "$SymbolExpression$");
			};
			LeftNode__2 = ApplyMatchPattern__5qwh(TokenContext__1, ParentNode, LeftNode__2, Pattern__6, ZTokenContext_Required_Z53);
		} else {
			if (AllowStatement__3) {
				return CreateExpectedErrorNode__3qwh(TokenContext__1, Token__5, "statement");
			} else {
				return CreateExpectedErrorNode__3qwh(TokenContext__1, Token__5, "expression");
			};
		};
	};
	if (!Pattern__6->IsStatement) {
		while (LeftNode__2 != NULL && !IsErrorNode__1qwg(LeftNode__2)) {
			struct ZSyntax219 * RightPattern__8 = ExpressionPattern_GetRightPattern__2qwa(NameSpace__7, TokenContext__1);
			if (RightPattern__8 == NULL) {
				break;
			};
			if (!AllowBinary__4 && IsBinaryOperator__1qur(RightPattern__8)) {
				break;
			};
			LeftNode__2 = ApplyMatchPattern__5qwh(TokenContext__1, ParentNode, LeftNode__2, RightPattern__8, ZTokenContext_Required_Z53);
		};
	};
	return LeftNode__2;
}
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ExpressionPattern_Z112 = f113;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) FalsePattern_Z114 = f115;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) FieldPattern_Z116 = f117;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) FloatLiteralPattern_Z118 = f119;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) FunctionPattern_Z120 = f121;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) GetIndexPattern_Z122 = f123;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) GetterPattern_Z124 = f125;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) GroupPattern_Z126 = f127;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) IfPattern_Z128 = f129;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) InstanceOfPattern_Z130 = f131;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) IntLiteralPattern_Z132 = f133;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) LetPattern_Z134 = f135;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) MapEntryPattern_Z136 = f137;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) MapLiteralPattern_Z138 = f139;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) MethodCallPattern_Z140 = f141;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) NamePattern_Z142 = f143;
static int (*)(struct ZSourceContext50 *) NameToken_Z144 = f145;
static int (*)(struct ZSourceContext50 *) NewLineToken_Z146 = f147;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) NewObjectPattern_Z148 = f149;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) NotPattern_Z150 = f151;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) NullPattern_Z152 = f153;
static const char * NumberLiteralToken_ParseDigit__1qwd(struct ZSourceContext50 * SourceContext) {
	const char * ch__1 = "0";
	while (HasChar__1qwd(SourceContext)) {
		ch__1 = GetCurrentChar__1qwd(SourceContext);
		if (!LibZen_IsDigit__1qqy(ch__1)) {
			break;
		};
		MoveNext__1qwd(SourceContext);
	};
	return ch__1;
}
static int (*)(struct ZSourceContext50 *) NumberLiteralToken_Z154 = f155;
static int (*)(struct ZSourceContext50 *) OperatorToken_Z156 = f157;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) OrPattern_Z158 = f159;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ParamPattern_Z160 = f161;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) PrototypePattern_Z162 = f163;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ReturnPattern_Z164 = f165;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) RightExpressionPattern_Z166 = f167;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) RightTypePattern_Z168 = f169;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) SetIndexPattern_Z170 = f171;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) SetterPattern_Z172 = f173;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) StatementEndPattern_Z174 = f175;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) StatementPattern_Z176 = f177;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) StringLiteralPattern_Z178 = f179;
static int (*)(struct ZSourceContext50 *) StringLiteralToken_Z180 = f181;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) SymbolExpressionPattern_Z182 = f183;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) SymbolStatementPattern_Z184 = f185;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) ThrowPattern_Z186 = f187;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) TruePattern_Z188 = f189;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) TryPattern_Z190 = f191;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) TypeAnnotationPattern_Z192 = f193;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) TypePattern_Z194 = f195;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) UnaryPattern_Z196 = f197;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) VarPattern_Z198 = f199;
static struct ZNode52 * (*)(struct ZNode52 *,struct ZTokenContext53 *,struct ZNode52 *) WhilePattern_Z200 = f201;
static int (*)(struct ZSourceContext50 *) WhiteSpaceToken_Z202 = f203;

