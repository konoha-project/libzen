//ifdef JAVA

package zen.codegen.erlang;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import zen.deps.Field;

//endif VAJA

public class VariableManager {
	@Field private HashMap<String, Variable> CurrentMap;
	@Field private ArrayList<HashMap<String, Variable>> MapList;
	@Field private int filter;
	@Field private boolean FilterOnlyUsed;

	public VariableManager/*constructor*/() {
		this.CurrentMap = new HashMap<String, Variable>();
		this.MapList = new ArrayList<HashMap<String, Variable>>();
		this.filter = 0;
		this.FilterOnlyUsed = false;
	}

	Variable SearchVariable(String VarName) {
		int size;
		Variable Var = this.CurrentMap.get(VarName);
		if (Var == null && (size = this.MapList.size()) > 0) {
			int i = size - 1;
			do {
				Var = MapList.get(i).get(VarName);
				i = i - 1;
			} while(i >= 0 && Var == null);
		}
		return Var;
	}

	Variable CreateVariable(String VarName) {
		Variable Var = this.CurrentMap.get(VarName);
		if (Var == null) {
			Var = new Variable();
			this.CurrentMap.put(VarName, Var);
		} else {
			//pass
		}
		return Var;
	}

	String GenVariableName(String VarName) {
		Variable Var = this.SearchVariable(VarName);
		String ret;
		if (Var != null) {
			int read = Var.Read;
			if (this.filter > 0
				&& (!FilterOnlyUsed
					|| (FilterOnlyUsed & Var.IsUsed()))) {
				read += filter;
			}
			if (read == -1) {
				ret = VarName.toUpperCase();
			} else {
				ret = VarName.toUpperCase() + Integer.toString(read);
			}
		} else {
			//Error handling
			ret = VarName;
		}
		return ret;
	}

	void IncrementVariableNumber(String VarName) {
		Variable Var = this.CurrentMap.get(VarName);
		if (Var == null) {
			Var = this.SearchVariable(VarName);
			if (Var == null) {
				//Error handling
				System.out.println(this.MapList);
			} else {
				Variable NewVar = this.CreateVariable(VarName);
				NewVar.Read = Var.Read;
				NewVar.Next = Var.Next;
				Var = NewVar;
			}
		}
		Var.Read = Var.Next;
		Var.Next += 1;
		Var.UsedByCurrentScope();
	}

	void PushScope() {
		HashMap<String, Variable> NewMap = new HashMap<String, Variable>();
		this.MapList.add(this.CurrentMap);
		this.CurrentMap = NewMap;
	}
	void PopScope() {
		int size = this.MapList.size();
		if (size > 0) {
			HashMap<String, Variable> OldMap = this.CurrentMap;
			this.CurrentMap = this.MapList.get(size - 1);
			this.MapList.remove(size - 1);
			for (Map.Entry<String, Variable> KeyValue : OldMap.entrySet()) {
				Variable OldVar = KeyValue.getValue();
				if (OldVar.IsUsed()) {
					Variable CurrentVar = this.CreateVariable(KeyValue.getKey());
					CurrentVar.Next = OldVar.Next;
					CurrentVar.UsedByChildScope();
				}
			}
		} else {
			System.out.println("too much call PopScope!!");
		}
	}

	String GenVarTupleOnlyUsed(boolean DoIncrement) {
		String VarTuple = "{";
		for (Map.Entry<String, Variable> KeyValue : this.CurrentMap.entrySet()) {
			Variable Var = KeyValue.getValue();
			//System.out.println(Var.UsedFlag);
			if (Var.IsUsed()) {
				String VarName = KeyValue.getKey();
				if (DoIncrement) this.IncrementVariableNumber(VarName);
				VarTuple += this.GenVariableName(VarName);
				VarTuple += ", ";
			}
		}
		VarTuple += "pad}";
		return VarTuple;
	}
	String GenVarTupleOnlyUsedByChildScope(boolean DoIncrement) {
		String VarTuple = "{";
		for (Map.Entry<String, Variable> KeyValue : this.CurrentMap.entrySet()) {
			Variable Var = KeyValue.getValue();
			//System.out.println(Var.UsedFlag);
			if (Var.IsUsedByChildScope()) {
				String VarName = KeyValue.getKey();
				if (DoIncrement) this.IncrementVariableNumber(VarName);
				VarTuple += this.GenVariableName(VarName);
				VarTuple += ", ";
			}
		}
		VarTuple += "pad}";
		return VarTuple;
	}

	void StartUsingFilter(boolean FilterOnlyUsed) {
		this.FilterOnlyUsed = FilterOnlyUsed;
		this.filter += 1;
	}
	void StopUsingFilter() {
		if (this.filter > 0) {
			this.filter = - this.filter;
		}
	}
	void ContinueUsingFilter(boolean FilterOnlyUsed) {
		this.FilterOnlyUsed = FilterOnlyUsed;
		if (this.filter < 0) {
			this.filter = - this.filter;
		}
	}
	void FinishUsingFilter() {
		for (Map.Entry<String, Variable> KeyValue : this.CurrentMap.entrySet()) {
			Variable Var = KeyValue.getValue();
			if (Var.IsUsed()) {
				Var.Next += 1;
			}
		}
		this.filter -= 1;
	}
}
