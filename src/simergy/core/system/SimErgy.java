package simergy.core.system;

import java.util.HashMap;


public class SimErgy {

	HashMap<String,EmergencyDept> EDs;
	
	public SimErgy() {
		this.EDs = new HashMap<String,EmergencyDept>();
	}

	public HashMap<String, EmergencyDept> getEDs() {
		return EDs;
	}

	@Override
	public String toString() {
		return "SimErgy [EDs=" + EDs + "]";
	}
	
}
