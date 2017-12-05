/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.system;

import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import simergy.core.patients.*;
import simergy.core.distributions.*;
import simergy.core.events.Workflow;

/**
 * The Class PatientGenerator.
 * 
 * This class is used to generate patients of different severity levels
 */
public class PatientGenerator implements Serializable{

	private static final long serialVersionUID = -9180828970654076297L;
	
	private EmergencyDept ed;
	private HashMap<SeverityLevel,ProbabilityDistribution> distributions;
	private boolean enableGen; // =variable utilisée pour activer ou non la génération automatique de patients dans l'ED
	
	/**
	 * Instantiates a new patient generator.
	 * 
	 */
	public PatientGenerator(EmergencyDept ed){
		this.ed = ed;
		this.distributions = new HashMap<SeverityLevel,ProbabilityDistribution>();
		for(SeverityLevel lvl : SeverityLevel.values()){
			distributions.put(lvl, lvl.distribution);
		}
		
	}
	
	public void initializePatients(){
		for(SeverityLevel lvl : SeverityLevel.values()){
			ed.addWorkflow(new Workflow(ed, new Patient(lvl), distributions.get(lvl).generateSample()));
		}
	}
	
	/**
	 * Creates then sets a new distribution for a given severity Level.
	 * 
	 * @param severityLevel the severity level
	 * @param type the distribution's type
	 * @param params the distribution's params
	 * @return true if it's a success, false if it's not.
	 */
	public boolean setDistribution(SeverityLevel severityLevel, String type, ArrayList<Double> params) {
		if(type.equalsIgnoreCase("DETERMINISTIC") && params.size()==1){
			this.distributions.put(severityLevel, new Deterministic(params.get(0)));
			return true;
		}else if(type.equalsIgnoreCase("EXPONENTIAL") && params.size()==1){
			this.distributions.put(severityLevel, new Exponential(params.get(0)));
			return true;
		}else if(type.equalsIgnoreCase("UNIFORM") && params.size()==2){
			this.distributions.put(severityLevel, new Uniform(params.get(0),params.get(1)));
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Gives the arrival time of the next patient of a given severity level
	 *
	 * @param time the time of simulation
	 * @parma lvl the severity level
	 * @return the next patients
	 */
	public void giveNewPatient(double time, SeverityLevel lvl){
		if(enableGen){
			ed.addWorkflow(new Workflow(ed, new Patient(lvl), time+distributions.get(lvl).generateSample()));
		}
	}

	/**
	 * Gets the distributions associated to the severity levels.
	 * @return HashMap>SeverityLevel,ProbabilityDistribution>
	 */
	public HashMap<SeverityLevel, ProbabilityDistribution> getDistributions() {
		return distributions;
	}

	/**
	 * Toogles auto-generation of patients
	 * @param enabeGen the boolean
	 */
	public void setEnableGen(boolean enableGen) {
		this.enableGen = enableGen;
	}
	
}
