package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;

public class CreateED implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public CreateED(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	public void execute(){
		
		if(st.countTokens()==1){
			String name = st.nextToken();
			clui.getSys().getEDs().put(name,new EmergencyDept(name));
			System.out.println("New ED : "+ name + " was succesfully created and added to SimErgy.");
		}else if(st.countTokens()==0){
			System.out.println("ERROR : You need to specify your ED's name.");
		}else{
			System.out.println("ERROR : Your ED's name is invalid (It can't be composed of spaces nor comas).");
		}
	}
}
