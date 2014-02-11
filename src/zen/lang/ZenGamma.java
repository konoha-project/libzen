package zen.lang;

import zen.ast.ZBooleanNode;
import zen.ast.ZFloatNode;
import zen.ast.ZIntNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.deps.LibZen;
import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;
import zen.type.ZType;

public class ZenGamma {

	public static void Debug(String Message) {
		LibZen._PrintDebug(Message);
	}

	static ZFunc GetFunc(ZNameSpace NameSpace, String GlobalName, @Nullable ZFunc DefVal) {
		@Var ZFunc Func = NameSpace.Generator.GetDefinedFunc(GlobalName);
		//Debug("GlobalKey="+GlobalName + ", " + Func);
		if(Func == null) {
			return DefVal;
		}
		return Func;
	}

	static ZFunc GetFunc(ZNameSpace NameSpace, String FuncName, ZType FuncType, @Nullable ZFunc DefVal) {
		return ZenGamma.GetFunc(NameSpace, FuncType.StringfySignature(FuncName), DefVal);
	}

	public static ZFunc LookupFunc(ZNameSpace NameSpace, String FuncName, ZType RecvType, int FuncParamSize) {
		@Var String Signature = ZFunc.StringfySignature(FuncName, FuncParamSize, RecvType);
		@Var ZFunc Func = NameSpace.Generator.GetDefinedFunc(Signature);
		if(Func != null) {
			return Func;
		}
		if(RecvType.IsIntType()) {
			Signature = ZFunc.StringfySignature(FuncName, FuncParamSize, ZType.FloatType);
			Func = NameSpace.Generator.GetDefinedFunc(Signature);
			if(Func != null) {
				return Func;
			}
		}
		if(RecvType.IsFloatType()) {
			Signature = ZFunc.StringfySignature(FuncName, FuncParamSize, ZType.IntType);
			Func = NameSpace.Generator.GetDefinedFunc(Signature);
			if(Func != null) {
				return Func;
			}
		}
		RecvType = RecvType.GetSuperType();
		while(RecvType != null) {
			Signature = ZFunc.StringfySignature(FuncName, FuncParamSize, RecvType);
			Func = NameSpace.Generator.GetDefinedFunc(Signature);
			if(Func != null) {
				return Func;
			}
			if(RecvType.IsVarType()) {
				break;
			}
			RecvType = RecvType.GetSuperType();
		}
		return null;
	}


	static void DefineFunc(ZNameSpace NameSpace, ZFunc Func) {
		//Debug("def GlobalKey="+Func.GetSignature() + ", " + Func);
		NameSpace.Generator.SetDefinedFunc(Func);
	}

	static ZType GetIndexType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsStringType()) {
			return ZType.IntType;
		}
		if(RecvType.IsMapType()) {
			return ZType.StringType;
		}
		return ZType.VarType;
	}

	static ZType GetElementType(ZNameSpace NameSpace, ZType RecvType) {
		if(RecvType.IsArrayType() || RecvType.IsMapType()) {
			return RecvType.GetParamType(0);
		}
		if(RecvType.IsStringType()) {
			return ZType.StringType;
		}
		return ZType.VarType;
	}

	static void SetClassField(ZNameSpace NameSpace, ZType ClassType, String FieldName, ZType FieldType, ZToken SourceToken) {
		//		ZenField Field = new ZenField(FieldName, FieldType, SourceToken);
		//		NameSpace.GetRootNameSpace().SetSymbol(ZNameSpace.StringfyClassSymbol(ClassType, FieldName), Field, SourceToken);
	}

	static protected final ZenField GetField(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		//		Object Field = NameSpace.GetRootNameSpace().GetClassSymbol(ClassType, FieldName, true);
		//		if(Field instanceof ZenField) {
		//			return (ZenField)Field;
		//		}
		return null;
	}

	static protected final ZType GetFieldType(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		if(ClassType instanceof ZenClassType) {
			return ((ZenClassType)ClassType).GetFieldType(FieldName, ZType.VoidType);
		}
		//		Object Field = NameSpace.GetRootNameSpace().GetClassSymbol(ClassType, FieldName, true);
		//		if(Field instanceof ZenField) {
		//			return ((ZenField)Field).FieldType;
		//		}
		return NameSpace.Generator.GetFieldType(ClassType, FieldName);
	}

	static protected final ZType GetSetterType(ZNameSpace NameSpace, ZType ClassType, String FieldName) {
		if(ClassType instanceof ZenClassType) {
			return ((ZenClassType)ClassType).GetFieldType(FieldName, ZType.VoidType);
		}
		//		Object Field = NameSpace.GetRootNameSpace().GetClassSymbol(ClassType, FieldName, true);
		//		if(Field instanceof ZenField) {
		//			return ((ZenField)Field).FieldType;
		//		}
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

	static protected ZNode CreateDefaultValueNode(ZNode ParentNode, ZType Type, String FieldName) {
		//		if(FieldName != null && Type.IsFuncType()) {
		//			return new ZSymbolNode(ParentNode, null, Type, FieldName, Type.StringfySignature(FieldName));
		//		}
		if(Type.IsIntType()) {
			return new ZIntNode(ParentNode, null, 0);
		}
		else if(Type.IsBooleanType()) {
			return new ZBooleanNode(ParentNode, null, false);
		}
		else if(Type.IsFloatType()) {
			return new ZFloatNode(ParentNode, null, 0.0);
		}
		return new ZNullNode(ParentNode, null);
	}

}
