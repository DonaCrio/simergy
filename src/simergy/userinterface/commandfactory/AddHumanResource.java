/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.resources.HumanResource;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddHumanResource.
 */
public abstract class AddHumanResource implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/** The type. */
	private String type;
	
	/**
	 * Instantiates a new adds the human resource.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 * @param type the type
	 */
	public AddHumanResource(StringTokenizer st, UserInterface userInterface, String type){
		this.st = st;
		this.userInterface = userInterface;
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource human = ed.getResourceFactory().getRessource(type);
				ed.addResource(human);
				return(human.getName() + " was successfully added to " + ed.getName() + ".");
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else if(st.countTokens()==3){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource human = ed.getResourceFactory().getRessource(type);
				String name = st.nextToken();
				String surname = st.nextToken();
				((HumanResource)human).setName(name);
				((HumanResource)human).setSurname(surname);
				ed.addResource(human);
				return(human.getName() + " was successfully added to " + ed.getName() + ".");
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}
}
