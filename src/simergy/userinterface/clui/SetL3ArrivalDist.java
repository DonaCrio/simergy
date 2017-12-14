package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;
import simergy.userinterface.intefaces.UserInterface;

public class SetL3ArrivalDist extends SetPatientArrivalDist{
	
	public SetL3ArrivalDist(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,SeverityLevel.L3);
	}
}