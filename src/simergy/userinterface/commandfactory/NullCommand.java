/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

// TODO: Auto-generated Javadoc
/**
 * The Class NullCommand.
 */
public class NullCommand implements Command{

	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		return("Command not found, consult the help for more informations");
	};
}
