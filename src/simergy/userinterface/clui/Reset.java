package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public class Reset implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public Reset(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	public String execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				userInterface.getSys().reset(ed);
				return(ed.getName() + " was successfully reset.");
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Requires 1 arguments (<EDname>).");
		}
	}
}
