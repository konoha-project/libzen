package zen.lang.konoha;

import zen.lang.zen.ZenGrammar;
import zen.parser.ZNameSpace;

public class KonohaGrammar {
	public static void ImportGrammar(ZNameSpace NameSpace) {
		ZenGrammar.ImportGrammar(NameSpace);
		NameSpace.DefineStatement("continue", new ContinuePatternFunction());

	}
}
