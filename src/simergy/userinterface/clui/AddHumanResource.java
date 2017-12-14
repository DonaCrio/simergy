package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.core.resources.HumanResource;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public abstract class AddHumanResource implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	private String type;
	
	public AddHumanResource(StringTokenizer st, UserInterface userInterface, String type){
		this.st = st;
		this.userInterface = userInterface;
		this.type = type;
	}
	
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
			return("ERROR : Requires 1 or 3 arguments (<EDname>,<NurseName>,<NurseSurname>).");
		}
	}
}
