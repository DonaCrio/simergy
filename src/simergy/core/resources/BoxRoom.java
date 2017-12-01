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
	
	/** The integer used to generate unique ids. */
	private static int n=0;

	/**
	 * Instantiates a new box room.
	 */
	public BoxRoom(int id){
		super(id, "Box Room n°" + Integer.toString(n++), "BOXROOM");
	}
}
