package simergy.userinterface.cmdfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

public class AddPhysi extends AddHumanResource{
	
	public AddPhysi(StringTokenizer st, UserInterface userInterface){
		super(st, userInterface, "PHYSICIAN");
	}
}