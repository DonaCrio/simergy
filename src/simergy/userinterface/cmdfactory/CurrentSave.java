package simergy.userinterface.cmdfactory;

import simergy.userinterface.intefaces.UserInterface;

public class CurrentSave implements Command{

	private UserInterface userInterface;
	
	public CurrentSave(UserInterface userInterface){
		this.userInterface = userInterface;
	}
	
	public String execute(){
		return(userInterface.getSys()==null?"There is no current save.":"Current save : " + userInterface.getSys().getName() + ".ser");
	}
}
