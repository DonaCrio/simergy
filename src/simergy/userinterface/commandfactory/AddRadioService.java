/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddRadioService.
 */
public class AddRadioService extends AddHealthService{

	/**
	 * Instantiates a new adds the radio service.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddRadioService(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,"RADIOGRAPHY");
	}
}
