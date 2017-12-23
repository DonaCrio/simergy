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
 * The Class SelectED.
 */
public class SelectED implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new select ED.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public SelectED(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		
		if(st.countTokens()==1){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				userInterface.setCurrentED(ed);
				return(ed.getName() + " has been set as current Ed.");
			}else{
				return("ERROR : Your ED's name is invalid (It can't be composed of spaces nor comas).");
			}
		}else{
			return("ERROR : Your ED's name is invalid (It can't be composed of spaces nor comas).");
		}
	}
}
