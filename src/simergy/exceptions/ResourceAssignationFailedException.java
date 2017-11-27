/*
 * @author Donatien Criaud
 * 
 */
package simergy.exceptions;

/**
 * The Class ResourceAssignationFailedException.
 */
public class ResourceAssignationFailedException extends Exception{

	private static final long serialVersionUID = -5281326575246491690L;

	/**
	 * Instantiates a new resource assignation failed exception.
	 */
	public ResourceAssignationFailedException(){
		System.out.println("Resources assignation failed !");
	}
}
