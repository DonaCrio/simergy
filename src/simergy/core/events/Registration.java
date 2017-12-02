/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import java.util.ArrayList;

import simergy.core.patients.SeverityLevel;
import simergy.core.resources.*;

/**
 * The Class Registration.
 */
public class Registration extends Event{
	
	private static final long serialVersionUID = 1808682799582705478L;

	/**
	 * Instantiates a new registration.
	 * The instantiation of this class results of the assignment of a physician to the patient and a room.
	 * Depending of the severity level of the patient, the room used if a simple box or a shock room.
	 *
	 * @param workflow the workflow
	 */
	public Registration(Workflow workflow) {
		super(workflow, "Registration of patient n° " + Integer.toString(workflow.getPatient().getId()),
				"REGISTRATION", 0);
		resources.put("NURSE",null);
		//Ici on attribue le Physician le moins occupé au patient
		Physician physician = givePhysician();
		physician.addPatient(workflow.getPatient());
	}
	
	/*
	 * @see simergy.core.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){
		//Ici on attribue un type de pièce en fonction de l'état du Patient
		String roomType = workflow.getPatient().getSeverityLevel()==SeverityLevel.L1 
				||workflow.getPatient().getSeverityLevel()==SeverityLevel.L2?"SHOCKROOM":"BOXROOM";
		return new Transportation(workflow, roomType);
	}
	
	/**
	 * Assigns a physician to the patient.
	 *
	 * @return the physician
	 */
	public Physician givePhysician(){
		ArrayList<Resource> physicians = workflow.getEd().getResources().get("PHYSICIAN");
		Physician physician = (Physician)workflow.getEd().getResources().get("PHYSICIAN").get(0);
		int minSize = physician.getOverseenPatients().size();
		for(Resource r : physicians){
			Physician p = (Physician)r;
			if(p.getOverseenPatients().size()<minSize){
				physician = p;
				minSize = physician.getOverseenPatients().size();
			}
		}
		return physician;
	}
}
