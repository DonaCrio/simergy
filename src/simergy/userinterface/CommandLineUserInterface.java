package simergy.userinterface;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import simergy.core.system.*;

public class CommandLineUserInterface {

	private CommandFactory commandFactory;
	private Scanner sc;
	private boolean run;
	private File currentDirectory;
	private SimErgy sys;
	
	public CommandLineUserInterface(){
		this.commandFactory = new CommandFactory(this);
		this.sc = new Scanner(System.in);
		this.currentDirectory = new File(System.getProperty("user.dir") + "/data/");
	}
	
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
			commandFactory.getCommand(st).execute();
		}
	}
	
	public static void main(String[] args) {
		CommandLineUserInterface clui = new CommandLineUserInterface();
		clui.run();
	}
	
	public SimErgy getSys() {
		return sys;
	}

	public void setSys(SimErgy sys) {
		this.sys = sys;
	}

	public File getCurrentDirectory() {
		return currentDirectory;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setRun(boolean run) {
		this.run = run;
	}	
}
