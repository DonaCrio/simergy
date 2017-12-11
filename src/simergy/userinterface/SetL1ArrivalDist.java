package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;

public class SetL1ArrivalDist extends SetPatientArrivalDist{
	
	public SetL1ArrivalDist(StringTokenizer st, CommandLineUserInterface clui){
		super(st,clui,SeverityLevel.L1);
	}
}
