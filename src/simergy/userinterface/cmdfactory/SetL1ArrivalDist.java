package simergy.userinterface.cmdfactory;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;
import simergy.userinterface.intefaces.UserInterface;

public class SetL1ArrivalDist extends SetPatientArrivalDist{
	
	public SetL1ArrivalDist(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,SeverityLevel.L1);
	}
}
