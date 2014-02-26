
var LibZen_GreekNames_Z0 = ["a", "b", "c"];
var ZType = (function() {
   function ZType(){
      this.TypeFlag = 0;
      this.TypeId = 0;
   }
   return ZType;
})();

var ZTypeUniqueTypeFlag_Z1 = 1 << 16;
var ZTypeUnboxTypeFlag_Z2 = 1 << 10;
var ZTypeOpenTypeFlag_Z3 = 1 << 9;
var ZTypeVarType_Z4 = ZType__4qwg(new ZType(), 1 << 16, "var", null);
var ZTypeVoidType_Z5 = ZType__4qwg(new ZType(), 1 << 16, "void", null);
var ZTypeBooleanType_Z6 = ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null));
var ZTypeIntType_Z7 = ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null));
var ZTypeFloatType_Z8 = ZType__4qwg(new ZType(), 1 << 16, "float", ZType__4qwg(new ZType(), 1 << 16, "var", null));
var ZTypeStringType_Z9 = ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null));
var ZTypeTypeType_Z10 = ZType__4qwg(new ZType(), 1 << 16, "Type", ZType__4qwg(new ZType(), 1 << 16, "var", null));
var ZClassField = (function() {
   function ZClassField(){
      this.FieldFlag = 0;
      this.FieldNativeIndex = 0;
   }
   return ZClassField;
})();

var __extends = this.__extends || function (d, b) {
   for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
   function __() { this.constructor = d; }
   __.prototype = b.prototype;
   d.prototype = new __();
};
var ZClassType = (function(_super) {
   __extends(ZClassType, _super);
   function ZClassType(){
      _super.call(this);
   }
   return ZClassType;
})(ZType);

var ZFunc = (function() {
   function ZFunc(){
      this.FuncFlag = 0;
   }
   return ZFunc;
})();

var ZFunc_NativeNameConnector_Z11 = "__";
var ZFunc_ConverterFunc_Z12 = 1 << 16;
var ZFunc_CoercionFunc_Z13 = (1 << 17) | (1 << 16);
var ZFuncType = (function(_super) {
   __extends(ZFuncType, _super);
   function ZFuncType(){
      _super.call(this);
      this.HasUnknownType = false;
      this.HasGreekType = false;
   }
   return ZFuncType;
})(ZType);

var ZFuncType_FuncType_Z14 = ZFuncType__3qe0(new ZFuncType(), "Func", null);
var ZGenericType = (function(_super) {
   __extends(ZGenericType, _super);
   function ZGenericType(){
      _super.call(this);
   }
   return ZGenericType;
})(ZType);

var ZGenericType_ArrayType_Z15 = ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null));
var ZGenericType_MapType_Z16 = ZGenericType__5qev(new ZGenericType(), 1 << 16, "Map", null, ZType__4qwg(new ZType(), 1 << 16, "var", null));
var ZGreekType = (function(_super) {
   __extends(ZGreekType, _super);
   function ZGreekType(){
      _super.call(this);
      this.GreekId = 0;
   }
   return ZGreekType;
})(ZType);

var ZPrototype = (function(_super) {
   __extends(ZPrototype, _super);
   function ZPrototype(){
      _super.call(this);
      this.DefinedCount = 0;
      this.UsedCount = 0;
   }
   return ZPrototype;
})(ZFunc);

var ZTypePool = (function() {
   function ZTypePool(){
   }
   return ZTypePool;
})();

var ZTypePool_TypeList_Z17 = [];
var ZTypePool_ClassNameMap_Z18 = LibZen.NewMap(0);
var ZTypePool_UniqueTypeSetMap_Z19 = LibZen.NewMap(0);
var ZVarScope = (function() {
   function ZVarScope(){
      this.VarNodeCount = 0;
      this.UnresolvedSymbolCount = 0;
   }
   return ZVarScope;
})();

var ZVarType = (function(_super) {
   __extends(ZVarType, _super);
   function ZVarType(){
      _super.call(this);
      this.GreekId = 0;
   }
   return ZVarType;
})(ZType);

var ZNode = (function() {
   function ZNode(){
      this.Type = ZType__4qwg(new ZType(), 1 << 16, "var", null);
      this.HasUntypedNode = true;
   }
   return ZNode;
})();

var ZNode_Nop_Z20 = -1;
var ZNode_NameInfo_Z21 = -2;
var ZNode_TypeInfo_Z22 = -3;
var ZNode_AppendIndex_Z23 = -4;
var ZNode_NestedAppendIndex_Z24 = -5;
var ZParamNode = (function(_super) {
   __extends(ZParamNode, _super);
   function ZParamNode(){
      _super.call(this);
      this.ParamIndex = 0;
   }
   return ZParamNode;
})(ZNode);

var ZReturnNode = (function(_super) {
   __extends(ZReturnNode, _super);
   function ZReturnNode(){
      _super.call(this);
   }
   return ZReturnNode;
})(ZNode);

var ZReturnNode_Expr_Z25 = 0;
var ZSetIndexNode = (function(_super) {
   __extends(ZSetIndexNode, _super);
   function ZSetIndexNode(){
      _super.call(this);
   }
   return ZSetIndexNode;
})(ZNode);

var ZSetIndexNode_Recv_Z26 = 0;
var ZSetIndexNode_Index_Z27 = 1;
var ZSetIndexNode_Expr_Z28 = 2;
var ZSetNameNode = (function(_super) {
   __extends(ZSetNameNode, _super);
   function ZSetNameNode(){
      _super.call(this);
      this.VarIndex = 0;
      this.IsCaptured = false;
   }
   return ZSetNameNode;
})(ZNode);

var ZSetNameNode_Expr_Z29 = 0;
var ZSetterNode = (function(_super) {
   __extends(ZSetterNode, _super);
   function ZSetterNode(){
      _super.call(this);
   }
   return ZSetterNode;
})(ZNode);

var ZSetterNode_Recv_Z30 = 0;
var ZSetterNode_Expr_Z31 = 1;
var ZSugarNode = (function(_super) {
   __extends(ZSugarNode, _super);
   function ZSugarNode(){
      _super.call(this);
   }
   return ZSugarNode;
})(ZNode);

var ZSugarNode_DeSugar_Z32 = 0;
var ZThrowNode = (function(_super) {
   __extends(ZThrowNode, _super);
   function ZThrowNode(){
      _super.call(this);
   }
   return ZThrowNode;
})(ZNode);

var ZThrowNode_Expr_Z33 = 0;
var ZTryNode = (function(_super) {
   __extends(ZTryNode, _super);
   function ZTryNode(){
      _super.call(this);
   }
   return ZTryNode;
})(ZNode);

var ZTryNode_Try_Z34 = 0;
var ZTryNode_Catch_Z35 = 1;
var ZTryNode_Finally_Z36 = 2;
var ZUnaryNode = (function(_super) {
   __extends(ZUnaryNode, _super);
   function ZUnaryNode(){
      _super.call(this);
   }
   return ZUnaryNode;
})(ZNode);

var ZUnaryNode_Recv_Z37 = 0;
var ZWhileNode = (function(_super) {
   __extends(ZWhileNode, _super);
   function ZWhileNode(){
      _super.call(this);
   }
   return ZWhileNode;
})(ZNode);

var ZWhileNode_Cond_Z38 = 0;
var ZWhileNode_Block_Z39 = 1;
var ZEmptyValue = (function() {
   function ZEmptyValue(){
   }
   return ZEmptyValue;
})();

var ZEmptyValue_TrueEmpty_Z40 = new ZEmptyValue();
var ZEmptyValue_FalseEmpty_Z41 = new ZEmptyValue();
var ZLogger = (function() {
   function ZLogger(){
      this.ReportedErrorList = [];
   }
   return ZLogger;
})();

var ZMacroFunc = (function(_super) {
   __extends(ZMacroFunc, _super);
   function ZMacroFunc(){
      _super.call(this);
   }
   return ZMacroFunc;
})(ZFunc);

var ZNameSpace = (function() {
   function ZNameSpace(){
      this.SerialId = 0;
   }
   return ZNameSpace;
})();

var ZParserConst = (function() {
   function ZParserConst(){
   }
   return ZParserConst;
})();

var ProgName_Z42 = "LibZen";
var CodeName_Z43 = "Reference Implementation of D-Script";
var MajorVersion_Z44 = 0;
var MinerVersion_Z45 = 1;
var PatchLevel_Z46 = 0;
var Version_Z47 = "0.1";
var Copyright_Z48 = "Copyright (c) 2013-2014, Konoha project authors";
var License_Z49 = "BSD-Style Open Source";
var ZSource = (function() {
   function ZSource(){
      this.LineNumber = 0;
   }
   return ZSource;
})();

var ZSourceBuilder = (function() {
   function ZSourceBuilder(){
      this.SourceList = [];
      this.IndentLevel = 0;
      this.CurrentIndentString = "";
      this.BufferedLineComment = "";
   }
   return ZSourceBuilder;
})();

var ZSourceContext = (function(_super) {
   __extends(ZSourceContext, _super);
   function ZSourceContext(){
      _super.call(this);
      this.SourcePosition = 0;
   }
   return ZSourceContext;
})(ZSource);

var ZSourceMacro = (function(_super) {
   __extends(ZSourceMacro, _super);
   function ZSourceMacro(){
      _super.call(this);
   }
   return ZSourceMacro;
})(ZMacroFunc);

var ZSymbolEntry = (function() {
   function ZSymbolEntry(){
      this.IsDisabled = false;
   }
   return ZSymbolEntry;
})();

var ZSyntax = (function() {
   function ZSyntax(){
      this.SyntaxFlag = 0;
      this.IsDisabled = false;
      this.IsStatement = false;
   }
   return ZSyntax;
})();

var ZSyntax_BinaryOperator_Z50 = 1;
var ZSyntax_LeftJoin_Z51 = 1 << 1;
var ZToken = (function() {
   function ZToken(){
      this.StartIndex = 0;
      this.EndIndex = 0;
   }
   return ZToken;
})();

var ZToken_NullToken_Z52 = ZToken__4qw3(new ZToken(), null, 0, 0);
var ZTokenContext = (function() {
   function ZTokenContext(){
      this.TokenList = [];
      this.CurrentPosition = 0;
      this.IsAllowSkipIndent = false;
   }
   return ZTokenContext;
})();

var ZTokenContext_Required_Z53 = true;
var ZTokenContext_Optional_Z54 = false;
var ZTokenContext_AllowSkipIndent_Z55 = true;
var ZTokenContext_NotAllowSkipIndent_Z56 = false;
var ZTokenContext_AllowNewLine_Z57 = true;
var ZTokenContext_MoveNext_Z58 = true;
var ZTokenFunc = (function() {
   function ZTokenFunc(){
   }
   return ZTokenFunc;
})();

var ZVariable = (function(_super) {
   __extends(ZVariable, _super);
   function ZVariable(){
      _super.call(this);
      this.VarFlag = 0;
      this.VarUniqueIndex = 0;
      this.DefCount = 0;
      this.UsedCount = 0;
   }
   return ZVariable;
})(ZSymbolEntry);

var ZVisitor = (function() {
   function ZVisitor(){
   }
   return ZVisitor;
})();

var ZArrayType = (function(_super) {
   __extends(ZArrayType, _super);
   function ZArrayType(){
      _super.call(this);
   }
   return ZArrayType;
})(ZGenericType);

var ZAnnotationNode = (function(_super) {
   __extends(ZAnnotationNode, _super);
   function ZAnnotationNode(){
      _super.call(this);
   }
   return ZAnnotationNode;
})(ZNode);

var ZAssertNode = (function(_super) {
   __extends(ZAssertNode, _super);
   function ZAssertNode(){
      _super.call(this);
   }
   return ZAssertNode;
})(ZNode);

var ZAssertNode_Expr_Z59 = 0;
var ZBinaryNode = (function(_super) {
   __extends(ZBinaryNode, _super);
   function ZBinaryNode(){
      _super.call(this);
   }
   return ZBinaryNode;
})(ZNode);

var ZBinaryNode_Left_Z60 = 0;
var ZBinaryNode_Right_Z61 = 1;
var ZBreakNode = (function(_super) {
   __extends(ZBreakNode, _super);
   function ZBreakNode(){
      _super.call(this);
   }
   return ZBreakNode;
})(ZNode);

var ZCastNode = (function(_super) {
   __extends(ZCastNode, _super);
   function ZCastNode(){
      _super.call(this);
   }
   return ZCastNode;
})(ZNode);

var ZCastNode_Expr_Z62 = 0;
var ZCatchNode = (function(_super) {
   __extends(ZCatchNode, _super);
   function ZCatchNode(){
      _super.call(this);
      this.ExceptionType = ZType__4qwg(new ZType(), 1 << 16, "var", null);
   }
   return ZCatchNode;
})(ZNode);

var ZCatchNode_Block_Z63 = 0;
var ZComparatorNode = (function(_super) {
   __extends(ZComparatorNode, _super);
   function ZComparatorNode(){
      _super.call(this);
   }
   return ZComparatorNode;
})(ZBinaryNode);

var ZConstNode = (function(_super) {
   __extends(ZConstNode, _super);
   function ZConstNode(){
      _super.call(this);
   }
   return ZConstNode;
})(ZNode);

var ZEmptyNode = (function(_super) {
   __extends(ZEmptyNode, _super);
   function ZEmptyNode(){
      _super.call(this);
   }
   return ZEmptyNode;
})(ZNode);

var ZErrorNode = (function(_super) {
   __extends(ZErrorNode, _super);
   function ZErrorNode(){
      _super.call(this);
   }
   return ZErrorNode;
})(ZConstNode);

var ZFieldNode = (function(_super) {
   __extends(ZFieldNode, _super);
   function ZFieldNode(){
      _super.call(this);
      this.DeclType = ZType__4qwg(new ZType(), 1 << 16, "var", null);
   }
   return ZFieldNode;
})(ZNode);

var ZFieldNode_InitValue_Z64 = 0;
var ZFloatNode = (function(_super) {
   __extends(ZFloatNode, _super);
   function ZFloatNode(){
      _super.call(this);
      this.FloatValue = 0.0;
   }
   return ZFloatNode;
})(ZConstNode);

var ZGetIndexNode = (function(_super) {
   __extends(ZGetIndexNode, _super);
   function ZGetIndexNode(){
      _super.call(this);
   }
   return ZGetIndexNode;
})(ZNode);

var ZGetIndexNode_Recv_Z65 = 0;
var ZGetIndexNode_Index_Z66 = 1;
var ZGetNameNode = (function(_super) {
   __extends(ZGetNameNode, _super);
   function ZGetNameNode(){
      _super.call(this);
      this.IsCaptured = false;
      this.VarIndex = 0;
   }
   return ZGetNameNode;
})(ZNode);

var ZGetterNode = (function(_super) {
   __extends(ZGetterNode, _super);
   function ZGetterNode(){
      _super.call(this);
   }
   return ZGetterNode;
})(ZNode);

var ZGetterNode_Recv_Z67 = 0;
var ZGlobalNameNode = (function(_super) {
   __extends(ZGlobalNameNode, _super);
   function ZGlobalNameNode(){
      _super.call(this);
      this.IsStaticFuncName = false;
   }
   return ZGlobalNameNode;
})(ZNode);

var ZGroupNode = (function(_super) {
   __extends(ZGroupNode, _super);
   function ZGroupNode(){
      _super.call(this);
   }
   return ZGroupNode;
})(ZNode);

var ZGroupNode_Expr_Z68 = 0;
var ZIfNode = (function(_super) {
   __extends(ZIfNode, _super);
   function ZIfNode(){
      _super.call(this);
   }
   return ZIfNode;
})(ZNode);

var ZIfNode_Cond_Z69 = 0;
var ZIfNode_Then_Z70 = 1;
var ZIfNode_Else_Z71 = 2;
var ZImportNode = (function(_super) {
   __extends(ZImportNode, _super);
   function ZImportNode(){
      _super.call(this);
   }
   return ZImportNode;
})(ZNode);

var ZInstanceOfNode = (function(_super) {
   __extends(ZInstanceOfNode, _super);
   function ZInstanceOfNode(){
      _super.call(this);
   }
   return ZInstanceOfNode;
})(ZNode);

var ZInstanceOfNode_Left_Z72 = 0;
var ZIntNode = (function(_super) {
   __extends(ZIntNode, _super);
   function ZIntNode(){
      _super.call(this);
      this.IntValue = 0;
   }
   return ZIntNode;
})(ZConstNode);

var ZLetNode = (function(_super) {
   __extends(ZLetNode, _super);
   function ZLetNode(){
      _super.call(this);
      this.SymbolType = ZType__4qwg(new ZType(), 1 << 16, "var", null);
   }
   return ZLetNode;
})(ZNode);

var ZLetNode_InitValue_Z73 = 0;
var ZListNode = (function(_super) {
   __extends(ZListNode, _super);
   function ZListNode(){
      _super.call(this);
      this.ListStartIndex = 0;
   }
   return ZListNode;
})(ZNode);

var ZMacroNode = (function(_super) {
   __extends(ZMacroNode, _super);
   function ZMacroNode(){
      _super.call(this);
   }
   return ZMacroNode;
})(ZListNode);

var ZMapEntryNode = (function(_super) {
   __extends(ZMapEntryNode, _super);
   function ZMapEntryNode(){
      _super.call(this);
   }
   return ZMapEntryNode;
})(ZNode);

var ZMapEntryNode_Key_Z74 = 0;
var ZMapEntryNode_Value_Z75 = 1;
var ZMapLiteralNode = (function(_super) {
   __extends(ZMapLiteralNode, _super);
   function ZMapLiteralNode(){
      _super.call(this);
   }
   return ZMapLiteralNode;
})(ZListNode);

var ZMethodCallNode = (function(_super) {
   __extends(ZMethodCallNode, _super);
   function ZMethodCallNode(){
      _super.call(this);
   }
   return ZMethodCallNode;
})(ZListNode);

var ZMethodCallNode_Recv_Z76 = 0;
var ZNewArrayNode = (function(_super) {
   __extends(ZNewArrayNode, _super);
   function ZNewArrayNode(){
      _super.call(this);
   }
   return ZNewArrayNode;
})(ZListNode);

var ZNewObjectNode = (function(_super) {
   __extends(ZNewObjectNode, _super);
   function ZNewObjectNode(){
      _super.call(this);
   }
   return ZNewObjectNode;
})(ZListNode);

var ZNotNode = (function(_super) {
   __extends(ZNotNode, _super);
   function ZNotNode(){
      _super.call(this);
   }
   return ZNotNode;
})(ZUnaryNode);

var ZNullNode = (function(_super) {
   __extends(ZNullNode, _super);
   function ZNullNode(){
      _super.call(this);
   }
   return ZNullNode;
})(ZConstNode);

var ZOrNode = (function(_super) {
   __extends(ZOrNode, _super);
   function ZOrNode(){
      _super.call(this);
   }
   return ZOrNode;
})(ZBinaryNode);

var ZPrototypeNode = (function(_super) {
   __extends(ZPrototypeNode, _super);
   function ZPrototypeNode(){
      _super.call(this);
      this.ReturnType = ZType__4qwg(new ZType(), 1 << 16, "var", null);
   }
   return ZPrototypeNode;
})(ZListNode);

var ZStringNode = (function(_super) {
   __extends(ZStringNode, _super);
   function ZStringNode(){
      _super.call(this);
   }
   return ZStringNode;
})(ZConstNode);

var ZStupidCastErrorNode = (function(_super) {
   __extends(ZStupidCastErrorNode, _super);
   function ZStupidCastErrorNode(){
      _super.call(this);
   }
   return ZStupidCastErrorNode;
})(ZErrorNode);

var ZTypeNode = (function(_super) {
   __extends(ZTypeNode, _super);
   function ZTypeNode(){
      _super.call(this);
   }
   return ZTypeNode;
})(ZConstNode);

var ZGenerator = (function(_super) {
   __extends(ZGenerator, _super);
   function ZGenerator(){
      _super.call(this);
      this.UniqueNumber = 0;
      this.DefinedFuncMap = LibZen.NewMap(0);
      this.StoppedVisitor = false;
   }
   return ZGenerator;
})(ZVisitor);

var ZIndentToken = (function(_super) {
   __extends(ZIndentToken, _super);
   function ZIndentToken(){
      _super.call(this);
   }
   return ZIndentToken;
})(ZToken);

var ZPatternToken = (function(_super) {
   __extends(ZPatternToken, _super);
   function ZPatternToken(){
      _super.call(this);
   }
   return ZPatternToken;
})(ZToken);

var ZSourceEngine = (function(_super) {
   __extends(ZSourceEngine, _super);
   function ZSourceEngine(){
      _super.call(this);
      this.InteractiveContext = false;
      this.IsVisitableFlag = true;
   }
   return ZSourceEngine;
})(ZVisitor);

var ZSourceGenerator = (function(_super) {
   __extends(ZSourceGenerator, _super);
   function ZSourceGenerator(){
      _super.call(this);
      this.NativeTypeMap = LibZen.NewMap(0);
      this.ReservedNameMap = LibZen.NewMap(0);
      this.BuilderList = [];
   }
   return ZSourceGenerator;
})(ZGenerator);

var ZTypeChecker = (function(_super) {
   __extends(ZTypeChecker, _super);
   function ZTypeChecker(){
      _super.call(this);
      this.StoppedVisitor = false;
   }
   return ZTypeChecker;
})(ZVisitor);

var ZTypeChecker_DefaultTypeCheckPolicy_Z77 = 0;
var ZTypeChecker_NoCheckPolicy_Z78 = 1;
var CSourceGenerator = (function(_super) {
   __extends(CSourceGenerator, _super);
   function CSourceGenerator(){
      _super.call(this);
   }
   return CSourceGenerator;
})(ZSourceGenerator);

var ZAndNode = (function(_super) {
   __extends(ZAndNode, _super);
   function ZAndNode(){
      _super.call(this);
   }
   return ZAndNode;
})(ZBinaryNode);

var ZArrayLiteralNode = (function(_super) {
   __extends(ZArrayLiteralNode, _super);
   function ZArrayLiteralNode(){
      _super.call(this);
   }
   return ZArrayLiteralNode;
})(ZListNode);

var ZBlockNode = (function(_super) {
   __extends(ZBlockNode, _super);
   function ZBlockNode(){
      _super.call(this);
   }
   return ZBlockNode;
})(ZListNode);

var ZBooleanNode = (function(_super) {
   __extends(ZBooleanNode, _super);
   function ZBooleanNode(){
      _super.call(this);
      this.BooleanValue = false;
   }
   return ZBooleanNode;
})(ZConstNode);

var ZClassNode = (function(_super) {
   __extends(ZClassNode, _super);
   function ZClassNode(){
      _super.call(this);
   }
   return ZClassNode;
})(ZListNode);

var ZFuncCallNode = (function(_super) {
   __extends(ZFuncCallNode, _super);
   function ZFuncCallNode(){
      _super.call(this);
   }
   return ZFuncCallNode;
})(ZListNode);

var ZFuncCallNode_Func_Z79 = 0;
var ZFunctionNode = (function(_super) {
   __extends(ZFunctionNode, _super);
   function ZFunctionNode(){
      _super.call(this);
      this.ReturnType = ZType__4qwg(new ZType(), 1 << 16, "var", null);
      this.VarIndex = 0;
   }
   return ZFunctionNode;
})(ZListNode);

var ZFunctionNode_Block_Z80 = 0;
var ZVarNode = (function(_super) {
   __extends(ZVarNode, _super);
   function ZVarNode(){
      _super.call(this);
      this.DeclType = ZType__4qwg(new ZType(), 1 << 16, "var", null);
   }
   return ZVarNode;
})(ZBlockNode);

var ZVarNode_InitValue_Z81 = 0;
var ZType__4qwg = (function (self, TypeFlag__1, ShortName__2, RefType__3) {
   self.TypeFlag = TypeFlag__1;
   self.ShortName = ShortName__2;
   self.RefType = RefType__3;
   if (LibZen.IsFlag(TypeFlag__1, 1 << 16)) {
      self.TypeId = ZTypePool_NewTypeId__1qwg(self);
   };
   return null;
});
ZType.prototype.ZType = ZType__4qwg;

var GetRealType__1qwg = (function (self) {
   return self;
});
ZType.prototype.GetRealType = GetRealType__1qwg;

var GetSuperType__1qwg = (function (self) {
   return self.RefType;
});
ZType.prototype.GetSuperType = GetSuperType__1qwg;

var GetBaseType__1qwg = (function (self) {
   return self;
});
ZType.prototype.GetBaseType = GetBaseType__1qwg;

var GetParamSize__1qwg = (function (self) {
   return 0;
});
ZType.prototype.GetParamSize = GetParamSize__1qwg;

var GetParamType__2qwg = (function (self, Index__1) {
   return ZType__4qwg(new ZType(), 1 << 16, "var", null);
});
ZType.prototype.GetParamType = GetParamType__2qwg;

var Equals__2qwg = (function (self, Type__1) {
   return (self.GetRealType(self) == Type__1.GetRealType(Type__1));
});
ZType.prototype.Equals = Equals__2qwg;

var Accept__2qwg = (function (self, Type__1) {
   var ThisType__2 = self.GetRealType(self);
   if (ThisType__2 == Type__1.GetRealType(Type__1)) {
      return true;
   };
   var SuperClass__3 = Type__1.GetSuperType(Type__1);
   while (SuperClass__3 != null) {
      if (SuperClass__3 == ThisType__2) {
         return true;
      };
      SuperClass__3 = SuperClass__3.GetSuperType(SuperClass__3);
   };
   return false;
});
ZType.prototype.Accept = Accept__2qwg;

var IsGreekType__1qwg = (function (self) {
   return false;
});
ZType.prototype.IsGreekType = IsGreekType__1qwg;

var GetGreekRealType__2qwg = (function (self, Greek__1) {
   return self.GetRealType(self);
});
ZType.prototype.GetGreekRealType = GetGreekRealType__2qwg;

var AcceptValueType__4qwg = (function (self, ValueType__1, ExactMatch__2, Greek__3) {
   if (self.GetRealType(self) != ValueType__1 && !ValueType__1.IsVarType(ValueType__1)) {
      if (ExactMatch__2 && !Accept__2qwg(self, ValueType__1)) {
         return false;
      };
   };
   return true;
});
ZType.prototype.AcceptValueType = AcceptValueType__4qwg;

var IsVoidType__1qwg = (function (self) {
   return (self.GetRealType(self) == ZType__4qwg(new ZType(), 1 << 16, "void", null));
});
ZType.prototype.IsVoidType = IsVoidType__1qwg;

var IsVarType__1qwg = (function (self) {
   return (self.GetRealType(self) == ZType__4qwg(new ZType(), 1 << 16, "var", null));
});
ZType.prototype.IsVarType = IsVarType__1qwg;

var IsInferrableType__1qwg = (function (self) {
   return (!self.IsVarType(self) && !IsVoidType__1qwg(self));
});
ZType.prototype.IsInferrableType = IsInferrableType__1qwg;

var IsTypeType__1qwg = (function (self) {
   return (self.GetRealType(self) == ZType__4qwg(new ZType(), 1 << 16, "Type", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
});
ZType.prototype.IsTypeType = IsTypeType__1qwg;

var IsBooleanType__1qwg = (function (self) {
   return (self.GetRealType(self) == ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
});
ZType.prototype.IsBooleanType = IsBooleanType__1qwg;

var IsIntType__1qwg = (function (self) {
   return (self.GetRealType(self) == ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
});
ZType.prototype.IsIntType = IsIntType__1qwg;

var IsFloatType__1qwg = (function (self) {
   return (self.GetRealType(self) == ZType__4qwg(new ZType(), 1 << 16, "float", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
});
ZType.prototype.IsFloatType = IsFloatType__1qwg;

var IsNumberType__1qwg = (function (self) {
   return (IsIntType__1qwg(self) || IsFloatType__1qwg(self));
});
ZType.prototype.IsNumberType = IsNumberType__1qwg;

var IsStringType__1qwg = (function (self) {
   return (self.GetRealType(self) == ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
});
ZType.prototype.IsStringType = IsStringType__1qwg;

var IsArrayType__1qwg = (function (self) {
   return (self.GetBaseType(self) == ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)));
});
ZType.prototype.IsArrayType = IsArrayType__1qwg;

var IsMapType__1qwg = (function (self) {
   return (self.GetBaseType(self) == ZGenericType__5qev(new ZGenericType(), 1 << 16, "Map", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)));
});
ZType.prototype.IsMapType = IsMapType__1qwg;

var IsOpenType__1qwg = (function (self) {
   return LibZen.IsFlag(self.TypeFlag, 1 << 9);
});
ZType.prototype.IsOpenType = IsOpenType__1qwg;

var IsImmutableType__1qwg = (function (self) {
   return false;
});
ZType.prototype.IsImmutableType = IsImmutableType__1qwg;

var IsNullableType__1qwg = (function (self) {
   return true;
});
ZType.prototype.IsNullableType = IsNullableType__1qwg;

var toString__1qwg = (function (self) {
   return self.ShortName;
});
ZType.prototype.toString = toString__1qwg;

var GetAsciiName__1qwg = (function (self) {
   return self.ShortName;
});
ZType.prototype.GetAsciiName = GetAsciiName__1qwg;

var StringfyClassMember__2qwg = (function (self, Name__1) {
   return (Name__1 + " of ") + self.ShortName;
});
ZType.prototype.StringfyClassMember = StringfyClassMember__2qwg;

var GetUniqueName__1qwg = (function (self) {
   return LibZen.Stringfy(self.TypeId);
});
ZType.prototype.GetUniqueName = GetUniqueName__1qwg;

var IsFuncType__1qwg = (function (self) {
   return ((self.GetRealType(self)).constructor.name == (ZFuncType).name);
});
ZType.prototype.IsFuncType = IsFuncType__1qwg;

var StringfySignature__2qwg = (function (self, FuncName__1) {
   return FuncName__1;
});
ZType.prototype.StringfySignature = StringfySignature__2qwg;

var Maybe__3qwg = (function (self, T__1, SourceToken__2) {
   return;
});
ZType.prototype.Maybe = Maybe__3qwg;

var ZClassField__5qw8 = (function (self, ClassType__1, FieldName__2, FieldType__3, SourceToken__4) {
   self.ClassType = ClassType__1;
   self.FieldType = FieldType__3;
   self.FieldName = FieldName__2;
   self.SourceToken = SourceToken__4;
   return null;
});
ZClassField.prototype.ZClassField = ZClassField__5qw8;

var ZClassType__3qeq = (function (self, ShortName__1, RefType__2) {
   ZType__4qwg(self, (1 << 9) | (1 << 16), ShortName__1, RefType__2);
   if ((RefType__2).constructor.name == (ZClassType).name) {
      ResetSuperType__2qeq(self, RefType__2);
   };
   return null;
});
ZClassType.prototype.ZClassType = ZClassType__3qeq;

var ResetSuperType__2qeq = (function (self, SuperClass__1) {
   self.RefType = SuperClass__1;
   if (SuperClass__1.FieldList != null) {
      self.FieldList = [];
      var i__2 = 0;
      while (i__2 < (SuperClass__1.FieldList).length) {
         var Field__3 = SuperClass__1.FieldList[i__2];
         self.FieldList.push(Field__3);
         i__2 = i__2 + 1;
      };
   };
   return;
});
ZClassType.prototype.ResetSuperType = ResetSuperType__2qeq;

var GetFieldSize__1qeq = (function (self) {
   if (self.FieldList != null) {
      return (self.FieldList).length;
   };
   return 0;
});
ZClassType.prototype.GetFieldSize = GetFieldSize__1qeq;

var GetFieldAt__2qeq = (function (self, Index__1) {
   return self.FieldList[Index__1];
});
ZClassType.prototype.GetFieldAt = GetFieldAt__2qeq;

var HasField__2qeq = (function (self, FieldName__1) {
   if (self.FieldList != null) {
      var i__3 = 0;
      while (i__2 < (self.FieldList).length) {
         if (FieldName__1.equals(self.FieldList[i].FieldName)) {
            return true;
         };
         i__2 = i__2 + 1;
      };
   };
   return false;
});
ZClassType.prototype.HasField = HasField__2qeq;

var GetFieldType__3qeq = (function (self, FieldName__1, DefaultType__2) {
   if (self.FieldList != null) {
      var i__5 = 0;
      while (i__3 < (self.FieldList).length) {
         var Field__6 = self.FieldList[i__3];
         if (FieldName__1.equals(Field.FieldName)) {
            return Field__4.FieldType;
         };
         i__3 = i__3 + 1;
      };
   };
   return DefaultType__2;
});
ZClassType.prototype.GetFieldType = GetFieldType__3qeq;

var AppendField__4qeq = (function (self, FieldType__1, FieldName__2, SourceToken__3) {
   console.assert(!FieldType__1.IsVarType(FieldType__1), "(libzen/libzen.zen:1483)");
   if (self.FieldList == null) {
      self.FieldList = [];
   };
   var ClassField__4 = ZClassField__5qw8(new ZClassField(), self, FieldName__2, FieldType__1, SourceToken__3);
   self.FieldList.push(ClassField__4);
   return ClassField__4;
});
ZClassType.prototype.AppendField = AppendField__4qeq;

var ZFunc_StringfySignature__3qqy = (function (FuncName, FuncParamSize__1, RecvType__2) {
   return ((FuncName + "__") + (FuncParamSize__1).toString()) + GetUniqueName__1qwg(RecvType__2);
});
String.prototype.ZFunc_StringfySignature = ZFunc_StringfySignature__3qqy;

var ZFunc__4qep = (function (self, FuncFlag__1, FuncName__2, FuncType__3) {
   self.FuncFlag = FuncFlag__1;
   self.FuncName = FuncName__2;
   self.FuncType = FuncType__3;
   return null;
});
ZFunc.prototype.ZFunc = ZFunc__4qep;

var GetFuncType__1qep = (function (self) {
   return self.FuncType;
});
ZFunc.prototype.GetFuncType = GetFuncType__1qep;

var toString__1qep = (function (self) {
   return (self.FuncName + ": ") + toString__1qwg(self.FuncType);
});
ZFunc.prototype.toString = toString__1qep;

var IsConverterFunc__1qep = (function (self) {
   return LibZen.IsFlag(self.FuncFlag, 1 << 16);
});
ZFunc.prototype.IsConverterFunc = IsConverterFunc__1qep;

var IsCoercionFunc__1qep = (function (self) {
   return LibZen.IsFlag(self.FuncFlag, (1 << 17) | 1 << 16);
});
ZFunc.prototype.IsCoercionFunc = IsCoercionFunc__1qep;

var Is__2qep = (function (self, Flag__1) {
   return LibZen.IsFlag(self.FuncFlag, Flag__1);
});
ZFunc.prototype.Is = Is__2qep;

var GetSignature__1qep = (function (self) {
   return StringfySignature__2qe0(self.FuncType, self.FuncName);
});
ZFunc.prototype.GetSignature = GetSignature__1qep;

var ZFuncType__3qe0 = (function (self, ShortName__1, UniqueTypeParams__2) {
   ZType__4qwg(self, 1 << 16, ShortName__1, ZType__4qwg(new ZType(), 1 << 16, "var", null));
   if (UniqueTypeParams__2 == null) {
      self.TypeParams = LibZen.NewTypeArray(1);
      self.TypeParams[0] = ZType__4qwg(new ZType(), 1 << 16, "var", null);
   } else {
      self.TypeParams = UniqueTypeParams__2;
   };
   var i__4 = 0;
   while (i__3 < (self.TypeParams).length) {
      if (self.TypeParams[i__3].IsVarType(self.TypeParams[i__3])) {
         self.HasUnknownType = true;
      };
      if (self.TypeParams[i__3].IsGreekType(self.TypeParams[i__3])) {
         self.HasGreekType = true;
      };
      i__3 = i__3 + 1;
   };
   return null;
});
ZFuncType.prototype.ZFuncType = ZFuncType__3qe0;

var IsFuncType__1qe0 = (function (self) {
   return true;
});
ZFuncType.prototype.IsFuncType = IsFuncType__1qe0;

var IsVarType__1qe0 = (function (self) {
   return self.HasUnknownType;
});
ZFuncType.prototype.IsVarType = IsVarType__1qe0;

var IsGreekType__1qe0 = (function (self) {
   return self.HasGreekType;
});
ZFuncType.prototype.IsGreekType = IsGreekType__1qe0;

var GetGreekRealType__2qe0 = (function (self, Greek__1) {
   if (self.HasGreekType) {
      var TypeList__4 = [];
      var i__5 = 0;
      while (i__3 < (self.TypeParams).length) {
         TypeList__2.push(self.TypeParams[i__3].GetGreekRealType(self.TypeParams[i__3], Greek__1));
         i__3 = i__3 + 1;
      };
      return ZTypePool_LookupFuncType__1qwh(TypeList__2);
   };
   return self;
});
ZFuncType.prototype.GetGreekRealType = GetGreekRealType__2qe0;

var AcceptValueType__4qe0 = (function (self, ValueType__1, ExactMatch__2, Greek__3) {
   if (IsFuncType__1qwg(ValueType__1) && ValueType__1.GetParamSize(ValueType__1) == self.GetParamSize(self)) {
      var i__4 = 0;
      while (i__4 < (self.TypeParams).length) {
         if (!self.TypeParams[i__4].AcceptValueType(self.TypeParams[i__4], ValueType__1.GetParamType(ValueType__1, i__4), true, Greek__3)) {
            return false;
         };
         i__4 = i__4 + 1;
      };
      return true;
   };
   return false;
});
ZFuncType.prototype.AcceptValueType = AcceptValueType__4qe0;

var StringfySignature__2qe0 = (function (self, FuncName__1) {
   return ZFunc_StringfySignature__3qqy(FuncName__1, GetFuncParamSize__1qe0(self), GetRecvType__1qe0(self));
});
ZFuncType.prototype.StringfySignature = StringfySignature__2qe0;

var GetBaseType__1qe0 = (function (self) {
   return ZFuncType__3qe0(new ZFuncType(), "Func", null);
});
ZFuncType.prototype.GetBaseType = GetBaseType__1qe0;

var GetParamSize__1qe0 = (function (self) {
   return (self.TypeParams).length;
});
ZFuncType.prototype.GetParamSize = GetParamSize__1qe0;

var GetParamType__2qe0 = (function (self, Index__1) {
   return self.TypeParams[Index__1];
});
ZFuncType.prototype.GetParamType = GetParamType__2qe0;

var GetReturnType__1qe0 = (function (self) {
   return self.TypeParams[0];
});
ZFuncType.prototype.GetReturnType = GetReturnType__1qe0;

var GetFuncParamSize__1qe0 = (function (self) {
   return (self.TypeParams).length - 1;
});
ZFuncType.prototype.GetFuncParamSize = GetFuncParamSize__1qe0;

var GetRecvType__1qe0 = (function (self) {
   if ((self.TypeParams).length == 1) {
      return ZType__4qwg(new ZType(), 1 << 16, "void", null);
   };
   return self.TypeParams[1];
});
ZFuncType.prototype.GetRecvType = GetRecvType__1qe0;

var GetFuncParamType__2qe0 = (function (self, Index__1) {
   return self.TypeParams[Index__1 + 1];
});
ZFuncType.prototype.GetFuncParamType = GetFuncParamType__2qe0;

var NewMethodFuncType__2qe0 = (function (self, RecvType__1) {
   var TypeList__2 = [];
   TypeList__2.push(GetReturnType__1qe0(self));
   TypeList__2.push(RecvType__1);
   var i__3 = 0;
   while (i__3 < GetFuncParamSize__1qe0(self)) {
      TypeList__2.push(GetFuncParamType__2qe0(self, i__3));
      i__3 = i__3 + 1;
   };
   return ZTypePool_LookupFuncType__1qwh(TypeList__2);
});
ZFuncType.prototype.NewMethodFuncType = NewMethodFuncType__2qe0;

var AcceptAsFieldFunc__2qe0 = (function (self, FuncType__1) {
   if (GetFuncParamSize__1qe0(FuncType__1) == GetFuncParamSize__1qe0(self) && Equals__2qwg(GetReturnType__1qe0(FuncType__1), GetReturnType__1qe0(self))) {
      var i__2 = 1;
      while (i__2 < GetFuncParamSize__1qe0(FuncType__1)) {
         if (!Equals__2qwg(GetFuncParamType__2qe0(FuncType__1, i__2), GetFuncParamType__2qe0(self, i__2))) {
            return false;
         };
         i__2 = i__2 + 1;
      };
   };
   return true;
});
ZFuncType.prototype.AcceptAsFieldFunc = AcceptAsFieldFunc__2qe0;

var ZGenericType__5qev = (function (self, TypeFlag__1, ShortName__2, BaseType__3, ParamType__4) {
   ZType__4qwg(self, TypeFlag__1, ShortName__2, ZType__4qwg(new ZType(), 1 << 16, "var", null));
   self.BaseType = BaseType__3;
   if (self.BaseType == null) {
      self.BaseType = self;
   };
   self.ParamType = ParamType__4;
   return null;
});
ZGenericType.prototype.ZGenericType = ZGenericType__5qev;

var GetSuperType__1qev = (function (self) {
   if (self.BaseType == self) {
      return self.RefType;
   };
   return self.BaseType;
});
ZGenericType.prototype.GetSuperType = GetSuperType__1qev;

var GetBaseType__1qev = (function (self) {
   return self.BaseType;
});
ZGenericType.prototype.GetBaseType = GetBaseType__1qev;

var GetParamSize__1qev = (function (self) {
   return 1;
});
ZGenericType.prototype.GetParamSize = GetParamSize__1qev;

var GetParamType__2qev = (function (self, Index__1) {
   if (Index__1 == 0) {
      return self.ParamType;
   };
   return null;
});
ZGenericType.prototype.GetParamType = GetParamType__2qev;

var IsGreekType__1qev = (function (self) {
   return (self.ParamType.IsGreekType(self.ParamType));
});
ZGenericType.prototype.IsGreekType = IsGreekType__1qev;

var GetGreekRealType__2qev = (function (self, Greek__1) {
   if (self.ParamType.IsGreekType(self.ParamType)) {
      return ZTypePool_GetGenericType1__2qwg(self.BaseType, self.ParamType.GetGreekRealType(self.ParamType, Greek__1));
   };
   return self.GetRealType(self);
});
ZGenericType.prototype.GetGreekRealType = GetGreekRealType__2qev;

var AcceptValueType__4qev = (function (self, ValueType__1, ExactMatch__2, Greek__3) {
   if (self.BaseType == ValueType__1.GetBaseType(ValueType__1) && ValueType__1.GetParamSize(ValueType__1) == 1) {
      return self.ParamType.AcceptValueType(self.ParamType, ValueType__1.GetParamType(ValueType__1, 0), true, Greek__3);
   };
   return false;
});
ZGenericType.prototype.AcceptValueType = AcceptValueType__4qev;

var ZGreekType_NewGreekTypes__1qwh = (function (GreekTypes) {
   if (GreekTypes == null) {
      return LibZen.NewTypeArray((["a", "b", "c"]).length);
   } else {
      var i__1 = 0;
      while (i__1 < (GreekTypes).length) {
         GreekTypes[i__1] = null;
         i__1 = i__1 + 1;
      };
      return GreekTypes;
   };
});
Array<ZType>.prototype.ZGreekType_NewGreekTypes = ZGreekType_NewGreekTypes__1qwh;

var ZGreekType__2qe8 = (function (self, GreekId__1) {
   ZType__4qwg(self, 1 << 16, ["a", "b", "c"][GreekId__1], ZType__4qwg(new ZType(), 1 << 16, "var", null));
   self.GreekId = GreekId__1;
   return null;
});
ZGreekType.prototype.ZGreekType = ZGreekType__2qe8;

var IsGreekType__1qe8 = (function (self) {
   return true;
});
ZGreekType.prototype.IsGreekType = IsGreekType__1qe8;

var GetGreekRealType__2qe8 = (function (self, Greek__1) {
   if (Greek__1[self.GreekId] == null) {
      return ZType__4qwg(new ZType(), 1 << 16, "var", null);
   };
   return Greek__1[self.GreekId];
});
ZGreekType.prototype.GetGreekRealType = GetGreekRealType__2qe8;

var AcceptValueType__4qe8 = (function (self, ValueType__1, ExactMatch__2, Greek__3) {
   if (Greek__3[self.GreekId] == null) {
      if (ValueType__1.IsVarType(ValueType__1)) {
         return true;
      };
      Greek__3[self.GreekId] = ValueType__1;
      return true;
   } else {
      return Greek__3[self.GreekId].AcceptValueType(Greek__3[self.GreekId], ValueType__1, ExactMatch__2, Greek__3);
   };
});
ZGreekType.prototype.AcceptValueType = AcceptValueType__4qe8;

var ZPrototype__5qry = (function (self, FuncFlag__1, FuncName__2, FuncType__3, SourceToken__4) {
   ZFunc__4qep(self, FuncFlag__1, FuncName__2, FuncType__3);
   self.DefinedCount = 0;
   self.UsedCount = 0;
   return null;
});
ZPrototype.prototype.ZPrototype = ZPrototype__5qry;

var Used__1qry = (function (self) {
   self.UsedCount = self.UsedCount + 1;
   return;
});
ZPrototype.prototype.Used = Used__1qry;

var Defined__1qry = (function (self) {
   self.DefinedCount = self.DefinedCount + 1;
   return;
});
ZPrototype.prototype.Defined = Defined__1qry;

var ZTypePool_NewTypeId__1qwg = (function (T) {
   var TypeId__1 = ([]).length;
   [].push(T);
   return TypeId__1;
});
ZType.prototype.ZTypePool_NewTypeId = ZTypePool_NewTypeId__1qwg;

var TypeOf__1qqr = (function (TypeId) {
   if (TypeId == 0) {
      return ZType__4qwg(new ZType(), 1 << 16, "var", null);
   };
   if (TypeId < ([]).length) {
      return [][TypeId];
   };
   return ZType__4qwg(new ZType(), 1 << 16, "var", null);
});
int.prototype.TypeOf = TypeOf__1qqr;

var ZTypePool_MangleType2__2qwg = (function (Type1, Type2__1) {
   return ((":" + (Type1.TypeId).toString()) + ":") + (Type2__1.TypeId).toString();
});
ZType.prototype.ZTypePool_MangleType2 = ZTypePool_MangleType2__2qwg;

var ZTypePool_MangleTypes__1qwh = (function (TypeList) {
   var s__1 = "";
   var i__2 = 0;
   while (i__2 < (TypeList).length) {
      var Type__3 = TypeList[i__2];
      s__1 = (s__1 + ":") + (Type__3.TypeId).toString();
      i__2 = i__2 + 1;
   };
   return s__1;
});
Array<ZType>.prototype.ZTypePool_MangleTypes = ZTypePool_MangleTypes__1qwh;

var ZTypePool_UniqueTypes__1qwh = (function (TypeList) {
   var MangleName__1 = "[]" + ZTypePool_MangleTypes__1qwh(TypeList);
   var Types__2 = LibZen.NewMap(0)[MangleName__1];
   if (Types__2 == null) {
      Types__2 = TypeList;
      LibZen.NewMap(0)[MangleName__1] = Types__2;
   };
   return Types__2;
});
Array<ZType>.prototype.ZTypePool_UniqueTypes = ZTypePool_UniqueTypes__1qwh;

var ZTypePool_GetGenericType1__2qwg = (function (BaseType, ParamType__1) {
   var MangleName__2 = ZTypePool_MangleType2__2qwg(BaseType, ParamType__1);
   var GenericType__3 = LibZen.NewMap(0)[MangleName__2];
   if (GenericType__3 == null) {
      var Name__4 = ((BaseType.ShortName + "<") + toString__1qwg(ParamType__1)) + ">";
      if (IsArrayType__1qwg(BaseType)) {
         Name__4 = ((BaseType.ShortName + "<") + toString__1qwg(ParamType__1)) + ">";
      };
      GenericType__3 = ZGenericType__5qev(new ZGenericType(), 1 << 16, Name__4, BaseType, ParamType__1);
      LibZen.NewMap(0)[MangleName__2] = GenericType__3;
   };
   return GenericType__3;
});
ZType.prototype.ZTypePool_GetGenericType1 = ZTypePool_GetGenericType1__2qwg;

var ZTypePool_GetGenericType__3qwg = (function (BaseType, TypeList__1, IsCreation__2) {
   console.assert(BaseType.GetParamSize(BaseType) > 0, "(libzen/libzen.zen:1800)");
   if ((TypeList__1).length == 1 && !IsFuncType__1qwg(BaseType)) {
      return ZTypePool_GetGenericType1__2qwg(BaseType, TypeList__1[0]);
   };
   var MangleName__7 = (":" + (BaseType.TypeId).toString()) + ZTypePool_MangleTypes__1qwh(TypeList__1);
   var GenericType__8 = LibZen.NewMap(0)[MangleName__3];
   if ((GenericType__4 == null) && IsCreation__2) {
      var ShortName__9 = BaseType.ShortName + "<";
      var i__10 = 0;
      while (i__6 < (TypeList__1).length) {
         ShortName__9 = ShortName__5 + TypeList__1[i__6].GetRealType(TypeList__1[i__6]).ShortName;
         if ((i__6 + 1) == (TypeList__1).length) {
            ShortName__5 = ShortName__5 + ">";
         } else {
            ShortName__5 = ShortName__5 + ",";
         };
         i__6 = i__6 + 1;
      };
      if (IsFuncType__1qwg(BaseType)) {
         GenericType__4 = ZFuncType__3qe0(new ZFuncType(), ShortName__5, ZTypePool_UniqueTypes__1qwh(TypeList__1));
      } else {
      };
      LibZen.NewMap(0)[MangleName__3] = GenericType__4;
   };
   return GenericType__4;
});
ZType.prototype.ZTypePool_GetGenericType = ZTypePool_GetGenericType__3qwg;

var ZTypePool_LookupFuncType__1qwh = (function (TypeList) {
   var FuncType__1 = ZTypePool_GetGenericType__3qwg(ZFuncType__3qe0(new ZFuncType(), "Func", null), TypeList, true);
   if ((FuncType__1).constructor.name == (ZFuncType).name) {
      return FuncType__1;
   };
   return null;
});
Array<ZType>.prototype.ZTypePool_LookupFuncType = ZTypePool_LookupFuncType__1qwh;

var ZTypePool_LookupFuncType__1qwg = (function (R) {
   var TypeList__1 = [];
   TypeList__1.push(R);
   return ZTypePool_LookupFuncType__1qwh(TypeList__1);
});
ZType.prototype.ZTypePool_LookupFuncType = ZTypePool_LookupFuncType__1qwg;

var ZTypePool_LookupFuncType__2qwg = (function (R, P1__1) {
   var TypeList__2 = [];
   TypeList__2.push(R);
   TypeList__2.push(P1__1);
   return ZTypePool_LookupFuncType__1qwh(TypeList__2);
});
ZType.prototype.ZTypePool_LookupFuncType = ZTypePool_LookupFuncType__2qwg;

var ZTypePool_LookupFuncType__3qwg = (function (R, P1__1, P2__2) {
   var TypeList__3 = [];
   TypeList__3.push(R);
   TypeList__3.push(P1__1);
   TypeList__3.push(P2__2);
   return ZTypePool_LookupFuncType__1qwh(TypeList__3);
});
ZType.prototype.ZTypePool_LookupFuncType = ZTypePool_LookupFuncType__3qwg;

var ZTypePool_LookupFuncType__4qwg = (function (R, P1__1, P2__2, P3__3) {
   var TypeList__4 = [];
   TypeList__4.push(R);
   TypeList__4.push(P1__1);
   TypeList__4.push(P2__2);
   TypeList__4.push(P3__3);
   return ZTypePool_LookupFuncType__1qwh(TypeList__4);
});
ZType.prototype.ZTypePool_LookupFuncType = ZTypePool_LookupFuncType__4qwg;

var ZVarScope__4qrj = (function (self, Parent__1, Logger__2, VarList__3) {
   self.Parent = Parent__1;
   self.Logger = Logger__2;
   self.VarList = VarList__3;
   if (self.VarList == null) {
      self.VarList = [];
   };
   return null;
});
ZVarScope.prototype.ZVarScope = ZVarScope__4qrj;

var NewVarType__4qrj = (function (self, VarType__1, Name__2, SourceToken__3) {
   if (!((VarType__1).constructor.name == (ZVarType).name) && VarType__1.IsVarType(VarType__1)) {
      VarType__1 = ZVarType__4qrl(new ZVarType(), self.VarList, Name__2, SourceToken__3);
   };
   return VarType__1;
});
ZVarScope.prototype.NewVarType = NewVarType__4qrj;

var FoundUnresolvedSymbol__2qrj = (function (self, FuncName__1) {
   self.UnresolvedSymbolCount = self.UnresolvedSymbolCount + 1;
   return;
});
ZVarScope.prototype.FoundUnresolvedSymbol = FoundUnresolvedSymbol__2qrj;

var CheckVarNode__3qrj = (function (self, ContextType__1, Node__2) {
   if (IsUntyped__1qwo(Node__2)) {
      self.VarNodeCount = self.VarNodeCount + 1;
   };
   if (IsInferrableType__1qwg(ContextType__1) && (Node__2.Type).constructor.name == (ZVarType).name) {
      Infer__3qrl((Node__2.Type), ContextType__1, Node__2.SourceToken);
      Node__2.Type = ContextType__1;
   };
   if ((ContextType__1).constructor.name == (ZVarType).name && !IsUntyped__1qwo(Node__2)) {
      Infer__3qrl((ContextType__1), Node__2.Type, Node__2.SourceToken);
   };
   return;
});
ZVarScope.prototype.CheckVarNode = CheckVarNode__3qrj;

var TypeCheckStmtList__3qrj = (function (self, TypeSafer__1, StmtList__2) {
   var PrevCount__3 = -1;
   while (true) {
      var i__4 = 0;
      self.VarNodeCount = 0;
      self.UnresolvedSymbolCount = 0;
      while (i__4 < (StmtList__2).length) {
         StmtList__2[i__4] = CheckType__3qrc(TypeSafer__1, StmtList__2[i__4], ZType__4qwg(new ZType(), 1 << 16, "void", null));
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
});
ZVarScope.prototype.TypeCheckStmtList = TypeCheckStmtList__3qrj;

var TypeCheckFuncBlock__3qrj = (function (self, TypeSafer__1, FunctionNode__2) {
   var PrevCount__3 = -1;
   while (true) {
      self.VarNodeCount = 0;
      self.UnresolvedSymbolCount = 0;
      TypeSafer__1.DefineFunction(TypeSafer__1, FunctionNode__2, false);
      FunctionNode__2.AST[0] = CheckType__3qrc(TypeSafer__1, FunctionNode__2.AST[0], ZType__4qwg(new ZType(), 1 << 16, "void", null));
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
});
ZVarScope.prototype.TypeCheckFuncBlock = TypeCheckFuncBlock__3qrj;

var ZVarType__4qrl = (function (self, VarList__1, Name__2, SourceToken__3) {
   ZType__4qwg(self, 0, Name__2, ZType__4qwg(new ZType(), 1 << 16, "var", null));
   self.VarList = VarList__1;
   self.SourceToken = SourceToken__3;
   self.GreekId = (VarList__1).length;
   VarList__1.push(self);
   self.TypeId = self.RefType.TypeId;
   return null;
});
ZVarType.prototype.ZVarType = ZVarType__4qrl;

var GetRealType__1qrl = (function (self) {
   return self.RefType;
});
ZVarType.prototype.GetRealType = GetRealType__1qrl;

var GetParamSize__1qrl = (function (self) {
   return self.RefType.GetParamSize(self.RefType);
});
ZVarType.prototype.GetParamSize = GetParamSize__1qrl;

var GetParamType__2qrl = (function (self, Index__1) {
   return self.RefType.GetParamType(self.RefType, Index__1);
});
ZVarType.prototype.GetParamType = GetParamType__2qrl;

var IsFuncType__1qrl = (function (self) {
   return IsFuncType__1qwg(self.RefType);
});
ZVarType.prototype.IsFuncType = IsFuncType__1qrl;

var IsVarType__1qrl = (function (self) {
   return self.RefType.IsVarType(self.RefType);
});
ZVarType.prototype.IsVarType = IsVarType__1qrl;

var Infer__3qrl = (function (self, ContextType__1, SourceToken__2) {
   if (self.RefType.IsVarType(self.RefType)) {
      if ((ContextType__1).constructor.name == (ZVarType).name && ContextType__1.IsVarType(ContextType__1)) {
         var VarType__3 = ContextType__1;
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
});
ZVarType.prototype.Infer = Infer__3qrl;

var Maybe__3qrl = (function (self, T__1, SourceToken__2) {
   if (self.RefType.IsVarType(self.RefType)) {
      if ((T__1).constructor.name == (ZVarType).name && T__1.IsVarType(T__1)) {
         var VarType__3 = T__1;
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
});
ZVarType.prototype.Maybe = Maybe__3qrl;

var ZNode__4qwo = (function (self, ParentNode__1, SourceToken__2, Size__3) {
   console.assert(self != ParentNode__1, "(libzen/libzen.zen:2008)");
   self.ParentNode = ParentNode__1;
   self.SourceToken = SourceToken__2;
   if (Size__3 > 0) {
      self.AST = LibZen.NewNodeArray(Size__3);
   } else {
      self.AST = null;
   };
   return null;
});
ZNode.prototype.ZNode = ZNode__4qwo;

var SetChild__2qwo = (function (self, Node__1) {
   console.assert(Node__1 != null, "(libzen/libzen.zen:2020)");
   if (Node__1 != null) {
      console.assert(self != Node__1, "(libzen/libzen.zen:2022)");
      Node__1.ParentNode = self;
   };
   return Node__1;
});
ZNode.prototype.SetChild = SetChild__2qwo;

var SetNameInfo__3qwo = (function (self, NameToken__1, Name__2) {
   console.assert(Name__2 == null, "(libzen/libzen.zen:2029)");
   return;
});
ZNode.prototype.SetNameInfo = SetNameInfo__3qwo;

var SetTypeInfo__3qwo = (function (self, TypeToken__1, Type__2) {
   self.Type = Type__2;
   return;
});
ZNode.prototype.SetTypeInfo = SetTypeInfo__3qwo;

var Set__3qwo = (function (self, Index__1, Node__2) {
   if (Index__1 >= 0) {
      self.AST[Index__1] = SetChild__2qwo(self, Node__2);
   } else if (Index__1 == -4) {
      var ListNode__3 = self;
      if ((ListNode__3).constructor.name == (ZListNode).name) {
         Append__2quv((ListNode__3), Node__2);
      } else {
         console.assert((ListNode__3).constructor.name == (ZListNode).name, "(libzen/libzen.zen:2046)");
      };
   } else if (Index__1 == -2) {
      self.SetNameInfo(self, Node__2.SourceToken, GetText__1qw3(Node__2.SourceToken));
      self.SourceToken = Node__2.SourceToken;
      return;
   } else if (Index__1 == -3) {
      self.SetTypeInfo(self, Node__2.SourceToken, Node__2.Type);
      return;
   };
   return;
});
ZNode.prototype.Set = Set__3qwo;

var GetAstSize__1qwo = (function (self) {
   if (self.AST == null) {
      return 0;
   };
   return (self.AST).length;
});
ZNode.prototype.GetAstSize = GetAstSize__1qwo;

var HasAst__2qwo = (function (self, Index__1) {
   if (self.AST != null && Index__1 < (self.AST).length) {
      return self.AST[Index__1] != null;
   };
   return false;
});
ZNode.prototype.HasAst = HasAst__2qwo;

var GetAstType__2qwo = (function (self, Index__1) {
   return self.AST[Index__1].Type.GetRealType(self.AST[Index__1].Type);
});
ZNode.prototype.GetAstType = GetAstType__2qwo;

var GetSourceLocation__1qwo = (function (self) {
   if (self.SourceToken != null) {
      return ((("(" + GetFileName__1qw3(self.SourceToken)) + ":") + (GetLineNumber__1qw3(self.SourceToken)).toString()) + ")";
   };
   return null;
});
ZNode.prototype.GetSourceLocation = GetSourceLocation__1qwo;

var toString__1qwo = (function (self) {
   var Self__3 = "#" + LibZen.GetClassName(self);
   if (!self.Type.IsVarType(self.Type)) {
      Self__1 = (Self__1 + ":") + toString__1qwg(self.Type);
   } else {
      Self__1 = Self__1 + ":?";
   };
   if (self.AST != null) {
      var i__2 = 0;
      Self__1 = Self__1 + "[";
      while (i__2 < (self.AST).length) {
         if (i__2 > 0) {
            Self__1 = Self__1 + ",";
         };
         if (self.AST[i__2] == null) {
            Self__1 = Self__1 + "null";
         } else {
            Self__1 = Self__1 + toString__1qwo(self.AST[i__2]);
         };
         i__2 = i__2 + 1;
      };
      Self__1 = Self__1 + "]";
   };
   return Self__1;
});
ZNode.prototype.toString = toString__1qwo;

var GetScopeBlockNode__1qwo = (function (self) {
   var Node__1 = self;
   while (Node__1 != null) {
      if ((Node__1).constructor.name == (ZBlockNode).name) {
         return Node__1;
      };
      console.assert(!(Node__1 == Node__1.ParentNode), "(libzen/libzen.zen:2119)");
      Node__1 = Node__1.ParentNode;
   };
   return null;
});
ZNode.prototype.GetScopeBlockNode = GetScopeBlockNode__1qwo;

var GetNameSpace__1qwo = (function (self) {
   var BlockNode__1 = GetScopeBlockNode__1qwo(self);
   return BlockNode__1.NameSpace;
});
ZNode.prototype.GetNameSpace = GetNameSpace__1qwo;

var IsErrorNode__1qwo = (function (self) {
   return ((self).constructor.name == (ZErrorNode).name);
});
ZNode.prototype.IsErrorNode = IsErrorNode__1qwo;

var IsBreakingBlock__1qwo = (function (self) {
   return false;
});
ZNode.prototype.IsBreakingBlock = IsBreakingBlock__1qwo;

var DeSugar__2qwo = (function (self, Generator__1) {
   return ZSugarNode__3qts(new ZSugarNode(), self, ZErrorNode__3qpr(new ZErrorNode(), self.ParentNode, "undefined code generation: " + toString__1qwo(self)));
});
ZNode.prototype.DeSugar = DeSugar__2qwo;

var Accept__2qwo = (function (self, Visitor__1) {
   Visitor__1.VisitExtendedNode(Visitor__1, self);
   return;
});
ZNode.prototype.Accept = Accept__2qwo;

var IsUntyped__1qwo = (function (self) {
   return !((self.Type).constructor.name == (ZFuncType).name) && self.Type.IsVarType(self.Type);
});
ZNode.prototype.IsUntyped = IsUntyped__1qwo;

var HasUntypedNode__1qwo = (function (self) {
   if (self.HasUntypedNode) {
      if (!IsUntyped__1qwo(self)) {
         var i__1 = 0;
         while (i__1 < GetAstSize__1qwo(self)) {
            if (self.AST[i__1] != null && HasUntypedNode__1qwo(self.AST[i__1])) {
               return true;
            };
            i__1 = i__1 + 1;
         };
         self.HasUntypedNode = false;
         return false;
      };
   };
   return self.HasUntypedNode;
});
ZNode.prototype.HasUntypedNode = HasUntypedNode__1qwo;

var VisitTypeChecker__3qwo = (function (self, TypeChecker__1, ContextType__2) {
   return VisitTypeChecker__3qrc(TypeChecker__1, self, ContextType__2);
});
ZNode.prototype.VisitTypeChecker = VisitTypeChecker__3qwo;

var ToReturnNode__1qwo = (function (self) {
   return null;
});
ZNode.prototype.ToReturnNode = ToReturnNode__1qwo;

var ZParamNode__2qtl = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 0);
   return null;
});
ZParamNode.prototype.ZParamNode = ZParamNode__2qtl;

var SetNameInfo__3qtl = (function (self, NameToken__1, Name__2) {
   self.Name = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZParamNode.prototype.SetNameInfo = SetNameInfo__3qtl;

var ZReturnNode__2qtj = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   return null;
});
ZReturnNode.prototype.ZReturnNode = ZReturnNode__2qtj;

var Accept__2qtj = (function (self, Visitor__1) {
   Visitor__1.VisitReturnNode(Visitor__1, self);
   return;
});
ZReturnNode.prototype.Accept = Accept__2qtj;

var ToReturnNode__1qtj = (function (self) {
   return self;
});
ZReturnNode.prototype.ToReturnNode = ToReturnNode__1qtj;

var ZSetIndexNode__3qtc = (function (self, ParentNode__1, LeftNode__2) {
   ZNode__4qwo(self, ParentNode__1, null, 3);
   Set__3qwo(self, 0, LeftNode__2);
   return null;
});
ZSetIndexNode.prototype.ZSetIndexNode = ZSetIndexNode__3qtc;

var Accept__2qtc = (function (self, Visitor__1) {
   Visitor__1.VisitSetIndexNode(Visitor__1, self);
   return;
});
ZSetIndexNode.prototype.Accept = Accept__2qtc;

var ZSetNameNode__4qtn = (function (self, ParentNode__1, Token__2, VarName__3) {
   ZNode__4qwo(self, ParentNode__1, Token__2, 1);
   self.VarName = VarName__3;
   return null;
});
ZSetNameNode.prototype.ZSetNameNode = ZSetNameNode__4qtn;

var Accept__2qtn = (function (self, Visitor__1) {
   Visitor__1.VisitSetNameNode(Visitor__1, self);
   return;
});
ZSetNameNode.prototype.Accept = Accept__2qtn;

var ZSetterNode__3qt5 = (function (self, ParentNode__1, RecvNode__2) {
   ZNode__4qwo(self, ParentNode__1, null, 2);
   Set__3qwo(self, 0, RecvNode__2);
   return null;
});
ZSetterNode.prototype.ZSetterNode = ZSetterNode__3qt5;

var SetNameInfo__3qt5 = (function (self, NameToken__1, Name__2) {
   self.FieldName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZSetterNode.prototype.SetNameInfo = SetNameInfo__3qt5;

var Accept__2qt5 = (function (self, Visitor__1) {
   Visitor__1.VisitSetterNode(Visitor__1, self);
   return;
});
ZSetterNode.prototype.Accept = Accept__2qt5;

var IsStaticField__1qt5 = (function (self) {
   return (self.AST[0]).constructor.name == (ZTypeNode).name;
});
ZSetterNode.prototype.IsStaticField = IsStaticField__1qt5;

var ZSugarNode__3qts = (function (self, SugarNode__1, DeSugarNode__2) {
   ZNode__4qwo(self, SugarNode__1.ParentNode, null, 1);
   self.SugarNode = SugarNode__1;
   SugarNode__1.ParentNode = self;
   Set__3qwo(self, 0, DeSugarNode__2);
   DeSugarNode__2.ParentNode = self;
   return null;
});
ZSugarNode.prototype.ZSugarNode = ZSugarNode__3qts;

var Accept__2qts = (function (self, Visitor__1) {
   Visitor__1.VisitSugarNode(Visitor__1, self);
   return;
});
ZSugarNode.prototype.Accept = Accept__2qts;

var ZThrowNode__2qyr = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   return null;
});
ZThrowNode.prototype.ZThrowNode = ZThrowNode__2qyr;

var Accept__2qyr = (function (self, Visitor__1) {
   Visitor__1.VisitThrowNode(Visitor__1, self);
   return;
});
ZThrowNode.prototype.Accept = Accept__2qyr;

var ZTryNode__2qyu = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 3);
   return null;
});
ZTryNode.prototype.ZTryNode = ZTryNode__2qyu;

var Accept__2qyu = (function (self, Visitor__1) {
   Visitor__1.VisitTryNode(Visitor__1, self);
   return;
});
ZTryNode.prototype.Accept = Accept__2qyu;

var ZUnaryNode__3qyp = (function (self, ParentNode__1, Token__2) {
   ZNode__4qwo(self, ParentNode__1, Token__2, 1);
   return null;
});
ZUnaryNode.prototype.ZUnaryNode = ZUnaryNode__3qyp;

var Accept__2qyp = (function (self, Visitor__1) {
   Visitor__1.VisitUnaryNode(Visitor__1, self);
   return;
});
ZUnaryNode.prototype.Accept = Accept__2qyp;

var ZWhileNode__2qya = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 2);
   return null;
});
ZWhileNode.prototype.ZWhileNode = ZWhileNode__2qya;

var Accept__2qya = (function (self, Visitor__1) {
   Visitor__1.VisitWhileNode(Visitor__1, self);
   return;
});
ZWhileNode.prototype.Accept = Accept__2qya;

var toString__1qyf = (function (self) {
   return "";
});
ZEmptyValue.prototype.toString = toString__1qyf;

var ZLogger_LogError__2qw3 = (function (Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qud(Token.Source, "error", Token.StartIndex, Message__1);
      Report__2qrk(Token.Source.Logger, Message__1);
   };
   return Message__1;
});
ZToken.prototype.ZLogger_LogError = ZLogger_LogError__2qw3;

var ZLogger_LogWarning__2qw3 = (function (Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qud(Token.Source, "warning", Token.StartIndex, Message__1);
      Report__2qrk(Token.Source.Logger, Message__1);
   };
   return;
});
ZToken.prototype.ZLogger_LogWarning = ZLogger_LogWarning__2qw3;

var ZLogger_LogInfo__2qw3 = (function (Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qud(Token.Source, "info", Token.StartIndex, Message__1);
      Report__2qrk(Token.Source.Logger, Message__1);
   };
   return;
});
ZToken.prototype.ZLogger_LogInfo = ZLogger_LogInfo__2qw3;

var ZLogger_LogDebug__2qw3 = (function (Token, Message__1) {
   if (Token != null && Token.Source != null) {
      Message__1 = FormatErrorMarker__4qud(Token.Source, "debug", Token.StartIndex, Message__1);
      Report__2qrk(Token.Source.Logger, Message__1);
   };
   return;
});
ZToken.prototype.ZLogger_LogDebug = ZLogger_LogDebug__2qw3;

var Report__2qrk = (function (self, Message__1) {
   self.ReportedErrorList.push(Message__1);
   return;
});
ZLogger.prototype.Report = Report__2qrk;

var GetReportedErrors__1qrk = (function (self) {
   var List__1 = self.ReportedErrorList;
   self.ReportedErrorList = [];
   return List__1;
});
ZLogger.prototype.GetReportedErrors = GetReportedErrors__1qrk;

var ShowErrors__1qrk = (function (self) {
   var Messages__1 = GetReportedErrors__1qrk(self);
   var i__2 = 0;
   while (i__2 < (Messages__1).length) {
      LibZen.PrintLine(Messages__1[i__2]);
      i__2 = i__2 + 1;
   };
   return;
});
ZLogger.prototype.ShowErrors = ShowErrors__1qrk;

var ZMacroFunc__3qy1 = (function (self, FuncName__1, FuncType__2) {
   ZFunc__4qep(self, 0, FuncName__1, FuncType__2);
   return null;
});
ZMacroFunc.prototype.ZMacroFunc = ZMacroFunc__3qy1;

var ZNameSpace_RightPatternSymbol__1qqy = (function (PatternName) {
   return "\t" + PatternName;
});
String.prototype.ZNameSpace_RightPatternSymbol = ZNameSpace_RightPatternSymbol__1qqy;

var ZNameSpace__3qwt = (function (self, Generator__1, ParentNameSpace__2) {
   self.ParentNameSpace = ParentNameSpace__2;
   if (ParentNameSpace__2 == null) {
      self.Generator = Generator__1;
   } else {
      self.Generator = ParentNameSpace__2.Generator;
   };
   self.SerialId = 0;
   return null;
});
ZNameSpace.prototype.ZNameSpace = ZNameSpace__3qwt;

var toString__1qwt = (function (self) {
   return ("NS[" + (self.SerialId).toString()) + "]";
});
ZNameSpace.prototype.toString = toString__1qwt;

var CreateSubNameSpace__1qwt = (function (self) {
   return ZNameSpace__3qwt(new ZNameSpace(), null, self);
});
ZNameSpace.prototype.CreateSubNameSpace = CreateSubNameSpace__1qwt;

var GetRootNameSpace__1qwt = (function (self) {
   return self.Generator.RootNameSpace;
});
ZNameSpace.prototype.GetRootNameSpace = GetRootNameSpace__1qwt;

var GetTokenFunc__2qwt = (function (self, ZenChar__1) {
   if (self.TokenMatrix == null) {
      return GetTokenFunc__2qwt(self.ParentNameSpace, ZenChar__1);
   };
   return self.TokenMatrix[ZenChar__1];
});
ZNameSpace.prototype.GetTokenFunc = GetTokenFunc__2qwt;

var JoinParentFunc__3qwt = (function (self, Func__1, Parent__2) {
   if (Parent__2 != null && Parent__2.Func == Func__1) {
      return Parent__2;
   };
   return ZTokenFunc__3qqc(new ZTokenFunc(), Func__1, Parent__2);
});
ZNameSpace.prototype.JoinParentFunc = JoinParentFunc__3qwt;

var AppendTokenFunc__3qwt = (function (self, keys__1, TokenFunc__2) {
   if (self.TokenMatrix == null) {
      self.TokenMatrix = LibZen.NewTokenMatrix();
      if (self.ParentNameSpace != null) {
         var i__3 = 0;
         while (i__3 < (self.TokenMatrix).length) {
            self.TokenMatrix[i__3] = GetTokenFunc__2qwt(self.ParentNameSpace, i__3);
            i__3 = i__3 + 1;
         };
      };
   };
   var i__7 = 0;
   while (i__4 < keys__1.size()) {
      var kchar__5 = LibZen.GetTokenMatrixIndex(LibZen.GetChar(keys__1, i__4));
      self.TokenMatrix[kchar__5] = JoinParentFunc__3qwt(self, TokenFunc__2, self.TokenMatrix[kchar__5]);
      i__4 = i__4 + 1;
   };
   return;
});
ZNameSpace.prototype.AppendTokenFunc = AppendTokenFunc__3qwt;

var GetSyntaxPattern__2qwt = (function (self, PatternName__1) {
   var NameSpace__2 = self;
   while (NameSpace__2 != null) {
      if (NameSpace__2.SyntaxTable != null) {
         return NameSpace__2.SyntaxTable[PatternName__1];
      };
      NameSpace__2 = NameSpace__2.ParentNameSpace;
   };
   return null;
});
ZNameSpace.prototype.GetSyntaxPattern = GetSyntaxPattern__2qwt;

var SetSyntaxPattern__3qwt = (function (self, PatternName__1, Syntax__2) {
   if (self.SyntaxTable == null) {
      self.SyntaxTable = LibZen.NewMap(0);
   };
   self.SyntaxTable[PatternName__1] = Syntax__2;
   return;
});
ZNameSpace.prototype.SetSyntaxPattern = SetSyntaxPattern__3qwt;

var GetRightSyntaxPattern__2qwt = (function (self, PatternName__1) {
   return GetSyntaxPattern__2qwt(self, ZNameSpace_RightPatternSymbol__1qqy(PatternName__1));
});
ZNameSpace.prototype.GetRightSyntaxPattern = GetRightSyntaxPattern__2qwt;

var AppendSyntaxPattern__3qwt = (function (self, PatternName__1, NewPattern__2) {
   LibZen.Assert(NewPattern__2.ParentPattern == null);
   var ParentPattern__3 = GetSyntaxPattern__2qwt(self, PatternName__1);
   NewPattern__2.ParentPattern = ParentPattern__3;
   SetSyntaxPattern__3qwt(self, PatternName__1, NewPattern__2);
   return;
});
ZNameSpace.prototype.AppendSyntaxPattern = AppendSyntaxPattern__3qwt;

var DefineStatement__3qwt = (function (self, PatternName__1, MatchFunc__2) {
   var Alias__9 = PatternName__1.indexOf(" ");
   var Name__10 = PatternName__1;
   if (Alias__3 != -1) {
      Name__10 = PatternName__1.substring(0, Alias);
   };
   var Pattern__11 = ZSyntax__4qy7(new ZSyntax(), self, Name__4, MatchFunc__2);
   Pattern__5.IsStatement = true;
   AppendSyntaxPattern__3qwt(self, Name__4, Pattern__5);
   if (Alias__3 != -1) {
      DefineStatement__3qwt(self, PatternName__1.substring(Alias + 1), MatchFunc__2);
   };
   return;
});
ZNameSpace.prototype.DefineStatement = DefineStatement__3qwt;

var DefineExpression__3qwt = (function (self, PatternName__1, MatchFunc__2) {
   var Alias__9 = PatternName__1.indexOf(" ");
   var Name__10 = PatternName__1;
   if (Alias__3 != -1) {
      Name__10 = PatternName__1.substring(0, Alias);
   };
   var Pattern__11 = ZSyntax__4qy7(new ZSyntax(), self, Name__4, MatchFunc__2);
   AppendSyntaxPattern__3qwt(self, Name__4, Pattern__5);
   if (Alias__3 != -1) {
      DefineExpression__3qwt(self, PatternName__1.substring(Alias + 1), MatchFunc__2);
   };
   return;
});
ZNameSpace.prototype.DefineExpression = DefineExpression__3qwt;

var DefineRightExpression__4qwt = (function (self, PatternName__1, SyntaxFlag__2, MatchFunc__3) {
   var Alias__7 = PatternName__1.indexOf(" ");
   var Name__8 = PatternName__1;
   if (Alias__4 != -1) {
      Name__8 = PatternName__1.substring(0, Alias);
   };
   var Pattern__9 = ZSyntax__4qy7(new ZSyntax(), self, Name__5, MatchFunc__3);
   Pattern__6.SyntaxFlag = SyntaxFlag__2;
   AppendSyntaxPattern__3qwt(self, ZNameSpace_RightPatternSymbol__1qqy(Name__5), Pattern__6);
   if (Alias__4 != -1) {
      DefineRightExpression__4qwt(self, PatternName__1.substring(Alias + 1), SyntaxFlag__2, MatchFunc__3);
   };
   return;
});
ZNameSpace.prototype.DefineRightExpression = DefineRightExpression__4qwt;

var GetSymbol__2qwt = (function (self, Symbol__1) {
   var NameSpace__2 = self;
   while (NameSpace__2 != null) {
      if (NameSpace__2.SymbolTable != null) {
         var Entry__3 = NameSpace__2.SymbolTable[Symbol__1];
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
});
ZNameSpace.prototype.GetSymbol = GetSymbol__2qwt;

var GetSymbolNode__2qwt = (function (self, Symbol__1) {
   var Entry__2 = GetSymbol__2qwt(self, Symbol__1);
   if (Entry__2 != null) {
      return Entry__2.Node;
   };
   return null;
});
ZNameSpace.prototype.GetSymbolNode = GetSymbolNode__2qwt;

var SetLocalSymbolEntry__3qwt = (function (self, Symbol__1, Entry__2) {
   if (self.SymbolTable == null) {
      self.SymbolTable = LibZen.NewMap(0);
   };
   self.SymbolTable[Symbol__1] = Entry__2;
   return;
});
ZNameSpace.prototype.SetLocalSymbolEntry = SetLocalSymbolEntry__3qwt;

var SetLocalSymbol__3qwt = (function (self, Symbol__1, Node__2) {
   var Parent__3 = GetSymbol__2qwt(self, Symbol__1);
   Node__2.ParentNode = null;
   SetLocalSymbolEntry__3qwt(self, Symbol__1, ZSymbolEntry__3quw(new ZSymbolEntry(), Parent__3, Node__2));
   return Parent__3;
});
ZNameSpace.prototype.SetLocalSymbol = SetLocalSymbol__3qwt;

var SetGlobalSymbol__3qwt = (function (self, Symbol__1, Node__2) {
   return SetLocalSymbol__3qwt(GetRootNameSpace__1qwt(self), Symbol__1, Node__2);
});
ZNameSpace.prototype.SetGlobalSymbol = SetGlobalSymbol__3qwt;

var GetLocalVariable__2qwt = (function (self, VarName__1) {
   var Entry__2 = GetSymbol__2qwt(self, VarName__1);
   if ((Entry__2).constructor.name == (ZVariable).name) {
      return Entry__2;
   };
   return null;
});
ZNameSpace.prototype.GetLocalVariable = GetLocalVariable__2qwt;

var SetLocalVariable__5qwt = (function (self, FunctionNode__1, VarType__2, VarName__3, SourceToken__4) {
   var Parent__5 = GetSymbol__2qwt(self, VarName__3);
   var VarInfo__6 = ZVariable__7quu(new ZVariable(), Parent__5, FunctionNode__1, 0, VarType__2, VarName__3, SourceToken__4);
   SetLocalSymbolEntry__3qwt(self, VarName__3, VarInfo__6);
   return;
});
ZNameSpace.prototype.SetLocalVariable = SetLocalVariable__5qwt;

var SetTypeName__4qwt = (function (self, Name__1, Type__2, SourceToken__3) {
   var Node__4 = ZTypeNode__4qu4(new ZTypeNode(), null, SourceToken__3, Type__2);
   SetLocalSymbol__3qwt(self, Name__1, Node__4);
   return;
});
ZNameSpace.prototype.SetTypeName = SetTypeName__4qwt;

var SetTypeName__3qwt = (function (self, Type__1, SourceToken__2) {
   SetTypeName__4qwt(self, Type__1.ShortName, Type__1, SourceToken__2);
   return;
});
ZNameSpace.prototype.SetTypeName = SetTypeName__3qwt;

var GetTypeNode__3qwt = (function (self, TypeName__1, SourceToken__2) {
   var Node__3 = GetSymbolNode__2qwt(self, TypeName__1);
   if ((Node__3).constructor.name == (ZTypeNode).name) {
      return Node__3;
   };
   if (Node__3 == null && SourceToken__2 != null) {
      var Type__4 = ZClassType__3qeq(new ZClassType(), TypeName__1, ZType__4qwg(new ZType(), 1 << 16, "var", null));
      SetTypeName__4qwt(GetRootNameSpace__1qwt(self), TypeName__1, Type__4, SourceToken__2);
      return GetTypeNode__3qwt(self, TypeName__1, null);
   };
   return null;
});
ZNameSpace.prototype.GetTypeNode = GetTypeNode__3qwt;

var GetType__3qwt = (function (self, TypeName__1, SourceToken__2) {
   var TypeNode__3 = GetTypeNode__3qwt(self, TypeName__1, SourceToken__2);
   if (TypeNode__3 != null) {
      return TypeNode__3.Type;
   };
   return null;
});
ZNameSpace.prototype.GetType = GetType__3qwt;

var ZSource__5qud = (function (self, FileName__1, LineNumber__2, Source__3, TokenContext__4) {
   self.FileName = FileName__1;
   self.LineNumber = LineNumber__2;
   self.TokenContext = TokenContext__4;
   self.SourceText = Source__3;
   self.Logger = TokenContext__4.Generator.Logger;
   return null;
});
ZSource.prototype.ZSource = ZSource__5qud;

var GetLineNumber__2qud = (function (self, Position__1) {
   var LineNumber__2 = self.LineNumber;
   var i__3 = 0;
   while (i__3 < Position__1) {
      var ch__4 = LibZen.GetChar(self.SourceText, i__3);
      if (ch__4 == "\n") {
         LineNumber__2 = LineNumber__2 + 1;
      };
      i__3 = i__3 + 1;
   };
   return LineNumber__2;
});
ZSource.prototype.GetLineNumber = GetLineNumber__2qud;

var GetLineHeadPosition__2qud = (function (self, Position__1) {
   var s__9 = self.SourceText;
   var StartIndex__10 = 0;
   var i__11 = Position__1;
   if (!(i__4 < s__2.size())) {
      i__11 = s__2.size() - 1;
   };
   while (i__4 >= 0) {
      var ch__5 = LibZen.GetChar(s__2, i__4);
      if (ch__5 == "\n") {
         StartIndex__3 = i__4 + 1;
         break;
      };
      i__4 = i__4 - 1;
   };
   return StartIndex__3;
});
ZSource.prototype.GetLineHeadPosition = GetLineHeadPosition__2qud;

var CountIndentSize__2qud = (function (self, Position__1) {
   var s__9 = self.SourceText;
   var length__10 = 0;
   var i__11 = Position__1;
   while (i__4 < s__2.size()) {
      var ch__5 = LibZen.GetChar(s__2, i__4);
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
});
ZSource.prototype.CountIndentSize = CountIndentSize__2qud;

var GetLineText__2qud = (function (self, Position__1) {
   var s__12 = self.SourceText;
   var StartIndex__13 = 0;
   var EndIndex__14 = s__2.size();
   var i__15 = Position__1;
   if (!(i__5 < s__2.size())) {
      i__15 = s__2.size() - 1;
   };
   while (i__5 >= 0) {
      var ch__6 = LibZen.GetChar(s__2, i__5);
      if (ch__6 == "\n") {
         StartIndex__3 = i__5 + 1;
         break;
      };
      i__5 = i__5 - 1;
   };
   i__5 = Position__1;
   while (i__5 < s__2.size()) {
      var ch__7 = LibZen.GetChar(s__2, i__5);
      if (ch__7 == "\n") {
         EndIndex__4 = i__5;
         break;
      };
      i__5 = i__5 + 1;
   };
   return s__2.substring(StartIndex, EndIndex);
});
ZSource.prototype.GetLineText = GetLineText__2qud;

var GetLineMarker__2qud = (function (self, Position__1) {
   var s__11 = self.SourceText;
   var StartIndex__12 = 0;
   var i__13 = Position__1;
   if (!(i__4 < s__2.size())) {
      i__13 = s__2.size() - 1;
   };
   while (i__4 >= 0) {
      var ch__5 = LibZen.GetChar(s__2, i__4);
      if (ch__5 == "\n") {
         StartIndex__3 = i__4 + 1;
         break;
      };
      i__4 = i__4 - 1;
   };
   var Line__6 = "";
   i__4 = StartIndex__3;
   while (i__4 < Position__1) {
      var ch__7 = LibZen.GetChar(s__2, i__4);
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
});
ZSource.prototype.GetLineMarker = GetLineMarker__2qud;

var FormatErrorHeader__4qud = (function (self, Error__1, Position__2, Message__3) {
   return (((((("(" + self.FileName) + ":") + (GetLineNumber__2qud(self, Position__2)).toString()) + ") [") + Error__1) + "] ") + Message__3;
});
ZSource.prototype.FormatErrorHeader = FormatErrorHeader__4qud;

var FormatErrorMarker__4qud = (function (self, Error__1, Position__2, Message__3) {
   var Line__8 = GetLineText__2qud(self, Position__2);
   var Delim__9 = "\n\t";
   if (Line__4.startsWith("\t") || Line__4.startsWith(" ")) {
      Delim__5 = "\n";
   };
   var Header__6 = FormatErrorHeader__4qud(self, Error__1, Position__2, Message__3);
   var Marker__7 = GetLineMarker__2qud(self, Position__2);
   Message__3 = (((Header__6 + Delim__5) + Line__4) + Delim__5) + Marker__7;
   return Message__3;
});
ZSource.prototype.FormatErrorMarker = FormatErrorMarker__4qud;

var GetCharAt__2qud = (function (self, n__1) {
   if (0 <= n__1 && n__1 < self.SourceText.size()) {
      return LibZen.GetChar(self.SourceText, n__1);
   };
   return "0";
});
ZSource.prototype.GetCharAt = GetCharAt__2qud;

var ZSourceBuilder__3qq2 = (function (self, Template__1, Parent__2) {
   self.Template = Template__1;
   self.Parent = Parent__2;
   return null;
});
ZSourceBuilder.prototype.ZSourceBuilder = ZSourceBuilder__3qq2;

var Pop__1qq2 = (function (self) {
   return self.Parent;
});
ZSourceBuilder.prototype.Pop = Pop__1qq2;

var Clear__1qq2 = (function (self) {
   self.SourceList.clear(0);
   return;
});
ZSourceBuilder.prototype.Clear = Clear__1qq2;

var GetPosition__1qq2 = (function (self) {
   return (self.SourceList).length;
});
ZSourceBuilder.prototype.GetPosition = GetPosition__1qq2;

var CopyString__3qq2 = (function (self, BeginIndex__1, EndIndex__2) {
   return LibZen.SourceBuilderToString(self, BeginIndex__1, EndIndex__2);
});
ZSourceBuilder.prototype.CopyString = CopyString__3qq2;

var Append__2qq2 = (function (self, Text__1) {
   self.SourceList.push(Text__1);
   return;
});
ZSourceBuilder.prototype.Append = Append__2qq2;

var AppendInt__2qq2 = (function (self, Value__1) {
   self.SourceList.push("" + (Value__1).toString());
   return;
});
ZSourceBuilder.prototype.AppendInt = AppendInt__2qq2;

var AppendLineFeed__1qq2 = (function (self) {
   if (self.BufferedLineComment.size() > 0) {
      self.SourceList.push(self.BufferedLineComment);
      self.BufferedLineComment = "";
   };
   self.SourceList.push(self.Template.LineFeed);
   return;
});
ZSourceBuilder.prototype.AppendLineFeed = AppendLineFeed__1qq2;

var AppendLineFeed__2qq2 = (function (self, AppendIndent__1) {
   if (self.BufferedLineComment.size() > 0) {
      self.SourceList.push(self.BufferedLineComment);
      self.BufferedLineComment = "";
   };
   self.SourceList.push(self.Template.LineFeed);
   if (AppendIndent__1) {
      AppendIndent__1qq2(self);
   };
   return;
});
ZSourceBuilder.prototype.AppendLineFeed = AppendLineFeed__2qq2;

var AppendWhiteSpace__1qq2 = (function (self) {
   var Size__3 = (self.SourceList).length;
   if (Size__1 > 0) {
      var Last__4 = self.SourceList[Size__1 - 1];
      if (Last__2 != null && (Last__2.endsWith(" ") || Last__2.endsWith("\n") || Last__2.endsWith("\t"))) {
         return;
      };
   };
   self.SourceList.push(" ");
   return;
});
ZSourceBuilder.prototype.AppendWhiteSpace = AppendWhiteSpace__1qq2;

var AppendToken__2qq2 = (function (self, Text__1) {
   AppendWhiteSpace__1qq2(self);
   self.SourceList.push(Text__1);
   AppendWhiteSpace__1qq2(self);
   return;
});
ZSourceBuilder.prototype.AppendToken = AppendToken__2qq2;

var AppendBlockComment__2qq2 = (function (self, Text__1) {
   if (self.Template.BeginComment != null) {
      self.SourceList.push(self.Template.BeginComment);
      self.SourceList.push(Text__1);
      self.SourceList.push(self.Template.EndComment);
   } else if (self.Template.LineComment != null) {
      self.BufferedLineComment = (self.BufferedLineComment + self.Template.LineComment) + Text__1;
   };
   return;
});
ZSourceBuilder.prototype.AppendBlockComment = AppendBlockComment__2qq2;

var AppendCommentLine__2qq2 = (function (self, Text__1) {
   if (self.Template.LineComment == null) {
      self.SourceList.push(self.Template.BeginComment);
      self.SourceList.push(Text__1);
      self.SourceList.push(self.Template.EndComment);
   } else {
      self.SourceList.push(self.Template.LineComment);
      self.SourceList.push(Text__1);
   };
   self.SourceList.push(self.Template.LineFeed);
   return;
});
ZSourceBuilder.prototype.AppendCommentLine = AppendCommentLine__2qq2;

var Indent__1qq2 = (function (self) {
   self.IndentLevel = self.IndentLevel + 1;
   self.CurrentIndentString = null;
   return;
});
ZSourceBuilder.prototype.Indent = Indent__1qq2;

var UnIndent__1qq2 = (function (self) {
   self.IndentLevel = self.IndentLevel - 1;
   self.CurrentIndentString = null;
   LibZen.Assert(self.IndentLevel >= 0);
   return;
});
ZSourceBuilder.prototype.UnIndent = UnIndent__1qq2;

var GetIndentString__1qq2 = (function (self) {
   if (self.CurrentIndentString == null) {
      self.CurrentIndentString = LibZen.JoinStrings(self.Template.Tab, self.IndentLevel);
   };
   return self.CurrentIndentString;
});
ZSourceBuilder.prototype.GetIndentString = GetIndentString__1qq2;

var AppendIndent__1qq2 = (function (self) {
   self.SourceList.push(GetIndentString__1qq2(self));
   return;
});
ZSourceBuilder.prototype.AppendIndent = AppendIndent__1qq2;

var AppendLineFeedIndent__1qq2 = (function (self) {
   self.SourceList.push(self.Template.LineFeed);
   self.SourceList.push(GetIndentString__1qq2(self));
   return;
});
ZSourceBuilder.prototype.AppendLineFeedIndent = AppendLineFeedIndent__1qq2;

var IndentAndAppend__2qq2 = (function (self, Text__1) {
   self.SourceList.push(GetIndentString__1qq2(self));
   self.SourceList.push(Text__1);
   return;
});
ZSourceBuilder.prototype.IndentAndAppend = IndentAndAppend__2qq2;

var AppendParamList__4qq2 = (function (self, ParamList__1, BeginIdx__2, EndIdx__3) {
   var i__4 = BeginIdx__2;
   while (i__4 < EndIdx__3) {
      if (i__4 > BeginIdx__2) {
         Append__2qq2(self, self.Template.Camma);
      };
      GetListAt__2quv(ParamList__1, i__4).Accept(GetListAt__2quv(ParamList__1, i__4), self.Template);
      i__4 = i__4 + 1;
   };
   return;
});
ZSourceBuilder.prototype.AppendParamList = AppendParamList__4qq2;

var toString__1qq2 = (function (self) {
   return LibZen.SourceBuilderToString(self);
});
ZSourceBuilder.prototype.toString = toString__1qq2;

var AppendLine__2qq2 = (function (self, Text__1) {
   Append__2qq2(self, Text__1);
   AppendLineFeed__1qq2(self);
   return;
});
ZSourceBuilder.prototype.AppendLine = AppendLine__2qq2;

var ZSourceContext__5qwu = (function (self, FileName__1, LineNumber__2, Source__3, TokenContext__4) {
   ZSource__5qud(self, FileName__1, LineNumber__2, Source__3, TokenContext__4);
   return null;
});
ZSourceContext.prototype.ZSourceContext = ZSourceContext__5qwu;

var GetCharCode__1qwu = (function (self) {
   return LibZen.GetTokenMatrixIndex(LibZen.GetChar(self.SourceText, self.SourcePosition));
});
ZSourceContext.prototype.GetCharCode = GetCharCode__1qwu;

var GetPosition__1qwu = (function (self) {
   return self.SourcePosition;
});
ZSourceContext.prototype.GetPosition = GetPosition__1qwu;

var HasChar__1qwu = (function (self) {
   return (self.SourceText.size() - self.SourcePosition) > 0;
});
ZSourceContext.prototype.HasChar = HasChar__1qwu;

var GetCurrentChar__1qwu = (function (self) {
   return LibZen.GetChar(self.SourceText, self.SourcePosition);
});
ZSourceContext.prototype.GetCurrentChar = GetCurrentChar__1qwu;

var GetCharAtFromCurrentPosition__2qwu = (function (self, n__1) {
   if ((self.SourcePosition + n__1) < self.SourceText.size()) {
      return LibZen.GetChar(self.SourceText, self.SourcePosition + n__1);
   };
   return "0";
});
ZSourceContext.prototype.GetCharAtFromCurrentPosition = GetCharAtFromCurrentPosition__2qwu;

var MoveNext__1qwu = (function (self) {
   self.SourcePosition = self.SourcePosition + 1;
   return;
});
ZSourceContext.prototype.MoveNext = MoveNext__1qwu;

var SkipWhiteSpace__1qwu = (function (self) {
   while (HasChar__1qwu(self)) {
      var ch__1 = GetCurrentChar__1qwu(self);
      if (ch__1 != " " && ch__1 != "\t") {
         break;
      };
      MoveNext__1qwu(self);
   };
   return;
});
ZSourceContext.prototype.SkipWhiteSpace = SkipWhiteSpace__1qwu;

var FoundIndent__3qwu = (function (self, StartIndex__1, EndIndex__2) {
   var Token__3 = ZIndentToken__4qak(new ZIndentToken(), self, StartIndex__1, EndIndex__2);
   self.SourcePosition = EndIndex__2;
   self.TokenContext.TokenList.push(Token__3);
   return;
});
ZSourceContext.prototype.FoundIndent = FoundIndent__3qwu;

var Tokenize__3qwu = (function (self, StartIndex__1, EndIndex__2) {
   self.SourcePosition = EndIndex__2;
   if (StartIndex__1 < EndIndex__2 && EndIndex__2 <= self.SourceText.size()) {
      var Token__3 = ZToken__4qw3(new ZToken(), self, StartIndex__1, EndIndex__2);
      self.TokenContext.TokenList.push(Token__3);
   };
   return;
});
ZSourceContext.prototype.Tokenize = Tokenize__3qwu;

var Tokenize__4qwu = (function (self, PatternName__1, StartIndex__2, EndIndex__3) {
   self.SourcePosition = EndIndex__3;
   if (StartIndex__2 <= EndIndex__3 && EndIndex__3 <= self.SourceText.size()) {
      var Pattern__4 = GetSyntaxPattern__2qwt(self.TokenContext.NameSpace, PatternName__1);
      if (Pattern__4 == null) {
         var Token__5 = ZToken__4qw3(new ZToken(), self, StartIndex__2, EndIndex__3);
         ZLogger_LogInfo__2qw3(Token__5, "unregistered token pattern: " + PatternName__1);
         self.TokenContext.TokenList.push(Token__5);
      } else {
         var Token__6 = ZPatternToken__5qa9(new ZPatternToken(), self, StartIndex__2, EndIndex__3, Pattern__4);
         self.TokenContext.TokenList.push(Token__6);
      };
   };
   return;
});
ZSourceContext.prototype.Tokenize = Tokenize__4qwu;

var IsDefinedSyntax__3qwu = (function (self, StartIndex__1, EndIndex__2) {
   if (EndIndex__2 < self.SourceText.size()) {
      var NameSpace__6 = self.TokenContext.NameSpace;
      var Token__7 = self.SourceText.substring(StartIndex, EndIndex);
      var Pattern__5 = GetRightSyntaxPattern__2qwt(NameSpace__3, Token__4);
      if (Pattern__5 != null) {
         return true;
      };
   };
   return false;
});
ZSourceContext.prototype.IsDefinedSyntax = IsDefinedSyntax__3qwu;

var TokenizeDefinedSymbol__2qwu = (function (self, StartIndex__1) {
   var EndIndex__2 = StartIndex__1 + 2;
   while (IsDefinedSyntax__3qwu(self, StartIndex__1, EndIndex__2)) {
      EndIndex__2 = EndIndex__2 + 1;
   };
   Tokenize__3qwu(self, StartIndex__1, EndIndex__2 - 1);
   return;
});
ZSourceContext.prototype.TokenizeDefinedSymbol = TokenizeDefinedSymbol__2qwu;

var ApplyTokenFunc__2qwu = (function (self, TokenFunc__1) {
   var RollbackPosition__2 = self.SourcePosition;
   while (TokenFunc__1 != null) {
      self.SourcePosition = RollbackPosition__2;
      if (LibZen.ApplyTokenFunc(TokenFunc__1.Func, self)) {
         return;
      };
      TokenFunc__1 = TokenFunc__1.ParentFunc;
   };
   TokenizeDefinedSymbol__2qwu(self, RollbackPosition__2);
   return;
});
ZSourceContext.prototype.ApplyTokenFunc = ApplyTokenFunc__2qwu;

var DoTokenize__1qwu = (function (self) {
   var TokenSize__1 = (self.TokenContext.TokenList).length;
   var CheckPosition__2 = self.SourcePosition;
   while (HasChar__1qwu(self)) {
      var CharCode__3 = GetCharCode__1qwu(self);
      var TokenFunc__4 = GetTokenFunc__2qwt(self.TokenContext.NameSpace, CharCode__3);
      ApplyTokenFunc__2qwu(self, TokenFunc__4);
      if ((self.TokenContext.TokenList).length > TokenSize__1) {
         break;
      };
      if (self.SourcePosition == CheckPosition__2) {
         MoveNext__1qwu(self);
      };
   };
   if ((self.TokenContext.TokenList).length > TokenSize__1) {
      return true;
   };
   return false;
});
ZSourceContext.prototype.DoTokenize = DoTokenize__1qwu;

var LogWarning__3qwu = (function (self, Position__1, Message__2) {
   Report__2qrk(self.Logger, FormatErrorMarker__4qud(self, "warning", Position__1, Message__2));
   return;
});
ZSourceContext.prototype.LogWarning = LogWarning__3qwu;

var ZSourceMacro__4qiy = (function (self, FuncName__1, FuncType__2, Macro__3) {
   ZMacroFunc__3qy1(self, FuncName__1, FuncType__2);
   self.Macro = Macro__3;
   return null;
});
ZSourceMacro.prototype.ZSourceMacro = ZSourceMacro__4qiy;

var ZSymbolEntry__3quw = (function (self, Parent__1, Node__2) {
   self.Parent = Parent__1;
   self.Node = Node__2;
   return null;
});
ZSymbolEntry.prototype.ZSymbolEntry = ZSymbolEntry__3quw;

var MergeSyntaxPattern__2qy7 = (function (Pattern, Parent__1) {
   if (Parent__1 == null) {
      return Pattern;
   };
   var MergedPattern__2 = ZSyntax__4qy7(new ZSyntax(), Pattern.PackageNameSpace, Pattern.PatternName, Pattern.MatchFunc);
   MergedPattern__2.ParentPattern = Parent__1;
   return MergedPattern__2;
});
ZSyntax.prototype.MergeSyntaxPattern = MergeSyntaxPattern__2qy7;

var ZSyntax__4qy7 = (function (self, NameSpace__1, PatternName__2, MatchFunc__3) {
   self.PackageNameSpace = NameSpace__1;
   self.PatternName = PatternName__2;
   self.MatchFunc = MatchFunc__3;
   return null;
});
ZSyntax.prototype.ZSyntax = ZSyntax__4qy7;

var toString__1qy7 = (function (self) {
   return self.PatternName;
});
ZSyntax.prototype.toString = toString__1qy7;

var IsBinaryOperator__1qy7 = (function (self) {
   return LibZen.IsFlag(self.SyntaxFlag, 1);
});
ZSyntax.prototype.IsBinaryOperator = IsBinaryOperator__1qy7;

var IsRightJoin__2qy7 = (function (self, Right__1) {
   var left__2 = self.SyntaxFlag;
   var right__3 = Right__1.SyntaxFlag;
   return (left__2 < right__3 || (left__2 == right__3 && !LibZen.IsFlag(left__2, 1 << 1) && !LibZen.IsFlag(right__3, 1 << 1)));
});
ZSyntax.prototype.IsRightJoin = IsRightJoin__2qy7;

var ZToken__4qw3 = (function (self, Source__1, StartIndex__2, EndIndex__3) {
   self.Source = Source__1;
   self.StartIndex = StartIndex__2;
   self.EndIndex = EndIndex__3;
   return null;
});
ZToken.prototype.ZToken = ZToken__4qw3;

var GetFileName__1qw3 = (function (self) {
   return self.Source.FileName;
});
ZToken.prototype.GetFileName = GetFileName__1qw3;

var GetLineNumber__1qw3 = (function (self) {
   return GetLineNumber__2qud(self.Source, self.StartIndex);
});
ZToken.prototype.GetLineNumber = GetLineNumber__1qw3;

var GetChar__1qw3 = (function (self) {
   if (self.Source != null) {
      return LibZen.GetChar(self.Source.SourceText, self.StartIndex);
   };
   return "0";
});
ZToken.prototype.GetChar = GetChar__1qw3;

var GetText__1qw3 = (function (self) {
   if (self.Source != null) {
      return self.Source.SourceText.substring(self.StartIndex, self.EndIndex);
   };
   return "";
});
ZToken.prototype.GetText = GetText__1qw3;

var toString__1qw3 = (function (self) {
   var ch__1 = GetCharAt__2qud(self.Source, self.StartIndex - 1);
   if (ch__1 == "\"") {
      return ("\"" + GetText__1qw3(self)) + "\"";
   };
   return GetText__1qw3(self);
});
ZToken.prototype.toString = toString__1qw3;

var EqualsText__2qw3 = (function (self, Text__1) {
   if (Text__1.size() == (self.EndIndex - self.StartIndex)) {
      var s__6 = self.Source.SourceText;
      var i__7 = 0;
      while (i__3 < Text__1.size()) {
         if (LibZen.GetChar(s__2, self.StartIndex + i__3) != LibZen.GetChar(Text__1, i__3)) {
            return false;
         };
         i__3 = i__3 + 1;
      };
      return true;
   };
   return false;
});
ZToken.prototype.EqualsText = EqualsText__2qw3;

var StartsWith__2qw3 = (function (self, Text__1) {
   if (Text__1.size() <= (self.EndIndex - self.StartIndex)) {
      var s__6 = self.Source.SourceText;
      var i__7 = 0;
      while (i__3 < Text__1.size()) {
         if (LibZen.GetChar(s__2, self.StartIndex + i__3) != LibZen.GetChar(Text__1, i__3)) {
            return false;
         };
         i__3 = i__3 + 1;
      };
      return true;
   };
   return false;
});
ZToken.prototype.StartsWith = StartsWith__2qw3;

var IsNull__1qw3 = (function (self) {
   return (self == ZToken__4qw3(new ZToken(), null, 0, 0));
});
ZToken.prototype.IsNull = IsNull__1qw3;

var IsIndent__1qw3 = (function (self) {
   return (self).constructor.name == (ZIndentToken).name;
});
ZToken.prototype.IsIndent = IsIndent__1qw3;

var IsNextWhiteSpace__1qw3 = (function (self) {
   var ch__1 = GetCharAt__2qud(self.Source, self.EndIndex);
   if (ch__1 == " " || ch__1 == "\t" || ch__1 == "\n") {
      return true;
   };
   return false;
});
ZToken.prototype.IsNextWhiteSpace = IsNextWhiteSpace__1qw3;

var IsNameSymbol__1qw3 = (function (self) {
   var ch__1 = GetCharAt__2qud(self.Source, self.StartIndex);
   return LibZen.IsSymbol(ch__1);
});
ZToken.prototype.IsNameSymbol = IsNameSymbol__1qw3;

var GetIndentSize__1qw3 = (function (self) {
   if (self.Source != null) {
      return CountIndentSize__2qud(self.Source, GetLineHeadPosition__2qud(self.Source, self.StartIndex));
   };
   return 0;
});
ZToken.prototype.GetIndentSize = GetIndentSize__1qw3;

var ZTokenContext__6qwp = (function (self, Generator__1, NameSpace__2, FileName__3, LineNumber__4, SourceText__5) {
   self.Generator = Generator__1;
   self.NameSpace = NameSpace__2;
   self.Source = ZSourceContext__5qwu(new ZSourceContext(), FileName__3, LineNumber__4, SourceText__5, self);
   return null;
});
ZTokenContext.prototype.ZTokenContext = ZTokenContext__6qwp;

var SetParseFlag__2qwp = (function (self, AllowSkipIndent__1) {
   var OldFlag__2 = self.IsAllowSkipIndent;
   self.IsAllowSkipIndent = AllowSkipIndent__1;
   return OldFlag__2;
});
ZTokenContext.prototype.SetParseFlag = SetParseFlag__2qwp;

var GetBeforeToken__1qwp = (function (self) {
   var MovingPos__1 = self.CurrentPosition - 1;
   while (MovingPos__1 >= 0 && MovingPos__1 < (self.TokenList).length) {
      var Token__2 = self.TokenList[MovingPos__1];
      if (!IsIndent__1qw3(Token__2)) {
         return Token__2;
      };
      MovingPos__1 = MovingPos__1 - 1;
   };
   return self.LatestToken;
});
ZTokenContext.prototype.GetBeforeToken = GetBeforeToken__1qwp;

var CreateExpectedErrorNode__3qwp = (function (self, SourceToken__1, ExpectedTokenText__2) {
   if (SourceToken__1 == null || IsNull__1qw3(SourceToken__1)) {
      SourceToken__1 = GetBeforeToken__1qwp(self);
      SourceToken__1 = ZToken__4qw3(new ZToken(), SourceToken__1.Source, SourceToken__1.EndIndex, SourceToken__1.EndIndex);
      return ZErrorNode__4qpr(new ZErrorNode(), null, SourceToken__1, ExpectedTokenText__2 + " is expected");
   };
   return ZErrorNode__4qpr(new ZErrorNode(), null, SourceToken__1, ExpectedTokenText__2 + " is expected");
});
ZTokenContext.prototype.CreateExpectedErrorNode = CreateExpectedErrorNode__3qwp;

var Vacume__1qwp = (function (self) {
   return;
});
ZTokenContext.prototype.Vacume = Vacume__1qwp;

var MoveNext__1qwp = (function (self) {
   self.CurrentPosition = self.CurrentPosition + 1;
   return;
});
ZTokenContext.prototype.MoveNext = MoveNext__1qwp;

var GetToken__2qwp = (function (self, EnforceMoveNext__1) {
   while (true) {
      if (!(self.CurrentPosition < (self.TokenList).length)) {
         if (!DoTokenize__1qwu(self.Source)) {
            break;
         };
      };
      var Token__2 = self.TokenList[self.CurrentPosition];
      if ((self.IsAllowSkipIndent) && IsIndent__1qw3(Token__2)) {
         self.CurrentPosition = self.CurrentPosition + 1;
      } else {
         self.LatestToken = Token__2;
         if (EnforceMoveNext__1) {
            self.CurrentPosition = self.CurrentPosition + 1;
         };
         return Token__2;
      };
   };
   return ZToken__4qw3(new ZToken(), null, 0, 0);
});
ZTokenContext.prototype.GetToken = GetToken__2qwp;

var GetToken__1qwp = (function (self) {
   return GetToken__2qwp(self, false);
});
ZTokenContext.prototype.GetToken = GetToken__1qwp;

var HasNext__1qwp = (function (self) {
   return (GetToken__1qwp(self) != ZToken__4qw3(new ZToken(), null, 0, 0));
});
ZTokenContext.prototype.HasNext = HasNext__1qwp;

var SkipIndent__1qwp = (function (self) {
   var Token__1 = GetToken__1qwp(self);
   while (IsIndent__1qw3(Token__1)) {
      self.CurrentPosition = self.CurrentPosition + 1;
      Token__1 = GetToken__1qwp(self);
   };
   return;
});
ZTokenContext.prototype.SkipIndent = SkipIndent__1qwp;

var SkipError__2qwp = (function (self, ErrorToken__1) {
   var StartIndex__2 = ErrorToken__1.StartIndex;
   var EndIndex__3 = ErrorToken__1.EndIndex;
   var length__4 = GetIndentSize__1qw3(ErrorToken__1);
   while (HasNext__1qwp(self)) {
      var Token__5 = GetToken__1qwp(self);
      EndIndex__3 = Token__5.EndIndex;
      self.CurrentPosition = self.CurrentPosition + 1;
      if ((Token__5).constructor.name == (ZIndentToken).name) {
         var ilength__6 = GetIndentSize__1qw3(Token__5);
         if (ilength__6 <= length__4) {
            break;
         };
      };
   };
   if (StartIndex__2 < EndIndex__3) {
      LibZen.PrintDebug((("StartIdx=" + (StartIndex__2).toString()) + ", EndIndex=") + (EndIndex__3).toString());
      LibZen.PrintDebug("skipped: \t" + ErrorToken__1.Source.SourceText.substring(StartIndex, EndIndex));
   };
   return;
});
ZTokenContext.prototype.SkipError = SkipError__2qwp;

var IsToken__2qwp = (function (self, TokenText__1) {
   var Token__2 = GetToken__1qwp(self);
   if (EqualsText__2qw3(Token__2, TokenText__1)) {
      return true;
   };
   return false;
});
ZTokenContext.prototype.IsToken = IsToken__2qwp;

var IsNewLineToken__2qwp = (function (self, TokenText__1) {
   var RollbackPos__2 = self.CurrentPosition;
   SkipIndent__1qwp(self);
   var Token__3 = GetToken__1qwp(self);
   if (EqualsText__2qw3(Token__3, TokenText__1)) {
      return true;
   };
   self.CurrentPosition = RollbackPos__2;
   return false;
});
ZTokenContext.prototype.IsNewLineToken = IsNewLineToken__2qwp;

var MatchToken__2qwp = (function (self, TokenText__1) {
   var RollbackPos__2 = self.CurrentPosition;
   var Token__3 = GetToken__2qwp(self, true);
   if (EqualsText__2qw3(Token__3, TokenText__1)) {
      return true;
   };
   self.CurrentPosition = RollbackPos__2;
   return false;
});
ZTokenContext.prototype.MatchToken = MatchToken__2qwp;

var MatchNewLineToken__2qwp = (function (self, TokenText__1) {
   var RollbackPos__2 = self.CurrentPosition;
   SkipIndent__1qwp(self);
   var Token__3 = GetToken__2qwp(self, true);
   if (EqualsText__2qw3(Token__3, TokenText__1)) {
      return true;
   };
   self.CurrentPosition = RollbackPos__2;
   return false;
});
ZTokenContext.prototype.MatchNewLineToken = MatchNewLineToken__2qwp;

var ParseLargeToken__1qwp = (function (self) {
   var Token__1 = GetToken__2qwp(self, true);
   if (IsNextWhiteSpace__1qw3(Token__1)) {
      return Token__1;
   };
   var StartIndex__2 = Token__1.StartIndex;
   var EndIndex__3 = Token__1.EndIndex;
   while (HasNext__1qwp(self) && !IsNextWhiteSpace__1qw3(Token__1)) {
      var RollbackPosition__4 = self.CurrentPosition;
      Token__1 = GetToken__2qwp(self, true);
      if (IsIndent__1qw3(Token__1) || EqualsText__2qw3(Token__1, ";") || EqualsText__2qw3(Token__1, ",")) {
         self.CurrentPosition = RollbackPosition__4;
         break;
      };
      EndIndex__3 = Token__1.EndIndex;
   };
   return ZToken__4qw3(new ZToken(), Token__1.Source, StartIndex__2, EndIndex__3);
});
ZTokenContext.prototype.ParseLargeToken = ParseLargeToken__1qwp;

var MatchToken__4qwp = (function (self, ParentNode__1, TokenText__2, IsRequired__3) {
   if (!IsErrorNode__1qwo(ParentNode__1)) {
      var RollbackPosition__4 = self.CurrentPosition;
      var Token__5 = GetToken__2qwp(self, true);
      if (EqualsText__2qw3(Token__5, TokenText__2)) {
         if (ParentNode__1.SourceToken == null) {
            ParentNode__1.SourceToken = Token__5;
         };
      } else {
         if (IsRequired__3) {
            return CreateExpectedErrorNode__3qwp(self, Token__5, TokenText__2);
         } else {
            self.CurrentPosition = RollbackPosition__4;
         };
      };
   };
   return ParentNode__1;
});
ZTokenContext.prototype.MatchToken = MatchToken__4qwp;

var GetApplyingSyntax__1qwp = (function (self) {
   return self.ApplyingPattern;
});
ZTokenContext.prototype.GetApplyingSyntax = GetApplyingSyntax__1qwp;

var ApplyMatchPattern__5qwp = (function (self, ParentNode__1, LeftNode__2, Pattern__3, IsRequired__4) {
   var RollbackPosition__5 = self.CurrentPosition;
   var CurrentPattern__6 = Pattern__3;
   var TopToken__7 = GetToken__1qwp(self);
   var ParsedNode__8 = null;
   while (CurrentPattern__6 != null) {
      var Remembered__9 = self.IsAllowSkipIndent;
      self.CurrentPosition = RollbackPosition__5;
      self.ApplyingPattern = CurrentPattern__6;
      ParsedNode__8 = LibZen.ApplyMatchFunc(CurrentPattern__6.MatchFunc, ParentNode__1, self, LeftNode__2);
      console.assert(ParsedNode__8 != ParentNode__1, "(libzen/libzen.zen:3276)");
      self.ApplyingPattern = null;
      self.IsAllowSkipIndent = Remembered__9;
      if (ParsedNode__8 != null && !IsErrorNode__1qwo(ParsedNode__8)) {
         return ParsedNode__8;
      };
      CurrentPattern__6 = CurrentPattern__6.ParentPattern;
   };
   if (!IsRequired__4) {
      self.CurrentPosition = RollbackPosition__5;
      return null;
   };
   if (self.CurrentPosition == RollbackPosition__5) {
      LibZen.PrintLine((((("DEBUG infinite looping" + (RollbackPosition__5).toString()) + " Token=") + toString__1qw3(TopToken__7)) + " ParsedNode=") + toString__1qwo(ParsedNode__8));
      console.assert(self.CurrentPosition != RollbackPosition__5, "(libzen/libzen.zen:3290)");
   };
   if (ParsedNode__8 == null) {
      ParsedNode__8 = CreateExpectedErrorNode__3qwp(self, TopToken__7, Pattern__3.PatternName);
   };
   return ParsedNode__8;
});
ZTokenContext.prototype.ApplyMatchPattern = ApplyMatchPattern__5qwp;

var ParsePatternAfter__5qwp = (function (self, ParentNode__1, LeftNode__2, PatternName__3, IsRequired__4) {
   var Pattern__5 = GetSyntaxPattern__2qwt(self.NameSpace, PatternName__3);
   var ParsedNode__6 = ApplyMatchPattern__5qwp(self, ParentNode__1, LeftNode__2, Pattern__5, IsRequired__4);
   return ParsedNode__6;
});
ZTokenContext.prototype.ParsePatternAfter = ParsePatternAfter__5qwp;

var ParsePattern__4qwp = (function (self, ParentNode__1, PatternName__2, IsRequired__3) {
   return ParsePatternAfter__5qwp(self, ParentNode__1, null, PatternName__2, IsRequired__3);
});
ZTokenContext.prototype.ParsePattern = ParsePattern__4qwp;

var MatchPattern__6qwp = (function (self, ParentNode__1, Index__2, PatternName__3, IsRequired__4, AllowSkipIndent__5) {
   if (!IsErrorNode__1qwo(ParentNode__1)) {
      var Rememberd__6 = SetParseFlag__2qwp(self, AllowSkipIndent__5);
      var ParsedNode__7 = ParsePattern__4qwp(self, ParentNode__1, PatternName__3, IsRequired__4);
      SetParseFlag__2qwp(self, Rememberd__6);
      if (ParsedNode__7 != null) {
         if (Index__2 == -5) {
            if (!((ParsedNode__7).constructor.name == (ZEmptyNode).name)) {
               Set__3qwo(ParentNode__1, -4, ParsedNode__7);
            };
            if ((ParsedNode__7).constructor.name == (ZBlockNode).name || IsErrorNode__1qwo(ParsedNode__7)) {
               return ParsedNode__7;
            };
         };
         if (IsErrorNode__1qwo(ParsedNode__7)) {
            return ParsedNode__7;
         } else {
            if (!((ParsedNode__7).constructor.name == (ZEmptyNode).name)) {
               Set__3qwo(ParentNode__1, Index__2, ParsedNode__7);
            };
         };
      };
   };
   return ParentNode__1;
});
ZTokenContext.prototype.MatchPattern = MatchPattern__6qwp;

var MatchPattern__5qwp = (function (self, ParentNode__1, Index__2, PatternName__3, IsRequired__4) {
   return MatchPattern__6qwp(self, ParentNode__1, Index__2, PatternName__3, IsRequired__4, false);
});
ZTokenContext.prototype.MatchPattern = MatchPattern__5qwp;

var MatchOptionaPattern__6qwp = (function (self, ParentNode__1, Index__2, AllowNewLine__3, TokenText__4, PatternName__5) {
   if (!IsErrorNode__1qwo(ParentNode__1)) {
      if (MatchToken__2qwp(self, TokenText__4)) {
         return MatchPattern__6qwp(self, ParentNode__1, Index__2, PatternName__5, false, false);
      };
   };
   return ParentNode__1;
});
ZTokenContext.prototype.MatchOptionaPattern = MatchOptionaPattern__6qwp;

var MatchNtimes__6qwp = (function (self, ParentNode__1, StartToken__2, PatternName__3, DelimToken__4, StopToken__5) {
   var Rememberd__6 = SetParseFlag__2qwp(self, true);
   var IsRequired__7 = false;
   if (StartToken__2 != null) {
      ParentNode__1 = MatchToken__4qwp(self, ParentNode__1, StartToken__2, true);
   };
   while (!IsErrorNode__1qwo(ParentNode__1)) {
      if (StopToken__5 != null) {
         var Token__8 = GetToken__1qwp(self);
         if (EqualsText__2qw3(Token__8, StopToken__5)) {
            break;
         };
         IsRequired__7 = true;
      };
      var ParsedNode__9 = ParsePattern__4qwp(self, ParentNode__1, PatternName__3, IsRequired__7);
      if (ParsedNode__9 == null) {
         break;
      };
      if (IsErrorNode__1qwo(ParsedNode__9)) {
         return ParsedNode__9;
      };
      if (!((ParsedNode__9).constructor.name == (ZEmptyNode).name)) {
         Set__3qwo(ParentNode__1, -4, ParsedNode__9);
      };
      if (DelimToken__4 != null) {
         if (!MatchToken__2qwp(self, DelimToken__4)) {
            break;
         };
      };
   };
   if (StopToken__5 != null) {
      ParentNode__1 = MatchToken__4qwp(self, ParentNode__1, StopToken__5, true);
   };
   SetParseFlag__2qwp(self, Rememberd__6);
   return ParentNode__1;
});
ZTokenContext.prototype.MatchNtimes = MatchNtimes__6qwp;

var StartsWithToken__2qwp = (function (self, TokenText__1) {
   var Token__3 = GetToken__1qwp(self);
   if (EqualsText__2qw3(Token__2, TokenText__1)) {
      self.CurrentPosition = self.CurrentPosition + 1;
      return true;
   };
   if (StartsWith__2qw3(Token__2, TokenText__1)) {
      Token__3 = ZToken__4qw3(new ZToken(), Token__2.Source, Token__2.StartIndex + TokenText__1.size(), Token__2.EndIndex);
      self.CurrentPosition = self.CurrentPosition + 1;
      self.TokenList.add(self.CurrentPosition, Token);
      return true;
   };
   return false;
});
ZTokenContext.prototype.StartsWithToken = StartsWithToken__2qwp;

var SkipEmptyStatement__1qwp = (function (self) {
   while (HasNext__1qwp(self)) {
      var Token__1 = GetToken__1qwp(self);
      if (IsIndent__1qw3(Token__1) || EqualsText__2qw3(Token__1, ";")) {
         self.CurrentPosition = self.CurrentPosition + 1;
      } else {
         break;
      };
   };
   return;
});
ZTokenContext.prototype.SkipEmptyStatement = SkipEmptyStatement__1qwp;

var Dump__1qwp = (function (self) {
   var Position__1 = self.CurrentPosition;
   while (Position__1 < (self.TokenList).length) {
      var Token__2 = self.TokenList[Position__1];
      var DumpedToken__3 = "[";
      DumpedToken__3 = ((DumpedToken__3 + (Position__1).toString()) + "] ") + toString__1qw3(Token__2);
      LibZen.PrintDebug(DumpedToken__3);
      Position__1 = Position__1 + 1;
   };
   return;
});
ZTokenContext.prototype.Dump = Dump__1qwp;

var ZTokenFunc__3qqc = (function (self, Func__1, Parent__2) {
   self.Func = Func__1;
   self.ParentFunc = Parent__2;
   return null;
});
ZTokenFunc.prototype.ZTokenFunc = ZTokenFunc__3qqc;

var ZVariable__7quu = (function (self, Parent__1, FuncNode__2, VarFlag__3, VarType__4, VarName__5, SourceToken__6) {
   ZSymbolEntry__3quw(self, Parent__1, FuncNode__2);
   self.VarFlag = VarFlag__3;
   self.VarType = VarType__4;
   self.VarName = VarName__5;
   self.SourceToken = SourceToken__6;
   self.VarUniqueIndex = GetVarIndex__1qrb(FuncNode__2);
   self.UsedCount = 0;
   self.DefCount = 1;
   return null;
});
ZVariable.prototype.ZVariable = ZVariable__7quu;

var IsCaptured__2quu = (function (self, CurrentFunctionNode__1) {
   if (CurrentFunctionNode__1 == self.Node) {
      return false;
   };
   return true;
});
ZVariable.prototype.IsCaptured = IsCaptured__2quu;

var Defined__1quu = (function (self) {
   self.DefCount = self.DefCount + 1;
   return;
});
ZVariable.prototype.Defined = Defined__1quu;

var Used__1quu = (function (self) {
   self.UsedCount = self.UsedCount + 1;
   return;
});
ZVariable.prototype.Used = Used__1quu;

var ZArrayType__3qor = (function (self, TypeFlag__1, ParamType__2) {
   ZGenericType__5qev(self, TypeFlag__1, toString__1qwg(ParamType__2) + "[]", ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)), ParamType__2);
   return null;
});
ZArrayType.prototype.ZArrayType = ZArrayType__3qor;

var ZAnnotationNode__4qoy = (function (self, ParentNode__1, Token__2, Anno__3) {
   ZNode__4qwo(self, ParentNode__1, Token__2, 0);
   return null;
});
ZAnnotationNode.prototype.ZAnnotationNode = ZAnnotationNode__4qoy;

var IsBreakingBlock__1qoy = (function (self) {
   return self.AnnotatedNode.IsBreakingBlock(self.AnnotatedNode);
});
ZAnnotationNode.prototype.IsBreakingBlock = IsBreakingBlock__1qoy;

var Accept__2qoy = (function (self, Visitor__1) {
   self.AnnotatedNode.Accept(self.AnnotatedNode, Visitor__1);
   return;
});
ZAnnotationNode.prototype.Accept = Accept__2qoy;

var ZAssertNode__2qo4 = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   return null;
});
ZAssertNode.prototype.ZAssertNode = ZAssertNode__2qo4;

var DeSugar__2qo4 = (function (self, Generator__1) {
   var Func__2 = GetMacroFunc__4qw4(Generator__1, "assert", ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)), 2);
   if (Func__2 != null) {
      var MacroNode__3 = ZMacroNode__4q06(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__2);
      Append__2quv(MacroNode__3, self.AST[0]);
      Append__2quv(MacroNode__3, ZStringNode__4q4c(new ZStringNode(), MacroNode__3, null, GetSourceLocation__1qwo(self)));
      return ZSugarNode__3qts(new ZSugarNode(), self, MacroNode__3);
   } else {
      var MacroNode__4 = ZFuncCallNode__4q4e(new ZFuncCallNode(), self.ParentNode, "assert", ZType__4qwg(new ZType(), 1 << 16, "var", null));
      Append__2quv(MacroNode__4, self.AST[0]);
      return ZSugarNode__3qts(new ZSugarNode(), self, MacroNode__4);
   };
});
ZAssertNode.prototype.DeSugar = DeSugar__2qo4;

var ZBinaryNode__5qod = (function (self, ParentNode__1, SourceToken__2, Left__3, Pattern__4) {
   ZNode__4qwo(self, ParentNode__1, SourceToken__2, 2);
   Set__3qwo(self, 0, Left__3);
   console.assert(Pattern__4 != null, "(libzen/libzen.zen:3492)");
   self.Pattern = Pattern__4;
   return null;
});
ZBinaryNode.prototype.ZBinaryNode = ZBinaryNode__5qod;

var IsRightJoin__2qod = (function (self, Node__1) {
   if ((Node__1).constructor.name == (ZBinaryNode).name) {
      return IsRightJoin__2qy7(self.Pattern, (Node__1).Pattern);
   };
   return false;
});
ZBinaryNode.prototype.IsRightJoin = IsRightJoin__2qod;

var RightJoin__3qod = (function (self, ParentNode__1, RightNode__2) {
   var RightLeftNode__3 = RightNode__2.AST[0];
   if (IsRightJoin__2qod(self, RightLeftNode__3)) {
      Set__3qwo(RightNode__2, 0, RightJoin__3qod(self, ParentNode__1, RightLeftNode__3));
   } else {
      Set__3qwo(RightNode__2, 0, self);
      Set__3qwo(self, 1, RightLeftNode__3);
   };
   return RightNode__2;
});
ZBinaryNode.prototype.RightJoin = RightJoin__3qod;

var AppendParsedRightNode__3qod = (function (self, ParentNode__1, TokenContext__2) {
   var RightNode__3 = ParsePattern__4qwp(TokenContext__2, ParentNode__1, "$Expression$", true);
   if (IsErrorNode__1qwo(RightNode__3)) {
      return RightNode__3;
   };
   if (IsRightJoin__2qod(self, RightNode__3)) {
      return RightJoin__3qod(self, ParentNode__1, RightNode__3);
   };
   Set__3qwo(self, 1, RightNode__3);
   return self;
});
ZBinaryNode.prototype.AppendParsedRightNode = AppendParsedRightNode__3qod;

var TryMacroNode__2qod = (function (self, Generator__1) {
   if (!GetAstType__2qwo(self, 0).IsVarType(GetAstType__2qwo(self, 0)) && !GetAstType__2qwo(self, 1).IsVarType(GetAstType__2qwo(self, 1))) {
      var Op__2 = GetText__1qw3(self.SourceToken);
      var Func__3 = GetDefinedFunc__4qw4(Generator__1, Op__2, GetAstType__2qwo(self, 0), 2);
      if ((Func__3).constructor.name == (ZMacroFunc).name) {
         var MacroNode__4 = ZMacroNode__4q06(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__3);
         Append__2quv(MacroNode__4, self.AST[0]);
         Append__2quv(MacroNode__4, self.AST[1]);
         return MacroNode__4;
      };
   };
   return self;
});
ZBinaryNode.prototype.TryMacroNode = TryMacroNode__2qod;

var Accept__2qod = (function (self, Visitor__1) {
   Visitor__1.VisitBinaryNode(Visitor__1, self);
   return;
});
ZBinaryNode.prototype.Accept = Accept__2qod;

var ZBreakNode__2qo9 = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 0);
   return null;
});
ZBreakNode.prototype.ZBreakNode = ZBreakNode__2qo9;

var Accept__2qo9 = (function (self, Visitor__1) {
   Visitor__1.VisitBreakNode(Visitor__1, self);
   return;
});
ZBreakNode.prototype.Accept = Accept__2qo9;

var ZCastNode__4qoz = (function (self, ParentNode__1, CastType__2, Node__3) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   self.Type = CastType__2;
   if (Node__3 != null) {
      Set__3qwo(self, 0, Node__3);
   };
   return null;
});
ZCastNode.prototype.ZCastNode = ZCastNode__4qoz;

var Accept__2qoz = (function (self, Visitor__1) {
   Visitor__1.VisitCastNode(Visitor__1, self);
   return;
});
ZCastNode.prototype.Accept = Accept__2qoz;

var ToFuncCallNode__2qoz = (function (self, Func__1) {
   if ((Func__1).constructor.name == (ZMacroFunc).name) {
      var FuncNode__2 = ZMacroNode__4q06(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__1);
      Append__2quv(FuncNode__2, self.AST[0]);
      return FuncNode__2;
   } else {
      var FuncNode__3 = ZFuncCallNode__4q4e(new ZFuncCallNode(), self.ParentNode, Func__1.FuncName, GetFuncType__1qep(Func__1));
      FuncNode__3.SourceToken = self.SourceToken;
      Append__2quv(FuncNode__3, self.AST[0]);
      return FuncNode__3;
   };
});
ZCastNode.prototype.ToFuncCallNode = ToFuncCallNode__2qoz;

var ZCatchNode__2qob = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   return null;
});
ZCatchNode.prototype.ZCatchNode = ZCatchNode__2qob;

var SetTypeInfo__3qob = (function (self, TypeToken__1, Type__2) {
   self.ExceptionType = Type__2;
   return;
});
ZCatchNode.prototype.SetTypeInfo = SetTypeInfo__3qob;

var SetNameInfo__3qob = (function (self, NameToken__1, Name__2) {
   self.ExceptionName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZCatchNode.prototype.SetNameInfo = SetNameInfo__3qob;

var ZComparatorNode__5qo5 = (function (self, ParentNode__1, SourceToken__2, Left__3, Pattern__4) {
   ZBinaryNode__5qod(self, ParentNode__1, SourceToken__2, Left__3, Pattern__4);
   return null;
});
ZComparatorNode.prototype.ZComparatorNode = ZComparatorNode__5qo5;

var Accept__2qo5 = (function (self, Visitor__1) {
   Visitor__1.VisitComparatorNode(Visitor__1, self);
   return;
});
ZComparatorNode.prototype.Accept = Accept__2qo5;

var ZConstNode__3qo8 = (function (self, ParentNode__1, SourceToken__2) {
   ZNode__4qwo(self, ParentNode__1, SourceToken__2, 0);
   return null;
});
ZConstNode.prototype.ZConstNode = ZConstNode__3qo8;

var ZEmptyNode__3qpw = (function (self, ParentNode__1, Token__2) {
   ZNode__4qwo(self, ParentNode__1, Token__2, 0);
   return null;
});
ZEmptyNode.prototype.ZEmptyNode = ZEmptyNode__3qpw;

var ZErrorNode__4qpr = (function (self, ParentNode__1, SourceToken__2, ErrorMessage__3) {
   ZConstNode__3qo8(self, ParentNode__1, SourceToken__2);
   self.ErrorMessage = ErrorMessage__3;
   return null;
});
ZErrorNode.prototype.ZErrorNode = ZErrorNode__4qpr;

var ZErrorNode__3qpr = (function (self, Node__1, ErrorMessage__2) {
   ZConstNode__3qo8(self, Node__1.ParentNode, Node__1.SourceToken);
   self.ErrorMessage = ErrorMessage__2;
   return null;
});
ZErrorNode.prototype.ZErrorNode = ZErrorNode__3qpr;

var Accept__2qpr = (function (self, Visitor__1) {
   Visitor__1.VisitErrorNode(Visitor__1, self);
   return;
});
ZErrorNode.prototype.Accept = Accept__2qpr;

var ZFieldNode__2qpi = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   return null;
});
ZFieldNode.prototype.ZFieldNode = ZFieldNode__2qpi;

var SetTypeInfo__3qpi = (function (self, TypeToken__1, Type__2) {
   self.DeclType = Type__2;
   return;
});
ZFieldNode.prototype.SetTypeInfo = SetTypeInfo__3qpi;

var SetNameInfo__3qpi = (function (self, NameToken__1, Name__2) {
   self.FieldName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZFieldNode.prototype.SetNameInfo = SetNameInfo__3qpi;

var ZFloatNode__4qp4 = (function (self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qo8(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwg(new ZType(), 1 << 16, "float", ZType__4qwg(new ZType(), 1 << 16, "var", null));
   self.FloatValue = Value__3;
   return null;
});
ZFloatNode.prototype.ZFloatNode = ZFloatNode__4qp4;

var Accept__2qp4 = (function (self, Visitor__1) {
   Visitor__1.VisitFloatNode(Visitor__1, self);
   return;
});
ZFloatNode.prototype.Accept = Accept__2qp4;

var ZGetIndexNode__3qpd = (function (self, ParentNode__1, RecvNode__2) {
   ZNode__4qwo(self, ParentNode__1, null, 2);
   self.AST[0] = SetChild__2qwo(self, RecvNode__2);
   return null;
});
ZGetIndexNode.prototype.ZGetIndexNode = ZGetIndexNode__3qpd;

var Accept__2qpd = (function (self, Visitor__1) {
   Visitor__1.VisitGetIndexNode(Visitor__1, self);
   return;
});
ZGetIndexNode.prototype.Accept = Accept__2qpd;

var ZGetNameNode__4qph = (function (self, ParentNode__1, Token__2, NativeName__3) {
   ZNode__4qwo(self, ParentNode__1, Token__2, 0);
   self.VarName = NativeName__3;
   return null;
});
ZGetNameNode.prototype.ZGetNameNode = ZGetNameNode__4qph;

var ZGetNameNode__3qph = (function (self, ParentNode__1, ResolvedFunc__2) {
   ZNode__4qwo(self, ParentNode__1, null, 0);
   self.VarName = ResolvedFunc__2.FuncName;
   self.Type = GetFuncType__1qep(ResolvedFunc__2);
   return null;
});
ZGetNameNode.prototype.ZGetNameNode = ZGetNameNode__3qph;

var Accept__2qph = (function (self, Visitor__1) {
   Visitor__1.VisitGetNameNode(Visitor__1, self);
   return;
});
ZGetNameNode.prototype.Accept = Accept__2qph;

var ToGlobalNameNode__1qph = (function (self) {
   return ZGlobalNameNode__6qpv(new ZGlobalNameNode(), self.ParentNode, self.SourceToken, self.Type, self.VarName, false);
});
ZGetNameNode.prototype.ToGlobalNameNode = ToGlobalNameNode__1qph;

var ZGetterNode__3qp1 = (function (self, ParentNode__1, RecvNode__2) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   Set__3qwo(self, 0, RecvNode__2);
   return null;
});
ZGetterNode.prototype.ZGetterNode = ZGetterNode__3qp1;

var SetNameInfo__3qp1 = (function (self, NameToken__1, Name__2) {
   self.FieldName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZGetterNode.prototype.SetNameInfo = SetNameInfo__3qp1;

var Accept__2qp1 = (function (self, Visitor__1) {
   Visitor__1.VisitGetterNode(Visitor__1, self);
   return;
});
ZGetterNode.prototype.Accept = Accept__2qp1;

var IsStaticField__1qp1 = (function (self) {
   return (self.AST[0]).constructor.name == (ZTypeNode).name;
});
ZGetterNode.prototype.IsStaticField = IsStaticField__1qp1;

var ZGlobalNameNode__6qpv = (function (self, ParentNode__1, SourceToken__2, Type__3, GlobalName__4, IsStaticFuncName__5) {
   ZNode__4qwo(self, ParentNode__1, SourceToken__2, 0);
   self.GlobalName = GlobalName__4;
   self.Type = Type__3;
   self.IsStaticFuncName = IsStaticFuncName__5;
   return null;
});
ZGlobalNameNode.prototype.ZGlobalNameNode = ZGlobalNameNode__6qpv;

var IsGivenName__1qpv = (function (self) {
   return (!self.IsStaticFuncName);
});
ZGlobalNameNode.prototype.IsGivenName = IsGivenName__1qpv;

var Accept__2qpv = (function (self, Visitor__1) {
   Visitor__1.VisitGlobalNameNode(Visitor__1, self);
   return;
});
ZGlobalNameNode.prototype.Accept = Accept__2qpv;

var ZGroupNode__2qp7 = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   return null;
});
ZGroupNode.prototype.ZGroupNode = ZGroupNode__2qp7;

var Accept__2qp7 = (function (self, Visitor__1) {
   Visitor__1.VisitGroupNode(Visitor__1, self);
   return;
});
ZGroupNode.prototype.Accept = Accept__2qp7;

var ZIfNode__2qp2 = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 3);
   return null;
});
ZIfNode.prototype.ZIfNode = ZIfNode__2qp2;

var Accept__2qp2 = (function (self, Visitor__1) {
   Visitor__1.VisitIfNode(Visitor__1, self);
   return;
});
ZIfNode.prototype.Accept = Accept__2qp2;

var ZImportNode__2q0w = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 0);
   return null;
});
ZImportNode.prototype.ZImportNode = ZImportNode__2q0w;

var SetNameInfo__3q0w = (function (self, NameToken__1, Name__2) {
   if (self.ResourcePath == null) {
      self.ResourcePath = Name__2;
      self.ResourceToken = NameToken__1;
   } else {
      self.Alias = Name__2;
   };
   return;
});
ZImportNode.prototype.SetNameInfo = SetNameInfo__3q0w;

var ZInstanceOfNode__4q0t = (function (self, ParentNode__1, Token__2, LeftNode__3) {
   ZNode__4qwo(self, ParentNode__1, Token__2, 1);
   Set__3qwo(self, 0, LeftNode__3);
   return null;
});
ZInstanceOfNode.prototype.ZInstanceOfNode = ZInstanceOfNode__4q0t;

var SetTypeInfo__3q0t = (function (self, TypeToken__1, Type__2) {
   self.TargetType = Type__2;
   return;
});
ZInstanceOfNode.prototype.SetTypeInfo = SetTypeInfo__3q0t;

var Accept__2q0t = (function (self, Visitor__1) {
   Visitor__1.VisitInstanceOfNode(Visitor__1, self);
   return;
});
ZInstanceOfNode.prototype.Accept = Accept__2q0t;

var ZIntNode__4q0o = (function (self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qo8(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null));
   self.IntValue = Value__3;
   return null;
});
ZIntNode.prototype.ZIntNode = ZIntNode__4q0o;

var Accept__2q0o = (function (self, Visitor__1) {
   Visitor__1.VisitIntNode(Visitor__1, self);
   return;
});
ZIntNode.prototype.Accept = Accept__2q0o;

var ZLetNode__2q04 = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 1);
   return null;
});
ZLetNode.prototype.ZLetNode = ZLetNode__2q04;

var SetNameInfo__3q04 = (function (self, NameToken__1, Name__2) {
   self.Symbol = Name__2;
   self.SymbolToken = NameToken__1;
   return;
});
ZLetNode.prototype.SetNameInfo = SetNameInfo__3q04;

var SetTypeInfo__3q04 = (function (self, TypeToken__1, Type__2) {
   self.SymbolType = Type__2;
   return;
});
ZLetNode.prototype.SetTypeInfo = SetTypeInfo__3q04;

var Accept__2q04 = (function (self, Visitor__1) {
   Visitor__1.VisitLetNode(Visitor__1, self);
   return;
});
ZLetNode.prototype.Accept = Accept__2q04;

var ToGlobalNameNode__1q04 = (function (self) {
   return ZGlobalNameNode__6qpv(new ZGlobalNameNode(), null, self.SymbolToken, GetAstType__2qwo(self, 0), self.GlobalName, false);
});
ZLetNode.prototype.ToGlobalNameNode = ToGlobalNameNode__1q04;

var ZListNode__4quv = (function (self, ParentNode__1, SourceToken__2, Size__3) {
   ZNode__4qwo(self, ParentNode__1, SourceToken__2, Size__3);
   self.ListStartIndex = Size__3;
   return null;
});
ZListNode.prototype.ZListNode = ZListNode__4quv;

var Append__2quv = (function (self, Node__1) {
   if (self.AST == null) {
      self.AST = LibZen.NewNodeArray(1);
      Set__3qwo(self, 0, Node__1);
   } else {
      var newAST__2 = LibZen.NewNodeArray((self.AST).length + 1);
      LibZen.ArrayCopy(self.AST, 0, newAST__2, 0, (self.AST).length);
      self.AST = newAST__2;
      Set__3qwo(self, (self.AST).length - 1, Node__1);
   };
   return;
});
ZListNode.prototype.Append = Append__2quv;

var GetListSize__1quv = (function (self) {
   return GetAstSize__1qwo(self) - self.ListStartIndex;
});
ZListNode.prototype.GetListSize = GetListSize__1quv;

var GetListAt__2quv = (function (self, Index__1) {
   return self.AST[self.ListStartIndex + Index__1];
});
ZListNode.prototype.GetListAt = GetListAt__2quv;

var SetListAt__3quv = (function (self, Index__1, Node__2) {
   Set__3qwo(self, Index__1 + self.ListStartIndex, Node__2);
   return;
});
ZListNode.prototype.SetListAt = SetListAt__3quv;

var InsertListAt__3quv = (function (self, Index__1, Node__2) {
   if (self.AST == null || Index__1 < 0 || (self.AST).length == Index__1) {
      Append__2quv(self, Node__2);
   } else {
      var newAST__3 = LibZen.NewNodeArray((self.AST).length + 1);
      Index__1 = self.ListStartIndex + Index__1;
      LibZen.ArrayCopy(self.AST, 0, newAST__3, 0, Index__1);
      Set__3qwo(self, Index__1, Node__2);
      LibZen.ArrayCopy(self.AST, Index__1, newAST__3, Index__1 + 1, (self.AST).length - Index__1);
      self.AST = newAST__3;
   };
   return;
});
ZListNode.prototype.InsertListAt = InsertListAt__3quv;

var RemoveListAt__2quv = (function (self, Index__1) {
   var Removed__2 = GetListAt__2quv(self, Index__1);
   var newAST__3 = LibZen.NewNodeArray((self.AST).length - 1);
   var RemovedIndex__4 = self.ListStartIndex + Index__1;
   LibZen.ArrayCopy(self.AST, 0, newAST__3, 0, RemovedIndex__4);
   LibZen.ArrayCopy(self.AST, RemovedIndex__4 + 1, newAST__3, RemovedIndex__4, (self.AST).length - (RemovedIndex__4 + 1));
   self.AST = newAST__3;
   return Removed__2;
});
ZListNode.prototype.RemoveListAt = RemoveListAt__2quv;

var ClearListAfter__2quv = (function (self, Size__1) {
   if (Size__1 < GetListSize__1quv(self)) {
      var newsize__2 = self.ListStartIndex + Size__1;
      if (newsize__2 == 0) {
         self.AST = null;
      } else {
         var newAST__3 = LibZen.NewNodeArray(newsize__2);
         LibZen.ArrayCopy(self.AST, 0, newAST__3, 0, newsize__2);
         self.AST = newAST__3;
      };
   };
   return;
});
ZListNode.prototype.ClearListAfter = ClearListAfter__2quv;

var ZMacroNode__4q06 = (function (self, ParentNode__1, SourceToken__2, MacroFunc__3) {
   ZListNode__4quv(self, ParentNode__1, SourceToken__2, 0);
   self.MacroFunc = MacroFunc__3;
   console.assert(MacroFunc__3 != null, "(libzen/libzen.zen:3850)");
   return null;
});
ZMacroNode.prototype.ZMacroNode = ZMacroNode__4q06;

var GetFuncType__1q06 = (function (self) {
   return GetFuncType__1qep(self.MacroFunc);
});
ZMacroNode.prototype.GetFuncType = GetFuncType__1q06;

var GetMacroText__1q06 = (function (self) {
   var Func__1 = self.MacroFunc;
   if ((Func__1).constructor.name == (ZSourceMacro).name) {
      return (Func__1).Macro;
   };
   return "";
});
ZMacroNode.prototype.GetMacroText = GetMacroText__1q06;

var Accept__2q06 = (function (self, Visitor__1) {
   Visitor__1.VisitMacroNode(Visitor__1, self);
   return;
});
ZMacroNode.prototype.Accept = Accept__2q06;

var ZMapEntryNode__2q0b = (function (self, ParentNode__1) {
   ZNode__4qwo(self, ParentNode__1, null, 2);
   return null;
});
ZMapEntryNode.prototype.ZMapEntryNode = ZMapEntryNode__2q0b;

var ZMapLiteralNode__2q0m = (function (self, ParentNode__1) {
   ZListNode__4quv(self, ParentNode__1, null, 0);
   return null;
});
ZMapLiteralNode.prototype.ZMapLiteralNode = ZMapLiteralNode__2q0m;

var GetMapEntryNode__2q0m = (function (self, Index__1) {
   var Node__2 = GetListAt__2quv(self, Index__1);
   if ((Node__2).constructor.name == (ZMapEntryNode).name) {
      return Node__2;
   };
   return null;
});
ZMapLiteralNode.prototype.GetMapEntryNode = GetMapEntryNode__2q0m;

var Accept__2q0m = (function (self, Visitor__1) {
   Visitor__1.VisitMapLiteralNode(Visitor__1, self);
   return;
});
ZMapLiteralNode.prototype.Accept = Accept__2q0m;

var ZMethodCallNode__3q02 = (function (self, ParentNode__1, RecvNode__2) {
   ZListNode__4quv(self, ParentNode__1, null, 1);
   Set__3qwo(self, 0, RecvNode__2);
   return null;
});
ZMethodCallNode.prototype.ZMethodCallNode = ZMethodCallNode__3q02;

var SetNameInfo__3q02 = (function (self, NameToken__1, Name__2) {
   self.MethodName = Name__2;
   self.MethodToken = NameToken__1;
   return;
});
ZMethodCallNode.prototype.SetNameInfo = SetNameInfo__3q02;

var Accept__2q02 = (function (self, Visitor__1) {
   Visitor__1.VisitMethodCallNode(Visitor__1, self);
   return;
});
ZMethodCallNode.prototype.Accept = Accept__2q02;

var ToGetterFuncCall__1q02 = (function (self) {
   var Getter__4 = ZGetterNode__3qp1(new ZGetterNode(), null, self.AST[0]);
   Getter__1.SetNameInfo(Getter__1, self.MethodToken, self.MethodName);
   var FuncNode__2 = ZFuncCallNode__3q4e(new ZFuncCallNode(), self.ParentNode, Getter__1);
   FuncNode__2.SourceToken = self.SourceToken;
   Append__2quv(FuncNode__2, self.AST[0]);
   var i__3 = 0;
   while (i__3 < GetListSize__1quv(self)) {
      Append__2quv(FuncNode__2, GetListAt__2quv(self, i__3));
      i__3 = i__3 + 1;
   };
   return FuncNode__2;
});
ZMethodCallNode.prototype.ToGetterFuncCall = ToGetterFuncCall__1q02;

var ToFuncCallNode__2q02 = (function (self, Func__1) {
   if ((Func__1).constructor.name == (ZMacroFunc).name) {
      var MacroNode__2 = ZMacroNode__4q06(new ZMacroNode(), self.ParentNode, self.MethodToken, Func__1);
      Append__2quv(MacroNode__2, self.AST[0]);
      var i__3 = 0;
      while (i__3 < GetListSize__1quv(self)) {
         Append__2quv(MacroNode__2, GetListAt__2quv(self, i__3));
         i__3 = i__3 + 1;
      };
      return MacroNode__2;
   } else {
      var FuncNode__4 = ZFuncCallNode__4q4e(new ZFuncCallNode(), self.ParentNode, Func__1.FuncName, GetFuncType__1qep(Func__1));
      FuncNode__4.SourceToken = self.MethodToken;
      Append__2quv(FuncNode__4, self.AST[0]);
      var i__5 = 0;
      while (i__5 < GetListSize__1quv(self)) {
         Append__2quv(FuncNode__4, GetListAt__2quv(self, i__5));
         i__5 = i__5 + 1;
      };
      return FuncNode__4;
   };
});
ZMethodCallNode.prototype.ToFuncCallNode = ToFuncCallNode__2q02;

var ZNewArrayNode__4q4y = (function (self, ParentNode__1, Type__2, Token__3) {
   ZListNode__4quv(self, ParentNode__1, null, 0);
   return null;
});
ZNewArrayNode.prototype.ZNewArrayNode = ZNewArrayNode__4q4y;

var ZNewObjectNode__2q4i = (function (self, ParentNode__1) {
   ZListNode__4quv(self, ParentNode__1, null, 0);
   return null;
});
ZNewObjectNode.prototype.ZNewObjectNode = ZNewObjectNode__2q4i;

var Accept__2q4i = (function (self, Visitor__1) {
   Visitor__1.VisitNewObjectNode(Visitor__1, self);
   return;
});
ZNewObjectNode.prototype.Accept = Accept__2q4i;

var ToFuncCallNode__2q4i = (function (self, Func__1) {
   var FuncNode__2 = null;
   if ((Func__1).constructor.name == (ZMacroFunc).name) {
      FuncNode__2 = ZMacroNode__4q06(new ZMacroNode(), self.ParentNode, self.SourceToken, Func__1);
   } else {
      FuncNode__2 = ZFuncCallNode__4q4e(new ZFuncCallNode(), self.ParentNode, Func__1.FuncName, GetFuncType__1qep(Func__1));
      FuncNode__2.SourceToken = self.SourceToken;
   };
   Append__2quv(FuncNode__2, self);
   var i__3 = 0;
   while (i__3 < GetListSize__1quv(self)) {
      Append__2quv(FuncNode__2, GetListAt__2quv(self, i__3));
      i__3 = i__3 + 1;
   };
   ClearListAfter__2quv(self, 0);
   return FuncNode__2;
});
ZNewObjectNode.prototype.ToFuncCallNode = ToFuncCallNode__2q4i;

var ZNotNode__3q44 = (function (self, ParentNode__1, Token__2) {
   ZUnaryNode__3qyp(self, ParentNode__1, Token__2);
   return null;
});
ZNotNode.prototype.ZNotNode = ZNotNode__3q44;

var Accept__2q44 = (function (self, Visitor__1) {
   Visitor__1.VisitNotNode(Visitor__1, self);
   return;
});
ZNotNode.prototype.Accept = Accept__2q44;

var ZNullNode__3q4d = (function (self, ParentNode__1, SourceToken__2) {
   ZConstNode__3qo8(self, ParentNode__1, SourceToken__2);
   return null;
});
ZNullNode.prototype.ZNullNode = ZNullNode__3q4d;

var Accept__2q4d = (function (self, Visitor__1) {
   Visitor__1.VisitNullNode(Visitor__1, self);
   return;
});
ZNullNode.prototype.Accept = Accept__2q4d;

var ZOrNode__5q4h = (function (self, ParentNode__1, Token__2, Left__3, Pattern__4) {
   ZBinaryNode__5qod(self, ParentNode__1, Token__2, Left__3, Pattern__4);
   return null;
});
ZOrNode.prototype.ZOrNode = ZOrNode__5q4h;

var Accept__2q4h = (function (self, Visitor__1) {
   Visitor__1.VisitOrNode(Visitor__1, self);
   return;
});
ZOrNode.prototype.Accept = Accept__2q4h;

var ZPrototypeNode__2q4l = (function (self, ParentNode__1) {
   ZListNode__4quv(self, ParentNode__1, null, 0);
   return null;
});
ZPrototypeNode.prototype.ZPrototypeNode = ZPrototypeNode__2q4l;

var SetTypeInfo__3q4l = (function (self, TypeToken__1, Type__2) {
   self.ReturnType = Type__2;
   return;
});
ZPrototypeNode.prototype.SetTypeInfo = SetTypeInfo__3q4l;

var SetNameInfo__3q4l = (function (self, NameToken__1, Name__2) {
   self.FuncName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZPrototypeNode.prototype.SetNameInfo = SetNameInfo__3q4l;

var GetParamNode__2q4l = (function (self, Index__1) {
   var Node__2 = GetListAt__2quv(self, Index__1);
   if ((Node__2).constructor.name == (ZParamNode).name) {
      return Node__2;
   };
   return null;
});
ZPrototypeNode.prototype.GetParamNode = GetParamNode__2q4l;

var GetFuncType__1q4l = (function (self) {
   var TypeList__5 = [];
   TypeList__1.push(self.ReturnType.GetRealType(self.ReturnType));
   var i__6 = 0;
   while (i__2 < GetListSize__1quv(self)) {
      var Node__7 = GetParamNode__2q4l(self, i__2);
      var ParamType__8 = Node__3.Type.GetRealType(Node__3.Type);
      TypeList__1.push(ParamType__4);
      i__2 = i__2 + 1;
   };
   return ZTypePool_LookupFuncType__1qwh(TypeList__1);
});
ZPrototypeNode.prototype.GetFuncType = GetFuncType__1q4l;

var ZStringNode__4q4c = (function (self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qo8(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null));
   self.StringValue = Value__3;
   return null;
});
ZStringNode.prototype.ZStringNode = ZStringNode__4q4c;

var Accept__2q4c = (function (self, Visitor__1) {
   Visitor__1.VisitStringNode(Visitor__1, self);
   return;
});
ZStringNode.prototype.Accept = Accept__2q4c;

var ZStupidCastErrorNode__3q4n = (function (self, Node__1, ErrorMessage__2) {
   ZErrorNode__3qpr(self, Node__1, ErrorMessage__2);
   self.ErrorNode = Node__1;
   return null;
});
ZStupidCastErrorNode.prototype.ZStupidCastErrorNode = ZStupidCastErrorNode__3q4n;

var ZTypeNode__4qu4 = (function (self, ParentNode__1, SourceToken__2, ParsedType__3) {
   ZConstNode__3qo8(self, ParentNode__1, SourceToken__2);
   self.Type = ParsedType__3;
   return null;
});
ZTypeNode.prototype.ZTypeNode = ZTypeNode__4qu4;

var ZGenerator__3qw4 = (function (self, LanguageExtension__1, TargetVersion__2) {
   self.RootNameSpace = ZNameSpace__3qwt(new ZNameSpace(), self, null);
   self.GrammarInfo = "";
   self.LanguageExtention = LanguageExtension__1;
   self.TargetVersion = TargetVersion__2;
   self.OutputFile = null;
   self.Logger = new ZLogger();
   self.StoppedVisitor = false;
   return null;
});
ZGenerator.prototype.ZGenerator = ZGenerator__3qw4;

var ImportLocalGrammar__2qw4 = (function (self, NameSpace__1) {
   return;
});
ZGenerator.prototype.ImportLocalGrammar = ImportLocalGrammar__2qw4;

var WriteTo__2qw4 = (function (self, FileName__1) {
   return;
});
ZGenerator.prototype.WriteTo = WriteTo__2qw4;

var GetSourceText__1qw4 = (function (self) {
   return null;
});
ZGenerator.prototype.GetSourceText = GetSourceText__1qw4;

var NameOutputFile__2qw4 = (function (self, FileName__1) {
   if (FileName__1 != null) {
      return (FileName__1 + ".") + self.LanguageExtention;
   };
   return FileName__1;
});
ZGenerator.prototype.NameOutputFile = NameOutputFile__2qw4;

var EnableVisitor__1qw4 = (function (self) {
   self.StoppedVisitor = false;
   return;
});
ZGenerator.prototype.EnableVisitor = EnableVisitor__1qw4;

var StopVisitor__1qw4 = (function (self) {
   self.StoppedVisitor = true;
   return;
});
ZGenerator.prototype.StopVisitor = StopVisitor__1qw4;

var IsVisitable__1qw4 = (function (self) {
   return !self.StoppedVisitor;
});
ZGenerator.prototype.IsVisitable = IsVisitable__1qw4;

var GetGrammarInfo__1qw4 = (function (self) {
   return self.GrammarInfo;
});
ZGenerator.prototype.GetGrammarInfo = GetGrammarInfo__1qw4;

var AppendGrammarInfo__2qw4 = (function (self, GrammarInfo__1) {
   self.GrammarInfo = (self.GrammarInfo + GrammarInfo__1) + " ";
   return;
});
ZGenerator.prototype.AppendGrammarInfo = AppendGrammarInfo__2qw4;

var GetTargetLangInfo__1qw4 = (function (self) {
   return self.LanguageExtention + self.TargetVersion;
});
ZGenerator.prototype.GetTargetLangInfo = GetTargetLangInfo__1qw4;

var GetFieldType__3qw4 = (function (self, BaseType__1, Name__2) {
   return ZType__4qwg(new ZType(), 1 << 16, "var", null);
});
ZGenerator.prototype.GetFieldType = GetFieldType__3qw4;

var GetSetterType__3qw4 = (function (self, BaseType__1, Name__2) {
   return ZType__4qwg(new ZType(), 1 << 16, "var", null);
});
ZGenerator.prototype.GetSetterType = GetSetterType__3qw4;

var GetConstructorFuncType__3qw4 = (function (self, ClassType__1, List__2) {
   return ZFuncType__3qe0(new ZFuncType(), "Func", null);
});
ZGenerator.prototype.GetConstructorFuncType = GetConstructorFuncType__3qw4;

var GetMethodFuncType__4qw4 = (function (self, RecvType__1, MethodName__2, List__3) {
   return ZFuncType__3qe0(new ZFuncType(), "Func", null);
});
ZGenerator.prototype.GetMethodFuncType = GetMethodFuncType__4qw4;

var GetUniqueNumber__1qw4 = (function (self) {
   var UniqueNumber__1 = self.UniqueNumber;
   self.UniqueNumber = self.UniqueNumber + 1;
   return UniqueNumber__1;
});
ZGenerator.prototype.GetUniqueNumber = GetUniqueNumber__1qw4;

var NameGlobalSymbol__2qw4 = (function (self, Symbol__1) {
   return (Symbol__1 + "_Z") + (GetUniqueNumber__1qw4(self)).toString();
});
ZGenerator.prototype.NameGlobalSymbol = NameGlobalSymbol__2qw4;

var NameClass__2qw4 = (function (self, ClassType__1) {
   return (ClassType__1.ShortName + "") + (ClassType__1.TypeId).toString();
});
ZGenerator.prototype.NameClass = NameClass__2qw4;

var SetDefinedFunc__2qw4 = (function (self, Func__1) {
   self.DefinedFuncMap[GetSignature__1qep(Func__1)] = Func__1;
   return;
});
ZGenerator.prototype.SetDefinedFunc = SetDefinedFunc__2qw4;

var SetPrototype__4qw4 = (function (self, Node__1, FuncName__2, FuncType__3) {
   var Func__4 = GetDefinedFunc__3qw4(self, FuncName__2, FuncType__3);
   if (Func__4 != null) {
      if (!Equals__2qwg(FuncType__3, GetFuncType__1qep(Func__4))) {
         ZLogger_LogError__2qw3(Node__1.SourceToken, "function has been defined diffrently: " + toString__1qwg(GetFuncType__1qep(Func__4)));
         return null;
      };
      if ((Func__4).constructor.name == (ZPrototype).name) {
         return Func__4;
      };
      ZLogger_LogError__2qw3(Node__1.SourceToken, "function has been defined as macro" + toString__1qep(Func__4));
      return null;
   };
   var Proto__5 = ZPrototype__5qry(new ZPrototype(), 0, FuncName__2, FuncType__3, Node__1.SourceToken);
   self.DefinedFuncMap[GetSignature__1qep(Proto__5)] = Proto__5;
   return Proto__5;
});
ZGenerator.prototype.SetPrototype = SetPrototype__4qw4;

var GetDefinedFunc__2qw4 = (function (self, GlobalName__1) {
   var Func__2 = self.DefinedFuncMap[GlobalName__1];
   if (Func__2 == null && LibZen.IsLetter(LibZen.GetChar(GlobalName__1, 0))) {
      Func__2 = self.DefinedFuncMap[LibZen.AnotherName(GlobalName__1)];
   };
   return Func__2;
});
ZGenerator.prototype.GetDefinedFunc = GetDefinedFunc__2qw4;

var GetDefinedFunc__3qw4 = (function (self, FuncName__1, FuncType__2) {
   return GetDefinedFunc__2qw4(self, StringfySignature__2qe0(FuncType__2, FuncName__1));
});
ZGenerator.prototype.GetDefinedFunc = GetDefinedFunc__3qw4;

var GetDefinedFunc__4qw4 = (function (self, FuncName__1, RecvType__2, FuncParamSize__3) {
   return GetDefinedFunc__2qw4(self, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
});
ZGenerator.prototype.GetDefinedFunc = GetDefinedFunc__4qw4;

var LookupFunc__4qw4 = (function (self, FuncName__1, RecvType__2, FuncParamSize__3) {
   var Func__5 = GetDefinedFunc__2qw4(self, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
   while (Func__4 == null) {
      RecvType__2 = RecvType__2.GetSuperType(RecvType__2);
      if (RecvType__2 == null) {
         break;
      };
      Func__4 = GetDefinedFunc__2qw4(self, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
   };
   return Func__4;
});
ZGenerator.prototype.LookupFunc = LookupFunc__4qw4;

var GetMacroFunc__4qw4 = (function (self, FuncName__1, RecvType__2, FuncParamSize__3) {
   var Func__4 = GetDefinedFunc__2qw4(self, ZFunc_StringfySignature__3qqy(FuncName__1, FuncParamSize__3, RecvType__2));
   if ((Func__4).constructor.name == (ZMacroFunc).name) {
      return (Func__4);
   };
   return null;
});
ZGenerator.prototype.GetMacroFunc = GetMacroFunc__4qw4;

var NameConverterFunc__3qw4 = (function (self, FromType__1, ToType__2) {
   return (GetUniqueName__1qwg(FromType__1) + "T") + GetUniqueName__1qwg(ToType__2);
});
ZGenerator.prototype.NameConverterFunc = NameConverterFunc__3qw4;

var SetConverterFunc__4qw4 = (function (self, FromType__1, ToType__2, Func__3) {
   self.DefinedFuncMap[NameConverterFunc__3qw4(self, FromType__1, ToType__2)] = Func__3;
   return;
});
ZGenerator.prototype.SetConverterFunc = SetConverterFunc__4qw4;

var LookupConverterFunc__3qw4 = (function (self, FromType__1, ToType__2) {
   while (FromType__1 != null) {
      var Func__3 = self.DefinedFuncMap[NameConverterFunc__3qw4(self, FromType__1, ToType__2)];
      if (Func__3 != null) {
         return Func__3;
      };
      FromType__1 = FromType__1.GetSuperType(FromType__1);
   };
   return null;
});
ZGenerator.prototype.LookupConverterFunc = LookupConverterFunc__3qw4;

var GetCoercionFunc__3qw4 = (function (self, FromType__1, ToType__2) {
   while (FromType__1 != null) {
      var Func__3 = self.DefinedFuncMap[NameConverterFunc__3qw4(self, FromType__1, ToType__2)];
      if (Func__3 != null && IsCoercionFunc__1qep(Func__3)) {
         return Func__3;
      };
      FromType__1 = FromType__1.GetSuperType(FromType__1);
   };
   return null;
});
ZGenerator.prototype.GetCoercionFunc = GetCoercionFunc__3qw4;

var VisitExtendedNode__2qw4 = (function (self, Node__1) {
   var DeNode__2 = Node__1.DeSugar(Node__1, self);
   DeNode__2.Accept(DeNode__2, self);
   return;
});
ZGenerator.prototype.VisitExtendedNode = VisitExtendedNode__2qw4;

var VisitSugarNode__2qw4 = (function (self, Node__1) {
   Node__1.AST[0].Accept(Node__1.AST[0], self);
   return;
});
ZGenerator.prototype.VisitSugarNode = VisitSugarNode__2qw4;

var ZIndentToken__4qak = (function (self, Source__1, StartIndex__2, EndIndex__3) {
   ZToken__4qw3(self, Source__1, StartIndex__2, EndIndex__3);
   return null;
});
ZIndentToken.prototype.ZIndentToken = ZIndentToken__4qak;

var ZPatternToken__5qa9 = (function (self, Source__1, StartIndex__2, EndIndex__3, PresetPattern__4) {
   ZToken__4qw3(self, Source__1, StartIndex__2, EndIndex__3);
   self.PresetPattern = PresetPattern__4;
   return null;
});
ZPatternToken.prototype.ZPatternToken = ZPatternToken__5qa9;

var ZSourceEngine__3qws = (function (self, TypeChecker__1, Generator__2) {
   self.TypeChecker = TypeChecker__1;
   self.Generator = Generator__2;
   self.Logger = Generator__2.Logger;
   return null;
});
ZSourceEngine.prototype.ZSourceEngine = ZSourceEngine__3qws;

var IsVisitable__1qws = (function (self) {
   return self.IsVisitableFlag;
});
ZSourceEngine.prototype.IsVisitable = IsVisitable__1qws;

var EnableVisitor__1qws = (function (self) {
   self.IsVisitableFlag = true;
   return;
});
ZSourceEngine.prototype.EnableVisitor = EnableVisitor__1qws;

var StopVisitor__1qws = (function (self) {
   self.IsVisitableFlag = false;
   return;
});
ZSourceEngine.prototype.StopVisitor = StopVisitor__1qws;

var Eval2__2qws = (function (self, Node__1) {
   if (self.IsVisitable(self)) {
      Node__1.Accept(Node__1, self);
   };
   return;
});
ZSourceEngine.prototype.Eval2 = Eval2__2qws;

var VisitPrototypeNode__2qws = (function (self, Node__1) {
   var FuncType__2 = GetFuncType__1q4l(Node__1);
   SetPrototype__4qw4(self.Generator, Node__1, Node__1.FuncName, FuncType__2);
   return;
});
ZSourceEngine.prototype.VisitPrototypeNode = VisitPrototypeNode__2qws;

var VisitImportNode__2qws = (function (self, Node__1) {
   Node__1.Import(Node__1);
   return;
});
ZSourceEngine.prototype.VisitImportNode = VisitImportNode__2qws;

var Exec2__3qws = (function (self, Node__1, IsInteractive__2) {
   self.InteractiveContext = IsInteractive__2;
   self.EnableVisitor(self);
   if ((Node__1).constructor.name == (ZPrototypeNode).name) {
      VisitPrototypeNode__2qws(self, Node__1);
   } else if ((Node__1).constructor.name == (ZImportNode).name) {
      VisitImportNode__2qws(self, Node__1);
   } else {
      Node__1 = CheckType__3qrc(self.TypeChecker, Node__1, ZType__4qwg(new ZType(), 1 << 16, "void", null));
      Eval2__2qws(self, Node__1);
   };
   return;
});
ZSourceEngine.prototype.Exec2 = Exec2__3qws;

var Translate__4qws = (function (self, ScriptText__1, FileName__2, LineNumber__3) {
   var TopBlockNode__4 = ZBlockNode__2qtp(new ZBlockNode(), self.Generator.RootNameSpace);
   var TokenContext__5 = ZTokenContext__6qwp(new ZTokenContext(), self.Generator, self.Generator.RootNameSpace, FileName__2, LineNumber__3, ScriptText__1);
   SkipEmptyStatement__1qwp(TokenContext__5);
   var SkipToken__6 = GetToken__1qwp(TokenContext__5);
   while (HasNext__1qwp(TokenContext__5)) {
      SetParseFlag__2qwp(TokenContext__5, false);
      ClearListAfter__2quv(TopBlockNode__4, 0);
      SkipToken__6 = GetToken__1qwp(TokenContext__5);
      var ParsedNode__7 = ParsePattern__4qwp(TokenContext__5, TopBlockNode__4, "$Statement$", true);
      if (IsErrorNode__1qwo(ParsedNode__7)) {
         SkipError__2qwp(TokenContext__5, SkipToken__6);
      };
      Exec2__3qws(self, ParsedNode__7, false);
      SkipEmptyStatement__1qwp(TokenContext__5);
      Vacume__1qwp(TokenContext__5);
   };
   return self.Generator.GetSourceText(self.Generator);
});
ZSourceEngine.prototype.Translate = Translate__4qws;

var Unsupported__2qws = (function (self, Node__1) {
   if (self.InteractiveContext) {
      self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   } else {
      ZLogger_LogError__2qw3(Node__1.SourceToken, "unsupported at top level");
      self.StopVisitor(self);
   };
   return;
});
ZSourceEngine.prototype.Unsupported = Unsupported__2qws;

var VisitNullNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitNullNode = VisitNullNode__2qws;

var VisitBooleanNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitBooleanNode = VisitBooleanNode__2qws;

var VisitIntNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitIntNode = VisitIntNode__2qws;

var VisitFloatNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitFloatNode = VisitFloatNode__2qws;

var VisitStringNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitStringNode = VisitStringNode__2qws;

var VisitArrayLiteralNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitArrayLiteralNode = VisitArrayLiteralNode__2qws;

var VisitMapLiteralNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitMapLiteralNode = VisitMapLiteralNode__2qws;

var VisitNewObjectNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitNewObjectNode = VisitNewObjectNode__2qws;

var VisitGlobalNameNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitGlobalNameNode = VisitGlobalNameNode__2qws;

var VisitGetNameNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitGetNameNode = VisitGetNameNode__2qws;

var VisitSetNameNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitSetNameNode = VisitSetNameNode__2qws;

var VisitGroupNode__2qws = (function (self, Node__1) {
   Eval2__2qws(self, Node__1.AST[0]);
   return;
});
ZSourceEngine.prototype.VisitGroupNode = VisitGroupNode__2qws;

var VisitGetterNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitGetterNode = VisitGetterNode__2qws;

var VisitSetterNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitSetterNode = VisitSetterNode__2qws;

var VisitGetIndexNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitGetIndexNode = VisitGetIndexNode__2qws;

var VisitSetIndexNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitSetIndexNode = VisitSetIndexNode__2qws;

var VisitMacroNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitMacroNode = VisitMacroNode__2qws;

var VisitFuncCallNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitFuncCallNode = VisitFuncCallNode__2qws;

var VisitMethodCallNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitMethodCallNode = VisitMethodCallNode__2qws;

var VisitUnaryNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitUnaryNode = VisitUnaryNode__2qws;

var VisitNotNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitNotNode = VisitNotNode__2qws;

var VisitCastNode__2qws = (function (self, Node__1) {
   if (IsVoidType__1qwg(Node__1.Type)) {
      Eval2__2qws(self, Node__1.AST[0]);
      Node__1.Type = Node__1.AST[0].Type;
   } else {
      Unsupported__2qws(self, Node__1);
   };
   return;
});
ZSourceEngine.prototype.VisitCastNode = VisitCastNode__2qws;

var VisitInstanceOfNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitInstanceOfNode = VisitInstanceOfNode__2qws;

var VisitBinaryNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitBinaryNode = VisitBinaryNode__2qws;

var VisitComparatorNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitComparatorNode = VisitComparatorNode__2qws;

var VisitAndNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitAndNode = VisitAndNode__2qws;

var VisitOrNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitOrNode = VisitOrNode__2qws;

var VisitBlockNode__2qws = (function (self, Node__1) {
   var i__2 = 1;
   while (i__2 < GetListSize__1quv(Node__1) && self.IsVisitable(self)) {
      var StmtNode__3 = GetListAt__2quv(Node__1, i__2);
      Eval2__2qws(self, StmtNode__3);
      if (StmtNode__3.IsBreakingBlock(StmtNode__3)) {
         break;
      };
   };
   return;
});
ZSourceEngine.prototype.VisitBlockNode = VisitBlockNode__2qws;

var VisitVarNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitVarNode = VisitVarNode__2qws;

var VisitIfNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitIfNode = VisitIfNode__2qws;

var VisitReturnNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitReturnNode = VisitReturnNode__2qws;

var VisitWhileNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitWhileNode = VisitWhileNode__2qws;

var VisitBreakNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitBreakNode = VisitBreakNode__2qws;

var VisitThrowNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitThrowNode = VisitThrowNode__2qws;

var VisitTryNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitTryNode = VisitTryNode__2qws;

var VisitLetNode__2qws = (function (self, Node__1) {
   if (HasUntypedNode__1qwo(Node__1)) {
      LibZen.PrintDebug((("HasUntypedNode: " + HasUntypedNode__1qwo(Node__1)) + "\n") + toString__1qwo(Node__1));
   };
   self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   return;
});
ZSourceEngine.prototype.VisitLetNode = VisitLetNode__2qws;

var VisitFunctionNode__2qws = (function (self, Node__1) {
   if (HasUntypedNode__1qwo(Node__1)) {
      LibZen.PrintDebug((("HasUntypedNode: " + HasUntypedNode__1qwo(Node__1)) + "\nLAZY: ") + toString__1qwo(Node__1));
   };
   self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   return;
});
ZSourceEngine.prototype.VisitFunctionNode = VisitFunctionNode__2qws;

var VisitClassNode__2qws = (function (self, Node__1) {
   if (HasUntypedNode__1qwo(Node__1)) {
      LibZen.PrintDebug((("HasUntypedNode: " + HasUntypedNode__1qwo(Node__1)) + "\n") + toString__1qwo(Node__1));
   };
   self.Generator.StartCodeGeneration(self.Generator, Node__1, self.InteractiveContext);
   return;
});
ZSourceEngine.prototype.VisitClassNode = VisitClassNode__2qws;

var VisitErrorNode__2qws = (function (self, Node__1) {
   ZLogger_LogError__2qw3(Node__1.SourceToken, Node__1.ErrorMessage);
   self.StopVisitor(self);
   return;
});
ZSourceEngine.prototype.VisitErrorNode = VisitErrorNode__2qws;

var VisitTypeNode__2qws = (function (self, Node__1) {
   Unsupported__2qws(self, Node__1);
   return;
});
ZSourceEngine.prototype.VisitTypeNode = VisitTypeNode__2qws;

var VisitExtendedNode__2qws = (function (self, Node__1) {
   if ((Node__1).constructor.name == (ZTypeNode).name) {
      VisitTypeNode__2qws(self, Node__1);
   } else {
      var SugarNode__2 = Node__1.DeSugar(Node__1, self.Generator);
      SugarNode__2.Accept(SugarNode__2, self);
   };
   return;
});
ZSourceEngine.prototype.VisitExtendedNode = VisitExtendedNode__2qws;

var VisitSugarNode__2qws = (function (self, Node__1) {
   Eval2__2qws(self, Node__1.AST[0]);
   return;
});
ZSourceEngine.prototype.VisitSugarNode = VisitSugarNode__2qws;

var WriteTo__2qws = (function (self, OutputFile__1) {
   self.Generator.WriteTo(self.Generator, OutputFile__1);
   ShowErrors__1qrk(self.Generator.Logger);
   return;
});
ZSourceEngine.prototype.WriteTo = WriteTo__2qws;

var ZSourceGenerator__3quk = (function (self, TargetCode__1, TargetVersion__2) {
   ZGenerator__3qw4(self, TargetCode__1, TargetVersion__2);
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
});
ZSourceGenerator.prototype.ZSourceGenerator = ZSourceGenerator__3quk;

var InitBuilderList__1quk = (function (self) {
   self.CurrentBuilder = null;
   self.BuilderList.clear(0);
   self.HeaderBuilder = AppendNewSourceBuilder__1quk(self);
   self.CurrentBuilder = AppendNewSourceBuilder__1quk(self);
   return;
});
ZSourceGenerator.prototype.InitBuilderList = InitBuilderList__1quk;

var GetEngine__1quk = (function (self) {
   LibZen.PrintLine("FIXME: Overide GetEngine in each generator!!");
   return ZSourceEngine__3qws(new ZSourceEngine(), ZTypeChecker__2qrc(new ZTypeChecker(), self), self);
});
ZSourceGenerator.prototype.GetEngine = GetEngine__1quk;

var AppendNewSourceBuilder__1quk = (function (self) {
   var Builder__1 = ZSourceBuilder__3qq2(new ZSourceBuilder(), self, self.CurrentBuilder);
   self.BuilderList.push(Builder__1);
   return Builder__1;
});
ZSourceGenerator.prototype.AppendNewSourceBuilder = AppendNewSourceBuilder__1quk;

var InsertNewSourceBuilder__1quk = (function (self) {
   var Builder__3 = ZSourceBuilder__3qq2(new ZSourceBuilder(), self, self.CurrentBuilder);
   var i__4 = 0;
   while (i__2 < (self.BuilderList).length) {
      if (self.BuilderList[i__2] == self.CurrentBuilder) {
         self.BuilderList.add(i, Builder);
         return Builder__1;
      };
      i__2 = i__2 + 1;
   };
   self.BuilderList.push(Builder__1);
   return Builder__1;
});
ZSourceGenerator.prototype.InsertNewSourceBuilder = InsertNewSourceBuilder__1quk;

var SetNativeType__3quk = (function (self, Type__1, TypeName__2) {
   var Key__3 = "" + (Type__1.TypeId).toString();
   self.NativeTypeMap[Key__3] = TypeName__2;
   return;
});
ZSourceGenerator.prototype.SetNativeType = SetNativeType__3quk;

var GetNativeTypeName__2quk = (function (self, Type__1) {
   var Key__2 = "" + (Type__1.TypeId).toString();
   var TypeName__3 = self.NativeTypeMap[Key__2];
   if (TypeName__3 == null) {
      return Type__1.ShortName;
   };
   return TypeName__3;
});
ZSourceGenerator.prototype.GetNativeTypeName = GetNativeTypeName__2quk;

var SetReservedName__3quk = (function (self, Keyword__1, AnotherName__2) {
   if (AnotherName__2 == null) {
      AnotherName__2 = "_" + Keyword__1;
   };
   self.ReservedNameMap[Keyword__1] = AnotherName__2;
   return;
});
ZSourceGenerator.prototype.SetReservedName = SetReservedName__3quk;

var SafeName__3quk = (function (self, Name__1, Index__2) {
   if (Index__2 == 0) {
      var SafeName__3 = self.ReservedNameMap[Name__1];
      if (SafeName__3 == null) {
         SafeName__3 = Name__1;
      };
      return SafeName__3;
   };
   return (Name__1 + "__") + (Index__2).toString();
});
ZSourceGenerator.prototype.SafeName = SafeName__3quk;

var SetMacro__4quk = (function (self, FuncName__1, Macro__2, ReturnType__3) {
   var FuncType__4 = ZTypePool_LookupFuncType__1qwg(ReturnType__3);
   SetDefinedFunc__2qw4(self, ZSourceMacro__4qiy(new ZSourceMacro(), FuncName__1, FuncType__4, Macro__2));
   return;
});
ZSourceGenerator.prototype.SetMacro = SetMacro__4quk;

var SetMacro__5quk = (function (self, FuncName__1, Macro__2, ReturnType__3, P1__4) {
   var FuncType__5 = ZTypePool_LookupFuncType__2qwg(ReturnType__3, P1__4);
   SetDefinedFunc__2qw4(self, ZSourceMacro__4qiy(new ZSourceMacro(), FuncName__1, FuncType__5, Macro__2));
   return;
});
ZSourceGenerator.prototype.SetMacro = SetMacro__5quk;

var SetMacro__6quk = (function (self, FuncName__1, Macro__2, ReturnType__3, P1__4, P2__5) {
   var FuncType__6 = ZTypePool_LookupFuncType__3qwg(ReturnType__3, P1__4, P2__5);
   SetDefinedFunc__2qw4(self, ZSourceMacro__4qiy(new ZSourceMacro(), FuncName__1, FuncType__6, Macro__2));
   return;
});
ZSourceGenerator.prototype.SetMacro = SetMacro__6quk;

var SetMacro__7quk = (function (self, FuncName__1, Macro__2, ReturnType__3, P1__4, P2__5, P3__6) {
   var FuncType__7 = ZTypePool_LookupFuncType__4qwg(ReturnType__3, P1__4, P2__5, P3__6);
   SetDefinedFunc__2qw4(self, ZSourceMacro__4qiy(new ZSourceMacro(), FuncName__1, FuncType__7, Macro__2));
   return;
});
ZSourceGenerator.prototype.SetMacro = SetMacro__7quk;

var SetConverterMacro__4quk = (function (self, Macro__1, ReturnType__2, P1__3) {
   var FuncType__4 = ZTypePool_LookupFuncType__2qwg(ReturnType__2, P1__3);
   SetConverterFunc__4qw4(self, P1__3, ReturnType__2, ZSourceMacro__4qiy(new ZSourceMacro(), "to" + NameClass__2qw4(self, ReturnType__2), FuncType__4, Macro__1));
   return;
});
ZSourceGenerator.prototype.SetConverterMacro = SetConverterMacro__4quk;

var WriteTo__2quk = (function (self, FileName__1) {
   LibZen.WriteTo(self.NameOutputFile(self, FileName__1), self.BuilderList);
   self.InitBuilderList(self);
   return;
});
ZSourceGenerator.prototype.WriteTo = WriteTo__2quk;

var GetSourceText__1quk = (function (self) {
   var sb__4 = ZSourceBuilder__3qq2(new ZSourceBuilder(), self, null);
   var i__5 = 0;
   while (i__2 < (self.BuilderList).length) {
      var Builder__3 = self.BuilderList[i__2];
      Append__2qq2(sb__1, toString__1qq2(Builder__3));
      Clear__1qq2(Builder__3);
      AppendLineFeed__1qq2(sb__1);
      AppendLineFeed__1qq2(sb__1);
      i__2 = i__2 + 1;
   };
   self.InitBuilderList(self);
   return LibZen.SourceBuilderToString(sb__1);
});
ZSourceGenerator.prototype.GetSourceText = GetSourceText__1quk;

var StartCodeGeneration__3quk = (function (self, Node__1, IsInteractive__2) {
   Node__1.Accept(Node__1, self);
   if (IsInteractive__2) {
      var i__5 = 0;
      LibZen.PrintLine("---");
      while (i__3 < (self.BuilderList).length) {
         var Builder__4 = self.BuilderList[i__3];
         LibZen.PrintLine(toString__1qq2(Builder__4));
         Clear__1qq2(Builder__4);
         i__3 = i__3 + 1;
      };
      self.InitBuilderList(self);
   };
   return true;
});
ZSourceGenerator.prototype.StartCodeGeneration = StartCodeGeneration__3quk;

var GenerateCode__3quk = (function (self, ContextType__1, Node__2) {
   Node__2.Accept(Node__2, self);
   return;
});
ZSourceGenerator.prototype.GenerateCode = GenerateCode__3quk;

var IsNeededSurroud__2quk = (function (self, Node__1) {
   if ((Node__1).constructor.name == (ZBinaryNode).name) {
      return true;
   };
   return false;
});
ZSourceGenerator.prototype.IsNeededSurroud = IsNeededSurroud__2quk;

var GenerateSurroundCode__2quk = (function (self, Node__1) {
   if (IsNeededSurroud__2quk(self, Node__1)) {
      Append__2qq2(self.CurrentBuilder, "(");
      self.GenerateCode(self, null, Node__1);
      Append__2qq2(self.CurrentBuilder, ")");
   } else {
      self.GenerateCode(self, null, Node__1);
   };
   return;
});
ZSourceGenerator.prototype.GenerateSurroundCode = GenerateSurroundCode__2quk;

var AppendCode__2quk = (function (self, RawSource__1) {
   Append__2qq2(self.CurrentBuilder, RawSource__1);
   return;
});
ZSourceGenerator.prototype.AppendCode = AppendCode__2quk;

var VisitStmtList__2quk = (function (self, BlockNode__1) {
   var i__2 = 0;
   while (i__2 < GetListSize__1quv(BlockNode__1)) {
      var SubNode__3 = GetListAt__2quv(BlockNode__1, i__2);
      AppendLineFeed__1qq2(self.CurrentBuilder);
      AppendIndent__1qq2(self.CurrentBuilder);
      self.GenerateCode(self, null, SubNode__3);
      i__2 = i__2 + 1;
      if (i__2 < GetListSize__1quv(BlockNode__1)) {
         Append__2qq2(self.CurrentBuilder, self.SemiColon);
      };
   };
   return;
});
ZSourceGenerator.prototype.VisitStmtList = VisitStmtList__2quk;

var VisitBlockNode__2quk = (function (self, Node__1) {
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, "{");
   Indent__1qq2(self.CurrentBuilder);
   VisitStmtList__2quk(self, Node__1);
   if (GetListSize__1quv(Node__1) > 0) {
      Append__2qq2(self.CurrentBuilder, self.SemiColon);
   };
   UnIndent__1qq2(self.CurrentBuilder);
   AppendLineFeed__1qq2(self.CurrentBuilder);
   AppendIndent__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, "}");
   return;
});
ZSourceGenerator.prototype.VisitBlockNode = VisitBlockNode__2quk;

var VisitNullNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, self.NullLiteral);
   return;
});
ZSourceGenerator.prototype.VisitNullNode = VisitNullNode__2quk;

var VisitBooleanNode__2quk = (function (self, Node__1) {
   if (Node__1.BooleanValue) {
      Append__2qq2(self.CurrentBuilder, self.TrueLiteral);
   } else {
      Append__2qq2(self.CurrentBuilder, self.FalseLiteral);
   };
   return;
});
ZSourceGenerator.prototype.VisitBooleanNode = VisitBooleanNode__2quk;

var VisitIntNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "" + ((Node__1.IntValue)).toString());
   return;
});
ZSourceGenerator.prototype.VisitIntNode = VisitIntNode__2quk;

var VisitFloatNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "" + ((Node__1.FloatValue)).toString());
   return;
});
ZSourceGenerator.prototype.VisitFloatNode = VisitFloatNode__2quk;

var VisitStringNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, LibZen.QuoteString(Node__1.StringValue));
   return;
});
ZSourceGenerator.prototype.VisitStringNode = VisitStringNode__2quk;

var VisitArrayLiteralNode__2quk = (function (self, Node__1) {
   VisitListNode__4quk(self, "[", Node__1, "]");
   return;
});
ZSourceGenerator.prototype.VisitArrayLiteralNode = VisitArrayLiteralNode__2quk;

var VisitMapLiteralNode__2quk = (function (self, Node__1) {
   return;
});
ZSourceGenerator.prototype.VisitMapLiteralNode = VisitMapLiteralNode__2quk;

var VisitNewObjectNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "new");
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   GenerateTypeName__2quk(self, Node__1.Type);
   VisitListNode__4quk(self, "(", Node__1, ")");
   return;
});
ZSourceGenerator.prototype.VisitNewObjectNode = VisitNewObjectNode__2quk;

var VisitGroupNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "(");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, ")");
   return;
});
ZSourceGenerator.prototype.VisitGroupNode = VisitGroupNode__2quk;

var VisitGetIndexNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, "[");
   self.GenerateCode(self, null, Node__1.AST[1]);
   Append__2qq2(self.CurrentBuilder, "]");
   return;
});
ZSourceGenerator.prototype.VisitGetIndexNode = VisitGetIndexNode__2quk;

var VisitSetIndexNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, "[");
   self.GenerateCode(self, null, Node__1.AST[1]);
   Append__2qq2(self.CurrentBuilder, "]");
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[2]);
   return;
});
ZSourceGenerator.prototype.VisitSetIndexNode = VisitSetIndexNode__2quk;

var VisitGlobalNameNode__2quk = (function (self, Node__1) {
   if (IsUntyped__1qwo(Node__1)) {
      ZLogger_LogError__2qw3(Node__1.SourceToken, "undefined symbol: " + Node__1.GlobalName);
   };
   if (Node__1.IsStaticFuncName) {
      Append__2qq2(self.CurrentBuilder, StringfySignature__2qwg(Node__1.Type, Node__1.GlobalName));
   } else {
      Append__2qq2(self.CurrentBuilder, Node__1.GlobalName);
   };
   return;
});
ZSourceGenerator.prototype.VisitGlobalNameNode = VisitGlobalNameNode__2quk;

var VisitGetNameNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, SafeName__3quk(self, Node__1.VarName, Node__1.VarIndex));
   return;
});
ZSourceGenerator.prototype.VisitGetNameNode = VisitGetNameNode__2quk;

var VisitSetNameNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, SafeName__3quk(self, Node__1.VarName, Node__1.VarIndex));
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitSetNameNode = VisitSetNameNode__2quk;

var VisitGetterNode__2quk = (function (self, Node__1) {
   GenerateSurroundCode__2quk(self, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, ".");
   Append__2qq2(self.CurrentBuilder, Node__1.FieldName);
   return;
});
ZSourceGenerator.prototype.VisitGetterNode = VisitGetterNode__2quk;

var VisitSetterNode__2quk = (function (self, Node__1) {
   GenerateSurroundCode__2quk(self, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, ".");
   Append__2qq2(self.CurrentBuilder, Node__1.FieldName);
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
});
ZSourceGenerator.prototype.VisitSetterNode = VisitSetterNode__2quk;

var VisitMethodCallNode__2quk = (function (self, Node__1) {
   GenerateSurroundCode__2quk(self, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, ".");
   Append__2qq2(self.CurrentBuilder, Node__1.MethodName);
   VisitListNode__4quk(self, "(", Node__1, ")");
   return;
});
ZSourceGenerator.prototype.VisitMethodCallNode = VisitMethodCallNode__2quk;

var VisitMacroNode__2quk = (function (self, Node__1) {
   var Macro__14 = GetMacroText__1q06(Node__1);
   var FuncType__15 = GetFuncType__1q06(Node__1);
   var fromIndex__16 = 0;
   var BeginNum__17 = Macro__2.indexOf("$[", fromIndex);
   while (BeginNum__5 != -1) {
      var EndNum__18 = Macro__2.indexOf("]", BeginNum + 2);
      if (EndNum__6 == -1) {
         break;
      };
      Append__2qq2(self.CurrentBuilder, Macro__2.substring(fromIndex, BeginNum));
      var Index__19 = LibZen_ParseInt(Macro__2.substring(BeginNum + 2, EndNum));
      if (HasAst__2qwo(Node__1, Index__7)) {
         self.GenerateCode(self, GetFuncParamType__2qe0(FuncType__3, Index__7), Node__1.AST[Index__7]);
      };
      fromIndex__4 = EndNum__6 + 1;
      BeginNum__17 = Macro__2.indexOf("$[", fromIndex);
   };
   Append__2qq2(self.CurrentBuilder, Macro__2.substring(fromIndex));
   return;
});
ZSourceGenerator.prototype.VisitMacroNode = VisitMacroNode__2quk;

var VisitFuncCallNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   VisitListNode__4quk(self, "(", Node__1, ")");
   return;
});
ZSourceGenerator.prototype.VisitFuncCallNode = VisitFuncCallNode__2quk;

var VisitUnaryNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, GetText__1qw3(Node__1.SourceToken));
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitUnaryNode = VisitUnaryNode__2quk;

var VisitNotNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, self.NotOperator);
   GenerateSurroundCode__2quk(self, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitNotNode = VisitNotNode__2quk;

var VisitCastNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "(");
   GenerateTypeName__2quk(self, Node__1.Type);
   Append__2qq2(self.CurrentBuilder, ")");
   GenerateSurroundCode__2quk(self, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitCastNode = VisitCastNode__2quk;

var VisitInstanceOfNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qq2(self.CurrentBuilder, "instanceof");
   GenerateTypeName__2quk(self, Node__1.AST[1].Type);
   return;
});
ZSourceGenerator.prototype.VisitInstanceOfNode = VisitInstanceOfNode__2quk;

var VisitBinaryNode__2quk = (function (self, Node__1) {
   if ((Node__1.ParentNode).constructor.name == (ZBinaryNode).name) {
      Append__2qq2(self.CurrentBuilder, "(");
   };
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qq2(self.CurrentBuilder, GetText__1qw3(Node__1.SourceToken));
   self.GenerateCode(self, null, Node__1.AST[1]);
   if ((Node__1.ParentNode).constructor.name == (ZBinaryNode).name) {
      Append__2qq2(self.CurrentBuilder, ")");
   };
   return;
});
ZSourceGenerator.prototype.VisitBinaryNode = VisitBinaryNode__2quk;

var VisitComparatorNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qq2(self.CurrentBuilder, GetText__1qw3(Node__1.SourceToken));
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
});
ZSourceGenerator.prototype.VisitComparatorNode = VisitComparatorNode__2quk;

var VisitAndNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qq2(self.CurrentBuilder, self.AndOperator);
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
});
ZSourceGenerator.prototype.VisitAndNode = VisitAndNode__2quk;

var VisitOrNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   AppendToken__2qq2(self.CurrentBuilder, self.OrOperator);
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
});
ZSourceGenerator.prototype.VisitOrNode = VisitOrNode__2quk;

var VisitIfNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "if (");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, ")");
   self.GenerateCode(self, null, Node__1.AST[1]);
   if (Node__1.AST[2] != null) {
      AppendToken__2qq2(self.CurrentBuilder, "else");
      self.GenerateCode(self, null, Node__1.AST[2]);
   };
   return;
});
ZSourceGenerator.prototype.VisitIfNode = VisitIfNode__2quk;

var VisitReturnNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "return");
   if (Node__1.AST[0] != null) {
      AppendWhiteSpace__1qq2(self.CurrentBuilder);
      self.GenerateCode(self, null, Node__1.AST[0]);
   };
   return;
});
ZSourceGenerator.prototype.VisitReturnNode = VisitReturnNode__2quk;

var VisitWhileNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "while (");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, ")");
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
});
ZSourceGenerator.prototype.VisitWhileNode = VisitWhileNode__2quk;

var VisitBreakNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "break");
   return;
});
ZSourceGenerator.prototype.VisitBreakNode = VisitBreakNode__2quk;

var VisitThrowNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "throw");
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitThrowNode = VisitThrowNode__2quk;

var VisitTryNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "try");
   self.GenerateCode(self, null, Node__1.AST[0]);
   if (Node__1.AST[1] != null) {
      self.GenerateCode(self, null, Node__1.AST[1]);
   };
   if (Node__1.AST[2] != null) {
      Append__2qq2(self.CurrentBuilder, "finally");
      self.GenerateCode(self, null, Node__1.AST[2]);
   };
   return;
});
ZSourceGenerator.prototype.VisitTryNode = VisitTryNode__2quk;

var VisitCatchNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "catch (");
   Append__2qq2(self.CurrentBuilder, Node__1.ExceptionName);
   VisitTypeAnnotation__2quk(self, Node__1.ExceptionType);
   Append__2qq2(self.CurrentBuilder, ")");
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitCatchNode = VisitCatchNode__2quk;

var VisitVarNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "var");
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, Node__1.NativeName);
   VisitTypeAnnotation__2quk(self, Node__1.DeclType);
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, self.SemiColon);
   VisitStmtList__2quk(self, Node__1);
   return;
});
ZSourceGenerator.prototype.VisitVarNode = VisitVarNode__2quk;

var VisitTypeAnnotation__2quk = (function (self, Type__1) {
   Append__2qq2(self.CurrentBuilder, ": ");
   GenerateTypeName__2quk(self, Type__1);
   return;
});
ZSourceGenerator.prototype.VisitTypeAnnotation = VisitTypeAnnotation__2quk;

var VisitLetNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "let");
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, Node__1.GlobalName);
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitLetNode = VisitLetNode__2quk;

var VisitParamNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, SafeName__3quk(self, Node__1.Name, Node__1.ParamIndex));
   VisitTypeAnnotation__2quk(self, Node__1.Type);
   return;
});
ZSourceGenerator.prototype.VisitParamNode = VisitParamNode__2quk;

var VisitFunctionNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "function");
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   if (Node__1.FuncName != null) {
      Append__2qq2(self.CurrentBuilder, Node__1.FuncName);
   };
   VisitListNode__4quk(self, "(", Node__1, ")");
   VisitTypeAnnotation__2quk(self, Node__1.ReturnType);
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitFunctionNode = VisitFunctionNode__2quk;

var VisitClassNode__2quk = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "class");
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, Node__1.ClassName);
   if (Node__1.SuperType != null) {
      AppendToken__2qq2(self.CurrentBuilder, "extends");
      GenerateTypeName__2quk(self, Node__1.SuperType);
   };
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, "{");
   Indent__1qq2(self.CurrentBuilder);
   var i__2 = 0;
   while (i__2 < GetListSize__1quv(Node__1)) {
      var FieldNode__3 = GetFieldNode__2qdq(Node__1, i__2);
      AppendLineFeed__1qq2(self.CurrentBuilder);
      AppendIndent__1qq2(self.CurrentBuilder);
      Append__2qq2(self.CurrentBuilder, "var");
      AppendWhiteSpace__1qq2(self.CurrentBuilder);
      Append__2qq2(self.CurrentBuilder, FieldNode__3.FieldName);
      VisitTypeAnnotation__2quk(self, FieldNode__3.DeclType);
      if (HasAst__2qwo(FieldNode__3, 0)) {
         AppendToken__2qq2(self.CurrentBuilder, "=");
         self.GenerateCode(self, null, FieldNode__3.AST[0]);
      };
      Append__2qq2(self.CurrentBuilder, self.SemiColon);
      i__2 = i__2 + 1;
   };
   UnIndent__1qq2(self.CurrentBuilder);
   AppendLineFeed__1qq2(self.CurrentBuilder);
   AppendIndent__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, "}");
   return;
});
ZSourceGenerator.prototype.VisitClassNode = VisitClassNode__2quk;

var VisitErrorNode__2quk = (function (self, Node__1) {
   ZLogger_LogError__2qw3(Node__1.SourceToken, Node__1.ErrorMessage);
   Append__2qq2(self.CurrentBuilder, "ThrowError(");
   Append__2qq2(self.CurrentBuilder, LibZen.QuoteString(Node__1.ErrorMessage));
   Append__2qq2(self.CurrentBuilder, ")");
   return;
});
ZSourceGenerator.prototype.VisitErrorNode = VisitErrorNode__2quk;

var VisitExtendedNode__2quk = (function (self, Node__1) {
   if ((Node__1).constructor.name == (ZParamNode).name) {
      VisitParamNode__2quk(self, Node__1);
   } else {
      var SugarNode__2 = Node__1.DeSugar(Node__1, self);
      self.VisitSugarNode(self, SugarNode__2);
   };
   return;
});
ZSourceGenerator.prototype.VisitExtendedNode = VisitExtendedNode__2quk;

var VisitSugarNode__2quk = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
ZSourceGenerator.prototype.VisitSugarNode = VisitSugarNode__2quk;

var GenerateTypeName__2quk = (function (self, Type__1) {
   Append__2qq2(self.CurrentBuilder, GetNativeTypeName__2quk(self, Type__1.GetRealType(Type__1)));
   return;
});
ZSourceGenerator.prototype.GenerateTypeName = GenerateTypeName__2quk;

var VisitListNode__5quk = (function (self, OpenToken__1, VargNode__2, DelimToken__3, CloseToken__4) {
   Append__2qq2(self.CurrentBuilder, OpenToken__1);
   var i__5 = 0;
   while (i__5 < GetListSize__1quv(VargNode__2)) {
      var ParamNode__6 = GetListAt__2quv(VargNode__2, i__5);
      if (i__5 > 0) {
         Append__2qq2(self.CurrentBuilder, DelimToken__3);
      };
      self.GenerateCode(self, null, ParamNode__6);
      i__5 = i__5 + 1;
   };
   Append__2qq2(self.CurrentBuilder, CloseToken__4);
   return;
});
ZSourceGenerator.prototype.VisitListNode = VisitListNode__5quk;

var VisitListNode__4quk = (function (self, OpenToken__1, VargNode__2, CloseToken__3) {
   VisitListNode__5quk(self, OpenToken__1, VargNode__2, ", ", CloseToken__3);
   return;
});
ZSourceGenerator.prototype.VisitListNode = VisitListNode__4quk;

var ZTypeChecker__2qrc = (function (self, Generator__1) {
   self.Generator = Generator__1;
   self.Logger = Generator__1.Logger;
   self.StackedContextType = null;
   self.ReturnedNode = null;
   self.StoppedVisitor = false;
   self.VarScope = ZVarScope__4qrj(new ZVarScope(), null, self.Logger, null);
   return null;
});
ZTypeChecker.prototype.ZTypeChecker = ZTypeChecker__2qrc;

var EnableVisitor__1qrc = (function (self) {
   self.StoppedVisitor = false;
   return;
});
ZTypeChecker.prototype.EnableVisitor = EnableVisitor__1qrc;

var StopVisitor__1qrc = (function (self) {
   self.StoppedVisitor = true;
   return;
});
ZTypeChecker.prototype.StopVisitor = StopVisitor__1qrc;

var IsVisitable__1qrc = (function (self) {
   return !self.StoppedVisitor;
});
ZTypeChecker.prototype.IsVisitable = IsVisitable__1qrc;

var GetContextType__1qrc = (function (self) {
   return self.StackedContextType;
});
ZTypeChecker.prototype.GetContextType = GetContextType__1qrc;

var VisitTypeChecker__3qrc = (function (self, Node__1, ContextType__2) {
   var ParentNode__4 = Node__1.ParentNode;
   self.StackedContextType = ContextType__2;
   self.ReturnedNode = null;
   Node__1.Accept(Node__1, self);
   if (self.ReturnedNode == null) {
      LibZen.PrintDebug("!! returns no value: " + toString__1qwo(Node__1));
   } else {
      Node__1 = self.ReturnedNode;
   };
   if (ParentNode__3 != Node__1.ParentNode && ParentNode__3 != null) {
      SetChild__2qwo(ParentNode__3, Node__1);
   };
   CheckVarNode__3qrj(self.VarScope, ContextType__2, Node__1);
   return Node__1;
});
ZTypeChecker.prototype.VisitTypeChecker = VisitTypeChecker__3qrc;

var CreateStupidCastNode__3qrc = (function (self, Requested__1, Node__2) {
   var ErrorNode__3 = ZStupidCastErrorNode__3q4n(new ZStupidCastErrorNode(), Node__2, (("type error: requested=" + toString__1qwg(Requested__1)) + ", given=") + toString__1qwg(Node__2.Type));
   ErrorNode__3.Type = Requested__1;
   return ErrorNode__3;
});
ZTypeChecker.prototype.CreateStupidCastNode = CreateStupidCastNode__3qrc;

var EnforceNodeType__3qrc = (function (self, Node__1, EnforcedType__2) {
   var Func__3 = LookupConverterFunc__3qw4(self.Generator, Node__1.Type, EnforcedType__2);
   if (Func__3 == null && IsStringType__1qwg(EnforcedType__2)) {
      Func__3 = LookupFunc__4qw4(self.Generator, "toString", Node__1.Type, 1);
   };
   if ((Func__3).constructor.name == (ZMacroFunc).name) {
      var MacroNode__4 = ZMacroNode__4q06(new ZMacroNode(), Node__1.ParentNode, null, Func__3);
      Append__2quv(MacroNode__4, Node__1);
      MacroNode__4.Type = EnforcedType__2;
      return MacroNode__4;
   } else if (Func__3 != null) {
      var MacroNode__5 = ZFuncCallNode__4q4e(new ZFuncCallNode(), Node__1.ParentNode, Func__3.FuncName, GetFuncType__1qep(Func__3));
      Append__2quv(MacroNode__5, Node__1);
      MacroNode__5.Type = EnforcedType__2;
      return MacroNode__5;
   };
   return CreateStupidCastNode__3qrc(self, EnforcedType__2, Node__1);
});
ZTypeChecker.prototype.EnforceNodeType = EnforceNodeType__3qrc;

var TypeCheckImpl__4qrc = (function (self, Node__1, ContextType__2, TypeCheckPolicy__3) {
   if (IsErrorNode__1qwo(Node__1)) {
      if (!ContextType__2.IsVarType(ContextType__2)) {
         Node__1.Type = ContextType__2;
      };
      return Node__1;
   };
   if (IsUntyped__1qwo(Node__1) || ContextType__2.IsVarType(ContextType__2) || LibZen.IsFlag(TypeCheckPolicy__3, 1)) {
      return Node__1;
   };
   if (Node__1.Type == ContextType__2 || Accept__2qwg(ContextType__2, Node__1.Type)) {
      return Node__1;
   };
   if (IsVoidType__1qwg(ContextType__2) && !IsVoidType__1qwg(Node__1.Type)) {
      return ZCastNode__4qoz(new ZCastNode(), Node__1.ParentNode, ZType__4qwg(new ZType(), 1 << 16, "void", null), Node__1);
   };
   if (IsFloatType__1qwg(ContextType__2) && IsIntType__1qwg(Node__1.Type)) {
      return EnforceNodeType__3qrc(self, Node__1, ContextType__2);
   };
   if (IsIntType__1qwg(ContextType__2) && IsFloatType__1qwg(Node__1.Type)) {
      return EnforceNodeType__3qrc(self, Node__1, ContextType__2);
   };
   return CreateStupidCastNode__3qrc(self, ContextType__2, Node__1);
});
ZTypeChecker.prototype.TypeCheckImpl = TypeCheckImpl__4qrc;

var VisitTypeChecker__4qrc = (function (self, Node__1, ContextType__2, TypeCheckPolicy__3) {
   if (self.IsVisitable(self) && Node__1 != null) {
      if (HasUntypedNode__1qwo(Node__1)) {
         Node__1 = VisitTypeChecker__3qwo(Node__1, self, ContextType__2);
      };
      Node__1 = TypeCheckImpl__4qrc(self, Node__1, ContextType__2, TypeCheckPolicy__3);
      CheckVarNode__3qrj(self.VarScope, ContextType__2, Node__1);
   };
   self.ReturnedNode = null;
   return Node__1;
});
ZTypeChecker.prototype.VisitTypeChecker = VisitTypeChecker__4qrc;

var TryType__3qrc = (function (self, Node__1, ContextType__2) {
   return VisitTypeChecker__4qrc(self, Node__1, ContextType__2, 1);
});
ZTypeChecker.prototype.TryType = TryType__3qrc;

var TryTypeAt__4qrc = (function (self, Node__1, Index__2, ContextType__3) {
   Set__3qwo(Node__1, Index__2, VisitTypeChecker__4qrc(self, Node__1.AST[Index__2], ContextType__3, 1));
   return;
});
ZTypeChecker.prototype.TryTypeAt = TryTypeAt__4qrc;

var CheckType__3qrc = (function (self, Node__1, ContextType__2) {
   return VisitTypeChecker__4qrc(self, Node__1, ContextType__2, 0);
});
ZTypeChecker.prototype.CheckType = CheckType__3qrc;

var CheckTypeAt__4qrc = (function (self, Node__1, Index__2, ContextType__3) {
   Set__3qwo(Node__1, Index__2, VisitTypeChecker__4qrc(self, Node__1.AST[Index__2], ContextType__3, 0));
   return;
});
ZTypeChecker.prototype.CheckTypeAt = CheckTypeAt__4qrc;

var TypeCheckNodeList__2qrc = (function (self, List__1) {
   if (self.IsVisitable(self)) {
      var AllTyped__2 = true;
      var i__3 = 0;
      while (i__3 < GetListSize__1quv(List__1)) {
         var SubNode__4 = GetListAt__2quv(List__1, i__3);
         SubNode__4 = CheckType__3qrc(self, SubNode__4, ZType__4qwg(new ZType(), 1 << 16, "var", null));
         SetListAt__3quv(List__1, i__3, SubNode__4);
         if (IsUntyped__1qwo(SubNode__4)) {
            AllTyped__2 = false;
         };
         i__3 = i__3 + 1;
      };
      return AllTyped__2;
   };
   return false;
});
ZTypeChecker.prototype.TypeCheckNodeList = TypeCheckNodeList__2qrc;

var Return__2qrc = (function (self, Node__1) {
   if (self.ReturnedNode != null) {
      LibZen.PrintDebug("previous returned node " + toString__1qwo(Node__1));
   };
   self.ReturnedNode = Node__1;
   return;
});
ZTypeChecker.prototype.Return = Return__2qrc;

var TypedNode__3qrc = (function (self, Node__1, Type__2) {
   Node__1.Type = Type__2.GetRealType(Type__2);
   if (self.ReturnedNode != null) {
      LibZen.PrintDebug("previous returned node " + toString__1qwo(Node__1));
   };
   self.ReturnedNode = Node__1;
   return;
});
ZTypeChecker.prototype.TypedNode = TypedNode__3qrc;

var ReturnErrorNode__4qrc = (function (self, Node__1, ErrorToken__2, Message__3) {
   if (ErrorToken__2 == null) {
      ErrorToken__2 = Node__1.SourceToken;
   };
   Return__2qrc(self, ZErrorNode__4qpr(new ZErrorNode(), Node__1.ParentNode, ErrorToken__2, Message__3));
   return;
});
ZTypeChecker.prototype.ReturnErrorNode = ReturnErrorNode__4qrc;

var VisitErrorNode__2qrc = (function (self, Node__1) {
   var ContextType__2 = GetContextType__1qrc(self);
   if (!ContextType__2.IsVarType(ContextType__2)) {
      TypedNode__3qrc(self, Node__1, ContextType__2);
   } else {
      Return__2qrc(self, Node__1);
   };
   return;
});
ZTypeChecker.prototype.VisitErrorNode = VisitErrorNode__2qrc;

var VisitExtendedNode__2qrc = (function (self, Node__1) {
   var ContextType__2 = GetContextType__1qrc(self);
   var DeNode__3 = Node__1.DeSugar(Node__1, self.Generator);
   if (!IsErrorNode__1qwo(DeNode__3)) {
      Return__2qrc(self, CheckType__3qrc(self, DeNode__3, ContextType__2));
   } else {
      TypedNode__3qrc(self, DeNode__3, ContextType__2);
   };
   return;
});
ZTypeChecker.prototype.VisitExtendedNode = VisitExtendedNode__2qrc;

var VisitSugarNode__2qrc = (function (self, Node__1) {
   var ContextType__2 = GetContextType__1qrc(self);
   CheckTypeAt__4qrc(self, Node__1, 0, ContextType__2);
   TypedNode__3qrc(self, Node__1, GetAstType__2qwo(Node__1, 0));
   return;
});
ZTypeChecker.prototype.VisitSugarNode = VisitSugarNode__2qrc;

var CSourceGenerator__1qga = (function (self) {
   ZSourceGenerator__3quk(self, "c", "C99");
   self.LineFeed = "\n";
   self.Tab = "\t";
   self.Camma = ", ";
   self.SemiColon = ";";
   self.TrueLiteral = "1/*true*/";
   self.FalseLiteral = "0/*false*/";
   self.NullLiteral = "NULL";
   self.TopType = "void *";
   SetNativeType__3quk(self, ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)), "int");
   SetNativeType__3quk(self, ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), "long");
   SetNativeType__3quk(self, ZType__4qwg(new ZType(), 1 << 16, "float", ZType__4qwg(new ZType(), 1 << 16, "var", null)), "double");
   SetNativeType__3quk(self, ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), "const char *");
   SetMacro__6quk(self, "assert", "LibZen_Assert($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "void", null), ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__5quk(self, "print", "LibZen_Print($[0])", ZType__4qwg(new ZType(), 1 << 16, "void", null), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__5quk(self, "println", "LibZen_PrintLine($[0])", ZType__4qwg(new ZType(), 1 << 16, "void", null), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetConverterMacro__4quk(self, "(double)($[0])", ZType__4qwg(new ZType(), 1 << 16, "float", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetConverterMacro__4quk(self, "(long)($[0])", ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "float", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetConverterMacro__4quk(self, "LibZen_BooleanToString($[0])", ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetConverterMacro__4quk(self, "LibZen_IntToString($[0])", ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetConverterMacro__4quk(self, "LibZen_FloatToString($[0])", ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "float", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "+", "LibZen_StrCat($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__5quk(self, "size", "LibZen_StringSize($[0])", ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "substring", "LibZen_SubString($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__7quk(self, "substring", "LibZen_SubString2($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "indexOf", "LibZen_IndexOf($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__7quk(self, "indexOf", "LibZen_IndexOf2($[0], $[1], $[2])", ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "equals", "LibZen_EqualsString($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "startsWith", "LibZen_StartsWith($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "endsWith", "LibZen_EndWidth($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "String", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__5quk(self, "size", "LibZen_ArraySize($[0])", ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "clear", "LibZen_ArrayClear($[0])", ZType__4qwg(new ZType(), 1 << 16, "void", null), ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)));
   SetMacro__6quk(self, "add", "LibZen_ArrayAdd($[0], $[1])", ZType__4qwg(new ZType(), 1 << 16, "void", null), ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "var", null));
   SetMacro__7quk(self, "add", "LibZen_ArrayAdd2($[0], $[1], $[2])", ZType__4qwg(new ZType(), 1 << 16, "void", null), ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "int", ZType__4qwg(new ZType(), 1 << 16, "var", null)), ZType__4qwg(new ZType(), 1 << 16, "var", null));
   return null;
});
CSourceGenerator.prototype.CSourceGenerator = CSourceGenerator__1qga;

var GetEngine__1qga = (function (self) {
   return ZSourceEngine__3qws(new ZSourceEngine(), ZTypeChecker__2qrc(new ZTypeChecker(), self), self);
});
CSourceGenerator.prototype.GetEngine = GetEngine__1qga;

var GenerateCode__3qga = (function (self, ContextType__1, Node__2) {
   if (IsUntyped__1qwo(Node__2) && !IsErrorNode__1qwo(Node__2) && !((Node__2).constructor.name == (ZGlobalNameNode).name)) {
      Append__2qq2(self.CurrentBuilder, "/*untyped*/" + self.NullLiteral);
      ZLogger_LogError__2qw3(Node__2.SourceToken, "untyped error: " + toString__1qwo(Node__2));
   } else {
      if (ContextType__1 != null && Node__2.Type != ContextType__1) {
         Append__2qq2(self.CurrentBuilder, "(");
         GenerateTypeName__2qga(self, ContextType__1);
         Append__2qq2(self.CurrentBuilder, ")");
      };
      Node__2.Accept(Node__2, self);
   };
   return;
});
CSourceGenerator.prototype.GenerateCode = GenerateCode__3qga;

var VisitArrayLiteralNode__2qga = (function (self, Node__1) {
   var ParamType__2 = Node__1.Type.GetParamType(Node__1.Type, 0);
   if (IsIntType__1qwg(ParamType__2) || IsBooleanType__1qwg(ParamType__2)) {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewIntArray(");
   } else if (IsFloatType__1qwg(ParamType__2)) {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewFloatArray(");
   } else if (IsStringType__1qwg(ParamType__2)) {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewStringArray(");
   } else {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewArray(");
   };
   Append__2qq2(self.CurrentBuilder, "" + ((GetListSize__1quv(Node__1))).toString());
   if (GetListSize__1quv(Node__1) > 0) {
      Append__2qq2(self.CurrentBuilder, self.Camma);
   };
   VisitListNode__4quk(self, "", Node__1, ")");
   return;
});
CSourceGenerator.prototype.VisitArrayLiteralNode = VisitArrayLiteralNode__2qga;

var VisitMapLiteralNode__2qga = (function (self, Node__1) {
   var ParamType__2 = Node__1.Type.GetParamType(Node__1.Type, 0);
   if (IsIntType__1qwg(ParamType__2) || IsBooleanType__1qwg(ParamType__2)) {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewIntMap(");
   } else if (IsFloatType__1qwg(ParamType__2)) {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewFloatMap(");
   } else if (IsStringType__1qwg(ParamType__2)) {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewStringMap(");
   } else {
      Append__2qq2(self.CurrentBuilder, "LibZen_NewMap(");
   };
   Append__2qq2(self.CurrentBuilder, "" + ((GetListSize__1quv(Node__1))).toString());
   if (GetListSize__1quv(Node__1) > 0) {
      Append__2qq2(self.CurrentBuilder, self.Camma);
   };
   VisitListNode__4quk(self, "", Node__1, ")");
   return;
});
CSourceGenerator.prototype.VisitMapLiteralNode = VisitMapLiteralNode__2qga;

var VisitNewObjectNode__2qga = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "_New" + NameClass__2qw4(self, Node__1.Type));
   VisitListNode__4quk(self, "(", Node__1, ")");
   return;
});
CSourceGenerator.prototype.VisitNewObjectNode = VisitNewObjectNode__2qga;

var BaseName__2qga = (function (self, RecvType__1) {
   return GetAsciiName__1qwg(RecvType__1);
});
CSourceGenerator.prototype.BaseName = BaseName__2qga;

var VisitGetIndexNode__2qga = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, BaseName__2qga(self, GetAstType__2qwo(Node__1, 0)) + "GetIndex");
   Append__2qq2(self.CurrentBuilder, "(");
   self.GenerateCode(self, null, Node__1.AST[1]);
   Append__2qq2(self.CurrentBuilder, ")");
   return;
});
CSourceGenerator.prototype.VisitGetIndexNode = VisitGetIndexNode__2qga;

var VisitSetIndexNode__2qga = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, BaseName__2qga(self, GetAstType__2qwo(Node__1, 0)) + "SetIndex");
   Append__2qq2(self.CurrentBuilder, "(");
   self.GenerateCode(self, null, Node__1.AST[1]);
   Append__2qq2(self.CurrentBuilder, self.Camma);
   self.GenerateCode(self, null, Node__1.AST[2]);
   Append__2qq2(self.CurrentBuilder, ")");
   return;
});
CSourceGenerator.prototype.VisitSetIndexNode = VisitSetIndexNode__2qga;

var VisitGetNameNode__2qga = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, Node__1.VarName);
   return;
});
CSourceGenerator.prototype.VisitGetNameNode = VisitGetNameNode__2qga;

var VisitSetNameNode__2qga = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, Node__1.VarName);
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   return;
});
CSourceGenerator.prototype.VisitSetNameNode = VisitSetNameNode__2qga;

var VisitGetterNode__2qga = (function (self, Node__1) {
   GenerateSurroundCode__2quk(self, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, "->");
   Append__2qq2(self.CurrentBuilder, Node__1.FieldName);
   return;
});
CSourceGenerator.prototype.VisitGetterNode = VisitGetterNode__2qga;

var VisitSetterNode__2qga = (function (self, Node__1) {
   GenerateSurroundCode__2quk(self, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, "->");
   Append__2qq2(self.CurrentBuilder, Node__1.FieldName);
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[1]);
   return;
});
CSourceGenerator.prototype.VisitSetterNode = VisitSetterNode__2qga;

var VisitMethodCallNode__2qga = (function (self, Node__1) {
   return;
});
CSourceGenerator.prototype.VisitMethodCallNode = VisitMethodCallNode__2qga;

var VisitFuncCallNode__2qga = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   VisitListNode__4quk(self, "(", Node__1, ")");
   return;
});
CSourceGenerator.prototype.VisitFuncCallNode = VisitFuncCallNode__2qga;

var VisitThrowNode__2qga = (function (self, Node__1) {
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, "longjump(1)");
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   return;
});
CSourceGenerator.prototype.VisitThrowNode = VisitThrowNode__2qga;

var VisitTryNode__2qga = (function (self, Node__1) {
   return;
});
CSourceGenerator.prototype.VisitTryNode = VisitTryNode__2qga;

var VisitCatchNode__2qga = (function (self, Node__1) {
   return;
});
CSourceGenerator.prototype.VisitCatchNode = VisitCatchNode__2qga;

var ParamTypeName__2qga = (function (self, Type__1) {
   if (IsArrayType__1qwg(Type__1)) {
      return "ArrayOf" + ParamTypeName__2qga(self, Type__1.GetParamType(Type__1, 0));
   };
   if (IsMapType__1qwg(Type__1)) {
      return "MapOf" + ParamTypeName__2qga(self, Type__1.GetParamType(Type__1, 0));
   };
   if (IsFuncType__1qwg(Type__1)) {
      var s__2 = ("FuncOf" + ParamTypeName__2qga(self, Type__1.GetParamType(Type__1, 0))) + "Of";
      var i__3 = 0;
      while (i__3 < Type__1.GetParamSize(Type__1)) {
         s__2 = s__2 + ParamTypeName__2qga(self, Type__1.GetParamType(Type__1, i__3));
         i__3 = i__3 + 1;
      };
      return s__2;
   };
   if (IsIntType__1qwg(Type__1)) {
      return "Int";
   };
   if (IsFloatType__1qwg(Type__1)) {
      return "Float";
   };
   if (IsVoidType__1qwg(Type__1)) {
      return "Void";
   };
   if (Type__1.IsVarType(Type__1)) {
      return "Var";
   };
   return Type__1.ShortName;
});
CSourceGenerator.prototype.ParamTypeName = ParamTypeName__2qga;

var GetCTypeName__2qga = (function (self, Type__1) {
   var TypeName__2 = null;
   if (IsArrayType__1qwg(Type__1) || IsMapType__1qwg(Type__1)) {
      TypeName__2 = ParamTypeName__2qga(self, Type__1) + " *";
   };
   if ((Type__1).constructor.name == (ZClassType).name) {
      TypeName__2 = ("struct " + NameClass__2qw4(self, Type__1)) + " *";
   };
   if (TypeName__2 == null) {
      TypeName__2 = GetNativeTypeName__2quk(self, Type__1);
   };
   return TypeName__2;
});
CSourceGenerator.prototype.GetCTypeName = GetCTypeName__2qga;

var GenerateFuncTypeName__3qga = (function (self, Type__1, FuncName__2) {
   GenerateTypeName__2qga(self, Type__1.GetParamType(Type__1, 0));
   Append__2qq2(self.CurrentBuilder, (" (*" + FuncName__2) + ")");
   var i__3 = 1;
   Append__2qq2(self.CurrentBuilder, "(");
   while (i__3 < Type__1.GetParamSize(Type__1)) {
      if (i__3 > 1) {
         Append__2qq2(self.CurrentBuilder, ",");
      };
      GenerateTypeName__2qga(self, Type__1.GetParamType(Type__1, i__3));
      i__3 = i__3 + 1;
   };
   Append__2qq2(self.CurrentBuilder, ")");
   return;
});
CSourceGenerator.prototype.GenerateFuncTypeName = GenerateFuncTypeName__3qga;

var GenerateTypeName__2qga = (function (self, Type__1) {
   if (IsFuncType__1qwg(Type__1)) {
      GenerateFuncTypeName__3qga(self, Type__1, "");
   } else {
      Append__2qq2(self.CurrentBuilder, GetCTypeName__2qga(self, Type__1.GetRealType(Type__1)));
   };
   return;
});
CSourceGenerator.prototype.GenerateTypeName = GenerateTypeName__2qga;

var VisitVarNode__2qga = (function (self, Node__1) {
   GenerateTypeName__2qga(self, Node__1.DeclType);
   Append__2qq2(self.CurrentBuilder, " ");
   Append__2qq2(self.CurrentBuilder, Node__1.NativeName);
   AppendToken__2qq2(self.CurrentBuilder, "=");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, self.SemiColon);
   VisitStmtList__2quk(self, Node__1);
   return;
});
CSourceGenerator.prototype.VisitVarNode = VisitVarNode__2qga;

var VisitParamNode__2qga = (function (self, Node__1) {
   if (IsFuncType__1qwg(Node__1.Type)) {
      GenerateFuncTypeName__3qga(self, Node__1.Type, Node__1.Name);
   } else {
      GenerateTypeName__2qga(self, Node__1.Type);
      Append__2qq2(self.CurrentBuilder, " ");
      Append__2qq2(self.CurrentBuilder, SafeName__3quk(self, Node__1.Name, Node__1.ParamIndex));
   };
   return;
});
CSourceGenerator.prototype.VisitParamNode = VisitParamNode__2qga;

var SetMethod__3qga = (function (self, FuncName__1, FuncType__2) {
   var RecvType__3 = GetRecvType__1qe0(FuncType__2);
   if ((RecvType__3).constructor.name == (ZClassType).name && FuncName__1 != null) {
      var ClassType__4 = RecvType__3;
      var FieldType__5 = GetFieldType__3qeq(ClassType__4, FuncName__1, null);
      if (FieldType__5 == null || !IsFuncType__1qwg(FieldType__5)) {
         FuncName__1 = LibZen.AnotherName(FuncName__1);
         FieldType__5 = GetFieldType__3qeq(ClassType__4, FuncName__1, null);
         if (FieldType__5 == null || !IsFuncType__1qwg(FieldType__5)) {
            return;
         };
      };
      if ((FieldType__5).constructor.name == (ZFuncType).name) {
         if (AcceptAsFieldFunc__2qe0((FieldType__5), FuncType__2)) {
            Append__2qq2(self.HeaderBuilder, (("#define _" + NameClass__2qw4(self, ClassType__4)) + "_") + FuncName__1);
            AppendLineFeed__1qq2(self.HeaderBuilder);
         };
      };
   };
   return;
});
CSourceGenerator.prototype.SetMethod = SetMethod__3qga;

var VisitInstanceOfNode__2qga = (function (self, Node__1) {
   Append__2qq2(self.CurrentBuilder, "LibZen_Is(");
   self.GenerateCode(self, null, Node__1.AST[0]);
   Append__2qq2(self.CurrentBuilder, self.Camma);
   AppendInt__2qq2(self.CurrentBuilder, Node__1.TargetType.TypeId);
   Append__2qq2(self.CurrentBuilder, ")");
   return;
});
CSourceGenerator.prototype.VisitInstanceOfNode = VisitInstanceOfNode__2qga;

var GenerateCField__3qga = (function (self, CType__1, FieldName__2) {
   AppendLineFeed__1qq2(self.CurrentBuilder);
   AppendIndent__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, CType__1);
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, FieldName__2);
   Append__2qq2(self.CurrentBuilder, self.SemiColon);
   return;
});
CSourceGenerator.prototype.GenerateCField = GenerateCField__3qga;

var GenerateField__3qga = (function (self, DeclType__1, FieldName__2) {
   AppendLineFeedIndent__1qq2(self.CurrentBuilder);
   GenerateTypeName__2qga(self, DeclType__1);
   AppendWhiteSpace__1qq2(self.CurrentBuilder);
   Append__2qq2(self.CurrentBuilder, FieldName__2);
   Append__2qq2(self.CurrentBuilder, self.SemiColon);
   return;
});
CSourceGenerator.prototype.GenerateField = GenerateField__3qga;

var GenerateFields__3qga = (function (self, ClassType__1, ThisType__2) {
   var SuperType__3 = ThisType__2.GetSuperType(ThisType__2);
   if (!SuperType__3.IsVarType(SuperType__3)) {
      GenerateFields__3qga(self, ClassType__1, SuperType__3);
   };
   var i__4 = 0;
   GenerateCField__3qga(self, "int", "_classId" + (ThisType__2.TypeId).toString());
   GenerateCField__3qga(self, "int", "_delta" + (ThisType__2.TypeId).toString());
   while (i__4 < GetFieldSize__1qeq(ClassType__1)) {
      var ClassField__5 = GetFieldAt__2qeq(ClassType__1, i__4);
      if (ClassField__5.ClassType == ThisType__2) {
         GenerateField__3qga(self, ClassField__5.FieldType, ClassField__5.FieldName);
      };
      i__4 = i__4 + 1;
   };
   return;
});
CSourceGenerator.prototype.GenerateFields = GenerateFields__3qga;

var VisitErrorNode__2qga = (function (self, Node__1) {
   ZLogger_LogError__2qw3(Node__1.SourceToken, Node__1.ErrorMessage);
   Append__2qq2(self.CurrentBuilder, "ThrowError(");
   Append__2qq2(self.CurrentBuilder, LibZen.QuoteString(Node__1.ErrorMessage));
   Append__2qq2(self.CurrentBuilder, ")");
   return;
});
CSourceGenerator.prototype.VisitErrorNode = VisitErrorNode__2qga;

var ZAndNode__5qs1 = (function (self, ParentNode__1, Token__2, Left__3, Pattern__4) {
   ZBinaryNode__5qod(self, ParentNode__1, Token__2, Left__3, Pattern__4);
   return null;
});
ZAndNode.prototype.ZAndNode = ZAndNode__5qs1;

var Accept__2qs1 = (function (self, Visitor__1) {
   Visitor__1.VisitAndNode(Visitor__1, self);
   return;
});
ZAndNode.prototype.Accept = Accept__2qs1;

var ZArrayLiteralNode__2qsw = (function (self, ParentNode__1) {
   ZListNode__4quv(self, ParentNode__1, null, 0);
   return null;
});
ZArrayLiteralNode.prototype.ZArrayLiteralNode = ZArrayLiteralNode__2qsw;

var Accept__2qsw = (function (self, Visitor__1) {
   Visitor__1.VisitArrayLiteralNode(Visitor__1, self);
   return;
});
ZArrayLiteralNode.prototype.Accept = Accept__2qsw;

var ZBlockNode__2qtp = (function (self, NameSpace__1) {
   ZListNode__4quv(self, null, null, 0);
   self.NameSpace = NameSpace__1;
   return null;
});
ZBlockNode.prototype.ZBlockNode = ZBlockNode__2qtp;

var ZBlockNode__3qtp = (function (self, ParentNode__1, Init__2) {
   ZListNode__4quv(self, ParentNode__1, null, Init__2);
   self.NameSpace = CreateSubNameSpace__1qwt(GetNameSpace__1qwo(ParentNode__1));
   return null;
});
ZBlockNode.prototype.ZBlockNode = ZBlockNode__3qtp;

var Accept__2qtp = (function (self, Visitor__1) {
   Visitor__1.VisitBlockNode(Visitor__1, self);
   return;
});
ZBlockNode.prototype.Accept = Accept__2qtp;

var ToReturnNode__1qtp = (function (self) {
   if (GetListSize__1quv(self) == 1) {
      return ToReturnNode__1qwo(GetListAt__2quv(self, 0));
   };
   return null;
});
ZBlockNode.prototype.ToReturnNode = ToReturnNode__1qtp;

var IndexOf__2qtp = (function (self, ChildNode__1) {
   var i__2 = 0;
   while (i__2 < GetListSize__1quv(self)) {
      if (GetListAt__2quv(self, i__2) == ChildNode__1) {
         return i__2;
      };
      i__2 = i__2 + 1;
   };
   return -1;
});
ZBlockNode.prototype.IndexOf = IndexOf__2qtp;

var CopyTo__3qtp = (function (self, Index__1, BlockNode__2) {
   var i__3 = Index__1;
   while (i__3 < GetListSize__1quv(self)) {
      Append__2quv(BlockNode__2, GetListAt__2quv(self, i__3));
      i__3 = i__3 + 1;
   };
   return;
});
ZBlockNode.prototype.CopyTo = CopyTo__3qtp;

var ZBooleanNode__4qa5 = (function (self, ParentNode__1, Token__2, Value__3) {
   ZConstNode__3qo8(self, ParentNode__1, Token__2);
   self.Type = ZType__4qwg(new ZType(), 1 << 16, "boolean", ZType__4qwg(new ZType(), 1 << 16, "var", null));
   self.BooleanValue = Value__3;
   return null;
});
ZBooleanNode.prototype.ZBooleanNode = ZBooleanNode__4qa5;

var Accept__2qa5 = (function (self, Visitor__1) {
   Visitor__1.VisitBooleanNode(Visitor__1, self);
   return;
});
ZBooleanNode.prototype.Accept = Accept__2qa5;

var ZClassNode__2qdq = (function (self, ParentNode__1) {
   ZListNode__4quv(self, ParentNode__1, null, 0);
   return null;
});
ZClassNode.prototype.ZClassNode = ZClassNode__2qdq;

var SetTypeInfo__3qdq = (function (self, TypeToken__1, Type__2) {
   self.SuperType = Type__2;
   self.SuperToken = TypeToken__1;
   return;
});
ZClassNode.prototype.SetTypeInfo = SetTypeInfo__3qdq;

var SetNameInfo__3qdq = (function (self, NameToken__1, Name__2) {
   self.ClassName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZClassNode.prototype.SetNameInfo = SetNameInfo__3qdq;

var GetFieldNode__2qdq = (function (self, Index__1) {
   var Node__2 = GetListAt__2quv(self, Index__1);
   if ((Node__2).constructor.name == (ZFieldNode).name) {
      return Node__2;
   };
   return null;
});
ZClassNode.prototype.GetFieldNode = GetFieldNode__2qdq;

var Accept__2qdq = (function (self, Visitor__1) {
   Visitor__1.VisitClassNode(Visitor__1, self);
   return;
});
ZClassNode.prototype.Accept = Accept__2qdq;

var ZFuncCallNode__3q4e = (function (self, ParentNode__1, FuncNode__2) {
   ZListNode__4quv(self, ParentNode__1, null, 1);
   Set__3qwo(self, 0, FuncNode__2);
   return null;
});
ZFuncCallNode.prototype.ZFuncCallNode = ZFuncCallNode__3q4e;

var ZFuncCallNode__4q4e = (function (self, ParentNode__1, FuncName__2, FuncType__3) {
   ZListNode__4quv(self, ParentNode__1, null, 1);
   var FuncNode__4 = ZGlobalNameNode__6qpv(new ZGlobalNameNode(), self, null, FuncType__3, FuncName__2, true);
   Set__3qwo(self, 0, FuncNode__4);
   return null;
});
ZFuncCallNode.prototype.ZFuncCallNode = ZFuncCallNode__4q4e;

var Accept__2q4e = (function (self, Visitor__1) {
   Visitor__1.VisitFuncCallNode(Visitor__1, self);
   return;
});
ZFuncCallNode.prototype.Accept = Accept__2q4e;

var GetRecvType__1q4e = (function (self) {
   if (GetListSize__1quv(self) > 0) {
      return GetListAt__2quv(self, 0).Type.GetRealType(GetListAt__2quv(self, 0).Type);
   };
   return ZType__4qwg(new ZType(), 1 << 16, "void", null);
});
ZFuncCallNode.prototype.GetRecvType = GetRecvType__1q4e;

var GetFuncName__1q4e = (function (self) {
   var FNode__1 = self.AST[0];
   if ((FNode__1).constructor.name == (ZGlobalNameNode).name) {
      return (FNode__1).GlobalName;
   };
   return null;
});
ZFuncCallNode.prototype.GetFuncName = GetFuncName__1q4e;

var GetFuncType__1q4e = (function (self) {
   var FType__1 = self.AST[0].Type;
   if ((FType__1).constructor.name == (ZFuncType).name) {
      return FType__1;
   };
   return null;
});
ZFuncCallNode.prototype.GetFuncType = GetFuncType__1q4e;

var ToMacroNode__2q4e = (function (self, MacroFunc__1) {
   var MacroNode__2 = ZMacroNode__4q06(new ZMacroNode(), self.ParentNode, self.AST[0].SourceToken, MacroFunc__1);
   var i__3 = 0;
   while (i__3 < GetListSize__1quv(self)) {
      Append__2quv(MacroNode__2, GetListAt__2quv(self, i__3));
      i__3 = i__3 + 1;
   };
   return MacroNode__2;
});
ZFuncCallNode.prototype.ToMacroNode = ToMacroNode__2q4e;

var ZFunctionNode__2qrb = (function (self, ParentNode__1) {
   ZListNode__4quv(self, ParentNode__1, null, 1);
   return null;
});
ZFunctionNode.prototype.ZFunctionNode = ZFunctionNode__2qrb;

var SetTypeInfo__3qrb = (function (self, TypeToken__1, Type__2) {
   self.ReturnType = Type__2;
   return;
});
ZFunctionNode.prototype.SetTypeInfo = SetTypeInfo__3qrb;

var SetNameInfo__3qrb = (function (self, NameToken__1, Name__2) {
   self.FuncName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZFunctionNode.prototype.SetNameInfo = SetNameInfo__3qrb;

var Accept__2qrb = (function (self, Visitor__1) {
   Visitor__1.VisitFunctionNode(Visitor__1, self);
   return;
});
ZFunctionNode.prototype.Accept = Accept__2qrb;

var GetParamNode__2qrb = (function (self, Index__1) {
   var Node__2 = GetListAt__2quv(self, Index__1);
   if ((Node__2).constructor.name == (ZParamNode).name) {
      return Node__2;
   };
   return null;
});
ZFunctionNode.prototype.GetParamNode = GetParamNode__2qrb;

var GetFuncType__2qrb = (function (self, ContextType__1) {
   if (self.ResolvedFuncType == null) {
      var FuncType__7 = null;
      if ((ContextType__1).constructor.name == (ZFuncType).name) {
         FuncType__2 = ContextType__1;
      };
      var TypeList__8 = [];
      if (self.ReturnType.IsVarType(self.ReturnType) && FuncType__2 != null) {
         self.ReturnType = FuncType__2.GetParamType(FuncType__2, 0);
      };
      TypeList__3.push(self.ReturnType.GetRealType(self.ReturnType));
      var i__9 = 0;
      while (i__4 < GetListSize__1quv(self)) {
         var Node__10 = GetParamNode__2qrb(self, i__4);
         var ParamType__11 = Node__5.Type.GetRealType(Node__5.Type);
         if (ParamType__6.IsVarType(ParamType__6) && FuncType__2 != null) {
            ParamType__11 = FuncType__2.GetParamType(FuncType__2, i__4 + 1);
         };
         TypeList__3.push(ParamType__6);
         i__4 = i__4 + 1;
      };
      FuncType__2 = ZTypePool_LookupFuncType__1qwh(TypeList__3);
      if (!FuncType__2.IsVarType(FuncType__2)) {
         self.ResolvedFuncType = FuncType__2;
      };
      return FuncType__2;
   };
   return self.ResolvedFuncType;
});
ZFunctionNode.prototype.GetFuncType = GetFuncType__2qrb;

var GetSignature__2qrb = (function (self, Generator__1) {
   var FuncType__2 = GetFuncType__2qrb(self, null);
   if (self.FuncName == null) {
      self.FuncName = "f_Z" + (GetUniqueNumber__1qw4(Generator__1)).toString();
   };
   return StringfySignature__2qe0(FuncType__2, self.FuncName);
});
ZFunctionNode.prototype.GetSignature = GetSignature__2qrb;

var Push__2qrb = (function (self, Parent__1) {
   self.ParentFunctionNode = Parent__1;
   return self;
});
ZFunctionNode.prototype.Push = Push__2qrb;

var Pop__1qrb = (function (self) {
   return self.ParentFunctionNode;
});
ZFunctionNode.prototype.Pop = Pop__1qrb;

var IsTopLevel__1qrb = (function (self) {
   return self.ParentFunctionNode == null;
});
ZFunctionNode.prototype.IsTopLevel = IsTopLevel__1qrb;

var GetVarIndex__1qrb = (function (self) {
   var Index__1 = self.VarIndex;
   self.VarIndex = self.VarIndex + 1;
   return Index__1;
});
ZFunctionNode.prototype.GetVarIndex = GetVarIndex__1qrb;

var ZVarNode__2qsc = (function (self, ParentNode__1) {
   ZBlockNode__3qtp(self, ParentNode__1, 1);
   return null;
});
ZVarNode.prototype.ZVarNode = ZVarNode__2qsc;

var SetNameInfo__3qsc = (function (self, NameToken__1, Name__2) {
   self.NativeName = Name__2;
   self.NameToken = NameToken__1;
   return;
});
ZVarNode.prototype.SetNameInfo = SetNameInfo__3qsc;

var SetTypeInfo__3qsc = (function (self, TypeToken__1, Type__2) {
   self.DeclType = Type__2;
   self.TypeToken = TypeToken__1;
   return;
});
ZVarNode.prototype.SetTypeInfo = SetTypeInfo__3qsc;

var Accept__2qsc = (function (self, Visitor__1) {
   Visitor__1.VisitVarNode(Visitor__1, self);
   return;
});
ZVarNode.prototype.Accept = Accept__2qsc;

var AndPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var BinaryNode__3 = ZAndNode__5qs1(new ZAndNode(), ParentNode, GetToken__2qwp(TokenContext__1, true), LeftNode__2, GetApplyingSyntax__1qwp(TokenContext__1));
   return AppendParsedRightNode__3qod(BinaryNode__3, ParentNode, TokenContext__1);
});
ZNode.prototype.AndPattern = AndPattern__3qwo;

var AnnotationPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   return null;
});
ZNode.prototype.AnnotationPattern = AnnotationPattern__3qwo;

var ApplyPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var ApplyNode__3 = ZFuncCallNode__3q4e(new ZFuncCallNode(), ParentNode, LeftNode__2);
   ApplyNode__3 = MatchNtimes__6qwp(TokenContext__1, ApplyNode__3, "(", "$Expression$", ",", ")");
   return ApplyNode__3;
});
ZNode.prototype.ApplyPattern = ApplyPattern__3qwo;

var ArrayLiteralPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode__3 = ZArrayLiteralNode__2qsw(new ZArrayLiteralNode(), ParentNode);
   LiteralNode__3 = MatchNtimes__6qwp(TokenContext__1, LiteralNode__3, "[", "$Expression$", ",", "]");
   return LiteralNode__3;
});
ZNode.prototype.ArrayLiteralPattern = ArrayLiteralPattern__3qwo;

var AssertPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var AssertNode__3 = ZAssertNode__2qo4(new ZAssertNode(), ParentNode);
   AssertNode__3 = MatchToken__4qwp(TokenContext__1, AssertNode__3, "assert", true);
   AssertNode__3 = MatchToken__4qwp(TokenContext__1, AssertNode__3, "(", true);
   AssertNode__3 = MatchPattern__6qwp(TokenContext__1, AssertNode__3, 0, "$Expression$", true, true);
   AssertNode__3 = MatchToken__4qwp(TokenContext__1, AssertNode__3, ")", true);
   return AssertNode__3;
});
ZNode.prototype.AssertPattern = AssertPattern__3qwo;

var AssignPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   return null;
});
ZNode.prototype.AssignPattern = AssignPattern__3qwo;

var BinaryPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Token__3 = GetToken__2qwp(TokenContext__1, true);
   var BinaryNode__4 = ZBinaryNode__5qod(new ZBinaryNode(), ParentNode, Token__3, LeftNode__2, GetApplyingSyntax__1qwp(TokenContext__1));
   return AppendParsedRightNode__3qod(BinaryNode__4, ParentNode, TokenContext__1);
});
ZNode.prototype.BinaryPattern = BinaryPattern__3qwo;

var BlockComment__1qwu = (function (SourceContext) {
   var StartIndex__1 = GetPosition__1qwu(SourceContext);
   var NextChar__2 = GetCharAtFromCurrentPosition__2qwu(SourceContext, +1);
   if (NextChar__2 != "/" && NextChar__2 != "*") {
      return false;
   };
   if (NextChar__2 == "/") {
      while (HasChar__1qwu(SourceContext)) {
         var ch__3 = GetCurrentChar__1qwu(SourceContext);
         if (ch__3 == "\n") {
            break;
         };
         MoveNext__1qwu(SourceContext);
      };
      return true;
   };
   var NestedLevel__4 = 0;
   var PrevChar__5 = "0";
   while (HasChar__1qwu(SourceContext)) {
      NextChar__2 = GetCurrentChar__1qwu(SourceContext);
      if (PrevChar__5 == "*" && NextChar__2 == "/") {
         NestedLevel__4 = NestedLevel__4 - 1;
         if (NestedLevel__4 == 0) {
            MoveNext__1qwu(SourceContext);
            return true;
         };
      };
      if (PrevChar__5 == "/" && NextChar__2 == "*") {
         NestedLevel__4 = NestedLevel__4 + 1;
      };
      MoveNext__1qwu(SourceContext);
      PrevChar__5 = NextChar__2;
   };
   LogWarning__3qwu(SourceContext, StartIndex__1, "unfound */");
   return true;
});
ZSourceContext.prototype.BlockComment = BlockComment__1qwu;

var BlockPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var BlockNode__3 = ZBlockNode__3qtp(new ZBlockNode(), ParentNode, 0);
   var SkipToken__4 = GetToken__1qwp(TokenContext__1);
   BlockNode__3 = MatchToken__4qwp(TokenContext__1, BlockNode__3, "{", true);
   if (!IsErrorNode__1qwo(BlockNode__3)) {
      var Remembered__5 = SetParseFlag__2qwp(TokenContext__1, true);
      var NestedBlockNode__6 = BlockNode__3;
      while (HasNext__1qwp(TokenContext__1)) {
         if (MatchToken__2qwp(TokenContext__1, "}")) {
            break;
         };
         NestedBlockNode__6 = MatchPattern__5qwp(TokenContext__1, NestedBlockNode__6, -5, "$Statement$", true);
         if (IsErrorNode__1qwo(NestedBlockNode__6)) {
            SkipError__2qwp(TokenContext__1, SkipToken__4);
            MatchToken__2qwp(TokenContext__1, "}");
            break;
         };
      };
      SetParseFlag__2qwp(TokenContext__1, Remembered__5);
   };
   return BlockNode__3;
});
ZNode.prototype.BlockPattern = BlockPattern__3qwo;

var BreakPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var BreakNode__3 = ZBreakNode__2qo9(new ZBreakNode(), ParentNode);
   BreakNode__3 = MatchToken__4qwp(TokenContext__1, BreakNode__3, "break", true);
   return BreakNode__3;
});
ZNode.prototype.BreakPattern = BreakPattern__3qwo;

var CLineComment__1qwu = (function (SourceContext) {
   return false;
});
ZSourceContext.prototype.CLineComment = CLineComment__1qwu;

var CastPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var CastNode__3 = ZCastNode__4qoz(new ZCastNode(), ParentNode, ZType__4qwg(new ZType(), 1 << 16, "var", null), null);
   CastNode__3 = MatchToken__4qwp(TokenContext__1, CastNode__3, "(", true);
   CastNode__3 = MatchPattern__5qwp(TokenContext__1, CastNode__3, -3, "$Type$", true);
   CastNode__3 = MatchToken__4qwp(TokenContext__1, CastNode__3, ")", true);
   CastNode__3 = MatchPattern__5qwp(TokenContext__1, CastNode__3, 0, "$RightExpression$", true);
   return CastNode__3;
});
ZNode.prototype.CastPattern = CastPattern__3qwo;

var CatchPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var CatchNode__3 = ZCatchNode__2qob(new ZCatchNode(), ParentNode);
   CatchNode__3 = MatchToken__4qwp(TokenContext__1, CatchNode__3, "catch", true);
   CatchNode__3 = MatchToken__4qwp(TokenContext__1, CatchNode__3, "(", true);
   CatchNode__3 = MatchPattern__5qwp(TokenContext__1, CatchNode__3, -2, "$Name$", true);
   CatchNode__3 = MatchToken__4qwp(TokenContext__1, CatchNode__3, ")", true);
   CatchNode__3 = MatchPattern__5qwp(TokenContext__1, CatchNode__3, 0, "$Block$", true);
   return CatchNode__3;
});
ZNode.prototype.CatchPattern = CatchPattern__3qwo;

var ClassPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var ClassNode__3 = ZClassNode__2qdq(new ZClassNode(), ParentNode);
   ClassNode__3 = MatchToken__4qwp(TokenContext__1, ClassNode__3, "class", true);
   ClassNode__3 = MatchPattern__5qwp(TokenContext__1, ClassNode__3, -2, "$Name$", true);
   if (MatchNewLineToken__2qwp(TokenContext__1, "extends")) {
      ClassNode__3 = MatchPattern__5qwp(TokenContext__1, ClassNode__3, -3, "$Type$", true);
   };
   ClassNode__3 = MatchNtimes__6qwp(TokenContext__1, ClassNode__3, "{", "$FieldDecl$", null, "}");
   return ClassNode__3;
});
ZNode.prototype.ClassPattern = ClassPattern__3qwo;

var ComparatorPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Token__3 = GetToken__2qwp(TokenContext__1, true);
   var BinaryNode__4 = ZComparatorNode__5qo5(new ZComparatorNode(), ParentNode, Token__3, LeftNode__2, GetApplyingSyntax__1qwp(TokenContext__1));
   return AppendParsedRightNode__3qod(BinaryNode__4, ParentNode, TokenContext__1);
});
ZNode.prototype.ComparatorPattern = ComparatorPattern__3qwo;

var ExpressionPattern_GetRightPattern__2qwt = (function (NameSpace, TokenContext__1) {
   var Token__2 = GetToken__1qwp(TokenContext__1);
   if (Token__2 != ZToken__4qw3(new ZToken(), null, 0, 0)) {
      var Pattern__3 = GetRightSyntaxPattern__2qwt(NameSpace, GetText__1qw3(Token__2));
      return Pattern__3;
   };
   return null;
});
ZNameSpace.prototype.ExpressionPattern_GetRightPattern = ExpressionPattern_GetRightPattern__2qwt;

var ExpressionPattern_DispatchPattern__5qwo = (function (ParentNode, TokenContext__1, LeftNode__2, AllowStatement__3, AllowBinary__4) {
   var Token__5 = GetToken__1qwp(TokenContext__1);
   var Pattern__6 = null;
   var NameSpace__7 = GetNameSpace__1qwo(ParentNode);
   if ((Token__5).constructor.name == (ZPatternToken).name) {
      Pattern__6 = (Token__5).PresetPattern;
   } else {
      Pattern__6 = GetSyntaxPattern__2qwt(NameSpace__7, GetText__1qw3(Token__5));
   };
   if (Pattern__6 != null) {
      if (Pattern__6.IsStatement && !AllowStatement__3) {
         return ZErrorNode__4qpr(new ZErrorNode(), ParentNode, Token__5, GetText__1qw3(Token__5) + " statement is not here");
      };
      LeftNode__2 = ApplyMatchPattern__5qwp(TokenContext__1, ParentNode, LeftNode__2, Pattern__6, true);
   } else {
      if (IsNameSymbol__1qw3(Token__5)) {
         if (AllowStatement__3) {
            Pattern__6 = GetSyntaxPattern__2qwt(NameSpace__7, "$SymbolStatement$");
         } else {
            Pattern__6 = GetSyntaxPattern__2qwt(NameSpace__7, "$SymbolExpression$");
         };
         LeftNode__2 = ApplyMatchPattern__5qwp(TokenContext__1, ParentNode, LeftNode__2, Pattern__6, true);
      } else {
         if (AllowStatement__3) {
            return CreateExpectedErrorNode__3qwp(TokenContext__1, Token__5, "statement");
         } else {
            return CreateExpectedErrorNode__3qwp(TokenContext__1, Token__5, "expression");
         };
      };
   };
   if (!Pattern__6.IsStatement) {
      while (LeftNode__2 != null && !IsErrorNode__1qwo(LeftNode__2)) {
         var RightPattern__8 = ExpressionPattern_GetRightPattern__2qwt(NameSpace__7, TokenContext__1);
         if (RightPattern__8 == null) {
            break;
         };
         if (!AllowBinary__4 && IsBinaryOperator__1qy7(RightPattern__8)) {
            break;
         };
         LeftNode__2 = ApplyMatchPattern__5qwp(TokenContext__1, ParentNode, LeftNode__2, RightPattern__8, true);
      };
   };
   return LeftNode__2;
});
ZNode.prototype.ExpressionPattern_DispatchPattern = ExpressionPattern_DispatchPattern__5qwo;

var ExpressionPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   return ExpressionPattern_DispatchPattern__5qwo(ParentNode, TokenContext__1, LeftNode__2, false, true);
});
ZNode.prototype.ExpressionPattern = ExpressionPattern__3qwo;

var FalsePattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   return ZBooleanNode__4qa5(new ZBooleanNode(), ParentNode, GetToken__2qwp(TokenContext__1, true), false);
});
ZNode.prototype.FalsePattern = FalsePattern__3qwo;

var FieldPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Rememberd__3 = SetParseFlag__2qwp(TokenContext__1, false);
   var FieldNode__4 = ZFieldNode__2qpi(new ZFieldNode(), ParentNode);
   FieldNode__4 = MatchToken__4qwp(TokenContext__1, FieldNode__4, "var", true);
   FieldNode__4 = MatchPattern__5qwp(TokenContext__1, FieldNode__4, -2, "$Name$", true);
   FieldNode__4 = MatchPattern__5qwp(TokenContext__1, FieldNode__4, -3, "$TypeAnnotation$", false);
   if (MatchToken__2qwp(TokenContext__1, "=")) {
      FieldNode__4 = MatchPattern__5qwp(TokenContext__1, FieldNode__4, 0, "$Expression$", true);
   };
   FieldNode__4 = MatchPattern__5qwp(TokenContext__1, FieldNode__4, -1, ";", true);
   SetParseFlag__2qwp(TokenContext__1, Rememberd__3);
   return FieldNode__4;
});
ZNode.prototype.FieldPattern = FieldPattern__3qwo;

var FloatLiteralPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Token__3 = GetToken__2qwp(TokenContext__1, true);
   return ZFloatNode__4qp4(new ZFloatNode(), ParentNode, Token__3, LibZen.ParseFloat(GetText__1qw3(Token__3)));
});
ZNode.prototype.FloatLiteralPattern = FloatLiteralPattern__3qwo;

var FunctionPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var FuncNode__3 = ZFunctionNode__2qrb(new ZFunctionNode(), ParentNode);
   FuncNode__3 = MatchToken__4qwp(TokenContext__1, FuncNode__3, "function", true);
   FuncNode__3 = MatchPattern__5qwp(TokenContext__1, FuncNode__3, -2, "$Name$", false);
   FuncNode__3 = MatchNtimes__6qwp(TokenContext__1, FuncNode__3, "(", "$Param$", ",", ")");
   FuncNode__3 = MatchPattern__5qwp(TokenContext__1, FuncNode__3, -3, "$TypeAnnotation$", false);
   FuncNode__3 = MatchPattern__5qwp(TokenContext__1, FuncNode__3, 0, "$Block$", true);
   return FuncNode__3;
});
ZNode.prototype.FunctionPattern = FunctionPattern__3qwo;

var GetIndexPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var IndexerNode__3 = ZGetIndexNode__3qpd(new ZGetIndexNode(), ParentNode, LeftNode__2);
   IndexerNode__3 = MatchToken__4qwp(TokenContext__1, IndexerNode__3, "[", true);
   IndexerNode__3 = MatchPattern__6qwp(TokenContext__1, IndexerNode__3, 1, "$Expression$", true, true);
   IndexerNode__3 = MatchToken__4qwp(TokenContext__1, IndexerNode__3, "]", true);
   return IndexerNode__3;
});
ZNode.prototype.GetIndexPattern = GetIndexPattern__3qwo;

var GetterPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var GetterNode__3 = ZGetterNode__3qp1(new ZGetterNode(), ParentNode, LeftNode__2);
   GetterNode__3 = MatchToken__4qwp(TokenContext__1, GetterNode__3, ".", true);
   GetterNode__3 = MatchPattern__5qwp(TokenContext__1, GetterNode__3, -2, "$Name$", true);
   return GetterNode__3;
});
ZNode.prototype.GetterPattern = GetterPattern__3qwo;

var GroupPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var GroupNode__3 = ZGroupNode__2qp7(new ZGroupNode(), ParentNode);
   GroupNode__3 = MatchToken__4qwp(TokenContext__1, GroupNode__3, "(", true);
   GroupNode__3 = MatchPattern__6qwp(TokenContext__1, GroupNode__3, 0, "$Expression$", true, true);
   GroupNode__3 = MatchToken__4qwp(TokenContext__1, GroupNode__3, ")", true);
   return GroupNode__3;
});
ZNode.prototype.GroupPattern = GroupPattern__3qwo;

var IfPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var IfNode__3 = ZIfNode__2qp2(new ZIfNode(), ParentNode);
   IfNode__3 = MatchToken__4qwp(TokenContext__1, IfNode__3, "if", true);
   IfNode__3 = MatchToken__4qwp(TokenContext__1, IfNode__3, "(", true);
   IfNode__3 = MatchPattern__6qwp(TokenContext__1, IfNode__3, 0, "$Expression$", true, true);
   IfNode__3 = MatchToken__4qwp(TokenContext__1, IfNode__3, ")", true);
   IfNode__3 = MatchPattern__5qwp(TokenContext__1, IfNode__3, 1, "$Block$", true);
   if (MatchNewLineToken__2qwp(TokenContext__1, "else")) {
      var PatternName__4 = "$Block$";
      if (IsNewLineToken__2qwp(TokenContext__1, "if")) {
         PatternName__4 = "if";
      };
      IfNode__3 = MatchPattern__5qwp(TokenContext__1, IfNode__3, 2, PatternName__4, true);
   };
   return IfNode__3;
});
ZNode.prototype.IfPattern = IfPattern__3qwo;

var InstanceOfPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var BinaryNode__3 = ZInstanceOfNode__4q0t(new ZInstanceOfNode(), ParentNode, GetToken__2qwp(TokenContext__1, true), LeftNode__2);
   BinaryNode__3 = MatchPattern__5qwp(TokenContext__1, BinaryNode__3, -3, "$Type$", true);
   return BinaryNode__3;
});
ZNode.prototype.InstanceOfPattern = InstanceOfPattern__3qwo;

var IntLiteralPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Token__3 = GetToken__2qwp(TokenContext__1, true);
   return ZIntNode__4q0o(new ZIntNode(), ParentNode, Token__3, LibZen.ParseInt(GetText__1qw3(Token__3)));
});
ZNode.prototype.IntLiteralPattern = IntLiteralPattern__3qwo;

var LetPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var LetNode__3 = ZLetNode__2q04(new ZLetNode(), ParentNode);
   LetNode__3 = MatchToken__4qwp(TokenContext__1, LetNode__3, "let", true);
   LetNode__3 = MatchPattern__5qwp(TokenContext__1, LetNode__3, -2, "$Name$", true);
   LetNode__3 = MatchPattern__5qwp(TokenContext__1, LetNode__3, -3, "$TypeAnnotation$", false);
   LetNode__3 = MatchToken__4qwp(TokenContext__1, LetNode__3, "=", true);
   LetNode__3 = MatchPattern__5qwp(TokenContext__1, LetNode__3, 0, "$Expression$", true);
   return LetNode__3;
});
ZNode.prototype.LetPattern = LetPattern__3qwo;

var MapEntryPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode__3 = ZMapEntryNode__2q0b(new ZMapEntryNode(), ParentNode);
   LiteralNode__3 = MatchPattern__5qwp(TokenContext__1, LiteralNode__3, 0, "$Expression$", true);
   LiteralNode__3 = MatchToken__4qwp(TokenContext__1, LiteralNode__3, ":", true);
   LiteralNode__3 = MatchPattern__5qwp(TokenContext__1, LiteralNode__3, 1, "$Expression$", true);
   return LiteralNode__3;
});
ZNode.prototype.MapEntryPattern = MapEntryPattern__3qwo;

var MapLiteralPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode__3 = ZMapLiteralNode__2q0m(new ZMapLiteralNode(), ParentNode);
   LiteralNode__3 = MatchNtimes__6qwp(TokenContext__1, LiteralNode__3, "{", "$MapEntry$", ",", "}");
   return LiteralNode__3;
});
ZNode.prototype.MapLiteralPattern = MapLiteralPattern__3qwo;

var MethodCallPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var MethodCallNode__3 = ZMethodCallNode__3q02(new ZMethodCallNode(), ParentNode, LeftNode__2);
   MethodCallNode__3 = MatchToken__4qwp(TokenContext__1, MethodCallNode__3, ".", true);
   MethodCallNode__3 = MatchPattern__5qwp(TokenContext__1, MethodCallNode__3, -2, "$Name$", true);
   MethodCallNode__3 = MatchNtimes__6qwp(TokenContext__1, MethodCallNode__3, "(", "$Expression$", ",", ")");
   return MethodCallNode__3;
});
ZNode.prototype.MethodCallPattern = MethodCallPattern__3qwo;

var NamePattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Token__3 = GetToken__2qwp(TokenContext__1, true);
   if (LibZen.IsSymbol(GetChar__1qw3(Token__3))) {
      return ZGetNameNode__4qph(new ZGetNameNode(), ParentNode, Token__3, GetText__1qw3(Token__3));
   };
   return ZErrorNode__4qpr(new ZErrorNode(), ParentNode, Token__3, ("illegal name: \"" + GetText__1qw3(Token__3)) + "\"");
});
ZNode.prototype.NamePattern = NamePattern__3qwo;

var NameToken__1qwu = (function (SourceContext) {
   var StartIndex__1 = GetPosition__1qwu(SourceContext);
   while (HasChar__1qwu(SourceContext)) {
      var ch__2 = GetCurrentChar__1qwu(SourceContext);
      if (!LibZen.IsSymbol(ch__2) && !LibZen.IsDigit(ch__2)) {
         break;
      };
      MoveNext__1qwu(SourceContext);
   };
   Tokenize__3qwu(SourceContext, StartIndex__1, GetPosition__1qwu(SourceContext));
   return true;
});
ZSourceContext.prototype.NameToken = NameToken__1qwu;

var NewLineToken__1qwu = (function (SourceContext) {
   var StartIndex__1 = GetPosition__1qwu(SourceContext) + 1;
   MoveNext__1qwu(SourceContext);
   SkipWhiteSpace__1qwu(SourceContext);
   FoundIndent__3qwu(SourceContext, StartIndex__1, GetPosition__1qwu(SourceContext));
   return true;
});
ZSourceContext.prototype.NewLineToken = NewLineToken__1qwu;

var NewObjectPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var LiteralNode__3 = ZNewObjectNode__2q4i(new ZNewObjectNode(), ParentNode);
   LiteralNode__3 = MatchToken__4qwp(TokenContext__1, LiteralNode__3, "new", true);
   LiteralNode__3 = MatchPattern__5qwp(TokenContext__1, LiteralNode__3, -3, "$Type$", false);
   LiteralNode__3 = MatchNtimes__6qwp(TokenContext__1, LiteralNode__3, "(", "$Expression$", ",", ")");
   return LiteralNode__3;
});
ZNode.prototype.NewObjectPattern = NewObjectPattern__3qwo;

var NotPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var UnaryNode__3 = ZNotNode__3q44(new ZNotNode(), ParentNode, GetToken__2qwp(TokenContext__1, true));
   UnaryNode__3 = MatchPattern__5qwp(TokenContext__1, UnaryNode__3, 0, "$RightExpression$", true);
   return UnaryNode__3;
});
ZNode.prototype.NotPattern = NotPattern__3qwo;

var NullPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   return ZNullNode__3q4d(new ZNullNode(), ParentNode, GetToken__2qwp(TokenContext__1, true));
});
ZNode.prototype.NullPattern = NullPattern__3qwo;

var NumberLiteralToken_ParseDigit__1qwu = (function (SourceContext) {
   var ch__1 = "0";
   while (HasChar__1qwu(SourceContext)) {
      ch__1 = GetCurrentChar__1qwu(SourceContext);
      if (!LibZen.IsDigit(ch__1)) {
         break;
      };
      MoveNext__1qwu(SourceContext);
   };
   return ch__1;
});
ZSourceContext.prototype.NumberLiteralToken_ParseDigit = NumberLiteralToken_ParseDigit__1qwu;

var NumberLiteralToken__1qwu = (function (SourceContext) {
   var StartIndex__1 = GetPosition__1qwu(SourceContext);
   var ch__2 = NumberLiteralToken_ParseDigit__1qwu(SourceContext);
   if (ch__2 == ".") {
      MoveNext__1qwu(SourceContext);
      ch__2 = NumberLiteralToken_ParseDigit__1qwu(SourceContext);
      if (ch__2 == "e" || ch__2 == "E") {
         MoveNext__1qwu(SourceContext);
         if (HasChar__1qwu(SourceContext)) {
            ch__2 = GetCurrentChar__1qwu(SourceContext);
            if (ch__2 == "+" || ch__2 == "-") {
               MoveNext__1qwu(SourceContext);
            };
         };
         NumberLiteralToken_ParseDigit__1qwu(SourceContext);
      };
      Tokenize__4qwu(SourceContext, "$FloatLiteral$", StartIndex__1, GetPosition__1qwu(SourceContext));
   } else {
      Tokenize__4qwu(SourceContext, "$IntegerLiteral$", StartIndex__1, GetPosition__1qwu(SourceContext));
   };
   return true;
});
ZSourceContext.prototype.NumberLiteralToken = NumberLiteralToken__1qwu;

var OperatorToken__1qwu = (function (SourceContext) {
   TokenizeDefinedSymbol__2qwu(SourceContext, GetPosition__1qwu(SourceContext));
   return true;
});
ZSourceContext.prototype.OperatorToken = OperatorToken__1qwu;

var OrPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var BinaryNode__3 = ZOrNode__5q4h(new ZOrNode(), ParentNode, GetToken__2qwp(TokenContext__1, true), LeftNode__2, GetApplyingSyntax__1qwp(TokenContext__1));
   return AppendParsedRightNode__3qod(BinaryNode__3, ParentNode, TokenContext__1);
});
ZNode.prototype.OrPattern = OrPattern__3qwo;

var ParamPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var ParamNode__3 = ZParamNode__2qtl(new ZParamNode(), ParentNode);
   ParamNode__3 = MatchPattern__5qwp(TokenContext__1, ParamNode__3, -2, "$Name$", true);
   ParamNode__3 = MatchPattern__5qwp(TokenContext__1, ParamNode__3, -3, "$TypeAnnotation$", false);
   return ParamNode__3;
});
ZNode.prototype.ParamPattern = ParamPattern__3qwo;

var PrototypePattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var FuncNode__3 = ZPrototypeNode__2q4l(new ZPrototypeNode(), ParentNode);
   FuncNode__3 = MatchToken__4qwp(TokenContext__1, FuncNode__3, "function", true);
   FuncNode__3 = MatchPattern__5qwp(TokenContext__1, FuncNode__3, -2, "$Name$", true);
   FuncNode__3 = MatchNtimes__6qwp(TokenContext__1, FuncNode__3, "(", "$Param$", ",", ")");
   FuncNode__3 = MatchPattern__5qwp(TokenContext__1, FuncNode__3, -3, "$TypeAnnotation$", true);
   return FuncNode__3;
});
ZNode.prototype.PrototypePattern = PrototypePattern__3qwo;

var ReturnPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var ReturnNode__3 = ZReturnNode__2qtj(new ZReturnNode(), ParentNode);
   ReturnNode__3 = MatchToken__4qwp(TokenContext__1, ReturnNode__3, "return", true);
   ReturnNode__3 = MatchPattern__5qwp(TokenContext__1, ReturnNode__3, 0, "$Expression$", false);
   return ReturnNode__3;
});
ZNode.prototype.ReturnPattern = ReturnPattern__3qwo;

var RightExpressionPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   return ExpressionPattern_DispatchPattern__5qwo(ParentNode, TokenContext__1, LeftNode__2, false, false);
});
ZNode.prototype.RightExpressionPattern = RightExpressionPattern__3qwo;

var RightTypePattern__3qwo = (function (ParentNode, TokenContext__1, LeftTypeNode__2) {
   var SourceToken__6 = GetToken__1qwp(TokenContext__1);
   if (LeftTypeNode__2.Type.GetParamSize(LeftTypeNode__2.Type) > 0) {
      if (MatchToken__2qwp(TokenContext__1, "<")) {
         var TypeList__4 = [];
         while (!StartsWithToken__2qwp(TokenContext__1, ">")) {
            if ((TypeList__4).length > 0 && !MatchToken__2qwp(TokenContext__1, ",")) {
               return null;
            };
            var ParamTypeNode__5 = ParsePattern__4qwp(TokenContext__1, ParentNode, "$Type$", false);
            if (ParamTypeNode__5 == null) {
               return LeftTypeNode__2;
            };
            TypeList__4.push(ParamTypeNode__5.Type);
         };
         LeftTypeNode__2 = ZTypeNode__4qu4(new ZTypeNode(), ParentNode, SourceToken__3, ZTypePool_GetGenericType__3qwg(LeftTypeNode__2.Type, TypeList__4, true));
      };
   };
   while (MatchToken__2qwp(TokenContext__1, "[")) {
      if (!MatchToken__2qwp(TokenContext__1, "]")) {
         return null;
      };
      LeftTypeNode__2 = ZTypeNode__4qu4(new ZTypeNode(), ParentNode, SourceToken__3, ZTypePool_GetGenericType1__2qwg(ZGenericType__5qev(new ZGenericType(), 1 << 16, "Array", null, ZType__4qwg(new ZType(), 1 << 16, "var", null)), LeftTypeNode__2.Type));
   };
   return LeftTypeNode__2;
});
ZNode.prototype.RightTypePattern = RightTypePattern__3qwo;

var SetIndexPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var IndexerNode__3 = ZSetIndexNode__3qtc(new ZSetIndexNode(), ParentNode, LeftNode__2);
   IndexerNode__3 = MatchToken__4qwp(TokenContext__1, IndexerNode__3, "[", true);
   IndexerNode__3 = MatchPattern__6qwp(TokenContext__1, IndexerNode__3, 1, "$Expression$", true, true);
   IndexerNode__3 = MatchToken__4qwp(TokenContext__1, IndexerNode__3, "]", true);
   IndexerNode__3 = MatchToken__4qwp(TokenContext__1, IndexerNode__3, "=", true);
   IndexerNode__3 = MatchPattern__5qwp(TokenContext__1, IndexerNode__3, 2, "$Expression$", true);
   return IndexerNode__3;
});
ZNode.prototype.SetIndexPattern = SetIndexPattern__3qwo;

var SetterPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var SetterNode__3 = ZSetterNode__3qt5(new ZSetterNode(), ParentNode, LeftNode__2);
   SetterNode__3 = MatchToken__4qwp(TokenContext__1, SetterNode__3, ".", true);
   SetterNode__3 = MatchPattern__5qwp(TokenContext__1, SetterNode__3, -2, "$Name$", true);
   SetterNode__3 = MatchToken__4qwp(TokenContext__1, SetterNode__3, "=", true);
   SetterNode__3 = MatchPattern__5qwp(TokenContext__1, SetterNode__3, 1, "$Expression$", true);
   return SetterNode__3;
});
ZNode.prototype.SetterPattern = SetterPattern__3qwo;

var StatementEndPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var ContextAllowance__3 = SetParseFlag__2qwp(TokenContext__1, false);
   var Token__4 = null;
   if (HasNext__1qwp(TokenContext__1)) {
      Token__4 = GetToken__1qwp(TokenContext__1);
      if (!EqualsText__2qw3(Token__4, ";") && !IsIndent__1qw3(Token__4)) {
         SetParseFlag__2qwp(TokenContext__1, ContextAllowance__3);
         return CreateExpectedErrorNode__3qwp(TokenContext__1, Token__4, ";");
      };
      MoveNext__1qwp(TokenContext__1);
      while (HasNext__1qwp(TokenContext__1)) {
         Token__4 = GetToken__1qwp(TokenContext__1);
         if (!EqualsText__2qw3(Token__4, ";") && !IsIndent__1qw3(Token__4)) {
            break;
         };
         MoveNext__1qwp(TokenContext__1);
      };
   };
   SetParseFlag__2qwp(TokenContext__1, ContextAllowance__3);
   return ZEmptyNode__3qpw(new ZEmptyNode(), ParentNode, Token__4);
});
ZNode.prototype.StatementEndPattern = StatementEndPattern__3qwo;

var StatementPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Rememberd__3 = SetParseFlag__2qwp(TokenContext__1, true);
   SetParseFlag__2qwp(TokenContext__1, false);
   var StmtNode__4 = ExpressionPattern_DispatchPattern__5qwo(ParentNode, TokenContext__1, null, true, true);
   StmtNode__4 = MatchPattern__5qwp(TokenContext__1, StmtNode__4, -1, ";", true);
   SetParseFlag__2qwp(TokenContext__1, Rememberd__3);
   return StmtNode__4;
});
ZNode.prototype.StatementPattern = StatementPattern__3qwo;

var StringLiteralPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Token__3 = GetToken__2qwp(TokenContext__1, true);
   return ZStringNode__4q4c(new ZStringNode(), ParentNode, Token__3, LibZen.UnquoteString(GetText__1qw3(Token__3)));
});
ZNode.prototype.StringLiteralPattern = StringLiteralPattern__3qwo;

var StringLiteralToken__1qwu = (function (SourceContext) {
   var StartIndex__1 = GetPosition__1qwu(SourceContext);
   MoveNext__1qwu(SourceContext);
   while (HasChar__1qwu(SourceContext)) {
      var ch__2 = GetCurrentChar__1qwu(SourceContext);
      if (ch__2 == "\"") {
         MoveNext__1qwu(SourceContext);
         Tokenize__4qwu(SourceContext, "$StringLiteral$", StartIndex__1, GetPosition__1qwu(SourceContext));
         return true;
      };
      if (ch__2 == "\n") {
         break;
      };
      if (ch__2 == "\\") {
         MoveNext__1qwu(SourceContext);
      };
      MoveNext__1qwu(SourceContext);
   };
   LogWarning__3qwu(SourceContext, StartIndex__1, "unclosed \"");
   Tokenize__4qwu(SourceContext, "$StringLiteral$", StartIndex__1, GetPosition__1qwu(SourceContext));
   return false;
});
ZSourceContext.prototype.StringLiteralToken = StringLiteralToken__1qwu;

var SymbolExpressionPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var NameToken__3 = GetToken__2qwp(TokenContext__1, true);
   if (IsToken__2qwp(TokenContext__1, "=")) {
      return ZErrorNode__4qpr(new ZErrorNode(), ParentNode, GetToken__1qwp(TokenContext__1), "assignment is not en expression");
   } else {
      return ZGetNameNode__4qph(new ZGetNameNode(), ParentNode, NameToken__3, GetText__1qw3(NameToken__3));
   };
});
ZNode.prototype.SymbolExpressionPattern = SymbolExpressionPattern__3qwo;

var SymbolStatementPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var NameToken__3 = GetToken__2qwp(TokenContext__1, true);
   if (MatchToken__2qwp(TokenContext__1, "=")) {
      var AssignedNode__4 = ZSetNameNode__4qtn(new ZSetNameNode(), ParentNode, NameToken__3, GetText__1qw3(NameToken__3));
      AssignedNode__4 = MatchPattern__5qwp(TokenContext__1, AssignedNode__4, 0, "$Expression$", true);
      return AssignedNode__4;
   } else {
      return ZGetNameNode__4qph(new ZGetNameNode(), ParentNode, NameToken__3, GetText__1qw3(NameToken__3));
   };
});
ZNode.prototype.SymbolStatementPattern = SymbolStatementPattern__3qwo;

var ThrowPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var ThrowNode__3 = ZThrowNode__2qyr(new ZThrowNode(), ParentNode);
   ThrowNode__3 = MatchToken__4qwp(TokenContext__1, ThrowNode__3, "throw", true);
   ThrowNode__3 = MatchPattern__5qwp(TokenContext__1, ThrowNode__3, 0, "$Expression$", true);
   return ThrowNode__3;
});
ZNode.prototype.ThrowPattern = ThrowPattern__3qwo;

var TruePattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   return ZBooleanNode__4qa5(new ZBooleanNode(), ParentNode, GetToken__2qwp(TokenContext__1, true), true);
});
ZNode.prototype.TruePattern = TruePattern__3qwo;

var TryPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var TryNode__3 = ZTryNode__2qyu(new ZTryNode(), ParentNode);
   TryNode__3 = MatchToken__4qwp(TokenContext__1, TryNode__3, "try", true);
   TryNode__3 = MatchPattern__5qwp(TokenContext__1, TryNode__3, 0, "$Block$", true);
   var count__4 = 0;
   if (IsNewLineToken__2qwp(TokenContext__1, "catch")) {
      TryNode__3 = MatchPattern__5qwp(TokenContext__1, TryNode__3, 1, "$Catch$", true);
      count__4 = count__4 + 1;
   };
   if (MatchNewLineToken__2qwp(TokenContext__1, "finally")) {
      TryNode__3 = MatchPattern__5qwp(TokenContext__1, TryNode__3, 2, "$Block$", true);
      count__4 = count__4 + 1;
   };
   if (count__4 == 0 && !IsErrorNode__1qwo(TryNode__3)) {
      return TryNode__3.AST[0];
   };
   return TryNode__3;
});
ZNode.prototype.TryPattern = TryPattern__3qwo;

var TypeAnnotationPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   if (MatchToken__2qwp(TokenContext__1, ":")) {
      return ParsePattern__4qwp(TokenContext__1, ParentNode, "$Type$", true);
   };
   return null;
});
ZNode.prototype.TypeAnnotationPattern = TypeAnnotationPattern__3qwo;

var TypePattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var Token__3 = GetToken__2qwp(TokenContext__1, true);
   var TypeNode__4 = GetTypeNode__3qwt(GetNameSpace__1qwo(ParentNode), GetText__1qw3(Token__3), Token__3);
   if (TypeNode__4 != null) {
      return ParsePatternAfter__5qwp(TokenContext__1, ParentNode, TypeNode__4, "$TypeRight$", false);
   };
   return null;
});
ZNode.prototype.TypePattern = TypePattern__3qwo;

var UnaryPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var UnaryNode__3 = ZUnaryNode__3qyp(new ZUnaryNode(), ParentNode, GetToken__2qwp(TokenContext__1, true));
   return MatchPattern__5qwp(TokenContext__1, UnaryNode__3, 0, "$RightExpression$", true);
});
ZNode.prototype.UnaryPattern = UnaryPattern__3qwo;

var VarPattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var VarNode__3 = ZVarNode__2qsc(new ZVarNode(), ParentNode);
   VarNode__3 = MatchToken__4qwp(TokenContext__1, VarNode__3, "var", true);
   VarNode__3 = MatchPattern__5qwp(TokenContext__1, VarNode__3, -2, "$Name$", true);
   VarNode__3 = MatchPattern__5qwp(TokenContext__1, VarNode__3, -3, "$TypeAnnotation$", false);
   VarNode__3 = MatchToken__4qwp(TokenContext__1, VarNode__3, "=", true);
   VarNode__3 = MatchPattern__5qwp(TokenContext__1, VarNode__3, 0, "$Expression$", true);
   return VarNode__3;
});
ZNode.prototype.VarPattern = VarPattern__3qwo;

var WhilePattern__3qwo = (function (ParentNode, TokenContext__1, LeftNode__2) {
   var WhileNode__3 = ZWhileNode__2qya(new ZWhileNode(), ParentNode);
   WhileNode__3 = MatchToken__4qwp(TokenContext__1, WhileNode__3, "while", true);
   WhileNode__3 = MatchToken__4qwp(TokenContext__1, WhileNode__3, "(", true);
   WhileNode__3 = MatchPattern__6qwp(TokenContext__1, WhileNode__3, 0, "$Expression$", true, true);
   WhileNode__3 = MatchToken__4qwp(TokenContext__1, WhileNode__3, ")", true);
   WhileNode__3 = MatchPattern__5qwp(TokenContext__1, WhileNode__3, 1, "$Block$", true);
   return WhileNode__3;
});
ZNode.prototype.WhilePattern = WhilePattern__3qwo;

var WhiteSpaceToken__1qwu = (function (SourceContext) {
   SkipWhiteSpace__1qwu(SourceContext);
   return true;
});
ZSourceContext.prototype.WhiteSpaceToken = WhiteSpaceToken__1qwu;


