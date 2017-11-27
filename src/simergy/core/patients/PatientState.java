/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.patients;

// TODO: Auto-generated Javadoc
/**
 * The Enum PatientState.
 */
public enum PatientState {

	W("Waiting"),
	V("Bieng-visited"),
	E("Taking-exam"),
	R("Released");
	
	/** The state's description. */
	private String description;
	
	/**
	 * Instantiates a new patient state.
	 *
	 * @param description the description
	 */
	private PatientState(String description){
		this.description = description;
	}

	/**
	 * Gets the state's description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
