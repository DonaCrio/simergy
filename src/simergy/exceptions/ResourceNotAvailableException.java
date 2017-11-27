/*
 * @author Donatien Criaud
 * 
 */
package simergy.exceptions;

/**
 * The Class ResourceNotAvailableException.
 */
public class ResourceNotAvailableException extends Exception{

	private static final long serialVersionUID = 3442573557860011344L;

	/**
	 * Instantiates a new resource not available exception.
	 *
	 * @param resourceType the resource type
	 */
	public ResourceNotAvailableException(String resourceType) {
		System.out.println("Resource[" + resourceType + "] is not available !");
	}
}
