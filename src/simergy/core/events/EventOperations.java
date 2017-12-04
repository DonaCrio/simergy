/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.exceptions.*;

/**
 * The Interface EventOperations.
 *
 */
public interface EventOperations {
	
	/**
	 * Checks if all the requirements to start an event are good.
	 * That means that all the resources needed are available and that the patient is the next to come in his physician or health service waiting queue.
	 *
	 * @return true, if successful
	 */
	public boolean requirementsAllGood();
	
	/**
	 * Starts the event.
	 * Sets the end time of the event.
	 * Sets the patient's state to VISITING and assign all the needed resources to the event.
	 * This method can be overridden in the subclasses to perform specific actions in particular examples.
	 * 
	 * @see simergy.events.EventOperations#assignResources()
	 *
	 * @throws EventStartFailedException if the event fails to start
	 */
	public void startEvent() throws EventStartFailedException;
	
	/**
	 * Assigns the needed resources to the event.
	 * It puts in the HashMap a (resourceType,Resource).
	 *
	 * @throws ResourceAssignationFailedException the resource assignation failed exception
	 */
	public void assignResources() throws ResourceAssignationFailedException;
	
	/**
	 * Ends the event.
	 * Releases all the resources and sets the patient's state to WAITING.
	 * This method can be Override in the subclasses to perform specific actions in particular examples.
	 * Creates the next event to come in the workflow.
	 * 
	 *  @see simergy.events.EventOperations#releaseResources()
	 *  @see simergy.events.EventOperations#createNextEvent()
	 */
	public void endEvent();
	
	/**
	 * Releases the resources.
	 * Sets their states to IDLE.
	 */
	public void releaseResources();
	
	/**
	 * Creates the next event to come in the workflow.
	 * This method is always overridden by the subclasses.
	 *
	 * @return the event
	 */
	public Event createNextEvent();
}
