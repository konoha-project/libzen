package zen.codegen.jvm;

import java.lang.reflect.Method;

import zen.parser.ZMacroFunc;
import zen.type.ZFuncType;
import zen.util.Field;

public class JavaStaticFunc extends ZMacroFunc {
	@Field Method StaticFunc;
	public JavaStaticFunc(String FuncName, ZFuncType FuncType, Method StaticMethod) {
		super(FuncName, FuncType, null);
		this.StaticFunc = StaticMethod;
	}

}
