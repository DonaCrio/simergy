package simergy.userinterface.cmdfactory;

import java.util.Scanner;

import simergy.userinterface.intefaces.UserInterface;

public class Exit implements Command{

	private UserInterface userInterface;
	
	public Exit(UserInterface userInterface){
		this.userInterface = userInterface;
	}
	
	public String execute(){
		System.out.println("Maybe you should save your system before exiting SimErgy...\n"
				+ "Are you sure you want to exit Simergy ? (Type 'yes' to continue)");
		System.out.print("\n>>> ");
		Scanner confirm = new Scanner(System.in);
		if(confirm.next().equalsIgnoreCase("yes")){
			confirm.close();
			userInterface.getSc().close();
			userInterface.setRun(false);
			return("Hope SimErgy has been useful ! See you next time !");
		}
		confirm.close();
		return "";
	}
}
