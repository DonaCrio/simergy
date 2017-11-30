/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.system;

import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import simergy.core.patients.Patient;
import simergy.core.patients.SeverityLevel;

/**
 * The Class PatientGenerator.
 * 
 * This class is used to generate patients of different severity levels
 */
public class PatientGenerator implements Serializable{

	private static final long serialVersionUID = -9180828970654076297L;
	
	private HashMap<SeverityLevel,Integer> nextPatients;
	
	/**
	 * Instantiates a new patient generator.
	 * Generates a HashMap<SeverityLevel,Integer>. The integer represents the time (in minutes) of arrival of the next patient with the considered severity level
	 */
	public PatientGenerator(){
		this.nextPatients = new HashMap<SeverityLevel,Integer>();
		for(SeverityLevel lvl : SeverityLevel.values()){
			nextPatients.put(lvl,lvl.distribution.generateSample());
		}
	}
	
	/**
	 * Gets the patients arriving at a time.
	 *
	 * @param time the time
	 * @return the patients arriving
	 */
	public ArrayList<Patient> getPatients(int time){
		ArrayList<Patient> newPatients = new ArrayList<Patient>();
		for(SeverityLevel lvl : nextPatients.keySet()){
			if(nextPatients.get(lvl) == time){
				newPatients.add(new Patient(lvl));
				nextPatients.put(lvl, time+lvl.distribution.generateSample());
			}
		}
		return newPatients;
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
		return nextPatients;
	}

	/**
	 * Sets the next patients.
	 *
	 * @param nextPatients the next patients
	 */
	public void setNextPatients(HashMap<SeverityLevel, Integer> nextPatients) {
		this.nextPatients = nextPatients;
	}
	
}
