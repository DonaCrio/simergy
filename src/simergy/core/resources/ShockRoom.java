/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

/**
 * The Class ShockRoom.
 * 
 *  @see simergy.core.resources.Room
 */
public class ShockRoom extends Room{


	private static final long serialVersionUID = 3621142982417945782L;

	/**
	 * Instantiates a new shock room.
	 */
	public ShockRoom(int id){
		super(id, "Shock Room n°" + Integer.toString(id), "SHOCKROOM");
	}
}
