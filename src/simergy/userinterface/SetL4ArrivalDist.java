package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;

public class SetL4ArrivalDist extends SetPatientArrivalDist{
	
	public SetL4ArrivalDist(StringTokenizer st, CommandLineUserInterface clui){
		super(st,clui,SeverityLevel.L4);
	}
}
