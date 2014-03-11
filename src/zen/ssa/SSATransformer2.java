package zen.ssa;

import java.util.ArrayList;

import zen.ast.ZFunctionNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZIfNode;
import zen.ast.ZParamNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZVarNode;
import zen.ast.ZWhileNode;

enum VariableState {
	Default,
	Modified
}

/**
 * Super-naive liner SSA(Static Single Assignment) form transformer
 * @author masahiro ide
 *
 */
public class SSATransformer2 extends ZASTTransformer {
	ArrayList<Variable> LocalVariables;
	ArrayList<VariableState> LocalStates;

	public SSATransformer2() {
		this.LocalVariables = new ArrayList<Variable>();
		this.LocalStates = new ArrayList<VariableState>();
	}

	private Variable FindVariable(String Name) {
		for (int i = this.LocalStates.size() - 1; i >= 0; i--) {
			Variable V = this.LocalVariables.get(i);
			if(V != null && V.Name.equals(Name)) {
				return V;
			}
		}
		assert(false); // unreachable
		return null;
	}

	private ArrayList<VariableState> CloneTable() {
		ArrayList<VariableState> NewList = new ArrayList<VariableState>();
		for (int i = 0; i < this.LocalStates.size(); i++) {
			NewList.add(this.LocalStates.get(i));
		}
		return NewList;
	}

	private void AddVariable(Variable V) {
		V.Index = this.LocalVariables.size();
		this.LocalStates.add(VariableState.Default);
		V.Def(V.Node);
		this.LocalVariables.add(V);
	}

	private void PlacePHINode(ArrayList<VariableState> State1, ArrayList<VariableState> State2) {
		assert(State1.size() == State2.size());
		for (int i = 0; i < State1.size(); i++) {
			VariableState S1 = State1.get(i);
			VariableState S2 = State2.get(i);
			if(S1 == VariableState.Modified || S2 == VariableState.Modified) {
				Variable V = this.LocalVariables.get(i);
				System.out.println(V);
			}
		}
	}

	@Override
	public void VisitGetNameNode(ZGetNameNode Node) {
		this.FindVariable(Node.GetName()).Use(Node);
	}

	@Override
	public void VisitSetNameNode(ZSetNameNode Node) {
		Variable V = this.FindVariable(Node.GetName());
		V.Def(Node);
		this.LocalStates.set(V.Index, VariableState.Modified);
	}

	@Override
	public void VisitVarNode(ZVarNode Node) {
		Variable V = new Variable(Node.GetName(), Node);
		this.AddVariable(V);
		for (int i = 0; i < Node.GetListSize(); i++) {
			Node.GetListAt(i).Accept(this);
		}
		this.LocalVariables.set(V.Index, null);
	}

	@Override
	public void VisitIfNode(ZIfNode Node) {
		ArrayList<VariableState> Original = this.LocalStates;
		ArrayList<VariableState> ThenBlockVars = this.CloneTable();
		ArrayList<VariableState> ElseBlockVars = this.CloneTable();
		Node.CondNode().Accept(this);
		this.LocalStates = ThenBlockVars;
		Node.ThenNode().Accept(this);
		this.LocalStates = ElseBlockVars;
		Node.ElseNode().Accept(this);
		this.LocalStates = Original;
		this.PlacePHINode(ThenBlockVars, ElseBlockVars);
	}

	@Override
	public void VisitWhileNode(ZWhileNode Node) {
		ArrayList<VariableState> Original = this.LocalStates;
		ArrayList<VariableState> BlockVars = this.CloneTable();
		Node.CondNode().Accept(this);
		this.LocalStates = BlockVars;
		Node.BlockNode().Accept(this);
		this.PlacePHINode(BlockVars, null);
		this.LocalStates = Original;
	}

	//	@Override
	//	public void VisitCatchNode(ZCatchNode Node) {
	//		Variable V = new Variable(Node.GivenName, Node);
	//		this.AddVariable(V);
	//		Node.AST[ZCatchNode._Block].Accept(this);
	//		this.LocalVariables.set(V.Index, null);
	//	}

	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		ArrayList<Variable> OriginalVars = this.LocalVariables;
		ArrayList<VariableState> OriginalState = this.LocalStates;
		this.LocalVariables = new ArrayList<Variable>();

		for(int i = 0; i < Node.GetListSize(); i++) {
			ZParamNode ParamNode = Node.GetParamNode(i);
			this.AddVariable(new Variable(ParamNode.GetName(), ParamNode));
		}
		Node.BlockNode().Accept(this);

		this.LocalVariables = OriginalVars;
		this.LocalStates = OriginalState;
	}

}
