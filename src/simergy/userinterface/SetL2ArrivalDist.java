package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;

public class SetL2ArrivalDist extends SetPatientArrivalDist{
	
	public SetL2ArrivalDist(StringTokenizer st, CommandLineUserInterface clui){
		super(st,clui,SeverityLevel.L2);
	}
}