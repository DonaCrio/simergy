package simergy.userinterface.cmdfactory;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

public class AddBloodTest extends AddHealthService{

	public AddBloodTest(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,"BLOODTEST");
	}
}
