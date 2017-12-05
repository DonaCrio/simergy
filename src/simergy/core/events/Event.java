/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import java.io.Serializable;
import java.util.HashMap;

import simergy.core.resources.Resource;
import simergy.core.resources.State;
import simergy.exceptions.*;
import simergy.core.patients.*;

/**
 * The Class Event.
 * 
 * This abstract class defines what information an event should contain.
 * An event belongs to a workflow. That workflow is used to store persistent information about the ED in witch the event occur, the patient affected by the event etc...
 * This class is very important to handle the particularity and differences of each kind of event through polymorphism.
 * The resources needed by an event are represented by a HashMap.
 */
public abstract class Event implements EventOperations, Serializable{

	private static final long serialVersionUID = -8417632545481743306L;


	/** The integer used to generate unique ids. */
	private static int i=0;
	

	protected Workflow workflow;
	private int id;
	protected String name;
	private String type;
	protected double startTime;
	protected double endTime;
	protected double duration;
	protected double occurenceTime;
	protected HashMap<String,Resource> resources;
	protected EventState state;
	
	/**
	 * Instantiates a new event.
	 * Event's duration is set during instantiation, depending on the event's subclass instantiated.
	 *
	 * @param workflow the workflow
	 * @param name the event's name
	 * @param type the event's type
	 * @param duration the event's duration
	 */
	public Event(Workflow workflow, String name, String type, double startTime, double duration){
		this.workflow = workflow;
		this.id = i++;
		this.name = name;
		this.type = type;
		this.startTime = startTime;
		this.duration = duration;
		this.resources = new HashMap<String,Resource>();
		this.state = EventState.NS;
	}
	
	/*
	 * @see simergy.events.EventOperations#requirementsAllGood()
	 */
	public boolean requirementsAllGood(){
		// On verifie l'état de chaque ressource nécessaire et on renvoie false si l'une d'elles n'est pas disponible.
		boolean allGood = true;
		for(String resourceType : resources.keySet()){
			if(resources.get(resourceType)==null){
				if(!workflow.getEd().isAvailable(resourceType, workflow.getPatient())){
					allGood = false;
				}
			}else if(resources.get(resourceType).getState()!=State.VISITING){
				if(!workflow.getEd().isAvailable(resourceType, workflow.getPatient())){
					allGood = false;
				}
			}
		}
		return allGood;
	}
	
	/*
	 * @see simergy.core.events.EventOperations#startEvent()
	 */
	public void startEvent() throws EventStartFailedException{
		/*
		 * On assigne les ressources nécessaires, on instancie la date de fin et on actualise l'état.
		 */
		try{
			assignResources();
			endTime = startTime + duration;
			workflow.getPatient().setState(PatientState.V);
			state = EventState.IP;
		}catch(ResourceAssignationFailedException e){
			workflow.getPatient().setState(PatientState.W);
			state = EventState.NS;
			throw new EventStartFailedException(name);
		}
	}
	
	/*
	 * @see simergy.core.events.EventOperations#assignRessources()
	 */
	public void assignResources() throws ResourceAssignationFailedException{
		/*
		 *  On parcours les ressources nécessaires et ont demande l'assignation au WorkFlow.
		 *  Si une assignation echoue, on vide les ressources assignées pour éviter de les mobiliser pour rien.
		 */
		try{
			for(String ressourceType : resources.keySet()){
				if(resources.get(ressourceType)==null){
					resources.put(ressourceType,workflow.getEd().giveResource(ressourceType));
				}else if(resources.get(ressourceType).getState()!=State.VISITING){
					resources.get(ressourceType).setState(State.VISITING);
				}
			}
		}catch(ResourceNotAvailableException e){
			for(String ressourceType : resources.keySet()){
				resources.put(ressourceType,null);
			throw new ResourceAssignationFailedException();
			}
		}
	}
	
	/*
	 * @see simergy.core.events.EventOperations#endEvent()
	 */
	public void endEvent(){
		releaseResources();
		workflow.getPatient().setState(PatientState.W);
		state = EventState.AF;
		workflow.setNextEvent(createNextEvent());
	}

	/*
	 * @see simergy.core.events.EventOperations#releaseRessources()
	 */
	public void releaseResources(){
		for(String ressourceType : resources.keySet()){
			workflow.getEd().takeBackResource(resources.get(ressourceType));
		}
	}
	

	
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [name=" + name + ", type=" + type + ", startTime=" + startTime + ", endTime=" + endTime + ", patient=" + workflow.getPatient().getId()
				+ ", state=" + state + "]";
	}
	
/* Getters and Setters */
	
	/**
	 * Gets the ressources.
	 *
	 * @return the ressources
	 */
	public HashMap<String, Resource> getRessources() {
		return resources;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public EventState getState() {
		return state;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public double getEndTime() {
		return endTime;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double d) {
		this.startTime = d;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public void setState(EventState state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public double getOccurenceTime() {
		return occurenceTime;
	}

	public void setOccurenceTime(double occurenceTime) {
		this.occurenceTime = occurenceTime;
	}
}
