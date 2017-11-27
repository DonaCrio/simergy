/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.patients.PatientState;
import simergy.core.resources.HealthService;
import simergy.core.resources.Radiography;

/**
 * The Class RadiographyExamination.
 */
public class RadiographyExamination extends Examination{
	
	/**
	 * Instantiates a new radiography examination.
	 *
	 * @param workflow the workflow
	 */
	public RadiographyExamination(Workflow workflow){
		super(workflow, "Radiography examination of patient n° " + Integer.toString(workflow.getPatient().getId()), 
				"RADIOGRAPHYEXAMINATION", ((HealthService)workflow.getEd().getResources().get("MRI").get(0)).getDistribution().generateSample());
		resources.put("RADIOGRAPHY",workflow.getEd().getResources().get("RADIOGRAPHY").get(0));
	}
	
	/**
	 * Overrides super in order to notify the patient's physician of the end of the examination.
	 * @see simergy.events.Event#endEvent()
	 */
	@Override
	public void endEvent(){
		releaseResources();
		workflow.getPatient().getPhysician().notify(workflow.getPatient());
		resources.get("RADIOGRAPHY").hasBeenTreated(workflow.getPatient());
		workflow.getPatient().addCharges(Radiography.getCost());
		workflow.getPatient().setState(PatientState.W);
		state = EventState.AF;
		workflow.setNextEvent(createNextEvent());
	}
}
