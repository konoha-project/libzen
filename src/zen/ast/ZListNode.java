package zen.ast;

import zen.deps.Field;
import zen.deps.LibZen;
import zen.deps.Var;
import zen.parser.ZToken;

public class ZListNode extends ZNode {
	@Field public int ListStartIndex;
	public ZListNode(ZNode ParentNode, ZToken SourceToken, int Size) {
		super(ParentNode, SourceToken, Size);
		this.ListStartIndex = Size;
	}

	public final void Append(ZNode Node) {
		if(this.AST == null) {
			this.AST = LibZen._NewNodeArray(1);
			this.Set(0, Node);
		}
		else {
			@Var ZNode[] newAST = LibZen._NewNodeArray(this.AST.length+1);
			System.arraycopy(this.AST, 0, newAST, 0, this.AST.length);
			this.AST = newAST;
			this.Set(this.AST.length - 1, Node);
		}
	}

	public final int GetListSize() {
		return this.GetAstSize() - this.ListStartIndex;
	}

	public final ZNode GetListAt(int Index) {
		return this.AST[this.ListStartIndex + Index];
	}

	public final void SetListAt(int Index, ZNode Node) {
		this.Set(Index + this.ListStartIndex, Node);
	}

	public final void InsertListAt(int Index, ZNode Node) {
		if(this.AST == null || Index < 0 || this.AST.length == Index) {
			this.Append(Node);
		} else {
			@Var ZNode[] newAST = LibZen._NewNodeArray(this.AST.length + 1);
			Index = this.ListStartIndex + Index;
			System.arraycopy(this.AST, 0, newAST, 0, Index);
			this.Set(Index, Node);
			System.arraycopy(this.AST, Index, newAST, Index + 1, this.AST.length - Index);
			this.AST = newAST;
		}
	}

	public final ZNode RemoveListAt(int Index) {
		@Var ZNode Removed = this.GetListAt(Index);
		@Var ZNode[] newAST = new ZNode[this.AST.length - 1];
		int RemovedIndex = this.ListStartIndex + Index;
		System.arraycopy(this.AST, 0, newAST, 0, RemovedIndex);
		System.arraycopy(this.AST, RemovedIndex + 1, newAST, RemovedIndex, this.AST.length - (RemovedIndex + 1));
		this.AST = newAST;
		return Removed;
	}

	public final void ClearListAfter(int Size) {
		if(Size < this.GetListSize()) {
			@Var int newsize = this.ListStartIndex + Size;
			if(newsize == 0) {
				this.AST = null;
			}
			else {
				@Var ZNode[] newAST = LibZen._NewNodeArray(newsize);
				System.arraycopy(this.AST, 0, newAST, 0, newsize);
				this.AST = newAST;
			}
		}
	}

}
