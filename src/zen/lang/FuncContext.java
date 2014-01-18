package zen.lang;

import java.util.ArrayList;

import zen.ast.ZenFunctionLiteralNode;
import zen.ast.ZenNode;
import zen.deps.Constructor;
import zen.deps.Field;
import zen.deps.Var;

class FuncContext {
	@Field FuncContext Parent;
	@Field public ZenFunctionLiteralNode FuncNode;
	@Field public ZenFuncType FuncType;
	//	@Field public String PredefinedSignature;
	@Field boolean IsInferredReturn;
	@Field ArrayList<ZenVarType> VarTypeList;
	@Field public int VarIndex;
	@Field public int CountOfUnknownTypeNode;

	@Constructor FuncContext(FuncContext Parent, ZenFunctionLiteralNode FuncNode, ZenFuncType FuncType) {
		this.Parent = Parent;
		this.FuncNode = FuncNode;
		this.FuncType = FuncType;
		this.IsInferredReturn = false;
		this.VarTypeList = new ArrayList<ZenVarType>();
		this.VarIndex = 0;
		this.CountOfUnknownTypeNode = 0;
	}

	public void HasReturnType(ZenType InferredType) {
		this.IsInferredReturn = true;
	}

	public ZenFuncType RecheckCompleteFuncType(ZenFunctionLiteralNode FuncNode) {
		@Var ZenFuncType FuncType = this.FuncType;
		if(!FuncType.IsCompleteFunc()) {
			if(FuncNode.ReturnType.IsVarType() && !this.IsInferredReturn) {
				FuncNode.ReturnType = ZenSystem.VoidType;
			}
			this.FuncType = this.FuncNode.GetFuncType();
			if(this.FuncType.IsCompleteFunc()) {
				return this.FuncType;
			}
		}
		return null;  // no renewal
	}

	public int GetVarSize() {
		@Var int count = 0;
		@Var int i = 0;
		while(i < this.VarTypeList.size()) {
			@Var ZenVarType VarType = this.VarTypeList.get(i);
			if(VarType.IsVarType()) {
				count = count + 1;
			}
			i = i + 1;
		}
		return count;
	}

	public void Dump() {
		@Var int i = 0;
		this.println("returning type: " + this.FuncNode.ReturnType);
		while(i < this.VarTypeList.size()) {
			@Var ZenVarType VarType = this.VarTypeList.get(i);
			this.println("type inference: " + VarType.ShortName + ": " + VarType.GetRealType());
			i = i + 1;
		}
		this.println("unknown type count = " + this.CountOfUnknownTypeNode);
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