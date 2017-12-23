/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrentSave.
 */
public class CurrentSave implements Command{

	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new current save.
	 *
	 * @param userInterface the user interface
	 */
	public CurrentSave(UserInterface userInterface){
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		return(userInterface.getSys()==null?"There is no current save.":"Current save : " + userInterface.getSys().getName());
	}
}
