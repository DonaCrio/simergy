/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

/**
 * The Class WaitingRoom.
 * 
 * @see simergy.core.resources.Room
 */
public class WaitingRoom extends Room{

	private static final long serialVersionUID = -7312529155171021288L;
	
	/**
	 * Instantiates a new waiting room.
	 */
	public WaitingRoom(int id){
		super(id, "Waiting Room n°" + Integer.toString(id), "WAITINGROOM");
	}
}
