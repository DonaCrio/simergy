package simergy.userinterface.cmdfactory;

import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public class CreateED implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public CreateED(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	public String execute(){
		
		if(st.countTokens()==1){
			String name = st.nextToken();
			userInterface.getSys().getEDs().put(name,new EmergencyDept(name));
			return("New ED : "+ name + " was succesfully created and added to SimErgy.");
		}else if(st.countTokens()==0){
			return("ERROR : You need to specify your ED's name.");
		}else{
			return("ERROR : Your ED's name is invalid (It can't be composed of spaces nor comas).");
		}
	}
}
