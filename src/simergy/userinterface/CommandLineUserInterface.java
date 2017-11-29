package simergy.userinterface;

import java.util.Scanner;
import java.util.StringTokenizer;
import simergy.core.system.*;

public class CommandLineUserInterface {

	public CommandLineUserInterface(){}
	
	public static void run(){
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		SimErgy sys = LoadSave.loadSys();
		String input;
		
		System.out.println("###################\n"
				+ "##### SIMERGY #####\n"
				+ "###################");
		System.out.println("\nWelcome to Simergy.\n"
				+ "This tool emulate an emergency department."
				+ "\n\nWe strongly advice you to read the help by typing 'help' to get started.");
		
		while(run){
			System.out.print("\n>>> ");
			input = sc.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			String cmd = st.nextToken();
			
			if(cmd.contentEquals("help")){
				System.out.println("Help hasn't been yet implemented...");
				
				
			}else if(cmd.contentEquals("save")){
				
				
			}else if(cmd.contentEquals("quit")){
				System.out.println("Are you sure you want to exit ? (Type 'y' to exit)\n"
						+ "Maybe you should save before...");
				System.out.print("\n>>> ");
				Scanner confirm = new Scanner(System.in);
				if(confirm.next().equalsIgnoreCase("y")){
					System.out.println("Hope SimErgy has been useful ! See you next time !");
					run = false;
				}
				
				
			}else if(cmd.contentEquals("createED")){
				if(st.countTokens()==1){
					String name = st.nextToken();
					sys.getEDs().put(name,new EmergencyDept(name));
					System.out.println("New ED : " + name + " added to SimErgy.");
				}else{
					System.err.println("You need to specify your ED's name.");
				}
				
				
			}else if(cmd.contentEquals("addRoom")){
				
			}else if(cmd.contentEquals("addRadioService")){
				
			}else if(cmd.contentEquals("addMRI")){
				
			}else if(cmd.contentEquals("addBloodTest")){
				
			}else if(cmd.contentEquals("addNurse")){
				
			}else if(cmd.contentEquals("addPhysi")){
				
			}else if(cmd.contentEquals("setL1arrivalDist")){
				
			}else if(cmd.contentEquals("setL2arrivalDist")){
				
			}else if(cmd.contentEquals("setL3arrivalDist")){
				
			}else if(cmd.contentEquals("setL4arrivalDist")){
				
			}else if(cmd.contentEquals("setL5arrivalDist")){
				
			}else if(cmd.contentEquals("addPatient")){
				
			}else if(cmd.contentEquals("registerPatient")){
				
			}else if(cmd.contentEquals("setPatientInsurance")){
				
			}else if(cmd.contentEquals("display")){
				
			}else{
				System.out.println("Command not found, maybe you should try 'help'.");
			}
		}
	}
	
	public static void main(String[] args) {
		CommandLineUserInterface.run();
	}
}
