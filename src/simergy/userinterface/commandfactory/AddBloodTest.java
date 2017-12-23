/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddBloodTest.
 */
public class AddBloodTest extends AddHealthService{

	/**
	 * Instantiates a new adds the blood test.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddBloodTest(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,"BLOODTEST");
	}
}
