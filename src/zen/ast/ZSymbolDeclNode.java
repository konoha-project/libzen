package zen.ast;

import zen.deps.Field;
import zen.lang.ZType;
import zen.parser.ZNameSpace;

public class ZSymbolDeclNode {
	@Field public ZNameSpace NameSpace;
	@Field public ZType  ClassType = null;
	@Field public String GivenSymbol = null;
	@Field public ZNode  ValueNode = null;
	public ZSymbolDeclNode(ZNameSpace NameSpace) {
		super();
		this.NameSpace = NameSpace.GetRootNameSpace();
	}

	//	@Override public void Append(ZNode Node) {
	//		if(Node instanceof ZFieldNode) {
	//			this.FieldList.add((ZFieldNode)this.SetChild(Node));
	//		}
	//		else if(Node instanceof ZTypeNode) {
	//			this.SuperType = Node.Type;
	//		}
	//		else if(this.ClassName == null) {
	//			this.ClassName = Node.SourceToken.ParsedText;
	//			this.SourceToken = Node.SourceToken;
	//			this.ClassType = this.NameSpace.GetType(this.ClassName, this.SourceToken);
	//		}
	//	}
	//	@Override public void Accept(ZVisitor Visitor) {
	//		Visitor.VisitClassDeclNode(this);
	//	}

	//	public ZNode CheckClassName(ZNameSpace NameSpace) {
	//		if(this.ClassType == null || !(this.ClassType instanceof ZenClassType)) {
	//			return new ZErrorNode(this.SourceToken, "" + this.ClassName + " is not a Zen class.");
	//		}
	//		if(!this.ClassType.IsOpenType()) {
	//			return new ZErrorNode(this.SourceToken, "" + this.ClassName + " has been defined.");
	//		}
	//		if(this.SuperType != null) {
	//			if(!(this.SuperType instanceof ZenClassType)) {
	//				return new ZErrorNode(this.SourceToken, "" + this.SuperType + " cannot be extended.");
	//			}
	//			if(this.SuperType.IsOpenType()) {
	//				NameSpace.Generator.Logger.ReportWarning(this.SourceToken, "" + this.SuperType + " is not defined with class.");
	//				//				return new ZenErrorNode(this.SourceToken, "" + this.SuperType + " is not defined with class.");
	//			}
	//			((ZenClassType)this.ClassType).ResetSuperType((ZenClassType)this.SuperType);
	//		}
	//		return null;
	//	}

}
