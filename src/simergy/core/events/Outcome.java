/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

/**
 * The Class Outcome.
 * 
 * This event is only instantiated when a workflow ends in order to avoid setting the workflow's current event to null.
 */
public class Outcome extends Event{
	
	private static final long serialVersionUID = 4523575686202839683L;

	/**
	 * Instantiates a new outcome event.
	 *
	 * @param workflow the workflow
	 */
	public Outcome(Workflow workflow, double startTime){
		super(workflow, "Outcome of patient n° " + Integer.toString(workflow.getPatient().getId()), "OUTCOME", startTime, 0);
		workflow.getPatient().getPhysician().patientTreated(workflow.getPatient());
		workflow.setEndTime(startTime);
	}
	
	/*
	 * @see simergy.core.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){return null;}

	/*
	 * @see simergy.core.events.Event#toString()
	 */
	@Override
	public String toString() {
		return "Outcome [name=" + name  + ", charges=" + workflow.getPatient().getCharges() + "]";
	}
	
	
}
