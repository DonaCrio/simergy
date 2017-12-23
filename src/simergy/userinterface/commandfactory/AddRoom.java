/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddRoom.
 */
public class AddRoom implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new adds the room.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddRoom(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
		
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		
		if(st.countTokens()==2){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){	
				Resource room = ed.getResourceFactory().getRessource(st.nextToken());
				if(room!=null){
					 ed.addResource(room);
					 return(room.getName() + " was successfully added to " + ed.getName());
				}else{
					return("This kind of room doesn't exists.");
				}
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}
	
}
