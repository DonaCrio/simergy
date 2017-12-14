package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.userinterface.intefaces.UserInterface;

public class AddMRI extends AddHealthService{

	public AddMRI(StringTokenizer st, UserInterface userInterface){
		super(st,userInterface,"MRI");
	}
}
