package simergy.userinterface.cmdfactory;

import java.io.File;

import simergy.userinterface.intefaces.UserInterface;

public class ListSaves implements Command{

	private UserInterface userInterface;
	
	public ListSaves(UserInterface userInterface){
		this.userInterface = userInterface;
	}
	
	public String execute() {

		String res = "Saves found :\n";
        File[] filesList = userInterface.getCurrentDirectory().listFiles();
        for(File f : filesList){
            if(f.isFile()){
                res +="# " + f.getName() + "\n";
            }
        }
        return res;
	}
}
