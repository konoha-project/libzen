// ***************************************************************************
// Copyright (c) 2013, JST/CREST DEOS project authors. All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// *  Redistributions of source code must retain the above copyright notice,
//    this list of conditions and the following disclaimer.
// *  Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// **************************************************************************

package org.ZenScript;

import java.util.ArrayList;
import java.util.HashMap;

import parser.ZenClassField;
import parser.ZenFieldInfo;
import parser.ZenFunc;
import parser.ZenSourceGenerator;
import parser.ZenSyntaxTree;
import parser.ZenType;
import parser.ast.ZenAllocateNode;
import parser.ast.ZenAndNode;
import parser.ast.ZenApplyFunctionObjectNode;
import parser.ast.ZenApplyOverridedMethodNode;
import parser.ast.ZenApplySymbolNode;
import parser.ast.ZenArrayLiteralNode;
import parser.ast.ZenBinaryNode;
import parser.ast.ZenBooleanNode;
import parser.ast.ZenBreakNode;
import parser.ast.ZenCaseNode;
import parser.ast.ZenCastNode;
import parser.ast.ZenCatchNode;
import parser.ast.ZenCommandNode;
import parser.ast.ZenConstPoolNode;
import parser.ast.ZenConstructorNode;
import parser.ast.ZenContinueNode;
import parser.ast.ZenDoWhileNode;
import parser.ast.ZenEmptyNode;
import parser.ast.ZenErrorNode;
import parser.ast.ZenFloatNode;
import parser.ast.ZenForEachNode;
import parser.ast.ZenForNode;
import parser.ast.ZenFunctionNode;
import parser.ast.ZenGetCapturedNode;
import parser.ast.ZenGetIndexNode;
import parser.ast.ZenGetLocalNode;
import parser.ast.ZenGetterNode;
import parser.ast.ZenIfNode;
import parser.ast.ZenInstanceOfNode;
import parser.ast.ZenIntNode;
import parser.ast.ZenMapLiteralNode;
import parser.ast.ZenNewArrayNode;
import parser.ast.ZenNode;
import parser.ast.ZenNullNode;
import parser.ast.ZenOrNode;
import parser.ast.ZenParamNode;
import parser.ast.ZenPrefixDeclNode;
import parser.ast.ZenPrefixInclNode;
import parser.ast.ZenRegexNode;
import parser.ast.ZenReturnNode;
import parser.ast.ZenSetCapturedNode;
import parser.ast.ZenSetIndexNode;
import parser.ast.ZenSetLocalNode;
import parser.ast.ZenSetterNode;
import parser.ast.ZenSliceNode;
import parser.ast.ZenStatementNode;
import parser.ast.ZenStringNode;
import parser.ast.ZenSuffixDeclNode;
import parser.ast.ZenSuffixInclNode;
import parser.ast.ZenSwitchNode;
import parser.ast.ZenThrowNode;
import parser.ast.ZenTrinaryNode;
import parser.ast.ZenTryNode;
import parser.ast.ZenUnaryNode;
import parser.ast.ZenUsingNode;
import parser.ast.ZenVarDeclNode;
import parser.ast.ZenWhileNode;
import parser.ast.ZenYieldNode;
import parser.deps.LibZen;

public class KonohaByteCodeGenerator extends ZenSourceGenerator {
	@Field private ArrayList<Object> ConstPool;
	@Field private ArrayList<String> MethodPool;
	@Field private ArrayList<ZenType> ClassPool;
	@Field private HashMap<ZenType, ArrayList<ZenFieldInfo>> ClassFieldMap;
	@Field private int RegisterNum;
	@Field private ArrayList<Integer> RegStack;
	@Field private int LabelNum;
	@Field private ArrayList<Integer> ContinueStack;
	@Field private ArrayList<Integer> BreakStack;
	@Field private HashMap<String, Integer> LocalVarMap;

	private static final int CallParameters = 5;
	private static final int ThisIndex = 0;
	private static final int MethodIndex = -1;
	private static final int ReturnIndex = -4;

	public KonohaByteCodeGenerator(String TargetCode, String OutputFile, int GeneratorFlag) {
		super(TargetCode, OutputFile, GeneratorFlag);
		this.ConstPool = new ArrayList<Object>();
		this.MethodPool = new ArrayList<String>();
		this.ClassPool = new ArrayList<ZenType>();
		this.ClassFieldMap = new HashMap<ZenType, ArrayList<ZenFieldInfo>>();
		this.RegisterNum = 0;
		this.RegStack = new ArrayList<Integer>();
		this.LabelNum = 0;
		this.ContinueStack = new ArrayList<Integer>();
		this.BreakStack = new ArrayList<Integer>();
		this.LocalVarMap = new HashMap<String, Integer>();
	}

	private void SetSignature() {
		@Var int ConstPoolSize = this.ConstPool.size();
		this.HeaderBuilder.Append("CONSTPOOLSIZE = " + ConstPoolSize + "\n");
		this.HeaderBuilder.Append("METHODPOOLSIZE = " + this.MethodPool.size() + "\n");
		@Var int ClassPoolSize = this.ClassPool.size();
		this.HeaderBuilder.Append("CLASSPOOLSIZE = " + ClassPoolSize + "\n");
		for(@Var int i = 0; i < ConstPoolSize; ++i) {
			@Var Object ConstValue = this.ConstPool.get(i);
			//Builder.Append("CONST" + i + " = " + ConstValue.toString() + "(" + ConstValue.getClass().getName() + ")" + "\n");
			this.HeaderBuilder.Append("CONST" + i + " = ");
			this.HeaderBuilder.Append(ConstValue.toString() + "\n");			
		}
		for(@Var int i = 0; i < ClassPoolSize; ++i) {
			@Var ZenType Class = this.ClassPool.get(i);
			this.HeaderBuilder.Append("CLASS" + i + "(" + Class.ShortName + ")");
			this.HeaderBuilder.Append(" :\n");
			this.HeaderBuilder.Indent();
			@Var ArrayList<ZenFieldInfo> FieldList = this.ClassFieldMap.get(Class);
			@Var int FieldSize = FieldList.size();
			for(@Var int j = 0; j < FieldSize; ++j) {
				@Var ZenFieldInfo ClassField = FieldList.get(j);
				this.HeaderBuilder.IndentAndAppend("FIELD" + j + ": " + ClassField.NativeName + "(" + ClassField.Type.ShortName + ")" + "\n");
			}
			this.HeaderBuilder.UnIndent();
			//this.HeaderBuilder.Append("CONST" + i + " = " + this.EscapeString(ConstValue) + "\n");
		}
	}

	@Override public void FlushBuffer() {
		this.SetSignature();
		super.FlushBuffer();
	}

	private void PushStack(ArrayList<Integer> Stack, int RegNum) {
		Stack.add(new Integer(RegNum));
	}
	private int PopStack(ArrayList<Integer> Stack) {
		@Var int Size = Stack.size();
		@Var Integer PopValue = Stack.remove(Size - 1);
		return PopValue.intValue();
	}
	private int PeekStack(ArrayList<Integer> Stack) {
		@Var int Size = Stack.size();
		return Stack.get(Size - 1);
	}
	private int AllocRegister() {
		/*FIXME*/
		return this.RegisterNum++;
	}
	private int ReserveRegister(int Size) {
		/*FIXME*/
		@Var int HeadRegister = this.RegisterNum;
		this.RegisterNum += Size;
		return HeadRegister;
	}
	private void FreeRegister(int TargetReg) {
		/*FIXME*/
		this.RegisterNum = TargetReg;
	}
	private void PushRegister(int RegNum) {
		this.PushStack(this.RegStack, RegNum);
	}
	private int PopRegister() {
		return this.PopStack(this.RegStack);
	}

	private int NewLabel() {
		return this.LabelNum++;
	}
	private void PushLoopLabel(int ContinueLabel, int BreakLabel) {
		this.PushStack(this.ContinueStack, ContinueLabel);
		this.PushStack(this.BreakStack, BreakLabel);
	}
	private void PopLoopLabel() {
		this.PopStack(this.ContinueStack);
		this.PopStack(this.BreakStack);
	}
	private int PeekContinueLabel() {
		return this.PeekStack(this.ContinueStack);
	}
	private int PeekBreakLabel() {
		return this.PeekStack(this.BreakStack);
	}
	private int AddConstant(Object ConstValue) {
		@Var int Index = this.ConstPool.indexOf(ConstValue);
		if(Index == -1) {
			Index = this.ConstPool.size();
			this.ConstPool.add(ConstValue);
		}
		return Index;
	}
	private int AddMethod(String MethodName) {
		@Var int Index = this.MethodPool.indexOf(MethodName);
		if(Index == -1) {
			Index = this.MethodPool.size();
			this.MethodPool.add(MethodName);
		}
		return Index;
	}
	private int GetFieldOffset(ArrayList<ZenFieldInfo> FieldList, String FieldName) {
		@Var int FieldSize = FieldList.size();
		@Var int Offset = -1;
		for(@Var int i = 0; i < FieldSize; ++i) {
			if(FieldList.get(i).NativeName.equals(FieldName)) {
				Offset = i;
				break;
			}
		}
		return Offset;
	}

	@Override public void VisitEmptyNode(ZenEmptyNode Node) {
		/*FIXME*/
	}

	@Override public void VisitNullNode(ZenNullNode Node) {
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NUL  " + "REG" + Reg + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitBooleanNode(ZenBooleanNode Node) {
		@Var int Index = this.AddConstant(new Boolean(Node.Value));
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NSET " + "REG" + Reg + ", " + "CONST" + Index + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitIntNode(ZenIntNode Node) {
		@Var int Index = this.AddConstant(new Long(Node.Value));
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NSET " + "REG" + Reg + ", " + "CONST" + Index + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitFloatNode(ZenFloatNode Node) {
		@Var int Index = this.AddConstant(new Float(Node.Value));
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NSET " + "REG" + Reg + ", " + "CONST" + Index + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitStringNode(ZenStringNode Node) {
		@Var int Index = this.AddConstant(LibZen.QuoteString(Node.Value));
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NSET " + "REG" + Reg + ", " + "CONST" + Index + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitRegexNode(ZenRegexNode Node) {
		@Var int Index = this.AddConstant(Node.Value);
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NSET " + "REG" + Reg + ", " + "CONST" + Index + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitConstPoolNode(ZenConstPoolNode Node) {
		@Var int Index = this.AddConstant(Node.ConstValue);
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NSET " + "REG" + Reg + ", " + "CONST" + Index + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitArrayLiteralNode(ZenArrayLiteralNode Node) {
		@Var int ArraySize = LibZen.ListSize(Node.NodeList);
		@Var int TargetReg = this.ReserveRegister(ArraySize + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		for(@Var int i = 0; i < ArraySize; ++i) {
			Node.NodeList.get(i).Accept(this);
			this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+i+1) + ", REG" + this.PopRegister() + "\n");
		}
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD\"SetArrayLiteral\"\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + ArraySize + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitMapLiteralNode(ZenMapLiteralNode Node) {
		/*FIXME*/
	}

	@Override public void VisitParamNode(ZenParamNode Node) {
		/*FIXME*/
	}

	@Override public void VisitFunctionNode(ZenFunctionNode Node) {
		/*FIXME*/
	}

	@Override public void VisitGetNameNode(ZenGetLocalNode Node) {
		this.PushRegister(this.LocalVarMap.get(Node.NativeName));
	}

	@Override public void VisitSetNameNode(ZenSetLocalNode Node) {
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + this.LocalVarMap.get(Node.NativeName) + ", REG" + this.PopRegister() + "\n");
	}

	@Override public void VisitGetCapturedNode(ZenGetCapturedNode Node) {
		/*FIXME*/
	}

	@Override public void VisitSetCapturedNode(ZenSetCapturedNode Node) {
		/*FIXME*/
	}

	@Override public void VisitGetterNode(ZenGetterNode Node) {
		Node.RecvNode.Accept(this);
		@Var int TargetReg = this.AllocRegister();
		@Var ArrayList<ZenFieldInfo> FieldList = this.ClassFieldMap.get(Node.RecvNode.Type);
		@Var int Offset = this.GetFieldOffset(FieldList, Node.NativeName);
		this.CurrentBuilder.Append("NMOVx " + "REG" + TargetReg + ", REG" + this.PopRegister() + ", " + Offset + "\n");
		this.PushRegister(TargetReg);
	}

	@Override public void VisitSetterNode(ZenSetterNode Node) {
		Node.RecvNode.Accept(this);
		@Var int TargetReg = this.PopRegister();
		@Var ArrayList<ZenFieldInfo> FieldList = this.ClassFieldMap.get(Node.RecvNode.Type);
		@Var int Offset = this.GetFieldOffset(FieldList, Node.NativeName);
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append("XNMOV " + "REG" + TargetReg + ", " + Offset + ", REG" + this.PopRegister() + "\n");
	}

	@Override public void VisitApplySymbolNode(ZenApplySymbolNode Node) {
		@Var int ParamSize = LibZen.ListSize(Node.ParamList);
		@Var int TargetReg = this.ReserveRegister(ParamSize + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		for(@Var int i = 0; i < ParamSize; ++i) {
			Node.ParamList.get(i).Accept(this);
			this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+i+1) + ", REG" + this.PopRegister() + "\n");
		}
		@Var int CallMethod = this.MethodPool.indexOf(Node.ResolvedFunc.GetNativeFuncName());
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD" + CallMethod + "\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + ParamSize + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitApplyFunctionObjectNode(ZenApplyFunctionObjectNode Node) {
		/*FIXME*/
		@Var int ParamSize = LibZen.ListSize(Node.ParamList);
		@Var int TargetReg = this.ReserveRegister(ParamSize + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		for(@Var int i = 0; i < ParamSize; ++i) {
			Node.ParamList.get(i).Accept(this);
			this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+i+1) + ", REG" + this.PopRegister() + "\n");
		}
		Node.FuncNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + CallReg + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("LOOPUP " + "REG" + CallReg + "\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + ParamSize + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitApplyOverridedMethodNode(ZenApplyOverridedMethodNode Node) {
		/*FIXME*/
	}

	@Override public void VisitGetIndexNode(ZenGetIndexNode Node) {
		@Var int TargetReg = this.ReserveRegister(2/*ArgumentSize*/ + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+1) + ", REG" + this.PopRegister() + "\n");
		Node.IndexNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+2) + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD\"GetIndex\"\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + 2/*ArgumentSize*/ + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitSetIndexNode(ZenSetIndexNode Node) {
		@Var int TargetReg = this.ReserveRegister(3/*ArgumentSize*/ + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		Node.RecvNode.Accept(this);
		//@Var int ArrayVarReg = this.PopRegister();
		//this.VisitingBuilder.Append("NMOV " + "REG" + (CallReg+1) + ", REG" + ArrayVarReg + "\n");
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+1) + ", REG" + this.PopRegister() + "\n");
		Node.IndexNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+2) + ", REG" + this.PopRegister() + "\n");
		Node.ValueNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+3) + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD\"SetIndex\"\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + 3/*ArgumentSize*/ + "\n");
		//this.VisitingBuilder.Append("NMOV " + "REG" + ArrayVarReg + ", REG" + TargetReg + "\n");
		this.FreeRegister(TargetReg);
	}

	@Override public void VisitSliceNode(ZenSliceNode Node) {
		/*FIXME*/
	}

	@Override public void VisitAndNode(ZenAndNode Node) {
		@Var int TargetReg = this.AllocRegister();
		@Var int EndLabel = this.NewLabel();
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + TargetReg + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("JMPF " + "L" + EndLabel + ", REG" + TargetReg + "\n");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + TargetReg + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("L" + EndLabel + ":\n");
		this.PushRegister(TargetReg);
	}

	@Override public void VisitOrNode(ZenOrNode Node) {
		@Var int TargetReg = this.AllocRegister();
		@Var int RightLabel = this.NewLabel();
		@Var int EndLabel = this.NewLabel();
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + TargetReg + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("JMPF " + "L" + RightLabel + ", REG" + TargetReg + "\n");
		this.CurrentBuilder.Append("JMP  " + "L" + EndLabel + "\n");
		this.CurrentBuilder.Append("L" + RightLabel + ":\n");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + TargetReg + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("L" + EndLabel + ":\n");
		this.PushRegister(TargetReg);
	}

	@Override public void VisitUnaryNode(ZenUnaryNode Node) {
		@Var int TargetReg = this.ReserveRegister(1/*ArgumentSize*/ + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+1) + ", REG" + this.PopRegister() + "\n");
		@Var String Op = Node.SourceToken.ParsedText; //Node.NativeName
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD\"" + Op + "\"\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + 1/*ArgumentSize*/ + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitPrefixInclNode(ZenPrefixInclNode Node) {
		/*FIXME*/
		@Var int TargetReg = this.ReserveRegister(2/*ArgumentSize*/ + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		Node.RecvNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+1) + ", REG" + this.PopRegister() + "\n");
		@Var int Index = this.AddConstant(new Long(1));
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+2) + ", " + "CONST" + Index + "\n");
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD\"\"\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + 2/*ArgumentSize*/ + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitPrefixDeclNode(ZenPrefixDeclNode Node) {
		/*FIXME*/
	}

	@Override public void VisitSuffixInclNode(ZenSuffixInclNode Node) {
		/*FIXME*/
	}

	@Override public void VisitSuffixDeclNode(ZenSuffixDeclNode Node) {
		/*FIXME*/
	}

	@Override public void VisitBinaryNode(ZenBinaryNode Node) {
		@Var int TargetReg = this.ReserveRegister(2/*ArgumentSize*/ + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		Node.LeftNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+1) + ", REG" + this.PopRegister() + "\n");
		Node.RightNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+2) + ", REG" + this.PopRegister() + "\n");
		@Var String Op = Node.SourceToken.ParsedText; //Node.NativeName
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD\"" + Op + "\"\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + 2/*ArgumentSize*/ + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitTrinaryNode(ZenTrinaryNode Node) {
		/*FIXME*/
	}

	@Override public void VisitConstructorNode(ZenConstructorNode Node) {
		@Var int ParamSize = LibZen.ListSize(Node.ParamList);
		@Var int TargetReg = this.ReserveRegister(ParamSize + CallParameters);
		@Var int CallReg = TargetReg - ReturnIndex + ThisIndex;
		for(@Var int i = 0; i < ParamSize; ++i) {
			Node.ParamList.get(i).Accept(this);
			this.CurrentBuilder.Append("NMOV " + "REG" + (CallReg+i+1) + ", REG" + this.PopRegister() + "\n");
		}
		@Var int CallMethod = this.MethodPool.indexOf(Node.Func.GetNativeFuncName());
		this.CurrentBuilder.Append("NSET " + "REG" + (CallReg+MethodIndex) + ", METHOD" + CallMethod + "\n");
		//this.VisitingBuilder.Append("NEW  " + "REG" + CallReg + ", CLASS" + this.ClassPool.indexOf(Node.Type) + "\n");
		this.CurrentBuilder.Append("CALL " + "REG" + CallReg + ", " + ParamSize + "\n");
		this.PushRegister(TargetReg);
		this.FreeRegister(TargetReg + 1);
	}

	@Override public void VisitAllocateNode(ZenAllocateNode Node) {
		@Var int Reg = this.AllocRegister();
		this.CurrentBuilder.Append("NEW  " + "REG" + Reg + ", CLASS" + this.ClassPool.indexOf(Node.Type) + "\n");
		this.PushRegister(Reg);
	}

	@Override public void VisitNewArrayNode(ZenNewArrayNode Node) {
		/*FIXME*/
	}

	@Override public void VisitInstanceOfNode(ZenInstanceOfNode Node) {
		/*FIXME*/
	}

	@Override public void VisitCastNode(ZenCastNode Node) {
		/*FIXME*/
	}

	@Override public void VisitVarDeclNode(ZenVarDeclNode Node) {
		this.LocalVarMap.put(Node.NativeName, this.AllocRegister());
		Node.InitNode.Accept(this);
		this.CurrentBuilder.Append("NMOV " + "REG" + this.LocalVarMap.get(Node.NativeName) + ", REG" + this.PopRegister() + "\n");
		this.VisitBlock(Node.BlockNode);
		this.LocalVarMap.remove(Node.NativeName);
	}

	@Override public void VisitUsingNode(ZenUsingNode Node) {
		/*FIXME*/
	}

	@Override public void VisitIfNode(ZenIfNode Node) {
		@Var int ElseLabel = this.NewLabel();
		@Var int EndLabel = this.NewLabel();
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append("JMPF " + "L" + ElseLabel + ", REG" + this.PopRegister() + "\n");
		this.VisitBlock(Node.ThenNode);
		this.CurrentBuilder.Append("JMP  " + "L" + EndLabel + "\n");
		this.CurrentBuilder.Append("L" + ElseLabel + ":\n");
		this.VisitBlock(Node.ElseNode);
		this.CurrentBuilder.Append("L" + EndLabel + ":\n");
	}

	@Override public void VisitWhileNode(ZenWhileNode Node) {
		@Var int CondLabel = this.NewLabel();
		@Var int EndLabel = this.NewLabel();
		this.PushLoopLabel(CondLabel, EndLabel);
		this.CurrentBuilder.Append("L" + CondLabel + ":\n");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append("JMPF " + "L" + EndLabel + ", REG" + this.PopRegister() + "\n");
		this.VisitBlock(Node.BodyNode);
		this.CurrentBuilder.Append("JMP  " + "L" + CondLabel + "\n");
		this.CurrentBuilder.Append("L" + EndLabel + ":\n");
		this.PopLoopLabel();
	}

	@Override public void VisitDoWhileNode(ZenDoWhileNode Node) {
		@Var int BodyLabel = this.NewLabel();
		@Var int CondLabel = this.NewLabel();
		@Var int EndLabel = this.NewLabel();
		this.PushLoopLabel(CondLabel, EndLabel);
		this.CurrentBuilder.Append("L" + BodyLabel + ":\n");
		this.VisitBlock(Node.BodyNode);
		this.CurrentBuilder.Append("L" + CondLabel + ":\n");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append("JMPF " + "L" + EndLabel + ", REG" + this.PopRegister() + "\n");
		this.CurrentBuilder.Append("JMP  " + "L" + BodyLabel + "\n");
		this.CurrentBuilder.Append("L" + EndLabel + ":\n");
		this.PopLoopLabel();
	}

	@Override public void VisitForNode(ZenForNode Node) {
		@Var int CondLabel = this.NewLabel();
		@Var int IterLabel = this.NewLabel();
		@Var int EndLabel = this.NewLabel();
		this.PushLoopLabel(IterLabel, EndLabel);
		this.CurrentBuilder.Append("L" + CondLabel + ":\n");
		Node.CondNode.Accept(this);
		this.CurrentBuilder.Append("JMPF " + "L" + EndLabel + ", REG" + this.PopRegister() + "\n");
		this.VisitBlock(Node.BodyNode);
		this.CurrentBuilder.Append("L" + IterLabel + ":\n");
		this.VisitBlock(Node.IterNode);
		this.CurrentBuilder.Append("JMP  " + "L" + CondLabel + "\n");
		this.CurrentBuilder.Append("L" + EndLabel + ":\n");
		this.PopLoopLabel();
	}

	@Override public void VisitForEachNode(ZenForEachNode Node) {
		/*FIXME*/
	}

	@Override public void VisitContinueNode(ZenContinueNode Node) {
		this.CurrentBuilder.Append("JMP  " + "L" + this.PeekContinueLabel() + "\n");
	}

	@Override public void VisitBreakNode(ZenBreakNode Node) {
		this.CurrentBuilder.Append("JMP  " + "L" + this.PeekBreakLabel() + "\n");
	}

	@Override public void VisitStatementNode(ZenStatementNode Node) {
		/*FIXME*/
	}

	@Override public void VisitReturnNode(ZenReturnNode Node) {
		if(Node.ValueNode != null) {
			Node.ValueNode.Accept(this);
			this.CurrentBuilder.Append("NMOV " + "REG" + ReturnIndex + ", REG" + this.PopRegister() + "\n");
		}
		this.CurrentBuilder.Append("RET\n");
	}

	@Override public void VisitYieldNode(ZenYieldNode Node) {
		/*FIXME*/
	}

	@Override public void VisitThrowNode(ZenThrowNode Node) {
		/*FIXME*/
	}

	@Override public void VisitTryNode(ZenTryNode Node) {
		/*FIXME*/
	}

	@Override public void VisitCatchNode(ZenCatchNode Node) {
		/*FIXME*/
	}

	@Override public void VisitSwitchNode(ZenSwitchNode Node) {
		/*FIXME*/
	}

	@Override public void VisitCaseNode(ZenCaseNode Node) {
		/*FIXME*/
	}

	@Override public void VisitCommandNode(ZenCommandNode Node) {
		/*FIXME*/
	}

	@Override public void VisitErrorNode(ZenErrorNode Node) {
		/*FIXME*/
	}

	@Override public void GenerateFunc(ZenFunc Func, ArrayList<String> ParamNameList, ZenNode Body) {
		@Var String MethodName = Func.GetNativeFuncName();
		@Var int Index = this.AddMethod(MethodName);
		this.RegisterNum = ThisIndex + 1;
		//this.LabelNum = 0;
		this.CurrentBuilder = this.NewSourceBuilder();
		this.CurrentBuilder.Append("(METHOD" + Index + " " + MethodName);
		@Var int ParamSize = LibZen.ListSize(ParamNameList);
		//@Var HashMap<String,Integer> PushedMap = (HashMap<String,Integer>)this.LocalVarMap.clone();
		for(@Var int i = 0; i < ParamSize; ++i) {
			@Var String ParamName = ParamNameList.get(i);
			this.LocalVarMap.put(ParamName, this.AllocRegister());
			this.CurrentBuilder.Append(" " + ParamName + ":REG" + this.LocalVarMap.get(ParamName));
		}
		this.CurrentBuilder.Append("):\n");
		this.VisitBlock(Body);
		//this.LocalVarMap = PushedMap;
	}

	@Override public void OpenClassField(ZenSyntaxTree ParsedTree, ZenType Type, ZenClassField ClassField) {
		this.ClassPool.add(Type);
		this.ClassFieldMap.put(Type, ClassField.FieldList);
	}
	
	@Override public void InvokeMainFunc(String MainFuncName) {
		/*FIXME*/
	}
}
