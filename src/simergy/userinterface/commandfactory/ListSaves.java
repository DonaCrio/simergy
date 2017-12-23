/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.io.File;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class ListSaves.
 */
public class ListSaves implements Command{

	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new list saves.
	 *
	 * @param userInterface the user interface
	 */
	public ListSaves(UserInterface userInterface){
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
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
