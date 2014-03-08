package zen.lang.zen;

public abstract class ZenPrecedence {
	public final static int _BinaryOperator					= 1;
	public final static int _LeftJoin						= 1 << 1;
	public final static int _PrecedenceShift					= 3;
	public final static int _CStyleMUL			    = (100 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleADD			    = (200 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleSHIFT			= (300 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleCOMPARE		    = (400 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _Instanceof            = ZenPrecedence._CStyleCOMPARE;
	public final static int _CStyleEquals			= (500 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleBITAND			= (600 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleBITXOR			= (700 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleBITOR			= (800 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleAND			    = (900 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleOR				= (1000 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleTRINARY		    = (1100 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;				/* ? : */
	public final static int _CStyleAssign			= (1200 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;
	public final static int _CStyleCOMMA			= (1300 << ZenPrecedence._PrecedenceShift) | ZenPrecedence._BinaryOperator;

}
