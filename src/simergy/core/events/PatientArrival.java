/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

/**
 * The Class PatientArrival.
 */
public class PatientArrival extends Event{

	private static final long serialVersionUID = -5123097992182110365L;

	/**
	 * Instantiates a new patient arrival event.
	 *
	 * @param workflow the workflow
	 */
	public PatientArrival(Workflow workflow) {
		super(workflow, "Arrival of patient n° " + Integer.toString(workflow.getPatient().getId()),
				"PATIENTARRIVAL", 0);
	}
	
	/*
	 * @see simergy.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){
		return new Registration(workflow);
	}
}
