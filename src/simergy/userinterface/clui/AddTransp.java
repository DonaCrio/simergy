package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

public class AddTransp extends AddHumanResource{
	
	public AddTransp(StringTokenizer st, UserInterface userInterface){
		super(st, userInterface, "TRANSPORTER");
	}
}