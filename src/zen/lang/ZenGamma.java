package zen.lang;

import zen.deps.Nullable;
import zen.deps.Var;
import zen.parser.ZNameSpace;

public class ZenGamma {
	public static void Debug(String Message) {
		//LibNative.Debug(Message);
	}
	public static ZFunc GetFunc(ZNameSpace NameSpace, String Key, @Nullable ZFunc DefVal) {
		@Var Object Func = NameSpace.GetSymbol(Key);
		ZenGamma.Debug("Signature="+Key+ ", " + Func);
		if(Func instanceof ZFunc) {
			return (ZFunc)Func;
		}
		return DefVal;
	}

	public static ZFunc GetFunc(ZNameSpace NameSpace, String FuncName, ZType FuncType, @Nullable ZFunc DefVal) {
		return ZenGamma.GetFunc(NameSpace, FuncType.StringfySignature(FuncName), DefVal);
	}

	public static void DefineFunc(ZNameSpace NameSpace, ZFunc Func) {
		@Var String Signature = Func.GetSignature();
		ZenGamma.Debug("Signature="+Signature+ ", " + Func);
		NameSpace.GetRootNameSpace().SetSymbol(Signature, Func, null);
	}


}
