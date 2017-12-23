/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.LoadSave;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class Save.
 */
public class Save implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new save.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public Save(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
		
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		if(st.countTokens()==1){
			LoadSave.saveSys(userInterface.getSys(), st.nextToken());
			return "";
		}else{
			LoadSave.saveSys(userInterface.getSys(), userInterface.getSys().getName());
			return "";			
		}

	}

}
