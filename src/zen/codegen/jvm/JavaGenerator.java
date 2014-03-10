package zen.codegen.jvm;

import zen.parser.ZGenerator;
import zen.parser.ZLangInfo;

public abstract class JavaGenerator extends ZGenerator {

	protected JavaGenerator(String TargetCode, String TargetVersion) {
		super(new ZLangInfo(TargetVersion, TargetCode));
	}

	// generated class


	//	// generated method
	//
	//	protected  Method LoadDefinedFunc(String FuncName, ZFuncType FuncType) {
	//		return this.FuncMap.GetOrNull(FuncType.StringfySignature(FuncName));
	//	}
	//
	//	protected void SetStaticFuncMethod(String FuncName, Method jMethod) {
	//		//	this.Debug(FuncName + ", " + jMethod);
	//		this.FuncMap.put(FuncName, jMethod);
	//	}
	//
	//	public Method GetStaticFuncMethod(String FuncName) {
	//		Method jMethod = this.FuncMap.GetOrNull(FuncName);
	//		//	this.Debug(FuncName + ", " + jMethod);
	//		return jMethod;
	//	}
	//


}
