package zen.codegen.jvm;

import java.util.ArrayList;
import java.util.Collections;

import zen.ast.ZBlockNode;
import zen.ast.ZClassDeclNode;
import zen.ast.ZFunctionNode;
import zen.ast.ZSymbolNode;
import zen.parser.ZTransformer;

class ClassNodeFilter extends ZTransformer {
	ArrayList<ZClassDeclNode> Decls;
	public ClassNodeFilter(ZBlockNode BlockNode) {
		super(BlockNode);
		this.Decls = new ArrayList<ZClassDeclNode>();
	}
	@Override
	public void VisitClassDeclNode(ZClassDeclNode Node) {
		this.Decls.add(Node);
		super.VisitClassDeclNode(Node);
	}
}

class FunctionNodeFilter extends ZTransformer {
	ArrayList<ZFunctionNode> Decls;
	int MethodId;
	public FunctionNodeFilter(ZBlockNode BlockNode) {
		super(BlockNode);
		this.Decls = new ArrayList<ZFunctionNode>();
		this.MethodId = 0;
	}
	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		String FuncName = "lambda" + this.MethodId++;
		ZFunctionNode FuncDeclNode = new ZFunctionNode(this.BlockNode.NameSpace);
		this.Decls.add(FuncDeclNode);
		this.InsertInBlockStatementBefore(this.GetBlockNode(), Node, FuncDeclNode);
		this.Transformed(new ZSymbolNode(FuncDeclNode.Type, Node.SourceToken, FuncName, FuncName));
	}

	//	public void VisitFuncDeclNode(ZFunctionNode Node) {
	//		this.Decls.add(Node);
	//		super.VisitFuncDeclNode(Node);
	//	}
}

class Edge {
	public final int src;
	public final int dst;
	public Edge(int src, int dst) {
		this.src = src;
		this.dst = dst;
	}
}

enum Color {
	NotVisited,
	Visiting,
	Visited
}

class Sorter {
	static private boolean visit(ArrayList<ArrayList<Edge>> g, int v, ArrayList<Integer> order, ArrayList<Color> color) {
		color.set(v, Color.Visiting);
		for (Edge e : g.get(v)) {
			if (color.get(e.dst) == Color.Visited) {
				continue;
			}
			if (color.get(e.dst) == Color.Visiting) {
				return false;
			}
			if (!visit(g, e.dst, order, color)) {
				return false;
			}
		}
		order.add(v);
		color.set(v, Color.Visited);
		return true;
	}

	public ArrayList<Integer> sort(ArrayList<ArrayList<Edge>> g) {
		int n = g.size();
		ArrayList<Color> color = new ArrayList<Color>();
		ArrayList<Integer> order = new ArrayList<Integer>();
		for (int i=0; i < n; i = i + 1) {
			color.add(Color.NotVisited);
		}
		for (int i=0; i < n; i = i + 1) {
			if (color.get(i) != Color.NotVisited && !visit(g, i, order, color)) {
				return null;
			}
		}
		Collections.reverse(order);
		return order;
	}
}

public class DeclarationExtractor extends ZTransformer {
	private final ClassNodeFilter ClassFilter;
	private final FunctionNodeFilter FunctionFilter;
	public DeclarationExtractor(ZBlockNode BlockNode) {
		super(BlockNode);
		this.ClassFilter = new ClassNodeFilter(BlockNode);
		this.FunctionFilter = new FunctionNodeFilter(BlockNode);
	}
	public ArrayList<ZClassDeclNode> GetClassDecls() {
		return this.ClassFilter.Decls;
	}
	public ArrayList<ZFunctionNode> GetFuncDecls() {
		return this.FunctionFilter.Decls;
	}
	@Override
	public void VisitClassDeclNode(ZClassDeclNode Node) {
		this.ClassFilter.VisitClassDeclNode(Node);
		super.VisitClassDeclNode(Node);
	}
	@Override
	public void VisitFunctionNode(ZFunctionNode Node) {
		this.FunctionFilter.VisitFunctionNode(Node);
		super.VisitFunctionNode(Node);
	}
	//	@Override
	//	public void VisitFuncDeclNode(ZFunctionNode Node) {
	//		this.FunctionFilter.VisitFuncDeclNode(Node);
	//		super.VisitFuncDeclNode(Node);
	//	}
}