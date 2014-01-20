package zen.lang;

import java.util.ArrayList;

import zen.ast.ZenFunctionNode;
import zen.ast.ZenNode;
import zen.deps.Constructor;
import zen.deps.Field;
import zen.deps.Var;
import zen.parser.ZLogger;

class FuncContext {
	@Field FuncContext Parent;
	@Field ZLogger Logger;
	@Field ZenFunctionNode FuncNode;
	@Field ZenFuncType FuncType;
	@Field int ReturnCount;
	@Field ArrayList<ZenVarType> VarTypeList;
	@Field int VarIndex;
	@Field int CountOfUnknownTypeNode;

	@Constructor FuncContext(FuncContext Parent, ZLogger Logger, ZenFunctionNode FuncNode, ZenFuncType FuncType) {
		this.Parent = Parent;
		this.Logger = Logger;
		this.FuncNode = FuncNode;
		this.FuncType = FuncType;
		this.ReturnCount = 0;
		this.VarTypeList = new ArrayList<ZenVarType>();
		this.VarIndex = 0;
		this.CountOfUnknownTypeNode = 0;
	}

	public ZenType GetReturnType() {
		this.ReturnCount = this.ReturnCount + 1;
		return this.FuncNode.ReturnType;
	}

	public ZenFuncType RecheckCompleteFuncType(ZenFunctionNode FuncNode) {
		@Var ZenFuncType FuncType = this.FuncType;
		if(!FuncType.IsCompleteFunc(false)) {
			if(FuncNode.ReturnType.IsVarType() && this.ReturnCount == 0) {
				((ZenVarType)FuncNode.ReturnType).Infer(ZenSystem.VoidType, FuncNode.SourceToken);
			}
			this.FuncType = this.FuncNode.GetFuncType(null);
			if(this.FuncType.IsCompleteFunc(false)) {
				return this.FuncType;
			}
		}
		return null;  // no renewal
	}

	//	public int GetVarSize() {
	//		@Var int count = 0;
	//		@Var int i = 0;
	//		while(i < this.VarTypeList.size()) {
	//			@Var ZenVarType VarType = this.VarTypeList.get(i);
	//			if(VarType.IsVarType()) {
	//				count = count + 1;
	//			}
	//			i = i + 1;
	//		}
	//		return count;
	//	}

	public void Dump() {
		@Var int i = 0;
		//		this.println("returning type: " + this.FuncNode.ReturnType);
		while(i < this.VarTypeList.size()) {
			@Var ZenVarType VarType = this.VarTypeList.get(i);
			if(VarType.IsVarType()) {
				this.Logger.ReportInfo(VarType.SourceToken, "ambigious type: " + VarType.ShortName);
			}
			//			this.println("type inference: " + VarType.ShortName + ": " + VarType.GetRealType());
			i = i + 1;
		}
		//		this.println("unknown type count = " + this.CountOfUnknownTypeNode);
		this.VarTypeList.clear();
	}

	public int GetVarIndex() {
		int Index = this.VarIndex;
		this.VarIndex = this.VarIndex + 1;
		return Index;
	}

	public void CountUnknownTypeNode(ZenNode Node) {
		this.CountOfUnknownTypeNode = this.CountOfUnknownTypeNode + 1;
	}

	protected void println(String string) {
		System.err.println("debug " + string);
	}

}