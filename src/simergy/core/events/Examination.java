/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.patients.PatientState;
import simergy.core.patients.SeverityLevel;

/**
 * The Class Examination.
 */
public abstract class Examination extends Event{
	
	private static final long serialVersionUID = -345298137509823041L;

	/**
	 * Instantiates a new examination event .
	 *
	 * @param workflow the workflow
	 * @param name the examination's name
	 * @param type the examination's type
	 * @param duration the examination's duration
	 */
	public Examination(Workflow workflow, String name, String type, double startTime, double duration) {
		super(workflow, name, type, startTime, duration);
		workflow.getPatient().setState(PatientState.E);
	}
	
	/*
	 * @see simergy.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){
		String roomType = workflow.getPatient().getSeverityLevel()==SeverityLevel.L1 
				||workflow.getPatient().getSeverityLevel()==SeverityLevel.L2?"SHOCKROOM":"BOXROOM";
		return new Consultation(workflow, endTime, roomType, null);
	}
}
