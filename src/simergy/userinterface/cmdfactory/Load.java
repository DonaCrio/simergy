package simergy.userinterface.cmdfactory;

import java.util.Scanner;
import java.util.StringTokenizer;

import simergy.userinterface.intefaces.LoadSave;
import simergy.userinterface.intefaces.UserInterface;

public class Load implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public Load(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	public String execute(){
		System.out.println("Maybe you should save your system before loading another one...\n"
				+ "Are you sure you want to load a save ? (Type 'yes' to continue)");
		System.out.print("\n>>> ");
		Scanner confirm = new Scanner(System.in);
		if(confirm.next().equalsIgnoreCase("yes")){
			if(st.countTokens()==1){
				userInterface.setSys(LoadSave.loadSys(st.nextToken()));
			}else{
				userInterface.setSys(LoadSave.loadSys(""));
			}
		}
		return "";
	}
}
