package zen.type;

import zen.ast.ZFunctionNode;
import zen.ast.ZNode;
import zen.parser.ZLogger;
import zen.parser.ZToken;
import zen.parser.ZTypeChecker;
import zen.util.Field;
import zen.util.Var;
import zen.util.ZArray;

public final class ZVarScope {
	@Field public ZVarScope Parent;
	@Field public ZLogger Logger;
	@Field ZArray<ZVarType> VarList;
	@Field int TypedNodeCount = 0;
	@Field int VarNodeCount = 0;
	@Field int UnresolvedSymbolCount = 0;


	public ZVarScope(ZVarScope Parent, ZLogger Logger, ZArray<ZVarType> VarList) {
		this.Parent = Parent;
		this.Logger = Logger;
		this.VarList = VarList;
		if(this.VarList == null) {
			this.VarList = new ZArray<ZVarType>(new ZVarType[8]);
		}
	}

	public void TypeNode(ZNode Node, ZType Type) {
		if(Type instanceof ZVarType) {
			if(!Type.IsVarType()) {
				Type = Type.GetRealType();
			}
		}
		if(Node.Type != Type) {
			Node.Type = Type;
			this.TypedNodeCount = this.TypedNodeCount + 1;
		}
	}

	public final ZType NewVarType(ZType VarType, String Name, ZToken SourceToken) {
		if(!(VarType instanceof ZVarType) && VarType.IsVarType()) {
			//System.out.println("@@ new var = " + Name);
			VarType = new ZVarType(this.VarList, Name, SourceToken);
		}
		return VarType;
	}

	public final void FoundUnresolvedSymbol(String FuncName) {
		//System.out.println("unresolved name: " + FuncName);
		this.UnresolvedSymbolCount = this.UnresolvedSymbolCount + 1;
	}

	public final void InferType(ZType ContextType, ZNode Node) {
		//System.out.println("@@ infering .. ContextType=" + ContextType + " Node.Type = " + Node.Type + ", at " + Node);
		if(Node.IsUntyped()) {
			this.VarNodeCount = this.VarNodeCount + 1;
		}
		if(ContextType.IsInferrableType() && Node.Type instanceof ZVarType) {
			((ZVarType)Node.Type).Infer(ContextType, Node.SourceToken);
			Node.Type = ContextType;
		}
		if(ContextType instanceof ZVarType && !Node.IsUntyped()) {
			((ZVarType)ContextType).Infer(Node.Type, Node.SourceToken);
		}
	}

	//	public final boolean TypeCheckStmtList(ZTypeChecker TypeSafer, ZArray<ZNode> StmtList) {
	//		@Var int PrevCount = -1;
	//		while(true) {
	//			@Var int i = 0;
	//			this.VarNodeCount = 0;
	//			this.UnresolvedSymbolCount = 0;
	//			while(i < StmtList.size()) {
	//				StmtList.ArrayValues[i] = TypeSafer.CheckType(StmtList.ArrayValues[i], ZType.VoidType);
	//				i = i + 1;
	//			}
	//			if(this.VarNodeCount == 0 || PrevCount == this.VarNodeCount) {
	//				break;
	//			}
	//			PrevCount = this.VarNodeCount;
	//		}
	//		if(this.VarNodeCount == 0) {
	//			return true;
	//		}
	//		return false;
	//	}

	public final void TypeCheckFuncBlock(ZTypeChecker TypeSafer, ZFunctionNode FunctionNode) {
		@Var int PrevCount = -1;
		while(true) {
			this.VarNodeCount = 0;
			this.UnresolvedSymbolCount = 0;
			this.TypedNodeCount = 0;
			TypeSafer.DefineFunction(FunctionNode, false/*Enforced*/);
			TypeSafer.CheckTypeAt(FunctionNode, ZFunctionNode._Block, ZType.VoidType);
			if(!FunctionNode.BlockNode().IsUntyped() || this.TypedNodeCount == 0) {
				break;
			}
			//System.out.println("@@ VarNodeCount="+ this.VarNodeCount + " Block.IsUntyped()=" + FunctionNode.BlockNode().IsUntyped());
			//System.out.println("@@ TypedNodeCount=" + this.TypedNodeCount + " Block.IsUntyped()=" + FunctionNode.BlockNode().IsUntyped());
			if(this.VarNodeCount == 0 || PrevCount == this.VarNodeCount) {
				break;
			}
			PrevCount = this.VarNodeCount;
		}
		if(this.Parent != null) {
			this.Parent.TypedNodeCount = this.Parent.TypedNodeCount = this.TypedNodeCount;
		}
		if(this.UnresolvedSymbolCount == 0) {
			TypeSafer.DefineFunction(FunctionNode, true);
		}
		else {
			TypeSafer.DefineFunction(FunctionNode, false/*Enforced*/);
			if(this.Parent != null) {
				this.Parent.UnresolvedSymbolCount = this.UnresolvedSymbolCount + this.Parent.UnresolvedSymbolCount;
			}
		}
	}

}
