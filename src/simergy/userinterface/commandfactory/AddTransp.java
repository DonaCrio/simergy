package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

public class AddTransp extends AddHumanResource{
	
	public AddTransp(StringTokenizer st, UserInterface userInterface){
		super(st, userInterface, "TRANSPORTER");
	}
}