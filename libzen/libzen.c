static const char * ZFunc_StringfySignature__3qqy(const char * FuncName, long FuncParamSize__1, struct ZType65 * RecvType__2);
static ArrayOfZType * ZGreekType_NewGreekTypes__1qwm(ArrayOfZType * GreekTypes);
static long ZTypePool_NewTypeId__1qwn(struct ZType65 * T);
static struct ZType65 * TypeOf__1qqr(long TypeId);
static struct ZType65 * GetGreekType__1qqr(long GreekId);
static const char * ZTypePool_MangleType2__2qwn(struct ZType65 * Type1, struct ZType65 * Type2__1);
static const char * ZTypePool_MangleTypes__1qwm(ArrayOfZType * TypeList);
static ArrayOfZType * ZTypePool_UniqueTypes__1qwm(ArrayOfZType * TypeList);
static struct ZType65 * ZTypePool_GetGenericType1__2qwn(struct ZType65 * BaseType, struct ZType65 * ParamType__1);
static struct ZType65 * ZTypePool_GetGenericType__3qwn(struct ZType65 * BaseType, ArrayOfZType * TypeList__1, int IsCreation__2);
static struct ZFuncType91 * ZTypePool_LookupFuncType__1qwm(ArrayOfZType * TypeList);
static struct ZFuncType91 * ZTypePool_LookupFuncType__1qwn(struct ZType65 * R);
static struct ZFuncType91 * ZTypePool_LookupFuncType__2qwn(struct ZType65 * R, struct ZType65 * P1__1);
static struct ZFuncType91 * ZTypePool_LookupFuncType__3qwn(struct ZType65 * R, struct ZType65 * P1__1, struct ZType65 * P2__2);
static struct ZFuncType91 * ZTypePool_LookupFuncType__4qwn(struct ZType65 * R, struct ZType65 * P1__1, struct ZType65 * P2__2, struct ZType65 * P3__3);
static const char * ZLogger_LogError__2qeu(struct ZToken78 * Token, const char * Message__1);
static void ZLogger_LogWarning__2qeu(struct ZToken78 * Token, const char * Message__1);
static void ZLogger_LogInfo__2qeu(struct ZToken78 * Token, const char * Message__1);
static void ZLogger_LogDebug__2qeu(struct ZToken78 * Token, const char * Message__1);
static const char * ZNameSpace_RightPatternSymbol__1qqy(const char * PatternName);
static struct ZSyntax221 * MergeSyntaxPattern__2quy(struct ZSyntax221 * Pattern, struct ZSyntax221 * Parent__1);
static struct ZSyntax221 * ExpressionPattern_GetRightPattern__2qws(struct ZNameSpace49 * NameSpace, struct ZTokenContext56 * TokenContext__1);
static struct ZNode55 * ExpressionPattern_DispatchPattern__5qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2, int AllowStatement__3, int AllowBinary__4);
static const char * NumberLiteralToken_ParseDigit__1qwg(struct ZSourceContext52 * SourceContext);
static struct ZType65 * ZType__4qwn(struct ZType65 * this, long TypeFlag__1, const char * ShortName__2, struct ZType65 * RefType__3);
static struct ZType65 * GetRealType__1qwn(struct ZType65 * this);
#define _ZType65_GetRealType
static struct ZType65 * GetSuperType__1qwn(struct ZType65 * this);
#define _ZType65_GetSuperType
static struct ZType65 * GetBaseType__1qwn(struct ZType65 * this);
#define _ZType65_GetBaseType
static long GetParamSize__1qwn(struct ZType65 * this);
#define _ZType65_GetParamSize
static struct ZType65 * GetParamType__2qwn(struct ZType65 * this, long Index__1);
#define _ZType65_GetParamType
static int Equals__2qwn(struct ZType65 * this, struct ZType65 * Type__1);
static int Accept__2qwn(struct ZType65 * this, struct ZType65 * Type__1);
static int IsGreekType__1qwn(struct ZType65 * this);
#define _ZType65_IsGreekType
static struct ZType65 * GetGreekRealType__2qwn(struct ZType65 * this, ArrayOfZType * Greek__1);
#define _ZType65_GetGreekRealType
static int AcceptValueType__4qwn(struct ZType65 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZType65_AcceptValueType
static int IsVoidType__1qwn(struct ZType65 * this);
static int IsVarType__1qwn(struct ZType65 * this);
#define _ZType65_IsVarType
static int IsInferrableType__1qwn(struct ZType65 * this);
static int IsTypeType__1qwn(struct ZType65 * this);
static int IsBooleanType__1qwn(struct ZType65 * this);
static int IsIntType__1qwn(struct ZType65 * this);
static int IsFloatType__1qwn(struct ZType65 * this);
static int IsNumberType__1qwn(struct ZType65 * this);
static int IsStringType__1qwn(struct ZType65 * this);
static int IsArrayType__1qwn(struct ZType65 * this);
static int IsMapType__1qwn(struct ZType65 * this);
static int IsOpenType__1qwn(struct ZType65 * this);
static int IsImmutableType__1qwn(struct ZType65 * this);
static int IsNullableType__1qwn(struct ZType65 * this);
static const char * toString__1qwn(struct ZType65 * this);
static const char * GetAsciiName__1qwn(struct ZType65 * this);
static const char * StringfyClassMember__2qwn(struct ZType65 * this, const char * Name__1);
static const char * GetUniqueName__1qwn(struct ZType65 * this);
static int IsFuncType__1qwn(struct ZType65 * this);
static const char * StringfySignature__2qwn(struct ZType65 * this, const char * FuncName__1);
static void Maybe__3qwn(struct ZType65 * this, struct ZType65 * T__1, struct ZToken78 * SourceToken__2);
static struct ZClassField80 * ZClassField__5qeo(struct ZClassField80 * this, struct ZClassType81 * ClassType__1, const char * FieldName__2, struct ZType65 * FieldType__3, struct ZToken78 * SourceToken__4);
static struct ZClassType81 * ZClassType__3qep(struct ZClassType81 * this, const char * ShortName__1, struct ZType65 * RefType__2);
static void ResetSuperType__2qep(struct ZClassType81 * this, struct ZClassType81 * SuperClass__1);
static long GetFieldSize__1qep(struct ZClassType81 * this);
static struct ZClassField80 * GetFieldAt__2qep(struct ZClassType81 * this, long Index__1);
static int HasField__2qep(struct ZClassType81 * this, const char * FieldName__1);
static struct ZType65 * GetFieldType__3qep(struct ZClassType81 * this, const char * FieldName__1, struct ZType65 * DefaultType__2);
static struct ZClassField80 * AppendField__4qep(struct ZClassType81 * this, struct ZType65 * FieldType__1, const char * FieldName__2, struct ZToken78 * SourceToken__3);
static struct ZFunc90 * ZFunc__4qej(struct ZFunc90 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType91 * FuncType__3);
static struct ZFuncType91 * GetFuncType__1qej(struct ZFunc90 * this);
static const char * toString__1qej(struct ZFunc90 * this);
static int IsConverterFunc__1qej(struct ZFunc90 * this);
static int IsCoercionFunc__1qej(struct ZFunc90 * this);
static int Is__2qej(struct ZFunc90 * this, long Flag__1);
static const char * GetSignature__1qej(struct ZFunc90 * this);
static struct ZFuncType91 * ZFuncType__3qek(struct ZFuncType91 * this, const char * ShortName__1, ArrayOfZType * UniqueTypeParams__2);
static int IsFuncType__1qek(struct ZFuncType91 * this);
static int IsVarType__1qek(struct ZFuncType91 * this);
#define _ZFuncType91_IsVarType
static int IsGreekType__1qek(struct ZFuncType91 * this);
#define _ZFuncType91_IsGreekType
static struct ZType65 * GetGreekRealType__2qek(struct ZFuncType91 * this, ArrayOfZType * Greek__1);
#define _ZFuncType91_GetGreekRealType
static int AcceptValueType__4qek(struct ZFuncType91 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZFuncType91_AcceptValueType
static const char * StringfySignature__2qek(struct ZFuncType91 * this, const char * FuncName__1);
static struct ZType65 * GetBaseType__1qek(struct ZFuncType91 * this);
#define _ZFuncType91_GetBaseType
static long GetParamSize__1qek(struct ZFuncType91 * this);
#define _ZFuncType91_GetParamSize
static struct ZType65 * GetParamType__2qek(struct ZFuncType91 * this, long Index__1);
#define _ZFuncType91_GetParamType
static struct ZType65 * GetReturnType__1qek(struct ZFuncType91 * this);
static long GetFuncParamSize__1qek(struct ZFuncType91 * this);
static struct ZType65 * GetRecvType__1qek(struct ZFuncType91 * this);
static struct ZType65 * GetFuncParamType__2qek(struct ZFuncType91 * this, long Index__1);
static struct ZFuncType91 * NewMethodFuncType__2qek(struct ZFuncType91 * this, struct ZType65 * RecvType__1);
static int AcceptAsFieldFunc__2qek(struct ZFuncType91 * this, struct ZFuncType91 * FuncType__1);
static struct ZGeneric1Type108 * ZGeneric1Type__5qrq(struct ZGeneric1Type108 * this, long TypeFlag__1, const char * ShortName__2, struct ZType65 * BaseType__3, struct ZType65 * ParamType__4);
static struct ZType65 * GetSuperType__1qrq(struct ZGeneric1Type108 * this);
#define _ZGeneric1Type108_GetSuperType
static struct ZType65 * GetBaseType__1qrq(struct ZGeneric1Type108 * this);
#define _ZGeneric1Type108_GetBaseType
static long GetParamSize__1qrq(struct ZGeneric1Type108 * this);
#define _ZGeneric1Type108_GetParamSize
static struct ZType65 * GetParamType__2qrq(struct ZGeneric1Type108 * this, long Index__1);
#define _ZGeneric1Type108_GetParamType
static int IsGreekType__1qrq(struct ZGeneric1Type108 * this);
#define _ZGeneric1Type108_IsGreekType
static struct ZType65 * GetGreekRealType__2qrq(struct ZGeneric1Type108 * this, ArrayOfZType * Greek__1);
#define _ZGeneric1Type108_GetGreekRealType
static int AcceptValueType__4qrq(struct ZGeneric1Type108 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZGeneric1Type108_AcceptValueType
static struct ZGreekType116 * ZGreekType__2qro(struct ZGreekType116 * this, long GreekId__1);
static int IsGreekType__1qro(struct ZGreekType116 * this);
#define _ZGreekType116_IsGreekType
static struct ZType65 * GetGreekRealType__2qro(struct ZGreekType116 * this, ArrayOfZType * Greek__1);
#define _ZGreekType116_GetGreekRealType
static int AcceptValueType__4qro(struct ZGreekType116 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZGreekType116_AcceptValueType
static struct ZPrototype122 * ZPrototype__5qrd(struct ZPrototype122 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType91 * FuncType__3, struct ZToken78 * SourceToken__4);
static void Used__1qrd(struct ZPrototype122 * this);
static void Defined__1qrd(struct ZPrototype122 * this);
static struct ZVarScope135 * ZVarScope__4qrv(struct ZVarScope135 * this, struct ZVarScope135 * Parent__1, struct ZLogger136 * Logger__2, ArrayOfZVarType * VarList__3);
static struct ZType65 * NewVarType__4qrv(struct ZVarScope135 * this, struct ZType65 * VarType__1, const char * Name__2, struct ZToken78 * SourceToken__3);
static void FoundUnresolvedSymbol__2qrv(struct ZVarScope135 * this, const char * FuncName__1);
static void CheckVarNode__3qrv(struct ZVarScope135 * this, struct ZType65 * ContextType__1, struct ZNode55 * Node__2);
static int TypeCheckStmtList__3qrv(struct ZVarScope135 * this, struct ZTypeChecker143 * TypeSafer__1, ArrayOfZNode * StmtList__2);
static void TypeCheckFuncBlock__3qrv(struct ZVarScope135 * this, struct ZTypeChecker143 * TypeSafer__1, struct ZFunctionNode146 * FunctionNode__2);
static struct ZVarType137 * ZVarType__4qrn(struct ZVarType137 * this, ArrayOfZVarType * VarList__1, const char * Name__2, struct ZToken78 * SourceToken__3);
static struct ZType65 * GetRealType__1qrn(struct ZVarType137 * this);
#define _ZVarType137_GetRealType
static long GetParamSize__1qrn(struct ZVarType137 * this);
#define _ZVarType137_GetParamSize
static struct ZType65 * GetParamType__2qrn(struct ZVarType137 * this, long Index__1);
#define _ZVarType137_GetParamType
static int IsFuncType__1qrn(struct ZVarType137 * this);
static int IsVarType__1qrn(struct ZVarType137 * this);
#define _ZVarType137_IsVarType
static void Infer__3qrn(struct ZVarType137 * this, struct ZType65 * ContextType__1, struct ZToken78 * SourceToken__2);
static void Maybe__3qrn(struct ZVarType137 * this, struct ZType65 * T__1, struct ZToken78 * SourceToken__2);
static struct ZNode55 * ZNode__4qwk(struct ZNode55 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, long Size__3);
static struct ZNode55 * SetChild__2qwk(struct ZNode55 * this, struct ZNode55 * Node__1);
static void SetNameInfo__3qwk(struct ZNode55 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZNode55_SetNameInfo
static void SetTypeInfo__3qwk(struct ZNode55 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZNode55_SetTypeInfo
static void Set__3qwk(struct ZNode55 * this, long Index__1, struct ZNode55 * Node__2);
static long GetAstSize__1qwk(struct ZNode55 * this);
static int HasAst__2qwk(struct ZNode55 * this, long Index__1);
static struct ZType65 * GetAstType__2qwk(struct ZNode55 * this, long Index__1);
static const char * GetSourceLocation__1qwk(struct ZNode55 * this);
static const char * toString__1qwk(struct ZNode55 * this);
static struct ZBlockNode163 * GetScopeBlockNode__1qwk(struct ZNode55 * this);
static struct ZNameSpace49 * GetNameSpace__1qwk(struct ZNode55 * this);
static int IsErrorNode__1qwk(struct ZNode55 * this);
static int IsBreakingBlock__1qwk(struct ZNode55 * this);
#define _ZNode55_IsBreakingBlock
static struct ZSugarNode167 * DeSugar__2qwk(struct ZNode55 * this, struct ZGenerator58 * Generator__1);
#define _ZNode55_DeSugar
static void Accept__2qwk(struct ZNode55 * this, struct ZVisitor169 * Visitor__1);
#define _ZNode55_Accept
static int IsUntyped__1qwk(struct ZNode55 * this);
static int HasUntypedNode__1qwk(struct ZNode55 * this);
static struct ZNode55 * VisitTypeChecker__3qwk(struct ZNode55 * this, struct ZTypeChecker143 * TypeChecker__1, struct ZType65 * ContextType__2);
static struct ZReturnNode172 * ToReturnNode__1qwk(struct ZNode55 * this);
static struct ZParamNode174 * ZParamNode__2qtm(struct ZParamNode174 * this, struct ZNode55 * ParentNode__1);
static void SetNameInfo__3qtm(struct ZParamNode174 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZParamNode174_SetNameInfo
static struct ZReturnNode172 * ZReturnNode__2qtb(struct ZReturnNode172 * this, struct ZNode55 * ParentNode__1);
static void Accept__2qtb(struct ZReturnNode172 * this, struct ZVisitor169 * Visitor__1);
#define _ZReturnNode172_Accept
static struct ZReturnNode172 * ToReturnNode__1qtb(struct ZReturnNode172 * this);
static struct ZSetIndexNode180 * ZSetIndexNode__3qyq(struct ZSetIndexNode180 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * LeftNode__2);
static void Accept__2qyq(struct ZSetIndexNode180 * this, struct ZVisitor169 * Visitor__1);
#define _ZSetIndexNode180_Accept
static struct ZSetNameNode183 * ZSetNameNode__4qyr(struct ZSetNameNode183 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, const char * VarName__3);
static void Accept__2qyr(struct ZSetNameNode183 * this, struct ZVisitor169 * Visitor__1);
#define _ZSetNameNode183_Accept
static struct ZSetterNode186 * ZSetterNode__3qyu(struct ZSetterNode186 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2);
static void SetNameInfo__3qyu(struct ZSetterNode186 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZSetterNode186_SetNameInfo
static void Accept__2qyu(struct ZSetterNode186 * this, struct ZVisitor169 * Visitor__1);
#define _ZSetterNode186_Accept
static int IsStaticField__1qyu(struct ZSetterNode186 * this);
static struct ZSugarNode167 * ZSugarNode__3qt6(struct ZSugarNode167 * this, struct ZNode55 * SugarNode__1, struct ZNode55 * DeSugarNode__2);
static void Accept__2qt6(struct ZSugarNode167 * this, struct ZVisitor169 * Visitor__1);
#define _ZSugarNode167_Accept
static struct ZThrowNode193 * ZThrowNode__2qys(struct ZThrowNode193 * this, struct ZNode55 * ParentNode__1);
static void Accept__2qys(struct ZThrowNode193 * this, struct ZVisitor169 * Visitor__1);
#define _ZThrowNode193_Accept
static struct ZTryNode196 * ZTryNode__2qyg(struct ZTryNode196 * this, struct ZNode55 * ParentNode__1);
static void Accept__2qyg(struct ZTryNode196 * this, struct ZVisitor169 * Visitor__1);
#define _ZTryNode196_Accept
static struct ZUnaryNode199 * ZUnaryNode__3qyk(struct ZUnaryNode199 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2);
static void Accept__2qyk(struct ZUnaryNode199 * this, struct ZVisitor169 * Visitor__1);
#define _ZUnaryNode199_Accept
static struct ZWhileNode202 * ZWhileNode__2qy1(struct ZWhileNode202 * this, struct ZNode55 * ParentNode__1);
static void Accept__2qy1(struct ZWhileNode202 * this, struct ZVisitor169 * Visitor__1);
#define _ZWhileNode202_Accept
static const char * toString__1qyx(struct ZEmptyValue205 * this);
static void Report__2qrb(struct ZLogger136 * this, const char * Message__1);
static ArrayOfString * GetReportedErrors__1qrb(struct ZLogger136 * this);
static void ShowErrors__1qrb(struct ZLogger136 * this);
static struct ZMacroFunc213 * ZMacroFunc__3qy3(struct ZMacroFunc213 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2);
static struct ZNameSpace49 * ZNameSpace__3qws(struct ZNameSpace49 * this, struct ZGenerator58 * Generator__1, struct ZNameSpace49 * ParentNameSpace__2);
static const char * toString__1qws(struct ZNameSpace49 * this);
static struct ZNameSpace49 * CreateSubNameSpace__1qws(struct ZNameSpace49 * this);
static struct ZNameSpace49 * GetRootNameSpace__1qws(struct ZNameSpace49 * this);
static struct ZTokenFunc36 * GetTokenFunc__2qws(struct ZNameSpace49 * this, long ZenChar__1);
static struct ZTokenFunc36 * JoinParentFunc__3qws(struct ZNameSpace49 * this, struct ZTokenFunction51 * Func__1, struct ZTokenFunc36 * Parent__2);
static void AppendTokenFunc__3qws(struct ZNameSpace49 * this, const char * keys__1, struct ZTokenFunction51 * TokenFunc__2);
static struct ZSyntax221 * GetSyntaxPattern__2qws(struct ZNameSpace49 * this, const char * PatternName__1);
static void SetSyntaxPattern__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZSyntax221 * Syntax__2);
static struct ZSyntax221 * GetRightSyntaxPattern__2qws(struct ZNameSpace49 * this, const char * PatternName__1);
static void AppendSyntaxPattern__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZSyntax221 * NewPattern__2);
static void DefineStatement__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZMatchFunction54 * MatchFunc__2);
static void DefineExpression__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZMatchFunction54 * MatchFunc__2);
static void DefineRightExpression__4qws(struct ZNameSpace49 * this, const char * PatternName__1, long SyntaxFlag__2, struct ZMatchFunction54 * MatchFunc__3);
static struct ZSymbolEntry226 * GetSymbol__2qws(struct ZNameSpace49 * this, const char * Symbol__1);
static struct ZNode55 * GetSymbolNode__2qws(struct ZNameSpace49 * this, const char * Symbol__1);
static void SetLocalSymbolEntry__3qws(struct ZNameSpace49 * this, const char * Symbol__1, struct ZSymbolEntry226 * Entry__2);
static struct ZSymbolEntry226 * SetLocalSymbol__3qws(struct ZNameSpace49 * this, const char * Symbol__1, struct ZNode55 * Node__2);
static struct ZSymbolEntry226 * SetGlobalSymbol__3qws(struct ZNameSpace49 * this, const char * Symbol__1, struct ZNode55 * Node__2);
static struct ZVariable231 * GetLocalVariable__2qws(struct ZNameSpace49 * this, const char * VarName__1);
static void SetLocalVariable__5qws(struct ZNameSpace49 * this, struct ZFunctionNode146 * FunctionNode__1, struct ZType65 * VarType__2, const char * VarName__3, struct ZToken78 * SourceToken__4);
static void SetTypeName__4qws(struct ZNameSpace49 * this, const char * Name__1, struct ZType65 * Type__2, struct ZToken78 * SourceToken__3);
static void SetTypeName__3qws(struct ZNameSpace49 * this, struct ZType65 * Type__1, struct ZToken78 * SourceToken__2);
static struct ZTypeNode236 * GetTypeNode__3qws(struct ZNameSpace49 * this, const char * TypeName__1, struct ZToken78 * SourceToken__2);
static struct ZType65 * GetType__3qws(struct ZNameSpace49 * this, const char * TypeName__1, struct ZToken78 * SourceToken__2);
static struct ZSource239 * ZSource__5qu6(struct ZSource239 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext56 * TokenContext__4);
static long GetLineNumber__2qu6(struct ZSource239 * this, long Position__1);
static long GetLineHeadPosition__2qu6(struct ZSource239 * this, long Position__1);
static long CountIndentSize__2qu6(struct ZSource239 * this, long Position__1);
static const char * GetLineText__2qu6(struct ZSource239 * this, long Position__1);
static const char * GetLineMarker__2qu6(struct ZSource239 * this, long Position__1);
static const char * FormatErrorHeader__4qu6(struct ZSource239 * this, const char * Error__1, long Position__2, const char * Message__3);
static const char * FormatErrorMarker__4qu6(struct ZSource239 * this, const char * Error__1, long Position__2, const char * Message__3);
static const char * GetCharAt__2qu6(struct ZSource239 * this, long n__1);
static struct ZSourceBuilder43 * ZSourceBuilder__3qwi(struct ZSourceBuilder43 * this, struct ZSourceGenerator244 * Template__1, struct ZSourceBuilder43 * Parent__2);
static struct ZSourceBuilder43 * Pop__1qwi(struct ZSourceBuilder43 * this);
static void Clear__1qwi(struct ZSourceBuilder43 * this);
static long GetPosition__1qwi(struct ZSourceBuilder43 * this);
static const char * CopyString__3qwi(struct ZSourceBuilder43 * this, long BeginIndex__1, long EndIndex__2);
static void Append__2qwi(struct ZSourceBuilder43 * this, const char * Text__1);
static void AppendInt__2qwi(struct ZSourceBuilder43 * this, long Value__1);
static void AppendLineFeed__1qwi(struct ZSourceBuilder43 * this);
static void AppendLineFeed__2qwi(struct ZSourceBuilder43 * this, int AppendIndent__1);
static void AppendWhiteSpace__1qwi(struct ZSourceBuilder43 * this);
static void AppendToken__2qwi(struct ZSourceBuilder43 * this, const char * Text__1);
static void AppendBlockComment__2qwi(struct ZSourceBuilder43 * this, const char * Text__1);
static void AppendCommentLine__2qwi(struct ZSourceBuilder43 * this, const char * Text__1);
static void Indent__1qwi(struct ZSourceBuilder43 * this);
static void UnIndent__1qwi(struct ZSourceBuilder43 * this);
static const char * GetIndentString__1qwi(struct ZSourceBuilder43 * this);
static void AppendIndent__1qwi(struct ZSourceBuilder43 * this);
static void AppendLineFeedIndent__1qwi(struct ZSourceBuilder43 * this);
static void IndentAndAppend__2qwi(struct ZSourceBuilder43 * this, const char * Text__1);
static void AppendParamList__4qwi(struct ZSourceBuilder43 * this, struct ZListNode252 * ParamList__1, long BeginIdx__2, long EndIdx__3);
static const char * toString__1qwi(struct ZSourceBuilder43 * this);
static void AppendLine__2qwi(struct ZSourceBuilder43 * this, const char * Text__1);
static struct ZSourceContext52 * ZSourceContext__5qwg(struct ZSourceContext52 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext56 * TokenContext__4);
static long GetCharCode__1qwg(struct ZSourceContext52 * this);
static long GetPosition__1qwg(struct ZSourceContext52 * this);
static int HasChar__1qwg(struct ZSourceContext52 * this);
static const char * GetCurrentChar__1qwg(struct ZSourceContext52 * this);
static const char * GetCharAtFromCurrentPosition__2qwg(struct ZSourceContext52 * this, long n__1);
static void MoveNext__1qwg(struct ZSourceContext52 * this);
static void SkipWhiteSpace__1qwg(struct ZSourceContext52 * this);
static void FoundIndent__3qwg(struct ZSourceContext52 * this, long StartIndex__1, long EndIndex__2);
static void Tokenize__3qwg(struct ZSourceContext52 * this, long StartIndex__1, long EndIndex__2);
static void Tokenize__4qwg(struct ZSourceContext52 * this, const char * PatternName__1, long StartIndex__2, long EndIndex__3);
static int IsDefinedSyntax__3qwg(struct ZSourceContext52 * this, long StartIndex__1, long EndIndex__2);
static void TokenizeDefinedSymbol__2qwg(struct ZSourceContext52 * this, long StartIndex__1);
static void ApplyTokenFunc__2qwg(struct ZSourceContext52 * this, struct ZTokenFunc36 * TokenFunc__1);
static int DoTokenize__1qwg(struct ZSourceContext52 * this);
static void LogWarning__3qwg(struct ZSourceContext52 * this, long Position__1, const char * Message__2);
static struct ZSourceMacro266 * ZSourceMacro__4qid(struct ZSourceMacro266 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2, const char * Macro__3);
static struct ZSymbolEntry226 * ZSymbolEntry__3qu0(struct ZSymbolEntry226 * this, struct ZSymbolEntry226 * Parent__1, struct ZNode55 * Node__2);
static struct ZSyntax221 * ZSyntax__4quy(struct ZSyntax221 * this, struct ZNameSpace49 * NameSpace__1, const char * PatternName__2, struct ZMatchFunction54 * MatchFunc__3);
static const char * toString__1quy(struct ZSyntax221 * this);
static int IsBinaryOperator__1quy(struct ZSyntax221 * this);
static int IsRightJoin__2quy(struct ZSyntax221 * this, struct ZSyntax221 * Right__1);
static int EqualsName__2quy(struct ZSyntax221 * this, const char * Name__1);
static struct ZToken78 * ZToken__4qeu(struct ZToken78 * this, struct ZSource239 * Source__1, long StartIndex__2, long EndIndex__3);
static const char * GetFileName__1qeu(struct ZToken78 * this);
static long GetLineNumber__1qeu(struct ZToken78 * this);
static const char * GetChar__1qeu(struct ZToken78 * this);
static const char * GetText__1qeu(struct ZToken78 * this);
static const char * toString__1qeu(struct ZToken78 * this);
static int EqualsText__2qeu(struct ZToken78 * this, const char * Text__1);
static int StartsWith__2qeu(struct ZToken78 * this, const char * Text__1);
static int IsNull__1qeu(struct ZToken78 * this);
static int IsIndent__1qeu(struct ZToken78 * this);
static int IsNextWhiteSpace__1qeu(struct ZToken78 * this);
static int IsNameSymbol__1qeu(struct ZToken78 * this);
static long GetIndentSize__1qeu(struct ZToken78 * this);
static struct ZTokenContext56 * ZTokenContext__6qwl(struct ZTokenContext56 * this, struct ZGenerator58 * Generator__1, struct ZNameSpace49 * NameSpace__2, const char * FileName__3, long LineNumber__4, const char * SourceText__5);
static int SetParseFlag__2qwl(struct ZTokenContext56 * this, int AllowSkipIndent__1);
static struct ZToken78 * GetBeforeToken__1qwl(struct ZTokenContext56 * this);
static struct ZNode55 * CreateExpectedErrorNode__3qwl(struct ZTokenContext56 * this, struct ZToken78 * SourceToken__1, const char * ExpectedTokenText__2);
static void Vacume__1qwl(struct ZTokenContext56 * this);
static void MoveNext__1qwl(struct ZTokenContext56 * this);
static struct ZToken78 * GetToken__2qwl(struct ZTokenContext56 * this, int EnforceMoveNext__1);
static struct ZToken78 * GetToken__1qwl(struct ZTokenContext56 * this);
static int HasNext__1qwl(struct ZTokenContext56 * this);
static void SkipIndent__1qwl(struct ZTokenContext56 * this);
static void SkipError__2qwl(struct ZTokenContext56 * this, struct ZToken78 * ErrorToken__1);
static int IsToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1);
static int IsNewLineToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1);
static int MatchToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1);
static int MatchNewLineToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1);
static struct ZToken78 * ParseLargeToken__1qwl(struct ZTokenContext56 * this);
static struct ZNode55 * MatchToken__4qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, const char * TokenText__2, int IsRequired__3);
static struct ZSyntax221 * GetApplyingSyntax__1qwl(struct ZTokenContext56 * this);
static struct ZNode55 * ApplyMatchPattern__5qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * LeftNode__2, struct ZSyntax221 * Pattern__3, int IsRequired__4);
static struct ZNode55 * ParsePatternAfter__5qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * LeftNode__2, const char * PatternName__3, int IsRequired__4);
static struct ZNode55 * ParsePattern__4qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, const char * PatternName__2, int IsRequired__3);
static struct ZNode55 * MatchPattern__6qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4, int AllowSkipIndent__5);
static struct ZNode55 * MatchPattern__5qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4);
static struct ZNode55 * MatchOptionaPattern__6qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, long Index__2, int AllowNewLine__3, const char * TokenText__4, const char * PatternName__5);
static struct ZNode55 * MatchNtimes__6qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, const char * StartToken__2, const char * PatternName__3, const char * DelimToken__4, const char * StopToken__5);
static int StartsWithToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1);
static void SkipEmptyStatement__1qwl(struct ZTokenContext56 * this);
static void Dump__1qwl(struct ZTokenContext56 * this);
static struct ZTokenFunc36 * ZTokenFunc__3qwq(struct ZTokenFunc36 * this, struct ZTokenFunction51 * Func__1, struct ZTokenFunc36 * Parent__2);
static const char * toString__1qwq(struct ZTokenFunc36 * this);
static struct ZVariable231 * ZVariable__7quf(struct ZVariable231 * this, struct ZSymbolEntry226 * Parent__1, struct ZFunctionNode146 * FuncNode__2, long VarFlag__3, struct ZType65 * VarType__4, const char * VarName__5, struct ZToken78 * SourceToken__6);
static int IsCaptured__2quf(struct ZVariable231 * this, struct ZFunctionNode146 * CurrentFunctionNode__1);
static void Defined__1quf(struct ZVariable231 * this);
static void Used__1quf(struct ZVariable231 * this);
static struct ZArrayType302 * ZArrayType__3qod(struct ZArrayType302 * this, long TypeFlag__1, struct ZType65 * ParamType__2);
static struct ZAnnotationNode304 * ZAnnotationNode__4qog(struct ZAnnotationNode304 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, MapOfObject * Anno__3);
static int IsBreakingBlock__1qog(struct ZAnnotationNode304 * this);
#define _ZAnnotationNode304_IsBreakingBlock
static void Accept__2qog(struct ZAnnotationNode304 * this, struct ZVisitor169 * Visitor__1);
#define _ZAnnotationNode304_Accept
static struct ZAssertNode310 * ZAssertNode__2qo1(struct ZAssertNode310 * this, struct ZNode55 * ParentNode__1);
static struct ZSugarNode167 * DeSugar__2qo1(struct ZAssertNode310 * this, struct ZGenerator58 * Generator__1);
#define _ZAssertNode310_DeSugar
static struct ZBinaryNode313 * ZBinaryNode__5qox(struct ZBinaryNode313 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4);
static int IsRightJoin__2qox(struct ZBinaryNode313 * this, struct ZNode55 * Node__1);
static struct ZNode55 * RightJoin__3qox(struct ZBinaryNode313 * this, struct ZNode55 * ParentNode__1, struct ZBinaryNode313 * RightNode__2);
static struct ZNode55 * AppendParsedRightNode__3qox(struct ZBinaryNode313 * this, struct ZNode55 * ParentNode__1, struct ZTokenContext56 * TokenContext__2);
static struct ZNode55 * TryMacroNode__2qox(struct ZBinaryNode313 * this, struct ZGenerator58 * Generator__1);
static void Accept__2qox(struct ZBinaryNode313 * this, struct ZVisitor169 * Visitor__1);
#define _ZBinaryNode313_Accept
static struct ZBreakNode320 * ZBreakNode__2qo5(struct ZBreakNode320 * this, struct ZNode55 * ParentNode__1);
static void Accept__2qo5(struct ZBreakNode320 * this, struct ZVisitor169 * Visitor__1);
#define _ZBreakNode320_Accept
static struct ZCastNode323 * ZCastNode__4qo8(struct ZCastNode323 * this, struct ZNode55 * ParentNode__1, struct ZType65 * CastType__2, struct ZNode55 * Node__3);
static void Accept__2qo8(struct ZCastNode323 * this, struct ZVisitor169 * Visitor__1);
#define _ZCastNode323_Accept
static struct ZListNode252 * ToFuncCallNode__2qo8(struct ZCastNode323 * this, struct ZFunc90 * Func__1);
static struct ZCatchNode327 * ZCatchNode__2qpr(struct ZCatchNode327 * this, struct ZNode55 * ParentNode__1);
static void SetTypeInfo__3qpr(struct ZCatchNode327 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZCatchNode327_SetTypeInfo
static void SetNameInfo__3qpr(struct ZCatchNode327 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZCatchNode327_SetNameInfo
static struct ZComparatorNode331 * ZComparatorNode__5qpi(struct ZComparatorNode331 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4);
static void Accept__2qpi(struct ZComparatorNode331 * this, struct ZVisitor169 * Visitor__1);
#define _ZComparatorNode331_Accept
static struct ZConstNode334 * ZConstNode__3qp0(struct ZConstNode334 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2);
static struct ZEmptyNode336 * ZEmptyNode__3qpa(struct ZEmptyNode336 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2);
static struct ZErrorNode338 * ZErrorNode__4qpd(struct ZErrorNode338 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, const char * ErrorMessage__3);
static struct ZErrorNode338 * ZErrorNode__3qpd(struct ZErrorNode338 * this, struct ZNode55 * Node__1, const char * ErrorMessage__2);
static void Accept__2qpd(struct ZErrorNode338 * this, struct ZVisitor169 * Visitor__1);
#define _ZErrorNode338_Accept
static struct ZFieldNode342 * ZFieldNode__2qpj(struct ZFieldNode342 * this, struct ZNode55 * ParentNode__1);
static void SetTypeInfo__3qpj(struct ZFieldNode342 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZFieldNode342_SetTypeInfo
static void SetNameInfo__3qpj(struct ZFieldNode342 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZFieldNode342_SetNameInfo
static struct ZFloatNode346 * ZFloatNode__4qp1(struct ZFloatNode346 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, double Value__3);
static void Accept__2qp1(struct ZFloatNode346 * this, struct ZVisitor169 * Visitor__1);
#define _ZFloatNode346_Accept
static struct ZGetIndexNode349 * ZGetIndexNode__3qpx(struct ZGetIndexNode349 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2);
static void Accept__2qpx(struct ZGetIndexNode349 * this, struct ZVisitor169 * Visitor__1);
#define _ZGetIndexNode349_Accept
static struct ZGetNameNode352 * ZGetNameNode__4qpb(struct ZGetNameNode352 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, const char * NativeName__3);
static struct ZGetNameNode352 * ZGetNameNode__3qpb(struct ZGetNameNode352 * this, struct ZNode55 * ParentNode__1, struct ZFunc90 * ResolvedFunc__2);
static void Accept__2qpb(struct ZGetNameNode352 * this, struct ZVisitor169 * Visitor__1);
#define _ZGetNameNode352_Accept
static struct ZNode55 * ToGlobalNameNode__1qpb(struct ZGetNameNode352 * this);
static struct ZGetterNode357 * ZGetterNode__3qp3(struct ZGetterNode357 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2);
static void SetNameInfo__3qp3(struct ZGetterNode357 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZGetterNode357_SetNameInfo
static void Accept__2qp3(struct ZGetterNode357 * this, struct ZVisitor169 * Visitor__1);
#define _ZGetterNode357_Accept
static int IsStaticField__1qp3(struct ZGetterNode357 * this);
static struct ZGlobalNameNode362 * ZGlobalNameNode__6q0e(struct ZGlobalNameNode362 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZType65 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5);
static int IsGivenName__1q0e(struct ZGlobalNameNode362 * this);
static void Accept__2q0e(struct ZGlobalNameNode362 * this, struct ZVisitor169 * Visitor__1);
#define _ZGlobalNameNode362_Accept
static struct ZGroupNode366 * ZGroupNode__2q0u(struct ZGroupNode366 * this, struct ZNode55 * ParentNode__1);
static void Accept__2q0u(struct ZGroupNode366 * this, struct ZVisitor169 * Visitor__1);
#define _ZGroupNode366_Accept
static struct ZIfNode369 * ZIfNode__2q0p(struct ZIfNode369 * this, struct ZNode55 * ParentNode__1);
static void Accept__2q0p(struct ZIfNode369 * this, struct ZVisitor169 * Visitor__1);
#define _ZIfNode369_Accept
static struct ZImportNode372 * ZImportNode__2q0a(struct ZImportNode372 * this, struct ZNode55 * ParentNode__1);
static void SetNameInfo__3q0a(struct ZImportNode372 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZImportNode372_SetNameInfo
static struct ZInstanceOfNode375 * ZInstanceOfNode__4q0f(struct ZInstanceOfNode375 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, struct ZNode55 * LeftNode__3);
static void SetTypeInfo__3q0f(struct ZInstanceOfNode375 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZInstanceOfNode375_SetTypeInfo
static void Accept__2q0f(struct ZInstanceOfNode375 * this, struct ZVisitor169 * Visitor__1);
#define _ZInstanceOfNode375_Accept
static struct ZIntNode379 * ZIntNode__4q0k(struct ZIntNode379 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, long Value__3);
static void Accept__2q0k(struct ZIntNode379 * this, struct ZVisitor169 * Visitor__1);
#define _ZIntNode379_Accept
static struct ZLetNode382 * ZLetNode__2q01(struct ZLetNode382 * this, struct ZNode55 * ParentNode__1);
static void SetNameInfo__3q01(struct ZLetNode382 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZLetNode382_SetNameInfo
static void SetTypeInfo__3q01(struct ZLetNode382 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZLetNode382_SetTypeInfo
static void Accept__2q01(struct ZLetNode382 * this, struct ZVisitor169 * Visitor__1);
#define _ZLetNode382_Accept
static struct ZGlobalNameNode362 * ToGlobalNameNode__1q01(struct ZLetNode382 * this);
static struct ZListNode252 * ZListNode__4qiq(struct ZListNode252 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, long Size__3);
static void Append__2qiq(struct ZListNode252 * this, struct ZNode55 * Node__1);
static long GetListSize__1qiq(struct ZListNode252 * this);
static struct ZNode55 * GetListAt__2qiq(struct ZListNode252 * this, long Index__1);
static void SetListAt__3qiq(struct ZListNode252 * this, long Index__1, struct ZNode55 * Node__2);
static void InsertListAt__3qiq(struct ZListNode252 * this, long Index__1, struct ZNode55 * Node__2);
static struct ZNode55 * RemoveListAt__2qiq(struct ZListNode252 * this, long Index__1);
static void ClearListAfter__2qiq(struct ZListNode252 * this, long Size__1);
static struct ZMacroNode394 * ZMacroNode__4q02(struct ZMacroNode394 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZMacroFunc213 * MacroFunc__3);
static struct ZFuncType91 * GetFuncType__1q02(struct ZMacroNode394 * this);
static const char * GetMacroText__1q02(struct ZMacroNode394 * this);
static void Accept__2q02(struct ZMacroNode394 * this, struct ZVisitor169 * Visitor__1);
#define _ZMacroNode394_Accept
static struct ZMapEntryNode399 * ZMapEntryNode__2q4r(struct ZMapEntryNode399 * this, struct ZNode55 * ParentNode__1);
static struct ZMapLiteralNode401 * ZMapLiteralNode__2q4y(struct ZMapLiteralNode401 * this, struct ZNode55 * ParentNode__1);
static struct ZMapEntryNode399 * GetMapEntryNode__2q4y(struct ZMapLiteralNode401 * this, long Index__1);
static void Accept__2q4y(struct ZMapLiteralNode401 * this, struct ZVisitor169 * Visitor__1);
#define _ZMapLiteralNode401_Accept
static struct ZMethodCallNode405 * ZMethodCallNode__3q4p(struct ZMethodCallNode405 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2);
static void SetNameInfo__3q4p(struct ZMethodCallNode405 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZMethodCallNode405_SetNameInfo
static void Accept__2q4p(struct ZMethodCallNode405 * this, struct ZVisitor169 * Visitor__1);
#define _ZMethodCallNode405_Accept
static struct ZFuncCallNode409 * ToGetterFuncCall__1q4p(struct ZMethodCallNode405 * this);
static struct ZListNode252 * ToFuncCallNode__2q4p(struct ZMethodCallNode405 * this, struct ZFunc90 * Func__1);
static struct ZNewArrayNode412 * ZNewArrayNode__4q4g(struct ZNewArrayNode412 * this, struct ZNode55 * ParentNode__1, struct ZType65 * Type__2, struct ZToken78 * Token__3);
static struct ZNewObjectNode414 * ZNewObjectNode__2q4j(struct ZNewObjectNode414 * this, struct ZNode55 * ParentNode__1);
static void Accept__2q4j(struct ZNewObjectNode414 * this, struct ZVisitor169 * Visitor__1);
#define _ZNewObjectNode414_Accept
static struct ZListNode252 * ToFuncCallNode__2q4j(struct ZNewObjectNode414 * this, struct ZFunc90 * Func__1);
static struct ZNotNode418 * ZNotNode__3q41(struct ZNotNode418 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2);
static void Accept__2q41(struct ZNotNode418 * this, struct ZVisitor169 * Visitor__1);
#define _ZNotNode418_Accept
static struct ZNullNode421 * ZNullNode__3q4x(struct ZNullNode421 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2);
static void Accept__2q4x(struct ZNullNode421 * this, struct ZVisitor169 * Visitor__1);
#define _ZNullNode421_Accept
static struct ZOrNode424 * ZOrNode__5q4b(struct ZOrNode424 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4);
static void Accept__2q4b(struct ZOrNode424 * this, struct ZVisitor169 * Visitor__1);
#define _ZOrNode424_Accept
static struct ZPrototypeNode427 * ZPrototypeNode__2q47(struct ZPrototypeNode427 * this, struct ZNode55 * ParentNode__1);
static void SetTypeInfo__3q47(struct ZPrototypeNode427 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZPrototypeNode427_SetTypeInfo
static void SetNameInfo__3q47(struct ZPrototypeNode427 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZPrototypeNode427_SetNameInfo
static struct ZParamNode174 * GetParamNode__2q47(struct ZPrototypeNode427 * this, long Index__1);
static struct ZFuncType91 * GetFuncType__1q47(struct ZPrototypeNode427 * this);
static struct ZStringNode433 * ZStringNode__4qaw(struct ZStringNode433 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, const char * Value__3);
static void Accept__2qaw(struct ZStringNode433 * this, struct ZVisitor169 * Visitor__1);
#define _ZStringNode433_Accept
static struct ZStupidCastErrorNode436 * ZStupidCastErrorNode__3qat(struct ZStupidCastErrorNode436 * this, struct ZNode55 * Node__1, const char * ErrorMessage__2);
static struct ZTypeNode236 * ZTypeNode__4qul(struct ZTypeNode236 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZType65 * ParsedType__3);
static struct ZGenerator58 * ZGenerator__3qw1(struct ZGenerator58 * this, const char * LanguageExtension__1, const char * TargetVersion__2);
static void ImportLocalGrammar__2qw1(struct ZGenerator58 * this, struct ZNameSpace49 * NameSpace__1);
#define _ZGenerator58_ImportLocalGrammar
static void WriteTo__2qw1(struct ZGenerator58 * this, const char * FileName__1);
#define _ZGenerator58_WriteTo
static const char * NameOutputFile__2qw1(struct ZGenerator58 * this, const char * FileName__1);
#define _ZGenerator58_NameOutputFile
static void EnableVisitor__1qw1(struct ZGenerator58 * this);
#define _ZGenerator58_EnableVisitor
static void StopVisitor__1qw1(struct ZGenerator58 * this);
#define _ZGenerator58_StopVisitor
static int IsVisitable__1qw1(struct ZGenerator58 * this);
#define _ZGenerator58_IsVisitable
static const char * GetGrammarInfo__1qw1(struct ZGenerator58 * this);
static void AppendGrammarInfo__2qw1(struct ZGenerator58 * this, const char * GrammarInfo__1);
static const char * GetTargetLangInfo__1qw1(struct ZGenerator58 * this);
static struct ZType65 * GetFieldType__3qw1(struct ZGenerator58 * this, struct ZType65 * BaseType__1, const char * Name__2);
#define _ZGenerator58_GetFieldType
static struct ZType65 * GetSetterType__3qw1(struct ZGenerator58 * this, struct ZType65 * BaseType__1, const char * Name__2);
#define _ZGenerator58_GetSetterType
static struct ZFuncType91 * GetConstructorFuncType__3qw1(struct ZGenerator58 * this, struct ZType65 * ClassType__1, struct ZListNode252 * List__2);
#define _ZGenerator58_GetConstructorFuncType
static struct ZFuncType91 * GetMethodFuncType__4qw1(struct ZGenerator58 * this, struct ZType65 * RecvType__1, const char * MethodName__2, struct ZListNode252 * List__3);
#define _ZGenerator58_GetMethodFuncType
static long GetUniqueNumber__1qw1(struct ZGenerator58 * this);
static const char * NameGlobalSymbol__2qw1(struct ZGenerator58 * this, const char * Symbol__1);
static const char * NameClass__2qw1(struct ZGenerator58 * this, struct ZType65 * ClassType__1);
static void SetDefinedFunc__2qw1(struct ZGenerator58 * this, struct ZFunc90 * Func__1);
static struct ZPrototype122 * SetPrototype__4qw1(struct ZGenerator58 * this, struct ZNode55 * Node__1, const char * FuncName__2, struct ZFuncType91 * FuncType__3);
static struct ZFunc90 * GetDefinedFunc__2qw1(struct ZGenerator58 * this, const char * GlobalName__1);
static struct ZFunc90 * GetDefinedFunc__3qw1(struct ZGenerator58 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2);
static struct ZFunc90 * GetDefinedFunc__4qw1(struct ZGenerator58 * this, const char * FuncName__1, struct ZType65 * RecvType__2, long FuncParamSize__3);
static struct ZMacroFunc213 * GetMacroFunc__4qw1(struct ZGenerator58 * this, const char * FuncName__1, struct ZType65 * RecvType__2, long FuncParamSize__3);
static const char * NameConverterFunc__3qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2);
static void SetConverterFunc__4qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2, struct ZFunc90 * Func__3);
static struct ZFunc90 * GetConverterFunc__3qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2);
static struct ZFunc90 * GetCoercionFunc__3qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2);
static void VisitExtendedNode__2qw1(struct ZGenerator58 * this, struct ZNode55 * Node__1);
#define _ZGenerator58_VisitExtendedNode
static void VisitSugarNode__2qw1(struct ZGenerator58 * this, struct ZSugarNode167 * Node__1);
#define _ZGenerator58_VisitSugarNode
static struct ZIndentToken462 * ZIndentToken__4qam(struct ZIndentToken462 * this, struct ZSource239 * Source__1, long StartIndex__2, long EndIndex__3);
static struct ZPatternToken464 * ZPatternToken__5qa5(struct ZPatternToken464 * this, struct ZSource239 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax221 * PresetPattern__4);
static struct ZSourceEngine60 * ZSourceEngine__3qwz(struct ZSourceEngine60 * this, struct ZTypeChecker143 * TypeChecker__1, struct ZGenerator58 * Generator__2);
static int IsVisitable__1qwz(struct ZSourceEngine60 * this);
#define _ZSourceEngine60_IsVisitable
static void EnableVisitor__1qwz(struct ZSourceEngine60 * this);
#define _ZSourceEngine60_EnableVisitor
static void StopVisitor__1qwz(struct ZSourceEngine60 * this);
#define _ZSourceEngine60_StopVisitor
static struct Object305 * Eval__2qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1);
static void VisitPrototypeNode__2qwz(struct ZSourceEngine60 * this, struct ZPrototypeNode427 * Node__1);
static void VisitImportNode__2qwz(struct ZSourceEngine60 * this, struct ZImportNode372 * Node__1);
static struct Object305 * Exec__3qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1, int IsInteractive__2);
static struct Object305 * Eval__6qwz(struct ZSourceEngine60 * this, struct ZNameSpace49 * NameSpace__1, const char * ScriptText__2, const char * FileName__3, long LineNumber__4, int IsInteractive__5);
static struct Object305 * Eval__5qwz(struct ZSourceEngine60 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3, int IsInteractive__4);
static int Load__2qwz(struct ZSourceEngine60 * this, const char * FileName__1);
static void Unsupported__2qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1);
static void VisitNullNode__2qwz(struct ZSourceEngine60 * this, struct ZNullNode421 * Node__1);
#define _ZSourceEngine60_VisitNullNode
static void VisitBooleanNode__2qwz(struct ZSourceEngine60 * this, struct ZBooleanNode478 * Node__1);
#define _ZSourceEngine60_VisitBooleanNode
static void VisitIntNode__2qwz(struct ZSourceEngine60 * this, struct ZIntNode379 * Node__1);
#define _ZSourceEngine60_VisitIntNode
static void VisitFloatNode__2qwz(struct ZSourceEngine60 * this, struct ZFloatNode346 * Node__1);
#define _ZSourceEngine60_VisitFloatNode
static void VisitStringNode__2qwz(struct ZSourceEngine60 * this, struct ZStringNode433 * Node__1);
#define _ZSourceEngine60_VisitStringNode
static void VisitArrayLiteralNode__2qwz(struct ZSourceEngine60 * this, struct ZArrayLiteralNode483 * Node__1);
#define _ZSourceEngine60_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qwz(struct ZSourceEngine60 * this, struct ZMapLiteralNode401 * Node__1);
#define _ZSourceEngine60_VisitMapLiteralNode
static void VisitNewObjectNode__2qwz(struct ZSourceEngine60 * this, struct ZNewObjectNode414 * Node__1);
#define _ZSourceEngine60_VisitNewObjectNode
static void VisitGlobalNameNode__2qwz(struct ZSourceEngine60 * this, struct ZGlobalNameNode362 * Node__1);
#define _ZSourceEngine60_VisitGlobalNameNode
static void VisitGetNameNode__2qwz(struct ZSourceEngine60 * this, struct ZGetNameNode352 * Node__1);
#define _ZSourceEngine60_VisitGetNameNode
static void VisitSetNameNode__2qwz(struct ZSourceEngine60 * this, struct ZSetNameNode183 * Node__1);
#define _ZSourceEngine60_VisitSetNameNode
static void VisitGroupNode__2qwz(struct ZSourceEngine60 * this, struct ZGroupNode366 * Node__1);
#define _ZSourceEngine60_VisitGroupNode
static void VisitGetterNode__2qwz(struct ZSourceEngine60 * this, struct ZGetterNode357 * Node__1);
#define _ZSourceEngine60_VisitGetterNode
static void VisitSetterNode__2qwz(struct ZSourceEngine60 * this, struct ZSetterNode186 * Node__1);
#define _ZSourceEngine60_VisitSetterNode
static void VisitGetIndexNode__2qwz(struct ZSourceEngine60 * this, struct ZGetIndexNode349 * Node__1);
#define _ZSourceEngine60_VisitGetIndexNode
static void VisitSetIndexNode__2qwz(struct ZSourceEngine60 * this, struct ZSetIndexNode180 * Node__1);
#define _ZSourceEngine60_VisitSetIndexNode
static void VisitMacroNode__2qwz(struct ZSourceEngine60 * this, struct ZMacroNode394 * Node__1);
#define _ZSourceEngine60_VisitMacroNode
static void VisitFuncCallNode__2qwz(struct ZSourceEngine60 * this, struct ZFuncCallNode409 * Node__1);
#define _ZSourceEngine60_VisitFuncCallNode
static void VisitMethodCallNode__2qwz(struct ZSourceEngine60 * this, struct ZMethodCallNode405 * Node__1);
#define _ZSourceEngine60_VisitMethodCallNode
static void VisitUnaryNode__2qwz(struct ZSourceEngine60 * this, struct ZUnaryNode199 * Node__1);
#define _ZSourceEngine60_VisitUnaryNode
static void VisitNotNode__2qwz(struct ZSourceEngine60 * this, struct ZNotNode418 * Node__1);
#define _ZSourceEngine60_VisitNotNode
static void VisitCastNode__2qwz(struct ZSourceEngine60 * this, struct ZCastNode323 * Node__1);
#define _ZSourceEngine60_VisitCastNode
static void VisitInstanceOfNode__2qwz(struct ZSourceEngine60 * this, struct ZInstanceOfNode375 * Node__1);
#define _ZSourceEngine60_VisitInstanceOfNode
static void VisitBinaryNode__2qwz(struct ZSourceEngine60 * this, struct ZBinaryNode313 * Node__1);
#define _ZSourceEngine60_VisitBinaryNode
static void VisitComparatorNode__2qwz(struct ZSourceEngine60 * this, struct ZComparatorNode331 * Node__1);
#define _ZSourceEngine60_VisitComparatorNode
static void VisitAndNode__2qwz(struct ZSourceEngine60 * this, struct ZAndNode504 * Node__1);
#define _ZSourceEngine60_VisitAndNode
static void VisitOrNode__2qwz(struct ZSourceEngine60 * this, struct ZOrNode424 * Node__1);
#define _ZSourceEngine60_VisitOrNode
static void VisitBlockNode__2qwz(struct ZSourceEngine60 * this, struct ZBlockNode163 * Node__1);
#define _ZSourceEngine60_VisitBlockNode
static void VisitVarNode__2qwz(struct ZSourceEngine60 * this, struct ZVarNode508 * Node__1);
#define _ZSourceEngine60_VisitVarNode
static void VisitIfNode__2qwz(struct ZSourceEngine60 * this, struct ZIfNode369 * Node__1);
#define _ZSourceEngine60_VisitIfNode
static void VisitReturnNode__2qwz(struct ZSourceEngine60 * this, struct ZReturnNode172 * Node__1);
#define _ZSourceEngine60_VisitReturnNode
static void VisitWhileNode__2qwz(struct ZSourceEngine60 * this, struct ZWhileNode202 * Node__1);
#define _ZSourceEngine60_VisitWhileNode
static void VisitBreakNode__2qwz(struct ZSourceEngine60 * this, struct ZBreakNode320 * Node__1);
#define _ZSourceEngine60_VisitBreakNode
static void VisitThrowNode__2qwz(struct ZSourceEngine60 * this, struct ZThrowNode193 * Node__1);
#define _ZSourceEngine60_VisitThrowNode
static void VisitTryNode__2qwz(struct ZSourceEngine60 * this, struct ZTryNode196 * Node__1);
#define _ZSourceEngine60_VisitTryNode
static void VisitLetNode__2qwz(struct ZSourceEngine60 * this, struct ZLetNode382 * Node__1);
#define _ZSourceEngine60_VisitLetNode
static void VisitFunctionNode__2qwz(struct ZSourceEngine60 * this, struct ZFunctionNode146 * Node__1);
#define _ZSourceEngine60_VisitFunctionNode
static void VisitClassNode__2qwz(struct ZSourceEngine60 * this, struct ZClassNode518 * Node__1);
#define _ZSourceEngine60_VisitClassNode
static void VisitErrorNode__2qwz(struct ZSourceEngine60 * this, struct ZErrorNode338 * Node__1);
#define _ZSourceEngine60_VisitErrorNode
static void VisitTypeNode__2qwz(struct ZSourceEngine60 * this, struct ZTypeNode236 * Node__1);
static void VisitExtendedNode__2qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1);
#define _ZSourceEngine60_VisitExtendedNode
static void VisitSugarNode__2qwz(struct ZSourceEngine60 * this, struct ZSugarNode167 * Node__1);
#define _ZSourceEngine60_VisitSugarNode
static void WriteTo__2qwz(struct ZSourceEngine60 * this, const char * OutputFile__1);
static struct ZSourceGenerator244 * ZSourceGenerator__3qub(struct ZSourceGenerator244 * this, const char * TargetCode__1, const char * TargetVersion__2);
static void InitBuilderList__1qub(struct ZSourceGenerator244 * this);
#define _ZSourceGenerator244_InitBuilderList
static struct ZSourceEngine60 * GetEngine__1qub(struct ZSourceGenerator244 * this);
#define _ZSourceGenerator244_GetEngine
static struct ZSourceBuilder43 * AppendNewSourceBuilder__1qub(struct ZSourceGenerator244 * this);
static struct ZSourceBuilder43 * InsertNewSourceBuilder__1qub(struct ZSourceGenerator244 * this);
static void SetNativeType__3qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1, const char * TypeName__2);
static const char * GetNativeType__2qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1);
static void SetReservedName__3qub(struct ZSourceGenerator244 * this, const char * Keyword__1, const char * AnotherName__2);
static const char * SafeName__3qub(struct ZSourceGenerator244 * this, const char * Name__1, long Index__2);
static void SetMacro__4qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3);
static void SetMacro__5qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3, struct ZType65 * P1__4);
static void SetMacro__6qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3, struct ZType65 * P1__4, struct ZType65 * P2__5);
static void SetMacro__7qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3, struct ZType65 * P1__4, struct ZType65 * P2__5, struct ZType65 * P3__6);
static void SetConverterMacro__4qub(struct ZSourceGenerator244 * this, const char * Macro__1, struct ZType65 * ReturnType__2, struct ZType65 * P1__3);
static void WriteTo__2qub(struct ZSourceGenerator244 * this, const char * FileName__1);
#define _ZSourceGenerator244_WriteTo
static int StartCodeGeneration__3qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1, int IsInteractive__2);
#define _ZSourceGenerator244_StartCodeGeneration
static void GenerateCode__3qub(struct ZSourceGenerator244 * this, struct ZType65 * ContextType__1, struct ZNode55 * Node__2);
#define _ZSourceGenerator244_GenerateCode
static int IsNeededSurroud__2qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1);
static void GenerateSurroundCode__2qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1);
static void AppendCode__2qub(struct ZSourceGenerator244 * this, const char * RawSource__1);
static void VisitStmtList__2qub(struct ZSourceGenerator244 * this, struct ZBlockNode163 * BlockNode__1);
static void VisitBlockNode__2qub(struct ZSourceGenerator244 * this, struct ZBlockNode163 * Node__1);
#define _ZSourceGenerator244_VisitBlockNode
static void VisitNullNode__2qub(struct ZSourceGenerator244 * this, struct ZNullNode421 * Node__1);
#define _ZSourceGenerator244_VisitNullNode
static void VisitBooleanNode__2qub(struct ZSourceGenerator244 * this, struct ZBooleanNode478 * Node__1);
#define _ZSourceGenerator244_VisitBooleanNode
static void VisitIntNode__2qub(struct ZSourceGenerator244 * this, struct ZIntNode379 * Node__1);
#define _ZSourceGenerator244_VisitIntNode
static void VisitFloatNode__2qub(struct ZSourceGenerator244 * this, struct ZFloatNode346 * Node__1);
#define _ZSourceGenerator244_VisitFloatNode
static void VisitStringNode__2qub(struct ZSourceGenerator244 * this, struct ZStringNode433 * Node__1);
#define _ZSourceGenerator244_VisitStringNode
static void VisitArrayLiteralNode__2qub(struct ZSourceGenerator244 * this, struct ZArrayLiteralNode483 * Node__1);
#define _ZSourceGenerator244_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qub(struct ZSourceGenerator244 * this, struct ZMapLiteralNode401 * Node__1);
#define _ZSourceGenerator244_VisitMapLiteralNode
static void VisitNewObjectNode__2qub(struct ZSourceGenerator244 * this, struct ZNewObjectNode414 * Node__1);
#define _ZSourceGenerator244_VisitNewObjectNode
static void VisitGroupNode__2qub(struct ZSourceGenerator244 * this, struct ZGroupNode366 * Node__1);
#define _ZSourceGenerator244_VisitGroupNode
static void VisitGetIndexNode__2qub(struct ZSourceGenerator244 * this, struct ZGetIndexNode349 * Node__1);
#define _ZSourceGenerator244_VisitGetIndexNode
static void VisitSetIndexNode__2qub(struct ZSourceGenerator244 * this, struct ZSetIndexNode180 * Node__1);
#define _ZSourceGenerator244_VisitSetIndexNode
static void VisitGlobalNameNode__2qub(struct ZSourceGenerator244 * this, struct ZGlobalNameNode362 * Node__1);
#define _ZSourceGenerator244_VisitGlobalNameNode
static void VisitGetNameNode__2qub(struct ZSourceGenerator244 * this, struct ZGetNameNode352 * Node__1);
#define _ZSourceGenerator244_VisitGetNameNode
static void VisitSetNameNode__2qub(struct ZSourceGenerator244 * this, struct ZSetNameNode183 * Node__1);
#define _ZSourceGenerator244_VisitSetNameNode
static void VisitGetterNode__2qub(struct ZSourceGenerator244 * this, struct ZGetterNode357 * Node__1);
#define _ZSourceGenerator244_VisitGetterNode
static void VisitSetterNode__2qub(struct ZSourceGenerator244 * this, struct ZSetterNode186 * Node__1);
#define _ZSourceGenerator244_VisitSetterNode
static void VisitMethodCallNode__2qub(struct ZSourceGenerator244 * this, struct ZMethodCallNode405 * Node__1);
#define _ZSourceGenerator244_VisitMethodCallNode
static void VisitMacroNode__2qub(struct ZSourceGenerator244 * this, struct ZMacroNode394 * Node__1);
#define _ZSourceGenerator244_VisitMacroNode
static void VisitFuncCallNode__2qub(struct ZSourceGenerator244 * this, struct ZFuncCallNode409 * Node__1);
#define _ZSourceGenerator244_VisitFuncCallNode
static void VisitUnaryNode__2qub(struct ZSourceGenerator244 * this, struct ZUnaryNode199 * Node__1);
#define _ZSourceGenerator244_VisitUnaryNode
static void VisitNotNode__2qub(struct ZSourceGenerator244 * this, struct ZNotNode418 * Node__1);
#define _ZSourceGenerator244_VisitNotNode
static void VisitCastNode__2qub(struct ZSourceGenerator244 * this, struct ZCastNode323 * Node__1);
#define _ZSourceGenerator244_VisitCastNode
static void VisitInstanceOfNode__2qub(struct ZSourceGenerator244 * this, struct ZInstanceOfNode375 * Node__1);
#define _ZSourceGenerator244_VisitInstanceOfNode
static void VisitBinaryNode__2qub(struct ZSourceGenerator244 * this, struct ZBinaryNode313 * Node__1);
#define _ZSourceGenerator244_VisitBinaryNode
static void VisitComparatorNode__2qub(struct ZSourceGenerator244 * this, struct ZComparatorNode331 * Node__1);
#define _ZSourceGenerator244_VisitComparatorNode
static void VisitAndNode__2qub(struct ZSourceGenerator244 * this, struct ZAndNode504 * Node__1);
#define _ZSourceGenerator244_VisitAndNode
static void VisitOrNode__2qub(struct ZSourceGenerator244 * this, struct ZOrNode424 * Node__1);
#define _ZSourceGenerator244_VisitOrNode
static void VisitIfNode__2qub(struct ZSourceGenerator244 * this, struct ZIfNode369 * Node__1);
#define _ZSourceGenerator244_VisitIfNode
static void VisitReturnNode__2qub(struct ZSourceGenerator244 * this, struct ZReturnNode172 * Node__1);
#define _ZSourceGenerator244_VisitReturnNode
static void VisitWhileNode__2qub(struct ZSourceGenerator244 * this, struct ZWhileNode202 * Node__1);
#define _ZSourceGenerator244_VisitWhileNode
static void VisitBreakNode__2qub(struct ZSourceGenerator244 * this, struct ZBreakNode320 * Node__1);
#define _ZSourceGenerator244_VisitBreakNode
static void VisitThrowNode__2qub(struct ZSourceGenerator244 * this, struct ZThrowNode193 * Node__1);
#define _ZSourceGenerator244_VisitThrowNode
static void VisitTryNode__2qub(struct ZSourceGenerator244 * this, struct ZTryNode196 * Node__1);
#define _ZSourceGenerator244_VisitTryNode
static void VisitCatchNode__2qub(struct ZSourceGenerator244 * this, struct ZCatchNode327 * Node__1);
static void VisitVarNode__2qub(struct ZSourceGenerator244 * this, struct ZVarNode508 * Node__1);
#define _ZSourceGenerator244_VisitVarNode
static void VisitTypeAnnotation__2qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1);
static void VisitLetNode__2qub(struct ZSourceGenerator244 * this, struct ZLetNode382 * Node__1);
#define _ZSourceGenerator244_VisitLetNode
static void VisitParamNode__2qub(struct ZSourceGenerator244 * this, struct ZParamNode174 * Node__1);
static void VisitFunctionNode__2qub(struct ZSourceGenerator244 * this, struct ZFunctionNode146 * Node__1);
#define _ZSourceGenerator244_VisitFunctionNode
static void VisitClassNode__2qub(struct ZSourceGenerator244 * this, struct ZClassNode518 * Node__1);
#define _ZSourceGenerator244_VisitClassNode
static void VisitErrorNode__2qub(struct ZSourceGenerator244 * this, struct ZErrorNode338 * Node__1);
#define _ZSourceGenerator244_VisitErrorNode
static void VisitExtendedNode__2qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1);
#define _ZSourceGenerator244_VisitExtendedNode
static void VisitSugarNode__2qub(struct ZSourceGenerator244 * this, struct ZSugarNode167 * Node__1);
#define _ZSourceGenerator244_VisitSugarNode
static void GenerateTypeName__2qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1);
static void VisitListNode__5qub(struct ZSourceGenerator244 * this, const char * OpenToken__1, struct ZListNode252 * VargNode__2, const char * DelimToken__3, const char * CloseToken__4);
static void VisitListNode__4qub(struct ZSourceGenerator244 * this, const char * OpenToken__1, struct ZListNode252 * VargNode__2, const char * CloseToken__3);
static struct ZTypeChecker143 * ZTypeChecker__2qr8(struct ZTypeChecker143 * this, struct ZGenerator58 * Generator__1);
static void EnableVisitor__1qr8(struct ZTypeChecker143 * this);
#define _ZTypeChecker143_EnableVisitor
static void StopVisitor__1qr8(struct ZTypeChecker143 * this);
#define _ZTypeChecker143_StopVisitor
static int IsVisitable__1qr8(struct ZTypeChecker143 * this);
#define _ZTypeChecker143_IsVisitable
static struct ZType65 * GetContextType__1qr8(struct ZTypeChecker143 * this);
static struct ZNode55 * VisitTypeChecker__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2);
static struct ZNode55 * CreateStupidCastNode__3qr8(struct ZTypeChecker143 * this, struct ZType65 * Requested__1, struct ZNode55 * Node__2);
static struct ZNode55 * EnforceNodeType__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * EnforceType__2);
static struct ZNode55 * TypeCheckImpl__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2, long TypeCheckPolicy__3);
static struct ZNode55 * VisitTypeChecker__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2, long TypeCheckPolicy__3);
static struct ZNode55 * TryType__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2);
static void TryTypeAt__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, long Index__2, struct ZType65 * ContextType__3);
static struct ZNode55 * CheckType__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2);
static void CheckTypeAt__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, long Index__2, struct ZType65 * ContextType__3);
static int TypeCheckNodeList__2qr8(struct ZTypeChecker143 * this, struct ZListNode252 * List__1);
static void Return__2qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1);
static void TypedNode__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * Type__2);
static void ReturnErrorNode__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZToken78 * ErrorToken__2, const char * Message__3);
static void VisitErrorNode__2qr8(struct ZTypeChecker143 * this, struct ZErrorNode338 * Node__1);
#define _ZTypeChecker143_VisitErrorNode
static void VisitExtendedNode__2qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1);
#define _ZTypeChecker143_VisitExtendedNode
static void VisitSugarNode__2qr8(struct ZTypeChecker143 * this, struct ZSugarNode167 * Node__1);
#define _ZTypeChecker143_VisitSugarNode
static struct CSourceGenerator601 * CSourceGenerator__1qgx(struct CSourceGenerator601 * this);
static struct ZSourceEngine60 * GetEngine__1qgx(struct CSourceGenerator601 * this);
#define _CSourceGenerator601_GetEngine
static void GenerateCode__3qgx(struct CSourceGenerator601 * this, struct ZType65 * ContextType__1, struct ZNode55 * Node__2);
#define _CSourceGenerator601_GenerateCode
static void VisitArrayLiteralNode__2qgx(struct CSourceGenerator601 * this, struct ZArrayLiteralNode483 * Node__1);
#define _CSourceGenerator601_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qgx(struct CSourceGenerator601 * this, struct ZMapLiteralNode401 * Node__1);
#define _CSourceGenerator601_VisitMapLiteralNode
static void VisitNewObjectNode__2qgx(struct CSourceGenerator601 * this, struct ZNewObjectNode414 * Node__1);
#define _CSourceGenerator601_VisitNewObjectNode
static const char * BaseName__2qgx(struct CSourceGenerator601 * this, struct ZType65 * RecvType__1);
static void VisitGetIndexNode__2qgx(struct CSourceGenerator601 * this, struct ZGetIndexNode349 * Node__1);
#define _CSourceGenerator601_VisitGetIndexNode
static void VisitSetIndexNode__2qgx(struct CSourceGenerator601 * this, struct ZSetIndexNode180 * Node__1);
#define _CSourceGenerator601_VisitSetIndexNode
static void VisitGetNameNode__2qgx(struct CSourceGenerator601 * this, struct ZGetNameNode352 * Node__1);
#define _CSourceGenerator601_VisitGetNameNode
static void VisitSetNameNode__2qgx(struct CSourceGenerator601 * this, struct ZSetNameNode183 * Node__1);
#define _CSourceGenerator601_VisitSetNameNode
static void VisitGetterNode__2qgx(struct CSourceGenerator601 * this, struct ZGetterNode357 * Node__1);
#define _CSourceGenerator601_VisitGetterNode
static void VisitSetterNode__2qgx(struct CSourceGenerator601 * this, struct ZSetterNode186 * Node__1);
#define _CSourceGenerator601_VisitSetterNode
static void VisitMethodCallNode__2qgx(struct CSourceGenerator601 * this, struct ZMethodCallNode405 * Node__1);
#define _CSourceGenerator601_VisitMethodCallNode
static void VisitFuncCallNode__2qgx(struct CSourceGenerator601 * this, struct ZFuncCallNode409 * Node__1);
#define _CSourceGenerator601_VisitFuncCallNode
static void VisitThrowNode__2qgx(struct CSourceGenerator601 * this, struct ZThrowNode193 * Node__1);
#define _CSourceGenerator601_VisitThrowNode
static void VisitTryNode__2qgx(struct CSourceGenerator601 * this, struct ZTryNode196 * Node__1);
#define _CSourceGenerator601_VisitTryNode
static void VisitCatchNode__2qgx(struct CSourceGenerator601 * this, struct ZCatchNode327 * Node__1);
static const char * ParamTypeName__2qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1);
static const char * GetNativeType__2qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1);
static void GenerateFuncTypeName__3qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1, const char * FuncName__2);
static void GenerateTypeName__2qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1);
static void VisitVarNode__2qgx(struct CSourceGenerator601 * this, struct ZVarNode508 * Node__1);
#define _CSourceGenerator601_VisitVarNode
static void VisitParamNode__2qgx(struct CSourceGenerator601 * this, struct ZParamNode174 * Node__1);
static void SetMethod__3qgx(struct CSourceGenerator601 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2);
static void VisitInstanceOfNode__2qgx(struct CSourceGenerator601 * this, struct ZInstanceOfNode375 * Node__1);
#define _CSourceGenerator601_VisitInstanceOfNode
static void GenerateCField__3qgx(struct CSourceGenerator601 * this, const char * CType__1, const char * FieldName__2);
static void GenerateField__3qgx(struct CSourceGenerator601 * this, struct ZType65 * DeclType__1, const char * FieldName__2);
static void GenerateFields__3qgx(struct CSourceGenerator601 * this, struct ZClassType81 * ClassType__1, struct ZType65 * ThisType__2);
static void VisitErrorNode__2qgx(struct CSourceGenerator601 * this, struct ZErrorNode338 * Node__1);
#define _CSourceGenerator601_VisitErrorNode
static struct ZAndNode504 * ZAndNode__5qdq(struct ZAndNode504 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4);
static void Accept__2qdq(struct ZAndNode504 * this, struct ZVisitor169 * Visitor__1);
#define _ZAndNode504_Accept
static struct ZArrayLiteralNode483 * ZArrayLiteralNode__2qsf(struct ZArrayLiteralNode483 * this, struct ZNode55 * ParentNode__1);
static void Accept__2qsf(struct ZArrayLiteralNode483 * this, struct ZVisitor169 * Visitor__1);
#define _ZArrayLiteralNode483_Accept
static struct ZBlockNode163 * ZBlockNode__2qtk(struct ZBlockNode163 * this, struct ZNameSpace49 * NameSpace__1);
static struct ZBlockNode163 * ZBlockNode__3qtk(struct ZBlockNode163 * this, struct ZNode55 * ParentNode__1, long Init__2);
static void Accept__2qtk(struct ZBlockNode163 * this, struct ZVisitor169 * Visitor__1);
#define _ZBlockNode163_Accept
static struct ZReturnNode172 * ToReturnNode__1qtk(struct ZBlockNode163 * this);
static long IndexOf__2qtk(struct ZBlockNode163 * this, struct ZNode55 * ChildNode__1);
static void CopyTo__3qtk(struct ZBlockNode163 * this, long Index__1, struct ZBlockNode163 * BlockNode__2);
static struct ZBooleanNode478 * ZBooleanNode__4qs0(struct ZBooleanNode478 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, int Value__3);
static void Accept__2qs0(struct ZBooleanNode478 * this, struct ZVisitor169 * Visitor__1);
#define _ZBooleanNode478_Accept
static struct ZClassNode518 * ZClassNode__2qdd(struct ZClassNode518 * this, struct ZNode55 * ParentNode__1);
static void SetTypeInfo__3qdd(struct ZClassNode518 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZClassNode518_SetTypeInfo
static void SetNameInfo__3qdd(struct ZClassNode518 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZClassNode518_SetNameInfo
static struct ZFieldNode342 * GetFieldNode__2qdd(struct ZClassNode518 * this, long Index__1);
static void Accept__2qdd(struct ZClassNode518 * this, struct ZVisitor169 * Visitor__1);
#define _ZClassNode518_Accept
static struct ZFuncCallNode409 * ZFuncCallNode__3q4s(struct ZFuncCallNode409 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * FuncNode__2);
static struct ZFuncCallNode409 * ZFuncCallNode__4q4s(struct ZFuncCallNode409 * this, struct ZNode55 * ParentNode__1, const char * FuncName__2, struct ZType65 * FuncType__3);
static void Accept__2q4s(struct ZFuncCallNode409 * this, struct ZVisitor169 * Visitor__1);
#define _ZFuncCallNode409_Accept
static struct ZType65 * GetRecvType__1q4s(struct ZFuncCallNode409 * this);
static const char * GetFuncName__1q4s(struct ZFuncCallNode409 * this);
static struct ZFuncType91 * GetFuncType__1q4s(struct ZFuncCallNode409 * this);
static struct ZMacroNode394 * ToMacroNode__2q4s(struct ZFuncCallNode409 * this, struct ZMacroFunc213 * MacroFunc__1);
static struct ZFunctionNode146 * ZFunctionNode__2qte(struct ZFunctionNode146 * this, struct ZNode55 * ParentNode__1);
static void SetTypeInfo__3qte(struct ZFunctionNode146 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZFunctionNode146_SetTypeInfo
static void SetNameInfo__3qte(struct ZFunctionNode146 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZFunctionNode146_SetNameInfo
static void Accept__2qte(struct ZFunctionNode146 * this, struct ZVisitor169 * Visitor__1);
#define _ZFunctionNode146_Accept
static struct ZParamNode174 * GetParamNode__2qte(struct ZFunctionNode146 * this, long Index__1);
static struct ZFuncType91 * GetFuncType__2qte(struct ZFunctionNode146 * this, struct ZType65 * ContextType__1);
static const char * GetSignature__2qte(struct ZFunctionNode146 * this, struct ZGenerator58 * Generator__1);
static struct ZFunctionNode146 * Push__2qte(struct ZFunctionNode146 * this, struct ZFunctionNode146 * Parent__1);
static struct ZFunctionNode146 * Pop__1qte(struct ZFunctionNode146 * this);
static int IsTopLevel__1qte(struct ZFunctionNode146 * this);
static long GetVarIndex__1qte(struct ZFunctionNode146 * this);
static struct ZVarNode508 * ZVarNode__2qdt(struct ZVarNode508 * this, struct ZNode55 * ParentNode__1);
static void SetNameInfo__3qdt(struct ZVarNode508 * this, struct ZToken78 * NameToken__1, const char * Name__2);
#define _ZVarNode508_SetNameInfo
static void SetTypeInfo__3qdt(struct ZVarNode508 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2);
#define _ZVarNode508_SetTypeInfo
static void Accept__2qdt(struct ZVarNode508 * this, struct ZVisitor169 * Visitor__1);
#define _ZVarNode508_Accept
static struct ZNode55 * AndPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * AnnotationPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ApplyPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ArrayLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * AssertPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * AssignPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * BinaryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static int BlockComment__1qwg(struct ZSourceContext52 * SourceContext);
static struct ZNode55 * BlockPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * BreakPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static int CLineComment__1qwg(struct ZSourceContext52 * SourceContext);
static struct ZNode55 * CastPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * CatchPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ClassPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ComparatorPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ExpressionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * FalsePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * FieldPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * FloatLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * FunctionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * GetIndexPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * GetterPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * GroupPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * IfPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * InstanceOfPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * IntLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * LetPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * MapEntryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * MapLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * MethodCallPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * NamePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static int NameToken__1qwg(struct ZSourceContext52 * SourceContext);
static int NewLineToken__1qwg(struct ZSourceContext52 * SourceContext);
static struct ZNode55 * NewObjectPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * NotPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * NullPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static int NumberLiteralToken__1qwg(struct ZSourceContext52 * SourceContext);
static int OperatorToken__1qwg(struct ZSourceContext52 * SourceContext);
static struct ZNode55 * OrPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ParamPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * PrototypePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ReturnPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * RightExpressionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * RightTypePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftTypeNode__2);
static struct ZNode55 * SetIndexPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * SetterPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * StatementEndPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * StatementPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * StringLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static int StringLiteralToken__1qwg(struct ZSourceContext52 * SourceContext);
static struct ZNode55 * SymbolExpressionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * SymbolStatementPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * ThrowPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * TruePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * TryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * TypeAnnotationPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * TypePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * UnaryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * VarPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static struct ZNode55 * WhilePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2);
static int WhiteSpaceToken__1qwg(struct ZSourceContext52 * SourceContext);

struct ZType65 {
	int _classId65;
	int _delta65;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType65 * RefType;
	struct ZType65 * (*)(struct ZType65 *) GetRealType;
	struct ZType65 * (*)(struct ZType65 *) GetSuperType;
	struct ZType65 * (*)(struct ZType65 *) GetBaseType;
	long (*)(struct ZType65 *) GetParamSize;
	struct ZType65 * (*)(struct ZType65 *,long) GetParamType;
	int (*)(struct ZType65 *) IsGreekType;
	struct ZType65 * (*)(struct ZType65 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType65 *,struct ZType65 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType65 *) IsVarType;
	int _nextId;
};

static void _InitZType65(struct ZType65 * o) {
	o->_classId65 = 65;
	o->_delta65 = sizeof(struct ZType65) - sizeof(int);
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
#ifdef _ZType65_GetRealType
	o->GetRealType = GetRealType__1qwn
#endif
#ifdef _ZType65_GetSuperType
	o->GetSuperType = GetSuperType__1qwn
#endif
#ifdef _ZType65_GetBaseType
	o->GetBaseType = GetBaseType__1qwn
#endif
#ifdef _ZType65_GetParamSize
	o->GetParamSize = GetParamSize__1qwn
#endif
#ifdef _ZType65_GetParamType
	o->GetParamType = GetParamType__2qwn
#endif
#ifdef _ZType65_IsGreekType
	o->IsGreekType = IsGreekType__1qwn
#endif
#ifdef _ZType65_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qwn
#endif
#ifdef _ZType65_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qwn
#endif
#ifdef _ZType65_IsVarType
	o->IsVarType = IsVarType__1qwn
#endif
	o->_nextId = 0;
}

static struct ZType65 * _NewZType65(void) {
	struct ZType65 *o = LibZen_Malloc(sizeof(struct ZType65));
	_InitZType65(o);
	return o;
}

struct ZClassField80 {
	int _classId80;
	int _delta80;
	long FieldFlag;
	struct ZClassType81 * ClassType;
	struct ZType65 * FieldType;
	const char * FieldName;
	long FieldNativeIndex;
	struct ZToken78 * SourceToken;
	int _nextId;
};

static void _InitZClassField80(struct ZClassField80 * o) {
	o->_classId80 = 80;
	o->_delta80 = sizeof(struct ZClassField80) - sizeof(int);
	o->FieldFlag = 0;
	o->ClassType = NULL;
	o->FieldType = NULL;
	o->FieldName = NULL;
	o->FieldNativeIndex = 0;
	o->SourceToken = NULL;
	o->_nextId = 0;
}

static struct ZClassField80 * _NewZClassField80(void) {
	struct ZClassField80 *o = LibZen_Malloc(sizeof(struct ZClassField80));
	_InitZClassField80(o);
	return o;
}

struct ZClassType81 {
	int _classId65;
	int _delta65;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType65 * RefType;
	struct ZType65 * (*)(struct ZType65 *) GetRealType;
	struct ZType65 * (*)(struct ZType65 *) GetSuperType;
	struct ZType65 * (*)(struct ZType65 *) GetBaseType;
	long (*)(struct ZType65 *) GetParamSize;
	struct ZType65 * (*)(struct ZType65 *,long) GetParamType;
	int (*)(struct ZType65 *) IsGreekType;
	struct ZType65 * (*)(struct ZType65 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType65 *,struct ZType65 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType65 *) IsVarType;
	int _classId81;
	int _delta81;
	ArrayOfZClassField * FieldList;
	int _nextId;
};

static void _InitZClassType81(struct ZClassType81 * o) {
	_InitZType65((struct ZType65 *)o);
	o->_classId81 = 81;
	o->_delta81 = sizeof(struct ZClassType81) - sizeof(struct ZType65);
	o->FieldList = NULL;
#ifdef _ZClassType81_GetRealType
	o->GetRealType = GetRealType__1qep
#endif
#ifdef _ZClassType81_GetSuperType
	o->GetSuperType = GetSuperType__1qep
#endif
#ifdef _ZClassType81_GetBaseType
	o->GetBaseType = GetBaseType__1qep
#endif
#ifdef _ZClassType81_GetParamSize
	o->GetParamSize = GetParamSize__1qep
#endif
#ifdef _ZClassType81_GetParamType
	o->GetParamType = GetParamType__2qep
#endif
#ifdef _ZClassType81_IsGreekType
	o->IsGreekType = IsGreekType__1qep
#endif
#ifdef _ZClassType81_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qep
#endif
#ifdef _ZClassType81_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qep
#endif
#ifdef _ZClassType81_IsVarType
	o->IsVarType = IsVarType__1qep
#endif
	o->_nextId = 0;
}

static struct ZClassType81 * _NewZClassType81(void) {
	struct ZClassType81 *o = LibZen_Malloc(sizeof(struct ZClassType81));
	_InitZClassType81(o);
	return o;
}

struct ZFunc90 {
	int _classId90;
	int _delta90;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType91 * FuncType;
	int _nextId;
};

static void _InitZFunc90(struct ZFunc90 * o) {
	o->_classId90 = 90;
	o->_delta90 = sizeof(struct ZFunc90) - sizeof(int);
	o->FuncFlag = 0;
	o->FuncName = NULL;
	o->FuncType = NULL;
	o->_nextId = 0;
}

static struct ZFunc90 * _NewZFunc90(void) {
	struct ZFunc90 *o = LibZen_Malloc(sizeof(struct ZFunc90));
	_InitZFunc90(o);
	return o;
}

struct ZFuncType91 {
	int _classId65;
	int _delta65;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType65 * RefType;
	struct ZType65 * (*)(struct ZType65 *) GetRealType;
	struct ZType65 * (*)(struct ZType65 *) GetSuperType;
	struct ZType65 * (*)(struct ZType65 *) GetBaseType;
	long (*)(struct ZType65 *) GetParamSize;
	struct ZType65 * (*)(struct ZType65 *,long) GetParamType;
	int (*)(struct ZType65 *) IsGreekType;
	struct ZType65 * (*)(struct ZType65 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType65 *,struct ZType65 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType65 *) IsVarType;
	int _classId91;
	int _delta91;
	ArrayOfZType * TypeParams;
	int HasUnknownType;
	int HasGreekType;
	int _nextId;
};

static void _InitZFuncType91(struct ZFuncType91 * o) {
	_InitZType65((struct ZType65 *)o);
	o->_classId91 = 91;
	o->_delta91 = sizeof(struct ZFuncType91) - sizeof(struct ZType65);
	o->TypeParams = NULL;
	o->HasUnknownType = 0/*false*/;
	o->HasGreekType = 0/*false*/;
#ifdef _ZFuncType91_GetRealType
	o->GetRealType = GetRealType__1qek
#endif
#ifdef _ZFuncType91_GetSuperType
	o->GetSuperType = GetSuperType__1qek
#endif
#ifdef _ZFuncType91_GetBaseType
	o->GetBaseType = GetBaseType__1qek
#endif
#ifdef _ZFuncType91_GetParamSize
	o->GetParamSize = GetParamSize__1qek
#endif
#ifdef _ZFuncType91_GetParamType
	o->GetParamType = GetParamType__2qek
#endif
#ifdef _ZFuncType91_IsGreekType
	o->IsGreekType = IsGreekType__1qek
#endif
#ifdef _ZFuncType91_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qek
#endif
#ifdef _ZFuncType91_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qek
#endif
#ifdef _ZFuncType91_IsVarType
	o->IsVarType = IsVarType__1qek
#endif
	o->_nextId = 0;
}

static struct ZFuncType91 * _NewZFuncType91(void) {
	struct ZFuncType91 *o = LibZen_Malloc(sizeof(struct ZFuncType91));
	_InitZFuncType91(o);
	return o;
}

struct ZGeneric1Type108 {
	int _classId65;
	int _delta65;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType65 * RefType;
	struct ZType65 * (*)(struct ZType65 *) GetRealType;
	struct ZType65 * (*)(struct ZType65 *) GetSuperType;
	struct ZType65 * (*)(struct ZType65 *) GetBaseType;
	long (*)(struct ZType65 *) GetParamSize;
	struct ZType65 * (*)(struct ZType65 *,long) GetParamType;
	int (*)(struct ZType65 *) IsGreekType;
	struct ZType65 * (*)(struct ZType65 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType65 *,struct ZType65 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType65 *) IsVarType;
	int _classId108;
	int _delta108;
	struct ZType65 * BaseType;
	struct ZType65 * ParamType;
	int _nextId;
};

static void _InitZGeneric1Type108(struct ZGeneric1Type108 * o) {
	_InitZType65((struct ZType65 *)o);
	o->_classId108 = 108;
	o->_delta108 = sizeof(struct ZGeneric1Type108) - sizeof(struct ZType65);
	o->BaseType = NULL;
	o->ParamType = NULL;
#ifdef _ZGeneric1Type108_GetRealType
	o->GetRealType = GetRealType__1qrq
#endif
#ifdef _ZGeneric1Type108_GetSuperType
	o->GetSuperType = GetSuperType__1qrq
#endif
#ifdef _ZGeneric1Type108_GetBaseType
	o->GetBaseType = GetBaseType__1qrq
#endif
#ifdef _ZGeneric1Type108_GetParamSize
	o->GetParamSize = GetParamSize__1qrq
#endif
#ifdef _ZGeneric1Type108_GetParamType
	o->GetParamType = GetParamType__2qrq
#endif
#ifdef _ZGeneric1Type108_IsGreekType
	o->IsGreekType = IsGreekType__1qrq
#endif
#ifdef _ZGeneric1Type108_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qrq
#endif
#ifdef _ZGeneric1Type108_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qrq
#endif
#ifdef _ZGeneric1Type108_IsVarType
	o->IsVarType = IsVarType__1qrq
#endif
	o->_nextId = 0;
}

static struct ZGeneric1Type108 * _NewZGeneric1Type108(void) {
	struct ZGeneric1Type108 *o = LibZen_Malloc(sizeof(struct ZGeneric1Type108));
	_InitZGeneric1Type108(o);
	return o;
}

struct ZGreekType116 {
	int _classId65;
	int _delta65;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType65 * RefType;
	struct ZType65 * (*)(struct ZType65 *) GetRealType;
	struct ZType65 * (*)(struct ZType65 *) GetSuperType;
	struct ZType65 * (*)(struct ZType65 *) GetBaseType;
	long (*)(struct ZType65 *) GetParamSize;
	struct ZType65 * (*)(struct ZType65 *,long) GetParamType;
	int (*)(struct ZType65 *) IsGreekType;
	struct ZType65 * (*)(struct ZType65 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType65 *,struct ZType65 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType65 *) IsVarType;
	int _classId116;
	int _delta116;
	long GreekId;
	int _nextId;
};

static void _InitZGreekType116(struct ZGreekType116 * o) {
	_InitZType65((struct ZType65 *)o);
	o->_classId116 = 116;
	o->_delta116 = sizeof(struct ZGreekType116) - sizeof(struct ZType65);
	o->GreekId = 0;
#ifdef _ZGreekType116_GetRealType
	o->GetRealType = GetRealType__1qro
#endif
#ifdef _ZGreekType116_GetSuperType
	o->GetSuperType = GetSuperType__1qro
#endif
#ifdef _ZGreekType116_GetBaseType
	o->GetBaseType = GetBaseType__1qro
#endif
#ifdef _ZGreekType116_GetParamSize
	o->GetParamSize = GetParamSize__1qro
#endif
#ifdef _ZGreekType116_GetParamType
	o->GetParamType = GetParamType__2qro
#endif
#ifdef _ZGreekType116_IsGreekType
	o->IsGreekType = IsGreekType__1qro
#endif
#ifdef _ZGreekType116_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qro
#endif
#ifdef _ZGreekType116_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qro
#endif
#ifdef _ZGreekType116_IsVarType
	o->IsVarType = IsVarType__1qro
#endif
	o->_nextId = 0;
}

static struct ZGreekType116 * _NewZGreekType116(void) {
	struct ZGreekType116 *o = LibZen_Malloc(sizeof(struct ZGreekType116));
	_InitZGreekType116(o);
	return o;
}

struct ZPrototype122 {
	int _classId90;
	int _delta90;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType91 * FuncType;
	int _classId122;
	int _delta122;
	long DefinedCount;
	long UsedCount;
	int _nextId;
};

static void _InitZPrototype122(struct ZPrototype122 * o) {
	_InitZFunc90((struct ZFunc90 *)o);
	o->_classId122 = 122;
	o->_delta122 = sizeof(struct ZPrototype122) - sizeof(struct ZFunc90);
	o->DefinedCount = 0;
	o->UsedCount = 0;
	o->_nextId = 0;
}

static struct ZPrototype122 * _NewZPrototype122(void) {
	struct ZPrototype122 *o = LibZen_Malloc(sizeof(struct ZPrototype122));
	_InitZPrototype122(o);
	return o;
}

struct ZTypePool675 {
	int _classId675;
	int _delta675;
	int _nextId;
};

static void _InitZTypePool675(struct ZTypePool675 * o) {
	o->_classId675 = 675;
	o->_delta675 = sizeof(struct ZTypePool675) - sizeof(int);
	o->_nextId = 0;
}

static struct ZTypePool675 * _NewZTypePool675(void) {
	struct ZTypePool675 *o = LibZen_Malloc(sizeof(struct ZTypePool675));
	_InitZTypePool675(o);
	return o;
}

struct ZVarScope135 {
	int _classId135;
	int _delta135;
	struct ZVarScope135 * Parent;
	struct ZLogger136 * Logger;
	ArrayOfZVarType * VarList;
	long VarNodeCount;
	long UnresolvedSymbolCount;
	int _nextId;
};

static void _InitZVarScope135(struct ZVarScope135 * o) {
	o->_classId135 = 135;
	o->_delta135 = sizeof(struct ZVarScope135) - sizeof(int);
	o->Parent = NULL;
	o->Logger = NULL;
	o->VarList = NULL;
	o->VarNodeCount = 0;
	o->UnresolvedSymbolCount = 0;
	o->_nextId = 0;
}

static struct ZVarScope135 * _NewZVarScope135(void) {
	struct ZVarScope135 *o = LibZen_Malloc(sizeof(struct ZVarScope135));
	_InitZVarScope135(o);
	return o;
}

struct ZVarType137 {
	int _classId65;
	int _delta65;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType65 * RefType;
	struct ZType65 * (*)(struct ZType65 *) GetRealType;
	struct ZType65 * (*)(struct ZType65 *) GetSuperType;
	struct ZType65 * (*)(struct ZType65 *) GetBaseType;
	long (*)(struct ZType65 *) GetParamSize;
	struct ZType65 * (*)(struct ZType65 *,long) GetParamType;
	int (*)(struct ZType65 *) IsGreekType;
	struct ZType65 * (*)(struct ZType65 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType65 *,struct ZType65 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType65 *) IsVarType;
	int _classId137;
	int _delta137;
	ArrayOfZVarType * VarList;
	struct ZToken78 * SourceToken;
	long GreekId;
	int _nextId;
};

static void _InitZVarType137(struct ZVarType137 * o) {
	_InitZType65((struct ZType65 *)o);
	o->_classId137 = 137;
	o->_delta137 = sizeof(struct ZVarType137) - sizeof(struct ZType65);
	o->VarList = NULL;
	o->SourceToken = NULL;
	o->GreekId = 0;
#ifdef _ZVarType137_GetRealType
	o->GetRealType = GetRealType__1qrn
#endif
#ifdef _ZVarType137_GetSuperType
	o->GetSuperType = GetSuperType__1qrn
#endif
#ifdef _ZVarType137_GetBaseType
	o->GetBaseType = GetBaseType__1qrn
#endif
#ifdef _ZVarType137_GetParamSize
	o->GetParamSize = GetParamSize__1qrn
#endif
#ifdef _ZVarType137_GetParamType
	o->GetParamType = GetParamType__2qrn
#endif
#ifdef _ZVarType137_IsGreekType
	o->IsGreekType = IsGreekType__1qrn
#endif
#ifdef _ZVarType137_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qrn
#endif
#ifdef _ZVarType137_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qrn
#endif
#ifdef _ZVarType137_IsVarType
	o->IsVarType = IsVarType__1qrn
#endif
	o->_nextId = 0;
}

static struct ZVarType137 * _NewZVarType137(void) {
	struct ZVarType137 *o = LibZen_Malloc(sizeof(struct ZVarType137));
	_InitZVarType137(o);
	return o;
}

struct ZNode55 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _nextId;
};

static void _InitZNode55(struct ZNode55 * o) {
	o->_classId55 = 55;
	o->_delta55 = sizeof(struct ZNode55) - sizeof(int);
	o->ParentNode = NULL;
	o->SourceToken = NULL;
	o->AST = NULL;
	o->Type = /*untyped*/NULL;
	o->HasUntypedNode = 1/*true*/;
	o->SetNameInfo = NULL;
	o->SetTypeInfo = NULL;
	o->IsBreakingBlock = NULL;
	o->DeSugar = NULL;
	o->Accept = NULL;
#ifdef _ZNode55_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qwk
#endif
#ifdef _ZNode55_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qwk
#endif
#ifdef _ZNode55_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qwk
#endif
#ifdef _ZNode55_DeSugar
	o->DeSugar = DeSugar__2qwk
#endif
#ifdef _ZNode55_Accept
	o->Accept = Accept__2qwk
#endif
	o->_nextId = 0;
}

static struct ZNode55 * _NewZNode55(void) {
	struct ZNode55 *o = LibZen_Malloc(sizeof(struct ZNode55));
	_InitZNode55(o);
	return o;
}

struct ZParamNode174 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId174;
	int _delta174;
	const char * Name;
	struct ZToken78 * NameToken;
	long ParamIndex;
	int _nextId;
};

static void _InitZParamNode174(struct ZParamNode174 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId174 = 174;
	o->_delta174 = sizeof(struct ZParamNode174) - sizeof(struct ZNode55);
	o->Name = NULL;
	o->NameToken = NULL;
	o->ParamIndex = 0;
#ifdef _ZParamNode174_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtm
#endif
#ifdef _ZParamNode174_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtm
#endif
#ifdef _ZParamNode174_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtm
#endif
#ifdef _ZParamNode174_DeSugar
	o->DeSugar = DeSugar__2qtm
#endif
#ifdef _ZParamNode174_Accept
	o->Accept = Accept__2qtm
#endif
	o->_nextId = 0;
}

static struct ZParamNode174 * _NewZParamNode174(void) {
	struct ZParamNode174 *o = LibZen_Malloc(sizeof(struct ZParamNode174));
	_InitZParamNode174(o);
	return o;
}

struct ZReturnNode172 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId172;
	int _delta172;
	int _nextId;
};

static void _InitZReturnNode172(struct ZReturnNode172 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId172 = 172;
	o->_delta172 = sizeof(struct ZReturnNode172) - sizeof(struct ZNode55);
#ifdef _ZReturnNode172_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtb
#endif
#ifdef _ZReturnNode172_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtb
#endif
#ifdef _ZReturnNode172_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtb
#endif
#ifdef _ZReturnNode172_DeSugar
	o->DeSugar = DeSugar__2qtb
#endif
#ifdef _ZReturnNode172_Accept
	o->Accept = Accept__2qtb
#endif
	o->_nextId = 0;
}

static struct ZReturnNode172 * _NewZReturnNode172(void) {
	struct ZReturnNode172 *o = LibZen_Malloc(sizeof(struct ZReturnNode172));
	_InitZReturnNode172(o);
	return o;
}

struct ZSetIndexNode180 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId180;
	int _delta180;
	int _nextId;
};

static void _InitZSetIndexNode180(struct ZSetIndexNode180 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId180 = 180;
	o->_delta180 = sizeof(struct ZSetIndexNode180) - sizeof(struct ZNode55);
#ifdef _ZSetIndexNode180_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyq
#endif
#ifdef _ZSetIndexNode180_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyq
#endif
#ifdef _ZSetIndexNode180_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyq
#endif
#ifdef _ZSetIndexNode180_DeSugar
	o->DeSugar = DeSugar__2qyq
#endif
#ifdef _ZSetIndexNode180_Accept
	o->Accept = Accept__2qyq
#endif
	o->_nextId = 0;
}

static struct ZSetIndexNode180 * _NewZSetIndexNode180(void) {
	struct ZSetIndexNode180 *o = LibZen_Malloc(sizeof(struct ZSetIndexNode180));
	_InitZSetIndexNode180(o);
	return o;
}

struct ZSetNameNode183 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId183;
	int _delta183;
	const char * VarName;
	long VarIndex;
	int IsCaptured;
	int _nextId;
};

static void _InitZSetNameNode183(struct ZSetNameNode183 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId183 = 183;
	o->_delta183 = sizeof(struct ZSetNameNode183) - sizeof(struct ZNode55);
	o->VarName = NULL;
	o->VarIndex = 0;
	o->IsCaptured = 0/*false*/;
#ifdef _ZSetNameNode183_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyr
#endif
#ifdef _ZSetNameNode183_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyr
#endif
#ifdef _ZSetNameNode183_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyr
#endif
#ifdef _ZSetNameNode183_DeSugar
	o->DeSugar = DeSugar__2qyr
#endif
#ifdef _ZSetNameNode183_Accept
	o->Accept = Accept__2qyr
#endif
	o->_nextId = 0;
}

static struct ZSetNameNode183 * _NewZSetNameNode183(void) {
	struct ZSetNameNode183 *o = LibZen_Malloc(sizeof(struct ZSetNameNode183));
	_InitZSetNameNode183(o);
	return o;
}

struct ZSetterNode186 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId186;
	int _delta186;
	const char * FieldName;
	struct ZToken78 * NameToken;
	int _nextId;
};

static void _InitZSetterNode186(struct ZSetterNode186 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId186 = 186;
	o->_delta186 = sizeof(struct ZSetterNode186) - sizeof(struct ZNode55);
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZSetterNode186_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyu
#endif
#ifdef _ZSetterNode186_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyu
#endif
#ifdef _ZSetterNode186_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyu
#endif
#ifdef _ZSetterNode186_DeSugar
	o->DeSugar = DeSugar__2qyu
#endif
#ifdef _ZSetterNode186_Accept
	o->Accept = Accept__2qyu
#endif
	o->_nextId = 0;
}

static struct ZSetterNode186 * _NewZSetterNode186(void) {
	struct ZSetterNode186 *o = LibZen_Malloc(sizeof(struct ZSetterNode186));
	_InitZSetterNode186(o);
	return o;
}

struct ZSugarNode167 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId167;
	int _delta167;
	struct ZNode55 * SugarNode;
	int _nextId;
};

static void _InitZSugarNode167(struct ZSugarNode167 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId167 = 167;
	o->_delta167 = sizeof(struct ZSugarNode167) - sizeof(struct ZNode55);
	o->SugarNode = NULL;
#ifdef _ZSugarNode167_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qt6
#endif
#ifdef _ZSugarNode167_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qt6
#endif
#ifdef _ZSugarNode167_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qt6
#endif
#ifdef _ZSugarNode167_DeSugar
	o->DeSugar = DeSugar__2qt6
#endif
#ifdef _ZSugarNode167_Accept
	o->Accept = Accept__2qt6
#endif
	o->_nextId = 0;
}

static struct ZSugarNode167 * _NewZSugarNode167(void) {
	struct ZSugarNode167 *o = LibZen_Malloc(sizeof(struct ZSugarNode167));
	_InitZSugarNode167(o);
	return o;
}

struct ZThrowNode193 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId193;
	int _delta193;
	int _nextId;
};

static void _InitZThrowNode193(struct ZThrowNode193 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId193 = 193;
	o->_delta193 = sizeof(struct ZThrowNode193) - sizeof(struct ZNode55);
#ifdef _ZThrowNode193_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qys
#endif
#ifdef _ZThrowNode193_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qys
#endif
#ifdef _ZThrowNode193_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qys
#endif
#ifdef _ZThrowNode193_DeSugar
	o->DeSugar = DeSugar__2qys
#endif
#ifdef _ZThrowNode193_Accept
	o->Accept = Accept__2qys
#endif
	o->_nextId = 0;
}

static struct ZThrowNode193 * _NewZThrowNode193(void) {
	struct ZThrowNode193 *o = LibZen_Malloc(sizeof(struct ZThrowNode193));
	_InitZThrowNode193(o);
	return o;
}

struct ZTryNode196 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId196;
	int _delta196;
	int _nextId;
};

static void _InitZTryNode196(struct ZTryNode196 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId196 = 196;
	o->_delta196 = sizeof(struct ZTryNode196) - sizeof(struct ZNode55);
#ifdef _ZTryNode196_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyg
#endif
#ifdef _ZTryNode196_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyg
#endif
#ifdef _ZTryNode196_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyg
#endif
#ifdef _ZTryNode196_DeSugar
	o->DeSugar = DeSugar__2qyg
#endif
#ifdef _ZTryNode196_Accept
	o->Accept = Accept__2qyg
#endif
	o->_nextId = 0;
}

static struct ZTryNode196 * _NewZTryNode196(void) {
	struct ZTryNode196 *o = LibZen_Malloc(sizeof(struct ZTryNode196));
	_InitZTryNode196(o);
	return o;
}

struct ZUnaryNode199 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId199;
	int _delta199;
	int _nextId;
};

static void _InitZUnaryNode199(struct ZUnaryNode199 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId199 = 199;
	o->_delta199 = sizeof(struct ZUnaryNode199) - sizeof(struct ZNode55);
#ifdef _ZUnaryNode199_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyk
#endif
#ifdef _ZUnaryNode199_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyk
#endif
#ifdef _ZUnaryNode199_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyk
#endif
#ifdef _ZUnaryNode199_DeSugar
	o->DeSugar = DeSugar__2qyk
#endif
#ifdef _ZUnaryNode199_Accept
	o->Accept = Accept__2qyk
#endif
	o->_nextId = 0;
}

static struct ZUnaryNode199 * _NewZUnaryNode199(void) {
	struct ZUnaryNode199 *o = LibZen_Malloc(sizeof(struct ZUnaryNode199));
	_InitZUnaryNode199(o);
	return o;
}

struct ZWhileNode202 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId202;
	int _delta202;
	int _nextId;
};

static void _InitZWhileNode202(struct ZWhileNode202 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId202 = 202;
	o->_delta202 = sizeof(struct ZWhileNode202) - sizeof(struct ZNode55);
#ifdef _ZWhileNode202_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qy1
#endif
#ifdef _ZWhileNode202_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qy1
#endif
#ifdef _ZWhileNode202_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qy1
#endif
#ifdef _ZWhileNode202_DeSugar
	o->DeSugar = DeSugar__2qy1
#endif
#ifdef _ZWhileNode202_Accept
	o->Accept = Accept__2qy1
#endif
	o->_nextId = 0;
}

static struct ZWhileNode202 * _NewZWhileNode202(void) {
	struct ZWhileNode202 *o = LibZen_Malloc(sizeof(struct ZWhileNode202));
	_InitZWhileNode202(o);
	return o;
}

struct ZEmptyValue205 {
	int _classId205;
	int _delta205;
	int _nextId;
};

static void _InitZEmptyValue205(struct ZEmptyValue205 * o) {
	o->_classId205 = 205;
	o->_delta205 = sizeof(struct ZEmptyValue205) - sizeof(int);
	o->_nextId = 0;
}

static struct ZEmptyValue205 * _NewZEmptyValue205(void) {
	struct ZEmptyValue205 *o = LibZen_Malloc(sizeof(struct ZEmptyValue205));
	_InitZEmptyValue205(o);
	return o;
}

struct ZLogger136 {
	int _classId136;
	int _delta136;
	ArrayOfString * ReportedErrorList;
	int _nextId;
};

static void _InitZLogger136(struct ZLogger136 * o) {
	o->_classId136 = 136;
	o->_delta136 = sizeof(struct ZLogger136) - sizeof(int);
	o->ReportedErrorList = LibZen_NewStringArray(0);
	o->_nextId = 0;
}

static struct ZLogger136 * _NewZLogger136(void) {
	struct ZLogger136 *o = LibZen_Malloc(sizeof(struct ZLogger136));
	_InitZLogger136(o);
	return o;
}

struct ZMacroFunc213 {
	int _classId90;
	int _delta90;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType91 * FuncType;
	int _classId213;
	int _delta213;
	int _nextId;
};

static void _InitZMacroFunc213(struct ZMacroFunc213 * o) {
	_InitZFunc90((struct ZFunc90 *)o);
	o->_classId213 = 213;
	o->_delta213 = sizeof(struct ZMacroFunc213) - sizeof(struct ZFunc90);
	o->_nextId = 0;
}

static struct ZMacroFunc213 * _NewZMacroFunc213(void) {
	struct ZMacroFunc213 *o = LibZen_Malloc(sizeof(struct ZMacroFunc213));
	_InitZMacroFunc213(o);
	return o;
}

struct ZNameSpace49 {
	int _classId49;
	int _delta49;
	struct ZNameSpace49 * ParentNameSpace;
	struct ZGenerator58 * Generator;
	long SerialId;
	ArrayOfZTokenFunc * TokenMatrix;
	MapOfZSyntax * SyntaxTable;
	MapOfZSymbolEntry * SymbolTable;
	int _nextId;
};

static void _InitZNameSpace49(struct ZNameSpace49 * o) {
	o->_classId49 = 49;
	o->_delta49 = sizeof(struct ZNameSpace49) - sizeof(int);
	o->ParentNameSpace = NULL;
	o->Generator = NULL;
	o->SerialId = 0;
	o->TokenMatrix = NULL;
	o->SyntaxTable = NULL;
	o->SymbolTable = NULL;
	o->_nextId = 0;
}

static struct ZNameSpace49 * _NewZNameSpace49(void) {
	struct ZNameSpace49 *o = LibZen_Malloc(sizeof(struct ZNameSpace49));
	_InitZNameSpace49(o);
	return o;
}

struct ZParserConst678 {
	int _classId678;
	int _delta678;
	int _nextId;
};

static void _InitZParserConst678(struct ZParserConst678 * o) {
	o->_classId678 = 678;
	o->_delta678 = sizeof(struct ZParserConst678) - sizeof(int);
	o->_nextId = 0;
}

static struct ZParserConst678 * _NewZParserConst678(void) {
	struct ZParserConst678 *o = LibZen_Malloc(sizeof(struct ZParserConst678));
	_InitZParserConst678(o);
	return o;
}

struct ZSource239 {
	int _classId239;
	int _delta239;
	struct ZTokenContext56 * TokenContext;
	struct ZLogger136 * Logger;
	const char * FileName;
	long LineNumber;
	const char * SourceText;
	int _nextId;
};

static void _InitZSource239(struct ZSource239 * o) {
	o->_classId239 = 239;
	o->_delta239 = sizeof(struct ZSource239) - sizeof(int);
	o->TokenContext = NULL;
	o->Logger = NULL;
	o->FileName = NULL;
	o->LineNumber = 0;
	o->SourceText = NULL;
	o->_nextId = 0;
}

static struct ZSource239 * _NewZSource239(void) {
	struct ZSource239 *o = LibZen_Malloc(sizeof(struct ZSource239));
	_InitZSource239(o);
	return o;
}

struct ZSourceBuilder43 {
	int _classId43;
	int _delta43;
	struct ZSourceGenerator244 * Template;
	ArrayOfString * SourceList;
	struct ZSourceBuilder43 * Parent;
	long IndentLevel;
	const char * CurrentIndentString;
	const char * BufferedLineComment;
	int _nextId;
};

static void _InitZSourceBuilder43(struct ZSourceBuilder43 * o) {
	o->_classId43 = 43;
	o->_delta43 = sizeof(struct ZSourceBuilder43) - sizeof(int);
	o->Template = NULL;
	o->SourceList = LibZen_NewStringArray(0);
	o->Parent = NULL;
	o->IndentLevel = 0;
	o->CurrentIndentString = "";
	o->BufferedLineComment = "";
	o->_nextId = 0;
}

static struct ZSourceBuilder43 * _NewZSourceBuilder43(void) {
	struct ZSourceBuilder43 *o = LibZen_Malloc(sizeof(struct ZSourceBuilder43));
	_InitZSourceBuilder43(o);
	return o;
}

struct ZSourceContext52 {
	int _classId239;
	int _delta239;
	struct ZTokenContext56 * TokenContext;
	struct ZLogger136 * Logger;
	const char * FileName;
	long LineNumber;
	const char * SourceText;
	int _classId52;
	int _delta52;
	long SourcePosition;
	int _nextId;
};

static void _InitZSourceContext52(struct ZSourceContext52 * o) {
	_InitZSource239((struct ZSource239 *)o);
	o->_classId52 = 52;
	o->_delta52 = sizeof(struct ZSourceContext52) - sizeof(struct ZSource239);
	o->SourcePosition = 0;
	o->_nextId = 0;
}

static struct ZSourceContext52 * _NewZSourceContext52(void) {
	struct ZSourceContext52 *o = LibZen_Malloc(sizeof(struct ZSourceContext52));
	_InitZSourceContext52(o);
	return o;
}

struct ZSourceMacro266 {
	int _classId90;
	int _delta90;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType91 * FuncType;
	int _classId213;
	int _delta213;
	int _classId266;
	int _delta266;
	const char * Macro;
	int _nextId;
};

static void _InitZSourceMacro266(struct ZSourceMacro266 * o) {
	_InitZMacroFunc213((struct ZMacroFunc213 *)o);
	o->_classId266 = 266;
	o->_delta266 = sizeof(struct ZSourceMacro266) - sizeof(struct ZMacroFunc213);
	o->Macro = NULL;
	o->_nextId = 0;
}

static struct ZSourceMacro266 * _NewZSourceMacro266(void) {
	struct ZSourceMacro266 *o = LibZen_Malloc(sizeof(struct ZSourceMacro266));
	_InitZSourceMacro266(o);
	return o;
}

struct ZSymbolEntry226 {
	int _classId226;
	int _delta226;
	struct ZSymbolEntry226 * Parent;
	struct ZNode55 * Node;
	int IsDisabled;
	int _nextId;
};

static void _InitZSymbolEntry226(struct ZSymbolEntry226 * o) {
	o->_classId226 = 226;
	o->_delta226 = sizeof(struct ZSymbolEntry226) - sizeof(int);
	o->Parent = NULL;
	o->Node = NULL;
	o->IsDisabled = 0/*false*/;
	o->_nextId = 0;
}

static struct ZSymbolEntry226 * _NewZSymbolEntry226(void) {
	struct ZSymbolEntry226 *o = LibZen_Malloc(sizeof(struct ZSymbolEntry226));
	_InitZSymbolEntry226(o);
	return o;
}

struct ZSyntax221 {
	int _classId221;
	int _delta221;
	struct ZNameSpace49 * PackageNameSpace;
	const char * PatternName;
	struct ZMatchFunction54 * MatchFunc;
	long SyntaxFlag;
	struct ZSyntax221 * ParentPattern;
	int IsDisabled;
	int IsStatement;
	int _nextId;
};

static void _InitZSyntax221(struct ZSyntax221 * o) {
	o->_classId221 = 221;
	o->_delta221 = sizeof(struct ZSyntax221) - sizeof(int);
	o->PackageNameSpace = NULL;
	o->PatternName = NULL;
	o->MatchFunc = NULL;
	o->SyntaxFlag = 0;
	o->ParentPattern = NULL;
	o->IsDisabled = 0/*false*/;
	o->IsStatement = 0/*false*/;
	o->_nextId = 0;
}

static struct ZSyntax221 * _NewZSyntax221(void) {
	struct ZSyntax221 *o = LibZen_Malloc(sizeof(struct ZSyntax221));
	_InitZSyntax221(o);
	return o;
}

struct ZToken78 {
	int _classId78;
	int _delta78;
	struct ZSource239 * Source;
	long StartIndex;
	long EndIndex;
	int _nextId;
};

static void _InitZToken78(struct ZToken78 * o) {
	o->_classId78 = 78;
	o->_delta78 = sizeof(struct ZToken78) - sizeof(int);
	o->Source = NULL;
	o->StartIndex = 0;
	o->EndIndex = 0;
	o->_nextId = 0;
}

static struct ZToken78 * _NewZToken78(void) {
	struct ZToken78 *o = LibZen_Malloc(sizeof(struct ZToken78));
	_InitZToken78(o);
	return o;
}

struct ZTokenContext56 {
	int _classId56;
	int _delta56;
	struct ZGenerator58 * Generator;
	struct ZNameSpace49 * NameSpace;
	struct ZSourceContext52 * Source;
	ArrayOfZToken * TokenList;
	long CurrentPosition;
	int IsAllowSkipIndent;
	struct ZToken78 * LatestToken;
	struct ZSyntax221 * ApplyingPattern;
	int _nextId;
};

static void _InitZTokenContext56(struct ZTokenContext56 * o) {
	o->_classId56 = 56;
	o->_delta56 = sizeof(struct ZTokenContext56) - sizeof(int);
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

static struct ZTokenContext56 * _NewZTokenContext56(void) {
	struct ZTokenContext56 *o = LibZen_Malloc(sizeof(struct ZTokenContext56));
	_InitZTokenContext56(o);
	return o;
}

struct ZTokenFunc36 {
	int _classId36;
	int _delta36;
	struct ZTokenFunction51 * Func;
	struct ZTokenFunc36 * ParentFunc;
	int _nextId;
};

static void _InitZTokenFunc36(struct ZTokenFunc36 * o) {
	o->_classId36 = 36;
	o->_delta36 = sizeof(struct ZTokenFunc36) - sizeof(int);
	o->Func = NULL;
	o->ParentFunc = NULL;
	o->_nextId = 0;
}

static struct ZTokenFunc36 * _NewZTokenFunc36(void) {
	struct ZTokenFunc36 *o = LibZen_Malloc(sizeof(struct ZTokenFunc36));
	_InitZTokenFunc36(o);
	return o;
}

struct ZVariable231 {
	int _classId226;
	int _delta226;
	struct ZSymbolEntry226 * Parent;
	struct ZNode55 * Node;
	int IsDisabled;
	int _classId231;
	int _delta231;
	long VarFlag;
	struct ZType65 * VarType;
	const char * VarName;
	long VarUniqueIndex;
	struct ZToken78 * SourceToken;
	long DefCount;
	long UsedCount;
	int _nextId;
};

static void _InitZVariable231(struct ZVariable231 * o) {
	_InitZSymbolEntry226((struct ZSymbolEntry226 *)o);
	o->_classId231 = 231;
	o->_delta231 = sizeof(struct ZVariable231) - sizeof(struct ZSymbolEntry226);
	o->VarFlag = 0;
	o->VarType = NULL;
	o->VarName = NULL;
	o->VarUniqueIndex = 0;
	o->SourceToken = NULL;
	o->DefCount = 0;
	o->UsedCount = 0;
	o->_nextId = 0;
}

static struct ZVariable231 * _NewZVariable231(void) {
	struct ZVariable231 *o = LibZen_Malloc(sizeof(struct ZVariable231));
	_InitZVariable231(o);
	return o;
}

struct ZVisitor169 {
	int _classId169;
	int _delta169;
	void (*)(struct ZVisitor169 *,struct ZNullNode421 *) VisitNullNode;
	void (*)(struct ZVisitor169 *,struct ZBooleanNode478 *) VisitBooleanNode;
	void (*)(struct ZVisitor169 *,struct ZIntNode379 *) VisitIntNode;
	void (*)(struct ZVisitor169 *,struct ZFloatNode346 *) VisitFloatNode;
	void (*)(struct ZVisitor169 *,struct ZStringNode433 *) VisitStringNode;
	void (*)(struct ZVisitor169 *,struct ZArrayLiteralNode483 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZMapLiteralNode401 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZNewObjectNode414 *) VisitNewObjectNode;
	void (*)(struct ZVisitor169 *,struct ZGlobalNameNode362 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor169 *,struct ZGetNameNode352 *) VisitGetNameNode;
	void (*)(struct ZVisitor169 *,struct ZSetNameNode183 *) VisitSetNameNode;
	void (*)(struct ZVisitor169 *,struct ZGroupNode366 *) VisitGroupNode;
	void (*)(struct ZVisitor169 *,struct ZGetterNode357 *) VisitGetterNode;
	void (*)(struct ZVisitor169 *,struct ZSetterNode186 *) VisitSetterNode;
	void (*)(struct ZVisitor169 *,struct ZGetIndexNode349 *) VisitGetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZSetIndexNode180 *) VisitSetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZMethodCallNode405 *) VisitMethodCallNode;
	void (*)(struct ZVisitor169 *,struct ZFuncCallNode409 *) VisitFuncCallNode;
	void (*)(struct ZVisitor169 *,struct ZMacroNode394 *) VisitMacroNode;
	void (*)(struct ZVisitor169 *,struct ZUnaryNode199 *) VisitUnaryNode;
	void (*)(struct ZVisitor169 *,struct ZNotNode418 *) VisitNotNode;
	void (*)(struct ZVisitor169 *,struct ZCastNode323 *) VisitCastNode;
	void (*)(struct ZVisitor169 *,struct ZInstanceOfNode375 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor169 *,struct ZBinaryNode313 *) VisitBinaryNode;
	void (*)(struct ZVisitor169 *,struct ZComparatorNode331 *) VisitComparatorNode;
	void (*)(struct ZVisitor169 *,struct ZAndNode504 *) VisitAndNode;
	void (*)(struct ZVisitor169 *,struct ZOrNode424 *) VisitOrNode;
	void (*)(struct ZVisitor169 *,struct ZBlockNode163 *) VisitBlockNode;
	void (*)(struct ZVisitor169 *,struct ZVarNode508 *) VisitVarNode;
	void (*)(struct ZVisitor169 *,struct ZIfNode369 *) VisitIfNode;
	void (*)(struct ZVisitor169 *,struct ZReturnNode172 *) VisitReturnNode;
	void (*)(struct ZVisitor169 *,struct ZWhileNode202 *) VisitWhileNode;
	void (*)(struct ZVisitor169 *,struct ZBreakNode320 *) VisitBreakNode;
	void (*)(struct ZVisitor169 *,struct ZThrowNode193 *) VisitThrowNode;
	void (*)(struct ZVisitor169 *,struct ZTryNode196 *) VisitTryNode;
	void (*)(struct ZVisitor169 *,struct ZLetNode382 *) VisitLetNode;
	void (*)(struct ZVisitor169 *,struct ZFunctionNode146 *) VisitFunctionNode;
	void (*)(struct ZVisitor169 *,struct ZClassNode518 *) VisitClassNode;
	void (*)(struct ZVisitor169 *,struct ZErrorNode338 *) VisitErrorNode;
	void (*)(struct ZVisitor169 *,struct ZNode55 *) VisitExtendedNode;
	void (*)(struct ZVisitor169 *,struct ZSugarNode167 *) VisitSugarNode;
	void (*)(struct ZVisitor169 *) EnableVisitor;
	void (*)(struct ZVisitor169 *) StopVisitor;
	int (*)(struct ZVisitor169 *) IsVisitable;
	int _nextId;
};

static void _InitZVisitor169(struct ZVisitor169 * o) {
	o->_classId169 = 169;
	o->_delta169 = sizeof(struct ZVisitor169) - sizeof(int);
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
#ifdef _ZVisitor169_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qtx
#endif
#ifdef _ZVisitor169_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qtx
#endif
#ifdef _ZVisitor169_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qtx
#endif
#ifdef _ZVisitor169_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qtx
#endif
#ifdef _ZVisitor169_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qtx
#endif
#ifdef _ZVisitor169_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qtx
#endif
#ifdef _ZVisitor169_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qtx
#endif
#ifdef _ZVisitor169_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qtx
#endif
#ifdef _ZVisitor169_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qtx
#endif
#ifdef _ZVisitor169_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qtx
#endif
#ifdef _ZVisitor169_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qtx
#endif
#ifdef _ZVisitor169_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qtx
#endif
#ifdef _ZVisitor169_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qtx
#endif
#ifdef _ZVisitor169_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qtx
#endif
#ifdef _ZVisitor169_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qtx
#endif
#ifdef _ZVisitor169_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qtx
#endif
#ifdef _ZVisitor169_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qtx
#endif
#ifdef _ZVisitor169_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qtx
#endif
#ifdef _ZVisitor169_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qtx
#endif
#ifdef _ZVisitor169_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qtx
#endif
#ifdef _ZVisitor169_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qtx
#endif
#ifdef _ZVisitor169_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qtx
#endif
#ifdef _ZVisitor169_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qtx
#endif
#ifdef _ZVisitor169_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qtx
#endif
#ifdef _ZVisitor169_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qtx
#endif
#ifdef _ZVisitor169_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qtx
#endif
#ifdef _ZVisitor169_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qtx
#endif
#ifdef _ZVisitor169_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qtx
#endif
#ifdef _ZVisitor169_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qtx
#endif
#ifdef _ZVisitor169_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qtx
#endif
#ifdef _ZVisitor169_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qtx
#endif
#ifdef _ZVisitor169_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qtx
#endif
#ifdef _ZVisitor169_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qtx
#endif
#ifdef _ZVisitor169_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qtx
#endif
#ifdef _ZVisitor169_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qtx
#endif
#ifdef _ZVisitor169_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qtx
#endif
#ifdef _ZVisitor169_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qtx
#endif
#ifdef _ZVisitor169_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qtx
#endif
#ifdef _ZVisitor169_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qtx
#endif
#ifdef _ZVisitor169_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qtx
#endif
#ifdef _ZVisitor169_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qtx
#endif
#ifdef _ZVisitor169_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qtx
#endif
#ifdef _ZVisitor169_StopVisitor
	o->StopVisitor = StopVisitor__1qtx
#endif
#ifdef _ZVisitor169_IsVisitable
	o->IsVisitable = IsVisitable__1qtx
#endif
	o->_nextId = 0;
}

static struct ZVisitor169 * _NewZVisitor169(void) {
	struct ZVisitor169 *o = LibZen_Malloc(sizeof(struct ZVisitor169));
	_InitZVisitor169(o);
	return o;
}

struct ZArrayType302 {
	int _classId65;
	int _delta65;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType65 * RefType;
	struct ZType65 * (*)(struct ZType65 *) GetRealType;
	struct ZType65 * (*)(struct ZType65 *) GetSuperType;
	struct ZType65 * (*)(struct ZType65 *) GetBaseType;
	long (*)(struct ZType65 *) GetParamSize;
	struct ZType65 * (*)(struct ZType65 *,long) GetParamType;
	int (*)(struct ZType65 *) IsGreekType;
	struct ZType65 * (*)(struct ZType65 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType65 *,struct ZType65 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType65 *) IsVarType;
	int _classId108;
	int _delta108;
	struct ZType65 * BaseType;
	struct ZType65 * ParamType;
	int _classId302;
	int _delta302;
	int _nextId;
};

static void _InitZArrayType302(struct ZArrayType302 * o) {
	_InitZGeneric1Type108((struct ZGeneric1Type108 *)o);
	o->_classId302 = 302;
	o->_delta302 = sizeof(struct ZArrayType302) - sizeof(struct ZGeneric1Type108);
#ifdef _ZArrayType302_GetRealType
	o->GetRealType = GetRealType__1qod
#endif
#ifdef _ZArrayType302_GetSuperType
	o->GetSuperType = GetSuperType__1qod
#endif
#ifdef _ZArrayType302_GetBaseType
	o->GetBaseType = GetBaseType__1qod
#endif
#ifdef _ZArrayType302_GetParamSize
	o->GetParamSize = GetParamSize__1qod
#endif
#ifdef _ZArrayType302_GetParamType
	o->GetParamType = GetParamType__2qod
#endif
#ifdef _ZArrayType302_IsGreekType
	o->IsGreekType = IsGreekType__1qod
#endif
#ifdef _ZArrayType302_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qod
#endif
#ifdef _ZArrayType302_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qod
#endif
#ifdef _ZArrayType302_IsVarType
	o->IsVarType = IsVarType__1qod
#endif
	o->_nextId = 0;
}

static struct ZArrayType302 * _NewZArrayType302(void) {
	struct ZArrayType302 *o = LibZen_Malloc(sizeof(struct ZArrayType302));
	_InitZArrayType302(o);
	return o;
}

struct ZAnnotationNode304 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId304;
	int _delta304;
	struct ZNode55 * AnnotatedNode;
	int _nextId;
};

static void _InitZAnnotationNode304(struct ZAnnotationNode304 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId304 = 304;
	o->_delta304 = sizeof(struct ZAnnotationNode304) - sizeof(struct ZNode55);
	o->AnnotatedNode = NULL;
#ifdef _ZAnnotationNode304_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qog
#endif
#ifdef _ZAnnotationNode304_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qog
#endif
#ifdef _ZAnnotationNode304_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qog
#endif
#ifdef _ZAnnotationNode304_DeSugar
	o->DeSugar = DeSugar__2qog
#endif
#ifdef _ZAnnotationNode304_Accept
	o->Accept = Accept__2qog
#endif
	o->_nextId = 0;
}

static struct ZAnnotationNode304 * _NewZAnnotationNode304(void) {
	struct ZAnnotationNode304 *o = LibZen_Malloc(sizeof(struct ZAnnotationNode304));
	_InitZAnnotationNode304(o);
	return o;
}

struct ZAssertNode310 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId310;
	int _delta310;
	int _nextId;
};

static void _InitZAssertNode310(struct ZAssertNode310 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId310 = 310;
	o->_delta310 = sizeof(struct ZAssertNode310) - sizeof(struct ZNode55);
#ifdef _ZAssertNode310_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo1
#endif
#ifdef _ZAssertNode310_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo1
#endif
#ifdef _ZAssertNode310_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo1
#endif
#ifdef _ZAssertNode310_DeSugar
	o->DeSugar = DeSugar__2qo1
#endif
#ifdef _ZAssertNode310_Accept
	o->Accept = Accept__2qo1
#endif
	o->_nextId = 0;
}

static struct ZAssertNode310 * _NewZAssertNode310(void) {
	struct ZAssertNode310 *o = LibZen_Malloc(sizeof(struct ZAssertNode310));
	_InitZAssertNode310(o);
	return o;
}

struct ZBinaryNode313 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId313;
	int _delta313;
	struct ZSyntax221 * Pattern;
	int _nextId;
};

static void _InitZBinaryNode313(struct ZBinaryNode313 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId313 = 313;
	o->_delta313 = sizeof(struct ZBinaryNode313) - sizeof(struct ZNode55);
	o->Pattern = NULL;
#ifdef _ZBinaryNode313_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qox
#endif
#ifdef _ZBinaryNode313_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qox
#endif
#ifdef _ZBinaryNode313_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qox
#endif
#ifdef _ZBinaryNode313_DeSugar
	o->DeSugar = DeSugar__2qox
#endif
#ifdef _ZBinaryNode313_Accept
	o->Accept = Accept__2qox
#endif
	o->_nextId = 0;
}

static struct ZBinaryNode313 * _NewZBinaryNode313(void) {
	struct ZBinaryNode313 *o = LibZen_Malloc(sizeof(struct ZBinaryNode313));
	_InitZBinaryNode313(o);
	return o;
}

struct ZBreakNode320 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId320;
	int _delta320;
	int _nextId;
};

static void _InitZBreakNode320(struct ZBreakNode320 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId320 = 320;
	o->_delta320 = sizeof(struct ZBreakNode320) - sizeof(struct ZNode55);
#ifdef _ZBreakNode320_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo5
#endif
#ifdef _ZBreakNode320_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo5
#endif
#ifdef _ZBreakNode320_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo5
#endif
#ifdef _ZBreakNode320_DeSugar
	o->DeSugar = DeSugar__2qo5
#endif
#ifdef _ZBreakNode320_Accept
	o->Accept = Accept__2qo5
#endif
	o->_nextId = 0;
}

static struct ZBreakNode320 * _NewZBreakNode320(void) {
	struct ZBreakNode320 *o = LibZen_Malloc(sizeof(struct ZBreakNode320));
	_InitZBreakNode320(o);
	return o;
}

struct ZCastNode323 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId323;
	int _delta323;
	int _nextId;
};

static void _InitZCastNode323(struct ZCastNode323 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId323 = 323;
	o->_delta323 = sizeof(struct ZCastNode323) - sizeof(struct ZNode55);
#ifdef _ZCastNode323_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo8
#endif
#ifdef _ZCastNode323_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo8
#endif
#ifdef _ZCastNode323_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo8
#endif
#ifdef _ZCastNode323_DeSugar
	o->DeSugar = DeSugar__2qo8
#endif
#ifdef _ZCastNode323_Accept
	o->Accept = Accept__2qo8
#endif
	o->_nextId = 0;
}

static struct ZCastNode323 * _NewZCastNode323(void) {
	struct ZCastNode323 *o = LibZen_Malloc(sizeof(struct ZCastNode323));
	_InitZCastNode323(o);
	return o;
}

struct ZCatchNode327 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId327;
	int _delta327;
	struct ZType65 * ExceptionType;
	const char * ExceptionName;
	struct ZToken78 * NameToken;
	int _nextId;
};

static void _InitZCatchNode327(struct ZCatchNode327 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId327 = 327;
	o->_delta327 = sizeof(struct ZCatchNode327) - sizeof(struct ZNode55);
	o->ExceptionType = /*untyped*/NULL;
	o->ExceptionName = NULL;
	o->NameToken = NULL;
#ifdef _ZCatchNode327_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpr
#endif
#ifdef _ZCatchNode327_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpr
#endif
#ifdef _ZCatchNode327_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpr
#endif
#ifdef _ZCatchNode327_DeSugar
	o->DeSugar = DeSugar__2qpr
#endif
#ifdef _ZCatchNode327_Accept
	o->Accept = Accept__2qpr
#endif
	o->_nextId = 0;
}

static struct ZCatchNode327 * _NewZCatchNode327(void) {
	struct ZCatchNode327 *o = LibZen_Malloc(sizeof(struct ZCatchNode327));
	_InitZCatchNode327(o);
	return o;
}

struct ZComparatorNode331 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId313;
	int _delta313;
	struct ZSyntax221 * Pattern;
	int _classId331;
	int _delta331;
	int _nextId;
};

static void _InitZComparatorNode331(struct ZComparatorNode331 * o) {
	_InitZBinaryNode313((struct ZBinaryNode313 *)o);
	o->_classId331 = 331;
	o->_delta331 = sizeof(struct ZComparatorNode331) - sizeof(struct ZBinaryNode313);
#ifdef _ZComparatorNode331_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpi
#endif
#ifdef _ZComparatorNode331_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpi
#endif
#ifdef _ZComparatorNode331_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpi
#endif
#ifdef _ZComparatorNode331_DeSugar
	o->DeSugar = DeSugar__2qpi
#endif
#ifdef _ZComparatorNode331_Accept
	o->Accept = Accept__2qpi
#endif
	o->_nextId = 0;
}

static struct ZComparatorNode331 * _NewZComparatorNode331(void) {
	struct ZComparatorNode331 *o = LibZen_Malloc(sizeof(struct ZComparatorNode331));
	_InitZComparatorNode331(o);
	return o;
}

struct ZConstNode334 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _nextId;
};

static void _InitZConstNode334(struct ZConstNode334 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId334 = 334;
	o->_delta334 = sizeof(struct ZConstNode334) - sizeof(struct ZNode55);
#ifdef _ZConstNode334_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp0
#endif
#ifdef _ZConstNode334_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp0
#endif
#ifdef _ZConstNode334_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp0
#endif
#ifdef _ZConstNode334_DeSugar
	o->DeSugar = DeSugar__2qp0
#endif
#ifdef _ZConstNode334_Accept
	o->Accept = Accept__2qp0
#endif
	o->_nextId = 0;
}

static struct ZConstNode334 * _NewZConstNode334(void) {
	struct ZConstNode334 *o = LibZen_Malloc(sizeof(struct ZConstNode334));
	_InitZConstNode334(o);
	return o;
}

struct ZEmptyNode336 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId336;
	int _delta336;
	int _nextId;
};

static void _InitZEmptyNode336(struct ZEmptyNode336 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId336 = 336;
	o->_delta336 = sizeof(struct ZEmptyNode336) - sizeof(struct ZNode55);
#ifdef _ZEmptyNode336_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpa
#endif
#ifdef _ZEmptyNode336_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpa
#endif
#ifdef _ZEmptyNode336_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpa
#endif
#ifdef _ZEmptyNode336_DeSugar
	o->DeSugar = DeSugar__2qpa
#endif
#ifdef _ZEmptyNode336_Accept
	o->Accept = Accept__2qpa
#endif
	o->_nextId = 0;
}

static struct ZEmptyNode336 * _NewZEmptyNode336(void) {
	struct ZEmptyNode336 *o = LibZen_Malloc(sizeof(struct ZEmptyNode336));
	_InitZEmptyNode336(o);
	return o;
}

struct ZErrorNode338 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId338;
	int _delta338;
	const char * ErrorMessage;
	int _nextId;
};

static void _InitZErrorNode338(struct ZErrorNode338 * o) {
	_InitZConstNode334((struct ZConstNode334 *)o);
	o->_classId338 = 338;
	o->_delta338 = sizeof(struct ZErrorNode338) - sizeof(struct ZConstNode334);
	o->ErrorMessage = NULL;
#ifdef _ZErrorNode338_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpd
#endif
#ifdef _ZErrorNode338_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpd
#endif
#ifdef _ZErrorNode338_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpd
#endif
#ifdef _ZErrorNode338_DeSugar
	o->DeSugar = DeSugar__2qpd
#endif
#ifdef _ZErrorNode338_Accept
	o->Accept = Accept__2qpd
#endif
	o->_nextId = 0;
}

static struct ZErrorNode338 * _NewZErrorNode338(void) {
	struct ZErrorNode338 *o = LibZen_Malloc(sizeof(struct ZErrorNode338));
	_InitZErrorNode338(o);
	return o;
}

struct ZFieldNode342 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId342;
	int _delta342;
	struct ZClassType81 * ClassType;
	struct ZType65 * DeclType;
	const char * FieldName;
	struct ZToken78 * NameToken;
	int _nextId;
};

static void _InitZFieldNode342(struct ZFieldNode342 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId342 = 342;
	o->_delta342 = sizeof(struct ZFieldNode342) - sizeof(struct ZNode55);
	o->ClassType = NULL;
	o->DeclType = /*untyped*/NULL;
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZFieldNode342_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpj
#endif
#ifdef _ZFieldNode342_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpj
#endif
#ifdef _ZFieldNode342_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpj
#endif
#ifdef _ZFieldNode342_DeSugar
	o->DeSugar = DeSugar__2qpj
#endif
#ifdef _ZFieldNode342_Accept
	o->Accept = Accept__2qpj
#endif
	o->_nextId = 0;
}

static struct ZFieldNode342 * _NewZFieldNode342(void) {
	struct ZFieldNode342 *o = LibZen_Malloc(sizeof(struct ZFieldNode342));
	_InitZFieldNode342(o);
	return o;
}

struct ZFloatNode346 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId346;
	int _delta346;
	double FloatValue;
	int _nextId;
};

static void _InitZFloatNode346(struct ZFloatNode346 * o) {
	_InitZConstNode334((struct ZConstNode334 *)o);
	o->_classId346 = 346;
	o->_delta346 = sizeof(struct ZFloatNode346) - sizeof(struct ZConstNode334);
	o->FloatValue = 0.0;
#ifdef _ZFloatNode346_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp1
#endif
#ifdef _ZFloatNode346_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp1
#endif
#ifdef _ZFloatNode346_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp1
#endif
#ifdef _ZFloatNode346_DeSugar
	o->DeSugar = DeSugar__2qp1
#endif
#ifdef _ZFloatNode346_Accept
	o->Accept = Accept__2qp1
#endif
	o->_nextId = 0;
}

static struct ZFloatNode346 * _NewZFloatNode346(void) {
	struct ZFloatNode346 *o = LibZen_Malloc(sizeof(struct ZFloatNode346));
	_InitZFloatNode346(o);
	return o;
}

struct ZGetIndexNode349 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId349;
	int _delta349;
	int _nextId;
};

static void _InitZGetIndexNode349(struct ZGetIndexNode349 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId349 = 349;
	o->_delta349 = sizeof(struct ZGetIndexNode349) - sizeof(struct ZNode55);
#ifdef _ZGetIndexNode349_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpx
#endif
#ifdef _ZGetIndexNode349_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpx
#endif
#ifdef _ZGetIndexNode349_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpx
#endif
#ifdef _ZGetIndexNode349_DeSugar
	o->DeSugar = DeSugar__2qpx
#endif
#ifdef _ZGetIndexNode349_Accept
	o->Accept = Accept__2qpx
#endif
	o->_nextId = 0;
}

static struct ZGetIndexNode349 * _NewZGetIndexNode349(void) {
	struct ZGetIndexNode349 *o = LibZen_Malloc(sizeof(struct ZGetIndexNode349));
	_InitZGetIndexNode349(o);
	return o;
}

struct ZGetNameNode352 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId352;
	int _delta352;
	int IsCaptured;
	const char * VarName;
	long VarIndex;
	int _nextId;
};

static void _InitZGetNameNode352(struct ZGetNameNode352 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId352 = 352;
	o->_delta352 = sizeof(struct ZGetNameNode352) - sizeof(struct ZNode55);
	o->IsCaptured = 0/*false*/;
	o->VarName = NULL;
	o->VarIndex = 0;
#ifdef _ZGetNameNode352_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpb
#endif
#ifdef _ZGetNameNode352_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpb
#endif
#ifdef _ZGetNameNode352_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpb
#endif
#ifdef _ZGetNameNode352_DeSugar
	o->DeSugar = DeSugar__2qpb
#endif
#ifdef _ZGetNameNode352_Accept
	o->Accept = Accept__2qpb
#endif
	o->_nextId = 0;
}

static struct ZGetNameNode352 * _NewZGetNameNode352(void) {
	struct ZGetNameNode352 *o = LibZen_Malloc(sizeof(struct ZGetNameNode352));
	_InitZGetNameNode352(o);
	return o;
}

struct ZGetterNode357 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId357;
	int _delta357;
	const char * FieldName;
	struct ZToken78 * NameToken;
	int _nextId;
};

static void _InitZGetterNode357(struct ZGetterNode357 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId357 = 357;
	o->_delta357 = sizeof(struct ZGetterNode357) - sizeof(struct ZNode55);
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZGetterNode357_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp3
#endif
#ifdef _ZGetterNode357_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp3
#endif
#ifdef _ZGetterNode357_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp3
#endif
#ifdef _ZGetterNode357_DeSugar
	o->DeSugar = DeSugar__2qp3
#endif
#ifdef _ZGetterNode357_Accept
	o->Accept = Accept__2qp3
#endif
	o->_nextId = 0;
}

static struct ZGetterNode357 * _NewZGetterNode357(void) {
	struct ZGetterNode357 *o = LibZen_Malloc(sizeof(struct ZGetterNode357));
	_InitZGetterNode357(o);
	return o;
}

struct ZGlobalNameNode362 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId362;
	int _delta362;
	const char * GlobalName;
	int IsStaticFuncName;
	int _nextId;
};

static void _InitZGlobalNameNode362(struct ZGlobalNameNode362 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId362 = 362;
	o->_delta362 = sizeof(struct ZGlobalNameNode362) - sizeof(struct ZNode55);
	o->GlobalName = NULL;
	o->IsStaticFuncName = 0/*false*/;
#ifdef _ZGlobalNameNode362_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0e
#endif
#ifdef _ZGlobalNameNode362_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0e
#endif
#ifdef _ZGlobalNameNode362_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0e
#endif
#ifdef _ZGlobalNameNode362_DeSugar
	o->DeSugar = DeSugar__2q0e
#endif
#ifdef _ZGlobalNameNode362_Accept
	o->Accept = Accept__2q0e
#endif
	o->_nextId = 0;
}

static struct ZGlobalNameNode362 * _NewZGlobalNameNode362(void) {
	struct ZGlobalNameNode362 *o = LibZen_Malloc(sizeof(struct ZGlobalNameNode362));
	_InitZGlobalNameNode362(o);
	return o;
}

struct ZGroupNode366 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId366;
	int _delta366;
	int _nextId;
};

static void _InitZGroupNode366(struct ZGroupNode366 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId366 = 366;
	o->_delta366 = sizeof(struct ZGroupNode366) - sizeof(struct ZNode55);
#ifdef _ZGroupNode366_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0u
#endif
#ifdef _ZGroupNode366_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0u
#endif
#ifdef _ZGroupNode366_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0u
#endif
#ifdef _ZGroupNode366_DeSugar
	o->DeSugar = DeSugar__2q0u
#endif
#ifdef _ZGroupNode366_Accept
	o->Accept = Accept__2q0u
#endif
	o->_nextId = 0;
}

static struct ZGroupNode366 * _NewZGroupNode366(void) {
	struct ZGroupNode366 *o = LibZen_Malloc(sizeof(struct ZGroupNode366));
	_InitZGroupNode366(o);
	return o;
}

struct ZIfNode369 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId369;
	int _delta369;
	int _nextId;
};

static void _InitZIfNode369(struct ZIfNode369 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId369 = 369;
	o->_delta369 = sizeof(struct ZIfNode369) - sizeof(struct ZNode55);
#ifdef _ZIfNode369_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0p
#endif
#ifdef _ZIfNode369_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0p
#endif
#ifdef _ZIfNode369_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0p
#endif
#ifdef _ZIfNode369_DeSugar
	o->DeSugar = DeSugar__2q0p
#endif
#ifdef _ZIfNode369_Accept
	o->Accept = Accept__2q0p
#endif
	o->_nextId = 0;
}

static struct ZIfNode369 * _NewZIfNode369(void) {
	struct ZIfNode369 *o = LibZen_Malloc(sizeof(struct ZIfNode369));
	_InitZIfNode369(o);
	return o;
}

struct ZImportNode372 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId372;
	int _delta372;
	const char * ResourcePath;
	const char * Alias;
	struct ZToken78 * ResourceToken;
	struct ZNode55 * (*)(struct ZImportNode372 *) Import;
	int _nextId;
};

static void _InitZImportNode372(struct ZImportNode372 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId372 = 372;
	o->_delta372 = sizeof(struct ZImportNode372) - sizeof(struct ZNode55);
	o->ResourcePath = NULL;
	o->Alias = NULL;
	o->ResourceToken = NULL;
	o->Import = NULL;
#ifdef _ZImportNode372_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0a
#endif
#ifdef _ZImportNode372_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0a
#endif
#ifdef _ZImportNode372_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0a
#endif
#ifdef _ZImportNode372_DeSugar
	o->DeSugar = DeSugar__2q0a
#endif
#ifdef _ZImportNode372_Accept
	o->Accept = Accept__2q0a
#endif
#ifdef _ZImportNode372_Import
	o->Import = Import__1q0a
#endif
	o->_nextId = 0;
}

static struct ZImportNode372 * _NewZImportNode372(void) {
	struct ZImportNode372 *o = LibZen_Malloc(sizeof(struct ZImportNode372));
	_InitZImportNode372(o);
	return o;
}

struct ZInstanceOfNode375 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId375;
	int _delta375;
	struct ZType65 * TargetType;
	int _nextId;
};

static void _InitZInstanceOfNode375(struct ZInstanceOfNode375 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId375 = 375;
	o->_delta375 = sizeof(struct ZInstanceOfNode375) - sizeof(struct ZNode55);
	o->TargetType = NULL;
#ifdef _ZInstanceOfNode375_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0f
#endif
#ifdef _ZInstanceOfNode375_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0f
#endif
#ifdef _ZInstanceOfNode375_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0f
#endif
#ifdef _ZInstanceOfNode375_DeSugar
	o->DeSugar = DeSugar__2q0f
#endif
#ifdef _ZInstanceOfNode375_Accept
	o->Accept = Accept__2q0f
#endif
	o->_nextId = 0;
}

static struct ZInstanceOfNode375 * _NewZInstanceOfNode375(void) {
	struct ZInstanceOfNode375 *o = LibZen_Malloc(sizeof(struct ZInstanceOfNode375));
	_InitZInstanceOfNode375(o);
	return o;
}

struct ZIntNode379 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId379;
	int _delta379;
	long IntValue;
	int _nextId;
};

static void _InitZIntNode379(struct ZIntNode379 * o) {
	_InitZConstNode334((struct ZConstNode334 *)o);
	o->_classId379 = 379;
	o->_delta379 = sizeof(struct ZIntNode379) - sizeof(struct ZConstNode334);
	o->IntValue = 0;
#ifdef _ZIntNode379_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0k
#endif
#ifdef _ZIntNode379_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0k
#endif
#ifdef _ZIntNode379_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0k
#endif
#ifdef _ZIntNode379_DeSugar
	o->DeSugar = DeSugar__2q0k
#endif
#ifdef _ZIntNode379_Accept
	o->Accept = Accept__2q0k
#endif
	o->_nextId = 0;
}

static struct ZIntNode379 * _NewZIntNode379(void) {
	struct ZIntNode379 *o = LibZen_Malloc(sizeof(struct ZIntNode379));
	_InitZIntNode379(o);
	return o;
}

struct ZLetNode382 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId382;
	int _delta382;
	const char * Symbol;
	struct ZToken78 * SymbolToken;
	struct ZType65 * SymbolType;
	const char * GlobalName;
	int _nextId;
};

static void _InitZLetNode382(struct ZLetNode382 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId382 = 382;
	o->_delta382 = sizeof(struct ZLetNode382) - sizeof(struct ZNode55);
	o->Symbol = NULL;
	o->SymbolToken = NULL;
	o->SymbolType = /*untyped*/NULL;
	o->GlobalName = NULL;
#ifdef _ZLetNode382_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q01
#endif
#ifdef _ZLetNode382_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q01
#endif
#ifdef _ZLetNode382_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q01
#endif
#ifdef _ZLetNode382_DeSugar
	o->DeSugar = DeSugar__2q01
#endif
#ifdef _ZLetNode382_Accept
	o->Accept = Accept__2q01
#endif
	o->_nextId = 0;
}

static struct ZLetNode382 * _NewZLetNode382(void) {
	struct ZLetNode382 *o = LibZen_Malloc(sizeof(struct ZLetNode382));
	_InitZLetNode382(o);
	return o;
}

struct ZListNode252 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _nextId;
};

static void _InitZListNode252(struct ZListNode252 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId252 = 252;
	o->_delta252 = sizeof(struct ZListNode252) - sizeof(struct ZNode55);
	o->ListStartIndex = 0;
#ifdef _ZListNode252_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qiq
#endif
#ifdef _ZListNode252_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qiq
#endif
#ifdef _ZListNode252_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qiq
#endif
#ifdef _ZListNode252_DeSugar
	o->DeSugar = DeSugar__2qiq
#endif
#ifdef _ZListNode252_Accept
	o->Accept = Accept__2qiq
#endif
	o->_nextId = 0;
}

static struct ZListNode252 * _NewZListNode252(void) {
	struct ZListNode252 *o = LibZen_Malloc(sizeof(struct ZListNode252));
	_InitZListNode252(o);
	return o;
}

struct ZMacroNode394 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId394;
	int _delta394;
	struct ZMacroFunc213 * MacroFunc;
	int _nextId;
};

static void _InitZMacroNode394(struct ZMacroNode394 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId394 = 394;
	o->_delta394 = sizeof(struct ZMacroNode394) - sizeof(struct ZListNode252);
	o->MacroFunc = NULL;
#ifdef _ZMacroNode394_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q02
#endif
#ifdef _ZMacroNode394_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q02
#endif
#ifdef _ZMacroNode394_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q02
#endif
#ifdef _ZMacroNode394_DeSugar
	o->DeSugar = DeSugar__2q02
#endif
#ifdef _ZMacroNode394_Accept
	o->Accept = Accept__2q02
#endif
	o->_nextId = 0;
}

static struct ZMacroNode394 * _NewZMacroNode394(void) {
	struct ZMacroNode394 *o = LibZen_Malloc(sizeof(struct ZMacroNode394));
	_InitZMacroNode394(o);
	return o;
}

struct ZMapEntryNode399 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId399;
	int _delta399;
	const char * Name;
	int _nextId;
};

static void _InitZMapEntryNode399(struct ZMapEntryNode399 * o) {
	_InitZNode55((struct ZNode55 *)o);
	o->_classId399 = 399;
	o->_delta399 = sizeof(struct ZMapEntryNode399) - sizeof(struct ZNode55);
	o->Name = NULL;
#ifdef _ZMapEntryNode399_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4r
#endif
#ifdef _ZMapEntryNode399_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4r
#endif
#ifdef _ZMapEntryNode399_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4r
#endif
#ifdef _ZMapEntryNode399_DeSugar
	o->DeSugar = DeSugar__2q4r
#endif
#ifdef _ZMapEntryNode399_Accept
	o->Accept = Accept__2q4r
#endif
	o->_nextId = 0;
}

static struct ZMapEntryNode399 * _NewZMapEntryNode399(void) {
	struct ZMapEntryNode399 *o = LibZen_Malloc(sizeof(struct ZMapEntryNode399));
	_InitZMapEntryNode399(o);
	return o;
}

struct ZMapLiteralNode401 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId401;
	int _delta401;
	int _nextId;
};

static void _InitZMapLiteralNode401(struct ZMapLiteralNode401 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId401 = 401;
	o->_delta401 = sizeof(struct ZMapLiteralNode401) - sizeof(struct ZListNode252);
#ifdef _ZMapLiteralNode401_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4y
#endif
#ifdef _ZMapLiteralNode401_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4y
#endif
#ifdef _ZMapLiteralNode401_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4y
#endif
#ifdef _ZMapLiteralNode401_DeSugar
	o->DeSugar = DeSugar__2q4y
#endif
#ifdef _ZMapLiteralNode401_Accept
	o->Accept = Accept__2q4y
#endif
	o->_nextId = 0;
}

static struct ZMapLiteralNode401 * _NewZMapLiteralNode401(void) {
	struct ZMapLiteralNode401 *o = LibZen_Malloc(sizeof(struct ZMapLiteralNode401));
	_InitZMapLiteralNode401(o);
	return o;
}

struct ZMethodCallNode405 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId405;
	int _delta405;
	const char * MethodName;
	struct ZToken78 * MethodToken;
	int _nextId;
};

static void _InitZMethodCallNode405(struct ZMethodCallNode405 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId405 = 405;
	o->_delta405 = sizeof(struct ZMethodCallNode405) - sizeof(struct ZListNode252);
	o->MethodName = NULL;
	o->MethodToken = NULL;
#ifdef _ZMethodCallNode405_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4p
#endif
#ifdef _ZMethodCallNode405_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4p
#endif
#ifdef _ZMethodCallNode405_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4p
#endif
#ifdef _ZMethodCallNode405_DeSugar
	o->DeSugar = DeSugar__2q4p
#endif
#ifdef _ZMethodCallNode405_Accept
	o->Accept = Accept__2q4p
#endif
	o->_nextId = 0;
}

static struct ZMethodCallNode405 * _NewZMethodCallNode405(void) {
	struct ZMethodCallNode405 *o = LibZen_Malloc(sizeof(struct ZMethodCallNode405));
	_InitZMethodCallNode405(o);
	return o;
}

struct ZNewArrayNode412 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId412;
	int _delta412;
	int _nextId;
};

static void _InitZNewArrayNode412(struct ZNewArrayNode412 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId412 = 412;
	o->_delta412 = sizeof(struct ZNewArrayNode412) - sizeof(struct ZListNode252);
#ifdef _ZNewArrayNode412_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4g
#endif
#ifdef _ZNewArrayNode412_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4g
#endif
#ifdef _ZNewArrayNode412_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4g
#endif
#ifdef _ZNewArrayNode412_DeSugar
	o->DeSugar = DeSugar__2q4g
#endif
#ifdef _ZNewArrayNode412_Accept
	o->Accept = Accept__2q4g
#endif
	o->_nextId = 0;
}

static struct ZNewArrayNode412 * _NewZNewArrayNode412(void) {
	struct ZNewArrayNode412 *o = LibZen_Malloc(sizeof(struct ZNewArrayNode412));
	_InitZNewArrayNode412(o);
	return o;
}

struct ZNewObjectNode414 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId414;
	int _delta414;
	int _nextId;
};

static void _InitZNewObjectNode414(struct ZNewObjectNode414 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId414 = 414;
	o->_delta414 = sizeof(struct ZNewObjectNode414) - sizeof(struct ZListNode252);
#ifdef _ZNewObjectNode414_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4j
#endif
#ifdef _ZNewObjectNode414_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4j
#endif
#ifdef _ZNewObjectNode414_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4j
#endif
#ifdef _ZNewObjectNode414_DeSugar
	o->DeSugar = DeSugar__2q4j
#endif
#ifdef _ZNewObjectNode414_Accept
	o->Accept = Accept__2q4j
#endif
	o->_nextId = 0;
}

static struct ZNewObjectNode414 * _NewZNewObjectNode414(void) {
	struct ZNewObjectNode414 *o = LibZen_Malloc(sizeof(struct ZNewObjectNode414));
	_InitZNewObjectNode414(o);
	return o;
}

struct ZNotNode418 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId199;
	int _delta199;
	int _classId418;
	int _delta418;
	int _nextId;
};

static void _InitZNotNode418(struct ZNotNode418 * o) {
	_InitZUnaryNode199((struct ZUnaryNode199 *)o);
	o->_classId418 = 418;
	o->_delta418 = sizeof(struct ZNotNode418) - sizeof(struct ZUnaryNode199);
#ifdef _ZNotNode418_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q41
#endif
#ifdef _ZNotNode418_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q41
#endif
#ifdef _ZNotNode418_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q41
#endif
#ifdef _ZNotNode418_DeSugar
	o->DeSugar = DeSugar__2q41
#endif
#ifdef _ZNotNode418_Accept
	o->Accept = Accept__2q41
#endif
	o->_nextId = 0;
}

static struct ZNotNode418 * _NewZNotNode418(void) {
	struct ZNotNode418 *o = LibZen_Malloc(sizeof(struct ZNotNode418));
	_InitZNotNode418(o);
	return o;
}

struct ZNullNode421 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId421;
	int _delta421;
	int _nextId;
};

static void _InitZNullNode421(struct ZNullNode421 * o) {
	_InitZConstNode334((struct ZConstNode334 *)o);
	o->_classId421 = 421;
	o->_delta421 = sizeof(struct ZNullNode421) - sizeof(struct ZConstNode334);
#ifdef _ZNullNode421_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4x
#endif
#ifdef _ZNullNode421_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4x
#endif
#ifdef _ZNullNode421_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4x
#endif
#ifdef _ZNullNode421_DeSugar
	o->DeSugar = DeSugar__2q4x
#endif
#ifdef _ZNullNode421_Accept
	o->Accept = Accept__2q4x
#endif
	o->_nextId = 0;
}

static struct ZNullNode421 * _NewZNullNode421(void) {
	struct ZNullNode421 *o = LibZen_Malloc(sizeof(struct ZNullNode421));
	_InitZNullNode421(o);
	return o;
}

struct ZOrNode424 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId313;
	int _delta313;
	struct ZSyntax221 * Pattern;
	int _classId424;
	int _delta424;
	int _nextId;
};

static void _InitZOrNode424(struct ZOrNode424 * o) {
	_InitZBinaryNode313((struct ZBinaryNode313 *)o);
	o->_classId424 = 424;
	o->_delta424 = sizeof(struct ZOrNode424) - sizeof(struct ZBinaryNode313);
#ifdef _ZOrNode424_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4b
#endif
#ifdef _ZOrNode424_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4b
#endif
#ifdef _ZOrNode424_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4b
#endif
#ifdef _ZOrNode424_DeSugar
	o->DeSugar = DeSugar__2q4b
#endif
#ifdef _ZOrNode424_Accept
	o->Accept = Accept__2q4b
#endif
	o->_nextId = 0;
}

static struct ZOrNode424 * _NewZOrNode424(void) {
	struct ZOrNode424 *o = LibZen_Malloc(sizeof(struct ZOrNode424));
	_InitZOrNode424(o);
	return o;
}

struct ZPrototypeNode427 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId427;
	int _delta427;
	struct ZType65 * ReturnType;
	const char * FuncName;
	struct ZToken78 * NameToken;
	int _nextId;
};

static void _InitZPrototypeNode427(struct ZPrototypeNode427 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId427 = 427;
	o->_delta427 = sizeof(struct ZPrototypeNode427) - sizeof(struct ZListNode252);
	o->ReturnType = /*untyped*/NULL;
	o->FuncName = NULL;
	o->NameToken = NULL;
#ifdef _ZPrototypeNode427_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q47
#endif
#ifdef _ZPrototypeNode427_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q47
#endif
#ifdef _ZPrototypeNode427_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q47
#endif
#ifdef _ZPrototypeNode427_DeSugar
	o->DeSugar = DeSugar__2q47
#endif
#ifdef _ZPrototypeNode427_Accept
	o->Accept = Accept__2q47
#endif
	o->_nextId = 0;
}

static struct ZPrototypeNode427 * _NewZPrototypeNode427(void) {
	struct ZPrototypeNode427 *o = LibZen_Malloc(sizeof(struct ZPrototypeNode427));
	_InitZPrototypeNode427(o);
	return o;
}

struct ZStringNode433 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId433;
	int _delta433;
	const char * StringValue;
	int _nextId;
};

static void _InitZStringNode433(struct ZStringNode433 * o) {
	_InitZConstNode334((struct ZConstNode334 *)o);
	o->_classId433 = 433;
	o->_delta433 = sizeof(struct ZStringNode433) - sizeof(struct ZConstNode334);
	o->StringValue = NULL;
#ifdef _ZStringNode433_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qaw
#endif
#ifdef _ZStringNode433_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qaw
#endif
#ifdef _ZStringNode433_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qaw
#endif
#ifdef _ZStringNode433_DeSugar
	o->DeSugar = DeSugar__2qaw
#endif
#ifdef _ZStringNode433_Accept
	o->Accept = Accept__2qaw
#endif
	o->_nextId = 0;
}

static struct ZStringNode433 * _NewZStringNode433(void) {
	struct ZStringNode433 *o = LibZen_Malloc(sizeof(struct ZStringNode433));
	_InitZStringNode433(o);
	return o;
}

struct ZStupidCastErrorNode436 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId338;
	int _delta338;
	const char * ErrorMessage;
	int _classId436;
	int _delta436;
	struct ZNode55 * ErrorNode;
	int _nextId;
};

static void _InitZStupidCastErrorNode436(struct ZStupidCastErrorNode436 * o) {
	_InitZErrorNode338((struct ZErrorNode338 *)o);
	o->_classId436 = 436;
	o->_delta436 = sizeof(struct ZStupidCastErrorNode436) - sizeof(struct ZErrorNode338);
	o->ErrorNode = NULL;
#ifdef _ZStupidCastErrorNode436_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qat
#endif
#ifdef _ZStupidCastErrorNode436_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qat
#endif
#ifdef _ZStupidCastErrorNode436_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qat
#endif
#ifdef _ZStupidCastErrorNode436_DeSugar
	o->DeSugar = DeSugar__2qat
#endif
#ifdef _ZStupidCastErrorNode436_Accept
	o->Accept = Accept__2qat
#endif
	o->_nextId = 0;
}

static struct ZStupidCastErrorNode436 * _NewZStupidCastErrorNode436(void) {
	struct ZStupidCastErrorNode436 *o = LibZen_Malloc(sizeof(struct ZStupidCastErrorNode436));
	_InitZStupidCastErrorNode436(o);
	return o;
}

struct ZTypeNode236 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId236;
	int _delta236;
	int _nextId;
};

static void _InitZTypeNode236(struct ZTypeNode236 * o) {
	_InitZConstNode334((struct ZConstNode334 *)o);
	o->_classId236 = 236;
	o->_delta236 = sizeof(struct ZTypeNode236) - sizeof(struct ZConstNode334);
#ifdef _ZTypeNode236_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qul
#endif
#ifdef _ZTypeNode236_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qul
#endif
#ifdef _ZTypeNode236_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qul
#endif
#ifdef _ZTypeNode236_DeSugar
	o->DeSugar = DeSugar__2qul
#endif
#ifdef _ZTypeNode236_Accept
	o->Accept = Accept__2qul
#endif
	o->_nextId = 0;
}

static struct ZTypeNode236 * _NewZTypeNode236(void) {
	struct ZTypeNode236 *o = LibZen_Malloc(sizeof(struct ZTypeNode236));
	_InitZTypeNode236(o);
	return o;
}

struct ZGenerator58 {
	int _classId169;
	int _delta169;
	void (*)(struct ZVisitor169 *,struct ZNullNode421 *) VisitNullNode;
	void (*)(struct ZVisitor169 *,struct ZBooleanNode478 *) VisitBooleanNode;
	void (*)(struct ZVisitor169 *,struct ZIntNode379 *) VisitIntNode;
	void (*)(struct ZVisitor169 *,struct ZFloatNode346 *) VisitFloatNode;
	void (*)(struct ZVisitor169 *,struct ZStringNode433 *) VisitStringNode;
	void (*)(struct ZVisitor169 *,struct ZArrayLiteralNode483 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZMapLiteralNode401 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZNewObjectNode414 *) VisitNewObjectNode;
	void (*)(struct ZVisitor169 *,struct ZGlobalNameNode362 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor169 *,struct ZGetNameNode352 *) VisitGetNameNode;
	void (*)(struct ZVisitor169 *,struct ZSetNameNode183 *) VisitSetNameNode;
	void (*)(struct ZVisitor169 *,struct ZGroupNode366 *) VisitGroupNode;
	void (*)(struct ZVisitor169 *,struct ZGetterNode357 *) VisitGetterNode;
	void (*)(struct ZVisitor169 *,struct ZSetterNode186 *) VisitSetterNode;
	void (*)(struct ZVisitor169 *,struct ZGetIndexNode349 *) VisitGetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZSetIndexNode180 *) VisitSetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZMethodCallNode405 *) VisitMethodCallNode;
	void (*)(struct ZVisitor169 *,struct ZFuncCallNode409 *) VisitFuncCallNode;
	void (*)(struct ZVisitor169 *,struct ZMacroNode394 *) VisitMacroNode;
	void (*)(struct ZVisitor169 *,struct ZUnaryNode199 *) VisitUnaryNode;
	void (*)(struct ZVisitor169 *,struct ZNotNode418 *) VisitNotNode;
	void (*)(struct ZVisitor169 *,struct ZCastNode323 *) VisitCastNode;
	void (*)(struct ZVisitor169 *,struct ZInstanceOfNode375 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor169 *,struct ZBinaryNode313 *) VisitBinaryNode;
	void (*)(struct ZVisitor169 *,struct ZComparatorNode331 *) VisitComparatorNode;
	void (*)(struct ZVisitor169 *,struct ZAndNode504 *) VisitAndNode;
	void (*)(struct ZVisitor169 *,struct ZOrNode424 *) VisitOrNode;
	void (*)(struct ZVisitor169 *,struct ZBlockNode163 *) VisitBlockNode;
	void (*)(struct ZVisitor169 *,struct ZVarNode508 *) VisitVarNode;
	void (*)(struct ZVisitor169 *,struct ZIfNode369 *) VisitIfNode;
	void (*)(struct ZVisitor169 *,struct ZReturnNode172 *) VisitReturnNode;
	void (*)(struct ZVisitor169 *,struct ZWhileNode202 *) VisitWhileNode;
	void (*)(struct ZVisitor169 *,struct ZBreakNode320 *) VisitBreakNode;
	void (*)(struct ZVisitor169 *,struct ZThrowNode193 *) VisitThrowNode;
	void (*)(struct ZVisitor169 *,struct ZTryNode196 *) VisitTryNode;
	void (*)(struct ZVisitor169 *,struct ZLetNode382 *) VisitLetNode;
	void (*)(struct ZVisitor169 *,struct ZFunctionNode146 *) VisitFunctionNode;
	void (*)(struct ZVisitor169 *,struct ZClassNode518 *) VisitClassNode;
	void (*)(struct ZVisitor169 *,struct ZErrorNode338 *) VisitErrorNode;
	void (*)(struct ZVisitor169 *,struct ZNode55 *) VisitExtendedNode;
	void (*)(struct ZVisitor169 *,struct ZSugarNode167 *) VisitSugarNode;
	void (*)(struct ZVisitor169 *) EnableVisitor;
	void (*)(struct ZVisitor169 *) StopVisitor;
	int (*)(struct ZVisitor169 *) IsVisitable;
	int _classId58;
	int _delta58;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace49 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger136 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine60 * (*)(struct ZGenerator58 *) GetEngine;
	void (*)(struct ZGenerator58 *,struct ZNameSpace49 *) ImportLocalGrammar;
	void (*)(struct ZGenerator58 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator58 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator58 *,struct ZNode55 *,int) StartCodeGeneration;
	struct ZType65 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *) GetFieldType;
	struct ZType65 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *) GetSetterType;
	struct ZFuncType91 * (*)(struct ZGenerator58 *,struct ZType65 *,struct ZListNode252 *) GetConstructorFuncType;
	struct ZFuncType91 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *,struct ZListNode252 *) GetMethodFuncType;
	int _nextId;
};

static void _InitZGenerator58(struct ZGenerator58 * o) {
	_InitZVisitor169((struct ZVisitor169 *)o);
	o->_classId58 = 58;
	o->_delta58 = sizeof(struct ZGenerator58) - sizeof(struct ZVisitor169);
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
#ifdef _ZGenerator58_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qw1
#endif
#ifdef _ZGenerator58_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qw1
#endif
#ifdef _ZGenerator58_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qw1
#endif
#ifdef _ZGenerator58_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qw1
#endif
#ifdef _ZGenerator58_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qw1
#endif
#ifdef _ZGenerator58_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qw1
#endif
#ifdef _ZGenerator58_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qw1
#endif
#ifdef _ZGenerator58_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qw1
#endif
#ifdef _ZGenerator58_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qw1
#endif
#ifdef _ZGenerator58_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qw1
#endif
#ifdef _ZGenerator58_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qw1
#endif
#ifdef _ZGenerator58_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qw1
#endif
#ifdef _ZGenerator58_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qw1
#endif
#ifdef _ZGenerator58_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qw1
#endif
#ifdef _ZGenerator58_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qw1
#endif
#ifdef _ZGenerator58_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qw1
#endif
#ifdef _ZGenerator58_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qw1
#endif
#ifdef _ZGenerator58_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qw1
#endif
#ifdef _ZGenerator58_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qw1
#endif
#ifdef _ZGenerator58_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qw1
#endif
#ifdef _ZGenerator58_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qw1
#endif
#ifdef _ZGenerator58_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qw1
#endif
#ifdef _ZGenerator58_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qw1
#endif
#ifdef _ZGenerator58_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qw1
#endif
#ifdef _ZGenerator58_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qw1
#endif
#ifdef _ZGenerator58_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qw1
#endif
#ifdef _ZGenerator58_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qw1
#endif
#ifdef _ZGenerator58_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qw1
#endif
#ifdef _ZGenerator58_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qw1
#endif
#ifdef _ZGenerator58_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qw1
#endif
#ifdef _ZGenerator58_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qw1
#endif
#ifdef _ZGenerator58_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qw1
#endif
#ifdef _ZGenerator58_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qw1
#endif
#ifdef _ZGenerator58_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qw1
#endif
#ifdef _ZGenerator58_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qw1
#endif
#ifdef _ZGenerator58_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qw1
#endif
#ifdef _ZGenerator58_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qw1
#endif
#ifdef _ZGenerator58_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qw1
#endif
#ifdef _ZGenerator58_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qw1
#endif
#ifdef _ZGenerator58_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qw1
#endif
#ifdef _ZGenerator58_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qw1
#endif
#ifdef _ZGenerator58_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qw1
#endif
#ifdef _ZGenerator58_StopVisitor
	o->StopVisitor = StopVisitor__1qw1
#endif
#ifdef _ZGenerator58_IsVisitable
	o->IsVisitable = IsVisitable__1qw1
#endif
#ifdef _ZGenerator58_GetEngine
	o->GetEngine = GetEngine__1qw1
#endif
#ifdef _ZGenerator58_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qw1
#endif
#ifdef _ZGenerator58_WriteTo
	o->WriteTo = WriteTo__2qw1
#endif
#ifdef _ZGenerator58_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qw1
#endif
#ifdef _ZGenerator58_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qw1
#endif
#ifdef _ZGenerator58_GetFieldType
	o->GetFieldType = GetFieldType__3qw1
#endif
#ifdef _ZGenerator58_GetSetterType
	o->GetSetterType = GetSetterType__3qw1
#endif
#ifdef _ZGenerator58_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qw1
#endif
#ifdef _ZGenerator58_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qw1
#endif
	o->_nextId = 0;
}

static struct ZGenerator58 * _NewZGenerator58(void) {
	struct ZGenerator58 *o = LibZen_Malloc(sizeof(struct ZGenerator58));
	_InitZGenerator58(o);
	return o;
}

struct ZIndentToken462 {
	int _classId78;
	int _delta78;
	struct ZSource239 * Source;
	long StartIndex;
	long EndIndex;
	int _classId462;
	int _delta462;
	int _nextId;
};

static void _InitZIndentToken462(struct ZIndentToken462 * o) {
	_InitZToken78((struct ZToken78 *)o);
	o->_classId462 = 462;
	o->_delta462 = sizeof(struct ZIndentToken462) - sizeof(struct ZToken78);
	o->_nextId = 0;
}

static struct ZIndentToken462 * _NewZIndentToken462(void) {
	struct ZIndentToken462 *o = LibZen_Malloc(sizeof(struct ZIndentToken462));
	_InitZIndentToken462(o);
	return o;
}

struct ZPatternToken464 {
	int _classId78;
	int _delta78;
	struct ZSource239 * Source;
	long StartIndex;
	long EndIndex;
	int _classId464;
	int _delta464;
	struct ZSyntax221 * PresetPattern;
	int _nextId;
};

static void _InitZPatternToken464(struct ZPatternToken464 * o) {
	_InitZToken78((struct ZToken78 *)o);
	o->_classId464 = 464;
	o->_delta464 = sizeof(struct ZPatternToken464) - sizeof(struct ZToken78);
	o->PresetPattern = NULL;
	o->_nextId = 0;
}

static struct ZPatternToken464 * _NewZPatternToken464(void) {
	struct ZPatternToken464 *o = LibZen_Malloc(sizeof(struct ZPatternToken464));
	_InitZPatternToken464(o);
	return o;
}

struct ZSourceEngine60 {
	int _classId169;
	int _delta169;
	void (*)(struct ZVisitor169 *,struct ZNullNode421 *) VisitNullNode;
	void (*)(struct ZVisitor169 *,struct ZBooleanNode478 *) VisitBooleanNode;
	void (*)(struct ZVisitor169 *,struct ZIntNode379 *) VisitIntNode;
	void (*)(struct ZVisitor169 *,struct ZFloatNode346 *) VisitFloatNode;
	void (*)(struct ZVisitor169 *,struct ZStringNode433 *) VisitStringNode;
	void (*)(struct ZVisitor169 *,struct ZArrayLiteralNode483 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZMapLiteralNode401 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZNewObjectNode414 *) VisitNewObjectNode;
	void (*)(struct ZVisitor169 *,struct ZGlobalNameNode362 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor169 *,struct ZGetNameNode352 *) VisitGetNameNode;
	void (*)(struct ZVisitor169 *,struct ZSetNameNode183 *) VisitSetNameNode;
	void (*)(struct ZVisitor169 *,struct ZGroupNode366 *) VisitGroupNode;
	void (*)(struct ZVisitor169 *,struct ZGetterNode357 *) VisitGetterNode;
	void (*)(struct ZVisitor169 *,struct ZSetterNode186 *) VisitSetterNode;
	void (*)(struct ZVisitor169 *,struct ZGetIndexNode349 *) VisitGetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZSetIndexNode180 *) VisitSetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZMethodCallNode405 *) VisitMethodCallNode;
	void (*)(struct ZVisitor169 *,struct ZFuncCallNode409 *) VisitFuncCallNode;
	void (*)(struct ZVisitor169 *,struct ZMacroNode394 *) VisitMacroNode;
	void (*)(struct ZVisitor169 *,struct ZUnaryNode199 *) VisitUnaryNode;
	void (*)(struct ZVisitor169 *,struct ZNotNode418 *) VisitNotNode;
	void (*)(struct ZVisitor169 *,struct ZCastNode323 *) VisitCastNode;
	void (*)(struct ZVisitor169 *,struct ZInstanceOfNode375 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor169 *,struct ZBinaryNode313 *) VisitBinaryNode;
	void (*)(struct ZVisitor169 *,struct ZComparatorNode331 *) VisitComparatorNode;
	void (*)(struct ZVisitor169 *,struct ZAndNode504 *) VisitAndNode;
	void (*)(struct ZVisitor169 *,struct ZOrNode424 *) VisitOrNode;
	void (*)(struct ZVisitor169 *,struct ZBlockNode163 *) VisitBlockNode;
	void (*)(struct ZVisitor169 *,struct ZVarNode508 *) VisitVarNode;
	void (*)(struct ZVisitor169 *,struct ZIfNode369 *) VisitIfNode;
	void (*)(struct ZVisitor169 *,struct ZReturnNode172 *) VisitReturnNode;
	void (*)(struct ZVisitor169 *,struct ZWhileNode202 *) VisitWhileNode;
	void (*)(struct ZVisitor169 *,struct ZBreakNode320 *) VisitBreakNode;
	void (*)(struct ZVisitor169 *,struct ZThrowNode193 *) VisitThrowNode;
	void (*)(struct ZVisitor169 *,struct ZTryNode196 *) VisitTryNode;
	void (*)(struct ZVisitor169 *,struct ZLetNode382 *) VisitLetNode;
	void (*)(struct ZVisitor169 *,struct ZFunctionNode146 *) VisitFunctionNode;
	void (*)(struct ZVisitor169 *,struct ZClassNode518 *) VisitClassNode;
	void (*)(struct ZVisitor169 *,struct ZErrorNode338 *) VisitErrorNode;
	void (*)(struct ZVisitor169 *,struct ZNode55 *) VisitExtendedNode;
	void (*)(struct ZVisitor169 *,struct ZSugarNode167 *) VisitSugarNode;
	void (*)(struct ZVisitor169 *) EnableVisitor;
	void (*)(struct ZVisitor169 *) StopVisitor;
	int (*)(struct ZVisitor169 *) IsVisitable;
	int _classId60;
	int _delta60;
	struct ZTypeChecker143 * TypeChecker;
	struct ZGenerator58 * Generator;
	struct ZLogger136 * Logger;
	int InteractiveContext;
	int _nextId;
};

static void _InitZSourceEngine60(struct ZSourceEngine60 * o) {
	_InitZVisitor169((struct ZVisitor169 *)o);
	o->_classId60 = 60;
	o->_delta60 = sizeof(struct ZSourceEngine60) - sizeof(struct ZVisitor169);
	o->TypeChecker = NULL;
	o->Generator = NULL;
	o->Logger = NULL;
	o->InteractiveContext = 0/*false*/;
	o->IsVisitable = 1/*true*/;
#ifdef _ZSourceEngine60_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qwz
#endif
#ifdef _ZSourceEngine60_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qwz
#endif
#ifdef _ZSourceEngine60_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qwz
#endif
#ifdef _ZSourceEngine60_StopVisitor
	o->StopVisitor = StopVisitor__1qwz
#endif
#ifdef _ZSourceEngine60_IsVisitable
	o->IsVisitable = IsVisitable__1qwz
#endif
	o->_nextId = 0;
}

static struct ZSourceEngine60 * _NewZSourceEngine60(void) {
	struct ZSourceEngine60 *o = LibZen_Malloc(sizeof(struct ZSourceEngine60));
	_InitZSourceEngine60(o);
	return o;
}

struct ZSourceGenerator244 {
	int _classId169;
	int _delta169;
	void (*)(struct ZVisitor169 *,struct ZNullNode421 *) VisitNullNode;
	void (*)(struct ZVisitor169 *,struct ZBooleanNode478 *) VisitBooleanNode;
	void (*)(struct ZVisitor169 *,struct ZIntNode379 *) VisitIntNode;
	void (*)(struct ZVisitor169 *,struct ZFloatNode346 *) VisitFloatNode;
	void (*)(struct ZVisitor169 *,struct ZStringNode433 *) VisitStringNode;
	void (*)(struct ZVisitor169 *,struct ZArrayLiteralNode483 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZMapLiteralNode401 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZNewObjectNode414 *) VisitNewObjectNode;
	void (*)(struct ZVisitor169 *,struct ZGlobalNameNode362 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor169 *,struct ZGetNameNode352 *) VisitGetNameNode;
	void (*)(struct ZVisitor169 *,struct ZSetNameNode183 *) VisitSetNameNode;
	void (*)(struct ZVisitor169 *,struct ZGroupNode366 *) VisitGroupNode;
	void (*)(struct ZVisitor169 *,struct ZGetterNode357 *) VisitGetterNode;
	void (*)(struct ZVisitor169 *,struct ZSetterNode186 *) VisitSetterNode;
	void (*)(struct ZVisitor169 *,struct ZGetIndexNode349 *) VisitGetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZSetIndexNode180 *) VisitSetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZMethodCallNode405 *) VisitMethodCallNode;
	void (*)(struct ZVisitor169 *,struct ZFuncCallNode409 *) VisitFuncCallNode;
	void (*)(struct ZVisitor169 *,struct ZMacroNode394 *) VisitMacroNode;
	void (*)(struct ZVisitor169 *,struct ZUnaryNode199 *) VisitUnaryNode;
	void (*)(struct ZVisitor169 *,struct ZNotNode418 *) VisitNotNode;
	void (*)(struct ZVisitor169 *,struct ZCastNode323 *) VisitCastNode;
	void (*)(struct ZVisitor169 *,struct ZInstanceOfNode375 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor169 *,struct ZBinaryNode313 *) VisitBinaryNode;
	void (*)(struct ZVisitor169 *,struct ZComparatorNode331 *) VisitComparatorNode;
	void (*)(struct ZVisitor169 *,struct ZAndNode504 *) VisitAndNode;
	void (*)(struct ZVisitor169 *,struct ZOrNode424 *) VisitOrNode;
	void (*)(struct ZVisitor169 *,struct ZBlockNode163 *) VisitBlockNode;
	void (*)(struct ZVisitor169 *,struct ZVarNode508 *) VisitVarNode;
	void (*)(struct ZVisitor169 *,struct ZIfNode369 *) VisitIfNode;
	void (*)(struct ZVisitor169 *,struct ZReturnNode172 *) VisitReturnNode;
	void (*)(struct ZVisitor169 *,struct ZWhileNode202 *) VisitWhileNode;
	void (*)(struct ZVisitor169 *,struct ZBreakNode320 *) VisitBreakNode;
	void (*)(struct ZVisitor169 *,struct ZThrowNode193 *) VisitThrowNode;
	void (*)(struct ZVisitor169 *,struct ZTryNode196 *) VisitTryNode;
	void (*)(struct ZVisitor169 *,struct ZLetNode382 *) VisitLetNode;
	void (*)(struct ZVisitor169 *,struct ZFunctionNode146 *) VisitFunctionNode;
	void (*)(struct ZVisitor169 *,struct ZClassNode518 *) VisitClassNode;
	void (*)(struct ZVisitor169 *,struct ZErrorNode338 *) VisitErrorNode;
	void (*)(struct ZVisitor169 *,struct ZNode55 *) VisitExtendedNode;
	void (*)(struct ZVisitor169 *,struct ZSugarNode167 *) VisitSugarNode;
	void (*)(struct ZVisitor169 *) EnableVisitor;
	void (*)(struct ZVisitor169 *) StopVisitor;
	int (*)(struct ZVisitor169 *) IsVisitable;
	int _classId58;
	int _delta58;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace49 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger136 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine60 * (*)(struct ZGenerator58 *) GetEngine;
	void (*)(struct ZGenerator58 *,struct ZNameSpace49 *) ImportLocalGrammar;
	void (*)(struct ZGenerator58 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator58 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator58 *,struct ZNode55 *,int) StartCodeGeneration;
	struct ZType65 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *) GetFieldType;
	struct ZType65 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *) GetSetterType;
	struct ZFuncType91 * (*)(struct ZGenerator58 *,struct ZType65 *,struct ZListNode252 *) GetConstructorFuncType;
	struct ZFuncType91 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *,struct ZListNode252 *) GetMethodFuncType;
	int _classId244;
	int _delta244;
	MapOfString * NativeTypeMap;
	MapOfString * ReservedNameMap;
	ArrayOfZSourceBuilder * BuilderList;
	struct ZSourceBuilder43 * HeaderBuilder;
	struct ZSourceBuilder43 * CurrentBuilder;
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
	void (*)(struct ZSourceGenerator244 *) InitBuilderList;
	void (*)(struct ZSourceGenerator244 *,struct ZType65 *,struct ZNode55 *) GenerateCode;
	int _nextId;
};

static void _InitZSourceGenerator244(struct ZSourceGenerator244 * o) {
	_InitZGenerator58((struct ZGenerator58 *)o);
	o->_classId244 = 244;
	o->_delta244 = sizeof(struct ZSourceGenerator244) - sizeof(struct ZGenerator58);
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
#ifdef _ZSourceGenerator244_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qub
#endif
#ifdef _ZSourceGenerator244_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qub
#endif
#ifdef _ZSourceGenerator244_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qub
#endif
#ifdef _ZSourceGenerator244_StopVisitor
	o->StopVisitor = StopVisitor__1qub
#endif
#ifdef _ZSourceGenerator244_IsVisitable
	o->IsVisitable = IsVisitable__1qub
#endif
#ifdef _ZSourceGenerator244_GetEngine
	o->GetEngine = GetEngine__1qub
#endif
#ifdef _ZSourceGenerator244_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qub
#endif
#ifdef _ZSourceGenerator244_WriteTo
	o->WriteTo = WriteTo__2qub
#endif
#ifdef _ZSourceGenerator244_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qub
#endif
#ifdef _ZSourceGenerator244_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qub
#endif
#ifdef _ZSourceGenerator244_GetFieldType
	o->GetFieldType = GetFieldType__3qub
#endif
#ifdef _ZSourceGenerator244_GetSetterType
	o->GetSetterType = GetSetterType__3qub
#endif
#ifdef _ZSourceGenerator244_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qub
#endif
#ifdef _ZSourceGenerator244_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qub
#endif
#ifdef _ZSourceGenerator244_InitBuilderList
	o->InitBuilderList = InitBuilderList__1qub
#endif
#ifdef _ZSourceGenerator244_GenerateCode
	o->GenerateCode = GenerateCode__3qub
#endif
	o->_nextId = 0;
}

static struct ZSourceGenerator244 * _NewZSourceGenerator244(void) {
	struct ZSourceGenerator244 *o = LibZen_Malloc(sizeof(struct ZSourceGenerator244));
	_InitZSourceGenerator244(o);
	return o;
}

struct ZTypeChecker143 {
	int _classId169;
	int _delta169;
	void (*)(struct ZVisitor169 *,struct ZNullNode421 *) VisitNullNode;
	void (*)(struct ZVisitor169 *,struct ZBooleanNode478 *) VisitBooleanNode;
	void (*)(struct ZVisitor169 *,struct ZIntNode379 *) VisitIntNode;
	void (*)(struct ZVisitor169 *,struct ZFloatNode346 *) VisitFloatNode;
	void (*)(struct ZVisitor169 *,struct ZStringNode433 *) VisitStringNode;
	void (*)(struct ZVisitor169 *,struct ZArrayLiteralNode483 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZMapLiteralNode401 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZNewObjectNode414 *) VisitNewObjectNode;
	void (*)(struct ZVisitor169 *,struct ZGlobalNameNode362 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor169 *,struct ZGetNameNode352 *) VisitGetNameNode;
	void (*)(struct ZVisitor169 *,struct ZSetNameNode183 *) VisitSetNameNode;
	void (*)(struct ZVisitor169 *,struct ZGroupNode366 *) VisitGroupNode;
	void (*)(struct ZVisitor169 *,struct ZGetterNode357 *) VisitGetterNode;
	void (*)(struct ZVisitor169 *,struct ZSetterNode186 *) VisitSetterNode;
	void (*)(struct ZVisitor169 *,struct ZGetIndexNode349 *) VisitGetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZSetIndexNode180 *) VisitSetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZMethodCallNode405 *) VisitMethodCallNode;
	void (*)(struct ZVisitor169 *,struct ZFuncCallNode409 *) VisitFuncCallNode;
	void (*)(struct ZVisitor169 *,struct ZMacroNode394 *) VisitMacroNode;
	void (*)(struct ZVisitor169 *,struct ZUnaryNode199 *) VisitUnaryNode;
	void (*)(struct ZVisitor169 *,struct ZNotNode418 *) VisitNotNode;
	void (*)(struct ZVisitor169 *,struct ZCastNode323 *) VisitCastNode;
	void (*)(struct ZVisitor169 *,struct ZInstanceOfNode375 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor169 *,struct ZBinaryNode313 *) VisitBinaryNode;
	void (*)(struct ZVisitor169 *,struct ZComparatorNode331 *) VisitComparatorNode;
	void (*)(struct ZVisitor169 *,struct ZAndNode504 *) VisitAndNode;
	void (*)(struct ZVisitor169 *,struct ZOrNode424 *) VisitOrNode;
	void (*)(struct ZVisitor169 *,struct ZBlockNode163 *) VisitBlockNode;
	void (*)(struct ZVisitor169 *,struct ZVarNode508 *) VisitVarNode;
	void (*)(struct ZVisitor169 *,struct ZIfNode369 *) VisitIfNode;
	void (*)(struct ZVisitor169 *,struct ZReturnNode172 *) VisitReturnNode;
	void (*)(struct ZVisitor169 *,struct ZWhileNode202 *) VisitWhileNode;
	void (*)(struct ZVisitor169 *,struct ZBreakNode320 *) VisitBreakNode;
	void (*)(struct ZVisitor169 *,struct ZThrowNode193 *) VisitThrowNode;
	void (*)(struct ZVisitor169 *,struct ZTryNode196 *) VisitTryNode;
	void (*)(struct ZVisitor169 *,struct ZLetNode382 *) VisitLetNode;
	void (*)(struct ZVisitor169 *,struct ZFunctionNode146 *) VisitFunctionNode;
	void (*)(struct ZVisitor169 *,struct ZClassNode518 *) VisitClassNode;
	void (*)(struct ZVisitor169 *,struct ZErrorNode338 *) VisitErrorNode;
	void (*)(struct ZVisitor169 *,struct ZNode55 *) VisitExtendedNode;
	void (*)(struct ZVisitor169 *,struct ZSugarNode167 *) VisitSugarNode;
	void (*)(struct ZVisitor169 *) EnableVisitor;
	void (*)(struct ZVisitor169 *) StopVisitor;
	int (*)(struct ZVisitor169 *) IsVisitable;
	int _classId143;
	int _delta143;
	struct ZType65 * StackedContextType;
	struct ZNode55 * ReturnedNode;
	struct ZGenerator58 * Generator;
	struct ZLogger136 * Logger;
	int StoppedVisitor;
	struct ZVarScope135 * VarScope;
	void (*)(struct ZTypeChecker143 *,struct ZFunctionNode146 *,int) DefineFunction;
	int _nextId;
};

static void _InitZTypeChecker143(struct ZTypeChecker143 * o) {
	_InitZVisitor169((struct ZVisitor169 *)o);
	o->_classId143 = 143;
	o->_delta143 = sizeof(struct ZTypeChecker143) - sizeof(struct ZVisitor169);
	o->StackedContextType = NULL;
	o->ReturnedNode = NULL;
	o->Generator = NULL;
	o->Logger = NULL;
	o->StoppedVisitor = 0/*false*/;
	o->VarScope = NULL;
	o->DefineFunction = NULL;
#ifdef _ZTypeChecker143_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qr8
#endif
#ifdef _ZTypeChecker143_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qr8
#endif
#ifdef _ZTypeChecker143_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qr8
#endif
#ifdef _ZTypeChecker143_StopVisitor
	o->StopVisitor = StopVisitor__1qr8
#endif
#ifdef _ZTypeChecker143_IsVisitable
	o->IsVisitable = IsVisitable__1qr8
#endif
#ifdef _ZTypeChecker143_DefineFunction
	o->DefineFunction = DefineFunction__3qr8
#endif
	o->_nextId = 0;
}

static struct ZTypeChecker143 * _NewZTypeChecker143(void) {
	struct ZTypeChecker143 *o = LibZen_Malloc(sizeof(struct ZTypeChecker143));
	_InitZTypeChecker143(o);
	return o;
}

struct CSourceGenerator601 {
	int _classId169;
	int _delta169;
	void (*)(struct ZVisitor169 *,struct ZNullNode421 *) VisitNullNode;
	void (*)(struct ZVisitor169 *,struct ZBooleanNode478 *) VisitBooleanNode;
	void (*)(struct ZVisitor169 *,struct ZIntNode379 *) VisitIntNode;
	void (*)(struct ZVisitor169 *,struct ZFloatNode346 *) VisitFloatNode;
	void (*)(struct ZVisitor169 *,struct ZStringNode433 *) VisitStringNode;
	void (*)(struct ZVisitor169 *,struct ZArrayLiteralNode483 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZMapLiteralNode401 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor169 *,struct ZNewObjectNode414 *) VisitNewObjectNode;
	void (*)(struct ZVisitor169 *,struct ZGlobalNameNode362 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor169 *,struct ZGetNameNode352 *) VisitGetNameNode;
	void (*)(struct ZVisitor169 *,struct ZSetNameNode183 *) VisitSetNameNode;
	void (*)(struct ZVisitor169 *,struct ZGroupNode366 *) VisitGroupNode;
	void (*)(struct ZVisitor169 *,struct ZGetterNode357 *) VisitGetterNode;
	void (*)(struct ZVisitor169 *,struct ZSetterNode186 *) VisitSetterNode;
	void (*)(struct ZVisitor169 *,struct ZGetIndexNode349 *) VisitGetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZSetIndexNode180 *) VisitSetIndexNode;
	void (*)(struct ZVisitor169 *,struct ZMethodCallNode405 *) VisitMethodCallNode;
	void (*)(struct ZVisitor169 *,struct ZFuncCallNode409 *) VisitFuncCallNode;
	void (*)(struct ZVisitor169 *,struct ZMacroNode394 *) VisitMacroNode;
	void (*)(struct ZVisitor169 *,struct ZUnaryNode199 *) VisitUnaryNode;
	void (*)(struct ZVisitor169 *,struct ZNotNode418 *) VisitNotNode;
	void (*)(struct ZVisitor169 *,struct ZCastNode323 *) VisitCastNode;
	void (*)(struct ZVisitor169 *,struct ZInstanceOfNode375 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor169 *,struct ZBinaryNode313 *) VisitBinaryNode;
	void (*)(struct ZVisitor169 *,struct ZComparatorNode331 *) VisitComparatorNode;
	void (*)(struct ZVisitor169 *,struct ZAndNode504 *) VisitAndNode;
	void (*)(struct ZVisitor169 *,struct ZOrNode424 *) VisitOrNode;
	void (*)(struct ZVisitor169 *,struct ZBlockNode163 *) VisitBlockNode;
	void (*)(struct ZVisitor169 *,struct ZVarNode508 *) VisitVarNode;
	void (*)(struct ZVisitor169 *,struct ZIfNode369 *) VisitIfNode;
	void (*)(struct ZVisitor169 *,struct ZReturnNode172 *) VisitReturnNode;
	void (*)(struct ZVisitor169 *,struct ZWhileNode202 *) VisitWhileNode;
	void (*)(struct ZVisitor169 *,struct ZBreakNode320 *) VisitBreakNode;
	void (*)(struct ZVisitor169 *,struct ZThrowNode193 *) VisitThrowNode;
	void (*)(struct ZVisitor169 *,struct ZTryNode196 *) VisitTryNode;
	void (*)(struct ZVisitor169 *,struct ZLetNode382 *) VisitLetNode;
	void (*)(struct ZVisitor169 *,struct ZFunctionNode146 *) VisitFunctionNode;
	void (*)(struct ZVisitor169 *,struct ZClassNode518 *) VisitClassNode;
	void (*)(struct ZVisitor169 *,struct ZErrorNode338 *) VisitErrorNode;
	void (*)(struct ZVisitor169 *,struct ZNode55 *) VisitExtendedNode;
	void (*)(struct ZVisitor169 *,struct ZSugarNode167 *) VisitSugarNode;
	void (*)(struct ZVisitor169 *) EnableVisitor;
	void (*)(struct ZVisitor169 *) StopVisitor;
	int (*)(struct ZVisitor169 *) IsVisitable;
	int _classId58;
	int _delta58;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace49 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger136 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine60 * (*)(struct ZGenerator58 *) GetEngine;
	void (*)(struct ZGenerator58 *,struct ZNameSpace49 *) ImportLocalGrammar;
	void (*)(struct ZGenerator58 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator58 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator58 *,struct ZNode55 *,int) StartCodeGeneration;
	struct ZType65 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *) GetFieldType;
	struct ZType65 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *) GetSetterType;
	struct ZFuncType91 * (*)(struct ZGenerator58 *,struct ZType65 *,struct ZListNode252 *) GetConstructorFuncType;
	struct ZFuncType91 * (*)(struct ZGenerator58 *,struct ZType65 *,const char *,struct ZListNode252 *) GetMethodFuncType;
	int _classId244;
	int _delta244;
	MapOfString * NativeTypeMap;
	MapOfString * ReservedNameMap;
	ArrayOfZSourceBuilder * BuilderList;
	struct ZSourceBuilder43 * HeaderBuilder;
	struct ZSourceBuilder43 * CurrentBuilder;
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
	void (*)(struct ZSourceGenerator244 *) InitBuilderList;
	void (*)(struct ZSourceGenerator244 *,struct ZType65 *,struct ZNode55 *) GenerateCode;
	int _classId601;
	int _delta601;
	int _nextId;
};

static void _InitCSourceGenerator601(struct CSourceGenerator601 * o) {
	_InitZSourceGenerator244((struct ZSourceGenerator244 *)o);
	o->_classId601 = 601;
	o->_delta601 = sizeof(struct CSourceGenerator601) - sizeof(struct ZSourceGenerator244);
#ifdef _CSourceGenerator601_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qgx
#endif
#ifdef _CSourceGenerator601_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qgx
#endif
#ifdef _CSourceGenerator601_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qgx
#endif
#ifdef _CSourceGenerator601_StopVisitor
	o->StopVisitor = StopVisitor__1qgx
#endif
#ifdef _CSourceGenerator601_IsVisitable
	o->IsVisitable = IsVisitable__1qgx
#endif
#ifdef _CSourceGenerator601_GetEngine
	o->GetEngine = GetEngine__1qgx
#endif
#ifdef _CSourceGenerator601_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qgx
#endif
#ifdef _CSourceGenerator601_WriteTo
	o->WriteTo = WriteTo__2qgx
#endif
#ifdef _CSourceGenerator601_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qgx
#endif
#ifdef _CSourceGenerator601_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qgx
#endif
#ifdef _CSourceGenerator601_GetFieldType
	o->GetFieldType = GetFieldType__3qgx
#endif
#ifdef _CSourceGenerator601_GetSetterType
	o->GetSetterType = GetSetterType__3qgx
#endif
#ifdef _CSourceGenerator601_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qgx
#endif
#ifdef _CSourceGenerator601_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qgx
#endif
#ifdef _CSourceGenerator601_InitBuilderList
	o->InitBuilderList = InitBuilderList__1qgx
#endif
#ifdef _CSourceGenerator601_GenerateCode
	o->GenerateCode = GenerateCode__3qgx
#endif
	o->_nextId = 0;
}

static struct CSourceGenerator601 * _NewCSourceGenerator601(void) {
	struct CSourceGenerator601 *o = LibZen_Malloc(sizeof(struct CSourceGenerator601));
	_InitCSourceGenerator601(o);
	return o;
}

struct ZAndNode504 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId313;
	int _delta313;
	struct ZSyntax221 * Pattern;
	int _classId504;
	int _delta504;
	int _nextId;
};

static void _InitZAndNode504(struct ZAndNode504 * o) {
	_InitZBinaryNode313((struct ZBinaryNode313 *)o);
	o->_classId504 = 504;
	o->_delta504 = sizeof(struct ZAndNode504) - sizeof(struct ZBinaryNode313);
#ifdef _ZAndNode504_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qdq
#endif
#ifdef _ZAndNode504_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qdq
#endif
#ifdef _ZAndNode504_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qdq
#endif
#ifdef _ZAndNode504_DeSugar
	o->DeSugar = DeSugar__2qdq
#endif
#ifdef _ZAndNode504_Accept
	o->Accept = Accept__2qdq
#endif
	o->_nextId = 0;
}

static struct ZAndNode504 * _NewZAndNode504(void) {
	struct ZAndNode504 *o = LibZen_Malloc(sizeof(struct ZAndNode504));
	_InitZAndNode504(o);
	return o;
}

struct ZArrayLiteralNode483 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId483;
	int _delta483;
	int _nextId;
};

static void _InitZArrayLiteralNode483(struct ZArrayLiteralNode483 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId483 = 483;
	o->_delta483 = sizeof(struct ZArrayLiteralNode483) - sizeof(struct ZListNode252);
#ifdef _ZArrayLiteralNode483_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qsf
#endif
#ifdef _ZArrayLiteralNode483_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qsf
#endif
#ifdef _ZArrayLiteralNode483_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qsf
#endif
#ifdef _ZArrayLiteralNode483_DeSugar
	o->DeSugar = DeSugar__2qsf
#endif
#ifdef _ZArrayLiteralNode483_Accept
	o->Accept = Accept__2qsf
#endif
	o->_nextId = 0;
}

static struct ZArrayLiteralNode483 * _NewZArrayLiteralNode483(void) {
	struct ZArrayLiteralNode483 *o = LibZen_Malloc(sizeof(struct ZArrayLiteralNode483));
	_InitZArrayLiteralNode483(o);
	return o;
}

struct ZBlockNode163 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId163;
	int _delta163;
	struct ZNameSpace49 * NameSpace;
	int _nextId;
};

static void _InitZBlockNode163(struct ZBlockNode163 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId163 = 163;
	o->_delta163 = sizeof(struct ZBlockNode163) - sizeof(struct ZListNode252);
	o->NameSpace = NULL;
#ifdef _ZBlockNode163_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtk
#endif
#ifdef _ZBlockNode163_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtk
#endif
#ifdef _ZBlockNode163_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtk
#endif
#ifdef _ZBlockNode163_DeSugar
	o->DeSugar = DeSugar__2qtk
#endif
#ifdef _ZBlockNode163_Accept
	o->Accept = Accept__2qtk
#endif
	o->_nextId = 0;
}

static struct ZBlockNode163 * _NewZBlockNode163(void) {
	struct ZBlockNode163 *o = LibZen_Malloc(sizeof(struct ZBlockNode163));
	_InitZBlockNode163(o);
	return o;
}

struct ZBooleanNode478 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId334;
	int _delta334;
	int _classId478;
	int _delta478;
	int BooleanValue;
	int _nextId;
};

static void _InitZBooleanNode478(struct ZBooleanNode478 * o) {
	_InitZConstNode334((struct ZConstNode334 *)o);
	o->_classId478 = 478;
	o->_delta478 = sizeof(struct ZBooleanNode478) - sizeof(struct ZConstNode334);
	o->BooleanValue = 0/*false*/;
#ifdef _ZBooleanNode478_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qs0
#endif
#ifdef _ZBooleanNode478_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qs0
#endif
#ifdef _ZBooleanNode478_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qs0
#endif
#ifdef _ZBooleanNode478_DeSugar
	o->DeSugar = DeSugar__2qs0
#endif
#ifdef _ZBooleanNode478_Accept
	o->Accept = Accept__2qs0
#endif
	o->_nextId = 0;
}

static struct ZBooleanNode478 * _NewZBooleanNode478(void) {
	struct ZBooleanNode478 *o = LibZen_Malloc(sizeof(struct ZBooleanNode478));
	_InitZBooleanNode478(o);
	return o;
}

struct ZClassNode518 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId518;
	int _delta518;
	const char * ClassName;
	struct ZClassType81 * ClassType;
	struct ZType65 * SuperType;
	struct ZToken78 * NameToken;
	struct ZToken78 * SuperToken;
	int _nextId;
};

static void _InitZClassNode518(struct ZClassNode518 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId518 = 518;
	o->_delta518 = sizeof(struct ZClassNode518) - sizeof(struct ZListNode252);
	o->ClassName = NULL;
	o->ClassType = NULL;
	o->SuperType = NULL;
	o->NameToken = NULL;
	o->SuperToken = NULL;
#ifdef _ZClassNode518_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qdd
#endif
#ifdef _ZClassNode518_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qdd
#endif
#ifdef _ZClassNode518_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qdd
#endif
#ifdef _ZClassNode518_DeSugar
	o->DeSugar = DeSugar__2qdd
#endif
#ifdef _ZClassNode518_Accept
	o->Accept = Accept__2qdd
#endif
	o->_nextId = 0;
}

static struct ZClassNode518 * _NewZClassNode518(void) {
	struct ZClassNode518 *o = LibZen_Malloc(sizeof(struct ZClassNode518));
	_InitZClassNode518(o);
	return o;
}

struct ZFuncCallNode409 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId409;
	int _delta409;
	int _nextId;
};

static void _InitZFuncCallNode409(struct ZFuncCallNode409 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId409 = 409;
	o->_delta409 = sizeof(struct ZFuncCallNode409) - sizeof(struct ZListNode252);
#ifdef _ZFuncCallNode409_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4s
#endif
#ifdef _ZFuncCallNode409_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4s
#endif
#ifdef _ZFuncCallNode409_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4s
#endif
#ifdef _ZFuncCallNode409_DeSugar
	o->DeSugar = DeSugar__2q4s
#endif
#ifdef _ZFuncCallNode409_Accept
	o->Accept = Accept__2q4s
#endif
	o->_nextId = 0;
}

static struct ZFuncCallNode409 * _NewZFuncCallNode409(void) {
	struct ZFuncCallNode409 *o = LibZen_Malloc(sizeof(struct ZFuncCallNode409));
	_InitZFuncCallNode409(o);
	return o;
}

struct ZFunctionNode146 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId146;
	int _delta146;
	struct ZType65 * ReturnType;
	const char * FuncName;
	struct ZToken78 * NameToken;
	struct ZFunctionNode146 * ParentFunctionNode;
	struct ZFuncType91 * ResolvedFuncType;
	long VarIndex;
	int _nextId;
};

static void _InitZFunctionNode146(struct ZFunctionNode146 * o) {
	_InitZListNode252((struct ZListNode252 *)o);
	o->_classId146 = 146;
	o->_delta146 = sizeof(struct ZFunctionNode146) - sizeof(struct ZListNode252);
	o->ReturnType = /*untyped*/NULL;
	o->FuncName = NULL;
	o->NameToken = NULL;
	o->ParentFunctionNode = NULL;
	o->ResolvedFuncType = NULL;
	o->VarIndex = 0;
#ifdef _ZFunctionNode146_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qte
#endif
#ifdef _ZFunctionNode146_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qte
#endif
#ifdef _ZFunctionNode146_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qte
#endif
#ifdef _ZFunctionNode146_DeSugar
	o->DeSugar = DeSugar__2qte
#endif
#ifdef _ZFunctionNode146_Accept
	o->Accept = Accept__2qte
#endif
	o->_nextId = 0;
}

static struct ZFunctionNode146 * _NewZFunctionNode146(void) {
	struct ZFunctionNode146 *o = LibZen_Malloc(sizeof(struct ZFunctionNode146));
	_InitZFunctionNode146(o);
	return o;
}

struct ZVarNode508 {
	int _classId55;
	int _delta55;
	struct ZNode55 * ParentNode;
	struct ZToken78 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType65 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode55 *,struct ZToken78 *,const char *) SetNameInfo;
	void (*)(struct ZNode55 *,struct ZToken78 *,struct ZType65 *) SetTypeInfo;
	int (*)(struct ZNode55 *) IsBreakingBlock;
	struct ZSugarNode167 * (*)(struct ZNode55 *,struct ZGenerator58 *) DeSugar;
	void (*)(struct ZNode55 *,struct ZVisitor169 *) Accept;
	int _classId252;
	int _delta252;
	long ListStartIndex;
	int _classId163;
	int _delta163;
	struct ZNameSpace49 * NameSpace;
	int _classId508;
	int _delta508;
	struct ZType65 * DeclType;
	const char * NativeName;
	struct ZToken78 * TypeToken;
	struct ZToken78 * NameToken;
	int _nextId;
};

static void _InitZVarNode508(struct ZVarNode508 * o) {
	_InitZBlockNode163((struct ZBlockNode163 *)o);
	o->_classId508 = 508;
	o->_delta508 = sizeof(struct ZVarNode508) - sizeof(struct ZBlockNode163);
	o->DeclType = /*untyped*/NULL;
	o->NativeName = NULL;
	o->TypeToken = NULL;
	o->NameToken = NULL;
#ifdef _ZVarNode508_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qdt
#endif
#ifdef _ZVarNode508_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qdt
#endif
#ifdef _ZVarNode508_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qdt
#endif
#ifdef _ZVarNode508_DeSugar
	o->DeSugar = DeSugar__2qdt
#endif
#ifdef _ZVarNode508_Accept
	o->Accept = Accept__2qdt
#endif
	o->_nextId = 0;
}

static struct ZVarNode508 * _NewZVarNode508(void) {
	struct ZVarNode508 *o = LibZen_Malloc(sizeof(struct ZVarNode508));
	_InitZVarNode508(o);
	return o;
}

static long ZTypeUniqueTypeFlag_Z0 = 1 << 16;
static long ZTypeUnboxTypeFlag_Z1 = 1 << 10;
static long ZTypeOpenTypeFlag_Z2 = 1 << 9;
static struct ZType65 * ZTypeVarType_Z3 = ZType__4qwn(_NewZType65(), ZTypeUniqueTypeFlag_Z0, "var", NULL);
static struct ZType65 * ZTypeVoidType_Z4 = ZType__4qwn(_NewZType65(), ZTypeUniqueTypeFlag_Z0, "void", NULL);
static struct ZType65 * ZTypeBooleanType_Z5 = ZType__4qwn(_NewZType65(), ZTypeUniqueTypeFlag_Z0, "boolean", ZTypeVarType_Z3);
static struct ZType65 * ZTypeIntType_Z6 = ZType__4qwn(_NewZType65(), ZTypeUniqueTypeFlag_Z0, "int", ZTypeVarType_Z3);
static struct ZType65 * ZTypeFloatType_Z7 = ZType__4qwn(_NewZType65(), ZTypeUniqueTypeFlag_Z0, "float", ZTypeVarType_Z3);
static struct ZType65 * ZTypeStringType_Z8 = ZType__4qwn(_NewZType65(), ZTypeUniqueTypeFlag_Z0, "String", ZTypeVarType_Z3);
static struct ZType65 * ZTypeTypeType_Z9 = ZType__4qwn(_NewZType65(), ZTypeUniqueTypeFlag_Z0, "Type", ZTypeVarType_Z3);
static struct ZGeneric1Type108 * ZTypeArrayType_Z10 = ZGeneric1Type__5qrq(_NewZGeneric1Type108(), ZTypeUniqueTypeFlag_Z0, "Array", NULL, ZTypeVarType_Z3);
static struct ZGeneric1Type108 * ZTypeMapType_Z11 = ZGeneric1Type__5qrq(_NewZGeneric1Type108(), ZTypeUniqueTypeFlag_Z0, "Map", NULL, ZTypeVarType_Z3);
static struct ZFuncType91 * ZTypeFuncType_Z12 = ZFuncType__3qek(_NewZFuncType91(), "Func", NULL);
static const char * ZFunc_NativeNameConnector_Z13 = "__";
static long ZFunc_CoercionFunc_Z14 = (1 << 17) | /*untyped*/NULL;
static long ZFunc_ConverterFunc_Z15 = 1 << 16;
static const char * ZFunc_StringfySignature__3qqy(const char * FuncName, long FuncParamSize__1, struct ZType65 * RecvType__2) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(FuncName, "__"), LibZen_IntToString(FuncParamSize)), GetUniqueName__1qwn(RecvType));
}
static ArrayOfZType * ZGreekType_NewGreekTypes__1qwm(ArrayOfZType * GreekTypes) {
	if (GreekTypes == NULL) {
		return /*untyped*/NULL;
	} else {
		long i = 0;
		while (i < /*untyped*/NULL(GreekTypes)) {
			Array<ZType>SetIndex(i, NULL);
			i = i + 1;
		};
		return GreekTypes;
	};
}
static ArrayOfZType * ZTypePool_TypeList_Z16 = LibZen_NewArray(0);
static var null = /*untyped*/NULL;
static long ZTypePool_NewTypeId__1qwn(struct ZType65 * T) {
	long TypeId = LibZen_ArraySize((ArrayOfVar *)ZTypePool_TypeList_Z16);
	LibZen_ArrayAdd((ArrayOfVar *)ZTypePool_TypeList_Z16, (var)T);
	return TypeId;
}
static struct ZType65 * TypeOf__1qqr(long TypeId) {
	if (TypeId == 0) {
		return ZTypeVarType_Z3;
	};
	if (TypeId < LibZen_ArraySize((ArrayOfVar *)ZTypePool_TypeList_Z16)) {
		return Array<ZType>GetIndex(TypeId);
	};
	return ZTypeVarType_Z3;
}
static struct ZType65 * GetGreekType__1qqr(long GreekId) {
	if (/*untyped*/NULL == /*untyped*/NULL) {
		varSetIndex(GreekId, ZGreekType__2qro(_NewZGreekType116(), GreekId));
	};
	return /*untyped*/NULL;
}
static MapOfZType * ZTypePool_ClassNameMap_Z17 = LibZen_NewMap(0);
static MapOfArrayOfZType * ZTypePool_UniqueTypeSetMap_Z18 = LibZen_NewMap(0);
static const char * ZTypePool_MangleType2__2qwn(struct ZType65 * Type1, struct ZType65 * Type2__1) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(Type1->TypeId)), ":"), LibZen_IntToString(Type2->TypeId));
}
static const char * ZTypePool_MangleTypes__1qwm(ArrayOfZType * TypeList) {
	const char * s = "";
	long i = 0;
	while (i < LibZen_ArraySize((ArrayOfVar *)TypeList)) {
		struct ZType65 * Type = Array<ZType>GetIndex(i);
		s = LibZen_StrCat(LibZen_StrCat(s, ":"), LibZen_IntToString(Type->TypeId));
		i = i + 1;
	};
	return s;
}
static ArrayOfZType * ZTypePool_UniqueTypes__1qwm(ArrayOfZType * TypeList) {
	const char * MangleName = LibZen_StrCat("[]", ZTypePool_MangleTypes__1qwm(TypeList));
	ArrayOfZType * Types = Map<Array<ZType>>GetIndex(MangleName);
	if (Types == NULL) {
		Types = /*untyped*/NULL;
		Map<Array<ZType>>SetIndex(MangleName, Types);
	};
	return Types;
}
static struct ZType65 * ZTypePool_GetGenericType1__2qwn(struct ZType65 * BaseType, struct ZType65 * ParamType__1) {
	const char * MangleName = ZTypePool_MangleType2__2qwn(BaseType, ParamType);
	struct ZType65 * GenericType = Map<ZType>GetIndex(MangleName);
	if (GenericType == NULL) {
		const char * Name = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), ThrowError("type error: requested = String, given = ZType")), ">");
		if (IsArrayType__1qwn(BaseType)) {
			Name = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), ThrowError("type error: requested = String, given = ZType")), ">");
		};
		GenericType = ZGeneric1Type__5qrq(_NewZGeneric1Type108(), ZTypeUniqueTypeFlag_Z0, Name, BaseType, ParamType);
		Map<ZType>SetIndex(MangleName, GenericType);
	};
	return GenericType;
}
static struct ZType65 * ZTypePool_GetGenericType__3qwn(struct ZType65 * BaseType, ArrayOfZType * TypeList__1, int IsCreation__2) {
	LibZen_Assert(BaseType->GetParamSize(BaseType) > 0, "(libzen/libzen.zen:1278)");
	if (LibZen_ArraySize((ArrayOfVar *)TypeList) == 1 && !IsFuncType__1qwn(BaseType)) {
		return ZTypePool_GetGenericType1__2qwn(BaseType, Array<ZType>GetIndex(0));
	};
	const char * MangleName = LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(BaseType->TypeId)), ZTypePool_MangleTypes__1qwm(TypeList));
	struct ZType65 * GenericType = Map<ZType>GetIndex(MangleName);
	if ((GenericType == NULL) && IsCreation) {
		const char * ShortName = LibZen_StrCat(BaseType->ShortName, "<");
		long i = 0;
		while (i < /*untyped*/NULL(TypeList)) {
			ShortName = LibZen_StrCat(ShortName, Array<ZType>GetIndex(i)->GetRealType(Array<ZType>GetIndex(i))->ShortName);
			if ((i + 1) == /*untyped*/NULL(TypeList)) {
				ShortName = LibZen_StrCat(ShortName, ">");
			} else {
				ShortName = LibZen_StrCat(ShortName, ",");
			};
			i = i + 1;
		};
		if (IsFuncType__1qwn(BaseType)) {
			GenericType = ZFuncType__3qek(_NewZFuncType91(), ShortName, ZTypePool_UniqueTypes__1qwm(TypeList));
		} else {
		};
		Map<ZType>SetIndex(MangleName, GenericType);
	};
	return GenericType;
}
static struct ZFuncType91 * ZTypePool_LookupFuncType__1qwm(ArrayOfZType * TypeList) {
	struct ZType65 * FuncType = ZTypePool_GetGenericType__3qwn(ZTypeFuncType_Z12, TypeList, 1/*true*/);
	if (LibZen_Is(FuncType, 91)) {
		return (struct ZFuncType91 *)FuncType;
	};
	return NULL;
}
static struct ZFuncType91 * ZTypePool_LookupFuncType__1qwn(struct ZType65 * R) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	return ZTypePool_LookupFuncType__1qwm(TypeList);
}
static struct ZFuncType91 * ZTypePool_LookupFuncType__2qwn(struct ZType65 * R, struct ZType65 * P1__1) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P1);
	return ZTypePool_LookupFuncType__1qwm(TypeList);
}
static struct ZFuncType91 * ZTypePool_LookupFuncType__3qwn(struct ZType65 * R, struct ZType65 * P1__1, struct ZType65 * P2__2) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P1);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P2);
	return ZTypePool_LookupFuncType__1qwm(TypeList);
}
static struct ZFuncType91 * ZTypePool_LookupFuncType__4qwn(struct ZType65 * R, struct ZType65 * P1__1, struct ZType65 * P2__2, struct ZType65 * P3__3) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)R);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P1);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P2);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)P3);
	return ZTypePool_LookupFuncType__1qwm(TypeList);
}
static long ZNode_Nop_Z19 = -1;
static long ZNode_NameInfo_Z20 = -2;
static long ZNode_TypeInfo_Z21 = -3;
static long ZNode_AppendIndex_Z22 = -4;
static long ZNode_NestedAppendIndex_Z23 = -5;
static long ZReturnNode_Expr_Z24 = 0;
static long ZSetIndexNode_Recv_Z25 = 0;
static long ZSetIndexNode_Index_Z26 = 1;
static long ZSetIndexNode_Expr_Z27 = 2;
static long ZSetNameNode_Expr_Z28 = 0;
static long ZSetterNode_Recv_Z29 = 0;
static long ZSetterNode_Expr_Z30 = 1;
static long ZSugarNode_DeSugar_Z31 = 0;
static long ZThrowNode_Expr_Z32 = 0;
static long ZTryNode_Try_Z33 = 0;
static long ZTryNode_Catch_Z34 = 1;
static long ZTryNode_Finally_Z35 = 2;
static long ZUnaryNode_Recv_Z36 = 0;
static long ZWhileNode_Cond_Z37 = 0;
static long ZWhileNode_Block_Z38 = 1;
static struct ZEmptyValue205 * ZEmptyValue_TrueEmpty_Z39 = _NewZEmptyValue205();
static struct ZEmptyValue205 * ZEmptyValue_FalseEmpty_Z40 = _NewZEmptyValue205();
static const char * ZLogger_LogError__2qeu(struct ZToken78 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu6(Token->Source, "error", Token->StartIndex, Message);
		Report__2qrb(Token->Source->Logger, Message);
	};
	return Message;
}
static void ZLogger_LogWarning__2qeu(struct ZToken78 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu6(Token->Source, "warning", Token->StartIndex, Message);
		Report__2qrb(Token->Source->Logger, Message);
	};
	return;
}
static void ZLogger_LogInfo__2qeu(struct ZToken78 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu6(Token->Source, "info", Token->StartIndex, Message);
		Report__2qrb(Token->Source->Logger, Message);
	};
	return;
}
static void ZLogger_LogDebug__2qeu(struct ZToken78 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qu6(Token->Source, "debug", Token->StartIndex, Message);
		Report__2qrb(Token->Source->Logger, Message);
	};
	return;
}
static const char * ZNameSpace_RightPatternSymbol__1qqy(const char * PatternName) {
	return LibZen_StrCat("\t", PatternName);
}
static const char * ProgName_Z41 = "LibZen";
static const char * CodeName_Z42 = "Reference Implementation of D-Script";
static long MajorVersion_Z43 = 0;
static long MinerVersion_Z44 = 1;
static long PatchLevel_Z45 = 0;
static const char * Version_Z46 = "0.1";
static const char * Copyright_Z47 = "Copyright (c) 2013-2014, Konoha project authors";
static const char * License_Z48 = "BSD-Style Open Source";
static long ZSyntax_LeftJoin_Z49 = 1 << 1;
static long ZSyntax_BinaryOperator_Z50 = 1;
static struct ZSyntax221 * MergeSyntaxPattern__2quy(struct ZSyntax221 * Pattern, struct ZSyntax221 * Parent__1) {
	if (Parent == NULL) {
		return Pattern;
	};
	struct ZSyntax221 * MergedPattern = ZSyntax__4quy(_NewZSyntax221(), Pattern->PackageNameSpace, Pattern->PatternName, Pattern->MatchFunc);
	MergedPattern->ParentPattern = Parent;
	return MergedPattern;
}
static struct ZToken78 * ZToken_NullToken_Z51 = ZToken__4qeu(_NewZToken78(), NULL, 0, 0);
static int ZTokenContext_Required_Z52 = 1/*true*/;
static int ZTokenContext_Optional_Z53 = 0/*false*/;
static int ZTokenContext_AllowSkipIndent_Z54 = 1/*true*/;
static int ZTokenContext_NotAllowSkipIndent_Z55 = 0/*false*/;
static int ZTokenContext_AllowNewLine_Z56 = 1/*true*/;
static int ZTokenContext_MoveNext_Z57 = 1/*true*/;
static long ZAssertNode_Expr_Z58 = 0;
static long ZBinaryNode_Left_Z59 = 0;
static long ZBinaryNode_Right_Z60 = 1;
static long ZCastNode_Expr_Z61 = 0;
static long ZCatchNode_Block_Z62 = 0;
static long ZFieldNode_InitValue_Z63 = 0;
static long ZGetIndexNode_Recv_Z64 = 0;
static long ZGetIndexNode_Index_Z65 = 1;
static long ZGetterNode_Recv_Z66 = 0;
static long ZGroupNode_Expr_Z67 = 0;
static long ZIfNode_Cond_Z68 = 0;
static long ZIfNode_Then_Z69 = 1;
static long ZIfNode_Else_Z70 = 2;
static long ZInstanceOfNode_Left_Z71 = 0;
static long ZLetNode_InitValue_Z72 = 0;
static long ZMapEntryNode_Key_Z73 = 0;
static long ZMapEntryNode_Value_Z74 = 1;
static long ZMethodCallNode_Recv_Z75 = 0;
static long ZTypeChecker_DefaultTypeCheckPolicy_Z76 = 0;
static long ZTypeChecker_NoCheckPolicy_Z77 = 1;
static long ZFuncCallNode_Func_Z78 = 0;
static long ZFunctionNode_Block_Z79 = 0;
static long ZVarNode_InitValue_Z80 = 0;
static struct ZSyntax221 * ExpressionPattern_GetRightPattern__2qws(struct ZNameSpace49 * NameSpace, struct ZTokenContext56 * TokenContext__1) {
	struct ZToken78 * Token = GetToken__1qwl(TokenContext);
	if (Token != ZToken_NullToken_Z51) {
		struct ZSyntax221 * Pattern = GetRightSyntaxPattern__2qws(NameSpace, GetText__1qeu(Token));
		return Pattern;
	};
	return NULL;
}
static struct ZNode55 * ExpressionPattern_DispatchPattern__5qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2, int AllowStatement__3, int AllowBinary__4) {
	struct ZToken78 * Token = GetToken__1qwl(TokenContext);
	struct ZSyntax221 * Pattern = NULL;
	struct ZNameSpace49 * NameSpace = GetNameSpace__1qwk(ParentNode);
	if (LibZen_Is(Token, 464)) {
		Pattern = ((struct ZPatternToken464 *)Token)->PresetPattern;
	} else {
		Pattern = GetSyntaxPattern__2qws(NameSpace, GetText__1qeu(Token));
	};
	if (Pattern != NULL) {
		if (Pattern->IsStatement && !AllowStatement) {
			return ZErrorNode__4qpd(_NewZErrorNode338(), ParentNode, Token, LibZen_StrCat(GetText__1qeu(Token), " statement is not here"));
		};
		LeftNode = ApplyMatchPattern__5qwl(TokenContext, ParentNode, LeftNode, Pattern, ZTokenContext_Required_Z52);
	} else {
		if (IsNameSymbol__1qeu(Token)) {
			if (AllowStatement) {
				Pattern = GetSyntaxPattern__2qws(NameSpace, "$SymbolStatement$");
			} else {
				Pattern = GetSyntaxPattern__2qws(NameSpace, "$SymbolExpression$");
			};
			LeftNode = ApplyMatchPattern__5qwl(TokenContext, ParentNode, LeftNode, Pattern, ZTokenContext_Required_Z52);
		} else {
			if (AllowStatement) {
				return CreateExpectedErrorNode__3qwl(TokenContext, Token, "statement");
			} else {
				return CreateExpectedErrorNode__3qwl(TokenContext, Token, "expression");
			};
		};
	};
	if (!Pattern->IsStatement) {
		while (LeftNode != NULL && !IsErrorNode__1qwk(LeftNode)) {
			struct ZSyntax221 * RightPattern = ExpressionPattern_GetRightPattern__2qws(NameSpace, TokenContext);
			if (RightPattern == NULL) {
				break;
			};
			if (!AllowBinary && IsBinaryOperator__1quy(RightPattern)) {
				break;
			};
			LeftNode = ApplyMatchPattern__5qwl(TokenContext, ParentNode, LeftNode, RightPattern, ZTokenContext_Required_Z52);
		};
	};
	return LeftNode;
}
static const char * NumberLiteralToken_ParseDigit__1qwg(struct ZSourceContext52 * SourceContext) {
	const char * ch = ThrowError("type error: requested = String, given = int");
	while (HasChar__1qwg(SourceContext)) {
		ch = GetCurrentChar__1qwg(SourceContext);
		if (!LibZen_IsDigit__1qqy(ch)) {
			break;
		};
		MoveNext__1qwg(SourceContext);
	};
	return ch;
}
static struct ZType65 * ZType__4qwn(struct ZType65 * this, long TypeFlag__1, const char * ShortName__2, struct ZType65 * RefType__3) {
	this->TypeFlag = TypeFlag;
	this->ShortName = ShortName;
	this->RefType = RefType;
	if (LibZen_IsFlag__2qqr(TypeFlag, ZTypeUniqueTypeFlag_Z0)) {
		this->TypeId = ZTypePool_NewTypeId__1qwn(this);
	};
	return NULL;
}
static struct ZType65 * GetRealType__1qwn(struct ZType65 * this) {
	return this;
}
static struct ZType65 * GetSuperType__1qwn(struct ZType65 * this) {
	return this->RefType;
}
static struct ZType65 * GetBaseType__1qwn(struct ZType65 * this) {
	return this;
}
static long GetParamSize__1qwn(struct ZType65 * this) {
	return 0;
}
static struct ZType65 * GetParamType__2qwn(struct ZType65 * this, long Index__1) {
	return ZTypeVarType_Z3;
}
static int Equals__2qwn(struct ZType65 * this, struct ZType65 * Type__1) {
	return (/*untyped*/NULL(this) == Type->GetRealType(Type));
}
static int Accept__2qwn(struct ZType65 * this, struct ZType65 * Type__1) {
	struct ZType65 * ThisType = /*untyped*/NULL(this);
	if (ThisType == Type->GetRealType(Type)) {
		return 1/*true*/;
	};
	struct ZType65 * SuperClass = /*untyped*/NULL(Type);
	while (SuperClass != NULL) {
		if (SuperClass == ThisType) {
			return 1/*true*/;
		};
		SuperClass = /*untyped*/NULL(SuperClass);
	};
	return 0/*false*/;
}
static int IsGreekType__1qwn(struct ZType65 * this) {
	return 0/*false*/;
}
static struct ZType65 * GetGreekRealType__2qwn(struct ZType65 * this, ArrayOfZType * Greek__1) {
	return /*untyped*/NULL(this);
}
static int AcceptValueType__4qwn(struct ZType65 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (/*untyped*/NULL(this) != ValueType && !/*untyped*/NULL(ValueType)) {
		if (ExactMatch && !Accept__2qwn(this, ValueType)) {
			return 0/*false*/;
		};
	};
	return 1/*true*/;
}
static int IsVoidType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeVoidType_Z4);
}
static int IsVarType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeVarType_Z3);
}
static int IsInferrableType__1qwn(struct ZType65 * this) {
	return (!/*untyped*/NULL(this) && !IsVoidType__1qwn(this));
}
static int IsTypeType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeTypeType_Z9);
}
static int IsBooleanType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeBooleanType_Z5);
}
static int IsIntType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeIntType_Z6);
}
static int IsFloatType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeFloatType_Z7);
}
static int IsNumberType__1qwn(struct ZType65 * this) {
	return (IsIntType__1qwn(this) || IsFloatType__1qwn(this));
}
static int IsStringType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeStringType_Z8);
}
static int IsArrayType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeArrayType_Z10);
}
static int IsMapType__1qwn(struct ZType65 * this) {
	return (/*untyped*/NULL(this) == ZTypeMapType_Z11);
}
static int IsOpenType__1qwn(struct ZType65 * this) {
	return LibZen_IsFlag__2qqr(this->TypeFlag, ZTypeOpenTypeFlag_Z2);
}
static int IsImmutableType__1qwn(struct ZType65 * this) {
	return 0/*false*/;
}
static int IsNullableType__1qwn(struct ZType65 * this) {
	return 1/*true*/;
}
static const char * toString__1qwn(struct ZType65 * this) {
	return this->ShortName;
}
static const char * GetAsciiName__1qwn(struct ZType65 * this) {
	return this->ShortName;
}
static const char * StringfyClassMember__2qwn(struct ZType65 * this, const char * Name__1) {
	return LibZen_StrCat(LibZen_StrCat(Name, " of "), this->ShortName);
}
static const char * GetUniqueName__1qwn(struct ZType65 * this) {
	return LibZen_Stringfy__1qqr(this->TypeId);
}
static int IsFuncType__1qwn(struct ZType65 * this) {
	return (LibZen_Is(/*untyped*/NULL(this), 91));
}
static const char * StringfySignature__2qwn(struct ZType65 * this, const char * FuncName__1) {
	return FuncName;
}
static void Maybe__3qwn(struct ZType65 * this, struct ZType65 * T__1, struct ZToken78 * SourceToken__2) {
	return;
}
static struct ZClassField80 * ZClassField__5qeo(struct ZClassField80 * this, struct ZClassType81 * ClassType__1, const char * FieldName__2, struct ZType65 * FieldType__3, struct ZToken78 * SourceToken__4) {
	this->ClassType = ClassType;
	this->FieldType = FieldType;
	this->FieldName = FieldName;
	this->SourceToken = SourceToken;
	return NULL;
}
static struct ZClassType81 * ZClassType__3qep(struct ZClassType81 * this, const char * ShortName__1, struct ZType65 * RefType__2) {
	(void)ZType__4qwn(this, ZTypeOpenTypeFlag_Z2 | ZTypeUniqueTypeFlag_Z0, ShortName, RefType);
	if (LibZen_Is(RefType, 81)) {
		ResetSuperType__2qep(this, (struct ZClassType81 *)RefType);
	};
	return NULL;
}
static void ResetSuperType__2qep(struct ZClassType81 * this, struct ZClassType81 * SuperClass__1) {
	this->RefType = SuperClass;
	if (SuperClass->FieldList != NULL) {
		this->FieldList = LibZen_NewArray(0);
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)SuperClass->FieldList)) {
			struct ZClassField80 * Field = Array<ZClassField>GetIndex(i);
			LibZen_ArrayAdd((ArrayOfVar *)this->FieldList, (var)Field);
			i = i + 1;
		};
	};
	return;
}
static long GetFieldSize__1qep(struct ZClassType81 * this) {
	if (this->FieldList != NULL) {
		return LibZen_ArraySize((ArrayOfVar *)this->FieldList);
	};
	return 0;
}
static struct ZClassField80 * GetFieldAt__2qep(struct ZClassType81 * this, long Index__1) {
	return Array<ZClassField>GetIndex(Index);
}
static int HasField__2qep(struct ZClassType81 * this, const char * FieldName__1) {
	if (this->FieldList != NULL) {
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)this->FieldList)) {
			if (LibZen_EqualsString__2qqy(FieldName, Array<ZClassField>GetIndex(i)->FieldName)) {
				return 1/*true*/;
			};
			i = i + 1;
		};
	};
	return 0/*false*/;
}
static struct ZType65 * GetFieldType__3qep(struct ZClassType81 * this, const char * FieldName__1, struct ZType65 * DefaultType__2) {
	if (this->FieldList != NULL) {
		long i = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)this->FieldList)) {
			struct ZClassField80 * Field = Array<ZClassField>GetIndex(i);
			if (LibZen_EqualsString__2qqy(FieldName, Field->FieldName)) {
				return Field->FieldType;
			};
			i = i + 1;
		};
	};
	return DefaultType;
}
static struct ZClassField80 * AppendField__4qep(struct ZClassType81 * this, struct ZType65 * FieldType__1, const char * FieldName__2, struct ZToken78 * SourceToken__3) {
	LibZen_Assert(!/*untyped*/NULL(FieldType), "(libzen/libzen.zen:1719)");
	if (this->FieldList == NULL) {
		this->FieldList = LibZen_NewArray(0);
	};
	struct ZClassField80 * ClassField = ZClassField__5qeo(_NewZClassField80(), this, FieldName, FieldType, SourceToken);
	LibZen_ArrayAdd((ArrayOfVar *)this->FieldList, (var)ClassField);
	return ClassField;
}
static struct ZFunc90 * ZFunc__4qej(struct ZFunc90 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType91 * FuncType__3) {
	this->FuncFlag = FuncFlag;
	this->FuncName = FuncName;
	this->FuncType = FuncType;
	return NULL;
}
static struct ZFuncType91 * GetFuncType__1qej(struct ZFunc90 * this) {
	return this->FuncType;
}
static const char * toString__1qej(struct ZFunc90 * this) {
	return LibZen_StrCat(LibZen_StrCat(this->FuncName, ": "), ThrowError("type error: requested = String, given = ZFuncType"));
}
static int IsConverterFunc__1qej(struct ZFunc90 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_ConverterFunc_Z15);
}
static int IsCoercionFunc__1qej(struct ZFunc90 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_CoercionFunc_Z14);
}
static int Is__2qej(struct ZFunc90 * this, long Flag__1) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, Flag);
}
static const char * GetSignature__1qej(struct ZFunc90 * this) {
	return StringfySignature__2qek(this->FuncType, this->FuncName);
}
static struct ZFuncType91 * ZFuncType__3qek(struct ZFuncType91 * this, const char * ShortName__1, ArrayOfZType * UniqueTypeParams__2) {
	(void)ZType__4qwn(this, ZTypeUniqueTypeFlag_Z0, ShortName, ZTypeVarType_Z3);
	if (UniqueTypeParams == NULL) {
		this->TypeParams = /*untyped*/NULL;
		Array<ZType>SetIndex(0, ZTypeVarType_Z3);
	} else {
		this->TypeParams = UniqueTypeParams;
	};
	long i = 0;
	while (i < /*untyped*/NULL(this->TypeParams)) {
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
static int IsFuncType__1qek(struct ZFuncType91 * this) {
	return 1/*true*/;
}
static int IsVarType__1qek(struct ZFuncType91 * this) {
	return this->HasUnknownType;
}
static int IsGreekType__1qek(struct ZFuncType91 * this) {
	return this->HasGreekType;
}
static struct ZType65 * GetGreekRealType__2qek(struct ZFuncType91 * this, ArrayOfZType * Greek__1) {
	if (this->HasGreekType) {
		ArrayOfZType * TypeList = LibZen_NewArray(0);
		long i = 0;
		while (i < /*untyped*/NULL(this->TypeParams)) {
			LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)Array<ZType>GetIndex(i)->GetGreekRealType(Array<ZType>GetIndex(i), Greek));
			i = i + 1;
		};
		return ZTypePool_LookupFuncType__1qwm(TypeList);
	};
	return this;
}
static int AcceptValueType__4qek(struct ZFuncType91 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (IsFuncType__1qwn(ValueType) && ValueType->GetParamSize(ValueType) == this->GetParamSize(this)) {
		long i = 0;
		while (i < /*untyped*/NULL(this->TypeParams)) {
			if (!Array<ZType>GetIndex(i)->AcceptValueType(Array<ZType>GetIndex(i), ValueType->GetParamType(ValueType, i), 1/*true*/, Greek)) {
				return 0/*false*/;
			};
			i = i + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static const char * StringfySignature__2qek(struct ZFuncType91 * this, const char * FuncName__1) {
	return ZFunc_StringfySignature__3qqy(FuncName, GetFuncParamSize__1qek(this), GetRecvType__1qek(this));
}
static struct ZType65 * GetBaseType__1qek(struct ZFuncType91 * this) {
	return ZTypeFuncType_Z12;
}
static long GetParamSize__1qek(struct ZFuncType91 * this) {
	return /*untyped*/NULL(this->TypeParams);
}
static struct ZType65 * GetParamType__2qek(struct ZFuncType91 * this, long Index__1) {
	return Array<ZType>GetIndex(Index);
}
static struct ZType65 * GetReturnType__1qek(struct ZFuncType91 * this) {
	return Array<ZType>GetIndex(0);
}
static long GetFuncParamSize__1qek(struct ZFuncType91 * this) {
	return /*untyped*/NULL(this->TypeParams) - 1;
}
static struct ZType65 * GetRecvType__1qek(struct ZFuncType91 * this) {
	if (/*untyped*/NULL(this->TypeParams) == 1) {
		return ZTypeVoidType_Z4;
	};
	return Array<ZType>GetIndex(1);
}
static struct ZType65 * GetFuncParamType__2qek(struct ZFuncType91 * this, long Index__1) {
	return Array<ZType>GetIndex(Index + 1);
}
static struct ZFuncType91 * NewMethodFuncType__2qek(struct ZFuncType91 * this, struct ZType65 * RecvType__1) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)GetReturnType__1qek(this));
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)RecvType);
	long i = 0;
	while (i < GetFuncParamSize__1qek(this)) {
		LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)GetFuncParamType__2qek(this, i));
		i = i + 1;
	};
	return ZTypePool_LookupFuncType__1qwm(TypeList);
}
static int AcceptAsFieldFunc__2qek(struct ZFuncType91 * this, struct ZFuncType91 * FuncType__1) {
	if (GetFuncParamSize__1qek(FuncType) == GetFuncParamSize__1qek(this) && Equals__2qwn(GetReturnType__1qek(FuncType), GetReturnType__1qek(this))) {
		long i = 1;
		while (i < GetFuncParamSize__1qek(FuncType)) {
			if (!Equals__2qwn(GetFuncParamType__2qek(FuncType, i), GetFuncParamType__2qek(this, i))) {
				return 0/*false*/;
			};
			i = i + 1;
		};
	};
	return 1/*true*/;
}
static struct ZGeneric1Type108 * ZGeneric1Type__5qrq(struct ZGeneric1Type108 * this, long TypeFlag__1, const char * ShortName__2, struct ZType65 * BaseType__3, struct ZType65 * ParamType__4) {
	(void)ZType__4qwn(this, TypeFlag, ShortName, ZTypeVarType_Z3);
	this->BaseType = BaseType;
	if (this->BaseType == NULL) {
		this->BaseType = this;
	};
	this->ParamType = ParamType;
	return NULL;
}
static struct ZType65 * GetSuperType__1qrq(struct ZGeneric1Type108 * this) {
	if (this->BaseType == this) {
		return this->RefType;
	};
	return this->BaseType;
}
static struct ZType65 * GetBaseType__1qrq(struct ZGeneric1Type108 * this) {
	return this->BaseType;
}
static long GetParamSize__1qrq(struct ZGeneric1Type108 * this) {
	return 1;
}
static struct ZType65 * GetParamType__2qrq(struct ZGeneric1Type108 * this, long Index__1) {
	if (Index == 0) {
		return this->ParamType;
	};
	return NULL;
}
static int IsGreekType__1qrq(struct ZGeneric1Type108 * this) {
	return /*untyped*/NULL;
}
static struct ZType65 * GetGreekRealType__2qrq(struct ZGeneric1Type108 * this, ArrayOfZType * Greek__1) {
	if (this->ParamType->IsGreekType(this->ParamType)) {
		return ZTypePool_GetGenericType1__2qwn(this->BaseType, this->ParamType->GetGreekRealType(this->ParamType, Greek));
	};
	return this->GetRealType(this);
}
static int AcceptValueType__4qrq(struct ZGeneric1Type108 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (this->BaseType == ValueType->GetBaseType(ValueType) && /*untyped*/NULL(ValueType) == 1) {
		return /*untyped*/NULL(this->ParamType, /*untyped*/NULL(ValueType, 0), 1/*true*/, Greek);
	};
	return 0/*false*/;
}
static struct ZGreekType116 * ZGreekType__2qro(struct ZGreekType116 * this, long GreekId__1) {
	(void)ZType__4qwn(this, ZTypeUniqueTypeFlag_Z0, /*untyped*/NULL, ZTypeVarType_Z3);
	this->GreekId = GreekId;
	return NULL;
}
static int IsGreekType__1qro(struct ZGreekType116 * this) {
	return 1/*true*/;
}
static struct ZType65 * GetGreekRealType__2qro(struct ZGreekType116 * this, ArrayOfZType * Greek__1) {
	if (Array<ZType>GetIndex(this->GreekId) == NULL) {
		return ZTypeVarType_Z3;
	};
	return Array<ZType>GetIndex(this->GreekId);
}
static int AcceptValueType__4qro(struct ZGreekType116 * this, struct ZType65 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
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
static struct ZPrototype122 * ZPrototype__5qrd(struct ZPrototype122 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType91 * FuncType__3, struct ZToken78 * SourceToken__4) {
	(void)ZFunc__4qej(this, FuncFlag, FuncName, FuncType);
	this->DefinedCount = 0;
	this->UsedCount = 0;
	return NULL;
}
static void Used__1qrd(struct ZPrototype122 * this) {
	this->UsedCount = this->UsedCount + 1;
	return;
}
static void Defined__1qrd(struct ZPrototype122 * this) {
	this->DefinedCount = this->DefinedCount + 1;
	return;
}
static struct ZVarScope135 * ZVarScope__4qrv(struct ZVarScope135 * this, struct ZVarScope135 * Parent__1, struct ZLogger136 * Logger__2, ArrayOfZVarType * VarList__3) {
	this->Parent = Parent;
	this->Logger = Logger;
	this->VarList = VarList;
	if (this->VarList == NULL) {
		this->VarList = LibZen_NewArray(0);
	};
	return NULL;
}
static struct ZType65 * NewVarType__4qrv(struct ZVarScope135 * this, struct ZType65 * VarType__1, const char * Name__2, struct ZToken78 * SourceToken__3) {
	if (!(LibZen_Is(VarType, 137)) && /*untyped*/NULL(VarType)) {
		VarType = ZVarType__4qrn(_NewZVarType137(), this->VarList, Name, SourceToken);
	};
	return VarType;
}
static void FoundUnresolvedSymbol__2qrv(struct ZVarScope135 * this, const char * FuncName__1) {
	/*untyped*/NULL;
	this->UnresolvedSymbolCount = this->UnresolvedSymbolCount + 1;
	return;
}
static void CheckVarNode__3qrv(struct ZVarScope135 * this, struct ZType65 * ContextType__1, struct ZNode55 * Node__2) {
	if (IsUntyped__1qwk(Node)) {
		this->VarNodeCount = this->VarNodeCount + 1;
	};
	if (IsInferrableType__1qwn(ContextType) && LibZen_Is(Node->Type, 137)) {
		Infer__3qrn(((struct ZVarType137 *)Node->Type), ContextType, Node->SourceToken);
		Node->Type = ContextType;
	};
	if (LibZen_Is(ContextType, 137) && !IsUntyped__1qwk(Node)) {
		Infer__3qrn(((struct ZVarType137 *)ContextType), Node->Type, Node->SourceToken);
	};
	return;
}
static int TypeCheckStmtList__3qrv(struct ZVarScope135 * this, struct ZTypeChecker143 * TypeSafer__1, ArrayOfZNode * StmtList__2) {
	long PrevCount = -1;
	while (1/*true*/) {
		long i = 0;
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		while (i < LibZen_ArraySize((ArrayOfVar *)StmtList)) {
			Array<ZNode>SetIndex(i, CheckType__3qr8(TypeSafer, Array<ZNode>GetIndex(i), ZTypeVoidType_Z4));
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
static void TypeCheckFuncBlock__3qrv(struct ZVarScope135 * this, struct ZTypeChecker143 * TypeSafer__1, struct ZFunctionNode146 * FunctionNode__2) {
	long PrevCount = -1;
	while (1/*true*/) {
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		/*untyped*/NULL(TypeSafer, FunctionNode, 0/*false*/);
		Array<ZNode>SetIndex(ZFunctionNode_Block_Z79, CheckType__3qr8(TypeSafer, Array<ZNode>GetIndex(ZFunctionNode_Block_Z79), ZTypeVoidType_Z4));
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
static struct ZVarType137 * ZVarType__4qrn(struct ZVarType137 * this, ArrayOfZVarType * VarList__1, const char * Name__2, struct ZToken78 * SourceToken__3) {
	(void)ZType__4qwn(this, 0, Name, ZTypeVarType_Z3);
	this->VarList = VarList;
	this->SourceToken = SourceToken;
	this->GreekId = LibZen_ArraySize((ArrayOfVar *)VarList);
	LibZen_ArrayAdd((ArrayOfVar *)VarList, (var)this);
	this->TypeId = this->RefType->TypeId;
	return NULL;
}
static struct ZType65 * GetRealType__1qrn(struct ZVarType137 * this) {
	return this->RefType;
}
static long GetParamSize__1qrn(struct ZVarType137 * this) {
	return /*untyped*/NULL(this->RefType);
}
static struct ZType65 * GetParamType__2qrn(struct ZVarType137 * this, long Index__1) {
	return /*untyped*/NULL(this->RefType, Index);
}
static int IsFuncType__1qrn(struct ZVarType137 * this) {
	return IsFuncType__1qwn(this->RefType);
}
static int IsVarType__1qrn(struct ZVarType137 * this) {
	return /*untyped*/NULL(this->RefType);
}
static void Infer__3qrn(struct ZVarType137 * this, struct ZType65 * ContextType__1, struct ZToken78 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(ContextType, 137) && /*untyped*/NULL(ContextType)) {
			struct ZVarType137 * VarType = (struct ZVarType137 *)ContextType;
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
static void Maybe__3qrn(struct ZVarType137 * this, struct ZType65 * T__1, struct ZToken78 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(T, 137) && /*untyped*/NULL(T)) {
			struct ZVarType137 * VarType = (struct ZVarType137 *)T;
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
static struct ZNode55 * ZNode__4qwk(struct ZNode55 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, long Size__3) {
	LibZen_Assert(this != ParentNode, "(libzen/libzen.zen:2118)");
	this->ParentNode = ParentNode;
	this->SourceToken = SourceToken;
	if (Size > 0) {
		this->AST = /*untyped*/NULL;
	} else {
		this->AST = NULL;
	};
	return NULL;
}
static struct ZNode55 * SetChild__2qwk(struct ZNode55 * this, struct ZNode55 * Node__1) {
	LibZen_Assert(Node != NULL, "(libzen/libzen.zen:2130)");
	if (Node != NULL) {
		LibZen_Assert(this != Node, "(libzen/libzen.zen:2132)");
		Node->ParentNode = this;
	};
	return Node;
}
static void SetNameInfo__3qwk(struct ZNode55 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	LibZen_Assert(Name == NULL, "(libzen/libzen.zen:2139)");
	return;
}
static void SetTypeInfo__3qwk(struct ZNode55 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->Type = Type;
	return;
}
static void Set__3qwk(struct ZNode55 * this, long Index__1, struct ZNode55 * Node__2) {
	if (Index >= 0) {
		Array<ZNode>SetIndex(Index, SetChild__2qwk(this, Node));
	} else if (Index == ZNode_AppendIndex_Z22) {
		struct ZNode55 * ListNode = this;
		if (LibZen_Is(ListNode, 252)) {
			Append__2qiq(((struct ZListNode252 *)ListNode), Node);
		} else {
			LibZen_Assert(LibZen_Is(ListNode, 252), "(libzen/libzen.zen:2156)");
		};
	} else if (Index == ZNode_NameInfo_Z20) {
		/*untyped*/NULL(this, Node->SourceToken, GetText__1qeu(Node->SourceToken));
		this->SourceToken = Node->SourceToken;
		return;
	} else if (Index == ZNode_TypeInfo_Z21) {
		/*untyped*/NULL(this, Node->SourceToken, Node->Type);
		return;
	};
	return;
}
static long GetAstSize__1qwk(struct ZNode55 * this) {
	if (this->AST == NULL) {
		return 0;
	};
	return /*untyped*/NULL;
}
static int HasAst__2qwk(struct ZNode55 * this, long Index__1) {
	if (this->AST != NULL && Index < /*untyped*/NULL) {
		return Array<ZNode>GetIndex(Index) != NULL;
	};
	return 0/*false*/;
}
static struct ZType65 * GetAstType__2qwk(struct ZNode55 * this, long Index__1) {
	return /*untyped*/NULL(Array<ZNode>GetIndex(Index)->Type);
}
static const char * GetSourceLocation__1qwk(struct ZNode55 * this) {
	if (this->SourceToken != NULL) {
		return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", GetFileName__1qeu(this->SourceToken)), ":"), LibZen_IntToString(GetLineNumber__1qeu(this->SourceToken))), ")");
	};
	return NULL;
}
static const char * toString__1qwk(struct ZNode55 * this) {
	const char * Self = LibZen_StrCat("#", ThrowError("type error: requested = String, given = var"));
	if (!this->Type->IsVarType(this->Type)) {
		Self = LibZen_StrCat(LibZen_StrCat(Self, ":"), ThrowError("type error: requested = String, given = ZType"));
	} else {
		Self = LibZen_StrCat(Self, ":?");
	};
	if (this->AST != NULL) {
		long i = 0;
		Self = LibZen_StrCat(Self, "[");
		while (i < /*untyped*/NULL) {
			if (i > 0) {
				Self = LibZen_StrCat(Self, ",");
			};
			if (Array<ZNode>GetIndex(i) == NULL) {
				Self = LibZen_StrCat(Self, "null");
			} else {
				Self = LibZen_StrCat(Self, toString__1qwk(Array<ZNode>GetIndex(i)));
			};
			i = i + 1;
		};
		Self = LibZen_StrCat(Self, "]");
	};
	return Self;
}
static struct ZBlockNode163 * GetScopeBlockNode__1qwk(struct ZNode55 * this) {
	struct ZNode55 * Node = this;
	while (Node != NULL) {
		if (LibZen_Is(Node, 163)) {
			return (struct ZBlockNode163 *)Node;
		};
		if (Node == Node->ParentNode) {
			/*untyped*/NULLlongjump(1) ;
		};
		Node = Node->ParentNode;
	};
	return NULL;
}
static struct ZNameSpace49 * GetNameSpace__1qwk(struct ZNode55 * this) {
	struct ZBlockNode163 * BlockNode = GetScopeBlockNode__1qwk(this);
	return BlockNode->NameSpace;
}
static int IsErrorNode__1qwk(struct ZNode55 * this) {
	return (LibZen_Is(this, 338));
}
static int IsBreakingBlock__1qwk(struct ZNode55 * this) {
	return 0/*false*/;
}
static struct ZSugarNode167 * DeSugar__2qwk(struct ZNode55 * this, struct ZGenerator58 * Generator__1) {
	return ZSugarNode__3qt6(_NewZSugarNode167(), this, ZErrorNode__3qpd(_NewZErrorNode338(), this->ParentNode, LibZen_StrCat("undefined code generation: ", ThrowError("type error: requested = String, given = ZNode"))));
}
static void Accept__2qwk(struct ZNode55 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsUntyped__1qwk(struct ZNode55 * this) {
	return /*untyped*/NULL(this->Type);
}
static int HasUntypedNode__1qwk(struct ZNode55 * this) {
	if (this->HasUntypedNode) {
		if (!IsUntyped__1qwk(this)) {
			long i = 0;
			while (i < GetAstSize__1qwk(this)) {
				if (Array<ZNode>GetIndex(i) != NULL && HasUntypedNode__1qwk(Array<ZNode>GetIndex(i))) {
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
static struct ZNode55 * VisitTypeChecker__3qwk(struct ZNode55 * this, struct ZTypeChecker143 * TypeChecker__1, struct ZType65 * ContextType__2) {
	return VisitTypeChecker__3qr8(TypeChecker, this, ContextType);
}
static struct ZReturnNode172 * ToReturnNode__1qwk(struct ZNode55 * this) {
	return NULL;
}
static struct ZParamNode174 * ZParamNode__2qtm(struct ZParamNode174 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetNameInfo__3qtm(struct ZParamNode174 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->Name = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZReturnNode172 * ZReturnNode__2qtb(struct ZReturnNode172 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	return NULL;
}
static void Accept__2qtb(struct ZReturnNode172 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZReturnNode172 * ToReturnNode__1qtb(struct ZReturnNode172 * this) {
	return this;
}
static struct ZSetIndexNode180 * ZSetIndexNode__3qyq(struct ZSetIndexNode180 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * LeftNode__2) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 3);
	Set__3qwk(this, ZSetIndexNode_Recv_Z25, LeftNode);
	return NULL;
}
static void Accept__2qyq(struct ZSetIndexNode180 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZSetNameNode183 * ZSetNameNode__4qyr(struct ZSetNameNode183 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, const char * VarName__3) {
	(void)ZNode__4qwk(this, ParentNode, Token, 1);
	this->VarName = VarName;
	return NULL;
}
static void Accept__2qyr(struct ZSetNameNode183 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZSetterNode186 * ZSetterNode__3qyu(struct ZSetterNode186 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 2);
	Set__3qwk(this, ZSetterNode_Recv_Z29, RecvNode);
	return NULL;
}
static void SetNameInfo__3qyu(struct ZSetterNode186 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qyu(struct ZSetterNode186 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsStaticField__1qyu(struct ZSetterNode186 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZSetterNode_Recv_Z29), 236);
}
static struct ZSugarNode167 * ZSugarNode__3qt6(struct ZSugarNode167 * this, struct ZNode55 * SugarNode__1, struct ZNode55 * DeSugarNode__2) {
	(void)ZNode__4qwk(this, SugarNode->ParentNode, NULL, 1);
	this->SugarNode = SugarNode;
	SugarNode->ParentNode = this;
	Set__3qwk(this, ZSugarNode_DeSugar_Z31, DeSugarNode);
	DeSugarNode->ParentNode = this;
	return NULL;
}
static void Accept__2qt6(struct ZSugarNode167 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZThrowNode193 * ZThrowNode__2qys(struct ZThrowNode193 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	return NULL;
}
static void Accept__2qys(struct ZThrowNode193 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZTryNode196 * ZTryNode__2qyg(struct ZTryNode196 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 3);
	return NULL;
}
static void Accept__2qyg(struct ZTryNode196 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZUnaryNode199 * ZUnaryNode__3qyk(struct ZUnaryNode199 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2) {
	(void)ZNode__4qwk(this, ParentNode, Token, 1);
	return NULL;
}
static void Accept__2qyk(struct ZUnaryNode199 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZWhileNode202 * ZWhileNode__2qy1(struct ZWhileNode202 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 2);
	return NULL;
}
static void Accept__2qy1(struct ZWhileNode202 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static const char * toString__1qyx(struct ZEmptyValue205 * this) {
	return "";
}
static void Report__2qrb(struct ZLogger136 * this, const char * Message__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->ReportedErrorList, (var)Message);
	return;
}
static ArrayOfString * GetReportedErrors__1qrb(struct ZLogger136 * this) {
	ArrayOfString * List = this->ReportedErrorList;
	this->ReportedErrorList = LibZen_NewStringArray(0);
	return /*untyped*/NULL;
}
static void ShowErrors__1qrb(struct ZLogger136 * this) {
	ArrayOfString * Messages = GetReportedErrors__1qrb(this);
	long i = 0;
	while (i < /*untyped*/NULL) {
		/*untyped*/NULL;
		i = i + 1;
	};
	return;
}
static struct ZMacroFunc213 * ZMacroFunc__3qy3(struct ZMacroFunc213 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2) {
	(void)ZFunc__4qej(this, 0, FuncName, FuncType);
	return NULL;
}
static struct ZNameSpace49 * ZNameSpace__3qws(struct ZNameSpace49 * this, struct ZGenerator58 * Generator__1, struct ZNameSpace49 * ParentNameSpace__2) {
	this->ParentNameSpace = ParentNameSpace;
	if (ParentNameSpace == NULL) {
		this->Generator = Generator;
	} else {
		this->Generator = ParentNameSpace->Generator;
	};
	this->SerialId = 0;
	return NULL;
}
static const char * toString__1qws(struct ZNameSpace49 * this) {
	return LibZen_StrCat(LibZen_StrCat("NS[", LibZen_IntToString(this->SerialId)), "]");
}
static struct ZNameSpace49 * CreateSubNameSpace__1qws(struct ZNameSpace49 * this) {
	return ZNameSpace__3qws(_NewZNameSpace49(), NULL, this);
}
static struct ZNameSpace49 * GetRootNameSpace__1qws(struct ZNameSpace49 * this) {
	return this->Generator->RootNameSpace;
}
static struct ZTokenFunc36 * GetTokenFunc__2qws(struct ZNameSpace49 * this, long ZenChar__1) {
	if (this->TokenMatrix == NULL) {
		return GetTokenFunc__2qws(this->ParentNameSpace, ZenChar);
	};
	return Array<ZTokenFunc>GetIndex(ZenChar);
}
static struct ZTokenFunc36 * JoinParentFunc__3qws(struct ZNameSpace49 * this, struct ZTokenFunction51 * Func__1, struct ZTokenFunc36 * Parent__2) {
	if (Parent != NULL && Parent->Func == Func) {
		return Parent;
	};
	return ZTokenFunc__3qwq(_NewZTokenFunc36(), Func, Parent);
}
static void AppendTokenFunc__3qws(struct ZNameSpace49 * this, const char * keys__1, struct ZTokenFunction51 * TokenFunc__2) {
	if (this->TokenMatrix == NULL) {
		this->TokenMatrix = LibZen_NewTokenMatrix__0qqw();
		if (this->ParentNameSpace != NULL) {
			long i = 0;
			while (i < /*untyped*/NULL) {
				Array<ZTokenFunc>SetIndex(i, GetTokenFunc__2qws(this->ParentNameSpace, i));
				i = i + 1;
			};
		};
	};
	long i = 0;
	while (i < LibZen_StringSize(keys)) {
		long kchar = LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(keys, i));
		Array<ZTokenFunc>SetIndex(kchar, JoinParentFunc__3qws(this, TokenFunc, Array<ZTokenFunc>GetIndex(kchar)));
		i = i + 1;
	};
	return;
}
static struct ZSyntax221 * GetSyntaxPattern__2qws(struct ZNameSpace49 * this, const char * PatternName__1) {
	struct ZNameSpace49 * NameSpace = this;
	while (NameSpace != NULL) {
		if (NameSpace->SyntaxTable != NULL) {
			return Map<ZSyntax>GetIndex(PatternName);
		};
		NameSpace = NameSpace->ParentNameSpace;
	};
	return NULL;
}
static void SetSyntaxPattern__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZSyntax221 * Syntax__2) {
	if (this->SyntaxTable == NULL) {
		this->SyntaxTable = LibZen_NewMap(0);
	};
	Map<ZSyntax>SetIndex(PatternName, Syntax);
	return;
}
static struct ZSyntax221 * GetRightSyntaxPattern__2qws(struct ZNameSpace49 * this, const char * PatternName__1) {
	return GetSyntaxPattern__2qws(this, ZNameSpace_RightPatternSymbol__1qqy(PatternName));
}
static void AppendSyntaxPattern__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZSyntax221 * NewPattern__2) {
	LibZen_Assert__1qqe(NewPattern->ParentPattern == NULL);
	struct ZSyntax221 * ParentPattern = GetSyntaxPattern__2qws(this, PatternName);
	NewPattern->ParentPattern = ParentPattern;
	SetSyntaxPattern__3qws(this, PatternName, NewPattern);
	return;
}
static void DefineStatement__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZMatchFunction54 * MatchFunc__2) {
	long Alias = LibZen_IndexOf(PatternName, " ");
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = LibZen_SubString2(PatternName, 0);
	};
	struct ZSyntax221 * Pattern = ZSyntax__4quy(_NewZSyntax221(), this, Name, MatchFunc);
	Pattern->IsStatement = 1/*true*/;
	AppendSyntaxPattern__3qws(this, Name, Pattern);
	if (Alias != -1) {
		DefineStatement__3qws(this, LibZen_SubString(PatternName, Alias + 1), MatchFunc);
	};
	return;
}
static void DefineExpression__3qws(struct ZNameSpace49 * this, const char * PatternName__1, struct ZMatchFunction54 * MatchFunc__2) {
	long Alias = LibZen_IndexOf(PatternName, " ");
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = LibZen_SubString2(PatternName, 0);
	};
	struct ZSyntax221 * Pattern = ZSyntax__4quy(_NewZSyntax221(), this, Name, MatchFunc);
	AppendSyntaxPattern__3qws(this, Name, Pattern);
	if (Alias != -1) {
		DefineExpression__3qws(this, LibZen_SubString(PatternName, Alias + 1), MatchFunc);
	};
	return;
}
static void DefineRightExpression__4qws(struct ZNameSpace49 * this, const char * PatternName__1, long SyntaxFlag__2, struct ZMatchFunction54 * MatchFunc__3) {
	long Alias = LibZen_IndexOf(PatternName, " ");
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = LibZen_SubString2(PatternName, 0);
	};
	struct ZSyntax221 * Pattern = ZSyntax__4quy(_NewZSyntax221(), this, Name, MatchFunc);
	Pattern->SyntaxFlag = SyntaxFlag;
	AppendSyntaxPattern__3qws(this, ZNameSpace_RightPatternSymbol__1qqy(Name), Pattern);
	if (Alias != -1) {
		DefineRightExpression__4qws(this, LibZen_SubString(PatternName, Alias + 1), SyntaxFlag, MatchFunc);
	};
	return;
}
static struct ZSymbolEntry226 * GetSymbol__2qws(struct ZNameSpace49 * this, const char * Symbol__1) {
	struct ZNameSpace49 * NameSpace = this;
	while (NameSpace != NULL) {
		if (NameSpace->SymbolTable != NULL) {
			struct ZSymbolEntry226 * Entry = Map<ZSymbolEntry>GetIndex(Symbol);
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
static struct ZNode55 * GetSymbolNode__2qws(struct ZNameSpace49 * this, const char * Symbol__1) {
	struct ZSymbolEntry226 * Entry = GetSymbol__2qws(this, Symbol);
	if (Entry != NULL) {
		return Entry->Node;
	};
	return NULL;
}
static void SetLocalSymbolEntry__3qws(struct ZNameSpace49 * this, const char * Symbol__1, struct ZSymbolEntry226 * Entry__2) {
	if (this->SymbolTable == NULL) {
		this->SymbolTable = LibZen_NewMap(0);
	};
	Map<ZSymbolEntry>SetIndex(Symbol, Entry);
	return;
}
static struct ZSymbolEntry226 * SetLocalSymbol__3qws(struct ZNameSpace49 * this, const char * Symbol__1, struct ZNode55 * Node__2) {
	struct ZSymbolEntry226 * Parent = GetSymbol__2qws(this, Symbol);
	Node->ParentNode = NULL;
	SetLocalSymbolEntry__3qws(this, Symbol, ZSymbolEntry__3qu0(_NewZSymbolEntry226(), Parent, Node));
	return Parent;
}
static struct ZSymbolEntry226 * SetGlobalSymbol__3qws(struct ZNameSpace49 * this, const char * Symbol__1, struct ZNode55 * Node__2) {
	return SetLocalSymbol__3qws(GetRootNameSpace__1qws(this), Symbol, Node);
}
static struct ZVariable231 * GetLocalVariable__2qws(struct ZNameSpace49 * this, const char * VarName__1) {
	struct ZSymbolEntry226 * Entry = GetSymbol__2qws(this, VarName);
	if (LibZen_Is(Entry, 231)) {
		return (struct ZVariable231 *)Entry;
	};
	return NULL;
}
static void SetLocalVariable__5qws(struct ZNameSpace49 * this, struct ZFunctionNode146 * FunctionNode__1, struct ZType65 * VarType__2, const char * VarName__3, struct ZToken78 * SourceToken__4) {
	struct ZSymbolEntry226 * Parent = GetSymbol__2qws(this, VarName);
	struct ZVariable231 * VarInfo = ZVariable__7quf(_NewZVariable231(), Parent, FunctionNode, 0, VarType, VarName, SourceToken);
	SetLocalSymbolEntry__3qws(this, VarName, VarInfo);
	return;
}
static void SetTypeName__4qws(struct ZNameSpace49 * this, const char * Name__1, struct ZType65 * Type__2, struct ZToken78 * SourceToken__3) {
	struct ZTypeNode236 * Node = ZTypeNode__4qul(_NewZTypeNode236(), NULL, SourceToken, Type);
	(void)SetLocalSymbol__3qws(this, Name, Node);
	return;
}
static void SetTypeName__3qws(struct ZNameSpace49 * this, struct ZType65 * Type__1, struct ZToken78 * SourceToken__2) {
	SetTypeName__4qws(this, Type->ShortName, Type, SourceToken);
	return;
}
static struct ZTypeNode236 * GetTypeNode__3qws(struct ZNameSpace49 * this, const char * TypeName__1, struct ZToken78 * SourceToken__2) {
	struct ZNode55 * Node = GetSymbolNode__2qws(this, TypeName);
	if (LibZen_Is(Node, 236)) {
		return (struct ZTypeNode236 *)Node;
	};
	if (Node == NULL && SourceToken != NULL) {
		struct ZType65 * Type = ZClassType__3qep(_NewZClassType81(), TypeName, ZTypeVarType_Z3);
		SetTypeName__4qws(GetRootNameSpace__1qws(this), TypeName, Type, SourceToken);
		return GetTypeNode__3qws(this, TypeName, NULL);
	};
	return NULL;
}
static struct ZType65 * GetType__3qws(struct ZNameSpace49 * this, const char * TypeName__1, struct ZToken78 * SourceToken__2) {
	struct ZTypeNode236 * TypeNode = GetTypeNode__3qws(this, TypeName, SourceToken);
	if (TypeNode != NULL) {
		return TypeNode->Type;
	};
	return NULL;
}
static struct ZSource239 * ZSource__5qu6(struct ZSource239 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext56 * TokenContext__4) {
	this->FileName = FileName;
	this->LineNumber = LineNumber;
	this->TokenContext = TokenContext;
	this->SourceText = Source;
	this->Logger = TokenContext->Generator->Logger;
	return NULL;
}
static long GetLineNumber__2qu6(struct ZSource239 * this, long Position__1) {
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
static long GetLineHeadPosition__2qu6(struct ZSource239 * this, long Position__1) {
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
static long CountIndentSize__2qu6(struct ZSource239 * this, long Position__1) {
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
static const char * GetLineText__2qu6(struct ZSource239 * this, long Position__1) {
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
static const char * GetLineMarker__2qu6(struct ZSource239 * this, long Position__1) {
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
static const char * FormatErrorHeader__4qu6(struct ZSource239 * this, const char * Error__1, long Position__2, const char * Message__3) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", this->FileName), ":"), LibZen_IntToString(GetLineNumber__2qu6(this, Position))), ") ["), Error), "] "), Message);
}
static const char * FormatErrorMarker__4qu6(struct ZSource239 * this, const char * Error__1, long Position__2, const char * Message__3) {
	const char * Line = GetLineText__2qu6(this, Position);
	const char * Delim = "\n\t";
	if (/*untyped*/NULL || /*untyped*/NULL) {
		Delim = "\n";
	};
	const char * Header = FormatErrorHeader__4qu6(this, Error, Position, Message);
	const char * Marker = GetLineMarker__2qu6(this, Position);
	Message = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(Header, Delim), Line), Delim), Marker);
	return Message;
}
static const char * GetCharAt__2qu6(struct ZSource239 * this, long n__1) {
	if (0 <= n && n < LibZen_StringSize(this->SourceText)) {
		return LibZen_GetChar__2qqy(this->SourceText, n);
	};
	return "0";
}
static struct ZSourceBuilder43 * ZSourceBuilder__3qwi(struct ZSourceBuilder43 * this, struct ZSourceGenerator244 * Template__1, struct ZSourceBuilder43 * Parent__2) {
	this->Template = Template;
	this->Parent = Parent;
	return NULL;
}
static struct ZSourceBuilder43 * Pop__1qwi(struct ZSourceBuilder43 * this) {
	return this->Parent;
}
static void Clear__1qwi(struct ZSourceBuilder43 * this) {
	LibZen_ArrayClear((ArrayOfVar *)this->SourceList);
	return;
}
static long GetPosition__1qwi(struct ZSourceBuilder43 * this) {
	return LibZen_ArraySize((ArrayOfVar *)this->SourceList);
}
static const char * CopyString__3qwi(struct ZSourceBuilder43 * this, long BeginIndex__1, long EndIndex__2) {
	return LibZen_SourceBuilderToString__3qwi(this, BeginIndex, EndIndex);
}
static void Append__2qwi(struct ZSourceBuilder43 * this, const char * Text__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
	return;
}
static void AppendInt__2qwi(struct ZSourceBuilder43 * this, long Value__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)LibZen_StrCat("", LibZen_IntToString(Value)));
	return;
}
static void AppendLineFeed__1qwi(struct ZSourceBuilder43 * this) {
	if (LibZen_StringSize(this->BufferedLineComment) > 0) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->BufferedLineComment);
		this->BufferedLineComment = "";
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineFeed);
	return;
}
static void AppendLineFeed__2qwi(struct ZSourceBuilder43 * this, int AppendIndent__1) {
	if (LibZen_StringSize(this->BufferedLineComment) > 0) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->BufferedLineComment);
		this->BufferedLineComment = "";
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineFeed);
	if (AppendIndent) {
		AppendIndent__1qwi(this);
	};
	return;
}
static void AppendWhiteSpace__1qwi(struct ZSourceBuilder43 * this) {
	long Size = LibZen_ArraySize((ArrayOfVar *)this->SourceList);
	if (Size > 0) {
		const char * Last = Array<String>GetIndex(Size - 1);
		if (Last != NULL && (/*untyped*/NULL || /*untyped*/NULL || /*untyped*/NULL)) {
			return;
		};
	};
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)" ");
	return;
}
static void AppendToken__2qwi(struct ZSourceBuilder43 * this, const char * Text__1) {
	AppendWhiteSpace__1qwi(this);
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
	AppendWhiteSpace__1qwi(this);
	return;
}
static void AppendBlockComment__2qwi(struct ZSourceBuilder43 * this, const char * Text__1) {
	if (this->Template->BeginComment != NULL) {
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->BeginComment);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
		LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->EndComment);
	} else if (this->Template->LineComment != NULL) {
		this->BufferedLineComment = LibZen_StrCat(LibZen_StrCat(this->BufferedLineComment, this->Template->LineComment), Text);
	};
	return;
}
static void AppendCommentLine__2qwi(struct ZSourceBuilder43 * this, const char * Text__1) {
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
static void Indent__1qwi(struct ZSourceBuilder43 * this) {
	this->IndentLevel = this->IndentLevel + 1;
	this->CurrentIndentString = NULL;
	return;
}
static void UnIndent__1qwi(struct ZSourceBuilder43 * this) {
	this->IndentLevel = this->IndentLevel - 1;
	this->CurrentIndentString = NULL;
	LibZen_Assert__1qqe(this->IndentLevel >= 0);
	return;
}
static const char * GetIndentString__1qwi(struct ZSourceBuilder43 * this) {
	if (this->CurrentIndentString == NULL) {
		this->CurrentIndentString = LibZen_JoinStrings__2qqy(this->Template->Tab, this->IndentLevel);
	};
	return this->CurrentIndentString;
}
static void AppendIndent__1qwi(struct ZSourceBuilder43 * this) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)GetIndentString__1qwi(this));
	return;
}
static void AppendLineFeedIndent__1qwi(struct ZSourceBuilder43 * this) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)this->Template->LineFeed);
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)GetIndentString__1qwi(this));
	return;
}
static void IndentAndAppend__2qwi(struct ZSourceBuilder43 * this, const char * Text__1) {
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)GetIndentString__1qwi(this));
	LibZen_ArrayAdd((ArrayOfVar *)this->SourceList, (var)Text);
	return;
}
static void AppendParamList__4qwi(struct ZSourceBuilder43 * this, struct ZListNode252 * ParamList__1, long BeginIdx__2, long EndIdx__3) {
	long i = BeginIdx;
	while (i < EndIdx) {
		if (i > BeginIdx) {
			Append__2qwi(this, this->Template->Camma);
		};
		/*untyped*/NULL(GetListAt__2qiq(ParamList, i), this->Template);
		i = i + 1;
	};
	return;
}
static const char * toString__1qwi(struct ZSourceBuilder43 * this) {
	return LibZen_SourceBuilderToString__1qwi(this);
}
static void AppendLine__2qwi(struct ZSourceBuilder43 * this, const char * Text__1) {
	Append__2qwi(this, Text);
	AppendLineFeed__1qwi(this);
	return;
}
static struct ZSourceContext52 * ZSourceContext__5qwg(struct ZSourceContext52 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext56 * TokenContext__4) {
	(void)ZSource__5qu6(this, FileName, LineNumber, Source, TokenContext);
	return NULL;
}
static long GetCharCode__1qwg(struct ZSourceContext52 * this) {
	return LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition));
}
static long GetPosition__1qwg(struct ZSourceContext52 * this) {
	return this->SourcePosition;
}
static int HasChar__1qwg(struct ZSourceContext52 * this) {
	return (LibZen_StringSize(this->SourceText) - this->SourcePosition) > 0;
}
static const char * GetCurrentChar__1qwg(struct ZSourceContext52 * this) {
	return LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition);
}
static const char * GetCharAtFromCurrentPosition__2qwg(struct ZSourceContext52 * this, long n__1) {
	if ((this->SourcePosition + n) < LibZen_StringSize(this->SourceText)) {
		return LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition + n);
	};
	return "0";
}
static void MoveNext__1qwg(struct ZSourceContext52 * this) {
	this->SourcePosition = this->SourcePosition + 1;
	return;
}
static void SkipWhiteSpace__1qwg(struct ZSourceContext52 * this) {
	while (HasChar__1qwg(this)) {
		const char * ch = GetCurrentChar__1qwg(this);
		if (ch != " " && ch != "\t") {
			break;
		};
		MoveNext__1qwg(this);
	};
	return;
}
static void FoundIndent__3qwg(struct ZSourceContext52 * this, long StartIndex__1, long EndIndex__2) {
	struct ZToken78 * Token = ZIndentToken__4qam(_NewZIndentToken462(), this, StartIndex, EndIndex);
	this->SourcePosition = EndIndex;
	LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
	return;
}
static void Tokenize__3qwg(struct ZSourceContext52 * this, long StartIndex__1, long EndIndex__2) {
	this->SourcePosition = EndIndex;
	if (StartIndex < EndIndex && EndIndex <= LibZen_StringSize(this->SourceText)) {
		struct ZToken78 * Token = ZToken__4qeu(_NewZToken78(), this, StartIndex, EndIndex);
		LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
	};
	return;
}
static void Tokenize__4qwg(struct ZSourceContext52 * this, const char * PatternName__1, long StartIndex__2, long EndIndex__3) {
	this->SourcePosition = EndIndex;
	if (StartIndex <= EndIndex && EndIndex <= LibZen_StringSize(this->SourceText)) {
		struct ZSyntax221 * Pattern = GetSyntaxPattern__2qws(this->TokenContext->NameSpace, PatternName);
		if (Pattern == NULL) {
			struct ZToken78 * Token = ZToken__4qeu(_NewZToken78(), this, StartIndex, EndIndex);
			ZLogger_LogInfo__2qeu(Token, LibZen_StrCat("unregistered token pattern: ", PatternName));
			LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
		} else {
			struct ZToken78 * Token = ZPatternToken__5qa5(_NewZPatternToken464(), this, StartIndex, EndIndex, Pattern);
			LibZen_ArrayAdd((ArrayOfVar *)this->TokenContext->TokenList, (var)Token);
		};
	};
	return;
}
static int IsDefinedSyntax__3qwg(struct ZSourceContext52 * this, long StartIndex__1, long EndIndex__2) {
	if (EndIndex < LibZen_StringSize(this->SourceText)) {
		struct ZNameSpace49 * NameSpace = this->TokenContext->NameSpace;
		const char * Token = LibZen_SubString2(this->SourceText, StartIndex);
		struct ZSyntax221 * Pattern = GetRightSyntaxPattern__2qws(NameSpace, Token);
		if (Pattern != NULL) {
			return 1/*true*/;
		};
	};
	return 0/*false*/;
}
static void TokenizeDefinedSymbol__2qwg(struct ZSourceContext52 * this, long StartIndex__1) {
	long EndIndex = StartIndex + 2;
	while (IsDefinedSyntax__3qwg(this, StartIndex, EndIndex)) {
		EndIndex = EndIndex + 1;
	};
	Tokenize__3qwg(this, StartIndex, EndIndex - 1);
	return;
}
static void ApplyTokenFunc__2qwg(struct ZSourceContext52 * this, struct ZTokenFunc36 * TokenFunc__1) {
	long RollbackPosition = this->SourcePosition;
	while (TokenFunc != NULL) {
		this->SourcePosition = RollbackPosition;
		if (/*untyped*/NULL) {
			return;
		};
		TokenFunc = TokenFunc->ParentFunc;
	};
	TokenizeDefinedSymbol__2qwg(this, RollbackPosition);
	return;
}
static int DoTokenize__1qwg(struct ZSourceContext52 * this) {
	long TokenSize = LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList);
	long CheckPosition = this->SourcePosition;
	while (HasChar__1qwg(this)) {
		long CharCode = GetCharCode__1qwg(this);
		struct ZTokenFunc36 * TokenFunc = GetTokenFunc__2qws(this->TokenContext->NameSpace, CharCode);
		ApplyTokenFunc__2qwg(this, TokenFunc);
		if (LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList) > TokenSize) {
			break;
		};
		if (this->SourcePosition == CheckPosition) {
			/*untyped*/NULL;
			MoveNext__1qwg(this);
		};
	};
	if (LibZen_ArraySize((ArrayOfVar *)this->TokenContext->TokenList) > TokenSize) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void LogWarning__3qwg(struct ZSourceContext52 * this, long Position__1, const char * Message__2) {
	Report__2qrb(this->Logger, FormatErrorMarker__4qu6(this, "warning", Position, Message));
	return;
}
static struct ZSourceMacro266 * ZSourceMacro__4qid(struct ZSourceMacro266 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2, const char * Macro__3) {
	(void)ZMacroFunc__3qy3(this, FuncName, FuncType);
	this->Macro = Macro;
	return NULL;
}
static struct ZSymbolEntry226 * ZSymbolEntry__3qu0(struct ZSymbolEntry226 * this, struct ZSymbolEntry226 * Parent__1, struct ZNode55 * Node__2) {
	this->Parent = Parent;
	this->Node = Node;
	return NULL;
}
static struct ZSyntax221 * ZSyntax__4quy(struct ZSyntax221 * this, struct ZNameSpace49 * NameSpace__1, const char * PatternName__2, struct ZMatchFunction54 * MatchFunc__3) {
	this->PackageNameSpace = NameSpace;
	this->PatternName = PatternName;
	this->MatchFunc = MatchFunc;
	return NULL;
}
static const char * toString__1quy(struct ZSyntax221 * this) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(this->PatternName, "{"), ThrowError("type error: requested = String, given = ZMatchFunction")), "}");
}
static int IsBinaryOperator__1quy(struct ZSyntax221 * this) {
	return LibZen_IsFlag__2qqr(this->SyntaxFlag, ZSyntax_BinaryOperator_Z50);
}
static int IsRightJoin__2quy(struct ZSyntax221 * this, struct ZSyntax221 * Right__1) {
	long left = this->SyntaxFlag;
	long right = Right->SyntaxFlag;
	return (left < right || (left == right && !LibZen_IsFlag__2qqr(left, ZSyntax_LeftJoin_Z49) && !LibZen_IsFlag__2qqr(right, ZSyntax_LeftJoin_Z49)));
}
static int EqualsName__2quy(struct ZSyntax221 * this, const char * Name__1) {
	return LibZen_EqualsString__2qqy(this->PatternName, Name);
}
static struct ZToken78 * ZToken__4qeu(struct ZToken78 * this, struct ZSource239 * Source__1, long StartIndex__2, long EndIndex__3) {
	this->Source = Source;
	this->StartIndex = StartIndex;
	this->EndIndex = EndIndex;
	return NULL;
}
static const char * GetFileName__1qeu(struct ZToken78 * this) {
	return this->Source->FileName;
}
static long GetLineNumber__1qeu(struct ZToken78 * this) {
	return GetLineNumber__2qu6(this->Source, this->StartIndex);
}
static const char * GetChar__1qeu(struct ZToken78 * this) {
	if (this->Source != NULL) {
		return LibZen_GetChar__2qqy(this->Source->SourceText, this->StartIndex);
	};
	return "0";
}
static const char * GetText__1qeu(struct ZToken78 * this) {
	if (this->Source != NULL) {
		return LibZen_SubString2(this->Source->SourceText, this->StartIndex);
	};
	return "";
}
static const char * toString__1qeu(struct ZToken78 * this) {
	const char * ch = GetCharAt__2qu6(this->Source, this->StartIndex - 1);
	if (ch == "\"") {
		return LibZen_StrCat(LibZen_StrCat("\"", GetText__1qeu(this)), "\"");
	};
	return GetText__1qeu(this);
}
static int EqualsText__2qeu(struct ZToken78 * this, const char * Text__1) {
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
static int StartsWith__2qeu(struct ZToken78 * this, const char * Text__1) {
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
static int IsNull__1qeu(struct ZToken78 * this) {
	return (this == ZToken_NullToken_Z51);
}
static int IsIndent__1qeu(struct ZToken78 * this) {
	return LibZen_Is(this, 462);
}
static int IsNextWhiteSpace__1qeu(struct ZToken78 * this) {
	const char * ch = GetCharAt__2qu6(this->Source, this->EndIndex);
	if (ch == " " || ch == "\t" || ch == "\n") {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNameSymbol__1qeu(struct ZToken78 * this) {
	const char * ch = GetCharAt__2qu6(this->Source, this->StartIndex);
	return LibZen_IsSymbol__1qqy(ch);
}
static long GetIndentSize__1qeu(struct ZToken78 * this) {
	if (this->Source != NULL) {
		return CountIndentSize__2qu6(this->Source, GetLineHeadPosition__2qu6(this->Source, this->StartIndex));
	};
	return 0;
}
static struct ZTokenContext56 * ZTokenContext__6qwl(struct ZTokenContext56 * this, struct ZGenerator58 * Generator__1, struct ZNameSpace49 * NameSpace__2, const char * FileName__3, long LineNumber__4, const char * SourceText__5) {
	this->Generator = Generator;
	this->NameSpace = NameSpace;
	this->Source = ZSourceContext__5qwg(_NewZSourceContext52(), FileName, LineNumber, SourceText, this);
	return NULL;
}
static int SetParseFlag__2qwl(struct ZTokenContext56 * this, int AllowSkipIndent__1) {
	int OldFlag = this->IsAllowSkipIndent;
	this->IsAllowSkipIndent = AllowSkipIndent;
	return OldFlag;
}
static struct ZToken78 * GetBeforeToken__1qwl(struct ZTokenContext56 * this) {
	long MovingPos = this->CurrentPosition - 1;
	while (MovingPos >= 0 && MovingPos < LibZen_ArraySize((ArrayOfVar *)this->TokenList)) {
		struct ZToken78 * Token = Array<ZToken>GetIndex(MovingPos);
		if (!IsIndent__1qeu(Token)) {
			return Token;
		};
		MovingPos = MovingPos - 1;
	};
	return this->LatestToken;
}
static struct ZNode55 * CreateExpectedErrorNode__3qwl(struct ZTokenContext56 * this, struct ZToken78 * SourceToken__1, const char * ExpectedTokenText__2) {
	if (SourceToken == NULL || IsNull__1qeu(SourceToken)) {
		SourceToken = GetBeforeToken__1qwl(this);
		SourceToken = ZToken__4qeu(_NewZToken78(), SourceToken->Source, SourceToken->EndIndex, SourceToken->EndIndex);
		return ZErrorNode__4qpd(_NewZErrorNode338(), NULL, SourceToken, LibZen_StrCat(ExpectedTokenText, " is expected"));
	};
	return ZErrorNode__4qpd(_NewZErrorNode338(), NULL, SourceToken, LibZen_StrCat(ExpectedTokenText, " is expected"));
}
static void Vacume__1qwl(struct ZTokenContext56 * this) {
	return;
}
static void MoveNext__1qwl(struct ZTokenContext56 * this) {
	this->CurrentPosition = this->CurrentPosition + 1;
	return;
}
static struct ZToken78 * GetToken__2qwl(struct ZTokenContext56 * this, int EnforceMoveNext__1) {
	while (1/*true*/) {
		if (!(this->CurrentPosition < LibZen_ArraySize((ArrayOfVar *)this->TokenList))) {
			if (!DoTokenize__1qwg(this->Source)) {
				break;
			};
		};
		struct ZToken78 * Token = Array<ZToken>GetIndex(this->CurrentPosition);
		if ((this->IsAllowSkipIndent) && IsIndent__1qeu(Token)) {
			this->CurrentPosition = this->CurrentPosition + 1;
		} else {
			this->LatestToken = Token;
			if (EnforceMoveNext) {
				this->CurrentPosition = this->CurrentPosition + 1;
			};
			return Token;
		};
	};
	return ZToken_NullToken_Z51;
}
static struct ZToken78 * GetToken__1qwl(struct ZTokenContext56 * this) {
	return GetToken__2qwl(this, 0/*false*/);
}
static int HasNext__1qwl(struct ZTokenContext56 * this) {
	return (GetToken__1qwl(this) != ZToken_NullToken_Z51);
}
static void SkipIndent__1qwl(struct ZTokenContext56 * this) {
	struct ZToken78 * Token = GetToken__1qwl(this);
	while (IsIndent__1qeu(Token)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		Token = GetToken__1qwl(this);
	};
	return;
}
static void SkipError__2qwl(struct ZTokenContext56 * this, struct ZToken78 * ErrorToken__1) {
	long StartIndex = ErrorToken->StartIndex;
	long EndIndex = ErrorToken->EndIndex;
	long length = GetIndentSize__1qeu(ErrorToken);
	while (HasNext__1qwl(this)) {
		struct ZToken78 * Token = GetToken__1qwl(this);
		EndIndex = Token->EndIndex;
		this->CurrentPosition = this->CurrentPosition + 1;
		if (LibZen_Is(Token, 462)) {
			long ilength = GetIndentSize__1qeu(Token);
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
static int IsToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1) {
	struct ZToken78 * Token = GetToken__1qwl(this);
	if (EqualsText__2qeu(Token, TokenText)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNewLineToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	SkipIndent__1qwl(this);
	struct ZToken78 * Token = GetToken__1qwl(this);
	if (EqualsText__2qeu(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static int MatchToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	struct ZToken78 * Token = GetToken__2qwl(this, ZTokenContext_MoveNext_Z57);
	if (EqualsText__2qeu(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static int MatchNewLineToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	SkipIndent__1qwl(this);
	struct ZToken78 * Token = GetToken__2qwl(this, ZTokenContext_MoveNext_Z57);
	if (EqualsText__2qeu(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static struct ZToken78 * ParseLargeToken__1qwl(struct ZTokenContext56 * this) {
	struct ZToken78 * Token = GetToken__2qwl(this, ZTokenContext_MoveNext_Z57);
	if (IsNextWhiteSpace__1qeu(Token)) {
		return Token;
	};
	long StartIndex = Token->StartIndex;
	long EndIndex = Token->EndIndex;
	while (HasNext__1qwl(this) && !IsNextWhiteSpace__1qeu(Token)) {
		long RollbackPosition = this->CurrentPosition;
		Token = GetToken__2qwl(this, ZTokenContext_MoveNext_Z57);
		if (IsIndent__1qeu(Token) || EqualsText__2qeu(Token, ";") || EqualsText__2qeu(Token, ",")) {
			this->CurrentPosition = RollbackPosition;
			break;
		};
		EndIndex = Token->EndIndex;
	};
	return ZToken__4qeu(_NewZToken78(), Token->Source, StartIndex, EndIndex);
}
static struct ZNode55 * MatchToken__4qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, const char * TokenText__2, int IsRequired__3) {
	if (!IsErrorNode__1qwk(ParentNode)) {
		long RollbackPosition = this->CurrentPosition;
		struct ZToken78 * Token = GetToken__2qwl(this, ZTokenContext_MoveNext_Z57);
		if (EqualsText__2qeu(Token, TokenText)) {
			if (ParentNode->SourceToken == NULL) {
				ParentNode->SourceToken = Token;
			};
		} else {
			if (IsRequired) {
				return CreateExpectedErrorNode__3qwl(this, Token, TokenText);
			} else {
				this->CurrentPosition = RollbackPosition;
			};
		};
	};
	return ParentNode;
}
static struct ZSyntax221 * GetApplyingSyntax__1qwl(struct ZTokenContext56 * this) {
	return this->ApplyingPattern;
}
static struct ZNode55 * ApplyMatchPattern__5qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * LeftNode__2, struct ZSyntax221 * Pattern__3, int IsRequired__4) {
	long RollbackPosition = this->CurrentPosition;
	struct ZSyntax221 * CurrentPattern = Pattern;
	struct ZToken78 * TopToken = GetToken__1qwl(this);
	struct ZNode55 * ParsedNode = NULL;
	while (CurrentPattern != NULL) {
		int Remembered = this->IsAllowSkipIndent;
		this->CurrentPosition = RollbackPosition;
		this->ApplyingPattern = CurrentPattern;
		ParsedNode = /*untyped*/NULL;
		LibZen_Assert(ParsedNode != ParentNode, "(libzen/libzen.zen:3357)");
		this->ApplyingPattern = NULL;
		this->IsAllowSkipIndent = Remembered;
		if (ParsedNode != NULL && !IsErrorNode__1qwk(ParsedNode)) {
			return ParsedNode;
		};
		CurrentPattern = CurrentPattern->ParentPattern;
	};
	if (!IsRequired) {
		this->CurrentPosition = RollbackPosition;
		return NULL;
	};
	if (this->CurrentPosition == RollbackPosition) {
		/*untyped*/NULL;
		LibZen_Assert(this->CurrentPosition != RollbackPosition, "(libzen/libzen.zen:3371)");
	};
	if (ParsedNode == NULL) {
		ParsedNode = CreateExpectedErrorNode__3qwl(this, TopToken, Pattern->PatternName);
	};
	return ParsedNode;
}
static struct ZNode55 * ParsePatternAfter__5qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * LeftNode__2, const char * PatternName__3, int IsRequired__4) {
	struct ZSyntax221 * Pattern = GetSyntaxPattern__2qws(this->NameSpace, PatternName);
	struct ZNode55 * ParsedNode = ApplyMatchPattern__5qwl(this, ParentNode, LeftNode, Pattern, IsRequired);
	return ParsedNode;
}
static struct ZNode55 * ParsePattern__4qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, const char * PatternName__2, int IsRequired__3) {
	return ParsePatternAfter__5qwl(this, ParentNode, NULL, PatternName, IsRequired);
}
static struct ZNode55 * MatchPattern__6qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4, int AllowSkipIndent__5) {
	if (!IsErrorNode__1qwk(ParentNode)) {
		int Rememberd = SetParseFlag__2qwl(this, AllowSkipIndent);
		struct ZNode55 * ParsedNode = ParsePattern__4qwl(this, ParentNode, PatternName, IsRequired);
		(void)SetParseFlag__2qwl(this, Rememberd);
		if (ParsedNode != NULL) {
			if (Index == ZNode_NestedAppendIndex_Z23) {
				if (!(LibZen_Is(ParsedNode, 336))) {
					Set__3qwk(ParentNode, ZNode_AppendIndex_Z22, ParsedNode);
				};
				if (LibZen_Is(ParsedNode, 163) || IsErrorNode__1qwk(ParsedNode)) {
					return ParsedNode;
				};
			};
			if (IsErrorNode__1qwk(ParsedNode)) {
				return ParsedNode;
			} else {
				if (!(LibZen_Is(ParsedNode, 336))) {
					Set__3qwk(ParentNode, Index, ParsedNode);
				};
			};
		};
	};
	return ParentNode;
}
static struct ZNode55 * MatchPattern__5qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4) {
	return MatchPattern__6qwl(this, ParentNode, Index, PatternName, IsRequired, ZTokenContext_NotAllowSkipIndent_Z55);
}
static struct ZNode55 * MatchOptionaPattern__6qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, long Index__2, int AllowNewLine__3, const char * TokenText__4, const char * PatternName__5) {
	if (!IsErrorNode__1qwk(ParentNode)) {
		if (MatchToken__2qwl(this, TokenText)) {
			return MatchPattern__6qwl(this, ParentNode, Index, PatternName, ZTokenContext_Optional_Z53, ZTokenContext_NotAllowSkipIndent_Z55);
		};
	};
	return ParentNode;
}
static struct ZNode55 * MatchNtimes__6qwl(struct ZTokenContext56 * this, struct ZNode55 * ParentNode__1, const char * StartToken__2, const char * PatternName__3, const char * DelimToken__4, const char * StopToken__5) {
	int Rememberd = SetParseFlag__2qwl(this, 1/*true*/);
	int IsRequired = ZTokenContext_Optional_Z53;
	if (StartToken != NULL) {
		ParentNode = MatchToken__4qwl(this, ParentNode, StartToken, ZTokenContext_Required_Z52);
	};
	while (!IsErrorNode__1qwk(ParentNode)) {
		if (StopToken != NULL) {
			struct ZToken78 * Token = GetToken__1qwl(this);
			if (EqualsText__2qeu(Token, StopToken)) {
				break;
			};
			IsRequired = ZTokenContext_Required_Z52;
		};
		struct ZNode55 * ParsedNode = ParsePattern__4qwl(this, ParentNode, PatternName, IsRequired);
		if (ParsedNode == NULL) {
			break;
		};
		if (IsErrorNode__1qwk(ParsedNode)) {
			return ParsedNode;
		};
		if (!(LibZen_Is(ParsedNode, 336))) {
			Set__3qwk(ParentNode, ZNode_AppendIndex_Z22, ParsedNode);
		};
		if (DelimToken != NULL) {
			if (!MatchToken__2qwl(this, DelimToken)) {
				break;
			};
		};
	};
	if (StopToken != NULL) {
		ParentNode = MatchToken__4qwl(this, ParentNode, StopToken, ZTokenContext_Required_Z52);
	};
	(void)SetParseFlag__2qwl(this, Rememberd);
	return ParentNode;
}
static int StartsWithToken__2qwl(struct ZTokenContext56 * this, const char * TokenText__1) {
	struct ZToken78 * Token = GetToken__1qwl(this);
	if (EqualsText__2qeu(Token, TokenText)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		return 1/*true*/;
	};
	if (StartsWith__2qeu(Token, TokenText)) {
		Token = ZToken__4qeu(_NewZToken78(), Token->Source, Token->StartIndex + LibZen_StringSize(TokenText), Token->EndIndex);
		this->CurrentPosition = this->CurrentPosition + 1;
		LibZen_ArrayAdd2((ArrayOfVar *)this->TokenList, this->CurrentPosition, (var)Token);
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void SkipEmptyStatement__1qwl(struct ZTokenContext56 * this) {
	while (HasNext__1qwl(this)) {
		struct ZToken78 * Token = GetToken__1qwl(this);
		if (IsIndent__1qeu(Token) || EqualsText__2qeu(Token, ";")) {
			this->CurrentPosition = this->CurrentPosition + 1;
			/*untyped*/NULL;
		};
		break;
	};
	return;
}
static void Dump__1qwl(struct ZTokenContext56 * this) {
	long Position = this->CurrentPosition;
	while (Position < LibZen_ArraySize((ArrayOfVar *)this->TokenList)) {
		struct ZToken78 * Token = Array<ZToken>GetIndex(Position);
		const char * DumpedToken = "[";
		DumpedToken = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(DumpedToken, LibZen_IntToString(Position)), "] "), toString__1qeu(Token));
		LibZen_PrintDebug__1qqy(DumpedToken);
		Position = Position + 1;
	};
	return;
}
static struct ZTokenFunc36 * ZTokenFunc__3qwq(struct ZTokenFunc36 * this, struct ZTokenFunction51 * Func__1, struct ZTokenFunc36 * Parent__2) {
	this->Func = Func;
	this->ParentFunc = Parent;
	return NULL;
}
static const char * toString__1qwq(struct ZTokenFunc36 * this) {
	return /*untyped*/NULL;
}
static struct ZVariable231 * ZVariable__7quf(struct ZVariable231 * this, struct ZSymbolEntry226 * Parent__1, struct ZFunctionNode146 * FuncNode__2, long VarFlag__3, struct ZType65 * VarType__4, const char * VarName__5, struct ZToken78 * SourceToken__6) {
	(void)ZSymbolEntry__3qu0(this, Parent, FuncNode);
	this->VarFlag = VarFlag;
	this->VarType = VarType;
	this->VarName = VarName;
	this->SourceToken = SourceToken;
	this->VarUniqueIndex = GetVarIndex__1qte(FuncNode);
	this->UsedCount = 0;
	this->DefCount = 1;
	return NULL;
}
static int IsCaptured__2quf(struct ZVariable231 * this, struct ZFunctionNode146 * CurrentFunctionNode__1) {
	if (CurrentFunctionNode == ThrowError("type error: requested = ZFunctionNode, given = ZNode")) {
		return 0/*false*/;
	};
	return 1/*true*/;
}
static void Defined__1quf(struct ZVariable231 * this) {
	this->DefCount = this->DefCount + 1;
	return;
}
static void Used__1quf(struct ZVariable231 * this) {
	this->UsedCount = this->UsedCount + 1;
	return;
}
static struct ZArrayType302 * ZArrayType__3qod(struct ZArrayType302 * this, long TypeFlag__1, struct ZType65 * ParamType__2) {
	(void)ZGeneric1Type__5qrq(this, TypeFlag, LibZen_StrCat(ThrowError("type error: requested = String, given = ZType"), "[]"), ZTypeArrayType_Z10, ParamType);
	return NULL;
}
static struct ZAnnotationNode304 * ZAnnotationNode__4qog(struct ZAnnotationNode304 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, MapOfObject * Anno__3) {
	(void)ZNode__4qwk(this, ParentNode, Token, 0);
	return NULL;
}
static int IsBreakingBlock__1qog(struct ZAnnotationNode304 * this) {
	return /*untyped*/NULL(this->AnnotatedNode);
}
static void Accept__2qog(struct ZAnnotationNode304 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(this->AnnotatedNode, Visitor);
	return;
}
static struct ZAssertNode310 * ZAssertNode__2qo1(struct ZAssertNode310 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	return NULL;
}
static struct ZSugarNode167 * DeSugar__2qo1(struct ZAssertNode310 * this, struct ZGenerator58 * Generator__1) {
	struct ZMacroFunc213 * Func = GetMacroFunc__4qw1(Generator, "assert", ZTypeBooleanType_Z5, 2);
	if (Func != NULL) {
		struct ZMacroNode394 * MacroNode = ZMacroNode__4q02(_NewZMacroNode394(), this->ParentNode, this->SourceToken, Func);
		Append__2qiq(MacroNode, Array<ZNode>GetIndex(ZAssertNode_Expr_Z58));
		Append__2qiq(MacroNode, ZStringNode__4qaw(_NewZStringNode433(), MacroNode, NULL, GetSourceLocation__1qwk(this)));
		return ZSugarNode__3qt6(_NewZSugarNode167(), this, MacroNode);
	} else {
		struct ZFuncCallNode409 * MacroNode = ZFuncCallNode__4q4s(_NewZFuncCallNode409(), this->ParentNode, "assert", ZTypeVarType_Z3);
		Append__2qiq(MacroNode, Array<ZNode>GetIndex(ZAssertNode_Expr_Z58));
		return ZSugarNode__3qt6(_NewZSugarNode167(), this, MacroNode);
	};
}
static struct ZBinaryNode313 * ZBinaryNode__5qox(struct ZBinaryNode313 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4) {
	(void)ZNode__4qwk(this, ParentNode, SourceToken, 2);
	Set__3qwk(this, ZBinaryNode_Left_Z59, Left);
	LibZen_Assert(Pattern != NULL, "(libzen/libzen.zen:3576)");
	this->Pattern = Pattern;
	return NULL;
}
static int IsRightJoin__2qox(struct ZBinaryNode313 * this, struct ZNode55 * Node__1) {
	if (LibZen_Is(Node, 313)) {
		return IsRightJoin__2quy(this->Pattern, ((struct ZBinaryNode313 *)Node)->Pattern);
	};
	return 0/*false*/;
}
static struct ZNode55 * RightJoin__3qox(struct ZBinaryNode313 * this, struct ZNode55 * ParentNode__1, struct ZBinaryNode313 * RightNode__2) {
	struct ZNode55 * RightLeftNode = Array<ZNode>GetIndex(ZBinaryNode_Left_Z59);
	if (IsRightJoin__2qox(this, RightLeftNode)) {
		Set__3qwk(RightNode, ZBinaryNode_Left_Z59, RightJoin__3qox(this, ParentNode, (struct ZBinaryNode313 *)RightLeftNode));
	} else {
		Set__3qwk(RightNode, ZBinaryNode_Left_Z59, this);
		Set__3qwk(this, ZBinaryNode_Right_Z60, RightLeftNode);
	};
	return RightNode;
}
static struct ZNode55 * AppendParsedRightNode__3qox(struct ZBinaryNode313 * this, struct ZNode55 * ParentNode__1, struct ZTokenContext56 * TokenContext__2) {
	struct ZNode55 * RightNode = ParsePattern__4qwl(TokenContext, ParentNode, "$Expression$", ZTokenContext_Required_Z52);
	if (IsErrorNode__1qwk(RightNode)) {
		return RightNode;
	};
	if (IsRightJoin__2qox(this, RightNode)) {
		return RightJoin__3qox(this, ParentNode, (struct ZBinaryNode313 *)RightNode);
	};
	Set__3qwk(this, ZBinaryNode_Right_Z60, RightNode);
	return this;
}
static struct ZNode55 * TryMacroNode__2qox(struct ZBinaryNode313 * this, struct ZGenerator58 * Generator__1) {
	if (!/*untyped*/NULL(GetAstType__2qwk(this, ZBinaryNode_Left_Z59)) && !/*untyped*/NULL(GetAstType__2qwk(this, ZBinaryNode_Right_Z60))) {
		const char * Op = GetText__1qeu(this->SourceToken);
		struct ZFunc90 * Func = GetDefinedFunc__4qw1(Generator, Op, GetAstType__2qwk(this, ZBinaryNode_Left_Z59), 2);
		if (LibZen_Is(Func, 213)) {
			struct ZMacroNode394 * MacroNode = ZMacroNode__4q02(_NewZMacroNode394(), this->ParentNode, this->SourceToken, (struct ZMacroFunc213 *)Func);
			Append__2qiq(MacroNode, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
			Append__2qiq(MacroNode, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
			return MacroNode;
		};
	};
	return this;
}
static void Accept__2qox(struct ZBinaryNode313 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZBreakNode320 * ZBreakNode__2qo5(struct ZBreakNode320 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 0);
	return NULL;
}
static void Accept__2qo5(struct ZBreakNode320 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZCastNode323 * ZCastNode__4qo8(struct ZCastNode323 * this, struct ZNode55 * ParentNode__1, struct ZType65 * CastType__2, struct ZNode55 * Node__3) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	this->Type = CastType;
	if (Node != NULL) {
		Set__3qwk(this, ZCastNode_Expr_Z61, Node);
	};
	return NULL;
}
static void Accept__2qo8(struct ZCastNode323 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZListNode252 * ToFuncCallNode__2qo8(struct ZCastNode323 * this, struct ZFunc90 * Func__1) {
	if (LibZen_Is(Func, 213)) {
		struct ZMacroNode394 * FuncNode = ZMacroNode__4q02(_NewZMacroNode394(), this->ParentNode, this->SourceToken, (struct ZMacroFunc213 *)Func);
		Append__2qiq(FuncNode, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
		return FuncNode;
	} else {
		struct ZFuncCallNode409 * FuncNode = ZFuncCallNode__4q4s(_NewZFuncCallNode409(), this->ParentNode, Func->FuncName, GetFuncType__1qej(Func));
		FuncNode->SourceToken = this->SourceToken;
		Append__2qiq(FuncNode, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
		return FuncNode;
	};
}
static struct ZCatchNode327 * ZCatchNode__2qpr(struct ZCatchNode327 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qpr(struct ZCatchNode327 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->ExceptionType = Type;
	return;
}
static void SetNameInfo__3qpr(struct ZCatchNode327 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->ExceptionName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZComparatorNode331 * ZComparatorNode__5qpi(struct ZComparatorNode331 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4) {
	(void)ZBinaryNode__5qox(this, ParentNode, SourceToken, Left, Pattern);
	return NULL;
}
static void Accept__2qpi(struct ZComparatorNode331 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZConstNode334 * ZConstNode__3qp0(struct ZConstNode334 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2) {
	(void)ZNode__4qwk(this, ParentNode, SourceToken, 0);
	return NULL;
}
static struct ZEmptyNode336 * ZEmptyNode__3qpa(struct ZEmptyNode336 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2) {
	(void)ZNode__4qwk(this, ParentNode, Token, 0);
	return NULL;
}
static struct ZErrorNode338 * ZErrorNode__4qpd(struct ZErrorNode338 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, const char * ErrorMessage__3) {
	(void)ZConstNode__3qp0(this, ParentNode, SourceToken);
	this->ErrorMessage = ErrorMessage;
	return NULL;
}
static struct ZErrorNode338 * ZErrorNode__3qpd(struct ZErrorNode338 * this, struct ZNode55 * Node__1, const char * ErrorMessage__2) {
	(void)ZConstNode__3qp0(this, Node->ParentNode, Node->SourceToken);
	this->ErrorMessage = ErrorMessage;
	return NULL;
}
static void Accept__2qpd(struct ZErrorNode338 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFieldNode342 * ZFieldNode__2qpj(struct ZFieldNode342 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qpj(struct ZFieldNode342 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->DeclType = Type;
	return;
}
static void SetNameInfo__3qpj(struct ZFieldNode342 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZFloatNode346 * ZFloatNode__4qp1(struct ZFloatNode346 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, double Value__3) {
	(void)ZConstNode__3qp0(this, ParentNode, Token);
	this->Type = ZTypeFloatType_Z7;
	this->FloatValue = Value;
	return NULL;
}
static void Accept__2qp1(struct ZFloatNode346 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGetIndexNode349 * ZGetIndexNode__3qpx(struct ZGetIndexNode349 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 2);
	Array<ZNode>SetIndex(ZGetIndexNode_Recv_Z64, SetChild__2qwk(this, RecvNode));
	return NULL;
}
static void Accept__2qpx(struct ZGetIndexNode349 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGetNameNode352 * ZGetNameNode__4qpb(struct ZGetNameNode352 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, const char * NativeName__3) {
	(void)ZNode__4qwk(this, ParentNode, Token, 0);
	this->VarName = NativeName;
	return NULL;
}
static struct ZGetNameNode352 * ZGetNameNode__3qpb(struct ZGetNameNode352 * this, struct ZNode55 * ParentNode__1, struct ZFunc90 * ResolvedFunc__2) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 0);
	this->VarName = ResolvedFunc->FuncName;
	this->Type = GetFuncType__1qej(ResolvedFunc);
	return NULL;
}
static void Accept__2qpb(struct ZGetNameNode352 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNode55 * ToGlobalNameNode__1qpb(struct ZGetNameNode352 * this) {
	return ZGlobalNameNode__6q0e(_NewZGlobalNameNode362(), this->ParentNode, this->SourceToken, this->Type, this->VarName, 0/*false*/);
}
static struct ZGetterNode357 * ZGetterNode__3qp3(struct ZGetterNode357 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	Set__3qwk(this, ZGetterNode_Recv_Z66, RecvNode);
	return NULL;
}
static void SetNameInfo__3qp3(struct ZGetterNode357 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qp3(struct ZGetterNode357 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsStaticField__1qp3(struct ZGetterNode357 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZGetterNode_Recv_Z66), 236);
}
static struct ZGlobalNameNode362 * ZGlobalNameNode__6q0e(struct ZGlobalNameNode362 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZType65 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5) {
	(void)ZNode__4qwk(this, ParentNode, SourceToken, 0);
	this->GlobalName = GlobalName;
	this->Type = Type;
	this->IsStaticFuncName = IsStaticFuncName;
	return NULL;
}
static int IsGivenName__1q0e(struct ZGlobalNameNode362 * this) {
	return (!this->IsStaticFuncName);
}
static void Accept__2q0e(struct ZGlobalNameNode362 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGroupNode366 * ZGroupNode__2q0u(struct ZGroupNode366 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	return NULL;
}
static void Accept__2q0u(struct ZGroupNode366 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZIfNode369 * ZIfNode__2q0p(struct ZIfNode369 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 3);
	return NULL;
}
static void Accept__2q0p(struct ZIfNode369 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZImportNode372 * ZImportNode__2q0a(struct ZImportNode372 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetNameInfo__3q0a(struct ZImportNode372 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	if (this->ResourcePath == NULL) {
		this->ResourcePath = Name;
		this->ResourceToken = NameToken;
	} else {
		this->Alias = Name;
	};
	return;
}
static struct ZInstanceOfNode375 * ZInstanceOfNode__4q0f(struct ZInstanceOfNode375 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, struct ZNode55 * LeftNode__3) {
	(void)ZNode__4qwk(this, ParentNode, Token, 1);
	Set__3qwk(this, ZInstanceOfNode_Left_Z71, LeftNode);
	return NULL;
}
static void SetTypeInfo__3q0f(struct ZInstanceOfNode375 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->TargetType = Type;
	return;
}
static void Accept__2q0f(struct ZInstanceOfNode375 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZIntNode379 * ZIntNode__4q0k(struct ZIntNode379 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, long Value__3) {
	(void)ZConstNode__3qp0(this, ParentNode, Token);
	this->Type = ZTypeIntType_Z6;
	this->IntValue = Value;
	return NULL;
}
static void Accept__2q0k(struct ZIntNode379 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZLetNode382 * ZLetNode__2q01(struct ZLetNode382 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetNameInfo__3q01(struct ZLetNode382 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->Symbol = Name;
	this->SymbolToken = NameToken;
	return;
}
static void SetTypeInfo__3q01(struct ZLetNode382 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->SymbolType = Type;
	return;
}
static void Accept__2q01(struct ZLetNode382 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGlobalNameNode362 * ToGlobalNameNode__1q01(struct ZLetNode382 * this) {
	return ZGlobalNameNode__6q0e(_NewZGlobalNameNode362(), NULL, this->SymbolToken, GetAstType__2qwk(this, ZLetNode_InitValue_Z72), this->GlobalName, 0/*false*/);
}
static struct ZListNode252 * ZListNode__4qiq(struct ZListNode252 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, long Size__3) {
	(void)ZNode__4qwk(this, ParentNode, SourceToken, Size);
	this->ListStartIndex = Size;
	return NULL;
}
static void Append__2qiq(struct ZListNode252 * this, struct ZNode55 * Node__1) {
	if (this->AST == NULL) {
		this->AST = /*untyped*/NULL;
		Set__3qwk(this, 0, Node);
	} else {
		ArrayOfZNode * newAST = /*untyped*/NULL;
		/*untyped*/NULL;
		this->AST = newAST;
		Set__3qwk(this, /*untyped*/NULL, Node);
	};
	return;
}
static long GetListSize__1qiq(struct ZListNode252 * this) {
	return GetAstSize__1qwk(this) - this->ListStartIndex;
}
static struct ZNode55 * GetListAt__2qiq(struct ZListNode252 * this, long Index__1) {
	return Array<ZNode>GetIndex(this->ListStartIndex + Index);
}
static void SetListAt__3qiq(struct ZListNode252 * this, long Index__1, struct ZNode55 * Node__2) {
	Set__3qwk(this, Index + this->ListStartIndex, Node);
	return;
}
static void InsertListAt__3qiq(struct ZListNode252 * this, long Index__1, struct ZNode55 * Node__2) {
	if (this->AST == NULL || Index < 0 || /*untyped*/NULL == Index) {
		Append__2qiq(this, Node);
	} else {
		ArrayOfZNode * newAST = /*untyped*/NULL;
		Index = this->ListStartIndex + Index;
		/*untyped*/NULL;
		Set__3qwk(this, Index, Node);
		/*untyped*/NULL;
		this->AST = newAST;
	};
	return;
}
static struct ZNode55 * RemoveListAt__2qiq(struct ZListNode252 * this, long Index__1) {
	struct ZNode55 * Removed = GetListAt__2qiq(this, Index);
	ArrayOfZNode * newAST = /*untyped*/NULL;
	long RemovedIndex = this->ListStartIndex + Index;
	/*untyped*/NULL;
	/*untyped*/NULL;
	this->AST = newAST;
	return Removed;
}
static void ClearListAfter__2qiq(struct ZListNode252 * this, long Size__1) {
	if (Size < GetListSize__1qiq(this)) {
		long newsize = this->ListStartIndex + Size;
		if (newsize == 0) {
			this->AST = NULL;
		} else {
			ArrayOfZNode * newAST = /*untyped*/NULL;
			/*untyped*/NULL;
			this->AST = newAST;
		};
	};
	return;
}
static struct ZMacroNode394 * ZMacroNode__4q02(struct ZMacroNode394 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZMacroFunc213 * MacroFunc__3) {
	(void)ZListNode__4qiq(this, ParentNode, SourceToken, 0);
	this->MacroFunc = MacroFunc;
	LibZen_Assert(MacroFunc != NULL, "(libzen/libzen.zen:3934)");
	return NULL;
}
static struct ZFuncType91 * GetFuncType__1q02(struct ZMacroNode394 * this) {
	return GetFuncType__1qej(this->MacroFunc);
}
static const char * GetMacroText__1q02(struct ZMacroNode394 * this) {
	struct ZMacroFunc213 * Func = this->MacroFunc;
	if (LibZen_Is(Func, 266)) {
		return ((struct ZSourceMacro266 *)Func)->Macro;
	};
	return "";
}
static void Accept__2q02(struct ZMacroNode394 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZMapEntryNode399 * ZMapEntryNode__2q4r(struct ZMapEntryNode399 * this, struct ZNode55 * ParentNode__1) {
	(void)ZNode__4qwk(this, ParentNode, NULL, 2);
	return NULL;
}
static struct ZMapLiteralNode401 * ZMapLiteralNode__2q4y(struct ZMapLiteralNode401 * this, struct ZNode55 * ParentNode__1) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 0);
	return NULL;
}
static struct ZMapEntryNode399 * GetMapEntryNode__2q4y(struct ZMapLiteralNode401 * this, long Index__1) {
	struct ZNode55 * Node = GetListAt__2qiq(this, Index);
	if (LibZen_Is(Node, 399)) {
		return (struct ZMapEntryNode399 *)Node;
	};
	return NULL;
}
static void Accept__2q4y(struct ZMapLiteralNode401 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZMethodCallNode405 * ZMethodCallNode__3q4p(struct ZMethodCallNode405 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * RecvNode__2) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 1);
	Set__3qwk(this, ZMethodCallNode_Recv_Z75, RecvNode);
	return NULL;
}
static void SetNameInfo__3q4p(struct ZMethodCallNode405 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->MethodName = Name;
	this->MethodToken = NameToken;
	return;
}
static void Accept__2q4p(struct ZMethodCallNode405 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFuncCallNode409 * ToGetterFuncCall__1q4p(struct ZMethodCallNode405 * this) {
	struct ZGetterNode357 * Getter = ZGetterNode__3qp3(_NewZGetterNode357(), NULL, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
	Getter->SetNameInfo(Getter, this->MethodToken, this->MethodName);
	struct ZFuncCallNode409 * FuncNode = ZFuncCallNode__3q4s(_NewZFuncCallNode409(), this->ParentNode, Getter);
	FuncNode->SourceToken = this->SourceToken;
	Append__2qiq(FuncNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
	long i = 0;
	while (i < GetListSize__1qiq(this)) {
		Append__2qiq(FuncNode, GetListAt__2qiq(this, i));
		i = i + 1;
	};
	return FuncNode;
}
static struct ZListNode252 * ToFuncCallNode__2q4p(struct ZMethodCallNode405 * this, struct ZFunc90 * Func__1) {
	if (LibZen_Is(Func, 213)) {
		struct ZMacroNode394 * MacroNode = ZMacroNode__4q02(_NewZMacroNode394(), this->ParentNode, this->MethodToken, (struct ZMacroFunc213 *)Func);
		Append__2qiq(MacroNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
		long i = 0;
		while (i < GetListSize__1qiq(this)) {
			Append__2qiq(MacroNode, GetListAt__2qiq(this, i));
			i = i + 1;
		};
		return MacroNode;
	} else {
		struct ZFuncCallNode409 * FuncNode = ZFuncCallNode__4q4s(_NewZFuncCallNode409(), this->ParentNode, Func->FuncName, GetFuncType__1qej(Func));
		FuncNode->SourceToken = this->MethodToken;
		Append__2qiq(FuncNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
		long i = 0;
		while (i < GetListSize__1qiq(this)) {
			Append__2qiq(FuncNode, GetListAt__2qiq(this, i));
			i = i + 1;
		};
		return FuncNode;
	};
}
static struct ZNewArrayNode412 * ZNewArrayNode__4q4g(struct ZNewArrayNode412 * this, struct ZNode55 * ParentNode__1, struct ZType65 * Type__2, struct ZToken78 * Token__3) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 0);
	return NULL;
}
static struct ZNewObjectNode414 * ZNewObjectNode__2q4j(struct ZNewObjectNode414 * this, struct ZNode55 * ParentNode__1) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 0);
	return NULL;
}
static void Accept__2q4j(struct ZNewObjectNode414 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZListNode252 * ToFuncCallNode__2q4j(struct ZNewObjectNode414 * this, struct ZFunc90 * Func__1) {
	struct ZListNode252 * FuncNode = NULL;
	if (LibZen_Is(Func, 213)) {
		FuncNode = ZMacroNode__4q02(_NewZMacroNode394(), this->ParentNode, this->SourceToken, (struct ZMacroFunc213 *)Func);
	} else {
		FuncNode = ZFuncCallNode__4q4s(_NewZFuncCallNode409(), this->ParentNode, Func->FuncName, GetFuncType__1qej(Func));
		FuncNode->SourceToken = this->SourceToken;
	};
	Append__2qiq(FuncNode, this);
	long i = 0;
	while (i < GetListSize__1qiq(this)) {
		Append__2qiq(FuncNode, GetListAt__2qiq(this, i));
		i = i + 1;
	};
	ClearListAfter__2qiq(this, 0);
	return FuncNode;
}
static struct ZNotNode418 * ZNotNode__3q41(struct ZNotNode418 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2) {
	(void)ZUnaryNode__3qyk(this, ParentNode, Token);
	return NULL;
}
static void Accept__2q41(struct ZNotNode418 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNullNode421 * ZNullNode__3q4x(struct ZNullNode421 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2) {
	(void)ZConstNode__3qp0(this, ParentNode, SourceToken);
	return NULL;
}
static void Accept__2q4x(struct ZNullNode421 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZOrNode424 * ZOrNode__5q4b(struct ZOrNode424 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4) {
	(void)ZBinaryNode__5qox(this, ParentNode, Token, Left, Pattern);
	return NULL;
}
static void Accept__2q4b(struct ZOrNode424 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZPrototypeNode427 * ZPrototypeNode__2q47(struct ZPrototypeNode427 * this, struct ZNode55 * ParentNode__1) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetTypeInfo__3q47(struct ZPrototypeNode427 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->ReturnType = Type;
	return;
}
static void SetNameInfo__3q47(struct ZPrototypeNode427 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->FuncName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZParamNode174 * GetParamNode__2q47(struct ZPrototypeNode427 * this, long Index__1) {
	struct ZNode55 * Node = GetListAt__2qiq(this, Index);
	if (LibZen_Is(Node, 174)) {
		return (struct ZParamNode174 *)Node;
	};
	return NULL;
}
static struct ZFuncType91 * GetFuncType__1q47(struct ZPrototypeNode427 * this) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)this->ReturnType->GetRealType(this->ReturnType));
	long i = 0;
	while (i < GetListSize__1qiq(this)) {
		struct ZParamNode174 * Node = GetParamNode__2q47(this, i);
		struct ZType65 * ParamType = Node->Type->GetRealType(Node->Type);
		LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)ParamType);
		i = i + 1;
	};
	return ZTypePool_LookupFuncType__1qwm(TypeList);
}
static struct ZStringNode433 * ZStringNode__4qaw(struct ZStringNode433 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, const char * Value__3) {
	(void)ZConstNode__3qp0(this, ParentNode, Token);
	this->Type = ZTypeStringType_Z8;
	this->StringValue = Value;
	return NULL;
}
static void Accept__2qaw(struct ZStringNode433 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZStupidCastErrorNode436 * ZStupidCastErrorNode__3qat(struct ZStupidCastErrorNode436 * this, struct ZNode55 * Node__1, const char * ErrorMessage__2) {
	(void)ZErrorNode__3qpd(this, Node, ErrorMessage);
	this->ErrorNode = Node;
	return NULL;
}
static struct ZTypeNode236 * ZTypeNode__4qul(struct ZTypeNode236 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * SourceToken__2, struct ZType65 * ParsedType__3) {
	(void)ZConstNode__3qp0(this, ParentNode, SourceToken);
	this->Type = ParsedType;
	return NULL;
}
static struct ZGenerator58 * ZGenerator__3qw1(struct ZGenerator58 * this, const char * LanguageExtension__1, const char * TargetVersion__2) {
	/*untyped*/NULL;
	this->RootNameSpace = ZNameSpace__3qws(_NewZNameSpace49(), this, NULL);
	this->GrammarInfo = "";
	this->LanguageExtention = LanguageExtension;
	this->TargetVersion = TargetVersion;
	this->OutputFile = NULL;
	this->Logger = _NewZLogger136();
	this->StoppedVisitor = 0/*false*/;
	return NULL;
}
static void ImportLocalGrammar__2qw1(struct ZGenerator58 * this, struct ZNameSpace49 * NameSpace__1) {
	return;
}
static void WriteTo__2qw1(struct ZGenerator58 * this, const char * FileName__1) {
	return;
}
static const char * NameOutputFile__2qw1(struct ZGenerator58 * this, const char * FileName__1) {
	if (FileName != NULL) {
		return LibZen_StrCat(LibZen_StrCat(FileName, "."), this->LanguageExtention);
	};
	return FileName;
}
static void EnableVisitor__1qw1(struct ZGenerator58 * this) {
	this->StoppedVisitor = 0/*false*/;
	return;
}
static void StopVisitor__1qw1(struct ZGenerator58 * this) {
	this->StoppedVisitor = 1/*true*/;
	return;
}
static int IsVisitable__1qw1(struct ZGenerator58 * this) {
	return !this->StoppedVisitor;
}
static const char * GetGrammarInfo__1qw1(struct ZGenerator58 * this) {
	return /*untyped*/NULL;
}
static void AppendGrammarInfo__2qw1(struct ZGenerator58 * this, const char * GrammarInfo__1) {
	this->GrammarInfo = LibZen_StrCat(LibZen_StrCat(this->GrammarInfo, GrammarInfo), " ");
	return;
}
static const char * GetTargetLangInfo__1qw1(struct ZGenerator58 * this) {
	return LibZen_StrCat(this->LanguageExtention, this->TargetVersion);
}
static struct ZType65 * GetFieldType__3qw1(struct ZGenerator58 * this, struct ZType65 * BaseType__1, const char * Name__2) {
	return ZTypeVarType_Z3;
}
static struct ZType65 * GetSetterType__3qw1(struct ZGenerator58 * this, struct ZType65 * BaseType__1, const char * Name__2) {
	return ZTypeVarType_Z3;
}
static struct ZFuncType91 * GetConstructorFuncType__3qw1(struct ZGenerator58 * this, struct ZType65 * ClassType__1, struct ZListNode252 * List__2) {
	return ZTypeFuncType_Z12;
}
static struct ZFuncType91 * GetMethodFuncType__4qw1(struct ZGenerator58 * this, struct ZType65 * RecvType__1, const char * MethodName__2, struct ZListNode252 * List__3) {
	return ZTypeFuncType_Z12;
}
static long GetUniqueNumber__1qw1(struct ZGenerator58 * this) {
	long UniqueNumber = this->UniqueNumber;
	this->UniqueNumber = this->UniqueNumber + 1;
	return UniqueNumber;
}
static const char * NameGlobalSymbol__2qw1(struct ZGenerator58 * this, const char * Symbol__1) {
	return LibZen_StrCat(LibZen_StrCat(Symbol, "_Z"), LibZen_IntToString(GetUniqueNumber__1qw1(this)));
}
static const char * NameClass__2qw1(struct ZGenerator58 * this, struct ZType65 * ClassType__1) {
	return LibZen_StrCat(LibZen_StrCat(ClassType->ShortName, ""), LibZen_IntToString(ClassType->TypeId));
}
static void SetDefinedFunc__2qw1(struct ZGenerator58 * this, struct ZFunc90 * Func__1) {
	Map<ZFunc>SetIndex(GetSignature__1qej(Func), Func);
	return;
}
static struct ZPrototype122 * SetPrototype__4qw1(struct ZGenerator58 * this, struct ZNode55 * Node__1, const char * FuncName__2, struct ZFuncType91 * FuncType__3) {
	struct ZFunc90 * Func = GetDefinedFunc__3qw1(this, FuncName, FuncType);
	if (Func != NULL) {
		if (!Equals__2qwn(FuncType, GetFuncType__1qej(Func))) {
			(void)ZLogger_LogError__2qeu(Node->SourceToken, LibZen_StrCat("function has been defined diffrently: ", ThrowError("type error: requested = String, given = ZFuncType")));
			return NULL;
		};
		if (LibZen_Is(Func, 122)) {
			return (struct ZPrototype122 *)Func;
		};
		(void)ZLogger_LogError__2qeu(Node->SourceToken, LibZen_StrCat("function has been defined as macro", ThrowError("type error: requested = String, given = ZFunc")));
		return NULL;
	};
	struct ZPrototype122 * Proto = ZPrototype__5qrd(_NewZPrototype122(), 0, FuncName, FuncType, Node->SourceToken);
	Map<ZFunc>SetIndex(GetSignature__1qej(Proto), Proto);
	return Proto;
}
static struct ZFunc90 * GetDefinedFunc__2qw1(struct ZGenerator58 * this, const char * GlobalName__1) {
	struct ZFunc90 * Func = Map<ZFunc>GetIndex(GlobalName);
	if (Func == NULL && LibZen_IsLetter__1qqy(LibZen_GetChar__2qqy(GlobalName, 0))) {
		Func = Map<ZFunc>GetIndex(LibZen_AnotherName__1qqy(GlobalName));
	};
	return Func;
}
static struct ZFunc90 * GetDefinedFunc__3qw1(struct ZGenerator58 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2) {
	return GetDefinedFunc__2qw1(this, StringfySignature__2qek(FuncType, FuncName));
}
static struct ZFunc90 * GetDefinedFunc__4qw1(struct ZGenerator58 * this, const char * FuncName__1, struct ZType65 * RecvType__2, long FuncParamSize__3) {
	return GetDefinedFunc__2qw1(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
}
static struct ZMacroFunc213 * GetMacroFunc__4qw1(struct ZGenerator58 * this, const char * FuncName__1, struct ZType65 * RecvType__2, long FuncParamSize__3) {
	struct ZFunc90 * Func = GetDefinedFunc__2qw1(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
	if (LibZen_Is(Func, 213)) {
		return ((struct ZMacroFunc213 *)Func);
	};
	return NULL;
}
static const char * NameConverterFunc__3qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2) {
	return LibZen_StrCat(LibZen_StrCat(GetUniqueName__1qwn(FromType), "T"), GetUniqueName__1qwn(ToType));
}
static void SetConverterFunc__4qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2, struct ZFunc90 * Func__3) {
	Map<ZFunc>SetIndex(NameConverterFunc__3qw1(this, FromType, ToType), Func);
	return;
}
static struct ZFunc90 * GetConverterFunc__3qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2) {
	while (FromType != NULL) {
		struct ZFunc90 * Func = Map<ZFunc>GetIndex(NameConverterFunc__3qw1(this, FromType, ToType));
		if (Func != NULL) {
			return Func;
		};
		FromType = /*untyped*/NULL(FromType);
	};
	return NULL;
}
static struct ZFunc90 * GetCoercionFunc__3qw1(struct ZGenerator58 * this, struct ZType65 * FromType__1, struct ZType65 * ToType__2) {
	while (FromType != NULL) {
		struct ZFunc90 * Func = Map<ZFunc>GetIndex(NameConverterFunc__3qw1(this, FromType, ToType));
		if (Func != NULL && IsCoercionFunc__1qej(Func)) {
			return Func;
		};
		FromType = /*untyped*/NULL(FromType);
	};
	return NULL;
}
static void VisitExtendedNode__2qw1(struct ZGenerator58 * this, struct ZNode55 * Node__1) {
	struct ZSugarNode167 * DeNode = /*untyped*/NULL(Node, this);
	/*untyped*/NULL(DeNode, this);
	return;
}
static void VisitSugarNode__2qw1(struct ZGenerator58 * this, struct ZSugarNode167 * Node__1) {
	/*untyped*/NULL(Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z31), this);
	return;
}
static struct ZIndentToken462 * ZIndentToken__4qam(struct ZIndentToken462 * this, struct ZSource239 * Source__1, long StartIndex__2, long EndIndex__3) {
	(void)ZToken__4qeu(this, Source, StartIndex, EndIndex);
	return NULL;
}
static struct ZPatternToken464 * ZPatternToken__5qa5(struct ZPatternToken464 * this, struct ZSource239 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax221 * PresetPattern__4) {
	(void)ZToken__4qeu(this, Source, StartIndex, EndIndex);
	this->PresetPattern = PresetPattern;
	return NULL;
}
static struct ZSourceEngine60 * ZSourceEngine__3qwz(struct ZSourceEngine60 * this, struct ZTypeChecker143 * TypeChecker__1, struct ZGenerator58 * Generator__2) {
	this->TypeChecker = TypeChecker;
	this->Generator = Generator;
	this->Logger = Generator->Logger;
	return NULL;
}
static int IsVisitable__1qwz(struct ZSourceEngine60 * this) {
	return ThrowError("type error: requested = boolean, given = Func<boolean,ZVisitor>");
}
static void EnableVisitor__1qwz(struct ZSourceEngine60 * this) {
	this->IsVisitable = ThrowError("type error: requested = Func<boolean,ZVisitor>, given = boolean");
	return;
}
static void StopVisitor__1qwz(struct ZSourceEngine60 * this) {
	this->IsVisitable = ThrowError("type error: requested = Func<boolean,ZVisitor>, given = boolean");
	return;
}
static struct Object305 * Eval__2qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1) {
	if (/*untyped*/NULL(this)) {
		/*untyped*/NULL(Node, this);
	};
	return ThrowError("type error: requested = Object, given = ZEmptyValue");
}
static void VisitPrototypeNode__2qwz(struct ZSourceEngine60 * this, struct ZPrototypeNode427 * Node__1) {
	struct ZFuncType91 * FuncType = GetFuncType__1q47(Node);
	(void)SetPrototype__4qw1(this->Generator, Node, Node->FuncName, FuncType);
	return;
}
static void VisitImportNode__2qwz(struct ZSourceEngine60 * this, struct ZImportNode372 * Node__1) {
	(void)/*untyped*/NULL(Node);
	return;
}
static struct Object305 * Exec__3qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1, int IsInteractive__2) {
	this->InteractiveContext = IsInteractive;
	/*untyped*/NULL(this);
	if (LibZen_Is(Node, 427)) {
		VisitPrototypeNode__2qwz(this, (struct ZPrototypeNode427 *)Node);
		return ThrowError("type error: requested = Object, given = ZEmptyValue");
	} else if (LibZen_Is(Node, 372)) {
		VisitImportNode__2qwz(this, (struct ZImportNode372 *)Node);
		return ThrowError("type error: requested = Object, given = ZEmptyValue");
	} else {
		Node = CheckType__3qr8(this->TypeChecker, Node, ZTypeVoidType_Z4);
		struct Object305 * ResultValue = Eval__2qwz(this, Node);
		return ResultValue;
	};
}
static struct Object305 * Eval__6qwz(struct ZSourceEngine60 * this, struct ZNameSpace49 * NameSpace__1, const char * ScriptText__2, const char * FileName__3, long LineNumber__4, int IsInteractive__5) {
	struct Object305 * ResultValue = ThrowError("type error: requested = Object, given = ZEmptyValue");
	struct ZBlockNode163 * TopBlockNode = ZBlockNode__2qtk(_NewZBlockNode163(), NameSpace);
	struct ZTokenContext56 * TokenContext = ZTokenContext__6qwl(_NewZTokenContext56(), this->Generator, NameSpace, FileName, LineNumber, ScriptText);
	SkipEmptyStatement__1qwl(TokenContext);
	struct ZToken78 * SkipToken = GetToken__1qwl(TokenContext);
	while (HasNext__1qwl(TokenContext)) {
		(void)SetParseFlag__2qwl(TokenContext, ZTokenContext_NotAllowSkipIndent_Z55);
		ClearListAfter__2qiq(TopBlockNode, 0);
		SkipToken = GetToken__1qwl(TokenContext);
		struct ZNode55 * ParsedNode = ParsePattern__4qwl(TokenContext, TopBlockNode, "$Statement$", ZTokenContext_Required_Z52);
		if (IsErrorNode__1qwk(ParsedNode)) {
			SkipError__2qwl(TokenContext, SkipToken);
		};
		ResultValue = Exec__3qwz(this, ParsedNode, IsInteractive);
		if (ResultValue == ThrowError("type error: requested = Object, given = ZEmptyValue")) {
			break;
		};
		SkipEmptyStatement__1qwl(TokenContext);
		Vacume__1qwl(TokenContext);
	};
	if (HasNext__1qwl(TokenContext) && !IsInteractive) {
		ZLogger_LogInfo__2qeu(SkipToken, "stopped script at this line");
	};
	return ResultValue;
}
static struct Object305 * Eval__5qwz(struct ZSourceEngine60 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3, int IsInteractive__4) {
	return Eval__6qwz(this, this->Generator->RootNameSpace, ScriptText, FileName, LineNumber, IsInteractive);
}
static int Load__2qwz(struct ZSourceEngine60 * this, const char * FileName__1) {
	const char * ScriptText = /*untyped*/NULL;
	if (ScriptText == NULL) {
		LibZen_Exit__2qqr(1, LibZen_StrCat("file not found: ", FileName));
		return 0/*false*/;
	};
	struct Object305 * ResultValue = Eval__5qwz(this, ScriptText, FileName, 1, 0/*false*/);
	ShowErrors__1qrb(this->Logger);
	if (ResultValue == ThrowError("type error: requested = Object, given = ZEmptyValue")) {
		return 0/*false*/;
	};
	return 1/*true*/;
}
static void Unsupported__2qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1) {
	if (this->InteractiveContext) {
		(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	} else {
		(void)ZLogger_LogError__2qeu(Node->SourceToken, "unsupported at top level");
		this->StopVisitor(this);
	};
	return;
}
static void VisitNullNode__2qwz(struct ZSourceEngine60 * this, struct ZNullNode421 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitBooleanNode__2qwz(struct ZSourceEngine60 * this, struct ZBooleanNode478 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitIntNode__2qwz(struct ZSourceEngine60 * this, struct ZIntNode379 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitFloatNode__2qwz(struct ZSourceEngine60 * this, struct ZFloatNode346 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitStringNode__2qwz(struct ZSourceEngine60 * this, struct ZStringNode433 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitArrayLiteralNode__2qwz(struct ZSourceEngine60 * this, struct ZArrayLiteralNode483 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitMapLiteralNode__2qwz(struct ZSourceEngine60 * this, struct ZMapLiteralNode401 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitNewObjectNode__2qwz(struct ZSourceEngine60 * this, struct ZNewObjectNode414 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitGlobalNameNode__2qwz(struct ZSourceEngine60 * this, struct ZGlobalNameNode362 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitGetNameNode__2qwz(struct ZSourceEngine60 * this, struct ZGetNameNode352 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitSetNameNode__2qwz(struct ZSourceEngine60 * this, struct ZSetNameNode183 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitGroupNode__2qwz(struct ZSourceEngine60 * this, struct ZGroupNode366 * Node__1) {
	(void)Eval__2qwz(this, Array<ZNode>GetIndex(ZGroupNode_Expr_Z67));
	return;
}
static void VisitGetterNode__2qwz(struct ZSourceEngine60 * this, struct ZGetterNode357 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitSetterNode__2qwz(struct ZSourceEngine60 * this, struct ZSetterNode186 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitGetIndexNode__2qwz(struct ZSourceEngine60 * this, struct ZGetIndexNode349 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitSetIndexNode__2qwz(struct ZSourceEngine60 * this, struct ZSetIndexNode180 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitMacroNode__2qwz(struct ZSourceEngine60 * this, struct ZMacroNode394 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitFuncCallNode__2qwz(struct ZSourceEngine60 * this, struct ZFuncCallNode409 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitMethodCallNode__2qwz(struct ZSourceEngine60 * this, struct ZMethodCallNode405 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitUnaryNode__2qwz(struct ZSourceEngine60 * this, struct ZUnaryNode199 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitNotNode__2qwz(struct ZSourceEngine60 * this, struct ZNotNode418 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitCastNode__2qwz(struct ZSourceEngine60 * this, struct ZCastNode323 * Node__1) {
	if (IsVoidType__1qwn(Node->Type)) {
		(void)Eval__2qwz(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
		Node->Type = Array<ZNode>GetIndex(ZCastNode_Expr_Z61)->Type;
	} else {
		Unsupported__2qwz(this, Node);
	};
	return;
}
static void VisitInstanceOfNode__2qwz(struct ZSourceEngine60 * this, struct ZInstanceOfNode375 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitBinaryNode__2qwz(struct ZSourceEngine60 * this, struct ZBinaryNode313 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitComparatorNode__2qwz(struct ZSourceEngine60 * this, struct ZComparatorNode331 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitAndNode__2qwz(struct ZSourceEngine60 * this, struct ZAndNode504 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitOrNode__2qwz(struct ZSourceEngine60 * this, struct ZOrNode424 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitBlockNode__2qwz(struct ZSourceEngine60 * this, struct ZBlockNode163 * Node__1) {
	long i = 1;
	while (i < GetListSize__1qiq(Node) && /*untyped*/NULL(this)) {
		struct ZNode55 * StmtNode = GetListAt__2qiq(Node, i);
		(void)Eval__2qwz(this, StmtNode);
		if (/*untyped*/NULL(StmtNode)) {
			break;
		};
	};
	return;
}
static void VisitVarNode__2qwz(struct ZSourceEngine60 * this, struct ZVarNode508 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitIfNode__2qwz(struct ZSourceEngine60 * this, struct ZIfNode369 * Node__1) {
	struct Object305 * BooleanValue = Eval__2qwz(this, Array<ZNode>GetIndex(ZIfNode_Cond_Z68));
	if (LibZen_Is(BooleanValue, 743)) {
		if (ThrowError("type error: requested = boolean, given = Boolean")) {
			(void)Eval__2qwz(this, Array<ZNode>GetIndex(ZIfNode_Then_Z69));
		} else if (Array<ZNode>GetIndex(ZIfNode_Else_Z70) != NULL) {
			(void)Eval__2qwz(this, Array<ZNode>GetIndex(ZIfNode_Then_Z69));
		};
	};
	return;
}
static void VisitReturnNode__2qwz(struct ZSourceEngine60 * this, struct ZReturnNode172 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitWhileNode__2qwz(struct ZSourceEngine60 * this, struct ZWhileNode202 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitBreakNode__2qwz(struct ZSourceEngine60 * this, struct ZBreakNode320 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitThrowNode__2qwz(struct ZSourceEngine60 * this, struct ZThrowNode193 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitTryNode__2qwz(struct ZSourceEngine60 * this, struct ZTryNode196 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitLetNode__2qwz(struct ZSourceEngine60 * this, struct ZLetNode382 * Node__1) {
	if (HasUntypedNode__1qwk(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", ThrowError("type error: requested = String, given = boolean")), "\n"), ThrowError("type error: requested = String, given = ZLetNode")));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitFunctionNode__2qwz(struct ZSourceEngine60 * this, struct ZFunctionNode146 * Node__1) {
	if (HasUntypedNode__1qwk(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", ThrowError("type error: requested = String, given = boolean")), "\nLAZY: "), ThrowError("type error: requested = String, given = ZFunctionNode")));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitClassNode__2qwz(struct ZSourceEngine60 * this, struct ZClassNode518 * Node__1) {
	if (HasUntypedNode__1qwk(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", ThrowError("type error: requested = String, given = boolean")), "\n"), ThrowError("type error: requested = String, given = ZClassNode")));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitErrorNode__2qwz(struct ZSourceEngine60 * this, struct ZErrorNode338 * Node__1) {
	(void)ZLogger_LogError__2qeu(Node->SourceToken, Node->ErrorMessage);
	this->StopVisitor(this);
	return;
}
static void VisitTypeNode__2qwz(struct ZSourceEngine60 * this, struct ZTypeNode236 * Node__1) {
	Unsupported__2qwz(this, Node);
	return;
}
static void VisitExtendedNode__2qwz(struct ZSourceEngine60 * this, struct ZNode55 * Node__1) {
	if (LibZen_Is(Node, 236)) {
		VisitTypeNode__2qwz(this, (struct ZTypeNode236 *)Node);
	} else {
		struct ZNode55 * SugarNode = /*untyped*/NULL(Node, this->Generator);
		/*untyped*/NULL(SugarNode, this);
	};
	return;
}
static void VisitSugarNode__2qwz(struct ZSourceEngine60 * this, struct ZSugarNode167 * Node__1) {
	(void)Eval__2qwz(this, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z31));
	return;
}
static void WriteTo__2qwz(struct ZSourceEngine60 * this, const char * OutputFile__1) {
	/*untyped*/NULL(this->Generator, OutputFile);
	ShowErrors__1qrb(this->Generator->Logger);
	return;
}
static struct ZSourceGenerator244 * ZSourceGenerator__3qub(struct ZSourceGenerator244 * this, const char * TargetCode__1, const char * TargetVersion__2) {
	(void)ZGenerator__3qw1(this, TargetCode, TargetVersion);
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
static void InitBuilderList__1qub(struct ZSourceGenerator244 * this) {
	this->CurrentBuilder = NULL;
	LibZen_ArrayClear((ArrayOfVar *)this->BuilderList);
	this->HeaderBuilder = AppendNewSourceBuilder__1qub(this);
	this->CurrentBuilder = AppendNewSourceBuilder__1qub(this);
	return;
}
static struct ZSourceEngine60 * GetEngine__1qub(struct ZSourceGenerator244 * this) {
	/*untyped*/NULL;
	return ZSourceEngine__3qwz(_NewZSourceEngine60(), ZTypeChecker__2qr8(_NewZTypeChecker143(), this), this);
}
static struct ZSourceBuilder43 * AppendNewSourceBuilder__1qub(struct ZSourceGenerator244 * this) {
	struct ZSourceBuilder43 * Builder = ZSourceBuilder__3qwi(_NewZSourceBuilder43(), this, this->CurrentBuilder);
	LibZen_ArrayAdd((ArrayOfVar *)this->BuilderList, (var)Builder);
	return Builder;
}
static struct ZSourceBuilder43 * InsertNewSourceBuilder__1qub(struct ZSourceGenerator244 * this) {
	struct ZSourceBuilder43 * Builder = ZSourceBuilder__3qwi(_NewZSourceBuilder43(), this, this->CurrentBuilder);
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
static void SetNativeType__3qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1, const char * TypeName__2) {
	const char * Key = LibZen_StrCat("", LibZen_IntToString(Type->TypeId));
	Map<String>SetIndex(Key, TypeName);
	return;
}
static const char * GetNativeType__2qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1) {
	const char * Key = LibZen_StrCat("", LibZen_IntToString(Type->TypeId));
	const char * TypeName = Map<String>GetIndex(Key);
	if (TypeName == NULL) {
		return Type->ShortName;
	};
	return TypeName;
}
static void SetReservedName__3qub(struct ZSourceGenerator244 * this, const char * Keyword__1, const char * AnotherName__2) {
	if (AnotherName == NULL) {
		AnotherName = LibZen_StrCat("_", Keyword);
	};
	Map<String>SetIndex(Keyword, AnotherName);
	return;
}
static const char * SafeName__3qub(struct ZSourceGenerator244 * this, const char * Name__1, long Index__2) {
	if (Index == 0) {
		const char * SafeName = Map<String>GetIndex(Name);
		if (SafeName == NULL) {
			SafeName = Name;
		};
		return SafeName;
	};
	return LibZen_StrCat(LibZen_StrCat(Name, "__"), LibZen_IntToString(Index));
}
static void SetMacro__4qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3) {
	struct ZFuncType91 * FuncType = ZTypePool_LookupFuncType__1qwn(ReturnType);
	SetDefinedFunc__2qw1(this, ZSourceMacro__4qid(_NewZSourceMacro266(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__5qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3, struct ZType65 * P1__4) {
	struct ZFuncType91 * FuncType = ZTypePool_LookupFuncType__2qwn(ReturnType, P1);
	SetDefinedFunc__2qw1(this, ZSourceMacro__4qid(_NewZSourceMacro266(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__6qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3, struct ZType65 * P1__4, struct ZType65 * P2__5) {
	struct ZFuncType91 * FuncType = ZTypePool_LookupFuncType__3qwn(ReturnType, P1, P2);
	SetDefinedFunc__2qw1(this, ZSourceMacro__4qid(_NewZSourceMacro266(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__7qub(struct ZSourceGenerator244 * this, const char * FuncName__1, const char * Macro__2, struct ZType65 * ReturnType__3, struct ZType65 * P1__4, struct ZType65 * P2__5, struct ZType65 * P3__6) {
	struct ZFuncType91 * FuncType = ZTypePool_LookupFuncType__4qwn(ReturnType, P1, P2, P3);
	SetDefinedFunc__2qw1(this, ZSourceMacro__4qid(_NewZSourceMacro266(), FuncName, FuncType, Macro));
	return;
}
static void SetConverterMacro__4qub(struct ZSourceGenerator244 * this, const char * Macro__1, struct ZType65 * ReturnType__2, struct ZType65 * P1__3) {
	struct ZFuncType91 * FuncType = ZTypePool_LookupFuncType__2qwn(ReturnType, P1);
	SetConverterFunc__4qw1(this, P1, ReturnType, ZSourceMacro__4qid(_NewZSourceMacro266(), LibZen_StrCat("to", NameClass__2qw1(this, ReturnType)), FuncType, Macro));
	return;
}
static void WriteTo__2qub(struct ZSourceGenerator244 * this, const char * FileName__1) {
	LibZen_WriteTo__2qqy(this->NameOutputFile(this, FileName), this->BuilderList);
	this->InitBuilderList(this);
	return;
}
static int StartCodeGeneration__3qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1, int IsInteractive__2) {
	Node->Accept(Node, this);
	if (IsInteractive) {
		long i = 0;
		/*untyped*/NULL;
		while (i < LibZen_ArraySize((ArrayOfVar *)this->BuilderList)) {
			struct ZSourceBuilder43 * Builder = Array<ZSourceBuilder>GetIndex(i);
			/*untyped*/NULL;
			Clear__1qwi(Builder);
			i = i + 1;
		};
		this->InitBuilderList(this);
	};
	return 1/*true*/;
}
static void GenerateCode__3qub(struct ZSourceGenerator244 * this, struct ZType65 * ContextType__1, struct ZNode55 * Node__2) {
	/*untyped*/NULL(Node, this);
	return;
}
static int IsNeededSurroud__2qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1) {
	if (LibZen_Is(Node, 313)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void GenerateSurroundCode__2qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1) {
	if (IsNeededSurroud__2qub(this, Node)) {
		Append__2qwi(this->CurrentBuilder, "(");
		/*untyped*/NULL(this, NULL, Node);
		Append__2qwi(this->CurrentBuilder, ")");
	} else {
		/*untyped*/NULL(this, NULL, Node);
	};
	return;
}
static void AppendCode__2qub(struct ZSourceGenerator244 * this, const char * RawSource__1) {
	Append__2qwi(this->CurrentBuilder, RawSource);
	return;
}
static void VisitStmtList__2qub(struct ZSourceGenerator244 * this, struct ZBlockNode163 * BlockNode__1) {
	long i = 0;
	while (i < GetListSize__1qiq(BlockNode)) {
		struct ZNode55 * SubNode = GetListAt__2qiq(BlockNode, i);
		AppendLineFeed__1qwi(this->CurrentBuilder);
		AppendIndent__1qwi(this->CurrentBuilder);
		/*untyped*/NULL(this, NULL, SubNode);
		i = i + 1;
		if (i < GetListSize__1qiq(BlockNode)) {
			Append__2qwi(this->CurrentBuilder, this->SemiColon);
		};
	};
	return;
}
static void VisitBlockNode__2qub(struct ZSourceGenerator244 * this, struct ZBlockNode163 * Node__1) {
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, "{");
	Indent__1qwi(this->CurrentBuilder);
	VisitStmtList__2qub(this, Node);
	if (GetListSize__1qiq(Node) > 0) {
		Append__2qwi(this->CurrentBuilder, this->SemiColon);
	};
	UnIndent__1qwi(this->CurrentBuilder);
	AppendLineFeed__1qwi(this->CurrentBuilder);
	AppendIndent__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, "}");
	return;
}
static void VisitNullNode__2qub(struct ZSourceGenerator244 * this, struct ZNullNode421 * Node__1) {
	Append__2qwi(this->CurrentBuilder, this->NullLiteral);
	return;
}
static void VisitBooleanNode__2qub(struct ZSourceGenerator244 * this, struct ZBooleanNode478 * Node__1) {
	if (Node->BooleanValue) {
		Append__2qwi(this->CurrentBuilder, this->TrueLiteral);
	} else {
		Append__2qwi(this->CurrentBuilder, this->FalseLiteral);
	};
	return;
}
static void VisitIntNode__2qub(struct ZSourceGenerator244 * this, struct ZIntNode379 * Node__1) {
	Append__2qwi(this->CurrentBuilder, /*untyped*/NULL);
	return;
}
static void VisitFloatNode__2qub(struct ZSourceGenerator244 * this, struct ZFloatNode346 * Node__1) {
	Append__2qwi(this->CurrentBuilder, /*untyped*/NULL);
	return;
}
static void VisitStringNode__2qub(struct ZSourceGenerator244 * this, struct ZStringNode433 * Node__1) {
	Append__2qwi(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->StringValue));
	return;
}
static void VisitArrayLiteralNode__2qub(struct ZSourceGenerator244 * this, struct ZArrayLiteralNode483 * Node__1) {
	VisitListNode__4qub(this, "[", Node, "]");
	return;
}
static void VisitMapLiteralNode__2qub(struct ZSourceGenerator244 * this, struct ZMapLiteralNode401 * Node__1) {
	return;
}
static void VisitNewObjectNode__2qub(struct ZSourceGenerator244 * this, struct ZNewObjectNode414 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "new");
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	GenerateTypeName__2qub(this, Node->Type);
	VisitListNode__4qub(this, "(", Node, ")");
	return;
}
static void VisitGroupNode__2qub(struct ZSourceGenerator244 * this, struct ZGroupNode366 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGroupNode_Expr_Z67));
	Append__2qwi(this->CurrentBuilder, ")");
	return;
}
static void VisitGetIndexNode__2qub(struct ZSourceGenerator244 * this, struct ZGetIndexNode349 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Recv_Z64));
	Append__2qwi(this->CurrentBuilder, "[");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Index_Z65));
	Append__2qwi(this->CurrentBuilder, "]");
	return;
}
static void VisitSetIndexNode__2qub(struct ZSourceGenerator244 * this, struct ZSetIndexNode180 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Recv_Z25));
	Append__2qwi(this->CurrentBuilder, "[");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Index_Z26));
	Append__2qwi(this->CurrentBuilder, "]");
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Expr_Z27));
	return;
}
static void VisitGlobalNameNode__2qub(struct ZSourceGenerator244 * this, struct ZGlobalNameNode362 * Node__1) {
	if (IsUntyped__1qwk(Node)) {
		(void)ZLogger_LogError__2qeu(Node->SourceToken, LibZen_StrCat("undefined symbol: ", Node->GlobalName));
	};
	if (Node->IsStaticFuncName) {
		Append__2qwi(this->CurrentBuilder, StringfySignature__2qwn(Node->Type, Node->GlobalName));
	} else {
		Append__2qwi(this->CurrentBuilder, Node->GlobalName);
	};
	return;
}
static void VisitGetNameNode__2qub(struct ZSourceGenerator244 * this, struct ZGetNameNode352 * Node__1) {
	Append__2qwi(this->CurrentBuilder, SafeName__3qub(this, Node->VarName, Node->VarIndex));
	return;
}
static void VisitSetNameNode__2qub(struct ZSourceGenerator244 * this, struct ZSetNameNode183 * Node__1) {
	Append__2qwi(this->CurrentBuilder, SafeName__3qub(this, Node->VarName, Node->VarIndex));
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetNameNode_Expr_Z28));
	return;
}
static void VisitGetterNode__2qub(struct ZSourceGenerator244 * this, struct ZGetterNode357 * Node__1) {
	GenerateSurroundCode__2qub(this, Array<ZNode>GetIndex(ZGetterNode_Recv_Z66));
	Append__2qwi(this->CurrentBuilder, ".");
	Append__2qwi(this->CurrentBuilder, Node->FieldName);
	return;
}
static void VisitSetterNode__2qub(struct ZSourceGenerator244 * this, struct ZSetterNode186 * Node__1) {
	GenerateSurroundCode__2qub(this, Array<ZNode>GetIndex(ZSetterNode_Recv_Z29));
	Append__2qwi(this->CurrentBuilder, ".");
	Append__2qwi(this->CurrentBuilder, Node->FieldName);
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetterNode_Expr_Z30));
	return;
}
static void VisitMethodCallNode__2qub(struct ZSourceGenerator244 * this, struct ZMethodCallNode405 * Node__1) {
	GenerateSurroundCode__2qub(this, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
	Append__2qwi(this->CurrentBuilder, ".");
	Append__2qwi(this->CurrentBuilder, Node->MethodName);
	VisitListNode__4qub(this, "(", Node, ")");
	return;
}
static void VisitMacroNode__2qub(struct ZSourceGenerator244 * this, struct ZMacroNode394 * Node__1) {
	const char * Macro = GetMacroText__1q02(Node);
	struct ZFuncType91 * FuncType = GetFuncType__1q02(Node);
	long fromIndex = 0;
	long BeginNum = LibZen_IndexOf2(Macro, "$[", fromIndex);
	while (BeginNum != -1) {
		long EndNum = LibZen_IndexOf2(Macro, "]", BeginNum + 2);
		if (EndNum == -1) {
			break;
		};
		Append__2qwi(this->CurrentBuilder, LibZen_SubString2(Macro, fromIndex));
		long Index = (long)LibZen_ParseInt__1qqy(LibZen_SubString2(Macro, BeginNum + 2));
		if (HasAst__2qwk(Node, Index)) {
			this->GenerateCode(this, GetFuncParamType__2qek(FuncType, Index), Array<ZNode>GetIndex(Index));
		};
		fromIndex = EndNum + 1;
		BeginNum = LibZen_IndexOf2(Macro, "$[", fromIndex);
	};
	Append__2qwi(this->CurrentBuilder, LibZen_SubString(Macro, fromIndex));
	return;
}
static void VisitFuncCallNode__2qub(struct ZSourceGenerator244 * this, struct ZFuncCallNode409 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78));
	VisitListNode__4qub(this, "(", Node, ")");
	return;
}
static void VisitUnaryNode__2qub(struct ZSourceGenerator244 * this, struct ZUnaryNode199 * Node__1) {
	Append__2qwi(this->CurrentBuilder, GetText__1qeu(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z36));
	return;
}
static void VisitNotNode__2qub(struct ZSourceGenerator244 * this, struct ZNotNode418 * Node__1) {
	Append__2qwi(this->CurrentBuilder, this->NotOperator);
	GenerateSurroundCode__2qub(this, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z36));
	return;
}
static void VisitCastNode__2qub(struct ZSourceGenerator244 * this, struct ZCastNode323 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "(");
	GenerateTypeName__2qub(this, Node->Type);
	Append__2qwi(this->CurrentBuilder, ")");
	GenerateSurroundCode__2qub(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
	return;
}
static void VisitInstanceOfNode__2qub(struct ZSourceGenerator244 * this, struct ZInstanceOfNode375 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qwi(this->CurrentBuilder, "instanceof");
	GenerateTypeName__2qub(this, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60)->Type);
	return;
}
static void VisitBinaryNode__2qub(struct ZSourceGenerator244 * this, struct ZBinaryNode313 * Node__1) {
	if (LibZen_Is(Node->ParentNode, 313)) {
		Append__2qwi(this->CurrentBuilder, "(");
	};
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qwi(this->CurrentBuilder, GetText__1qeu(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	if (LibZen_Is(Node->ParentNode, 313)) {
		Append__2qwi(this->CurrentBuilder, ")");
	};
	return;
}
static void VisitComparatorNode__2qub(struct ZSourceGenerator244 * this, struct ZComparatorNode331 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qwi(this->CurrentBuilder, GetText__1qeu(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	return;
}
static void VisitAndNode__2qub(struct ZSourceGenerator244 * this, struct ZAndNode504 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qwi(this->CurrentBuilder, this->AndOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	return;
}
static void VisitOrNode__2qub(struct ZSourceGenerator244 * this, struct ZOrNode424 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qwi(this->CurrentBuilder, this->OrOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	return;
}
static void VisitIfNode__2qub(struct ZSourceGenerator244 * this, struct ZIfNode369 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "if (");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Cond_Z68));
	Append__2qwi(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Then_Z69));
	if (Array<ZNode>GetIndex(ZIfNode_Else_Z70) != NULL) {
		AppendToken__2qwi(this->CurrentBuilder, "else");
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Else_Z70));
	};
	return;
}
static void VisitReturnNode__2qub(struct ZSourceGenerator244 * this, struct ZReturnNode172 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "return");
	if (Array<ZNode>GetIndex(ZReturnNode_Expr_Z24) != NULL) {
		AppendWhiteSpace__1qwi(this->CurrentBuilder);
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZReturnNode_Expr_Z24));
	};
	return;
}
static void VisitWhileNode__2qub(struct ZSourceGenerator244 * this, struct ZWhileNode202 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "while (");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZWhileNode_Cond_Z37));
	Append__2qwi(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZWhileNode_Block_Z38));
	return;
}
static void VisitBreakNode__2qub(struct ZSourceGenerator244 * this, struct ZBreakNode320 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "break");
	return;
}
static void VisitThrowNode__2qub(struct ZSourceGenerator244 * this, struct ZThrowNode193 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "throw");
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZThrowNode_Expr_Z32));
	return;
}
static void VisitTryNode__2qub(struct ZSourceGenerator244 * this, struct ZTryNode196 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "try");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Try_Z33));
	if (Array<ZNode>GetIndex(ZTryNode_Catch_Z34) != NULL) {
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Catch_Z34));
	};
	if (Array<ZNode>GetIndex(ZTryNode_Finally_Z35) != NULL) {
		Append__2qwi(this->CurrentBuilder, "finally");
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Finally_Z35));
	};
	return;
}
static void VisitCatchNode__2qub(struct ZSourceGenerator244 * this, struct ZCatchNode327 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "catch (");
	Append__2qwi(this->CurrentBuilder, Node->ExceptionName);
	VisitTypeAnnotation__2qub(this, Node->ExceptionType);
	Append__2qwi(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZCatchNode_Block_Z62));
	return;
}
static void VisitVarNode__2qub(struct ZSourceGenerator244 * this, struct ZVarNode508 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "var");
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, Node->NativeName);
	VisitTypeAnnotation__2qub(this, Node->DeclType);
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZVarNode_InitValue_Z80));
	Append__2qwi(this->CurrentBuilder, this->SemiColon);
	VisitStmtList__2qub(this, Node);
	return;
}
static void VisitTypeAnnotation__2qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1) {
	Append__2qwi(this->CurrentBuilder, ": ");
	GenerateTypeName__2qub(this, Type);
	return;
}
static void VisitLetNode__2qub(struct ZSourceGenerator244 * this, struct ZLetNode382 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "let");
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, Node->GlobalName);
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZLetNode_InitValue_Z72));
	return;
}
static void VisitParamNode__2qub(struct ZSourceGenerator244 * this, struct ZParamNode174 * Node__1) {
	Append__2qwi(this->CurrentBuilder, SafeName__3qub(this, Node->Name, Node->ParamIndex));
	VisitTypeAnnotation__2qub(this, Node->Type);
	return;
}
static void VisitFunctionNode__2qub(struct ZSourceGenerator244 * this, struct ZFunctionNode146 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "function");
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	if (Node->FuncName != NULL) {
		Append__2qwi(this->CurrentBuilder, Node->FuncName);
	};
	VisitListNode__4qub(this, "(", Node, ")");
	VisitTypeAnnotation__2qub(this, Node->ReturnType);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFunctionNode_Block_Z79));
	return;
}
static void VisitClassNode__2qub(struct ZSourceGenerator244 * this, struct ZClassNode518 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "class");
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, Node->ClassName);
	if (Node->SuperType != NULL) {
		AppendToken__2qwi(this->CurrentBuilder, "extends");
		GenerateTypeName__2qub(this, Node->SuperType);
	};
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, "{");
	Indent__1qwi(this->CurrentBuilder);
	long i = 0;
	while (i < GetListSize__1qiq(Node)) {
		struct ZFieldNode342 * FieldNode = GetFieldNode__2qdd(Node, i);
		AppendLineFeed__1qwi(this->CurrentBuilder);
		AppendIndent__1qwi(this->CurrentBuilder);
		Append__2qwi(this->CurrentBuilder, "var");
		AppendWhiteSpace__1qwi(this->CurrentBuilder);
		Append__2qwi(this->CurrentBuilder, FieldNode->FieldName);
		VisitTypeAnnotation__2qub(this, FieldNode->DeclType);
		if (HasAst__2qwk(FieldNode, ZFieldNode_InitValue_Z63)) {
			AppendToken__2qwi(this->CurrentBuilder, "=");
			/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFieldNode_InitValue_Z63));
		};
		Append__2qwi(this->CurrentBuilder, this->SemiColon);
		i = i + 1;
	};
	UnIndent__1qwi(this->CurrentBuilder);
	AppendLineFeed__1qwi(this->CurrentBuilder);
	AppendIndent__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, "}");
	return;
}
static void VisitErrorNode__2qub(struct ZSourceGenerator244 * this, struct ZErrorNode338 * Node__1) {
	(void)ZLogger_LogError__2qeu(Node->SourceToken, Node->ErrorMessage);
	Append__2qwi(this->CurrentBuilder, "ThrowError(");
	Append__2qwi(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->ErrorMessage));
	Append__2qwi(this->CurrentBuilder, ")");
	return;
}
static void VisitExtendedNode__2qub(struct ZSourceGenerator244 * this, struct ZNode55 * Node__1) {
	if (LibZen_Is(Node, 174)) {
		VisitParamNode__2qub(this, (struct ZParamNode174 *)Node);
	} else {
		struct ZSugarNode167 * SugarNode = /*untyped*/NULL(Node, this);
		/*untyped*/NULL(this, SugarNode);
	};
	return;
}
static void VisitSugarNode__2qub(struct ZSourceGenerator244 * this, struct ZSugarNode167 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z31));
	return;
}
static void GenerateTypeName__2qub(struct ZSourceGenerator244 * this, struct ZType65 * Type__1) {
	Append__2qwi(this->CurrentBuilder, GetNativeType__2qub(this, /*untyped*/NULL(Type)));
	return;
}
static void VisitListNode__5qub(struct ZSourceGenerator244 * this, const char * OpenToken__1, struct ZListNode252 * VargNode__2, const char * DelimToken__3, const char * CloseToken__4) {
	Append__2qwi(this->CurrentBuilder, OpenToken);
	long i = 0;
	while (i < GetListSize__1qiq(VargNode)) {
		struct ZNode55 * ParamNode = GetListAt__2qiq(VargNode, i);
		if (i > 0) {
			Append__2qwi(this->CurrentBuilder, DelimToken);
		};
		/*untyped*/NULL(this, NULL, ParamNode);
		i = i + 1;
	};
	Append__2qwi(this->CurrentBuilder, CloseToken);
	return;
}
static void VisitListNode__4qub(struct ZSourceGenerator244 * this, const char * OpenToken__1, struct ZListNode252 * VargNode__2, const char * CloseToken__3) {
	VisitListNode__5qub(this, OpenToken, VargNode, ", ", CloseToken);
	return;
}
static struct ZTypeChecker143 * ZTypeChecker__2qr8(struct ZTypeChecker143 * this, struct ZGenerator58 * Generator__1) {
	this->Generator = Generator;
	this->Logger = Generator->Logger;
	this->StackedContextType = NULL;
	this->ReturnedNode = NULL;
	this->StoppedVisitor = 0/*false*/;
	this->VarScope = ZVarScope__4qrv(_NewZVarScope135(), NULL, this->Logger, NULL);
	return NULL;
}
static void EnableVisitor__1qr8(struct ZTypeChecker143 * this) {
	this->StoppedVisitor = 0/*false*/;
	return;
}
static void StopVisitor__1qr8(struct ZTypeChecker143 * this) {
	this->StoppedVisitor = 1/*true*/;
	return;
}
static int IsVisitable__1qr8(struct ZTypeChecker143 * this) {
	return !this->StoppedVisitor;
}
static struct ZType65 * GetContextType__1qr8(struct ZTypeChecker143 * this) {
	return this->StackedContextType;
}
static struct ZNode55 * VisitTypeChecker__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2) {
	struct ZNode55 * ParentNode = Node->ParentNode;
	this->StackedContextType = ContextType;
	this->ReturnedNode = NULL;
	Node->Accept(Node, this);
	if (this->ReturnedNode == NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("!! returns no value: ", ThrowError("type error: requested = String, given = ZNode")));
	} else {
		Node = this->ReturnedNode;
	};
	if (ParentNode != Node->ParentNode && ParentNode != NULL) {
		(void)SetChild__2qwk(ParentNode, Node);
	};
	CheckVarNode__3qrv(this->VarScope, ContextType, Node);
	return Node;
}
static struct ZNode55 * CreateStupidCastNode__3qr8(struct ZTypeChecker143 * this, struct ZType65 * Requested__1, struct ZNode55 * Node__2) {
	struct ZNode55 * ErrorNode = ZStupidCastErrorNode__3qat(_NewZStupidCastErrorNode436(), Node, LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("type error: requested = ", ThrowError("type error: requested = String, given = ZType")), ", given = "), ThrowError("type error: requested = String, given = ZType")));
	ErrorNode->Type = Requested;
	return ErrorNode;
}
static struct ZNode55 * EnforceNodeType__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * EnforceType__2) {
	struct ZFunc90 * Func = GetConverterFunc__3qw1(this->Generator, Node->Type, ZTypeStringType_Z8);
	if (LibZen_Is(Func, 213)) {
		struct ZMacroNode394 * MacroNode = ZMacroNode__4q02(_NewZMacroNode394(), Node->ParentNode, NULL, (struct ZMacroFunc213 *)Func);
		Append__2qiq(MacroNode, Node);
		MacroNode->Type = EnforceType;
		return MacroNode;
	} else if (Func != NULL) {
		struct ZFuncCallNode409 * MacroNode = ZFuncCallNode__4q4s(_NewZFuncCallNode409(), Node->ParentNode, Func->FuncName, GetFuncType__1qej(Func));
		Append__2qiq(MacroNode, Node);
		MacroNode->Type = EnforceType;
		return MacroNode;
	};
	return CreateStupidCastNode__3qr8(this, EnforceType, Node);
}
static struct ZNode55 * TypeCheckImpl__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2, long TypeCheckPolicy__3) {
	if (IsErrorNode__1qwk(Node)) {
		if (!ContextType->IsVarType(ContextType)) {
			Node->Type = ContextType;
		};
		return Node;
	};
	if (IsUntyped__1qwk(Node) || ContextType->IsVarType(ContextType) || LibZen_IsFlag__2qqr(TypeCheckPolicy, ZTypeChecker_NoCheckPolicy_Z77)) {
		return Node;
	};
	if (Node->Type == ContextType || Accept__2qwn(ContextType, Node->Type)) {
		return Node;
	};
	if (IsVoidType__1qwn(ContextType) && !IsVoidType__1qwn(Node->Type)) {
		return ZCastNode__4qo8(_NewZCastNode323(), Node->ParentNode, ZTypeVoidType_Z4, Node);
	};
	if (IsFloatType__1qwn(ContextType) && IsIntType__1qwn(Node->Type)) {
		return EnforceNodeType__3qr8(this, Node, ContextType);
	};
	if (IsIntType__1qwn(ContextType) && IsFloatType__1qwn(Node->Type)) {
		return EnforceNodeType__3qr8(this, Node, ContextType);
	};
	return CreateStupidCastNode__3qr8(this, ContextType, Node);
}
static struct ZNode55 * VisitTypeChecker__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2, long TypeCheckPolicy__3) {
	if (/*untyped*/NULL(this) && Node != NULL) {
		if (HasUntypedNode__1qwk(Node)) {
			Node = VisitTypeChecker__3qwk(Node, this, ContextType);
		};
		Node = TypeCheckImpl__4qr8(this, Node, ContextType, TypeCheckPolicy);
		CheckVarNode__3qrv(this->VarScope, ContextType, Node);
	};
	this->ReturnedNode = NULL;
	return Node;
}
static struct ZNode55 * TryType__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2) {
	return VisitTypeChecker__4qr8(this, Node, ContextType, ZTypeChecker_NoCheckPolicy_Z77);
}
static void TryTypeAt__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, long Index__2, struct ZType65 * ContextType__3) {
	Set__3qwk(Node, Index, VisitTypeChecker__4qr8(this, Array<ZNode>GetIndex(Index), ContextType, ZTypeChecker_NoCheckPolicy_Z77));
	return;
}
static struct ZNode55 * CheckType__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * ContextType__2) {
	return VisitTypeChecker__4qr8(this, Node, ContextType, ZTypeChecker_DefaultTypeCheckPolicy_Z76);
}
static void CheckTypeAt__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, long Index__2, struct ZType65 * ContextType__3) {
	Set__3qwk(Node, Index, VisitTypeChecker__4qr8(this, Array<ZNode>GetIndex(Index), ContextType, ZTypeChecker_DefaultTypeCheckPolicy_Z76));
	return;
}
static int TypeCheckNodeList__2qr8(struct ZTypeChecker143 * this, struct ZListNode252 * List__1) {
	if (/*untyped*/NULL(this)) {
		int AllTyped = 1/*true*/;
		long i = 0;
		while (i < GetListSize__1qiq(List)) {
			struct ZNode55 * SubNode = GetListAt__2qiq(List, i);
			SubNode = CheckType__3qr8(this, SubNode, ZTypeVarType_Z3);
			SetListAt__3qiq(List, i, SubNode);
			if (IsUntyped__1qwk(SubNode)) {
				AllTyped = 0/*false*/;
			};
			i = i + 1;
		};
		return AllTyped;
	};
	return 0/*false*/;
}
static void Return__2qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1) {
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", ThrowError("type error: requested = String, given = ZNode")));
	};
	this->ReturnedNode = Node;
	return;
}
static void TypedNode__3qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZType65 * Type__2) {
	Node->Type = Type->GetRealType(Type);
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", ThrowError("type error: requested = String, given = ZNode")));
	};
	this->ReturnedNode = Node;
	return;
}
static void ReturnErrorNode__4qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1, struct ZToken78 * ErrorToken__2, const char * Message__3) {
	if (ErrorToken == NULL) {
		ErrorToken = Node->SourceToken;
	};
	Return__2qr8(this, ZErrorNode__4qpd(_NewZErrorNode338(), Node->ParentNode, ErrorToken, Message));
	return;
}
static void VisitErrorNode__2qr8(struct ZTypeChecker143 * this, struct ZErrorNode338 * Node__1) {
	struct ZType65 * ContextType = GetContextType__1qr8(this);
	if (!/*untyped*/NULL(ContextType)) {
		TypedNode__3qr8(this, Node, ContextType);
	} else {
		Return__2qr8(this, Node);
	};
	return;
}
static void VisitExtendedNode__2qr8(struct ZTypeChecker143 * this, struct ZNode55 * Node__1) {
	struct ZType65 * ContextType = GetContextType__1qr8(this);
	struct ZNode55 * DeNode = /*untyped*/NULL(Node, this->Generator);
	if (!IsErrorNode__1qwk(DeNode)) {
		Return__2qr8(this, CheckType__3qr8(this, DeNode, ContextType));
	} else {
		TypedNode__3qr8(this, DeNode, ContextType);
	};
	return;
}
static void VisitSugarNode__2qr8(struct ZTypeChecker143 * this, struct ZSugarNode167 * Node__1) {
	struct ZType65 * ContextType = GetContextType__1qr8(this);
	CheckTypeAt__4qr8(this, Node, ZSugarNode_DeSugar_Z31, ContextType);
	TypedNode__3qr8(this, Node, GetAstType__2qwk(Node, ZSugarNode_DeSugar_Z31));
	return;
}
static struct CSourceGenerator601 * CSourceGenerator__1qgx(struct CSourceGenerator601 * this) {
	(void)ZSourceGenerator__3qub(this, "c", "C99");
	this->LineFeed = "\n";
	this->Tab = "\t";
	this->Camma = ", ";
	this->SemiColon = ";";
	this->TrueLiteral = "1/*true*/";
	this->FalseLiteral = "0/*false*/";
	this->NullLiteral = "NULL";
	this->TopType = "void *";
	SetNativeType__3qub(this, ZTypeBooleanType_Z5, "int");
	SetNativeType__3qub(this, ZTypeIntType_Z6, "long");
	SetNativeType__3qub(this, ZTypeFloatType_Z7, "double");
	SetNativeType__3qub(this, ZTypeStringType_Z8, "const char *");
	SetMacro__6qub(this, "assert", "LibZen_Assert($[0], $[1])", ZTypeVoidType_Z4, ZTypeBooleanType_Z5, ZTypeStringType_Z8);
	SetMacro__5qub(this, "print", "LibZen_Print($[0])", ZTypeVoidType_Z4, ZTypeStringType_Z8);
	SetMacro__5qub(this, "println", "LibZen_PrintLine($[0])", ZTypeVoidType_Z4, ZTypeStringType_Z8);
	SetConverterMacro__4qub(this, "(double)($[0])", ZTypeFloatType_Z7, ZTypeIntType_Z6);
	SetConverterMacro__4qub(this, "(long)($[0])", ZTypeIntType_Z6, ZTypeFloatType_Z7);
	SetConverterMacro__4qub(this, "LibZen_IntToString($[0])", ZTypeStringType_Z8, ZTypeIntType_Z6);
	SetConverterMacro__4qub(this, "LibZen_FloatToString($[0])", ZTypeStringType_Z8, ZTypeFloatType_Z7);
	SetMacro__6qub(this, "+", "LibZen_StrCat($[0], $[1])", ZTypeStringType_Z8, ZTypeStringType_Z8, ZTypeStringType_Z8);
	SetMacro__5qub(this, "size", "LibZen_StringSize($[0])", ZTypeIntType_Z6, ZTypeStringType_Z8);
	SetMacro__6qub(this, "substring", "LibZen_SubString($[0], $[1])", ZTypeStringType_Z8, ZTypeStringType_Z8, ZTypeIntType_Z6);
	SetMacro__7qub(this, "substring", "LibZen_SubString2($[0], $[1])", ZTypeStringType_Z8, ZTypeStringType_Z8, ZTypeIntType_Z6, ZTypeIntType_Z6);
	SetMacro__6qub(this, "indexOf", "LibZen_IndexOf($[0], $[1])", ZTypeIntType_Z6, ZTypeStringType_Z8, ZTypeStringType_Z8);
	SetMacro__7qub(this, "indexOf", "LibZen_IndexOf2($[0], $[1], $[2])", ZTypeIntType_Z6, ZTypeStringType_Z8, ZTypeStringType_Z8, ZTypeIntType_Z6);
	SetMacro__5qub(this, "size", "LibZen_ArraySize($[0])", ZTypeIntType_Z6, ZTypeArrayType_Z10);
	SetMacro__6qub(this, "clear", "LibZen_ArrayClear($[0])", ZTypeVoidType_Z4, ZTypeArrayType_Z10, ZTypeIntType_Z6);
	SetMacro__6qub(this, "add", "LibZen_ArrayAdd($[0], $[1])", ZTypeVoidType_Z4, ZTypeArrayType_Z10, ZTypeVarType_Z3);
	SetMacro__7qub(this, "add", "LibZen_ArrayAdd2($[0], $[1], $[2])", ZTypeVoidType_Z4, ZTypeArrayType_Z10, ZTypeIntType_Z6, ZTypeVarType_Z3);
	return NULL;
}
static struct ZSourceEngine60 * GetEngine__1qgx(struct CSourceGenerator601 * this) {
	return ZSourceEngine__3qwz(_NewZSourceEngine60(), ZTypeChecker__2qr8(_NewZTypeChecker143(), this), this);
}
static void GenerateCode__3qgx(struct CSourceGenerator601 * this, struct ZType65 * ContextType__1, struct ZNode55 * Node__2) {
	if (IsUntyped__1qwk(Node) && !IsErrorNode__1qwk(Node)) {
		Append__2qwi(this->CurrentBuilder, LibZen_StrCat("/*untyped*/", this->NullLiteral));
		(void)ZLogger_LogError__2qeu(Node->SourceToken, "untyped error");
	} else {
		if (ContextType != NULL && Node->Type != ContextType) {
			Append__2qwi(this->CurrentBuilder, "(");
			GenerateTypeName__2qgx(this, ContextType);
			Append__2qwi(this->CurrentBuilder, ")");
		};
		Node->Accept(Node, this);
	};
	return;
}
static void VisitArrayLiteralNode__2qgx(struct CSourceGenerator601 * this, struct ZArrayLiteralNode483 * Node__1) {
	struct ZType65 * ParamType = Node->Type->GetParamType(Node->Type, 0);
	if (IsIntType__1qwn(ParamType) || IsBooleanType__1qwn(ParamType)) {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewIntArray(");
	} else if (IsFloatType__1qwn(ParamType)) {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewFloatArray(");
	} else if (IsStringType__1qwn(ParamType)) {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewStringArray(");
	} else {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewArray(");
	};
	Append__2qwi(this->CurrentBuilder, /*untyped*/NULL);
	if (GetListSize__1qiq(Node) > 0) {
		Append__2qwi(this->CurrentBuilder, this->Camma);
	};
	VisitListNode__4qub(this, "", Node, ")");
	return;
}
static void VisitMapLiteralNode__2qgx(struct CSourceGenerator601 * this, struct ZMapLiteralNode401 * Node__1) {
	struct ZType65 * ParamType = Node->Type->GetParamType(Node->Type, 0);
	if (IsIntType__1qwn(ParamType) || IsBooleanType__1qwn(ParamType)) {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewIntMap(");
	} else if (IsFloatType__1qwn(ParamType)) {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewFloatMap(");
	} else if (IsStringType__1qwn(ParamType)) {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewStringMap(");
	} else {
		Append__2qwi(this->CurrentBuilder, "LibZen_NewMap(");
	};
	Append__2qwi(this->CurrentBuilder, /*untyped*/NULL);
	if (GetListSize__1qiq(Node) > 0) {
		Append__2qwi(this->CurrentBuilder, this->Camma);
	};
	VisitListNode__4qub(this, "", Node, ")");
	return;
}
static void VisitNewObjectNode__2qgx(struct CSourceGenerator601 * this, struct ZNewObjectNode414 * Node__1) {
	Append__2qwi(this->CurrentBuilder, LibZen_StrCat("_New", NameClass__2qw1(this, Node->Type)));
	VisitListNode__4qub(this, "(", Node, ")");
	return;
}
static const char * BaseName__2qgx(struct CSourceGenerator601 * this, struct ZType65 * RecvType__1) {
	return GetAsciiName__1qwn(RecvType);
}
static void VisitGetIndexNode__2qgx(struct CSourceGenerator601 * this, struct ZGetIndexNode349 * Node__1) {
	Append__2qwi(this->CurrentBuilder, LibZen_StrCat(BaseName__2qgx(this, GetAstType__2qwk(Node, ZGetIndexNode_Recv_Z64)), "GetIndex"));
	Append__2qwi(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Index_Z65));
	Append__2qwi(this->CurrentBuilder, ")");
	return;
}
static void VisitSetIndexNode__2qgx(struct CSourceGenerator601 * this, struct ZSetIndexNode180 * Node__1) {
	Append__2qwi(this->CurrentBuilder, LibZen_StrCat(BaseName__2qgx(this, GetAstType__2qwk(Node, ZGetIndexNode_Recv_Z64)), "SetIndex"));
	Append__2qwi(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Index_Z26));
	Append__2qwi(this->CurrentBuilder, this->Camma);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Expr_Z27));
	Append__2qwi(this->CurrentBuilder, ")");
	return;
}
static void VisitGetNameNode__2qgx(struct CSourceGenerator601 * this, struct ZGetNameNode352 * Node__1) {
	Append__2qwi(this->CurrentBuilder, Node->VarName);
	return;
}
static void VisitSetNameNode__2qgx(struct CSourceGenerator601 * this, struct ZSetNameNode183 * Node__1) {
	Append__2qwi(this->CurrentBuilder, Node->VarName);
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetNameNode_Expr_Z28));
	return;
}
static void VisitGetterNode__2qgx(struct CSourceGenerator601 * this, struct ZGetterNode357 * Node__1) {
	GenerateSurroundCode__2qub(this, Array<ZNode>GetIndex(ZGetterNode_Recv_Z66));
	Append__2qwi(this->CurrentBuilder, "->");
	Append__2qwi(this->CurrentBuilder, Node->FieldName);
	return;
}
static void VisitSetterNode__2qgx(struct CSourceGenerator601 * this, struct ZSetterNode186 * Node__1) {
	GenerateSurroundCode__2qub(this, Array<ZNode>GetIndex(ZSetterNode_Recv_Z29));
	Append__2qwi(this->CurrentBuilder, "->");
	Append__2qwi(this->CurrentBuilder, Node->FieldName);
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetterNode_Expr_Z30));
	return;
}
static void VisitMethodCallNode__2qgx(struct CSourceGenerator601 * this, struct ZMethodCallNode405 * Node__1) {
	return;
}
static void VisitFuncCallNode__2qgx(struct CSourceGenerator601 * this, struct ZFuncCallNode409 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78));
	VisitListNode__4qub(this, "(", Node, ")");
	return;
}
static void VisitThrowNode__2qgx(struct CSourceGenerator601 * this, struct ZThrowNode193 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZThrowNode_Expr_Z32));
	Append__2qwi(this->CurrentBuilder, "longjump(1)");
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	return;
}
static void VisitTryNode__2qgx(struct CSourceGenerator601 * this, struct ZTryNode196 * Node__1) {
	return;
}
static void VisitCatchNode__2qgx(struct CSourceGenerator601 * this, struct ZCatchNode327 * Node__1) {
	return;
}
static const char * ParamTypeName__2qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1) {
	if (IsArrayType__1qwn(Type)) {
		return LibZen_StrCat("ArrayOf", ParamTypeName__2qgx(this, /*untyped*/NULL(Type, 0)));
	};
	if (IsMapType__1qwn(Type)) {
		return LibZen_StrCat("MapOf", ParamTypeName__2qgx(this, /*untyped*/NULL(Type, 0)));
	};
	if (IsFuncType__1qwn(Type)) {
		const char * s = LibZen_StrCat(LibZen_StrCat("FuncOf", ParamTypeName__2qgx(this, /*untyped*/NULL(Type, 0))), "Of");
		long i = 0;
		while (i < Type->GetParamSize(Type)) {
			s = LibZen_StrCat(s, ParamTypeName__2qgx(this, /*untyped*/NULL(Type, i)));
			i = i + 1;
		};
		return s;
	};
	if (IsIntType__1qwn(Type)) {
		return "Int";
	};
	if (IsFloatType__1qwn(Type)) {
		return "Float";
	};
	if (IsVoidType__1qwn(Type)) {
		return "Void";
	};
	if (/*untyped*/NULL(Type)) {
		return "Var";
	};
	return Type->ShortName;
}
static const char * GetNativeType__2qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1) {
	const char * TypeName = NULL;
	if (IsArrayType__1qwn(Type) || IsMapType__1qwn(Type)) {
		TypeName = LibZen_StrCat(ParamTypeName__2qgx(this, Type), " *");
	};
	if (LibZen_Is(Type, 81)) {
		TypeName = LibZen_StrCat(LibZen_StrCat("struct ", NameClass__2qw1(this, Type)), " *");
	};
	if (TypeName == NULL) {
		TypeName = /*untyped*/NULL;
	};
	return TypeName;
}
static void GenerateFuncTypeName__3qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1, const char * FuncName__2) {
	GenerateTypeName__2qgx(this, /*untyped*/NULL(Type, 0));
	Append__2qwi(this->CurrentBuilder, LibZen_StrCat(LibZen_StrCat(" (*", FuncName), ")"));
	long i = 1;
	Append__2qwi(this->CurrentBuilder, "(");
	while (i < Type->GetParamSize(Type)) {
		if (i > 1) {
			Append__2qwi(this->CurrentBuilder, ",");
		};
		GenerateTypeName__2qgx(this, /*untyped*/NULL(Type, i));
		i = i + 1;
	};
	Append__2qwi(this->CurrentBuilder, ")");
	return;
}
static void GenerateTypeName__2qgx(struct CSourceGenerator601 * this, struct ZType65 * Type__1) {
	if (IsFuncType__1qwn(Type)) {
		GenerateFuncTypeName__3qgx(this, Type, "");
	} else {
		Append__2qwi(this->CurrentBuilder, GetNativeType__2qgx(this, /*untyped*/NULL(Type)));
	};
	return;
}
static void VisitVarNode__2qgx(struct CSourceGenerator601 * this, struct ZVarNode508 * Node__1) {
	GenerateTypeName__2qgx(this, Node->DeclType);
	Append__2qwi(this->CurrentBuilder, " ");
	Append__2qwi(this->CurrentBuilder, Node->NativeName);
	AppendToken__2qwi(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZVarNode_InitValue_Z80));
	Append__2qwi(this->CurrentBuilder, this->SemiColon);
	VisitStmtList__2qub(this, Node);
	return;
}
static void VisitParamNode__2qgx(struct CSourceGenerator601 * this, struct ZParamNode174 * Node__1) {
	if (IsFuncType__1qwn(Node->Type)) {
		GenerateFuncTypeName__3qgx(this, Node->Type, Node->Name);
	} else {
		GenerateTypeName__2qgx(this, Node->Type);
		Append__2qwi(this->CurrentBuilder, " ");
		Append__2qwi(this->CurrentBuilder, SafeName__3qub(this, Node->Name, Node->ParamIndex));
	};
	return;
}
static void SetMethod__3qgx(struct CSourceGenerator601 * this, const char * FuncName__1, struct ZFuncType91 * FuncType__2) {
	struct ZType65 * RecvType = GetRecvType__1qek(FuncType);
	if (LibZen_Is(RecvType, 81) && FuncName != NULL) {
		struct ZClassType81 * ClassType = (struct ZClassType81 *)RecvType;
		struct ZType65 * FieldType = GetFieldType__3qep(ClassType, FuncName, NULL);
		if (FieldType == NULL || !IsFuncType__1qwn(FieldType)) {
			FuncName = LibZen_AnotherName__1qqy(FuncName);
			FieldType = GetFieldType__3qep(ClassType, FuncName, NULL);
			if (FieldType == NULL || !IsFuncType__1qwn(FieldType)) {
				return;
			};
		};
		if (LibZen_Is(FieldType, 91)) {
			if (AcceptAsFieldFunc__2qek(((struct ZFuncType91 *)FieldType), FuncType)) {
				Append__2qwi(this->HeaderBuilder, LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("#define _", NameClass__2qw1(this, ClassType)), "_"), FuncName));
				AppendLineFeed__1qwi(this->HeaderBuilder);
			};
		};
	};
	return;
}
static void VisitInstanceOfNode__2qgx(struct CSourceGenerator601 * this, struct ZInstanceOfNode375 * Node__1) {
	Append__2qwi(this->CurrentBuilder, "LibZen_Is(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZInstanceOfNode_Left_Z71));
	Append__2qwi(this->CurrentBuilder, this->Camma);
	AppendInt__2qwi(this->CurrentBuilder, Node->TargetType->TypeId);
	Append__2qwi(this->CurrentBuilder, ")");
	return;
}
static void GenerateCField__3qgx(struct CSourceGenerator601 * this, const char * CType__1, const char * FieldName__2) {
	AppendLineFeed__1qwi(this->CurrentBuilder);
	AppendIndent__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, CType);
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, FieldName);
	Append__2qwi(this->CurrentBuilder, this->SemiColon);
	return;
}
static void GenerateField__3qgx(struct CSourceGenerator601 * this, struct ZType65 * DeclType__1, const char * FieldName__2) {
	AppendLineFeedIndent__1qwi(this->CurrentBuilder);
	GenerateTypeName__2qgx(this, DeclType);
	AppendWhiteSpace__1qwi(this->CurrentBuilder);
	Append__2qwi(this->CurrentBuilder, FieldName);
	Append__2qwi(this->CurrentBuilder, this->SemiColon);
	return;
}
static void GenerateFields__3qgx(struct CSourceGenerator601 * this, struct ZClassType81 * ClassType__1, struct ZType65 * ThisType__2) {
	struct ZType65 * SuperType = /*untyped*/NULL(ThisType);
	if (!/*untyped*/NULL(SuperType)) {
		GenerateFields__3qgx(this, ClassType, SuperType);
	};
	long i = 0;
	GenerateCField__3qgx(this, "int", LibZen_StrCat("_classId", LibZen_IntToString(ThisType->TypeId)));
	GenerateCField__3qgx(this, "int", LibZen_StrCat("_delta", LibZen_IntToString(ThisType->TypeId)));
	while (i < GetFieldSize__1qep(ClassType)) {
		struct ZClassField80 * ClassField = GetFieldAt__2qep(ClassType, i);
		if (ClassField->ClassType == ThrowError("type error: requested = ZClassType, given = ZType")) {
			GenerateField__3qgx(this, ClassField->FieldType, ClassField->FieldName);
		};
		i = i + 1;
	};
	return;
}
static void VisitErrorNode__2qgx(struct CSourceGenerator601 * this, struct ZErrorNode338 * Node__1) {
	(void)ZLogger_LogError__2qeu(Node->SourceToken, Node->ErrorMessage);
	Append__2qwi(this->CurrentBuilder, "ThrowError(");
	Append__2qwi(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->ErrorMessage));
	Append__2qwi(this->CurrentBuilder, ")");
	return;
}
static struct ZAndNode504 * ZAndNode__5qdq(struct ZAndNode504 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, struct ZNode55 * Left__3, struct ZSyntax221 * Pattern__4) {
	(void)ZBinaryNode__5qox(this, ParentNode, Token, Left, Pattern);
	return NULL;
}
static void Accept__2qdq(struct ZAndNode504 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZArrayLiteralNode483 * ZArrayLiteralNode__2qsf(struct ZArrayLiteralNode483 * this, struct ZNode55 * ParentNode__1) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 0);
	return NULL;
}
static void Accept__2qsf(struct ZArrayLiteralNode483 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZBlockNode163 * ZBlockNode__2qtk(struct ZBlockNode163 * this, struct ZNameSpace49 * NameSpace__1) {
	(void)ZListNode__4qiq(this, NULL, NULL, 0);
	this->NameSpace = NameSpace;
	return NULL;
}
static struct ZBlockNode163 * ZBlockNode__3qtk(struct ZBlockNode163 * this, struct ZNode55 * ParentNode__1, long Init__2) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, Init);
	this->NameSpace = CreateSubNameSpace__1qws(GetNameSpace__1qwk(ParentNode));
	return NULL;
}
static void Accept__2qtk(struct ZBlockNode163 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZReturnNode172 * ToReturnNode__1qtk(struct ZBlockNode163 * this) {
	if (GetListSize__1qiq(this) == 1) {
		return ToReturnNode__1qwk(GetListAt__2qiq(this, 0));
	};
	return NULL;
}
static long IndexOf__2qtk(struct ZBlockNode163 * this, struct ZNode55 * ChildNode__1) {
	long i = 0;
	while (i < GetListSize__1qiq(this)) {
		if (GetListAt__2qiq(this, i) == ChildNode) {
			return i;
		};
		i = i + 1;
	};
	return -1;
}
static void CopyTo__3qtk(struct ZBlockNode163 * this, long Index__1, struct ZBlockNode163 * BlockNode__2) {
	long i = Index;
	while (i < GetListSize__1qiq(this)) {
		Append__2qiq(BlockNode, GetListAt__2qiq(this, i));
		i = i + 1;
	};
	return;
}
static struct ZBooleanNode478 * ZBooleanNode__4qs0(struct ZBooleanNode478 * this, struct ZNode55 * ParentNode__1, struct ZToken78 * Token__2, int Value__3) {
	(void)ZConstNode__3qp0(this, ParentNode, Token);
	this->Type = ZTypeBooleanType_Z5;
	this->BooleanValue = Value;
	return NULL;
}
static void Accept__2qs0(struct ZBooleanNode478 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZClassNode518 * ZClassNode__2qdd(struct ZClassNode518 * this, struct ZNode55 * ParentNode__1) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 0);
	return NULL;
}
static void SetTypeInfo__3qdd(struct ZClassNode518 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->SuperType = Type;
	this->SuperToken = TypeToken;
	return;
}
static void SetNameInfo__3qdd(struct ZClassNode518 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->ClassName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZFieldNode342 * GetFieldNode__2qdd(struct ZClassNode518 * this, long Index__1) {
	struct ZNode55 * Node = GetListAt__2qiq(this, Index);
	if (LibZen_Is(Node, 342)) {
		return (struct ZFieldNode342 *)Node;
	};
	return NULL;
}
static void Accept__2qdd(struct ZClassNode518 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFuncCallNode409 * ZFuncCallNode__3q4s(struct ZFuncCallNode409 * this, struct ZNode55 * ParentNode__1, struct ZNode55 * FuncNode__2) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 1);
	Set__3qwk(this, ZFuncCallNode_Func_Z78, FuncNode);
	return NULL;
}
static struct ZFuncCallNode409 * ZFuncCallNode__4q4s(struct ZFuncCallNode409 * this, struct ZNode55 * ParentNode__1, const char * FuncName__2, struct ZType65 * FuncType__3) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 1);
	struct ZGlobalNameNode362 * FuncNode = ZGlobalNameNode__6q0e(_NewZGlobalNameNode362(), this, NULL, FuncType, FuncName, 1/*true*/);
	Set__3qwk(this, ZFuncCallNode_Func_Z78, FuncNode);
	return NULL;
}
static void Accept__2q4s(struct ZFuncCallNode409 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZType65 * GetRecvType__1q4s(struct ZFuncCallNode409 * this) {
	if (GetListSize__1qiq(this) > 0) {
		return /*untyped*/NULL(GetListAt__2qiq(this, 0)->Type);
	};
	return ZTypeVoidType_Z4;
}
static const char * GetFuncName__1q4s(struct ZFuncCallNode409 * this) {
	struct ZNode55 * FNode = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78);
	if (LibZen_Is(FNode, 362)) {
		return ((struct ZGlobalNameNode362 *)FNode)->GlobalName;
	};
	return NULL;
}
static struct ZFuncType91 * GetFuncType__1q4s(struct ZFuncCallNode409 * this) {
	struct ZType65 * FType = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78)->Type;
	if (LibZen_Is(FType, 91)) {
		return (struct ZFuncType91 *)FType;
	};
	return NULL;
}
static struct ZMacroNode394 * ToMacroNode__2q4s(struct ZFuncCallNode409 * this, struct ZMacroFunc213 * MacroFunc__1) {
	struct ZMacroNode394 * MacroNode = ZMacroNode__4q02(_NewZMacroNode394(), this->ParentNode, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78)->SourceToken, MacroFunc);
	long i = 0;
	while (i < GetListSize__1qiq(this)) {
		Append__2qiq(MacroNode, GetListAt__2qiq(this, i));
		i = i + 1;
	};
	return MacroNode;
}
static struct ZFunctionNode146 * ZFunctionNode__2qte(struct ZFunctionNode146 * this, struct ZNode55 * ParentNode__1) {
	(void)ZListNode__4qiq(this, ParentNode, NULL, 1);
	return NULL;
}
static void SetTypeInfo__3qte(struct ZFunctionNode146 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->ReturnType = Type;
	return;
}
static void SetNameInfo__3qte(struct ZFunctionNode146 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->FuncName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qte(struct ZFunctionNode146 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZParamNode174 * GetParamNode__2qte(struct ZFunctionNode146 * this, long Index__1) {
	struct ZNode55 * Node = GetListAt__2qiq(this, Index);
	if (LibZen_Is(Node, 174)) {
		return (struct ZParamNode174 *)Node;
	};
	return NULL;
}
static struct ZFuncType91 * GetFuncType__2qte(struct ZFunctionNode146 * this, struct ZType65 * ContextType__1) {
	if (this->ResolvedFuncType == NULL) {
		struct ZFuncType91 * FuncType = NULL;
		if (LibZen_Is(ContextType, 91)) {
			FuncType = (struct ZFuncType91 *)ContextType;
		};
		ArrayOfZType * TypeList = LibZen_NewArray(0);
		if (this->ReturnType->IsVarType(this->ReturnType) && FuncType != NULL) {
			this->ReturnType = FuncType->GetParamType(FuncType, 0);
		};
		LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)this->ReturnType->GetRealType(this->ReturnType));
		long i = 0;
		while (i < GetListSize__1qiq(this)) {
			struct ZParamNode174 * Node = GetParamNode__2qte(this, i);
			struct ZType65 * ParamType = Node->Type->GetRealType(Node->Type);
			if (ParamType->IsVarType(ParamType) && FuncType != NULL) {
				ParamType = FuncType->GetParamType(FuncType, i + 1);
			};
			LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)ParamType);
			i = i + 1;
		};
		FuncType = ZTypePool_LookupFuncType__1qwm(TypeList);
		if (!FuncType->IsVarType(FuncType)) {
			this->ResolvedFuncType = FuncType;
		};
		return FuncType;
	};
	return this->ResolvedFuncType;
}
static const char * GetSignature__2qte(struct ZFunctionNode146 * this, struct ZGenerator58 * Generator__1) {
	struct ZFuncType91 * FuncType = GetFuncType__2qte(this, NULL);
	if (this->FuncName == NULL) {
		this->FuncName = LibZen_StrCat("f_Z", LibZen_IntToString(GetUniqueNumber__1qw1(Generator)));
	};
	return StringfySignature__2qek(FuncType, this->FuncName);
}
static struct ZFunctionNode146 * Push__2qte(struct ZFunctionNode146 * this, struct ZFunctionNode146 * Parent__1) {
	this->ParentFunctionNode = Parent;
	return this;
}
static struct ZFunctionNode146 * Pop__1qte(struct ZFunctionNode146 * this) {
	return this->ParentFunctionNode;
}
static int IsTopLevel__1qte(struct ZFunctionNode146 * this) {
	return this->ParentFunctionNode == NULL;
}
static long GetVarIndex__1qte(struct ZFunctionNode146 * this) {
	long Index = this->VarIndex;
	this->VarIndex = this->VarIndex + 1;
	return Index;
}
static struct ZVarNode508 * ZVarNode__2qdt(struct ZVarNode508 * this, struct ZNode55 * ParentNode__1) {
	(void)ZBlockNode__3qtk(this, ParentNode, 1);
	return NULL;
}
static void SetNameInfo__3qdt(struct ZVarNode508 * this, struct ZToken78 * NameToken__1, const char * Name__2) {
	this->NativeName = Name;
	this->NameToken = NameToken;
	return;
}
static void SetTypeInfo__3qdt(struct ZVarNode508 * this, struct ZToken78 * TypeToken__1, struct ZType65 * Type__2) {
	this->DeclType = Type;
	this->TypeToken = TypeToken;
	return;
}
static void Accept__2qdt(struct ZVarNode508 * this, struct ZVisitor169 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNode55 * AndPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZBinaryNode313 * BinaryNode = ZAndNode__5qdq(_NewZAndNode504(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57), LeftNode, GetApplyingSyntax__1qwl(TokenContext));
	return AppendParsedRightNode__3qox(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode55 * AnnotationPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	return NULL;
}
static struct ZNode55 * ApplyPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * ApplyNode = ZFuncCallNode__3q4s(_NewZFuncCallNode409(), ParentNode, LeftNode);
	ApplyNode = MatchNtimes__6qwl(TokenContext, ApplyNode, "(", "$Expression$", ",", ")");
	return ApplyNode;
}
static struct ZNode55 * ArrayLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * LiteralNode = ZArrayLiteralNode__2qsf(_NewZArrayLiteralNode483(), ParentNode);
	LiteralNode = MatchNtimes__6qwl(TokenContext, LiteralNode, "[", "$Expression$", ",", "]");
	return LiteralNode;
}
static struct ZNode55 * AssertPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * AssertNode = ZAssertNode__2qo1(_NewZAssertNode310(), ParentNode);
	AssertNode = MatchToken__4qwl(TokenContext, AssertNode, "assert", ZTokenContext_Required_Z52);
	AssertNode = MatchToken__4qwl(TokenContext, AssertNode, "(", ZTokenContext_Required_Z52);
	AssertNode = MatchPattern__6qwl(TokenContext, AssertNode, ZThrowNode_Expr_Z32, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	AssertNode = MatchToken__4qwl(TokenContext, AssertNode, ")", ZTokenContext_Required_Z52);
	return AssertNode;
}
static struct ZNode55 * AssignPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	return NULL;
}
static struct ZNode55 * BinaryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * Token = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	struct ZBinaryNode313 * BinaryNode = ZBinaryNode__5qox(_NewZBinaryNode313(), ParentNode, Token, LeftNode, GetApplyingSyntax__1qwl(TokenContext));
	return AppendParsedRightNode__3qox(BinaryNode, ParentNode, TokenContext);
}
static int BlockComment__1qwg(struct ZSourceContext52 * SourceContext) {
	long StartIndex = GetPosition__1qwg(SourceContext);
	const char * NextChar = GetCharAtFromCurrentPosition__2qwg(SourceContext, +1);
	if (NextChar != "/" && NextChar != "*") {
		return 0/*false*/;
	};
	if (NextChar == "/") {
		while (HasChar__1qwg(SourceContext)) {
			const char * ch = GetCurrentChar__1qwg(SourceContext);
			if (ch == "\n") {
				break;
			};
			MoveNext__1qwg(SourceContext);
		};
		return 1/*true*/;
	};
	long NestedLevel = 0;
	const char * PrevChar = "0";
	while (HasChar__1qwg(SourceContext)) {
		NextChar = GetCurrentChar__1qwg(SourceContext);
		if (PrevChar == "*" && NextChar == "/") {
			NestedLevel = NestedLevel - 1;
			if (NestedLevel == 0) {
				MoveNext__1qwg(SourceContext);
				return 1/*true*/;
			};
		};
		if (PrevChar == "/" && NextChar == "*") {
			NestedLevel = NestedLevel + 1;
		};
		MoveNext__1qwg(SourceContext);
		PrevChar = NextChar;
	};
	LogWarning__3qwg(SourceContext, StartIndex, "unfound */");
	return 1/*true*/;
}
static struct ZNode55 * BlockPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * BlockNode = ZBlockNode__3qtk(_NewZBlockNode163(), ParentNode, 0);
	struct ZToken78 * SkipToken = GetToken__1qwl(TokenContext);
	BlockNode = MatchToken__4qwl(TokenContext, BlockNode, "{", ZTokenContext_Required_Z52);
	if (!IsErrorNode__1qwk(BlockNode)) {
		int Remembered = SetParseFlag__2qwl(TokenContext, ZTokenContext_AllowSkipIndent_Z54);
		struct ZNode55 * NestedBlockNode = BlockNode;
		while (HasNext__1qwl(TokenContext)) {
			if (MatchToken__2qwl(TokenContext, "}")) {
				break;
			};
			NestedBlockNode = MatchPattern__5qwl(TokenContext, NestedBlockNode, ZNode_NestedAppendIndex_Z23, "$Statement$", ZTokenContext_Required_Z52);
			if (IsErrorNode__1qwk(NestedBlockNode)) {
				SkipError__2qwl(TokenContext, SkipToken);
				(void)MatchToken__2qwl(TokenContext, "}");
				break;
			};
		};
		(void)SetParseFlag__2qwl(TokenContext, Remembered);
	};
	return BlockNode;
}
static struct ZNode55 * BreakPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * BreakNode = ZBreakNode__2qo5(_NewZBreakNode320(), ParentNode);
	BreakNode = MatchToken__4qwl(TokenContext, BreakNode, "break", ZTokenContext_Required_Z52);
	return BreakNode;
}
static int CLineComment__1qwg(struct ZSourceContext52 * SourceContext) {
	return 0/*false*/;
}
static struct ZNode55 * CastPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * CastNode = ZCastNode__4qo8(_NewZCastNode323(), ParentNode, ZTypeVarType_Z3, NULL);
	CastNode = MatchToken__4qwl(TokenContext, CastNode, "(", ZTokenContext_Required_Z52);
	CastNode = MatchPattern__5qwl(TokenContext, CastNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Required_Z52);
	CastNode = MatchToken__4qwl(TokenContext, CastNode, ")", ZTokenContext_Required_Z52);
	CastNode = MatchPattern__5qwl(TokenContext, CastNode, ZCastNode_Expr_Z61, "$RightExpression$", ZTokenContext_Required_Z52);
	return CastNode;
}
static struct ZNode55 * CatchPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * CatchNode = ZCatchNode__2qpr(_NewZCatchNode327(), ParentNode);
	CatchNode = MatchToken__4qwl(TokenContext, CatchNode, "catch", ZTokenContext_Required_Z52);
	CatchNode = MatchToken__4qwl(TokenContext, CatchNode, "(", ZTokenContext_Required_Z52);
	CatchNode = MatchPattern__5qwl(TokenContext, CatchNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	CatchNode = MatchToken__4qwl(TokenContext, CatchNode, ")", ZTokenContext_Required_Z52);
	CatchNode = MatchPattern__5qwl(TokenContext, CatchNode, ZCatchNode_Block_Z62, "$Block$", ZTokenContext_Required_Z52);
	return CatchNode;
}
static struct ZNode55 * ClassPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * ClassNode = ZClassNode__2qdd(_NewZClassNode518(), ParentNode);
	ClassNode = MatchToken__4qwl(TokenContext, ClassNode, "class", ZTokenContext_Required_Z52);
	ClassNode = MatchPattern__5qwl(TokenContext, ClassNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	if (MatchNewLineToken__2qwl(TokenContext, "extends")) {
		ClassNode = MatchPattern__5qwl(TokenContext, ClassNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Required_Z52);
	};
	ClassNode = MatchNtimes__6qwl(TokenContext, ClassNode, "{", "$FieldDecl$", NULL, "}");
	return ClassNode;
}
static struct ZNode55 * ComparatorPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * Token = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	struct ZBinaryNode313 * BinaryNode = ZComparatorNode__5qpi(_NewZComparatorNode331(), ParentNode, Token, LeftNode, GetApplyingSyntax__1qwl(TokenContext));
	return AppendParsedRightNode__3qox(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode55 * ExpressionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qwk(ParentNode, TokenContext, LeftNode, 0/*false*/, 1/*true*/);
}
static struct ZNode55 * FalsePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	return ZBooleanNode__4qs0(_NewZBooleanNode478(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57), 0/*false*/);
}
static struct ZNode55 * FieldPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	int Rememberd = SetParseFlag__2qwl(TokenContext, 0/*false*/);
	struct ZNode55 * FieldNode = ZFieldNode__2qpj(_NewZFieldNode342(), ParentNode);
	FieldNode = MatchToken__4qwl(TokenContext, FieldNode, "var", ZTokenContext_Required_Z52);
	FieldNode = MatchPattern__5qwl(TokenContext, FieldNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	FieldNode = MatchPattern__5qwl(TokenContext, FieldNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	if (MatchToken__2qwl(TokenContext, "=")) {
		FieldNode = MatchPattern__5qwl(TokenContext, FieldNode, ZFieldNode_InitValue_Z63, "$Expression$", ZTokenContext_Required_Z52);
	};
	FieldNode = MatchPattern__5qwl(TokenContext, FieldNode, ZNode_Nop_Z19, ";", ZTokenContext_Required_Z52);
	(void)SetParseFlag__2qwl(TokenContext, Rememberd);
	return FieldNode;
}
static struct ZNode55 * FloatLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * Token = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	return ZFloatNode__4qp1(_NewZFloatNode346(), ParentNode, Token, LibZen_ParseFloat__1qqy(GetText__1qeu(Token)));
}
static struct ZNode55 * FunctionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * FuncNode = ZFunctionNode__2qte(_NewZFunctionNode146(), ParentNode);
	FuncNode = MatchToken__4qwl(TokenContext, FuncNode, "function", ZTokenContext_Required_Z52);
	FuncNode = MatchPattern__5qwl(TokenContext, FuncNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Optional_Z53);
	FuncNode = MatchNtimes__6qwl(TokenContext, FuncNode, "(", "$Param$", ",", ")");
	FuncNode = MatchPattern__5qwl(TokenContext, FuncNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	FuncNode = MatchPattern__5qwl(TokenContext, FuncNode, ZFunctionNode_Block_Z79, "$Block$", ZTokenContext_Required_Z52);
	return FuncNode;
}
static struct ZNode55 * GetIndexPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * IndexerNode = ZGetIndexNode__3qpx(_NewZGetIndexNode349(), ParentNode, LeftNode);
	IndexerNode = MatchToken__4qwl(TokenContext, IndexerNode, "[", ZTokenContext_Required_Z52);
	IndexerNode = MatchPattern__6qwl(TokenContext, IndexerNode, ZGetIndexNode_Index_Z65, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	IndexerNode = MatchToken__4qwl(TokenContext, IndexerNode, "]", ZTokenContext_Required_Z52);
	return IndexerNode;
}
static struct ZNode55 * GetterPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * GetterNode = ZGetterNode__3qp3(_NewZGetterNode357(), ParentNode, LeftNode);
	GetterNode = MatchToken__4qwl(TokenContext, GetterNode, ".", ZTokenContext_Required_Z52);
	GetterNode = MatchPattern__5qwl(TokenContext, GetterNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	return GetterNode;
}
static struct ZNode55 * GroupPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * GroupNode = ZGroupNode__2q0u(_NewZGroupNode366(), ParentNode);
	GroupNode = MatchToken__4qwl(TokenContext, GroupNode, "(", ZTokenContext_Required_Z52);
	GroupNode = MatchPattern__6qwl(TokenContext, GroupNode, ZGroupNode_Expr_Z67, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	GroupNode = MatchToken__4qwl(TokenContext, GroupNode, ")", ZTokenContext_Required_Z52);
	return GroupNode;
}
static struct ZNode55 * IfPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * IfNode = ZIfNode__2q0p(_NewZIfNode369(), ParentNode);
	IfNode = MatchToken__4qwl(TokenContext, IfNode, "if", ZTokenContext_Required_Z52);
	IfNode = MatchToken__4qwl(TokenContext, IfNode, "(", ZTokenContext_Required_Z52);
	IfNode = MatchPattern__6qwl(TokenContext, IfNode, ZIfNode_Cond_Z68, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowNewLine_Z56);
	IfNode = MatchToken__4qwl(TokenContext, IfNode, ")", ZTokenContext_Required_Z52);
	IfNode = MatchPattern__5qwl(TokenContext, IfNode, ZIfNode_Then_Z69, "$Block$", ZTokenContext_Required_Z52);
	if (MatchNewLineToken__2qwl(TokenContext, "else")) {
		const char * PatternName = "$Block$";
		if (IsNewLineToken__2qwl(TokenContext, "if")) {
			PatternName = "if";
		};
		IfNode = MatchPattern__5qwl(TokenContext, IfNode, ZIfNode_Else_Z70, PatternName, ZTokenContext_Required_Z52);
	};
	return IfNode;
}
static struct ZNode55 * InstanceOfPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * BinaryNode = ZInstanceOfNode__4q0f(_NewZInstanceOfNode375(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57), LeftNode);
	BinaryNode = MatchPattern__5qwl(TokenContext, BinaryNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Required_Z52);
	return BinaryNode;
}
static struct ZNode55 * IntLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * Token = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	return ZIntNode__4q0k(_NewZIntNode379(), ParentNode, Token, LibZen_ParseInt__1qqy(GetText__1qeu(Token)));
}
static struct ZNode55 * LetPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * LetNode = ZLetNode__2q01(_NewZLetNode382(), ParentNode);
	LetNode = MatchToken__4qwl(TokenContext, LetNode, "let", ZTokenContext_Required_Z52);
	LetNode = MatchPattern__5qwl(TokenContext, LetNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	LetNode = MatchPattern__5qwl(TokenContext, LetNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	LetNode = MatchToken__4qwl(TokenContext, LetNode, "=", ZTokenContext_Required_Z52);
	LetNode = MatchPattern__5qwl(TokenContext, LetNode, ZLetNode_InitValue_Z72, "$Expression$", ZTokenContext_Required_Z52);
	return LetNode;
}
static struct ZNode55 * MapEntryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * LiteralNode = ZMapEntryNode__2q4r(_NewZMapEntryNode399(), ParentNode);
	LiteralNode = MatchPattern__5qwl(TokenContext, LiteralNode, ZMapEntryNode_Key_Z73, "$Expression$", ZTokenContext_Required_Z52);
	LiteralNode = MatchToken__4qwl(TokenContext, LiteralNode, ":", ZTokenContext_Required_Z52);
	LiteralNode = MatchPattern__5qwl(TokenContext, LiteralNode, ZMapEntryNode_Value_Z74, "$Expression$", ZTokenContext_Required_Z52);
	return LiteralNode;
}
static struct ZNode55 * MapLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * LiteralNode = ZMapLiteralNode__2q4y(_NewZMapLiteralNode401(), ParentNode);
	LiteralNode = MatchNtimes__6qwl(TokenContext, LiteralNode, "{", "$MapEntry$", ",", "}");
	return LiteralNode;
}
static struct ZNode55 * MethodCallPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * MethodCallNode = ZMethodCallNode__3q4p(_NewZMethodCallNode405(), ParentNode, LeftNode);
	MethodCallNode = MatchToken__4qwl(TokenContext, MethodCallNode, ".", ZTokenContext_Required_Z52);
	MethodCallNode = MatchPattern__5qwl(TokenContext, MethodCallNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	MethodCallNode = MatchNtimes__6qwl(TokenContext, MethodCallNode, "(", "$Expression$", ",", ")");
	return MethodCallNode;
}
static struct ZNode55 * NamePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * Token = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	if (LibZen_IsSymbol__1qqy(GetChar__1qeu(Token))) {
		return ZGetNameNode__4qpb(_NewZGetNameNode352(), ParentNode, Token, GetText__1qeu(Token));
	};
	return ZErrorNode__4qpd(_NewZErrorNode338(), ParentNode, Token, LibZen_StrCat(LibZen_StrCat("illegal name: \"", GetText__1qeu(Token)), "\""));
}
static int NameToken__1qwg(struct ZSourceContext52 * SourceContext) {
	long StartIndex = GetPosition__1qwg(SourceContext);
	while (HasChar__1qwg(SourceContext)) {
		const char * ch = GetCurrentChar__1qwg(SourceContext);
		if (!LibZen_IsSymbol__1qqy(ch) && !LibZen_IsDigit__1qqy(ch)) {
			break;
		};
		MoveNext__1qwg(SourceContext);
	};
	Tokenize__3qwg(SourceContext, StartIndex, GetPosition__1qwg(SourceContext));
	return 1/*true*/;
}
static int NewLineToken__1qwg(struct ZSourceContext52 * SourceContext) {
	long StartIndex = GetPosition__1qwg(SourceContext) + 1;
	MoveNext__1qwg(SourceContext);
	SkipWhiteSpace__1qwg(SourceContext);
	FoundIndent__3qwg(SourceContext, StartIndex, GetPosition__1qwg(SourceContext));
	return 1/*true*/;
}
static struct ZNode55 * NewObjectPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * LiteralNode = ZNewObjectNode__2q4j(_NewZNewObjectNode414(), ParentNode);
	LiteralNode = MatchToken__4qwl(TokenContext, LiteralNode, "new", ZTokenContext_Required_Z52);
	LiteralNode = MatchPattern__5qwl(TokenContext, LiteralNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Optional_Z53);
	LiteralNode = MatchNtimes__6qwl(TokenContext, LiteralNode, "(", "$Expression$", ",", ")");
	return LiteralNode;
}
static struct ZNode55 * NotPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * UnaryNode = ZNotNode__3q41(_NewZNotNode418(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57));
	UnaryNode = MatchPattern__5qwl(TokenContext, UnaryNode, ZUnaryNode_Recv_Z36, "$RightExpression$", ZTokenContext_Required_Z52);
	return UnaryNode;
}
static struct ZNode55 * NullPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	return ZNullNode__3q4x(_NewZNullNode421(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57));
}
static int NumberLiteralToken__1qwg(struct ZSourceContext52 * SourceContext) {
	long StartIndex = GetPosition__1qwg(SourceContext);
	const char * ch = NumberLiteralToken_ParseDigit__1qwg(SourceContext);
	if (ch == ".") {
		MoveNext__1qwg(SourceContext);
		ch = NumberLiteralToken_ParseDigit__1qwg(SourceContext);
		if (ch == "e" || ch == "E") {
			MoveNext__1qwg(SourceContext);
			if (HasChar__1qwg(SourceContext)) {
				ch = GetCurrentChar__1qwg(SourceContext);
				if (ch == "+" || ch == "-") {
					MoveNext__1qwg(SourceContext);
				};
			};
			(void)NumberLiteralToken_ParseDigit__1qwg(SourceContext);
		};
		Tokenize__4qwg(SourceContext, "$FloatLiteral$", StartIndex, GetPosition__1qwg(SourceContext));
	} else {
		Tokenize__4qwg(SourceContext, "$IntegerLiteral$", StartIndex, GetPosition__1qwg(SourceContext));
	};
	return 1/*true*/;
}
static int OperatorToken__1qwg(struct ZSourceContext52 * SourceContext) {
	TokenizeDefinedSymbol__2qwg(SourceContext, GetPosition__1qwg(SourceContext));
	return 1/*true*/;
}
static struct ZNode55 * OrPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZBinaryNode313 * BinaryNode = ZOrNode__5q4b(_NewZOrNode424(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57), LeftNode, GetApplyingSyntax__1qwl(TokenContext));
	return AppendParsedRightNode__3qox(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode55 * ParamPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * ParamNode = ZParamNode__2qtm(_NewZParamNode174(), ParentNode);
	ParamNode = MatchPattern__5qwl(TokenContext, ParamNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	ParamNode = MatchPattern__5qwl(TokenContext, ParamNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	return ParamNode;
}
static struct ZNode55 * PrototypePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * FuncNode = ZPrototypeNode__2q47(_NewZPrototypeNode427(), ParentNode);
	FuncNode = MatchToken__4qwl(TokenContext, FuncNode, "function", ZTokenContext_Required_Z52);
	FuncNode = MatchPattern__5qwl(TokenContext, FuncNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	FuncNode = MatchNtimes__6qwl(TokenContext, FuncNode, "(", "$Param$", ",", ")");
	FuncNode = MatchPattern__5qwl(TokenContext, FuncNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Required_Z52);
	return FuncNode;
}
static struct ZNode55 * ReturnPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * ReturnNode = ZReturnNode__2qtb(_NewZReturnNode172(), ParentNode);
	ReturnNode = MatchToken__4qwl(TokenContext, ReturnNode, "return", ZTokenContext_Required_Z52);
	ReturnNode = MatchPattern__5qwl(TokenContext, ReturnNode, ZReturnNode_Expr_Z24, "$Expression$", ZTokenContext_Optional_Z53);
	return ReturnNode;
}
static struct ZNode55 * RightExpressionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qwk(ParentNode, TokenContext, LeftNode, 0/*false*/, 0/*false*/);
}
static struct ZNode55 * RightTypePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftTypeNode__2) {
	struct ZToken78 * SourceToken = GetToken__1qwl(TokenContext);
	if (LeftTypeNode->Type->GetParamSize(LeftTypeNode->Type) > 0) {
		if (MatchToken__2qwl(TokenContext, "<")) {
			ArrayOfZType * TypeList = LibZen_NewArray(0);
			while (!StartsWithToken__2qwl(TokenContext, ">")) {
				if (LibZen_ArraySize((ArrayOfVar *)TypeList) > 0 && !MatchToken__2qwl(TokenContext, ",")) {
					return NULL;
				};
				struct ZTypeNode236 * ParamTypeNode = (struct ZTypeNode236 *)ParsePattern__4qwl(TokenContext, ParentNode, "$Type$", ZTokenContext_Optional_Z53);
				if (ParamTypeNode == NULL) {
					return LeftTypeNode;
				};
				LibZen_ArrayAdd((ArrayOfVar *)TypeList, (var)ParamTypeNode->Type);
			};
			LeftTypeNode = ZTypeNode__4qul(_NewZTypeNode236(), ParentNode, SourceToken, ZTypePool_GetGenericType__3qwn(LeftTypeNode->Type, TypeList, 1/*true*/));
		};
	};
	while (MatchToken__2qwl(TokenContext, "[")) {
		if (!MatchToken__2qwl(TokenContext, "]")) {
			return NULL;
		};
		LeftTypeNode = ZTypeNode__4qul(_NewZTypeNode236(), ParentNode, SourceToken, ZTypePool_GetGenericType1__2qwn(ZTypeArrayType_Z10, LeftTypeNode->Type));
	};
	return LeftTypeNode;
}
static struct ZNode55 * SetIndexPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * IndexerNode = ZSetIndexNode__3qyq(_NewZSetIndexNode180(), ParentNode, LeftNode);
	IndexerNode = MatchToken__4qwl(TokenContext, IndexerNode, "[", ZTokenContext_Required_Z52);
	IndexerNode = MatchPattern__6qwl(TokenContext, IndexerNode, ZSetIndexNode_Index_Z26, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	IndexerNode = MatchToken__4qwl(TokenContext, IndexerNode, "]", ZTokenContext_Required_Z52);
	IndexerNode = MatchToken__4qwl(TokenContext, IndexerNode, "=", ZTokenContext_Required_Z52);
	IndexerNode = MatchPattern__5qwl(TokenContext, IndexerNode, ZSetIndexNode_Expr_Z27, "$Expression$", ZTokenContext_Required_Z52);
	return IndexerNode;
}
static struct ZNode55 * SetterPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * SetterNode = ZSetterNode__3qyu(_NewZSetterNode186(), ParentNode, LeftNode);
	SetterNode = MatchToken__4qwl(TokenContext, SetterNode, ".", ZTokenContext_Required_Z52);
	SetterNode = MatchPattern__5qwl(TokenContext, SetterNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	SetterNode = MatchToken__4qwl(TokenContext, SetterNode, "=", ZTokenContext_Required_Z52);
	SetterNode = MatchPattern__5qwl(TokenContext, SetterNode, ZSetterNode_Expr_Z30, "$Expression$", ZTokenContext_Required_Z52);
	return SetterNode;
}
static struct ZNode55 * StatementEndPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	int ContextAllowance = SetParseFlag__2qwl(TokenContext, 0/*false*/);
	struct ZToken78 * Token = NULL;
	if (HasNext__1qwl(TokenContext)) {
		Token = GetToken__1qwl(TokenContext);
		if (!EqualsText__2qeu(Token, ";") && !IsIndent__1qeu(Token)) {
			(void)SetParseFlag__2qwl(TokenContext, ContextAllowance);
			return CreateExpectedErrorNode__3qwl(TokenContext, Token, ";");
		};
		MoveNext__1qwl(TokenContext);
		while (HasNext__1qwl(TokenContext)) {
			Token = GetToken__1qwl(TokenContext);
			if (!EqualsText__2qeu(Token, ";") && !IsIndent__1qeu(Token)) {
				break;
			};
			MoveNext__1qwl(TokenContext);
		};
	};
	(void)SetParseFlag__2qwl(TokenContext, ContextAllowance);
	return ZEmptyNode__3qpa(_NewZEmptyNode336(), ParentNode, Token);
}
static struct ZNode55 * StatementPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	int Rememberd = SetParseFlag__2qwl(TokenContext, ZTokenContext_AllowSkipIndent_Z54);
	(void)SetParseFlag__2qwl(TokenContext, ZTokenContext_NotAllowSkipIndent_Z55);
	struct ZNode55 * StmtNode = ExpressionPattern_DispatchPattern__5qwk(ParentNode, TokenContext, NULL, 1/*true*/, 1/*true*/);
	StmtNode = MatchPattern__5qwl(TokenContext, StmtNode, ZNode_Nop_Z19, ";", ZTokenContext_Required_Z52);
	(void)SetParseFlag__2qwl(TokenContext, Rememberd);
	return StmtNode;
}
static struct ZNode55 * StringLiteralPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * Token = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	return ZStringNode__4qaw(_NewZStringNode433(), ParentNode, Token, LibZen_UnquoteString__1qqy(GetText__1qeu(Token)));
}
static int StringLiteralToken__1qwg(struct ZSourceContext52 * SourceContext) {
	long StartIndex = GetPosition__1qwg(SourceContext);
	MoveNext__1qwg(SourceContext);
	while (HasChar__1qwg(SourceContext)) {
		const char * ch = GetCurrentChar__1qwg(SourceContext);
		if (ch == "\"") {
			MoveNext__1qwg(SourceContext);
			Tokenize__4qwg(SourceContext, "$StringLiteral$", StartIndex, GetPosition__1qwg(SourceContext));
			return 1/*true*/;
		};
		if (ch == "\n") {
			break;
		};
		if (ch == "\\") {
			MoveNext__1qwg(SourceContext);
		};
		MoveNext__1qwg(SourceContext);
	};
	LogWarning__3qwg(SourceContext, StartIndex, "unclosed \"");
	Tokenize__4qwg(SourceContext, "$StringLiteral$", StartIndex, GetPosition__1qwg(SourceContext));
	return 0/*false*/;
}
static struct ZNode55 * SymbolExpressionPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * NameToken = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	if (IsToken__2qwl(TokenContext, "=")) {
		return ZErrorNode__4qpd(_NewZErrorNode338(), ParentNode, GetToken__1qwl(TokenContext), "assignment is not en expression");
	} else {
		return ZGetNameNode__4qpb(_NewZGetNameNode352(), ParentNode, NameToken, GetText__1qeu(NameToken));
	};
}
static struct ZNode55 * SymbolStatementPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * NameToken = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	if (MatchToken__2qwl(TokenContext, "=")) {
		struct ZNode55 * AssignedNode = ZSetNameNode__4qyr(_NewZSetNameNode183(), ParentNode, NameToken, GetText__1qeu(NameToken));
		AssignedNode = MatchPattern__5qwl(TokenContext, AssignedNode, ZSetNameNode_Expr_Z28, "$Expression$", ZTokenContext_Required_Z52);
		return AssignedNode;
	} else {
		return ZGetNameNode__4qpb(_NewZGetNameNode352(), ParentNode, NameToken, GetText__1qeu(NameToken));
	};
}
static struct ZNode55 * ThrowPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * ThrowNode = ZThrowNode__2qys(_NewZThrowNode193(), ParentNode);
	ThrowNode = MatchToken__4qwl(TokenContext, ThrowNode, "throw", ZTokenContext_Required_Z52);
	ThrowNode = MatchPattern__5qwl(TokenContext, ThrowNode, ZThrowNode_Expr_Z32, "$Expression$", ZTokenContext_Required_Z52);
	return ThrowNode;
}
static struct ZNode55 * TruePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	return ZBooleanNode__4qs0(_NewZBooleanNode478(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57), 1/*true*/);
}
static struct ZNode55 * TryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * TryNode = ZTryNode__2qyg(_NewZTryNode196(), ParentNode);
	TryNode = MatchToken__4qwl(TokenContext, TryNode, "try", ZTokenContext_Required_Z52);
	TryNode = MatchPattern__5qwl(TokenContext, TryNode, ZTryNode_Try_Z33, "$Block$", ZTokenContext_Required_Z52);
	long count = 0;
	if (IsNewLineToken__2qwl(TokenContext, "catch")) {
		TryNode = MatchPattern__5qwl(TokenContext, TryNode, ZTryNode_Catch_Z34, "$Catch$", ZTokenContext_Required_Z52);
		count = count + 1;
	};
	if (MatchNewLineToken__2qwl(TokenContext, "finally")) {
		TryNode = MatchPattern__5qwl(TokenContext, TryNode, ZTryNode_Finally_Z35, "$Block$", ZTokenContext_Required_Z52);
		count = count + 1;
	};
	if (count == 0 && !IsErrorNode__1qwk(TryNode)) {
		return Array<ZNode>GetIndex(ZTryNode_Try_Z33);
	};
	return TryNode;
}
static struct ZNode55 * TypeAnnotationPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	if (MatchToken__2qwl(TokenContext, ":")) {
		return ParsePattern__4qwl(TokenContext, ParentNode, "$Type$", ZTokenContext_Required_Z52);
	};
	return NULL;
}
static struct ZNode55 * TypePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZToken78 * Token = GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57);
	struct ZTypeNode236 * TypeNode = GetTypeNode__3qws(GetNameSpace__1qwk(ParentNode), GetText__1qeu(Token), Token);
	if (TypeNode != NULL) {
		return ParsePatternAfter__5qwl(TokenContext, ParentNode, TypeNode, "$TypeRight$", ZTokenContext_Optional_Z53);
	};
	return NULL;
}
static struct ZNode55 * UnaryPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * UnaryNode = ZUnaryNode__3qyk(_NewZUnaryNode199(), ParentNode, GetToken__2qwl(TokenContext, ZTokenContext_MoveNext_Z57));
	return MatchPattern__5qwl(TokenContext, UnaryNode, ZUnaryNode_Recv_Z36, "$RightExpression$", ZTokenContext_Required_Z52);
}
static struct ZNode55 * VarPattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * VarNode = ZVarNode__2qdt(_NewZVarNode508(), ParentNode);
	VarNode = MatchToken__4qwl(TokenContext, VarNode, "var", ZTokenContext_Required_Z52);
	VarNode = MatchPattern__5qwl(TokenContext, VarNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	VarNode = MatchPattern__5qwl(TokenContext, VarNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	VarNode = MatchToken__4qwl(TokenContext, VarNode, "=", ZTokenContext_Required_Z52);
	VarNode = MatchPattern__5qwl(TokenContext, VarNode, ZVarNode_InitValue_Z80, "$Expression$", ZTokenContext_Required_Z52);
	return VarNode;
}
static struct ZNode55 * WhilePattern__3qwk(struct ZNode55 * ParentNode, struct ZTokenContext56 * TokenContext__1, struct ZNode55 * LeftNode__2) {
	struct ZNode55 * WhileNode = ZWhileNode__2qy1(_NewZWhileNode202(), ParentNode);
	WhileNode = MatchToken__4qwl(TokenContext, WhileNode, "while", ZTokenContext_Required_Z52);
	WhileNode = MatchToken__4qwl(TokenContext, WhileNode, "(", ZTokenContext_Required_Z52);
	WhileNode = MatchPattern__6qwl(TokenContext, WhileNode, ZWhileNode_Cond_Z37, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	WhileNode = MatchToken__4qwl(TokenContext, WhileNode, ")", ZTokenContext_Required_Z52);
	WhileNode = MatchPattern__5qwl(TokenContext, WhileNode, ZWhileNode_Block_Z38, "$Block$", ZTokenContext_Required_Z52);
	return WhileNode;
}
static int WhiteSpaceToken__1qwg(struct ZSourceContext52 * SourceContext) {
	SkipWhiteSpace__1qwg(SourceContext);
	return 1/*true*/;
}

