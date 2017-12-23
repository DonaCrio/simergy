/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddPhysi.
 */
public class AddPhysi extends AddHumanResource{
	
	/**
	 * Instantiates a new adds the physi.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddPhysi(StringTokenizer st, UserInterface userInterface){
		super(st, userInterface, "PHYSICIAN");
	}
}