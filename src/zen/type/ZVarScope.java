package zen.type;

import java.util.ArrayList;

import zen.ast.ZNode;
import zen.deps.Field;
import zen.deps.Var;
import zen.lang.ZSystem;
import zen.lang.ZType;
import zen.lang.ZVarType;
import zen.parser.ZLogger;
import zen.parser.ZNameSpace;
import zen.parser.ZToken;

public final class ZVarScope {
	@Field public ZVarScope Parent;
	@Field public ZLogger Logger;
	@Field ArrayList<ZVarType> VarList;
	@Field int VarNodeCount;

	////	@Field ZFunctionNode FuncNode;
	////	@Field ZFuncType FuncType;
	//	@Field int ReturnCount;
	@Field int VarIndex;

	ZVarScope(ZVarScope Parent, ZLogger Logger, ArrayList<ZVarType> VarList) {
		this.Parent = Parent;
		this.Logger = Logger;
		this.VarList = VarList;
		if(this.VarList == null) {
			this.VarList = new ArrayList<ZVarType>();
		}
		this.VarIndex = 0;
		this.VarNodeCount = 0;
		//		this.FuncNode = FuncNode;
		//		this.FuncType = FuncType;
		//		this.ReturnCount = 0;
	}

	public final ZType NewVarType(ZType VarType, String Name, ZToken SourceToken) {
		if(!(VarType instanceof ZVarType) && VarType.IsVarType()) {
			int AlphaId = this.VarList.size();
			ZVarType VarType1 = new ZVarType(Name, AlphaId, SourceToken);
			this.VarList.add(VarType1);
			VarType = VarType1;
		}
		return VarType;
	}

	public final void CheckVarNode(ZType ContextType, ZNode Node) {
		if(Node.IsVarType()) {
			this.VarNodeCount = this.VarNodeCount + 1;
		}
		if(ContextType.IsInferrableType() && Node.Type instanceof ZVarType) {
			((ZVarType)Node.Type).Infer(ContextType, Node.SourceToken);
			Node.Type = ContextType;
		}
		if(ContextType instanceof ZVarType && !Node.IsVarType()) {
			((ZVarType)ContextType).Infer(Node.Type, Node.SourceToken);
		}
	}

	public final boolean TypeCheckNodeList(ZNameSpace NameSpace, ZTypeChecker TypeChecker, ArrayList<ZNode> NodeList) {
		@Var int i = 0;
		@Var int PrevCount = -1;
		while(true) {
			this.VarNodeCount = 0;
			while(i < NodeList.size()) {
				NodeList.set(i, TypeChecker.CheckType(NodeList.get(i), NameSpace, ZSystem.VoidType));
				i = i + 1;
			}
			if(this.VarNodeCount == 0 && PrevCount != this.VarNodeCount) {
				break;
			}
			PrevCount = this.VarNodeCount;
		}
		if(this.VarNodeCount == 0) {
			return true;
		}
		return false;
	}
	//
	//
	//	public ZVarType NewVarType() {
	//
	//	}
	//
	//	public ZType GetReturnType() {
	//		this.ReturnCount = this.ReturnCount + 1;
	//		return this.FuncNode.ReturnType;
	//	}
	//
	//	public ZFuncType RecheckCompleteFuncType(ZFunctionNode FuncNode) {
	//		@Var ZFuncType FuncType = this.FuncType;
	//		if(!FuncType.IsCompleteFunc(false)) {
	//			if(FuncNode.ReturnType.IsVarType() && this.ReturnCount == 0) {
	//				((ZVarType)FuncNode.ReturnType).Infer(ZSystem.VoidType, FuncNode.SourceToken);
	//			}
	//			this.FuncType = this.FuncNode.GetFuncType(null);
	//			if(this.FuncType.IsCompleteFunc(false)) {
	//				return this.FuncType;
	//			}
	//		}
	//		return null;  // no renewal
	//	}
	//
	//	//	public int GetVarSize() {
	//	//		@Var int count = 0;
	//	//		@Var int i = 0;
	//	//		while(i < this.VarTypeList.size()) {
	//	//			@Var ZenVarType VarType = this.VarTypeList.get(i);
	//	//			if(VarType.IsVarType()) {
	//	//				count = count + 1;
	//	//			}
	//	//			i = i + 1;
	//	//		}
	//	//		return count;
	//	//	}
	//
	//	public void Dump() {
	//		@Var int i = 0;
	//		//		this.println("returning type: " + this.FuncNode.ReturnType);
	//		while(i < this.VarTypeList.size()) {
	//			@Var ZVarType VarType = this.VarTypeList.get(i);
	//			if(VarType.IsVarType()) {
	//				this.Logger.ReportInfo(VarType.SourceToken, "ambigious type: " + VarType.ShortName);
	//			}
	//			//			this.println("type inference: " + VarType.ShortName + ": " + VarType.GetRealType());
	//			i = i + 1;
	//		}
	//		//		this.println("unknown type count = " + this.CountOfUnknownTypeNode);
	//		this.VarTypeList.clear();
	//	}
	//
	//	public int GetVarIndex() {
	//		int Index = this.VarIndex;
	//		this.VarIndex = this.VarIndex + 1;
	//		return Index;
	//	}
	//
	//
	//	protected void println(String string) {
	//		System.err.println("debug " + string);
	//	}

}
