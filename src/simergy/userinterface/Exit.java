package simergy.userinterface;

import java.util.Scanner;

public class Exit implements Command{

	private CommandLineUserInterface clui;
	
	public Exit(CommandLineUserInterface clui){
		this.clui = clui;
	}
	
	public void execute(){
		System.out.println("Maybe you should save your system before exiting SimErgy...\n"
				+ "Are you sure you want to exit Simergy ? (Type 'yes' to continue)");
		System.out.print("\n>>> ");
		Scanner confirm = new Scanner(System.in);
		if(confirm.next().equalsIgnoreCase("yes")){
			confirm.close();
			System.out.println("Hope SimErgy has been useful ! See you next time !");
			clui.getSc().close();
			clui.setRun(false);
		}
	}
}
