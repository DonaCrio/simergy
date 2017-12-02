/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.distributions.Uniform;
import simergy.core.patients.PatientState;
import simergy.core.resources.Room;
import simergy.exceptions.EventStartFailedException;
import simergy.exceptions.ResourceAssignationFailedException;

/**
 * The Class Consultation.
 */
public class Consultation extends Event{
	
	private static final long serialVersionUID = -7565936593046692899L;
	private boolean secondTime = false;
	/**
	 * Instantiates a new consultation event.
	 *
	 * @param workflow the workflow
	 * @param roomType the used room type
	 * @param room the used room
	 */
	public Consultation(Workflow workflow, String roomType, Room room) {
		super(workflow, "Consultation of patient n° " + Integer.toString(workflow.getPatient().getId()), "CONSULTATION", new Uniform(5,20).generateSample());
		resources.put("PHYSICIAN", null);
		resources.put(roomType, room);
		if(room == null){
			secondTime = true;
		}else{
			workflow.setConsultationTime(workflow.getEd().getClock().getTime());
		}
	}
	/**
	 * Overrides super in order to set the time of first visitation by a Physician.
	 * 
	 * @see simergy.events.Event#startEvent()
	 */
	@Override
	public void startEvent() throws EventStartFailedException{
		/*
		 * On assigne les ressources nécessaires, on instancie la date de fin et on actualise l'état.
		 */
		try{
			assignResources();
			startTime = workflow.getEd().getClock().getTime();
			workflow.setConsultationTime(workflow.getEd().getClock().getTime());
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
	 * @see simergy.core.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){
		if(workflow.getPatient().getPrescription()=="NONE"){
			workflow.endWorkflow();
			return new Outcome(workflow);
		}else{
			return new TestTransportation(workflow);
		}
	}
	
	/**
	 * Overrides super in order to give a prescription to the patient.
	 * @see simergy.events.Event#endEvent()
	 */
	@Override
	public void endEvent(){
		// On override la méthode mere pour pouvoir fixer le verdict du Physician.
		workflow.getPatient().getPhysician().givePrescription(workflow.getPatient(),secondTime);
		//On donne la prescription en accord avec le fait que le patient soit consulté pour la premiere fois ou non
		releaseResources();
		workflow.getPatient().getPhysician().patientSeen(workflow.getPatient());
		state = EventState.AF;
		workflow.setNextEvent(createNextEvent());
	}
}
