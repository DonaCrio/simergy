package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

public class AddNurse extends AddHumanResource{
	
	public AddNurse(StringTokenizer st, UserInterface userInterface){
		super(st, userInterface, "NURSE");
	}
}
