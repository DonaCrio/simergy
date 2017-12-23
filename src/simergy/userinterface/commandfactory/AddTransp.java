/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddTransp.
 */
public class AddTransp extends AddHumanResource{
	
	/**
	 * Instantiates a new adds the transp.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddTransp(StringTokenizer st, UserInterface userInterface){
		super(st, userInterface, "TRANSPORTER");
	}
}