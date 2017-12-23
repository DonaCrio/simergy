/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.intefaces;

import java.util.Scanner;
import java.util.StringTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandLineUserInterface.
 */
public class CommandLineUserInterface extends UserInterface{
	
	/**
	 * Instantiates a new command line user interface.
	 */
	public CommandLineUserInterface(){
		this.sc = new Scanner(System.in);
	}
	
	/**
	 * Run.
	 */
	public void run(){
		
		System.out.println("\n###################\n"
				+ "##### SIMERGY #####\n"
				+ "###################");
		System.out.println("\nWelcome to Simergy.\n"
				+ "This tool emulates an emergency department."
				+ "\n\nWe strongly advice you to read the help by typing 'help' to get started.\n"
				+ "\nTo load a previous configuration, see the help about managing saves : 'help s'.");
		
		run = true;
		while(run){
			System.out.print("\n>>> ");
			String input = sc.nextLine();
			StringTokenizer st = new StringTokenizer(input, " ,");
			System.out.println(commandFactory.getCommand(st).execute());
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		CommandLineUserInterface clui = new CommandLineUserInterface();
		clui.run();
	}	
}
