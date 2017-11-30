package simergy.core.system;

import java.io.Serializable;
import java.util.HashMap;


public class SimErgy implements Serializable{

	private static final long serialVersionUID = -412240945789262714L;
	
	private HashMap<String,EmergencyDept> EDs;
	
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
