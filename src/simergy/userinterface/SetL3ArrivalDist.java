package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.patients.SeverityLevel;

public class SetL3ArrivalDist extends SetPatientArrivalDist{
	
	public SetL3ArrivalDist(StringTokenizer st, CommandLineUserInterface clui){
		super(st,clui,SeverityLevel.L3);
	}
}