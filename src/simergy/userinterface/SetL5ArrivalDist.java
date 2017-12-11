package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;

public class SetL5ArrivalDist extends SetPatientArrivalDist{
	
	public SetL5ArrivalDist(StringTokenizer st, CommandLineUserInterface clui){
		super(st,clui,SeverityLevel.L5);
	}
}
