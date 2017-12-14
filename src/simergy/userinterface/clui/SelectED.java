package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public class SelectED implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public SelectED(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
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
