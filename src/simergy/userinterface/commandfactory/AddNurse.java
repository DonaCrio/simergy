/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddNurse.
 */
public class AddNurse extends AddHumanResource{
	
	/**
	 * Instantiates a new adds the nurse.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddNurse(StringTokenizer st, UserInterface userInterface){
		super(st, userInterface, "NURSE");
	}
}
