/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.resources.MRI;
import simergy.core.patients.PatientState;
import simergy.core.resources.HealthService;

/**
 * The Class MRIExamination.
 */
public class MRIExamination extends Examination{
	
	/**
	 * Instantiates a new MRI examination.
	 *
	 * @param workflow the workflow
	 */
	public MRIExamination(Workflow workflow){
		super(workflow, "MRI examination of patient n° " + Integer.toString(workflow.getPatient().getId()), 
				"MRIEXAMINATION", ((HealthService)workflow.getEd().getResources().get("MRI").get(0)).getDistribution().generateSample());
		resources.put("MRI",workflow.getEd().getResources().get("MRI").get(0));
	}
	
	/**
	 * Overrides super in order to notify the patient's physician of the end of the examination.
	 * @see simergy.events.Event#endEvent()
	 */
	@Override
	public void endEvent(){
		releaseResources();
		workflow.getPatient().getPhysician().notify(workflow.getPatient());
		resources.get("MRI").hasBeenTreated(workflow.getPatient());
		workflow.getPatient().addCharges(MRI.getCost());
		workflow.getPatient().setState(PatientState.W);
		state = EventState.AF;
		workflow.setNextEvent(createNextEvent());
	}
}
