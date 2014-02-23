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
	s = s.replace("Object", "any")
	s = s.replace("ZenMap", "Map")
	s = s.replace("char", "String")
	s = s.replace("long", "int")
	s = s.replace("double", "float")
	m = ArrayPattern.match(s)
	if m:
		s = m.group(1) + "[]"
	return s

FieldPattern = re.compile('\@Field\s+(\S*)\s+(\w*)(.*)')

def GenField(s):
	s = RemoveQ(s)
	s = s.replace('@Init ', '')
	m = FieldPattern.match(s)
	if m:
		return '\tvar ' + m.group(2) + ': ' + GenType(m.group(1)) + m.group(3) + '\n'
	return '\t//'+s;

SymbolPattern = re.compile('(\S*)\s+(\w*)\s+\=\s+(.*)')

def GenLetDecl(cname, line):
	line = RemoveQ(line)
	line = line.replace('static ', '')
	m = SymbolPattern.match(line)
	if m:
		sym = m.group(2)
		if sym.startswith("_") or cname == "ZType" :
			return 'let ' + cname + sym + ' = ' + m.group(3) + '\n'
		else:
			return 'let ' + sym + ' = ' + m.group(3) + '\n'
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
NewMapPattern = re.compile('(.*)new ZenMap\<\S*\>\(.*\)(.*)')

def GenVar(line):
	line = line.replace("'", '"')
	line = line.replace("._", "_")
	line = line.replace(".ArrayValues[", "[")
	line = line.replace("ZType.", "ZType")
	m = VarPattern.match(line)
	if m:
		line = m.group(1) + 'var ' + m.group(3) + ": " + GenType(m.group(2)) + m.group(4) + '\n'
	m = NewArrayPattern.match(line)
	if m:
		line = m.group(1) + "[]" + m.group(2) + "\n";
	m = NewMapPattern.match(line)
        if m:
                line = m.group(1) + "[]" + m.group(2) + "\n";
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
	block = line[:start].replace('@Override ', '').replace('@Constructor ', '')
	findex = block.find(' ')
	if findex > 0:
		ReturnType = block[:findex]
		block = block[findex+1:]
	else:
		ReturnType = cname
		block = block
	block = block + GenParam(params) + ": " + GenType(ReturnType)
	if IsProto:
		block = block + ";"
	else:
		block = block + line[end+1:]
	return "function " + block + "\n"

def ParseFuncType(s, rtype, cname):
        param = [rtype, cname]
        s = s.replace('@Nullable ', '')
        for p in s.split(', '):
                t = p.split()
                if len(t) > 1:
                        param.append(t[0])
        s = 'Func<'
        c = 0
        for p in param:
                if c > 0:
                        s = s + ','
                s = s + GenType(p)
                c = c + 1
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
		f.write('class ' + self.ClassName)
		if self.SuperName:
			f.write(' extends ' + self.SuperName)
		f.write(' {\n')
		for line in self.lines:
			if line.find('@Field') != -1:
				f.write(GenField(line))
				continue
			if line.find('@ZenIgnored') >= 0:
				continue
			if self.IsFinal or line.find('static') != -1 or line.find('@Override') != -1 or line.find('final') != -1: 
				continue
			if line.find('abstract') != -1 or line.find('@ZenMethod') > 0 :
				f.write(GenMethod(self.ClassName, line))
			
		f.write('}\n')

	def writeproto(self, f):
		for line in self.lines:
			if line.find('@Field') >= 0:
				continue
			if line.find('@ZenIgnored') >= 0:
				continue
			if line.find('{') >=0 :
				if line.find('static') >= 0:
					f.write(GenStaticFunc(self.ClassName, line, True))
				else:
					f.write(GenFunc(self.ClassName, line, True))
	
	def writesymbol(self, f):
		for line in self.lines:
			if line.find('static') >= 0:
				if line.find('{') == -1 :
					f.write(GenLetDecl(self.ClassName, line))
				else:
					f.write(GenStaticFunc(self.ClassName, line))
	def writefunc(self, f, IsProto):
		for line in self.lines:
			if line.find('@Field') >= 0 or line.find('static') >0 or line.find('@ZenIgnored') >= 0 :
				continue
			if line.find('{') != -1:
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
		for c in self.ClassList:
			c.writefield(f)
		for c in self.ClassList:
			c.writeproto(f)
		for c in self.ClassList:
			c.writesymbol(f)
		for c in self.ClassList:
			c.writefunc(f, False)
		f.close()

def readfile(file, c):
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

def main(files) :
	c = Context()
	for file in files[1:]:
		readfile(file, c)
	c.ClassList = ClassSort(c.ClassList, {})
	c.write('sample/libzen.zen')


main(sys.argv)
