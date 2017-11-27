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
	
	/**
	 * Instantiates a new outcome event.
	 *
	 * @param workflow the workflow
	 */
	public Outcome(Workflow workflow){
		super(workflow, "Outcome of patient n° " + Integer.toString(workflow.getPatient().getId()), "OUTCOME",0);
		workflow.getPatient().getPhysician().patientTreated(workflow.getPatient());
		workflow.setEndTime(workflow.getEd().getClock().getTime());
	}

	/*
	 * @see simergy.core.events.Event#update()
	 */
	@Override
	public void update(){}
	
	/*
	 * @see simergy.core.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){return null;}

	/*
	 * @see simergy.core.events.Event#toString()
	 */
	@Override
	public String toString() {
		return "Outcome [name=" + name + ", occurenceTime=" + occurenceTime + ", charges=" + workflow.getPatient().getCharges() + "]";
	}
	
	
}
