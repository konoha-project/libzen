import re
import sys

IgnoreLinePattern = re.compile('\s*\/\/')
ClassPattern = re.compile('.*class\s+(\w*)')
ExtendsPattern = re.compile('.*\sextends\s+(\w*)')

def MatchSymbol(p, text):
	m = p.match(text)
	if m: 
		return m.group(1)
	return None	

def RemoveQ(s):
	s = s.replace('public ', '')
	s = s.replace('protected ', '')
	s = s.replace('private ', '')
	s = s.replace('final ', '')
	s = s.replace('abstract ', '')
	s = s.replace('@Deprecated ', '')
	s = s.replace('@ZenMethod ', '')
	s = s.replace('@ZenIgnored ', '')
	return s

ArrayPattern = re.compile('ZArray\<(.*)\>')

def GenType(s):
	s = s.replace("ZMap", "Map")
	s = s.replace("char", "String")
	s = s.replace("long", "int")
	s = s.replace("double", "float")
	s = s.replace("ZMatchFunction", "Func<ZNode,ZTokenContext,ZNode,ZNode>")
	s = s.replace("ZTokenFunction", "Func<ZSourceContext,boolean>")
	m = ArrayPattern.match(s)
	if m:
		s = m.group(1) + "[]"
	return s

def GenAnno(s):
	return ": " + GenType(s)

FieldPattern = re.compile('\@Field\s+(\S*)\s+(\w*)(.*)')

def GenField(s):
	s = RemoveQ(s)
	s = s.replace('@Init ', '')
	m = FieldPattern.match(s)
	if m:
		return '\tvar ' + m.group(2) + GenAnno(m.group(1)) + m.group(3) + '\n'
	return '\t//'+s;

SymbolPattern = re.compile('(\S*)\s+(\w*)\s+\=\s+(.*)')

def GenLetDecl(cname, line):
	line = RemoveQ(line)
	line = line.replace('static ', '')
	m = SymbolPattern.match(line)
	if m:
		sym = m.group(2)
		if sym.startswith("_") or cname == "ZType" :
			return 'let ' + cname + sym +  ': ' + GenType(m.group(1)) + ' = ' + m.group(3) + '\n'
		else:
			return 'let ' + sym + ': ' + GenType(m.group(1)) + ' = ' + m.group(3) + '\n'
	return '//let ' + cname + '.' + line

def GenStaticFunc(cname, line, IsProto=False):
	line = RemoveQ(line)
	line = line.replace('static ', '')
	start = line.find('(')
	end = line.find(')')
	params = ParseParam(line[start+1:end], False, cname)
	t = line[:start].split()
	block = GenParam(params) + ": " + GenType(t[0])
	if IsProto:
		block = block + ";\n"
	else:
		block = block + line[end+1:]
	if t[1].startswith("_"):
		return "function " + cname + t[1] + block
	else:
		return "function " + t[1]  + block

VarPattern = re.compile('(.*)\@Var\s+(\S*)\s+(\w*)(.*)')
NewArrayPattern = re.compile('(.*)new ZArray\<\S*\>\(.*\)(.*)')
NewMapPattern = re.compile('(.*)new ZMap\<\S*\>\(.*\)(.*)')
MapPattern1 = re.compile('(.*)\.GetOrNull\((.*)\);')
MapPattern2 = re.compile('(.*)\.put\((.*)\,(.*)\);')
FuncPattern = re.compile('(.*)new (\w+)Function\(\)(.*)');

def GenVar(line):
	line = line.replace("'", '"')
	line = line.replace("._", "_")
	line = line.replace(".ArrayValues[", "[")
	line = line.replace("ZType.", "ZType")
	line = line.replace(".length()", ".size()")
	line = line.replace(".length", ".size()")
	line = line.replace("String.valueOf", '""+')
	line = line.replace(".CompactArray()", "")
	m = VarPattern.match(line)
	if m:
		line = m.group(1) + 'var ' + m.group(3) + GenAnno(m.group(2)) + m.group(4) + '\n'
	m = NewArrayPattern.match(line)
	if m:
		line = m.group(1) + "[]" + m.group(2) + "\n";
	m = NewMapPattern.match(line)
        if m:
                line = m.group(1) + "[]" + m.group(2) + "\n";
	m = MapPattern1.match(line)
	if m:
                line = m.group(1) + "[" + m.group(2) + "];\n";
	m = MapPattern2.match(line)
	if m :
		line = m.group(1) + "[" + m.group(2) + "] = " + m.group(3) + ";\n";
	m = FuncPattern.match(line)
	if m :
		line = m.group(1) + m.group(2) + m.group(3) + "\n"
	return line;

def ParseParam(s, IsMethod, cname):
	param = []
	if IsMethod: 
		param.append((cname, 'this'))
	s = s.replace('@Nullable ', '')
	for p in s.split(', '):
		t = p.split()
		if len(t) > 1:
			param.append(t)
	return param

def GenParam(param):
	s = '('
	c = 0
	for p in param:
		if c > 0:
			s = s + ', '
		s = s + p[1] + ': ' + GenType(p[0])
		c = c + 1
	return s + ')'

def GenFunc(cname, line, IsProto):
	line = RemoveQ(line)
	start = line.find('(')
	end = line.find(')')
	params = ParseParam(line[start+1:end], True, cname)
	block = line[:start].replace('@Override ', '')
	findex = block.find(' ')
	if findex > 0:
		ReturnType = block[:findex]
		funcname = block[findex+1:]
	else:
		ReturnType = cname
		funcname = block
	if funcname == "Invoke" :
		funcname = params[0][0][0:-8]
		params = params[1:]
		if IsProto:
			s = ""
		else:
			s = "let " + funcname + " = function" + GenParam(params) + ": " + GenType(ReturnType) + line[end+1:] + "\n"
		return s
	sig = funcname + GenParam(params) + ": " + GenType(ReturnType)
	if IsProto:
		return "function " + sig + ";\n"
	return "function " + sig + line[end+1:] + "\n"
	

def ParseFuncType(s, rtype, cname):
        param = [rtype, cname]
        s = s.replace('@Nullable ', '')
        for p in s.split(', '):
                t = p.split()
                if len(t) > 1:
                        param.append(t[0])
        s = 'Func<'
        c = 0
        for p in param[1:]:
                if c > 0:
                        s = s + ','
                s = s + GenType(p)
                c = c + 1
	if len(param) == 1:
		s = s + 'void'
	s = s + "," + param[0]
        return s + '>'

def GenMethod(cname, line):
	line = RemoveQ(line)
	start = line.find('(')
	end = line.find(')')
	block = line[:start].replace('@Override ', '')
	t = block.split()
	if len(t)>1:
		params = ParseFuncType(line[start+1:end], t[0], cname)
		return "\tvar " + t[1] + ": " + params + ";\n"
	return "\n"

def rewriteSuper(line, superclass):
	if superclass :
		if line.find('super()') > 0:
			line.replace('super()', superclass+'(this)')
			return line
		if line.find('super(') > 0:
			line = line.replace('super(', superclass + '(this, ')
	return line

class ClassBlock:
	def __init__(self, cname, sname, line):
		self.ClassName = cname
		self.SuperName = sname
		self.line = line
		self.IsFinal = line.find('final') != -1
		self.prev = ""
		self.lines = []

	def read(self, line):
		if line.startswith("}"):
			if len(self.prev)>0 :
				self.lines.append(self.prev)
			return None
		if line.startswith('\t'):
			line = GenVar(line[1:])
			if line.startswith('}'):
				self.lines.append(self.prev + line)
				self.prev = "";
				return self
			if line.startswith('\t') :
				self.prev = self.prev + line
			else:
				if len(self.prev) > 0:
					self.lines.append(self.prev)
				self.prev = line
		else:
			if len(line) > 1:
				print "#bugs '", line, "'", 
		return self

	def writefield(self, f):
		if self.SuperName and self.SuperName.find('Function') > 0: 
			return
		f.write('class ' + self.ClassName)
		if self.SuperName:
			f.write(' extends ' + self.SuperName)
		f.write(' {\n')
		for line in self.lines:
			if line.find('@Field') != -1:
				f.write(GenField(line))
				continue
			if self.IsFinal or line.find('static') != -1 or line.find('@Override') != -1 or line.find('final') != -1: 
				continue
			if line.find('abstract') != -1 or line.find('@ZenMethod') >= 0 :
				f.write(GenMethod(self.ClassName, line))
			
		f.write('}\n')

	def writeproto(self, f):
		for line in self.lines:
			if line.find('@Field') >= 0:
				continue
			if line.find('@ZenIgnored') >= 0:
				continue
			if line.find('{') >=0 :
				if line.find('static ') >= 0 and line.find('@Override') == -1:
					f.write(GenStaticFunc(self.ClassName, line, True))
				else:
					s = GenFunc(self.ClassName, line, True)
					f.write(s)
	
	def writesymbol(self, f):
		for line in self.lines:
			if line.find(' static') >= 0 :
				if line.find('{') == -1 :
					f.write(GenLetDecl(self.ClassName, line))
				#else:
				#f.write(GenStaticFunc(self.ClassName, line))
	
	def writefunc(self, f, IsProto):
		if not IsProto:
			for line in self.lines:
				if line.find(' static') >= 0 and line.find('{') != -1 :
					f.write(GenStaticFunc(self.ClassName, line))
		for line in self.lines:
			if line.find('@Field') >= 0 or line.find('static') >0 or line.find('@ZenIgnored') >= 0 :
				continue
			if line.find('{') != -1:
				line = rewriteSuper(line, self.SuperName)
				f.write(GenFunc(self.ClassName, line, IsProto))


class Context:
	def __init__(self):
		self.CurrentClass = None
		self.ClassList = []
		self.ClassMap = {}

	def read(self, line):
		if IgnoreLinePattern.match(line): return
		if self.CurrentClass != None:
			self.CurrentClass = self.CurrentClass.read(line)
			return
		cname = MatchSymbol(ClassPattern, line)
		if cname: 
			print "find .. ", cname
			self.CurrentClass = ClassBlock(cname, MatchSymbol(ExtendsPattern, line), line)
			self.ClassList.append(self.CurrentClass)
			self.ClassMap[cname] = self.CurrentClass
		#print line

	def write(self, filename):
		f = open(filename, 'w')
		writeLIBZEN(f)
		for c in self.ClassList:
			c.writeproto(f)
		for c in self.ClassList:
			c.writefield(f)
			c.writesymbol(f)
		for c in self.ClassList:
			#c.writesymbol(f)
			pass
		for c in self.ClassList:
			c.writefunc(f, False)
		f.close()

ReadFiles = {}

def readfile(file, c):
	global ReadFiles;
	if ReadFiles.has_key(file):
		return
	ReadFiles[file] = file
	f = open(file, 'r')
	line = f.readline()
	while line:
		c.read(line)
		line = f.readline()
	f.close()
	

def ClassSort(list, m):
	if len(list) == 0: return []
	s = []
	e = []
	for c in list:
		if c.SuperName:
			if not m.has_key(c.SuperName):
				e.append(c)
				continue
		m[c.ClassName] = c
		s.append(c)
	if len(s) > 0:
		return s + ClassSort(e, m)
	else:
		return list

def writeLIBZEN(f):
	LIBZEN='''
function LibZen_Print(msg: String): void;
function LibZen_PrintLine(msg: String): void;
function LibZen_FixMe(e): void;
function LibZen_PrintDebug(msg: String): void;
function LibZen_Assert(TestResult: boolean): void;
function LibZen_Exit(status: int, Message: String): void;
function LibZen_GetPlatform(): String;
function LibZen_GetEnv(Name: String): String;
function LibZen_IsFlag(flag: int, flag2: int): boolean;
function LibZen_UnsetFlag(flag: int, flag2: int): int;
function LibZen_GetTokenMatrixIndex(c: String): int;
function LibZen_NewTokenMatrix(): ZTokenFunc[];
function LibZen_GetChar(Text: String, Pos: int): String;
function LibZen_IsLetter(ch: String): boolean;
function LibZen_IsDigit(ch: String): boolean;
function LibZen_IsSymbol(ch: String): boolean;
function LibZen_JoinStrings(Unit: String, Times: int): String;
function LibZen_UnquoteString(Text: String): String;
function LibZen_QuoteString(Text: String): String;
function LibZen_ParseInt(Text: String): int;
function LibZen_ParseFloat(Text: String): float;
function LibZen_Stringify(Value: any): String;
function LibZen_AnotherName(s: String): String;
function LibZen_Stringfy(number: int): String;
function LibZen_SourceBuilderToString(Builder: ZSourceBuilder): String;
function LibZen_SourceBuilderToString(Builder: ZSourceBuilder, BeginIndex: int, EndIndex: int): String;
function LibZen_LoadTextFile(FileName: String): String;
function LibZen_WriteTo(FileName: String, List: ZSourceBuilder[]): void;
function LibZen_Size(o) : int;

function LibZen_ImportGrammar(NameSpace: ZNameSpace, ClassName: String): boolean;
//function LoadTokenFunc(GrammarClass: Class<?>, FuncName: String): ZFunc;
//function LoadMatchFunc(GrammarClass: Class<?>, FuncName: String): ZFunc;
function LibZen_ApplyTokenFunc(TokenFunc, SourceContext: ZSourceContext): boolean;
function LibZen_ApplyMatchFunc(MatchFunc, ParentNode: ZNode, TokenContext: ZTokenContext, LeftNode: ZNode): ZNode;
function LibZen_LoadGenerator(ClassName: String, OutputFile: String): ZGenerator;
function LibZen_LoadEngine(ClassName: String, GrammarClass: String): ZSourceEngine;
//function GetNativeType(NativeClass: Class<?>): ZType;
//function ConvertToNativeFunc(jMethod: Method): JavaStaticFunc;

function LibZen_GetClassName(Value): String;

//function GetClassOfValue(Value: any): Class<?>;

function LibZen_NewTypeArray(Size: int): ZType[];
function LibZen_NewNodeArray(Size: int): ZNode[];
function LibZen_ArrayCopy(src, sindex: int, dst, dindex: int, len: int): void;

let LibZen_GreekNames = ["a", "b", "c"];
'''
	#f.write(LIBZEN)

OUTFILE = 'libzen/libzen.zen'

def main(files) :
	c = Context()
	for file in files[1:]:
		if file.endswith(".zen"):
			OUTFILE = file
			continue
		readfile(file, c)
	c.ClassList = ClassSort(c.ClassList, {})
	c.write(OUTFILE)


main(sys.argv)
