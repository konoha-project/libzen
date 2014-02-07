package zen.ast;

import zen.deps.Field;
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
			this.AST = new ZNode[1];
			this.Set(0, Node);
		}
		else {
			@Var ZNode[] newAST = new ZNode[this.AST.length+1];
			System.arraycopy(this.AST, 0, newAST, 0, this.AST.length);
			this.AST = newAST;
			this.Set(this.AST.length - 1, Node);
		}
	}

	public final int GetListSize() {
		if(this.AST == null) {
			return 0;
		}
		return this.AST.length - this.ListStartIndex;
	}

	public final ZNode GetListAt(int Index) {
		return this.AST[this.ListStartIndex + Index];
	}

	public final void SetListAt(int Index, ZNode Node) {
		this.Set(Index + this.ListStartIndex, Node);
	}

	public final void ClearList(int Size) {
		if(Size < this.GetListSize()) {
			@Var int newsize = this.ListStartIndex + Size;
			if(newsize == 0) {
				this.AST = null;
			}
			else {
				@Var ZNode[] newAST = new ZNode[newsize];
				System.arraycopy(this.AST, 0, newAST, 0, newsize);
				this.AST = newAST;
			}
		}
	}

}
