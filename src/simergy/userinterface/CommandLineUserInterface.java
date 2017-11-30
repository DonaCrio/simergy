package simergy.userinterface;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import simergy.core.system.*;
import simergy.core.patients.*;

public class CommandLineUserInterface {

	public CommandLineUserInterface(){}
	
	public static void run(){
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do you want to load a previous save before start ? If not, just press Enter.");
		getFilesInCurrentDirectory(new File(System.getProperty("user.dir") + "/data/"));
		System.out.print("\nEnter the file to load : ");
		String fileName = sc.nextLine();
		SimErgy sys = LoadSave.loadSys(fileName);
		
		
		System.out.println("\n###################\n"
				+ "##### SIMERGY #####\n"
				+ "###################");
		System.out.println("\nWelcome to Simergy.\n"
				+ "This tool emulate an emergency department."
				+ "\n\nWe strongly advice you to read the help by typing 'help' to get started.");
		
		while(run){
			System.out.print("\n>>> ");
			String input = sc.nextLine();
			StringTokenizer st = new StringTokenizer(input, " ,");
			String cmd = st.countTokens()==0?"":st.nextToken();
			
			if(cmd.contentEquals("help")){
				if(st.countTokens()==1){
					help(st.nextToken());
				}else{
					help("");
				}
				
				
				
			}else if(cmd.contentEquals("save")){
				if(st.countTokens()==1){
					String name = st.nextToken();
					LoadSave.saveSys(sys,name);
					fileName = name;
				}else{
					LoadSave.saveSys(sys, fileName);
				}
					
				
			}else if(cmd.contentEquals("load")){
				System.out.println("Maybe you should save your system before loading another one...\n"
						+ "Are you sure you want to load a save ? (Type 'yes' to continue)");
				System.out.print("\n>>> ");
				Scanner confirm = new Scanner(System.in);
				if(confirm.next().equalsIgnoreCase("yes")){
					if(st.countTokens()==1){
						fileName = st.nextToken();
						sys = LoadSave.loadSys(fileName);
					}else{
						fileName = "SimErgy";
						sys = LoadSave.loadSys(fileName);
					}
				}
				
				
			}else if(cmd.contentEquals("currentSave")){
				System.out.println("Current save : " + fileName);
				
				
			}else if(cmd.contentEquals("listSaves")){
				getFilesInCurrentDirectory(new File(System.getProperty("user.dir") + "/data/"));
				
			}else if(cmd.contentEquals("quit")){
				System.out.println("Maybe you should save your system before exiting SimErgy...\n"
						+ "Are you sure you want to exit Simergy ? (Type 'yes' to continue)");
				System.out.print("\n>>> ");
				Scanner confirm = new Scanner(System.in);
				if(confirm.next().equalsIgnoreCase("yes")){
					System.out.println("Hope SimErgy has been useful ! See you next time !");
					run = false;
				}
				
				
			}else if(cmd.contentEquals("createED")){
				if(st.countTokens()==1){
					String name = st.nextToken();
					sys.getEDs().put(name,new EmergencyDept(name));
					System.out.println("New ED : "+ name + " was succesfully created and added to SimErgy.");
				}else if(st.countTokens()==0){
					System.out.println("ERROR : You need to specify your ED's name.");
				}else{
					System.out.println("ERROR : Your ED's name is invalid (It can't be composed of spaces nor comas).");
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
				if(st.countTokens()==1){
					String name = st.nextToken();
					System.out.println(sys.getEDs().get(name)==null?"ERROR : This ED doesn't exists.":displayED(sys.getEDs().get(name)));
				}else if(st.countTokens()==0){
					System.out.println("Type 'display <EDName>' to display Ed with given name.\n"
							+ "List of EDs present in the system :\n");
					for(String name : sys.getEDs().keySet()){
						System.out.println("# " + name);
					}
				}
			}else{
				System.out.println("ERROR : Command not found, maybe you should try 'help'.");
			}
		}
	}
	
	public static void main(String[] args) {
		CommandLineUserInterface.run();
	}
	
	public static void help(String param){
		if(param.contentEquals("")){
			System.out.println("Welcome into SimErgy's help.\n"
					+ "To get the full commands guide type : 'help f'.\n"
					+ "To get the save's commands guide type : 'help s'\n"
					+ "To get the ED's command guide type : 'help ed'\n"
					+ "To get help on a specific command type : 'help <commandeName>.");
			
		}if(param.contentEquals("save") || param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# save <SaveName> : saves the system's state. <SaveName> is optional (the save then will be named 'SimErgy.ser'). ");
			
		}if(param.contentEquals("load")|| param.contentEquals("f") || param.contentEquals("s")){			
			System.out.println("\n# load <SaveName> : Loads a system's state from a save. If <SaveName> is not found, a new system is instanciated.");
			
		}if(param.contentEquals("currentSave")|| param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# currentSave : displays the current save's name.");
			
		}if(param.contentEquals("listSaves")|| param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# listSaves : displays the saves found in /data.");
			
		}if(param.contentEquals("quit") || param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# quit : quits SimErgy.");
			
		}if(param.contentEquals("createED") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# createED <EDname> : creates an ED with given name.");
			
		}if(param.contentEquals("addRoom") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addRoom <EDname>,<RoomType>,<RoomName> : adds a room of given type and name to an ED with given name.");
		
		}if(param.contentEquals("addRadioService") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addRadioService <EDname>,<DistType>,<DistParams> : adds a radiology service to an ED with given name.\n"
					+ "DistType, DistParams representing the probability distribution for the service time of the radiology.\n"
					+ "See 'help distribution' for more informations.");
			
		}if(param.contentEquals("addMRI") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addMRI <EDname>,<DistType>,<DistParams> : adds a mri service to an ED with given name.\n"
					+ "DistType, DistParams representing the probability distribution for the service time of the radiology.\n"
					+ "See 'help distribution' for more informations.");
			
		}if(param.contentEquals("addBloodTest") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addBloodTest <EDname>,<DistType>,<DistParams> : adds a blood test service to an ED with given name.\n"
					+ "DistType, DistParams representing the probability distribution for the service time of the radiology.\n"
					+ "See 'help distribution' for more informations.");
			
		}if(param.contentEquals("addNurse") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("addPhysi") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL1arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL2arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL3arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL4arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL5arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("addPatient") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("registerPatient") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setPatientInsurance") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("distribution") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("display") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}
	}
	
	public static String displayED(EmergencyDept ed){
		String res ="";
		String name = ed.getName();
		String border = "";
		for(int i=0;i<name.length()+23;i++){
			border += "#";
		}
		res += border + "\n"
				+ "### Informations : " + name + " ###\n"
				+ border + "\n";
		res += "\n# Time : " + ed.getClock().computeTime() + "\n";
		res += "\n# Patients :";
		for(Patient p : ed.getPatients()){
			res += "\n### " + p;
		}
		return res;
	}
	
	private static void getFilesInCurrentDirectory(File curDir) {

		System.out.println("Saves found :");
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
            	getFilesInCurrentDirectory(f);
            if(f.isFile()){
                System.out.println("# " + f.getName());
            }
        }
	}
}
