/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

/**
 * The Class NonHumanResource.
 * 
 * This abstract class makes the difference between a human and a non human resource
 * (This class is not really useful but i wrote it in case of an eventual future add-on) 
 */
public abstract class NonHumanResource extends Resource{

	private static final long serialVersionUID = -7526080555901198578L;
	
	/**
	 * Instantiates a new non human resource.
	 *
	 * @param name the resource's name
	 * @param type the resource's type
	 */
	public NonHumanResource(int id, String name, String type){
		super(id, name, type);
	}

}
