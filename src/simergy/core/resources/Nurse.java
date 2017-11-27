/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

/**
 * The Class Nurse.
 */
public class Nurse extends HumanResource{

	private static final long serialVersionUID = -2791144985175587073L;

	/**
	 * Instantiates a new nurse.
	 *
	 * @param name the nurse's name
	 * @param surname the nurse's surname
	 */
	public Nurse(String name, String surname) {
		super(name, "NURSE", surname);
	}
}
