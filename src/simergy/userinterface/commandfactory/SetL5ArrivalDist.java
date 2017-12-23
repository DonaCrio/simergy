/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class SetL5ArrivalDist.
 */
public class SetL5ArrivalDist extends SetPatientArrivalDist{
	
	/**
	 * Instantiates a new sets the L 5 arrival dist.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public SetL5ArrivalDist(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,SeverityLevel.L5);
	}
}
