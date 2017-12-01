/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

/**
 * The Class BoxRoom.
 * 
 *  @see simergy.core.resources.Room
 */
public class BoxRoom extends Room{

	private static final long serialVersionUID = 5423558398860993199L;

	/**
	 * Instantiates a new box room.
	 */
	public BoxRoom(int id){
		super(id, "Box Room n°" + Integer.toString(id), "BOXROOM");
	}
}
