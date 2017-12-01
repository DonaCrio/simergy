/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

// TODO: Auto-generated Javadoc
/**
 * The Class Transporter.
 */
public class Transporter extends HumanResource{

	private static final long serialVersionUID = -3299374046877336495L;

	/**
	 * Instantiates a new transporter.
	 *
	 * @param name the transporter's name
	 * @param surname the transporter's surname
	 */
	public Transporter(int id, String name, String surname) {
		super(id, name, "TRANSPORTER", surname);
	}
	
	/**
	 * Instantiates a new transporter.
	 *
	 * Both name and surname are set to "transporterN" where N is the id of the resource
	 */
	public Transporter(int id){
		super(id,"", "TRANSPORTER", "");
		this.name = "transporter" + this.id;
		this.surname = "transporter" + this.id;
	}
}
