package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

public class AddRadioService extends AddHealthService{

	public AddRadioService(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,"RADIOGRAPHY");
	}
}
