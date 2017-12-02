/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

import simergy.core.resources.Room;

/**
 * The Class Transportation.
 */
public class Transportation extends Event{
	
	private static final long serialVersionUID = 4313206586375453728L;
	private String roomType;
	
	/**
	 * Instantiates a new transportation event.
	 *
	 * @param workflow the workflow
	 * @param roomType the room type
	 */
	public Transportation(Workflow workflow, String roomType) {
		super(workflow, "Transportation of patient n° " + Integer.toString(workflow.getPatient().getId()), 
				"TRANSPORTATION", 2);
		resources.put("NURSE",null);
		resources.put(roomType,null);
		this.roomType = roomType;
	}
	
	/*
	 * @see simergy.core.events.EventOperations#createNextEvent()
	 */
	public Event createNextEvent(){
		return new Consultation(workflow, roomType, (Room)resources.get(roomType));
	}
	
	/*
	 * Overrides super in order to keep the room where the patient is visiting by the physician.
	 * @see simergy.core.events.Event#releaseRessources()
	 */
	@Override
	public void releaseResources(){
		for(String ressourceType : resources.keySet()){
			if(ressourceType!=roomType){
				workflow.getEd().takeBackResource(resources.get(ressourceType));
			}
		}
	}
	
}
