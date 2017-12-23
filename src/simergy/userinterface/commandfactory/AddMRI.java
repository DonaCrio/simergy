/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddMRI.
 */
public class AddMRI extends AddHealthService{

	/**
	 * Instantiates a new adds the MRI.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddMRI(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,"MRI");
	}
}
