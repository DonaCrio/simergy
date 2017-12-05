/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import java.util.ArrayList;
import simergy.core.distributions.*;
import simergy.core.patients.*;

/**
 * The Class HealthService.
 * 
 * This abstract class represents a health service of the ED, adding a waiting queue and a probability distribution used to set the duration of an examination.
 */
public abstract class HealthService extends NonHumanResource{

	private static final long serialVersionUID = 1295898712641211076L;

	private ArrayList<Patient> waitingQueue;
	private Patient currentPatient;
	private ProbabilityDistribution distribution;
	
	/**
	 * Instantiates a new health service.
	 *
	 * @param name the health service's name
	 * @param type the health service's type
	 * @param cost the health service's cost
	 * @param distribution the health service's distribution
	 */
	public HealthService(int id, String name, String type, double cost, ProbabilityDistribution distribution){
		super(id, name, type);
		this.waitingQueue = new ArrayList<Patient>();
		this.setDistribution(distribution);
	}
	
	/**
	 * Adds a patient to the service's waiting queue
	 *
	 * @param patient the patient
	 */
	public void newArrival(Patient patient){
		if(waitingQueue.size()==0){
			currentPatient = patient;
		}
		waitingQueue.add(patient);
	}
	
	/**
	 * Returns the next patient in the waiting queue
	 * 
	 * @param patient the patient
	 * 
	 * @see simergy.core.resources.Resource#nextPatient()
	 */
	@Override
	public Patient nextPatient(){
		return currentPatient;
	}
	
	/*
	 * @see simergy.core.resources.Resource#hasBeenTreated(simergy.core.patients.Patient)
	 */
	@Override
	public void hasBeenTreated(Patient patient){
		waitingQueue.remove(patient);
		currentPatient = waitingQueue.size()==0?null:waitingQueue.get(0);
	}

	/**
	 * Creates then sets a new distribution.
	 * 
	 * @param type the distribution's type
	 * @param params the distribution's params
	 * @return true if it's a success, false if it's not.
	 */
	public boolean createDistribution(String type, ArrayList<Double> params){
		if(type.equalsIgnoreCase("DETERMINISTIC") && params.size()==1){
			distribution = new Deterministic(params.get(0));
			return true;
		}else if(type.equalsIgnoreCase("EXPONENTIAL") && params.size()==1){
			distribution = new Exponential(params.get(0));
			return true;
		}else if(type.equalsIgnoreCase("UNIFORM") && params.size()==2){
			distribution = new Uniform(params.get(0),params.get(1));
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Gets the waiting queue.
	 *
	 * @return the waiting queue
	 */
	public ArrayList<Patient> getWaitingQueue() {
		return waitingQueue;
	}

	/**
	 * Gets the distribution.
	 *
	 * @return the distribution
	 */
	public ProbabilityDistribution getDistribution() {
		return distribution;
	}

	/**
	 * Sets the distribution.
	 *
	 * @param distribution the new distribution
	 */
	public void setDistribution(ProbabilityDistribution distribution) {
		this.distribution = distribution;
	}

	public void setWaitingQueue(ArrayList<Patient> waitingQueue) {
		this.waitingQueue = waitingQueue;
	}
}
