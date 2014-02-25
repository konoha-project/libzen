static const char * ZFunc_StringfySignature__3qqy(const char * FuncName, long FuncParamSize__1, struct ZType59 * RecvType__2);
static long ZTypePool_NewTypeId__1qw6(struct ZType59 * T);
static struct ZType59 * TypeOf__1qqr(long TypeId);
static struct ZType59 * GetGreekType__1qqr(long GreekId);
static const char * ZTypePool_MangleType2__2qw6(struct ZType59 * Type1, struct ZType59 * Type2__1);
static const char * ZTypePool_MangleTypes__1qwz(ArrayOfZType * TypeList);
static ArrayOfZType * ZTypePool_UniqueTypes__1qwz(ArrayOfZType * TypeList);
static struct ZType59 * ZTypePool_GetGenericType1__2qw6(struct ZType59 * BaseType, struct ZType59 * ParamType__1);
static struct ZType59 * ZTypePool_GetGenericType__3qw6(struct ZType59 * BaseType, ArrayOfZType * TypeList__1, int IsCreation__2);
static struct ZFuncType67 * ZTypePool_LookupFuncType__1qwz(ArrayOfZType * TypeList);
static struct ZFuncType67 * ZTypePool_LookupFuncType__1qw6(struct ZType59 * R);
static struct ZFuncType67 * ZTypePool_LookupFuncType__2qw6(struct ZType59 * R, struct ZType59 * P1__1);
static struct ZFuncType67 * ZTypePool_LookupFuncType__3qw6(struct ZType59 * R, struct ZType59 * P1__1, struct ZType59 * P2__2);
static const char * ZLogger_LogError__2qwb(struct ZToken64 * Token, const char * Message__1);
static void ZLogger_LogWarning__2qwb(struct ZToken64 * Token, const char * Message__1);
static void ZLogger_LogInfo__2qwb(struct ZToken64 * Token, const char * Message__1);
static void ZLogger_LogDebug__2qwb(struct ZToken64 * Token, const char * Message__1);
static const char * ZNameSpace_RightPatternSymbol__1qqy(const char * PatternName);
static struct ZSyntax184 * MergeSyntaxPattern__2qyt(struct ZSyntax184 * Pattern, struct ZSyntax184 * Parent__1);
static ArrayOfZType * ZGreekType_NewGreekTypes__1qwz(ArrayOfZType * GreekTypes);
static struct ZSyntax184 * ExpressionPattern_GetRightPattern__2qwi(struct ZNameSpace43 * NameSpace, struct ZTokenContext50 * TokenContext__1);
static struct ZNode49 * ExpressionPattern_DispatchPattern__5qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2, int AllowStatement__3, int AllowBinary__4);
static const char * NumberLiteralToken_ParseDigit__1qw0(struct ZSourceContext46 * SourceContext);
static struct ZClassField62 * ZClassField__5qwc(struct ZClassField62 * this, struct ZClassType63 * ClassType__1, const char * FieldName__2, struct ZType59 * FieldType__3, struct ZToken64 * SourceToken__4);
static struct ZFunc66 * ZFunc__4qwm(struct ZFunc66 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType67 * FuncType__3);
static struct ZFuncType67 * GetFuncType__1qwm(struct ZFunc66 * this);
static const char * toString__1qwm(struct ZFunc66 * this);
static int IsConverterFunc__1qwm(struct ZFunc66 * this);
static int IsCoercionFunc__1qwm(struct ZFunc66 * this);
static int Is__2qwm(struct ZFunc66 * this, long Flag__1);
static const char * GetSignature__1qwm(struct ZFunc66 * this);
static struct ZPrototype74 * ZPrototype__5qee(struct ZPrototype74 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType67 * FuncType__3, struct ZToken64 * SourceToken__4);
static void Used__1qee(struct ZPrototype74 * this);
static void Defined__1qee(struct ZPrototype74 * this);
static struct ZType59 * ZType__4qw6(struct ZType59 * this, long TypeFlag__1, const char * ShortName__2, struct ZType59 * RefType__3);
static struct ZType59 * GetRealType__1qw6(struct ZType59 * this);
#define _ZType59_GetRealType
static struct ZType59 * GetSuperType__1qw6(struct ZType59 * this);
#define _ZType59_GetSuperType
static struct ZType59 * GetBaseType__1qw6(struct ZType59 * this);
#define _ZType59_GetBaseType
static long GetParamSize__1qw6(struct ZType59 * this);
#define _ZType59_GetParamSize
static struct ZType59 * GetParamType__2qw6(struct ZType59 * this, long Index__1);
#define _ZType59_GetParamType
static int Equals__2qw6(struct ZType59 * this, struct ZType59 * Type__1);
static int Accept__2qw6(struct ZType59 * this, struct ZType59 * Type__1);
static int IsGreekType__1qw6(struct ZType59 * this);
#define _ZType59_IsGreekType
static struct ZType59 * GetGreekRealType__2qw6(struct ZType59 * this, ArrayOfZType * Greek__1);
#define _ZType59_GetGreekRealType
static int AcceptValueType__4qw6(struct ZType59 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZType59_AcceptValueType
static int IsVoidType__1qw6(struct ZType59 * this);
static int IsVarType__1qw6(struct ZType59 * this);
#define _ZType59_IsVarType
static int IsInferrableType__1qw6(struct ZType59 * this);
static int IsTypeType__1qw6(struct ZType59 * this);
static int IsBooleanType__1qw6(struct ZType59 * this);
static int IsIntType__1qw6(struct ZType59 * this);
static int IsFloatType__1qw6(struct ZType59 * this);
static int IsNumberType__1qw6(struct ZType59 * this);
static int IsStringType__1qw6(struct ZType59 * this);
static int IsArrayType__1qw6(struct ZType59 * this);
static int IsMapType__1qw6(struct ZType59 * this);
static int IsOpenType__1qw6(struct ZType59 * this);
static int IsImmutableType__1qw6(struct ZType59 * this);
static int IsNullableType__1qw6(struct ZType59 * this);
static const char * toString__1qw6(struct ZType59 * this);
static const char * GetAsciiName__1qw6(struct ZType59 * this);
static const char * StringfyClassMember__2qw6(struct ZType59 * this, const char * Name__1);
static const char * GetUniqueName__1qw6(struct ZType59 * this);
static int IsFuncType__1qw6(struct ZType59 * this);
static const char * StringfySignature__2qw6(struct ZType59 * this, const char * FuncName__1);
static void Maybe__3qw6(struct ZType59 * this, struct ZType59 * T__1, struct ZToken64 * SourceToken__2);
static struct ZVarScope98 * ZVarScope__4qec(struct ZVarScope98 * this, struct ZVarScope98 * Parent__1, struct ZLogger99 * Logger__2, ArrayOfZVarType * VarList__3);
static struct ZType59 * NewVarType__4qec(struct ZVarScope98 * this, struct ZType59 * VarType__1, const char * Name__2, struct ZToken64 * SourceToken__3);
static void FoundUnresolvedSymbol__2qec(struct ZVarScope98 * this, const char * FuncName__1);
static void CheckVarNode__3qec(struct ZVarScope98 * this, struct ZType59 * ContextType__1, struct ZNode49 * Node__2);
static int TypeCheckStmtList__3qec(struct ZVarScope98 * this, struct ZTypeChecker106 * TypeSafer__1, ArrayOfZNode * StmtList__2);
static void TypeCheckFuncBlock__3qec(struct ZVarScope98 * this, struct ZTypeChecker106 * TypeSafer__1, struct ZFunctionNode109 * FunctionNode__2);
static struct ZVarType100 * ZVarType__4qeb(struct ZVarType100 * this, ArrayOfZVarType * VarList__1, const char * Name__2, struct ZToken64 * SourceToken__3);
static struct ZType59 * GetRealType__1qeb(struct ZVarType100 * this);
#define _ZVarType100_GetRealType
static long GetParamSize__1qeb(struct ZVarType100 * this);
#define _ZVarType100_GetParamSize
static struct ZType59 * GetParamType__2qeb(struct ZVarType100 * this, long Index__1);
#define _ZVarType100_GetParamType
static int IsFuncType__1qeb(struct ZVarType100 * this);
static int IsVarType__1qeb(struct ZVarType100 * this);
#define _ZVarType100_IsVarType
static void Infer__3qeb(struct ZVarType100 * this, struct ZType59 * ContextType__1, struct ZToken64 * SourceToken__2);
static void Maybe__3qeb(struct ZVarType100 * this, struct ZType59 * T__1, struct ZToken64 * SourceToken__2);
static struct ZNode49 * ZNode__4qws(struct ZNode49 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, long Size__3);
static struct ZNode49 * SetChild__2qws(struct ZNode49 * this, struct ZNode49 * Node__1);
static void SetNameInfo__3qws(struct ZNode49 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZNode49_SetNameInfo
static void SetTypeInfo__3qws(struct ZNode49 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZNode49_SetTypeInfo
static void Set__3qws(struct ZNode49 * this, long Index__1, struct ZNode49 * Node__2);
static long GetAstSize__1qws(struct ZNode49 * this);
static int HasAst__2qws(struct ZNode49 * this, long Index__1);
static struct ZType59 * GetAstType__2qws(struct ZNode49 * this, long Index__1);
static const char * GetSourceLocation__1qws(struct ZNode49 * this);
static const char * toString__1qws(struct ZNode49 * this);
static struct ZBlockNode126 * GetScopeBlockNode__1qws(struct ZNode49 * this);
static struct ZNameSpace43 * GetNameSpace__1qws(struct ZNode49 * this);
static int IsErrorNode__1qws(struct ZNode49 * this);
static int IsBreakingBlock__1qws(struct ZNode49 * this);
#define _ZNode49_IsBreakingBlock
static struct ZSugarNode130 * DeSugar__2qws(struct ZNode49 * this, struct ZGenerator52 * Generator__1);
#define _ZNode49_DeSugar
static void Accept__2qws(struct ZNode49 * this, struct ZVisitor132 * Visitor__1);
#define _ZNode49_Accept
static int IsUntyped__1qws(struct ZNode49 * this);
static int HasUntypedNode__1qws(struct ZNode49 * this);
static struct ZNode49 * VisitTypeChecker__3qws(struct ZNode49 * this, struct ZTypeChecker106 * TypeChecker__1, struct ZType59 * ContextType__2);
static struct ZReturnNode135 * ToReturnNode__1qws(struct ZNode49 * this);
static struct ZParamNode137 * ZParamNode__2qrn(struct ZParamNode137 * this, struct ZNode49 * ParentNode__1);
static void SetNameInfo__3qrn(struct ZParamNode137 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZParamNode137_SetNameInfo
static struct ZReturnNode135 * ZReturnNode__2qrv(struct ZReturnNode135 * this, struct ZNode49 * ParentNode__1);
static void Accept__2qrv(struct ZReturnNode135 * this, struct ZVisitor132 * Visitor__1);
#define _ZReturnNode135_Accept
static struct ZReturnNode135 * ToReturnNode__1qrv(struct ZReturnNode135 * this);
static struct ZSetIndexNode143 * ZSetIndexNode__3qr8(struct ZSetIndexNode143 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * LeftNode__2);
static void Accept__2qr8(struct ZSetIndexNode143 * this, struct ZVisitor132 * Visitor__1);
#define _ZSetIndexNode143_Accept
static struct ZSetNameNode146 * ZSetNameNode__4qte(struct ZSetNameNode146 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, const char * VarName__3);
static void Accept__2qte(struct ZSetNameNode146 * this, struct ZVisitor132 * Visitor__1);
#define _ZSetNameNode146_Accept
static struct ZSetterNode149 * ZSetterNode__3qty(struct ZSetterNode149 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2);
static void SetNameInfo__3qty(struct ZSetterNode149 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZSetterNode149_SetNameInfo
static void Accept__2qty(struct ZSetterNode149 * this, struct ZVisitor132 * Visitor__1);
#define _ZSetterNode149_Accept
static int IsStaticField__1qty(struct ZSetterNode149 * this);
static struct ZSugarNode130 * ZSugarNode__3qr1(struct ZSugarNode130 * this, struct ZNode49 * SugarNode__1, struct ZNode49 * DeSugarNode__2);
static void Accept__2qr1(struct ZSugarNode130 * this, struct ZVisitor132 * Visitor__1);
#define _ZSugarNode130_Accept
static struct ZThrowNode156 * ZThrowNode__2qta(struct ZThrowNode156 * this, struct ZNode49 * ParentNode__1);
static void Accept__2qta(struct ZThrowNode156 * this, struct ZVisitor132 * Visitor__1);
#define _ZThrowNode156_Accept
static struct ZTryNode159 * ZTryNode__2qtf(struct ZTryNode159 * this, struct ZNode49 * ParentNode__1);
static void Accept__2qtf(struct ZTryNode159 * this, struct ZVisitor132 * Visitor__1);
#define _ZTryNode159_Accept
static struct ZUnaryNode162 * ZUnaryNode__3qtj(struct ZUnaryNode162 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2);
static void Accept__2qtj(struct ZUnaryNode162 * this, struct ZVisitor132 * Visitor__1);
#define _ZUnaryNode162_Accept
static struct ZWhileNode165 * ZWhileNode__2qt9(struct ZWhileNode165 * this, struct ZNode49 * ParentNode__1);
static void Accept__2qt9(struct ZWhileNode165 * this, struct ZVisitor132 * Visitor__1);
#define _ZWhileNode165_Accept
static const char * toString__1qtz(struct ZEmptyValue168 * this);
static void Report__2qev(struct ZLogger99 * this, const char * Message__1);
static ArrayOfString * GetReportedErrors__1qev(struct ZLogger99 * this);
static void ShowErrors__1qev(struct ZLogger99 * this);
static struct ZMacroFunc176 * ZMacroFunc__3qt5(struct ZMacroFunc176 * this, const char * FuncName__1, struct ZFuncType67 * FuncType__2);
static struct ZNameSpace43 * ZNameSpace__3qwi(struct ZNameSpace43 * this, struct ZGenerator52 * Generator__1, struct ZNameSpace43 * ParentNameSpace__2);
static const char * toString__1qwi(struct ZNameSpace43 * this);
static struct ZNameSpace43 * CreateSubNameSpace__1qwi(struct ZNameSpace43 * this);
static struct ZNameSpace43 * GetRootNameSpace__1qwi(struct ZNameSpace43 * this);
static struct ZTokenFunc28 * GetTokenFunc__2qwi(struct ZNameSpace43 * this, long ZenChar__1);
static struct ZTokenFunc28 * JoinParentFunc__3qwi(struct ZNameSpace43 * this, struct ZTokenFunction45 * Func__1, struct ZTokenFunc28 * Parent__2);
static void AppendTokenFunc__3qwi(struct ZNameSpace43 * this, const char * keys__1, struct ZTokenFunction45 * TokenFunc__2);
static struct ZSyntax184 * GetSyntaxPattern__2qwi(struct ZNameSpace43 * this, const char * PatternName__1);
static void SetSyntaxPattern__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZSyntax184 * Syntax__2);
static struct ZSyntax184 * GetRightSyntaxPattern__2qwi(struct ZNameSpace43 * this, const char * PatternName__1);
static void AppendSyntaxPattern__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZSyntax184 * NewPattern__2);
static void DefineStatement__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZMatchFunction48 * MatchFunc__2);
static void DefineExpression__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZMatchFunction48 * MatchFunc__2);
static void DefineRightExpression__4qwi(struct ZNameSpace43 * this, const char * PatternName__1, long SyntaxFlag__2, struct ZMatchFunction48 * MatchFunc__3);
static struct ZSymbolEntry189 * GetSymbol__2qwi(struct ZNameSpace43 * this, const char * Symbol__1);
static struct ZNode49 * GetSymbolNode__2qwi(struct ZNameSpace43 * this, const char * Symbol__1);
static void SetLocalSymbolEntry__3qwi(struct ZNameSpace43 * this, const char * Symbol__1, struct ZSymbolEntry189 * Entry__2);
static struct ZSymbolEntry189 * SetLocalSymbol__3qwi(struct ZNameSpace43 * this, const char * Symbol__1, struct ZNode49 * Node__2);
static struct ZSymbolEntry189 * SetGlobalSymbol__3qwi(struct ZNameSpace43 * this, const char * Symbol__1, struct ZNode49 * Node__2);
static struct ZVariable194 * GetLocalVariable__2qwi(struct ZNameSpace43 * this, const char * VarName__1);
static void SetLocalVariable__5qwi(struct ZNameSpace43 * this, struct ZFunctionNode109 * FunctionNode__1, struct ZType59 * VarType__2, const char * VarName__3, struct ZToken64 * SourceToken__4);
static void SetTypeName__4qwi(struct ZNameSpace43 * this, const char * Name__1, struct ZType59 * Type__2, struct ZToken64 * SourceToken__3);
static void SetTypeName__3qwi(struct ZNameSpace43 * this, struct ZType59 * Type__1, struct ZToken64 * SourceToken__2);
static struct ZTypeNode199 * GetTypeNode__3qwi(struct ZNameSpace43 * this, const char * TypeName__1, struct ZToken64 * SourceToken__2);
static struct ZType59 * GetType__3qwi(struct ZNameSpace43 * this, const char * TypeName__1, struct ZToken64 * SourceToken__2);
static struct ZSource202 * ZSource__5qy1(struct ZSource202 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext50 * TokenContext__4);
static long GetLineNumber__2qy1(struct ZSource202 * this, long Position__1);
static long GetLineHeadPosition__2qy1(struct ZSource202 * this, long Position__1);
static long CountIndentSize__2qy1(struct ZSource202 * this, long Position__1);
static const char * GetLineText__2qy1(struct ZSource202 * this, long Position__1);
static const char * GetLineMarker__2qy1(struct ZSource202 * this, long Position__1);
static const char * FormatErrorHeader__4qy1(struct ZSource202 * this, const char * Error__1, long Position__2, const char * Message__3);
static const char * FormatErrorMarker__4qy1(struct ZSource202 * this, const char * Error__1, long Position__2, const char * Message__3);
static const char * GetCharAt__2qy1(struct ZSource202 * this, long n__1);
static struct ZSourceBuilder37 * ZSourceBuilder__3qww(struct ZSourceBuilder37 * this, struct ZSourceGenerator207 * Template__1, struct ZSourceBuilder37 * Parent__2);
static struct ZSourceBuilder37 * Pop__1qww(struct ZSourceBuilder37 * this);
static void Clear__1qww(struct ZSourceBuilder37 * this);
static long GetPosition__1qww(struct ZSourceBuilder37 * this);
static const char * CopyString__3qww(struct ZSourceBuilder37 * this, long BeginIndex__1, long EndIndex__2);
static void Append__2qww(struct ZSourceBuilder37 * this, const char * Text__1);
static void AppendInt__2qww(struct ZSourceBuilder37 * this, long Value__1);
static void AppendLineFeed__1qww(struct ZSourceBuilder37 * this);
static void AppendLineFeed__2qww(struct ZSourceBuilder37 * this, int AppendIndent__1);
static void AppendWhiteSpace__1qww(struct ZSourceBuilder37 * this);
static void AppendToken__2qww(struct ZSourceBuilder37 * this, const char * Text__1);
static void AppendBlockComment__2qww(struct ZSourceBuilder37 * this, const char * Text__1);
static void AppendCommentLine__2qww(struct ZSourceBuilder37 * this, const char * Text__1);
static void Indent__1qww(struct ZSourceBuilder37 * this);
static void UnIndent__1qww(struct ZSourceBuilder37 * this);
static const char * GetIndentString__1qww(struct ZSourceBuilder37 * this);
static void AppendIndent__1qww(struct ZSourceBuilder37 * this);
static void AppendLineFeedIndent__1qww(struct ZSourceBuilder37 * this);
static void IndentAndAppend__2qww(struct ZSourceBuilder37 * this, const char * Text__1);
static void AppendParamList__4qww(struct ZSourceBuilder37 * this, struct ZListNode215 * ParamList__1, long BeginIdx__2, long EndIdx__3);
static const char * toString__1qww(struct ZSourceBuilder37 * this);
static void AppendLine__2qww(struct ZSourceBuilder37 * this, const char * Text__1);
static struct ZSourceContext46 * ZSourceContext__5qw0(struct ZSourceContext46 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext50 * TokenContext__4);
static long GetCharCode__1qw0(struct ZSourceContext46 * this);
static long GetPosition__1qw0(struct ZSourceContext46 * this);
static int HasChar__1qw0(struct ZSourceContext46 * this);
static const char * GetCurrentChar__1qw0(struct ZSourceContext46 * this);
static const char * GetCharAtFromCurrentPosition__2qw0(struct ZSourceContext46 * this, long n__1);
static void MoveNext__1qw0(struct ZSourceContext46 * this);
static void SkipWhiteSpace__1qw0(struct ZSourceContext46 * this);
static void FoundIndent__3qw0(struct ZSourceContext46 * this, long StartIndex__1, long EndIndex__2);
static void Tokenize__3qw0(struct ZSourceContext46 * this, long StartIndex__1, long EndIndex__2);
static void Tokenize__4qw0(struct ZSourceContext46 * this, const char * PatternName__1, long StartIndex__2, long EndIndex__3);
static int IsDefinedSyntax__3qw0(struct ZSourceContext46 * this, long StartIndex__1, long EndIndex__2);
static void TokenizeDefinedSymbol__2qw0(struct ZSourceContext46 * this, long StartIndex__1);
static void ApplyTokenFunc__2qw0(struct ZSourceContext46 * this, struct ZTokenFunc28 * TokenFunc__1);
static int DoTokenize__1qw0(struct ZSourceContext46 * this);
static void LogWarning__3qw0(struct ZSourceContext46 * this, long Position__1, const char * Message__2);
static struct ZSourceMacro229 * ZSourceMacro__4qus(struct ZSourceMacro229 * this, const char * FuncName__1, struct ZFuncType67 * FuncType__2, const char * Macro__3);
static struct ZSymbolEntry189 * ZSymbolEntry__3qyp(struct ZSymbolEntry189 * this, struct ZSymbolEntry189 * Parent__1, struct ZNode49 * Node__2);
static struct ZSyntax184 * ZSyntax__4qyt(struct ZSyntax184 * this, struct ZNameSpace43 * NameSpace__1, const char * PatternName__2, struct ZMatchFunction48 * MatchFunc__3);
static const char * toString__1qyt(struct ZSyntax184 * this);
static int IsBinaryOperator__1qyt(struct ZSyntax184 * this);
static int IsRightJoin__2qyt(struct ZSyntax184 * this, struct ZSyntax184 * Right__1);
static int EqualsName__2qyt(struct ZSyntax184 * this, const char * Name__1);
static struct ZToken64 * ZToken__4qwb(struct ZToken64 * this, struct ZSource202 * Source__1, long StartIndex__2, long EndIndex__3);
static const char * GetFileName__1qwb(struct ZToken64 * this);
static long GetLineNumber__1qwb(struct ZToken64 * this);
static const char * GetChar__1qwb(struct ZToken64 * this);
static const char * GetText__1qwb(struct ZToken64 * this);
static const char * toString__1qwb(struct ZToken64 * this);
static int EqualsText__2qwb(struct ZToken64 * this, const char * Text__1);
static int StartsWith__2qwb(struct ZToken64 * this, const char * Text__1);
static int IsNull__1qwb(struct ZToken64 * this);
static int IsIndent__1qwb(struct ZToken64 * this);
static int IsNextWhiteSpace__1qwb(struct ZToken64 * this);
static int IsNameSymbol__1qwb(struct ZToken64 * this);
static long GetIndentSize__1qwb(struct ZToken64 * this);
static struct ZTokenContext50 * ZTokenContext__6qwd(struct ZTokenContext50 * this, struct ZGenerator52 * Generator__1, struct ZNameSpace43 * NameSpace__2, const char * FileName__3, long LineNumber__4, const char * SourceText__5);
static int SetParseFlag__2qwd(struct ZTokenContext50 * this, int AllowSkipIndent__1);
static struct ZToken64 * GetBeforeToken__1qwd(struct ZTokenContext50 * this);
static struct ZNode49 * CreateExpectedErrorNode__3qwd(struct ZTokenContext50 * this, struct ZToken64 * SourceToken__1, const char * ExpectedTokenText__2);
static void Vacume__1qwd(struct ZTokenContext50 * this);
static void MoveNext__1qwd(struct ZTokenContext50 * this);
static struct ZToken64 * GetToken__2qwd(struct ZTokenContext50 * this, int EnforceMoveNext__1);
static struct ZToken64 * GetToken__1qwd(struct ZTokenContext50 * this);
static int HasNext__1qwd(struct ZTokenContext50 * this);
static void SkipIndent__1qwd(struct ZTokenContext50 * this);
static void SkipError__2qwd(struct ZTokenContext50 * this, struct ZToken64 * ErrorToken__1);
static int IsToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1);
static int IsNewLineToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1);
static int MatchToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1);
static int MatchNewLineToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1);
static struct ZToken64 * ParseLargeToken__1qwd(struct ZTokenContext50 * this);
static struct ZNode49 * MatchToken__4qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, const char * TokenText__2, int IsRequired__3);
static struct ZSyntax184 * GetApplyingSyntax__1qwd(struct ZTokenContext50 * this);
static struct ZNode49 * ApplyMatchPattern__5qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * LeftNode__2, struct ZSyntax184 * Pattern__3, int IsRequired__4);
static struct ZNode49 * ParsePatternAfter__5qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * LeftNode__2, const char * PatternName__3, int IsRequired__4);
static struct ZNode49 * ParsePattern__4qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, const char * PatternName__2, int IsRequired__3);
static struct ZNode49 * MatchPattern__6qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4, int AllowSkipIndent__5);
static struct ZNode49 * MatchPattern__5qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4);
static struct ZNode49 * MatchOptionaPattern__6qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, long Index__2, int AllowNewLine__3, const char * TokenText__4, const char * PatternName__5);
static struct ZNode49 * MatchNtimes__6qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, const char * StartToken__2, const char * PatternName__3, const char * DelimToken__4, const char * StopToken__5);
static int StartsWithToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1);
static void SkipEmptyStatement__1qwd(struct ZTokenContext50 * this);
static void Dump__1qwd(struct ZTokenContext50 * this);
static struct ZTokenFunc28 * ZTokenFunc__3qqb(struct ZTokenFunc28 * this, struct ZTokenFunction45 * Func__1, struct ZTokenFunc28 * Parent__2);
static const char * toString__1qqb(struct ZTokenFunc28 * this);
static struct ZVariable194 * ZVariable__7qyd(struct ZVariable194 * this, struct ZSymbolEntry189 * Parent__1, struct ZFunctionNode109 * FuncNode__2, long VarFlag__3, struct ZType59 * VarType__4, const char * VarName__5, struct ZToken64 * SourceToken__6);
static int IsCaptured__2qyd(struct ZVariable194 * this, struct ZFunctionNode109 * CurrentFunctionNode__1);
static void Defined__1qyd(struct ZVariable194 * this);
static void Used__1qyd(struct ZVariable194 * this);
static struct ZClassType63 * ZClassType__3qwv(struct ZClassType63 * this, const char * ShortName__1, struct ZType59 * RefType__2);
static void ResetSuperType__2qwv(struct ZClassType63 * this, struct ZClassType63 * SuperClass__1);
static long GetFieldSize__1qwv(struct ZClassType63 * this);
static struct ZClassField62 * GetFieldAt__2qwv(struct ZClassType63 * this, long Index__1);
static int HasField__2qwv(struct ZClassType63 * this, const char * FieldName__1);
static struct ZType59 * GetFieldType__3qwv(struct ZClassType63 * this, const char * FieldName__1, struct ZType59 * DefaultType__2);
static struct ZClassField62 * AppendField__4qwv(struct ZClassType63 * this, struct ZType59 * FieldType__1, const char * FieldName__2, struct ZToken64 * SourceToken__3);
static struct ZFuncType67 * ZFuncType__3qw7(struct ZFuncType67 * this, const char * ShortName__1, ArrayOfZType * UniqueTypeParams__2);
static int IsFuncType__1qw7(struct ZFuncType67 * this);
static int IsVarType__1qw7(struct ZFuncType67 * this);
#define _ZFuncType67_IsVarType
static int IsGreekType__1qw7(struct ZFuncType67 * this);
#define _ZFuncType67_IsGreekType
static struct ZType59 * GetGreekRealType__2qw7(struct ZFuncType67 * this, ArrayOfZType * Greek__1);
#define _ZFuncType67_GetGreekRealType
static int AcceptValueType__4qw7(struct ZFuncType67 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZFuncType67_AcceptValueType
static const char * StringfySignature__2qw7(struct ZFuncType67 * this, const char * FuncName__1);
static struct ZType59 * GetBaseType__1qw7(struct ZFuncType67 * this);
#define _ZFuncType67_GetBaseType
static long GetParamSize__1qw7(struct ZFuncType67 * this);
#define _ZFuncType67_GetParamSize
static struct ZType59 * GetParamType__2qw7(struct ZFuncType67 * this, long Index__1);
#define _ZFuncType67_GetParamType
static struct ZType59 * GetReturnType__1qw7(struct ZFuncType67 * this);
static long GetFuncParamSize__1qw7(struct ZFuncType67 * this);
static struct ZType59 * GetRecvType__1qw7(struct ZFuncType67 * this);
static struct ZType59 * GetFuncParamType__2qw7(struct ZFuncType67 * this, long Index__1);
static struct ZFuncType67 * NewMethodFuncType__2qw7(struct ZFuncType67 * this, struct ZType59 * RecvType__1);
static int AcceptAsFieldFunc__2qw7(struct ZFuncType67 * this, struct ZFuncType67 * FuncType__1);
static struct ZGeneric1Type282 * ZGeneric1Type__5qim(struct ZGeneric1Type282 * this, long TypeFlag__1, const char * ShortName__2, struct ZType59 * BaseType__3, struct ZType59 * ParamType__4);
static struct ZType59 * GetSuperType__1qim(struct ZGeneric1Type282 * this);
#define _ZGeneric1Type282_GetSuperType
static struct ZType59 * GetBaseType__1qim(struct ZGeneric1Type282 * this);
#define _ZGeneric1Type282_GetBaseType
static long GetParamSize__1qim(struct ZGeneric1Type282 * this);
#define _ZGeneric1Type282_GetParamSize
static struct ZType59 * GetParamType__2qim(struct ZGeneric1Type282 * this, long Index__1);
#define _ZGeneric1Type282_GetParamType
static int IsGreekType__1qim(struct ZGeneric1Type282 * this);
#define _ZGeneric1Type282_IsGreekType
static struct ZType59 * GetGreekRealType__2qim(struct ZGeneric1Type282 * this, ArrayOfZType * Greek__1);
#define _ZGeneric1Type282_GetGreekRealType
static int AcceptValueType__4qim(struct ZGeneric1Type282 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZGeneric1Type282_AcceptValueType
static struct ZGreekType290 * ZGreekType__2qoe(struct ZGreekType290 * this, long GreekId__1);
static int IsGreekType__1qoe(struct ZGreekType290 * this);
#define _ZGreekType290_IsGreekType
static struct ZType59 * GetGreekRealType__2qoe(struct ZGreekType290 * this, ArrayOfZType * Greek__1);
#define _ZGreekType290_GetGreekRealType
static int AcceptValueType__4qoe(struct ZGreekType290 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3);
#define _ZGreekType290_AcceptValueType
static struct ZAnnotationNode295 * ZAnnotationNode__4qoi(struct ZAnnotationNode295 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, MapOfObject * Anno__3);
static int IsBreakingBlock__1qoi(struct ZAnnotationNode295 * this);
#define _ZAnnotationNode295_IsBreakingBlock
static void Accept__2qoi(struct ZAnnotationNode295 * this, struct ZVisitor132 * Visitor__1);
#define _ZAnnotationNode295_Accept
static struct ZAssertNode301 * ZAssertNode__2qos(struct ZAssertNode301 * this, struct ZNode49 * ParentNode__1);
static struct ZSugarNode130 * DeSugar__2qos(struct ZAssertNode301 * this, struct ZGenerator52 * Generator__1);
#define _ZAssertNode301_DeSugar
static struct ZBinaryNode304 * ZBinaryNode__5qog(struct ZBinaryNode304 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4);
static int IsRightJoin__2qog(struct ZBinaryNode304 * this, struct ZNode49 * Node__1);
static struct ZNode49 * RightJoin__3qog(struct ZBinaryNode304 * this, struct ZNode49 * ParentNode__1, struct ZBinaryNode304 * RightNode__2);
static struct ZNode49 * AppendParsedRightNode__3qog(struct ZBinaryNode304 * this, struct ZNode49 * ParentNode__1, struct ZTokenContext50 * TokenContext__2);
static struct ZNode49 * TryMacroNode__2qog(struct ZBinaryNode304 * this, struct ZGenerator52 * Generator__1);
static void Accept__2qog(struct ZBinaryNode304 * this, struct ZVisitor132 * Visitor__1);
#define _ZBinaryNode304_Accept
static struct ZBreakNode311 * ZBreakNode__2qo6(struct ZBreakNode311 * this, struct ZNode49 * ParentNode__1);
static void Accept__2qo6(struct ZBreakNode311 * this, struct ZVisitor132 * Visitor__1);
#define _ZBreakNode311_Accept
static struct ZCastNode314 * ZCastNode__4qoc(struct ZCastNode314 * this, struct ZNode49 * ParentNode__1, struct ZType59 * CastType__2, struct ZNode49 * Node__3);
static void Accept__2qoc(struct ZCastNode314 * this, struct ZVisitor132 * Visitor__1);
#define _ZCastNode314_Accept
static struct ZListNode215 * ToFuncCallNode__2qoc(struct ZCastNode314 * this, struct ZFunc66 * Func__1);
static struct ZCatchNode318 * ZCatchNode__2qom(struct ZCatchNode318 * this, struct ZNode49 * ParentNode__1);
static void SetTypeInfo__3qom(struct ZCatchNode318 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZCatchNode318_SetTypeInfo
static void SetNameInfo__3qom(struct ZCatchNode318 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZCatchNode318_SetNameInfo
static struct ZComparatorNode322 * ZComparatorNode__5qo2(struct ZComparatorNode322 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4);
static void Accept__2qo2(struct ZComparatorNode322 * this, struct ZVisitor132 * Visitor__1);
#define _ZComparatorNode322_Accept
static struct ZConstNode325 * ZConstNode__3qpw(struct ZConstNode325 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2);
static struct ZEmptyNode327 * ZEmptyNode__3qpr(struct ZEmptyNode327 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2);
static struct ZErrorNode329 * ZErrorNode__4qpy(struct ZErrorNode329 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, const char * ErrorMessage__3);
static struct ZErrorNode329 * ZErrorNode__3qpy(struct ZErrorNode329 * this, struct ZNode49 * Node__1, const char * ErrorMessage__2);
static void Accept__2qpy(struct ZErrorNode329 * this, struct ZVisitor132 * Visitor__1);
#define _ZErrorNode329_Accept
static struct ZFieldNode333 * ZFieldNode__2qpp(struct ZFieldNode333 * this, struct ZNode49 * ParentNode__1);
static void SetTypeInfo__3qpp(struct ZFieldNode333 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZFieldNode333_SetTypeInfo
static void SetNameInfo__3qpp(struct ZFieldNode333 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZFieldNode333_SetNameInfo
static struct ZFloatNode337 * ZFloatNode__4qps(struct ZFloatNode337 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, double Value__3);
static void Accept__2qps(struct ZFloatNode337 * this, struct ZVisitor132 * Visitor__1);
#define _ZFloatNode337_Accept
static struct ZGetIndexNode340 * ZGetIndexNode__3qpg(struct ZGetIndexNode340 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2);
static void Accept__2qpg(struct ZGetIndexNode340 * this, struct ZVisitor132 * Visitor__1);
#define _ZGetIndexNode340_Accept
static struct ZGetNameNode343 * ZGetNameNode__4qpk(struct ZGetNameNode343 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, const char * NativeName__3);
static struct ZGetNameNode343 * ZGetNameNode__3qpk(struct ZGetNameNode343 * this, struct ZNode49 * ParentNode__1, struct ZFunc66 * ResolvedFunc__2);
static void Accept__2qpk(struct ZGetNameNode343 * this, struct ZVisitor132 * Visitor__1);
#define _ZGetNameNode343_Accept
static struct ZNode49 * ToGlobalNameNode__1qpk(struct ZGetNameNode343 * this);
static struct ZGetterNode348 * ZGetterNode__3qpz(struct ZGetterNode348 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2);
static void SetNameInfo__3qpz(struct ZGetterNode348 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZGetterNode348_SetNameInfo
static void Accept__2qpz(struct ZGetterNode348 * this, struct ZVisitor132 * Visitor__1);
#define _ZGetterNode348_Accept
static int IsStaticField__1qpz(struct ZGetterNode348 * this);
static struct ZGlobalNameNode353 * ZGlobalNameNode__6qpn(struct ZGlobalNameNode353 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZType59 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5);
static int IsGivenName__1qpn(struct ZGlobalNameNode353 * this);
static void Accept__2qpn(struct ZGlobalNameNode353 * this, struct ZVisitor132 * Visitor__1);
#define _ZGlobalNameNode353_Accept
static struct ZGroupNode357 * ZGroupNode__2qp3(struct ZGroupNode357 * this, struct ZNode49 * ParentNode__1);
static void Accept__2qp3(struct ZGroupNode357 * this, struct ZVisitor132 * Visitor__1);
#define _ZGroupNode357_Accept
static struct ZIfNode360 * ZIfNode__2q0q(struct ZIfNode360 * this, struct ZNode49 * ParentNode__1);
static void Accept__2q0q(struct ZIfNode360 * this, struct ZVisitor132 * Visitor__1);
#define _ZIfNode360_Accept
static struct ZImportNode363 * ZImportNode__2q0r(struct ZImportNode363 * this, struct ZNode49 * ParentNode__1);
static void SetNameInfo__3q0r(struct ZImportNode363 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZImportNode363_SetNameInfo
static struct ZInstanceOfNode366 * ZInstanceOfNode__4q0u(struct ZInstanceOfNode366 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, struct ZNode49 * LeftNode__3);
static void SetTypeInfo__3q0u(struct ZInstanceOfNode366 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZInstanceOfNode366_SetTypeInfo
static void Accept__2q0u(struct ZInstanceOfNode366 * this, struct ZVisitor132 * Visitor__1);
#define _ZInstanceOfNode366_Accept
static struct ZIntNode370 * ZIntNode__4q00(struct ZIntNode370 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, long Value__3);
static void Accept__2q00(struct ZIntNode370 * this, struct ZVisitor132 * Visitor__1);
#define _ZIntNode370_Accept
static struct ZLetNode373 * ZLetNode__2q0s(struct ZLetNode373 * this, struct ZNode49 * ParentNode__1);
static void SetNameInfo__3q0s(struct ZLetNode373 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZLetNode373_SetNameInfo
static void SetTypeInfo__3q0s(struct ZLetNode373 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZLetNode373_SetTypeInfo
static void Accept__2q0s(struct ZLetNode373 * this, struct ZVisitor132 * Visitor__1);
#define _ZLetNode373_Accept
static struct ZGlobalNameNode353 * ToGlobalNameNode__1q0s(struct ZLetNode373 * this);
static struct ZListNode215 * ZListNode__4qy8(struct ZListNode215 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, long Size__3);
static void Append__2qy8(struct ZListNode215 * this, struct ZNode49 * Node__1);
static long GetListSize__1qy8(struct ZListNode215 * this);
static struct ZNode49 * GetListAt__2qy8(struct ZListNode215 * this, long Index__1);
static void SetListAt__3qy8(struct ZListNode215 * this, long Index__1, struct ZNode49 * Node__2);
static void InsertListAt__3qy8(struct ZListNode215 * this, long Index__1, struct ZNode49 * Node__2);
static struct ZNode49 * RemoveListAt__2qy8(struct ZListNode215 * this, long Index__1);
static void ClearListAfter__2qy8(struct ZListNode215 * this, long Size__1);
static struct ZMacroNode385 * ZMacroNode__4q0x(struct ZMacroNode385 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZMacroFunc176 * MacroFunc__3);
static struct ZFuncType67 * GetFuncType__1q0x(struct ZMacroNode385 * this);
static const char * GetMacroText__1q0x(struct ZMacroNode385 * this);
static void Accept__2q0x(struct ZMacroNode385 * this, struct ZVisitor132 * Visitor__1);
#define _ZMacroNode385_Accept
static struct ZMapEntryNode390 * ZMapEntryNode__2q0m(struct ZMapEntryNode390 * this, struct ZNode49 * ParentNode__1);
static struct ZMapLiteralNode392 * ZMapLiteralNode__2q05(struct ZMapLiteralNode392 * this, struct ZNode49 * ParentNode__1);
static struct ZMapEntryNode390 * GetMapEntryNode__2q05(struct ZMapLiteralNode392 * this, long Index__1);
static void Accept__2q05(struct ZMapLiteralNode392 * this, struct ZVisitor132 * Visitor__1);
#define _ZMapLiteralNode392_Accept
static struct ZMethodCallNode396 * ZMethodCallNode__3q4q(struct ZMethodCallNode396 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2);
static void SetNameInfo__3q4q(struct ZMethodCallNode396 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZMethodCallNode396_SetNameInfo
static void Accept__2q4q(struct ZMethodCallNode396 * this, struct ZVisitor132 * Visitor__1);
#define _ZMethodCallNode396_Accept
static struct ZFuncCallNode400 * ToGetterFuncCall__1q4q(struct ZMethodCallNode396 * this);
static struct ZListNode215 * ToFuncCallNode__2q4q(struct ZMethodCallNode396 * this, struct ZFunc66 * Func__1);
static struct ZNewArrayNode403 * ZNewArrayNode__4q4i(struct ZNewArrayNode403 * this, struct ZNode49 * ParentNode__1, struct ZType59 * Type__2, struct ZToken64 * Token__3);
static struct ZNewObjectNode405 * ZNewObjectNode__2q4p(struct ZNewObjectNode405 * this, struct ZNode49 * ParentNode__1);
static void Accept__2q4p(struct ZNewObjectNode405 * this, struct ZVisitor132 * Visitor__1);
#define _ZNewObjectNode405_Accept
static struct ZListNode215 * ToFuncCallNode__2q4p(struct ZNewObjectNode405 * this, struct ZFunc66 * Func__1);
static struct ZNotNode409 * ZNotNode__3q4s(struct ZNotNode409 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2);
static void Accept__2q4s(struct ZNotNode409 * this, struct ZVisitor132 * Visitor__1);
#define _ZNotNode409_Accept
static struct ZNullNode412 * ZNullNode__3q4g(struct ZNullNode412 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2);
static void Accept__2q4g(struct ZNullNode412 * this, struct ZVisitor132 * Visitor__1);
#define _ZNullNode412_Accept
static struct ZOrNode415 * ZOrNode__5q4k(struct ZOrNode415 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4);
static void Accept__2q4k(struct ZOrNode415 * this, struct ZVisitor132 * Visitor__1);
#define _ZOrNode415_Accept
static struct ZPrototypeNode418 * ZPrototypeNode__2q41(struct ZPrototypeNode418 * this, struct ZNode49 * ParentNode__1);
static void SetTypeInfo__3q41(struct ZPrototypeNode418 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZPrototypeNode418_SetTypeInfo
static void SetNameInfo__3q41(struct ZPrototypeNode418 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZPrototypeNode418_SetNameInfo
static struct ZParamNode137 * GetParamNode__2q41(struct ZPrototypeNode418 * this, long Index__1);
static struct ZFuncType67 * GetFuncType__1q41(struct ZPrototypeNode418 * this);
static struct ZStringNode424 * ZStringNode__4q4b(struct ZStringNode424 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, const char * Value__3);
static void Accept__2q4b(struct ZStringNode424 * this, struct ZVisitor132 * Visitor__1);
#define _ZStringNode424_Accept
static struct ZStupidCastErrorNode427 * ZStupidCastErrorNode__3q47(struct ZStupidCastErrorNode427 * this, struct ZNode49 * Node__1, const char * ErrorMessage__2);
static struct ZTypeNode199 * ZTypeNode__4qyk(struct ZTypeNode199 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZType59 * ParsedType__3);
static struct ZGenerator52 * ZGenerator__3qwg(struct ZGenerator52 * this, const char * LanguageExtension__1, const char * TargetVersion__2);
static void ImportLocalGrammar__2qwg(struct ZGenerator52 * this, struct ZNameSpace43 * NameSpace__1);
#define _ZGenerator52_ImportLocalGrammar
static void WriteTo__2qwg(struct ZGenerator52 * this, const char * FileName__1);
#define _ZGenerator52_WriteTo
static const char * NameOutputFile__2qwg(struct ZGenerator52 * this, const char * FileName__1);
#define _ZGenerator52_NameOutputFile
static void EnableVisitor__1qwg(struct ZGenerator52 * this);
#define _ZGenerator52_EnableVisitor
static void StopVisitor__1qwg(struct ZGenerator52 * this);
#define _ZGenerator52_StopVisitor
static int IsVisitable__1qwg(struct ZGenerator52 * this);
#define _ZGenerator52_IsVisitable
static const char * GetGrammarInfo__1qwg(struct ZGenerator52 * this);
static void AppendGrammarInfo__2qwg(struct ZGenerator52 * this, const char * GrammarInfo__1);
static const char * GetTargetLangInfo__1qwg(struct ZGenerator52 * this);
static struct ZType59 * GetFieldType__3qwg(struct ZGenerator52 * this, struct ZType59 * BaseType__1, const char * Name__2);
#define _ZGenerator52_GetFieldType
static struct ZType59 * GetSetterType__3qwg(struct ZGenerator52 * this, struct ZType59 * BaseType__1, const char * Name__2);
#define _ZGenerator52_GetSetterType
static struct ZFuncType67 * GetConstructorFuncType__3qwg(struct ZGenerator52 * this, struct ZType59 * ClassType__1, struct ZListNode215 * List__2);
#define _ZGenerator52_GetConstructorFuncType
static struct ZFuncType67 * GetMethodFuncType__4qwg(struct ZGenerator52 * this, struct ZType59 * RecvType__1, const char * MethodName__2, struct ZListNode215 * List__3);
#define _ZGenerator52_GetMethodFuncType
static long GetUniqueNumber__1qwg(struct ZGenerator52 * this);
static const char * NameGlobalSymbol__2qwg(struct ZGenerator52 * this, const char * Symbol__1);
static const char * NameClass__2qwg(struct ZGenerator52 * this, struct ZType59 * ClassType__1);
static void SetDefinedFunc__2qwg(struct ZGenerator52 * this, struct ZFunc66 * Func__1);
static struct ZPrototype74 * SetPrototype__4qwg(struct ZGenerator52 * this, struct ZNode49 * Node__1, const char * FuncName__2, struct ZFuncType67 * FuncType__3);
static struct ZFunc66 * GetDefinedFunc__2qwg(struct ZGenerator52 * this, const char * GlobalName__1);
static struct ZFunc66 * GetDefinedFunc__3qwg(struct ZGenerator52 * this, const char * FuncName__1, struct ZFuncType67 * FuncType__2);
static struct ZFunc66 * GetDefinedFunc__4qwg(struct ZGenerator52 * this, const char * FuncName__1, struct ZType59 * RecvType__2, long FuncParamSize__3);
static struct ZMacroFunc176 * GetMacroFunc__4qwg(struct ZGenerator52 * this, const char * FuncName__1, struct ZType59 * RecvType__2, long FuncParamSize__3);
static const char * NameConverterFunc__3qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2);
static void SetConverterFunc__4qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2, struct ZFunc66 * Func__3);
static struct ZFunc66 * GetConverterFunc__3qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2);
static struct ZFunc66 * GetCoercionFunc__3qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2);
static void VisitExtendedNode__2qwg(struct ZGenerator52 * this, struct ZNode49 * Node__1);
#define _ZGenerator52_VisitExtendedNode
static void VisitSugarNode__2qwg(struct ZGenerator52 * this, struct ZSugarNode130 * Node__1);
#define _ZGenerator52_VisitSugarNode
static struct ZIndentToken453 * ZIndentToken__4qa9(struct ZIndentToken453 * this, struct ZSource202 * Source__1, long StartIndex__2, long EndIndex__3);
static struct ZPatternToken455 * ZPatternToken__5qa6(struct ZPatternToken455 * this, struct ZSource202 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax184 * PresetPattern__4);
static struct ZSourceEngine54 * ZSourceEngine__3qwj(struct ZSourceEngine54 * this, struct ZTypeChecker106 * TypeChecker__1, struct ZGenerator52 * Generator__2);
static int IsVisitable__1qwj(struct ZSourceEngine54 * this);
#define _ZSourceEngine54_IsVisitable
static void EnableVisitor__1qwj(struct ZSourceEngine54 * this);
#define _ZSourceEngine54_EnableVisitor
static void StopVisitor__1qwj(struct ZSourceEngine54 * this);
#define _ZSourceEngine54_StopVisitor
static struct Object296 * Eval__2qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1);
static void VisitPrototypeNode__2qwj(struct ZSourceEngine54 * this, struct ZPrototypeNode418 * Node__1);
static void VisitImportNode__2qwj(struct ZSourceEngine54 * this, struct ZImportNode363 * Node__1);
static struct Object296 * Exec__3qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1, int IsInteractive__2);
static struct Object296 * Eval__6qwj(struct ZSourceEngine54 * this, struct ZNameSpace43 * NameSpace__1, const char * ScriptText__2, const char * FileName__3, long LineNumber__4, int IsInteractive__5);
static struct Object296 * Eval__5qwj(struct ZSourceEngine54 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3, int IsInteractive__4);
static int Load__2qwj(struct ZSourceEngine54 * this, const char * FileName__1);
static void Unsupported__2qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1);
static void VisitNullNode__2qwj(struct ZSourceEngine54 * this, struct ZNullNode412 * Node__1);
#define _ZSourceEngine54_VisitNullNode
static void VisitBooleanNode__2qwj(struct ZSourceEngine54 * this, struct ZBooleanNode469 * Node__1);
#define _ZSourceEngine54_VisitBooleanNode
static void VisitIntNode__2qwj(struct ZSourceEngine54 * this, struct ZIntNode370 * Node__1);
#define _ZSourceEngine54_VisitIntNode
static void VisitFloatNode__2qwj(struct ZSourceEngine54 * this, struct ZFloatNode337 * Node__1);
#define _ZSourceEngine54_VisitFloatNode
static void VisitStringNode__2qwj(struct ZSourceEngine54 * this, struct ZStringNode424 * Node__1);
#define _ZSourceEngine54_VisitStringNode
static void VisitArrayLiteralNode__2qwj(struct ZSourceEngine54 * this, struct ZArrayLiteralNode474 * Node__1);
#define _ZSourceEngine54_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qwj(struct ZSourceEngine54 * this, struct ZMapLiteralNode392 * Node__1);
#define _ZSourceEngine54_VisitMapLiteralNode
static void VisitNewObjectNode__2qwj(struct ZSourceEngine54 * this, struct ZNewObjectNode405 * Node__1);
#define _ZSourceEngine54_VisitNewObjectNode
static void VisitGlobalNameNode__2qwj(struct ZSourceEngine54 * this, struct ZGlobalNameNode353 * Node__1);
#define _ZSourceEngine54_VisitGlobalNameNode
static void VisitGetNameNode__2qwj(struct ZSourceEngine54 * this, struct ZGetNameNode343 * Node__1);
#define _ZSourceEngine54_VisitGetNameNode
static void VisitSetNameNode__2qwj(struct ZSourceEngine54 * this, struct ZSetNameNode146 * Node__1);
#define _ZSourceEngine54_VisitSetNameNode
static void VisitGroupNode__2qwj(struct ZSourceEngine54 * this, struct ZGroupNode357 * Node__1);
#define _ZSourceEngine54_VisitGroupNode
static void VisitGetterNode__2qwj(struct ZSourceEngine54 * this, struct ZGetterNode348 * Node__1);
#define _ZSourceEngine54_VisitGetterNode
static void VisitSetterNode__2qwj(struct ZSourceEngine54 * this, struct ZSetterNode149 * Node__1);
#define _ZSourceEngine54_VisitSetterNode
static void VisitGetIndexNode__2qwj(struct ZSourceEngine54 * this, struct ZGetIndexNode340 * Node__1);
#define _ZSourceEngine54_VisitGetIndexNode
static void VisitSetIndexNode__2qwj(struct ZSourceEngine54 * this, struct ZSetIndexNode143 * Node__1);
#define _ZSourceEngine54_VisitSetIndexNode
static void VisitMacroNode__2qwj(struct ZSourceEngine54 * this, struct ZMacroNode385 * Node__1);
#define _ZSourceEngine54_VisitMacroNode
static void VisitFuncCallNode__2qwj(struct ZSourceEngine54 * this, struct ZFuncCallNode400 * Node__1);
#define _ZSourceEngine54_VisitFuncCallNode
static void VisitMethodCallNode__2qwj(struct ZSourceEngine54 * this, struct ZMethodCallNode396 * Node__1);
#define _ZSourceEngine54_VisitMethodCallNode
static void VisitUnaryNode__2qwj(struct ZSourceEngine54 * this, struct ZUnaryNode162 * Node__1);
#define _ZSourceEngine54_VisitUnaryNode
static void VisitNotNode__2qwj(struct ZSourceEngine54 * this, struct ZNotNode409 * Node__1);
#define _ZSourceEngine54_VisitNotNode
static void VisitCastNode__2qwj(struct ZSourceEngine54 * this, struct ZCastNode314 * Node__1);
#define _ZSourceEngine54_VisitCastNode
static void VisitInstanceOfNode__2qwj(struct ZSourceEngine54 * this, struct ZInstanceOfNode366 * Node__1);
#define _ZSourceEngine54_VisitInstanceOfNode
static void VisitBinaryNode__2qwj(struct ZSourceEngine54 * this, struct ZBinaryNode304 * Node__1);
#define _ZSourceEngine54_VisitBinaryNode
static void VisitComparatorNode__2qwj(struct ZSourceEngine54 * this, struct ZComparatorNode322 * Node__1);
#define _ZSourceEngine54_VisitComparatorNode
static void VisitAndNode__2qwj(struct ZSourceEngine54 * this, struct ZAndNode495 * Node__1);
#define _ZSourceEngine54_VisitAndNode
static void VisitOrNode__2qwj(struct ZSourceEngine54 * this, struct ZOrNode415 * Node__1);
#define _ZSourceEngine54_VisitOrNode
static void VisitBlockNode__2qwj(struct ZSourceEngine54 * this, struct ZBlockNode126 * Node__1);
#define _ZSourceEngine54_VisitBlockNode
static void VisitVarNode__2qwj(struct ZSourceEngine54 * this, struct ZVarNode499 * Node__1);
#define _ZSourceEngine54_VisitVarNode
static void VisitIfNode__2qwj(struct ZSourceEngine54 * this, struct ZIfNode360 * Node__1);
#define _ZSourceEngine54_VisitIfNode
static void VisitReturnNode__2qwj(struct ZSourceEngine54 * this, struct ZReturnNode135 * Node__1);
#define _ZSourceEngine54_VisitReturnNode
static void VisitWhileNode__2qwj(struct ZSourceEngine54 * this, struct ZWhileNode165 * Node__1);
#define _ZSourceEngine54_VisitWhileNode
static void VisitBreakNode__2qwj(struct ZSourceEngine54 * this, struct ZBreakNode311 * Node__1);
#define _ZSourceEngine54_VisitBreakNode
static void VisitThrowNode__2qwj(struct ZSourceEngine54 * this, struct ZThrowNode156 * Node__1);
#define _ZSourceEngine54_VisitThrowNode
static void VisitTryNode__2qwj(struct ZSourceEngine54 * this, struct ZTryNode159 * Node__1);
#define _ZSourceEngine54_VisitTryNode
static void VisitLetNode__2qwj(struct ZSourceEngine54 * this, struct ZLetNode373 * Node__1);
#define _ZSourceEngine54_VisitLetNode
static void VisitFunctionNode__2qwj(struct ZSourceEngine54 * this, struct ZFunctionNode109 * Node__1);
#define _ZSourceEngine54_VisitFunctionNode
static void VisitClassNode__2qwj(struct ZSourceEngine54 * this, struct ZClassNode509 * Node__1);
#define _ZSourceEngine54_VisitClassNode
static void VisitErrorNode__2qwj(struct ZSourceEngine54 * this, struct ZErrorNode329 * Node__1);
#define _ZSourceEngine54_VisitErrorNode
static void VisitTypeNode__2qwj(struct ZSourceEngine54 * this, struct ZTypeNode199 * Node__1);
static void VisitExtendedNode__2qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1);
#define _ZSourceEngine54_VisitExtendedNode
static void VisitSugarNode__2qwj(struct ZSourceEngine54 * this, struct ZSugarNode130 * Node__1);
#define _ZSourceEngine54_VisitSugarNode
static void WriteTo__2qwj(struct ZSourceEngine54 * this, const char * OutputFile__1);
static struct ZSourceGenerator207 * ZSourceGenerator__3qyv(struct ZSourceGenerator207 * this, const char * TargetCode__1, const char * TargetVersion__2);
static void InitBuilderList__1qyv(struct ZSourceGenerator207 * this);
#define _ZSourceGenerator207_InitBuilderList
static struct ZSourceEngine54 * GetEngine__1qyv(struct ZSourceGenerator207 * this);
#define _ZSourceGenerator207_GetEngine
static struct ZSourceBuilder37 * AppendNewSourceBuilder__1qyv(struct ZSourceGenerator207 * this);
static struct ZSourceBuilder37 * InsertNewSourceBuilder__1qyv(struct ZSourceGenerator207 * this);
static void SetNativeType__3qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1, const char * TypeName__2);
static const char * GetNativeType__2qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1);
static void SetReservedName__3qyv(struct ZSourceGenerator207 * this, const char * Keyword__1, const char * AnotherName__2);
static const char * SafeName__3qyv(struct ZSourceGenerator207 * this, const char * Name__1, long Index__2);
static void SetMacro__4qyv(struct ZSourceGenerator207 * this, const char * FuncName__1, const char * Macro__2, struct ZType59 * ReturnType__3);
static void SetMacro__5qyv(struct ZSourceGenerator207 * this, const char * FuncName__1, const char * Macro__2, struct ZType59 * ReturnType__3, struct ZType59 * P1__4);
static void SetMacro__6qyv(struct ZSourceGenerator207 * this, const char * FuncName__1, const char * Macro__2, struct ZType59 * ReturnType__3, struct ZType59 * P1__4, struct ZType59 * P2__5);
static void SetConverterMacro__4qyv(struct ZSourceGenerator207 * this, const char * Macro__1, struct ZType59 * ReturnType__2, struct ZType59 * P1__3);
static void WriteTo__2qyv(struct ZSourceGenerator207 * this, const char * FileName__1);
#define _ZSourceGenerator207_WriteTo
static int StartCodeGeneration__3qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1, int IsInteractive__2);
#define _ZSourceGenerator207_StartCodeGeneration
static void GenerateCode__3qyv(struct ZSourceGenerator207 * this, struct ZType59 * ContextType__1, struct ZNode49 * Node__2);
#define _ZSourceGenerator207_GenerateCode
static int IsNeededSurroud__2qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1);
static void GenerateSurroundCode__2qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1);
static void AppendCode__2qyv(struct ZSourceGenerator207 * this, const char * RawSource__1);
static void VisitStmtList__2qyv(struct ZSourceGenerator207 * this, struct ZBlockNode126 * BlockNode__1);
static void VisitBlockNode__2qyv(struct ZSourceGenerator207 * this, struct ZBlockNode126 * Node__1);
#define _ZSourceGenerator207_VisitBlockNode
static void VisitNullNode__2qyv(struct ZSourceGenerator207 * this, struct ZNullNode412 * Node__1);
#define _ZSourceGenerator207_VisitNullNode
static void VisitBooleanNode__2qyv(struct ZSourceGenerator207 * this, struct ZBooleanNode469 * Node__1);
#define _ZSourceGenerator207_VisitBooleanNode
static void VisitIntNode__2qyv(struct ZSourceGenerator207 * this, struct ZIntNode370 * Node__1);
#define _ZSourceGenerator207_VisitIntNode
static void VisitFloatNode__2qyv(struct ZSourceGenerator207 * this, struct ZFloatNode337 * Node__1);
#define _ZSourceGenerator207_VisitFloatNode
static void VisitStringNode__2qyv(struct ZSourceGenerator207 * this, struct ZStringNode424 * Node__1);
#define _ZSourceGenerator207_VisitStringNode
static void VisitArrayLiteralNode__2qyv(struct ZSourceGenerator207 * this, struct ZArrayLiteralNode474 * Node__1);
#define _ZSourceGenerator207_VisitArrayLiteralNode
static void VisitMapLiteralNode__2qyv(struct ZSourceGenerator207 * this, struct ZMapLiteralNode392 * Node__1);
#define _ZSourceGenerator207_VisitMapLiteralNode
static void VisitNewObjectNode__2qyv(struct ZSourceGenerator207 * this, struct ZNewObjectNode405 * Node__1);
#define _ZSourceGenerator207_VisitNewObjectNode
static void VisitGroupNode__2qyv(struct ZSourceGenerator207 * this, struct ZGroupNode357 * Node__1);
#define _ZSourceGenerator207_VisitGroupNode
static void VisitGetIndexNode__2qyv(struct ZSourceGenerator207 * this, struct ZGetIndexNode340 * Node__1);
#define _ZSourceGenerator207_VisitGetIndexNode
static void VisitSetIndexNode__2qyv(struct ZSourceGenerator207 * this, struct ZSetIndexNode143 * Node__1);
#define _ZSourceGenerator207_VisitSetIndexNode
static void VisitGlobalNameNode__2qyv(struct ZSourceGenerator207 * this, struct ZGlobalNameNode353 * Node__1);
#define _ZSourceGenerator207_VisitGlobalNameNode
static void VisitGetNameNode__2qyv(struct ZSourceGenerator207 * this, struct ZGetNameNode343 * Node__1);
#define _ZSourceGenerator207_VisitGetNameNode
static void VisitSetNameNode__2qyv(struct ZSourceGenerator207 * this, struct ZSetNameNode146 * Node__1);
#define _ZSourceGenerator207_VisitSetNameNode
static void VisitGetterNode__2qyv(struct ZSourceGenerator207 * this, struct ZGetterNode348 * Node__1);
#define _ZSourceGenerator207_VisitGetterNode
static void VisitSetterNode__2qyv(struct ZSourceGenerator207 * this, struct ZSetterNode149 * Node__1);
#define _ZSourceGenerator207_VisitSetterNode
static void VisitMethodCallNode__2qyv(struct ZSourceGenerator207 * this, struct ZMethodCallNode396 * Node__1);
#define _ZSourceGenerator207_VisitMethodCallNode
static void VisitMacroNode__2qyv(struct ZSourceGenerator207 * this, struct ZMacroNode385 * Node__1);
#define _ZSourceGenerator207_VisitMacroNode
static void VisitFuncCallNode__2qyv(struct ZSourceGenerator207 * this, struct ZFuncCallNode400 * Node__1);
#define _ZSourceGenerator207_VisitFuncCallNode
static void VisitUnaryNode__2qyv(struct ZSourceGenerator207 * this, struct ZUnaryNode162 * Node__1);
#define _ZSourceGenerator207_VisitUnaryNode
static void VisitNotNode__2qyv(struct ZSourceGenerator207 * this, struct ZNotNode409 * Node__1);
#define _ZSourceGenerator207_VisitNotNode
static void VisitCastNode__2qyv(struct ZSourceGenerator207 * this, struct ZCastNode314 * Node__1);
#define _ZSourceGenerator207_VisitCastNode
static void VisitInstanceOfNode__2qyv(struct ZSourceGenerator207 * this, struct ZInstanceOfNode366 * Node__1);
#define _ZSourceGenerator207_VisitInstanceOfNode
static void VisitBinaryNode__2qyv(struct ZSourceGenerator207 * this, struct ZBinaryNode304 * Node__1);
#define _ZSourceGenerator207_VisitBinaryNode
static void VisitComparatorNode__2qyv(struct ZSourceGenerator207 * this, struct ZComparatorNode322 * Node__1);
#define _ZSourceGenerator207_VisitComparatorNode
static void VisitAndNode__2qyv(struct ZSourceGenerator207 * this, struct ZAndNode495 * Node__1);
#define _ZSourceGenerator207_VisitAndNode
static void VisitOrNode__2qyv(struct ZSourceGenerator207 * this, struct ZOrNode415 * Node__1);
#define _ZSourceGenerator207_VisitOrNode
static void VisitIfNode__2qyv(struct ZSourceGenerator207 * this, struct ZIfNode360 * Node__1);
#define _ZSourceGenerator207_VisitIfNode
static void VisitReturnNode__2qyv(struct ZSourceGenerator207 * this, struct ZReturnNode135 * Node__1);
#define _ZSourceGenerator207_VisitReturnNode
static void VisitWhileNode__2qyv(struct ZSourceGenerator207 * this, struct ZWhileNode165 * Node__1);
#define _ZSourceGenerator207_VisitWhileNode
static void VisitBreakNode__2qyv(struct ZSourceGenerator207 * this, struct ZBreakNode311 * Node__1);
#define _ZSourceGenerator207_VisitBreakNode
static void VisitThrowNode__2qyv(struct ZSourceGenerator207 * this, struct ZThrowNode156 * Node__1);
#define _ZSourceGenerator207_VisitThrowNode
static void VisitTryNode__2qyv(struct ZSourceGenerator207 * this, struct ZTryNode159 * Node__1);
#define _ZSourceGenerator207_VisitTryNode
static void VisitCatchNode__2qyv(struct ZSourceGenerator207 * this, struct ZCatchNode318 * Node__1);
static void VisitVarNode__2qyv(struct ZSourceGenerator207 * this, struct ZVarNode499 * Node__1);
#define _ZSourceGenerator207_VisitVarNode
static void VisitTypeAnnotation__2qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1);
static void VisitLetNode__2qyv(struct ZSourceGenerator207 * this, struct ZLetNode373 * Node__1);
#define _ZSourceGenerator207_VisitLetNode
static void VisitParamNode__2qyv(struct ZSourceGenerator207 * this, struct ZParamNode137 * Node__1);
static void VisitFunctionNode__2qyv(struct ZSourceGenerator207 * this, struct ZFunctionNode109 * Node__1);
#define _ZSourceGenerator207_VisitFunctionNode
static void VisitClassNode__2qyv(struct ZSourceGenerator207 * this, struct ZClassNode509 * Node__1);
#define _ZSourceGenerator207_VisitClassNode
static void VisitErrorNode__2qyv(struct ZSourceGenerator207 * this, struct ZErrorNode329 * Node__1);
#define _ZSourceGenerator207_VisitErrorNode
static void VisitExtendedNode__2qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1);
#define _ZSourceGenerator207_VisitExtendedNode
static void VisitSugarNode__2qyv(struct ZSourceGenerator207 * this, struct ZSugarNode130 * Node__1);
#define _ZSourceGenerator207_VisitSugarNode
static void GenerateTypeName__2qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1);
static void VisitListNode__5qyv(struct ZSourceGenerator207 * this, const char * OpenToken__1, struct ZListNode215 * VargNode__2, const char * DelimToken__3, const char * CloseToken__4);
static void VisitListNode__4qyv(struct ZSourceGenerator207 * this, const char * OpenToken__1, struct ZListNode215 * VargNode__2, const char * CloseToken__3);
static struct ZTypeChecker106 * ZTypeChecker__2qe2(struct ZTypeChecker106 * this, struct ZGenerator52 * Generator__1);
static void EnableVisitor__1qe2(struct ZTypeChecker106 * this);
#define _ZTypeChecker106_EnableVisitor
static void StopVisitor__1qe2(struct ZTypeChecker106 * this);
#define _ZTypeChecker106_StopVisitor
static int IsVisitable__1qe2(struct ZTypeChecker106 * this);
#define _ZTypeChecker106_IsVisitable
static struct ZType59 * GetContextType__1qe2(struct ZTypeChecker106 * this);
static struct ZNode49 * VisitTypeChecker__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2);
static struct ZNode49 * CreateStupidCastNode__3qe2(struct ZTypeChecker106 * this, struct ZType59 * Requested__1, struct ZNode49 * Node__2);
static struct ZNode49 * EnforceNodeType__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * EnforceType__2);
static struct ZNode49 * TypeCheckImpl__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2, long TypeCheckPolicy__3);
static struct ZNode49 * VisitTypeChecker__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2, long TypeCheckPolicy__3);
static struct ZNode49 * TryType__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2);
static void TryTypeAt__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, long Index__2, struct ZType59 * ContextType__3);
static struct ZNode49 * CheckType__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2);
static void CheckTypeAt__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, long Index__2, struct ZType59 * ContextType__3);
static int TypeCheckNodeList__2qe2(struct ZTypeChecker106 * this, struct ZListNode215 * List__1);
static void Return__2qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1);
static void TypedNode__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * Type__2);
static void ReturnErrorNode__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZToken64 * ErrorToken__2, const char * Message__3);
static void VisitErrorNode__2qe2(struct ZTypeChecker106 * this, struct ZErrorNode329 * Node__1);
#define _ZTypeChecker106_VisitErrorNode
static void VisitExtendedNode__2qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1);
#define _ZTypeChecker106_VisitExtendedNode
static void VisitSugarNode__2qe2(struct ZTypeChecker106 * this, struct ZSugarNode130 * Node__1);
#define _ZTypeChecker106_VisitSugarNode
static struct ZArrayType591 * ZArrayType__3qgf(struct ZArrayType591 * this, long TypeFlag__1, struct ZType59 * ParamType__2);
static struct ZAndNode495 * ZAndNode__5qsv(struct ZAndNode495 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4);
static void Accept__2qsv(struct ZAndNode495 * this, struct ZVisitor132 * Visitor__1);
#define _ZAndNode495_Accept
static struct ZArrayLiteralNode474 * ZArrayLiteralNode__2qsu(struct ZArrayLiteralNode474 * this, struct ZNode49 * ParentNode__1);
static void Accept__2qsu(struct ZArrayLiteralNode474 * this, struct ZVisitor132 * Visitor__1);
#define _ZArrayLiteralNode474_Accept
static struct ZBlockNode126 * ZBlockNode__2qrj(struct ZBlockNode126 * this, struct ZNameSpace43 * NameSpace__1);
static struct ZBlockNode126 * ZBlockNode__3qrj(struct ZBlockNode126 * this, struct ZNode49 * ParentNode__1, long Init__2);
static void Accept__2qrj(struct ZBlockNode126 * this, struct ZVisitor132 * Visitor__1);
#define _ZBlockNode126_Accept
static struct ZReturnNode135 * ToReturnNode__1qrj(struct ZBlockNode126 * this);
static long IndexOf__2qrj(struct ZBlockNode126 * this, struct ZNode49 * ChildNode__1);
static void CopyTo__3qrj(struct ZBlockNode126 * this, long Index__1, struct ZBlockNode126 * BlockNode__2);
static struct ZBooleanNode469 * ZBooleanNode__4qsw(struct ZBooleanNode469 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, int Value__3);
static void Accept__2qsw(struct ZBooleanNode469 * this, struct ZVisitor132 * Visitor__1);
#define _ZBooleanNode469_Accept
static struct ZClassNode509 * ZClassNode__2qdy(struct ZClassNode509 * this, struct ZNode49 * ParentNode__1);
static void SetTypeInfo__3qdy(struct ZClassNode509 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZClassNode509_SetTypeInfo
static void SetNameInfo__3qdy(struct ZClassNode509 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZClassNode509_SetNameInfo
static struct ZFieldNode333 * GetFieldNode__2qdy(struct ZClassNode509 * this, long Index__1);
static void Accept__2qdy(struct ZClassNode509 * this, struct ZVisitor132 * Visitor__1);
#define _ZClassNode509_Accept
static struct ZFuncCallNode400 * ZFuncCallNode__3q4t(struct ZFuncCallNode400 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * FuncNode__2);
static struct ZFuncCallNode400 * ZFuncCallNode__4q4t(struct ZFuncCallNode400 * this, struct ZNode49 * ParentNode__1, const char * FuncName__2, struct ZType59 * FuncType__3);
static void Accept__2q4t(struct ZFuncCallNode400 * this, struct ZVisitor132 * Visitor__1);
#define _ZFuncCallNode400_Accept
static struct ZType59 * GetRecvType__1q4t(struct ZFuncCallNode400 * this);
static const char * GetFuncName__1q4t(struct ZFuncCallNode400 * this);
static struct ZFuncType67 * GetFuncType__1q4t(struct ZFuncCallNode400 * this);
static struct ZMacroNode385 * ToMacroNode__2q4t(struct ZFuncCallNode400 * this, struct ZMacroFunc176 * MacroFunc__1);
static struct ZFunctionNode109 * ZFunctionNode__2qrw(struct ZFunctionNode109 * this, struct ZNode49 * ParentNode__1);
static void SetTypeInfo__3qrw(struct ZFunctionNode109 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZFunctionNode109_SetTypeInfo
static void SetNameInfo__3qrw(struct ZFunctionNode109 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZFunctionNode109_SetNameInfo
static void Accept__2qrw(struct ZFunctionNode109 * this, struct ZVisitor132 * Visitor__1);
#define _ZFunctionNode109_Accept
static struct ZParamNode137 * GetParamNode__2qrw(struct ZFunctionNode109 * this, long Index__1);
static struct ZFuncType67 * GetFuncType__2qrw(struct ZFunctionNode109 * this, struct ZType59 * ContextType__1);
static const char * GetSignature__2qrw(struct ZFunctionNode109 * this, struct ZGenerator52 * Generator__1);
static struct ZFunctionNode109 * Push__2qrw(struct ZFunctionNode109 * this, struct ZFunctionNode109 * Parent__1);
static struct ZFunctionNode109 * Pop__1qrw(struct ZFunctionNode109 * this);
static int IsTopLevel__1qrw(struct ZFunctionNode109 * this);
static long GetVarIndex__1qrw(struct ZFunctionNode109 * this);
static struct ZVarNode499 * ZVarNode__2qs7(struct ZVarNode499 * this, struct ZNode49 * ParentNode__1);
static void SetNameInfo__3qs7(struct ZVarNode499 * this, struct ZToken64 * NameToken__1, const char * Name__2);
#define _ZVarNode499_SetNameInfo
static void SetTypeInfo__3qs7(struct ZVarNode499 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2);
#define _ZVarNode499_SetTypeInfo
static void Accept__2qs7(struct ZVarNode499 * this, struct ZVisitor132 * Visitor__1);
#define _ZVarNode499_Accept
static struct ZNode49 * AndPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * AnnotationPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ApplyPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ArrayLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * AssertPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * AssignPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * BinaryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static int BlockComment__1qw0(struct ZSourceContext46 * SourceContext);
static struct ZNode49 * BlockPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * BreakPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static int CLineComment__1qw0(struct ZSourceContext46 * SourceContext);
static struct ZNode49 * CastPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * CatchPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ClassPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ComparatorPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ExpressionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * FalsePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * FieldPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * FloatLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * FunctionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * GetIndexPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * GetterPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * GroupPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * IfPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * InstanceOfPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * IntLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * LetPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * MapEntryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * MapLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * MethodCallPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * NamePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static int NameToken__1qw0(struct ZSourceContext46 * SourceContext);
static int NewLineToken__1qw0(struct ZSourceContext46 * SourceContext);
static struct ZNode49 * NewObjectPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * NotPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * NullPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static int NumberLiteralToken__1qw0(struct ZSourceContext46 * SourceContext);
static int OperatorToken__1qw0(struct ZSourceContext46 * SourceContext);
static struct ZNode49 * OrPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ParamPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * PrototypePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ReturnPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * RightExpressionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * RightTypePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftTypeNode__2);
static struct ZNode49 * SetIndexPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * SetterPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * StatementEndPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * StatementPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * StringLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static int StringLiteralToken__1qw0(struct ZSourceContext46 * SourceContext);
static struct ZNode49 * SymbolExpressionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * SymbolStatementPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * ThrowPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * TruePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * TryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * TypeAnnotationPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * TypePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * UnaryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * VarPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static struct ZNode49 * WhilePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2);
static int WhiteSpaceToken__1qw0(struct ZSourceContext46 * SourceContext);

struct ZClassField62 {
	int _classId62;
	int _delta62;
	long FieldFlag;
	struct ZClassType63 * ClassType;
	struct ZType59 * FieldType;
	const char * FieldName;
	long FieldNativeIndex;
	struct ZToken64 * SourceToken;
	int _nextId;
};

static void _InitZClassField62(struct ZClassField62 * o) {
	o->_classId62 = 62;
	o->_delta62 = sizeof(struct ZClassField62) - sizeof(int);
	o->FieldFlag = 0;
	o->ClassType = NULL;
	o->FieldType = NULL;
	o->FieldName = NULL;
	o->FieldNativeIndex = 0;
	o->SourceToken = NULL;
	o->_nextId = 0;
}

static struct ZClassField62 * _NewZClassField62(void) {
	struct ZClassField62 *o = LibZen_Malloc(sizeof(struct ZClassField62));
	_InitZClassField62(o);
	return o;
}

struct ZFunc66 {
	int _classId66;
	int _delta66;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType67 * FuncType;
	int _nextId;
};

static void _InitZFunc66(struct ZFunc66 * o) {
	o->_classId66 = 66;
	o->_delta66 = sizeof(struct ZFunc66) - sizeof(int);
	o->FuncFlag = 0;
	o->FuncName = NULL;
	o->FuncType = NULL;
	o->_nextId = 0;
}

static struct ZFunc66 * _NewZFunc66(void) {
	struct ZFunc66 *o = LibZen_Malloc(sizeof(struct ZFunc66));
	_InitZFunc66(o);
	return o;
}

struct ZPrototype74 {
	int _classId66;
	int _delta66;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType67 * FuncType;
	int _classId74;
	int _delta74;
	long DefinedCount;
	long UsedCount;
	int _nextId;
};

static void _InitZPrototype74(struct ZPrototype74 * o) {
	_InitZFunc66((struct ZFunc66 *)o);
	o->_classId74 = 74;
	o->_delta74 = sizeof(struct ZPrototype74) - sizeof(struct ZFunc66);
	o->DefinedCount = 0;
	o->UsedCount = 0;
	o->_nextId = 0;
}

static struct ZPrototype74 * _NewZPrototype74(void) {
	struct ZPrototype74 *o = LibZen_Malloc(sizeof(struct ZPrototype74));
	_InitZPrototype74(o);
	return o;
}

struct ZType59 {
	int _classId59;
	int _delta59;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType59 * RefType;
	struct ZType59 * (*)(struct ZType59 *) GetRealType;
	struct ZType59 * (*)(struct ZType59 *) GetSuperType;
	struct ZType59 * (*)(struct ZType59 *) GetBaseType;
	long (*)(struct ZType59 *) GetParamSize;
	struct ZType59 * (*)(struct ZType59 *,long) GetParamType;
	int (*)(struct ZType59 *) IsGreekType;
	struct ZType59 * (*)(struct ZType59 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType59 *,struct ZType59 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType59 *) IsVarType;
	int _nextId;
};

static void _InitZType59(struct ZType59 * o) {
	o->_classId59 = 59;
	o->_delta59 = sizeof(struct ZType59) - sizeof(int);
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
#ifdef _ZType59_GetRealType
	o->GetRealType = GetRealType__1qw6
#endif
#ifdef _ZType59_GetSuperType
	o->GetSuperType = GetSuperType__1qw6
#endif
#ifdef _ZType59_GetBaseType
	o->GetBaseType = GetBaseType__1qw6
#endif
#ifdef _ZType59_GetParamSize
	o->GetParamSize = GetParamSize__1qw6
#endif
#ifdef _ZType59_GetParamType
	o->GetParamType = GetParamType__2qw6
#endif
#ifdef _ZType59_IsGreekType
	o->IsGreekType = IsGreekType__1qw6
#endif
#ifdef _ZType59_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qw6
#endif
#ifdef _ZType59_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qw6
#endif
#ifdef _ZType59_IsVarType
	o->IsVarType = IsVarType__1qw6
#endif
	o->_nextId = 0;
}

static struct ZType59 * _NewZType59(void) {
	struct ZType59 *o = LibZen_Malloc(sizeof(struct ZType59));
	_InitZType59(o);
	return o;
}

struct ZTypePool635 {
	int _classId635;
	int _delta635;
	int _nextId;
};

static void _InitZTypePool635(struct ZTypePool635 * o) {
	o->_classId635 = 635;
	o->_delta635 = sizeof(struct ZTypePool635) - sizeof(int);
	o->_nextId = 0;
}

static struct ZTypePool635 * _NewZTypePool635(void) {
	struct ZTypePool635 *o = LibZen_Malloc(sizeof(struct ZTypePool635));
	_InitZTypePool635(o);
	return o;
}

struct ZVarScope98 {
	int _classId98;
	int _delta98;
	struct ZVarScope98 * Parent;
	struct ZLogger99 * Logger;
	ArrayOfZVarType * VarList;
	long VarNodeCount;
	long UnresolvedSymbolCount;
	int _nextId;
};

static void _InitZVarScope98(struct ZVarScope98 * o) {
	o->_classId98 = 98;
	o->_delta98 = sizeof(struct ZVarScope98) - sizeof(int);
	o->Parent = NULL;
	o->Logger = NULL;
	o->VarList = NULL;
	o->VarNodeCount = 0;
	o->UnresolvedSymbolCount = 0;
	o->_nextId = 0;
}

static struct ZVarScope98 * _NewZVarScope98(void) {
	struct ZVarScope98 *o = LibZen_Malloc(sizeof(struct ZVarScope98));
	_InitZVarScope98(o);
	return o;
}

struct ZVarType100 {
	int _classId59;
	int _delta59;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType59 * RefType;
	struct ZType59 * (*)(struct ZType59 *) GetRealType;
	struct ZType59 * (*)(struct ZType59 *) GetSuperType;
	struct ZType59 * (*)(struct ZType59 *) GetBaseType;
	long (*)(struct ZType59 *) GetParamSize;
	struct ZType59 * (*)(struct ZType59 *,long) GetParamType;
	int (*)(struct ZType59 *) IsGreekType;
	struct ZType59 * (*)(struct ZType59 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType59 *,struct ZType59 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType59 *) IsVarType;
	int _classId100;
	int _delta100;
	ArrayOfZVarType * VarList;
	struct ZToken64 * SourceToken;
	long GreekId;
	int _nextId;
};

static void _InitZVarType100(struct ZVarType100 * o) {
	_InitZType59((struct ZType59 *)o);
	o->_classId100 = 100;
	o->_delta100 = sizeof(struct ZVarType100) - sizeof(struct ZType59);
	o->VarList = NULL;
	o->SourceToken = NULL;
	o->GreekId = 0;
#ifdef _ZVarType100_GetRealType
	o->GetRealType = GetRealType__1qeb
#endif
#ifdef _ZVarType100_GetSuperType
	o->GetSuperType = GetSuperType__1qeb
#endif
#ifdef _ZVarType100_GetBaseType
	o->GetBaseType = GetBaseType__1qeb
#endif
#ifdef _ZVarType100_GetParamSize
	o->GetParamSize = GetParamSize__1qeb
#endif
#ifdef _ZVarType100_GetParamType
	o->GetParamType = GetParamType__2qeb
#endif
#ifdef _ZVarType100_IsGreekType
	o->IsGreekType = IsGreekType__1qeb
#endif
#ifdef _ZVarType100_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qeb
#endif
#ifdef _ZVarType100_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qeb
#endif
#ifdef _ZVarType100_IsVarType
	o->IsVarType = IsVarType__1qeb
#endif
	o->_nextId = 0;
}

static struct ZVarType100 * _NewZVarType100(void) {
	struct ZVarType100 *o = LibZen_Malloc(sizeof(struct ZVarType100));
	_InitZVarType100(o);
	return o;
}

struct ZNode49 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _nextId;
};

static void _InitZNode49(struct ZNode49 * o) {
	o->_classId49 = 49;
	o->_delta49 = sizeof(struct ZNode49) - sizeof(int);
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
#ifdef _ZNode49_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qws
#endif
#ifdef _ZNode49_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qws
#endif
#ifdef _ZNode49_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qws
#endif
#ifdef _ZNode49_DeSugar
	o->DeSugar = DeSugar__2qws
#endif
#ifdef _ZNode49_Accept
	o->Accept = Accept__2qws
#endif
	o->_nextId = 0;
}

static struct ZNode49 * _NewZNode49(void) {
	struct ZNode49 *o = LibZen_Malloc(sizeof(struct ZNode49));
	_InitZNode49(o);
	return o;
}

struct ZParamNode137 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId137;
	int _delta137;
	const char * Name;
	struct ZToken64 * NameToken;
	long ParamIndex;
	int _nextId;
};

static void _InitZParamNode137(struct ZParamNode137 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId137 = 137;
	o->_delta137 = sizeof(struct ZParamNode137) - sizeof(struct ZNode49);
	o->Name = NULL;
	o->NameToken = NULL;
	o->ParamIndex = 0;
#ifdef _ZParamNode137_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qrn
#endif
#ifdef _ZParamNode137_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qrn
#endif
#ifdef _ZParamNode137_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qrn
#endif
#ifdef _ZParamNode137_DeSugar
	o->DeSugar = DeSugar__2qrn
#endif
#ifdef _ZParamNode137_Accept
	o->Accept = Accept__2qrn
#endif
	o->_nextId = 0;
}

static struct ZParamNode137 * _NewZParamNode137(void) {
	struct ZParamNode137 *o = LibZen_Malloc(sizeof(struct ZParamNode137));
	_InitZParamNode137(o);
	return o;
}

struct ZReturnNode135 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId135;
	int _delta135;
	int _nextId;
};

static void _InitZReturnNode135(struct ZReturnNode135 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId135 = 135;
	o->_delta135 = sizeof(struct ZReturnNode135) - sizeof(struct ZNode49);
#ifdef _ZReturnNode135_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qrv
#endif
#ifdef _ZReturnNode135_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qrv
#endif
#ifdef _ZReturnNode135_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qrv
#endif
#ifdef _ZReturnNode135_DeSugar
	o->DeSugar = DeSugar__2qrv
#endif
#ifdef _ZReturnNode135_Accept
	o->Accept = Accept__2qrv
#endif
	o->_nextId = 0;
}

static struct ZReturnNode135 * _NewZReturnNode135(void) {
	struct ZReturnNode135 *o = LibZen_Malloc(sizeof(struct ZReturnNode135));
	_InitZReturnNode135(o);
	return o;
}

struct ZSetIndexNode143 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId143;
	int _delta143;
	int _nextId;
};

static void _InitZSetIndexNode143(struct ZSetIndexNode143 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId143 = 143;
	o->_delta143 = sizeof(struct ZSetIndexNode143) - sizeof(struct ZNode49);
#ifdef _ZSetIndexNode143_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qr8
#endif
#ifdef _ZSetIndexNode143_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qr8
#endif
#ifdef _ZSetIndexNode143_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qr8
#endif
#ifdef _ZSetIndexNode143_DeSugar
	o->DeSugar = DeSugar__2qr8
#endif
#ifdef _ZSetIndexNode143_Accept
	o->Accept = Accept__2qr8
#endif
	o->_nextId = 0;
}

static struct ZSetIndexNode143 * _NewZSetIndexNode143(void) {
	struct ZSetIndexNode143 *o = LibZen_Malloc(sizeof(struct ZSetIndexNode143));
	_InitZSetIndexNode143(o);
	return o;
}

struct ZSetNameNode146 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId146;
	int _delta146;
	const char * VarName;
	long VarIndex;
	int IsCaptured;
	int _nextId;
};

static void _InitZSetNameNode146(struct ZSetNameNode146 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId146 = 146;
	o->_delta146 = sizeof(struct ZSetNameNode146) - sizeof(struct ZNode49);
	o->VarName = NULL;
	o->VarIndex = 0;
	o->IsCaptured = 0/*false*/;
#ifdef _ZSetNameNode146_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qte
#endif
#ifdef _ZSetNameNode146_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qte
#endif
#ifdef _ZSetNameNode146_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qte
#endif
#ifdef _ZSetNameNode146_DeSugar
	o->DeSugar = DeSugar__2qte
#endif
#ifdef _ZSetNameNode146_Accept
	o->Accept = Accept__2qte
#endif
	o->_nextId = 0;
}

static struct ZSetNameNode146 * _NewZSetNameNode146(void) {
	struct ZSetNameNode146 *o = LibZen_Malloc(sizeof(struct ZSetNameNode146));
	_InitZSetNameNode146(o);
	return o;
}

struct ZSetterNode149 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId149;
	int _delta149;
	const char * FieldName;
	struct ZToken64 * NameToken;
	int _nextId;
};

static void _InitZSetterNode149(struct ZSetterNode149 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId149 = 149;
	o->_delta149 = sizeof(struct ZSetterNode149) - sizeof(struct ZNode49);
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZSetterNode149_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qty
#endif
#ifdef _ZSetterNode149_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qty
#endif
#ifdef _ZSetterNode149_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qty
#endif
#ifdef _ZSetterNode149_DeSugar
	o->DeSugar = DeSugar__2qty
#endif
#ifdef _ZSetterNode149_Accept
	o->Accept = Accept__2qty
#endif
	o->_nextId = 0;
}

static struct ZSetterNode149 * _NewZSetterNode149(void) {
	struct ZSetterNode149 *o = LibZen_Malloc(sizeof(struct ZSetterNode149));
	_InitZSetterNode149(o);
	return o;
}

struct ZSugarNode130 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId130;
	int _delta130;
	struct ZNode49 * SugarNode;
	int _nextId;
};

static void _InitZSugarNode130(struct ZSugarNode130 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId130 = 130;
	o->_delta130 = sizeof(struct ZSugarNode130) - sizeof(struct ZNode49);
	o->SugarNode = NULL;
#ifdef _ZSugarNode130_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qr1
#endif
#ifdef _ZSugarNode130_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qr1
#endif
#ifdef _ZSugarNode130_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qr1
#endif
#ifdef _ZSugarNode130_DeSugar
	o->DeSugar = DeSugar__2qr1
#endif
#ifdef _ZSugarNode130_Accept
	o->Accept = Accept__2qr1
#endif
	o->_nextId = 0;
}

static struct ZSugarNode130 * _NewZSugarNode130(void) {
	struct ZSugarNode130 *o = LibZen_Malloc(sizeof(struct ZSugarNode130));
	_InitZSugarNode130(o);
	return o;
}

struct ZThrowNode156 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId156;
	int _delta156;
	int _nextId;
};

static void _InitZThrowNode156(struct ZThrowNode156 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId156 = 156;
	o->_delta156 = sizeof(struct ZThrowNode156) - sizeof(struct ZNode49);
#ifdef _ZThrowNode156_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qta
#endif
#ifdef _ZThrowNode156_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qta
#endif
#ifdef _ZThrowNode156_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qta
#endif
#ifdef _ZThrowNode156_DeSugar
	o->DeSugar = DeSugar__2qta
#endif
#ifdef _ZThrowNode156_Accept
	o->Accept = Accept__2qta
#endif
	o->_nextId = 0;
}

static struct ZThrowNode156 * _NewZThrowNode156(void) {
	struct ZThrowNode156 *o = LibZen_Malloc(sizeof(struct ZThrowNode156));
	_InitZThrowNode156(o);
	return o;
}

struct ZTryNode159 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId159;
	int _delta159;
	int _nextId;
};

static void _InitZTryNode159(struct ZTryNode159 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId159 = 159;
	o->_delta159 = sizeof(struct ZTryNode159) - sizeof(struct ZNode49);
#ifdef _ZTryNode159_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtf
#endif
#ifdef _ZTryNode159_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtf
#endif
#ifdef _ZTryNode159_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtf
#endif
#ifdef _ZTryNode159_DeSugar
	o->DeSugar = DeSugar__2qtf
#endif
#ifdef _ZTryNode159_Accept
	o->Accept = Accept__2qtf
#endif
	o->_nextId = 0;
}

static struct ZTryNode159 * _NewZTryNode159(void) {
	struct ZTryNode159 *o = LibZen_Malloc(sizeof(struct ZTryNode159));
	_InitZTryNode159(o);
	return o;
}

struct ZUnaryNode162 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId162;
	int _delta162;
	int _nextId;
};

static void _InitZUnaryNode162(struct ZUnaryNode162 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId162 = 162;
	o->_delta162 = sizeof(struct ZUnaryNode162) - sizeof(struct ZNode49);
#ifdef _ZUnaryNode162_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qtj
#endif
#ifdef _ZUnaryNode162_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qtj
#endif
#ifdef _ZUnaryNode162_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qtj
#endif
#ifdef _ZUnaryNode162_DeSugar
	o->DeSugar = DeSugar__2qtj
#endif
#ifdef _ZUnaryNode162_Accept
	o->Accept = Accept__2qtj
#endif
	o->_nextId = 0;
}

static struct ZUnaryNode162 * _NewZUnaryNode162(void) {
	struct ZUnaryNode162 *o = LibZen_Malloc(sizeof(struct ZUnaryNode162));
	_InitZUnaryNode162(o);
	return o;
}

struct ZWhileNode165 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId165;
	int _delta165;
	int _nextId;
};

static void _InitZWhileNode165(struct ZWhileNode165 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId165 = 165;
	o->_delta165 = sizeof(struct ZWhileNode165) - sizeof(struct ZNode49);
#ifdef _ZWhileNode165_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qt9
#endif
#ifdef _ZWhileNode165_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qt9
#endif
#ifdef _ZWhileNode165_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qt9
#endif
#ifdef _ZWhileNode165_DeSugar
	o->DeSugar = DeSugar__2qt9
#endif
#ifdef _ZWhileNode165_Accept
	o->Accept = Accept__2qt9
#endif
	o->_nextId = 0;
}

static struct ZWhileNode165 * _NewZWhileNode165(void) {
	struct ZWhileNode165 *o = LibZen_Malloc(sizeof(struct ZWhileNode165));
	_InitZWhileNode165(o);
	return o;
}

struct ZEmptyValue168 {
	int _classId168;
	int _delta168;
	int _nextId;
};

static void _InitZEmptyValue168(struct ZEmptyValue168 * o) {
	o->_classId168 = 168;
	o->_delta168 = sizeof(struct ZEmptyValue168) - sizeof(int);
	o->_nextId = 0;
}

static struct ZEmptyValue168 * _NewZEmptyValue168(void) {
	struct ZEmptyValue168 *o = LibZen_Malloc(sizeof(struct ZEmptyValue168));
	_InitZEmptyValue168(o);
	return o;
}

struct ZLogger99 {
	int _classId99;
	int _delta99;
	ArrayOfString * ReportedErrorList;
	int _nextId;
};

static void _InitZLogger99(struct ZLogger99 * o) {
	o->_classId99 = 99;
	o->_delta99 = sizeof(struct ZLogger99) - sizeof(int);
	o->ReportedErrorList = LibZen_NewStringArray(0);
	o->_nextId = 0;
}

static struct ZLogger99 * _NewZLogger99(void) {
	struct ZLogger99 *o = LibZen_Malloc(sizeof(struct ZLogger99));
	_InitZLogger99(o);
	return o;
}

struct ZMacroFunc176 {
	int _classId66;
	int _delta66;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType67 * FuncType;
	int _classId176;
	int _delta176;
	int _nextId;
};

static void _InitZMacroFunc176(struct ZMacroFunc176 * o) {
	_InitZFunc66((struct ZFunc66 *)o);
	o->_classId176 = 176;
	o->_delta176 = sizeof(struct ZMacroFunc176) - sizeof(struct ZFunc66);
	o->_nextId = 0;
}

static struct ZMacroFunc176 * _NewZMacroFunc176(void) {
	struct ZMacroFunc176 *o = LibZen_Malloc(sizeof(struct ZMacroFunc176));
	_InitZMacroFunc176(o);
	return o;
}

struct ZNameSpace43 {
	int _classId43;
	int _delta43;
	struct ZNameSpace43 * ParentNameSpace;
	struct ZGenerator52 * Generator;
	long SerialId;
	ArrayOfZTokenFunc * TokenMatrix;
	MapOfZSyntax * SyntaxTable;
	MapOfZSymbolEntry * SymbolTable;
	int _nextId;
};

static void _InitZNameSpace43(struct ZNameSpace43 * o) {
	o->_classId43 = 43;
	o->_delta43 = sizeof(struct ZNameSpace43) - sizeof(int);
	o->ParentNameSpace = NULL;
	o->Generator = NULL;
	o->SerialId = 0;
	o->TokenMatrix = NULL;
	o->SyntaxTable = NULL;
	o->SymbolTable = NULL;
	o->_nextId = 0;
}

static struct ZNameSpace43 * _NewZNameSpace43(void) {
	struct ZNameSpace43 *o = LibZen_Malloc(sizeof(struct ZNameSpace43));
	_InitZNameSpace43(o);
	return o;
}

struct ZParserConst638 {
	int _classId638;
	int _delta638;
	int _nextId;
};

static void _InitZParserConst638(struct ZParserConst638 * o) {
	o->_classId638 = 638;
	o->_delta638 = sizeof(struct ZParserConst638) - sizeof(int);
	o->_nextId = 0;
}

static struct ZParserConst638 * _NewZParserConst638(void) {
	struct ZParserConst638 *o = LibZen_Malloc(sizeof(struct ZParserConst638));
	_InitZParserConst638(o);
	return o;
}

struct ZSource202 {
	int _classId202;
	int _delta202;
	struct ZTokenContext50 * TokenContext;
	struct ZLogger99 * Logger;
	const char * FileName;
	long LineNumber;
	const char * SourceText;
	int _nextId;
};

static void _InitZSource202(struct ZSource202 * o) {
	o->_classId202 = 202;
	o->_delta202 = sizeof(struct ZSource202) - sizeof(int);
	o->TokenContext = NULL;
	o->Logger = NULL;
	o->FileName = NULL;
	o->LineNumber = 0;
	o->SourceText = NULL;
	o->_nextId = 0;
}

static struct ZSource202 * _NewZSource202(void) {
	struct ZSource202 *o = LibZen_Malloc(sizeof(struct ZSource202));
	_InitZSource202(o);
	return o;
}

struct ZSourceBuilder37 {
	int _classId37;
	int _delta37;
	struct ZSourceGenerator207 * Template;
	ArrayOfString * SourceList;
	struct ZSourceBuilder37 * Parent;
	long IndentLevel;
	const char * CurrentIndentString;
	const char * BufferedLineComment;
	int _nextId;
};

static void _InitZSourceBuilder37(struct ZSourceBuilder37 * o) {
	o->_classId37 = 37;
	o->_delta37 = sizeof(struct ZSourceBuilder37) - sizeof(int);
	o->Template = NULL;
	o->SourceList = LibZen_NewStringArray(0);
	o->Parent = NULL;
	o->IndentLevel = 0;
	o->CurrentIndentString = "";
	o->BufferedLineComment = "";
	o->_nextId = 0;
}

static struct ZSourceBuilder37 * _NewZSourceBuilder37(void) {
	struct ZSourceBuilder37 *o = LibZen_Malloc(sizeof(struct ZSourceBuilder37));
	_InitZSourceBuilder37(o);
	return o;
}

struct ZSourceContext46 {
	int _classId202;
	int _delta202;
	struct ZTokenContext50 * TokenContext;
	struct ZLogger99 * Logger;
	const char * FileName;
	long LineNumber;
	const char * SourceText;
	int _classId46;
	int _delta46;
	long SourcePosition;
	int _nextId;
};

static void _InitZSourceContext46(struct ZSourceContext46 * o) {
	_InitZSource202((struct ZSource202 *)o);
	o->_classId46 = 46;
	o->_delta46 = sizeof(struct ZSourceContext46) - sizeof(struct ZSource202);
	o->SourcePosition = 0;
	o->_nextId = 0;
}

static struct ZSourceContext46 * _NewZSourceContext46(void) {
	struct ZSourceContext46 *o = LibZen_Malloc(sizeof(struct ZSourceContext46));
	_InitZSourceContext46(o);
	return o;
}

struct ZSourceMacro229 {
	int _classId66;
	int _delta66;
	long FuncFlag;
	const char * FuncName;
	struct ZFuncType67 * FuncType;
	int _classId176;
	int _delta176;
	int _classId229;
	int _delta229;
	const char * Macro;
	int _nextId;
};

static void _InitZSourceMacro229(struct ZSourceMacro229 * o) {
	_InitZMacroFunc176((struct ZMacroFunc176 *)o);
	o->_classId229 = 229;
	o->_delta229 = sizeof(struct ZSourceMacro229) - sizeof(struct ZMacroFunc176);
	o->Macro = NULL;
	o->_nextId = 0;
}

static struct ZSourceMacro229 * _NewZSourceMacro229(void) {
	struct ZSourceMacro229 *o = LibZen_Malloc(sizeof(struct ZSourceMacro229));
	_InitZSourceMacro229(o);
	return o;
}

struct ZSymbolEntry189 {
	int _classId189;
	int _delta189;
	struct ZSymbolEntry189 * Parent;
	struct ZNode49 * Node;
	int IsDisabled;
	int _nextId;
};

static void _InitZSymbolEntry189(struct ZSymbolEntry189 * o) {
	o->_classId189 = 189;
	o->_delta189 = sizeof(struct ZSymbolEntry189) - sizeof(int);
	o->Parent = NULL;
	o->Node = NULL;
	o->IsDisabled = 0/*false*/;
	o->_nextId = 0;
}

static struct ZSymbolEntry189 * _NewZSymbolEntry189(void) {
	struct ZSymbolEntry189 *o = LibZen_Malloc(sizeof(struct ZSymbolEntry189));
	_InitZSymbolEntry189(o);
	return o;
}

struct ZSyntax184 {
	int _classId184;
	int _delta184;
	struct ZNameSpace43 * PackageNameSpace;
	const char * PatternName;
	struct ZMatchFunction48 * MatchFunc;
	long SyntaxFlag;
	struct ZSyntax184 * ParentPattern;
	int IsDisabled;
	int IsStatement;
	int _nextId;
};

static void _InitZSyntax184(struct ZSyntax184 * o) {
	o->_classId184 = 184;
	o->_delta184 = sizeof(struct ZSyntax184) - sizeof(int);
	o->PackageNameSpace = NULL;
	o->PatternName = NULL;
	o->MatchFunc = NULL;
	o->SyntaxFlag = 0;
	o->ParentPattern = NULL;
	o->IsDisabled = 0/*false*/;
	o->IsStatement = 0/*false*/;
	o->_nextId = 0;
}

static struct ZSyntax184 * _NewZSyntax184(void) {
	struct ZSyntax184 *o = LibZen_Malloc(sizeof(struct ZSyntax184));
	_InitZSyntax184(o);
	return o;
}

struct ZToken64 {
	int _classId64;
	int _delta64;
	struct ZSource202 * Source;
	long StartIndex;
	long EndIndex;
	int _nextId;
};

static void _InitZToken64(struct ZToken64 * o) {
	o->_classId64 = 64;
	o->_delta64 = sizeof(struct ZToken64) - sizeof(int);
	o->Source = NULL;
	o->StartIndex = 0;
	o->EndIndex = 0;
	o->_nextId = 0;
}

static struct ZToken64 * _NewZToken64(void) {
	struct ZToken64 *o = LibZen_Malloc(sizeof(struct ZToken64));
	_InitZToken64(o);
	return o;
}

struct ZTokenContext50 {
	int _classId50;
	int _delta50;
	struct ZGenerator52 * Generator;
	struct ZNameSpace43 * NameSpace;
	struct ZSourceContext46 * Source;
	ArrayOfZToken * TokenList;
	long CurrentPosition;
	int IsAllowSkipIndent;
	struct ZToken64 * LatestToken;
	struct ZSyntax184 * ApplyingPattern;
	int _nextId;
};

static void _InitZTokenContext50(struct ZTokenContext50 * o) {
	o->_classId50 = 50;
	o->_delta50 = sizeof(struct ZTokenContext50) - sizeof(int);
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

static struct ZTokenContext50 * _NewZTokenContext50(void) {
	struct ZTokenContext50 *o = LibZen_Malloc(sizeof(struct ZTokenContext50));
	_InitZTokenContext50(o);
	return o;
}

struct ZTokenFunc28 {
	int _classId28;
	int _delta28;
	struct ZTokenFunction45 * Func;
	struct ZTokenFunc28 * ParentFunc;
	int _nextId;
};

static void _InitZTokenFunc28(struct ZTokenFunc28 * o) {
	o->_classId28 = 28;
	o->_delta28 = sizeof(struct ZTokenFunc28) - sizeof(int);
	o->Func = NULL;
	o->ParentFunc = NULL;
	o->_nextId = 0;
}

static struct ZTokenFunc28 * _NewZTokenFunc28(void) {
	struct ZTokenFunc28 *o = LibZen_Malloc(sizeof(struct ZTokenFunc28));
	_InitZTokenFunc28(o);
	return o;
}

struct ZVariable194 {
	int _classId189;
	int _delta189;
	struct ZSymbolEntry189 * Parent;
	struct ZNode49 * Node;
	int IsDisabled;
	int _classId194;
	int _delta194;
	long VarFlag;
	struct ZType59 * VarType;
	const char * VarName;
	long VarUniqueIndex;
	struct ZToken64 * SourceToken;
	long DefCount;
	long UsedCount;
	int _nextId;
};

static void _InitZVariable194(struct ZVariable194 * o) {
	_InitZSymbolEntry189((struct ZSymbolEntry189 *)o);
	o->_classId194 = 194;
	o->_delta194 = sizeof(struct ZVariable194) - sizeof(struct ZSymbolEntry189);
	o->VarFlag = 0;
	o->VarType = NULL;
	o->VarName = NULL;
	o->VarUniqueIndex = 0;
	o->SourceToken = NULL;
	o->DefCount = 0;
	o->UsedCount = 0;
	o->_nextId = 0;
}

static struct ZVariable194 * _NewZVariable194(void) {
	struct ZVariable194 *o = LibZen_Malloc(sizeof(struct ZVariable194));
	_InitZVariable194(o);
	return o;
}

struct ZVisitor132 {
	int _classId132;
	int _delta132;
	void (*)(struct ZVisitor132 *,struct ZNullNode412 *) VisitNullNode;
	void (*)(struct ZVisitor132 *,struct ZBooleanNode469 *) VisitBooleanNode;
	void (*)(struct ZVisitor132 *,struct ZIntNode370 *) VisitIntNode;
	void (*)(struct ZVisitor132 *,struct ZFloatNode337 *) VisitFloatNode;
	void (*)(struct ZVisitor132 *,struct ZStringNode424 *) VisitStringNode;
	void (*)(struct ZVisitor132 *,struct ZArrayLiteralNode474 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZMapLiteralNode392 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZNewObjectNode405 *) VisitNewObjectNode;
	void (*)(struct ZVisitor132 *,struct ZGlobalNameNode353 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor132 *,struct ZGetNameNode343 *) VisitGetNameNode;
	void (*)(struct ZVisitor132 *,struct ZSetNameNode146 *) VisitSetNameNode;
	void (*)(struct ZVisitor132 *,struct ZGroupNode357 *) VisitGroupNode;
	void (*)(struct ZVisitor132 *,struct ZGetterNode348 *) VisitGetterNode;
	void (*)(struct ZVisitor132 *,struct ZSetterNode149 *) VisitSetterNode;
	void (*)(struct ZVisitor132 *,struct ZGetIndexNode340 *) VisitGetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZSetIndexNode143 *) VisitSetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZMethodCallNode396 *) VisitMethodCallNode;
	void (*)(struct ZVisitor132 *,struct ZFuncCallNode400 *) VisitFuncCallNode;
	void (*)(struct ZVisitor132 *,struct ZMacroNode385 *) VisitMacroNode;
	void (*)(struct ZVisitor132 *,struct ZUnaryNode162 *) VisitUnaryNode;
	void (*)(struct ZVisitor132 *,struct ZNotNode409 *) VisitNotNode;
	void (*)(struct ZVisitor132 *,struct ZCastNode314 *) VisitCastNode;
	void (*)(struct ZVisitor132 *,struct ZInstanceOfNode366 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor132 *,struct ZBinaryNode304 *) VisitBinaryNode;
	void (*)(struct ZVisitor132 *,struct ZComparatorNode322 *) VisitComparatorNode;
	void (*)(struct ZVisitor132 *,struct ZAndNode495 *) VisitAndNode;
	void (*)(struct ZVisitor132 *,struct ZOrNode415 *) VisitOrNode;
	void (*)(struct ZVisitor132 *,struct ZBlockNode126 *) VisitBlockNode;
	void (*)(struct ZVisitor132 *,struct ZVarNode499 *) VisitVarNode;
	void (*)(struct ZVisitor132 *,struct ZIfNode360 *) VisitIfNode;
	void (*)(struct ZVisitor132 *,struct ZReturnNode135 *) VisitReturnNode;
	void (*)(struct ZVisitor132 *,struct ZWhileNode165 *) VisitWhileNode;
	void (*)(struct ZVisitor132 *,struct ZBreakNode311 *) VisitBreakNode;
	void (*)(struct ZVisitor132 *,struct ZThrowNode156 *) VisitThrowNode;
	void (*)(struct ZVisitor132 *,struct ZTryNode159 *) VisitTryNode;
	void (*)(struct ZVisitor132 *,struct ZLetNode373 *) VisitLetNode;
	void (*)(struct ZVisitor132 *,struct ZFunctionNode109 *) VisitFunctionNode;
	void (*)(struct ZVisitor132 *,struct ZClassNode509 *) VisitClassNode;
	void (*)(struct ZVisitor132 *,struct ZErrorNode329 *) VisitErrorNode;
	void (*)(struct ZVisitor132 *,struct ZNode49 *) VisitExtendedNode;
	void (*)(struct ZVisitor132 *,struct ZSugarNode130 *) VisitSugarNode;
	void (*)(struct ZVisitor132 *) EnableVisitor;
	void (*)(struct ZVisitor132 *) StopVisitor;
	int (*)(struct ZVisitor132 *) IsVisitable;
	int _nextId;
};

static void _InitZVisitor132(struct ZVisitor132 * o) {
	o->_classId132 = 132;
	o->_delta132 = sizeof(struct ZVisitor132) - sizeof(int);
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
#ifdef _ZVisitor132_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qrz
#endif
#ifdef _ZVisitor132_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qrz
#endif
#ifdef _ZVisitor132_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qrz
#endif
#ifdef _ZVisitor132_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qrz
#endif
#ifdef _ZVisitor132_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qrz
#endif
#ifdef _ZVisitor132_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qrz
#endif
#ifdef _ZVisitor132_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qrz
#endif
#ifdef _ZVisitor132_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qrz
#endif
#ifdef _ZVisitor132_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qrz
#endif
#ifdef _ZVisitor132_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qrz
#endif
#ifdef _ZVisitor132_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qrz
#endif
#ifdef _ZVisitor132_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qrz
#endif
#ifdef _ZVisitor132_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qrz
#endif
#ifdef _ZVisitor132_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qrz
#endif
#ifdef _ZVisitor132_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qrz
#endif
#ifdef _ZVisitor132_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qrz
#endif
#ifdef _ZVisitor132_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qrz
#endif
#ifdef _ZVisitor132_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qrz
#endif
#ifdef _ZVisitor132_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qrz
#endif
#ifdef _ZVisitor132_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qrz
#endif
#ifdef _ZVisitor132_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qrz
#endif
#ifdef _ZVisitor132_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qrz
#endif
#ifdef _ZVisitor132_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qrz
#endif
#ifdef _ZVisitor132_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qrz
#endif
#ifdef _ZVisitor132_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qrz
#endif
#ifdef _ZVisitor132_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qrz
#endif
#ifdef _ZVisitor132_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qrz
#endif
#ifdef _ZVisitor132_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qrz
#endif
#ifdef _ZVisitor132_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qrz
#endif
#ifdef _ZVisitor132_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qrz
#endif
#ifdef _ZVisitor132_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qrz
#endif
#ifdef _ZVisitor132_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qrz
#endif
#ifdef _ZVisitor132_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qrz
#endif
#ifdef _ZVisitor132_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qrz
#endif
#ifdef _ZVisitor132_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qrz
#endif
#ifdef _ZVisitor132_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qrz
#endif
#ifdef _ZVisitor132_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qrz
#endif
#ifdef _ZVisitor132_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qrz
#endif
#ifdef _ZVisitor132_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qrz
#endif
#ifdef _ZVisitor132_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qrz
#endif
#ifdef _ZVisitor132_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qrz
#endif
#ifdef _ZVisitor132_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qrz
#endif
#ifdef _ZVisitor132_StopVisitor
	o->StopVisitor = StopVisitor__1qrz
#endif
#ifdef _ZVisitor132_IsVisitable
	o->IsVisitable = IsVisitable__1qrz
#endif
	o->_nextId = 0;
}

static struct ZVisitor132 * _NewZVisitor132(void) {
	struct ZVisitor132 *o = LibZen_Malloc(sizeof(struct ZVisitor132));
	_InitZVisitor132(o);
	return o;
}

struct ZClassType63 {
	int _classId59;
	int _delta59;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType59 * RefType;
	struct ZType59 * (*)(struct ZType59 *) GetRealType;
	struct ZType59 * (*)(struct ZType59 *) GetSuperType;
	struct ZType59 * (*)(struct ZType59 *) GetBaseType;
	long (*)(struct ZType59 *) GetParamSize;
	struct ZType59 * (*)(struct ZType59 *,long) GetParamType;
	int (*)(struct ZType59 *) IsGreekType;
	struct ZType59 * (*)(struct ZType59 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType59 *,struct ZType59 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType59 *) IsVarType;
	int _classId63;
	int _delta63;
	ArrayOfZClassField * FieldList;
	int _nextId;
};

static void _InitZClassType63(struct ZClassType63 * o) {
	_InitZType59((struct ZType59 *)o);
	o->_classId63 = 63;
	o->_delta63 = sizeof(struct ZClassType63) - sizeof(struct ZType59);
	o->FieldList = NULL;
#ifdef _ZClassType63_GetRealType
	o->GetRealType = GetRealType__1qwv
#endif
#ifdef _ZClassType63_GetSuperType
	o->GetSuperType = GetSuperType__1qwv
#endif
#ifdef _ZClassType63_GetBaseType
	o->GetBaseType = GetBaseType__1qwv
#endif
#ifdef _ZClassType63_GetParamSize
	o->GetParamSize = GetParamSize__1qwv
#endif
#ifdef _ZClassType63_GetParamType
	o->GetParamType = GetParamType__2qwv
#endif
#ifdef _ZClassType63_IsGreekType
	o->IsGreekType = IsGreekType__1qwv
#endif
#ifdef _ZClassType63_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qwv
#endif
#ifdef _ZClassType63_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qwv
#endif
#ifdef _ZClassType63_IsVarType
	o->IsVarType = IsVarType__1qwv
#endif
	o->_nextId = 0;
}

static struct ZClassType63 * _NewZClassType63(void) {
	struct ZClassType63 *o = LibZen_Malloc(sizeof(struct ZClassType63));
	_InitZClassType63(o);
	return o;
}

struct ZFuncType67 {
	int _classId59;
	int _delta59;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType59 * RefType;
	struct ZType59 * (*)(struct ZType59 *) GetRealType;
	struct ZType59 * (*)(struct ZType59 *) GetSuperType;
	struct ZType59 * (*)(struct ZType59 *) GetBaseType;
	long (*)(struct ZType59 *) GetParamSize;
	struct ZType59 * (*)(struct ZType59 *,long) GetParamType;
	int (*)(struct ZType59 *) IsGreekType;
	struct ZType59 * (*)(struct ZType59 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType59 *,struct ZType59 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType59 *) IsVarType;
	int _classId67;
	int _delta67;
	ArrayOfZType * TypeParams;
	int HasUnknownType;
	int HasGreekType;
	int _nextId;
};

static void _InitZFuncType67(struct ZFuncType67 * o) {
	_InitZType59((struct ZType59 *)o);
	o->_classId67 = 67;
	o->_delta67 = sizeof(struct ZFuncType67) - sizeof(struct ZType59);
	o->TypeParams = NULL;
	o->HasUnknownType = 0/*false*/;
	o->HasGreekType = 0/*false*/;
#ifdef _ZFuncType67_GetRealType
	o->GetRealType = GetRealType__1qw7
#endif
#ifdef _ZFuncType67_GetSuperType
	o->GetSuperType = GetSuperType__1qw7
#endif
#ifdef _ZFuncType67_GetBaseType
	o->GetBaseType = GetBaseType__1qw7
#endif
#ifdef _ZFuncType67_GetParamSize
	o->GetParamSize = GetParamSize__1qw7
#endif
#ifdef _ZFuncType67_GetParamType
	o->GetParamType = GetParamType__2qw7
#endif
#ifdef _ZFuncType67_IsGreekType
	o->IsGreekType = IsGreekType__1qw7
#endif
#ifdef _ZFuncType67_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qw7
#endif
#ifdef _ZFuncType67_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qw7
#endif
#ifdef _ZFuncType67_IsVarType
	o->IsVarType = IsVarType__1qw7
#endif
	o->_nextId = 0;
}

static struct ZFuncType67 * _NewZFuncType67(void) {
	struct ZFuncType67 *o = LibZen_Malloc(sizeof(struct ZFuncType67));
	_InitZFuncType67(o);
	return o;
}

struct ZGeneric1Type282 {
	int _classId59;
	int _delta59;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType59 * RefType;
	struct ZType59 * (*)(struct ZType59 *) GetRealType;
	struct ZType59 * (*)(struct ZType59 *) GetSuperType;
	struct ZType59 * (*)(struct ZType59 *) GetBaseType;
	long (*)(struct ZType59 *) GetParamSize;
	struct ZType59 * (*)(struct ZType59 *,long) GetParamType;
	int (*)(struct ZType59 *) IsGreekType;
	struct ZType59 * (*)(struct ZType59 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType59 *,struct ZType59 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType59 *) IsVarType;
	int _classId282;
	int _delta282;
	struct ZType59 * BaseType;
	struct ZType59 * ParamType;
	int _nextId;
};

static void _InitZGeneric1Type282(struct ZGeneric1Type282 * o) {
	_InitZType59((struct ZType59 *)o);
	o->_classId282 = 282;
	o->_delta282 = sizeof(struct ZGeneric1Type282) - sizeof(struct ZType59);
	o->BaseType = NULL;
	o->ParamType = NULL;
#ifdef _ZGeneric1Type282_GetRealType
	o->GetRealType = GetRealType__1qim
#endif
#ifdef _ZGeneric1Type282_GetSuperType
	o->GetSuperType = GetSuperType__1qim
#endif
#ifdef _ZGeneric1Type282_GetBaseType
	o->GetBaseType = GetBaseType__1qim
#endif
#ifdef _ZGeneric1Type282_GetParamSize
	o->GetParamSize = GetParamSize__1qim
#endif
#ifdef _ZGeneric1Type282_GetParamType
	o->GetParamType = GetParamType__2qim
#endif
#ifdef _ZGeneric1Type282_IsGreekType
	o->IsGreekType = IsGreekType__1qim
#endif
#ifdef _ZGeneric1Type282_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qim
#endif
#ifdef _ZGeneric1Type282_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qim
#endif
#ifdef _ZGeneric1Type282_IsVarType
	o->IsVarType = IsVarType__1qim
#endif
	o->_nextId = 0;
}

static struct ZGeneric1Type282 * _NewZGeneric1Type282(void) {
	struct ZGeneric1Type282 *o = LibZen_Malloc(sizeof(struct ZGeneric1Type282));
	_InitZGeneric1Type282(o);
	return o;
}

struct ZGreekType290 {
	int _classId59;
	int _delta59;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType59 * RefType;
	struct ZType59 * (*)(struct ZType59 *) GetRealType;
	struct ZType59 * (*)(struct ZType59 *) GetSuperType;
	struct ZType59 * (*)(struct ZType59 *) GetBaseType;
	long (*)(struct ZType59 *) GetParamSize;
	struct ZType59 * (*)(struct ZType59 *,long) GetParamType;
	int (*)(struct ZType59 *) IsGreekType;
	struct ZType59 * (*)(struct ZType59 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType59 *,struct ZType59 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType59 *) IsVarType;
	int _classId290;
	int _delta290;
	long GreekId;
	int _nextId;
};

static void _InitZGreekType290(struct ZGreekType290 * o) {
	_InitZType59((struct ZType59 *)o);
	o->_classId290 = 290;
	o->_delta290 = sizeof(struct ZGreekType290) - sizeof(struct ZType59);
	o->GreekId = 0;
#ifdef _ZGreekType290_GetRealType
	o->GetRealType = GetRealType__1qoe
#endif
#ifdef _ZGreekType290_GetSuperType
	o->GetSuperType = GetSuperType__1qoe
#endif
#ifdef _ZGreekType290_GetBaseType
	o->GetBaseType = GetBaseType__1qoe
#endif
#ifdef _ZGreekType290_GetParamSize
	o->GetParamSize = GetParamSize__1qoe
#endif
#ifdef _ZGreekType290_GetParamType
	o->GetParamType = GetParamType__2qoe
#endif
#ifdef _ZGreekType290_IsGreekType
	o->IsGreekType = IsGreekType__1qoe
#endif
#ifdef _ZGreekType290_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qoe
#endif
#ifdef _ZGreekType290_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qoe
#endif
#ifdef _ZGreekType290_IsVarType
	o->IsVarType = IsVarType__1qoe
#endif
	o->_nextId = 0;
}

static struct ZGreekType290 * _NewZGreekType290(void) {
	struct ZGreekType290 *o = LibZen_Malloc(sizeof(struct ZGreekType290));
	_InitZGreekType290(o);
	return o;
}

struct ZAnnotationNode295 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId295;
	int _delta295;
	struct ZNode49 * AnnotatedNode;
	int _nextId;
};

static void _InitZAnnotationNode295(struct ZAnnotationNode295 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId295 = 295;
	o->_delta295 = sizeof(struct ZAnnotationNode295) - sizeof(struct ZNode49);
	o->AnnotatedNode = NULL;
#ifdef _ZAnnotationNode295_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qoi
#endif
#ifdef _ZAnnotationNode295_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qoi
#endif
#ifdef _ZAnnotationNode295_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qoi
#endif
#ifdef _ZAnnotationNode295_DeSugar
	o->DeSugar = DeSugar__2qoi
#endif
#ifdef _ZAnnotationNode295_Accept
	o->Accept = Accept__2qoi
#endif
	o->_nextId = 0;
}

static struct ZAnnotationNode295 * _NewZAnnotationNode295(void) {
	struct ZAnnotationNode295 *o = LibZen_Malloc(sizeof(struct ZAnnotationNode295));
	_InitZAnnotationNode295(o);
	return o;
}

struct ZAssertNode301 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId301;
	int _delta301;
	int _nextId;
};

static void _InitZAssertNode301(struct ZAssertNode301 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId301 = 301;
	o->_delta301 = sizeof(struct ZAssertNode301) - sizeof(struct ZNode49);
#ifdef _ZAssertNode301_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qos
#endif
#ifdef _ZAssertNode301_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qos
#endif
#ifdef _ZAssertNode301_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qos
#endif
#ifdef _ZAssertNode301_DeSugar
	o->DeSugar = DeSugar__2qos
#endif
#ifdef _ZAssertNode301_Accept
	o->Accept = Accept__2qos
#endif
	o->_nextId = 0;
}

static struct ZAssertNode301 * _NewZAssertNode301(void) {
	struct ZAssertNode301 *o = LibZen_Malloc(sizeof(struct ZAssertNode301));
	_InitZAssertNode301(o);
	return o;
}

struct ZBinaryNode304 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId304;
	int _delta304;
	struct ZSyntax184 * Pattern;
	int _nextId;
};

static void _InitZBinaryNode304(struct ZBinaryNode304 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId304 = 304;
	o->_delta304 = sizeof(struct ZBinaryNode304) - sizeof(struct ZNode49);
	o->Pattern = NULL;
#ifdef _ZBinaryNode304_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qog
#endif
#ifdef _ZBinaryNode304_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qog
#endif
#ifdef _ZBinaryNode304_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qog
#endif
#ifdef _ZBinaryNode304_DeSugar
	o->DeSugar = DeSugar__2qog
#endif
#ifdef _ZBinaryNode304_Accept
	o->Accept = Accept__2qog
#endif
	o->_nextId = 0;
}

static struct ZBinaryNode304 * _NewZBinaryNode304(void) {
	struct ZBinaryNode304 *o = LibZen_Malloc(sizeof(struct ZBinaryNode304));
	_InitZBinaryNode304(o);
	return o;
}

struct ZBreakNode311 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId311;
	int _delta311;
	int _nextId;
};

static void _InitZBreakNode311(struct ZBreakNode311 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId311 = 311;
	o->_delta311 = sizeof(struct ZBreakNode311) - sizeof(struct ZNode49);
#ifdef _ZBreakNode311_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo6
#endif
#ifdef _ZBreakNode311_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo6
#endif
#ifdef _ZBreakNode311_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo6
#endif
#ifdef _ZBreakNode311_DeSugar
	o->DeSugar = DeSugar__2qo6
#endif
#ifdef _ZBreakNode311_Accept
	o->Accept = Accept__2qo6
#endif
	o->_nextId = 0;
}

static struct ZBreakNode311 * _NewZBreakNode311(void) {
	struct ZBreakNode311 *o = LibZen_Malloc(sizeof(struct ZBreakNode311));
	_InitZBreakNode311(o);
	return o;
}

struct ZCastNode314 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId314;
	int _delta314;
	int _nextId;
};

static void _InitZCastNode314(struct ZCastNode314 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId314 = 314;
	o->_delta314 = sizeof(struct ZCastNode314) - sizeof(struct ZNode49);
#ifdef _ZCastNode314_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qoc
#endif
#ifdef _ZCastNode314_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qoc
#endif
#ifdef _ZCastNode314_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qoc
#endif
#ifdef _ZCastNode314_DeSugar
	o->DeSugar = DeSugar__2qoc
#endif
#ifdef _ZCastNode314_Accept
	o->Accept = Accept__2qoc
#endif
	o->_nextId = 0;
}

static struct ZCastNode314 * _NewZCastNode314(void) {
	struct ZCastNode314 *o = LibZen_Malloc(sizeof(struct ZCastNode314));
	_InitZCastNode314(o);
	return o;
}

struct ZCatchNode318 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId318;
	int _delta318;
	struct ZType59 * ExceptionType;
	const char * ExceptionName;
	struct ZToken64 * NameToken;
	int _nextId;
};

static void _InitZCatchNode318(struct ZCatchNode318 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId318 = 318;
	o->_delta318 = sizeof(struct ZCatchNode318) - sizeof(struct ZNode49);
	o->ExceptionType = /*untyped*/NULL;
	o->ExceptionName = NULL;
	o->NameToken = NULL;
#ifdef _ZCatchNode318_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qom
#endif
#ifdef _ZCatchNode318_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qom
#endif
#ifdef _ZCatchNode318_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qom
#endif
#ifdef _ZCatchNode318_DeSugar
	o->DeSugar = DeSugar__2qom
#endif
#ifdef _ZCatchNode318_Accept
	o->Accept = Accept__2qom
#endif
	o->_nextId = 0;
}

static struct ZCatchNode318 * _NewZCatchNode318(void) {
	struct ZCatchNode318 *o = LibZen_Malloc(sizeof(struct ZCatchNode318));
	_InitZCatchNode318(o);
	return o;
}

struct ZComparatorNode322 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId304;
	int _delta304;
	struct ZSyntax184 * Pattern;
	int _classId322;
	int _delta322;
	int _nextId;
};

static void _InitZComparatorNode322(struct ZComparatorNode322 * o) {
	_InitZBinaryNode304((struct ZBinaryNode304 *)o);
	o->_classId322 = 322;
	o->_delta322 = sizeof(struct ZComparatorNode322) - sizeof(struct ZBinaryNode304);
#ifdef _ZComparatorNode322_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qo2
#endif
#ifdef _ZComparatorNode322_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qo2
#endif
#ifdef _ZComparatorNode322_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qo2
#endif
#ifdef _ZComparatorNode322_DeSugar
	o->DeSugar = DeSugar__2qo2
#endif
#ifdef _ZComparatorNode322_Accept
	o->Accept = Accept__2qo2
#endif
	o->_nextId = 0;
}

static struct ZComparatorNode322 * _NewZComparatorNode322(void) {
	struct ZComparatorNode322 *o = LibZen_Malloc(sizeof(struct ZComparatorNode322));
	_InitZComparatorNode322(o);
	return o;
}

struct ZConstNode325 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _nextId;
};

static void _InitZConstNode325(struct ZConstNode325 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId325 = 325;
	o->_delta325 = sizeof(struct ZConstNode325) - sizeof(struct ZNode49);
#ifdef _ZConstNode325_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpw
#endif
#ifdef _ZConstNode325_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpw
#endif
#ifdef _ZConstNode325_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpw
#endif
#ifdef _ZConstNode325_DeSugar
	o->DeSugar = DeSugar__2qpw
#endif
#ifdef _ZConstNode325_Accept
	o->Accept = Accept__2qpw
#endif
	o->_nextId = 0;
}

static struct ZConstNode325 * _NewZConstNode325(void) {
	struct ZConstNode325 *o = LibZen_Malloc(sizeof(struct ZConstNode325));
	_InitZConstNode325(o);
	return o;
}

struct ZEmptyNode327 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId327;
	int _delta327;
	int _nextId;
};

static void _InitZEmptyNode327(struct ZEmptyNode327 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId327 = 327;
	o->_delta327 = sizeof(struct ZEmptyNode327) - sizeof(struct ZNode49);
#ifdef _ZEmptyNode327_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpr
#endif
#ifdef _ZEmptyNode327_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpr
#endif
#ifdef _ZEmptyNode327_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpr
#endif
#ifdef _ZEmptyNode327_DeSugar
	o->DeSugar = DeSugar__2qpr
#endif
#ifdef _ZEmptyNode327_Accept
	o->Accept = Accept__2qpr
#endif
	o->_nextId = 0;
}

static struct ZEmptyNode327 * _NewZEmptyNode327(void) {
	struct ZEmptyNode327 *o = LibZen_Malloc(sizeof(struct ZEmptyNode327));
	_InitZEmptyNode327(o);
	return o;
}

struct ZErrorNode329 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId329;
	int _delta329;
	const char * ErrorMessage;
	int _nextId;
};

static void _InitZErrorNode329(struct ZErrorNode329 * o) {
	_InitZConstNode325((struct ZConstNode325 *)o);
	o->_classId329 = 329;
	o->_delta329 = sizeof(struct ZErrorNode329) - sizeof(struct ZConstNode325);
	o->ErrorMessage = NULL;
#ifdef _ZErrorNode329_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpy
#endif
#ifdef _ZErrorNode329_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpy
#endif
#ifdef _ZErrorNode329_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpy
#endif
#ifdef _ZErrorNode329_DeSugar
	o->DeSugar = DeSugar__2qpy
#endif
#ifdef _ZErrorNode329_Accept
	o->Accept = Accept__2qpy
#endif
	o->_nextId = 0;
}

static struct ZErrorNode329 * _NewZErrorNode329(void) {
	struct ZErrorNode329 *o = LibZen_Malloc(sizeof(struct ZErrorNode329));
	_InitZErrorNode329(o);
	return o;
}

struct ZFieldNode333 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId333;
	int _delta333;
	struct ZClassType63 * ClassType;
	struct ZType59 * DeclType;
	const char * FieldName;
	struct ZToken64 * NameToken;
	int _nextId;
};

static void _InitZFieldNode333(struct ZFieldNode333 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId333 = 333;
	o->_delta333 = sizeof(struct ZFieldNode333) - sizeof(struct ZNode49);
	o->ClassType = NULL;
	o->DeclType = /*untyped*/NULL;
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZFieldNode333_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpp
#endif
#ifdef _ZFieldNode333_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpp
#endif
#ifdef _ZFieldNode333_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpp
#endif
#ifdef _ZFieldNode333_DeSugar
	o->DeSugar = DeSugar__2qpp
#endif
#ifdef _ZFieldNode333_Accept
	o->Accept = Accept__2qpp
#endif
	o->_nextId = 0;
}

static struct ZFieldNode333 * _NewZFieldNode333(void) {
	struct ZFieldNode333 *o = LibZen_Malloc(sizeof(struct ZFieldNode333));
	_InitZFieldNode333(o);
	return o;
}

struct ZFloatNode337 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId337;
	int _delta337;
	double FloatValue;
	int _nextId;
};

static void _InitZFloatNode337(struct ZFloatNode337 * o) {
	_InitZConstNode325((struct ZConstNode325 *)o);
	o->_classId337 = 337;
	o->_delta337 = sizeof(struct ZFloatNode337) - sizeof(struct ZConstNode325);
	o->FloatValue = 0.0;
#ifdef _ZFloatNode337_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qps
#endif
#ifdef _ZFloatNode337_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qps
#endif
#ifdef _ZFloatNode337_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qps
#endif
#ifdef _ZFloatNode337_DeSugar
	o->DeSugar = DeSugar__2qps
#endif
#ifdef _ZFloatNode337_Accept
	o->Accept = Accept__2qps
#endif
	o->_nextId = 0;
}

static struct ZFloatNode337 * _NewZFloatNode337(void) {
	struct ZFloatNode337 *o = LibZen_Malloc(sizeof(struct ZFloatNode337));
	_InitZFloatNode337(o);
	return o;
}

struct ZGetIndexNode340 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId340;
	int _delta340;
	int _nextId;
};

static void _InitZGetIndexNode340(struct ZGetIndexNode340 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId340 = 340;
	o->_delta340 = sizeof(struct ZGetIndexNode340) - sizeof(struct ZNode49);
#ifdef _ZGetIndexNode340_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpg
#endif
#ifdef _ZGetIndexNode340_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpg
#endif
#ifdef _ZGetIndexNode340_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpg
#endif
#ifdef _ZGetIndexNode340_DeSugar
	o->DeSugar = DeSugar__2qpg
#endif
#ifdef _ZGetIndexNode340_Accept
	o->Accept = Accept__2qpg
#endif
	o->_nextId = 0;
}

static struct ZGetIndexNode340 * _NewZGetIndexNode340(void) {
	struct ZGetIndexNode340 *o = LibZen_Malloc(sizeof(struct ZGetIndexNode340));
	_InitZGetIndexNode340(o);
	return o;
}

struct ZGetNameNode343 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId343;
	int _delta343;
	int IsCaptured;
	const char * VarName;
	long VarIndex;
	int _nextId;
};

static void _InitZGetNameNode343(struct ZGetNameNode343 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId343 = 343;
	o->_delta343 = sizeof(struct ZGetNameNode343) - sizeof(struct ZNode49);
	o->IsCaptured = 0/*false*/;
	o->VarName = NULL;
	o->VarIndex = 0;
#ifdef _ZGetNameNode343_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpk
#endif
#ifdef _ZGetNameNode343_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpk
#endif
#ifdef _ZGetNameNode343_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpk
#endif
#ifdef _ZGetNameNode343_DeSugar
	o->DeSugar = DeSugar__2qpk
#endif
#ifdef _ZGetNameNode343_Accept
	o->Accept = Accept__2qpk
#endif
	o->_nextId = 0;
}

static struct ZGetNameNode343 * _NewZGetNameNode343(void) {
	struct ZGetNameNode343 *o = LibZen_Malloc(sizeof(struct ZGetNameNode343));
	_InitZGetNameNode343(o);
	return o;
}

struct ZGetterNode348 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId348;
	int _delta348;
	const char * FieldName;
	struct ZToken64 * NameToken;
	int _nextId;
};

static void _InitZGetterNode348(struct ZGetterNode348 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId348 = 348;
	o->_delta348 = sizeof(struct ZGetterNode348) - sizeof(struct ZNode49);
	o->FieldName = NULL;
	o->NameToken = NULL;
#ifdef _ZGetterNode348_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpz
#endif
#ifdef _ZGetterNode348_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpz
#endif
#ifdef _ZGetterNode348_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpz
#endif
#ifdef _ZGetterNode348_DeSugar
	o->DeSugar = DeSugar__2qpz
#endif
#ifdef _ZGetterNode348_Accept
	o->Accept = Accept__2qpz
#endif
	o->_nextId = 0;
}

static struct ZGetterNode348 * _NewZGetterNode348(void) {
	struct ZGetterNode348 *o = LibZen_Malloc(sizeof(struct ZGetterNode348));
	_InitZGetterNode348(o);
	return o;
}

struct ZGlobalNameNode353 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId353;
	int _delta353;
	const char * GlobalName;
	int IsStaticFuncName;
	int _nextId;
};

static void _InitZGlobalNameNode353(struct ZGlobalNameNode353 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId353 = 353;
	o->_delta353 = sizeof(struct ZGlobalNameNode353) - sizeof(struct ZNode49);
	o->GlobalName = NULL;
	o->IsStaticFuncName = 0/*false*/;
#ifdef _ZGlobalNameNode353_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qpn
#endif
#ifdef _ZGlobalNameNode353_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qpn
#endif
#ifdef _ZGlobalNameNode353_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qpn
#endif
#ifdef _ZGlobalNameNode353_DeSugar
	o->DeSugar = DeSugar__2qpn
#endif
#ifdef _ZGlobalNameNode353_Accept
	o->Accept = Accept__2qpn
#endif
	o->_nextId = 0;
}

static struct ZGlobalNameNode353 * _NewZGlobalNameNode353(void) {
	struct ZGlobalNameNode353 *o = LibZen_Malloc(sizeof(struct ZGlobalNameNode353));
	_InitZGlobalNameNode353(o);
	return o;
}

struct ZGroupNode357 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId357;
	int _delta357;
	int _nextId;
};

static void _InitZGroupNode357(struct ZGroupNode357 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId357 = 357;
	o->_delta357 = sizeof(struct ZGroupNode357) - sizeof(struct ZNode49);
#ifdef _ZGroupNode357_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qp3
#endif
#ifdef _ZGroupNode357_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qp3
#endif
#ifdef _ZGroupNode357_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qp3
#endif
#ifdef _ZGroupNode357_DeSugar
	o->DeSugar = DeSugar__2qp3
#endif
#ifdef _ZGroupNode357_Accept
	o->Accept = Accept__2qp3
#endif
	o->_nextId = 0;
}

static struct ZGroupNode357 * _NewZGroupNode357(void) {
	struct ZGroupNode357 *o = LibZen_Malloc(sizeof(struct ZGroupNode357));
	_InitZGroupNode357(o);
	return o;
}

struct ZIfNode360 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId360;
	int _delta360;
	int _nextId;
};

static void _InitZIfNode360(struct ZIfNode360 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId360 = 360;
	o->_delta360 = sizeof(struct ZIfNode360) - sizeof(struct ZNode49);
#ifdef _ZIfNode360_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0q
#endif
#ifdef _ZIfNode360_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0q
#endif
#ifdef _ZIfNode360_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0q
#endif
#ifdef _ZIfNode360_DeSugar
	o->DeSugar = DeSugar__2q0q
#endif
#ifdef _ZIfNode360_Accept
	o->Accept = Accept__2q0q
#endif
	o->_nextId = 0;
}

static struct ZIfNode360 * _NewZIfNode360(void) {
	struct ZIfNode360 *o = LibZen_Malloc(sizeof(struct ZIfNode360));
	_InitZIfNode360(o);
	return o;
}

struct ZImportNode363 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId363;
	int _delta363;
	const char * ResourcePath;
	const char * Alias;
	struct ZToken64 * ResourceToken;
	struct ZNode49 * (*)(struct ZImportNode363 *) Import;
	int _nextId;
};

static void _InitZImportNode363(struct ZImportNode363 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId363 = 363;
	o->_delta363 = sizeof(struct ZImportNode363) - sizeof(struct ZNode49);
	o->ResourcePath = NULL;
	o->Alias = NULL;
	o->ResourceToken = NULL;
	o->Import = NULL;
#ifdef _ZImportNode363_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0r
#endif
#ifdef _ZImportNode363_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0r
#endif
#ifdef _ZImportNode363_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0r
#endif
#ifdef _ZImportNode363_DeSugar
	o->DeSugar = DeSugar__2q0r
#endif
#ifdef _ZImportNode363_Accept
	o->Accept = Accept__2q0r
#endif
#ifdef _ZImportNode363_Import
	o->Import = Import__1q0r
#endif
	o->_nextId = 0;
}

static struct ZImportNode363 * _NewZImportNode363(void) {
	struct ZImportNode363 *o = LibZen_Malloc(sizeof(struct ZImportNode363));
	_InitZImportNode363(o);
	return o;
}

struct ZInstanceOfNode366 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId366;
	int _delta366;
	struct ZType59 * TargetType;
	int _nextId;
};

static void _InitZInstanceOfNode366(struct ZInstanceOfNode366 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId366 = 366;
	o->_delta366 = sizeof(struct ZInstanceOfNode366) - sizeof(struct ZNode49);
	o->TargetType = NULL;
#ifdef _ZInstanceOfNode366_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0u
#endif
#ifdef _ZInstanceOfNode366_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0u
#endif
#ifdef _ZInstanceOfNode366_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0u
#endif
#ifdef _ZInstanceOfNode366_DeSugar
	o->DeSugar = DeSugar__2q0u
#endif
#ifdef _ZInstanceOfNode366_Accept
	o->Accept = Accept__2q0u
#endif
	o->_nextId = 0;
}

static struct ZInstanceOfNode366 * _NewZInstanceOfNode366(void) {
	struct ZInstanceOfNode366 *o = LibZen_Malloc(sizeof(struct ZInstanceOfNode366));
	_InitZInstanceOfNode366(o);
	return o;
}

struct ZIntNode370 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId370;
	int _delta370;
	long IntValue;
	int _nextId;
};

static void _InitZIntNode370(struct ZIntNode370 * o) {
	_InitZConstNode325((struct ZConstNode325 *)o);
	o->_classId370 = 370;
	o->_delta370 = sizeof(struct ZIntNode370) - sizeof(struct ZConstNode325);
	o->IntValue = 0;
#ifdef _ZIntNode370_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q00
#endif
#ifdef _ZIntNode370_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q00
#endif
#ifdef _ZIntNode370_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q00
#endif
#ifdef _ZIntNode370_DeSugar
	o->DeSugar = DeSugar__2q00
#endif
#ifdef _ZIntNode370_Accept
	o->Accept = Accept__2q00
#endif
	o->_nextId = 0;
}

static struct ZIntNode370 * _NewZIntNode370(void) {
	struct ZIntNode370 *o = LibZen_Malloc(sizeof(struct ZIntNode370));
	_InitZIntNode370(o);
	return o;
}

struct ZLetNode373 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId373;
	int _delta373;
	const char * Symbol;
	struct ZToken64 * SymbolToken;
	struct ZType59 * SymbolType;
	const char * GlobalName;
	int _nextId;
};

static void _InitZLetNode373(struct ZLetNode373 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId373 = 373;
	o->_delta373 = sizeof(struct ZLetNode373) - sizeof(struct ZNode49);
	o->Symbol = NULL;
	o->SymbolToken = NULL;
	o->SymbolType = /*untyped*/NULL;
	o->GlobalName = NULL;
#ifdef _ZLetNode373_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0s
#endif
#ifdef _ZLetNode373_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0s
#endif
#ifdef _ZLetNode373_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0s
#endif
#ifdef _ZLetNode373_DeSugar
	o->DeSugar = DeSugar__2q0s
#endif
#ifdef _ZLetNode373_Accept
	o->Accept = Accept__2q0s
#endif
	o->_nextId = 0;
}

static struct ZLetNode373 * _NewZLetNode373(void) {
	struct ZLetNode373 *o = LibZen_Malloc(sizeof(struct ZLetNode373));
	_InitZLetNode373(o);
	return o;
}

struct ZListNode215 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _nextId;
};

static void _InitZListNode215(struct ZListNode215 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId215 = 215;
	o->_delta215 = sizeof(struct ZListNode215) - sizeof(struct ZNode49);
	o->ListStartIndex = 0;
#ifdef _ZListNode215_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qy8
#endif
#ifdef _ZListNode215_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qy8
#endif
#ifdef _ZListNode215_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qy8
#endif
#ifdef _ZListNode215_DeSugar
	o->DeSugar = DeSugar__2qy8
#endif
#ifdef _ZListNode215_Accept
	o->Accept = Accept__2qy8
#endif
	o->_nextId = 0;
}

static struct ZListNode215 * _NewZListNode215(void) {
	struct ZListNode215 *o = LibZen_Malloc(sizeof(struct ZListNode215));
	_InitZListNode215(o);
	return o;
}

struct ZMacroNode385 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId385;
	int _delta385;
	struct ZMacroFunc176 * MacroFunc;
	int _nextId;
};

static void _InitZMacroNode385(struct ZMacroNode385 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId385 = 385;
	o->_delta385 = sizeof(struct ZMacroNode385) - sizeof(struct ZListNode215);
	o->MacroFunc = NULL;
#ifdef _ZMacroNode385_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0x
#endif
#ifdef _ZMacroNode385_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0x
#endif
#ifdef _ZMacroNode385_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0x
#endif
#ifdef _ZMacroNode385_DeSugar
	o->DeSugar = DeSugar__2q0x
#endif
#ifdef _ZMacroNode385_Accept
	o->Accept = Accept__2q0x
#endif
	o->_nextId = 0;
}

static struct ZMacroNode385 * _NewZMacroNode385(void) {
	struct ZMacroNode385 *o = LibZen_Malloc(sizeof(struct ZMacroNode385));
	_InitZMacroNode385(o);
	return o;
}

struct ZMapEntryNode390 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId390;
	int _delta390;
	const char * Name;
	int _nextId;
};

static void _InitZMapEntryNode390(struct ZMapEntryNode390 * o) {
	_InitZNode49((struct ZNode49 *)o);
	o->_classId390 = 390;
	o->_delta390 = sizeof(struct ZMapEntryNode390) - sizeof(struct ZNode49);
	o->Name = NULL;
#ifdef _ZMapEntryNode390_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q0m
#endif
#ifdef _ZMapEntryNode390_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q0m
#endif
#ifdef _ZMapEntryNode390_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q0m
#endif
#ifdef _ZMapEntryNode390_DeSugar
	o->DeSugar = DeSugar__2q0m
#endif
#ifdef _ZMapEntryNode390_Accept
	o->Accept = Accept__2q0m
#endif
	o->_nextId = 0;
}

static struct ZMapEntryNode390 * _NewZMapEntryNode390(void) {
	struct ZMapEntryNode390 *o = LibZen_Malloc(sizeof(struct ZMapEntryNode390));
	_InitZMapEntryNode390(o);
	return o;
}

struct ZMapLiteralNode392 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId392;
	int _delta392;
	int _nextId;
};

static void _InitZMapLiteralNode392(struct ZMapLiteralNode392 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId392 = 392;
	o->_delta392 = sizeof(struct ZMapLiteralNode392) - sizeof(struct ZListNode215);
#ifdef _ZMapLiteralNode392_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q05
#endif
#ifdef _ZMapLiteralNode392_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q05
#endif
#ifdef _ZMapLiteralNode392_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q05
#endif
#ifdef _ZMapLiteralNode392_DeSugar
	o->DeSugar = DeSugar__2q05
#endif
#ifdef _ZMapLiteralNode392_Accept
	o->Accept = Accept__2q05
#endif
	o->_nextId = 0;
}

static struct ZMapLiteralNode392 * _NewZMapLiteralNode392(void) {
	struct ZMapLiteralNode392 *o = LibZen_Malloc(sizeof(struct ZMapLiteralNode392));
	_InitZMapLiteralNode392(o);
	return o;
}

struct ZMethodCallNode396 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId396;
	int _delta396;
	const char * MethodName;
	struct ZToken64 * MethodToken;
	int _nextId;
};

static void _InitZMethodCallNode396(struct ZMethodCallNode396 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId396 = 396;
	o->_delta396 = sizeof(struct ZMethodCallNode396) - sizeof(struct ZListNode215);
	o->MethodName = NULL;
	o->MethodToken = NULL;
#ifdef _ZMethodCallNode396_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4q
#endif
#ifdef _ZMethodCallNode396_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4q
#endif
#ifdef _ZMethodCallNode396_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4q
#endif
#ifdef _ZMethodCallNode396_DeSugar
	o->DeSugar = DeSugar__2q4q
#endif
#ifdef _ZMethodCallNode396_Accept
	o->Accept = Accept__2q4q
#endif
	o->_nextId = 0;
}

static struct ZMethodCallNode396 * _NewZMethodCallNode396(void) {
	struct ZMethodCallNode396 *o = LibZen_Malloc(sizeof(struct ZMethodCallNode396));
	_InitZMethodCallNode396(o);
	return o;
}

struct ZNewArrayNode403 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId403;
	int _delta403;
	int _nextId;
};

static void _InitZNewArrayNode403(struct ZNewArrayNode403 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId403 = 403;
	o->_delta403 = sizeof(struct ZNewArrayNode403) - sizeof(struct ZListNode215);
#ifdef _ZNewArrayNode403_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4i
#endif
#ifdef _ZNewArrayNode403_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4i
#endif
#ifdef _ZNewArrayNode403_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4i
#endif
#ifdef _ZNewArrayNode403_DeSugar
	o->DeSugar = DeSugar__2q4i
#endif
#ifdef _ZNewArrayNode403_Accept
	o->Accept = Accept__2q4i
#endif
	o->_nextId = 0;
}

static struct ZNewArrayNode403 * _NewZNewArrayNode403(void) {
	struct ZNewArrayNode403 *o = LibZen_Malloc(sizeof(struct ZNewArrayNode403));
	_InitZNewArrayNode403(o);
	return o;
}

struct ZNewObjectNode405 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId405;
	int _delta405;
	int _nextId;
};

static void _InitZNewObjectNode405(struct ZNewObjectNode405 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId405 = 405;
	o->_delta405 = sizeof(struct ZNewObjectNode405) - sizeof(struct ZListNode215);
#ifdef _ZNewObjectNode405_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4p
#endif
#ifdef _ZNewObjectNode405_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4p
#endif
#ifdef _ZNewObjectNode405_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4p
#endif
#ifdef _ZNewObjectNode405_DeSugar
	o->DeSugar = DeSugar__2q4p
#endif
#ifdef _ZNewObjectNode405_Accept
	o->Accept = Accept__2q4p
#endif
	o->_nextId = 0;
}

static struct ZNewObjectNode405 * _NewZNewObjectNode405(void) {
	struct ZNewObjectNode405 *o = LibZen_Malloc(sizeof(struct ZNewObjectNode405));
	_InitZNewObjectNode405(o);
	return o;
}

struct ZNotNode409 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId162;
	int _delta162;
	int _classId409;
	int _delta409;
	int _nextId;
};

static void _InitZNotNode409(struct ZNotNode409 * o) {
	_InitZUnaryNode162((struct ZUnaryNode162 *)o);
	o->_classId409 = 409;
	o->_delta409 = sizeof(struct ZNotNode409) - sizeof(struct ZUnaryNode162);
#ifdef _ZNotNode409_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4s
#endif
#ifdef _ZNotNode409_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4s
#endif
#ifdef _ZNotNode409_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4s
#endif
#ifdef _ZNotNode409_DeSugar
	o->DeSugar = DeSugar__2q4s
#endif
#ifdef _ZNotNode409_Accept
	o->Accept = Accept__2q4s
#endif
	o->_nextId = 0;
}

static struct ZNotNode409 * _NewZNotNode409(void) {
	struct ZNotNode409 *o = LibZen_Malloc(sizeof(struct ZNotNode409));
	_InitZNotNode409(o);
	return o;
}

struct ZNullNode412 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId412;
	int _delta412;
	int _nextId;
};

static void _InitZNullNode412(struct ZNullNode412 * o) {
	_InitZConstNode325((struct ZConstNode325 *)o);
	o->_classId412 = 412;
	o->_delta412 = sizeof(struct ZNullNode412) - sizeof(struct ZConstNode325);
#ifdef _ZNullNode412_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4g
#endif
#ifdef _ZNullNode412_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4g
#endif
#ifdef _ZNullNode412_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4g
#endif
#ifdef _ZNullNode412_DeSugar
	o->DeSugar = DeSugar__2q4g
#endif
#ifdef _ZNullNode412_Accept
	o->Accept = Accept__2q4g
#endif
	o->_nextId = 0;
}

static struct ZNullNode412 * _NewZNullNode412(void) {
	struct ZNullNode412 *o = LibZen_Malloc(sizeof(struct ZNullNode412));
	_InitZNullNode412(o);
	return o;
}

struct ZOrNode415 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId304;
	int _delta304;
	struct ZSyntax184 * Pattern;
	int _classId415;
	int _delta415;
	int _nextId;
};

static void _InitZOrNode415(struct ZOrNode415 * o) {
	_InitZBinaryNode304((struct ZBinaryNode304 *)o);
	o->_classId415 = 415;
	o->_delta415 = sizeof(struct ZOrNode415) - sizeof(struct ZBinaryNode304);
#ifdef _ZOrNode415_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4k
#endif
#ifdef _ZOrNode415_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4k
#endif
#ifdef _ZOrNode415_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4k
#endif
#ifdef _ZOrNode415_DeSugar
	o->DeSugar = DeSugar__2q4k
#endif
#ifdef _ZOrNode415_Accept
	o->Accept = Accept__2q4k
#endif
	o->_nextId = 0;
}

static struct ZOrNode415 * _NewZOrNode415(void) {
	struct ZOrNode415 *o = LibZen_Malloc(sizeof(struct ZOrNode415));
	_InitZOrNode415(o);
	return o;
}

struct ZPrototypeNode418 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId418;
	int _delta418;
	struct ZType59 * ReturnType;
	const char * FuncName;
	struct ZToken64 * NameToken;
	int _nextId;
};

static void _InitZPrototypeNode418(struct ZPrototypeNode418 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId418 = 418;
	o->_delta418 = sizeof(struct ZPrototypeNode418) - sizeof(struct ZListNode215);
	o->ReturnType = /*untyped*/NULL;
	o->FuncName = NULL;
	o->NameToken = NULL;
#ifdef _ZPrototypeNode418_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q41
#endif
#ifdef _ZPrototypeNode418_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q41
#endif
#ifdef _ZPrototypeNode418_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q41
#endif
#ifdef _ZPrototypeNode418_DeSugar
	o->DeSugar = DeSugar__2q41
#endif
#ifdef _ZPrototypeNode418_Accept
	o->Accept = Accept__2q41
#endif
	o->_nextId = 0;
}

static struct ZPrototypeNode418 * _NewZPrototypeNode418(void) {
	struct ZPrototypeNode418 *o = LibZen_Malloc(sizeof(struct ZPrototypeNode418));
	_InitZPrototypeNode418(o);
	return o;
}

struct ZStringNode424 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId424;
	int _delta424;
	const char * StringValue;
	int _nextId;
};

static void _InitZStringNode424(struct ZStringNode424 * o) {
	_InitZConstNode325((struct ZConstNode325 *)o);
	o->_classId424 = 424;
	o->_delta424 = sizeof(struct ZStringNode424) - sizeof(struct ZConstNode325);
	o->StringValue = NULL;
#ifdef _ZStringNode424_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4b
#endif
#ifdef _ZStringNode424_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4b
#endif
#ifdef _ZStringNode424_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4b
#endif
#ifdef _ZStringNode424_DeSugar
	o->DeSugar = DeSugar__2q4b
#endif
#ifdef _ZStringNode424_Accept
	o->Accept = Accept__2q4b
#endif
	o->_nextId = 0;
}

static struct ZStringNode424 * _NewZStringNode424(void) {
	struct ZStringNode424 *o = LibZen_Malloc(sizeof(struct ZStringNode424));
	_InitZStringNode424(o);
	return o;
}

struct ZStupidCastErrorNode427 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId329;
	int _delta329;
	const char * ErrorMessage;
	int _classId427;
	int _delta427;
	struct ZNode49 * ErrorNode;
	int _nextId;
};

static void _InitZStupidCastErrorNode427(struct ZStupidCastErrorNode427 * o) {
	_InitZErrorNode329((struct ZErrorNode329 *)o);
	o->_classId427 = 427;
	o->_delta427 = sizeof(struct ZStupidCastErrorNode427) - sizeof(struct ZErrorNode329);
	o->ErrorNode = NULL;
#ifdef _ZStupidCastErrorNode427_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q47
#endif
#ifdef _ZStupidCastErrorNode427_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q47
#endif
#ifdef _ZStupidCastErrorNode427_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q47
#endif
#ifdef _ZStupidCastErrorNode427_DeSugar
	o->DeSugar = DeSugar__2q47
#endif
#ifdef _ZStupidCastErrorNode427_Accept
	o->Accept = Accept__2q47
#endif
	o->_nextId = 0;
}

static struct ZStupidCastErrorNode427 * _NewZStupidCastErrorNode427(void) {
	struct ZStupidCastErrorNode427 *o = LibZen_Malloc(sizeof(struct ZStupidCastErrorNode427));
	_InitZStupidCastErrorNode427(o);
	return o;
}

struct ZTypeNode199 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId199;
	int _delta199;
	int _nextId;
};

static void _InitZTypeNode199(struct ZTypeNode199 * o) {
	_InitZConstNode325((struct ZConstNode325 *)o);
	o->_classId199 = 199;
	o->_delta199 = sizeof(struct ZTypeNode199) - sizeof(struct ZConstNode325);
#ifdef _ZTypeNode199_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qyk
#endif
#ifdef _ZTypeNode199_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qyk
#endif
#ifdef _ZTypeNode199_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qyk
#endif
#ifdef _ZTypeNode199_DeSugar
	o->DeSugar = DeSugar__2qyk
#endif
#ifdef _ZTypeNode199_Accept
	o->Accept = Accept__2qyk
#endif
	o->_nextId = 0;
}

static struct ZTypeNode199 * _NewZTypeNode199(void) {
	struct ZTypeNode199 *o = LibZen_Malloc(sizeof(struct ZTypeNode199));
	_InitZTypeNode199(o);
	return o;
}

struct ZGenerator52 {
	int _classId132;
	int _delta132;
	void (*)(struct ZVisitor132 *,struct ZNullNode412 *) VisitNullNode;
	void (*)(struct ZVisitor132 *,struct ZBooleanNode469 *) VisitBooleanNode;
	void (*)(struct ZVisitor132 *,struct ZIntNode370 *) VisitIntNode;
	void (*)(struct ZVisitor132 *,struct ZFloatNode337 *) VisitFloatNode;
	void (*)(struct ZVisitor132 *,struct ZStringNode424 *) VisitStringNode;
	void (*)(struct ZVisitor132 *,struct ZArrayLiteralNode474 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZMapLiteralNode392 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZNewObjectNode405 *) VisitNewObjectNode;
	void (*)(struct ZVisitor132 *,struct ZGlobalNameNode353 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor132 *,struct ZGetNameNode343 *) VisitGetNameNode;
	void (*)(struct ZVisitor132 *,struct ZSetNameNode146 *) VisitSetNameNode;
	void (*)(struct ZVisitor132 *,struct ZGroupNode357 *) VisitGroupNode;
	void (*)(struct ZVisitor132 *,struct ZGetterNode348 *) VisitGetterNode;
	void (*)(struct ZVisitor132 *,struct ZSetterNode149 *) VisitSetterNode;
	void (*)(struct ZVisitor132 *,struct ZGetIndexNode340 *) VisitGetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZSetIndexNode143 *) VisitSetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZMethodCallNode396 *) VisitMethodCallNode;
	void (*)(struct ZVisitor132 *,struct ZFuncCallNode400 *) VisitFuncCallNode;
	void (*)(struct ZVisitor132 *,struct ZMacroNode385 *) VisitMacroNode;
	void (*)(struct ZVisitor132 *,struct ZUnaryNode162 *) VisitUnaryNode;
	void (*)(struct ZVisitor132 *,struct ZNotNode409 *) VisitNotNode;
	void (*)(struct ZVisitor132 *,struct ZCastNode314 *) VisitCastNode;
	void (*)(struct ZVisitor132 *,struct ZInstanceOfNode366 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor132 *,struct ZBinaryNode304 *) VisitBinaryNode;
	void (*)(struct ZVisitor132 *,struct ZComparatorNode322 *) VisitComparatorNode;
	void (*)(struct ZVisitor132 *,struct ZAndNode495 *) VisitAndNode;
	void (*)(struct ZVisitor132 *,struct ZOrNode415 *) VisitOrNode;
	void (*)(struct ZVisitor132 *,struct ZBlockNode126 *) VisitBlockNode;
	void (*)(struct ZVisitor132 *,struct ZVarNode499 *) VisitVarNode;
	void (*)(struct ZVisitor132 *,struct ZIfNode360 *) VisitIfNode;
	void (*)(struct ZVisitor132 *,struct ZReturnNode135 *) VisitReturnNode;
	void (*)(struct ZVisitor132 *,struct ZWhileNode165 *) VisitWhileNode;
	void (*)(struct ZVisitor132 *,struct ZBreakNode311 *) VisitBreakNode;
	void (*)(struct ZVisitor132 *,struct ZThrowNode156 *) VisitThrowNode;
	void (*)(struct ZVisitor132 *,struct ZTryNode159 *) VisitTryNode;
	void (*)(struct ZVisitor132 *,struct ZLetNode373 *) VisitLetNode;
	void (*)(struct ZVisitor132 *,struct ZFunctionNode109 *) VisitFunctionNode;
	void (*)(struct ZVisitor132 *,struct ZClassNode509 *) VisitClassNode;
	void (*)(struct ZVisitor132 *,struct ZErrorNode329 *) VisitErrorNode;
	void (*)(struct ZVisitor132 *,struct ZNode49 *) VisitExtendedNode;
	void (*)(struct ZVisitor132 *,struct ZSugarNode130 *) VisitSugarNode;
	void (*)(struct ZVisitor132 *) EnableVisitor;
	void (*)(struct ZVisitor132 *) StopVisitor;
	int (*)(struct ZVisitor132 *) IsVisitable;
	int _classId52;
	int _delta52;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace43 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger99 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine54 * (*)(struct ZGenerator52 *) GetEngine;
	void (*)(struct ZGenerator52 *,struct ZNameSpace43 *) ImportLocalGrammar;
	void (*)(struct ZGenerator52 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator52 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator52 *,struct ZNode49 *,int) StartCodeGeneration;
	struct ZType59 * (*)(struct ZGenerator52 *,struct ZType59 *,const char *) GetFieldType;
	struct ZType59 * (*)(struct ZGenerator52 *,struct ZType59 *,const char *) GetSetterType;
	struct ZFuncType67 * (*)(struct ZGenerator52 *,struct ZType59 *,struct ZListNode215 *) GetConstructorFuncType;
	struct ZFuncType67 * (*)(struct ZGenerator52 *,struct ZType59 *,const char *,struct ZListNode215 *) GetMethodFuncType;
	int _nextId;
};

static void _InitZGenerator52(struct ZGenerator52 * o) {
	_InitZVisitor132((struct ZVisitor132 *)o);
	o->_classId52 = 52;
	o->_delta52 = sizeof(struct ZGenerator52) - sizeof(struct ZVisitor132);
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
#ifdef _ZGenerator52_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qwg
#endif
#ifdef _ZGenerator52_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qwg
#endif
#ifdef _ZGenerator52_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qwg
#endif
#ifdef _ZGenerator52_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qwg
#endif
#ifdef _ZGenerator52_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qwg
#endif
#ifdef _ZGenerator52_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qwg
#endif
#ifdef _ZGenerator52_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qwg
#endif
#ifdef _ZGenerator52_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qwg
#endif
#ifdef _ZGenerator52_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qwg
#endif
#ifdef _ZGenerator52_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qwg
#endif
#ifdef _ZGenerator52_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qwg
#endif
#ifdef _ZGenerator52_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qwg
#endif
#ifdef _ZGenerator52_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qwg
#endif
#ifdef _ZGenerator52_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qwg
#endif
#ifdef _ZGenerator52_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qwg
#endif
#ifdef _ZGenerator52_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qwg
#endif
#ifdef _ZGenerator52_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qwg
#endif
#ifdef _ZGenerator52_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qwg
#endif
#ifdef _ZGenerator52_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qwg
#endif
#ifdef _ZGenerator52_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qwg
#endif
#ifdef _ZGenerator52_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qwg
#endif
#ifdef _ZGenerator52_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qwg
#endif
#ifdef _ZGenerator52_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qwg
#endif
#ifdef _ZGenerator52_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qwg
#endif
#ifdef _ZGenerator52_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qwg
#endif
#ifdef _ZGenerator52_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qwg
#endif
#ifdef _ZGenerator52_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qwg
#endif
#ifdef _ZGenerator52_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qwg
#endif
#ifdef _ZGenerator52_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qwg
#endif
#ifdef _ZGenerator52_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qwg
#endif
#ifdef _ZGenerator52_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qwg
#endif
#ifdef _ZGenerator52_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qwg
#endif
#ifdef _ZGenerator52_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qwg
#endif
#ifdef _ZGenerator52_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qwg
#endif
#ifdef _ZGenerator52_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qwg
#endif
#ifdef _ZGenerator52_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qwg
#endif
#ifdef _ZGenerator52_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qwg
#endif
#ifdef _ZGenerator52_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qwg
#endif
#ifdef _ZGenerator52_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qwg
#endif
#ifdef _ZGenerator52_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qwg
#endif
#ifdef _ZGenerator52_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qwg
#endif
#ifdef _ZGenerator52_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qwg
#endif
#ifdef _ZGenerator52_StopVisitor
	o->StopVisitor = StopVisitor__1qwg
#endif
#ifdef _ZGenerator52_IsVisitable
	o->IsVisitable = IsVisitable__1qwg
#endif
#ifdef _ZGenerator52_GetEngine
	o->GetEngine = GetEngine__1qwg
#endif
#ifdef _ZGenerator52_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qwg
#endif
#ifdef _ZGenerator52_WriteTo
	o->WriteTo = WriteTo__2qwg
#endif
#ifdef _ZGenerator52_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qwg
#endif
#ifdef _ZGenerator52_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qwg
#endif
#ifdef _ZGenerator52_GetFieldType
	o->GetFieldType = GetFieldType__3qwg
#endif
#ifdef _ZGenerator52_GetSetterType
	o->GetSetterType = GetSetterType__3qwg
#endif
#ifdef _ZGenerator52_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qwg
#endif
#ifdef _ZGenerator52_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qwg
#endif
	o->_nextId = 0;
}

static struct ZGenerator52 * _NewZGenerator52(void) {
	struct ZGenerator52 *o = LibZen_Malloc(sizeof(struct ZGenerator52));
	_InitZGenerator52(o);
	return o;
}

struct ZIndentToken453 {
	int _classId64;
	int _delta64;
	struct ZSource202 * Source;
	long StartIndex;
	long EndIndex;
	int _classId453;
	int _delta453;
	int _nextId;
};

static void _InitZIndentToken453(struct ZIndentToken453 * o) {
	_InitZToken64((struct ZToken64 *)o);
	o->_classId453 = 453;
	o->_delta453 = sizeof(struct ZIndentToken453) - sizeof(struct ZToken64);
	o->_nextId = 0;
}

static struct ZIndentToken453 * _NewZIndentToken453(void) {
	struct ZIndentToken453 *o = LibZen_Malloc(sizeof(struct ZIndentToken453));
	_InitZIndentToken453(o);
	return o;
}

struct ZPatternToken455 {
	int _classId64;
	int _delta64;
	struct ZSource202 * Source;
	long StartIndex;
	long EndIndex;
	int _classId455;
	int _delta455;
	struct ZSyntax184 * PresetPattern;
	int _nextId;
};

static void _InitZPatternToken455(struct ZPatternToken455 * o) {
	_InitZToken64((struct ZToken64 *)o);
	o->_classId455 = 455;
	o->_delta455 = sizeof(struct ZPatternToken455) - sizeof(struct ZToken64);
	o->PresetPattern = NULL;
	o->_nextId = 0;
}

static struct ZPatternToken455 * _NewZPatternToken455(void) {
	struct ZPatternToken455 *o = LibZen_Malloc(sizeof(struct ZPatternToken455));
	_InitZPatternToken455(o);
	return o;
}

struct ZSourceEngine54 {
	int _classId132;
	int _delta132;
	void (*)(struct ZVisitor132 *,struct ZNullNode412 *) VisitNullNode;
	void (*)(struct ZVisitor132 *,struct ZBooleanNode469 *) VisitBooleanNode;
	void (*)(struct ZVisitor132 *,struct ZIntNode370 *) VisitIntNode;
	void (*)(struct ZVisitor132 *,struct ZFloatNode337 *) VisitFloatNode;
	void (*)(struct ZVisitor132 *,struct ZStringNode424 *) VisitStringNode;
	void (*)(struct ZVisitor132 *,struct ZArrayLiteralNode474 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZMapLiteralNode392 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZNewObjectNode405 *) VisitNewObjectNode;
	void (*)(struct ZVisitor132 *,struct ZGlobalNameNode353 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor132 *,struct ZGetNameNode343 *) VisitGetNameNode;
	void (*)(struct ZVisitor132 *,struct ZSetNameNode146 *) VisitSetNameNode;
	void (*)(struct ZVisitor132 *,struct ZGroupNode357 *) VisitGroupNode;
	void (*)(struct ZVisitor132 *,struct ZGetterNode348 *) VisitGetterNode;
	void (*)(struct ZVisitor132 *,struct ZSetterNode149 *) VisitSetterNode;
	void (*)(struct ZVisitor132 *,struct ZGetIndexNode340 *) VisitGetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZSetIndexNode143 *) VisitSetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZMethodCallNode396 *) VisitMethodCallNode;
	void (*)(struct ZVisitor132 *,struct ZFuncCallNode400 *) VisitFuncCallNode;
	void (*)(struct ZVisitor132 *,struct ZMacroNode385 *) VisitMacroNode;
	void (*)(struct ZVisitor132 *,struct ZUnaryNode162 *) VisitUnaryNode;
	void (*)(struct ZVisitor132 *,struct ZNotNode409 *) VisitNotNode;
	void (*)(struct ZVisitor132 *,struct ZCastNode314 *) VisitCastNode;
	void (*)(struct ZVisitor132 *,struct ZInstanceOfNode366 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor132 *,struct ZBinaryNode304 *) VisitBinaryNode;
	void (*)(struct ZVisitor132 *,struct ZComparatorNode322 *) VisitComparatorNode;
	void (*)(struct ZVisitor132 *,struct ZAndNode495 *) VisitAndNode;
	void (*)(struct ZVisitor132 *,struct ZOrNode415 *) VisitOrNode;
	void (*)(struct ZVisitor132 *,struct ZBlockNode126 *) VisitBlockNode;
	void (*)(struct ZVisitor132 *,struct ZVarNode499 *) VisitVarNode;
	void (*)(struct ZVisitor132 *,struct ZIfNode360 *) VisitIfNode;
	void (*)(struct ZVisitor132 *,struct ZReturnNode135 *) VisitReturnNode;
	void (*)(struct ZVisitor132 *,struct ZWhileNode165 *) VisitWhileNode;
	void (*)(struct ZVisitor132 *,struct ZBreakNode311 *) VisitBreakNode;
	void (*)(struct ZVisitor132 *,struct ZThrowNode156 *) VisitThrowNode;
	void (*)(struct ZVisitor132 *,struct ZTryNode159 *) VisitTryNode;
	void (*)(struct ZVisitor132 *,struct ZLetNode373 *) VisitLetNode;
	void (*)(struct ZVisitor132 *,struct ZFunctionNode109 *) VisitFunctionNode;
	void (*)(struct ZVisitor132 *,struct ZClassNode509 *) VisitClassNode;
	void (*)(struct ZVisitor132 *,struct ZErrorNode329 *) VisitErrorNode;
	void (*)(struct ZVisitor132 *,struct ZNode49 *) VisitExtendedNode;
	void (*)(struct ZVisitor132 *,struct ZSugarNode130 *) VisitSugarNode;
	void (*)(struct ZVisitor132 *) EnableVisitor;
	void (*)(struct ZVisitor132 *) StopVisitor;
	int (*)(struct ZVisitor132 *) IsVisitable;
	int _classId54;
	int _delta54;
	struct ZTypeChecker106 * TypeChecker;
	struct ZGenerator52 * Generator;
	struct ZLogger99 * Logger;
	int InteractiveContext;
	int _nextId;
};

static void _InitZSourceEngine54(struct ZSourceEngine54 * o) {
	_InitZVisitor132((struct ZVisitor132 *)o);
	o->_classId54 = 54;
	o->_delta54 = sizeof(struct ZSourceEngine54) - sizeof(struct ZVisitor132);
	o->TypeChecker = NULL;
	o->Generator = NULL;
	o->Logger = NULL;
	o->InteractiveContext = 0/*false*/;
	o->IsVisitable = 1/*true*/;
#ifdef _ZSourceEngine54_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qwj
#endif
#ifdef _ZSourceEngine54_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qwj
#endif
#ifdef _ZSourceEngine54_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qwj
#endif
#ifdef _ZSourceEngine54_StopVisitor
	o->StopVisitor = StopVisitor__1qwj
#endif
#ifdef _ZSourceEngine54_IsVisitable
	o->IsVisitable = IsVisitable__1qwj
#endif
	o->_nextId = 0;
}

static struct ZSourceEngine54 * _NewZSourceEngine54(void) {
	struct ZSourceEngine54 *o = LibZen_Malloc(sizeof(struct ZSourceEngine54));
	_InitZSourceEngine54(o);
	return o;
}

struct ZSourceGenerator207 {
	int _classId132;
	int _delta132;
	void (*)(struct ZVisitor132 *,struct ZNullNode412 *) VisitNullNode;
	void (*)(struct ZVisitor132 *,struct ZBooleanNode469 *) VisitBooleanNode;
	void (*)(struct ZVisitor132 *,struct ZIntNode370 *) VisitIntNode;
	void (*)(struct ZVisitor132 *,struct ZFloatNode337 *) VisitFloatNode;
	void (*)(struct ZVisitor132 *,struct ZStringNode424 *) VisitStringNode;
	void (*)(struct ZVisitor132 *,struct ZArrayLiteralNode474 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZMapLiteralNode392 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZNewObjectNode405 *) VisitNewObjectNode;
	void (*)(struct ZVisitor132 *,struct ZGlobalNameNode353 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor132 *,struct ZGetNameNode343 *) VisitGetNameNode;
	void (*)(struct ZVisitor132 *,struct ZSetNameNode146 *) VisitSetNameNode;
	void (*)(struct ZVisitor132 *,struct ZGroupNode357 *) VisitGroupNode;
	void (*)(struct ZVisitor132 *,struct ZGetterNode348 *) VisitGetterNode;
	void (*)(struct ZVisitor132 *,struct ZSetterNode149 *) VisitSetterNode;
	void (*)(struct ZVisitor132 *,struct ZGetIndexNode340 *) VisitGetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZSetIndexNode143 *) VisitSetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZMethodCallNode396 *) VisitMethodCallNode;
	void (*)(struct ZVisitor132 *,struct ZFuncCallNode400 *) VisitFuncCallNode;
	void (*)(struct ZVisitor132 *,struct ZMacroNode385 *) VisitMacroNode;
	void (*)(struct ZVisitor132 *,struct ZUnaryNode162 *) VisitUnaryNode;
	void (*)(struct ZVisitor132 *,struct ZNotNode409 *) VisitNotNode;
	void (*)(struct ZVisitor132 *,struct ZCastNode314 *) VisitCastNode;
	void (*)(struct ZVisitor132 *,struct ZInstanceOfNode366 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor132 *,struct ZBinaryNode304 *) VisitBinaryNode;
	void (*)(struct ZVisitor132 *,struct ZComparatorNode322 *) VisitComparatorNode;
	void (*)(struct ZVisitor132 *,struct ZAndNode495 *) VisitAndNode;
	void (*)(struct ZVisitor132 *,struct ZOrNode415 *) VisitOrNode;
	void (*)(struct ZVisitor132 *,struct ZBlockNode126 *) VisitBlockNode;
	void (*)(struct ZVisitor132 *,struct ZVarNode499 *) VisitVarNode;
	void (*)(struct ZVisitor132 *,struct ZIfNode360 *) VisitIfNode;
	void (*)(struct ZVisitor132 *,struct ZReturnNode135 *) VisitReturnNode;
	void (*)(struct ZVisitor132 *,struct ZWhileNode165 *) VisitWhileNode;
	void (*)(struct ZVisitor132 *,struct ZBreakNode311 *) VisitBreakNode;
	void (*)(struct ZVisitor132 *,struct ZThrowNode156 *) VisitThrowNode;
	void (*)(struct ZVisitor132 *,struct ZTryNode159 *) VisitTryNode;
	void (*)(struct ZVisitor132 *,struct ZLetNode373 *) VisitLetNode;
	void (*)(struct ZVisitor132 *,struct ZFunctionNode109 *) VisitFunctionNode;
	void (*)(struct ZVisitor132 *,struct ZClassNode509 *) VisitClassNode;
	void (*)(struct ZVisitor132 *,struct ZErrorNode329 *) VisitErrorNode;
	void (*)(struct ZVisitor132 *,struct ZNode49 *) VisitExtendedNode;
	void (*)(struct ZVisitor132 *,struct ZSugarNode130 *) VisitSugarNode;
	void (*)(struct ZVisitor132 *) EnableVisitor;
	void (*)(struct ZVisitor132 *) StopVisitor;
	int (*)(struct ZVisitor132 *) IsVisitable;
	int _classId52;
	int _delta52;
	const char * GrammarInfo;
	const char * LanguageExtention;
	const char * TargetVersion;
	struct ZNameSpace43 * RootNameSpace;
	long UniqueNumber;
	const char * OutputFile;
	struct ZLogger99 * Logger;
	MapOfZFunc * DefinedFuncMap;
	int StoppedVisitor;
	struct ZSourceEngine54 * (*)(struct ZGenerator52 *) GetEngine;
	void (*)(struct ZGenerator52 *,struct ZNameSpace43 *) ImportLocalGrammar;
	void (*)(struct ZGenerator52 *,const char *) WriteTo;
	const char * (*)(struct ZGenerator52 *,const char *) NameOutputFile;
	int (*)(struct ZGenerator52 *,struct ZNode49 *,int) StartCodeGeneration;
	struct ZType59 * (*)(struct ZGenerator52 *,struct ZType59 *,const char *) GetFieldType;
	struct ZType59 * (*)(struct ZGenerator52 *,struct ZType59 *,const char *) GetSetterType;
	struct ZFuncType67 * (*)(struct ZGenerator52 *,struct ZType59 *,struct ZListNode215 *) GetConstructorFuncType;
	struct ZFuncType67 * (*)(struct ZGenerator52 *,struct ZType59 *,const char *,struct ZListNode215 *) GetMethodFuncType;
	int _classId207;
	int _delta207;
	MapOfString * NativeTypeMap;
	MapOfString * ReservedNameMap;
	ArrayOfZSourceBuilder * BuilderList;
	struct ZSourceBuilder37 * HeaderBuilder;
	struct ZSourceBuilder37 * CurrentBuilder;
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
	void (*)(struct ZSourceGenerator207 *) InitBuilderList;
	void (*)(struct ZSourceGenerator207 *,struct ZType59 *,struct ZNode49 *) GenerateCode;
	int _nextId;
};

static void _InitZSourceGenerator207(struct ZSourceGenerator207 * o) {
	_InitZGenerator52((struct ZGenerator52 *)o);
	o->_classId207 = 207;
	o->_delta207 = sizeof(struct ZSourceGenerator207) - sizeof(struct ZGenerator52);
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
#ifdef _ZSourceGenerator207_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qyv
#endif
#ifdef _ZSourceGenerator207_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qyv
#endif
#ifdef _ZSourceGenerator207_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qyv
#endif
#ifdef _ZSourceGenerator207_StopVisitor
	o->StopVisitor = StopVisitor__1qyv
#endif
#ifdef _ZSourceGenerator207_IsVisitable
	o->IsVisitable = IsVisitable__1qyv
#endif
#ifdef _ZSourceGenerator207_GetEngine
	o->GetEngine = GetEngine__1qyv
#endif
#ifdef _ZSourceGenerator207_ImportLocalGrammar
	o->ImportLocalGrammar = ImportLocalGrammar__2qyv
#endif
#ifdef _ZSourceGenerator207_WriteTo
	o->WriteTo = WriteTo__2qyv
#endif
#ifdef _ZSourceGenerator207_NameOutputFile
	o->NameOutputFile = NameOutputFile__2qyv
#endif
#ifdef _ZSourceGenerator207_StartCodeGeneration
	o->StartCodeGeneration = StartCodeGeneration__3qyv
#endif
#ifdef _ZSourceGenerator207_GetFieldType
	o->GetFieldType = GetFieldType__3qyv
#endif
#ifdef _ZSourceGenerator207_GetSetterType
	o->GetSetterType = GetSetterType__3qyv
#endif
#ifdef _ZSourceGenerator207_GetConstructorFuncType
	o->GetConstructorFuncType = GetConstructorFuncType__3qyv
#endif
#ifdef _ZSourceGenerator207_GetMethodFuncType
	o->GetMethodFuncType = GetMethodFuncType__4qyv
#endif
#ifdef _ZSourceGenerator207_InitBuilderList
	o->InitBuilderList = InitBuilderList__1qyv
#endif
#ifdef _ZSourceGenerator207_GenerateCode
	o->GenerateCode = GenerateCode__3qyv
#endif
	o->_nextId = 0;
}

static struct ZSourceGenerator207 * _NewZSourceGenerator207(void) {
	struct ZSourceGenerator207 *o = LibZen_Malloc(sizeof(struct ZSourceGenerator207));
	_InitZSourceGenerator207(o);
	return o;
}

struct ZTypeChecker106 {
	int _classId132;
	int _delta132;
	void (*)(struct ZVisitor132 *,struct ZNullNode412 *) VisitNullNode;
	void (*)(struct ZVisitor132 *,struct ZBooleanNode469 *) VisitBooleanNode;
	void (*)(struct ZVisitor132 *,struct ZIntNode370 *) VisitIntNode;
	void (*)(struct ZVisitor132 *,struct ZFloatNode337 *) VisitFloatNode;
	void (*)(struct ZVisitor132 *,struct ZStringNode424 *) VisitStringNode;
	void (*)(struct ZVisitor132 *,struct ZArrayLiteralNode474 *) VisitArrayLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZMapLiteralNode392 *) VisitMapLiteralNode;
	void (*)(struct ZVisitor132 *,struct ZNewObjectNode405 *) VisitNewObjectNode;
	void (*)(struct ZVisitor132 *,struct ZGlobalNameNode353 *) VisitGlobalNameNode;
	void (*)(struct ZVisitor132 *,struct ZGetNameNode343 *) VisitGetNameNode;
	void (*)(struct ZVisitor132 *,struct ZSetNameNode146 *) VisitSetNameNode;
	void (*)(struct ZVisitor132 *,struct ZGroupNode357 *) VisitGroupNode;
	void (*)(struct ZVisitor132 *,struct ZGetterNode348 *) VisitGetterNode;
	void (*)(struct ZVisitor132 *,struct ZSetterNode149 *) VisitSetterNode;
	void (*)(struct ZVisitor132 *,struct ZGetIndexNode340 *) VisitGetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZSetIndexNode143 *) VisitSetIndexNode;
	void (*)(struct ZVisitor132 *,struct ZMethodCallNode396 *) VisitMethodCallNode;
	void (*)(struct ZVisitor132 *,struct ZFuncCallNode400 *) VisitFuncCallNode;
	void (*)(struct ZVisitor132 *,struct ZMacroNode385 *) VisitMacroNode;
	void (*)(struct ZVisitor132 *,struct ZUnaryNode162 *) VisitUnaryNode;
	void (*)(struct ZVisitor132 *,struct ZNotNode409 *) VisitNotNode;
	void (*)(struct ZVisitor132 *,struct ZCastNode314 *) VisitCastNode;
	void (*)(struct ZVisitor132 *,struct ZInstanceOfNode366 *) VisitInstanceOfNode;
	void (*)(struct ZVisitor132 *,struct ZBinaryNode304 *) VisitBinaryNode;
	void (*)(struct ZVisitor132 *,struct ZComparatorNode322 *) VisitComparatorNode;
	void (*)(struct ZVisitor132 *,struct ZAndNode495 *) VisitAndNode;
	void (*)(struct ZVisitor132 *,struct ZOrNode415 *) VisitOrNode;
	void (*)(struct ZVisitor132 *,struct ZBlockNode126 *) VisitBlockNode;
	void (*)(struct ZVisitor132 *,struct ZVarNode499 *) VisitVarNode;
	void (*)(struct ZVisitor132 *,struct ZIfNode360 *) VisitIfNode;
	void (*)(struct ZVisitor132 *,struct ZReturnNode135 *) VisitReturnNode;
	void (*)(struct ZVisitor132 *,struct ZWhileNode165 *) VisitWhileNode;
	void (*)(struct ZVisitor132 *,struct ZBreakNode311 *) VisitBreakNode;
	void (*)(struct ZVisitor132 *,struct ZThrowNode156 *) VisitThrowNode;
	void (*)(struct ZVisitor132 *,struct ZTryNode159 *) VisitTryNode;
	void (*)(struct ZVisitor132 *,struct ZLetNode373 *) VisitLetNode;
	void (*)(struct ZVisitor132 *,struct ZFunctionNode109 *) VisitFunctionNode;
	void (*)(struct ZVisitor132 *,struct ZClassNode509 *) VisitClassNode;
	void (*)(struct ZVisitor132 *,struct ZErrorNode329 *) VisitErrorNode;
	void (*)(struct ZVisitor132 *,struct ZNode49 *) VisitExtendedNode;
	void (*)(struct ZVisitor132 *,struct ZSugarNode130 *) VisitSugarNode;
	void (*)(struct ZVisitor132 *) EnableVisitor;
	void (*)(struct ZVisitor132 *) StopVisitor;
	int (*)(struct ZVisitor132 *) IsVisitable;
	int _classId106;
	int _delta106;
	struct ZType59 * StackedContextType;
	struct ZNode49 * ReturnedNode;
	struct ZGenerator52 * Generator;
	struct ZLogger99 * Logger;
	int StoppedVisitor;
	struct ZVarScope98 * VarScope;
	void (*)(struct ZTypeChecker106 *,struct ZFunctionNode109 *,int) DefineFunction;
	int _nextId;
};

static void _InitZTypeChecker106(struct ZTypeChecker106 * o) {
	_InitZVisitor132((struct ZVisitor132 *)o);
	o->_classId106 = 106;
	o->_delta106 = sizeof(struct ZTypeChecker106) - sizeof(struct ZVisitor132);
	o->StackedContextType = NULL;
	o->ReturnedNode = NULL;
	o->Generator = NULL;
	o->Logger = NULL;
	o->StoppedVisitor = 0/*false*/;
	o->VarScope = NULL;
	o->DefineFunction = NULL;
#ifdef _ZTypeChecker106_VisitNullNode
	o->VisitNullNode = VisitNullNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitBooleanNode
	o->VisitBooleanNode = VisitBooleanNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitIntNode
	o->VisitIntNode = VisitIntNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitFloatNode
	o->VisitFloatNode = VisitFloatNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitStringNode
	o->VisitStringNode = VisitStringNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitArrayLiteralNode
	o->VisitArrayLiteralNode = VisitArrayLiteralNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitMapLiteralNode
	o->VisitMapLiteralNode = VisitMapLiteralNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitNewObjectNode
	o->VisitNewObjectNode = VisitNewObjectNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitGlobalNameNode
	o->VisitGlobalNameNode = VisitGlobalNameNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitGetNameNode
	o->VisitGetNameNode = VisitGetNameNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitSetNameNode
	o->VisitSetNameNode = VisitSetNameNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitGroupNode
	o->VisitGroupNode = VisitGroupNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitGetterNode
	o->VisitGetterNode = VisitGetterNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitSetterNode
	o->VisitSetterNode = VisitSetterNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitGetIndexNode
	o->VisitGetIndexNode = VisitGetIndexNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitSetIndexNode
	o->VisitSetIndexNode = VisitSetIndexNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitMethodCallNode
	o->VisitMethodCallNode = VisitMethodCallNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitFuncCallNode
	o->VisitFuncCallNode = VisitFuncCallNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitMacroNode
	o->VisitMacroNode = VisitMacroNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitUnaryNode
	o->VisitUnaryNode = VisitUnaryNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitNotNode
	o->VisitNotNode = VisitNotNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitCastNode
	o->VisitCastNode = VisitCastNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitInstanceOfNode
	o->VisitInstanceOfNode = VisitInstanceOfNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitBinaryNode
	o->VisitBinaryNode = VisitBinaryNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitComparatorNode
	o->VisitComparatorNode = VisitComparatorNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitAndNode
	o->VisitAndNode = VisitAndNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitOrNode
	o->VisitOrNode = VisitOrNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitBlockNode
	o->VisitBlockNode = VisitBlockNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitVarNode
	o->VisitVarNode = VisitVarNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitIfNode
	o->VisitIfNode = VisitIfNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitReturnNode
	o->VisitReturnNode = VisitReturnNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitWhileNode
	o->VisitWhileNode = VisitWhileNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitBreakNode
	o->VisitBreakNode = VisitBreakNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitThrowNode
	o->VisitThrowNode = VisitThrowNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitTryNode
	o->VisitTryNode = VisitTryNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitLetNode
	o->VisitLetNode = VisitLetNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitFunctionNode
	o->VisitFunctionNode = VisitFunctionNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitClassNode
	o->VisitClassNode = VisitClassNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitErrorNode
	o->VisitErrorNode = VisitErrorNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitExtendedNode
	o->VisitExtendedNode = VisitExtendedNode__2qe2
#endif
#ifdef _ZTypeChecker106_VisitSugarNode
	o->VisitSugarNode = VisitSugarNode__2qe2
#endif
#ifdef _ZTypeChecker106_EnableVisitor
	o->EnableVisitor = EnableVisitor__1qe2
#endif
#ifdef _ZTypeChecker106_StopVisitor
	o->StopVisitor = StopVisitor__1qe2
#endif
#ifdef _ZTypeChecker106_IsVisitable
	o->IsVisitable = IsVisitable__1qe2
#endif
#ifdef _ZTypeChecker106_DefineFunction
	o->DefineFunction = DefineFunction__3qe2
#endif
	o->_nextId = 0;
}

static struct ZTypeChecker106 * _NewZTypeChecker106(void) {
	struct ZTypeChecker106 *o = LibZen_Malloc(sizeof(struct ZTypeChecker106));
	_InitZTypeChecker106(o);
	return o;
}

struct ZArrayType591 {
	int _classId59;
	int _delta59;
	long TypeFlag;
	long TypeId;
	const char * ShortName;
	struct ZType59 * RefType;
	struct ZType59 * (*)(struct ZType59 *) GetRealType;
	struct ZType59 * (*)(struct ZType59 *) GetSuperType;
	struct ZType59 * (*)(struct ZType59 *) GetBaseType;
	long (*)(struct ZType59 *) GetParamSize;
	struct ZType59 * (*)(struct ZType59 *,long) GetParamType;
	int (*)(struct ZType59 *) IsGreekType;
	struct ZType59 * (*)(struct ZType59 *,ArrayOfZType *) GetGreekRealType;
	int (*)(struct ZType59 *,struct ZType59 *,int,ArrayOfZType *) AcceptValueType;
	int (*)(struct ZType59 *) IsVarType;
	int _classId282;
	int _delta282;
	struct ZType59 * BaseType;
	struct ZType59 * ParamType;
	int _classId591;
	int _delta591;
	int _nextId;
};

static void _InitZArrayType591(struct ZArrayType591 * o) {
	_InitZGeneric1Type282((struct ZGeneric1Type282 *)o);
	o->_classId591 = 591;
	o->_delta591 = sizeof(struct ZArrayType591) - sizeof(struct ZGeneric1Type282);
#ifdef _ZArrayType591_GetRealType
	o->GetRealType = GetRealType__1qgf
#endif
#ifdef _ZArrayType591_GetSuperType
	o->GetSuperType = GetSuperType__1qgf
#endif
#ifdef _ZArrayType591_GetBaseType
	o->GetBaseType = GetBaseType__1qgf
#endif
#ifdef _ZArrayType591_GetParamSize
	o->GetParamSize = GetParamSize__1qgf
#endif
#ifdef _ZArrayType591_GetParamType
	o->GetParamType = GetParamType__2qgf
#endif
#ifdef _ZArrayType591_IsGreekType
	o->IsGreekType = IsGreekType__1qgf
#endif
#ifdef _ZArrayType591_GetGreekRealType
	o->GetGreekRealType = GetGreekRealType__2qgf
#endif
#ifdef _ZArrayType591_AcceptValueType
	o->AcceptValueType = AcceptValueType__4qgf
#endif
#ifdef _ZArrayType591_IsVarType
	o->IsVarType = IsVarType__1qgf
#endif
	o->_nextId = 0;
}

static struct ZArrayType591 * _NewZArrayType591(void) {
	struct ZArrayType591 *o = LibZen_Malloc(sizeof(struct ZArrayType591));
	_InitZArrayType591(o);
	return o;
}

struct ZAndNode495 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId304;
	int _delta304;
	struct ZSyntax184 * Pattern;
	int _classId495;
	int _delta495;
	int _nextId;
};

static void _InitZAndNode495(struct ZAndNode495 * o) {
	_InitZBinaryNode304((struct ZBinaryNode304 *)o);
	o->_classId495 = 495;
	o->_delta495 = sizeof(struct ZAndNode495) - sizeof(struct ZBinaryNode304);
#ifdef _ZAndNode495_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qsv
#endif
#ifdef _ZAndNode495_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qsv
#endif
#ifdef _ZAndNode495_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qsv
#endif
#ifdef _ZAndNode495_DeSugar
	o->DeSugar = DeSugar__2qsv
#endif
#ifdef _ZAndNode495_Accept
	o->Accept = Accept__2qsv
#endif
	o->_nextId = 0;
}

static struct ZAndNode495 * _NewZAndNode495(void) {
	struct ZAndNode495 *o = LibZen_Malloc(sizeof(struct ZAndNode495));
	_InitZAndNode495(o);
	return o;
}

struct ZArrayLiteralNode474 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId474;
	int _delta474;
	int _nextId;
};

static void _InitZArrayLiteralNode474(struct ZArrayLiteralNode474 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId474 = 474;
	o->_delta474 = sizeof(struct ZArrayLiteralNode474) - sizeof(struct ZListNode215);
#ifdef _ZArrayLiteralNode474_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qsu
#endif
#ifdef _ZArrayLiteralNode474_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qsu
#endif
#ifdef _ZArrayLiteralNode474_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qsu
#endif
#ifdef _ZArrayLiteralNode474_DeSugar
	o->DeSugar = DeSugar__2qsu
#endif
#ifdef _ZArrayLiteralNode474_Accept
	o->Accept = Accept__2qsu
#endif
	o->_nextId = 0;
}

static struct ZArrayLiteralNode474 * _NewZArrayLiteralNode474(void) {
	struct ZArrayLiteralNode474 *o = LibZen_Malloc(sizeof(struct ZArrayLiteralNode474));
	_InitZArrayLiteralNode474(o);
	return o;
}

struct ZBlockNode126 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId126;
	int _delta126;
	struct ZNameSpace43 * NameSpace;
	int _nextId;
};

static void _InitZBlockNode126(struct ZBlockNode126 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId126 = 126;
	o->_delta126 = sizeof(struct ZBlockNode126) - sizeof(struct ZListNode215);
	o->NameSpace = NULL;
#ifdef _ZBlockNode126_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qrj
#endif
#ifdef _ZBlockNode126_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qrj
#endif
#ifdef _ZBlockNode126_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qrj
#endif
#ifdef _ZBlockNode126_DeSugar
	o->DeSugar = DeSugar__2qrj
#endif
#ifdef _ZBlockNode126_Accept
	o->Accept = Accept__2qrj
#endif
	o->_nextId = 0;
}

static struct ZBlockNode126 * _NewZBlockNode126(void) {
	struct ZBlockNode126 *o = LibZen_Malloc(sizeof(struct ZBlockNode126));
	_InitZBlockNode126(o);
	return o;
}

struct ZBooleanNode469 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId325;
	int _delta325;
	int _classId469;
	int _delta469;
	int BooleanValue;
	int _nextId;
};

static void _InitZBooleanNode469(struct ZBooleanNode469 * o) {
	_InitZConstNode325((struct ZConstNode325 *)o);
	o->_classId469 = 469;
	o->_delta469 = sizeof(struct ZBooleanNode469) - sizeof(struct ZConstNode325);
	o->BooleanValue = 0/*false*/;
#ifdef _ZBooleanNode469_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qsw
#endif
#ifdef _ZBooleanNode469_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qsw
#endif
#ifdef _ZBooleanNode469_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qsw
#endif
#ifdef _ZBooleanNode469_DeSugar
	o->DeSugar = DeSugar__2qsw
#endif
#ifdef _ZBooleanNode469_Accept
	o->Accept = Accept__2qsw
#endif
	o->_nextId = 0;
}

static struct ZBooleanNode469 * _NewZBooleanNode469(void) {
	struct ZBooleanNode469 *o = LibZen_Malloc(sizeof(struct ZBooleanNode469));
	_InitZBooleanNode469(o);
	return o;
}

struct ZClassNode509 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId509;
	int _delta509;
	const char * ClassName;
	struct ZClassType63 * ClassType;
	struct ZType59 * SuperType;
	struct ZToken64 * NameToken;
	struct ZToken64 * SuperToken;
	int _nextId;
};

static void _InitZClassNode509(struct ZClassNode509 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId509 = 509;
	o->_delta509 = sizeof(struct ZClassNode509) - sizeof(struct ZListNode215);
	o->ClassName = NULL;
	o->ClassType = NULL;
	o->SuperType = NULL;
	o->NameToken = NULL;
	o->SuperToken = NULL;
#ifdef _ZClassNode509_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qdy
#endif
#ifdef _ZClassNode509_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qdy
#endif
#ifdef _ZClassNode509_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qdy
#endif
#ifdef _ZClassNode509_DeSugar
	o->DeSugar = DeSugar__2qdy
#endif
#ifdef _ZClassNode509_Accept
	o->Accept = Accept__2qdy
#endif
	o->_nextId = 0;
}

static struct ZClassNode509 * _NewZClassNode509(void) {
	struct ZClassNode509 *o = LibZen_Malloc(sizeof(struct ZClassNode509));
	_InitZClassNode509(o);
	return o;
}

struct ZFuncCallNode400 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId400;
	int _delta400;
	int _nextId;
};

static void _InitZFuncCallNode400(struct ZFuncCallNode400 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId400 = 400;
	o->_delta400 = sizeof(struct ZFuncCallNode400) - sizeof(struct ZListNode215);
#ifdef _ZFuncCallNode400_SetNameInfo
	o->SetNameInfo = SetNameInfo__3q4t
#endif
#ifdef _ZFuncCallNode400_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3q4t
#endif
#ifdef _ZFuncCallNode400_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1q4t
#endif
#ifdef _ZFuncCallNode400_DeSugar
	o->DeSugar = DeSugar__2q4t
#endif
#ifdef _ZFuncCallNode400_Accept
	o->Accept = Accept__2q4t
#endif
	o->_nextId = 0;
}

static struct ZFuncCallNode400 * _NewZFuncCallNode400(void) {
	struct ZFuncCallNode400 *o = LibZen_Malloc(sizeof(struct ZFuncCallNode400));
	_InitZFuncCallNode400(o);
	return o;
}

struct ZFunctionNode109 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId109;
	int _delta109;
	struct ZType59 * ReturnType;
	const char * FuncName;
	struct ZToken64 * NameToken;
	struct ZFunctionNode109 * ParentFunctionNode;
	struct ZFuncType67 * ResolvedFuncType;
	long VarIndex;
	int _nextId;
};

static void _InitZFunctionNode109(struct ZFunctionNode109 * o) {
	_InitZListNode215((struct ZListNode215 *)o);
	o->_classId109 = 109;
	o->_delta109 = sizeof(struct ZFunctionNode109) - sizeof(struct ZListNode215);
	o->ReturnType = /*untyped*/NULL;
	o->FuncName = NULL;
	o->NameToken = NULL;
	o->ParentFunctionNode = NULL;
	o->ResolvedFuncType = NULL;
	o->VarIndex = 0;
#ifdef _ZFunctionNode109_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qrw
#endif
#ifdef _ZFunctionNode109_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qrw
#endif
#ifdef _ZFunctionNode109_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qrw
#endif
#ifdef _ZFunctionNode109_DeSugar
	o->DeSugar = DeSugar__2qrw
#endif
#ifdef _ZFunctionNode109_Accept
	o->Accept = Accept__2qrw
#endif
	o->_nextId = 0;
}

static struct ZFunctionNode109 * _NewZFunctionNode109(void) {
	struct ZFunctionNode109 *o = LibZen_Malloc(sizeof(struct ZFunctionNode109));
	_InitZFunctionNode109(o);
	return o;
}

struct ZVarNode499 {
	int _classId49;
	int _delta49;
	struct ZNode49 * ParentNode;
	struct ZToken64 * SourceToken;
	ArrayOfZNode * AST;
	struct ZType59 * Type;
	int HasUntypedNode;
	void (*)(struct ZNode49 *,struct ZToken64 *,const char *) SetNameInfo;
	void (*)(struct ZNode49 *,struct ZToken64 *,struct ZType59 *) SetTypeInfo;
	int (*)(struct ZNode49 *) IsBreakingBlock;
	struct ZSugarNode130 * (*)(struct ZNode49 *,struct ZGenerator52 *) DeSugar;
	void (*)(struct ZNode49 *,struct ZVisitor132 *) Accept;
	int _classId215;
	int _delta215;
	long ListStartIndex;
	int _classId126;
	int _delta126;
	struct ZNameSpace43 * NameSpace;
	int _classId499;
	int _delta499;
	struct ZType59 * DeclType;
	const char * NativeName;
	struct ZToken64 * TypeToken;
	struct ZToken64 * NameToken;
	int _nextId;
};

static void _InitZVarNode499(struct ZVarNode499 * o) {
	_InitZBlockNode126((struct ZBlockNode126 *)o);
	o->_classId499 = 499;
	o->_delta499 = sizeof(struct ZVarNode499) - sizeof(struct ZBlockNode126);
	o->DeclType = /*untyped*/NULL;
	o->NativeName = NULL;
	o->TypeToken = NULL;
	o->NameToken = NULL;
#ifdef _ZVarNode499_SetNameInfo
	o->SetNameInfo = SetNameInfo__3qs7
#endif
#ifdef _ZVarNode499_SetTypeInfo
	o->SetTypeInfo = SetTypeInfo__3qs7
#endif
#ifdef _ZVarNode499_IsBreakingBlock
	o->IsBreakingBlock = IsBreakingBlock__1qs7
#endif
#ifdef _ZVarNode499_DeSugar
	o->DeSugar = DeSugar__2qs7
#endif
#ifdef _ZVarNode499_Accept
	o->Accept = Accept__2qs7
#endif
	o->_nextId = 0;
}

static struct ZVarNode499 * _NewZVarNode499(void) {
	struct ZVarNode499 *o = LibZen_Malloc(sizeof(struct ZVarNode499));
	_InitZVarNode499(o);
	return o;
}

static const char * ZFunc_NativeNameConnector_Z0 = "__";
static long ZFunc_CoercionFunc_Z1 = (1 << 17) | /*untyped*/NULL;
static long ZFunc_ConverterFunc_Z2 = 1 << 16;
static const char * ZFunc_StringfySignature__3qqy(const char * FuncName, long FuncParamSize__1, struct ZType59 * RecvType__2) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(FuncName, "__"), LibZen_IntToString(FuncParamSize)), GetUniqueName__1qw6(RecvType));
}
static long ZTypeUniqueTypeFlag_Z3 = 1 << 16;
static long ZTypeUnboxTypeFlag_Z4 = 1 << 10;
static long ZTypeOpenTypeFlag_Z5 = 1 << 9;
static struct ZType59 * ZTypeVarType_Z6 = ZType__4qw6(_NewZType59(), ZTypeUniqueTypeFlag_Z3, "var", NULL);
static struct ZType59 * ZTypeVoidType_Z7 = ZType__4qw6(_NewZType59(), ZTypeUniqueTypeFlag_Z3, "void", NULL);
static struct ZType59 * ZTypeBooleanType_Z8 = ZType__4qw6(_NewZType59(), ZTypeUniqueTypeFlag_Z3, "boolean", ZTypeVarType_Z6);
static struct ZType59 * ZTypeIntType_Z9 = ZType__4qw6(_NewZType59(), ZTypeUniqueTypeFlag_Z3, "int", ZTypeVarType_Z6);
static struct ZType59 * ZTypeFloatType_Z10 = ZType__4qw6(_NewZType59(), ZTypeUniqueTypeFlag_Z3, "float", ZTypeVarType_Z6);
static struct ZType59 * ZTypeStringType_Z11 = ZType__4qw6(_NewZType59(), ZTypeUniqueTypeFlag_Z3, "String", ZTypeVarType_Z6);
static struct ZType59 * ZTypeTypeType_Z12 = ZType__4qw6(_NewZType59(), ZTypeUniqueTypeFlag_Z3, "Type", ZTypeVarType_Z6);
static struct ZGeneric1Type282 * ZTypeArrayType_Z13 = ZGeneric1Type__5qim(_NewZGeneric1Type282(), ZTypeUniqueTypeFlag_Z3, "Array", NULL, ZTypeVarType_Z6);
static struct ZGeneric1Type282 * ZTypeMapType_Z14 = ZGeneric1Type__5qim(_NewZGeneric1Type282(), ZTypeUniqueTypeFlag_Z3, "Map", NULL, ZTypeVarType_Z6);
static struct ZFuncType67 * ZTypeFuncType_Z15 = ZFuncType__3qw7(_NewZFuncType67(), "Func", NULL);
static ArrayOfZType * ZTypePool_TypeList_Z16 = LibZen_NewArray(0);
static var null = /*untyped*/NULL;
static long ZTypePool_NewTypeId__1qw6(struct ZType59 * T) {
	long TypeId = /*untyped*/NULL;
	/*untyped*/NULL;
	return TypeId;
}
static struct ZType59 * TypeOf__1qqr(long TypeId) {
	if (TypeId == 0) {
		return ZTypeVarType_Z6;
	};
	if (TypeId < /*untyped*/NULL) {
		return Array<ZType>GetIndex(TypeId);
	};
	return ZTypeVarType_Z6;
}
static struct ZType59 * GetGreekType__1qqr(long GreekId) {
	if (/*untyped*/NULL == /*untyped*/NULL) {
		varSetIndex(GreekId, ZGreekType__2qoe(_NewZGreekType290(), GreekId));
	};
	return /*untyped*/NULL;
}
static MapOfZType * ZTypePool_ClassNameMap_Z17 = LibZen_NewMap(0);
static MapOfArrayOfZType * ZTypePool_UniqueTypeSetMap_Z18 = LibZen_NewMap(0);
static const char * ZTypePool_MangleType2__2qw6(struct ZType59 * Type1, struct ZType59 * Type2__1) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(Type1->TypeId)), ":"), LibZen_IntToString(Type2->TypeId));
}
static const char * ZTypePool_MangleTypes__1qwz(ArrayOfZType * TypeList) {
	const char * s = "";
	long i = 0;
	while (i < /*untyped*/NULL) {
		struct ZType59 * Type = Array<ZType>GetIndex(i);
		s = LibZen_StrCat(LibZen_StrCat(s, ":"), LibZen_IntToString(Type->TypeId));
		i = i + 1;
	};
	return s;
}
static ArrayOfZType * ZTypePool_UniqueTypes__1qwz(ArrayOfZType * TypeList) {
	const char * MangleName = LibZen_StrCat("[]", ZTypePool_MangleTypes__1qwz(TypeList));
	ArrayOfZType * Types = Map<Array<ZType>>GetIndex(MangleName);
	if (Types == NULL) {
		Types = /*untyped*/NULL;
		Map<Array<ZType>>SetIndex(MangleName, Types);
	};
	return Types;
}
static struct ZType59 * ZTypePool_GetGenericType1__2qw6(struct ZType59 * BaseType, struct ZType59 * ParamType__1) {
	const char * MangleName = ZTypePool_MangleType2__2qw6(BaseType, ParamType);
	struct ZType59 * GenericType = Map<ZType>GetIndex(MangleName);
	if (GenericType == NULL) {
		const char * Name = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), ThrowError("type error: requested = String, given = ZType")), ">");
		if (IsArrayType__1qw6(BaseType)) {
			Name = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(BaseType->ShortName, "<"), ThrowError("type error: requested = String, given = ZType")), ">");
		};
		GenericType = ZGeneric1Type__5qim(_NewZGeneric1Type282(), ZTypeUniqueTypeFlag_Z3, Name, BaseType, ParamType);
		Map<ZType>SetIndex(MangleName, GenericType);
	};
	return GenericType;
}
static struct ZType59 * ZTypePool_GetGenericType__3qw6(struct ZType59 * BaseType, ArrayOfZType * TypeList__1, int IsCreation__2) {
	LibZen_Assert(BaseType->GetParamSize(BaseType) > 0, "(sample/libzen.zen:1228)");
	if (/*untyped*/NULL == 1 && !IsFuncType__1qw6(BaseType)) {
		return ZTypePool_GetGenericType1__2qw6(BaseType, Array<ZType>GetIndex(0));
	};
	const char * MangleName = LibZen_StrCat(LibZen_StrCat(":", LibZen_IntToString(BaseType->TypeId)), ZTypePool_MangleTypes__1qwz(TypeList));
	struct ZType59 * GenericType = Map<ZType>GetIndex(MangleName);
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
		if (IsFuncType__1qw6(BaseType)) {
			GenericType = ZFuncType__3qw7(_NewZFuncType67(), ShortName, ZTypePool_UniqueTypes__1qwz(TypeList));
		} else {
		};
		Map<ZType>SetIndex(MangleName, GenericType);
	};
	return GenericType;
}
static struct ZFuncType67 * ZTypePool_LookupFuncType__1qwz(ArrayOfZType * TypeList) {
	struct ZType59 * FuncType = ZTypePool_GetGenericType__3qw6(ZTypeFuncType_Z15, TypeList, 1/*true*/);
	if (LibZen_Is(FuncType, 67)) {
		return (struct ZFuncType67 *)FuncType;
	};
	return NULL;
}
static struct ZFuncType67 * ZTypePool_LookupFuncType__1qw6(struct ZType59 * R) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	/*untyped*/NULL;
	return ZTypePool_LookupFuncType__1qwz(TypeList);
}
static struct ZFuncType67 * ZTypePool_LookupFuncType__2qw6(struct ZType59 * R, struct ZType59 * P1__1) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	/*untyped*/NULL;
	/*untyped*/NULL;
	return ZTypePool_LookupFuncType__1qwz(TypeList);
}
static struct ZFuncType67 * ZTypePool_LookupFuncType__3qw6(struct ZType59 * R, struct ZType59 * P1__1, struct ZType59 * P2__2) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	/*untyped*/NULL;
	/*untyped*/NULL;
	/*untyped*/NULL;
	return ZTypePool_LookupFuncType__1qwz(TypeList);
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
static struct ZEmptyValue168 * ZEmptyValue_TrueEmpty_Z39 = _NewZEmptyValue168();
static struct ZEmptyValue168 * ZEmptyValue_FalseEmpty_Z40 = _NewZEmptyValue168();
static const char * ZLogger_LogError__2qwb(struct ZToken64 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qy1(Token->Source, "error", Token->StartIndex, Message);
		Report__2qev(Token->Source->Logger, Message);
	};
	return Message;
}
static void ZLogger_LogWarning__2qwb(struct ZToken64 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qy1(Token->Source, "warning", Token->StartIndex, Message);
		Report__2qev(Token->Source->Logger, Message);
	};
	return;
}
static void ZLogger_LogInfo__2qwb(struct ZToken64 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qy1(Token->Source, "info", Token->StartIndex, Message);
		Report__2qev(Token->Source->Logger, Message);
	};
	return;
}
static void ZLogger_LogDebug__2qwb(struct ZToken64 * Token, const char * Message__1) {
	if (Token != NULL && Token->Source != NULL) {
		Message = FormatErrorMarker__4qy1(Token->Source, "debug", Token->StartIndex, Message);
		Report__2qev(Token->Source->Logger, Message);
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
static struct ZSyntax184 * MergeSyntaxPattern__2qyt(struct ZSyntax184 * Pattern, struct ZSyntax184 * Parent__1) {
	if (Parent == NULL) {
		return Pattern;
	};
	struct ZSyntax184 * MergedPattern = ZSyntax__4qyt(_NewZSyntax184(), Pattern->PackageNameSpace, Pattern->PatternName, Pattern->MatchFunc);
	MergedPattern->ParentPattern = Parent;
	return MergedPattern;
}
static struct ZToken64 * ZToken_NullToken_Z51 = ZToken__4qwb(_NewZToken64(), NULL, 0, 0);
static int ZTokenContext_Required_Z52 = 1/*true*/;
static int ZTokenContext_Optional_Z53 = 0/*false*/;
static int ZTokenContext_AllowSkipIndent_Z54 = 1/*true*/;
static int ZTokenContext_NotAllowSkipIndent_Z55 = 0/*false*/;
static int ZTokenContext_AllowNewLine_Z56 = 1/*true*/;
static int ZTokenContext_MoveNext_Z57 = 1/*true*/;
static ArrayOfZType * ZGreekType_NewGreekTypes__1qwz(ArrayOfZType * GreekTypes) {
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
static struct ZSyntax184 * ExpressionPattern_GetRightPattern__2qwi(struct ZNameSpace43 * NameSpace, struct ZTokenContext50 * TokenContext__1) {
	struct ZToken64 * Token = GetToken__1qwd(TokenContext);
	if (Token != ZToken_NullToken_Z51) {
		struct ZSyntax184 * Pattern = GetRightSyntaxPattern__2qwi(NameSpace, GetText__1qwb(Token));
		return Pattern;
	};
	return NULL;
}
static struct ZNode49 * ExpressionPattern_DispatchPattern__5qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2, int AllowStatement__3, int AllowBinary__4) {
	struct ZToken64 * Token = GetToken__1qwd(TokenContext);
	struct ZSyntax184 * Pattern = NULL;
	struct ZNameSpace43 * NameSpace = GetNameSpace__1qws(ParentNode);
	if (LibZen_Is(Token, 455)) {
		Pattern = ((struct ZPatternToken455 *)Token)->PresetPattern;
	} else {
		Pattern = GetSyntaxPattern__2qwi(NameSpace, GetText__1qwb(Token));
	};
	if (Pattern != NULL) {
		if (Pattern->IsStatement && !AllowStatement) {
			return ZErrorNode__4qpy(_NewZErrorNode329(), ParentNode, Token, LibZen_StrCat(GetText__1qwb(Token), " statement is not here"));
		};
		LeftNode = ApplyMatchPattern__5qwd(TokenContext, ParentNode, LeftNode, Pattern, ZTokenContext_Required_Z52);
	} else {
		if (IsNameSymbol__1qwb(Token)) {
			if (AllowStatement) {
				Pattern = GetSyntaxPattern__2qwi(NameSpace, "$SymbolStatement$");
			} else {
				Pattern = GetSyntaxPattern__2qwi(NameSpace, "$SymbolExpression$");
			};
			LeftNode = ApplyMatchPattern__5qwd(TokenContext, ParentNode, LeftNode, Pattern, ZTokenContext_Required_Z52);
		} else {
			if (AllowStatement) {
				return CreateExpectedErrorNode__3qwd(TokenContext, Token, "statement");
			} else {
				return CreateExpectedErrorNode__3qwd(TokenContext, Token, "expression");
			};
		};
	};
	if (!Pattern->IsStatement) {
		while (LeftNode != NULL && !IsErrorNode__1qws(LeftNode)) {
			struct ZSyntax184 * RightPattern = ExpressionPattern_GetRightPattern__2qwi(NameSpace, TokenContext);
			if (RightPattern == NULL) {
				break;
			};
			if (!AllowBinary && IsBinaryOperator__1qyt(RightPattern)) {
				break;
			};
			LeftNode = ApplyMatchPattern__5qwd(TokenContext, ParentNode, LeftNode, RightPattern, ZTokenContext_Required_Z52);
		};
	};
	return LeftNode;
}
static const char * NumberLiteralToken_ParseDigit__1qw0(struct ZSourceContext46 * SourceContext) {
	const char * ch = ThrowError("type error: requested = String, given = int");
	while (HasChar__1qw0(SourceContext)) {
		ch = GetCurrentChar__1qw0(SourceContext);
		if (!LibZen_IsDigit__1qqy(ch)) {
			break;
		};
		MoveNext__1qw0(SourceContext);
	};
	return ch;
}
static struct ZClassField62 * ZClassField__5qwc(struct ZClassField62 * this, struct ZClassType63 * ClassType__1, const char * FieldName__2, struct ZType59 * FieldType__3, struct ZToken64 * SourceToken__4) {
	this->ClassType = ClassType;
	this->FieldType = FieldType;
	this->FieldName = FieldName;
	this->SourceToken = SourceToken;
	return NULL;
}
static struct ZFunc66 * ZFunc__4qwm(struct ZFunc66 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType67 * FuncType__3) {
	this->FuncFlag = FuncFlag;
	this->FuncName = FuncName;
	this->FuncType = FuncType;
	return NULL;
}
static struct ZFuncType67 * GetFuncType__1qwm(struct ZFunc66 * this) {
	return this->FuncType;
}
static const char * toString__1qwm(struct ZFunc66 * this) {
	return LibZen_StrCat(LibZen_StrCat(this->FuncName, ": "), ThrowError("type error: requested = String, given = ZFuncType"));
}
static int IsConverterFunc__1qwm(struct ZFunc66 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_ConverterFunc_Z2);
}
static int IsCoercionFunc__1qwm(struct ZFunc66 * this) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, ZFunc_CoercionFunc_Z1);
}
static int Is__2qwm(struct ZFunc66 * this, long Flag__1) {
	return LibZen_IsFlag__2qqr(this->FuncFlag, Flag);
}
static const char * GetSignature__1qwm(struct ZFunc66 * this) {
	return StringfySignature__2qw7(this->FuncType, this->FuncName);
}
static struct ZPrototype74 * ZPrototype__5qee(struct ZPrototype74 * this, long FuncFlag__1, const char * FuncName__2, struct ZFuncType67 * FuncType__3, struct ZToken64 * SourceToken__4) {
	ThrowError("not function: ZFunc");
	this->DefinedCount = 0;
	this->UsedCount = 0;
	return NULL;
}
static void Used__1qee(struct ZPrototype74 * this) {
	this->UsedCount = this->UsedCount + 1;
	return;
}
static void Defined__1qee(struct ZPrototype74 * this) {
	this->DefinedCount = this->DefinedCount + 1;
	return;
}
static struct ZType59 * ZType__4qw6(struct ZType59 * this, long TypeFlag__1, const char * ShortName__2, struct ZType59 * RefType__3) {
	this->TypeFlag = TypeFlag;
	this->ShortName = ShortName;
	this->RefType = RefType;
	if (LibZen_IsFlag__2qqr(TypeFlag, ZTypeUniqueTypeFlag_Z3)) {
		this->TypeId = ZTypePool_NewTypeId__1qw6(this);
	};
	return NULL;
}
static struct ZType59 * GetRealType__1qw6(struct ZType59 * this) {
	return this;
}
static struct ZType59 * GetSuperType__1qw6(struct ZType59 * this) {
	return this->RefType;
}
static struct ZType59 * GetBaseType__1qw6(struct ZType59 * this) {
	return this;
}
static long GetParamSize__1qw6(struct ZType59 * this) {
	return 0;
}
static struct ZType59 * GetParamType__2qw6(struct ZType59 * this, long Index__1) {
	return ZTypeVarType_Z6;
}
static int Equals__2qw6(struct ZType59 * this, struct ZType59 * Type__1) {
	return (/*untyped*/NULL(this) == Type->GetRealType(Type));
}
static int Accept__2qw6(struct ZType59 * this, struct ZType59 * Type__1) {
	struct ZType59 * ThisType = /*untyped*/NULL(this);
	if (ThisType == Type->GetRealType(Type)) {
		return 1/*true*/;
	};
	struct ZType59 * SuperClass = /*untyped*/NULL(Type);
	while (SuperClass != NULL) {
		if (SuperClass == ThisType) {
			return 1/*true*/;
		};
		SuperClass = /*untyped*/NULL(SuperClass);
	};
	return 0/*false*/;
}
static int IsGreekType__1qw6(struct ZType59 * this) {
	return 0/*false*/;
}
static struct ZType59 * GetGreekRealType__2qw6(struct ZType59 * this, ArrayOfZType * Greek__1) {
	return /*untyped*/NULL(this);
}
static int AcceptValueType__4qw6(struct ZType59 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (/*untyped*/NULL(this) != ValueType && !/*untyped*/NULL(ValueType)) {
		if (ExactMatch && !Accept__2qw6(this, ValueType)) {
			return 0/*false*/;
		};
	};
	return 1/*true*/;
}
static int IsVoidType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeVoidType_Z7);
}
static int IsVarType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeVarType_Z6);
}
static int IsInferrableType__1qw6(struct ZType59 * this) {
	return (!/*untyped*/NULL(this) && !IsVoidType__1qw6(this));
}
static int IsTypeType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeTypeType_Z12);
}
static int IsBooleanType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeBooleanType_Z8);
}
static int IsIntType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeIntType_Z9);
}
static int IsFloatType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeFloatType_Z10);
}
static int IsNumberType__1qw6(struct ZType59 * this) {
	return (IsIntType__1qw6(this) || IsFloatType__1qw6(this));
}
static int IsStringType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeStringType_Z11);
}
static int IsArrayType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeArrayType_Z13);
}
static int IsMapType__1qw6(struct ZType59 * this) {
	return (/*untyped*/NULL(this) == ZTypeMapType_Z14);
}
static int IsOpenType__1qw6(struct ZType59 * this) {
	return LibZen_IsFlag__2qqr(this->TypeFlag, ZTypeOpenTypeFlag_Z5);
}
static int IsImmutableType__1qw6(struct ZType59 * this) {
	return 0/*false*/;
}
static int IsNullableType__1qw6(struct ZType59 * this) {
	return 1/*true*/;
}
static const char * toString__1qw6(struct ZType59 * this) {
	return this->ShortName;
}
static const char * GetAsciiName__1qw6(struct ZType59 * this) {
	return this->ShortName;
}
static const char * StringfyClassMember__2qw6(struct ZType59 * this, const char * Name__1) {
	return LibZen_StrCat(LibZen_StrCat(Name, " of "), this->ShortName);
}
static const char * GetUniqueName__1qw6(struct ZType59 * this) {
	return LibZen_Stringfy__1qqr(this->TypeId);
}
static int IsFuncType__1qw6(struct ZType59 * this) {
	return (LibZen_Is(/*untyped*/NULL(this), 67));
}
static const char * StringfySignature__2qw6(struct ZType59 * this, const char * FuncName__1) {
	return FuncName;
}
static void Maybe__3qw6(struct ZType59 * this, struct ZType59 * T__1, struct ZToken64 * SourceToken__2) {
	return;
}
static struct ZVarScope98 * ZVarScope__4qec(struct ZVarScope98 * this, struct ZVarScope98 * Parent__1, struct ZLogger99 * Logger__2, ArrayOfZVarType * VarList__3) {
	this->Parent = Parent;
	this->Logger = Logger;
	this->VarList = VarList;
	if (this->VarList == NULL) {
		this->VarList = LibZen_NewArray(0);
	};
	return NULL;
}
static struct ZType59 * NewVarType__4qec(struct ZVarScope98 * this, struct ZType59 * VarType__1, const char * Name__2, struct ZToken64 * SourceToken__3) {
	if (!(LibZen_Is(VarType, 100)) && /*untyped*/NULL(VarType)) {
		VarType = ZVarType__4qeb(_NewZVarType100(), this->VarList, Name, SourceToken);
	};
	return VarType;
}
static void FoundUnresolvedSymbol__2qec(struct ZVarScope98 * this, const char * FuncName__1) {
	/*untyped*/NULL;
	this->UnresolvedSymbolCount = this->UnresolvedSymbolCount + 1;
	return;
}
static void CheckVarNode__3qec(struct ZVarScope98 * this, struct ZType59 * ContextType__1, struct ZNode49 * Node__2) {
	if (IsUntyped__1qws(Node)) {
		this->VarNodeCount = this->VarNodeCount + 1;
	};
	if (IsInferrableType__1qw6(ContextType) && LibZen_Is(Node->Type, 100)) {
		Infer__3qeb(((struct ZVarType100 *)Node->Type), ContextType, Node->SourceToken);
		Node->Type = ContextType;
	};
	if (LibZen_Is(ContextType, 100) && !IsUntyped__1qws(Node)) {
		Infer__3qeb(((struct ZVarType100 *)ContextType), Node->Type, Node->SourceToken);
	};
	return;
}
static int TypeCheckStmtList__3qec(struct ZVarScope98 * this, struct ZTypeChecker106 * TypeSafer__1, ArrayOfZNode * StmtList__2) {
	long PrevCount = -1;
	while (1/*true*/) {
		long i = 0;
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		while (i < /*untyped*/NULL) {
			Array<ZNode>SetIndex(i, CheckType__3qe2(TypeSafer, Array<ZNode>GetIndex(i), ZTypeVoidType_Z7));
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
static void TypeCheckFuncBlock__3qec(struct ZVarScope98 * this, struct ZTypeChecker106 * TypeSafer__1, struct ZFunctionNode109 * FunctionNode__2) {
	long PrevCount = -1;
	while (1/*true*/) {
		this->VarNodeCount = 0;
		this->UnresolvedSymbolCount = 0;
		/*untyped*/NULL(TypeSafer, FunctionNode, 0/*false*/);
		Array<ZNode>SetIndex(ZFunctionNode_Block_Z79, CheckType__3qe2(TypeSafer, Array<ZNode>GetIndex(ZFunctionNode_Block_Z79), ZTypeVoidType_Z7));
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
static struct ZVarType100 * ZVarType__4qeb(struct ZVarType100 * this, ArrayOfZVarType * VarList__1, const char * Name__2, struct ZToken64 * SourceToken__3) {
	ThrowError("not function: ZType");
	this->VarList = VarList;
	this->SourceToken = SourceToken;
	this->GreekId = /*untyped*/NULL;
	/*untyped*/NULL;
	this->TypeId = this->RefType->TypeId;
	return NULL;
}
static struct ZType59 * GetRealType__1qeb(struct ZVarType100 * this) {
	return this->RefType;
}
static long GetParamSize__1qeb(struct ZVarType100 * this) {
	return /*untyped*/NULL(this->RefType);
}
static struct ZType59 * GetParamType__2qeb(struct ZVarType100 * this, long Index__1) {
	return /*untyped*/NULL(this->RefType, Index);
}
static int IsFuncType__1qeb(struct ZVarType100 * this) {
	return IsFuncType__1qw6(this->RefType);
}
static int IsVarType__1qeb(struct ZVarType100 * this) {
	return /*untyped*/NULL(this->RefType);
}
static void Infer__3qeb(struct ZVarType100 * this, struct ZType59 * ContextType__1, struct ZToken64 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(ContextType, 100) && /*untyped*/NULL(ContextType)) {
			struct ZVarType100 * VarType = (struct ZVarType100 *)ContextType;
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
static void Maybe__3qeb(struct ZVarType100 * this, struct ZType59 * T__1, struct ZToken64 * SourceToken__2) {
	if (/*untyped*/NULL(this->RefType)) {
		if (LibZen_Is(T, 100) && /*untyped*/NULL(T)) {
			struct ZVarType100 * VarType = (struct ZVarType100 *)T;
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
static struct ZNode49 * ZNode__4qws(struct ZNode49 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, long Size__3) {
	LibZen_Assert(this != ParentNode, "(sample/libzen.zen:1807)");
	this->ParentNode = ParentNode;
	this->SourceToken = SourceToken;
	if (Size > 0) {
		this->AST = /*untyped*/NULL;
	} else {
		this->AST = NULL;
	};
	return NULL;
}
static struct ZNode49 * SetChild__2qws(struct ZNode49 * this, struct ZNode49 * Node__1) {
	LibZen_Assert(Node != NULL, "(sample/libzen.zen:1819)");
	if (Node != NULL) {
		LibZen_Assert(this != Node, "(sample/libzen.zen:1821)");
		Node->ParentNode = this;
	};
	return Node;
}
static void SetNameInfo__3qws(struct ZNode49 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	LibZen_Assert(Name == NULL, "(sample/libzen.zen:1828)");
	return;
}
static void SetTypeInfo__3qws(struct ZNode49 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->Type = Type;
	return;
}
static void Set__3qws(struct ZNode49 * this, long Index__1, struct ZNode49 * Node__2) {
	if (Index >= 0) {
		Array<ZNode>SetIndex(Index, SetChild__2qws(this, Node));
	} else if (Index == ZNode_AppendIndex_Z22) {
		struct ZNode49 * ListNode = this;
		if (LibZen_Is(ListNode, 215)) {
			Append__2qy8(((struct ZListNode215 *)ListNode), Node);
		} else {
			LibZen_Assert(LibZen_Is(ListNode, 215), "(sample/libzen.zen:1845)");
		};
	} else if (Index == ZNode_NameInfo_Z20) {
		/*untyped*/NULL(this, Node->SourceToken, GetText__1qwb(Node->SourceToken));
		this->SourceToken = Node->SourceToken;
		return;
	} else if (Index == ZNode_TypeInfo_Z21) {
		/*untyped*/NULL(this, Node->SourceToken, Node->Type);
		return;
	};
	return;
}
static long GetAstSize__1qws(struct ZNode49 * this) {
	if (this->AST == NULL) {
		return 0;
	};
	return /*untyped*/NULL;
}
static int HasAst__2qws(struct ZNode49 * this, long Index__1) {
	if (this->AST != NULL && Index < /*untyped*/NULL) {
		return Array<ZNode>GetIndex(Index) != NULL;
	};
	return 0/*false*/;
}
static struct ZType59 * GetAstType__2qws(struct ZNode49 * this, long Index__1) {
	return /*untyped*/NULL(Array<ZNode>GetIndex(Index)->Type);
}
static const char * GetSourceLocation__1qws(struct ZNode49 * this) {
	if (this->SourceToken != NULL) {
		return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", GetFileName__1qwb(this->SourceToken)), ":"), LibZen_IntToString(GetLineNumber__1qwb(this->SourceToken))), ")");
	};
	return NULL;
}
static const char * toString__1qws(struct ZNode49 * this) {
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
				Self = LibZen_StrCat(Self, toString__1qws(Array<ZNode>GetIndex(i)));
			};
			i = i + 1;
		};
		Self = LibZen_StrCat(Self, "]");
	};
	return Self;
}
static struct ZBlockNode126 * GetScopeBlockNode__1qws(struct ZNode49 * this) {
	struct ZNode49 * Node = this;
	while (Node != NULL) {
		if (LibZen_Is(Node, 126)) {
			return (struct ZBlockNode126 *)Node;
		};
		if (Node == Node->ParentNode) {
			/*untyped*/NULLlongjump(1) ;
		};
		Node = Node->ParentNode;
	};
	return NULL;
}
static struct ZNameSpace43 * GetNameSpace__1qws(struct ZNode49 * this) {
	struct ZBlockNode126 * BlockNode = GetScopeBlockNode__1qws(this);
	return BlockNode->NameSpace;
}
static int IsErrorNode__1qws(struct ZNode49 * this) {
	return (LibZen_Is(this, 329));
}
static int IsBreakingBlock__1qws(struct ZNode49 * this) {
	return 0/*false*/;
}
static struct ZSugarNode130 * DeSugar__2qws(struct ZNode49 * this, struct ZGenerator52 * Generator__1) {
	return ZSugarNode__3qr1(_NewZSugarNode130(), this, ZErrorNode__3qpy(_NewZErrorNode329(), this->ParentNode, LibZen_StrCat("undefined code generation: ", ThrowError("type error: requested = String, given = ZNode"))));
}
static void Accept__2qws(struct ZNode49 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsUntyped__1qws(struct ZNode49 * this) {
	return /*untyped*/NULL(this->Type);
}
static int HasUntypedNode__1qws(struct ZNode49 * this) {
	if (this->HasUntypedNode) {
		if (!IsUntyped__1qws(this)) {
			long i = 0;
			while (i < GetAstSize__1qws(this)) {
				if (Array<ZNode>GetIndex(i) != NULL && HasUntypedNode__1qws(Array<ZNode>GetIndex(i))) {
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
static struct ZNode49 * VisitTypeChecker__3qws(struct ZNode49 * this, struct ZTypeChecker106 * TypeChecker__1, struct ZType59 * ContextType__2) {
	return VisitTypeChecker__3qe2(TypeChecker, this, ContextType);
}
static struct ZReturnNode135 * ToReturnNode__1qws(struct ZNode49 * this) {
	return NULL;
}
static struct ZParamNode137 * ZParamNode__2qrn(struct ZParamNode137 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void SetNameInfo__3qrn(struct ZParamNode137 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->Name = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZReturnNode135 * ZReturnNode__2qrv(struct ZReturnNode135 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2qrv(struct ZReturnNode135 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZReturnNode135 * ToReturnNode__1qrv(struct ZReturnNode135 * this) {
	return this;
}
static struct ZSetIndexNode143 * ZSetIndexNode__3qr8(struct ZSetIndexNode143 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * LeftNode__2) {
	ThrowError("not function: ZNode");
	Set__3qws(this, ZSetIndexNode_Recv_Z25, LeftNode);
	return NULL;
}
static void Accept__2qr8(struct ZSetIndexNode143 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZSetNameNode146 * ZSetNameNode__4qte(struct ZSetNameNode146 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, const char * VarName__3) {
	ThrowError("not function: ZNode");
	this->VarName = VarName;
	return NULL;
}
static void Accept__2qte(struct ZSetNameNode146 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZSetterNode149 * ZSetterNode__3qty(struct ZSetterNode149 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2) {
	ThrowError("not function: ZNode");
	Set__3qws(this, ZSetterNode_Recv_Z29, RecvNode);
	return NULL;
}
static void SetNameInfo__3qty(struct ZSetterNode149 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qty(struct ZSetterNode149 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsStaticField__1qty(struct ZSetterNode149 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZSetterNode_Recv_Z29), 199);
}
static struct ZSugarNode130 * ZSugarNode__3qr1(struct ZSugarNode130 * this, struct ZNode49 * SugarNode__1, struct ZNode49 * DeSugarNode__2) {
	ThrowError("not function: ZNode");
	this->SugarNode = SugarNode;
	SugarNode->ParentNode = this;
	Set__3qws(this, ZSugarNode_DeSugar_Z31, DeSugarNode);
	DeSugarNode->ParentNode = this;
	return NULL;
}
static void Accept__2qr1(struct ZSugarNode130 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZThrowNode156 * ZThrowNode__2qta(struct ZThrowNode156 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2qta(struct ZThrowNode156 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZTryNode159 * ZTryNode__2qtf(struct ZTryNode159 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2qtf(struct ZTryNode159 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZUnaryNode162 * ZUnaryNode__3qtj(struct ZUnaryNode162 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2qtj(struct ZUnaryNode162 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZWhileNode165 * ZWhileNode__2qt9(struct ZWhileNode165 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2qt9(struct ZWhileNode165 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static const char * toString__1qtz(struct ZEmptyValue168 * this) {
	return "";
}
static void Report__2qev(struct ZLogger99 * this, const char * Message__1) {
	/*untyped*/NULL;
	return;
}
static ArrayOfString * GetReportedErrors__1qev(struct ZLogger99 * this) {
	ArrayOfString * List = this->ReportedErrorList;
	this->ReportedErrorList = LibZen_NewStringArray(0);
	return /*untyped*/NULL;
}
static void ShowErrors__1qev(struct ZLogger99 * this) {
	ArrayOfString * Messages = GetReportedErrors__1qev(this);
	long i = 0;
	while (i < /*untyped*/NULL) {
		/*untyped*/NULL;
		i = i + 1;
	};
	return;
}
static struct ZMacroFunc176 * ZMacroFunc__3qt5(struct ZMacroFunc176 * this, const char * FuncName__1, struct ZFuncType67 * FuncType__2) {
	ThrowError("not function: ZFunc");
	return NULL;
}
static struct ZNameSpace43 * ZNameSpace__3qwi(struct ZNameSpace43 * this, struct ZGenerator52 * Generator__1, struct ZNameSpace43 * ParentNameSpace__2) {
	this->ParentNameSpace = ParentNameSpace;
	if (ParentNameSpace == NULL) {
		this->Generator = Generator;
	} else {
		this->Generator = ParentNameSpace->Generator;
	};
	this->SerialId = 0;
	return NULL;
}
static const char * toString__1qwi(struct ZNameSpace43 * this) {
	return LibZen_StrCat(LibZen_StrCat("NS[", LibZen_IntToString(this->SerialId)), "]");
}
static struct ZNameSpace43 * CreateSubNameSpace__1qwi(struct ZNameSpace43 * this) {
	return ZNameSpace__3qwi(_NewZNameSpace43(), NULL, this);
}
static struct ZNameSpace43 * GetRootNameSpace__1qwi(struct ZNameSpace43 * this) {
	return this->Generator->RootNameSpace;
}
static struct ZTokenFunc28 * GetTokenFunc__2qwi(struct ZNameSpace43 * this, long ZenChar__1) {
	if (this->TokenMatrix == NULL) {
		return GetTokenFunc__2qwi(this->ParentNameSpace, ZenChar);
	};
	return Array<ZTokenFunc>GetIndex(ZenChar);
}
static struct ZTokenFunc28 * JoinParentFunc__3qwi(struct ZNameSpace43 * this, struct ZTokenFunction45 * Func__1, struct ZTokenFunc28 * Parent__2) {
	if (Parent != NULL && Parent->Func == Func) {
		return Parent;
	};
	return ZTokenFunc__3qqb(_NewZTokenFunc28(), Func, Parent);
}
static void AppendTokenFunc__3qwi(struct ZNameSpace43 * this, const char * keys__1, struct ZTokenFunction45 * TokenFunc__2) {
	if (this->TokenMatrix == NULL) {
		this->TokenMatrix = LibZen_NewTokenMatrix__0qqw();
		if (this->ParentNameSpace != NULL) {
			long i = 0;
			while (i < /*untyped*/NULL) {
				Array<ZTokenFunc>SetIndex(i, GetTokenFunc__2qwi(this->ParentNameSpace, i));
				i = i + 1;
			};
		};
	};
	long i = 0;
	while (i < /*untyped*/NULL) {
		long kchar = LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(keys, i));
		Array<ZTokenFunc>SetIndex(kchar, JoinParentFunc__3qwi(this, TokenFunc, Array<ZTokenFunc>GetIndex(kchar)));
		i = i + 1;
	};
	return;
}
static struct ZSyntax184 * GetSyntaxPattern__2qwi(struct ZNameSpace43 * this, const char * PatternName__1) {
	struct ZNameSpace43 * NameSpace = this;
	while (NameSpace != NULL) {
		if (NameSpace->SyntaxTable != NULL) {
			return Map<ZSyntax>GetIndex(PatternName);
		};
		NameSpace = NameSpace->ParentNameSpace;
	};
	return NULL;
}
static void SetSyntaxPattern__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZSyntax184 * Syntax__2) {
	if (this->SyntaxTable == NULL) {
		this->SyntaxTable = LibZen_NewMap(0);
	};
	Map<ZSyntax>SetIndex(PatternName, Syntax);
	return;
}
static struct ZSyntax184 * GetRightSyntaxPattern__2qwi(struct ZNameSpace43 * this, const char * PatternName__1) {
	return GetSyntaxPattern__2qwi(this, ZNameSpace_RightPatternSymbol__1qqy(PatternName));
}
static void AppendSyntaxPattern__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZSyntax184 * NewPattern__2) {
	LibZen_Assert__1qqe(NewPattern->ParentPattern == NULL);
	struct ZSyntax184 * ParentPattern = GetSyntaxPattern__2qwi(this, PatternName);
	NewPattern->ParentPattern = ParentPattern;
	SetSyntaxPattern__3qwi(this, PatternName, NewPattern);
	return;
}
static void DefineStatement__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZMatchFunction48 * MatchFunc__2) {
	long Alias = /*untyped*/NULL;
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = /*untyped*/NULL;
	};
	struct ZSyntax184 * Pattern = ZSyntax__4qyt(_NewZSyntax184(), this, Name, MatchFunc);
	Pattern->IsStatement = 1/*true*/;
	AppendSyntaxPattern__3qwi(this, Name, Pattern);
	if (Alias != -1) {
		DefineStatement__3qwi(this, /*untyped*/NULL, MatchFunc);
	};
	return;
}
static void DefineExpression__3qwi(struct ZNameSpace43 * this, const char * PatternName__1, struct ZMatchFunction48 * MatchFunc__2) {
	long Alias = /*untyped*/NULL;
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = /*untyped*/NULL;
	};
	struct ZSyntax184 * Pattern = ZSyntax__4qyt(_NewZSyntax184(), this, Name, MatchFunc);
	AppendSyntaxPattern__3qwi(this, Name, Pattern);
	if (Alias != -1) {
		DefineExpression__3qwi(this, /*untyped*/NULL, MatchFunc);
	};
	return;
}
static void DefineRightExpression__4qwi(struct ZNameSpace43 * this, const char * PatternName__1, long SyntaxFlag__2, struct ZMatchFunction48 * MatchFunc__3) {
	long Alias = /*untyped*/NULL;
	const char * Name = PatternName;
	if (Alias != -1) {
		Name = /*untyped*/NULL;
	};
	struct ZSyntax184 * Pattern = ZSyntax__4qyt(_NewZSyntax184(), this, Name, MatchFunc);
	Pattern->SyntaxFlag = SyntaxFlag;
	AppendSyntaxPattern__3qwi(this, ZNameSpace_RightPatternSymbol__1qqy(Name), Pattern);
	if (Alias != -1) {
		DefineRightExpression__4qwi(this, /*untyped*/NULL, SyntaxFlag, MatchFunc);
	};
	return;
}
static struct ZSymbolEntry189 * GetSymbol__2qwi(struct ZNameSpace43 * this, const char * Symbol__1) {
	struct ZNameSpace43 * NameSpace = this;
	while (NameSpace != NULL) {
		if (NameSpace->SymbolTable != NULL) {
			struct ZSymbolEntry189 * Entry = Map<ZSymbolEntry>GetIndex(Symbol);
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
static struct ZNode49 * GetSymbolNode__2qwi(struct ZNameSpace43 * this, const char * Symbol__1) {
	struct ZSymbolEntry189 * Entry = GetSymbol__2qwi(this, Symbol);
	if (Entry != NULL) {
		return Entry->Node;
	};
	return NULL;
}
static void SetLocalSymbolEntry__3qwi(struct ZNameSpace43 * this, const char * Symbol__1, struct ZSymbolEntry189 * Entry__2) {
	if (this->SymbolTable == NULL) {
		this->SymbolTable = LibZen_NewMap(0);
	};
	Map<ZSymbolEntry>SetIndex(Symbol, Entry);
	return;
}
static struct ZSymbolEntry189 * SetLocalSymbol__3qwi(struct ZNameSpace43 * this, const char * Symbol__1, struct ZNode49 * Node__2) {
	struct ZSymbolEntry189 * Parent = GetSymbol__2qwi(this, Symbol);
	Node->ParentNode = NULL;
	SetLocalSymbolEntry__3qwi(this, Symbol, ZSymbolEntry__3qyp(_NewZSymbolEntry189(), Parent, Node));
	return Parent;
}
static struct ZSymbolEntry189 * SetGlobalSymbol__3qwi(struct ZNameSpace43 * this, const char * Symbol__1, struct ZNode49 * Node__2) {
	return SetLocalSymbol__3qwi(GetRootNameSpace__1qwi(this), Symbol, Node);
}
static struct ZVariable194 * GetLocalVariable__2qwi(struct ZNameSpace43 * this, const char * VarName__1) {
	struct ZSymbolEntry189 * Entry = GetSymbol__2qwi(this, VarName);
	if (LibZen_Is(Entry, 194)) {
		return (struct ZVariable194 *)Entry;
	};
	return NULL;
}
static void SetLocalVariable__5qwi(struct ZNameSpace43 * this, struct ZFunctionNode109 * FunctionNode__1, struct ZType59 * VarType__2, const char * VarName__3, struct ZToken64 * SourceToken__4) {
	struct ZSymbolEntry189 * Parent = GetSymbol__2qwi(this, VarName);
	struct ZVariable194 * VarInfo = ZVariable__7qyd(_NewZVariable194(), Parent, FunctionNode, 0, VarType, VarName, SourceToken);
	SetLocalSymbolEntry__3qwi(this, VarName, VarInfo);
	return;
}
static void SetTypeName__4qwi(struct ZNameSpace43 * this, const char * Name__1, struct ZType59 * Type__2, struct ZToken64 * SourceToken__3) {
	struct ZTypeNode199 * Node = ZTypeNode__4qyk(_NewZTypeNode199(), NULL, SourceToken, Type);
	(void)SetLocalSymbol__3qwi(this, Name, Node);
	return;
}
static void SetTypeName__3qwi(struct ZNameSpace43 * this, struct ZType59 * Type__1, struct ZToken64 * SourceToken__2) {
	SetTypeName__4qwi(this, Type->ShortName, Type, SourceToken);
	return;
}
static struct ZTypeNode199 * GetTypeNode__3qwi(struct ZNameSpace43 * this, const char * TypeName__1, struct ZToken64 * SourceToken__2) {
	struct ZNode49 * Node = GetSymbolNode__2qwi(this, TypeName);
	if (LibZen_Is(Node, 199)) {
		return (struct ZTypeNode199 *)Node;
	};
	if (Node == NULL && SourceToken != NULL) {
		struct ZType59 * Type = ZClassType__3qwv(_NewZClassType63(), TypeName, ZTypeVarType_Z6);
		SetTypeName__4qwi(GetRootNameSpace__1qwi(this), TypeName, Type, SourceToken);
		return GetTypeNode__3qwi(this, TypeName, NULL);
	};
	return NULL;
}
static struct ZType59 * GetType__3qwi(struct ZNameSpace43 * this, const char * TypeName__1, struct ZToken64 * SourceToken__2) {
	struct ZTypeNode199 * TypeNode = GetTypeNode__3qwi(this, TypeName, SourceToken);
	if (TypeNode != NULL) {
		return TypeNode->Type;
	};
	return NULL;
}
static struct ZSource202 * ZSource__5qy1(struct ZSource202 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext50 * TokenContext__4) {
	this->FileName = FileName;
	this->LineNumber = LineNumber;
	this->TokenContext = TokenContext;
	this->SourceText = Source;
	this->Logger = TokenContext->Generator->Logger;
	return NULL;
}
static long GetLineNumber__2qy1(struct ZSource202 * this, long Position__1) {
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
static long GetLineHeadPosition__2qy1(struct ZSource202 * this, long Position__1) {
	const char * s = this->SourceText;
	long StartIndex = 0;
	long i = Position;
	if (!(i < /*untyped*/NULL)) {
		i = /*untyped*/NULL;
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
static long CountIndentSize__2qy1(struct ZSource202 * this, long Position__1) {
	const char * s = this->SourceText;
	long length = 0;
	long i = Position;
	while (i < /*untyped*/NULL) {
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
static const char * GetLineText__2qy1(struct ZSource202 * this, long Position__1) {
	const char * s = this->SourceText;
	long StartIndex = 0;
	long EndIndex = /*untyped*/NULL;
	long i = Position;
	if (!(i < /*untyped*/NULL)) {
		i = /*untyped*/NULL;
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
	while (i < /*untyped*/NULL) {
		const char * ch = LibZen_GetChar__2qqy(s, i);
		if (ch == "\n") {
			EndIndex = i;
			break;
		};
		i = i + 1;
	};
	return /*untyped*/NULL;
}
static const char * GetLineMarker__2qy1(struct ZSource202 * this, long Position__1) {
	const char * s = this->SourceText;
	long StartIndex = 0;
	long i = Position;
	if (!(i < /*untyped*/NULL)) {
		i = /*untyped*/NULL;
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
static const char * FormatErrorHeader__4qy1(struct ZSource202 * this, const char * Error__1, long Position__2, const char * Message__3) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("(", this->FileName), ":"), LibZen_IntToString(GetLineNumber__2qy1(this, Position))), ") ["), Error), "] "), Message);
}
static const char * FormatErrorMarker__4qy1(struct ZSource202 * this, const char * Error__1, long Position__2, const char * Message__3) {
	const char * Line = GetLineText__2qy1(this, Position);
	const char * Delim = "\n\t";
	if (/*untyped*/NULL || /*untyped*/NULL) {
		Delim = "\n";
	};
	const char * Header = FormatErrorHeader__4qy1(this, Error, Position, Message);
	const char * Marker = GetLineMarker__2qy1(this, Position);
	Message = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(Header, Delim), Line), Delim), Marker);
	return Message;
}
static const char * GetCharAt__2qy1(struct ZSource202 * this, long n__1) {
	if (0 <= n && n < /*untyped*/NULL) {
		return LibZen_GetChar__2qqy(this->SourceText, n);
	};
	return "0";
}
static struct ZSourceBuilder37 * ZSourceBuilder__3qww(struct ZSourceBuilder37 * this, struct ZSourceGenerator207 * Template__1, struct ZSourceBuilder37 * Parent__2) {
	this->Template = Template;
	this->Parent = Parent;
	return NULL;
}
static struct ZSourceBuilder37 * Pop__1qww(struct ZSourceBuilder37 * this) {
	return this->Parent;
}
static void Clear__1qww(struct ZSourceBuilder37 * this) {
	/*untyped*/NULL;
	return;
}
static long GetPosition__1qww(struct ZSourceBuilder37 * this) {
	return /*untyped*/NULL;
}
static const char * CopyString__3qww(struct ZSourceBuilder37 * this, long BeginIndex__1, long EndIndex__2) {
	return LibZen_SourceBuilderToString__3qww(this, BeginIndex, EndIndex);
}
static void Append__2qww(struct ZSourceBuilder37 * this, const char * Text__1) {
	/*untyped*/NULL;
	return;
}
static void AppendInt__2qww(struct ZSourceBuilder37 * this, long Value__1) {
	/*untyped*/NULL;
	return;
}
static void AppendLineFeed__1qww(struct ZSourceBuilder37 * this) {
	if (/*untyped*/NULL > 0) {
		/*untyped*/NULL;
		this->BufferedLineComment = "";
	};
	/*untyped*/NULL;
	return;
}
static void AppendLineFeed__2qww(struct ZSourceBuilder37 * this, int AppendIndent__1) {
	if (/*untyped*/NULL > 0) {
		/*untyped*/NULL;
		this->BufferedLineComment = "";
	};
	/*untyped*/NULL;
	if (AppendIndent) {
		AppendIndent__1qww(this);
	};
	return;
}
static void AppendWhiteSpace__1qww(struct ZSourceBuilder37 * this) {
	long Size = /*untyped*/NULL;
	if (Size > 0) {
		const char * Last = Array<String>GetIndex(Size - 1);
		if (Last != NULL && (/*untyped*/NULL || /*untyped*/NULL || /*untyped*/NULL)) {
			return;
		};
	};
	/*untyped*/NULL;
	return;
}
static void AppendToken__2qww(struct ZSourceBuilder37 * this, const char * Text__1) {
	AppendWhiteSpace__1qww(this);
	/*untyped*/NULL;
	AppendWhiteSpace__1qww(this);
	return;
}
static void AppendBlockComment__2qww(struct ZSourceBuilder37 * this, const char * Text__1) {
	if (this->Template->BeginComment != NULL) {
		/*untyped*/NULL;
		/*untyped*/NULL;
		/*untyped*/NULL;
	} else if (this->Template->LineComment != NULL) {
		this->BufferedLineComment = LibZen_StrCat(LibZen_StrCat(this->BufferedLineComment, this->Template->LineComment), Text);
	};
	return;
}
static void AppendCommentLine__2qww(struct ZSourceBuilder37 * this, const char * Text__1) {
	if (this->Template->LineComment == NULL) {
		/*untyped*/NULL;
		/*untyped*/NULL;
		/*untyped*/NULL;
	} else {
		/*untyped*/NULL;
		/*untyped*/NULL;
	};
	/*untyped*/NULL;
	return;
}
static void Indent__1qww(struct ZSourceBuilder37 * this) {
	this->IndentLevel = this->IndentLevel + 1;
	this->CurrentIndentString = NULL;
	return;
}
static void UnIndent__1qww(struct ZSourceBuilder37 * this) {
	this->IndentLevel = this->IndentLevel - 1;
	this->CurrentIndentString = NULL;
	LibZen_Assert__1qqe(this->IndentLevel >= 0);
	return;
}
static const char * GetIndentString__1qww(struct ZSourceBuilder37 * this) {
	if (this->CurrentIndentString == NULL) {
		this->CurrentIndentString = LibZen_JoinStrings__2qqy(this->Template->Tab, this->IndentLevel);
	};
	return this->CurrentIndentString;
}
static void AppendIndent__1qww(struct ZSourceBuilder37 * this) {
	/*untyped*/NULL;
	return;
}
static void AppendLineFeedIndent__1qww(struct ZSourceBuilder37 * this) {
	/*untyped*/NULL;
	/*untyped*/NULL;
	return;
}
static void IndentAndAppend__2qww(struct ZSourceBuilder37 * this, const char * Text__1) {
	/*untyped*/NULL;
	/*untyped*/NULL;
	return;
}
static void AppendParamList__4qww(struct ZSourceBuilder37 * this, struct ZListNode215 * ParamList__1, long BeginIdx__2, long EndIdx__3) {
	long i = BeginIdx;
	while (i < EndIdx) {
		if (i > BeginIdx) {
			Append__2qww(this, this->Template->Camma);
		};
		/*untyped*/NULL(GetListAt__2qy8(ParamList, i), this->Template);
		i = i + 1;
	};
	return;
}
static const char * toString__1qww(struct ZSourceBuilder37 * this) {
	return LibZen_SourceBuilderToString__1qww(this);
}
static void AppendLine__2qww(struct ZSourceBuilder37 * this, const char * Text__1) {
	Append__2qww(this, Text);
	AppendLineFeed__1qww(this);
	return;
}
static struct ZSourceContext46 * ZSourceContext__5qw0(struct ZSourceContext46 * this, const char * FileName__1, long LineNumber__2, const char * Source__3, struct ZTokenContext50 * TokenContext__4) {
	ThrowError("not function: ZSource");
	return NULL;
}
static long GetCharCode__1qw0(struct ZSourceContext46 * this) {
	return LibZen_GetTokenMatrixIndex__1qqy(LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition));
}
static long GetPosition__1qw0(struct ZSourceContext46 * this) {
	return this->SourcePosition;
}
static int HasChar__1qw0(struct ZSourceContext46 * this) {
	return /*untyped*/NULL > 0;
}
static const char * GetCurrentChar__1qw0(struct ZSourceContext46 * this) {
	return LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition);
}
static const char * GetCharAtFromCurrentPosition__2qw0(struct ZSourceContext46 * this, long n__1) {
	if ((this->SourcePosition + n) < /*untyped*/NULL) {
		return LibZen_GetChar__2qqy(this->SourceText, this->SourcePosition + n);
	};
	return "0";
}
static void MoveNext__1qw0(struct ZSourceContext46 * this) {
	this->SourcePosition = this->SourcePosition + 1;
	return;
}
static void SkipWhiteSpace__1qw0(struct ZSourceContext46 * this) {
	while (HasChar__1qw0(this)) {
		const char * ch = GetCurrentChar__1qw0(this);
		if (ch != " " && ch != "\t") {
			break;
		};
		MoveNext__1qw0(this);
	};
	return;
}
static void FoundIndent__3qw0(struct ZSourceContext46 * this, long StartIndex__1, long EndIndex__2) {
	struct ZToken64 * Token = ZIndentToken__4qa9(_NewZIndentToken453(), this, StartIndex, EndIndex);
	this->SourcePosition = EndIndex;
	/*untyped*/NULL;
	return;
}
static void Tokenize__3qw0(struct ZSourceContext46 * this, long StartIndex__1, long EndIndex__2) {
	this->SourcePosition = EndIndex;
	if (StartIndex < EndIndex && EndIndex <= /*untyped*/NULL) {
		struct ZToken64 * Token = ZToken__4qwb(_NewZToken64(), this, StartIndex, EndIndex);
		/*untyped*/NULL;
	};
	return;
}
static void Tokenize__4qw0(struct ZSourceContext46 * this, const char * PatternName__1, long StartIndex__2, long EndIndex__3) {
	this->SourcePosition = EndIndex;
	if (StartIndex <= EndIndex && EndIndex <= /*untyped*/NULL) {
		struct ZSyntax184 * Pattern = GetSyntaxPattern__2qwi(this->TokenContext->NameSpace, PatternName);
		if (Pattern == NULL) {
			struct ZToken64 * Token = ZToken__4qwb(_NewZToken64(), this, StartIndex, EndIndex);
			ZLogger_LogInfo__2qwb(Token, LibZen_StrCat("unregistered token pattern: ", PatternName));
			/*untyped*/NULL;
		} else {
			struct ZToken64 * Token = ZPatternToken__5qa6(_NewZPatternToken455(), this, StartIndex, EndIndex, Pattern);
			/*untyped*/NULL;
		};
	};
	return;
}
static int IsDefinedSyntax__3qw0(struct ZSourceContext46 * this, long StartIndex__1, long EndIndex__2) {
	if (EndIndex < /*untyped*/NULL) {
		struct ZNameSpace43 * NameSpace = this->TokenContext->NameSpace;
		const char * Token = /*untyped*/NULL;
		struct ZSyntax184 * Pattern = GetRightSyntaxPattern__2qwi(NameSpace, Token);
		if (Pattern != NULL) {
			return 1/*true*/;
		};
	};
	return 0/*false*/;
}
static void TokenizeDefinedSymbol__2qw0(struct ZSourceContext46 * this, long StartIndex__1) {
	long EndIndex = StartIndex + 2;
	while (IsDefinedSyntax__3qw0(this, StartIndex, EndIndex)) {
		EndIndex = EndIndex + 1;
	};
	Tokenize__3qw0(this, StartIndex, EndIndex - 1);
	return;
}
static void ApplyTokenFunc__2qw0(struct ZSourceContext46 * this, struct ZTokenFunc28 * TokenFunc__1) {
	long RollbackPosition = this->SourcePosition;
	while (TokenFunc != NULL) {
		this->SourcePosition = RollbackPosition;
		if (/*untyped*/NULL) {
			return;
		};
		TokenFunc = TokenFunc->ParentFunc;
	};
	TokenizeDefinedSymbol__2qw0(this, RollbackPosition);
	return;
}
static int DoTokenize__1qw0(struct ZSourceContext46 * this) {
	long TokenSize = /*untyped*/NULL;
	long CheckPosition = this->SourcePosition;
	while (HasChar__1qw0(this)) {
		long CharCode = GetCharCode__1qw0(this);
		struct ZTokenFunc28 * TokenFunc = GetTokenFunc__2qwi(this->TokenContext->NameSpace, CharCode);
		ApplyTokenFunc__2qw0(this, TokenFunc);
		if (/*untyped*/NULL > TokenSize) {
			break;
		};
		if (this->SourcePosition == CheckPosition) {
			/*untyped*/NULL;
			MoveNext__1qw0(this);
		};
	};
	if (/*untyped*/NULL > TokenSize) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void LogWarning__3qw0(struct ZSourceContext46 * this, long Position__1, const char * Message__2) {
	Report__2qev(this->Logger, FormatErrorMarker__4qy1(this, "warning", Position, Message));
	return;
}
static struct ZSourceMacro229 * ZSourceMacro__4qus(struct ZSourceMacro229 * this, const char * FuncName__1, struct ZFuncType67 * FuncType__2, const char * Macro__3) {
	ThrowError("not function: ZMacroFunc");
	this->Macro = Macro;
	return NULL;
}
static struct ZSymbolEntry189 * ZSymbolEntry__3qyp(struct ZSymbolEntry189 * this, struct ZSymbolEntry189 * Parent__1, struct ZNode49 * Node__2) {
	this->Parent = Parent;
	this->Node = Node;
	return NULL;
}
static struct ZSyntax184 * ZSyntax__4qyt(struct ZSyntax184 * this, struct ZNameSpace43 * NameSpace__1, const char * PatternName__2, struct ZMatchFunction48 * MatchFunc__3) {
	this->PackageNameSpace = NameSpace;
	this->PatternName = PatternName;
	this->MatchFunc = MatchFunc;
	return NULL;
}
static const char * toString__1qyt(struct ZSyntax184 * this) {
	return LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(this->PatternName, "{"), ThrowError("type error: requested = String, given = ZMatchFunction")), "}");
}
static int IsBinaryOperator__1qyt(struct ZSyntax184 * this) {
	return LibZen_IsFlag__2qqr(this->SyntaxFlag, ZSyntax_BinaryOperator_Z50);
}
static int IsRightJoin__2qyt(struct ZSyntax184 * this, struct ZSyntax184 * Right__1) {
	long left = this->SyntaxFlag;
	long right = Right->SyntaxFlag;
	return (left < right || (left == right && !LibZen_IsFlag__2qqr(left, ZSyntax_LeftJoin_Z49) && !LibZen_IsFlag__2qqr(right, ZSyntax_LeftJoin_Z49)));
}
static int EqualsName__2qyt(struct ZSyntax184 * this, const char * Name__1) {
	return LibZen_EqualsString__2qqy(this->PatternName, Name);
}
static struct ZToken64 * ZToken__4qwb(struct ZToken64 * this, struct ZSource202 * Source__1, long StartIndex__2, long EndIndex__3) {
	this->Source = Source;
	this->StartIndex = StartIndex;
	this->EndIndex = EndIndex;
	return NULL;
}
static const char * GetFileName__1qwb(struct ZToken64 * this) {
	return this->Source->FileName;
}
static long GetLineNumber__1qwb(struct ZToken64 * this) {
	return GetLineNumber__2qy1(this->Source, this->StartIndex);
}
static const char * GetChar__1qwb(struct ZToken64 * this) {
	if (this->Source != NULL) {
		return LibZen_GetChar__2qqy(this->Source->SourceText, this->StartIndex);
	};
	return "0";
}
static const char * GetText__1qwb(struct ZToken64 * this) {
	if (this->Source != NULL) {
		return /*untyped*/NULL;
	};
	return "";
}
static const char * toString__1qwb(struct ZToken64 * this) {
	const char * ch = GetCharAt__2qy1(this->Source, this->StartIndex - 1);
	if (ch == "\"") {
		return LibZen_StrCat(LibZen_StrCat("\"", GetText__1qwb(this)), "\"");
	};
	return GetText__1qwb(this);
}
static int EqualsText__2qwb(struct ZToken64 * this, const char * Text__1) {
	if (/*untyped*/NULL == (this->EndIndex - this->StartIndex)) {
		const char * s = this->Source->SourceText;
		long i = 0;
		while (i < /*untyped*/NULL) {
			if (LibZen_GetChar__2qqy(s, this->StartIndex + i) != LibZen_GetChar__2qqy(Text, i)) {
				return 0/*false*/;
			};
			i = i + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int StartsWith__2qwb(struct ZToken64 * this, const char * Text__1) {
	if (/*untyped*/NULL <= (this->EndIndex - this->StartIndex)) {
		const char * s = this->Source->SourceText;
		long i = 0;
		while (i < /*untyped*/NULL) {
			if (LibZen_GetChar__2qqy(s, this->StartIndex + i) != LibZen_GetChar__2qqy(Text, i)) {
				return 0/*false*/;
			};
			i = i + 1;
		};
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNull__1qwb(struct ZToken64 * this) {
	return (this == ZToken_NullToken_Z51);
}
static int IsIndent__1qwb(struct ZToken64 * this) {
	return LibZen_Is(this, 453);
}
static int IsNextWhiteSpace__1qwb(struct ZToken64 * this) {
	const char * ch = GetCharAt__2qy1(this->Source, this->EndIndex);
	if (ch == " " || ch == "\t" || ch == "\n") {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNameSymbol__1qwb(struct ZToken64 * this) {
	const char * ch = GetCharAt__2qy1(this->Source, this->StartIndex);
	return LibZen_IsSymbol__1qqy(ch);
}
static long GetIndentSize__1qwb(struct ZToken64 * this) {
	if (this->Source != NULL) {
		return CountIndentSize__2qy1(this->Source, GetLineHeadPosition__2qy1(this->Source, this->StartIndex));
	};
	return 0;
}
static struct ZTokenContext50 * ZTokenContext__6qwd(struct ZTokenContext50 * this, struct ZGenerator52 * Generator__1, struct ZNameSpace43 * NameSpace__2, const char * FileName__3, long LineNumber__4, const char * SourceText__5) {
	this->Generator = Generator;
	this->NameSpace = NameSpace;
	this->Source = ZSourceContext__5qw0(_NewZSourceContext46(), FileName, LineNumber, SourceText, this);
	return NULL;
}
static int SetParseFlag__2qwd(struct ZTokenContext50 * this, int AllowSkipIndent__1) {
	int OldFlag = this->IsAllowSkipIndent;
	this->IsAllowSkipIndent = AllowSkipIndent;
	return OldFlag;
}
static struct ZToken64 * GetBeforeToken__1qwd(struct ZTokenContext50 * this) {
	long MovingPos = this->CurrentPosition - 1;
	while (MovingPos >= 0 && MovingPos < /*untyped*/NULL) {
		struct ZToken64 * Token = Array<ZToken>GetIndex(MovingPos);
		if (!IsIndent__1qwb(Token)) {
			return Token;
		};
		MovingPos = MovingPos - 1;
	};
	return this->LatestToken;
}
static struct ZNode49 * CreateExpectedErrorNode__3qwd(struct ZTokenContext50 * this, struct ZToken64 * SourceToken__1, const char * ExpectedTokenText__2) {
	if (SourceToken == NULL || IsNull__1qwb(SourceToken)) {
		SourceToken = GetBeforeToken__1qwd(this);
		SourceToken = ZToken__4qwb(_NewZToken64(), SourceToken->Source, SourceToken->EndIndex, SourceToken->EndIndex);
		return ZErrorNode__4qpy(_NewZErrorNode329(), NULL, SourceToken, LibZen_StrCat(ExpectedTokenText, " is expected"));
	};
	return ZErrorNode__4qpy(_NewZErrorNode329(), NULL, SourceToken, LibZen_StrCat(ExpectedTokenText, " is expected"));
}
static void Vacume__1qwd(struct ZTokenContext50 * this) {
	return;
}
static void MoveNext__1qwd(struct ZTokenContext50 * this) {
	this->CurrentPosition = this->CurrentPosition + 1;
	return;
}
static struct ZToken64 * GetToken__2qwd(struct ZTokenContext50 * this, int EnforceMoveNext__1) {
	while (1/*true*/) {
		if (!(this->CurrentPosition < /*untyped*/NULL)) {
			if (!DoTokenize__1qw0(this->Source)) {
				break;
			};
		};
		struct ZToken64 * Token = Array<ZToken>GetIndex(this->CurrentPosition);
		if ((this->IsAllowSkipIndent) && IsIndent__1qwb(Token)) {
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
static struct ZToken64 * GetToken__1qwd(struct ZTokenContext50 * this) {
	return GetToken__2qwd(this, 0/*false*/);
}
static int HasNext__1qwd(struct ZTokenContext50 * this) {
	return (GetToken__1qwd(this) != ZToken_NullToken_Z51);
}
static void SkipIndent__1qwd(struct ZTokenContext50 * this) {
	struct ZToken64 * Token = GetToken__1qwd(this);
	while (IsIndent__1qwb(Token)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		Token = GetToken__1qwd(this);
	};
	return;
}
static void SkipError__2qwd(struct ZTokenContext50 * this, struct ZToken64 * ErrorToken__1) {
	long StartIndex = ErrorToken->StartIndex;
	long EndIndex = ErrorToken->EndIndex;
	long length = GetIndentSize__1qwb(ErrorToken);
	while (HasNext__1qwd(this)) {
		struct ZToken64 * Token = GetToken__1qwd(this);
		EndIndex = Token->EndIndex;
		this->CurrentPosition = this->CurrentPosition + 1;
		if (LibZen_Is(Token, 453)) {
			long ilength = GetIndentSize__1qwb(Token);
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
static int IsToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1) {
	struct ZToken64 * Token = GetToken__1qwd(this);
	if (EqualsText__2qwb(Token, TokenText)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static int IsNewLineToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	SkipIndent__1qwd(this);
	struct ZToken64 * Token = GetToken__1qwd(this);
	if (EqualsText__2qwb(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static int MatchToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	struct ZToken64 * Token = GetToken__2qwd(this, ZTokenContext_MoveNext_Z57);
	if (EqualsText__2qwb(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static int MatchNewLineToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1) {
	long RollbackPos = this->CurrentPosition;
	SkipIndent__1qwd(this);
	struct ZToken64 * Token = GetToken__2qwd(this, ZTokenContext_MoveNext_Z57);
	if (EqualsText__2qwb(Token, TokenText)) {
		return 1/*true*/;
	};
	this->CurrentPosition = RollbackPos;
	return 0/*false*/;
}
static struct ZToken64 * ParseLargeToken__1qwd(struct ZTokenContext50 * this) {
	struct ZToken64 * Token = GetToken__2qwd(this, ZTokenContext_MoveNext_Z57);
	if (IsNextWhiteSpace__1qwb(Token)) {
		return Token;
	};
	long StartIndex = Token->StartIndex;
	long EndIndex = Token->EndIndex;
	while (HasNext__1qwd(this) && !IsNextWhiteSpace__1qwb(Token)) {
		long RollbackPosition = this->CurrentPosition;
		Token = GetToken__2qwd(this, ZTokenContext_MoveNext_Z57);
		if (IsIndent__1qwb(Token) || EqualsText__2qwb(Token, ";") || EqualsText__2qwb(Token, ",")) {
			this->CurrentPosition = RollbackPosition;
			break;
		};
		EndIndex = Token->EndIndex;
	};
	return ZToken__4qwb(_NewZToken64(), Token->Source, StartIndex, EndIndex);
}
static struct ZNode49 * MatchToken__4qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, const char * TokenText__2, int IsRequired__3) {
	if (!IsErrorNode__1qws(ParentNode)) {
		long RollbackPosition = this->CurrentPosition;
		struct ZToken64 * Token = GetToken__2qwd(this, ZTokenContext_MoveNext_Z57);
		if (EqualsText__2qwb(Token, TokenText)) {
			if (ParentNode->SourceToken == NULL) {
				ParentNode->SourceToken = Token;
			};
		} else {
			if (IsRequired) {
				return CreateExpectedErrorNode__3qwd(this, Token, TokenText);
			} else {
				this->CurrentPosition = RollbackPosition;
			};
		};
	};
	return ParentNode;
}
static struct ZSyntax184 * GetApplyingSyntax__1qwd(struct ZTokenContext50 * this) {
	return this->ApplyingPattern;
}
static struct ZNode49 * ApplyMatchPattern__5qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * LeftNode__2, struct ZSyntax184 * Pattern__3, int IsRequired__4) {
	long RollbackPosition = this->CurrentPosition;
	struct ZSyntax184 * CurrentPattern = Pattern;
	struct ZToken64 * TopToken = GetToken__1qwd(this);
	struct ZNode49 * ParsedNode = NULL;
	while (CurrentPattern != NULL) {
		int Remembered = this->IsAllowSkipIndent;
		this->CurrentPosition = RollbackPosition;
		this->ApplyingPattern = CurrentPattern;
		ParsedNode = /*untyped*/NULL;
		LibZen_Assert(ParsedNode != ParentNode, "(sample/libzen.zen:3046)");
		this->ApplyingPattern = NULL;
		this->IsAllowSkipIndent = Remembered;
		if (ParsedNode != NULL && !IsErrorNode__1qws(ParsedNode)) {
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
		LibZen_Assert(this->CurrentPosition != RollbackPosition, "(sample/libzen.zen:3060)");
	};
	if (ParsedNode == NULL) {
		ParsedNode = CreateExpectedErrorNode__3qwd(this, TopToken, Pattern->PatternName);
	};
	return ParsedNode;
}
static struct ZNode49 * ParsePatternAfter__5qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * LeftNode__2, const char * PatternName__3, int IsRequired__4) {
	struct ZSyntax184 * Pattern = GetSyntaxPattern__2qwi(this->NameSpace, PatternName);
	struct ZNode49 * ParsedNode = ApplyMatchPattern__5qwd(this, ParentNode, LeftNode, Pattern, IsRequired);
	return ParsedNode;
}
static struct ZNode49 * ParsePattern__4qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, const char * PatternName__2, int IsRequired__3) {
	return ParsePatternAfter__5qwd(this, ParentNode, NULL, PatternName, IsRequired);
}
static struct ZNode49 * MatchPattern__6qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4, int AllowSkipIndent__5) {
	if (!IsErrorNode__1qws(ParentNode)) {
		int Rememberd = SetParseFlag__2qwd(this, AllowSkipIndent);
		struct ZNode49 * ParsedNode = ParsePattern__4qwd(this, ParentNode, PatternName, IsRequired);
		(void)SetParseFlag__2qwd(this, Rememberd);
		if (ParsedNode != NULL) {
			if (Index == ZNode_NestedAppendIndex_Z23) {
				if (!(LibZen_Is(ParsedNode, 327))) {
					Set__3qws(ParentNode, ZNode_AppendIndex_Z22, ParsedNode);
				};
				if (LibZen_Is(ParsedNode, 126) || IsErrorNode__1qws(ParsedNode)) {
					return ParsedNode;
				};
			};
			if (IsErrorNode__1qws(ParsedNode)) {
				return ParsedNode;
			} else {
				if (!(LibZen_Is(ParsedNode, 327))) {
					Set__3qws(ParentNode, Index, ParsedNode);
				};
			};
		};
	};
	return ParentNode;
}
static struct ZNode49 * MatchPattern__5qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, long Index__2, const char * PatternName__3, int IsRequired__4) {
	return MatchPattern__6qwd(this, ParentNode, Index, PatternName, IsRequired, ZTokenContext_NotAllowSkipIndent_Z55);
}
static struct ZNode49 * MatchOptionaPattern__6qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, long Index__2, int AllowNewLine__3, const char * TokenText__4, const char * PatternName__5) {
	if (!IsErrorNode__1qws(ParentNode)) {
		if (MatchToken__2qwd(this, TokenText)) {
			return MatchPattern__6qwd(this, ParentNode, Index, PatternName, ZTokenContext_Optional_Z53, ZTokenContext_NotAllowSkipIndent_Z55);
		};
	};
	return ParentNode;
}
static struct ZNode49 * MatchNtimes__6qwd(struct ZTokenContext50 * this, struct ZNode49 * ParentNode__1, const char * StartToken__2, const char * PatternName__3, const char * DelimToken__4, const char * StopToken__5) {
	int Rememberd = SetParseFlag__2qwd(this, 1/*true*/);
	int IsRequired = ZTokenContext_Optional_Z53;
	if (StartToken != NULL) {
		ParentNode = MatchToken__4qwd(this, ParentNode, StartToken, ZTokenContext_Required_Z52);
	};
	while (!IsErrorNode__1qws(ParentNode)) {
		if (StopToken != NULL) {
			struct ZToken64 * Token = GetToken__1qwd(this);
			if (EqualsText__2qwb(Token, StopToken)) {
				break;
			};
			IsRequired = ZTokenContext_Required_Z52;
		};
		struct ZNode49 * ParsedNode = ParsePattern__4qwd(this, ParentNode, PatternName, IsRequired);
		if (ParsedNode == NULL) {
			break;
		};
		if (IsErrorNode__1qws(ParsedNode)) {
			return ParsedNode;
		};
		if (!(LibZen_Is(ParsedNode, 327))) {
			Set__3qws(ParentNode, ZNode_AppendIndex_Z22, ParsedNode);
		};
		if (DelimToken != NULL) {
			if (!MatchToken__2qwd(this, DelimToken)) {
				break;
			};
		};
	};
	if (StopToken != NULL) {
		ParentNode = MatchToken__4qwd(this, ParentNode, StopToken, ZTokenContext_Required_Z52);
	};
	(void)SetParseFlag__2qwd(this, Rememberd);
	return ParentNode;
}
static int StartsWithToken__2qwd(struct ZTokenContext50 * this, const char * TokenText__1) {
	struct ZToken64 * Token = GetToken__1qwd(this);
	if (EqualsText__2qwb(Token, TokenText)) {
		this->CurrentPosition = this->CurrentPosition + 1;
		return 1/*true*/;
	};
	if (StartsWith__2qwb(Token, TokenText)) {
		Token = ZToken__4qwb(_NewZToken64(), Token->Source, Token->StartIndex + /*untyped*/NULL, Token->EndIndex);
		this->CurrentPosition = this->CurrentPosition + 1;
		/*untyped*/NULL;
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void SkipEmptyStatement__1qwd(struct ZTokenContext50 * this) {
	while (HasNext__1qwd(this)) {
		struct ZToken64 * Token = GetToken__1qwd(this);
		if (IsIndent__1qwb(Token) || EqualsText__2qwb(Token, ";")) {
			this->CurrentPosition = this->CurrentPosition + 1;
			/*untyped*/NULL;
		};
		break;
	};
	return;
}
static void Dump__1qwd(struct ZTokenContext50 * this) {
	long Position = this->CurrentPosition;
	while (Position < /*untyped*/NULL) {
		struct ZToken64 * Token = Array<ZToken>GetIndex(Position);
		const char * DumpedToken = "[";
		DumpedToken = LibZen_StrCat(LibZen_StrCat(LibZen_StrCat(DumpedToken, LibZen_IntToString(Position)), "] "), toString__1qwb(Token));
		LibZen_PrintDebug__1qqy(DumpedToken);
		Position = Position + 1;
	};
	return;
}
static struct ZTokenFunc28 * ZTokenFunc__3qqb(struct ZTokenFunc28 * this, struct ZTokenFunction45 * Func__1, struct ZTokenFunc28 * Parent__2) {
	this->Func = Func;
	this->ParentFunc = Parent;
	return NULL;
}
static const char * toString__1qqb(struct ZTokenFunc28 * this) {
	return /*untyped*/NULL;
}
static struct ZVariable194 * ZVariable__7qyd(struct ZVariable194 * this, struct ZSymbolEntry189 * Parent__1, struct ZFunctionNode109 * FuncNode__2, long VarFlag__3, struct ZType59 * VarType__4, const char * VarName__5, struct ZToken64 * SourceToken__6) {
	ThrowError("not function: ZSymbolEntry");
	this->VarFlag = VarFlag;
	this->VarType = VarType;
	this->VarName = VarName;
	this->SourceToken = SourceToken;
	this->VarUniqueIndex = GetVarIndex__1qrw(FuncNode);
	this->UsedCount = 0;
	this->DefCount = 1;
	return NULL;
}
static int IsCaptured__2qyd(struct ZVariable194 * this, struct ZFunctionNode109 * CurrentFunctionNode__1) {
	if (CurrentFunctionNode == ThrowError("type error: requested = ZFunctionNode, given = ZNode")) {
		return 0/*false*/;
	};
	return 1/*true*/;
}
static void Defined__1qyd(struct ZVariable194 * this) {
	this->DefCount = this->DefCount + 1;
	return;
}
static void Used__1qyd(struct ZVariable194 * this) {
	this->UsedCount = this->UsedCount + 1;
	return;
}
static struct ZClassType63 * ZClassType__3qwv(struct ZClassType63 * this, const char * ShortName__1, struct ZType59 * RefType__2) {
	ThrowError("not function: ZType");
	if (LibZen_Is(RefType, 63)) {
		ResetSuperType__2qwv(this, (struct ZClassType63 *)RefType);
	};
	return NULL;
}
static void ResetSuperType__2qwv(struct ZClassType63 * this, struct ZClassType63 * SuperClass__1) {
	this->RefType = SuperClass;
	if (SuperClass->FieldList != NULL) {
		this->FieldList = LibZen_NewArray(0);
		long i = 0;
		while (i < /*untyped*/NULL) {
			struct ZClassField62 * Field = Array<ZClassField>GetIndex(i);
			/*untyped*/NULL;
			i = i + 1;
		};
	};
	return;
}
static long GetFieldSize__1qwv(struct ZClassType63 * this) {
	if (this->FieldList != NULL) {
		return /*untyped*/NULL;
	};
	return 0;
}
static struct ZClassField62 * GetFieldAt__2qwv(struct ZClassType63 * this, long Index__1) {
	return Array<ZClassField>GetIndex(Index);
}
static int HasField__2qwv(struct ZClassType63 * this, const char * FieldName__1) {
	if (this->FieldList != NULL) {
		long i = 0;
		while (i < /*untyped*/NULL) {
			if (LibZen_EqualsString__2qqy(FieldName, Array<ZClassField>GetIndex(i)->FieldName)) {
				return 1/*true*/;
			};
			i = i + 1;
		};
	};
	return 0/*false*/;
}
static struct ZType59 * GetFieldType__3qwv(struct ZClassType63 * this, const char * FieldName__1, struct ZType59 * DefaultType__2) {
	if (this->FieldList != NULL) {
		long i = 0;
		while (i < /*untyped*/NULL) {
			struct ZClassField62 * Field = Array<ZClassField>GetIndex(i);
			if (LibZen_EqualsString__2qqy(FieldName, Field->FieldName)) {
				return Field->FieldType;
			};
			i = i + 1;
		};
	};
	return DefaultType;
}
static struct ZClassField62 * AppendField__4qwv(struct ZClassType63 * this, struct ZType59 * FieldType__1, const char * FieldName__2, struct ZToken64 * SourceToken__3) {
	LibZen_Assert(!FieldType->IsVarType(FieldType), "(sample/libzen.zen:3286)");
	if (this->FieldList == NULL) {
		this->FieldList = LibZen_NewArray(0);
	};
	struct ZClassField62 * ClassField = ZClassField__5qwc(_NewZClassField62(), this, FieldName, FieldType, SourceToken);
	/*untyped*/NULL;
	return ClassField;
}
static struct ZFuncType67 * ZFuncType__3qw7(struct ZFuncType67 * this, const char * ShortName__1, ArrayOfZType * UniqueTypeParams__2) {
	ThrowError("not function: ZType");
	if (UniqueTypeParams == NULL) {
		this->TypeParams = /*untyped*/NULL;
		Array<ZType>SetIndex(0, ZTypeVarType_Z6);
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
static int IsFuncType__1qw7(struct ZFuncType67 * this) {
	return 1/*true*/;
}
static int IsVarType__1qw7(struct ZFuncType67 * this) {
	return this->HasUnknownType;
}
static int IsGreekType__1qw7(struct ZFuncType67 * this) {
	return this->HasGreekType;
}
static struct ZType59 * GetGreekRealType__2qw7(struct ZFuncType67 * this, ArrayOfZType * Greek__1) {
	if (this->HasGreekType) {
		ArrayOfZType * TypeList = LibZen_NewArray(0);
		long i = 0;
		while (i < /*untyped*/NULL(this->TypeParams)) {
			/*untyped*/NULL;
			i = i + 1;
		};
		return ZTypePool_LookupFuncType__1qwz(TypeList);
	};
	return this;
}
static int AcceptValueType__4qw7(struct ZFuncType67 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (IsFuncType__1qw6(ValueType) && ValueType->GetParamSize(ValueType) == this->GetParamSize(this)) {
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
static const char * StringfySignature__2qw7(struct ZFuncType67 * this, const char * FuncName__1) {
	return ZFunc_StringfySignature__3qqy(FuncName, GetFuncParamSize__1qw7(this), GetRecvType__1qw7(this));
}
static struct ZType59 * GetBaseType__1qw7(struct ZFuncType67 * this) {
	return ZTypeFuncType_Z15;
}
static long GetParamSize__1qw7(struct ZFuncType67 * this) {
	return /*untyped*/NULL(this->TypeParams);
}
static struct ZType59 * GetParamType__2qw7(struct ZFuncType67 * this, long Index__1) {
	return Array<ZType>GetIndex(Index);
}
static struct ZType59 * GetReturnType__1qw7(struct ZFuncType67 * this) {
	return Array<ZType>GetIndex(0);
}
static long GetFuncParamSize__1qw7(struct ZFuncType67 * this) {
	return /*untyped*/NULL(this->TypeParams) - 1;
}
static struct ZType59 * GetRecvType__1qw7(struct ZFuncType67 * this) {
	if (/*untyped*/NULL(this->TypeParams) == 1) {
		return ZTypeVoidType_Z7;
	};
	return Array<ZType>GetIndex(1);
}
static struct ZType59 * GetFuncParamType__2qw7(struct ZFuncType67 * this, long Index__1) {
	return Array<ZType>GetIndex(Index + 1);
}
static struct ZFuncType67 * NewMethodFuncType__2qw7(struct ZFuncType67 * this, struct ZType59 * RecvType__1) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	/*untyped*/NULL;
	/*untyped*/NULL;
	long i = 0;
	while (i < GetFuncParamSize__1qw7(this)) {
		/*untyped*/NULL;
		i = i + 1;
	};
	return ZTypePool_LookupFuncType__1qwz(TypeList);
}
static int AcceptAsFieldFunc__2qw7(struct ZFuncType67 * this, struct ZFuncType67 * FuncType__1) {
	if (GetFuncParamSize__1qw7(FuncType) == GetFuncParamSize__1qw7(this) && Equals__2qw6(GetReturnType__1qw7(FuncType), GetReturnType__1qw7(this))) {
		long i = 1;
		while (i < GetFuncParamSize__1qw7(FuncType)) {
			if (!Equals__2qw6(GetFuncParamType__2qw7(FuncType, i), GetFuncParamType__2qw7(this, i))) {
				return 0/*false*/;
			};
			i = i + 1;
		};
	};
	return 1/*true*/;
}
static struct ZGeneric1Type282 * ZGeneric1Type__5qim(struct ZGeneric1Type282 * this, long TypeFlag__1, const char * ShortName__2, struct ZType59 * BaseType__3, struct ZType59 * ParamType__4) {
	ThrowError("not function: ZType");
	this->BaseType = BaseType;
	if (this->BaseType == NULL) {
		this->BaseType = this;
	};
	this->ParamType = ParamType;
	return NULL;
}
static struct ZType59 * GetSuperType__1qim(struct ZGeneric1Type282 * this) {
	if (this->BaseType == this) {
		return this->RefType;
	};
	return this->BaseType;
}
static struct ZType59 * GetBaseType__1qim(struct ZGeneric1Type282 * this) {
	return this->BaseType;
}
static long GetParamSize__1qim(struct ZGeneric1Type282 * this) {
	return 1;
}
static struct ZType59 * GetParamType__2qim(struct ZGeneric1Type282 * this, long Index__1) {
	if (Index == 0) {
		return this->ParamType;
	};
	return NULL;
}
static int IsGreekType__1qim(struct ZGeneric1Type282 * this) {
	return /*untyped*/NULL;
}
static struct ZType59 * GetGreekRealType__2qim(struct ZGeneric1Type282 * this, ArrayOfZType * Greek__1) {
	if (this->ParamType->IsGreekType(this->ParamType)) {
		return ZTypePool_GetGenericType1__2qw6(this->BaseType, this->ParamType->GetGreekRealType(this->ParamType, Greek));
	};
	return this->GetRealType(this);
}
static int AcceptValueType__4qim(struct ZGeneric1Type282 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
	if (this->BaseType == ValueType->GetBaseType(ValueType) && /*untyped*/NULL(ValueType) == 1) {
		return /*untyped*/NULL(this->ParamType, /*untyped*/NULL(ValueType, 0), 1/*true*/, Greek);
	};
	return 0/*false*/;
}
static struct ZGreekType290 * ZGreekType__2qoe(struct ZGreekType290 * this, long GreekId__1) {
	ThrowError("not function: ZType");
	this->GreekId = GreekId;
	return NULL;
}
static int IsGreekType__1qoe(struct ZGreekType290 * this) {
	return 1/*true*/;
}
static struct ZType59 * GetGreekRealType__2qoe(struct ZGreekType290 * this, ArrayOfZType * Greek__1) {
	if (Array<ZType>GetIndex(this->GreekId) == NULL) {
		return ZTypeVarType_Z6;
	};
	return Array<ZType>GetIndex(this->GreekId);
}
static int AcceptValueType__4qoe(struct ZGreekType290 * this, struct ZType59 * ValueType__1, int ExactMatch__2, ArrayOfZType * Greek__3) {
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
static struct ZAnnotationNode295 * ZAnnotationNode__4qoi(struct ZAnnotationNode295 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, MapOfObject * Anno__3) {
	ThrowError("not function: ZNode");
	return NULL;
}
static int IsBreakingBlock__1qoi(struct ZAnnotationNode295 * this) {
	return /*untyped*/NULL(this->AnnotatedNode);
}
static void Accept__2qoi(struct ZAnnotationNode295 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(this->AnnotatedNode, Visitor);
	return;
}
static struct ZAssertNode301 * ZAssertNode__2qos(struct ZAssertNode301 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static struct ZSugarNode130 * DeSugar__2qos(struct ZAssertNode301 * this, struct ZGenerator52 * Generator__1) {
	struct ZMacroFunc176 * Func = GetMacroFunc__4qwg(Generator, "assert", ZTypeBooleanType_Z8, 2);
	if (Func != NULL) {
		struct ZMacroNode385 * MacroNode = ZMacroNode__4q0x(_NewZMacroNode385(), this->ParentNode, this->SourceToken, Func);
		Append__2qy8(MacroNode, Array<ZNode>GetIndex(ZAssertNode_Expr_Z58));
		Append__2qy8(MacroNode, ZStringNode__4q4b(_NewZStringNode424(), MacroNode, NULL, GetSourceLocation__1qws(this)));
		return ZSugarNode__3qr1(_NewZSugarNode130(), this, MacroNode);
	} else {
		struct ZFuncCallNode400 * MacroNode = ZFuncCallNode__4q4t(_NewZFuncCallNode400(), this->ParentNode, "assert", ZTypeVarType_Z6);
		Append__2qy8(MacroNode, Array<ZNode>GetIndex(ZAssertNode_Expr_Z58));
		return ZSugarNode__3qr1(_NewZSugarNode130(), this, MacroNode);
	};
}
static struct ZBinaryNode304 * ZBinaryNode__5qog(struct ZBinaryNode304 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4) {
	ThrowError("not function: ZNode");
	Set__3qws(this, ZBinaryNode_Left_Z59, Left);
	LibZen_Assert(Pattern != NULL, "(sample/libzen.zen:3527)");
	this->Pattern = Pattern;
	return NULL;
}
static int IsRightJoin__2qog(struct ZBinaryNode304 * this, struct ZNode49 * Node__1) {
	if (LibZen_Is(Node, 304)) {
		return IsRightJoin__2qyt(this->Pattern, ((struct ZBinaryNode304 *)Node)->Pattern);
	};
	return 0/*false*/;
}
static struct ZNode49 * RightJoin__3qog(struct ZBinaryNode304 * this, struct ZNode49 * ParentNode__1, struct ZBinaryNode304 * RightNode__2) {
	struct ZNode49 * RightLeftNode = Array<ZNode>GetIndex(ZBinaryNode_Left_Z59);
	if (IsRightJoin__2qog(this, RightLeftNode)) {
		Set__3qws(RightNode, ZBinaryNode_Left_Z59, RightJoin__3qog(this, ParentNode, (struct ZBinaryNode304 *)RightLeftNode));
	} else {
		Set__3qws(RightNode, ZBinaryNode_Left_Z59, this);
		Set__3qws(this, ZBinaryNode_Right_Z60, RightLeftNode);
	};
	return RightNode;
}
static struct ZNode49 * AppendParsedRightNode__3qog(struct ZBinaryNode304 * this, struct ZNode49 * ParentNode__1, struct ZTokenContext50 * TokenContext__2) {
	struct ZNode49 * RightNode = ParsePattern__4qwd(TokenContext, ParentNode, "$Expression$", ZTokenContext_Required_Z52);
	if (IsErrorNode__1qws(RightNode)) {
		return RightNode;
	};
	if (IsRightJoin__2qog(this, RightNode)) {
		return RightJoin__3qog(this, ParentNode, (struct ZBinaryNode304 *)RightNode);
	};
	Set__3qws(this, ZBinaryNode_Right_Z60, RightNode);
	return this;
}
static struct ZNode49 * TryMacroNode__2qog(struct ZBinaryNode304 * this, struct ZGenerator52 * Generator__1) {
	if (!/*untyped*/NULL(GetAstType__2qws(this, ZBinaryNode_Left_Z59)) && !/*untyped*/NULL(GetAstType__2qws(this, ZBinaryNode_Right_Z60))) {
		const char * Op = GetText__1qwb(this->SourceToken);
		struct ZFunc66 * Func = GetDefinedFunc__4qwg(Generator, Op, GetAstType__2qws(this, ZBinaryNode_Left_Z59), 2);
		if (LibZen_Is(Func, 176)) {
			struct ZMacroNode385 * MacroNode = ZMacroNode__4q0x(_NewZMacroNode385(), this->ParentNode, this->SourceToken, (struct ZMacroFunc176 *)Func);
			Append__2qy8(MacroNode, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
			Append__2qy8(MacroNode, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
			return MacroNode;
		};
	};
	return this;
}
static void Accept__2qog(struct ZBinaryNode304 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZBreakNode311 * ZBreakNode__2qo6(struct ZBreakNode311 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2qo6(struct ZBreakNode311 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZCastNode314 * ZCastNode__4qoc(struct ZCastNode314 * this, struct ZNode49 * ParentNode__1, struct ZType59 * CastType__2, struct ZNode49 * Node__3) {
	ThrowError("not function: ZNode");
	this->Type = CastType;
	if (Node != NULL) {
		Set__3qws(this, ZCastNode_Expr_Z61, Node);
	};
	return NULL;
}
static void Accept__2qoc(struct ZCastNode314 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZListNode215 * ToFuncCallNode__2qoc(struct ZCastNode314 * this, struct ZFunc66 * Func__1) {
	if (LibZen_Is(Func, 176)) {
		struct ZMacroNode385 * FuncNode = ZMacroNode__4q0x(_NewZMacroNode385(), this->ParentNode, this->SourceToken, (struct ZMacroFunc176 *)Func);
		Append__2qy8(FuncNode, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
		return FuncNode;
	} else {
		struct ZFuncCallNode400 * FuncNode = ZFuncCallNode__4q4t(_NewZFuncCallNode400(), this->ParentNode, Func->FuncName, GetFuncType__1qwm(Func));
		FuncNode->SourceToken = this->SourceToken;
		Append__2qy8(FuncNode, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
		return FuncNode;
	};
}
static struct ZCatchNode318 * ZCatchNode__2qom(struct ZCatchNode318 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void SetTypeInfo__3qom(struct ZCatchNode318 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->ExceptionType = Type;
	return;
}
static void SetNameInfo__3qom(struct ZCatchNode318 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->ExceptionName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZComparatorNode322 * ZComparatorNode__5qo2(struct ZComparatorNode322 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4) {
	ThrowError("not function: ZBinaryNode");
	return NULL;
}
static void Accept__2qo2(struct ZComparatorNode322 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZConstNode325 * ZConstNode__3qpw(struct ZConstNode325 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2) {
	ThrowError("not function: ZNode");
	return NULL;
}
static struct ZEmptyNode327 * ZEmptyNode__3qpr(struct ZEmptyNode327 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2) {
	ThrowError("not function: ZNode");
	return NULL;
}
static struct ZErrorNode329 * ZErrorNode__4qpy(struct ZErrorNode329 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, const char * ErrorMessage__3) {
	ThrowError("not function: ZConstNode");
	this->ErrorMessage = ErrorMessage;
	return NULL;
}
static struct ZErrorNode329 * ZErrorNode__3qpy(struct ZErrorNode329 * this, struct ZNode49 * Node__1, const char * ErrorMessage__2) {
	ThrowError("not function: ZConstNode");
	this->ErrorMessage = ErrorMessage;
	return NULL;
}
static void Accept__2qpy(struct ZErrorNode329 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFieldNode333 * ZFieldNode__2qpp(struct ZFieldNode333 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void SetTypeInfo__3qpp(struct ZFieldNode333 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->DeclType = Type;
	return;
}
static void SetNameInfo__3qpp(struct ZFieldNode333 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZFloatNode337 * ZFloatNode__4qps(struct ZFloatNode337 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, double Value__3) {
	ThrowError("not function: ZConstNode");
	this->Type = ZTypeFloatType_Z10;
	this->FloatValue = Value;
	return NULL;
}
static void Accept__2qps(struct ZFloatNode337 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGetIndexNode340 * ZGetIndexNode__3qpg(struct ZGetIndexNode340 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2) {
	ThrowError("not function: ZNode");
	Array<ZNode>SetIndex(ZGetIndexNode_Recv_Z64, SetChild__2qws(this, RecvNode));
	return NULL;
}
static void Accept__2qpg(struct ZGetIndexNode340 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGetNameNode343 * ZGetNameNode__4qpk(struct ZGetNameNode343 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, const char * NativeName__3) {
	ThrowError("not function: ZNode");
	this->VarName = NativeName;
	return NULL;
}
static struct ZGetNameNode343 * ZGetNameNode__3qpk(struct ZGetNameNode343 * this, struct ZNode49 * ParentNode__1, struct ZFunc66 * ResolvedFunc__2) {
	ThrowError("not function: ZNode");
	this->VarName = ResolvedFunc->FuncName;
	this->Type = GetFuncType__1qwm(ResolvedFunc);
	return NULL;
}
static void Accept__2qpk(struct ZGetNameNode343 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNode49 * ToGlobalNameNode__1qpk(struct ZGetNameNode343 * this) {
	return ZGlobalNameNode__6qpn(_NewZGlobalNameNode353(), this->ParentNode, this->SourceToken, this->Type, this->VarName, 0/*false*/);
}
static struct ZGetterNode348 * ZGetterNode__3qpz(struct ZGetterNode348 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2) {
	ThrowError("not function: ZNode");
	Set__3qws(this, ZGetterNode_Recv_Z66, RecvNode);
	return NULL;
}
static void SetNameInfo__3qpz(struct ZGetterNode348 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->FieldName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qpz(struct ZGetterNode348 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static int IsStaticField__1qpz(struct ZGetterNode348 * this) {
	return LibZen_Is(Array<ZNode>GetIndex(ZGetterNode_Recv_Z66), 199);
}
static struct ZGlobalNameNode353 * ZGlobalNameNode__6qpn(struct ZGlobalNameNode353 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZType59 * Type__3, const char * GlobalName__4, int IsStaticFuncName__5) {
	ThrowError("not function: ZNode");
	this->GlobalName = GlobalName;
	this->Type = Type;
	this->IsStaticFuncName = IsStaticFuncName;
	return NULL;
}
static int IsGivenName__1qpn(struct ZGlobalNameNode353 * this) {
	return (!this->IsStaticFuncName);
}
static void Accept__2qpn(struct ZGlobalNameNode353 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGroupNode357 * ZGroupNode__2qp3(struct ZGroupNode357 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2qp3(struct ZGroupNode357 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZIfNode360 * ZIfNode__2q0q(struct ZIfNode360 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void Accept__2q0q(struct ZIfNode360 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZImportNode363 * ZImportNode__2q0r(struct ZImportNode363 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void SetNameInfo__3q0r(struct ZImportNode363 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	if (this->ResourcePath == NULL) {
		this->ResourcePath = Name;
		this->ResourceToken = NameToken;
	} else {
		this->Alias = Name;
	};
	return;
}
static struct ZInstanceOfNode366 * ZInstanceOfNode__4q0u(struct ZInstanceOfNode366 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, struct ZNode49 * LeftNode__3) {
	ThrowError("not function: ZNode");
	Set__3qws(this, ZInstanceOfNode_Left_Z71, LeftNode);
	return NULL;
}
static void SetTypeInfo__3q0u(struct ZInstanceOfNode366 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->TargetType = Type;
	return;
}
static void Accept__2q0u(struct ZInstanceOfNode366 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZIntNode370 * ZIntNode__4q00(struct ZIntNode370 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, long Value__3) {
	ThrowError("not function: ZConstNode");
	this->Type = ZTypeIntType_Z9;
	this->IntValue = Value;
	return NULL;
}
static void Accept__2q00(struct ZIntNode370 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZLetNode373 * ZLetNode__2q0s(struct ZLetNode373 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static void SetNameInfo__3q0s(struct ZLetNode373 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->Symbol = Name;
	this->SymbolToken = NameToken;
	return;
}
static void SetTypeInfo__3q0s(struct ZLetNode373 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->SymbolType = Type;
	return;
}
static void Accept__2q0s(struct ZLetNode373 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZGlobalNameNode353 * ToGlobalNameNode__1q0s(struct ZLetNode373 * this) {
	return ZGlobalNameNode__6qpn(_NewZGlobalNameNode353(), NULL, this->SymbolToken, GetAstType__2qws(this, ZLetNode_InitValue_Z72), this->GlobalName, 0/*false*/);
}
static struct ZListNode215 * ZListNode__4qy8(struct ZListNode215 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, long Size__3) {
	ThrowError("not function: ZNode");
	this->ListStartIndex = Size;
	return NULL;
}
static void Append__2qy8(struct ZListNode215 * this, struct ZNode49 * Node__1) {
	if (this->AST == NULL) {
		this->AST = /*untyped*/NULL;
		Set__3qws(this, 0, Node);
	} else {
		ArrayOfZNode * newAST = /*untyped*/NULL;
		/*untyped*/NULL;
		this->AST = newAST;
		Set__3qws(this, /*untyped*/NULL, Node);
	};
	return;
}
static long GetListSize__1qy8(struct ZListNode215 * this) {
	return GetAstSize__1qws(this) - this->ListStartIndex;
}
static struct ZNode49 * GetListAt__2qy8(struct ZListNode215 * this, long Index__1) {
	return Array<ZNode>GetIndex(this->ListStartIndex + Index);
}
static void SetListAt__3qy8(struct ZListNode215 * this, long Index__1, struct ZNode49 * Node__2) {
	Set__3qws(this, Index + this->ListStartIndex, Node);
	return;
}
static void InsertListAt__3qy8(struct ZListNode215 * this, long Index__1, struct ZNode49 * Node__2) {
	if (this->AST == NULL || Index < 0 || /*untyped*/NULL == Index) {
		Append__2qy8(this, Node);
	} else {
		ArrayOfZNode * newAST = /*untyped*/NULL;
		Index = this->ListStartIndex + Index;
		/*untyped*/NULL;
		Set__3qws(this, Index, Node);
		/*untyped*/NULL;
		this->AST = newAST;
	};
	return;
}
static struct ZNode49 * RemoveListAt__2qy8(struct ZListNode215 * this, long Index__1) {
	struct ZNode49 * Removed = GetListAt__2qy8(this, Index);
	ArrayOfZNode * newAST = /*untyped*/NULL;
	long RemovedIndex = this->ListStartIndex + Index;
	/*untyped*/NULL;
	/*untyped*/NULL;
	this->AST = newAST;
	return Removed;
}
static void ClearListAfter__2qy8(struct ZListNode215 * this, long Size__1) {
	if (Size < GetListSize__1qy8(this)) {
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
static struct ZMacroNode385 * ZMacroNode__4q0x(struct ZMacroNode385 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZMacroFunc176 * MacroFunc__3) {
	ThrowError("not function: ZListNode");
	this->MacroFunc = MacroFunc;
	LibZen_Assert(MacroFunc != NULL, "(sample/libzen.zen:3885)");
	return NULL;
}
static struct ZFuncType67 * GetFuncType__1q0x(struct ZMacroNode385 * this) {
	return GetFuncType__1qwm(this->MacroFunc);
}
static const char * GetMacroText__1q0x(struct ZMacroNode385 * this) {
	struct ZMacroFunc176 * Func = this->MacroFunc;
	if (LibZen_Is(Func, 229)) {
		return ((struct ZSourceMacro229 *)Func)->Macro;
	};
	return "";
}
static void Accept__2q0x(struct ZMacroNode385 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZMapEntryNode390 * ZMapEntryNode__2q0m(struct ZMapEntryNode390 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZNode");
	return NULL;
}
static struct ZMapLiteralNode392 * ZMapLiteralNode__2q05(struct ZMapLiteralNode392 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZListNode");
	return NULL;
}
static struct ZMapEntryNode390 * GetMapEntryNode__2q05(struct ZMapLiteralNode392 * this, long Index__1) {
	struct ZNode49 * Node = GetListAt__2qy8(this, Index);
	if (LibZen_Is(Node, 390)) {
		return (struct ZMapEntryNode390 *)Node;
	};
	return NULL;
}
static void Accept__2q05(struct ZMapLiteralNode392 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZMethodCallNode396 * ZMethodCallNode__3q4q(struct ZMethodCallNode396 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * RecvNode__2) {
	ThrowError("not function: ZListNode");
	Set__3qws(this, ZMethodCallNode_Recv_Z75, RecvNode);
	return NULL;
}
static void SetNameInfo__3q4q(struct ZMethodCallNode396 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->MethodName = Name;
	this->MethodToken = NameToken;
	return;
}
static void Accept__2q4q(struct ZMethodCallNode396 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFuncCallNode400 * ToGetterFuncCall__1q4q(struct ZMethodCallNode396 * this) {
	struct ZGetterNode348 * Getter = ZGetterNode__3qpz(_NewZGetterNode348(), NULL, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
	Getter->SetNameInfo(Getter, this->MethodToken, this->MethodName);
	struct ZFuncCallNode400 * FuncNode = ZFuncCallNode__3q4t(_NewZFuncCallNode400(), this->ParentNode, Getter);
	FuncNode->SourceToken = this->SourceToken;
	Append__2qy8(FuncNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
	long i = 0;
	while (i < GetListSize__1qy8(this)) {
		Append__2qy8(FuncNode, GetListAt__2qy8(this, i));
		i = i + 1;
	};
	return FuncNode;
}
static struct ZListNode215 * ToFuncCallNode__2q4q(struct ZMethodCallNode396 * this, struct ZFunc66 * Func__1) {
	if (LibZen_Is(Func, 176)) {
		struct ZMacroNode385 * MacroNode = ZMacroNode__4q0x(_NewZMacroNode385(), this->ParentNode, this->MethodToken, (struct ZMacroFunc176 *)Func);
		Append__2qy8(MacroNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
		long i = 0;
		while (i < GetListSize__1qy8(this)) {
			Append__2qy8(MacroNode, GetListAt__2qy8(this, i));
			i = i + 1;
		};
		return MacroNode;
	} else {
		struct ZFuncCallNode400 * FuncNode = ZFuncCallNode__4q4t(_NewZFuncCallNode400(), this->ParentNode, Func->FuncName, GetFuncType__1qwm(Func));
		FuncNode->SourceToken = this->MethodToken;
		Append__2qy8(FuncNode, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
		long i = 0;
		while (i < GetListSize__1qy8(this)) {
			Append__2qy8(FuncNode, GetListAt__2qy8(this, i));
			i = i + 1;
		};
		return FuncNode;
	};
}
static struct ZNewArrayNode403 * ZNewArrayNode__4q4i(struct ZNewArrayNode403 * this, struct ZNode49 * ParentNode__1, struct ZType59 * Type__2, struct ZToken64 * Token__3) {
	ThrowError("not function: ZListNode");
	return NULL;
}
static struct ZNewObjectNode405 * ZNewObjectNode__2q4p(struct ZNewObjectNode405 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZListNode");
	return NULL;
}
static void Accept__2q4p(struct ZNewObjectNode405 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZListNode215 * ToFuncCallNode__2q4p(struct ZNewObjectNode405 * this, struct ZFunc66 * Func__1) {
	struct ZListNode215 * FuncNode = NULL;
	if (LibZen_Is(Func, 176)) {
		FuncNode = ZMacroNode__4q0x(_NewZMacroNode385(), this->ParentNode, this->SourceToken, (struct ZMacroFunc176 *)Func);
	} else {
		FuncNode = ZFuncCallNode__4q4t(_NewZFuncCallNode400(), this->ParentNode, Func->FuncName, GetFuncType__1qwm(Func));
		FuncNode->SourceToken = this->SourceToken;
	};
	Append__2qy8(FuncNode, this);
	long i = 0;
	while (i < GetListSize__1qy8(this)) {
		Append__2qy8(FuncNode, GetListAt__2qy8(this, i));
		i = i + 1;
	};
	ClearListAfter__2qy8(this, 0);
	return FuncNode;
}
static struct ZNotNode409 * ZNotNode__3q4s(struct ZNotNode409 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2) {
	ThrowError("not function: ZUnaryNode");
	return NULL;
}
static void Accept__2q4s(struct ZNotNode409 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNullNode412 * ZNullNode__3q4g(struct ZNullNode412 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2) {
	ThrowError("not function: ZConstNode");
	return NULL;
}
static void Accept__2q4g(struct ZNullNode412 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZOrNode415 * ZOrNode__5q4k(struct ZOrNode415 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4) {
	ThrowError("not function: ZBinaryNode");
	return NULL;
}
static void Accept__2q4k(struct ZOrNode415 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZPrototypeNode418 * ZPrototypeNode__2q41(struct ZPrototypeNode418 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZListNode");
	return NULL;
}
static void SetTypeInfo__3q41(struct ZPrototypeNode418 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->ReturnType = Type;
	return;
}
static void SetNameInfo__3q41(struct ZPrototypeNode418 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->FuncName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZParamNode137 * GetParamNode__2q41(struct ZPrototypeNode418 * this, long Index__1) {
	struct ZNode49 * Node = GetListAt__2qy8(this, Index);
	if (LibZen_Is(Node, 137)) {
		return (struct ZParamNode137 *)Node;
	};
	return NULL;
}
static struct ZFuncType67 * GetFuncType__1q41(struct ZPrototypeNode418 * this) {
	ArrayOfZType * TypeList = LibZen_NewArray(0);
	/*untyped*/NULL;
	long i = 0;
	while (i < GetListSize__1qy8(this)) {
		struct ZParamNode137 * Node = GetParamNode__2q41(this, i);
		struct ZType59 * ParamType = Node->Type->GetRealType(Node->Type);
		/*untyped*/NULL;
		i = i + 1;
	};
	return ZTypePool_LookupFuncType__1qwz(TypeList);
}
static struct ZStringNode424 * ZStringNode__4q4b(struct ZStringNode424 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, const char * Value__3) {
	ThrowError("not function: ZConstNode");
	this->Type = ZTypeStringType_Z11;
	this->StringValue = Value;
	return NULL;
}
static void Accept__2q4b(struct ZStringNode424 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZStupidCastErrorNode427 * ZStupidCastErrorNode__3q47(struct ZStupidCastErrorNode427 * this, struct ZNode49 * Node__1, const char * ErrorMessage__2) {
	ThrowError("not function: ZErrorNode");
	this->ErrorNode = Node;
	return NULL;
}
static struct ZTypeNode199 * ZTypeNode__4qyk(struct ZTypeNode199 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * SourceToken__2, struct ZType59 * ParsedType__3) {
	ThrowError("not function: ZConstNode");
	this->Type = ParsedType;
	return NULL;
}
static struct ZGenerator52 * ZGenerator__3qwg(struct ZGenerator52 * this, const char * LanguageExtension__1, const char * TargetVersion__2) {
	ThrowError("not function: ZVisitor");
	this->RootNameSpace = ZNameSpace__3qwi(_NewZNameSpace43(), this, NULL);
	this->GrammarInfo = "";
	this->LanguageExtention = LanguageExtension;
	this->TargetVersion = TargetVersion;
	this->OutputFile = NULL;
	this->Logger = _NewZLogger99();
	this->StoppedVisitor = 0/*false*/;
	return NULL;
}
static void ImportLocalGrammar__2qwg(struct ZGenerator52 * this, struct ZNameSpace43 * NameSpace__1) {
	return;
}
static void WriteTo__2qwg(struct ZGenerator52 * this, const char * FileName__1) {
	return;
}
static const char * NameOutputFile__2qwg(struct ZGenerator52 * this, const char * FileName__1) {
	if (FileName != NULL) {
		return LibZen_StrCat(LibZen_StrCat(FileName, "."), this->LanguageExtention);
	};
	return FileName;
}
static void EnableVisitor__1qwg(struct ZGenerator52 * this) {
	this->StoppedVisitor = 0/*false*/;
	return;
}
static void StopVisitor__1qwg(struct ZGenerator52 * this) {
	this->StoppedVisitor = 1/*true*/;
	return;
}
static int IsVisitable__1qwg(struct ZGenerator52 * this) {
	return !this->StoppedVisitor;
}
static const char * GetGrammarInfo__1qwg(struct ZGenerator52 * this) {
	return /*untyped*/NULL;
}
static void AppendGrammarInfo__2qwg(struct ZGenerator52 * this, const char * GrammarInfo__1) {
	this->GrammarInfo = LibZen_StrCat(LibZen_StrCat(this->GrammarInfo, GrammarInfo), " ");
	return;
}
static const char * GetTargetLangInfo__1qwg(struct ZGenerator52 * this) {
	return LibZen_StrCat(this->LanguageExtention, this->TargetVersion);
}
static struct ZType59 * GetFieldType__3qwg(struct ZGenerator52 * this, struct ZType59 * BaseType__1, const char * Name__2) {
	return ZTypeVarType_Z6;
}
static struct ZType59 * GetSetterType__3qwg(struct ZGenerator52 * this, struct ZType59 * BaseType__1, const char * Name__2) {
	return ZTypeVarType_Z6;
}
static struct ZFuncType67 * GetConstructorFuncType__3qwg(struct ZGenerator52 * this, struct ZType59 * ClassType__1, struct ZListNode215 * List__2) {
	return ZTypeFuncType_Z15;
}
static struct ZFuncType67 * GetMethodFuncType__4qwg(struct ZGenerator52 * this, struct ZType59 * RecvType__1, const char * MethodName__2, struct ZListNode215 * List__3) {
	return ZTypeFuncType_Z15;
}
static long GetUniqueNumber__1qwg(struct ZGenerator52 * this) {
	long UniqueNumber = this->UniqueNumber;
	this->UniqueNumber = this->UniqueNumber + 1;
	return UniqueNumber;
}
static const char * NameGlobalSymbol__2qwg(struct ZGenerator52 * this, const char * Symbol__1) {
	return LibZen_StrCat(LibZen_StrCat(Symbol, "_Z"), LibZen_IntToString(GetUniqueNumber__1qwg(this)));
}
static const char * NameClass__2qwg(struct ZGenerator52 * this, struct ZType59 * ClassType__1) {
	return LibZen_StrCat(LibZen_StrCat(ClassType->ShortName, ""), LibZen_IntToString(ClassType->TypeId));
}
static void SetDefinedFunc__2qwg(struct ZGenerator52 * this, struct ZFunc66 * Func__1) {
	Map<ZFunc>SetIndex(GetSignature__1qwm(Func), Func);
	return;
}
static struct ZPrototype74 * SetPrototype__4qwg(struct ZGenerator52 * this, struct ZNode49 * Node__1, const char * FuncName__2, struct ZFuncType67 * FuncType__3) {
	struct ZFunc66 * Func = GetDefinedFunc__3qwg(this, FuncName, FuncType);
	if (Func != NULL) {
		if (!Equals__2qw6(FuncType, GetFuncType__1qwm(Func))) {
			(void)ZLogger_LogError__2qwb(Node->SourceToken, LibZen_StrCat("function has been defined diffrently: ", ThrowError("type error: requested = String, given = ZFuncType")));
			return NULL;
		};
		if (LibZen_Is(Func, 74)) {
			return (struct ZPrototype74 *)Func;
		};
		(void)ZLogger_LogError__2qwb(Node->SourceToken, LibZen_StrCat("function has been defined as macro", ThrowError("type error: requested = String, given = ZFunc")));
		return NULL;
	};
	struct ZPrototype74 * Proto = ZPrototype__5qee(_NewZPrototype74(), 0, FuncName, FuncType, Node->SourceToken);
	Map<ZFunc>SetIndex(GetSignature__1qwm(Proto), Proto);
	return Proto;
}
static struct ZFunc66 * GetDefinedFunc__2qwg(struct ZGenerator52 * this, const char * GlobalName__1) {
	struct ZFunc66 * Func = Map<ZFunc>GetIndex(GlobalName);
	if (Func == NULL && LibZen_IsLetter__1qqy(LibZen_GetChar__2qqy(GlobalName, 0))) {
		Func = Map<ZFunc>GetIndex(LibZen_AnotherName__1qqy(GlobalName));
	};
	return Func;
}
static struct ZFunc66 * GetDefinedFunc__3qwg(struct ZGenerator52 * this, const char * FuncName__1, struct ZFuncType67 * FuncType__2) {
	return GetDefinedFunc__2qwg(this, StringfySignature__2qw7(FuncType, FuncName));
}
static struct ZFunc66 * GetDefinedFunc__4qwg(struct ZGenerator52 * this, const char * FuncName__1, struct ZType59 * RecvType__2, long FuncParamSize__3) {
	return GetDefinedFunc__2qwg(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
}
static struct ZMacroFunc176 * GetMacroFunc__4qwg(struct ZGenerator52 * this, const char * FuncName__1, struct ZType59 * RecvType__2, long FuncParamSize__3) {
	struct ZFunc66 * Func = GetDefinedFunc__2qwg(this, ZFunc_StringfySignature__3qqy(FuncName, FuncParamSize, RecvType));
	if (LibZen_Is(Func, 176)) {
		return ((struct ZMacroFunc176 *)Func);
	};
	return NULL;
}
static const char * NameConverterFunc__3qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2) {
	return LibZen_StrCat(LibZen_StrCat(GetUniqueName__1qw6(FromType), "T"), GetUniqueName__1qw6(ToType));
}
static void SetConverterFunc__4qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2, struct ZFunc66 * Func__3) {
	Map<ZFunc>SetIndex(NameConverterFunc__3qwg(this, FromType, ToType), Func);
	return;
}
static struct ZFunc66 * GetConverterFunc__3qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2) {
	while (FromType != NULL) {
		struct ZFunc66 * Func = Map<ZFunc>GetIndex(NameConverterFunc__3qwg(this, FromType, ToType));
		if (Func != NULL) {
			return Func;
		};
		FromType = /*untyped*/NULL(FromType);
	};
	return NULL;
}
static struct ZFunc66 * GetCoercionFunc__3qwg(struct ZGenerator52 * this, struct ZType59 * FromType__1, struct ZType59 * ToType__2) {
	while (FromType != NULL) {
		struct ZFunc66 * Func = Map<ZFunc>GetIndex(NameConverterFunc__3qwg(this, FromType, ToType));
		if (Func != NULL && IsCoercionFunc__1qwm(Func)) {
			return Func;
		};
		FromType = /*untyped*/NULL(FromType);
	};
	return NULL;
}
static void VisitExtendedNode__2qwg(struct ZGenerator52 * this, struct ZNode49 * Node__1) {
	struct ZSugarNode130 * DeNode = /*untyped*/NULL(Node, this);
	/*untyped*/NULL(DeNode, this);
	return;
}
static void VisitSugarNode__2qwg(struct ZGenerator52 * this, struct ZSugarNode130 * Node__1) {
	/*untyped*/NULL(Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z31), this);
	return;
}
static struct ZIndentToken453 * ZIndentToken__4qa9(struct ZIndentToken453 * this, struct ZSource202 * Source__1, long StartIndex__2, long EndIndex__3) {
	ThrowError("not function: ZToken");
	return NULL;
}
static struct ZPatternToken455 * ZPatternToken__5qa6(struct ZPatternToken455 * this, struct ZSource202 * Source__1, long StartIndex__2, long EndIndex__3, struct ZSyntax184 * PresetPattern__4) {
	ThrowError("not function: ZToken");
	this->PresetPattern = PresetPattern;
	return NULL;
}
static struct ZSourceEngine54 * ZSourceEngine__3qwj(struct ZSourceEngine54 * this, struct ZTypeChecker106 * TypeChecker__1, struct ZGenerator52 * Generator__2) {
	this->TypeChecker = TypeChecker;
	this->Generator = Generator;
	this->Logger = Generator->Logger;
	return NULL;
}
static int IsVisitable__1qwj(struct ZSourceEngine54 * this) {
	return ThrowError("type error: requested = boolean, given = Func<boolean,ZVisitor>");
}
static void EnableVisitor__1qwj(struct ZSourceEngine54 * this) {
	this->IsVisitable = ThrowError("type error: requested = Func<boolean,ZVisitor>, given = boolean");
	return;
}
static void StopVisitor__1qwj(struct ZSourceEngine54 * this) {
	this->IsVisitable = ThrowError("type error: requested = Func<boolean,ZVisitor>, given = boolean");
	return;
}
static struct Object296 * Eval__2qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1) {
	if (/*untyped*/NULL(this)) {
		/*untyped*/NULL(Node, this);
	};
	return ThrowError("type error: requested = Object, given = ZEmptyValue");
}
static void VisitPrototypeNode__2qwj(struct ZSourceEngine54 * this, struct ZPrototypeNode418 * Node__1) {
	struct ZFuncType67 * FuncType = GetFuncType__1q41(Node);
	(void)SetPrototype__4qwg(this->Generator, Node, Node->FuncName, FuncType);
	return;
}
static void VisitImportNode__2qwj(struct ZSourceEngine54 * this, struct ZImportNode363 * Node__1) {
	(void)/*untyped*/NULL(Node);
	return;
}
static struct Object296 * Exec__3qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1, int IsInteractive__2) {
	this->InteractiveContext = IsInteractive;
	/*untyped*/NULL(this);
	if (LibZen_Is(Node, 418)) {
		VisitPrototypeNode__2qwj(this, (struct ZPrototypeNode418 *)Node);
		return ThrowError("type error: requested = Object, given = ZEmptyValue");
	} else if (LibZen_Is(Node, 363)) {
		VisitImportNode__2qwj(this, (struct ZImportNode363 *)Node);
		return ThrowError("type error: requested = Object, given = ZEmptyValue");
	} else {
		Node = CheckType__3qe2(this->TypeChecker, Node, ZTypeVoidType_Z7);
		struct Object296 * ResultValue = Eval__2qwj(this, Node);
		return ResultValue;
	};
}
static struct Object296 * Eval__6qwj(struct ZSourceEngine54 * this, struct ZNameSpace43 * NameSpace__1, const char * ScriptText__2, const char * FileName__3, long LineNumber__4, int IsInteractive__5) {
	struct Object296 * ResultValue = ThrowError("type error: requested = Object, given = ZEmptyValue");
	struct ZBlockNode126 * TopBlockNode = ZBlockNode__2qrj(_NewZBlockNode126(), NameSpace);
	struct ZTokenContext50 * TokenContext = ZTokenContext__6qwd(_NewZTokenContext50(), this->Generator, NameSpace, FileName, LineNumber, ScriptText);
	SkipEmptyStatement__1qwd(TokenContext);
	struct ZToken64 * SkipToken = GetToken__1qwd(TokenContext);
	while (HasNext__1qwd(TokenContext)) {
		(void)SetParseFlag__2qwd(TokenContext, ZTokenContext_NotAllowSkipIndent_Z55);
		ClearListAfter__2qy8(TopBlockNode, 0);
		SkipToken = GetToken__1qwd(TokenContext);
		struct ZNode49 * ParsedNode = ParsePattern__4qwd(TokenContext, TopBlockNode, "$Statement$", ZTokenContext_Required_Z52);
		if (IsErrorNode__1qws(ParsedNode)) {
			SkipError__2qwd(TokenContext, SkipToken);
		};
		ResultValue = Exec__3qwj(this, ParsedNode, IsInteractive);
		if (ResultValue == ThrowError("type error: requested = Object, given = ZEmptyValue")) {
			break;
		};
		SkipEmptyStatement__1qwd(TokenContext);
		Vacume__1qwd(TokenContext);
	};
	if (HasNext__1qwd(TokenContext) && !IsInteractive) {
		ZLogger_LogInfo__2qwb(SkipToken, "stopped script at this line");
	};
	return ResultValue;
}
static struct Object296 * Eval__5qwj(struct ZSourceEngine54 * this, const char * ScriptText__1, const char * FileName__2, long LineNumber__3, int IsInteractive__4) {
	return Eval__6qwj(this, this->Generator->RootNameSpace, ScriptText, FileName, LineNumber, IsInteractive);
}
static int Load__2qwj(struct ZSourceEngine54 * this, const char * FileName__1) {
	const char * ScriptText = /*untyped*/NULL;
	if (ScriptText == NULL) {
		LibZen_Exit__2qqr(1, LibZen_StrCat("file not found: ", FileName));
		return 0/*false*/;
	};
	struct Object296 * ResultValue = Eval__5qwj(this, ScriptText, FileName, 1, 0/*false*/);
	ShowErrors__1qev(this->Logger);
	if (ResultValue == ThrowError("type error: requested = Object, given = ZEmptyValue")) {
		return 0/*false*/;
	};
	return 1/*true*/;
}
static void Unsupported__2qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1) {
	if (this->InteractiveContext) {
		(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	} else {
		(void)ZLogger_LogError__2qwb(Node->SourceToken, "unsupported at top level");
		this->StopVisitor(this);
	};
	return;
}
static void VisitNullNode__2qwj(struct ZSourceEngine54 * this, struct ZNullNode412 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitBooleanNode__2qwj(struct ZSourceEngine54 * this, struct ZBooleanNode469 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitIntNode__2qwj(struct ZSourceEngine54 * this, struct ZIntNode370 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitFloatNode__2qwj(struct ZSourceEngine54 * this, struct ZFloatNode337 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitStringNode__2qwj(struct ZSourceEngine54 * this, struct ZStringNode424 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitArrayLiteralNode__2qwj(struct ZSourceEngine54 * this, struct ZArrayLiteralNode474 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitMapLiteralNode__2qwj(struct ZSourceEngine54 * this, struct ZMapLiteralNode392 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitNewObjectNode__2qwj(struct ZSourceEngine54 * this, struct ZNewObjectNode405 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitGlobalNameNode__2qwj(struct ZSourceEngine54 * this, struct ZGlobalNameNode353 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitGetNameNode__2qwj(struct ZSourceEngine54 * this, struct ZGetNameNode343 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitSetNameNode__2qwj(struct ZSourceEngine54 * this, struct ZSetNameNode146 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitGroupNode__2qwj(struct ZSourceEngine54 * this, struct ZGroupNode357 * Node__1) {
	(void)Eval__2qwj(this, Array<ZNode>GetIndex(ZGroupNode_Expr_Z67));
	return;
}
static void VisitGetterNode__2qwj(struct ZSourceEngine54 * this, struct ZGetterNode348 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitSetterNode__2qwj(struct ZSourceEngine54 * this, struct ZSetterNode149 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitGetIndexNode__2qwj(struct ZSourceEngine54 * this, struct ZGetIndexNode340 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitSetIndexNode__2qwj(struct ZSourceEngine54 * this, struct ZSetIndexNode143 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitMacroNode__2qwj(struct ZSourceEngine54 * this, struct ZMacroNode385 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitFuncCallNode__2qwj(struct ZSourceEngine54 * this, struct ZFuncCallNode400 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitMethodCallNode__2qwj(struct ZSourceEngine54 * this, struct ZMethodCallNode396 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitUnaryNode__2qwj(struct ZSourceEngine54 * this, struct ZUnaryNode162 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitNotNode__2qwj(struct ZSourceEngine54 * this, struct ZNotNode409 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitCastNode__2qwj(struct ZSourceEngine54 * this, struct ZCastNode314 * Node__1) {
	if (IsVoidType__1qw6(Node->Type)) {
		(void)Eval__2qwj(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
		Node->Type = Array<ZNode>GetIndex(ZCastNode_Expr_Z61)->Type;
	} else {
		Unsupported__2qwj(this, Node);
	};
	return;
}
static void VisitInstanceOfNode__2qwj(struct ZSourceEngine54 * this, struct ZInstanceOfNode366 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitBinaryNode__2qwj(struct ZSourceEngine54 * this, struct ZBinaryNode304 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitComparatorNode__2qwj(struct ZSourceEngine54 * this, struct ZComparatorNode322 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitAndNode__2qwj(struct ZSourceEngine54 * this, struct ZAndNode495 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitOrNode__2qwj(struct ZSourceEngine54 * this, struct ZOrNode415 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitBlockNode__2qwj(struct ZSourceEngine54 * this, struct ZBlockNode126 * Node__1) {
	long i = 1;
	while (i < GetListSize__1qy8(Node) && /*untyped*/NULL(this)) {
		struct ZNode49 * StmtNode = GetListAt__2qy8(Node, i);
		(void)Eval__2qwj(this, StmtNode);
		if (/*untyped*/NULL(StmtNode)) {
			break;
		};
	};
	return;
}
static void VisitVarNode__2qwj(struct ZSourceEngine54 * this, struct ZVarNode499 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitIfNode__2qwj(struct ZSourceEngine54 * this, struct ZIfNode360 * Node__1) {
	struct Object296 * BooleanValue = Eval__2qwj(this, Array<ZNode>GetIndex(ZIfNode_Cond_Z68));
	if (LibZen_Is(BooleanValue, 704)) {
		if (ThrowError("type error: requested = boolean, given = Boolean")) {
			(void)Eval__2qwj(this, Array<ZNode>GetIndex(ZIfNode_Then_Z69));
		} else if (Array<ZNode>GetIndex(ZIfNode_Else_Z70) != NULL) {
			(void)Eval__2qwj(this, Array<ZNode>GetIndex(ZIfNode_Then_Z69));
		};
	};
	return;
}
static void VisitReturnNode__2qwj(struct ZSourceEngine54 * this, struct ZReturnNode135 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitWhileNode__2qwj(struct ZSourceEngine54 * this, struct ZWhileNode165 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitBreakNode__2qwj(struct ZSourceEngine54 * this, struct ZBreakNode311 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitThrowNode__2qwj(struct ZSourceEngine54 * this, struct ZThrowNode156 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitTryNode__2qwj(struct ZSourceEngine54 * this, struct ZTryNode159 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitLetNode__2qwj(struct ZSourceEngine54 * this, struct ZLetNode373 * Node__1) {
	if (HasUntypedNode__1qws(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", ThrowError("type error: requested = String, given = boolean")), "\n"), ThrowError("type error: requested = String, given = ZLetNode")));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitFunctionNode__2qwj(struct ZSourceEngine54 * this, struct ZFunctionNode109 * Node__1) {
	if (HasUntypedNode__1qws(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", ThrowError("type error: requested = String, given = boolean")), "\nLAZY: "), ThrowError("type error: requested = String, given = ZFunctionNode")));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitClassNode__2qwj(struct ZSourceEngine54 * this, struct ZClassNode509 * Node__1) {
	if (HasUntypedNode__1qws(Node)) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("HasUntypedNode: ", ThrowError("type error: requested = String, given = boolean")), "\n"), ThrowError("type error: requested = String, given = ZClassNode")));
	};
	(void)this->Generator->StartCodeGeneration(this->Generator, Node, this->InteractiveContext);
	return;
}
static void VisitErrorNode__2qwj(struct ZSourceEngine54 * this, struct ZErrorNode329 * Node__1) {
	(void)ZLogger_LogError__2qwb(Node->SourceToken, Node->ErrorMessage);
	this->StopVisitor(this);
	return;
}
static void VisitTypeNode__2qwj(struct ZSourceEngine54 * this, struct ZTypeNode199 * Node__1) {
	Unsupported__2qwj(this, Node);
	return;
}
static void VisitExtendedNode__2qwj(struct ZSourceEngine54 * this, struct ZNode49 * Node__1) {
	if (LibZen_Is(Node, 199)) {
		VisitTypeNode__2qwj(this, (struct ZTypeNode199 *)Node);
	} else {
		struct ZNode49 * SugarNode = /*untyped*/NULL(Node, this->Generator);
		/*untyped*/NULL(SugarNode, this);
	};
	return;
}
static void VisitSugarNode__2qwj(struct ZSourceEngine54 * this, struct ZSugarNode130 * Node__1) {
	(void)Eval__2qwj(this, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z31));
	return;
}
static void WriteTo__2qwj(struct ZSourceEngine54 * this, const char * OutputFile__1) {
	/*untyped*/NULL(this->Generator, OutputFile);
	ShowErrors__1qev(this->Generator->Logger);
	return;
}
static struct ZSourceGenerator207 * ZSourceGenerator__3qyv(struct ZSourceGenerator207 * this, const char * TargetCode__1, const char * TargetVersion__2) {
	ThrowError("not function: ZGenerator");
	this->InitBuilderList(this);
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
static void InitBuilderList__1qyv(struct ZSourceGenerator207 * this) {
	this->CurrentBuilder = NULL;
	/*untyped*/NULL;
	this->HeaderBuilder = AppendNewSourceBuilder__1qyv(this);
	this->CurrentBuilder = AppendNewSourceBuilder__1qyv(this);
	return;
}
static struct ZSourceEngine54 * GetEngine__1qyv(struct ZSourceGenerator207 * this) {
	/*untyped*/NULL;
	return ZSourceEngine__3qwj(_NewZSourceEngine54(), ZTypeChecker__2qe2(_NewZTypeChecker106(), this), this);
}
static struct ZSourceBuilder37 * AppendNewSourceBuilder__1qyv(struct ZSourceGenerator207 * this) {
	struct ZSourceBuilder37 * Builder = ZSourceBuilder__3qww(_NewZSourceBuilder37(), this, this->CurrentBuilder);
	/*untyped*/NULL;
	return Builder;
}
static struct ZSourceBuilder37 * InsertNewSourceBuilder__1qyv(struct ZSourceGenerator207 * this) {
	struct ZSourceBuilder37 * Builder = ZSourceBuilder__3qww(_NewZSourceBuilder37(), this, this->CurrentBuilder);
	long i = 0;
	while (i < /*untyped*/NULL) {
		if (Array<ZSourceBuilder>GetIndex(i) == this->CurrentBuilder) {
			/*untyped*/NULL;
			return Builder;
		};
		i = i + 1;
	};
	/*untyped*/NULL;
	return Builder;
}
static void SetNativeType__3qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1, const char * TypeName__2) {
	const char * Key = LibZen_StrCat("", LibZen_IntToString(Type->TypeId));
	Map<String>SetIndex(Key, TypeName);
	return;
}
static const char * GetNativeType__2qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1) {
	const char * Key = LibZen_StrCat("", LibZen_IntToString(Type->TypeId));
	const char * TypeName = Map<String>GetIndex(Key);
	if (TypeName == NULL) {
		return Type->ShortName;
	};
	return TypeName;
}
static void SetReservedName__3qyv(struct ZSourceGenerator207 * this, const char * Keyword__1, const char * AnotherName__2) {
	if (AnotherName == NULL) {
		AnotherName = LibZen_StrCat("_", Keyword);
	};
	Map<String>SetIndex(Keyword, AnotherName);
	return;
}
static const char * SafeName__3qyv(struct ZSourceGenerator207 * this, const char * Name__1, long Index__2) {
	if (Index == 0) {
		const char * SafeName = Map<String>GetIndex(Name);
		if (SafeName == NULL) {
			SafeName = Name;
		};
		return SafeName;
	};
	return LibZen_StrCat(LibZen_StrCat(Name, "__"), LibZen_IntToString(Index));
}
static void SetMacro__4qyv(struct ZSourceGenerator207 * this, const char * FuncName__1, const char * Macro__2, struct ZType59 * ReturnType__3) {
	struct ZFuncType67 * FuncType = ZTypePool_LookupFuncType__1qw6(ReturnType);
	SetDefinedFunc__2qwg(this, ZSourceMacro__4qus(_NewZSourceMacro229(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__5qyv(struct ZSourceGenerator207 * this, const char * FuncName__1, const char * Macro__2, struct ZType59 * ReturnType__3, struct ZType59 * P1__4) {
	struct ZFuncType67 * FuncType = ZTypePool_LookupFuncType__2qw6(ReturnType, P1);
	SetDefinedFunc__2qwg(this, ZSourceMacro__4qus(_NewZSourceMacro229(), FuncName, FuncType, Macro));
	return;
}
static void SetMacro__6qyv(struct ZSourceGenerator207 * this, const char * FuncName__1, const char * Macro__2, struct ZType59 * ReturnType__3, struct ZType59 * P1__4, struct ZType59 * P2__5) {
	struct ZFuncType67 * FuncType = ZTypePool_LookupFuncType__3qw6(ReturnType, P1, P2);
	SetDefinedFunc__2qwg(this, ZSourceMacro__4qus(_NewZSourceMacro229(), FuncName, FuncType, Macro));
	return;
}
static void SetConverterMacro__4qyv(struct ZSourceGenerator207 * this, const char * Macro__1, struct ZType59 * ReturnType__2, struct ZType59 * P1__3) {
	struct ZFuncType67 * FuncType = ZTypePool_LookupFuncType__2qw6(ReturnType, P1);
	SetConverterFunc__4qwg(this, P1, ReturnType, ZSourceMacro__4qus(_NewZSourceMacro229(), LibZen_StrCat("to", NameClass__2qwg(this, ReturnType)), FuncType, Macro));
	return;
}
static void WriteTo__2qyv(struct ZSourceGenerator207 * this, const char * FileName__1) {
	LibZen_WriteTo__2qqy(this->NameOutputFile(this, FileName), this->BuilderList);
	this->InitBuilderList(this);
	return;
}
static int StartCodeGeneration__3qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1, int IsInteractive__2) {
	Node->Accept(Node, this);
	if (IsInteractive) {
		long i = 0;
		/*untyped*/NULL;
		while (i < /*untyped*/NULL) {
			struct ZSourceBuilder37 * Builder = Array<ZSourceBuilder>GetIndex(i);
			/*untyped*/NULL;
			Clear__1qww(Builder);
			i = i + 1;
		};
		this->InitBuilderList(this);
	};
	return 1/*true*/;
}
static void GenerateCode__3qyv(struct ZSourceGenerator207 * this, struct ZType59 * ContextType__1, struct ZNode49 * Node__2) {
	/*untyped*/NULL(Node, this);
	return;
}
static int IsNeededSurroud__2qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1) {
	if (LibZen_Is(Node, 304)) {
		return 1/*true*/;
	};
	return 0/*false*/;
}
static void GenerateSurroundCode__2qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1) {
	if (IsNeededSurroud__2qyv(this, Node)) {
		Append__2qww(this->CurrentBuilder, "(");
		/*untyped*/NULL(this, NULL, Node);
		Append__2qww(this->CurrentBuilder, ")");
	} else {
		/*untyped*/NULL(this, NULL, Node);
	};
	return;
}
static void AppendCode__2qyv(struct ZSourceGenerator207 * this, const char * RawSource__1) {
	Append__2qww(this->CurrentBuilder, RawSource);
	return;
}
static void VisitStmtList__2qyv(struct ZSourceGenerator207 * this, struct ZBlockNode126 * BlockNode__1) {
	long i = 0;
	while (i < GetListSize__1qy8(BlockNode)) {
		struct ZNode49 * SubNode = GetListAt__2qy8(BlockNode, i);
		AppendLineFeed__1qww(this->CurrentBuilder);
		AppendIndent__1qww(this->CurrentBuilder);
		/*untyped*/NULL(this, NULL, SubNode);
		i = i + 1;
		if (i < GetListSize__1qy8(BlockNode)) {
			Append__2qww(this->CurrentBuilder, this->SemiColon);
		};
	};
	return;
}
static void VisitBlockNode__2qyv(struct ZSourceGenerator207 * this, struct ZBlockNode126 * Node__1) {
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	Append__2qww(this->CurrentBuilder, "{");
	Indent__1qww(this->CurrentBuilder);
	VisitStmtList__2qyv(this, Node);
	if (GetListSize__1qy8(Node) > 0) {
		Append__2qww(this->CurrentBuilder, this->SemiColon);
	};
	UnIndent__1qww(this->CurrentBuilder);
	AppendLineFeed__1qww(this->CurrentBuilder);
	AppendIndent__1qww(this->CurrentBuilder);
	Append__2qww(this->CurrentBuilder, "}");
	return;
}
static void VisitNullNode__2qyv(struct ZSourceGenerator207 * this, struct ZNullNode412 * Node__1) {
	Append__2qww(this->CurrentBuilder, this->NullLiteral);
	return;
}
static void VisitBooleanNode__2qyv(struct ZSourceGenerator207 * this, struct ZBooleanNode469 * Node__1) {
	if (Node->BooleanValue) {
		Append__2qww(this->CurrentBuilder, this->TrueLiteral);
	} else {
		Append__2qww(this->CurrentBuilder, this->FalseLiteral);
	};
	return;
}
static void VisitIntNode__2qyv(struct ZSourceGenerator207 * this, struct ZIntNode370 * Node__1) {
	Append__2qww(this->CurrentBuilder, /*untyped*/NULL);
	return;
}
static void VisitFloatNode__2qyv(struct ZSourceGenerator207 * this, struct ZFloatNode337 * Node__1) {
	Append__2qww(this->CurrentBuilder, /*untyped*/NULL);
	return;
}
static void VisitStringNode__2qyv(struct ZSourceGenerator207 * this, struct ZStringNode424 * Node__1) {
	Append__2qww(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->StringValue));
	return;
}
static void VisitArrayLiteralNode__2qyv(struct ZSourceGenerator207 * this, struct ZArrayLiteralNode474 * Node__1) {
	VisitListNode__4qyv(this, "[", Node, "]");
	return;
}
static void VisitMapLiteralNode__2qyv(struct ZSourceGenerator207 * this, struct ZMapLiteralNode392 * Node__1) {
	return;
}
static void VisitNewObjectNode__2qyv(struct ZSourceGenerator207 * this, struct ZNewObjectNode405 * Node__1) {
	Append__2qww(this->CurrentBuilder, "new");
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	GenerateTypeName__2qyv(this, Node->Type);
	VisitListNode__4qyv(this, "(", Node, ")");
	return;
}
static void VisitGroupNode__2qyv(struct ZSourceGenerator207 * this, struct ZGroupNode357 * Node__1) {
	Append__2qww(this->CurrentBuilder, "(");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGroupNode_Expr_Z67));
	Append__2qww(this->CurrentBuilder, ")");
	return;
}
static void VisitGetIndexNode__2qyv(struct ZSourceGenerator207 * this, struct ZGetIndexNode340 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Recv_Z64));
	Append__2qww(this->CurrentBuilder, "[");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZGetIndexNode_Index_Z65));
	Append__2qww(this->CurrentBuilder, "]");
	return;
}
static void VisitSetIndexNode__2qyv(struct ZSourceGenerator207 * this, struct ZSetIndexNode143 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Recv_Z25));
	Append__2qww(this->CurrentBuilder, "[");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Index_Z26));
	Append__2qww(this->CurrentBuilder, "]");
	AppendToken__2qww(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetIndexNode_Expr_Z27));
	return;
}
static void VisitGlobalNameNode__2qyv(struct ZSourceGenerator207 * this, struct ZGlobalNameNode353 * Node__1) {
	if (IsUntyped__1qws(Node)) {
		(void)ZLogger_LogError__2qwb(Node->SourceToken, LibZen_StrCat("undefined symbol: ", Node->GlobalName));
	};
	if (Node->IsStaticFuncName) {
		Append__2qww(this->CurrentBuilder, StringfySignature__2qw6(Node->Type, Node->GlobalName));
	} else {
		Append__2qww(this->CurrentBuilder, Node->GlobalName);
	};
	return;
}
static void VisitGetNameNode__2qyv(struct ZSourceGenerator207 * this, struct ZGetNameNode343 * Node__1) {
	Append__2qww(this->CurrentBuilder, SafeName__3qyv(this, Node->VarName, Node->VarIndex));
	return;
}
static void VisitSetNameNode__2qyv(struct ZSourceGenerator207 * this, struct ZSetNameNode146 * Node__1) {
	Append__2qww(this->CurrentBuilder, SafeName__3qyv(this, Node->VarName, Node->VarIndex));
	AppendToken__2qww(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetNameNode_Expr_Z28));
	return;
}
static void VisitGetterNode__2qyv(struct ZSourceGenerator207 * this, struct ZGetterNode348 * Node__1) {
	GenerateSurroundCode__2qyv(this, Array<ZNode>GetIndex(ZGetterNode_Recv_Z66));
	Append__2qww(this->CurrentBuilder, ".");
	Append__2qww(this->CurrentBuilder, Node->FieldName);
	return;
}
static void VisitSetterNode__2qyv(struct ZSourceGenerator207 * this, struct ZSetterNode149 * Node__1) {
	GenerateSurroundCode__2qyv(this, Array<ZNode>GetIndex(ZSetterNode_Recv_Z29));
	Append__2qww(this->CurrentBuilder, ".");
	Append__2qww(this->CurrentBuilder, Node->FieldName);
	AppendToken__2qww(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSetterNode_Expr_Z30));
	return;
}
static void VisitMethodCallNode__2qyv(struct ZSourceGenerator207 * this, struct ZMethodCallNode396 * Node__1) {
	GenerateSurroundCode__2qyv(this, Array<ZNode>GetIndex(ZMethodCallNode_Recv_Z75));
	Append__2qww(this->CurrentBuilder, ".");
	Append__2qww(this->CurrentBuilder, Node->MethodName);
	VisitListNode__4qyv(this, "(", Node, ")");
	return;
}
static void VisitMacroNode__2qyv(struct ZSourceGenerator207 * this, struct ZMacroNode385 * Node__1) {
	const char * Macro = GetMacroText__1q0x(Node);
	struct ZFuncType67 * FuncType = GetFuncType__1q0x(Node);
	long fromIndex = 0;
	long BeginNum = /*untyped*/NULL;
	while (BeginNum != -1) {
		long EndNum = /*untyped*/NULL;
		if (EndNum == -1) {
			break;
		};
		Append__2qww(this->CurrentBuilder, /*untyped*/NULL);
		long Index = (long)/*untyped*/NULL;
		if (HasAst__2qws(Node, Index)) {
			this->GenerateCode(this, GetFuncParamType__2qw7(FuncType, Index), Array<ZNode>GetIndex(Index));
		};
		fromIndex = EndNum + 1;
		BeginNum = /*untyped*/NULL;
	};
	Append__2qww(this->CurrentBuilder, /*untyped*/NULL);
	return;
}
static void VisitFuncCallNode__2qyv(struct ZSourceGenerator207 * this, struct ZFuncCallNode400 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78));
	VisitListNode__4qyv(this, "(", Node, ")");
	return;
}
static void VisitUnaryNode__2qyv(struct ZSourceGenerator207 * this, struct ZUnaryNode162 * Node__1) {
	Append__2qww(this->CurrentBuilder, GetText__1qwb(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z36));
	return;
}
static void VisitNotNode__2qyv(struct ZSourceGenerator207 * this, struct ZNotNode409 * Node__1) {
	Append__2qww(this->CurrentBuilder, this->NotOperator);
	GenerateSurroundCode__2qyv(this, Array<ZNode>GetIndex(ZUnaryNode_Recv_Z36));
	return;
}
static void VisitCastNode__2qyv(struct ZSourceGenerator207 * this, struct ZCastNode314 * Node__1) {
	Append__2qww(this->CurrentBuilder, "(");
	GenerateTypeName__2qyv(this, Node->Type);
	Append__2qww(this->CurrentBuilder, ")");
	GenerateSurroundCode__2qyv(this, Array<ZNode>GetIndex(ZCastNode_Expr_Z61));
	return;
}
static void VisitInstanceOfNode__2qyv(struct ZSourceGenerator207 * this, struct ZInstanceOfNode366 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qww(this->CurrentBuilder, "instanceof");
	GenerateTypeName__2qyv(this, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60)->Type);
	return;
}
static void VisitBinaryNode__2qyv(struct ZSourceGenerator207 * this, struct ZBinaryNode304 * Node__1) {
	if (LibZen_Is(Node->ParentNode, 304)) {
		Append__2qww(this->CurrentBuilder, "(");
	};
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qww(this->CurrentBuilder, GetText__1qwb(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	if (LibZen_Is(Node->ParentNode, 304)) {
		Append__2qww(this->CurrentBuilder, ")");
	};
	return;
}
static void VisitComparatorNode__2qyv(struct ZSourceGenerator207 * this, struct ZComparatorNode322 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qww(this->CurrentBuilder, GetText__1qwb(Node->SourceToken));
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	return;
}
static void VisitAndNode__2qyv(struct ZSourceGenerator207 * this, struct ZAndNode495 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qww(this->CurrentBuilder, this->AndOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	return;
}
static void VisitOrNode__2qyv(struct ZSourceGenerator207 * this, struct ZOrNode415 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Left_Z59));
	AppendToken__2qww(this->CurrentBuilder, this->OrOperator);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZBinaryNode_Right_Z60));
	return;
}
static void VisitIfNode__2qyv(struct ZSourceGenerator207 * this, struct ZIfNode360 * Node__1) {
	Append__2qww(this->CurrentBuilder, "if (");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Cond_Z68));
	Append__2qww(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Then_Z69));
	if (Array<ZNode>GetIndex(ZIfNode_Else_Z70) != NULL) {
		AppendToken__2qww(this->CurrentBuilder, "else");
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZIfNode_Else_Z70));
	};
	return;
}
static void VisitReturnNode__2qyv(struct ZSourceGenerator207 * this, struct ZReturnNode135 * Node__1) {
	Append__2qww(this->CurrentBuilder, "return");
	if (Array<ZNode>GetIndex(ZReturnNode_Expr_Z24) != NULL) {
		AppendWhiteSpace__1qww(this->CurrentBuilder);
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZReturnNode_Expr_Z24));
	};
	return;
}
static void VisitWhileNode__2qyv(struct ZSourceGenerator207 * this, struct ZWhileNode165 * Node__1) {
	Append__2qww(this->CurrentBuilder, "while (");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZWhileNode_Cond_Z37));
	Append__2qww(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZWhileNode_Block_Z38));
	return;
}
static void VisitBreakNode__2qyv(struct ZSourceGenerator207 * this, struct ZBreakNode311 * Node__1) {
	Append__2qww(this->CurrentBuilder, "break");
	return;
}
static void VisitThrowNode__2qyv(struct ZSourceGenerator207 * this, struct ZThrowNode156 * Node__1) {
	Append__2qww(this->CurrentBuilder, "throw");
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZThrowNode_Expr_Z32));
	return;
}
static void VisitTryNode__2qyv(struct ZSourceGenerator207 * this, struct ZTryNode159 * Node__1) {
	Append__2qww(this->CurrentBuilder, "try");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Try_Z33));
	if (Array<ZNode>GetIndex(ZTryNode_Catch_Z34) != NULL) {
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Catch_Z34));
	};
	if (Array<ZNode>GetIndex(ZTryNode_Finally_Z35) != NULL) {
		Append__2qww(this->CurrentBuilder, "finally");
		/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZTryNode_Finally_Z35));
	};
	return;
}
static void VisitCatchNode__2qyv(struct ZSourceGenerator207 * this, struct ZCatchNode318 * Node__1) {
	Append__2qww(this->CurrentBuilder, "catch (");
	Append__2qww(this->CurrentBuilder, Node->ExceptionName);
	VisitTypeAnnotation__2qyv(this, Node->ExceptionType);
	Append__2qww(this->CurrentBuilder, ")");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZCatchNode_Block_Z62));
	return;
}
static void VisitVarNode__2qyv(struct ZSourceGenerator207 * this, struct ZVarNode499 * Node__1) {
	Append__2qww(this->CurrentBuilder, "var");
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	Append__2qww(this->CurrentBuilder, Node->NativeName);
	VisitTypeAnnotation__2qyv(this, Node->DeclType);
	AppendToken__2qww(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZVarNode_InitValue_Z80));
	Append__2qww(this->CurrentBuilder, this->SemiColon);
	VisitStmtList__2qyv(this, Node);
	return;
}
static void VisitTypeAnnotation__2qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1) {
	Append__2qww(this->CurrentBuilder, ": ");
	GenerateTypeName__2qyv(this, Type);
	return;
}
static void VisitLetNode__2qyv(struct ZSourceGenerator207 * this, struct ZLetNode373 * Node__1) {
	Append__2qww(this->CurrentBuilder, "let");
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	Append__2qww(this->CurrentBuilder, Node->GlobalName);
	AppendToken__2qww(this->CurrentBuilder, "=");
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZLetNode_InitValue_Z72));
	return;
}
static void VisitParamNode__2qyv(struct ZSourceGenerator207 * this, struct ZParamNode137 * Node__1) {
	Append__2qww(this->CurrentBuilder, SafeName__3qyv(this, Node->Name, Node->ParamIndex));
	VisitTypeAnnotation__2qyv(this, Node->Type);
	return;
}
static void VisitFunctionNode__2qyv(struct ZSourceGenerator207 * this, struct ZFunctionNode109 * Node__1) {
	Append__2qww(this->CurrentBuilder, "function");
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	if (Node->FuncName != NULL) {
		Append__2qww(this->CurrentBuilder, Node->FuncName);
	};
	VisitListNode__4qyv(this, "(", Node, ")");
	VisitTypeAnnotation__2qyv(this, Node->ReturnType);
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFunctionNode_Block_Z79));
	return;
}
static void VisitClassNode__2qyv(struct ZSourceGenerator207 * this, struct ZClassNode509 * Node__1) {
	Append__2qww(this->CurrentBuilder, "class");
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	Append__2qww(this->CurrentBuilder, Node->ClassName);
	if (Node->SuperType != NULL) {
		AppendToken__2qww(this->CurrentBuilder, "extends");
		GenerateTypeName__2qyv(this, Node->SuperType);
	};
	AppendWhiteSpace__1qww(this->CurrentBuilder);
	Append__2qww(this->CurrentBuilder, "{");
	Indent__1qww(this->CurrentBuilder);
	long i = 0;
	while (i < GetListSize__1qy8(Node)) {
		struct ZFieldNode333 * FieldNode = GetFieldNode__2qdy(Node, i);
		AppendLineFeed__1qww(this->CurrentBuilder);
		AppendIndent__1qww(this->CurrentBuilder);
		Append__2qww(this->CurrentBuilder, "var");
		AppendWhiteSpace__1qww(this->CurrentBuilder);
		Append__2qww(this->CurrentBuilder, FieldNode->FieldName);
		VisitTypeAnnotation__2qyv(this, FieldNode->DeclType);
		if (HasAst__2qws(FieldNode, ZFieldNode_InitValue_Z63)) {
			AppendToken__2qww(this->CurrentBuilder, "=");
			/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZFieldNode_InitValue_Z63));
		};
		Append__2qww(this->CurrentBuilder, this->SemiColon);
		i = i + 1;
	};
	UnIndent__1qww(this->CurrentBuilder);
	AppendLineFeed__1qww(this->CurrentBuilder);
	AppendIndent__1qww(this->CurrentBuilder);
	Append__2qww(this->CurrentBuilder, "}");
	return;
}
static void VisitErrorNode__2qyv(struct ZSourceGenerator207 * this, struct ZErrorNode329 * Node__1) {
	(void)ZLogger_LogError__2qwb(Node->SourceToken, Node->ErrorMessage);
	Append__2qww(this->CurrentBuilder, "ThrowError(");
	Append__2qww(this->CurrentBuilder, LibZen_QuoteString__1qqy(Node->ErrorMessage));
	Append__2qww(this->CurrentBuilder, ")");
	return;
}
static void VisitExtendedNode__2qyv(struct ZSourceGenerator207 * this, struct ZNode49 * Node__1) {
	if (LibZen_Is(Node, 137)) {
		VisitParamNode__2qyv(this, (struct ZParamNode137 *)Node);
	} else {
		struct ZSugarNode130 * SugarNode = /*untyped*/NULL(Node, this);
		/*untyped*/NULL(this, SugarNode);
	};
	return;
}
static void VisitSugarNode__2qyv(struct ZSourceGenerator207 * this, struct ZSugarNode130 * Node__1) {
	/*untyped*/NULL(this, NULL, Array<ZNode>GetIndex(ZSugarNode_DeSugar_Z31));
	return;
}
static void GenerateTypeName__2qyv(struct ZSourceGenerator207 * this, struct ZType59 * Type__1) {
	Append__2qww(this->CurrentBuilder, GetNativeType__2qyv(this, /*untyped*/NULL(Type)));
	return;
}
static void VisitListNode__5qyv(struct ZSourceGenerator207 * this, const char * OpenToken__1, struct ZListNode215 * VargNode__2, const char * DelimToken__3, const char * CloseToken__4) {
	Append__2qww(this->CurrentBuilder, OpenToken);
	long i = 0;
	while (i < GetListSize__1qy8(VargNode)) {
		struct ZNode49 * ParamNode = GetListAt__2qy8(VargNode, i);
		if (i > 0) {
			Append__2qww(this->CurrentBuilder, DelimToken);
		};
		/*untyped*/NULL(this, NULL, ParamNode);
		i = i + 1;
	};
	Append__2qww(this->CurrentBuilder, CloseToken);
	return;
}
static void VisitListNode__4qyv(struct ZSourceGenerator207 * this, const char * OpenToken__1, struct ZListNode215 * VargNode__2, const char * CloseToken__3) {
	VisitListNode__5qyv(this, OpenToken, VargNode, ", ", CloseToken);
	return;
}
static struct ZTypeChecker106 * ZTypeChecker__2qe2(struct ZTypeChecker106 * this, struct ZGenerator52 * Generator__1) {
	this->Generator = Generator;
	this->Logger = Generator->Logger;
	this->StackedContextType = NULL;
	this->ReturnedNode = NULL;
	this->StoppedVisitor = 0/*false*/;
	this->VarScope = ZVarScope__4qec(_NewZVarScope98(), NULL, this->Logger, NULL);
	return NULL;
}
static void EnableVisitor__1qe2(struct ZTypeChecker106 * this) {
	this->StoppedVisitor = 0/*false*/;
	return;
}
static void StopVisitor__1qe2(struct ZTypeChecker106 * this) {
	this->StoppedVisitor = 1/*true*/;
	return;
}
static int IsVisitable__1qe2(struct ZTypeChecker106 * this) {
	return !this->StoppedVisitor;
}
static struct ZType59 * GetContextType__1qe2(struct ZTypeChecker106 * this) {
	return this->StackedContextType;
}
static struct ZNode49 * VisitTypeChecker__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2) {
	struct ZNode49 * ParentNode = Node->ParentNode;
	this->StackedContextType = ContextType;
	this->ReturnedNode = NULL;
	Node->Accept(Node, this);
	if (this->ReturnedNode == NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("!! returns no value: ", ThrowError("type error: requested = String, given = ZNode")));
	} else {
		Node = this->ReturnedNode;
	};
	if (ParentNode != Node->ParentNode && ParentNode != NULL) {
		(void)SetChild__2qws(ParentNode, Node);
	};
	CheckVarNode__3qec(this->VarScope, ContextType, Node);
	return Node;
}
static struct ZNode49 * CreateStupidCastNode__3qe2(struct ZTypeChecker106 * this, struct ZType59 * Requested__1, struct ZNode49 * Node__2) {
	struct ZNode49 * ErrorNode = ZStupidCastErrorNode__3q47(_NewZStupidCastErrorNode427(), Node, LibZen_StrCat(LibZen_StrCat(LibZen_StrCat("type error: requested = ", ThrowError("type error: requested = String, given = ZType")), ", given = "), ThrowError("type error: requested = String, given = ZType")));
	ErrorNode->Type = Requested;
	return ErrorNode;
}
static struct ZNode49 * EnforceNodeType__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * EnforceType__2) {
	struct ZFunc66 * Func = GetConverterFunc__3qwg(this->Generator, Node->Type, ZTypeStringType_Z11);
	if (LibZen_Is(Func, 176)) {
		struct ZMacroNode385 * MacroNode = ZMacroNode__4q0x(_NewZMacroNode385(), Node->ParentNode, NULL, (struct ZMacroFunc176 *)Func);
		Append__2qy8(MacroNode, Node);
		MacroNode->Type = EnforceType;
		return MacroNode;
	} else if (Func != NULL) {
		struct ZFuncCallNode400 * MacroNode = ZFuncCallNode__4q4t(_NewZFuncCallNode400(), Node->ParentNode, Func->FuncName, GetFuncType__1qwm(Func));
		Append__2qy8(MacroNode, Node);
		MacroNode->Type = EnforceType;
		return MacroNode;
	};
	return CreateStupidCastNode__3qe2(this, EnforceType, Node);
}
static struct ZNode49 * TypeCheckImpl__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2, long TypeCheckPolicy__3) {
	if (IsErrorNode__1qws(Node)) {
		if (!ContextType->IsVarType(ContextType)) {
			Node->Type = ContextType;
		};
		return Node;
	};
	if (IsUntyped__1qws(Node) || ContextType->IsVarType(ContextType) || LibZen_IsFlag__2qqr(TypeCheckPolicy, /*untyped*/NULL)) {
		return Node;
	};
	if (Node->Type == ContextType || Accept__2qw6(ContextType, Node->Type)) {
		return Node;
	};
	if (IsVoidType__1qw6(ContextType) && !IsVoidType__1qw6(Node->Type)) {
		return ZCastNode__4qoc(_NewZCastNode314(), Node->ParentNode, ZTypeVoidType_Z7, Node);
	};
	if (IsFloatType__1qw6(ContextType) && IsIntType__1qw6(Node->Type)) {
		return EnforceNodeType__3qe2(this, Node, ContextType);
	};
	if (IsIntType__1qw6(ContextType) && IsFloatType__1qw6(Node->Type)) {
		return EnforceNodeType__3qe2(this, Node, ContextType);
	};
	return CreateStupidCastNode__3qe2(this, ContextType, Node);
}
static struct ZNode49 * VisitTypeChecker__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2, long TypeCheckPolicy__3) {
	if (/*untyped*/NULL(this) && Node != NULL) {
		if (HasUntypedNode__1qws(Node)) {
			Node = VisitTypeChecker__3qws(Node, this, ContextType);
		};
		Node = TypeCheckImpl__4qe2(this, Node, ContextType, TypeCheckPolicy);
		CheckVarNode__3qec(this->VarScope, ContextType, Node);
	};
	this->ReturnedNode = NULL;
	return Node;
}
static struct ZNode49 * TryType__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2) {
	return VisitTypeChecker__4qe2(this, Node, ContextType, /*untyped*/NULL);
}
static void TryTypeAt__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, long Index__2, struct ZType59 * ContextType__3) {
	Set__3qws(Node, Index, VisitTypeChecker__4qe2(this, Array<ZNode>GetIndex(Index), ContextType, /*untyped*/NULL));
	return;
}
static struct ZNode49 * CheckType__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * ContextType__2) {
	return VisitTypeChecker__4qe2(this, Node, ContextType, /*untyped*/NULL);
}
static void CheckTypeAt__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, long Index__2, struct ZType59 * ContextType__3) {
	Set__3qws(Node, Index, VisitTypeChecker__4qe2(this, Array<ZNode>GetIndex(Index), ContextType, /*untyped*/NULL));
	return;
}
static int TypeCheckNodeList__2qe2(struct ZTypeChecker106 * this, struct ZListNode215 * List__1) {
	if (/*untyped*/NULL(this)) {
		int AllTyped = 1/*true*/;
		long i = 0;
		while (i < GetListSize__1qy8(List)) {
			struct ZNode49 * SubNode = GetListAt__2qy8(List, i);
			SubNode = CheckType__3qe2(this, SubNode, ZTypeVarType_Z6);
			SetListAt__3qy8(List, i, SubNode);
			if (IsUntyped__1qws(SubNode)) {
				AllTyped = 0/*false*/;
			};
			i = i + 1;
		};
		return AllTyped;
	};
	return 0/*false*/;
}
static void Return__2qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1) {
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", ThrowError("type error: requested = String, given = ZNode")));
	};
	this->ReturnedNode = Node;
	return;
}
static void TypedNode__3qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZType59 * Type__2) {
	Node->Type = Type->GetRealType(Type);
	if (this->ReturnedNode != NULL) {
		LibZen_PrintDebug__1qqy(LibZen_StrCat("previous returned node ", ThrowError("type error: requested = String, given = ZNode")));
	};
	this->ReturnedNode = Node;
	return;
}
static void ReturnErrorNode__4qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1, struct ZToken64 * ErrorToken__2, const char * Message__3) {
	if (ErrorToken == NULL) {
		ErrorToken = Node->SourceToken;
	};
	Return__2qe2(this, ZErrorNode__4qpy(_NewZErrorNode329(), Node->ParentNode, ErrorToken, Message));
	return;
}
static void VisitErrorNode__2qe2(struct ZTypeChecker106 * this, struct ZErrorNode329 * Node__1) {
	struct ZType59 * ContextType = GetContextType__1qe2(this);
	if (!/*untyped*/NULL(ContextType)) {
		TypedNode__3qe2(this, Node, ContextType);
	} else {
		Return__2qe2(this, Node);
	};
	return;
}
static void VisitExtendedNode__2qe2(struct ZTypeChecker106 * this, struct ZNode49 * Node__1) {
	struct ZType59 * ContextType = GetContextType__1qe2(this);
	struct ZNode49 * DeNode = /*untyped*/NULL(Node, this->Generator);
	if (!IsErrorNode__1qws(DeNode)) {
		Return__2qe2(this, CheckType__3qe2(this, DeNode, ContextType));
	} else {
		TypedNode__3qe2(this, DeNode, ContextType);
	};
	return;
}
static void VisitSugarNode__2qe2(struct ZTypeChecker106 * this, struct ZSugarNode130 * Node__1) {
	struct ZType59 * ContextType = GetContextType__1qe2(this);
	CheckTypeAt__4qe2(this, Node, ZSugarNode_DeSugar_Z31, ContextType);
	TypedNode__3qe2(this, Node, GetAstType__2qws(Node, ZSugarNode_DeSugar_Z31));
	return;
}
static struct ZArrayType591 * ZArrayType__3qgf(struct ZArrayType591 * this, long TypeFlag__1, struct ZType59 * ParamType__2) {
	ThrowError("not function: ZGeneric1Type");
	return NULL;
}
static struct ZAndNode495 * ZAndNode__5qsv(struct ZAndNode495 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, struct ZNode49 * Left__3, struct ZSyntax184 * Pattern__4) {
	ThrowError("not function: ZBinaryNode");
	return NULL;
}
static void Accept__2qsv(struct ZAndNode495 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZArrayLiteralNode474 * ZArrayLiteralNode__2qsu(struct ZArrayLiteralNode474 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZListNode");
	return NULL;
}
static void Accept__2qsu(struct ZArrayLiteralNode474 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZBlockNode126 * ZBlockNode__2qrj(struct ZBlockNode126 * this, struct ZNameSpace43 * NameSpace__1) {
	ThrowError("not function: ZListNode");
	this->NameSpace = NameSpace;
	return NULL;
}
static struct ZBlockNode126 * ZBlockNode__3qrj(struct ZBlockNode126 * this, struct ZNode49 * ParentNode__1, long Init__2) {
	ThrowError("not function: ZListNode");
	this->NameSpace = CreateSubNameSpace__1qwi(GetNameSpace__1qws(ParentNode));
	return NULL;
}
static void Accept__2qrj(struct ZBlockNode126 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZReturnNode135 * ToReturnNode__1qrj(struct ZBlockNode126 * this) {
	if (GetListSize__1qy8(this) == 1) {
		return ToReturnNode__1qws(GetListAt__2qy8(this, 0));
	};
	return NULL;
}
static long IndexOf__2qrj(struct ZBlockNode126 * this, struct ZNode49 * ChildNode__1) {
	long i = 0;
	while (i < GetListSize__1qy8(this)) {
		if (GetListAt__2qy8(this, i) == ChildNode) {
			return i;
		};
		i = i + 1;
	};
	return -1;
}
static void CopyTo__3qrj(struct ZBlockNode126 * this, long Index__1, struct ZBlockNode126 * BlockNode__2) {
	long i = Index;
	while (i < GetListSize__1qy8(this)) {
		Append__2qy8(BlockNode, GetListAt__2qy8(this, i));
		i = i + 1;
	};
	return;
}
static struct ZBooleanNode469 * ZBooleanNode__4qsw(struct ZBooleanNode469 * this, struct ZNode49 * ParentNode__1, struct ZToken64 * Token__2, int Value__3) {
	ThrowError("not function: ZConstNode");
	this->Type = ZTypeBooleanType_Z8;
	this->BooleanValue = Value;
	return NULL;
}
static void Accept__2qsw(struct ZBooleanNode469 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZClassNode509 * ZClassNode__2qdy(struct ZClassNode509 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZListNode");
	return NULL;
}
static void SetTypeInfo__3qdy(struct ZClassNode509 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->SuperType = Type;
	this->SuperToken = TypeToken;
	return;
}
static void SetNameInfo__3qdy(struct ZClassNode509 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->ClassName = Name;
	this->NameToken = NameToken;
	return;
}
static struct ZFieldNode333 * GetFieldNode__2qdy(struct ZClassNode509 * this, long Index__1) {
	struct ZNode49 * Node = GetListAt__2qy8(this, Index);
	if (LibZen_Is(Node, 333)) {
		return (struct ZFieldNode333 *)Node;
	};
	return NULL;
}
static void Accept__2qdy(struct ZClassNode509 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZFuncCallNode400 * ZFuncCallNode__3q4t(struct ZFuncCallNode400 * this, struct ZNode49 * ParentNode__1, struct ZNode49 * FuncNode__2) {
	ThrowError("not function: ZListNode");
	Set__3qws(this, ZFuncCallNode_Func_Z78, FuncNode);
	return NULL;
}
static struct ZFuncCallNode400 * ZFuncCallNode__4q4t(struct ZFuncCallNode400 * this, struct ZNode49 * ParentNode__1, const char * FuncName__2, struct ZType59 * FuncType__3) {
	ThrowError("not function: ZListNode");
	struct ZGlobalNameNode353 * FuncNode = ZGlobalNameNode__6qpn(_NewZGlobalNameNode353(), this, NULL, FuncType, FuncName, 1/*true*/);
	Set__3qws(this, ZFuncCallNode_Func_Z78, FuncNode);
	return NULL;
}
static void Accept__2q4t(struct ZFuncCallNode400 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZType59 * GetRecvType__1q4t(struct ZFuncCallNode400 * this) {
	if (GetListSize__1qy8(this) > 0) {
		return /*untyped*/NULL(GetListAt__2qy8(this, 0)->Type);
	};
	return ZTypeVoidType_Z7;
}
static const char * GetFuncName__1q4t(struct ZFuncCallNode400 * this) {
	struct ZNode49 * FNode = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78);
	if (LibZen_Is(FNode, 353)) {
		return ((struct ZGlobalNameNode353 *)FNode)->GlobalName;
	};
	return NULL;
}
static struct ZFuncType67 * GetFuncType__1q4t(struct ZFuncCallNode400 * this) {
	struct ZType59 * FType = Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78)->Type;
	if (LibZen_Is(FType, 67)) {
		return (struct ZFuncType67 *)FType;
	};
	return NULL;
}
static struct ZMacroNode385 * ToMacroNode__2q4t(struct ZFuncCallNode400 * this, struct ZMacroFunc176 * MacroFunc__1) {
	struct ZMacroNode385 * MacroNode = ZMacroNode__4q0x(_NewZMacroNode385(), this->ParentNode, Array<ZNode>GetIndex(ZFuncCallNode_Func_Z78)->SourceToken, MacroFunc);
	long i = 0;
	while (i < GetListSize__1qy8(this)) {
		Append__2qy8(MacroNode, GetListAt__2qy8(this, i));
		i = i + 1;
	};
	return MacroNode;
}
static struct ZFunctionNode109 * ZFunctionNode__2qrw(struct ZFunctionNode109 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZListNode");
	return NULL;
}
static void SetTypeInfo__3qrw(struct ZFunctionNode109 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->ReturnType = Type;
	return;
}
static void SetNameInfo__3qrw(struct ZFunctionNode109 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->FuncName = Name;
	this->NameToken = NameToken;
	return;
}
static void Accept__2qrw(struct ZFunctionNode109 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZParamNode137 * GetParamNode__2qrw(struct ZFunctionNode109 * this, long Index__1) {
	struct ZNode49 * Node = GetListAt__2qy8(this, Index);
	if (LibZen_Is(Node, 137)) {
		return (struct ZParamNode137 *)Node;
	};
	return NULL;
}
static struct ZFuncType67 * GetFuncType__2qrw(struct ZFunctionNode109 * this, struct ZType59 * ContextType__1) {
	if (this->ResolvedFuncType == NULL) {
		struct ZFuncType67 * FuncType = NULL;
		if (LibZen_Is(ContextType, 67)) {
			FuncType = (struct ZFuncType67 *)ContextType;
		};
		ArrayOfZType * TypeList = LibZen_NewArray(0);
		if (this->ReturnType->IsVarType(this->ReturnType) && FuncType != NULL) {
			this->ReturnType = FuncType->GetParamType(FuncType, 0);
		};
		/*untyped*/NULL;
		long i = 0;
		while (i < GetListSize__1qy8(this)) {
			struct ZParamNode137 * Node = GetParamNode__2qrw(this, i);
			struct ZType59 * ParamType = Node->Type->GetRealType(Node->Type);
			if (ParamType->IsVarType(ParamType) && FuncType != NULL) {
				ParamType = FuncType->GetParamType(FuncType, i + 1);
			};
			/*untyped*/NULL;
			i = i + 1;
		};
		FuncType = ZTypePool_LookupFuncType__1qwz(TypeList);
		if (!FuncType->IsVarType(FuncType)) {
			this->ResolvedFuncType = FuncType;
		};
		return FuncType;
	};
	return this->ResolvedFuncType;
}
static const char * GetSignature__2qrw(struct ZFunctionNode109 * this, struct ZGenerator52 * Generator__1) {
	struct ZFuncType67 * FuncType = GetFuncType__2qrw(this, NULL);
	if (this->FuncName == NULL) {
		this->FuncName = LibZen_StrCat("f_Z", LibZen_IntToString(GetUniqueNumber__1qwg(Generator)));
	};
	return StringfySignature__2qw7(FuncType, this->FuncName);
}
static struct ZFunctionNode109 * Push__2qrw(struct ZFunctionNode109 * this, struct ZFunctionNode109 * Parent__1) {
	this->ParentFunctionNode = Parent;
	return this;
}
static struct ZFunctionNode109 * Pop__1qrw(struct ZFunctionNode109 * this) {
	return this->ParentFunctionNode;
}
static int IsTopLevel__1qrw(struct ZFunctionNode109 * this) {
	return this->ParentFunctionNode == NULL;
}
static long GetVarIndex__1qrw(struct ZFunctionNode109 * this) {
	long Index = this->VarIndex;
	this->VarIndex = this->VarIndex + 1;
	return Index;
}
static struct ZVarNode499 * ZVarNode__2qs7(struct ZVarNode499 * this, struct ZNode49 * ParentNode__1) {
	ThrowError("not function: ZBlockNode");
	return NULL;
}
static void SetNameInfo__3qs7(struct ZVarNode499 * this, struct ZToken64 * NameToken__1, const char * Name__2) {
	this->NativeName = Name;
	this->NameToken = NameToken;
	return;
}
static void SetTypeInfo__3qs7(struct ZVarNode499 * this, struct ZToken64 * TypeToken__1, struct ZType59 * Type__2) {
	this->DeclType = Type;
	this->TypeToken = TypeToken;
	return;
}
static void Accept__2qs7(struct ZVarNode499 * this, struct ZVisitor132 * Visitor__1) {
	/*untyped*/NULL(Visitor, this);
	return;
}
static struct ZNode49 * AndPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZBinaryNode304 * BinaryNode = ZAndNode__5qsv(_NewZAndNode495(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57), LeftNode, GetApplyingSyntax__1qwd(TokenContext));
	return AppendParsedRightNode__3qog(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode49 * AnnotationPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	return NULL;
}
static struct ZNode49 * ApplyPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * ApplyNode = ZFuncCallNode__3q4t(_NewZFuncCallNode400(), ParentNode, LeftNode);
	ApplyNode = MatchNtimes__6qwd(TokenContext, ApplyNode, "(", "$Expression$", ",", ")");
	return ApplyNode;
}
static struct ZNode49 * ArrayLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * LiteralNode = ZArrayLiteralNode__2qsu(_NewZArrayLiteralNode474(), ParentNode);
	LiteralNode = MatchNtimes__6qwd(TokenContext, LiteralNode, "[", "$Expression$", ",", "]");
	return LiteralNode;
}
static struct ZNode49 * AssertPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * AssertNode = ZAssertNode__2qos(_NewZAssertNode301(), ParentNode);
	AssertNode = MatchToken__4qwd(TokenContext, AssertNode, "assert", ZTokenContext_Required_Z52);
	AssertNode = MatchToken__4qwd(TokenContext, AssertNode, "(", ZTokenContext_Required_Z52);
	AssertNode = MatchPattern__6qwd(TokenContext, AssertNode, ZThrowNode_Expr_Z32, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	AssertNode = MatchToken__4qwd(TokenContext, AssertNode, ")", ZTokenContext_Required_Z52);
	return AssertNode;
}
static struct ZNode49 * AssignPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	return NULL;
}
static struct ZNode49 * BinaryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * Token = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	struct ZBinaryNode304 * BinaryNode = ZBinaryNode__5qog(_NewZBinaryNode304(), ParentNode, Token, LeftNode, GetApplyingSyntax__1qwd(TokenContext));
	return AppendParsedRightNode__3qog(BinaryNode, ParentNode, TokenContext);
}
static int BlockComment__1qw0(struct ZSourceContext46 * SourceContext) {
	long StartIndex = GetPosition__1qw0(SourceContext);
	const char * NextChar = GetCharAtFromCurrentPosition__2qw0(SourceContext, +1);
	if (NextChar != "/" && NextChar != "*") {
		return 0/*false*/;
	};
	if (NextChar == "/") {
		while (HasChar__1qw0(SourceContext)) {
			const char * ch = GetCurrentChar__1qw0(SourceContext);
			if (ch == "\n") {
				break;
			};
			MoveNext__1qw0(SourceContext);
		};
		return 1/*true*/;
	};
	long NestedLevel = 0;
	const char * PrevChar = "0";
	while (HasChar__1qw0(SourceContext)) {
		NextChar = GetCurrentChar__1qw0(SourceContext);
		if (PrevChar == "*" && NextChar == "/") {
			NestedLevel = NestedLevel - 1;
			if (NestedLevel == 0) {
				MoveNext__1qw0(SourceContext);
				return 1/*true*/;
			};
		};
		if (PrevChar == "/" && NextChar == "*") {
			NestedLevel = NestedLevel + 1;
		};
		MoveNext__1qw0(SourceContext);
		PrevChar = NextChar;
	};
	LogWarning__3qw0(SourceContext, StartIndex, "unfound */");
	return 1/*true*/;
}
static struct ZNode49 * BlockPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * BlockNode = ZBlockNode__3qrj(_NewZBlockNode126(), ParentNode, 0);
	struct ZToken64 * SkipToken = GetToken__1qwd(TokenContext);
	BlockNode = MatchToken__4qwd(TokenContext, BlockNode, "{", ZTokenContext_Required_Z52);
	if (!IsErrorNode__1qws(BlockNode)) {
		int Remembered = SetParseFlag__2qwd(TokenContext, ZTokenContext_AllowSkipIndent_Z54);
		struct ZNode49 * NestedBlockNode = BlockNode;
		while (HasNext__1qwd(TokenContext)) {
			if (MatchToken__2qwd(TokenContext, "}")) {
				break;
			};
			NestedBlockNode = MatchPattern__5qwd(TokenContext, NestedBlockNode, ZNode_NestedAppendIndex_Z23, "$Statement$", ZTokenContext_Required_Z52);
			if (IsErrorNode__1qws(NestedBlockNode)) {
				SkipError__2qwd(TokenContext, SkipToken);
				(void)MatchToken__2qwd(TokenContext, "}");
				break;
			};
		};
		(void)SetParseFlag__2qwd(TokenContext, Remembered);
	};
	return BlockNode;
}
static struct ZNode49 * BreakPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * BreakNode = ZBreakNode__2qo6(_NewZBreakNode311(), ParentNode);
	BreakNode = MatchToken__4qwd(TokenContext, BreakNode, "break", ZTokenContext_Required_Z52);
	return BreakNode;
}
static int CLineComment__1qw0(struct ZSourceContext46 * SourceContext) {
	return 0/*false*/;
}
static struct ZNode49 * CastPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * CastNode = ZCastNode__4qoc(_NewZCastNode314(), ParentNode, ZTypeVarType_Z6, NULL);
	CastNode = MatchToken__4qwd(TokenContext, CastNode, "(", ZTokenContext_Required_Z52);
	CastNode = MatchPattern__5qwd(TokenContext, CastNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Required_Z52);
	CastNode = MatchToken__4qwd(TokenContext, CastNode, ")", ZTokenContext_Required_Z52);
	CastNode = MatchPattern__5qwd(TokenContext, CastNode, ZCastNode_Expr_Z61, "$RightExpression$", ZTokenContext_Required_Z52);
	return CastNode;
}
static struct ZNode49 * CatchPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * CatchNode = ZCatchNode__2qom(_NewZCatchNode318(), ParentNode);
	CatchNode = MatchToken__4qwd(TokenContext, CatchNode, "catch", ZTokenContext_Required_Z52);
	CatchNode = MatchToken__4qwd(TokenContext, CatchNode, "(", ZTokenContext_Required_Z52);
	CatchNode = MatchPattern__5qwd(TokenContext, CatchNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	CatchNode = MatchToken__4qwd(TokenContext, CatchNode, ")", ZTokenContext_Required_Z52);
	CatchNode = MatchPattern__5qwd(TokenContext, CatchNode, ZCatchNode_Block_Z62, "$Block$", ZTokenContext_Required_Z52);
	return CatchNode;
}
static struct ZNode49 * ClassPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * ClassNode = ZClassNode__2qdy(_NewZClassNode509(), ParentNode);
	ClassNode = MatchToken__4qwd(TokenContext, ClassNode, "class", ZTokenContext_Required_Z52);
	ClassNode = MatchPattern__5qwd(TokenContext, ClassNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	if (MatchNewLineToken__2qwd(TokenContext, "extends")) {
		ClassNode = MatchPattern__5qwd(TokenContext, ClassNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Required_Z52);
	};
	ClassNode = MatchNtimes__6qwd(TokenContext, ClassNode, "{", "$FieldDecl$", NULL, "}");
	return ClassNode;
}
static struct ZNode49 * ComparatorPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * Token = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	struct ZBinaryNode304 * BinaryNode = ZComparatorNode__5qo2(_NewZComparatorNode322(), ParentNode, Token, LeftNode, GetApplyingSyntax__1qwd(TokenContext));
	return AppendParsedRightNode__3qog(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode49 * ExpressionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qws(ParentNode, TokenContext, LeftNode, 0/*false*/, 1/*true*/);
}
static struct ZNode49 * FalsePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	return ZBooleanNode__4qsw(_NewZBooleanNode469(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57), 0/*false*/);
}
static struct ZNode49 * FieldPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	int Rememberd = SetParseFlag__2qwd(TokenContext, 0/*false*/);
	struct ZNode49 * FieldNode = ZFieldNode__2qpp(_NewZFieldNode333(), ParentNode);
	FieldNode = MatchToken__4qwd(TokenContext, FieldNode, "var", ZTokenContext_Required_Z52);
	FieldNode = MatchPattern__5qwd(TokenContext, FieldNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	FieldNode = MatchPattern__5qwd(TokenContext, FieldNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	if (MatchToken__2qwd(TokenContext, "=")) {
		FieldNode = MatchPattern__5qwd(TokenContext, FieldNode, ZFieldNode_InitValue_Z63, "$Expression$", ZTokenContext_Required_Z52);
	};
	FieldNode = MatchPattern__5qwd(TokenContext, FieldNode, ZNode_Nop_Z19, ";", ZTokenContext_Required_Z52);
	(void)SetParseFlag__2qwd(TokenContext, Rememberd);
	return FieldNode;
}
static struct ZNode49 * FloatLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * Token = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	return ZFloatNode__4qps(_NewZFloatNode337(), ParentNode, Token, LibZen_ParseFloat__1qqy(GetText__1qwb(Token)));
}
static struct ZNode49 * FunctionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * FuncNode = ZFunctionNode__2qrw(_NewZFunctionNode109(), ParentNode);
	FuncNode = MatchToken__4qwd(TokenContext, FuncNode, "function", ZTokenContext_Required_Z52);
	FuncNode = MatchPattern__5qwd(TokenContext, FuncNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Optional_Z53);
	FuncNode = MatchNtimes__6qwd(TokenContext, FuncNode, "(", "$Param$", ",", ")");
	FuncNode = MatchPattern__5qwd(TokenContext, FuncNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	FuncNode = MatchPattern__5qwd(TokenContext, FuncNode, ZFunctionNode_Block_Z79, "$Block$", ZTokenContext_Required_Z52);
	return FuncNode;
}
static struct ZNode49 * GetIndexPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * IndexerNode = ZGetIndexNode__3qpg(_NewZGetIndexNode340(), ParentNode, LeftNode);
	IndexerNode = MatchToken__4qwd(TokenContext, IndexerNode, "[", ZTokenContext_Required_Z52);
	IndexerNode = MatchPattern__6qwd(TokenContext, IndexerNode, ZGetIndexNode_Index_Z65, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	IndexerNode = MatchToken__4qwd(TokenContext, IndexerNode, "]", ZTokenContext_Required_Z52);
	return IndexerNode;
}
static struct ZNode49 * GetterPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * GetterNode = ZGetterNode__3qpz(_NewZGetterNode348(), ParentNode, LeftNode);
	GetterNode = MatchToken__4qwd(TokenContext, GetterNode, ".", ZTokenContext_Required_Z52);
	GetterNode = MatchPattern__5qwd(TokenContext, GetterNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	return GetterNode;
}
static struct ZNode49 * GroupPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * GroupNode = ZGroupNode__2qp3(_NewZGroupNode357(), ParentNode);
	GroupNode = MatchToken__4qwd(TokenContext, GroupNode, "(", ZTokenContext_Required_Z52);
	GroupNode = MatchPattern__6qwd(TokenContext, GroupNode, ZGroupNode_Expr_Z67, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	GroupNode = MatchToken__4qwd(TokenContext, GroupNode, ")", ZTokenContext_Required_Z52);
	return GroupNode;
}
static struct ZNode49 * IfPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * IfNode = ZIfNode__2q0q(_NewZIfNode360(), ParentNode);
	IfNode = MatchToken__4qwd(TokenContext, IfNode, "if", ZTokenContext_Required_Z52);
	IfNode = MatchToken__4qwd(TokenContext, IfNode, "(", ZTokenContext_Required_Z52);
	IfNode = MatchPattern__6qwd(TokenContext, IfNode, ZIfNode_Cond_Z68, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowNewLine_Z56);
	IfNode = MatchToken__4qwd(TokenContext, IfNode, ")", ZTokenContext_Required_Z52);
	IfNode = MatchPattern__5qwd(TokenContext, IfNode, ZIfNode_Then_Z69, "$Block$", ZTokenContext_Required_Z52);
	if (MatchNewLineToken__2qwd(TokenContext, "else")) {
		const char * PatternName = "$Block$";
		if (IsNewLineToken__2qwd(TokenContext, "if")) {
			PatternName = "if";
		};
		IfNode = MatchPattern__5qwd(TokenContext, IfNode, ZIfNode_Else_Z70, PatternName, ZTokenContext_Required_Z52);
	};
	return IfNode;
}
static struct ZNode49 * InstanceOfPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * BinaryNode = ZInstanceOfNode__4q0u(_NewZInstanceOfNode366(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57), LeftNode);
	BinaryNode = MatchPattern__5qwd(TokenContext, BinaryNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Required_Z52);
	return BinaryNode;
}
static struct ZNode49 * IntLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * Token = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	return ZIntNode__4q00(_NewZIntNode370(), ParentNode, Token, LibZen_ParseInt__1qqy(GetText__1qwb(Token)));
}
static struct ZNode49 * LetPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * LetNode = ZLetNode__2q0s(_NewZLetNode373(), ParentNode);
	LetNode = MatchToken__4qwd(TokenContext, LetNode, "let", ZTokenContext_Required_Z52);
	LetNode = MatchPattern__5qwd(TokenContext, LetNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	LetNode = MatchPattern__5qwd(TokenContext, LetNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	LetNode = MatchToken__4qwd(TokenContext, LetNode, "=", ZTokenContext_Required_Z52);
	LetNode = MatchPattern__5qwd(TokenContext, LetNode, ZLetNode_InitValue_Z72, "$Expression$", ZTokenContext_Required_Z52);
	return LetNode;
}
static struct ZNode49 * MapEntryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * LiteralNode = ZMapEntryNode__2q0m(_NewZMapEntryNode390(), ParentNode);
	LiteralNode = MatchPattern__5qwd(TokenContext, LiteralNode, ZMapEntryNode_Key_Z73, "$Expression$", ZTokenContext_Required_Z52);
	LiteralNode = MatchToken__4qwd(TokenContext, LiteralNode, ":", ZTokenContext_Required_Z52);
	LiteralNode = MatchPattern__5qwd(TokenContext, LiteralNode, ZMapEntryNode_Value_Z74, "$Expression$", ZTokenContext_Required_Z52);
	return LiteralNode;
}
static struct ZNode49 * MapLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * LiteralNode = ZMapLiteralNode__2q05(_NewZMapLiteralNode392(), ParentNode);
	LiteralNode = MatchNtimes__6qwd(TokenContext, LiteralNode, "{", "$MapEntry$", ",", "}");
	return LiteralNode;
}
static struct ZNode49 * MethodCallPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * MethodCallNode = ZMethodCallNode__3q4q(_NewZMethodCallNode396(), ParentNode, LeftNode);
	MethodCallNode = MatchToken__4qwd(TokenContext, MethodCallNode, ".", ZTokenContext_Required_Z52);
	MethodCallNode = MatchPattern__5qwd(TokenContext, MethodCallNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	MethodCallNode = MatchNtimes__6qwd(TokenContext, MethodCallNode, "(", "$Expression$", ",", ")");
	return MethodCallNode;
}
static struct ZNode49 * NamePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * Token = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	if (LibZen_IsSymbol__1qqy(GetChar__1qwb(Token))) {
		return ZGetNameNode__4qpk(_NewZGetNameNode343(), ParentNode, Token, GetText__1qwb(Token));
	};
	return ZErrorNode__4qpy(_NewZErrorNode329(), ParentNode, Token, LibZen_StrCat(LibZen_StrCat("illegal name: \"", GetText__1qwb(Token)), "\""));
}
static int NameToken__1qw0(struct ZSourceContext46 * SourceContext) {
	long StartIndex = GetPosition__1qw0(SourceContext);
	while (HasChar__1qw0(SourceContext)) {
		const char * ch = GetCurrentChar__1qw0(SourceContext);
		if (!LibZen_IsSymbol__1qqy(ch) && !LibZen_IsDigit__1qqy(ch)) {
			break;
		};
		MoveNext__1qw0(SourceContext);
	};
	Tokenize__3qw0(SourceContext, StartIndex, GetPosition__1qw0(SourceContext));
	return 1/*true*/;
}
static int NewLineToken__1qw0(struct ZSourceContext46 * SourceContext) {
	long StartIndex = GetPosition__1qw0(SourceContext) + 1;
	MoveNext__1qw0(SourceContext);
	SkipWhiteSpace__1qw0(SourceContext);
	FoundIndent__3qw0(SourceContext, StartIndex, GetPosition__1qw0(SourceContext));
	return 1/*true*/;
}
static struct ZNode49 * NewObjectPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * LiteralNode = ZNewObjectNode__2q4p(_NewZNewObjectNode405(), ParentNode);
	LiteralNode = MatchToken__4qwd(TokenContext, LiteralNode, "new", ZTokenContext_Required_Z52);
	LiteralNode = MatchPattern__5qwd(TokenContext, LiteralNode, ZNode_TypeInfo_Z21, "$Type$", ZTokenContext_Optional_Z53);
	LiteralNode = MatchNtimes__6qwd(TokenContext, LiteralNode, "(", "$Expression$", ",", ")");
	return LiteralNode;
}
static struct ZNode49 * NotPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * UnaryNode = ZNotNode__3q4s(_NewZNotNode409(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57));
	UnaryNode = MatchPattern__5qwd(TokenContext, UnaryNode, ZUnaryNode_Recv_Z36, "$RightExpression$", ZTokenContext_Required_Z52);
	return UnaryNode;
}
static struct ZNode49 * NullPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	return ZNullNode__3q4g(_NewZNullNode412(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57));
}
static int NumberLiteralToken__1qw0(struct ZSourceContext46 * SourceContext) {
	long StartIndex = GetPosition__1qw0(SourceContext);
	const char * ch = NumberLiteralToken_ParseDigit__1qw0(SourceContext);
	if (ch == ".") {
		MoveNext__1qw0(SourceContext);
		ch = NumberLiteralToken_ParseDigit__1qw0(SourceContext);
		if (ch == "e" || ch == "E") {
			MoveNext__1qw0(SourceContext);
			if (HasChar__1qw0(SourceContext)) {
				ch = GetCurrentChar__1qw0(SourceContext);
				if (ch == "+" || ch == "-") {
					MoveNext__1qw0(SourceContext);
				};
			};
			(void)NumberLiteralToken_ParseDigit__1qw0(SourceContext);
		};
		Tokenize__4qw0(SourceContext, "$FloatLiteral$", StartIndex, GetPosition__1qw0(SourceContext));
	} else {
		Tokenize__4qw0(SourceContext, "$IntegerLiteral$", StartIndex, GetPosition__1qw0(SourceContext));
	};
	return 1/*true*/;
}
static int OperatorToken__1qw0(struct ZSourceContext46 * SourceContext) {
	TokenizeDefinedSymbol__2qw0(SourceContext, GetPosition__1qw0(SourceContext));
	return 1/*true*/;
}
static struct ZNode49 * OrPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZBinaryNode304 * BinaryNode = ZOrNode__5q4k(_NewZOrNode415(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57), LeftNode, GetApplyingSyntax__1qwd(TokenContext));
	return AppendParsedRightNode__3qog(BinaryNode, ParentNode, TokenContext);
}
static struct ZNode49 * ParamPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * ParamNode = ZParamNode__2qrn(_NewZParamNode137(), ParentNode);
	ParamNode = MatchPattern__5qwd(TokenContext, ParamNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	ParamNode = MatchPattern__5qwd(TokenContext, ParamNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	return ParamNode;
}
static struct ZNode49 * PrototypePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * FuncNode = ZPrototypeNode__2q41(_NewZPrototypeNode418(), ParentNode);
	FuncNode = MatchToken__4qwd(TokenContext, FuncNode, "function", ZTokenContext_Required_Z52);
	FuncNode = MatchPattern__5qwd(TokenContext, FuncNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	FuncNode = MatchNtimes__6qwd(TokenContext, FuncNode, "(", "$Param$", ",", ")");
	FuncNode = MatchPattern__5qwd(TokenContext, FuncNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Required_Z52);
	return FuncNode;
}
static struct ZNode49 * ReturnPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * ReturnNode = ZReturnNode__2qrv(_NewZReturnNode135(), ParentNode);
	ReturnNode = MatchToken__4qwd(TokenContext, ReturnNode, "return", ZTokenContext_Required_Z52);
	ReturnNode = MatchPattern__5qwd(TokenContext, ReturnNode, ZReturnNode_Expr_Z24, "$Expression$", ZTokenContext_Optional_Z53);
	return ReturnNode;
}
static struct ZNode49 * RightExpressionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	return ExpressionPattern_DispatchPattern__5qws(ParentNode, TokenContext, LeftNode, 0/*false*/, 0/*false*/);
}
static struct ZNode49 * RightTypePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftTypeNode__2) {
	struct ZToken64 * SourceToken = GetToken__1qwd(TokenContext);
	if (LeftTypeNode->Type->GetParamSize(LeftTypeNode->Type) > 0) {
		if (MatchToken__2qwd(TokenContext, "<")) {
			ArrayOfZType * TypeList = LibZen_NewArray(0);
			while (!StartsWithToken__2qwd(TokenContext, ">")) {
				if (/*untyped*/NULL > 0 && !MatchToken__2qwd(TokenContext, ",")) {
					return NULL;
				};
				struct ZTypeNode199 * ParamTypeNode = (struct ZTypeNode199 *)ParsePattern__4qwd(TokenContext, ParentNode, "$Type$", ZTokenContext_Optional_Z53);
				if (ParamTypeNode == NULL) {
					return LeftTypeNode;
				};
				/*untyped*/NULL;
			};
			LeftTypeNode = ZTypeNode__4qyk(_NewZTypeNode199(), ParentNode, SourceToken, ZTypePool_GetGenericType__3qw6(LeftTypeNode->Type, TypeList, 1/*true*/));
		};
	};
	while (MatchToken__2qwd(TokenContext, "[")) {
		if (!MatchToken__2qwd(TokenContext, "]")) {
			return NULL;
		};
		LeftTypeNode = ZTypeNode__4qyk(_NewZTypeNode199(), ParentNode, SourceToken, ZTypePool_GetGenericType1__2qw6(ZTypeArrayType_Z13, LeftTypeNode->Type));
	};
	return LeftTypeNode;
}
static struct ZNode49 * SetIndexPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * IndexerNode = ZSetIndexNode__3qr8(_NewZSetIndexNode143(), ParentNode, LeftNode);
	IndexerNode = MatchToken__4qwd(TokenContext, IndexerNode, "[", ZTokenContext_Required_Z52);
	IndexerNode = MatchPattern__6qwd(TokenContext, IndexerNode, ZSetIndexNode_Index_Z26, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	IndexerNode = MatchToken__4qwd(TokenContext, IndexerNode, "]", ZTokenContext_Required_Z52);
	IndexerNode = MatchToken__4qwd(TokenContext, IndexerNode, "=", ZTokenContext_Required_Z52);
	IndexerNode = MatchPattern__5qwd(TokenContext, IndexerNode, ZSetIndexNode_Expr_Z27, "$Expression$", ZTokenContext_Required_Z52);
	return IndexerNode;
}
static struct ZNode49 * SetterPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * SetterNode = ZSetterNode__3qty(_NewZSetterNode149(), ParentNode, LeftNode);
	SetterNode = MatchToken__4qwd(TokenContext, SetterNode, ".", ZTokenContext_Required_Z52);
	SetterNode = MatchPattern__5qwd(TokenContext, SetterNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	SetterNode = MatchToken__4qwd(TokenContext, SetterNode, "=", ZTokenContext_Required_Z52);
	SetterNode = MatchPattern__5qwd(TokenContext, SetterNode, ZSetterNode_Expr_Z30, "$Expression$", ZTokenContext_Required_Z52);
	return SetterNode;
}
static struct ZNode49 * StatementEndPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	int ContextAllowance = SetParseFlag__2qwd(TokenContext, 0/*false*/);
	struct ZToken64 * Token = NULL;
	if (HasNext__1qwd(TokenContext)) {
		Token = GetToken__1qwd(TokenContext);
		if (!EqualsText__2qwb(Token, ";") && !IsIndent__1qwb(Token)) {
			(void)SetParseFlag__2qwd(TokenContext, ContextAllowance);
			return CreateExpectedErrorNode__3qwd(TokenContext, Token, ";");
		};
		MoveNext__1qwd(TokenContext);
		while (HasNext__1qwd(TokenContext)) {
			Token = GetToken__1qwd(TokenContext);
			if (!EqualsText__2qwb(Token, ";") && !IsIndent__1qwb(Token)) {
				break;
			};
			MoveNext__1qwd(TokenContext);
		};
	};
	(void)SetParseFlag__2qwd(TokenContext, ContextAllowance);
	return ZEmptyNode__3qpr(_NewZEmptyNode327(), ParentNode, Token);
}
static struct ZNode49 * StatementPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	int Rememberd = SetParseFlag__2qwd(TokenContext, ZTokenContext_AllowSkipIndent_Z54);
	(void)SetParseFlag__2qwd(TokenContext, ZTokenContext_NotAllowSkipIndent_Z55);
	struct ZNode49 * StmtNode = ExpressionPattern_DispatchPattern__5qws(ParentNode, TokenContext, NULL, 1/*true*/, 1/*true*/);
	StmtNode = MatchPattern__5qwd(TokenContext, StmtNode, ZNode_Nop_Z19, ";", ZTokenContext_Required_Z52);
	(void)SetParseFlag__2qwd(TokenContext, Rememberd);
	return StmtNode;
}
static struct ZNode49 * StringLiteralPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * Token = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	return ZStringNode__4q4b(_NewZStringNode424(), ParentNode, Token, LibZen_UnquoteString__1qqy(GetText__1qwb(Token)));
}
static int StringLiteralToken__1qw0(struct ZSourceContext46 * SourceContext) {
	long StartIndex = GetPosition__1qw0(SourceContext);
	MoveNext__1qw0(SourceContext);
	while (HasChar__1qw0(SourceContext)) {
		const char * ch = GetCurrentChar__1qw0(SourceContext);
		if (ch == "\"") {
			MoveNext__1qw0(SourceContext);
			Tokenize__4qw0(SourceContext, "$StringLiteral$", StartIndex, GetPosition__1qw0(SourceContext));
			return 1/*true*/;
		};
		if (ch == "\n") {
			break;
		};
		if (ch == "\\") {
			MoveNext__1qw0(SourceContext);
		};
		MoveNext__1qw0(SourceContext);
	};
	LogWarning__3qw0(SourceContext, StartIndex, "unclosed \"");
	Tokenize__4qw0(SourceContext, "$StringLiteral$", StartIndex, GetPosition__1qw0(SourceContext));
	return 0/*false*/;
}
static struct ZNode49 * SymbolExpressionPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * NameToken = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	if (IsToken__2qwd(TokenContext, "=")) {
		return ZErrorNode__4qpy(_NewZErrorNode329(), ParentNode, GetToken__1qwd(TokenContext), "assignment is not en expression");
	} else {
		return ZGetNameNode__4qpk(_NewZGetNameNode343(), ParentNode, NameToken, GetText__1qwb(NameToken));
	};
}
static struct ZNode49 * SymbolStatementPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * NameToken = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	if (MatchToken__2qwd(TokenContext, "=")) {
		struct ZNode49 * AssignedNode = ZSetNameNode__4qte(_NewZSetNameNode146(), ParentNode, NameToken, GetText__1qwb(NameToken));
		AssignedNode = MatchPattern__5qwd(TokenContext, AssignedNode, ZSetNameNode_Expr_Z28, "$Expression$", ZTokenContext_Required_Z52);
		return AssignedNode;
	} else {
		return ZGetNameNode__4qpk(_NewZGetNameNode343(), ParentNode, NameToken, GetText__1qwb(NameToken));
	};
}
static struct ZNode49 * ThrowPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * ThrowNode = ZThrowNode__2qta(_NewZThrowNode156(), ParentNode);
	ThrowNode = MatchToken__4qwd(TokenContext, ThrowNode, "throw", ZTokenContext_Required_Z52);
	ThrowNode = MatchPattern__5qwd(TokenContext, ThrowNode, ZThrowNode_Expr_Z32, "$Expression$", ZTokenContext_Required_Z52);
	return ThrowNode;
}
static struct ZNode49 * TruePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	return ZBooleanNode__4qsw(_NewZBooleanNode469(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57), 1/*true*/);
}
static struct ZNode49 * TryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * TryNode = ZTryNode__2qtf(_NewZTryNode159(), ParentNode);
	TryNode = MatchToken__4qwd(TokenContext, TryNode, "try", ZTokenContext_Required_Z52);
	TryNode = MatchPattern__5qwd(TokenContext, TryNode, ZTryNode_Try_Z33, "$Block$", ZTokenContext_Required_Z52);
	long count = 0;
	if (IsNewLineToken__2qwd(TokenContext, "catch")) {
		TryNode = MatchPattern__5qwd(TokenContext, TryNode, ZTryNode_Catch_Z34, "$Catch$", ZTokenContext_Required_Z52);
		count = count + 1;
	};
	if (MatchNewLineToken__2qwd(TokenContext, "finally")) {
		TryNode = MatchPattern__5qwd(TokenContext, TryNode, ZTryNode_Finally_Z35, "$Block$", ZTokenContext_Required_Z52);
		count = count + 1;
	};
	if (count == 0 && !IsErrorNode__1qws(TryNode)) {
		return Array<ZNode>GetIndex(ZTryNode_Try_Z33);
	};
	return TryNode;
}
static struct ZNode49 * TypeAnnotationPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	if (MatchToken__2qwd(TokenContext, ":")) {
		return ParsePattern__4qwd(TokenContext, ParentNode, "$Type$", ZTokenContext_Required_Z52);
	};
	return NULL;
}
static struct ZNode49 * TypePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZToken64 * Token = GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57);
	struct ZTypeNode199 * TypeNode = GetTypeNode__3qwi(GetNameSpace__1qws(ParentNode), GetText__1qwb(Token), Token);
	if (TypeNode != NULL) {
		return ParsePatternAfter__5qwd(TokenContext, ParentNode, TypeNode, "$TypeRight$", ZTokenContext_Optional_Z53);
	};
	return NULL;
}
static struct ZNode49 * UnaryPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * UnaryNode = ZUnaryNode__3qtj(_NewZUnaryNode162(), ParentNode, GetToken__2qwd(TokenContext, ZTokenContext_MoveNext_Z57));
	return MatchPattern__5qwd(TokenContext, UnaryNode, ZUnaryNode_Recv_Z36, "$RightExpression$", ZTokenContext_Required_Z52);
}
static struct ZNode49 * VarPattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * VarNode = ZVarNode__2qs7(_NewZVarNode499(), ParentNode);
	VarNode = MatchToken__4qwd(TokenContext, VarNode, "var", ZTokenContext_Required_Z52);
	VarNode = MatchPattern__5qwd(TokenContext, VarNode, ZNode_NameInfo_Z20, "$Name$", ZTokenContext_Required_Z52);
	VarNode = MatchPattern__5qwd(TokenContext, VarNode, ZNode_TypeInfo_Z21, "$TypeAnnotation$", ZTokenContext_Optional_Z53);
	VarNode = MatchToken__4qwd(TokenContext, VarNode, "=", ZTokenContext_Required_Z52);
	VarNode = MatchPattern__5qwd(TokenContext, VarNode, ZVarNode_InitValue_Z80, "$Expression$", ZTokenContext_Required_Z52);
	return VarNode;
}
static struct ZNode49 * WhilePattern__3qws(struct ZNode49 * ParentNode, struct ZTokenContext50 * TokenContext__1, struct ZNode49 * LeftNode__2) {
	struct ZNode49 * WhileNode = ZWhileNode__2qt9(_NewZWhileNode165(), ParentNode);
	WhileNode = MatchToken__4qwd(TokenContext, WhileNode, "while", ZTokenContext_Required_Z52);
	WhileNode = MatchToken__4qwd(TokenContext, WhileNode, "(", ZTokenContext_Required_Z52);
	WhileNode = MatchPattern__6qwd(TokenContext, WhileNode, ZWhileNode_Cond_Z37, "$Expression$", ZTokenContext_Required_Z52, ZTokenContext_AllowSkipIndent_Z54);
	WhileNode = MatchToken__4qwd(TokenContext, WhileNode, ")", ZTokenContext_Required_Z52);
	WhileNode = MatchPattern__5qwd(TokenContext, WhileNode, ZWhileNode_Block_Z38, "$Block$", ZTokenContext_Required_Z52);
	return WhileNode;
}
static int WhiteSpaceToken__1qw0(struct ZSourceContext46 * SourceContext) {
	SkipWhiteSpace__1qw0(SourceContext);
	return 1/*true*/;
}

