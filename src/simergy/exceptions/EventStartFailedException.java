/*
 * @author Donatien Criaud
 * 
 */
package simergy.exceptions;

/**
 * The Class EventStartFailedException.
 */
public class EventStartFailedException extends Exception{

	private static final long serialVersionUID = -63684345713445786L;

	/**
	 * Instantiates a new event start failed exception.
	 *
	 * @param name the name
	 */
	public EventStartFailedException(String name){
		System.out.println("Event[" + name + "] failed to start !");
	}
}
