/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

/**
 * The Class Room.
 * 
 * This abstract class is used to represent a room.
 * Only used to improve polymorphism and encapsulation of the room type
 */
public abstract class Room extends NonHumanResource{

	private static final long serialVersionUID = -3803874719304604592L;
	
	/**
	 * Instantiates a new room.
	 *
	 * @param name the room's name
	 * @param type the room's type
	 */
	public Room(String name, String type){
		super(name, type);
	}

}
