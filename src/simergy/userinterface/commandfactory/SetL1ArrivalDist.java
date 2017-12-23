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
 * The Class SetL1ArrivalDist.
 */
public class SetL1ArrivalDist extends SetPatientArrivalDist{
	
	/**
	 * Instantiates a new sets the L 1 arrival dist.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public SetL1ArrivalDist(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,SeverityLevel.L1);
	}
}
