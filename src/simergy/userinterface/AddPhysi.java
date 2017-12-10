package simergy.userinterface;

import java.util.StringTokenizer;

public class AddPhysi extends AddHumanResource{
	
	public AddPhysi(StringTokenizer st, CommandLineUserInterface clui){
		super(st, clui, "PHYSICIAN");
	}
}