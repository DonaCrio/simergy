/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateED.
 */
public class CreateED implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new creates the ED.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public CreateED(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		
		if(st.countTokens()==1){
			String name = st.nextToken();
			userInterface.getSys().getEDs().put(name,new EmergencyDept(name));
			return("New ED : "+ name + " was succesfully created and added to SimErgy.");
		}else if(st.countTokens()==0){
			return("ERROR : You need to specify your ED's name.");
		}else{
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}
}
