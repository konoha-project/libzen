package zen.lang;

import zen.ast.ZBooleanNode;
import zen.ast.ZFloatNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZIntNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.ast.ZSymbolNode;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;

public class ZenGamma {
	public static void Debug(String Message) {
		//LibNative.Debug(Message);
	}

	static ZFunc GetFunc(ZNameSpace NameSpace, String Key, @Nullable ZFunc DefVal) {
		@Var Object Func = NameSpace.GetSymbol(Key);
		ZenGamma.Debug("Signature="+Key+ ", " + Func);
		if(Func instanceof ZFunc) {
			return (ZFunc)Func;
		}
		return DefVal;
	}

	static ZFunc GetFunc(ZNameSpace NameSpace, String FuncName, ZType FuncType, @Nullable ZFunc DefVal) {
		return ZenGamma.GetFunc(NameSpace, FuncType.StringfySignature(FuncName), DefVal);
	}

	static void DefineFunc(ZNameSpace NameSpace, ZFunc Func) {
		@Var String Signature = Func.GetSignature();
		ZenGamma.Debug("Signature="+Signature+ ", " + Func);
		NameSpace.GetRootNameSpace().SetSymbol(Signature, Func, null);
	}

	static ZType GetIndexType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsStringType()) {
			return ZSystem.IntType;
		}
		if(RecvType.IsMapType()) {
			return ZSystem.StringType;
		}
		return ZSystem.VarType;
	}

	static ZType GetElementType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsMapType()) {
			return RecvType.GetParamType(0);
		}
		if(RecvType.IsStringType()) {
			return ZSystem.StringType;
		}
		return ZSystem.VarType;
	}

	static void SetClassField(ZNameSpace NameSpace, ZType ClassType, String FieldName, ZType FieldType, ZToken SourceToken) {
		ZenField Field = new ZenField(FieldName, FieldType, SourceToken);
		NameSpace.GetRootNameSpace().SetSymbol(ZNameSpace.StringfyClassSymbol(ClassType, FieldName), Field, SourceToken);
	}

	static protected final ZenField GetField(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		Object Field = NameSpace.GetRootNameSpace().GetClassSymbol(ClassType, FieldName, true);
		if(Field instanceof ZenField) {
			return (ZenField)Field;
		}
		return null;
	}

	static protected final ZType GetFieldType(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		if(ClassType instanceof ZenClassType) {
			return ((ZenClassType)ClassType).GetFieldType(FieldName, ZSystem.VoidType);
		}
		Object Field = NameSpace.GetRootNameSpace().GetClassSymbol(ClassType, FieldName, true);
		if(Field instanceof ZenField) {
			return ((ZenField)Field).FieldType;
		}
		return NameSpace.Generator.GetFieldType(ClassType, FieldName);
	}

	static protected final ZType GetSetterType(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		if(ClassType instanceof ZenClassType) {
			return ((ZenClassType)ClassType).GetFieldType(FieldName, ZSystem.VoidType);
		}
		Object Field = NameSpace.GetRootNameSpace().GetClassSymbol(ClassType, FieldName, true);
		if(Field instanceof ZenField) {
			return ((ZenField)Field).FieldType;
		}
		return NameSpace.Generator.GetSetterType(ClassType, FieldName);
	}

	//	static ZType InferFieldType(ZNameSpace NameSpace, ZType ClassType, String FieldName, ZType InferredType, ZToken SourceToken) {
	//		this.Debug("field inferrence " + ClassType + "." + FieldName + ": " + InferredType);
	//		if(ClassType.IsVarType() || !InferredType.IsInferrableType()) {
	//			return ZSystem.VarType;
	//		}
	//		if(ClassType.IsOpenType()) {
	//			this.Logger.ReportInfo(SourceToken, "field " + ClassType + "." + FieldName + ": " + InferredType);
	//			this.SetClassField(NameSpace, ClassType, FieldName, InferredType, SourceToken);
	//		}
	//		return InferredType;
	//	}

	static protected ZNode CreateDefaultValueNode(ZType Type, String FieldName) {
		if(FieldName != null && Type.IsFuncType()) {
			return new ZSymbolNode(Type, null, FieldName, Type.StringfySignature(FieldName));
		}
		if(Type.IsIntType()) {
			return new ZIntNode(null, 0);
		}
		else if(Type.IsBooleanType()) {
			return new ZBooleanNode(null, false);
		}
		else if(Type.IsFloatType()) {
			return new ZFloatNode(null, 0.0);
		}
		return new ZNullNode(null);
	}

	static ZenVariable GetLocalVariable(ZNameSpace NameSpace, String VarName) {
		@Var Object VarInfo = NameSpace.GetSymbol(VarName);
		if(VarInfo instanceof ZenVariable) {
			return (ZenVariable)VarInfo;
		}
		return null;
	}

	static void SetLocalVariable(ZNameSpace NameSpace, ZFunctionNode FunctionNode, ZType VarType, String VarName, ZToken SourceToken) {
		@Var ZenVariable VarInfo = new ZenVariable(FunctionNode, 0, VarType, VarName, FunctionNode.GetVarIndex(), SourceToken);
		NameSpace.SetSymbol(VarName, VarInfo, SourceToken);
	}



}
