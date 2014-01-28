package zen.lang;

import java.util.ArrayList;

import zen.ast.ZFunctionNode;
import zen.ast.ZNode;
import zen.deps.Field;
import zen.deps.LibNative;
import zen.deps.Var;
import zen.parser.ZLogger;
import zen.type.ZFuncType;

final class ZFuncContext {
	@Field ZFuncContext Parent;
	@Field ZLogger Logger;
	@Field ZFunctionNode FuncNode;
	@Field ZFuncType FuncType;
	@Field int ReturnCount;
	@Field ArrayList<ZVarType> VarTypeList;
	@Field int VarIndex;
	@Field int CountOfUnknownTypeNode;

	ZFuncContext(ZFuncContext Parent, ZLogger Logger, ZFunctionNode FuncNode, ZFuncType FuncType) {
		this.Parent = Parent;
		this.Logger = Logger;
		this.FuncNode = FuncNode;
		this.FuncType = FuncType;
		this.ReturnCount = 0;
		this.VarTypeList = new ArrayList<ZVarType>();
		this.VarIndex = 0;
		this.CountOfUnknownTypeNode = 0;
	}

	public ZType GetReturnType() {
		this.ReturnCount = this.ReturnCount + 1;
		return this.FuncNode.ReturnType;
	}

	public ZFuncType RecheckCompleteFuncType(ZFunctionNode FuncNode) {
		@Var ZFuncType FuncType = this.FuncType;
		if(!FuncType.IsVarType(false)) {
			if(FuncNode.ReturnType.IsVarType() && this.ReturnCount == 0) {
				((ZVarType)FuncNode.ReturnType).Infer(ZSystem.VoidType, FuncNode.SourceToken);
			}
			this.FuncType = this.FuncNode.GetFuncType(null);
			if(this.FuncType.IsVarType(false)) {
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
			@Var ZVarType VarType = this.VarTypeList.get(i);
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

	public void CountUnknownTypeNode(ZNode Node) {
		this.CountOfUnknownTypeNode = this.CountOfUnknownTypeNode + 1;
	}

	protected void println(String string) {
		LibNative.Debug("debug " + string);
	}

}