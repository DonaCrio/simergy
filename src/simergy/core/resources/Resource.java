/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import java.io.Serializable;

import simergy.core.patients.Patient;

/**
 * The Class Resource.
 * 
 * An abstract class that represent a resource of the ed.
 * Resources are manipulated by the EmergencyDept class through events of a patient's workflow. 
 */
public abstract class Resource implements Serializable{

	static final long serialVersionUID = -2840494229767380108L;
	protected int id;
	protected String name;
	protected String type;
	protected State state;
	
	/**
	 * Instantiates a new resource.
	 *
	 * @param name the resource's name
	 * @param type the resource's type
	 */
	public Resource(int id, String name, String type){
		/**
		 * Constructor used to instantiate subclasses
		 * @param name
		 * @param type
		 */
		this.id = id;
		this.name = name;
		this.type = type;
		this.state = State.IDLE;
	}
	
	/**
	 * Method used for the subclasses Physician and HealthService
	 * Updates the waiting queue of these resources.
	 *
	 * @param patient the patient
	 */
	public void hasBeenTreated(Patient patient){};
	
	/**
	 * Returns the next patient in the waiting queue.
	 * Returns null for a lambda resource and is overridden in classes with a waiting queue attribute.
	 * 
	 * @param patient the patient
	 * 
	 * @see simergy.core.resources.Resource#nextPatient()
	 */
	public Patient nextPatient(){return null;};
	
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ressource [id=" + id + ", name=" + name + ", type=" + type + ", state=" + state + "]";
	}

/* Getters and Setters */

	/**
 * Gets the state.
 *
 * @return the state
 */
public State getState() {
		return state;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
