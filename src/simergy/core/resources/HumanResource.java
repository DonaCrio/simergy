/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

/**
 * The Class HumanResource.
 * 
 * This abstract class makes a link between the resource representation and a human representation by adding attributes like the surname.
 */
public abstract class HumanResource extends Resource{

	private static final long serialVersionUID = 7853278297546382776L;
	
	protected String surname;
	
	/**
	 * Instantiates a new human resource.
	 *
	 * @param name the human's name
	 * @param type the human's type
	 * @param surname the human's surname
	 */
	public HumanResource(int id, String name, String type, String surname){
		super(id, name, type);
		this.surname = surname;
	}

	/*
	 * @see simergy.core.ressources.Ressource#toString()
	 */
	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", surname=" + surname + ", type=" + type + ", state=" + state + "]";
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
