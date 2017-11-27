/*
 * @author Donatien Criaud
 * 
 */
package simergy.exceptions;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = -6277047173250635701L;

	/**
	 * Instantiates a new resource not found exception.
	 *
	 * @param resourceType the resource type
	 */
	public ResourceNotFoundException(String resourceType){
		System.out.println("Resource[" + resourceType + "] not found !");
	}
}
