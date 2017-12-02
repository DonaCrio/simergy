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

/**
 * The Class PatientGenerator.
 * 
 * This class is used to generate patients of different severity levels
 */
public class PatientGenerator implements Serializable{

	private static final long serialVersionUID = -9180828970654076297L;
	
	private HashMap<SeverityLevel,Integer> nextPatients;
	private HashMap<SeverityLevel,ProbabilityDistribution> distributions;
	private boolean patientsInitialized;
	
	/**
	 * Instantiates a new patient generator.
	 * 
	 */
	public PatientGenerator(){
		this.distributions = new HashMap<SeverityLevel,ProbabilityDistribution>();
		for(SeverityLevel lvl : SeverityLevel.values()){
			distributions.put(lvl, lvl.distribution);
		}
		this.nextPatients = new HashMap<SeverityLevel,Integer>();
		patientsInitialized = false;
	}
	
	/**
	 * Generates a HashMap<SeverityLevel,Integer>. The integer represents the time (in minutes) of arrival of the next patient with the considered severity level
	 */
	public void initializePatients(){
		for(SeverityLevel lvl : SeverityLevel.values()){
			nextPatients.put(lvl,distributions.get(lvl).generateSample());
		}
		patientsInitialized = true;
	}
	
	/**
	 * Gets the patients arriving at a time.
	 *
	 * @param time the time
	 * @return the patients arriving
	 */
	public ArrayList<Patient> getPatients(int time){
		if(!patientsInitialized){
			initializePatients();
		}
		ArrayList<Patient> newPatients = new ArrayList<Patient>();
		for(SeverityLevel lvl : nextPatients.keySet()){
			if(nextPatients.get(lvl) == time){
				newPatients.add(new Patient(lvl));
				nextPatients.put(lvl, time+lvl.distribution.generateSample());
			}
		}
		return newPatients;
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

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PatientGenerator [nextPatients=" + nextPatients + "]";
	}

	/**
	 * Gets the next patients.
	 *
	 * @return the next patients
	 */
	public HashMap<SeverityLevel, Integer> getNextPatients() {
		if(!patientsInitialized){
			initializePatients();
		}
		return nextPatients;
	}

	public HashMap<SeverityLevel, ProbabilityDistribution> getDistributions() {
		return distributions;
	}
	
}
