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
	public Nurse(int id,String name, String surname) {
		super(id, name, "NURSE", surname);
	}
	
	/**
	 * Instantiates a new nurse.
	 *
	 * Both name and surname are set to "nurseN" where N is the id of the resource
	 */
	public Nurse(int id){
		super(id, "", "NURSE", "");
		this.name = "nurse" + this.id;
		this.surname = "nurse" + this.id;
	}
}
