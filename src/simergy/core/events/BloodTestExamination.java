/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.patients.PatientState;
import simergy.core.resources.BloodTest;
import simergy.core.resources.HealthService;

/**
 * The Class BloodTestExamination.
 */
public class BloodTestExamination extends Examination{
	
	private static final long serialVersionUID = -4150987159968187377L;

	/**
	 * Instantiates a new blood test examination.
	 *
	 * @param workflow the workflow
	 */
	public BloodTestExamination(Workflow workflow, double startTime){
		super(workflow, "BloodTest examination of patient n° " + Integer.toString(workflow.getPatient().getId()), 
				"BLOODTESTEXAMINATION", startTime, ((HealthService)workflow.getEd().getResources().get("MRI").get(0)).getDistribution().generateSample());
		resources.put("BLOODTEST",workflow.getEd().getResources().get("BLOODTEST").get(0));
	}
	
	/**
	 * Overrides super in order to notify the patient's physician of the end of the examination.
	 * @see simergy.events.Event#endEvent()
	 */
	@Override
	public void endEvent(){
		releaseResources();
		workflow.getPatient().getPhysician().notify(workflow.getPatient());
		resources.get("BLOODTEST").hasBeenTreated(workflow.getPatient());
		workflow.getPatient().addCharges(BloodTest.getCost());
		workflow.getPatient().setState(PatientState.W);
		state = EventState.AF;
		workflow.setNextEvent(createNextEvent());
	}
}
