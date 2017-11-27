/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.events;

/**
 * The Enum EventState.
 */
public enum EventState {

	NS("Not Started"),
	IP("In progress"),
	AF("Already finished");
	
	private String description;
	
	/**
	 * Instantiates a new event state.
	 *
	 * @param description the description
	 */
	private EventState(String description){
		this.setDescription(description);
	}

	/**
	 * Gets the state description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the state description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
