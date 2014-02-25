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
static struct ZGeneric1Type107 * ZGeneric1Type__5qe8(struct ZGeneric1Type107 * this, long TypeFlag__1, const char * ShortName__2, struct ZType60 * BaseType__3, struct ZType60 * ParamType__4);
static struct ZType60 * GetSuperType__1qe8(struct ZGeneric1Type107 * this);
#define _ZGeneric1Type107_GetSuperType
static struct ZType60 * GetBaseType__1qe8(struct ZGeneric1Type107 * this);
#define _ZGeneric1Type107_GetBaseType
static long GetParamSize__1qe8(struct ZGeneric1Type107 * this);
#define _ZGeneric1Type107_GetParamSize
static struct ZType60 * GetParamType__2qe8(struct ZGeneric1Type107 * this, long Index__1);
#define _ZGeneric1Type107_GetParamType
static int IsGreekType__1qe8(struct ZGeneric1Type107 * this);
#define _ZGeneric1Type107_IsGreekType
static struct ZType60 * GetGreekRealType__2qe8(struct ZGeneric1Type107 * this, ArrayOfZType * Greek__1);
#define _ZGeneric1Type107_GetGreekRealType
static int AcceptValueType__4qe8(struct ZGeneric1Type107 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZGeneric1Type107_AcceptValueType
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
static void SetLocalVariable__5qwa(struct ZNameSpace48 * this, struct ZFunctionNode144 * FunctionNode__1, struct ZType60 * VarType__2, const char * VarName__3, struct ZToken77 * SourceToken__4);
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
static const char * toString__1qq8(struct ZTokenFunc35 * this);
static struct ZVariable230 * ZVariable__7qud(struct ZVariable230 * this, struct ZSymbolEntry225 * Parent__1, struct ZFunctionNode144 * FuncNode__2, long VarFlag__3, struct ZType60 * VarType__4, const char * VarName__5, struct ZToken77 * SourceToken__6);
static int IsCaptured__2qud(struct ZVariable230 * this, struct ZFunctionNode144 * CurrentFunctionNode__1);
static void Defined__1qud(struct ZVariable230 * this);
static void Used__1qud(struct ZVariable230 * this);
static struct ZArrayType300 * ZArrayType__3qoa(struct ZArrayType300 * this, long TypeFlag__1, struct ZType60 * ParamType__2);
static struct ZAnnotationNode302 * ZAnnotationNode__4qod(struct ZAnnotationNode302 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, MapOfObject * Anno__3);
static int IsBreakingBlock__1qod(struct ZAnnotationNode302 * this);
#define _ZAnnotationNode302_IsBreakingBlock
static void Accept__2qod(struct ZAnnotationNode302 * this, struct ZVisitor167 * Visitor__1);
#define _ZAnnotationNode302_Accept
static struct ZAssertNode308 * ZAssertNode__2qol(struct ZAssertNode308 * this, struct ZNode52 * ParentNode__1);
static struct ZSugarNode165 * DeSugar__2qol(struct ZAssertNode308 * this, struct ZGenerator55 * Generator__1);
#define _ZAssertNode308_DeSugar
static struct ZBinaryNode311 * ZBinaryNode__5qo6(struct ZBinaryNode311 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static int IsRightJoin__2qo6(struct ZBinaryNode311 * this, struct ZNode52 * Node__1);
static struct ZNode52 * RightJoin__3qo6(struct ZBinaryNode311 * this, struct ZNode52 * ParentNode__1, struct ZBinaryNode311 * RightNode__2);
static struct ZNode52 * AppendParsedRightNode__3qo6(struct ZBinaryNode311 * this, struct ZNode52 * ParentNode__1, struct ZTokenContext53 * TokenContext__2);
static struct ZNode52 * TryMacroNode__2qo6(struct ZBinaryNode311 * this, struct ZGenerator55 * Generator__1);
static void Accept__2qo6(struct ZBinaryNode311 * this, struct ZVisitor167 * Visitor__1);
#define _ZBinaryNode311_Accept
static struct ZBreakNode318 * ZBreakNode__2qom(struct ZBreakNode318 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qom(struct ZBreakNode318 * this, struct ZVisitor167 * Visitor__1);
#define _ZBreakNode318_Accept
static struct ZCastNode321 * ZCastNode__4qo3(struct ZCastNode321 * this, struct ZNode52 * ParentNode__1, struct ZType60 * CastType__2, struct ZNode52 * Node__3);
static void Accept__2qo3(struct ZCastNode321 * this, struct ZVisitor167 * Visitor__1);
#define _ZCastNode321_Accept
static struct ZListNode251 * ToFuncCallNode__2qo3(struct ZCastNode321 * this, struct ZFunc89 * Func__1);
static struct ZCatchNode325 * ZCatchNode__2qpw(struct ZCatchNode325 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3qpw(struct ZCatchNode325 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZCatchNode325_SetTypeInfo
static void SetNameInfo__3qpw(struct ZCatchNode325 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZCatchNode325_SetNameInfo
static struct ZComparatorNode329 * ZComparatorNode__5qpy(struct ZComparatorNode329 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static void Accept__2qpy(struct ZComparatorNode329 * this, struct ZVisitor167 * Visitor__1);
#define _ZComparatorNode329_Accept
static struct ZConstNode332 * ZConstNode__3qpo(struct ZConstNode332 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2);
static struct ZEmptyNode334 * ZEmptyNode__3qp0(struct ZEmptyNode334 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2);
static struct ZErrorNode336 * ZErrorNode__4qpa(struct ZErrorNode336 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, const char * ErrorMessage__3);
static struct ZErrorNode336 * ZErrorNode__3qpa(struct ZErrorNode336 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2);
static void Accept__2qpa(struct ZErrorNode336 * this, struct ZVisitor167 * Visitor__1);
#define _ZErrorNode336_Accept
static struct ZFieldNode340 * ZFieldNode__2qpg(struct ZFieldNode340 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3qpg(struct ZFieldNode340 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZFieldNode340_SetTypeInfo
static void SetNameInfo__3qpg(struct ZFieldNode340 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZFieldNode340_SetNameInfo
static struct ZFloatNode344 * ZFloatNode__4qpl(struct ZFloatNode344 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, double Value__3);
static void Accept__2qpl(struct ZFloatNode344 * this, struct ZVisitor167 * Visitor__1);
#define _ZFloatNode344_Accept
static struct ZGetIndexNode347 * ZGetIndexNode__3qp6(struct ZGetIndexNode347 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2);
static void Accept__2qp6(struct ZGetIndexNode347 * this, struct ZVisitor167 * Visitor__1);
#define _ZGetIndexNode347_Accept
static struct ZGetNameNode350 * ZGetNameNode__4qpc(struct ZGetNameNode350 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * NativeName__3);
static struct ZGetNameNode350 * ZGetNameNode__3qpc(struct ZGetNameNode350 * this, struct ZNode52 * ParentNode__1, struct ZFunc89 * ResolvedFunc__2);
static void Accept__2qpc(struct ZGetNameNode350 * this, struct ZVisitor167 * Visitor__1);
#define _ZGetNameNode350_Accept
static struct ZNode52 * ToGlobalNameNode__1qpc(struct ZGetNameNode350 * this);
static struct ZGetterNode355 * ZGetterNode__3qp7(struct ZGetterNode355 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2);
static void SetNameInfo__3qp7(struct ZGetterNode355 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZGetterNode355_SetNameInfo
static void Accept__2qp7(struct ZGetterNode355 * this, struct ZVisitor167 * Visitor__1);
#define _ZGetterNode355_Accept
static int IsStaticField__1qp7(struct ZGetterNode355 * this);
static struct ZGlobalNameNode360 * ZGlobalNameNode__6q0q(struct ZGlobalNameNode360 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5);
static int IsGivenName__1q0q(struct ZGlobalNameNode360 * this);
static void Accept__2q0q(struct ZGlobalNameNode360 * this, struct ZVisitor167 * Visitor__1);
#define _ZGlobalNameNode360_Accept
static struct ZGroupNode364 * ZGroupNode__2q0t(struct ZGroupNode364 * this, struct ZNode52 * ParentNode__1);
static void Accept__2q0t(struct ZGroupNode364 * this, struct ZVisitor167 * Visitor__1);
#define _ZGroupNode364_Accept
static struct ZIfNode367 * ZIfNode__2q0i(struct ZIfNode367 * this, struct ZNode52 * ParentNode__1);
static void Accept__2q0i(struct ZIfNode367 * this, struct ZVisitor167 * Visitor__1);
#define _ZIfNode367_Accept
static struct ZImportNode370 * ZImportNode__2q00(struct ZImportNode370 * this, struct ZNode52 * ParentNode__1);
static void SetNameInfo__3q00(struct ZImportNode370 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZImportNode370_SetNameInfo
static struct ZInstanceOfNode373 * ZInstanceOfNode__4q0s(struct ZInstanceOfNode373 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * LeftNode__3);
static void SetTypeInfo__3q0s(struct ZInstanceOfNode373 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZInstanceOfNode373_SetTypeInfo
static void Accept__2q0s(struct ZInstanceOfNode373 * this, struct ZVisitor167 * Visitor__1);
#define _ZInstanceOfNode373_Accept
static struct ZIntNode377 * ZIntNode__4q0h(struct ZIntNode377 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, long Value__3);
static void Accept__2q0h(struct ZIntNode377 * this, struct ZVisitor167 * Visitor__1);
#define _ZIntNode377_Accept
static struct ZLetNode380 * ZLetNode__2q0l(struct ZLetNode380 * this, struct ZNode52 * ParentNode__1);
static void SetNameInfo__3q0l(struct ZLetNode380 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZLetNode380_SetNameInfo
static void SetTypeInfo__3q0l(struct ZLetNode380 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZLetNode380_SetTypeInfo
static void Accept__2q0l(struct ZLetNode380 * this, struct ZVisitor167 * Visitor__1);
#define _ZLetNode380_Accept
static struct ZGlobalNameNode360 * ToGlobalNameNode__1q0l(struct ZLetNode380 * this);
static struct ZListNode251 * ZListNode__4qu8(struct ZListNode251 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, long Size__3);
static void Append__2qu8(struct ZListNode251 * this, struct ZNode52 * Node__1);
static long GetListSize__1qu8(struct ZListNode251 * this);
static struct ZNode52 * GetListAt__2qu8(struct ZListNode251 * this, long Index__1);
static void SetListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2);
static void InsertListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2);
static struct ZNode52 * RemoveListAt__2qu8(struct ZListNode251 * this, long Index__1);
static void ClearListAfter__2qu8(struct ZListNode251 * this, long Size__1);
static struct ZMacroNode392 * ZMacroNode__4q05(struct ZMacroNode392 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZMacroFunc210 * MacroFunc__3);
static struct ZFuncType90 * GetFuncType__1q05(struct ZMacroNode392 * this);
static const char * GetMacroText__1q05(struct ZMacroNode392 * this);
static void Accept__2q05(struct ZMacroNode392 * this, struct ZVisitor167 * Visitor__1);
#define _ZMacroNode392_Accept
static struct ZMapEntryNode397 * ZMapEntryNode__2q4w(struct ZMapEntryNode397 * this, struct ZNode52 * ParentNode__1);
static struct ZMapLiteralNode399 * ZMapLiteralNode__2q4r(struct ZMapLiteralNode399 * this, struct ZNode52 * ParentNode__1);
static struct ZMapEntryNode397 * GetMapEntryNode__2q4r(struct ZMapLiteralNode399 * this, long Index__1);
static void Accept__2q4r(struct ZMapLiteralNode399 * this, struct ZVisitor167 * Visitor__1);
#define _ZMapLiteralNode399_Accept
static struct ZMethodCallNode403 * ZMethodCallNode__3q4i(struct ZMethodCallNode403 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2);
static void SetNameInfo__3q4i(struct ZMethodCallNode403 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZMethodCallNode403_SetNameInfo
static void Accept__2q4i(struct ZMethodCallNode403 * this, struct ZVisitor167 * Visitor__1);
#define _ZMethodCallNode403_Accept
static struct ZFuncCallNode407 * ToGetterFuncCall__1q4i(struct ZMethodCallNode403 * this);
static struct ZListNode251 * ToFuncCallNode__2q4i(struct ZMethodCallNode403 * this, struct ZFunc89 * Func__1);
static struct ZNewArrayNode410 * ZNewArrayNode__4q4d(struct ZNewArrayNode410 * this, struct ZNode52 * ParentNode__1, struct ZType60 * Type__2, struct ZToken77 * Token__3);
static struct ZNewObjectNode412 * ZNewObjectNode__2q4g(struct ZNewObjectNode412 * this, struct ZNode52 * ParentNode__1);
static void Accept__2q4g(struct ZNewObjectNode412 * this, struct ZVisitor167 * Visitor__1);
#define _ZNewObjectNode412_Accept
static struct ZListNode251 * ToFuncCallNode__2q4g(struct ZNewObjectNode412 * this, struct ZFunc89 * Func__1);
static struct ZNotNode416 * ZNotNode__3q4l(struct ZNotNode416 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2);
static void Accept__2q4l(struct ZNotNode416 * this, struct ZVisitor167 * Visitor__1);
#define _ZNotNode416_Accept
static struct ZNullNode419 * ZNullNode__3q46(struct ZNullNode419 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2);
static void Accept__2q46(struct ZNullNode419 * this, struct ZVisitor167 * Visitor__1);
#define _ZNullNode419_Accept
static struct ZOrNode422 * ZOrNode__5q4c(struct ZOrNode422 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static void Accept__2q4c(struct ZOrNode422 * this, struct ZVisitor167 * Visitor__1);
#define _ZOrNode422_Accept
static struct ZPrototypeNode425 * ZPrototypeNode__2q4n(struct ZPrototypeNode425 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3q4n(struct ZPrototypeNode425 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZPrototypeNode425_SetTypeInfo
static void SetNameInfo__3q4n(struct ZPrototypeNode425 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZPrototypeNode425_SetNameInfo
static struct ZParamNode172 * GetParamNode__2q4n(struct ZPrototypeNode425 * this, long Index__1);
static struct ZFuncType90 * GetFuncType__1q4n(struct ZPrototypeNode425 * this);
static struct ZStringNode431 * ZStringNode__4q48(struct ZStringNode431 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * Value__3);
static void Accept__2q48(struct ZStringNode431 * this, struct ZVisitor167 * Visitor__1);
#define _ZStringNode431_Accept
static struct ZStupidCastErrorNode434 * ZStupidCastErrorNode__3qae(struct ZStupidCastErrorNode434 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2);
static struct ZTypeNode235 * ZTypeNode__4quk(struct ZTypeNode235 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * ParsedType__3);
static struct ZGenerator55 * ZGenerator__3qwk(struct ZGenerator55 * this, const char * LanguageExtension__1, const char * TargetVersion__2);
static void ImportLocalGrammar__2qwk(struct ZGenerator55 * this, struct ZNameSpace48 * NameSpace__1);
#define _ZGenerator55_ImportLocalGrammar
static void WriteTo__2qwk(struct ZGenerator55 * this, const char * FileName__1);
#define _ZGenerator55_WriteTo
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
static struct ZIndentToken460 * ZIndentToken__4qab(struct ZIndentToken460 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3);
static struct ZPatternToken462 * ZPatternToken__5qam(struct ZPatternToken462 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax219 * PresetPattern__4);
static struct ZSourceEngine57 * ZSourceEngine__3qw9(struct ZSourceEngine57 * this, struct ZTypeChecker142 * TypeChecker__1, struct ZGenerator55 * Generator__2);
static int IsVisitable__1qw9(struct ZSourceEngine57 * this);
#define _ZSourceEngine57_IsVisitable
static void EnableVisitor__1qw9(struct ZSourceEngine57 * this);
#define _ZSourceEngine57_EnableVisitor
static void StopVisitor__1qw9(struct ZSourceEngine57 * this);
#define _ZSourceEngine57_StopVisitor
static struct Object303 * Eval__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1);
static void VisitPrototypeNode__2qw9(struct ZSourceEngine57 * this, struct ZPrototypeNode425 * Node__1);
static void VisitImportNode__2qw9(struct ZSourceEngine57 * this, struct ZImportNode370 * Node__1);
static struct Object303 * Exec__3qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1, int IsInteractive__2);
static struct Object303 * Eval__6qw9(struct ZSourceEngine57 * this, struct ZNameSpace48 * NameSpace__1, const char * ScriptText__2, const char * FileName__3, long LineNumber__4, int IsInteractive__5);
static struct Object303 * Eval__5qw9(struct ZSourceEngine57 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3, int IsInteractive__4);
static int Load__2qw9(struct ZSourceEngine57 * this, const char * FileName__1);
static void Unsupported__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1);
static void VisitNullNode__2qw9(struct ZSourceEngine57 * this, struct ZNullNode419 * Node__1);
#define _ZSourceEngine57_VisitNullNode
static void VisitBooleanNode__2qw9(struct ZSourceEngine57 * this, struct ZBooleanNode476 * Node__1);
#define _ZSourceEngine57_VisitBooleanNode
static void VisitIntNode__2qw9(struct ZSourceEngine57 * this, struct ZIntNode377 * Node__1);
#define _ZSourceEngine57_VisitIntNode
static void VisitFloatNode__2qw9(struct ZSourceEngine57 * this, struct ZFloatNode344 * Node__1);
#define _ZSourceEngine57_VisitFloatNode
static void VisitStringNode__2qw9(struct ZSourceEngine57 * this, struct ZStringNode431 * Node__1);
#define _ZSourceEngine57_VisitStringNode
static void VisitArrayLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZArrayLiteralNode481 * Node__1);
#define _ZSourceEngine57_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZMapLiteralNode399 * Node__1);
#define _ZSourceEngine57_VisitMapLiteralNode
static void VisitNewObjectNode__2qw9(struct ZSourceEngine57 * this, struct ZNewObjectNode412 * Node__1);
#define _ZSourceEngine57_VisitNewObjectNode
static void VisitGlobalNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGlobalNameNode360 * Node__1);
#define _ZSourceEngine57_VisitGlobalNameNode
static void VisitGetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGetNameNode350 * Node__1);
#define _ZSourceEngine57_VisitGetNameNode
static void VisitSetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZSetNameNode181 * Node__1);
#define _ZSourceEngine57_VisitSetNameNode
static void VisitGroupNode__2qw9(struct ZSourceEngine57 * this, struct ZGroupNode364 * Node__1);
#define _ZSourceEngine57_VisitGroupNode
static void VisitGetterNode__2qw9(struct ZSourceEngine57 * this, struct ZGetterNode355 * Node__1);
#define _ZSourceEngine57_VisitGetterNode
static void VisitSetterNode__2qw9(struct ZSourceEngine57 * this, struct ZSetterNode184 * Node__1);
#define _ZSourceEngine57_VisitSetterNode
static void VisitGetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZGetIndexNode347 * Node__1);
#define _ZSourceEngine57_VisitGetIndexNode
static void VisitSetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZSetIndexNode178 * Node__1);
#define _ZSourceEngine57_VisitSetIndexNode
static void VisitMacroNode__2qw9(struct ZSourceEngine57 * this, struct ZMacroNode392 * Node__1);
#define _ZSourceEngine57_VisitMacroNode
static void VisitFuncCallNode__2qw9(struct ZSourceEngine57 * this, struct ZFuncCallNode407 * Node__1);
#define _ZSourceEngine57_VisitFuncCallNode
static void VisitMethodCallNode__2qw9(struct ZSourceEngine57 * this, struct ZMethodCallNode403 * Node__1);
#define _ZSourceEngine57_VisitMethodCallNode
static void VisitUnaryNode__2qw9(struct ZSourceEngine57 * this, struct ZUnaryNode197 * Node__1);
#define _ZSourceEngine57_VisitUnaryNode
static void VisitNotNode__2qw9(struct ZSourceEngine57 * this, struct ZNotNode416 * Node__1);
#define _ZSourceEngine57_VisitNotNode
static void VisitCastNode__2qw9(struct ZSourceEngine57 * this, struct ZCastNode321 * Node__1);
#define _ZSourceEngine57_VisitCastNode
static void VisitInstanceOfNode__2qw9(struct ZSourceEngine57 * this, struct ZInstanceOfNode373 * Node__1);
#define _ZSourceEngine57_VisitInstanceOfNode
static void VisitBinaryNode__2qw9(struct ZSourceEngine57 * this, struct ZBinaryNode311 * Node__1);
#define _ZSourceEngine57_VisitBinaryNode
static void VisitComparatorNode__2qw9(struct ZSourceEngine57 * this, struct ZComparatorNode329 * Node__1);
#define _ZSourceEngine57_VisitComparatorNode
static void VisitAndNode__2qw9(struct ZSourceEngine57 * this, struct ZAndNode502 * Node__1);
#define _ZSourceEngine57_VisitAndNode
static void VisitOrNode__2qw9(struct ZSourceEngine57 * this, struct ZOrNode422 * Node__1);
#define _ZSourceEngine57_VisitOrNode
static void VisitBlockNode__2qw9(struct ZSourceEngine57 * this, struct ZBlockNode161 * Node__1);
#define _ZSourceEngine57_VisitBlockNode
static void VisitVarNode__2qw9(struct ZSourceEngine57 * this, struct ZVarNode506 * Node__1);
#define _ZSourceEngine57_VisitVarNode
static void VisitIfNode__2qw9(struct ZSourceEngine57 * this, struct ZIfNode367 * Node__1);
#define _ZSourceEngine57_VisitIfNode
static void VisitReturnNode__2qw9(struct ZSourceEngine57 * this, struct ZReturnNode170 * Node__1);
#define _ZSourceEngine57_VisitReturnNode
static void VisitWhileNode__2qw9(struct ZSourceEngine57 * this, struct ZWhileNode200 * Node__1);
#define _ZSourceEngine57_VisitWhileNode
static void VisitBreakNode__2qw9(struct ZSourceEngine57 * this, struct ZBreakNode318 * Node__1);
#define _ZSourceEngine57_VisitBreakNode
static void VisitThrowNode__2qw9(struct ZSourceEngine57 * this, struct ZThrowNode191 * Node__1);
#define _ZSourceEngine57_VisitThrowNode
static void VisitTryNode__2qw9(struct ZSourceEngine57 * this, struct ZTryNode194 * Node__1);
#define _ZSourceEngine57_VisitTryNode
static void VisitLetNode__2qw9(struct ZSourceEngine57 * this, struct ZLetNode380 * Node__1);
#define _ZSourceEngine57_VisitLetNode
static void VisitFunctionNode__2qw9(struct ZSourceEngine57 * this, struct ZFunctionNode144 * Node__1);
#define _ZSourceEngine57_VisitFunctionNode
static void VisitClassNode__2qw9(struct ZSourceEngine57 * this, struct ZClassNode516 * Node__1);
#define _ZSourceEngine57_VisitClassNode
static void VisitErrorNode__2qw9(struct ZSourceEngine57 * this, struct ZErrorNode336 * Node__1);
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
static const char * GetNativeType__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1);
static void SetReservedName__3quv(struct ZSourceGenerator243 * this, const char * Keyword__1, const char * AnotherName__2);
static const char * SafeName__3quv(struct ZSourceGenerator243 * this, const char * Name__1, long Index__2);
static void SetMacro__4quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3);
static void SetMacro__5quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4);
static void SetMacro__6quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5);
static void SetMacro__7quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5, struct ZType60 * P3__6);
static void SetConverterMacro__4quv(struct ZSourceGenerator243 * this, const char * Macro__1, struct ZType60 * ReturnType__2, struct ZType60 * P1__3);
static void WriteTo__2quv(struct ZSourceGenerator243 * this, const char * FileName__1);
#define _ZSourceGenerator243_WriteTo
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
static void VisitNullNode__2quv(struct ZSourceGenerator243 * this, struct ZNullNode419 * Node__1);
#define _ZSourceGenerator243_VisitNullNode
static void VisitBooleanNode__2quv(struct ZSourceGenerator243 * this, struct ZBooleanNode476 * Node__1);
#define _ZSourceGenerator243_VisitBooleanNode
static void VisitIntNode__2quv(struct ZSourceGenerator243 * this, struct ZIntNode377 * Node__1);
#define _ZSourceGenerator243_VisitIntNode
static void VisitFloatNode__2quv(struct ZSourceGenerator243 * this, struct ZFloatNode344 * Node__1);
#define _ZSourceGenerator243_VisitFloatNode
static void VisitStringNode__2quv(struct ZSourceGenerator243 * this, struct ZStringNode431 * Node__1);
#define _ZSourceGenerator243_VisitStringNode
static void VisitArrayLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZArrayLiteralNode481 * Node__1);
#define _ZSourceGenerator243_VisitArrayLiteralNode
static void VisitMapLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZMapLiteralNode399 * Node__1);
#define _ZSourceGenerator243_VisitMapLiteralNode
static void VisitNewObjectNode__2quv(struct ZSourceGenerator243 * this, struct ZNewObjectNode412 * Node__1);
#define _ZSourceGenerator243_VisitNewObjectNode
static void VisitGroupNode__2quv(struct ZSourceGenerator243 * this, struct ZGroupNode364 * Node__1);
#define _ZSourceGenerator243_VisitGroupNode
static void VisitGetIndexNode__2quv(struct ZSourceGenerator243 * this, struct ZGetIndexNode347 * Node__1);
#define _ZSourceGenerator243_VisitGetIndexNode
static void VisitSetIndexNode__2quv(struct ZSourceGenerator243 * this, struct ZSetIndexNode178 * Node__1);
#define _ZSourceGenerator243_VisitSetIndexNode
static void VisitGlobalNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGlobalNameNode360 * Node__1);
#define _ZSourceGenerator243_VisitGlobalNameNode
static void VisitGetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGetNameNode350 * Node__1);
#define _ZSourceGenerator243_VisitGetNameNode
static void VisitSetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZSetNameNode181 * Node__1);
#define _ZSourceGenerator243_VisitSetNameNode
static void VisitGetterNode__2quv(struct ZSourceGenerator243 * this, struct ZGetterNode355 * Node__1);
#define _ZSourceGenerator243_VisitGetterNode
static void VisitSetterNode__2quv(struct ZSourceGenerator243 * this, struct ZSetterNode184 * Node__1);
#define _ZSourceGenerator243_VisitSetterNode
static void VisitMethodCallNode__2quv(struct ZSourceGenerator243 * this, struct ZMethodCallNode403 * Node__1);
#define _ZSourceGenerator243_VisitMethodCallNode
static void VisitMacroNode__2quv(struct ZSourceGenerator243 * this, struct ZMacroNode392 * Node__1);
#define _ZSourceGenerator243_VisitMacroNode
static void VisitFuncCallNode__2quv(struct ZSourceGenerator243 * this, struct ZFuncCallNode407 * Node__1);
#define _ZSourceGenerator243_VisitFuncCallNode
static void VisitUnaryNode__2quv(struct ZSourceGenerator243 * this, struct ZUnaryNode197 * Node__1);
#define _ZSourceGenerator243_VisitUnaryNode
static void VisitNotNode__2quv(struct ZSourceGenerator243 * this, struct ZNotNode416 * Node__1);
#define _ZSourceGenerator243_VisitNotNode
static void VisitCastNode__2quv(struct ZSourceGenerator243 * this, struct ZCastNode321 * Node__1);
#define _ZSourceGenerator243_VisitCastNode
static void VisitInstanceOfNode__2quv(struct ZSourceGenerator243 * this, struct ZInstanceOfNode373 * Node__1);
#define _ZSourceGenerator243_VisitInstanceOfNode
static void VisitBinaryNode__2quv(struct ZSourceGenerator243 * this, struct ZBinaryNode311 * Node__1);
#define _ZSourceGenerator243_VisitBinaryNode
static void VisitComparatorNode__2quv(struct ZSourceGenerator243 * this, struct ZComparatorNode329 * Node__1);
#define _ZSourceGenerator243_VisitComparatorNode
static void VisitAndNode__2quv(struct ZSourceGenerator243 * this, struct ZAndNode502 * Node__1);
#define _ZSourceGenerator243_VisitAndNode
static void VisitOrNode__2quv(struct ZSourceGenerator243 * this, struct ZOrNode422 * Node__1);
#define _ZSourceGenerator243_VisitOrNode
static void VisitIfNode__2quv(struct ZSourceGenerator243 * this, struct ZIfNode367 * Node__1);
#define _ZSourceGenerator243_VisitIfNode
static void VisitReturnNode__2quv(struct ZSourceGenerator243 * this, struct ZReturnNode170 * Node__1);
#define _ZSourceGenerator243_VisitReturnNode
static void VisitWhileNode__2quv(struct ZSourceGenerator243 * this, struct ZWhileNode200 * Node__1);
#define _ZSourceGenerator243_VisitWhileNode
static void VisitBreakNode__2quv(struct ZSourceGenerator243 * this, struct ZBreakNode318 * Node__1);
#define _ZSourceGenerator243_VisitBreakNode
static void VisitThrowNode__2quv(struct ZSourceGenerator243 * this, struct ZThrowNode191 * Node__1);
#define _ZSourceGenerator243_VisitThrowNode
static void VisitTryNode__2quv(struct ZSourceGenerator243 * this, struct ZTryNode194 * Node__1);
#define _ZSourceGenerator243_VisitTryNode
static void VisitCatchNode__2quv(struct ZSourceGenerator243 * this, struct ZCatchNode325 * Node__1);
static void VisitVarNode__2quv(struct ZSourceGenerator243 * this, struct ZVarNode506 * Node__1);
#define _ZSourceGenerator243_VisitVarNode
static void VisitTypeAnnotation__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1);
static void VisitLetNode__2quv(struct ZSourceGenerator243 * this, struct ZLetNode380 * Node__1);
#define _ZSourceGenerator243_VisitLetNode
static void VisitParamNode__2quv(struct ZSourceGenerator243 * this, struct ZParamNode172 * Node__1);
static void VisitFunctionNode__2quv(struct ZSourceGenerator243 * this, struct ZFunctionNode144 * Node__1);
#define _ZSourceGenerator243_VisitFunctionNode
static void VisitClassNode__2quv(struct ZSourceGenerator243 * this, struct ZClassNode516 * Node__1);
#define _ZSourceGenerator243_VisitClassNode
static void VisitErrorNode__2quv(struct ZSourceGenerator243 * this, struct ZErrorNode336 * Node__1);
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
static void VisitErrorNode__2qr2(struct ZTypeChecker142 * this, struct ZErrorNode336 * Node__1);
#define _ZTypeChecker142_VisitErrorNode
static void VisitExtendedNode__2qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1);
#define _ZTypeChecker142_VisitExtendedNode
static void VisitSugarNode__2qr2(struct ZTypeChecker142 * this, struct ZSugarNode165 * Node__1);
#define _ZTypeChecker142_VisitSugarNode
static struct CSourceGenerator599 * CSourceGenerator__1qg6(struct CSourceGenerator599 * this);
static struct ZSourceEngine57 * GetEngine__1qg6(struct CSourceGenerator599 * this);
#define _CSourceGenerator599_GetEngine
static void GenerateCode__3qg6(struct CSourceGenerator599 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2);
#define _CSourceGenerator599_GenerateCode
static void VisitArrayLiteralNode__2qg6(struct CSourceGenerator599 * this, struct ZArrayLiteralNode481 * Node__1);
#define _CSourceGenerator599_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qg6(struct CSourceGenerator599 * this, struct ZMapLiteralNode399 * Node__1);
#define _CSourceGenerator599_VisitMapLiteralNode
static void VisitNewObjectNode__2qg6(struct CSourceGenerator599 * this, struct ZNewObjectNode412 * Node__1);
#define _CSourceGenerator599_VisitNewObjectNode
static const char * BaseName__2qg6(struct CSourceGenerator599 * this, struct ZType60 * RecvType__1);
static void VisitGetIndexNode__2qg6(struct CSourceGenerator599 * this, struct ZGetIndexNode347 * Node__1);
#define _CSourceGenerator599_VisitGetIndexNode
static void VisitSetIndexNode__2qg6(struct CSourceGenerator599 * this, struct ZSetIndexNode178 * Node__1);
#define _CSourceGenerator599_VisitSetIndexNode
static void VisitGetNameNode__2qg6(struct CSourceGenerator599 * this, struct ZGetNameNode350 * Node__1);
#define _CSourceGenerator599_VisitGetNameNode
static void VisitSetNameNode__2qg6(struct CSourceGenerator599 * this, struct ZSetNameNode181 * Node__1);
#define _CSourceGenerator599_VisitSetNameNode
static void VisitGetterNode__2qg6(struct CSourceGenerator599 * this, struct ZGetterNode355 * Node__1);
#define _CSourceGenerator599_VisitGetterNode
static void VisitSetterNode__2qg6(struct CSourceGenerator599 * this, struct ZSetterNode184 * Node__1);
#define _CSourceGenerator599_VisitSetterNode
static void VisitMethodCallNode__2qg6(struct CSourceGenerator599 * this, struct ZMethodCallNode403 * Node__1);
#define _CSourceGenerator599_VisitMethodCallNode
static void VisitFuncCallNode__2qg6(struct CSourceGenerator599 * this, struct ZFuncCallNode407 * Node__1);
#define _CSourceGenerator599_VisitFuncCallNode
static void VisitThrowNode__2qg6(struct CSourceGenerator599 * this, struct ZThrowNode191 * Node__1);
#define _CSourceGenerator599_VisitThrowNode
static void VisitTryNode__2qg6(struct CSourceGenerator599 * this, struct ZTryNode194 * Node__1);
#define _CSourceGenerator599_VisitTryNode
static void VisitCatchNode__2qg6(struct CSourceGenerator599 * this, struct ZCatchNode325 * Node__1);
static const char * ParamTypeName__2qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1);
static const char * GetNativeType__2qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1);
static void GenerateFuncTypeName__3qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1, const char * FuncName__2);
static void GenerateTypeName__2qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1);
static void VisitVarNode__2qg6(struct CSourceGenerator599 * this, struct ZVarNode506 * Node__1);
#define _CSourceGenerator599_VisitVarNode
static void VisitParamNode__2qg6(struct CSourceGenerator599 * this, struct ZParamNode172 * Node__1);
static void SetMethod__3qg6(struct CSourceGenerator599 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2);
static void VisitInstanceOfNode__2qg6(struct CSourceGenerator599 * this, struct ZInstanceOfNode373 * Node__1);
#define _CSourceGenerator599_VisitInstanceOfNode
static void GenerateCField__3qg6(struct CSourceGenerator599 * this, const char * CType__1, const char * FieldName__2);
static void GenerateField__3qg6(struct CSourceGenerator599 * this, struct ZType60 * DeclType__1, const char * FieldName__2);
static void GenerateFields__3qg6(struct CSourceGenerator599 * this, struct ZClassType80 * ClassType__1, struct ZType60 * ThisType__2);
static void VisitErrorNode__2qg6(struct CSourceGenerator599 * this, struct ZErrorNode336 * Node__1);
#define _CSourceGenerator599_VisitErrorNode
static struct ZAndNode502 * ZAndNode__5qs2(struct ZAndNode502 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4);
static void Accept__2qs2(struct ZAndNode502 * this, struct ZVisitor167 * Visitor__1);
#define _ZAndNode502_Accept
static struct ZArrayLiteralNode481 * ZArrayLiteralNode__2qss(struct ZArrayLiteralNode481 * this, struct ZNode52 * ParentNode__1);
static void Accept__2qss(struct ZArrayLiteralNode481 * this, struct ZVisitor167 * Visitor__1);
#define _ZArrayLiteralNode481_Accept
static struct ZBlockNode161 * ZBlockNode__2qth(struct ZBlockNode161 * this, struct ZNameSpace48 * NameSpace__1);
static struct ZBlockNode161 * ZBlockNode__3qth(struct ZBlockNode161 * this, struct ZNode52 * ParentNode__1, long Init__2);
static void Accept__2qth(struct ZBlockNode161 * this, struct ZVisitor167 * Visitor__1);
#define _ZBlockNode161_Accept
static struct ZReturnNode170 * ToReturnNode__1qth(struct ZBlockNode161 * this);
static long IndexOf__2qth(struct ZBlockNode161 * this, struct ZNode52 * ChildNode__1);
static void CopyTo__3qth(struct ZBlockNode161 * this, long Index__1, struct ZBlockNode161 * BlockNode__2);
static struct ZBooleanNode476 * ZBooleanNode__4qso(struct ZBooleanNode476 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, int Value__3);
static void Accept__2qso(struct ZBooleanNode476 * this, struct ZVisitor167 * Visitor__1);
#define _ZBooleanNode476_Accept
static struct ZClassNode516 * ZClassNode__2qda(struct ZClassNode516 * this, struct ZNode52 * ParentNode__1);
static void SetTypeInfo__3qda(struct ZClassNode516 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZClassNode516_SetTypeInfo
static void SetNameInfo__3qda(struct ZClassNode516 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZClassNode516_SetNameInfo
static struct ZFieldNode340 * GetFieldNode__2qda(struct ZClassNode516 * this, long Index__1);
static void Accept__2qda(struct ZClassNode516 * this, struct ZVisitor167 * Visitor__1);
#define _ZClassNode516_Accept
static struct ZFuncCallNode407 * ZFuncCallNode__3q44(struct ZFuncCallNode407 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * FuncNode__2);
static struct ZFuncCallNode407 * ZFuncCallNode__4q44(struct ZFuncCallNode407 * this, struct ZNode52 * ParentNode__1, const char * FuncName__2, struct ZType60 * FuncType__3);
static void Accept__2q44(struct ZFuncCallNode407 * this, struct ZVisitor167 * Visitor__1);
#define _ZFuncCallNode407_Accept
static struct ZType60 * GetRecvType__1q44(struct ZFuncCallNode407 * this);
static const char * GetFuncName__1q44(struct ZFuncCallNode407 * this);
static struct ZFuncType90 * GetFuncType__1q44(struct ZFuncCallNode407 * this);
static struct ZMacroNode392 * ToMacroNode__2q44(struct ZFuncCallNode407 * this, struct ZMacroFunc210 * MacroFunc__1);
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
static struct ZVarNode506 * ZVarNode__2qde(struct ZVarNode506 * this, struct ZNode52 * ParentNode__1);
static void SetNameInfo__3qde(struct ZVarNode506 * this, struct ZToken77 * NameToken__1, const char * Name__2);
#define _ZVarNode506_SetNameInfo
static void SetTypeInfo__3qde(struct ZVarNode506 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2);
#define _ZVarNode506_SetTypeInfo
static void Accept__2qde(struct ZVarNode506 * this, struct ZVisitor167 * Visitor__1);
#define _ZVarNode506_Accept
static struct ZNode52 * AndPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * AnnotationPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * ApplyPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * ArrayLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * AssertPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * AssignPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * BinaryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static int BlockComment__1qwd(struct ZSourceContext50 * SourceContext);
static struct ZNode52 * BlockPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * BreakPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static int CLineComment__1qwd(struct ZSourceContext50 * SourceContext);
static struct ZNode52 * CastPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * CatchPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * ClassPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * ComparatorPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZSyntax219 * ExpressionPattern_GetRightPattern__2qwa(struct ZNameSpace48 * NameSpace, struct ZTokenContext53 * TokenContext__1);
static struct ZNode52 * ExpressionPattern_DispatchPattern__5qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2, int AllowStatement__3, int AllowBinary__4);
static struct ZNode52 * ExpressionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * FalsePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * FieldPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * FloatLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * FunctionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * GetIndexPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * GetterPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * GroupPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * IfPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * InstanceOfPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * IntLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * LetPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * MapEntryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * MapLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * MethodCallPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * NamePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static int NameToken__1qwd(struct ZSourceContext50 * SourceContext);
static int NewLineToken__1qwd(struct ZSourceContext50 * SourceContext);
static struct ZNode52 * NewObjectPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * NotPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * NullPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static const char * NumberLiteralToken_ParseDigit__1qwd(struct ZSourceContext50 * SourceContext);
static int NumberLiteralToken__1qwd(struct ZSourceContext50 * SourceContext);
static int OperatorToken__1qwd(struct ZSourceContext50 * SourceContext);
static struct ZNode52 * OrPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * ParamPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * PrototypePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * ReturnPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * RightExpressionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * RightTypePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftTypeNode__2);
static struct ZNode52 * SetIndexPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * SetterPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * StatementEndPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * StatementPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * StringLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static int StringLiteralToken__1qwd(struct ZSourceContext50 * SourceContext);
static struct ZNode52 * SymbolExpressionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * SymbolStatementPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * ThrowPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * TruePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * TryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * TypeAnnotationPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * TypePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * UnaryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * VarPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static struct ZNode52 * WhilePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2);
static int WhiteSpaceToken__1qwd(struct ZSourceContext50 * SourceContext);

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
ThrowError("type error: requested = ZType, given = ZGeneric1Type")ThrowError("type error: requested = ZType, given = ZGeneric1Type")static struct ZFuncType90 * ZTypeFuncType_Z13 = ZFuncType__3qej(_NewZFuncType90(), "Func", NULL);
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

static const char * ZFunc_NativeNameConnector_Z14 = "__";
static long ZFunc_ConverterFunc_Z15 = 1 << 16;
static long ZFunc_CoercionFunc_Z16 = (1 << 17) | ZFunc_ConverterFunc_Z15;
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

struct ZGeneric1Type107 {
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

static void _InitZGeneric1Type107(struct ZGeneric1Type107 * o) {
	_InitZType60((struct ZType60 *)o);
	o->_classId107 = 107;
	o->_delta107 = sizeof(struct ZGeneric1Type107) - sizeof(struct ZType60);
	o->BaseType = NULL;
	o->ParamType = NULL;
#ifdef _ZGeneric1Type107_GetRealType
	o->GetRealType = GetRealType__1qe8
#endif
#ifdef _ZGeneric1Type107_GetSuperType
	o->GetSuperType = GetSuperType__1qe8
#endif
#ifdef _ZGeneric1Type107_GetBaseType
	o->GetBaseType = GetBaseType__1qe8
#endif
#ifdef _ZGeneric1Type107_GetParamSize
	o->GetParamSize = GetParamSize__1qe8
#endif
#ifdef _ZGeneric1Type107_GetParamType
	o->GetParamType = GetParamType__2qe8
#endif
#ifdef _ZGeneric1Type107_IsGreekType
	o->IsGreekType = IsGreekType__1qe8
#endif
#ifdef _ZGeneric1Type107_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qe8
#endif
#ifdef _ZGeneric1Type107_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qe8
#endif
#ifdef _ZGeneric1Type107_IsVarType
	o->IsVarType = IsVarType__1qe8
#endif
	o->_nextId = 0;
}

static struct ZGeneric1Type107 * _NewZGeneric1Type107(void) {
	struct ZGeneric1Type107 *o = LibZen_Malloc(sizeof(struct ZGeneric1Type107));
	_InitZGeneric1Type107(o);
	return o;
}

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

struct ZTypePool674 {
	int _classId674;
	int _delta674;
	int _nextId;
};

static void _InitZTypePool674(struct ZTypePool674 * o) {
	o->_classId674 = 674;
	o->_delta674 = sizeof(struct ZTypePool674) - sizeof(int);
	o->_nextId = 0;
}

static struct ZTypePool674 * _NewZTypePool674(void) {
	struct ZTypePool674 *o = LibZen_Malloc(sizeof(struct ZTypePool674));
	_InitZTypePool674(o);
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

struct ZParserConst679 {
	int _classId679;
	int _delta679;
	int _nextId;
};

static void _InitZParserConst679(struct ZParserConst679 * o) {
	o->_classId679 = 679;
	o->_delta679 = sizeof(struct ZParserConst679) - sizeof(int);
	o->_nextId = 0;
}

static struct ZParserConst679 * _NewZParserConst679(void) {
	struct ZParserConst679 *o = LibZen_Malloc(sizeof(struct ZParserConst679));
	_InitZParserConst679(o);
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
	void (*)(struct ZVisitor167 *,struct ZNullNode419 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode476 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode377 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode344 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode431 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode481 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode399 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode412 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode360 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode350 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode364 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode355 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode347 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode403 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode407 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode392 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode416 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode321 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode373 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode311 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode329 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode502 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode422 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode506 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode367 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode318 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode380 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode516 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode336 *) VisitErrorNode;
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

struct ZArrayType300 {
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
	int _classId300;
	int _delta300;
	int _nextId;
};

static void _InitZArrayType300(struct ZArrayType300 * o) {
	_InitZGeneric1Type107((struct ZGeneric1Type107 *)o);
	o->_classId300 = 300;
	o->_delta300 = sizeof(struct ZArrayType300) - sizeof(struct ZGeneric1Type107);
#ifdef _ZArrayType300_GetRealType
	o->GetRealType = GetRealType__1qoa
#endif
#ifdef _ZArrayType300_GetSuperType
	o->GetSuperType = GetSuperType__1qoa
#endif
#ifdef _ZArrayType300_GetBaseType
	o->GetBaseType = GetBaseType__1qoa
#endif
#ifdef _ZArrayType300_GetParamSize
	o->GetParamSize = GetParamSize__1qoa
#endif
#ifdef _ZArrayType300_GetParamType
	o->GetParamType = GetParamType__2qoa
#endif
#ifdef _ZArrayType300_IsGreekType
	o->IsGreekType = IsGreekType__1qoa
#endif
#ifdef _ZArrayType300_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qoa
#endif
#ifdef _ZArrayType300_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qoa
#endif
#ifdef _ZArrayType300_IsVarType
	o->IsVarType = IsVarType__1qoa
#endif
	o->_nextId = 0;
}

static struct ZArrayType300 * _NewZArrayType300(void) {
	struct ZArrayType300 *o = LibZen_Malloc(sizeof(struct ZArrayType300));
	_InitZArrayType300(o);
	return o;
}

struct ZAnnotationNode302 {
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
	int _classId302;
	int _delta302;
	struct ZNode52 * AnnotatedNode;
	int _nextId;
};

static void _InitZAnnotationNode302(struct ZAnnotationNode302 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId302 = 302;
	o->_delta302 = sizeof(struct ZAnnotationNode302) - sizeof(struct ZNode52);
	o->AnnotatedNode = NULL;
#ifdef _ZAnnotationNode302_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qod
#endif
#ifdef _ZAnnotationNode302_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qod
#endif
#ifdef _ZAnnotationNode302_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qod
#endif
#ifdef _ZAnnotationNode302_DeSugar
	o->DeSugar = DeSugar__2qod
#endif
#ifdef _ZAnnotationNode302_Accept
	o->Accept = Accept__2qod
#endif
	o->_nextId = 0;
}

static struct ZAnnotationNode302 * _NewZAnnotationNode302(void) {
	struct ZAnnotationNode302 *o = LibZen_Malloc(sizeof(struct ZAnnotationNode302));
	_InitZAnnotationNode302(o);
	return o;
}

struct ZAssertNode308 {
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
	int _classId308;
	int _delta308;
	int _nextId;
};

static void _InitZAssertNode308(struct ZAssertNode308 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId308 = 308;
	o->_delta308 = sizeof(struct ZAssertNode308) - sizeof(struct ZNode52);
#ifdef _ZAssertNode308_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qol
#endif
#ifdef _ZAssertNode308_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qol
#endif
#ifdef _ZAssertNode308_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qol
#endif
#ifdef _ZAssertNode308_DeSugar
	o->DeSugar = DeSugar__2qol
#endif
#ifdef _ZAssertNode308_Accept
	o->Accept = Accept__2qol
#endif
	o->_nextId = 0;
}

static struct ZAssertNode308 * _NewZAssertNode308(void) {
	struct ZAssertNode308 *o = LibZen_Malloc(sizeof(struct ZAssertNode308));
	_InitZAssertNode308(o);
	return o;
}

static long ZAssertNode_Expr_Z59 = 0;
struct ZBinaryNode311 {
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
	int _classId311;
	int _delta311;
	struct ZSyntax219 * Pattern;
	int _nextId;
};

static void _InitZBinaryNode311(struct ZBinaryNode311 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId311 = 311;
	o->_delta311 = sizeof(struct ZBinaryNode311) - sizeof(struct ZNode52);
	o->Pattern = NULL;
#ifdef _ZBinaryNode311_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo6
#endif
#ifdef _ZBinaryNode311_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo6
#endif
#ifdef _ZBinaryNode311_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo6
#endif
#ifdef _ZBinaryNode311_DeSugar
	o->DeSugar = DeSugar__2qo6
#endif
#ifdef _ZBinaryNode311_Accept
	o->Accept = Accept__2qo6
#endif
	o->_nextId = 0;
}

static struct ZBinaryNode311 * _NewZBinaryNode311(void) {
	struct ZBinaryNode311 *o = LibZen_Malloc(sizeof(struct ZBinaryNode311));
	_InitZBinaryNode311(o);
	return o;
}

static long ZBinaryNode_Left_Z60 = 0;
static long ZBinaryNode_Right_Z61 = 1;
struct ZBreakNode318 {
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
	int _classId318;
	int _delta318;
	int _nextId;
};

static void _InitZBreakNode318(struct ZBreakNode318 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId318 = 318;
	o->_delta318 = sizeof(struct ZBreakNode318) - sizeof(struct ZNode52);
#ifdef _ZBreakNode318_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qom
#endif
#ifdef _ZBreakNode318_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qom
#endif
#ifdef _ZBreakNode318_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qom
#endif
#ifdef _ZBreakNode318_DeSugar
	o->DeSugar = DeSugar__2qom
#endif
#ifdef _ZBreakNode318_Accept
	o->Accept = Accept__2qom
#endif
	o->_nextId = 0;
}

static struct ZBreakNode318 * _NewZBreakNode318(void) {
	struct ZBreakNode318 *o = LibZen_Malloc(sizeof(struct ZBreakNode318));
	_InitZBreakNode318(o);
	return o;
}

struct ZCastNode321 {
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
	int _classId321;
	int _delta321;
	int _nextId;
};

static void _InitZCastNode321(struct ZCastNode321 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId321 = 321;
	o->_delta321 = sizeof(struct ZCastNode321) - sizeof(struct ZNode52);
#ifdef _ZCastNode321_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo3
#endif
#ifdef _ZCastNode321_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo3
#endif
#ifdef _ZCastNode321_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo3
#endif
#ifdef _ZCastNode321_DeSugar
	o->DeSugar = DeSugar__2qo3
#endif
#ifdef _ZCastNode321_Accept
	o->Accept = Accept__2qo3
#endif
	o->_nextId = 0;
}

static struct ZCastNode321 * _NewZCastNode321(void) {
	struct ZCastNode321 *o = LibZen_Malloc(sizeof(struct ZCastNode321));
	_InitZCastNode321(o);
	return o;
}

static long ZCastNode_Expr_Z62 = 0;
struct ZCatchNode325 {
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
	int _classId325;
	int _delta325;
	struct ZType60 * ExceptionType;
	const char * ExceptionName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZCatchNode325(struct ZCatchNode325 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId325 = 325;
	o->_delta325 = sizeof(struct ZCatchNode325) - sizeof(struct ZNode52);
	o->ExceptionType = ZTypeVarType_Z4;
	o->ExceptionName = NULL;
	o->NameToken = NULL;
#ifdef _ZCatchNode325_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpw
#endif
#ifdef _ZCatchNode325_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpw
#endif
#ifdef _ZCatchNode325_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpw
#endif
#ifdef _ZCatchNode325_DeSugar
	o->DeSugar = DeSugar__2qpw
#endif
#ifdef _ZCatchNode325_Accept
	o->Accept = Accept__2qpw
#endif
	o->_nextId = 0;
}

static struct ZCatchNode325 * _NewZCatchNode325(void) {
	struct ZCatchNode325 *o = LibZen_Malloc(sizeof(struct ZCatchNode325));
	_InitZCatchNode325(o);
	return o;
}

static long ZCatchNode_Block_Z63 = 0;
struct ZComparatorNode329 {
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
	int _classId311;
	int _delta311;
	struct ZSyntax219 * Pattern;
	int _classId329;
	int _delta329;
	int _nextId;
};

static void _InitZComparatorNode329(struct ZComparatorNode329 * o) {
	_InitZBinaryNode311((struct ZBinaryNode311 *)o);
	o->_classId329 = 329;
	o->_delta329 = sizeof(struct ZComparatorNode329) - sizeof(struct ZBinaryNode311);
#ifdef _ZComparatorNode329_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpy
#endif
#ifdef _ZComparatorNode329_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpy
#endif
#ifdef _ZComparatorNode329_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpy
#endif
#ifdef _ZComparatorNode329_DeSugar
	o->DeSugar = DeSugar__2qpy
#endif
#ifdef _ZComparatorNode329_Accept
	o->Accept = Accept__2qpy
#endif
	o->_nextId = 0;
}

static struct ZComparatorNode329 * _NewZComparatorNode329(void) {
	struct ZComparatorNode329 *o = LibZen_Malloc(sizeof(struct ZComparatorNode329));
	_InitZComparatorNode329(o);
	return o;
}

struct ZConstNode332 {
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
	int _classId332;
	int _delta332;
	int _nextId;
};

static void _InitZConstNode332(struct ZConstNode332 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId332 = 332;
	o->_delta332 = sizeof(struct ZConstNode332) - sizeof(struct ZNode52);
#ifdef _ZConstNode332_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpo
#endif
#ifdef _ZConstNode332_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpo
#endif
#ifdef _ZConstNode332_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpo
#endif
#ifdef _ZConstNode332_DeSugar
	o->DeSugar = DeSugar__2qpo
#endif
#ifdef _ZConstNode332_Accept
	o->Accept = Accept__2qpo
#endif
	o->_nextId = 0;
}

static struct ZConstNode332 * _NewZConstNode332(void) {
	struct ZConstNode332 *o = LibZen_Malloc(sizeof(struct ZConstNode332));
	_InitZConstNode332(o);
	return o;
}

struct ZEmptyNode334 {
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
	int _classId334;
	int _delta334;
	int _nextId;
};

static void _InitZEmptyNode334(struct ZEmptyNode334 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId334 = 334;
	o->_delta334 = sizeof(struct ZEmptyNode334) - sizeof(struct ZNode52);
#ifdef _ZEmptyNode334_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp0
#endif
#ifdef _ZEmptyNode334_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp0
#endif
#ifdef _ZEmptyNode334_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp0
#endif
#ifdef _ZEmptyNode334_DeSugar
	o->DeSugar = DeSugar__2qp0
#endif
#ifdef _ZEmptyNode334_Accept
	o->Accept = Accept__2qp0
#endif
	o->_nextId = 0;
}

static struct ZEmptyNode334 * _NewZEmptyNode334(void) {
	struct ZEmptyNode334 *o = LibZen_Malloc(sizeof(struct ZEmptyNode334));
	_InitZEmptyNode334(o);
	return o;
}

struct ZErrorNode336 {
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
	int _classId332;
	int _delta332;
	int _classId336;
	int _delta336;
	const char * ErrorMessage;
	int _nextId;
};

static void _InitZErrorNode336(struct ZErrorNode336 * o) {
	_InitZConstNode332((struct ZConstNode332 *)o);
	o->_classId336 = 336;
	o->_delta336 = sizeof(struct ZErrorNode336) - sizeof(struct ZConstNode332);
	o->ErrorMessage = NULL;
#ifdef _ZErrorNode336_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpa
#endif
#ifdef _ZErrorNode336_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpa
#endif
#ifdef _ZErrorNode336_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpa
#endif
#ifdef _ZErrorNode336_DeSugar
	o->DeSugar = DeSugar__2qpa
#endif
#ifdef _ZErrorNode336_Accept
	o->Accept = Accept__2qpa
#endif
	o->_nextId = 0;
}

static struct ZErrorNode336 * _NewZErrorNode336(void) {
	struct ZErrorNode336 *o = LibZen_Malloc(sizeof(struct ZErrorNode336));
	_InitZErrorNode336(o);
	return o;
}

struct ZFieldNode340 {
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
	int _classId340;
	int _delta340;
	struct ZClassType80 * ClassType;
	struct ZType60 * DeclType;
	const char * FieldName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZFieldNode340(struct ZFieldNode340 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId340 = 340;
	o->_delta340 = sizeof(struct ZFieldNode340) - sizeof(struct ZNode52);
	o->ClassType = NULL;
	o->DeclType = ZTypeVarType_Z4;
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZFieldNode340_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpg
#endif
#ifdef _ZFieldNode340_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpg
#endif
#ifdef _ZFieldNode340_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpg
#endif
#ifdef _ZFieldNode340_DeSugar
	o->DeSugar = DeSugar__2qpg
#endif
#ifdef _ZFieldNode340_Accept
	o->Accept = Accept__2qpg
#endif
	o->_nextId = 0;
}

static struct ZFieldNode340 * _NewZFieldNode340(void) {
	struct ZFieldNode340 *o = LibZen_Malloc(sizeof(struct ZFieldNode340));
	_InitZFieldNode340(o);
	return o;
}

static long ZFieldNode_InitValue_Z64 = 0;
struct ZFloatNode344 {
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
	int _classId332;
	int _delta332;
	int _classId344;
	int _delta344;
	double FloatValue;
	int _nextId;
};

static void _InitZFloatNode344(struct ZFloatNode344 * o) {
	_InitZConstNode332((struct ZConstNode332 *)o);
	o->_classId344 = 344;
	o->_delta344 = sizeof(struct ZFloatNode344) - sizeof(struct ZConstNode332);
	o->FloatValue = 0.0;
#ifdef _ZFloatNode344_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpl
#endif
#ifdef _ZFloatNode344_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpl
#endif
#ifdef _ZFloatNode344_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpl
#endif
#ifdef _ZFloatNode344_DeSugar
	o->DeSugar = DeSugar__2qpl
#endif
#ifdef _ZFloatNode344_Accept
	o->Accept = Accept__2qpl
#endif
	o->_nextId = 0;
}

static struct ZFloatNode344 * _NewZFloatNode344(void) {
	struct ZFloatNode344 *o = LibZen_Malloc(sizeof(struct ZFloatNode344));
	_InitZFloatNode344(o);
	return o;
}

struct ZGetIndexNode347 {
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
	int _classId347;
	int _delta347;
	int _nextId;
};

static void _InitZGetIndexNode347(struct ZGetIndexNode347 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId347 = 347;
	o->_delta347 = sizeof(struct ZGetIndexNode347) - sizeof(struct ZNode52);
#ifdef _ZGetIndexNode347_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp6
#endif
#ifdef _ZGetIndexNode347_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp6
#endif
#ifdef _ZGetIndexNode347_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp6
#endif
#ifdef _ZGetIndexNode347_DeSugar
	o->DeSugar = DeSugar__2qp6
#endif
#ifdef _ZGetIndexNode347_Accept
	o->Accept = Accept__2qp6
#endif
	o->_nextId = 0;
}

static struct ZGetIndexNode347 * _NewZGetIndexNode347(void) {
	struct ZGetIndexNode347 *o = LibZen_Malloc(sizeof(struct ZGetIndexNode347));
	_InitZGetIndexNode347(o);
	return o;
}

static long ZGetIndexNode_Recv_Z65 = 0;
static long ZGetIndexNode_Index_Z66 = 1;
struct ZGetNameNode350 {
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
	int _classId350;
	int _delta350;
	int IsCaptured;
	const char * VarName;
	long VarIndex;
	int _nextId;
};

static void _InitZGetNameNode350(struct ZGetNameNode350 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId350 = 350;
	o->_delta350 = sizeof(struct ZGetNameNode350) - sizeof(struct ZNode52);
	o->IsCaptured = 0/*false*/;
	o->VarName = NULL;
	o->VarIndex = 0;
#ifdef _ZGetNameNode350_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpc
#endif
#ifdef _ZGetNameNode350_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpc
#endif
#ifdef _ZGetNameNode350_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpc
#endif
#ifdef _ZGetNameNode350_DeSugar
	o->DeSugar = DeSugar__2qpc
#endif
#ifdef _ZGetNameNode350_Accept
	o->Accept = Accept__2qpc
#endif
	o->_nextId = 0;
}

static struct ZGetNameNode350 * _NewZGetNameNode350(void) {
	struct ZGetNameNode350 *o = LibZen_Malloc(sizeof(struct ZGetNameNode350));
	_InitZGetNameNode350(o);
	return o;
}

struct ZGetterNode355 {
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
	int _classId355;
	int _delta355;
	const char * FieldName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZGetterNode355(struct ZGetterNode355 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId355 = 355;
	o->_delta355 = sizeof(struct ZGetterNode355) - sizeof(struct ZNode52);
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZGetterNode355_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp7
#endif
#ifdef _ZGetterNode355_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp7
#endif
#ifdef _ZGetterNode355_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp7
#endif
#ifdef _ZGetterNode355_DeSugar
	o->DeSugar = DeSugar__2qp7
#endif
#ifdef _ZGetterNode355_Accept
	o->Accept = Accept__2qp7
#endif
	o->_nextId = 0;
}

static struct ZGetterNode355 * _NewZGetterNode355(void) {
	struct ZGetterNode355 *o = LibZen_Malloc(sizeof(struct ZGetterNode355));
	_InitZGetterNode355(o);
	return o;
}

static long ZGetterNode_Recv_Z67 = 0;
struct ZGlobalNameNode360 {
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
	int _classId360;
	int _delta360;
	const char * GlobalName;
	int IsStaticFuncName;
	int _nextId;
};

static void _InitZGlobalNameNode360(struct ZGlobalNameNode360 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId360 = 360;
	o->_delta360 = sizeof(struct ZGlobalNameNode360) - sizeof(struct ZNode52);
	o->GlobalName = NULL;
	o->IsStaticFuncName = 0/*false*/;
#ifdef _ZGlobalNameNode360_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0q
#endif
#ifdef _ZGlobalNameNode360_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0q
#endif
#ifdef _ZGlobalNameNode360_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0q
#endif
#ifdef _ZGlobalNameNode360_DeSugar
	o->DeSugar = DeSugar__2q0q
#endif
#ifdef _ZGlobalNameNode360_Accept
	o->Accept = Accept__2q0q
#endif
	o->_nextId = 0;
}

static struct ZGlobalNameNode360 * _NewZGlobalNameNode360(void) {
	struct ZGlobalNameNode360 *o = LibZen_Malloc(sizeof(struct ZGlobalNameNode360));
	_InitZGlobalNameNode360(o);
	return o;
}

struct ZGroupNode364 {
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
	int _classId364;
	int _delta364;
	int _nextId;
};

static void _InitZGroupNode364(struct ZGroupNode364 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId364 = 364;
	o->_delta364 = sizeof(struct ZGroupNode364) - sizeof(struct ZNode52);
#ifdef _ZGroupNode364_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0t
#endif
#ifdef _ZGroupNode364_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0t
#endif
#ifdef _ZGroupNode364_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0t
#endif
#ifdef _ZGroupNode364_DeSugar
	o->DeSugar = DeSugar__2q0t
#endif
#ifdef _ZGroupNode364_Accept
	o->Accept = Accept__2q0t
#endif
	o->_nextId = 0;
}

static struct ZGroupNode364 * _NewZGroupNode364(void) {
	struct ZGroupNode364 *o = LibZen_Malloc(sizeof(struct ZGroupNode364));
	_InitZGroupNode364(o);
	return o;
}

static long ZGroupNode_Expr_Z68 = 0;
struct ZIfNode367 {
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
	int _classId367;
	int _delta367;
	int _nextId;
};

static void _InitZIfNode367(struct ZIfNode367 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId367 = 367;
	o->_delta367 = sizeof(struct ZIfNode367) - sizeof(struct ZNode52);
#ifdef _ZIfNode367_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0i
#endif
#ifdef _ZIfNode367_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0i
#endif
#ifdef _ZIfNode367_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0i
#endif
#ifdef _ZIfNode367_DeSugar
	o->DeSugar = DeSugar__2q0i
#endif
#ifdef _ZIfNode367_Accept
	o->Accept = Accept__2q0i
#endif
	o->_nextId = 0;
}

static struct ZIfNode367 * _NewZIfNode367(void) {
	struct ZIfNode367 *o = LibZen_Malloc(sizeof(struct ZIfNode367));
	_InitZIfNode367(o);
	return o;
}

static long ZIfNode_Cond_Z69 = 0;
static long ZIfNode_Then_Z70 = 1;
static long ZIfNode_Else_Z71 = 2;
struct ZImportNode370 {
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
	int _classId370;
	int _delta370;
	const char * ResourcePath;
	const char * Alias;
	struct ZToken77 * ResourceToken;
	struct ZNode52 * (*)(struct ZImportNode370 *) Import;
	int _nextId;
};

static void _InitZImportNode370(struct ZImportNode370 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId370 = 370;
	o->_delta370 = sizeof(struct ZImportNode370) - sizeof(struct ZNode52);
	o->ResourcePath = NULL;
	o->Alias = NULL;
	o->ResourceToken = NULL;
	o->Import = NULL;
#ifdef _ZImportNode370_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q00
#endif
#ifdef _ZImportNode370_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q00
#endif
#ifdef _ZImportNode370_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q00
#endif
#ifdef _ZImportNode370_DeSugar
	o->DeSugar = DeSugar__2q00
#endif
#ifdef _ZImportNode370_Accept
	o->Accept = Accept__2q00
#endif
#ifdef _ZImportNode370_Import
	o->Import = Import__1q00
#endif
	o->_nextId = 0;
}

static struct ZImportNode370 * _NewZImportNode370(void) {
	struct ZImportNode370 *o = LibZen_Malloc(sizeof(struct ZImportNode370));
	_InitZImportNode370(o);
	return o;
}

struct ZInstanceOfNode373 {
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
	int _classId373;
	int _delta373;
	struct ZType60 * TargetType;
	int _nextId;
};

static void _InitZInstanceOfNode373(struct ZInstanceOfNode373 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId373 = 373;
	o->_delta373 = sizeof(struct ZInstanceOfNode373) - sizeof(struct ZNode52);
	o->TargetType = NULL;
#ifdef _ZInstanceOfNode373_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0s
#endif
#ifdef _ZInstanceOfNode373_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0s
#endif
#ifdef _ZInstanceOfNode373_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0s
#endif
#ifdef _ZInstanceOfNode373_DeSugar
	o->DeSugar = DeSugar__2q0s
#endif
#ifdef _ZInstanceOfNode373_Accept
	o->Accept = Accept__2q0s
#endif
	o->_nextId = 0;
}

static struct ZInstanceOfNode373 * _NewZInstanceOfNode373(void) {
	struct ZInstanceOfNode373 *o = LibZen_Malloc(sizeof(struct ZInstanceOfNode373));
	_InitZInstanceOfNode373(o);
	return o;
}

static long ZInstanceOfNode_Left_Z72 = 0;
struct ZIntNode377 {
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
	int _classId332;
	int _delta332;
	int _classId377;
	int _delta377;
	long IntValue;
	int _nextId;
};

static void _InitZIntNode377(struct ZIntNode377 * o) {
	_InitZConstNode332((struct ZConstNode332 *)o);
	o->_classId377 = 377;
	o->_delta377 = sizeof(struct ZIntNode377) - sizeof(struct ZConstNode332);
	o->IntValue = 0;
#ifdef _ZIntNode377_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0h
#endif
#ifdef _ZIntNode377_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0h
#endif
#ifdef _ZIntNode377_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0h
#endif
#ifdef _ZIntNode377_DeSugar
	o->DeSugar = DeSugar__2q0h
#endif
#ifdef _ZIntNode377_Accept
	o->Accept = Accept__2q0h
#endif
	o->_nextId = 0;
}

static struct ZIntNode377 * _NewZIntNode377(void) {
	struct ZIntNode377 *o = LibZen_Malloc(sizeof(struct ZIntNode377));
	_InitZIntNode377(o);
	return o;
}

struct ZLetNode380 {
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
	int _classId380;
	int _delta380;
	const char * Symbol;
	struct ZToken77 * SymbolToken;
	struct ZType60 * SymbolType;
	const char * GlobalName;
	int _nextId;
};

static void _InitZLetNode380(struct ZLetNode380 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId380 = 380;
	o->_delta380 = sizeof(struct ZLetNode380) - sizeof(struct ZNode52);
	o->Symbol = NULL;
	o->SymbolToken = NULL;
	o->SymbolType = ZTypeVarType_Z4;
	o->GlobalName = NULL;
#ifdef _ZLetNode380_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0l
#endif
#ifdef _ZLetNode380_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0l
#endif
#ifdef _ZLetNode380_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0l
#endif
#ifdef _ZLetNode380_DeSugar
	o->DeSugar = DeSugar__2q0l
#endif
#ifdef _ZLetNode380_Accept
	o->Accept = Accept__2q0l
#endif
	o->_nextId = 0;
}

static struct ZLetNode380 * _NewZLetNode380(void) {
	struct ZLetNode380 *o = LibZen_Malloc(sizeof(struct ZLetNode380));
	_InitZLetNode380(o);
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

struct ZMacroNode392 {
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
	int _classId392;
	int _delta392;
	struct ZMacroFunc210 * MacroFunc;
	int _nextId;
};

static void _InitZMacroNode392(struct ZMacroNode392 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId392 = 392;
	o->_delta392 = sizeof(struct ZMacroNode392) - sizeof(struct ZListNode251);
	o->MacroFunc = NULL;
#ifdef _ZMacroNode392_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q05
#endif
#ifdef _ZMacroNode392_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q05
#endif
#ifdef _ZMacroNode392_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q05
#endif
#ifdef _ZMacroNode392_DeSugar
	o->DeSugar = DeSugar__2q05
#endif
#ifdef _ZMacroNode392_Accept
	o->Accept = Accept__2q05
#endif
	o->_nextId = 0;
}

static struct ZMacroNode392 * _NewZMacroNode392(void) {
	struct ZMacroNode392 *o = LibZen_Malloc(sizeof(struct ZMacroNode392));
	_InitZMacroNode392(o);
	return o;
}

struct ZMapEntryNode397 {
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
	int _classId397;
	int _delta397;
	const char * Name;
	int _nextId;
};

static void _InitZMapEntryNode397(struct ZMapEntryNode397 * o) {
	_InitZNode52((struct ZNode52 *)o);
	o->_classId397 = 397;
	o->_delta397 = sizeof(struct ZMapEntryNode397) - sizeof(struct ZNode52);
	o->Name = NULL;
#ifdef _ZMapEntryNode397_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4w
#endif
#ifdef _ZMapEntryNode397_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4w
#endif
#ifdef _ZMapEntryNode397_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4w
#endif
#ifdef _ZMapEntryNode397_DeSugar
	o->DeSugar = DeSugar__2q4w
#endif
#ifdef _ZMapEntryNode397_Accept
	o->Accept = Accept__2q4w
#endif
	o->_nextId = 0;
}

static struct ZMapEntryNode397 * _NewZMapEntryNode397(void) {
	struct ZMapEntryNode397 *o = LibZen_Malloc(sizeof(struct ZMapEntryNode397));
	_InitZMapEntryNode397(o);
	return o;
}

static long ZMapEntryNode_Key_Z74 = 0;
static long ZMapEntryNode_Value_Z75 = 1;
struct ZMapLiteralNode399 {
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
	int _classId399;
	int _delta399;
	int _nextId;
};

static void _InitZMapLiteralNode399(struct ZMapLiteralNode399 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId399 = 399;
	o->_delta399 = sizeof(struct ZMapLiteralNode399) - sizeof(struct ZListNode251);
#ifdef _ZMapLiteralNode399_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4r
#endif
#ifdef _ZMapLiteralNode399_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4r
#endif
#ifdef _ZMapLiteralNode399_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4r
#endif
#ifdef _ZMapLiteralNode399_DeSugar
	o->DeSugar = DeSugar__2q4r
#endif
#ifdef _ZMapLiteralNode399_Accept
	o->Accept = Accept__2q4r
#endif
	o->_nextId = 0;
}

static struct ZMapLiteralNode399 * _NewZMapLiteralNode399(void) {
	struct ZMapLiteralNode399 *o = LibZen_Malloc(sizeof(struct ZMapLiteralNode399));
	_InitZMapLiteralNode399(o);
	return o;
}

struct ZMethodCallNode403 {
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
	int _classId403;
	int _delta403;
	const char * MethodName;
	struct ZToken77 * MethodToken;
	int _nextId;
};

static void _InitZMethodCallNode403(struct ZMethodCallNode403 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId403 = 403;
	o->_delta403 = sizeof(struct ZMethodCallNode403) - sizeof(struct ZListNode251);
	o->MethodName = NULL;
	o->MethodToken = NULL;
#ifdef _ZMethodCallNode403_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4i
#endif
#ifdef _ZMethodCallNode403_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4i
#endif
#ifdef _ZMethodCallNode403_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4i
#endif
#ifdef _ZMethodCallNode403_DeSugar
	o->DeSugar = DeSugar__2q4i
#endif
#ifdef _ZMethodCallNode403_Accept
	o->Accept = Accept__2q4i
#endif
	o->_nextId = 0;
}

static struct ZMethodCallNode403 * _NewZMethodCallNode403(void) {
	struct ZMethodCallNode403 *o = LibZen_Malloc(sizeof(struct ZMethodCallNode403));
	_InitZMethodCallNode403(o);
	return o;
}

static long ZMethodCallNode_Recv_Z76 = 0;
struct ZNewArrayNode410 {
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
	int _classId410;
	int _delta410;
	int _nextId;
};

static void _InitZNewArrayNode410(struct ZNewArrayNode410 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId410 = 410;
	o->_delta410 = sizeof(struct ZNewArrayNode410) - sizeof(struct ZListNode251);
#ifdef _ZNewArrayNode410_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4d
#endif
#ifdef _ZNewArrayNode410_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4d
#endif
#ifdef _ZNewArrayNode410_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4d
#endif
#ifdef _ZNewArrayNode410_DeSugar
	o->DeSugar = DeSugar__2q4d
#endif
#ifdef _ZNewArrayNode410_Accept
	o->Accept = Accept__2q4d
#endif
	o->_nextId = 0;
}

static struct ZNewArrayNode410 * _NewZNewArrayNode410(void) {
	struct ZNewArrayNode410 *o = LibZen_Malloc(sizeof(struct ZNewArrayNode410));
	_InitZNewArrayNode410(o);
	return o;
}

struct ZNewObjectNode412 {
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
	int _classId412;
	int _delta412;
	int _nextId;
};

static void _InitZNewObjectNode412(struct ZNewObjectNode412 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId412 = 412;
	o->_delta412 = sizeof(struct ZNewObjectNode412) - sizeof(struct ZListNode251);
#ifdef _ZNewObjectNode412_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4g
#endif
#ifdef _ZNewObjectNode412_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4g
#endif
#ifdef _ZNewObjectNode412_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4g
#endif
#ifdef _ZNewObjectNode412_DeSugar
	o->DeSugar = DeSugar__2q4g
#endif
#ifdef _ZNewObjectNode412_Accept
	o->Accept = Accept__2q4g
#endif
	o->_nextId = 0;
}

static struct ZNewObjectNode412 * _NewZNewObjectNode412(void) {
	struct ZNewObjectNode412 *o = LibZen_Malloc(sizeof(struct ZNewObjectNode412));
	_InitZNewObjectNode412(o);
	return o;
}

struct ZNotNode416 {
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
	int _classId416;
	int _delta416;
	int _nextId;
};

static void _InitZNotNode416(struct ZNotNode416 * o) {
	_InitZUnaryNode197((struct ZUnaryNode197 *)o);
	o->_classId416 = 416;
	o->_delta416 = sizeof(struct ZNotNode416) - sizeof(struct ZUnaryNode197);
#ifdef _ZNotNode416_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4l
#endif
#ifdef _ZNotNode416_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4l
#endif
#ifdef _ZNotNode416_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4l
#endif
#ifdef _ZNotNode416_DeSugar
	o->DeSugar = DeSugar__2q4l
#endif
#ifdef _ZNotNode416_Accept
	o->Accept = Accept__2q4l
#endif
	o->_nextId = 0;
}

static struct ZNotNode416 * _NewZNotNode416(void) {
	struct ZNotNode416 *o = LibZen_Malloc(sizeof(struct ZNotNode416));
	_InitZNotNode416(o);
	return o;
}

struct ZNullNode419 {
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
	int _classId332;
	int _delta332;
	int _classId419;
	int _delta419;
	int _nextId;
};

static void _InitZNullNode419(struct ZNullNode419 * o) {
	_InitZConstNode332((struct ZConstNode332 *)o);
	o->_classId419 = 419;
	o->_delta419 = sizeof(struct ZNullNode419) - sizeof(struct ZConstNode332);
#ifdef _ZNullNode419_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q46
#endif
#ifdef _ZNullNode419_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q46
#endif
#ifdef _ZNullNode419_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q46
#endif
#ifdef _ZNullNode419_DeSugar
	o->DeSugar = DeSugar__2q46
#endif
#ifdef _ZNullNode419_Accept
	o->Accept = Accept__2q46
#endif
	o->_nextId = 0;
}

static struct ZNullNode419 * _NewZNullNode419(void) {
	struct ZNullNode419 *o = LibZen_Malloc(sizeof(struct ZNullNode419));
	_InitZNullNode419(o);
	return o;
}

struct ZOrNode422 {
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
	int _classId311;
	int _delta311;
	struct ZSyntax219 * Pattern;
	int _classId422;
	int _delta422;
	int _nextId;
};

static void _InitZOrNode422(struct ZOrNode422 * o) {
	_InitZBinaryNode311((struct ZBinaryNode311 *)o);
	o->_classId422 = 422;
	o->_delta422 = sizeof(struct ZOrNode422) - sizeof(struct ZBinaryNode311);
#ifdef _ZOrNode422_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4c
#endif
#ifdef _ZOrNode422_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4c
#endif
#ifdef _ZOrNode422_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4c
#endif
#ifdef _ZOrNode422_DeSugar
	o->DeSugar = DeSugar__2q4c
#endif
#ifdef _ZOrNode422_Accept
	o->Accept = Accept__2q4c
#endif
	o->_nextId = 0;
}

static struct ZOrNode422 * _NewZOrNode422(void) {
	struct ZOrNode422 *o = LibZen_Malloc(sizeof(struct ZOrNode422));
	_InitZOrNode422(o);
	return o;
}

struct ZPrototypeNode425 {
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
	int _classId425;
	int _delta425;
	struct ZType60 * ReturnType;
	const char * FuncName;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZPrototypeNode425(struct ZPrototypeNode425 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId425 = 425;
	o->_delta425 = sizeof(struct ZPrototypeNode425) - sizeof(struct ZListNode251);
	o->ReturnType = ZTypeVarType_Z4;
	o->FuncName = NULL;
	o->NameToken = NULL;
#ifdef _ZPrototypeNode425_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4n
#endif
#ifdef _ZPrototypeNode425_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4n
#endif
#ifdef _ZPrototypeNode425_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4n
#endif
#ifdef _ZPrototypeNode425_DeSugar
	o->DeSugar = DeSugar__2q4n
#endif
#ifdef _ZPrototypeNode425_Accept
	o->Accept = Accept__2q4n
#endif
	o->_nextId = 0;
}

static struct ZPrototypeNode425 * _NewZPrototypeNode425(void) {
	struct ZPrototypeNode425 *o = LibZen_Malloc(sizeof(struct ZPrototypeNode425));
	_InitZPrototypeNode425(o);
	return o;
}

struct ZStringNode431 {
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
	int _classId332;
	int _delta332;
	int _classId431;
	int _delta431;
	const char * StringValue;
	int _nextId;
};

static void _InitZStringNode431(struct ZStringNode431 * o) {
	_InitZConstNode332((struct ZConstNode332 *)o);
	o->_classId431 = 431;
	o->_delta431 = sizeof(struct ZStringNode431) - sizeof(struct ZConstNode332);
	o->StringValue = NULL;
#ifdef _ZStringNode431_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q48
#endif
#ifdef _ZStringNode431_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q48
#endif
#ifdef _ZStringNode431_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q48
#endif
#ifdef _ZStringNode431_DeSugar
	o->DeSugar = DeSugar__2q48
#endif
#ifdef _ZStringNode431_Accept
	o->Accept = Accept__2q48
#endif
	o->_nextId = 0;
}

static struct ZStringNode431 * _NewZStringNode431(void) {
	struct ZStringNode431 *o = LibZen_Malloc(sizeof(struct ZStringNode431));
	_InitZStringNode431(o);
	return o;
}

struct ZStupidCastErrorNode434 {
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
	int _classId332;
	int _delta332;
	int _classId336;
	int _delta336;
	const char * ErrorMessage;
	int _classId434;
	int _delta434;
	struct ZNode52 * ErrorNode;
	int _nextId;
};

static void _InitZStupidCastErrorNode434(struct ZStupidCastErrorNode434 * o) {
	_InitZErrorNode336((struct ZErrorNode336 *)o);
	o->_classId434 = 434;
	o->_delta434 = sizeof(struct ZStupidCastErrorNode434) - sizeof(struct ZErrorNode336);
	o->ErrorNode = NULL;
#ifdef _ZStupidCastErrorNode434_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qae
#endif
#ifdef _ZStupidCastErrorNode434_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qae
#endif
#ifdef _ZStupidCastErrorNode434_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qae
#endif
#ifdef _ZStupidCastErrorNode434_DeSugar
	o->DeSugar = DeSugar__2qae
#endif
#ifdef _ZStupidCastErrorNode434_Accept
	o->Accept = Accept__2qae
#endif
	o->_nextId = 0;
}

static struct ZStupidCastErrorNode434 * _NewZStupidCastErrorNode434(void) {
	struct ZStupidCastErrorNode434 *o = LibZen_Malloc(sizeof(struct ZStupidCastErrorNode434));
	_InitZStupidCastErrorNode434(o);
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
	int _classId332;
	int _delta332;
	int _classId235;
	int _delta235;
	int _nextId;
};

static void _InitZTypeNode235(struct ZTypeNode235 * o) {
	_InitZConstNode332((struct ZConstNode332 *)o);
	o->_classId235 = 235;
	o->_delta235 = sizeof(struct ZTypeNode235) - sizeof(struct ZConstNode332);
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
	void (*)(struct ZVisitor167 *,struct ZNullNode419 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode476 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode377 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode344 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode431 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode481 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode399 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode412 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode360 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode350 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode364 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode355 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode347 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode403 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode407 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode392 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode416 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode321 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode373 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode311 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode329 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode502 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode422 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode506 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode367 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode318 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode380 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode516 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode336 *) VisitErrorNode;
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

struct ZIndentToken460 {
	int _classId77;
	int _delta77;
	struct ZSource238 * Source;
	long StartIndex;
	long EndIndex;
	int _classId460;
	int _delta460;
	int _nextId;
};

static void _InitZIndentToken460(struct ZIndentToken460 * o) {
	_InitZToken77((struct ZToken77 *)o);
	o->_classId460 = 460;
	o->_delta460 = sizeof(struct ZIndentToken460) - sizeof(struct ZToken77);
	o->_nextId = 0;
}

static struct ZIndentToken460 * _NewZIndentToken460(void) {
	struct ZIndentToken460 *o = LibZen_Malloc(sizeof(struct ZIndentToken460));
	_InitZIndentToken460(o);
	return o;
}

struct ZPatternToken462 {
	int _classId77;
	int _delta77;
	struct ZSource238 * Source;
	long StartIndex;
	long EndIndex;
	int _classId462;
	int _delta462;
	struct ZSyntax219 * PresetPattern;
	int _nextId;
};

static void _InitZPatternToken462(struct ZPatternToken462 * o) {
	_InitZToken77((struct ZToken77 *)o);
	o->_classId462 = 462;
	o->_delta462 = sizeof(struct ZPatternToken462) - sizeof(struct ZToken77);
	o->PresetPattern = NULL;
	o->_nextId = 0;
}

static struct ZPatternToken462 * _NewZPatternToken462(void) {
	struct ZPatternToken462 *o = LibZen_Malloc(sizeof(struct ZPatternToken462));
	_InitZPatternToken462(o);
	return o;
}

struct ZSourceEngine57 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode419 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode476 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode377 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode344 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode431 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode481 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode399 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode412 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode360 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode350 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode364 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode355 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode347 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode403 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode407 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode392 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode416 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode321 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode373 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode311 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode329 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode502 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode422 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode506 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode367 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode318 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode380 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode516 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode336 *) VisitErrorNode;
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
	void (*)(struct ZVisitor167 *,struct ZNullNode419 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode476 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode377 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode344 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode431 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode481 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode399 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode412 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode360 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode350 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode364 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode355 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode347 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode403 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode407 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode392 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode416 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode321 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode373 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode311 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode329 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode502 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode422 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode506 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode367 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode318 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode380 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode516 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode336 *) VisitErrorNode;
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
	void (*)(struct ZVisitor167 *,struct ZNullNode419 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode476 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode377 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode344 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode431 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode481 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode399 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode412 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode360 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode350 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode364 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode355 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode347 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode403 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode407 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode392 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode416 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode321 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode373 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode311 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode329 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode502 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode422 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode506 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode367 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode318 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode380 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode516 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode336 *) VisitErrorNode;
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
struct CSourceGenerator599 {
	int _classId167;
	int _delta167;
	void (*)(struct ZVisitor167 *,struct ZNullNode419 *) VisitNullNode;
	void (*)(struct ZVisitor167 *,struct ZBooleanNode476 *) VisitBooleanNode;
	void (*)(struct ZVisitor167 *,struct ZIntNode377 *) VisitIntNode;
	void (*)(struct ZVisitor167 *,struct ZFloatNode344 *) VisitFloatNode;
	void (*)(struct ZVisitor167 *,struct ZStringNode431 *) VisitStringNode;
	void (*)(struct ZVisitor167 *,struct ZArrayLiteralNode481 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZMapLiteralNode399 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor167 *,struct ZNewObjectNode412 *) VisitNewObjectNode;
	void (*)(struct ZVisitor167 *,struct ZGlobalNameNode360 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor167 *,struct ZGetNameNode350 *) VisitGetNameNode;
	void (*)(struct ZVisitor167 *,struct ZSetNameNode181 *) VisitSetNameNode;
	void (*)(struct ZVisitor167 *,struct ZGroupNode364 *) VisitGroupNode;
	void (*)(struct ZVisitor167 *,struct ZGetterNode355 *) VisitGetterNode;
	void (*)(struct ZVisitor167 *,struct ZSetterNode184 *) VisitSetterNode;
	void (*)(struct ZVisitor167 *,struct ZGetIndexNode347 *) VisitGetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZSetIndexNode178 *) VisitSetIndexNode;
	void (*)(struct ZVisitor167 *,struct ZMethodCallNode403 *) VisitMethodCallNode;
	void (*)(struct ZVisitor167 *,struct ZFuncCallNode407 *) VisitFuncCallNode;
	void (*)(struct ZVisitor167 *,struct ZMacroNode392 *) VisitMacroNode;
	void (*)(struct ZVisitor167 *,struct ZUnaryNode197 *) VisitUnaryNode;
	void (*)(struct ZVisitor167 *,struct ZNotNode416 *) VisitNotNode;
	void (*)(struct ZVisitor167 *,struct ZCastNode321 *) VisitCastNode;
	void (*)(struct ZVisitor167 *,struct ZInstanceOfNode373 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor167 *,struct ZBinaryNode311 *) VisitBinaryNode;
	void (*)(struct ZVisitor167 *,struct ZComparatorNode329 *) VisitComparatorNode;
	void (*)(struct ZVisitor167 *,struct ZAndNode502 *) VisitAndNode;
	void (*)(struct ZVisitor167 *,struct ZOrNode422 *) VisitOrNode;
	void (*)(struct ZVisitor167 *,struct ZBlockNode161 *) VisitBlockNode;
	void (*)(struct ZVisitor167 *,struct ZVarNode506 *) VisitVarNode;
	void (*)(struct ZVisitor167 *,struct ZIfNode367 *) VisitIfNode;
	void (*)(struct ZVisitor167 *,struct ZReturnNode170 *) VisitReturnNode;
	void (*)(struct ZVisitor167 *,struct ZWhileNode200 *) VisitWhileNode;
	void (*)(struct ZVisitor167 *,struct ZBreakNode318 *) VisitBreakNode;
	void (*)(struct ZVisitor167 *,struct ZThrowNode191 *) VisitThrowNode;
	void (*)(struct ZVisitor167 *,struct ZTryNode194 *) VisitTryNode;
	void (*)(struct ZVisitor167 *,struct ZLetNode380 *) VisitLetNode;
	void (*)(struct ZVisitor167 *,struct ZFunctionNode144 *) VisitFunctionNode;
	void (*)(struct ZVisitor167 *,struct ZClassNode516 *) VisitClassNode;
	void (*)(struct ZVisitor167 *,struct ZErrorNode336 *) VisitErrorNode;
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
	int _classId599;
	int _delta599;
	int _nextId;
};

static void _InitCSourceGenerator599(struct CSourceGenerator599 * o) {
	_InitZSourceGenerator243((struct ZSourceGenerator243 *)o);
	o->_classId599 = 599;
	o->_delta599 = sizeof(struct CSourceGenerator599) - sizeof(struct ZSourceGenerator243);
#ifdef _CSourceGenerator599_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qg6
#endif
#ifdef _CSourceGenerator599_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qg6
#endif
#ifdef _CSourceGenerator599_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qg6
#endif
#ifdef _CSourceGenerator599_StopVisitor
	o->StopVisitor = StopVisitor__1qg6
#endif
#ifdef _CSourceGenerator599_IsVisitable
	o->IsVisitable = IsVisitable__1qg6
#endif
#ifdef _CSourceGenerator599_GetEngine
	o->GetEngine = GetEngine__1qg6
#endif
#ifdef _CSourceGenerator599_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qg6
#endif
#ifdef _CSourceGenerator599_WriteTo
	o->WriteTo = WriteTo__2qg6
#endif
#ifdef _CSourceGenerator599_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qg6
#endif
#ifdef _CSourceGenerator599_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qg6
#endif
#ifdef _CSourceGenerator599_GetFieldType
	o->GetFieldType = GetFieldType__3qg6
#endif
#ifdef _CSourceGenerator599_GetSetterType
	o->GetSetterType = GetSetterType__3qg6
#endif
#ifdef _CSourceGenerator599_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qg6
#endif
#ifdef _CSourceGenerator599_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qg6
#endif
#ifdef _CSourceGenerator599_InitBuilderList
	o->InitBuilderList = InitBuilderList__1qg6
#endif
#ifdef _CSourceGenerator599_GenerateCode
	o->GenerateCode = GenerateCode__3qg6
#endif
	o->_nextId = 0;
}

static struct CSourceGenerator599 * _NewCSourceGenerator599(void) {
	struct CSourceGenerator599 *o = LibZen_Malloc(sizeof(struct CSourceGenerator599));
	_InitCSourceGenerator599(o);
	return o;
}

struct ZAndNode502 {
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
	int _classId311;
	int _delta311;
	struct ZSyntax219 * Pattern;
	int _classId502;
	int _delta502;
	int _nextId;
};

static void _InitZAndNode502(struct ZAndNode502 * o) {
	_InitZBinaryNode311((struct ZBinaryNode311 *)o);
	o->_classId502 = 502;
	o->_delta502 = sizeof(struct ZAndNode502) - sizeof(struct ZBinaryNode311);
#ifdef _ZAndNode502_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qs2
#endif
#ifdef _ZAndNode502_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qs2
#endif
#ifdef _ZAndNode502_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qs2
#endif
#ifdef _ZAndNode502_DeSugar
	o->DeSugar = DeSugar__2qs2
#endif
#ifdef _ZAndNode502_Accept
	o->Accept = Accept__2qs2
#endif
	o->_nextId = 0;
}

static struct ZAndNode502 * _NewZAndNode502(void) {
	struct ZAndNode502 *o = LibZen_Malloc(sizeof(struct ZAndNode502));
	_InitZAndNode502(o);
	return o;
}

struct ZArrayLiteralNode481 {
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
	int _classId481;
	int _delta481;
	int _nextId;
};

static void _InitZArrayLiteralNode481(struct ZArrayLiteralNode481 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId481 = 481;
	o->_delta481 = sizeof(struct ZArrayLiteralNode481) - sizeof(struct ZListNode251);
#ifdef _ZArrayLiteralNode481_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qss
#endif
#ifdef _ZArrayLiteralNode481_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qss
#endif
#ifdef _ZArrayLiteralNode481_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qss
#endif
#ifdef _ZArrayLiteralNode481_DeSugar
	o->DeSugar = DeSugar__2qss
#endif
#ifdef _ZArrayLiteralNode481_Accept
	o->Accept = Accept__2qss
#endif
	o->_nextId = 0;
}

static struct ZArrayLiteralNode481 * _NewZArrayLiteralNode481(void) {
	struct ZArrayLiteralNode481 *o = LibZen_Malloc(sizeof(struct ZArrayLiteralNode481));
	_InitZArrayLiteralNode481(o);
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

struct ZBooleanNode476 {
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
	int _classId332;
	int _delta332;
	int _classId476;
	int _delta476;
	int BooleanValue;
	int _nextId;
};

static void _InitZBooleanNode476(struct ZBooleanNode476 * o) {
	_InitZConstNode332((struct ZConstNode332 *)o);
	o->_classId476 = 476;
	o->_delta476 = sizeof(struct ZBooleanNode476) - sizeof(struct ZConstNode332);
	o->BooleanValue = 0/*false*/;
#ifdef _ZBooleanNode476_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qso
#endif
#ifdef _ZBooleanNode476_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qso
#endif
#ifdef _ZBooleanNode476_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qso
#endif
#ifdef _ZBooleanNode476_DeSugar
	o->DeSugar = DeSugar__2qso
#endif
#ifdef _ZBooleanNode476_Accept
	o->Accept = Accept__2qso
#endif
	o->_nextId = 0;
}

static struct ZBooleanNode476 * _NewZBooleanNode476(void) {
	struct ZBooleanNode476 *o = LibZen_Malloc(sizeof(struct ZBooleanNode476));
	_InitZBooleanNode476(o);
	return o;
}

struct ZClassNode516 {
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
	int _classId516;
	int _delta516;
	const char * ClassName;
	struct ZClassType80 * ClassType;
	struct ZType60 * SuperType;
	struct ZToken77 * NameToken;
	struct ZToken77 * SuperToken;
	int _nextId;
};

static void _InitZClassNode516(struct ZClassNode516 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId516 = 516;
	o->_delta516 = sizeof(struct ZClassNode516) - sizeof(struct ZListNode251);
	o->ClassName = NULL;
	o->ClassType = NULL;
	o->SuperType = NULL;
	o->NameToken = NULL;
	o->SuperToken = NULL;
#ifdef _ZClassNode516_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qda
#endif
#ifdef _ZClassNode516_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qda
#endif
#ifdef _ZClassNode516_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qda
#endif
#ifdef _ZClassNode516_DeSugar
	o->DeSugar = DeSugar__2qda
#endif
#ifdef _ZClassNode516_Accept
	o->Accept = Accept__2qda
#endif
	o->_nextId = 0;
}

static struct ZClassNode516 * _NewZClassNode516(void) {
	struct ZClassNode516 *o = LibZen_Malloc(sizeof(struct ZClassNode516));
	_InitZClassNode516(o);
	return o;
}

struct ZFuncCallNode407 {
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
	int _classId407;
	int _delta407;
	int _nextId;
};

static void _InitZFuncCallNode407(struct ZFuncCallNode407 * o) {
	_InitZListNode251((struct ZListNode251 *)o);
	o->_classId407 = 407;
	o->_delta407 = sizeof(struct ZFuncCallNode407) - sizeof(struct ZListNode251);
#ifdef _ZFuncCallNode407_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q44
#endif
#ifdef _ZFuncCallNode407_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q44
#endif
#ifdef _ZFuncCallNode407_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q44
#endif
#ifdef _ZFuncCallNode407_DeSugar
	o->DeSugar = DeSugar__2q44
#endif
#ifdef _ZFuncCallNode407_Accept
	o->Accept = Accept__2q44
#endif
	o->_nextId = 0;
}

static struct ZFuncCallNode407 * _NewZFuncCallNode407(void) {
	struct ZFuncCallNode407 *o = LibZen_Malloc(sizeof(struct ZFuncCallNode407));
	_InitZFuncCallNode407(o);
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
struct ZVarNode506 {
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
	int _classId506;
	int _delta506;
	struct ZType60 * DeclType;
	const char * NativeName;
	struct ZToken77 * TypeToken;
	struct ZToken77 * NameToken;
	int _nextId;
};

static void _InitZVarNode506(struct ZVarNode506 * o) {
	_InitZBlockNode161((struct ZBlockNode161 *)o);
	o->_classId506 = 506;
	o->_delta506 = sizeof(struct ZVarNode506) - sizeof(struct ZBlockNode161);
	o->DeclType = ZTypeVarType_Z4;
	o->NativeName = NULL;
	o->TypeToken = NULL;
	o->NameToken = NULL;
#ifdef _ZVarNode506_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qde
#endif
#ifdef _ZVarNode506_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qde
#endif
#ifdef _ZVarNode506_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qde
#endif
#ifdef _ZVarNode506_DeSugar
	o->DeSugar = DeSugar__2qde
#endif
#ifdef _ZVarNode506_Accept
	o->Accept = Accept__2qde
#endif
	o->_nextId = 0;
}

static struct ZVarNode506 * _NewZVarNode506(void) {
	struct ZVarNode506 *o = LibZen_Malloc(sizeof(struct ZVarNode506));
	_InitZVarNode506(o);
	return o;
}

static long ZVarNode_InitValue_Z81 = 0;
static struct ZType60 * ZType__4qwz(struct ZType60 * this, long TypeFlag__1, const char * ShortName__2, struct ZType60 * RefType__3) {
	this->TypeFlag = TypeFlag;
	this->ShortName = ShortName;
	this->RefType = RefType;
	if (LibZen_IsFlag__2qqr(TypeFlag, ZTypeUniqueTypeFlag_Z1)) {
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
	return (/*untyped*/NULL(this) == /*untyped*/NULL(Type));
}
static int Accept__2qwz(struct ZType60 * this, struct ZType60 * Type__1) {
	struct ZType60 * ThisType = /*untyped*/NULL(this);
	if (ThisType == /*untyped*/NULL(Type)) {
		return 1/*true*/;
	};
	struct ZType60 * SuperClass = /*untyped*/NULL(Type);
	while (SuperClass != NULL) {
		if (SuperClass == ThisType) {
			return 1/*true*/;
		};
		SuperClass = /*untyped*/NULL(SuperClass);
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
	if (/*untyped*/NULL(this) != ValueType && !/*untyped*/NULL(ValueType)) {
		if (ExactMatch && !Accept__2qwz(this, ValueType)) {
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
	return (/*untyped*/NULL(this) == ThrowError("type error: requested = ZType, given = ZGeneric1Type"));
}
static int IsMapType__1qwz(struct ZType60 * this) {
	return (/*untyped*/NULL(this) == ThrowError("type error: requested = ZType, given = ZGeneric1Type"));
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
	return LibZen_StrCat(LibZen_StrCat(Name, " of "), this->ShortName);
}
static const char * GetUniqueName__1qwz(struct ZType60 * this) {
	return LibZen_Stringfy__1qqr(this->TypeId);
}
static int IsFuncType__1qwz(struct ZType60 * this) {
	return (LibZen_Is(/*untyped*/NULL(this), 90));
}
static const char * StringfySignature__2qwz(struct ZType60 * this, const char * FuncName__1) {
	return FuncName;
}
static void Maybe__3qwz(struct ZType60 * this, struct ZType60 * T__1, struct ZToken77 * SourceToken__2) {
	return;
}
static struct ZClassField79 * ZClassField__5qei(struct ZClassField79 * this, struct ZClassType80 * ClassType__1, const char * FieldName__2, struct ZType60 * FieldType__3, struct ZToken77 * SourceToken__4) {
	this->ClassType = ClassType;
	this->FieldType = FieldType;
	this->FieldName = FieldName;
	this->SourceToken = SourceToken;
	return NULL;
}
static struct ZClassType80 * ZClassType__3qeo(struct ZClassType80 * this, const char * ShortName__1, struct ZType60 * RefType__2) {
	(void)ZType__4qwz(this, ZTypeOpenTypeFlag_Z3 | ZTypeUniqueTypeFlag_Z1, ShortName, RefType);
	if (LibZen_Is(RefType, 80)) {
		ResetSuperType__2qeo(this, (struct ZClassType80 *)RefType);
	};
	return NULL;
}
static void ResetSuperType__2qeo(struct ZClassType80 * this, struct ZClassType80 * SuperClass__1) {
	this->RefType = SuperClass;
	if (SuperClass->FieldList != NULL) {
		this->FieldList = LibZen_NewArray(0);
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)SuperClass->FieldList)) {
			struct ZClassField79 * Field = Array<ZClassField>GetIndex(i);
			LibZen_ArrayAdd((ArrayOfVar *)this->FieldList, (var)Field);
			i = i + 1;
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
	return Array<ZClassField>GetIndex(Index);
}
static int HasField__2qeo(struct ZClassType80 * this, const char * FieldName__1) {
	if (this->FieldList != NULL) {
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)this->FieldList)) {
			if (LibZen_EqualsString(FieldName, Array<ZClassField>GetIndex(i)->FieldName)) {
				return 1/*true*/;
			};
			i = i + 1;
		};
	};
	return 0/*false*/;
}
static struct ZType60 * GetFieldType__3qeo(struct ZClassType80 * this, const char * FieldName__1, struct ZType60 * DefaultType__2) {
	if (this->FieldList != NULL) {
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)this->FieldList)) {
			struct ZClassField79 * Field = Array<ZClassField>GetIndex(i);
			if (LibZen_EqualsString(FieldName, Field->FieldName)) {
				return Field->FieldType;
			};
			i = i + 1;
		};
	};
	return DefaultType;
}
static struct ZClassField79 * AppendField__4qeo(struct ZClassType80 * this, struct ZType60 * FieldType__1, const char * FieldName__2, struct ZToken77 * SourceToken__3) {
	LibZen_Assert(!/*untyped*/NULL(FieldType), "(libzen/libzen.zen:1483)");
	if (this->FieldList == NULL) {
		this->FieldList = LibZen_NewArray(0);
	};
	struct ZClassField79 * ClassField = ZClassField__5qei(_NewZClassField79(), this, FieldName, FieldType, SourceToken);
	LibZen_ArrayAdd((ArrayOfVar *)this->FieldList, (var)ClassField);
	return ClassField;
}
static const char * ZFunc_StringfySignature__3qqy(const char * FuncName, long FuncParamSize__1, struct ZType60 * RecvType__2) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(FuncName, "__"), LibZen_IntToString(FuncParamSize)), GetUniqueName__1qwz(RecvType));
}
static struct ZFunc89 * ZFunc__4qeh(struct ZFunc89 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3) {
	this->FuncFlag = FuncFlag;
	this->FuncName = FuncName;
	this->FuncType = FuncType;
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1qeh(struct ZFunc89 * this) {
	return this->FuncType;
}
static const char * toString__1qeh(struct ZFunc89 * this) {
	return LibZen_StrCat(LibZen_StrCat(this->FuncName, ": "), toString__1qwz(this->FuncType));
}
static int IsConverterFunc__1qeh(struct ZFunc89 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_ConverterFunc_Z15);
}
static int IsCoercionFunc__1qeh(struct ZFunc89 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_CoercionFunc_Z16);
}
static int Is__2qeh(struct ZFunc89 * this, long Flag__1) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, Flag);
}
static const char * GetSignature__1qeh(struct ZFunc89 * this) {
	return StringfySignature__2qej(this->FuncType, this->FuncName);
}
static struct ZFuncType90 * ZFuncType__3qej(struct ZFuncType90 * this, const char * ShortName__1, ArrayOfZType * UniqueTypeParams__2) {
	(void)ZType__4qwz(this, ZTypeUniqueTypeFlag_Z1, ShortName, ZTypeVarType_Z4);
	if (UniqueTypeParams == NULL) {
		this->TypeParams = LibZen_NewTypeArray__1qqr(1);
		Array<ZType>SetIndex(0, ZTypeVarType_Z4);
	} else {
		this->TypeParams = UniqueTypeParams;
	};
	long i = 0;
	while (i < LibZen_ArraySize((ArrayOfVar *)this->TypeParams)) {
		if (Array<ZType>GetIndex(i)->IsVarType(Array<ZType>GetIndex(i))) {
			this->HasUnknownType = 1/*true*/;
		};
		if (Array<ZType>GetIndex(i)->IsGreekType(Array<ZType>GetIndex(i))) {
			this->HasGreekType = 1/*true*/;
		};
		i = i + 1;
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
		ArrayOfZType * TypeList = LibZen_NewArray(0);
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)this->TypeParams)) {
			LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)Array<ZType>GetIndex(i)->GetGreekRealType(Array<ZType>GetIndex(i), Greek));
			i = i + 1;
		};
		return ZTypePool_LookupFuncType__1qwx(TypeList);
	};
	return this;
}
static int AcceptValueType__4qej(struct ZFuncType90 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (IsFuncType__1qwz(ValueType) && /*untyped*/NULL(ValueType) == /*untyped*/NULL(this)) {
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)this->TypeParams)) {
			if (!/*untyped*/NULL(Array<ZType>GetIndex(i), /*untyped*/NULL(ValueType, i), 1/*true*/, Greek)) {
				return 0/*false*/;
			};
			i = i + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static const char * StringfySignature__2qej(struct ZFuncType90 * this, const char * FuncName__1) {
	return ZFunc_StringfySignature__3qqy(FuncName, GetFuncParamSize__1qej(this), GetRecvType__1qej(this));
}
static struct ZType60 * GetBaseType__1qej(struct ZFuncType90 * this) {
	return ZTypeFuncType_Z13;
}
static long GetParamSize__1qej(struct ZFuncType90 * this) {
	return LibZen_ArraySize((ArrayOfVar *)this->TypeParams);
}
static struct ZType60 * GetParamType__2qej(struct ZFuncType90 * this, long Index__1) {
	return Array<ZType>GetIndex(Index);
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
	return Array<ZType>GetIndex(Index + 1);
}
static struct ZFuncType90 * NewMethodFuncType__2qej(struct ZFuncType90 * this, struct ZType60 * RecvType__1) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)GetReturnType__1qej(this));
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)RecvType);
	long i = 0;
	while (i < GetFuncParamSize__1qej(this)) {
		LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)GetFuncParamType__2qej(this, i));
		i = i + 1;
	};
	return ZTypePool_LookupFuncType__1qwx(TypeList);
}
static int AcceptAsFieldFunc__2qej(struct ZFuncType90 * this, struct ZFuncType90 * FuncType__1) {
	if (GetFuncParamSize__1qej(FuncType) == GetFuncParamSize__1qej(this) && Equals__2qwz(GetReturnType__1qej(FuncType), GetReturnType__1qej(this))) {
		long i = 1;
		while (i < GetFuncParamSize__1qej(FuncType)) {
			if (!Equals__2qwz(GetFuncParamType__2qej(FuncType, i), GetFuncParamType__2qej(this, i))) {
				return 0/*false*/;
			};
			i = i + 1;
		};
	};
	return 1/*true*/;
}
static struct ZGeneric1Type107 * ZGeneric1Type__5qe8(struct ZGeneric1Type107 * this, long TypeFlag__1, const char * ShortName__2, struct ZType60 * BaseType__3, struct ZType60 * ParamType__4) {
	(void)ZType__4qwz(this, TypeFlag, ShortName, ZTypeVarType_Z4);
	this->BaseType = BaseType;
	if (this->BaseType == NULL) {
		this->BaseType = this;
	};
	this->ParamType = ParamType;
	return NULL;
}
static struct ZType60 * GetSuperType__1qe8(struct ZGeneric1Type107 * this) {
	if (this->BaseType == this) {
		return this->RefType;
	};
	return this->BaseType;
}
static struct ZType60 * GetBaseType__1qe8(struct ZGeneric1Type107 * this) {
	return this->BaseType;
}
static long GetParamSize__1qe8(struct ZGeneric1Type107 * this) {
	return 1;
}
static struct ZType60 * GetParamType__2qe8(struct ZGeneric1Type107 * this, long Index__1) {
	if (Index == 0) {
		return this->ParamType;
	};
	return NULL;
}
static int IsGreekType__1qe8(struct ZGeneric1Type107 * this) {
	return /*untyped*/NULL;
}
static struct ZType60 * GetGreekRealType__2qe8(struct ZGeneric1Type107 * this, ArrayOfZType * Greek__1) {
	if (this->ParamType->IsGreekType(this->ParamType)) {
		return ZTypePool_GetGenericType1__2qwz(this->BaseType, this->ParamType->GetGreekRealType(this->ParamType, Greek));
	};
	return this->GetRealType(this);
}
static int AcceptValueType__4qe8(struct ZGeneric1Type107 * this, struct ZType60 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (this->BaseType == /*untyped*/NULL(ValueType) && /*untyped*/NULL(ValueType) == 1) {
		return /*untyped*/NULL(this->ParamType, /*untyped*/NULL(ValueType, 0), 1/*true*/, Greek);
	};
	return 0/*false*/;
}
static ArrayOfZType * ZGreekType_NewGreekTypes__1qwx(ArrayOfZType * GreekTypes) {
	if (GreekTypes == NULL) {
		return LibZen_NewTypeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)LibZen_GreekNames_Z0));
	} else {
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)GreekTypes)) {
			Array<ZType>SetIndex(i, NULL);
			i = i + 1;
		};
		return GreekTypes;
	};
}
static struct ZGreekType115 * ZGreekType__2qri(struct ZGreekType115 * this, long GreekId__1) {
	(void)ZType__4qwz(this, ZTypeUniqueTypeFlag_Z1, Array<String>GetIndex(GreekId), ZTypeVarType_Z4);
	this->GreekId = GreekId;
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
		if (/*untyped*/NULL(ValueType)) {
			return 1/*true*/;
		};
		Array<ZType>SetIndex(this->GreekId, ValueType);
		return 1/*true*/;
	} else {
		return /*untyped*/NULL(Array<ZType>GetIndex(this->GreekId), ValueType, ExactMatch, Greek);
	};
}
static struct ZPrototype121 * ZPrototype__5qrs(struct ZPrototype121 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3, struct ZToken77 * SourceToken__4) {
	(void)ZFunc__4qeh(this, FuncFlag, FuncName, FuncType);
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
	long TypeId = LibZen_ArraySize((ArrayOfVar *)ZTypePool_TypeList_Z17);
	LibZen_ArrayAdd((ArrayOfVar *)ZTypePool_TypeList_Z17, (var)T);
	return TypeId;
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
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(Type1->TypeId)), ":"), LibZen_IntToString(Type2->TypeId));
}
static const char * ZTypePool_MangleTypes__1qwx(ArrayOfZType * TypeList) {
	const char * s = "";
	long i = 0;
	while (i < LibZen_ArraySize((ArrayOfVar *)TypeList)) {
		struct ZType60 * Type = Array<ZType>GetIndex(i);
		s = LibZen_StrCat(LibZen_StrCat(s, ":"), LibZen_IntToString(Type->TypeId));
		i = i + 1;
	};
	return s;
}
static ArrayOfZType * ZTypePool_UniqueTypes__1qwx(ArrayOfZType * TypeList) {
	const char * MangleName = LibZen_StrCat("[]", ZTypePool_MangleTypes__1qwx(TypeList));
	ArrayOfZType * Types = Map<Array<ZType>>GetIndex(MangleName);
	if (Types == NULL) {
		Types = /*untyped*/NULL;
		Map<Array<ZType>>SetIndex(MangleName, Types);
	};
	return Types;
}
static struct ZType60 * ZTypePool_GetGenericType1__2qwz(struct ZType60 * BaseType, struct ZType60 * ParamType__1) {
	const char * MangleName = ZTypePool_MangleType2__2qwz(BaseType, ParamType);
	struct ZType60 * GenericType = Map<ZType>GetIndex(MangleName);
	if (GenericType == NULL) {
		const char * Name = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), toString__1qwz(ParamType)), ">");
		if (IsArrayType__1qwz(BaseType)) {
			Name = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), toString__1qwz(ParamType)), ">");
		};
		GenericType = ZGeneric1Type__5qe8(_NewZGeneric1Type107(), ZTypeUniqueTypeFlag_Z1, Name, BaseType, ParamType);
		Map<ZType>SetIndex(MangleName, GenericType);
	};
	return GenericType;
}
static struct ZType60 * ZTypePool_GetGenericType__3qwz(struct ZType60 * BaseType, ArrayOfZType * TypeList__1, int IsCreation__2) {
	LibZen_Assert(BaseType->GetParamSize(BaseType) > 0, "(libzen/libzen.zen:1800)");
	if (LibZen_ArraySize((ArrayOfVar *)TypeList) == 1 && !IsFuncType__1qwz(BaseType)) {
		return ZTypePool_GetGenericType1__2qwz(BaseType, Array<ZType>GetIndex(0));
	};
	const char * MangleName = LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(BaseType->TypeId)), ZTypePool_MangleTypes__1qwx(TypeList));
	struct ZType60 * GenericType = Map<ZType>GetIndex(MangleName);
	if ((GenericType == NULL) && IsCreation) {
		const char * ShortName = LibZen_StrCat(BaseType->ShortName, "<");
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)TypeList)) {
			ShortName = LibZen_StrCat(ShortName, Array<ZType>GetIndex(i)->GetRealType(Array<ZType>GetIndex(i))->ShortName);
			if ((i + 1) == LibZen_ArraySize((ArrayOfVar *)TypeList)) {
				ShortName = LibZen_StrCat(ShortName, ">");
			} else {
				ShortName = LibZen_StrCat(ShortName, ",");
			};
			i = i + 1;
		};
		if (IsFuncType__1qwz(BaseType)) {
			GenericType = ZFuncType__3qej(_NewZFuncType90(), ShortName, ZTypePool_UniqueTypes__1qwx(TypeList));
		} else {
		};
		Map<ZType>SetIndex(MangleName, GenericType);
	};
	return GenericType;
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__1qwx(ArrayOfZType * TypeList) {
	struct ZType60 * FuncType = ZTypePool_GetGenericType__3qwz(ZTypeFuncType_Z13, TypeList, 1/*true*/);
	if (LibZen_Is(FuncType, 90)) {
		return (struct ZFuncType90 *)FuncType;
	};
	return NULL;
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__1qwz(struct ZType60 * R) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	return ZTypePool_LookupFuncType__1qwx(TypeList);
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__2qwz(struct ZType60 * R, struct ZType60 * P1__1) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P1);
	return ZTypePool_LookupFuncType__1qwx(TypeList);
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__3qwz(struct ZType60 * R, struct ZType60 * P1__1, struct ZType60 * P2__2) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P1);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P2);
	return ZTypePool_LookupFuncType__1qwx(TypeList);
}
static struct ZFuncType90 * ZTypePool_LookupFuncType__4qwz(struct ZType60 * R, struct ZType60 * P1__1, struct ZType60 * P2__2, struct ZType60 * P3__3) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P1);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P2);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P3);
	return ZTypePool_LookupFuncType__1qwx(TypeList);
}
static struct ZVarScope134 * ZVarScope__4qrc(struct ZVarScope134 * this, struct ZVarScope134 * Parent__1, struct ZLogger135 * Logger__2, ArrayOfZVarType * VarList__3) {
	this->Parent = Parent;
	this->Logger = Logger;
	this->VarList = VarList;
	if (this->VarList == NULL) {
		this->VarList = LibZen_NewArray(0);
	};
	return NULL;
}
static struct ZType60 * NewVarType__4qrc(struct ZVarScope134 * this, struct ZType60 * VarType__1, const char * Name__2, struct ZToken77 * SourceToken__3) {
	if (!(LibZen_Is(VarType, 136)) && /*untyped*/NULL(VarType)) {
		VarType = ZVarType__4qrb(_NewZVarType136(), this->VarList, Name, SourceToken);
	};
	return VarType;
}
static void FoundUnresolvedSymbol__2qrc(struct ZVarScope134 * this, const char * FuncName__1) {
	this->UnresolvedSymbolCount = this->UnresolvedSymbolCount + 1;
	return;
}
static void CheckVarNode__3qrc(struct ZVarScope134 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2) {
	if (IsUntyped__1qwg(Node)) {
		this->VarNodeCount = this->VarNodeCount + 1;
	};
	if (IsInferrableType__1qwz(ContextType) && LibZen_Is(Node->Type, 136)) {
		Infer__3qrb(((struct ZVarType136 *)Node->Type), ContextType, Node->SourceToken);
		Node->Type = ContextType;
	};
	if (LibZen_Is(ContextType, 136) && !IsUntyped__1qwg(Node)) {
		Infer__3qrb(((struct ZVarType136 *)ContextType), Node->Type, Node->SourceToken);
	};
	return;
}
static int TypeCheckStmtList__3qrc(struct ZVarScope134 * this, struct ZTypeChecker142 * TypeSafer__1, ArrayOfZNode * StmtList__2) {
	long PrevCount = -1;
	while (1/*true*/) {
		long i = 0;
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)StmtList)) {
			Array<ZNode>SetIndex(i, CheckType__3qr2(TypeSafer, Array<ZNode>GetIndex(i), ZTypeVoidType_Z5));
			i = i + 1;
		};
		if (this->VarNodeCount == 0 || PrevCount == this->VarNodeCount) {
			break;
		};
		PrevCount = this->VarNodeCount;
	};
	if (this->VarNodeCount == 0) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void TypeCheckFuncBlock__3qrc(struct ZVarScope134 * this, struct ZTypeChecker142 * TypeSafer__1, struct ZFunctionNode144 * FunctionNode__2) {
	long PrevCount = -1;
	while (1/*true*/) {
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		/*untyped*/NULL(TypeSafer, FunctionNode, 0/*false*/);
		Array<ZNode>SetIndex(ZFunctionNode_Block_Z80, CheckType__3qr2(TypeSafer, Array<ZNode>GetIndex(ZFunctionNode_Block_Z80), ZTypeVoidType_Z5));
		if (this->VarNodeCount == 0 || PrevCount == this->VarNodeCount) {
			break;
		};
		PrevCount = this->VarNodeCount;
	};
	if (this->UnresolvedSymbolCount == 0) {
		/*untyped*/NULL(TypeSafer, FunctionNode, 1/*true*/);
	} else {
		/*untyped*/NULL(TypeSafer, FunctionNode, 0/*false*/);
		if (this->Parent != NULL) {
			this->Parent->UnresolvedSymbolCount = this->UnresolvedSymbolCount + this->Parent->UnresolvedSymbolCount;
		};
	};
	return;
}
static struct ZVarType136 * ZVarType__4qrb(struct ZVarType136 * this, ArrayOfZVarType * VarList__1, const char * Name__2, struct ZToken77 * SourceToken__3) {
	(void)ZType__4qwz(this, 0, Name, ZTypeVarType_Z4);
	this->VarList = VarList;
	this->SourceToken = SourceToken;
	this->GreekId = LibZen_ArraySize((ArrayOfVar *)VarList);
	LibZen_ArrayAdd((ArrayOfVar *)VarList, (var)this);
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
	return /*untyped*/NULL(this->RefType, Index);
}
static int IsFuncType__1qrb(struct ZVarType136 * this) {
	return IsFuncType__1qwz(this->RefType);
}
static int IsVarType__1qrb(struct ZVarType136 * this) {
	return /*untyped*/NULL(this->RefType);
}
static void Infer__3qrb(struct ZVarType136 * this, struct ZType60 * ContextType__1, struct ZToken77 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(ContextType, 136) && /*untyped*/NULL(ContextType)) {
			struct ZVarType136 * VarType = (struct ZVarType136 *)ContextType;
			if (this->GreekId < VarType->GreekId) {
				VarType->GreekId = this->GreekId;
			} else {
				this->GreekId = VarType->GreekId;
			};
		} else {
			this->RefType = /*untyped*/NULL(ContextType);
			this->SourceToken = SourceToken;
			this->TypeId = this->RefType->TypeId;
			this->TypeFlag = this->RefType->TypeFlag;
		};
	};
	return;
}
static void Maybe__3qrb(struct ZVarType136 * this, struct ZType60 * T__1, struct ZToken77 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(T, 136) && /*untyped*/NULL(T)) {
			struct ZVarType136 * VarType = (struct ZVarType136 *)T;
			if (this->GreekId < VarType->GreekId) {
				VarType->GreekId = this->GreekId;
			} else {
				this->GreekId = VarType->GreekId;
			};
		} else {
			this->RefType = /*untyped*/NULL(T);
			this->SourceToken = SourceToken;
			this->TypeId = T->TypeId;
			this->TypeFlag = T->TypeFlag;
		};
	};
	return;
}
static struct ZNode52 * ZNode__4qwg(struct ZNode52 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, long Size__3) {
	LibZen_Assert(this != ParentNode, "(libzen/libzen.zen:2008)");
	this->ParentNode = ParentNode;
	this->SourceToken = SourceToken;
	if (Size > 0) {
		this->AST = LibZen_NewNodeArray__1qqr(Size);
	} else {
		this->AST = NULL;
	};
	return NULL;
}
static struct ZNode52 * SetChild__2qwg(struct ZNode52 * this, struct ZNode52 * Node__1) {
	LibZen_Assert(Node != NULL, "(libzen/libzen.zen:2020)");
	if (Node != NULL) {
		LibZen_Assert(this != Node, "(libzen/libzen.zen:2022)");
		Node->ParentNode = this;
	};
	return Node;
}
static void SetNameInfo__3qwg(struct ZNode52 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	LibZen_Assert(Name == NULL, "(libzen/libzen.zen:2029)");
	return;
}
static void SetTypeInfo__3qwg(struct ZNode52 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->Type = Type;
	return;
}
static void Set__3qwg(struct ZNode52 * this, long Index__1, struct ZNode52 * Node__2) {
	if (Index >= 0) {
		Array<ZNode>SetIndex(Index, SetChild__2qwg(this, Node));
	} else if (Index == ZNode_AppendIndex_Z23) {
		struct ZNode52 * ListNode = this;
		if (LibZen_Is(ListNode, 251)) {
			Append__2qu8(((struct ZListNode251 *)ListNode), Node);
		} else {
			LibZen_Assert(LibZen_Is(ListNode, 251), "(libzen/libzen.zen:2046)");
		};
	} else if (Index == ZNode_NameInfo_Z21) {
		/*untyped*/NULL(this, Node->SourceToken, GetText__1qey(Node->SourceToken));
		this->SourceToken = Node->SourceToken;
		return;
	} else if (Index == ZNode_TypeInfo_Z22) {
		/*untyped*/NULL(this, Node->SourceToken, Node->Type);
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
	if (this->AST != NULL && Index < LibZen_ArraySize((ArrayOfVar *)this->AST)) {
		return Array<ZNode>GetIndex(Index) != NULL;
	};
	return 0/*false*/;
}
static struct ZType60 * GetAstType__2qwg(struct ZNode52 * this, long Index__1) {
	return /*untyped*/NULL(Array<ZNode>GetIndex(Index)->Type);
}
static const char * GetSourceLocation__1qwg(struct ZNode52 * this) {
	if (this->SourceToken != NULL) {
		return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", GetFileName__1qey(this->SourceToken)), ":"), LibZen_IntToString(GetLineNumber__1qey(this->SourceToken))), ")");
	};
	return NULL;
}
static const char * toString__1qwg(struct ZNode52 * this) {
	const char * Self = LibZen_StrCat("#", /*untyped*/NULL(this));
	if (!this->Type->IsVarType(this->Type)) {
		Self = LibZen_StrCat(LibZen_StrCat(Self, ":"), toString__1qwz(this->Type));
	} else {
		Self = LibZen_StrCat(Self, ":?");
	};
	if (this->AST != NULL) {
		long i = 0;
		Self = LibZen_StrCat(Self, "[");
		while (i < LibZen_ArraySize((ArrayOfVar *)this->AST)) {
			if (i > 0) {
				Self = LibZen_StrCat(Self, ",");
			};
			if (Array<ZNode>GetIndex(i) == NULL) {
				Self = LibZen_StrCat(Self, "null");
			} else {
				Self = LibZen_StrCat(Self, toString__1qwg(Array<ZNode>GetIndex(i)));
			};
			i = i + 1;
		};
		Self = LibZen_StrCat(Self, "]");
	};
	return Self;
}
static struct ZBlockNode161 * GetScopeBlockNode__1qwg(struct ZNode52 * this) {
	struct ZNode52 * Node = this;
	while (Node != NULL) {
		if (LibZen_Is(Node, 161)) {
			return (struct ZBlockNode161 *)Node;
		};
		if (Node == Node->ParentNode) {
			/*untyped*/NULLlongjump(1) ;
		};
		Node = Node->ParentNode;
	};
	return NULL;
}
static struct ZNameSpace48 * GetNameSpace__1qwg(struct ZNode52 * this) {
	struct ZBlockNode161 * BlockNode = GetScopeBlockNode__1qwg(this);
	return BlockNode->NameSpace;
}
static int IsErrorNode__1qwg(struct ZNode52 * this) {
	return (LibZen_Is(this, 336));
}
static int IsBreakingBlock__1qwg(struct ZNode52 * this) {
	return 0/*false*/;
}
static struct ZSugarNode165 * DeSugar__2qwg(struct ZNode52 * this, struct ZGenerator55 * Generator__1) {
	return ZSugarNode__3qt9(_NewZSugarNode165(), this, ZErrorNode__3qpa(_NewZErrorNode336(), this->ParentNode, LibZen_StrCat("undefined code generation: ", toString__1qwg(this))));
}
static void Accept__2qwg(struct ZNode52 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsUntyped__1qwg(struct ZNode52 * this) {
	return /*untyped*/NULL(this->Type);
}
static int HasUntypedNode__1qwg(struct ZNode52 * this) {
	if (this->HasUntypedNode) {
		if (!IsUntyped__1qwg(this)) {
			long i = 0;
			while (i < GetAstSize__1qwg(this)) {
				if (Array<ZNode>GetIndex(i) != NULL && HasUntypedNode__1qwg(Array<ZNode>GetIndex(i))) {
					return 1/*true*/;
				};
				i = i + 1;
			};
			this->HasUntypedNode = 0/*false*/;
			return 0/*false*/;
		};
	};
	return this->HasUntypedNode;
}
static struct ZNode52 * VisitTypeChecker__3qwg(struct ZNode52 * this, struct ZTypeChecker142 * TypeChecker__1, struct ZType60 * ContextType__2) {
	return VisitTypeChecker__3qr2(TypeChecker, this, ContextType);
}
static struct ZReturnNode170 * ToReturnNode__1qwg(struct ZNode52 * this) {
	return NULL;
}
static struct ZParamNode172 * ZParamNode__2qtb(struct ZParamNode172 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetNameInfo__3qtb(struct ZParamNode172 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->Name = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZReturnNode170 * ZReturnNode__2qtc(struct ZReturnNode170 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	return NULL;
}
static void Accept__2qtc(struct ZReturnNode170 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZReturnNode170 * ToReturnNode__1qtc(struct ZReturnNode170 * this) {
	return this;
}
static struct ZSetIndexNode178 * ZSetIndexNode__3qt2(struct ZSetIndexNode178 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 3);
	Set__3qwg(this, ZSetIndexNode_Recv_Z26, LeftNode);
	return NULL;
}
static void Accept__2qt2(struct ZSetIndexNode178 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZSetNameNode181 * ZSetNameNode__4qyw(struct ZSetNameNode181 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * VarName__3) {
	(void)ZNode__4qwg(this, ParentNode, Token, 1);
	this->VarName = VarName;
	return NULL;
}
static void Accept__2qyw(struct ZSetNameNode181 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZSetterNode184 * ZSetterNode__3qyt(struct ZSetterNode184 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 2);
	Set__3qwg(this, ZSetterNode_Recv_Z30, RecvNode);
	return NULL;
}
static void SetNameInfo__3qyt(struct ZSetterNode184 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qyt(struct ZSetterNode184 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsStaticField__1qyt(struct ZSetterNode184 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZSetterNode_Recv_Z30), 235);
}
static struct ZSugarNode165 * ZSugarNode__3qt9(struct ZSugarNode165 * this, struct ZNode52 * SugarNode__1, struct ZNode52 * DeSugarNode__2) {
	(void)ZNode__4qwg(this, SugarNode->ParentNode, NULL, 1);
	this->SugarNode = SugarNode;
	SugarNode->ParentNode = this;
	Set__3qwg(this, ZSugarNode_DeSugar_Z32, DeSugarNode);
	DeSugarNode->ParentNode = this;
	return NULL;
}
static void Accept__2qt9(struct ZSugarNode165 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZThrowNode191 * ZThrowNode__2qy4(struct ZThrowNode191 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	return NULL;
}
static void Accept__2qy4(struct ZThrowNode191 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZTryNode194 * ZTryNode__2qyd(struct ZTryNode194 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 3);
	return NULL;
}
static void Accept__2qyd(struct ZTryNode194 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZUnaryNode197 * ZUnaryNode__3qyh(struct ZUnaryNode197 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2) {
	(void)ZNode__4qwg(this, ParentNode, Token, 1);
	return NULL;
}
static void Accept__2qyh(struct ZUnaryNode197 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZWhileNode200 * ZWhileNode__2qyl(struct ZWhileNode200 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 2);
	return NULL;
}
static void Accept__2qyl(struct ZWhileNode200 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static const char * toString__1qy6(struct ZEmptyValue203 * this) {
	return "";
}
static const char * ZLogger_LogError__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu1(Token->Source, "error", Token->StartIndex, Message);
		Report__2qrv(Token->Source->Logger, Message);
	};
	return Message;
}
static void ZLogger_LogWarning__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu1(Token->Source, "warning", Token->StartIndex, Message);
		Report__2qrv(Token->Source->Logger, Message);
	};
	return;
}
static void ZLogger_LogInfo__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu1(Token->Source, "info", Token->StartIndex, Message);
		Report__2qrv(Token->Source->Logger, Message);
	};
	return;
}
static void ZLogger_LogDebug__2qey(struct ZToken77 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu1(Token->Source, "debug", Token->StartIndex, Message);
		Report__2qrv(Token->Source->Logger, Message);
	};
	return;
}
static void Report__2qrv(struct ZLogger135 * this, const char * Message__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->ReportedErrorList, (var)Message);
	return;
}
static ArrayOfString * GetReportedErrors__1qrv(struct ZLogger135 * this) {
	ArrayOfString * List = this->ReportedErrorList;
	this->ReportedErrorList = LibZen_NewStringArray(0);
	return /*untyped*/NULL;
}
static void ShowErrors__1qrv(struct ZLogger135 * this) {
	ArrayOfString * Messages = GetReportedErrors__1qrv(this);
	long i = 0;
	while (i < LibZen_ArraySize((ArrayOfVar *)Messages)) {
		LibZen_PrintLine__1qqy(Array<String>GetIndex(i));
		i = i + 1;
	};
	return;
}
static struct ZMacroFunc210 * ZMacroFunc__3qym(struct ZMacroFunc210 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2) {
	(void)ZFunc__4qeh(this, 0, FuncName, FuncType);
	return NULL;
}
static const char * ZNameSpace_RightPatternSymbol__1qqy(const char * PatternName) {
	return LibZen_StrCat("\t", PatternName);
}
static struct ZNameSpace48 * ZNameSpace__3qwa(struct ZNameSpace48 * this, struct ZGenerator55 * Generator__1, struct ZNameSpace48 * ParentNameSpace__2) {
	this->ParentNameSpace = ParentNameSpace;
	if (ParentNameSpace == NULL) {
		this->Generator = Generator;
	} else {
		this->Generator = ParentNameSpace->Generator;
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
		return GetTokenFunc__2qwa(this->ParentNameSpace, ZenChar);
	};
	return Array<ZTokenFunc>GetIndex(ZenChar);
}
static struct ZTokenFunc35 * JoinParentFunc__3qwa(struct ZNameSpace48 * this, struct ZTokenFunction216 * Func__1, struct ZTokenFunc35 * Parent__2) {
	if (Parent != NULL && Parent->Func == Func) {
		return Parent;
	};
	return ZTokenFunc__3qq8(_NewZTokenFunc35(), Func, Parent);
}
static void AppendTokenFunc__3qwa(struct ZNameSpace48 * this, const char * keys__1, struct ZTokenFunction216 * TokenFunc__2) {
	if (this->TokenMatrix == NULL) {
		this->TokenMatrix = LibZen_NewTokenMatrix__0qqw();
		if (this->ParentNameSpace != NULL) {
			long i = 0;
			while (i < LibZen_ArraySize((ArrayOfVar *)this->TokenMatrix)) {
				Array<ZTokenFunc>SetIndex(i, GetTokenFunc__2qwa(this->ParentNameSpace, i));
				i = i + 1;
			};
		};
	};
	long i = 0;
	while (i < LibZen_StringSize(keys)) {
		long kchar = LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(keys, i));
		Array<ZTokenFunc>SetIndex(kchar, JoinParentFunc__3qwa(this, TokenFunc, Array<ZTokenFunc>GetIndex(kchar)));
		i = i + 1;
	};
	return;
}
static struct ZSyntax219 * GetSyntaxPattern__2qwa(struct ZNameSpace48 * this, const char * PatternName__1) {
	struct ZNameSpace48 * NameSpace = this;
	while (NameSpace != NULL) {
		if (NameSpace->SyntaxTable != NULL) {
			return Map<ZSyntax>GetIndex(PatternName);
		};
		NameSpace = NameSpace->ParentNameSpace;
	};
	return NULL;
}
static void SetSyntaxPattern__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZSyntax219 * Syntax__2) {
	if (this->SyntaxTable == NULL) {
		this->SyntaxTable = LibZen_NewMap(0);
	};
	Map<ZSyntax>SetIndex(PatternName, Syntax);
	return;
}
static struct ZSyntax219 * GetRightSyntaxPattern__2qwa(struct ZNameSpace48 * this, const char * PatternName__1) {
	return GetSyntaxPattern__2qwa(this, ZNameSpace_RightPatternSymbol__1qqy(PatternName));
}
static void AppendSyntaxPattern__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZSyntax219 * NewPattern__2) {
	LibZen_Assert__1qqe(NewPattern->ParentPattern == NULL);
	struct ZSyntax219 * ParentPattern = GetSyntaxPattern__2qwa(this, PatternName);
	NewPattern->ParentPattern = ParentPattern;
	SetSyntaxPattern__3qwa(this, PatternName, NewPattern);
	return;
}
static void DefineStatement__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZMatchFunction222 * MatchFunc__2) {
	long Alias = LibZen_IndexOf(PatternName, " ");
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = LibZen_SubString2(PatternName, 0);
	};
	struct ZSyntax219 * Pattern = ZSyntax__4qur(_NewZSyntax219(), this, Name, MatchFunc);
	Pattern->IsStatement = 1/*true*/;
	AppendSyntaxPattern__3qwa(this, Name, Pattern);
	if (Alias != -1) {
		DefineStatement__3qwa(this, LibZen_SubString(PatternName, Alias + 1), MatchFunc);
	};
	return;
}
static void DefineExpression__3qwa(struct ZNameSpace48 * this, const char * PatternName__1, struct ZMatchFunction222 * MatchFunc__2) {
	long Alias = LibZen_IndexOf(PatternName, " ");
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = LibZen_SubString2(PatternName, 0);
	};
	struct ZSyntax219 * Pattern = ZSyntax__4qur(_NewZSyntax219(), this, Name, MatchFunc);
	AppendSyntaxPattern__3qwa(this, Name, Pattern);
	if (Alias != -1) {
		DefineExpression__3qwa(this, LibZen_SubString(PatternName, Alias + 1), MatchFunc);
	};
	return;
}
static void DefineRightExpression__4qwa(struct ZNameSpace48 * this, const char * PatternName__1, long SyntaxFlag__2, struct ZMatchFunction222 * MatchFunc__3) {
	long Alias = LibZen_IndexOf(PatternName, " ");
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = LibZen_SubString2(PatternName, 0);
	};
	struct ZSyntax219 * Pattern = ZSyntax__4qur(_NewZSyntax219(), this, Name, MatchFunc);
	Pattern->SyntaxFlag = SyntaxFlag;
	AppendSyntaxPattern__3qwa(this, ZNameSpace_RightPatternSymbol__1qqy(Name), Pattern);
	if (Alias != -1) {
		DefineRightExpression__4qwa(this, LibZen_SubString(PatternName, Alias + 1), SyntaxFlag, MatchFunc);
	};
	return;
}
static struct ZSymbolEntry225 * GetSymbol__2qwa(struct ZNameSpace48 * this, const char * Symbol__1) {
	struct ZNameSpace48 * NameSpace = this;
	while (NameSpace != NULL) {
		if (NameSpace->SymbolTable != NULL) {
			struct ZSymbolEntry225 * Entry = Map<ZSymbolEntry>GetIndex(Symbol);
			if (Entry != NULL) {
				if (Entry->IsDisabled) {
					return NULL;
				};
				return Entry;
			};
		};
		NameSpace = NameSpace->ParentNameSpace;
	};
	return NULL;
}
static struct ZNode52 * GetSymbolNode__2qwa(struct ZNameSpace48 * this, const char * Symbol__1) {
	struct ZSymbolEntry225 * Entry = GetSymbol__2qwa(this, Symbol);
	if (Entry != NULL) {
		return Entry->Node;
	};
	return NULL;
}
static void SetLocalSymbolEntry__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZSymbolEntry225 * Entry__2) {
	if (this->SymbolTable == NULL) {
		this->SymbolTable = LibZen_NewMap(0);
	};
	Map<ZSymbolEntry>SetIndex(Symbol, Entry);
	return;
}
static struct ZSymbolEntry225 * SetLocalSymbol__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZNode52 * Node__2) {
	struct ZSymbolEntry225 * Parent = GetSymbol__2qwa(this, Symbol);
	Node->ParentNode = NULL;
	SetLocalSymbolEntry__3qwa(this, Symbol, ZSymbolEntry__3qup(_NewZSymbolEntry225(), Parent, Node));
	return Parent;
}
static struct ZSymbolEntry225 * SetGlobalSymbol__3qwa(struct ZNameSpace48 * this, const char * Symbol__1, struct ZNode52 * Node__2) {
	return SetLocalSymbol__3qwa(GetRootNameSpace__1qwa(this), Symbol, Node);
}
static struct ZVariable230 * GetLocalVariable__2qwa(struct ZNameSpace48 * this, const char * VarName__1) {
	struct ZSymbolEntry225 * Entry = GetSymbol__2qwa(this, VarName);
	if (LibZen_Is(Entry, 230)) {
		return (struct ZVariable230 *)Entry;
	};
	return NULL;
}
static void SetLocalVariable__5qwa(struct ZNameSpace48 * this, struct ZFunctionNode144 * FunctionNode__1, struct ZType60 * VarType__2, const char * VarName__3, struct ZToken77 * SourceToken__4) {
	struct ZSymbolEntry225 * Parent = GetSymbol__2qwa(this, VarName);
	struct ZVariable230 * VarInfo = ZVariable__7qud(_NewZVariable230(), Parent, FunctionNode, 0, VarType, VarName, SourceToken);
	SetLocalSymbolEntry__3qwa(this, VarName, VarInfo);
	return;
}
static void SetTypeName__4qwa(struct ZNameSpace48 * this, const char * Name__1, struct ZType60 * Type__2, struct ZToken77 * SourceToken__3) {
	struct ZTypeNode235 * Node = ZTypeNode__4quk(_NewZTypeNode235(), NULL, SourceToken, Type);
	(void)SetLocalSymbol__3qwa(this, Name, Node);
	return;
}
static void SetTypeName__3qwa(struct ZNameSpace48 * this, struct ZType60 * Type__1, struct ZToken77 * SourceToken__2) {
	SetTypeName__4qwa(this, Type->ShortName, Type, SourceToken);
	return;
}
static struct ZTypeNode235 * GetTypeNode__3qwa(struct ZNameSpace48 * this, const char * TypeName__1, struct ZToken77 * SourceToken__2) {
	struct ZNode52 * Node = GetSymbolNode__2qwa(this, TypeName);
	if (LibZen_Is(Node, 235)) {
		return (struct ZTypeNode235 *)Node;
	};
	if (Node == NULL && SourceToken != NULL) {
		struct ZType60 * Type = ZClassType__3qeo(_NewZClassType80(), TypeName, ZTypeVarType_Z4);
		SetTypeName__4qwa(GetRootNameSpace__1qwa(this), TypeName, Type, SourceToken);
		return GetTypeNode__3qwa(this, TypeName, NULL);
	};
	return NULL;
}
static struct ZType60 * GetType__3qwa(struct ZNameSpace48 * this, const char * TypeName__1, struct ZToken77 * SourceToken__2) {
	struct ZTypeNode235 * TypeNode = GetTypeNode__3qwa(this, TypeName, SourceToken);
	if (TypeNode != NULL) {
		return TypeNode->Type;
	};
	return NULL;
}
static struct ZSource238 * ZSource__5qu1(struct ZSource238 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext53 * TokenContext__4) {
	this->FileName = FileName;
	this->LineNumber = LineNumber;
	this->TokenContext = TokenContext;
	this->SourceText = Source;
	this->Logger = TokenContext->Generator->Logger;
	return NULL;
}
static long GetLineNumber__2qu1(struct ZSource238 * this, long Position__1) {
	long LineNumber = this->LineNumber;
	long i = 0;
	while (i < Position) {
		const char * ch = LibZen_GetChar__2qqy(this->SourceText, i);
		if (ch == "\n") {
			LineNumber = LineNumber + 1;
		};
		i = i + 1;
	};
	return LineNumber;
}
static long GetLineHeadPosition__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s = this->SourceText;
	long StartIndex = 0;
	long i = Position;
	if (!(i < LibZen_StringSize(s))) {
		i = LibZen_StringSize(s) - 1;
	};
	while (i >= 0) {
		const char * ch = LibZen_GetChar__2qqy(s, i);
		if (ch == "\n") {
			StartIndex = i + 1;
			break;
		};
		i = i - 1;
	};
	return StartIndex;
}
static long CountIndentSize__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s = this->SourceText;
	long length = 0;
	long i = Position;
	while (i < LibZen_StringSize(s)) {
		const char * ch = LibZen_GetChar__2qqy(s, i);
		if (ch == "\t") {
			length = length + 8;
		} else if (ch == " ") {
			length = length + 1;
		} else {
			break;
		};
		i = i + 1;
	};
	return length;
}
static const char * GetLineText__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s = this->SourceText;
	long StartIndex = 0;
	long EndIndex = LibZen_StringSize(s);
	long i = Position;
	if (!(i < LibZen_StringSize(s))) {
		i = LibZen_StringSize(s) - 1;
	};
	while (i >= 0) {
		const char * ch = LibZen_GetChar__2qqy(s, i);
		if (ch == "\n") {
			StartIndex = i + 1;
			break;
		};
		i = i - 1;
	};
	i = Position;
	while (i < LibZen_StringSize(s)) {
		const char * ch = LibZen_GetChar__2qqy(s, i);
		if (ch == "\n") {
			EndIndex = i;
			break;
		};
		i = i + 1;
	};
	return LibZen_SubString2(s, StartIndex);
}
static const char * GetLineMarker__2qu1(struct ZSource238 * this, long Position__1) {
	const char * s = this->SourceText;
	long StartIndex = 0;
	long i = Position;
	if (!(i < LibZen_StringSize(s))) {
		i = LibZen_StringSize(s) - 1;
	};
	while (i >= 0) {
		const char * ch = LibZen_GetChar__2qqy(s, i);
		if (ch == "\n") {
			StartIndex = i + 1;
			break;
		};
		i = i - 1;
	};
	const char * Line = "";
	i = StartIndex;
	while (i < Position) {
		const char * ch = LibZen_GetChar__2qqy(s, i);
		if (ch == "\n") {
			break;
		};
		if (ch == "\t") {
			Line = LibZen_StrCat(Line, "\t");
		} else {
			Line = LibZen_StrCat(Line, " ");
		};
		i = i + 1;
	};
	return LibZen_StrCat(Line, "^");
}
static const char * FormatErrorHeader__4qu1(struct ZSource238 * this, const char * Error__1, long Position__2, const char * Message__3) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", this->FileName), ":"), LibZen_IntToString(GetLineNumber__2qu1(this, Position))), ") ["), Error), "] "), Message);
}
static const char * FormatErrorMarker__4qu1(struct ZSource238 * this, const char * Error__1, long Position__2, const char * Message__3) {
	const char * Line = GetLineText__2qu1(this, Position);
	const char * Delim = "\n\t";
	if (LibZen_StartsWith(Line, "\t") || LibZen_StartsWith(Line, " ")) {
		Delim = "\n";
	};
	const char * Header = FormatErrorHeader__4qu1(this, Error, Position, Message);
	const char * Marker = GetLineMarker__2qu1(this, Position);
	Message = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(Header, Delim), Line), Delim), Marker);
	return Message;
}
static const char * GetCharAt__2qu1(struct ZSource238 * this, long n__1) {
	if (0 <= n && n < LibZen_StringSize(this->SourceText)) {
		return LibZen_GetChar__2qqy(this->SourceText, n);
	};
	return "0";
}
static struct ZSourceBuilder42 * ZSourceBuilder__3qwu(struct ZSourceBuilder42 * this, struct ZSourceGenerator243 * Template__1, struct ZSourceBuilder42 * Parent__2) {
	this->Template = Template;
	this->Parent = Parent;
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
	return LibZen_SourceBuilderToString__3qwu(this, BeginIndex, EndIndex);
}
static void Append__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
	return;
}
static void AppendInt__2qwu(struct ZSourceBuilder42 * this, long Value__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)LibZen_StrCat("", LibZen_IntToString(Value)));
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
	if (AppendIndent) {
		AppendIndent__1qwu(this);
	};
	return;
}
static void AppendWhiteSpace__1qwu(struct ZSourceBuilder42 * this) {
	long Size = LibZen_ArraySize((ArrayOfVar *)this->SourceList);
	if (Size > 0) {
		const char * Last = Array<String>GetIndex(Size - 1);
		if (Last != NULL && (LibZen_EndWidth(Last, " ") || LibZen_EndWidth(Last, "\n") || LibZen_EndWidth(Last, "\t"))) {
			return;
		};
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)" ");
	return;
}
static void AppendToken__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	AppendWhiteSpace__1qwu(this);
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
	AppendWhiteSpace__1qwu(this);
	return;
}
static void AppendBlockComment__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	if (this->Template->BeginComment != NULL) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->BeginComment);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->EndComment);
	} else if (this->Template->LineComment != NULL) {
		this->BufferedLineComment = LibZen_StrCat(LibZen_StrCat(this->BufferedLineComment, this->Template->LineComment), Text);
	};
	return;
}
static void AppendCommentLine__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	if (this->Template->LineComment == NULL) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->BeginComment);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->EndComment);
	} else {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineComment);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
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
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
	return;
}
static void AppendParamList__4qwu(struct ZSourceBuilder42 * this, struct ZListNode251 * ParamList__1, long BeginIdx__2, long EndIdx__3) {
	long i = BeginIdx;
	while (i < EndIdx) {
		if (i > BeginIdx) {
			Append__2qwu(this, this->Template->Camma);
		};
		/*untyped*/NULL(GetListAt__2qu8(ParamList, i), this->Template);
		i = i + 1;
	};
	return;
}
static const char * toString__1qwu(struct ZSourceBuilder42 * this) {
	return LibZen_SourceBuilderToString__1qwu(this);
}
static void AppendLine__2qwu(struct ZSourceBuilder42 * this, const char * Text__1) {
	Append__2qwu(this, Text);
	AppendLineFeed__1qwu(this);
	return;
}
static struct ZSourceContext50 * ZSourceContext__5qwd(struct ZSourceContext50 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext53 * TokenContext__4) {
	(void)ZSource__5qu1(this, FileName, LineNumber, Source, TokenContext);
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
	if ((this->SourcePosition + n) < LibZen_StringSize(this->SourceText)) {
		return LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition + n);
	};
	return "0";
}
static void MoveNext__1qwd(struct ZSourceContext50 * this) {
	this->SourcePosition = this->SourcePosition + 1;
	return;
}
static void SkipWhiteSpace__1qwd(struct ZSourceContext50 * this) {
	while (HasChar__1qwd(this)) {
		const char * ch = GetCurrentChar__1qwd(this);
		if (ch != " " && ch != "\t") {
			break;
		};
		MoveNext__1qwd(this);
	};
	return;
}
static void FoundIndent__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2) {
	struct ZToken77 * Token = ZIndentToken__4qab(_NewZIndentToken460(), this, StartIndex, EndIndex);
	this->SourcePosition = EndIndex;
	LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
	return;
}
static void Tokenize__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2) {
	this->SourcePosition = EndIndex;
	if (StartIndex < EndIndex && EndIndex <= LibZen_StringSize(this->SourceText)) {
		struct ZToken77 * Token = ZToken__4qey(_NewZToken77(), this, StartIndex, EndIndex);
		LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
	};
	return;
}
static void Tokenize__4qwd(struct ZSourceContext50 * this, const char * PatternName__1, long StartIndex__2, long EndIndex__3) {
	this->SourcePosition = EndIndex;
	if (StartIndex <= EndIndex && EndIndex <= LibZen_StringSize(this->SourceText)) {
		struct ZSyntax219 * Pattern = GetSyntaxPattern__2qwa(this->TokenContext->NameSpace, PatternName);
		if (Pattern == NULL) {
			struct ZToken77 * Token = ZToken__4qey(_NewZToken77(), this, StartIndex, EndIndex);
			ZLogger_LogInfo__2qey(Token, LibZen_StrCat("unregistered token pattern: ", PatternName));
			LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
		} else {
			struct ZToken77 * Token = ZPatternToken__5qam(_NewZPatternToken462(), this, StartIndex, EndIndex, Pattern);
			LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
		};
	};
	return;
}
static int IsDefinedSyntax__3qwd(struct ZSourceContext50 * this, long StartIndex__1, long EndIndex__2) {
	if (EndIndex < LibZen_StringSize(this->SourceText)) {
		struct ZNameSpace48 * NameSpace = this->TokenContext->NameSpace;
		const char * Token = LibZen_SubString2(this->SourceText, StartIndex);
		struct ZSyntax219 * Pattern = GetRightSyntaxPattern__2qwa(NameSpace, Token);
		if (Pattern != NULL) {
			return 1/*true*/;
		};
	};
	return 0/*false*/;
}
static void TokenizeDefinedSymbol__2qwd(struct ZSourceContext50 * this, long StartIndex__1) {
	long EndIndex = StartIndex + 2;
	while (IsDefinedSyntax__3qwd(this, StartIndex, EndIndex)) {
		EndIndex = EndIndex + 1;
	};
	Tokenize__3qwd(this, StartIndex, EndIndex - 1);
	return;
}
static void ApplyTokenFunc__2qwd(struct ZSourceContext50 * this, struct ZTokenFunc35 * TokenFunc__1) {
	long RollbackPosition = this->SourcePosition;
	while (TokenFunc != NULL) {
		this->SourcePosition = RollbackPosition;
		if (/*untyped*/NULL(TokenFunc->Func, this)) {
			return;
		};
		TokenFunc = TokenFunc->ParentFunc;
	};
	TokenizeDefinedSymbol__2qwd(this, RollbackPosition);
	return;
}
static int DoTokenize__1qwd(struct ZSourceContext50 * this) {
	long TokenSize = LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList);
	long CheckPosition = this->SourcePosition;
	while (HasChar__1qwd(this)) {
		long CharCode = GetCharCode__1qwd(this);
		struct ZTokenFunc35 * TokenFunc = GetTokenFunc__2qwa(this->TokenContext->NameSpace, CharCode);
		ApplyTokenFunc__2qwd(this, TokenFunc);
		if (LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList) > TokenSize) {
			break;
		};
		if (this->SourcePosition == CheckPosition) {
			LibZen_PrintLine__1qqy(LibZen_StrCat("Buggy TokenFunc: ", toString__1qq8(TokenFunc)));
			MoveNext__1qwd(this);
		};
	};
	if (LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList) > TokenSize) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void LogWarning__3qwd(struct ZSourceContext50 * this, long Position__1, const char * Message__2) {
	Report__2qrv(this->Logger, FormatErrorMarker__4qu1(this, "warning", Position, Message));
	return;
}
static struct ZSourceMacro265 * ZSourceMacro__4qis(struct ZSourceMacro265 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2, const char * Macro__3) {
	(void)ZMacroFunc__3qym(this, FuncName, FuncType);
	this->Macro = Macro;
	return NULL;
}
static struct ZSymbolEntry225 * ZSymbolEntry__3qup(struct ZSymbolEntry225 * this, struct ZSymbolEntry225 * Parent__1, struct ZNode52 * Node__2) {
	this->Parent = Parent;
	this->Node = Node;
	return NULL;
}
static struct ZSyntax219 * MergeSyntaxPattern__2qur(struct ZSyntax219 * Pattern, struct ZSyntax219 * Parent__1) {
	if (Parent == NULL) {
		return Pattern;
	};
	struct ZSyntax219 * MergedPattern = ZSyntax__4qur(_NewZSyntax219(), Pattern->PackageNameSpace, Pattern->PatternName, Pattern->MatchFunc);
	MergedPattern->ParentPattern = Parent;
	return MergedPattern;
}
static struct ZSyntax219 * ZSyntax__4qur(struct ZSyntax219 * this, struct ZNameSpace48 * NameSpace__1, const char * PatternName__2, struct ZMatchFunction222 * MatchFunc__3) {
	this->PackageNameSpace = NameSpace;
	this->PatternName = PatternName;
	this->MatchFunc = MatchFunc;
	return NULL;
}
static const char * toString__1qur(struct ZSyntax219 * this) {
	return this->PatternName;
}
static int IsBinaryOperator__1qur(struct ZSyntax219 * this) {
	return LibZen_IsFlag__2qqr(this->SyntaxFlag, ZSyntax_BinaryOperator_Z50);
}
static int IsRightJoin__2qur(struct ZSyntax219 * this, struct ZSyntax219 * Right__1) {
	long left = this->SyntaxFlag;
	long right = Right->SyntaxFlag;
	return (left < right || (left == right && !LibZen_IsFlag__2qqr(left, ZSyntax_LeftJoin_Z51) && !LibZen_IsFlag__2qqr(right, ZSyntax_LeftJoin_Z51)));
}
static struct ZToken77 * ZToken__4qey(struct ZToken77 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3) {
	this->Source = Source;
	this->StartIndex = StartIndex;
	this->EndIndex = EndIndex;
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
	const char * ch = GetCharAt__2qu1(this->Source, this->StartIndex - 1);
	if (ch == "\"") {
		return LibZen_StrCat(LibZen_StrCat("\"", GetText__1qey(this)), "\"");
	};
	return GetText__1qey(this);
}
static int EqualsText__2qey(struct ZToken77 * this, const char * Text__1) {
	if (LibZen_StringSize(Text) == (this->EndIndex - this->StartIndex)) {
		const char * s = this->Source->SourceText;
		long i = 0;
		while (i < LibZen_StringSize(Text)) {
			if (LibZen_GetChar__2qqy(s, this->StartIndex + i) != LibZen_GetChar__2qqy(Text, i)) {
				return 0/*false*/;
			};
			i = i + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int StartsWith__2qey(struct ZToken77 * this, const char * Text__1) {
	if (LibZen_StringSize(Text) <= (this->EndIndex - this->StartIndex)) {
		const char * s = this->Source->SourceText;
		long i = 0;
		while (i < LibZen_StringSize(Text)) {
			if (LibZen_GetChar__2qqy(s, this->StartIndex + i) != LibZen_GetChar__2qqy(Text, i)) {
				return 0/*false*/;
			};
			i = i + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNull__1qey(struct ZToken77 * this) {
	return (this == ZToken_NullToken_Z52);
}
static int IsIndent__1qey(struct ZToken77 * this) {
	return LibZen_Is(this, 460);
}
static int IsNextWhiteSpace__1qey(struct ZToken77 * this) {
	const char * ch = GetCharAt__2qu1(this->Source, this->EndIndex);
	if (ch == " " || ch == "\t" || ch == "\n") {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNameSymbol__1qey(struct ZToken77 * this) {
	const char * ch = GetCharAt__2qu1(this->Source, this->StartIndex);
	return LibZen_IsSymbol__1qqy(ch);
}
static long GetIndentSize__1qey(struct ZToken77 * this) {
	if (this->Source != NULL) {
		return CountIndentSize__2qu1(this->Source, GetLineHeadPosition__2qu1(this->Source, this->StartIndex));
	};
	return 0;
}
static struct ZTokenContext53 * ZTokenContext__6qwh(struct ZTokenContext53 * this, struct ZGenerator55 * Generator__1, struct ZNameSpace48 * NameSpace__2, const char * FileName__3, long LineNumber__4, const char * SourceText__5) {
	this->Generator = Generator;
	this->NameSpace = NameSpace;
	this->Source = ZSourceContext__5qwd(_NewZSourceContext50(), FileName, LineNumber, SourceText, this);
	return NULL;
}
static int SetParseFlag__2qwh(struct ZTokenContext53 * this, int AllowSkipIndent__1) {
	int OldFlag = this->IsAllowSkipIndent;
	this->IsAllowSkipIndent = AllowSkipIndent;
	return OldFlag;
}
static struct ZToken77 * GetBeforeToken__1qwh(struct ZTokenContext53 * this) {
	long MovingPos = this->CurrentPosition - 1;
	while (MovingPos >= 0 && MovingPos < LibZen_ArraySize((ArrayOfVar *)this->TokenList)) {
		struct ZToken77 * Token = Array<ZToken>GetIndex(MovingPos);
		if (!IsIndent__1qey(Token)) {
			return Token;
		};
		MovingPos = MovingPos - 1;
	};
	return this->LatestToken;
}
static struct ZNode52 * CreateExpectedErrorNode__3qwh(struct ZTokenContext53 * this, struct ZToken77 * SourceToken__1, const char * ExpectedTokenText__2) {
	if (SourceToken == NULL || IsNull__1qey(SourceToken)) {
		SourceToken = GetBeforeToken__1qwh(this);
		SourceToken = ZToken__4qey(_NewZToken77(), SourceToken->Source, SourceToken->EndIndex, SourceToken->EndIndex);
		return ZErrorNode__4qpa(_NewZErrorNode336(), NULL, SourceToken, LibZen_StrCat(ExpectedTokenText, " is expected"));
	};
	return ZErrorNode__4qpa(_NewZErrorNode336(), NULL, SourceToken, LibZen_StrCat(ExpectedTokenText, " is expected"));
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
		struct ZToken77 * Token = Array<ZToken>GetIndex(this->CurrentPosition);
		if ((this->IsAllowSkipIndent) && IsIndent__1qey(Token)) {
			this->CurrentPosition = this->CurrentPosition + 1;
		} else {
			this->LatestToken = Token;
			if (EnforceMoveNext) {
				this->CurrentPosition = this->CurrentPosition + 1;
			};
			return Token;
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
	struct ZToken77 * Token = GetToken__1qwh(this);
	while (IsIndent__1qey(Token)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		Token = GetToken__1qwh(this);
	};
	return;
}
static void SkipError__2qwh(struct ZTokenContext53 * this, struct ZToken77 * ErrorToken__1) {
	long StartIndex = ErrorToken->StartIndex;
	long EndIndex = ErrorToken->EndIndex;
	long length = GetIndentSize__1qey(ErrorToken);
	while (HasNext__1qwh(this)) {
		struct ZToken77 * Token = GetToken__1qwh(this);
		EndIndex = Token->EndIndex;
		this->CurrentPosition = this->CurrentPosition + 1;
		if (LibZen_Is(Token, 460)) {
			long ilength = GetIndentSize__1qey(Token);
			if (ilength <= length) {
				break;
			};
		};
	};
	if (StartIndex < EndIndex) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("StartIdx=", LibZen_IntToString(StartIndex)), ", EndIndex="), LibZen_IntToString(EndIndex)));
		LibZen_PrintDebug__1qqy(LibZen_StrCat("skipped: \t", ThrowError("type error: requested = String, given = var")));
	};
	return;
}
static int IsToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	struct ZToken77 * Token = GetToken__1qwh(this);
	if (EqualsText__2qey(Token, TokenText)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNewLineToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	SkipIndent__1qwh(this);
	struct ZToken77 * Token = GetToken__1qwh(this);
	if (EqualsText__2qey(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static int MatchToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	struct ZToken77 * Token = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
	if (EqualsText__2qey(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static int MatchNewLineToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	SkipIndent__1qwh(this);
	struct ZToken77 * Token = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
	if (EqualsText__2qey(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static struct ZToken77 * ParseLargeToken__1qwh(struct ZTokenContext53 * this) {
	struct ZToken77 * Token = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
	if (IsNextWhiteSpace__1qey(Token)) {
		return Token;
	};
	long StartIndex = Token->StartIndex;
	long EndIndex = Token->EndIndex;
	while (HasNext__1qwh(this) && !IsNextWhiteSpace__1qey(Token)) {
		long RollbackPosition = this->CurrentPosition;
		Token = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
		if (IsIndent__1qey(Token) || EqualsText__2qey(Token, ";") || EqualsText__2qey(Token, ",")) {
			this->CurrentPosition = RollbackPosition;
			break;
		};
		EndIndex = Token->EndIndex;
	};
	return ZToken__4qey(_NewZToken77(), Token->Source, StartIndex, EndIndex);
}
static struct ZNode52 * MatchToken__4qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * TokenText__2, int IsRequired__3) {
	if (!IsErrorNode__1qwg(ParentNode)) {
		long RollbackPosition = this->CurrentPosition;
		struct ZToken77 * Token = GetToken__2qwh(this, ZTokenContext_MoveNext_Z58);
		if (EqualsText__2qey(Token, TokenText)) {
			if (ParentNode->SourceToken == NULL) {
				ParentNode->SourceToken = Token;
			};
		} else {
			if (IsRequired) {
				return CreateExpectedErrorNode__3qwh(this, Token, TokenText);
			} else {
				this->CurrentPosition = RollbackPosition;
			};
		};
	};
	return ParentNode;
}
static struct ZSyntax219 * GetApplyingSyntax__1qwh(struct ZTokenContext53 * this) {
	return this->ApplyingPattern;
}
static struct ZNode52 * ApplyMatchPattern__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2, struct ZSyntax219 * Pattern__3, int IsRequired__4) {
	long RollbackPosition = this->CurrentPosition;
	struct ZSyntax219 * CurrentPattern = Pattern;
	struct ZToken77 * TopToken = GetToken__1qwh(this);
	struct ZNode52 * ParsedNode = NULL;
	while (CurrentPattern != NULL) {
		int Remembered = this->IsAllowSkipIndent;
		this->CurrentPosition = RollbackPosition;
		this->ApplyingPattern = CurrentPattern;
		ParsedNode = /*untyped*/NULL(CurrentPattern->MatchFunc, ParentNode, this, LeftNode);
		LibZen_Assert(ParsedNode != ParentNode, "(libzen/libzen.zen:3279)");
		this->ApplyingPattern = NULL;
		this->IsAllowSkipIndent = Remembered;
		if (ParsedNode != NULL && !IsErrorNode__1qwg(ParsedNode)) {
			return ParsedNode;
		};
		CurrentPattern = CurrentPattern->ParentPattern;
	};
	if (!IsRequired) {
		this->CurrentPosition = RollbackPosition;
		return NULL;
	};
	if (this->CurrentPosition == RollbackPosition) {
		LibZen_PrintLine__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("DEBUG infinite looping", LibZen_IntToString(RollbackPosition)), " Token="), toString__1qey(TopToken)), " ParsedNode="), toString__1qwg(ParsedNode)));
		LibZen_Assert(this->CurrentPosition != RollbackPosition, "(libzen/libzen.zen:3293)");
	};
	if (ParsedNode == NULL) {
		ParsedNode = CreateExpectedErrorNode__3qwh(this, TopToken, Pattern->PatternName);
	};
	return ParsedNode;
}
static struct ZNode52 * ParsePatternAfter__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * LeftNode__2, const char * PatternName__3, int IsRequired__4) {
	struct ZSyntax219 * Pattern = GetSyntaxPattern__2qwa(this->NameSpace, PatternName);
	struct ZNode52 * ParsedNode = ApplyMatchPattern__5qwh(this, ParentNode, LeftNode, Pattern, IsRequired);
	return ParsedNode;
}
static struct ZNode52 * ParsePattern__4qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * PatternName__2, int IsRequired__3) {
	return ParsePatternAfter__5qwh(this, ParentNode, NULL, PatternName, IsRequired);
}
static struct ZNode52 * MatchPattern__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4, int AllowSkipIndent__5) {
	if (!IsErrorNode__1qwg(ParentNode)) {
		int Rememberd = SetParseFlag__2qwh(this, AllowSkipIndent);
		struct ZNode52 * ParsedNode = ParsePattern__4qwh(this, ParentNode, PatternName, IsRequired);
		(void)SetParseFlag__2qwh(this, Rememberd);
		if (ParsedNode != NULL) {
			if (Index == ZNode_NestedAppendIndex_Z24) {
				if (!(LibZen_Is(ParsedNode, 334))) {
					Set__3qwg(ParentNode, ZNode_AppendIndex_Z23, ParsedNode);
				};
				if (LibZen_Is(ParsedNode, 161) || IsErrorNode__1qwg(ParsedNode)) {
					return ParsedNode;
				};
			};
			if (IsErrorNode__1qwg(ParsedNode)) {
				return ParsedNode;
			} else {
				if (!(LibZen_Is(ParsedNode, 334))) {
					Set__3qwg(ParentNode, Index, ParsedNode);
				};
			};
		};
	};
	return ParentNode;
}
static struct ZNode52 * MatchPattern__5qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4) {
	return MatchPattern__6qwh(this, ParentNode, Index, PatternName, IsRequired, ZTokenContext_NotAllowSkipIndent_Z56);
}
static struct ZNode52 * MatchOptionaPattern__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, long Index__2, int AllowNewLine__3, const char * TokenText__4, const char * PatternName__5) {
	if (!IsErrorNode__1qwg(ParentNode)) {
		if (MatchToken__2qwh(this, TokenText)) {
			return MatchPattern__6qwh(this, ParentNode, Index, PatternName, ZTokenContext_Optional_Z54, ZTokenContext_NotAllowSkipIndent_Z56);
		};
	};
	return ParentNode;
}
static struct ZNode52 * MatchNtimes__6qwh(struct ZTokenContext53 * this, struct ZNode52 * ParentNode__1, const char * StartToken__2, const char * PatternName__3, const char * DelimToken__4, const char * StopToken__5) {
	int Rememberd = SetParseFlag__2qwh(this, 1/*true*/);
	int IsRequired = ZTokenContext_Optional_Z54;
	if (StartToken != NULL) {
		ParentNode = MatchToken__4qwh(this, ParentNode, StartToken, ZTokenContext_Required_Z53);
	};
	while (!IsErrorNode__1qwg(ParentNode)) {
		if (StopToken != NULL) {
			struct ZToken77 * Token = GetToken__1qwh(this);
			if (EqualsText__2qey(Token, StopToken)) {
				break;
			};
			IsRequired = ZTokenContext_Required_Z53;
		};
		struct ZNode52 * ParsedNode = ParsePattern__4qwh(this, ParentNode, PatternName, IsRequired);
		if (ParsedNode == NULL) {
			break;
		};
		if (IsErrorNode__1qwg(ParsedNode)) {
			return ParsedNode;
		};
		if (!(LibZen_Is(ParsedNode, 334))) {
			Set__3qwg(ParentNode, ZNode_AppendIndex_Z23, ParsedNode);
		};
		if (DelimToken != NULL) {
			if (!MatchToken__2qwh(this, DelimToken)) {
				break;
			};
		};
	};
	if (StopToken != NULL) {
		ParentNode = MatchToken__4qwh(this, ParentNode, StopToken, ZTokenContext_Required_Z53);
	};
	(void)SetParseFlag__2qwh(this, Rememberd);
	return ParentNode;
}
static int StartsWithToken__2qwh(struct ZTokenContext53 * this, const char * TokenText__1) {
	struct ZToken77 * Token = GetToken__1qwh(this);
	if (EqualsText__2qey(Token, TokenText)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		return 1/*true*/;
	};
	if (StartsWith__2qey(Token, TokenText)) {
		Token = ZToken__4qey(_NewZToken77(), Token->Source, Token->StartIndex + LibZen_StringSize(TokenText), Token->EndIndex);
		this->CurrentPosition = this->CurrentPosition + 1;
		LibZen_ArrayAdd2((ArrayOfVar *)this->TokenList, this->CurrentPosition, (var)Token);
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void SkipEmptyStatement__1qwh(struct ZTokenContext53 * this) {
	while (HasNext__1qwh(this)) {
		struct ZToken77 * Token = GetToken__1qwh(this);
		if (IsIndent__1qey(Token) || EqualsText__2qey(Token, ";")) {
			this->CurrentPosition = this->CurrentPosition + 1;
			/*untyped*/NULL;
		};
		break;
	};
	return;
}
static void Dump__1qwh(struct ZTokenContext53 * this) {
	long Position = this->CurrentPosition;
	while (Position < LibZen_ArraySize((ArrayOfVar *)this->TokenList)) {
		struct ZToken77 * Token = Array<ZToken>GetIndex(Position);
		const char * DumpedToken = "[";
		DumpedToken = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(DumpedToken, LibZen_IntToString(Position)), "] "), toString__1qey(Token));
		LibZen_PrintDebug__1qqy(DumpedToken);
		Position = Position + 1;
	};
	return;
}
static struct ZTokenFunc35 * ZTokenFunc__3qq8(struct ZTokenFunc35 * this, struct ZTokenFunction216 * Func__1, struct ZTokenFunc35 * Parent__2) {
	this->Func = Func;
	this->ParentFunc = Parent;
	return NULL;
}
static const char * toString__1qq8(struct ZTokenFunc35 * this) {
	return /*untyped*/NULL;
}
static struct ZVariable230 * ZVariable__7qud(struct ZVariable230 * this, struct ZSymbolEntry225 * Parent__1, struct ZFunctionNode144 * FuncNode__2, long VarFlag__3, struct ZType60 * VarType__4, const char * VarName__5, struct ZToken77 * SourceToken__6) {
	(void)ZSymbolEntry__3qup(this, Parent, FuncNode);
	this->VarFlag = VarFlag;
	this->VarType = VarType;
	this->VarName = VarName;
	this->SourceToken = SourceToken;
	this->VarUniqueIndex = GetVarIndex__1qtq(FuncNode);
	this->UsedCount = 0;
	this->DefCount = 1;
	return NULL;
}
static int IsCaptured__2qud(struct ZVariable230 * this, struct ZFunctionNode144 * CurrentFunctionNode__1) {
	if (CurrentFunctionNode == this->Node) {
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
static struct ZArrayType300 * ZArrayType__3qoa(struct ZArrayType300 * this, long TypeFlag__1, struct ZType60 * ParamType__2) {
	(void)ZGeneric1Type__5qe8(this, TypeFlag, LibZen_StrCat(toString__1qwz(ParamType), "[]"), ThrowError("type error: requested = ZType, given = ZGeneric1Type"), ParamType);
	return NULL;
}
static struct ZAnnotationNode302 * ZAnnotationNode__4qod(struct ZAnnotationNode302 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, MapOfObject * Anno__3) {
	(void)ZNode__4qwg(this, ParentNode, Token, 0);
	return NULL;
}
static int IsBreakingBlock__1qod(struct ZAnnotationNode302 * this) {
	return /*untyped*/NULL(this->AnnotatedNode);
}
static void Accept__2qod(struct ZAnnotationNode302 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(this->AnnotatedNode, Visitor);
	return;
}
static struct ZAssertNode308 * ZAssertNode__2qol(struct ZAssertNode308 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	return NULL;
}
static struct ZSugarNode165 * DeSugar__2qol(struct ZAssertNode308 * this, struct ZGenerator55 * Generator__1) {
	struct ZMacroFunc210 * Func = GetMacroFunc__4qwk(Generator, "assert", ZTypeBooleanType_Z6, 2);
	if (Func != NULL) {
		struct ZMacroNode392 * MacroNode = ZMacroNode__4q05(_NewZMacroNode392(), this->ParentNode, this->SourceToken, Func);
		Append__2qu8(MacroNode, Array<ZNode>GetIndex(ZAssertNode_Expr_Z59));
		Append__2qu8(MacroNode, ZStringNode__4q48(_NewZStringNode431(), MacroNode, NULL, GetSourceLocation__1qwg(this)));
		return ZSugarNode__3qt9(_NewZSugarNode165(), this, MacroNode);
	} else {
		struct ZFuncCallNode407 * MacroNode = ZFuncCallNode__4q44(_NewZFuncCallNode407(), this->ParentNode, "assert", ZTypeVarType_Z4);
		Append__2qu8(MacroNode, Array<ZNode>GetIndex(ZAssertNode_Expr_Z59));
		return ZSugarNode__3qt9(_NewZSugarNode165(), this, MacroNode);
	};
}
static struct ZBinaryNode311 * ZBinaryNode__5qo6(struct ZBinaryNode311 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZNode__4qwg(this, ParentNode, SourceToken, 2);
	Set__3qwg(this, ZBinaryNode_Left_Z60, Left);
	LibZen_Assert(Pattern != NULL, "(libzen/libzen.zen:3498)");
	this->Pattern = Pattern;
	return NULL;
}
static int IsRightJoin__2qo6(struct ZBinaryNode311 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node, 311)) {
		return IsRightJoin__2qur(this->Pattern, ((struct ZBinaryNode311 *)Node)->Pattern);
	};
	return 0/*false*/;
}
static struct ZNode52 * RightJoin__3qo6(struct ZBinaryNode311 * this, struct ZNode52 * ParentNode__1, struct ZBinaryNode311 * RightNode__2) {
	struct ZNode52 * RightLeftNode = Array<ZNode>GetIndex(ZBinaryNode_Left_Z60);
	if (IsRightJoin__2qo6(this, RightLeftNode)) {
		Set__3qwg(RightNode, ZBinaryNode_Left_Z60, RightJoin__3qo6(this, ParentNode, (struct ZBinaryNode311 *)RightLeftNode));
	} else {
		Set__3qwg(RightNode, ZBinaryNode_Left_Z60, this);
		Set__3qwg(this, ZBinaryNode_Right_Z61, RightLeftNode);
	};
	return RightNode;
}
static struct ZNode52 * AppendParsedRightNode__3qo6(struct ZBinaryNode311 * this, struct ZNode52 * ParentNode__1, struct ZTokenContext53 * TokenContext__2) {
	struct ZNode52 * RightNode = ParsePattern__4qwh(TokenContext, ParentNode, "$Expression$", ZTokenContext_Required_Z53);
	if (IsErrorNode__1qwg(RightNode)) {
		return RightNode;
	};
	if (IsRightJoin__2qo6(this, RightNode)) {
		return RightJoin__3qo6(this, ParentNode, (struct ZBinaryNode311 *)RightNode);
	};
	Set__3qwg(this, ZBinaryNode_Right_Z61, RightNode);
	return this;
}
static struct ZNode52 * TryMacroNode__2qo6(struct ZBinaryNode311 * this, struct ZGenerator55 * Generator__1) {
	if (!/*untyped*/NULL(GetAstType__2qwg(this, ZBinaryNode_Left_Z60)) && !/*untyped*/NULL(GetAstType__2qwg(this, ZBinaryNode_Right_Z61))) {
		const char * Op = GetText__1qey(this->SourceToken);
		struct ZFunc89 * Func = GetDefinedFunc__4qwk(Generator, Op, GetAstType__2qwg(this, ZBinaryNode_Left_Z60), 2);
		if (LibZen_Is(Func, 210)) {
			struct ZMacroNode392 * MacroNode = ZMacroNode__4q05(_NewZMacroNode392(), this->ParentNode, this->SourceToken, (struct ZMacroFunc210 *)Func);
			Append__2qu8(MacroNode, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
			Append__2qu8(MacroNode, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
			return MacroNode;
		};
	};
	return this;
}
static void Accept__2qo6(struct ZBinaryNode311 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZBreakNode318 * ZBreakNode__2qom(struct ZBreakNode318 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 0);
	return NULL;
}
static void Accept__2qom(struct ZBreakNode318 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZCastNode321 * ZCastNode__4qo3(struct ZCastNode321 * this, struct ZNode52 * ParentNode__1, struct ZType60 * CastType__2, struct ZNode52 * Node__3) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	this->Type = CastType;
	if (Node != NULL) {
		Set__3qwg(this, ZCastNode_Expr_Z62, Node);
	};
	return NULL;
}
static void Accept__2qo3(struct ZCastNode321 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZListNode251 * ToFuncCallNode__2qo3(struct ZCastNode321 * this, struct ZFunc89 * Func__1) {
	if (LibZen_Is(Func, 210)) {
		struct ZMacroNode392 * FuncNode = ZMacroNode__4q05(_NewZMacroNode392(), this->ParentNode, this->SourceToken, (struct ZMacroFunc210 *)Func);
		Append__2qu8(FuncNode, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
		return FuncNode;
	} else {
		struct ZFuncCallNode407 * FuncNode = ZFuncCallNode__4q44(_NewZFuncCallNode407(), this->ParentNode, Func->FuncName, GetFuncType__1qeh(Func));
		FuncNode->SourceToken = this->SourceToken;
		Append__2qu8(FuncNode, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
		return FuncNode;
	};
}
static struct ZCatchNode325 * ZCatchNode__2qpw(struct ZCatchNode325 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qpw(struct ZCatchNode325 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->ExceptionType = Type;
	return;
}
static void SetNameInfo__3qpw(struct ZCatchNode325 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->ExceptionName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZComparatorNode329 * ZComparatorNode__5qpy(struct ZComparatorNode329 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZBinaryNode__5qo6(this, ParentNode, SourceToken, Left, Pattern);
	return NULL;
}
static void Accept__2qpy(struct ZComparatorNode329 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZConstNode332 * ZConstNode__3qpo(struct ZConstNode332 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2) {
	(void)ZNode__4qwg(this, ParentNode, SourceToken, 0);
	return NULL;
}
static struct ZEmptyNode334 * ZEmptyNode__3qp0(struct ZEmptyNode334 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2) {
	(void)ZNode__4qwg(this, ParentNode, Token, 0);
	return NULL;
}
static struct ZErrorNode336 * ZErrorNode__4qpa(struct ZErrorNode336 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, const char * ErrorMessage__3) {
	(void)ZConstNode__3qpo(this, ParentNode, SourceToken);
	this->ErrorMessage = ErrorMessage;
	return NULL;
}
static struct ZErrorNode336 * ZErrorNode__3qpa(struct ZErrorNode336 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2) {
	(void)ZConstNode__3qpo(this, Node->ParentNode, Node->SourceToken);
	this->ErrorMessage = ErrorMessage;
	return NULL;
}
static void Accept__2qpa(struct ZErrorNode336 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFieldNode340 * ZFieldNode__2qpg(struct ZFieldNode340 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qpg(struct ZFieldNode340 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->DeclType = Type;
	return;
}
static void SetNameInfo__3qpg(struct ZFieldNode340 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZFloatNode344 * ZFloatNode__4qpl(struct ZFloatNode344 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, double Value__3) {
	(void)ZConstNode__3qpo(this, ParentNode, Token);
	this->Type = ZTypeFloatType_Z8;
	this->FloatValue = Value;
	return NULL;
}
static void Accept__2qpl(struct ZFloatNode344 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGetIndexNode347 * ZGetIndexNode__3qp6(struct ZGetIndexNode347 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 2);
	Array<ZNode>SetIndex(ZGetIndexNode_Recv_Z65, SetChild__2qwg(this, RecvNode));
	return NULL;
}
static void Accept__2qp6(struct ZGetIndexNode347 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGetNameNode350 * ZGetNameNode__4qpc(struct ZGetNameNode350 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * NativeName__3) {
	(void)ZNode__4qwg(this, ParentNode, Token, 0);
	this->VarName = NativeName;
	return NULL;
}
static struct ZGetNameNode350 * ZGetNameNode__3qpc(struct ZGetNameNode350 * this, struct ZNode52 * ParentNode__1, struct ZFunc89 * ResolvedFunc__2) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 0);
	this->VarName = ResolvedFunc->FuncName;
	this->Type = GetFuncType__1qeh(ResolvedFunc);
	return NULL;
}
static void Accept__2qpc(struct ZGetNameNode350 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNode52 * ToGlobalNameNode__1qpc(struct ZGetNameNode350 * this) {
	return ZGlobalNameNode__6q0q(_NewZGlobalNameNode360(), this->ParentNode, this->SourceToken, this->Type, this->VarName, 0/*false*/);
}
static struct ZGetterNode355 * ZGetterNode__3qp7(struct ZGetterNode355 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	Set__3qwg(this, ZGetterNode_Recv_Z67, RecvNode);
	return NULL;
}
static void SetNameInfo__3qp7(struct ZGetterNode355 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qp7(struct ZGetterNode355 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsStaticField__1qp7(struct ZGetterNode355 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZGetterNode_Recv_Z67), 235);
}
static struct ZGlobalNameNode360 * ZGlobalNameNode__6q0q(struct ZGlobalNameNode360 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5) {
	(void)ZNode__4qwg(this, ParentNode, SourceToken, 0);
	this->GlobalName = GlobalName;
	this->Type = Type;
	this->IsStaticFuncName = IsStaticFuncName;
	return NULL;
}
static int IsGivenName__1q0q(struct ZGlobalNameNode360 * this) {
	return (!this->IsStaticFuncName);
}
static void Accept__2q0q(struct ZGlobalNameNode360 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGroupNode364 * ZGroupNode__2q0t(struct ZGroupNode364 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	return NULL;
}
static void Accept__2q0t(struct ZGroupNode364 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZIfNode367 * ZIfNode__2q0i(struct ZIfNode367 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 3);
	return NULL;
}
static void Accept__2q0i(struct ZIfNode367 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZImportNode370 * ZImportNode__2q00(struct ZImportNode370 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetNameInfo__3q00(struct ZImportNode370 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	if (this->ResourcePath == NULL) {
		this->ResourcePath = Name;
		this->ResourceToken = NameToken;
	} else {
		this->Alias = Name;
	};
	return;
}
static struct ZInstanceOfNode373 * ZInstanceOfNode__4q0s(struct ZInstanceOfNode373 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * LeftNode__3) {
	(void)ZNode__4qwg(this, ParentNode, Token, 1);
	Set__3qwg(this, ZInstanceOfNode_Left_Z72, LeftNode);
	return NULL;
}
static void SetTypeInfo__3q0s(struct ZInstanceOfNode373 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->TargetType = Type;
	return;
}
static void Accept__2q0s(struct ZInstanceOfNode373 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZIntNode377 * ZIntNode__4q0h(struct ZIntNode377 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, long Value__3) {
	(void)ZConstNode__3qpo(this, ParentNode, Token);
	this->Type = ZTypeIntType_Z7;
	this->IntValue = Value;
	return NULL;
}
static void Accept__2q0h(struct ZIntNode377 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZLetNode380 * ZLetNode__2q0l(struct ZLetNode380 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetNameInfo__3q0l(struct ZLetNode380 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->Symbol = Name;
	this->SymbolToken = NameToken;
	return;
}
static void SetTypeInfo__3q0l(struct ZLetNode380 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->SymbolType = Type;
	return;
}
static void Accept__2q0l(struct ZLetNode380 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGlobalNameNode360 * ToGlobalNameNode__1q0l(struct ZLetNode380 * this) {
	return ZGlobalNameNode__6q0q(_NewZGlobalNameNode360(), NULL, this->SymbolToken, GetAstType__2qwg(this, ZLetNode_InitValue_Z73), this->GlobalName, 0/*false*/);
}
static struct ZListNode251 * ZListNode__4qu8(struct ZListNode251 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, long Size__3) {
	(void)ZNode__4qwg(this, ParentNode, SourceToken, Size);
	this->ListStartIndex = Size;
	return NULL;
}
static void Append__2qu8(struct ZListNode251 * this, struct ZNode52 * Node__1) {
	if (this->AST == NULL) {
		this->AST = LibZen_NewNodeArray__1qqr(1);
		Set__3qwg(this, 0, Node);
	} else {
		ArrayOfZNode * newAST = LibZen_NewNodeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)this->AST) + 1);
		/*untyped*/NULL(this->AST, 0, newAST, 0, LibZen_ArraySize((ArrayOfVar *)this->AST));
		this->AST = newAST;
		Set__3qwg(this, LibZen_ArraySize((ArrayOfVar *)this->AST) - 1, Node);
	};
	return;
}
static long GetListSize__1qu8(struct ZListNode251 * this) {
	return GetAstSize__1qwg(this) - this->ListStartIndex;
}
static struct ZNode52 * GetListAt__2qu8(struct ZListNode251 * this, long Index__1) {
	return Array<ZNode>GetIndex(this->ListStartIndex + Index);
}
static void SetListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2) {
	Set__3qwg(this, Index + this->ListStartIndex, Node);
	return;
}
static void InsertListAt__3qu8(struct ZListNode251 * this, long Index__1, struct ZNode52 * Node__2) {
	if (this->AST == NULL || Index < 0 || LibZen_ArraySize((ArrayOfVar *)this->AST) == Index) {
		Append__2qu8(this, Node);
	} else {
		ArrayOfZNode * newAST = LibZen_NewNodeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)this->AST) + 1);
		Index = this->ListStartIndex + Index;
		/*untyped*/NULL(this->AST, 0, newAST, 0, Index);
		Set__3qwg(this, Index, Node);
		/*untyped*/NULL(this->AST, Index, newAST, Index + 1, LibZen_ArraySize((ArrayOfVar *)this->AST) - Index);
		this->AST = newAST;
	};
	return;
}
static struct ZNode52 * RemoveListAt__2qu8(struct ZListNode251 * this, long Index__1) {
	struct ZNode52 * Removed = GetListAt__2qu8(this, Index);
	ArrayOfZNode * newAST = LibZen_NewNodeArray__1qqr(LibZen_ArraySize((ArrayOfVar *)this->AST) - 1);
	long RemovedIndex = this->ListStartIndex + Index;
	/*untyped*/NULL(this->AST, 0, newAST, 0, RemovedIndex);
	/*untyped*/NULL(this->AST, RemovedIndex + 1, newAST, RemovedIndex, LibZen_ArraySize((ArrayOfVar *)this->AST) - (RemovedIndex + 1));
	this->AST = newAST;
	return Removed;
}
static void ClearListAfter__2qu8(struct ZListNode251 * this, long Size__1) {
	if (Size < GetListSize__1qu8(this)) {
		long newsize = this->ListStartIndex + Size;
		if (newsize == 0) {
			this->AST = NULL;
		} else {
			ArrayOfZNode * newAST = LibZen_NewNodeArray__1qqr(newsize);
			/*untyped*/NULL(this->AST, 0, newAST, 0, newsize);
			this->AST = newAST;
		};
	};
	return;
}
static struct ZMacroNode392 * ZMacroNode__4q05(struct ZMacroNode392 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZMacroFunc210 * MacroFunc__3) {
	(void)ZListNode__4qu8(this, ParentNode, SourceToken, 0);
	this->MacroFunc = MacroFunc;
	LibZen_Assert(MacroFunc != NULL, "(libzen/libzen.zen:3856)");
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1q05(struct ZMacroNode392 * this) {
	return GetFuncType__1qeh(this->MacroFunc);
}
static const char * GetMacroText__1q05(struct ZMacroNode392 * this) {
	struct ZMacroFunc210 * Func = this->MacroFunc;
	if (LibZen_Is(Func, 265)) {
		return ((struct ZSourceMacro265 *)Func)->Macro;
	};
	return "";
}
static void Accept__2q05(struct ZMacroNode392 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZMapEntryNode397 * ZMapEntryNode__2q4w(struct ZMapEntryNode397 * this, struct ZNode52 * ParentNode__1) {
	(void)ZNode__4qwg(this, ParentNode, NULL, 2);
	return NULL;
}
static struct ZMapLiteralNode399 * ZMapLiteralNode__2q4r(struct ZMapLiteralNode399 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 0);
	return NULL;
}
static struct ZMapEntryNode397 * GetMapEntryNode__2q4r(struct ZMapLiteralNode399 * this, long Index__1) {
	struct ZNode52 * Node = GetListAt__2qu8(this, Index);
	if (LibZen_Is(Node, 397)) {
		return (struct ZMapEntryNode397 *)Node;
	};
	return NULL;
}
static void Accept__2q4r(struct ZMapLiteralNode399 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZMethodCallNode403 * ZMethodCallNode__3q4i(struct ZMethodCallNode403 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * RecvNode__2) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 1);
	Set__3qwg(this, ZMethodCallNode_Recv_Z76, RecvNode);
	return NULL;
}
static void SetNameInfo__3q4i(struct ZMethodCallNode403 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->MethodName = Name;
	this->MethodToken = NameToken;
	return;
}
static void Accept__2q4i(struct ZMethodCallNode403 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFuncCallNode407 * ToGetterFuncCall__1q4i(struct ZMethodCallNode403 * this) {
	struct ZGetterNode355 * Getter = ZGetterNode__3qp7(_NewZGetterNode355(), NULL, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
	Getter->SetNameInfo(Getter, this->MethodToken, this->MethodName);
	struct ZFuncCallNode407 * FuncNode = ZFuncCallNode__3q44(_NewZFuncCallNode407(), this->ParentNode, Getter);
	FuncNode->SourceToken = this->SourceToken;
	Append__2qu8(FuncNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
	long i = 0;
	while (i < GetListSize__1qu8(this)) {
		Append__2qu8(FuncNode, GetListAt__2qu8(this, i));
		i = i + 1;
	};
	return FuncNode;
}
static struct ZListNode251 * ToFuncCallNode__2q4i(struct ZMethodCallNode403 * this, struct ZFunc89 * Func__1) {
	if (LibZen_Is(Func, 210)) {
		struct ZMacroNode392 * MacroNode = ZMacroNode__4q05(_NewZMacroNode392(), this->ParentNode, this->MethodToken, (struct ZMacroFunc210 *)Func);
		Append__2qu8(MacroNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
		long i = 0;
		while (i < GetListSize__1qu8(this)) {
			Append__2qu8(MacroNode, GetListAt__2qu8(this, i));
			i = i + 1;
		};
		return MacroNode;
	} else {
		struct ZFuncCallNode407 * FuncNode = ZFuncCallNode__4q44(_NewZFuncCallNode407(), this->ParentNode, Func->FuncName, GetFuncType__1qeh(Func));
		FuncNode->SourceToken = this->MethodToken;
		Append__2qu8(FuncNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
		long i = 0;
		while (i < GetListSize__1qu8(this)) {
			Append__2qu8(FuncNode, GetListAt__2qu8(this, i));
			i = i + 1;
		};
		return FuncNode;
	};
}
static struct ZNewArrayNode410 * ZNewArrayNode__4q4d(struct ZNewArrayNode410 * this, struct ZNode52 * ParentNode__1, struct ZType60 * Type__2, struct ZToken77 * Token__3) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 0);
	return NULL;
}
static struct ZNewObjectNode412 * ZNewObjectNode__2q4g(struct ZNewObjectNode412 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 0);
	return NULL;
}
static void Accept__2q4g(struct ZNewObjectNode412 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZListNode251 * ToFuncCallNode__2q4g(struct ZNewObjectNode412 * this, struct ZFunc89 * Func__1) {
	struct ZListNode251 * FuncNode = NULL;
	if (LibZen_Is(Func, 210)) {
		FuncNode = ZMacroNode__4q05(_NewZMacroNode392(), this->ParentNode, this->SourceToken, (struct ZMacroFunc210 *)Func);
	} else {
		FuncNode = ZFuncCallNode__4q44(_NewZFuncCallNode407(), this->ParentNode, Func->FuncName, GetFuncType__1qeh(Func));
		FuncNode->SourceToken = this->SourceToken;
	};
	Append__2qu8(FuncNode, this);
	long i = 0;
	while (i < GetListSize__1qu8(this)) {
		Append__2qu8(FuncNode, GetListAt__2qu8(this, i));
		i = i + 1;
	};
	ClearListAfter__2qu8(this, 0);
	return FuncNode;
}
static struct ZNotNode416 * ZNotNode__3q4l(struct ZNotNode416 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2) {
	(void)ZUnaryNode__3qyh(this, ParentNode, Token);
	return NULL;
}
static void Accept__2q4l(struct ZNotNode416 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNullNode419 * ZNullNode__3q46(struct ZNullNode419 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2) {
	(void)ZConstNode__3qpo(this, ParentNode, SourceToken);
	return NULL;
}
static void Accept__2q46(struct ZNullNode419 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZOrNode422 * ZOrNode__5q4c(struct ZOrNode422 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZBinaryNode__5qo6(this, ParentNode, Token, Left, Pattern);
	return NULL;
}
static void Accept__2q4c(struct ZOrNode422 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZPrototypeNode425 * ZPrototypeNode__2q4n(struct ZPrototypeNode425 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetTypeInfo__3q4n(struct ZPrototypeNode425 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->ReturnType = Type;
	return;
}
static void SetNameInfo__3q4n(struct ZPrototypeNode425 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FuncName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZParamNode172 * GetParamNode__2q4n(struct ZPrototypeNode425 * this, long Index__1) {
	struct ZNode52 * Node = GetListAt__2qu8(this, Index);
	if (LibZen_Is(Node, 172)) {
		return (struct ZParamNode172 *)Node;
	};
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1q4n(struct ZPrototypeNode425 * this) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)this->ReturnType->GetRealType(this->ReturnType));
	long i = 0;
	while (i < GetListSize__1qu8(this)) {
		struct ZParamNode172 * Node = GetParamNode__2q4n(this, i);
		struct ZType60 * ParamType = Node->Type->GetRealType(Node->Type);
		LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)ParamType);
		i = i + 1;
	};
	return ZTypePool_LookupFuncType__1qwx(TypeList);
}
static struct ZStringNode431 * ZStringNode__4q48(struct ZStringNode431 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, const char * Value__3) {
	(void)ZConstNode__3qpo(this, ParentNode, Token);
	this->Type = ZTypeStringType_Z9;
	this->StringValue = Value;
	return NULL;
}
static void Accept__2q48(struct ZStringNode431 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZStupidCastErrorNode434 * ZStupidCastErrorNode__3qae(struct ZStupidCastErrorNode434 * this, struct ZNode52 * Node__1, const char * ErrorMessage__2) {
	(void)ZErrorNode__3qpa(this, Node, ErrorMessage);
	this->ErrorNode = Node;
	return NULL;
}
static struct ZTypeNode235 * ZTypeNode__4quk(struct ZTypeNode235 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * SourceToken__2, struct ZType60 * ParsedType__3) {
	(void)ZConstNode__3qpo(this, ParentNode, SourceToken);
	this->Type = ParsedType;
	return NULL;
}
static struct ZGenerator55 * ZGenerator__3qwk(struct ZGenerator55 * this, const char * LanguageExtension__1, const char * TargetVersion__2) {
	/*untyped*/NULL;
	this->RootNameSpace = ZNameSpace__3qwa(_NewZNameSpace48(), this, NULL);
	this->GrammarInfo = "";
	this->LanguageExtention = LanguageExtension;
	this->TargetVersion = TargetVersion;
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
static const char * NameOutputFile__2qwk(struct ZGenerator55 * this, const char * FileName__1) {
	if (FileName != NULL) {
		return LibZen_StrCat(LibZen_StrCat(FileName, "."), this->LanguageExtention);
	};
	return FileName;
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
	this->GrammarInfo = LibZen_StrCat(LibZen_StrCat(this->GrammarInfo, GrammarInfo), " ");
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
	return ZTypeFuncType_Z13;
}
static struct ZFuncType90 * GetMethodFuncType__4qwk(struct ZGenerator55 * this, struct ZType60 * RecvType__1, const char * MethodName__2, struct ZListNode251 * List__3) {
	return ZTypeFuncType_Z13;
}
static long GetUniqueNumber__1qwk(struct ZGenerator55 * this) {
	long UniqueNumber = this->UniqueNumber;
	this->UniqueNumber = this->UniqueNumber + 1;
	return UniqueNumber;
}
static const char * NameGlobalSymbol__2qwk(struct ZGenerator55 * this, const char * Symbol__1) {
	return LibZen_StrCat(LibZen_StrCat(Symbol, "_Z"), LibZen_IntToString(GetUniqueNumber__1qwk(this)));
}
static const char * NameClass__2qwk(struct ZGenerator55 * this, struct ZType60 * ClassType__1) {
	return LibZen_StrCat(LibZen_StrCat(ClassType->ShortName, ""), LibZen_IntToString(ClassType->TypeId));
}
static void SetDefinedFunc__2qwk(struct ZGenerator55 * this, struct ZFunc89 * Func__1) {
	Map<ZFunc>SetIndex(GetSignature__1qeh(Func), Func);
	return;
}
static struct ZPrototype121 * SetPrototype__4qwk(struct ZGenerator55 * this, struct ZNode52 * Node__1, const char * FuncName__2, struct ZFuncType90 * FuncType__3) {
	struct ZFunc89 * Func = GetDefinedFunc__3qwk(this, FuncName, FuncType);
	if (Func != NULL) {
		if (!Equals__2qwz(FuncType, GetFuncType__1qeh(Func))) {
			(void)ZLogger_LogError__2qey(Node->SourceToken, LibZen_StrCat("function has been defined diffrently: ", toString__1qwz(GetFuncType__1qeh(Func))));
			return NULL;
		};
		if (LibZen_Is(Func, 121)) {
			return (struct ZPrototype121 *)Func;
		};
		(void)ZLogger_LogError__2qey(Node->SourceToken, LibZen_StrCat("function has been defined as macro", toString__1qeh(Func)));
		return NULL;
	};
	struct ZPrototype121 * Proto = ZPrototype__5qrs(_NewZPrototype121(), 0, FuncName, FuncType, Node->SourceToken);
	Map<ZFunc>SetIndex(GetSignature__1qeh(Proto), Proto);
	return Proto;
}
static struct ZFunc89 * GetDefinedFunc__2qwk(struct ZGenerator55 * this, const char * GlobalName__1) {
	struct ZFunc89 * Func = Map<ZFunc>GetIndex(GlobalName);
	if (Func == NULL && LibZen_IsLetter__1qqy(LibZen_GetChar__2qqy(GlobalName, 0))) {
		Func = Map<ZFunc>GetIndex(LibZen_AnotherName__1qqy(GlobalName));
	};
	return Func;
}
static struct ZFunc89 * GetDefinedFunc__3qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2) {
	return GetDefinedFunc__2qwk(this, StringfySignature__2qej(FuncType, FuncName));
}
static struct ZFunc89 * GetDefinedFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3) {
	return GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
}
static struct ZFunc89 * LookupFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3) {
	struct ZFunc89 * Func = GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
	while (Func == NULL) {
		RecvType = RecvType->GetSuperType(RecvType);
		if (RecvType == NULL) {
			break;
		};
		Func = GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
		if (RecvType->IsVarType(RecvType)) {
			break;
		};
	};
	return Func;
}
static struct ZMacroFunc210 * GetMacroFunc__4qwk(struct ZGenerator55 * this, const char * FuncName__1, struct ZType60 * RecvType__2, long FuncParamSize__3) {
	struct ZFunc89 * Func = GetDefinedFunc__2qwk(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
	if (LibZen_Is(Func, 210)) {
		return ((struct ZMacroFunc210 *)Func);
	};
	return NULL;
}
static const char * NameConverterFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2) {
	return LibZen_StrCat(LibZen_StrCat(GetUniqueName__1qwz(FromType), "T"), GetUniqueName__1qwz(ToType));
}
static void SetConverterFunc__4qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2, struct ZFunc89 * Func__3) {
	Map<ZFunc>SetIndex(NameConverterFunc__3qwk(this, FromType, ToType), Func);
	return;
}
static struct ZFunc89 * LookupConverterFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2) {
	while (FromType != NULL) {
		struct ZFunc89 * Func = Map<ZFunc>GetIndex(NameConverterFunc__3qwk(this, FromType, ToType));
		if (Func != NULL) {
			return Func;
		};
		FromType = /*untyped*/NULL(FromType);
	};
	return NULL;
}
static struct ZFunc89 * GetCoercionFunc__3qwk(struct ZGenerator55 * this, struct ZType60 * FromType__1, struct ZType60 * ToType__2) {
	while (FromType != NULL) {
		struct ZFunc89 * Func = Map<ZFunc>GetIndex(NameConverterFunc__3qwk(this, FromType, ToType));
		if (Func != NULL && IsCoercionFunc__1qeh(Func)) {
			return Func;
		};
		FromType = /*untyped*/NULL(FromType);
	};
	return NULL;
}
static void VisitExtendedNode__2qwk(struct ZGenerator55 * this, struct ZNode52 * Node__1) {
	struct ZSugarNode165 * DeNode = /*untyped*/NULL(Node, this);
	/*untyped*/NULL(DeNode, this);
	return;
}
static void VisitSugarNode__2qwk(struct ZGenerator55 * this, struct ZSugarNode165 * Node__1) {
	/*untyped*/NULL(Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z32), this);
	return;
}
static struct ZIndentToken460 * ZIndentToken__4qab(struct ZIndentToken460 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3) {
	(void)ZToken__4qey(this, Source, StartIndex, EndIndex);
	return NULL;
}
static struct ZPatternToken462 * ZPatternToken__5qam(struct ZPatternToken462 * this, struct ZSource238 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax219 * PresetPattern__4) {
	(void)ZToken__4qey(this, Source, StartIndex, EndIndex);
	this->PresetPattern = PresetPattern;
	return NULL;
}
static struct ZSourceEngine57 * ZSourceEngine__3qw9(struct ZSourceEngine57 * this, struct ZTypeChecker142 * TypeChecker__1, struct ZGenerator55 * Generator__2) {
	this->TypeChecker = TypeChecker;
	this->Generator = Generator;
	this->Logger = Generator->Logger;
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
static struct Object303 * Eval__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1) {
	if (/*untyped*/NULL(this)) {
		/*untyped*/NULL(Node, this);
	};
	return ThrowError("type error: requested = Object, given = ZEmptyValue");
}
static void VisitPrototypeNode__2qw9(struct ZSourceEngine57 * this, struct ZPrototypeNode425 * Node__1) {
	struct ZFuncType90 * FuncType = GetFuncType__1q4n(Node);
	(void)SetPrototype__4qwk(this->Generator, Node, Node->FuncName, FuncType);
	return;
}
static void VisitImportNode__2qw9(struct ZSourceEngine57 * this, struct ZImportNode370 * Node__1) {
	(void)/*untyped*/NULL(Node);
	return;
}
static struct Object303 * Exec__3qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1, int IsInteractive__2) {
	this->InteractiveContext = IsInteractive;
	/*untyped*/NULL(this);
	if (LibZen_Is(Node, 425)) {
		VisitPrototypeNode__2qw9(this, (struct ZPrototypeNode425 *)Node);
		return ThrowError("type error: requested = Object, given = ZEmptyValue");
	} else if (LibZen_Is(Node, 370)) {
		VisitImportNode__2qw9(this, (struct ZImportNode370 *)Node);
		return ThrowError("type error: requested = Object, given = ZEmptyValue");
	} else {
		Node = CheckType__3qr2(this->TypeChecker, Node, ZTypeVoidType_Z5);
		struct Object303 * ResultValue = Eval__2qw9(this, Node);
		return ResultValue;
	};
}
static struct Object303 * Eval__6qw9(struct ZSourceEngine57 * this, struct ZNameSpace48 * NameSpace__1, const char * ScriptText__2, const char * FileName__3, long LineNumber__4, int IsInteractive__5) {
	struct Object303 * ResultValue = ThrowError("type error: requested = Object, given = ZEmptyValue");
	struct ZBlockNode161 * TopBlockNode = ZBlockNode__2qth(_NewZBlockNode161(), NameSpace);
	struct ZTokenContext53 * TokenContext = ZTokenContext__6qwh(_NewZTokenContext53(), this->Generator, NameSpace, FileName, LineNumber, ScriptText);
	SkipEmptyStatement__1qwh(TokenContext);
	struct ZToken77 * SkipToken = GetToken__1qwh(TokenContext);
	while (HasNext__1qwh(TokenContext)) {
		(void)SetParseFlag__2qwh(TokenContext, ZTokenContext_NotAllowSkipIndent_Z56);
		ClearListAfter__2qu8(TopBlockNode, 0);
		SkipToken = GetToken__1qwh(TokenContext);
		struct ZNode52 * ParsedNode = ParsePattern__4qwh(TokenContext, TopBlockNode, "$Statement$", ZTokenContext_Required_Z53);
		if (IsErrorNode__1qwg(ParsedNode)) {
			SkipError__2qwh(TokenContext, SkipToken);
		};
		ResultValue = Exec__3qw9(this, ParsedNode, IsInteractive);
		if (ResultValue == ZEmptyValue_FalseEmpty_Z41) {
			break;
		};
		SkipEmptyStatement__1qwh(TokenContext);
		Vacume__1qwh(TokenContext);
	};
	if (HasNext__1qwh(TokenContext) && !IsInteractive) {
		ZLogger_LogInfo__2qey(SkipToken, "stopped script at this line");
	};
	return ResultValue;
}
static struct Object303 * Eval__5qw9(struct ZSourceEngine57 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3, int IsInteractive__4) {
	return Eval__6qw9(this, this->Generator->RootNameSpace, ScriptText, FileName, LineNumber, IsInteractive);
}
static int Load__2qw9(struct ZSourceEngine57 * this, const char * FileName__1) {
	const char * ScriptText = LibZen_LoadTextFile__1qqy(FileName);
	if (ScriptText == NULL) {
		LibZen_Exit__2qqr(1, LibZen_StrCat("file not found: ", FileName));
		return 0/*false*/;
	};
	struct Object303 * ResultValue = Eval__5qw9(this, ScriptText, FileName, 1, 0/*false*/);
	ShowErrors__1qrv(this->Logger);
	if (ResultValue == ZEmptyValue_FalseEmpty_Z41) {
		return 0/*false*/;
	};
	return 1/*true*/;
}
static void Unsupported__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1) {
	if (this->InteractiveContext) {
		(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	} else {
		(void)ZLogger_LogError__2qey(Node->SourceToken, "unsupported at top level");
		this->StopVisitor(this);
	};
	return;
}
static void VisitNullNode__2qw9(struct ZSourceEngine57 * this, struct ZNullNode419 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitBooleanNode__2qw9(struct ZSourceEngine57 * this, struct ZBooleanNode476 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitIntNode__2qw9(struct ZSourceEngine57 * this, struct ZIntNode377 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitFloatNode__2qw9(struct ZSourceEngine57 * this, struct ZFloatNode344 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitStringNode__2qw9(struct ZSourceEngine57 * this, struct ZStringNode431 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitArrayLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZArrayLiteralNode481 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitMapLiteralNode__2qw9(struct ZSourceEngine57 * this, struct ZMapLiteralNode399 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitNewObjectNode__2qw9(struct ZSourceEngine57 * this, struct ZNewObjectNode412 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitGlobalNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGlobalNameNode360 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitGetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZGetNameNode350 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitSetNameNode__2qw9(struct ZSourceEngine57 * this, struct ZSetNameNode181 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitGroupNode__2qw9(struct ZSourceEngine57 * this, struct ZGroupNode364 * Node__1) {
	(void)Eval__2qw9(this, Array<ZNode>GetIndex(ZGroupNode_Expr_Z68));
	return;
}
static void VisitGetterNode__2qw9(struct ZSourceEngine57 * this, struct ZGetterNode355 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitSetterNode__2qw9(struct ZSourceEngine57 * this, struct ZSetterNode184 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitGetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZGetIndexNode347 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitSetIndexNode__2qw9(struct ZSourceEngine57 * this, struct ZSetIndexNode178 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitMacroNode__2qw9(struct ZSourceEngine57 * this, struct ZMacroNode392 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitFuncCallNode__2qw9(struct ZSourceEngine57 * this, struct ZFuncCallNode407 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitMethodCallNode__2qw9(struct ZSourceEngine57 * this, struct ZMethodCallNode403 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitUnaryNode__2qw9(struct ZSourceEngine57 * this, struct ZUnaryNode197 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitNotNode__2qw9(struct ZSourceEngine57 * this, struct ZNotNode416 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitCastNode__2qw9(struct ZSourceEngine57 * this, struct ZCastNode321 * Node__1) {
	if (IsVoidType__1qwz(Node->Type)) {
		(void)Eval__2qw9(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
		Node->Type = Array<ZNode>GetIndex(ZCastNode_Expr_Z62)->Type;
	} else {
		Unsupported__2qw9(this, Node);
	};
	return;
}
static void VisitInstanceOfNode__2qw9(struct ZSourceEngine57 * this, struct ZInstanceOfNode373 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitBinaryNode__2qw9(struct ZSourceEngine57 * this, struct ZBinaryNode311 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitComparatorNode__2qw9(struct ZSourceEngine57 * this, struct ZComparatorNode329 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitAndNode__2qw9(struct ZSourceEngine57 * this, struct ZAndNode502 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitOrNode__2qw9(struct ZSourceEngine57 * this, struct ZOrNode422 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitBlockNode__2qw9(struct ZSourceEngine57 * this, struct ZBlockNode161 * Node__1) {
	long i = 1;
	while (i < GetListSize__1qu8(Node) && /*untyped*/NULL(this)) {
		struct ZNode52 * StmtNode = GetListAt__2qu8(Node, i);
		(void)Eval__2qw9(this, StmtNode);
		if (/*untyped*/NULL(StmtNode)) {
			break;
		};
	};
	return;
}
static void VisitVarNode__2qw9(struct ZSourceEngine57 * this, struct ZVarNode506 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitIfNode__2qw9(struct ZSourceEngine57 * this, struct ZIfNode367 * Node__1) {
	struct Object303 * BooleanValue = Eval__2qw9(this, Array<ZNode>GetIndex(ZIfNode_Cond_Z69));
	if (LibZen_Is(BooleanValue, 741)) {
		if (ThrowError("type error: requested = boolean, given = Boolean")) {
			(void)Eval__2qw9(this, Array<ZNode>GetIndex(ZIfNode_Then_Z70));
		} else if (Array<ZNode>GetIndex(ZIfNode_Else_Z71) != NULL) {
			(void)Eval__2qw9(this, Array<ZNode>GetIndex(ZIfNode_Then_Z70));
		};
	};
	return;
}
static void VisitReturnNode__2qw9(struct ZSourceEngine57 * this, struct ZReturnNode170 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitWhileNode__2qw9(struct ZSourceEngine57 * this, struct ZWhileNode200 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitBreakNode__2qw9(struct ZSourceEngine57 * this, struct ZBreakNode318 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitThrowNode__2qw9(struct ZSourceEngine57 * this, struct ZThrowNode191 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitTryNode__2qw9(struct ZSourceEngine57 * this, struct ZTryNode194 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitLetNode__2qw9(struct ZSourceEngine57 * this, struct ZLetNode380 * Node__1) {
	if (HasUntypedNode__1qwg(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", LibZen_BooleanToString(HasUntypedNode__1qwg(Node))), "\n"), toString__1qwg(Node)));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitFunctionNode__2qw9(struct ZSourceEngine57 * this, struct ZFunctionNode144 * Node__1) {
	if (HasUntypedNode__1qwg(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", LibZen_BooleanToString(HasUntypedNode__1qwg(Node))), "\nLAZY: "), toString__1qwg(Node)));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitClassNode__2qw9(struct ZSourceEngine57 * this, struct ZClassNode516 * Node__1) {
	if (HasUntypedNode__1qwg(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", LibZen_BooleanToString(HasUntypedNode__1qwg(Node))), "\n"), toString__1qwg(Node)));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitErrorNode__2qw9(struct ZSourceEngine57 * this, struct ZErrorNode336 * Node__1) {
	(void)ZLogger_LogError__2qey(Node->SourceToken, Node->ErrorMessage);
	this->StopVisitor(this);
	return;
}
static void VisitTypeNode__2qw9(struct ZSourceEngine57 * this, struct ZTypeNode235 * Node__1) {
	Unsupported__2qw9(this, Node);
	return;
}
static void VisitExtendedNode__2qw9(struct ZSourceEngine57 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node, 235)) {
		VisitTypeNode__2qw9(this, (struct ZTypeNode235 *)Node);
	} else {
		struct ZNode52 * SugarNode = /*untyped*/NULL(Node, this->Generator);
		/*untyped*/NULL(SugarNode, this);
	};
	return;
}
static void VisitSugarNode__2qw9(struct ZSourceEngine57 * this, struct ZSugarNode165 * Node__1) {
	(void)Eval__2qw9(this, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z32));
	return;
}
static void WriteTo__2qw9(struct ZSourceEngine57 * this, const char * OutputFile__1) {
	/*untyped*/NULL(this->Generator, OutputFile);
	ShowErrors__1qrv(this->Generator->Logger);
	return;
}
static struct ZSourceGenerator243 * ZSourceGenerator__3quv(struct ZSourceGenerator243 * this, const char * TargetCode__1, const char * TargetVersion__2) {
	(void)ZGenerator__3qwk(this, TargetCode, TargetVersion);
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
	struct ZSourceBuilder42 * Builder = ZSourceBuilder__3qwu(_NewZSourceBuilder42(), this, this->CurrentBuilder);
	LibZen_ArrayAdd((ArrayOfVar *)this->BuilderList, (var)Builder);
	return Builder;
}
static struct ZSourceBuilder42 * InsertNewSourceBuilder__1quv(struct ZSourceGenerator243 * this) {
	struct ZSourceBuilder42 * Builder = ZSourceBuilder__3qwu(_NewZSourceBuilder42(), this, this->CurrentBuilder);
	long i = 0;
	while (i < LibZen_ArraySize((ArrayOfVar *)this->BuilderList)) {
		if (Array<ZSourceBuilder>GetIndex(i) == this->CurrentBuilder) {
			LibZen_ArrayAdd2((ArrayOfVar *)this->BuilderList, i, (var)Builder);
			return Builder;
		};
		i = i + 1;
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->BuilderList, (var)Builder);
	return Builder;
}
static void SetNativeType__3quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1, const char * TypeName__2) {
	const char * Key = LibZen_StrCat("", LibZen_IntToString(Type->TypeId));
	Map<String>SetIndex(Key, TypeName);
	return;
}
static const char * GetNativeType__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1) {
	const char * Key = LibZen_StrCat("", LibZen_IntToString(Type->TypeId));
	const char * TypeName = Map<String>GetIndex(Key);
	if (TypeName == NULL) {
		return Type->ShortName;
	};
	return TypeName;
}
static void SetReservedName__3quv(struct ZSourceGenerator243 * this, const char * Keyword__1, const char * AnotherName__2) {
	if (AnotherName == NULL) {
		AnotherName = LibZen_StrCat("_", Keyword);
	};
	Map<String>SetIndex(Keyword, AnotherName);
	return;
}
static const char * SafeName__3quv(struct ZSourceGenerator243 * this, const char * Name__1, long Index__2) {
	if (Index == 0) {
		const char * SafeName = Map<String>GetIndex(Name);
		if (SafeName == NULL) {
			SafeName = Name;
		};
		return SafeName;
	};
	return LibZen_StrCat(LibZen_StrCat(Name, "__"), LibZen_IntToString(Index));
}
static void SetMacro__4quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3) {
	struct ZFuncType90 * FuncType = ZTypePool_LookupFuncType__1qwz(ReturnType);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__5quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4) {
	struct ZFuncType90 * FuncType = ZTypePool_LookupFuncType__2qwz(ReturnType, P1);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__6quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5) {
	struct ZFuncType90 * FuncType = ZTypePool_LookupFuncType__3qwz(ReturnType, P1, P2);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__7quv(struct ZSourceGenerator243 * this, const char * FuncName__1, const char * Macro__2, struct ZType60 * ReturnType__3, struct ZType60 * P1__4, struct ZType60 * P2__5, struct ZType60 * P3__6) {
	struct ZFuncType90 * FuncType = ZTypePool_LookupFuncType__4qwz(ReturnType, P1, P2, P3);
	SetDefinedFunc__2qwk(this, ZSourceMacro__4qis(_NewZSourceMacro265(), FuncName, FuncType, Macro));
	return;
}
static void SetConverterMacro__4quv(struct ZSourceGenerator243 * this, const char * Macro__1, struct ZType60 * ReturnType__2, struct ZType60 * P1__3) {
	struct ZFuncType90 * FuncType = ZTypePool_LookupFuncType__2qwz(ReturnType, P1);
	SetConverterFunc__4qwk(this, P1, ReturnType, ZSourceMacro__4qis(_NewZSourceMacro265(), LibZen_StrCat("to", NameClass__2qwk(this, ReturnType)), FuncType, Macro));
	return;
}
static void WriteTo__2quv(struct ZSourceGenerator243 * this, const char * FileName__1) {
	LibZen_WriteTo__2qqy(this->NameOutputFile(this, FileName), this->BuilderList);
	this->InitBuilderList(this);
	return;
}
static int StartCodeGeneration__3quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1, int IsInteractive__2) {
	Node->Accept(Node, this);
	if (IsInteractive) {
		long i = 0;
		LibZen_PrintLine__1qqy("---");
		while (i < LibZen_ArraySize((ArrayOfVar *)this->BuilderList)) {
			struct ZSourceBuilder42 * Builder = Array<ZSourceBuilder>GetIndex(i);
			LibZen_PrintLine__1qqy(toString__1qwu(Builder));
			Clear__1qwu(Builder);
			i = i + 1;
		};
		this->InitBuilderList(this);
	};
	return 1/*true*/;
}
static void GenerateCode__3quv(struct ZSourceGenerator243 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2) {
	/*untyped*/NULL(Node, this);
	return;
}
static int IsNeededSurroud__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node, 311)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void GenerateSurroundCode__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1) {
	if (IsNeededSurroud__2quv(this, Node)) {
		Append__2qwu(this->CurrentBuilder, "(");
		/*untyped*/NULL(this, NULL, Node);
		Append__2qwu(this->CurrentBuilder, ")");
	} else {
		/*untyped*/NULL(this, NULL, Node);
	};
	return;
}
static void AppendCode__2quv(struct ZSourceGenerator243 * this, const char * RawSource__1) {
	Append__2qwu(this->CurrentBuilder, RawSource);
	return;
}
static void VisitStmtList__2quv(struct ZSourceGenerator243 * this, struct ZBlockNode161 * BlockNode__1) {
	long i = 0;
	while (i < GetListSize__1qu8(BlockNode)) {
		struct ZNode52 * SubNode = GetListAt__2qu8(BlockNode, i);
		AppendLineFeed__1qwu(this->CurrentBuilder);
		AppendIndent__1qwu(this->CurrentBuilder);
		/*untyped*/NULL(this, NULL, SubNode);
		i = i + 1;
		if (i < GetListSize__1qu8(BlockNode)) {
			Append__2qwu(this->CurrentBuilder, this->SemiColon);
		};
	};
	return;
}
static void VisitBlockNode__2quv(struct ZSourceGenerator243 * this, struct ZBlockNode161 * Node__1) {
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "{");
	Indent__1qwu(this->CurrentBuilder);
	VisitStmtList__2quv(this, Node);
	if (GetListSize__1qu8(Node) > 0) {
		Append__2qwu(this->CurrentBuilder, this->SemiColon);
	};
	UnIndent__1qwu(this->CurrentBuilder);
	AppendLineFeed__1qwu(this->CurrentBuilder);
	AppendIndent__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "}");
	return;
}
static void VisitNullNode__2quv(struct ZSourceGenerator243 * this, struct ZNullNode419 * Node__1) {
	Append__2qwu(this->CurrentBuilder, this->NullLiteral);
	return;
}
static void VisitBooleanNode__2quv(struct ZSourceGenerator243 * this, struct ZBooleanNode476 * Node__1) {
	if (Node->BooleanValue) {
		Append__2qwu(this->CurrentBuilder, this->TrueLiteral);
	} else {
		Append__2qwu(this->CurrentBuilder, this->FalseLiteral);
	};
	return;
}
static void VisitIntNode__2quv(struct ZSourceGenerator243 * this, struct ZIntNode377 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", LibZen_IntToString((Node->IntValue))));
	return;
}
static void VisitFloatNode__2quv(struct ZSourceGenerator243 * this, struct ZFloatNode344 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", LibZen_FloatToString((Node->FloatValue))));
	return;
}
static void VisitStringNode__2quv(struct ZSourceGenerator243 * this, struct ZStringNode431 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->StringValue));
	return;
}
static void VisitArrayLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZArrayLiteralNode481 * Node__1) {
	VisitListNode__4quv(this, "[", Node, "]");
	return;
}
static void VisitMapLiteralNode__2quv(struct ZSourceGenerator243 * this, struct ZMapLiteralNode399 * Node__1) {
	return;
}
static void VisitNewObjectNode__2quv(struct ZSourceGenerator243 * this, struct ZNewObjectNode412 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "new");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	GenerateTypeName__2quv(this, Node->Type);
	VisitListNode__4quv(this, "(", Node, ")");
	return;
}
static void VisitGroupNode__2quv(struct ZSourceGenerator243 * this, struct ZGroupNode364 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGroupNode_Expr_Z68));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitGetIndexNode__2quv(struct ZSourceGenerator243 * this, struct ZGetIndexNode347 * Node__1) {
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
static void VisitGlobalNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGlobalNameNode360 * Node__1) {
	if (IsUntyped__1qwg(Node)) {
		(void)ZLogger_LogError__2qey(Node->SourceToken, LibZen_StrCat("undefined symbol: ", Node->GlobalName));
	};
	if (Node->IsStaticFuncName) {
		Append__2qwu(this->CurrentBuilder, StringfySignature__2qwz(Node->Type, Node->GlobalName));
	} else {
		Append__2qwu(this->CurrentBuilder, Node->GlobalName);
	};
	return;
}
static void VisitGetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZGetNameNode350 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node->VarName, Node->VarIndex));
	return;
}
static void VisitSetNameNode__2quv(struct ZSourceGenerator243 * this, struct ZSetNameNode181 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node->VarName, Node->VarIndex));
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetNameNode_Expr_Z29));
	return;
}
static void VisitGetterNode__2quv(struct ZSourceGenerator243 * this, struct ZGetterNode355 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZGetterNode_Recv_Z67));
	Append__2qwu(this->CurrentBuilder, ".");
	Append__2qwu(this->CurrentBuilder, Node->FieldName);
	return;
}
static void VisitSetterNode__2quv(struct ZSourceGenerator243 * this, struct ZSetterNode184 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZSetterNode_Recv_Z30));
	Append__2qwu(this->CurrentBuilder, ".");
	Append__2qwu(this->CurrentBuilder, Node->FieldName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetterNode_Expr_Z31));
	return;
}
static void VisitMethodCallNode__2quv(struct ZSourceGenerator243 * this, struct ZMethodCallNode403 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z76));
	Append__2qwu(this->CurrentBuilder, ".");
	Append__2qwu(this->CurrentBuilder, Node->MethodName);
	VisitListNode__4quv(this, "(", Node, ")");
	return;
}
static void VisitMacroNode__2quv(struct ZSourceGenerator243 * this, struct ZMacroNode392 * Node__1) {
	const char * Macro = GetMacroText__1q05(Node);
	struct ZFuncType90 * FuncType = GetFuncType__1q05(Node);
	long fromIndex = 0;
	long BeginNum = LibZen_IndexOf2(Macro, "$[", fromIndex);
	while (BeginNum != -1) {
		long EndNum = LibZen_IndexOf2(Macro, "]", BeginNum + 2);
		if (EndNum == -1) {
			break;
		};
		Append__2qwu(this->CurrentBuilder, LibZen_SubString2(Macro, fromIndex));
		long Index = (long)LibZen_ParseInt__1qqy(LibZen_SubString2(Macro, BeginNum + 2));
		if (HasAst__2qwg(Node, Index)) {
			this->GenerateCode(this, GetFuncParamType__2qej(FuncType, Index), Array<ZNode>GetIndex(Index));
		};
		fromIndex = EndNum + 1;
		BeginNum = LibZen_IndexOf2(Macro, "$[", fromIndex);
	};
	Append__2qwu(this->CurrentBuilder, LibZen_SubString(Macro, fromIndex));
	return;
}
static void VisitFuncCallNode__2quv(struct ZSourceGenerator243 * this, struct ZFuncCallNode407 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79));
	VisitListNode__4quv(this, "(", Node, ")");
	return;
}
static void VisitUnaryNode__2quv(struct ZSourceGenerator243 * this, struct ZUnaryNode197 * Node__1) {
	Append__2qwu(this->CurrentBuilder, GetText__1qey(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z37));
	return;
}
static void VisitNotNode__2quv(struct ZSourceGenerator243 * this, struct ZNotNode416 * Node__1) {
	Append__2qwu(this->CurrentBuilder, this->NotOperator);
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z37));
	return;
}
static void VisitCastNode__2quv(struct ZSourceGenerator243 * this, struct ZCastNode321 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "(");
	GenerateTypeName__2quv(this, Node->Type);
	Append__2qwu(this->CurrentBuilder, ")");
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z62));
	return;
}
static void VisitInstanceOfNode__2quv(struct ZSourceGenerator243 * this, struct ZInstanceOfNode373 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, "instanceof");
	GenerateTypeName__2quv(this, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61)->Type);
	return;
}
static void VisitBinaryNode__2quv(struct ZSourceGenerator243 * this, struct ZBinaryNode311 * Node__1) {
	if (LibZen_Is(Node->ParentNode, 311)) {
		Append__2qwu(this->CurrentBuilder, "(");
	};
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, GetText__1qey(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	if (LibZen_Is(Node->ParentNode, 311)) {
		Append__2qwu(this->CurrentBuilder, ")");
	};
	return;
}
static void VisitComparatorNode__2quv(struct ZSourceGenerator243 * this, struct ZComparatorNode329 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, GetText__1qey(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	return;
}
static void VisitAndNode__2quv(struct ZSourceGenerator243 * this, struct ZAndNode502 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, this->AndOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	return;
}
static void VisitOrNode__2quv(struct ZSourceGenerator243 * this, struct ZOrNode422 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z60));
	AppendToken__2qwu(this->CurrentBuilder, this->OrOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z61));
	return;
}
static void VisitIfNode__2quv(struct ZSourceGenerator243 * this, struct ZIfNode367 * Node__1) {
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
static void VisitBreakNode__2quv(struct ZSourceGenerator243 * this, struct ZBreakNode318 * Node__1) {
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
static void VisitCatchNode__2quv(struct ZSourceGenerator243 * this, struct ZCatchNode325 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "catch (");
	Append__2qwu(this->CurrentBuilder, Node->ExceptionName);
	VisitTypeAnnotation__2quv(this, Node->ExceptionType);
	Append__2qwu(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZCatchNode_Block_Z63));
	return;
}
static void VisitVarNode__2quv(struct ZSourceGenerator243 * this, struct ZVarNode506 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "var");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, Node->NativeName);
	VisitTypeAnnotation__2quv(this, Node->DeclType);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZVarNode_InitValue_Z81));
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	VisitStmtList__2quv(this, Node);
	return;
}
static void VisitTypeAnnotation__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1) {
	Append__2qwu(this->CurrentBuilder, ": ");
	GenerateTypeName__2quv(this, Type);
	return;
}
static void VisitLetNode__2quv(struct ZSourceGenerator243 * this, struct ZLetNode380 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "let");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, Node->GlobalName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZLetNode_InitValue_Z73));
	return;
}
static void VisitParamNode__2quv(struct ZSourceGenerator243 * this, struct ZParamNode172 * Node__1) {
	Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node->Name, Node->ParamIndex));
	VisitTypeAnnotation__2quv(this, Node->Type);
	return;
}
static void VisitFunctionNode__2quv(struct ZSourceGenerator243 * this, struct ZFunctionNode144 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "function");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	if (Node->FuncName != NULL) {
		Append__2qwu(this->CurrentBuilder, Node->FuncName);
	};
	VisitListNode__4quv(this, "(", Node, ")");
	VisitTypeAnnotation__2quv(this, Node->ReturnType);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFunctionNode_Block_Z80));
	return;
}
static void VisitClassNode__2quv(struct ZSourceGenerator243 * this, struct ZClassNode516 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "class");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, Node->ClassName);
	if (Node->SuperType != NULL) {
		AppendToken__2qwu(this->CurrentBuilder, "extends");
		GenerateTypeName__2quv(this, Node->SuperType);
	};
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "{");
	Indent__1qwu(this->CurrentBuilder);
	long i = 0;
	while (i < GetListSize__1qu8(Node)) {
		struct ZFieldNode340 * FieldNode = GetFieldNode__2qda(Node, i);
		AppendLineFeed__1qwu(this->CurrentBuilder);
		AppendIndent__1qwu(this->CurrentBuilder);
		Append__2qwu(this->CurrentBuilder, "var");
		AppendWhiteSpace__1qwu(this->CurrentBuilder);
		Append__2qwu(this->CurrentBuilder, FieldNode->FieldName);
		VisitTypeAnnotation__2quv(this, FieldNode->DeclType);
		if (HasAst__2qwg(FieldNode, ZFieldNode_InitValue_Z64)) {
			AppendToken__2qwu(this->CurrentBuilder, "=");
			/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFieldNode_InitValue_Z64));
		};
		Append__2qwu(this->CurrentBuilder, this->SemiColon);
		i = i + 1;
	};
	UnIndent__1qwu(this->CurrentBuilder);
	AppendLineFeed__1qwu(this->CurrentBuilder);
	AppendIndent__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, "}");
	return;
}
static void VisitErrorNode__2quv(struct ZSourceGenerator243 * this, struct ZErrorNode336 * Node__1) {
	(void)ZLogger_LogError__2qey(Node->SourceToken, Node->ErrorMessage);
	Append__2qwu(this->CurrentBuilder, "ThrowError(");
	Append__2qwu(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->ErrorMessage));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitExtendedNode__2quv(struct ZSourceGenerator243 * this, struct ZNode52 * Node__1) {
	if (LibZen_Is(Node, 172)) {
		VisitParamNode__2quv(this, (struct ZParamNode172 *)Node);
	} else {
		struct ZSugarNode165 * SugarNode = /*untyped*/NULL(Node, this);
		/*untyped*/NULL(this, SugarNode);
	};
	return;
}
static void VisitSugarNode__2quv(struct ZSourceGenerator243 * this, struct ZSugarNode165 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z32));
	return;
}
static void GenerateTypeName__2quv(struct ZSourceGenerator243 * this, struct ZType60 * Type__1) {
	Append__2qwu(this->CurrentBuilder, GetNativeType__2quv(this, /*untyped*/NULL(Type)));
	return;
}
static void VisitListNode__5quv(struct ZSourceGenerator243 * this, const char * OpenToken__1, struct ZListNode251 * VargNode__2, const char * DelimToken__3, const char * CloseToken__4) {
	Append__2qwu(this->CurrentBuilder, OpenToken);
	long i = 0;
	while (i < GetListSize__1qu8(VargNode)) {
		struct ZNode52 * ParamNode = GetListAt__2qu8(VargNode, i);
		if (i > 0) {
			Append__2qwu(this->CurrentBuilder, DelimToken);
		};
		/*untyped*/NULL(this, NULL, ParamNode);
		i = i + 1;
	};
	Append__2qwu(this->CurrentBuilder, CloseToken);
	return;
}
static void VisitListNode__4quv(struct ZSourceGenerator243 * this, const char * OpenToken__1, struct ZListNode251 * VargNode__2, const char * CloseToken__3) {
	VisitListNode__5quv(this, OpenToken, VargNode, ", ", CloseToken);
	return;
}
static struct ZTypeChecker142 * ZTypeChecker__2qr2(struct ZTypeChecker142 * this, struct ZGenerator55 * Generator__1) {
	this->Generator = Generator;
	this->Logger = Generator->Logger;
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
	struct ZNode52 * ParentNode = Node->ParentNode;
	this->StackedContextType = ContextType;
	this->ReturnedNode = NULL;
	Node->Accept(Node, this);
	if (this->ReturnedNode == NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("!! returns no value: ", toString__1qwg(Node)));
	} else {
		Node = this->ReturnedNode;
	};
	if (ParentNode != Node->ParentNode && ParentNode != NULL) {
		(void)SetChild__2qwg(ParentNode, Node);
	};
	CheckVarNode__3qrc(this->VarScope, ContextType, Node);
	return Node;
}
static struct ZNode52 * CreateStupidCastNode__3qr2(struct ZTypeChecker142 * this, struct ZType60 * Requested__1, struct ZNode52 * Node__2) {
	struct ZNode52 * ErrorNode = ZStupidCastErrorNode__3qae(_NewZStupidCastErrorNode434(), Node, LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("type error: requested = ", toString__1qwz(Requested)), ", given = "), toString__1qwz(Node->Type)));
	ErrorNode->Type = Requested;
	return ErrorNode;
}
static struct ZNode52 * EnforceNodeType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * EnforcedType__2) {
	struct ZFunc89 * Func = LookupConverterFunc__3qwk(this->Generator, Node->Type, EnforcedType);
	if (Func == NULL && IsStringType__1qwz(EnforcedType)) {
		Func = LookupFunc__4qwk(this->Generator, "toString", Node->Type, 1);
	};
	if (LibZen_Is(Func, 210)) {
		struct ZMacroNode392 * MacroNode = ZMacroNode__4q05(_NewZMacroNode392(), Node->ParentNode, NULL, (struct ZMacroFunc210 *)Func);
		Append__2qu8(MacroNode, Node);
		MacroNode->Type = EnforcedType;
		return MacroNode;
	} else if (Func != NULL) {
		struct ZFuncCallNode407 * MacroNode = ZFuncCallNode__4q44(_NewZFuncCallNode407(), Node->ParentNode, Func->FuncName, GetFuncType__1qeh(Func));
		Append__2qu8(MacroNode, Node);
		MacroNode->Type = EnforcedType;
		return MacroNode;
	};
	return CreateStupidCastNode__3qr2(this, EnforcedType, Node);
}
static struct ZNode52 * TypeCheckImpl__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2, long TypeCheckPolicy__3) {
	if (IsErrorNode__1qwg(Node)) {
		if (!ContextType->IsVarType(ContextType)) {
			Node->Type = ContextType;
		};
		return Node;
	};
	if (IsUntyped__1qwg(Node) || ContextType->IsVarType(ContextType) || LibZen_IsFlag__2qqr(TypeCheckPolicy, ZTypeChecker_NoCheckPolicy_Z78)) {
		return Node;
	};
	if (Node->Type == ContextType || Accept__2qwz(ContextType, Node->Type)) {
		return Node;
	};
	if (IsVoidType__1qwz(ContextType) && !IsVoidType__1qwz(Node->Type)) {
		return ZCastNode__4qo3(_NewZCastNode321(), Node->ParentNode, ZTypeVoidType_Z5, Node);
	};
	if (IsFloatType__1qwz(ContextType) && IsIntType__1qwz(Node->Type)) {
		return EnforceNodeType__3qr2(this, Node, ContextType);
	};
	if (IsIntType__1qwz(ContextType) && IsFloatType__1qwz(Node->Type)) {
		return EnforceNodeType__3qr2(this, Node, ContextType);
	};
	return CreateStupidCastNode__3qr2(this, ContextType, Node);
}
static struct ZNode52 * VisitTypeChecker__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2, long TypeCheckPolicy__3) {
	if (/*untyped*/NULL(this) && Node != NULL) {
		if (HasUntypedNode__1qwg(Node)) {
			Node = VisitTypeChecker__3qwg(Node, this, ContextType);
		};
		Node = TypeCheckImpl__4qr2(this, Node, ContextType, TypeCheckPolicy);
		CheckVarNode__3qrc(this->VarScope, ContextType, Node);
	};
	this->ReturnedNode = NULL;
	return Node;
}
static struct ZNode52 * TryType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2) {
	return VisitTypeChecker__4qr2(this, Node, ContextType, ZTypeChecker_NoCheckPolicy_Z78);
}
static void TryTypeAt__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, long Index__2, struct ZType60 * ContextType__3) {
	Set__3qwg(Node, Index, VisitTypeChecker__4qr2(this, Array<ZNode>GetIndex(Index), ContextType, ZTypeChecker_NoCheckPolicy_Z78));
	return;
}
static struct ZNode52 * CheckType__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * ContextType__2) {
	return VisitTypeChecker__4qr2(this, Node, ContextType, ZTypeChecker_DefaultTypeCheckPolicy_Z77);
}
static void CheckTypeAt__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, long Index__2, struct ZType60 * ContextType__3) {
	Set__3qwg(Node, Index, VisitTypeChecker__4qr2(this, Array<ZNode>GetIndex(Index), ContextType, ZTypeChecker_DefaultTypeCheckPolicy_Z77));
	return;
}
static int TypeCheckNodeList__2qr2(struct ZTypeChecker142 * this, struct ZListNode251 * List__1) {
	if (/*untyped*/NULL(this)) {
		int AllTyped = 1/*true*/;
		long i = 0;
		while (i < GetListSize__1qu8(List)) {
			struct ZNode52 * SubNode = GetListAt__2qu8(List, i);
			SubNode = CheckType__3qr2(this, SubNode, ZTypeVarType_Z4);
			SetListAt__3qu8(List, i, SubNode);
			if (IsUntyped__1qwg(SubNode)) {
				AllTyped = 0/*false*/;
			};
			i = i + 1;
		};
		return AllTyped;
	};
	return 0/*false*/;
}
static void Return__2qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1) {
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", toString__1qwg(Node)));
	};
	this->ReturnedNode = Node;
	return;
}
static void TypedNode__3qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZType60 * Type__2) {
	Node->Type = Type->GetRealType(Type);
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", toString__1qwg(Node)));
	};
	this->ReturnedNode = Node;
	return;
}
static void ReturnErrorNode__4qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1, struct ZToken77 * ErrorToken__2, const char * Message__3) {
	if (ErrorToken == NULL) {
		ErrorToken = Node->SourceToken;
	};
	Return__2qr2(this, ZErrorNode__4qpa(_NewZErrorNode336(), Node->ParentNode, ErrorToken, Message));
	return;
}
static void VisitErrorNode__2qr2(struct ZTypeChecker142 * this, struct ZErrorNode336 * Node__1) {
	struct ZType60 * ContextType = GetContextType__1qr2(this);
	if (!/*untyped*/NULL(ContextType)) {
		TypedNode__3qr2(this, Node, ContextType);
	} else {
		Return__2qr2(this, Node);
	};
	return;
}
static void VisitExtendedNode__2qr2(struct ZTypeChecker142 * this, struct ZNode52 * Node__1) {
	struct ZType60 * ContextType = GetContextType__1qr2(this);
	struct ZNode52 * DeNode = /*untyped*/NULL(Node, this->Generator);
	if (!IsErrorNode__1qwg(DeNode)) {
		Return__2qr2(this, CheckType__3qr2(this, DeNode, ContextType));
	} else {
		TypedNode__3qr2(this, DeNode, ContextType);
	};
	return;
}
static void VisitSugarNode__2qr2(struct ZTypeChecker142 * this, struct ZSugarNode165 * Node__1) {
	struct ZType60 * ContextType = GetContextType__1qr2(this);
	CheckTypeAt__4qr2(this, Node, ZSugarNode_DeSugar_Z32, ContextType);
	TypedNode__3qr2(this, Node, GetAstType__2qwg(Node, ZSugarNode_DeSugar_Z32));
	return;
}
static struct CSourceGenerator599 * CSourceGenerator__1qg6(struct CSourceGenerator599 * this) {
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
	SetMacro__5quv(this, "size", "LibZen_ArraySize($[0])", ZTypeIntType_Z7, ThrowError("type error: requested = ZType, given = ZGeneric1Type"));
	SetMacro__6quv(this, "clear", "LibZen_ArrayClear($[0])", ZTypeVoidType_Z5, ThrowError("type error: requested = ZType, given = ZGeneric1Type"), ZTypeIntType_Z7);
	SetMacro__6quv(this, "add", "LibZen_ArrayAdd($[0], $[1])", ZTypeVoidType_Z5, ThrowError("type error: requested = ZType, given = ZGeneric1Type"), ZTypeVarType_Z4);
	SetMacro__7quv(this, "add", "LibZen_ArrayAdd2($[0], $[1], $[2])", ZTypeVoidType_Z5, ThrowError("type error: requested = ZType, given = ZGeneric1Type"), ZTypeIntType_Z7, ZTypeVarType_Z4);
	return NULL;
}
static struct ZSourceEngine57 * GetEngine__1qg6(struct CSourceGenerator599 * this) {
	return ZSourceEngine__3qw9(_NewZSourceEngine57(), ZTypeChecker__2qr2(_NewZTypeChecker142(), this), this);
}
static void GenerateCode__3qg6(struct CSourceGenerator599 * this, struct ZType60 * ContextType__1, struct ZNode52 * Node__2) {
	if (IsUntyped__1qwg(Node) && !IsErrorNode__1qwg(Node)) {
		Append__2qwu(this->CurrentBuilder, LibZen_StrCat("/*untyped*/", this->NullLiteral));
		(void)ZLogger_LogError__2qey(Node->SourceToken, "untyped error");
	} else {
		if (ContextType != NULL && Node->Type != ContextType) {
			Append__2qwu(this->CurrentBuilder, "(");
			GenerateTypeName__2qg6(this, ContextType);
			Append__2qwu(this->CurrentBuilder, ")");
		};
		Node->Accept(Node, this);
	};
	return;
}
static void VisitArrayLiteralNode__2qg6(struct CSourceGenerator599 * this, struct ZArrayLiteralNode481 * Node__1) {
	struct ZType60 * ParamType = Node->Type->GetParamType(Node->Type, 0);
	if (IsIntType__1qwz(ParamType) || IsBooleanType__1qwz(ParamType)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewIntArray(");
	} else if (IsFloatType__1qwz(ParamType)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewFloatArray(");
	} else if (IsStringType__1qwz(ParamType)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewStringArray(");
	} else {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewArray(");
	};
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", ThrowError("type error: requested = String, given = var")));
	if (GetListSize__1qu8(Node) > 0) {
		Append__2qwu(this->CurrentBuilder, this->Camma);
	};
	VisitListNode__4quv(this, "", Node, ")");
	return;
}
static void VisitMapLiteralNode__2qg6(struct CSourceGenerator599 * this, struct ZMapLiteralNode399 * Node__1) {
	struct ZType60 * ParamType = Node->Type->GetParamType(Node->Type, 0);
	if (IsIntType__1qwz(ParamType) || IsBooleanType__1qwz(ParamType)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewIntMap(");
	} else if (IsFloatType__1qwz(ParamType)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewFloatMap(");
	} else if (IsStringType__1qwz(ParamType)) {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewStringMap(");
	} else {
		Append__2qwu(this->CurrentBuilder, "LibZen_NewMap(");
	};
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("", ThrowError("type error: requested = String, given = var")));
	if (GetListSize__1qu8(Node) > 0) {
		Append__2qwu(this->CurrentBuilder, this->Camma);
	};
	VisitListNode__4quv(this, "", Node, ")");
	return;
}
static void VisitNewObjectNode__2qg6(struct CSourceGenerator599 * this, struct ZNewObjectNode412 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat("_New", NameClass__2qwk(this, Node->Type)));
	VisitListNode__4quv(this, "(", Node, ")");
	return;
}
static const char * BaseName__2qg6(struct CSourceGenerator599 * this, struct ZType60 * RecvType__1) {
	return GetAsciiName__1qwz(RecvType);
}
static void VisitGetIndexNode__2qg6(struct CSourceGenerator599 * this, struct ZGetIndexNode347 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat(BaseName__2qg6(this, GetAstType__2qwg(Node, ZGetIndexNode_Recv_Z65)), "GetIndex"));
	Append__2qwu(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Index_Z66));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitSetIndexNode__2qg6(struct CSourceGenerator599 * this, struct ZSetIndexNode178 * Node__1) {
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat(BaseName__2qg6(this, GetAstType__2qwg(Node, ZGetIndexNode_Recv_Z65)), "SetIndex"));
	Append__2qwu(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Index_Z27));
	Append__2qwu(this->CurrentBuilder, this->Camma);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Expr_Z28));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void VisitGetNameNode__2qg6(struct CSourceGenerator599 * this, struct ZGetNameNode350 * Node__1) {
	Append__2qwu(this->CurrentBuilder, Node->VarName);
	return;
}
static void VisitSetNameNode__2qg6(struct CSourceGenerator599 * this, struct ZSetNameNode181 * Node__1) {
	Append__2qwu(this->CurrentBuilder, Node->VarName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetNameNode_Expr_Z29));
	return;
}
static void VisitGetterNode__2qg6(struct CSourceGenerator599 * this, struct ZGetterNode355 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZGetterNode_Recv_Z67));
	Append__2qwu(this->CurrentBuilder, "->");
	Append__2qwu(this->CurrentBuilder, Node->FieldName);
	return;
}
static void VisitSetterNode__2qg6(struct CSourceGenerator599 * this, struct ZSetterNode184 * Node__1) {
	GenerateSurroundCode__2quv(this, Array<ZNode>GetIndex(ZSetterNode_Recv_Z30));
	Append__2qwu(this->CurrentBuilder, "->");
	Append__2qwu(this->CurrentBuilder, Node->FieldName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetterNode_Expr_Z31));
	return;
}
static void VisitMethodCallNode__2qg6(struct CSourceGenerator599 * this, struct ZMethodCallNode403 * Node__1) {
	return;
}
static void VisitFuncCallNode__2qg6(struct CSourceGenerator599 * this, struct ZFuncCallNode407 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79));
	VisitListNode__4quv(this, "(", Node, ")");
	return;
}
static void VisitThrowNode__2qg6(struct CSourceGenerator599 * this, struct ZThrowNode191 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZThrowNode_Expr_Z33));
	Append__2qwu(this->CurrentBuilder, "longjump(1)");
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	return;
}
static void VisitTryNode__2qg6(struct CSourceGenerator599 * this, struct ZTryNode194 * Node__1) {
	return;
}
static void VisitCatchNode__2qg6(struct CSourceGenerator599 * this, struct ZCatchNode325 * Node__1) {
	return;
}
static const char * ParamTypeName__2qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1) {
	if (IsArrayType__1qwz(Type)) {
		return LibZen_StrCat("ArrayOf", ParamTypeName__2qg6(this, /*untyped*/NULL(Type, 0)));
	};
	if (IsMapType__1qwz(Type)) {
		return LibZen_StrCat("MapOf", ParamTypeName__2qg6(this, /*untyped*/NULL(Type, 0)));
	};
	if (IsFuncType__1qwz(Type)) {
		const char * s = LibZen_StrCat(LibZen_StrCat("FuncOf", ParamTypeName__2qg6(this, /*untyped*/NULL(Type, 0))), "Of");
		long i = 0;
		while (i < /*untyped*/NULL(Type)) {
			s = LibZen_StrCat(s, ParamTypeName__2qg6(this, /*untyped*/NULL(Type, i)));
			i = i + 1;
		};
		return s;
	};
	if (IsIntType__1qwz(Type)) {
		return "Int";
	};
	if (IsFloatType__1qwz(Type)) {
		return "Float";
	};
	if (IsVoidType__1qwz(Type)) {
		return "Void";
	};
	if (/*untyped*/NULL(Type)) {
		return "Var";
	};
	return Type->ShortName;
}
static const char * GetNativeType__2qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1) {
	const char * TypeName = NULL;
	if (IsArrayType__1qwz(Type) || IsMapType__1qwz(Type)) {
		TypeName = LibZen_StrCat(ParamTypeName__2qg6(this, Type), " *");
	};
	if (LibZen_Is(Type, 80)) {
		TypeName = LibZen_StrCat(LibZen_StrCat("struct ", NameClass__2qwk(this, Type)), " *");
	};
	if (TypeName == NULL) {
		TypeName = /*untyped*/NULL;
	};
	return TypeName;
}
static void GenerateFuncTypeName__3qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1, const char * FuncName__2) {
	GenerateTypeName__2qg6(this, /*untyped*/NULL(Type, 0));
	Append__2qwu(this->CurrentBuilder, LibZen_StrCat(LibZen_StrCat(" (*", FuncName), ")"));
	long i = 1;
	Append__2qwu(this->CurrentBuilder, "(");
	while (i < /*untyped*/NULL(Type)) {
		if (i > 1) {
			Append__2qwu(this->CurrentBuilder, ",");
		};
		GenerateTypeName__2qg6(this, /*untyped*/NULL(Type, i));
		i = i + 1;
	};
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void GenerateTypeName__2qg6(struct CSourceGenerator599 * this, struct ZType60 * Type__1) {
	if (IsFuncType__1qwz(Type)) {
		GenerateFuncTypeName__3qg6(this, Type, "");
	} else {
		Append__2qwu(this->CurrentBuilder, GetNativeType__2qg6(this, /*untyped*/NULL(Type)));
	};
	return;
}
static void VisitVarNode__2qg6(struct CSourceGenerator599 * this, struct ZVarNode506 * Node__1) {
	GenerateTypeName__2qg6(this, Node->DeclType);
	Append__2qwu(this->CurrentBuilder, " ");
	Append__2qwu(this->CurrentBuilder, Node->NativeName);
	AppendToken__2qwu(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZVarNode_InitValue_Z81));
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	VisitStmtList__2quv(this, Node);
	return;
}
static void VisitParamNode__2qg6(struct CSourceGenerator599 * this, struct ZParamNode172 * Node__1) {
	if (IsFuncType__1qwz(Node->Type)) {
		GenerateFuncTypeName__3qg6(this, Node->Type, Node->Name);
	} else {
		GenerateTypeName__2qg6(this, Node->Type);
		Append__2qwu(this->CurrentBuilder, " ");
		Append__2qwu(this->CurrentBuilder, SafeName__3quv(this, Node->Name, Node->ParamIndex));
	};
	return;
}
static void SetMethod__3qg6(struct CSourceGenerator599 * this, const char * FuncName__1, struct ZFuncType90 * FuncType__2) {
	struct ZType60 * RecvType = GetRecvType__1qej(FuncType);
	if (LibZen_Is(RecvType, 80) && FuncName != NULL) {
		struct ZClassType80 * ClassType = (struct ZClassType80 *)RecvType;
		struct ZType60 * FieldType = GetFieldType__3qeo(ClassType, FuncName, NULL);
		if (FieldType == NULL || !IsFuncType__1qwz(FieldType)) {
			FuncName = LibZen_AnotherName__1qqy(FuncName);
			FieldType = GetFieldType__3qeo(ClassType, FuncName, NULL);
			if (FieldType == NULL || !IsFuncType__1qwz(FieldType)) {
				return;
			};
		};
		if (LibZen_Is(FieldType, 90)) {
			if (AcceptAsFieldFunc__2qej(((struct ZFuncType90 *)FieldType), FuncType)) {
				Append__2qwu(this->HeaderBuilder, LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("#define _", NameClass__2qwk(this, ClassType)), "_"), FuncName));
				AppendLineFeed__1qwu(this->HeaderBuilder);
			};
		};
	};
	return;
}
static void VisitInstanceOfNode__2qg6(struct CSourceGenerator599 * this, struct ZInstanceOfNode373 * Node__1) {
	Append__2qwu(this->CurrentBuilder, "LibZen_Is(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZInstanceOfNode_Left_Z72));
	Append__2qwu(this->CurrentBuilder, this->Camma);
	AppendInt__2qwu(this->CurrentBuilder, Node->TargetType->TypeId);
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static void GenerateCField__3qg6(struct CSourceGenerator599 * this, const char * CType__1, const char * FieldName__2) {
	AppendLineFeed__1qwu(this->CurrentBuilder);
	AppendIndent__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, CType);
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, FieldName);
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	return;
}
static void GenerateField__3qg6(struct CSourceGenerator599 * this, struct ZType60 * DeclType__1, const char * FieldName__2) {
	AppendLineFeedIndent__1qwu(this->CurrentBuilder);
	GenerateTypeName__2qg6(this, DeclType);
	AppendWhiteSpace__1qwu(this->CurrentBuilder);
	Append__2qwu(this->CurrentBuilder, FieldName);
	Append__2qwu(this->CurrentBuilder, this->SemiColon);
	return;
}
static void GenerateFields__3qg6(struct CSourceGenerator599 * this, struct ZClassType80 * ClassType__1, struct ZType60 * ThisType__2) {
	struct ZType60 * SuperType = /*untyped*/NULL(ThisType);
	if (!/*untyped*/NULL(SuperType)) {
		GenerateFields__3qg6(this, ClassType, SuperType);
	};
	long i = 0;
	GenerateCField__3qg6(this, "int", LibZen_StrCat("_classId", LibZen_IntToString(ThisType->TypeId)));
	GenerateCField__3qg6(this, "int", LibZen_StrCat("_delta", LibZen_IntToString(ThisType->TypeId)));
	while (i < GetFieldSize__1qeo(ClassType)) {
		struct ZClassField79 * ClassField = GetFieldAt__2qeo(ClassType, i);
		if (ClassField->ClassType == ThisType) {
			GenerateField__3qg6(this, ClassField->FieldType, ClassField->FieldName);
		};
		i = i + 1;
	};
	return;
}
static void VisitErrorNode__2qg6(struct CSourceGenerator599 * this, struct ZErrorNode336 * Node__1) {
	(void)ZLogger_LogError__2qey(Node->SourceToken, Node->ErrorMessage);
	Append__2qwu(this->CurrentBuilder, "ThrowError(");
	Append__2qwu(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->ErrorMessage));
	Append__2qwu(this->CurrentBuilder, ")");
	return;
}
static struct ZAndNode502 * ZAndNode__5qs2(struct ZAndNode502 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, struct ZNode52 * Left__3, struct ZSyntax219 * Pattern__4) {
	(void)ZBinaryNode__5qo6(this, ParentNode, Token, Left, Pattern);
	return NULL;
}
static void Accept__2qs2(struct ZAndNode502 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZArrayLiteralNode481 * ZArrayLiteralNode__2qss(struct ZArrayLiteralNode481 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 0);
	return NULL;
}
static void Accept__2qss(struct ZArrayLiteralNode481 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZBlockNode161 * ZBlockNode__2qth(struct ZBlockNode161 * this, struct ZNameSpace48 * NameSpace__1) {
	(void)ZListNode__4qu8(this, NULL, NULL, 0);
	this->NameSpace = NameSpace;
	return NULL;
}
static struct ZBlockNode161 * ZBlockNode__3qth(struct ZBlockNode161 * this, struct ZNode52 * ParentNode__1, long Init__2) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, Init);
	this->NameSpace = CreateSubNameSpace__1qwa(GetNameSpace__1qwg(ParentNode));
	return NULL;
}
static void Accept__2qth(struct ZBlockNode161 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZReturnNode170 * ToReturnNode__1qth(struct ZBlockNode161 * this) {
	if (GetListSize__1qu8(this) == 1) {
		return ToReturnNode__1qwg(GetListAt__2qu8(this, 0));
	};
	return NULL;
}
static long IndexOf__2qth(struct ZBlockNode161 * this, struct ZNode52 * ChildNode__1) {
	long i = 0;
	while (i < GetListSize__1qu8(this)) {
		if (GetListAt__2qu8(this, i) == ChildNode) {
			return i;
		};
		i = i + 1;
	};
	return -1;
}
static void CopyTo__3qth(struct ZBlockNode161 * this, long Index__1, struct ZBlockNode161 * BlockNode__2) {
	long i = Index;
	while (i < GetListSize__1qu8(this)) {
		Append__2qu8(BlockNode, GetListAt__2qu8(this, i));
		i = i + 1;
	};
	return;
}
static struct ZBooleanNode476 * ZBooleanNode__4qso(struct ZBooleanNode476 * this, struct ZNode52 * ParentNode__1, struct ZToken77 * Token__2, int Value__3) {
	(void)ZConstNode__3qpo(this, ParentNode, Token);
	this->Type = ZTypeBooleanType_Z6;
	this->BooleanValue = Value;
	return NULL;
}
static void Accept__2qso(struct ZBooleanNode476 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZClassNode516 * ZClassNode__2qda(struct ZClassNode516 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetTypeInfo__3qda(struct ZClassNode516 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->SuperType = Type;
	this->SuperToken = TypeToken;
	return;
}
static void SetNameInfo__3qda(struct ZClassNode516 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->ClassName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZFieldNode340 * GetFieldNode__2qda(struct ZClassNode516 * this, long Index__1) {
	struct ZNode52 * Node = GetListAt__2qu8(this, Index);
	if (LibZen_Is(Node, 340)) {
		return (struct ZFieldNode340 *)Node;
	};
	return NULL;
}
static void Accept__2qda(struct ZClassNode516 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFuncCallNode407 * ZFuncCallNode__3q44(struct ZFuncCallNode407 * this, struct ZNode52 * ParentNode__1, struct ZNode52 * FuncNode__2) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 1);
	Set__3qwg(this, ZFuncCallNode_Func_Z79, FuncNode);
	return NULL;
}
static struct ZFuncCallNode407 * ZFuncCallNode__4q44(struct ZFuncCallNode407 * this, struct ZNode52 * ParentNode__1, const char * FuncName__2, struct ZType60 * FuncType__3) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 1);
	struct ZGlobalNameNode360 * FuncNode = ZGlobalNameNode__6q0q(_NewZGlobalNameNode360(), this, NULL, FuncType, FuncName, 1/*true*/);
	Set__3qwg(this, ZFuncCallNode_Func_Z79, FuncNode);
	return NULL;
}
static void Accept__2q44(struct ZFuncCallNode407 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZType60 * GetRecvType__1q44(struct ZFuncCallNode407 * this) {
	if (GetListSize__1qu8(this) > 0) {
		return /*untyped*/NULL(GetListAt__2qu8(this, 0)->Type);
	};
	return ZTypeVoidType_Z5;
}
static const char * GetFuncName__1q44(struct ZFuncCallNode407 * this) {
	struct ZNode52 * FNode = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79);
	if (LibZen_Is(FNode, 360)) {
		return ((struct ZGlobalNameNode360 *)FNode)->GlobalName;
	};
	return NULL;
}
static struct ZFuncType90 * GetFuncType__1q44(struct ZFuncCallNode407 * this) {
	struct ZType60 * FType = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79)->Type;
	if (LibZen_Is(FType, 90)) {
		return (struct ZFuncType90 *)FType;
	};
	return NULL;
}
static struct ZMacroNode392 * ToMacroNode__2q44(struct ZFuncCallNode407 * this, struct ZMacroFunc210 * MacroFunc__1) {
	struct ZMacroNode392 * MacroNode = ZMacroNode__4q05(_NewZMacroNode392(), this->ParentNode, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z79)->SourceToken, MacroFunc);
	long i = 0;
	while (i < GetListSize__1qu8(this)) {
		Append__2qu8(MacroNode, GetListAt__2qu8(this, i));
		i = i + 1;
	};
	return MacroNode;
}
static struct ZFunctionNode144 * ZFunctionNode__2qtq(struct ZFunctionNode144 * this, struct ZNode52 * ParentNode__1) {
	(void)ZListNode__4qu8(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qtq(struct ZFunctionNode144 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->ReturnType = Type;
	return;
}
static void SetNameInfo__3qtq(struct ZFunctionNode144 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->FuncName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qtq(struct ZFunctionNode144 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZParamNode172 * GetParamNode__2qtq(struct ZFunctionNode144 * this, long Index__1) {
	struct ZNode52 * Node = GetListAt__2qu8(this, Index);
	if (LibZen_Is(Node, 172)) {
		return (struct ZParamNode172 *)Node;
	};
	return NULL;
}
static struct ZFuncType90 * GetFuncType__2qtq(struct ZFunctionNode144 * this, struct ZType60 * ContextType__1) {
	if (this->ResolvedFuncType == NULL) {
		struct ZFuncType90 * FuncType = NULL;
		if (LibZen_Is(ContextType, 90)) {
			FuncType = (struct ZFuncType90 *)ContextType;
		};
		ArrayOfZType * TypeList = LibZen_NewArray(0);
		if (this->ReturnType->IsVarType(this->ReturnType) && FuncType != NULL) {
			this->ReturnType = FuncType->GetParamType(FuncType, 0);
		};
		LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)this->ReturnType->GetRealType(this->ReturnType));
		long i = 0;
		while (i < GetListSize__1qu8(this)) {
			struct ZParamNode172 * Node = GetParamNode__2qtq(this, i);
			struct ZType60 * ParamType = Node->Type->GetRealType(Node->Type);
			if (ParamType->IsVarType(ParamType) && FuncType != NULL) {
				ParamType = FuncType->GetParamType(FuncType, i + 1);
			};
			LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)ParamType);
			i = i + 1;
		};
		FuncType = ZTypePool_LookupFuncType__1qwx(TypeList);
		if (!FuncType->IsVarType(FuncType)) {
			this->ResolvedFuncType = FuncType;
		};
		return FuncType;
	};
	return this->ResolvedFuncType;
}
static const char * GetSignature__2qtq(struct ZFunctionNode144 * this, struct ZGenerator55 * Generator__1) {
	struct ZFuncType90 * FuncType = GetFuncType__2qtq(this, NULL);
	if (this->FuncName == NULL) {
		this->FuncName = LibZen_StrCat("f_Z", LibZen_IntToString(GetUniqueNumber__1qwk(Generator)));
	};
	return StringfySignature__2qej(FuncType, this->FuncName);
}
static struct ZFunctionNode144 * Push__2qtq(struct ZFunctionNode144 * this, struct ZFunctionNode144 * Parent__1) {
	this->ParentFunctionNode = Parent;
	return this;
}
static struct ZFunctionNode144 * Pop__1qtq(struct ZFunctionNode144 * this) {
	return this->ParentFunctionNode;
}
static int IsTopLevel__1qtq(struct ZFunctionNode144 * this) {
	return this->ParentFunctionNode == NULL;
}
static long GetVarIndex__1qtq(struct ZFunctionNode144 * this) {
	long Index = this->VarIndex;
	this->VarIndex = this->VarIndex + 1;
	return Index;
}
static struct ZVarNode506 * ZVarNode__2qde(struct ZVarNode506 * this, struct ZNode52 * ParentNode__1) {
	(void)ZBlockNode__3qth(this, ParentNode, 1);
	return NULL;
}
static void SetNameInfo__3qde(struct ZVarNode506 * this, struct ZToken77 * NameToken__1, const char * Name__2) {
	this->NativeName = Name;
	this->NameToken = NameToken;
	return;
}
static void SetTypeInfo__3qde(struct ZVarNode506 * this, struct ZToken77 * TypeToken__1, struct ZType60 * Type__2) {
	this->DeclType = Type;
	this->TypeToken = TypeToken;
	return;
}
static void Accept__2qde(struct ZVarNode506 * this, struct ZVisitor167 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNode52 * AndPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZBinaryNode311 * BinaryNode = ZAndNode__5qs2(_NewZAndNode502(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58), LeftNode, GetApplyingSyntax__1qwh(TokenContext));
	return AppendParsedRightNode__3qo6(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode52 * AnnotationPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return NULL;
}
static struct ZNode52 * ApplyPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ApplyNode = ZFuncCallNode__3q44(_NewZFuncCallNode407(), ParentNode, LeftNode);
	ApplyNode = MatchNtimes__6qwh(TokenContext, ApplyNode, "(", "$Expression$", ",", ")");
	return ApplyNode;
}
static struct ZNode52 * ArrayLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode = ZArrayLiteralNode__2qss(_NewZArrayLiteralNode481(), ParentNode);
	LiteralNode = MatchNtimes__6qwh(TokenContext, LiteralNode, "[", "$Expression$", ",", "]");
	return LiteralNode;
}
static struct ZNode52 * AssertPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * AssertNode = ZAssertNode__2qol(_NewZAssertNode308(), ParentNode);
	AssertNode = MatchToken__4qwh(TokenContext, AssertNode, "assert", ZTokenContext_Required_Z53);
	AssertNode = MatchToken__4qwh(TokenContext, AssertNode, "(", ZTokenContext_Required_Z53);
	AssertNode = MatchPattern__6qwh(TokenContext, AssertNode, ZThrowNode_Expr_Z33, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	AssertNode = MatchToken__4qwh(TokenContext, AssertNode, ")", ZTokenContext_Required_Z53);
	return AssertNode;
}
static struct ZNode52 * AssignPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return NULL;
}
static struct ZNode52 * BinaryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	struct ZBinaryNode311 * BinaryNode = ZBinaryNode__5qo6(_NewZBinaryNode311(), ParentNode, Token, LeftNode, GetApplyingSyntax__1qwh(TokenContext));
	return AppendParsedRightNode__3qo6(BinaryNode, ParentNode, TokenContext);
}
static int BlockComment__1qwd(struct ZSourceContext50 * SourceContext) {
	long StartIndex = GetPosition__1qwd(SourceContext);
	const char * NextChar = GetCharAtFromCurrentPosition__2qwd(SourceContext, +1);
	if (NextChar != "/" && NextChar != "*") {
		return 0/*false*/;
	};
	if (NextChar == "/") {
		while (HasChar__1qwd(SourceContext)) {
			const char * ch = GetCurrentChar__1qwd(SourceContext);
			if (ch == "\n") {
				break;
			};
			MoveNext__1qwd(SourceContext);
		};
		return 1/*true*/;
	};
	long NestedLevel = 0;
	const char * PrevChar = "0";
	while (HasChar__1qwd(SourceContext)) {
		NextChar = GetCurrentChar__1qwd(SourceContext);
		if (PrevChar == "*" && NextChar == "/") {
			NestedLevel = NestedLevel - 1;
			if (NestedLevel == 0) {
				MoveNext__1qwd(SourceContext);
				return 1/*true*/;
			};
		};
		if (PrevChar == "/" && NextChar == "*") {
			NestedLevel = NestedLevel + 1;
		};
		MoveNext__1qwd(SourceContext);
		PrevChar = NextChar;
	};
	LogWarning__3qwd(SourceContext, StartIndex, "unfound */");
	return 1/*true*/;
}
static struct ZNode52 * BlockPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * BlockNode = ZBlockNode__3qth(_NewZBlockNode161(), ParentNode, 0);
	struct ZToken77 * SkipToken = GetToken__1qwh(TokenContext);
	BlockNode = MatchToken__4qwh(TokenContext, BlockNode, "{", ZTokenContext_Required_Z53);
	if (!IsErrorNode__1qwg(BlockNode)) {
		int Remembered = SetParseFlag__2qwh(TokenContext, ZTokenContext_AllowSkipIndent_Z55);
		struct ZNode52 * NestedBlockNode = BlockNode;
		while (HasNext__1qwh(TokenContext)) {
			if (MatchToken__2qwh(TokenContext, "}")) {
				break;
			};
			NestedBlockNode = MatchPattern__5qwh(TokenContext, NestedBlockNode, ZNode_NestedAppendIndex_Z24, "$Statement$", ZTokenContext_Required_Z53);
			if (IsErrorNode__1qwg(NestedBlockNode)) {
				SkipError__2qwh(TokenContext, SkipToken);
				(void)MatchToken__2qwh(TokenContext, "}");
				break;
			};
		};
		(void)SetParseFlag__2qwh(TokenContext, Remembered);
	};
	return BlockNode;
}
static struct ZNode52 * BreakPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * BreakNode = ZBreakNode__2qom(_NewZBreakNode318(), ParentNode);
	BreakNode = MatchToken__4qwh(TokenContext, BreakNode, "break", ZTokenContext_Required_Z53);
	return BreakNode;
}
static int CLineComment__1qwd(struct ZSourceContext50 * SourceContext) {
	return 0/*false*/;
}
static struct ZNode52 * CastPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * CastNode = ZCastNode__4qo3(_NewZCastNode321(), ParentNode, ZTypeVarType_Z4, NULL);
	CastNode = MatchToken__4qwh(TokenContext, CastNode, "(", ZTokenContext_Required_Z53);
	CastNode = MatchPattern__5qwh(TokenContext, CastNode, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Required_Z53);
	CastNode = MatchToken__4qwh(TokenContext, CastNode, ")", ZTokenContext_Required_Z53);
	CastNode = MatchPattern__5qwh(TokenContext, CastNode, ZCastNode_Expr_Z62, "$RightExpression$", ZTokenContext_Required_Z53);
	return CastNode;
}
static struct ZNode52 * CatchPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * CatchNode = ZCatchNode__2qpw(_NewZCatchNode325(), ParentNode);
	CatchNode = MatchToken__4qwh(TokenContext, CatchNode, "catch", ZTokenContext_Required_Z53);
	CatchNode = MatchToken__4qwh(TokenContext, CatchNode, "(", ZTokenContext_Required_Z53);
	CatchNode = MatchPattern__5qwh(TokenContext, CatchNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	CatchNode = MatchToken__4qwh(TokenContext, CatchNode, ")", ZTokenContext_Required_Z53);
	CatchNode = MatchPattern__5qwh(TokenContext, CatchNode, ZCatchNode_Block_Z63, "$Block$", ZTokenContext_Required_Z53);
	return CatchNode;
}
static struct ZNode52 * ClassPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ClassNode = ZClassNode__2qda(_NewZClassNode516(), ParentNode);
	ClassNode = MatchToken__4qwh(TokenContext, ClassNode, "class", ZTokenContext_Required_Z53);
	ClassNode = MatchPattern__5qwh(TokenContext, ClassNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	if (MatchNewLineToken__2qwh(TokenContext, "extends")) {
		ClassNode = MatchPattern__5qwh(TokenContext, ClassNode, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Required_Z53);
	};
	ClassNode = MatchNtimes__6qwh(TokenContext, ClassNode, "{", "$FieldDecl$", NULL, "}");
	return ClassNode;
}
static struct ZNode52 * ComparatorPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	struct ZBinaryNode311 * BinaryNode = ZComparatorNode__5qpy(_NewZComparatorNode329(), ParentNode, Token, LeftNode, GetApplyingSyntax__1qwh(TokenContext));
	return AppendParsedRightNode__3qo6(BinaryNode, ParentNode, TokenContext);
}
static struct ZSyntax219 * ExpressionPattern_GetRightPattern__2qwa(struct ZNameSpace48 * NameSpace, struct ZTokenContext53 * TokenContext__1) {
	struct ZToken77 * Token = GetToken__1qwh(TokenContext);
	if (Token != ZToken_NullToken_Z52) {
		struct ZSyntax219 * Pattern = GetRightSyntaxPattern__2qwa(NameSpace, GetText__1qey(Token));
		return Pattern;
	};
	return NULL;
}
static struct ZNode52 * ExpressionPattern_DispatchPattern__5qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2, int AllowStatement__3, int AllowBinary__4) {
	struct ZToken77 * Token = GetToken__1qwh(TokenContext);
	struct ZSyntax219 * Pattern = NULL;
	struct ZNameSpace48 * NameSpace = GetNameSpace__1qwg(ParentNode);
	if (LibZen_Is(Token, 462)) {
		Pattern = ((struct ZPatternToken462 *)Token)->PresetPattern;
	} else {
		Pattern = GetSyntaxPattern__2qwa(NameSpace, GetText__1qey(Token));
	};
	if (Pattern != NULL) {
		if (Pattern->IsStatement && !AllowStatement) {
			return ZErrorNode__4qpa(_NewZErrorNode336(), ParentNode, Token, LibZen_StrCat(GetText__1qey(Token), " statement is not here"));
		};
		LeftNode = ApplyMatchPattern__5qwh(TokenContext, ParentNode, LeftNode, Pattern, ZTokenContext_Required_Z53);
	} else {
		if (IsNameSymbol__1qey(Token)) {
			if (AllowStatement) {
				Pattern = GetSyntaxPattern__2qwa(NameSpace, "$SymbolStatement$");
			} else {
				Pattern = GetSyntaxPattern__2qwa(NameSpace, "$SymbolExpression$");
			};
			LeftNode = ApplyMatchPattern__5qwh(TokenContext, ParentNode, LeftNode, Pattern, ZTokenContext_Required_Z53);
		} else {
			if (AllowStatement) {
				return CreateExpectedErrorNode__3qwh(TokenContext, Token, "statement");
			} else {
				return CreateExpectedErrorNode__3qwh(TokenContext, Token, "expression");
			};
		};
	};
	if (!Pattern->IsStatement) {
		while (LeftNode != NULL && !IsErrorNode__1qwg(LeftNode)) {
			struct ZSyntax219 * RightPattern = ExpressionPattern_GetRightPattern__2qwa(NameSpace, TokenContext);
			if (RightPattern == NULL) {
				break;
			};
			if (!AllowBinary && IsBinaryOperator__1qur(RightPattern)) {
				break;
			};
			LeftNode = ApplyMatchPattern__5qwh(TokenContext, ParentNode, LeftNode, RightPattern, ZTokenContext_Required_Z53);
		};
	};
	return LeftNode;
}
static struct ZNode52 * ExpressionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qwg(ParentNode, TokenContext, LeftNode, 0/*false*/, 1/*true*/);
}
static struct ZNode52 * FalsePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ZBooleanNode__4qso(_NewZBooleanNode476(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58), 0/*false*/);
}
static struct ZNode52 * FieldPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	int Rememberd = SetParseFlag__2qwh(TokenContext, 0/*false*/);
	struct ZNode52 * FieldNode = ZFieldNode__2qpg(_NewZFieldNode340(), ParentNode);
	FieldNode = MatchToken__4qwh(TokenContext, FieldNode, "var", ZTokenContext_Required_Z53);
	FieldNode = MatchPattern__5qwh(TokenContext, FieldNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	FieldNode = MatchPattern__5qwh(TokenContext, FieldNode, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	if (MatchToken__2qwh(TokenContext, "=")) {
		FieldNode = MatchPattern__5qwh(TokenContext, FieldNode, ZFieldNode_InitValue_Z64, "$Expression$", ZTokenContext_Required_Z53);
	};
	FieldNode = MatchPattern__5qwh(TokenContext, FieldNode, ZNode_Nop_Z20, ";", ZTokenContext_Required_Z53);
	(void)SetParseFlag__2qwh(TokenContext, Rememberd);
	return FieldNode;
}
static struct ZNode52 * FloatLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	return ZFloatNode__4qpl(_NewZFloatNode344(), ParentNode, Token, LibZen_ParseFloat__1qqy(GetText__1qey(Token)));
}
static struct ZNode52 * FunctionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * FuncNode = ZFunctionNode__2qtq(_NewZFunctionNode144(), ParentNode);
	FuncNode = MatchToken__4qwh(TokenContext, FuncNode, "function", ZTokenContext_Required_Z53);
	FuncNode = MatchPattern__5qwh(TokenContext, FuncNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Optional_Z54);
	FuncNode = MatchNtimes__6qwh(TokenContext, FuncNode, "(", "$Param$", ",", ")");
	FuncNode = MatchPattern__5qwh(TokenContext, FuncNode, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	FuncNode = MatchPattern__5qwh(TokenContext, FuncNode, ZFunctionNode_Block_Z80, "$Block$", ZTokenContext_Required_Z53);
	return FuncNode;
}
static struct ZNode52 * GetIndexPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * IndexerNode = ZGetIndexNode__3qp6(_NewZGetIndexNode347(), ParentNode, LeftNode);
	IndexerNode = MatchToken__4qwh(TokenContext, IndexerNode, "[", ZTokenContext_Required_Z53);
	IndexerNode = MatchPattern__6qwh(TokenContext, IndexerNode, ZGetIndexNode_Index_Z66, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	IndexerNode = MatchToken__4qwh(TokenContext, IndexerNode, "]", ZTokenContext_Required_Z53);
	return IndexerNode;
}
static struct ZNode52 * GetterPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * GetterNode = ZGetterNode__3qp7(_NewZGetterNode355(), ParentNode, LeftNode);
	GetterNode = MatchToken__4qwh(TokenContext, GetterNode, ".", ZTokenContext_Required_Z53);
	GetterNode = MatchPattern__5qwh(TokenContext, GetterNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	return GetterNode;
}
static struct ZNode52 * GroupPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * GroupNode = ZGroupNode__2q0t(_NewZGroupNode364(), ParentNode);
	GroupNode = MatchToken__4qwh(TokenContext, GroupNode, "(", ZTokenContext_Required_Z53);
	GroupNode = MatchPattern__6qwh(TokenContext, GroupNode, ZGroupNode_Expr_Z68, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	GroupNode = MatchToken__4qwh(TokenContext, GroupNode, ")", ZTokenContext_Required_Z53);
	return GroupNode;
}
static struct ZNode52 * IfPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * IfNode = ZIfNode__2q0i(_NewZIfNode367(), ParentNode);
	IfNode = MatchToken__4qwh(TokenContext, IfNode, "if", ZTokenContext_Required_Z53);
	IfNode = MatchToken__4qwh(TokenContext, IfNode, "(", ZTokenContext_Required_Z53);
	IfNode = MatchPattern__6qwh(TokenContext, IfNode, ZIfNode_Cond_Z69, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowNewLine_Z57);
	IfNode = MatchToken__4qwh(TokenContext, IfNode, ")", ZTokenContext_Required_Z53);
	IfNode = MatchPattern__5qwh(TokenContext, IfNode, ZIfNode_Then_Z70, "$Block$", ZTokenContext_Required_Z53);
	if (MatchNewLineToken__2qwh(TokenContext, "else")) {
		const char * PatternName = "$Block$";
		if (IsNewLineToken__2qwh(TokenContext, "if")) {
			PatternName = "if";
		};
		IfNode = MatchPattern__5qwh(TokenContext, IfNode, ZIfNode_Else_Z71, PatternName, ZTokenContext_Required_Z53);
	};
	return IfNode;
}
static struct ZNode52 * InstanceOfPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * BinaryNode = ZInstanceOfNode__4q0s(_NewZInstanceOfNode373(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58), LeftNode);
	BinaryNode = MatchPattern__5qwh(TokenContext, BinaryNode, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Required_Z53);
	return BinaryNode;
}
static struct ZNode52 * IntLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	return ZIntNode__4q0h(_NewZIntNode377(), ParentNode, Token, LibZen_ParseInt__1qqy(GetText__1qey(Token)));
}
static struct ZNode52 * LetPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LetNode = ZLetNode__2q0l(_NewZLetNode380(), ParentNode);
	LetNode = MatchToken__4qwh(TokenContext, LetNode, "let", ZTokenContext_Required_Z53);
	LetNode = MatchPattern__5qwh(TokenContext, LetNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	LetNode = MatchPattern__5qwh(TokenContext, LetNode, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	LetNode = MatchToken__4qwh(TokenContext, LetNode, "=", ZTokenContext_Required_Z53);
	LetNode = MatchPattern__5qwh(TokenContext, LetNode, ZLetNode_InitValue_Z73, "$Expression$", ZTokenContext_Required_Z53);
	return LetNode;
}
static struct ZNode52 * MapEntryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode = ZMapEntryNode__2q4w(_NewZMapEntryNode397(), ParentNode);
	LiteralNode = MatchPattern__5qwh(TokenContext, LiteralNode, ZMapEntryNode_Key_Z74, "$Expression$", ZTokenContext_Required_Z53);
	LiteralNode = MatchToken__4qwh(TokenContext, LiteralNode, ":", ZTokenContext_Required_Z53);
	LiteralNode = MatchPattern__5qwh(TokenContext, LiteralNode, ZMapEntryNode_Value_Z75, "$Expression$", ZTokenContext_Required_Z53);
	return LiteralNode;
}
static struct ZNode52 * MapLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode = ZMapLiteralNode__2q4r(_NewZMapLiteralNode399(), ParentNode);
	LiteralNode = MatchNtimes__6qwh(TokenContext, LiteralNode, "{", "$MapEntry$", ",", "}");
	return LiteralNode;
}
static struct ZNode52 * MethodCallPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * MethodCallNode = ZMethodCallNode__3q4i(_NewZMethodCallNode403(), ParentNode, LeftNode);
	MethodCallNode = MatchToken__4qwh(TokenContext, MethodCallNode, ".", ZTokenContext_Required_Z53);
	MethodCallNode = MatchPattern__5qwh(TokenContext, MethodCallNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	MethodCallNode = MatchNtimes__6qwh(TokenContext, MethodCallNode, "(", "$Expression$", ",", ")");
	return MethodCallNode;
}
static struct ZNode52 * NamePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	if (LibZen_IsSymbol__1qqy(GetChar__1qey(Token))) {
		return ZGetNameNode__4qpc(_NewZGetNameNode350(), ParentNode, Token, GetText__1qey(Token));
	};
	return ZErrorNode__4qpa(_NewZErrorNode336(), ParentNode, Token, LibZen_StrCat(LibZen_StrCat("illegal name: \"", GetText__1qey(Token)), "\""));
}
static int NameToken__1qwd(struct ZSourceContext50 * SourceContext) {
	long StartIndex = GetPosition__1qwd(SourceContext);
	while (HasChar__1qwd(SourceContext)) {
		const char * ch = GetCurrentChar__1qwd(SourceContext);
		if (!LibZen_IsSymbol__1qqy(ch) && !LibZen_IsDigit__1qqy(ch)) {
			break;
		};
		MoveNext__1qwd(SourceContext);
	};
	Tokenize__3qwd(SourceContext, StartIndex, GetPosition__1qwd(SourceContext));
	return 1/*true*/;
}
static int NewLineToken__1qwd(struct ZSourceContext50 * SourceContext) {
	long StartIndex = GetPosition__1qwd(SourceContext) + 1;
	MoveNext__1qwd(SourceContext);
	SkipWhiteSpace__1qwd(SourceContext);
	FoundIndent__3qwd(SourceContext, StartIndex, GetPosition__1qwd(SourceContext));
	return 1/*true*/;
}
static struct ZNode52 * NewObjectPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * LiteralNode = ZNewObjectNode__2q4g(_NewZNewObjectNode412(), ParentNode);
	LiteralNode = MatchToken__4qwh(TokenContext, LiteralNode, "new", ZTokenContext_Required_Z53);
	LiteralNode = MatchPattern__5qwh(TokenContext, LiteralNode, ZNode_TypeInfo_Z22, "$Type$", ZTokenContext_Optional_Z54);
	LiteralNode = MatchNtimes__6qwh(TokenContext, LiteralNode, "(", "$Expression$", ",", ")");
	return LiteralNode;
}
static struct ZNode52 * NotPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * UnaryNode = ZNotNode__3q4l(_NewZNotNode416(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58));
	UnaryNode = MatchPattern__5qwh(TokenContext, UnaryNode, ZUnaryNode_Recv_Z37, "$RightExpression$", ZTokenContext_Required_Z53);
	return UnaryNode;
}
static struct ZNode52 * NullPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ZNullNode__3q46(_NewZNullNode419(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58));
}
static const char * NumberLiteralToken_ParseDigit__1qwd(struct ZSourceContext50 * SourceContext) {
	const char * ch = "0";
	while (HasChar__1qwd(SourceContext)) {
		ch = GetCurrentChar__1qwd(SourceContext);
		if (!LibZen_IsDigit__1qqy(ch)) {
			break;
		};
		MoveNext__1qwd(SourceContext);
	};
	return ch;
}
static int NumberLiteralToken__1qwd(struct ZSourceContext50 * SourceContext) {
	long StartIndex = GetPosition__1qwd(SourceContext);
	const char * ch = NumberLiteralToken_ParseDigit__1qwd(SourceContext);
	if (ch == ".") {
		MoveNext__1qwd(SourceContext);
		ch = NumberLiteralToken_ParseDigit__1qwd(SourceContext);
		if (ch == "e" || ch == "E") {
			MoveNext__1qwd(SourceContext);
			if (HasChar__1qwd(SourceContext)) {
				ch = GetCurrentChar__1qwd(SourceContext);
				if (ch == "+" || ch == "-") {
					MoveNext__1qwd(SourceContext);
				};
			};
			(void)NumberLiteralToken_ParseDigit__1qwd(SourceContext);
		};
		Tokenize__4qwd(SourceContext, "$FloatLiteral$", StartIndex, GetPosition__1qwd(SourceContext));
	} else {
		Tokenize__4qwd(SourceContext, "$IntegerLiteral$", StartIndex, GetPosition__1qwd(SourceContext));
	};
	return 1/*true*/;
}
static int OperatorToken__1qwd(struct ZSourceContext50 * SourceContext) {
	TokenizeDefinedSymbol__2qwd(SourceContext, GetPosition__1qwd(SourceContext));
	return 1/*true*/;
}
static struct ZNode52 * OrPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZBinaryNode311 * BinaryNode = ZOrNode__5q4c(_NewZOrNode422(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58), LeftNode, GetApplyingSyntax__1qwh(TokenContext));
	return AppendParsedRightNode__3qo6(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode52 * ParamPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ParamNode = ZParamNode__2qtb(_NewZParamNode172(), ParentNode);
	ParamNode = MatchPattern__5qwh(TokenContext, ParamNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	ParamNode = MatchPattern__5qwh(TokenContext, ParamNode, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	return ParamNode;
}
static struct ZNode52 * PrototypePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * FuncNode = ZPrototypeNode__2q4n(_NewZPrototypeNode425(), ParentNode);
	FuncNode = MatchToken__4qwh(TokenContext, FuncNode, "function", ZTokenContext_Required_Z53);
	FuncNode = MatchPattern__5qwh(TokenContext, FuncNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	FuncNode = MatchNtimes__6qwh(TokenContext, FuncNode, "(", "$Param$", ",", ")");
	FuncNode = MatchPattern__5qwh(TokenContext, FuncNode, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Required_Z53);
	return FuncNode;
}
static struct ZNode52 * ReturnPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ReturnNode = ZReturnNode__2qtc(_NewZReturnNode170(), ParentNode);
	ReturnNode = MatchToken__4qwh(TokenContext, ReturnNode, "return", ZTokenContext_Required_Z53);
	ReturnNode = MatchPattern__5qwh(TokenContext, ReturnNode, ZReturnNode_Expr_Z25, "$Expression$", ZTokenContext_Optional_Z54);
	return ReturnNode;
}
static struct ZNode52 * RightExpressionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qwg(ParentNode, TokenContext, LeftNode, 0/*false*/, 0/*false*/);
}
static struct ZNode52 * RightTypePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftTypeNode__2) {
	struct ZToken77 * SourceToken = GetToken__1qwh(TokenContext);
	if (LeftTypeNode->Type->GetParamSize(LeftTypeNode->Type) > 0) {
		if (MatchToken__2qwh(TokenContext, "<")) {
			ArrayOfZType * TypeList = LibZen_NewArray(0);
			while (!StartsWithToken__2qwh(TokenContext, ">")) {
				if (LibZen_ArraySize((ArrayOfVar *)TypeList) > 0 && !MatchToken__2qwh(TokenContext, ",")) {
					return NULL;
				};
				struct ZTypeNode235 * ParamTypeNode = (struct ZTypeNode235 *)ParsePattern__4qwh(TokenContext, ParentNode, "$Type$", ZTokenContext_Optional_Z54);
				if (ParamTypeNode == NULL) {
					return LeftTypeNode;
				};
				LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)ParamTypeNode->Type);
			};
			LeftTypeNode = ZTypeNode__4quk(_NewZTypeNode235(), ParentNode, SourceToken, ZTypePool_GetGenericType__3qwz(LeftTypeNode->Type, TypeList, 1/*true*/));
		};
	};
	while (MatchToken__2qwh(TokenContext, "[")) {
		if (!MatchToken__2qwh(TokenContext, "]")) {
			return NULL;
		};
		LeftTypeNode = ZTypeNode__4quk(_NewZTypeNode235(), ParentNode, SourceToken, ZTypePool_GetGenericType1__2qwz(ThrowError("type error: requested = ZType, given = ZGeneric1Type"), LeftTypeNode->Type));
	};
	return LeftTypeNode;
}
static struct ZNode52 * SetIndexPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * IndexerNode = ZSetIndexNode__3qt2(_NewZSetIndexNode178(), ParentNode, LeftNode);
	IndexerNode = MatchToken__4qwh(TokenContext, IndexerNode, "[", ZTokenContext_Required_Z53);
	IndexerNode = MatchPattern__6qwh(TokenContext, IndexerNode, ZSetIndexNode_Index_Z27, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	IndexerNode = MatchToken__4qwh(TokenContext, IndexerNode, "]", ZTokenContext_Required_Z53);
	IndexerNode = MatchToken__4qwh(TokenContext, IndexerNode, "=", ZTokenContext_Required_Z53);
	IndexerNode = MatchPattern__5qwh(TokenContext, IndexerNode, ZSetIndexNode_Expr_Z28, "$Expression$", ZTokenContext_Required_Z53);
	return IndexerNode;
}
static struct ZNode52 * SetterPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * SetterNode = ZSetterNode__3qyt(_NewZSetterNode184(), ParentNode, LeftNode);
	SetterNode = MatchToken__4qwh(TokenContext, SetterNode, ".", ZTokenContext_Required_Z53);
	SetterNode = MatchPattern__5qwh(TokenContext, SetterNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	SetterNode = MatchToken__4qwh(TokenContext, SetterNode, "=", ZTokenContext_Required_Z53);
	SetterNode = MatchPattern__5qwh(TokenContext, SetterNode, ZSetterNode_Expr_Z31, "$Expression$", ZTokenContext_Required_Z53);
	return SetterNode;
}
static struct ZNode52 * StatementEndPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	int ContextAllowance = SetParseFlag__2qwh(TokenContext, 0/*false*/);
	struct ZToken77 * Token = NULL;
	if (HasNext__1qwh(TokenContext)) {
		Token = GetToken__1qwh(TokenContext);
		if (!EqualsText__2qey(Token, ";") && !IsIndent__1qey(Token)) {
			(void)SetParseFlag__2qwh(TokenContext, ContextAllowance);
			return CreateExpectedErrorNode__3qwh(TokenContext, Token, ";");
		};
		MoveNext__1qwh(TokenContext);
		while (HasNext__1qwh(TokenContext)) {
			Token = GetToken__1qwh(TokenContext);
			if (!EqualsText__2qey(Token, ";") && !IsIndent__1qey(Token)) {
				break;
			};
			MoveNext__1qwh(TokenContext);
		};
	};
	(void)SetParseFlag__2qwh(TokenContext, ContextAllowance);
	return ZEmptyNode__3qp0(_NewZEmptyNode334(), ParentNode, Token);
}
static struct ZNode52 * StatementPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	int Rememberd = SetParseFlag__2qwh(TokenContext, ZTokenContext_AllowSkipIndent_Z55);
	(void)SetParseFlag__2qwh(TokenContext, ZTokenContext_NotAllowSkipIndent_Z56);
	struct ZNode52 * StmtNode = ExpressionPattern_DispatchPattern__5qwg(ParentNode, TokenContext, NULL, 1/*true*/, 1/*true*/);
	StmtNode = MatchPattern__5qwh(TokenContext, StmtNode, ZNode_Nop_Z20, ";", ZTokenContext_Required_Z53);
	(void)SetParseFlag__2qwh(TokenContext, Rememberd);
	return StmtNode;
}
static struct ZNode52 * StringLiteralPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	return ZStringNode__4q48(_NewZStringNode431(), ParentNode, Token, LibZen_UnquoteString__1qqy(GetText__1qey(Token)));
}
static int StringLiteralToken__1qwd(struct ZSourceContext50 * SourceContext) {
	long StartIndex = GetPosition__1qwd(SourceContext);
	MoveNext__1qwd(SourceContext);
	while (HasChar__1qwd(SourceContext)) {
		const char * ch = GetCurrentChar__1qwd(SourceContext);
		if (ch == "\"") {
			MoveNext__1qwd(SourceContext);
			Tokenize__4qwd(SourceContext, "$StringLiteral$", StartIndex, GetPosition__1qwd(SourceContext));
			return 1/*true*/;
		};
		if (ch == "\n") {
			break;
		};
		if (ch == "\\") {
			MoveNext__1qwd(SourceContext);
		};
		MoveNext__1qwd(SourceContext);
	};
	LogWarning__3qwd(SourceContext, StartIndex, "unclosed \"");
	Tokenize__4qwd(SourceContext, "$StringLiteral$", StartIndex, GetPosition__1qwd(SourceContext));
	return 0/*false*/;
}
static struct ZNode52 * SymbolExpressionPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * NameToken = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	if (IsToken__2qwh(TokenContext, "=")) {
		return ZErrorNode__4qpa(_NewZErrorNode336(), ParentNode, GetToken__1qwh(TokenContext), "assignment is not en expression");
	} else {
		return ZGetNameNode__4qpc(_NewZGetNameNode350(), ParentNode, NameToken, GetText__1qey(NameToken));
	};
}
static struct ZNode52 * SymbolStatementPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * NameToken = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	if (MatchToken__2qwh(TokenContext, "=")) {
		struct ZNode52 * AssignedNode = ZSetNameNode__4qyw(_NewZSetNameNode181(), ParentNode, NameToken, GetText__1qey(NameToken));
		AssignedNode = MatchPattern__5qwh(TokenContext, AssignedNode, ZSetNameNode_Expr_Z29, "$Expression$", ZTokenContext_Required_Z53);
		return AssignedNode;
	} else {
		return ZGetNameNode__4qpc(_NewZGetNameNode350(), ParentNode, NameToken, GetText__1qey(NameToken));
	};
}
static struct ZNode52 * ThrowPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * ThrowNode = ZThrowNode__2qy4(_NewZThrowNode191(), ParentNode);
	ThrowNode = MatchToken__4qwh(TokenContext, ThrowNode, "throw", ZTokenContext_Required_Z53);
	ThrowNode = MatchPattern__5qwh(TokenContext, ThrowNode, ZThrowNode_Expr_Z33, "$Expression$", ZTokenContext_Required_Z53);
	return ThrowNode;
}
static struct ZNode52 * TruePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	return ZBooleanNode__4qso(_NewZBooleanNode476(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58), 1/*true*/);
}
static struct ZNode52 * TryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * TryNode = ZTryNode__2qyd(_NewZTryNode194(), ParentNode);
	TryNode = MatchToken__4qwh(TokenContext, TryNode, "try", ZTokenContext_Required_Z53);
	TryNode = MatchPattern__5qwh(TokenContext, TryNode, ZTryNode_Try_Z34, "$Block$", ZTokenContext_Required_Z53);
	long count = 0;
	if (IsNewLineToken__2qwh(TokenContext, "catch")) {
		TryNode = MatchPattern__5qwh(TokenContext, TryNode, ZTryNode_Catch_Z35, "$Catch$", ZTokenContext_Required_Z53);
		count = count + 1;
	};
	if (MatchNewLineToken__2qwh(TokenContext, "finally")) {
		TryNode = MatchPattern__5qwh(TokenContext, TryNode, ZTryNode_Finally_Z36, "$Block$", ZTokenContext_Required_Z53);
		count = count + 1;
	};
	if (count == 0 && !IsErrorNode__1qwg(TryNode)) {
		return Array<ZNode>GetIndex(ZTryNode_Try_Z34);
	};
	return TryNode;
}
static struct ZNode52 * TypeAnnotationPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	if (MatchToken__2qwh(TokenContext, ":")) {
		return ParsePattern__4qwh(TokenContext, ParentNode, "$Type$", ZTokenContext_Required_Z53);
	};
	return NULL;
}
static struct ZNode52 * TypePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZToken77 * Token = GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58);
	struct ZTypeNode235 * TypeNode = GetTypeNode__3qwa(GetNameSpace__1qwg(ParentNode), GetText__1qey(Token), Token);
	if (TypeNode != NULL) {
		return ParsePatternAfter__5qwh(TokenContext, ParentNode, TypeNode, "$TypeRight$", ZTokenContext_Optional_Z54);
	};
	return NULL;
}
static struct ZNode52 * UnaryPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * UnaryNode = ZUnaryNode__3qyh(_NewZUnaryNode197(), ParentNode, GetToken__2qwh(TokenContext, ZTokenContext_MoveNext_Z58));
	return MatchPattern__5qwh(TokenContext, UnaryNode, ZUnaryNode_Recv_Z37, "$RightExpression$", ZTokenContext_Required_Z53);
}
static struct ZNode52 * VarPattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * VarNode = ZVarNode__2qde(_NewZVarNode506(), ParentNode);
	VarNode = MatchToken__4qwh(TokenContext, VarNode, "var", ZTokenContext_Required_Z53);
	VarNode = MatchPattern__5qwh(TokenContext, VarNode, ZNode_NameInfo_Z21, "$Name$", ZTokenContext_Required_Z53);
	VarNode = MatchPattern__5qwh(TokenContext, VarNode, ZNode_TypeInfo_Z22, "$TypeAnnotation$", ZTokenContext_Optional_Z54);
	VarNode = MatchToken__4qwh(TokenContext, VarNode, "=", ZTokenContext_Required_Z53);
	VarNode = MatchPattern__5qwh(TokenContext, VarNode, ZVarNode_InitValue_Z81, "$Expression$", ZTokenContext_Required_Z53);
	return VarNode;
}
static struct ZNode52 * WhilePattern__3qwg(struct ZNode52 * ParentNode, struct ZTokenContext53 * TokenContext__1, struct ZNode52 * LeftNode__2) {
	struct ZNode52 * WhileNode = ZWhileNode__2qyl(_NewZWhileNode200(), ParentNode);
	WhileNode = MatchToken__4qwh(TokenContext, WhileNode, "while", ZTokenContext_Required_Z53);
	WhileNode = MatchToken__4qwh(TokenContext, WhileNode, "(", ZTokenContext_Required_Z53);
	WhileNode = MatchPattern__6qwh(TokenContext, WhileNode, ZWhileNode_Cond_Z38, "$Expression$", ZTokenContext_Required_Z53, ZTokenContext_AllowSkipIndent_Z55);
	WhileNode = MatchToken__4qwh(TokenContext, WhileNode, ")", ZTokenContext_Required_Z53);
	WhileNode = MatchPattern__5qwh(TokenContext, WhileNode, ZWhileNode_Block_Z39, "$Block$", ZTokenContext_Required_Z53);
	return WhileNode;
}
static int WhiteSpaceToken__1qwd(struct ZSourceContext50 * SourceContext) {
	SkipWhiteSpace__1qwd(SourceContext);
	return 1/*true*/;
}

