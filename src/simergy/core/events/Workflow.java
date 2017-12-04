
/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.patients.*;
import simergy.core.system.EmergencyDept;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Class Workflow.
 */
public class Workflow implements Serializable{

	private static final long serialVersionUID = -450065771556983070L;

	/** The integer used to generate unique ids. */
	private static int i;
	
	private int id;
	private String name;
	private EmergencyDept ed;
	private double startTime;
	private double consultationTime;
	private double endTime;
	private Patient patient;
	private ArrayList<Event> passedEvents;
	private Event currentEvent;
	private EventState state;
	
	/**
	 * Instantiates a new workflow.
	 *
	 * @param ed the ed
	 * @param patient the patient concerned by this workflow
	 */
	public Workflow(EmergencyDept ed, Patient patient, double startTime){
		this.id = i++;
		this.name = "Workflow n°" + id + " in ED";
		this.ed = ed;
		this.startTime = startTime;
		this.patient = patient;
		this.passedEvents = new ArrayList<Event>();
		this.currentEvent = new PatientArrival(this);
		this.state = EventState.IP;
		patient.setWorkflow(this);
		
	}
	
	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Sets the next event.
	 *
	 * @param newEvent the next event
	 * 
	 * @see simergy.events.EventOperations#createNextEvent()
	 */
	public void setNextEvent(Event newEvent) {
		passedEvents.add(currentEvent);
		currentEvent = newEvent;
	}
	
	/**
	 * Ends the workflow.
	 * Releases the patient.
	 */
	public void endWorkflow(){
		passedEvents.add(currentEvent);
		state = EventState.AF;
		patient.setState(PatientState.R);
	}
/* Getters and Setters*/
	
	/*
 * @see java.lang.Object#toString()
 */
@Override
	public String toString() {
		return "Workflow [id=" + id + ", name=" + name + ", startTime=" + startTime + ", patient="
				+ patient.getId() + ", currentEvent=" + currentEvent.getName() + ", state=" + state
				+ "]";
	}

	/**
	 * Sets the current event.
	 *
	 * @param currentEvent the new current event
	 */
	public void setCurrentEvent(Event currentEvent) {
		this.currentEvent = currentEvent;
	}

	/**
	 * Gets the current event.
	 *
	 * @return the current event
	 */
	public Event getCurrentEvent() {
		return currentEvent;
	}

	/**
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Sets the patient.
	 *
	 * @param patient the new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Gets the ed.
	 *
	 * @return the ed
	 */
	public EmergencyDept getEd() {
		return ed;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public EventState getState(){
		return state;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	public double getConsultationTime() {
		return consultationTime;
	}

	public void setConsultationTime(double consultationTime) {
		this.consultationTime = consultationTime;
	}
	
	public ArrayList<Event> getPassedEvents() {
		return passedEvents;
	}
}