/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.resources.HealthService;

/**
 * The Class TestTransportation.
 */
public class TestTransportation extends Event{
	
	private static final long serialVersionUID = 2905517630120591225L;

	/**
	 * Instantiates a new test transportation.
	 *
	 * @param workflow the workflow
	 */
	public TestTransportation(Workflow workflow) {
		super(workflow, "TestTransportation of patient n° " + Integer.toString(workflow.getPatient().getId()), "TESTTRANSPORTATION", 5);
		this.resources.put("TRANSPORTER",null);
	}
	
	/*
	 * @see simergy.core.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){
		((HealthService)workflow.getEd().getResources().get(workflow.getPatient().getPrescription()).get(0)).newArrival(workflow.getPatient());
		switch(workflow.getPatient().getPrescription()){
		case "BLOODTEST":
			return new BloodTestExamination(workflow);
		case "MRI":
			return new MRIExamination(workflow);
		case "RADIOGRAPHY":
			return new RadiographyExamination(workflow);
		default:
			return null;
		}
	}
}
