package simergy.userinterface;

import java.io.File;

public class ListSaves implements Command{

	private CommandLineUserInterface clui;
	
	public ListSaves(CommandLineUserInterface clui){
		this.clui = clui;
	}
	
	public void execute() {

		System.out.println("Saves found :");
        File[] filesList = clui.getCurrentDirectory().listFiles();
        for(File f : filesList){
            if(f.isFile()){
                System.out.println("# " + f.getName());
            }
        }
	}
}
