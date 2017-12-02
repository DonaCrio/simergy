package simergy.core.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import simergy.core.events.*;
import simergy.core.patients.*;
import simergy.core.resources.*;

public class SimErgy implements Serializable{

	private static final long serialVersionUID = -412240945789262714L;
	
	private HashMap<String,EmergencyDept> EDs;
	
	public SimErgy() {
		this.EDs = new HashMap<String,EmergencyDept>();
	}

	public HashMap<String, EmergencyDept> getEDs() {
		return EDs;
	}
	
	public ArrayList<Double> simulation(EmergencyDept ed, int endTime){
		ArrayList<Double> KPIs;
		for(int i=1;i<=endTime;i++){
			ed.update();
		}
		KPIs = computeKPIs(ed);
		return KPIs	;	
	}
	
	public void reset(EmergencyDept ed){
		ed.setWorkflows(new ArrayList<Workflow>());
		ed.setPatients(new ArrayList<Patient>());
		ed.setClock(new TimeMachine());
		ed.setPatientGenerator(new PatientGenerator());
		for(String resourceType : ed.getResources().keySet()){
			for(Resource r : ed.getResources().get(resourceType)){
				r.setState(State.IDLE);
			}
		}
		for(Resource r : ed.getResources().get("MRI")){
			((HealthService)r).setWaitingQueue(new ArrayList<Patient>());
		}
		for(Resource r : ed.getResources().get("BLOODTEST")){
			((HealthService)r).setWaitingQueue(new ArrayList<Patient>());
		}
		for(Resource r : ed.getResources().get("RADIOGRAPHY")){
			((HealthService)r).setWaitingQueue(new ArrayList<Patient>());
		}
		for(Resource r : ed.getResources().get("PHYSICIAN")){
			((Physician)r).setOverseenPatients(new ArrayList<Patient>());
			((Physician)r).setToBeSeenPatients(new ArrayList<Patient>());
			((Physician)r).setTreatedPatients(new ArrayList<Patient>());
			((Physician)r).setCurrentPatient(null);
		}
	}
	
	public ArrayList<Double> computeKPIs(EmergencyDept ed){
		double DTDT = 0;
		double LOS = 0;
		double nbR = 0;
		double nbPatients = ed.getWorkflows().size();
		for(Workflow w : ed.getWorkflows()){
			if(w.getPatient().getState()==PatientState.R){
				nbR += 1;
				DTDT += w.getConsultationTime()-w.getStartTime();
				LOS += w.getEndTime()-w.getStartTime();
			}
		}
		ArrayList<Double> KPIs = new ArrayList<Double>();
		KPIs.add(DTDT/nbPatients);
		KPIs.add(LOS/nbPatients);
		KPIs.add(nbR);
		return KPIs;
	}

	@Override
	public String toString() {
		return "SimErgy [EDs=" + EDs + "]";
	}	
	
}
