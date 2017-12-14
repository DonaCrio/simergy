package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.LoadSave;
import simergy.userinterface.intefaces.UserInterface;

public class Save implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public Save(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
		
	}
	
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
