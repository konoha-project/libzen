package zen.ssa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import zen.ast.ZBlockNode;
import zen.ast.ZGetNameNode;
import zen.ast.ZNode;
import zen.ast.ZNullNode;
import zen.ast.ZSetNameNode;
import zen.ast.ZVarNode;

public class SSAConveter extends ZASTTransformer {
	static final boolean	DEBUG_DOMTREE	= !false;

	public boolean Apply(ZBlockNode Block) {
		ControlFlowGraph cfg = new ControlFlowGraph(Block);
		cfg.ComputeDominanceFrontier();
		cfg.EntryBlock.InsertPHI();

		Iterator<BlockNode> Itr = cfg.BlockNodes.iterator();
		while(Itr.hasNext()) {
			BlockNode node = Itr.next();
			if(node.phis.size() != 0) {
				// FIXME
				//				ArrayList<ZNode> list = node.block.StmtList;
				//				ArrayList<PHINode> phis = node.phis;
				//				// phis=[phi1, phi2, phi3], list=[expr1, expr2]
				//				// => list[phi1, phi2, phi3, expr1, expr2]
				//				int Index = 0;
				//				Iterator<PHINode> Itr1 = phis.iterator();
				//				while(Itr1.hasNext()) {
				//					list.add(Index, Itr1.next());
				//				}
			}
		}
		cfg.EntryBlock.InsertUndefinedVariables();
		cfg.RenamingVariables();
		return true;
	}
}

class BlockNode {
	ZBlockNode			block;
	int					preorderId;	/* Depth First Number, Preorder */
	int					rpostoderId;	/* Depth First Number, Reverse Postorder */
	ArrayList<BlockNode>	preds;			/* List of predecessor nodes */
	ArrayList<BlockNode>	succs;			/* List of successor nodes */
	ArrayList<BlockNode>	children;		/* Subnodes in the Dominator Tree */
	HashSet<BlockNode>		dfront;		/* Dominance Frontier */
	BlockNode			idom;			/* Immediate Dominator */
	BitMap			domset;		/* Dominator Set Bit Vector */
	ArrayList<PHINode>		phis;
	ControlFlowGraph cfg;

	public BlockNode(ZBlockNode block, ControlFlowGraph cfg) {
		this.idom = null;
		this.block = block;
		this.preds = new ArrayList<BlockNode>();
		this.succs = new ArrayList<BlockNode>();
		this.phis = new ArrayList<PHINode>();
		this.cfg  = cfg;
	}

	void addedge(BlockNode ToNode) {
		this.succs.add(ToNode);
		ToNode.preds.add(this);
	}

	/* Compute Depth First Spanning Tree */
	int dfst(int preorderId, int rpostoderId) {
		int n = 1;
		this.preorderId = preorderId;

		Iterator<BlockNode> Itr = this.succs.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			if(x.preorderId == 0) {
				n += x.dfst(preorderId + n, rpostoderId - n + 1);
			}
		}
		this.rpostoderId = rpostoderId - n + 1;
		return n;
	}

	/* Print Dominator Tree */
	void printdomtree(int level) {
		if(SSAConveter.DEBUG_DOMTREE) {
			for(int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.print(this.block + " (");
			Iterator<BlockNode> Itr = this.dfront.iterator();
			while(Itr.hasNext()) {
				BlockNode x = Itr.next();
				System.out.print(x.block + " ");
			}
			System.out.println(")");

			Itr = this.children.iterator();
			while(Itr.hasNext()) {
				BlockNode x = Itr.next();
				x.printdomtree(level + 1);
			}
		}
	}

	/* Compute Dominance Frontier */
	void domfront() {
		Iterator<BlockNode> Itr = this.children.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			x.domfront();
		}
		this.dfront = new HashSet<BlockNode>();

		Itr = this.succs.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			if((x).idom != this) {
				this.dfront.add(x);
			}
		}
		Itr = this.children.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			Iterator<BlockNode> Itr2 = x.dfront.iterator();
			while(Itr2.hasNext()) {
				BlockNode y = Itr2.next();
				if(y.idom != this) {
					this.dfront.add(y);
				}
			}
		}
	}

	void addPHI(ZNode Node) {
		for(Iterator<PHINode> Itr = this.phis.iterator(); Itr.hasNext();) {
			PHINode phi = Itr.next();
			for(Iterator<ZNode> Itr2 = phi.Args.iterator(); Itr2.hasNext();) {
				ZNode Inst = Itr2.next();
				if(Inst == Node) {
					return;
				}
			}
		}

		PHINode phi = new PHINode(Node);
		phi.AddIncoming(this.block, Node);
		this.phis.add(phi);
	}

	void InsertPHI() {
		for(Iterator<ZVarNode> Itr = this.cfg.LocalVars.iterator(); Itr.hasNext();) {
			ZVarNode Inst = Itr.next();
			Iterator<BlockNode> BlockItr = this.dfront.iterator();
			while(BlockItr.hasNext()) {
				BlockNode x = BlockItr.next();
				x.addPHI(Inst);
			}
		}

		for(Iterator<BlockNode> BlockItr = this.children.iterator(); BlockItr.hasNext();) {
			BlockItr.next().InsertPHI();
		}
	}

	void InsertUndefinedVariables() {
		int size = this.cfg.LocalVars.size();
		/* create undefined local variables at entryblock */
		HashMap<String, Integer> local = new HashMap<String, Integer>();
		int i = 0;
		for(i = 0; i < size; i++) {
			local.put(this.cfg.LocalVars.get(i).GetName(), -1);
		}

		while(i < this.block.GetListSize()) {
			ZNode x = this.block.GetListAt(i);
			if(x instanceof ZSetNameNode) {
				ZSetNameNode Inst = (ZSetNameNode) x;
				local.put(Inst.GetName(), Inst.VarIndex);
			}
			i = i + 1;
		}

		ZBlockNode EntryBB = this.block;

		int change = 0;
		int TailIndex = EntryBB.GetListSize();
		for(i = 0; i < size; i++) {
			if(local.get(this.cfg.LocalVars.get(i).GetName()) == -1) {
				ZNode LHS = this.cfg.LocalVars.get(i);
				ZNode RHS = new ZNullNode(null, null);
				RHS.Type = LHS.Type;
				System.err.println("FIXME(000) support undefined local variables"); // FIXME
				//builder.CreateUpdate(LHS, RHS);
				change += 1;
			}
		}
		if(change > 0) {
			int CurrentSize = EntryBB.GetListSize();
			ZNode Terminator = EntryBB.GetListAt(TailIndex - 1);
			for(i = 0; i < CurrentSize - TailIndex; i++) {
				EntryBB.SetListAt(TailIndex - 1 + i, EntryBB.GetListAt(TailIndex + i));
			}
			EntryBB.SetListAt(CurrentSize - 1, Terminator);
		}
	}
}


class ControlFlowGraph { // ControlFlowGraph
	ArrayList<BlockNode>	BlockNodes;
	BlockNode			EntryBlock;
	public final ArrayList<ZVarNode> LocalVars;

	public ControlFlowGraph(ZBlockNode TopLevelBlock) {
		this.BlockNodes = new ArrayList<BlockNode>(TopLevelBlock.GetListSize());
		this.LocalVars = new ArrayList<ZVarNode>();
		for (int i = 0; i < TopLevelBlock.GetListSize(); i++) {
			ZNode x = TopLevelBlock.GetListAt(i);
			this.CreateBlockNode(x);
		}

		Iterator<BlockNode> Itr2 = this.BlockNodes.iterator();
		while(Itr2.hasNext()) {
			BlockNode node = Itr2.next();
			Iterator<BlockNode> Itr3 = node.succs.iterator();
			while(Itr3.hasNext()) {
				BlockNode x = Itr3.next();
				node.addedge(x);
			}
		}
		this.EntryBlock = this.BlockNodes.get(0);
	}
	BlockNode CreateBlockNode(ZNode block) {
		if(block instanceof ZBlockNode) {
		}
		else {
			ZBlockNode NewBlock = new ZBlockNode(null, block.GetNameSpace());
			NewBlock.Append(block);
			block = NewBlock;
		}
		BlockNode p = new BlockNode((ZBlockNode)block, this);
		this.BlockNodes.add(p);
		return p;
	}

	/* Compute Dominators by Aho-Ullman's bit vector algorithm */
	void ComputeDominator() {
		int BlockNodeSize = this.BlockNodes.size();
		int w = (BlockNodeSize + BitMap.BITS - 1) / BitMap.BITS;
		BitMap work = new BitMap(w);

		BlockNode[] nodes = new BlockNode[BlockNodeSize + 1];
		Iterator<BlockNode> Itr = this.BlockNodes.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			x.preorderId = 0;
			x.domset = new BitMap(w);
			x.domset.clear(~0);
		}

		this.EntryBlock.domset.clear(0);
		this.EntryBlock.dfst(1, BlockNodeSize);
		this.EntryBlock.domset.add(1);

		nodes[0] = null;
		Itr = this.BlockNodes.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			nodes[x.rpostoderId] = x;
			// System.out.println(x.block.GetName() + ":" + x.preorderId + "," +
			// x.rpostoderId);
		}

		boolean change;
		do {
			change = false;
			for(int i = 2; i <= BlockNodeSize; i++) {
				work.clear(~0);
				Iterator<BlockNode> Itr2 = nodes[i].preds.iterator();
				while(Itr2.hasNext()) {
					BlockNode x = Itr2.next();
					for(int j = 0; j < w; ++j) {
						work.SetAll(j, work.GetAll(j) & x.domset.GetAll(j));
					}
				}
				work.add(i);
				for(int j = 0; j < w; ++j) {
					if(work.get(j) != nodes[i].domset.get(j)) {
						nodes[i].domset.SetAll(j, work.GetAll(j));
						change = true;
					}
				}

			}
		} while(change);

		/* Convert dominator sets to dominator tree */
		this.EntryBlock.idom = null;
		Itr = this.BlockNodes.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			x.domset.Remove(x.rpostoderId);
			for(int i = w - 1; i >= 0; --i) {
				if(x.domset.get(i) != 0) {
					int bit = BitMap.highestbit(x.domset.get(i));
					System.out.println(x.block + ":" + i + "," + bit);
					x.idom = nodes[(i * BitMap.BITS) + bit];
					break;
				}
			}
			x.domset = null;
		}
	}

	/* Set up Subnode Pointers in the Dominator Tree */
	void setup_domtree() {
		Iterator<BlockNode> Itr = this.BlockNodes.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			x.children = new ArrayList<BlockNode>();
		}
		Itr = this.BlockNodes.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			if(x.idom != null) {
				x.idom.children.add(x);
			}
		}
	}

	BlockNode GetBlockNode(ZNode block) {
		Iterator<BlockNode> Itr = this.BlockNodes.iterator();
		while(Itr.hasNext()) {
			BlockNode x = Itr.next();
			if(x.block == block) {
				return x;
			}
		}
		assert (false); // unreachable;
		return null;
	}

	void ComputeDominanceFrontier() {
		this.ComputeDominator();
		/* Compute Dominance Frontier */
		this.setup_domtree();
		this.EntryBlock.domfront();
		/* Print Dominace Frontiers */
		this.EntryBlock.printdomtree(0);
	}

	void RenamingVariables() {
		int i = 0, size = this.LocalVars.size();
		HashMap<String, Stack<ZNode>> stack = new HashMap<String, Stack<ZNode>>();
		for(i = 0; i < size; i++) {
			stack.put(this.LocalVars.get(i).GetName(), new Stack<ZNode>());
		}
		this.Rename(this.EntryBlock, stack);
	}

	private void NewName(ZNode NewVal, ZNode Node, HashMap<String, Stack<ZNode>> stack) {
		String n = null;
		if(Node instanceof ZGetNameNode) {
			n = ((ZGetNameNode)Node).GetName();
		}
		else {
			assert(Node instanceof ZVarNode);
			n = ((ZVarNode)Node).GetName();
		}
		stack.get(n).push(NewVal);
	}

	private ZNode TopStack(ZNode Node, HashMap<String, Stack<ZNode>> stack) {
		if(Node instanceof ZGetNameNode) {
			String n = ((ZGetNameNode)Node).GetName();
			return stack.get(n).peek();
		}
		else {
			assert(Node instanceof ZVarNode);
			String n = ((ZVarNode)Node).GetName();
			return stack.get(n).peek();
		}
	}

	private ZNode PopStack(ZNode Node, HashMap<String, Stack<ZNode>> stack) {
		if(Node instanceof ZGetNameNode) {
			String n = ((ZGetNameNode)Node).GetName();
			return stack.get(n).peek();
		}
		else {
			assert(Node instanceof ZSetNameNode);
			String n = ((ZVarNode)Node).GetName();
			return stack.get(n).peek();
		}
	}

	private void FillIncoming(ZBlockNode BB, PHINode phi, HashMap<String, Stack<ZNode>> stack) {
		int Index = 0;
		Iterator<ZNode> VarItr = phi.Args.iterator();
		Iterator<ZBlockNode> BlockItr = phi.Blocks.iterator();
		while(VarItr.hasNext()) {
			ZNode Inst = VarItr.next();
			ZBlockNode Block = BlockItr.next();
			if(Block == BB) {
				ZNode Value = this.TopStack(Inst, stack);
				phi.Args.set(Index, Value);
			}
			Index++;
		}
	}

	<T> void RewriteList(ArrayList<T> List, HashMap<String, Stack<ZNode>> stack) {
		for(int i = 0; i < List.size(); i++) {
			List.set(i, this.RewriteInst(List.get(i), stack));
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T RewriteInst(T Inst, HashMap<String, Stack<ZNode>> stack) {
		if(Inst instanceof ZVarNode) {
			ZNode Node = this.TopStack((ZVarNode) Inst, stack);
			if(Node == null) {
				throw new RuntimeException("Error");
			}
			return (T) Node;
		}
		return Inst;
	}

	void Rename(BlockNode b, HashMap<String, Stack<ZNode>> stack) {
		for (int i = 0; i < b.block.GetListSize(); i++) {
			ZNode Inst = b.block.GetListAt(i);
			if(Inst instanceof PHINode) {
				PHINode PHI = (PHINode) Inst;
				this.NewName(PHI, PHI.Value, stack);
			}
		}
		for (int i = 0; i < b.block.GetListSize(); i++) {
			ZNode Inst = b.block.GetListAt(i);
			this.RewriteInst(Inst, stack);
		}

		Iterator<BlockNode> Itr2 = b.succs.iterator();
		while(Itr2.hasNext()) {
			for (int i = 0; i < Itr2.next().block.GetListSize(); i++) {
				ZNode Inst = Itr2.next().block.GetListAt(i);
				if(Inst instanceof PHINode) {
					PHINode PHI = (PHINode) Inst;
					this.FillIncoming(b.block, PHI, stack);
				}
			}
		}

		/* Rename each successor s of b in the dominator tree */
		Itr2 = b.children.iterator();
		while(Itr2.hasNext()) {
			this.Rename(Itr2.next(), stack);
		}

		/* clear stack */
		for (int i = 0; i < b.block.GetListSize(); i++) {
			ZNode Inst = b.block.GetListAt(i);
			if(Inst instanceof PHINode) {
				PHINode phi = (PHINode) Inst;
				this.PopStack(phi.Value, stack);
			}
			if(Inst instanceof ZSetNameNode) {
				ZSetNameNode update = (ZSetNameNode) Inst;
				this.PopStack(update, stack);
			}
		}
	}

}