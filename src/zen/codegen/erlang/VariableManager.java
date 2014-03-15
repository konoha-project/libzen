//ifdef JAVA

package zen.codegen.erlang;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import zen.util.Field;
import zen.util.Var;

//endif VAJA

public class VariableManager{
	@Field private HashMap<String, VariableDefinition> DefMap;
	@Field private int CurrentScopeIdx;
	@Field private ArrayList<ArrayList<VariableReference>> ScopeEmulator;
	@Field private int FilterCount;
	@Field private int FilterFlag;

	public VariableManager/*constructor*/() {
		this.Init();
	}
	public void Init() {
		this.DefMap = new HashMap<String, VariableDefinition>();
		this.ScopeEmulator = new ArrayList<ArrayList<VariableReference>>();
		this.ScopeEmulator.add(new ArrayList<VariableReference>());
		this.CurrentScopeIdx = 0;
		this.FilterFlag = VarFlag.None;
	}

	public void PushScope() {
		this.ScopeEmulator.add(new ArrayList<VariableReference>());
		this.CurrentScopeIdx = this.CurrentScopeIdx + 1;
	}
	public void PopScope() {
		if (this.CurrentScopeIdx >= 0) {
			ArrayList<VariableReference> OldScope = this.ScopeEmulator.get(this.CurrentScopeIdx);
			this.CurrentScopeIdx = this.CurrentScopeIdx - 1;
			@Var int i = 0;
			@Var int size = OldScope.size();
			while (i < size) {
				VariableReference OldRef = OldScope.get(i);
				OldRef.SelfDef.CurrentRef = OldRef.ParentRef;
				i = i + 1;
			}
		} else {
			throw new RuntimeException("Try to call PopScope too much");
		}
	}

	public ArrayList<String> GetVarListInCurrentScope(int Flag) {
		@Var ArrayList<String> Ret = new ArrayList<String>();
		return Ret;
	}
	public String GenVarTuple(int Flag, boolean DoIncrement) {
		@Var String Ret = "{";
		for (Map.Entry<String, VariableDefinition> KeyValue : this.DefMap.entrySet()) {
			VariableDefinition VarDef = KeyValue.getValue();
			if (VarDef.CurrentRef != null) {
				if (VarFlag.Check(VarDef.CurrentRef.Flag, Flag)) {
					String VarName = KeyValue.getKey();
					if (DoIncrement) this.AssignVariable(VarName);
					Ret += this.GenVariableName(VarName);
					Ret += ", ";
				}
			}
		}
		Ret += "pad}";
		return Ret;
	}

	public VariableDefinition DefineVariable(String VarName) {
		VariableDefinition VarDef = this.DefMap.get(VarName);
		if (VarDef == null) {
			VarDef = new VariableDefinition(VarName);
			VariableReference VarRef = new VariableReference(VarDef, null, 0, this.CurrentScopeIdx);
			VarDef.CurrentRef = VarRef;
			this.DefMap.put(VarName, VarDef);
			ArrayList<VariableReference> CurrentScope = this.ScopeEmulator.get(this.CurrentScopeIdx);
			CurrentScope.add(VarRef);
		} else {
			//redefine variable
		}
		return VarDef;
	}
	public void AssignVariable(String VarName) {
		VariableDefinition VarDef = this.DefMap.get(VarName);
		if (VarDef == null) throw new RuntimeException("Try to use undefined variable : " + VarName);

		VariableReference CurrentRef = VarDef.CurrentRef;
		VarDef.AssignedCount = VarDef.AssignedCount + 1;
		if (CurrentRef.ScopeLevel == this.CurrentScopeIdx) {
			CurrentRef.UniqueID = VarDef.AssignedCount;
		} else {
			CurrentRef = new VariableReference(VarDef, CurrentRef, VarDef.AssignedCount, this.CurrentScopeIdx);
			CurrentRef.Flag = VarFlag.Update(CurrentRef.Flag, VarFlag.DefinedByParentScope);
		}
		CurrentRef.Flag = VarFlag.Update(CurrentRef.Flag, VarFlag.AssignedByCurrentScope);
		if (CurrentRef.ParentRef != null) CurrentRef.ParentRef.Flag = VarFlag.Update(CurrentRef.ParentRef.Flag, VarFlag.AssignedByChildScope);
		VarDef.CurrentRef = CurrentRef;
		this.ScopeEmulator.get(this.CurrentScopeIdx).add(CurrentRef);
	}
	public void ReadVariable(String VarName) {
		VariableDefinition VarDef = this.DefMap.get(VarName);
		if (VarDef == null) throw new RuntimeException("Try to use undefined variable : " + VarName);
	}

	public String GenVariableName(String VarName) {
		VariableDefinition VarDef = this.DefMap.get(VarName);
		if (VarDef != null && VarDef.CurrentRef != null) {
			int Id = VarDef.CurrentRef.UniqueID;
			if (VarFlag.Check(VarDef.CurrentRef.Flag, this.FilterFlag)) {
				Id = Id + this.FilterCount;
			}
			return VarName.toUpperCase() + Integer.toString(Id);
		} else {
			throw new RuntimeException("Try to use undefined variable : " + VarName);
		}
	}

	int ChangeFilterFlag(int NewFlag) {
		@Var int OldFlag = this.FilterFlag;
		this.FilterFlag = NewFlag;
		return OldFlag;
	}
	void FilterStart() {
		this.FilterCount = this.FilterCount + 1;
	}
	void FilterFinish() {
		for (Map.Entry<String, VariableDefinition> KeyValue : this.DefMap.entrySet()) {
			VariableDefinition VarDef = KeyValue.getValue();
			if (VarDef.CurrentRef != null) {
				if (VarFlag.Check(VarDef.CurrentRef.Flag, VarFlag.Assigned)) VarDef.AssignedCount = VarDef.AssignedCount + 1;
			}
		}
		this.FilterCount = this.FilterCount - 1;
	}
}

// public class VariableManager {
// 	@Field private HashMap<String, Variable> CurrentMap;
// 	@Field private ArrayList<HashMap<String, Variable>> MapList;
// 	@Field private int filter;
// 	@Field private boolean FilterOnlyUsed;

// 	public VariableManager/*constructor*/() {
// 		this.CurrentMap = new HashMap<String, Variable>();
// 		this.MapList = new ArrayList<HashMap<String, Variable>>();
// 		this.filter = 0;
// 		this.FilterOnlyUsed = false;
// 	}

// 	Variable SearchVariable(String VarName) {
// 		int size;
// 		Variable Var = this.CurrentMap.get(VarName);
// 		if (Var == null && (size = this.MapList.size()) > 0) {
// 			int i = size - 1;
// 			do {
// 				Var = MapList.get(i).get(VarName);
// 				i = i - 1;
// 			} while(i >= 0 && Var == null);
// 		}
// 		return Var;
// 	}

// 	Variable CreateVariable(String VarName) {
// 		Variable Var = this.CurrentMap.get(VarName);
// 		if (Var == null) {
// 			Var = new Variable();
// 			this.CurrentMap.put(VarName, Var);
// 		} else {
// 			//pass
// 		}
// 		return Var;
// 	}

// 	String GenVariableName(String VarName) {
// 		Variable Var = this.SearchVariable(VarName);
// 		String ret;
// 		if (Var != null) {
// 			int read = Var.Read;
// 			if (this.filter > 0
// 				&& (!FilterOnlyUsed
// 					|| (FilterOnlyUsed & Var.IsUsed()))) {
// 				read += filter;
// 			}
// 			if (read == -1) {
// 				ret = VarName.toUpperCase();
// 			} else {
// 				ret = VarName.toUpperCase() + Integer.toString(read);
// 			}
// 		} else {
// 			//Error handling
// 			ret = VarName;
// 		}
// 		return ret;
// 	}

// 	void IncrementVariableNumber(String VarName) {
// 		Variable Var = this.CurrentMap.get(VarName);
// 		if (Var == null) {
// 			Var = this.SearchVariable(VarName);
// 			if (Var == null) {
// 				//FIXME!! Error handling
// 				//System.out.println(this.MapList);
// 				return;
// 			} else {
// 				Variable NewVar = this.CreateVariable(VarName);
// 				NewVar.CreatedTemporary();
// 				NewVar.Read = Var.Read;
// 				NewVar.Next = Var.Next;
// 				Var = NewVar;
// 			}
// 		}
// 		Var.Read = Var.Next;
// 		Var.Next += 1;
// 		Var.UsedByCurrentScope();
// 	}

// 	void PushScope() {
// 		HashMap<String, Variable> NewMap = new HashMap<String, Variable>();
// 		this.MapList.add(this.CurrentMap);
// 		this.CurrentMap = NewMap;
// 	}
// 	void PopScope(boolean DoClear) {
// 		int size = this.MapList.size();
// 		if (size > 0) {
// 			HashMap<String, Variable> OldMap = this.CurrentMap;
// 			this.CurrentMap = this.MapList.get(size - 1);
// 			this.MapList.remove(size - 1);
// 			if (!DoClear) {
// 				for (Map.Entry<String, Variable> KeyValue : OldMap.entrySet()) {
// 					Variable OldVar = KeyValue.getValue();
// 					if (OldVar.IsUsed() && OldVar.IsCreatedTemporary()) {
// 						Variable CurrentVar = this.CreateVariable(KeyValue.getKey());
// 						CurrentVar.Next = OldVar.Next;
// 						CurrentVar.UsedByChildScope();
// 					}
// 				}
// 			}
// 		} else {
// 			System.out.println("too much call PopScope!!");
// 		}
// 	}

// 	String GenVarTupleOnlyUsed(boolean DoIncrement) {
// 		String VarTuple = "{";
// 		for (Map.Entry<String, Variable> KeyValue : this.CurrentMap.entrySet()) {
// 			Variable Var = KeyValue.getValue();
// 			//System.out.println(Var.UsedFlag);
// 			if (Var.IsUsed()) {
// 				String VarName = KeyValue.getKey();
// 				if (DoIncrement) this.IncrementVariableNumber(VarName);
// 				VarTuple += this.GenVariableName(VarName);
// 				VarTuple += ", ";
// 			}
// 		}
// 		VarTuple += "pad}";
// 		return VarTuple;
// 	}
// 	String GenVarTupleOnlyUsedByChildScope(boolean DoIncrement) {
// 		String VarTuple = "{";
// 		for (Map.Entry<String, Variable> KeyValue : this.CurrentMap.entrySet()) {
// 			Variable Var = KeyValue.getValue();
// 			//System.out.println(Var.UsedFlag);
// 			if (Var.IsUsedByChildScope()) {
// 				String VarName = KeyValue.getKey();
// 				if (DoIncrement) this.IncrementVariableNumber(VarName);
// 				VarTuple += this.GenVariableName(VarName);
// 				VarTuple += ", ";
// 			}
// 		}
// 		VarTuple += "pad}";
// 		return VarTuple;
// 	}
// 	String GenVarTupleOnlyUsedDefinedByParentScope(boolean DoIncrement) { //FIX ME!!
// 		String VarTuple = "{";
// 		for (Map.Entry<String, Variable> KeyValue : this.CurrentMap.entrySet()) {
// 			Variable Var = KeyValue.getValue();
// 			//System.out.println(Var.UsedFlag);
// 			if (Var.IsUsed() && Var.IsCreatedTemporary()) {
// 				String VarName = KeyValue.getKey();
// 				if (DoIncrement) this.IncrementVariableNumber(VarName);
// 				VarTuple += this.GenVariableName(VarName);
// 				VarTuple += ", ";
// 			}
// 		}
// 		VarTuple += "pad}";
// 		return VarTuple;
// 	}

// 	void StartUsingFilter(boolean FilterOnlyUsed) {
// 		this.FilterOnlyUsed = FilterOnlyUsed;
// 		this.filter += 1;
// 	}
// 	void StopUsingFilter() {
// 		this.FilterOnlyUsed = false;
// 		this.filter -= 1;
// 	}
// 	void ContinueUsingFilter(boolean FilterOnlyUsed) {
// 		this.FilterOnlyUsed = FilterOnlyUsed;
// 		this.filter += 1;
// 	}
// 	void FinishUsingFilter() {
// 		this.FilterOnlyUsed = false;
// 		for (Map.Entry<String, Variable> KeyValue : this.CurrentMap.entrySet()) {
// 			Variable Var = KeyValue.getValue();
// 			if (Var.IsUsed()) {
// 				Var.Next += 1;
// 			}
// 		}
// 		this.filter -= 1;
// 	}
// }
