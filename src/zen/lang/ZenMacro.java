package zen.lang;

import java.util.ArrayList;

import zen.ast.ZNode;
import zen.deps.Field;
import zen.deps.LibZen;
import zen.parser.ZSourceGenerator;

public class ZenMacro extends ZFunc {
	@Field String Macro;
	public ZenMacro(int FuncFlag, String FuncName, ZenFuncType FuncType, String Macro) {
		super(FuncFlag, FuncName, FuncType);
		this.Macro = Macro;
	}

	public void Expand(ZSourceGenerator Generator, ArrayList<ZNode> ParamList) {
		int BeginIndex = 0;
		while(true) {
			int Index = this.Macro.indexOf("${", BeginIndex);
			if(Index == -1) {
				Generator.AppendCode(this.Macro.substring(BeginIndex));
				break;
			}
			Generator.AppendCode(this.Macro.substring(BeginIndex, Index));
			int NumIndex = this.Macro.indexOf("}", Index+2);
			int n = (int)LibZen.ParseInt(this.Macro.substring(Index+2, NumIndex));
			Generator.GenerateCode(ParamList.get(n-1));
			BeginIndex = NumIndex+1;
		}
	}


}
