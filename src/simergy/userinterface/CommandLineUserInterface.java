package simergy.userinterface;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import simergy.core.system.*;
import simergy.core.patients.*;
import simergy.core.resources.*;
import simergy.core.events.*;

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
				+ "This tool emulates an emergency department."
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
				
				
			}else if(cmd.contentEquals("exit")){
				System.out.println("Maybe you should save your system before exiting SimErgy...\n"
						+ "Are you sure you want to exit Simergy ? (Type 'yes' to continue)");
				System.out.print("\n>>> ");
				Scanner confirm = new Scanner(System.in);
				if(confirm.next().equalsIgnoreCase("yes")){
					confirm.close();
					System.out.println("Hope SimErgy has been useful ! See you next time !");
					sc.close();
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
				if(st.countTokens()==2){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){	
						Resource room = ed.getResourceFactory().getRessource(st.nextToken());
						if(room!=null){
							 ed.addResource(room);
							 System.out.println(room.getName() + " was successfully added to " + ed.getName());
						}
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 2 arguments (<EDname>,<RoomType>)");
				}
				
				
			}else if(cmd.contentEquals("addRadioService")){
				if(st.countTokens()==1){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource service = ed.getResourceFactory().getRessource("RADIOGRAPHY");
						ed.addResource(service);
						System.out.println(service.getName() + " was successfully added to " + ed.getName() + ".\n"
								+ "Distribution was set Uniform(10,20)");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else if(st.countTokens()>=3){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource service = ed.getResourceFactory().getRessource("RADIOGRAPHY");
						String type = st.nextToken();
						ArrayList<Double> params = new ArrayList<Double>();
						try{
							for(int i=0;i<st.countTokens();i++){
								params.add(Double.parseDouble(st.nextToken()));
							}
						}catch(NumberFormatException e){
							System.out.println("ERROR : <DistParams> must be integers or doubles.");
						}
						
						boolean done = ((HealthService)service).createDistribution(type,params);
						ed.addResource(service);
						System.out.println(service.getName() + " was successfully added to " + ed.getName() 
							+ (done?" with the given distribution":" but the distribution's informations were wrong.\n"
									+ "Distribution was set Uniform(10,20)"));
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<DistType>,<DistParams>).");
				}
				
				
			}else if(cmd.contentEquals("addMRI")){
				if(st.countTokens()==1){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource service = ed.getResourceFactory().getRessource("MRI");
						ed.addResource(service);
						System.out.println(service.getName() + " was successfully added to " + ed.getName() + ".\n"
								+ "Distribution was set Uniform(30,70)");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else if(st.countTokens()>=3){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource service = ed.getResourceFactory().getRessource("MRI");
						String type = st.nextToken();
						ArrayList<Double> params = new ArrayList<Double>();
						try{
							for(int i=0;i<st.countTokens();i++){
								params.add(Double.parseDouble(st.nextToken()));
							}
						}catch(NumberFormatException e){
							System.out.println("ERROR : <DistParams> must be integers or doubles.");
						}
						
						boolean done = ((HealthService)service).createDistribution(type,params);
						ed.addResource(service);
						System.out.println(service.getName() + " was successfully added to " + ed.getName() 
							+ (done?" with the given distribution":" but the distribution's informations were wrong.\n"
									+ "Distribution was set Uniform(30,70)"));
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<DistType>,<DistParams>).");
				}
				
				
			}else if(cmd.contentEquals("addBloodTest")){
				if(st.countTokens()==1){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource service = ed.getResourceFactory().getRessource("BLOODTEST");
						ed.addResource(service);
						System.out.println(service.getName() + " was successfully added to " + ed.getName() + ".\n"
								+ "Distribution was set Uniform(15,90)");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else if(st.countTokens()>=3){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource service = ed.getResourceFactory().getRessource("BLOODTEST");
						String type = st.nextToken();
						ArrayList<Double> params = new ArrayList<Double>();
						try{
							for(int i=0;i<st.countTokens();i++){
								params.add(Double.parseDouble(st.nextToken()));
							}
						}catch(NumberFormatException e){
							System.out.println("ERROR : <DistParams> must be integers or doubles.");
						}
						
						boolean done = ((HealthService)service).createDistribution(type,params);
						ed.addResource(service);
						System.out.println(service.getName() + " was successfully added to " + ed.getName() 
							+ (done?" with the given distribution":" but the distribution's informations were wrong.\n"
									+ "Distribution was set Uniform(15,90)"));
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<DistType>,<DistParams>).");
				}
				
				
			}else if(cmd.contentEquals("addNurse")){
				if(st.countTokens()==1){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource nurse = ed.getResourceFactory().getRessource("NURSE");
						ed.addResource(nurse);
						System.out.println(nurse.getName() + " was successfully added to " + ed.getName() + ".");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else if(st.countTokens()==3){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource nurse = ed.getResourceFactory().getRessource("NURSE");
						String name = st.nextToken();
						String surname = st.nextToken();
						((HumanResource)nurse).setName(name);
						((HumanResource)nurse).setSurname(surname);
						ed.addResource(nurse);
						System.out.println(nurse.getName() + " was successfully added to " + ed.getName() + ".");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<NurseName>,<NurseSurname>).");
				}
				
				
			}else if(cmd.contentEquals("addTransp")){
				if(st.countTokens()==1){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource transp = ed.getResourceFactory().getRessource("TRANSPORTER");
						ed.addResource(transp);
						System.out.println(transp.getName() + " was successfully added to " + ed.getName() + ".");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else if(st.countTokens()==3){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource transp = ed.getResourceFactory().getRessource("TRANSPORTER");
						String name = st.nextToken();
						String surname = st.nextToken();
						((HumanResource)transp).setName(name);
						((HumanResource)transp).setSurname(surname);
						ed.addResource(transp);
						System.out.println(transp.getName() + " was successfully added to " + ed.getName() + ".");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<NurseName>,<NurseSurname>).");
				}
				
				
			}else if(cmd.contentEquals("addPhysi")){
				if(st.countTokens()==1){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource physi = ed.getResourceFactory().getRessource("PHYSICIAN");
						ed.addResource(physi);
						System.out.println(physi.getName() + " was successfully added to " + ed.getName() + ".");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else if(st.countTokens()==3){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						Resource physi = ed.getResourceFactory().getRessource("PHYSICIAN");
						String name = st.nextToken();
						String surname = st.nextToken();
						((HumanResource)physi).setName(name);
						((HumanResource)physi).setSurname(surname);
						ed.addResource(physi);
						System.out.println(physi.getName() + " was successfully added to " + ed.getName() + ".");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<PhysiName>,<PhysiSurname>).");
				}
				
				
			}else if(cmd.contentEquals("setL1arrivalDist")){
				
				
			}else if(cmd.contentEquals("setL2arrivalDist")){
				
				
			}else if(cmd.contentEquals("setL3arrivalDist")){
				
				
			}else if(cmd.contentEquals("setL4arrivalDist")){
				
				
			}else if(cmd.contentEquals("setL5arrivalDist")){
				
				
			}else if(cmd.contentEquals("addPatient")){
				if(st.countTokens()==5){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						String name = st.nextToken();
						String surname = st.nextToken();
						String severityLevel = st.nextToken();
						String healthInsurance = st.nextToken();
						Patient patient = new Patient(name,surname,severityLevel,healthInsurance);
						ed.addWorkflow(new Workflow(ed, patient));
						System.out.println(patient.getName() + " was successfully added to " + ed.getName() + ".");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 5 arguments (<EDname>,<PatientName>,<PatientSurname>,<SeverityLevel>,<HealthInsurance>).");
				}
				
				
			}else if(cmd.contentEquals("setPatientInsurance")){
				if(st.countTokens()==3){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						try{
							int id = Integer.parseInt(st.nextToken());
							Patient p = ed.getPatients().get(id);
							String healthInsurance = st.nextToken();
							p.setHealthInsurance(HealthInsurance.getHealthInsurance(healthInsurance));
							System.out.println(p.getName() + "'s health insurance was successfully set");
						}catch(NumberFormatException e){
							System.out.println("ERROR : <PatientID> must be an integer.");
						}catch(NullPointerException e){
							System.out.println("ERROR : This Patient doesn't exists.");
						}
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 3 arguments (<EDname>,<PatientID>,<HealthInsurance>).");
				}
				
			}else if(cmd.contentEquals("simulate")){
				if(st.countTokens()==2){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						try{
							int endTime = Integer.parseInt(st.nextToken());
							ArrayList<Double> KPIs = sys.simulation(ed, endTime);
							System.out.println("\n# Key performance indicators for ED : " + ed.getName() + "\n"
									+ "### Patients Released : " + KPIs.get(2) + "/" + ed.getWorkflows().size() + "\n"
									+ "### DTDT = " +  KPIs.get(0) + "\n"
									+ "### LOS = " + KPIs.get(1));
						}catch(NumberFormatException e){
							System.out.println("ERROR : <SimulationTime> must be an integer.");
						}
						
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
					
				}else{
					System.out.println("Type 'simulation <EDName>,<SimulationTime>' to simulate Ed with given name during given time.\n"
							+ "List of EDs present in the system :\n");
					for(String name : sys.getEDs().keySet()){
						System.out.println("# " + name);
					}
				}
				
				
			}else if(cmd.contentEquals("reset")){
				if(st.countTokens()==1){
					EmergencyDept ed = sys.getEDs().get(st.nextToken());
					if(ed!=null){
						sys.reset(ed);
						System.out.println(ed.getName() + " was successfully reset.");
					}else{
						System.out.println("ERROR : This ED doesn't exists.");
					}
				}else{
					System.out.println("ERROR : Requires 1 arguments (<EDname>).");
				}
				
			}else if(cmd.contentEquals("display")){
				if(st.countTokens()==1){
					String name = st.nextToken();
					System.out.println(sys.getEDs().get(name)==null?"ERROR : This ED doesn't exists.":displayED(sys.getEDs().get(name)));
				}else{
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
					+ "To get the save/load commands guide type : 'help s'\n"
					+ "To get the ED command guide type : 'help ed'\n"
					+ "To get the ED simulation command guide type : 'help sim'\n"
					+ "To get help on a specific command type : 'help <commandeName>.");
			
		}if(param.contentEquals("save") || param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# save <SaveName> : saves the system's state. <SaveName> is optional (the save then will be named 'SimErgy.ser'). ");
			
		}if(param.contentEquals("load")|| param.contentEquals("f") || param.contentEquals("s")){			
			System.out.println("\n# load <SaveName> : Loads a system's state from a save. If <SaveName> is not found, a new system is instanciated.");
			
		}if(param.contentEquals("currentSave")|| param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# currentSave : displays the current save's name.");
			
		}if(param.contentEquals("listSaves")|| param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# listSaves : displays the saves found in /data.");
			
		}if(param.contentEquals("exit") || param.contentEquals("f") || param.contentEquals("s")){
			System.out.println("\n# exit : exitss SimErgy.");
			
		}if(param.contentEquals("createED") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# createED <EDname> : creates an ED with given name.");
			
		}if(param.contentEquals("addRoom") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addRoom <EDname>,<RoomType> : adds a room of given type to an ED with given name :\n"
					+ "-boxRoom\n"
					+ "-shockRoom");
		
		}if(param.contentEquals("addRadioService") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addRadioService <EDname>,<DistType>,<DistParams> : adds a radiology service to an ED with given name.\n"
					+ "<DistType>, <DistParams> representing the probability distribution for the service time of the radiology : \n"
					+ "- uniform : <DistParams> = leftBound,rightbound\n"
					+ "- exponential : <DistParams> = exponentialParam\n"
					+ "- deterministic : <DistParams> = deterministicParam\n"
					+ "<DistType> and <DistParams> are not mandatory. If not specified, the distribution will be Uniform(10,20)");
			
		}if(param.contentEquals("addMRI") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addMRI <EDname>,<DistType>,<DistParams> : adds a mri service to an ED with given name.\n"
					+ "<DistType>, <DistParams> representing the probability distribution for the service time of the mri : \n"
					+ "- uniform : <DistParams> = leftBound,rightbound\n"
					+ "- exponential : <DistParams> = exponentialParam\n"
					+ "- deterministic : <DistParams> = deterministicParam\n"
					+ "<DistType> and <DistParams> are not mandatory. If not specified, the distribution will be Uniform(30,70)");
			
		}if(param.contentEquals("addBloodTest") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addBloodTest <EDname>,<DistType>,<DistParams> : adds a blood test service to an ED with given name.\n"
					+ "<DistType>, <DistParams> representing the probability distribution for the service time of the blood test : \n"
					+ "- uniform : <DistParams> = leftBound,rightbound\n"
					+ "- exponential : <DistParams> = exponentialParam\n"
					+ "- deterministic : <DistParams> = deterministicParam\n"
					+ "<DistType> and <DistParams> are not mandatory. If not specified, the distribution will be Uniform(15,90)");
			
		}if(param.contentEquals("addNurse") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("addNurse <EDname>,<NurseName>,<NurseSurname> : adds a nurse with given name and surname to an ED with given name.\n"
					+ "<NurseName> and <NurseSurname> are not mandatory. If not specified, the name and surname will be 'nurseN' where N is the nurse's ID");
		
		}if(param.contentEquals("addPhysi") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("addPhysi <EDname>,<PhysiName>,<PhysiSurname> : adds a physician with given name and surname to an ED with given name.\n"
					+ "<PhysiName> and <PhysiSurname> are not mandatory. If not specified, the name and surname will be 'physiN' where N is the physician's ID");
		
		}if(param.contentEquals("setL1arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL2arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL3arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL4arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("setL5arrivalDist") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("addPatient") || param.contentEquals("f") || param.contentEquals("ed")){
			System.out.println("\n# addPatient <EDname>,<PatientName>,<PatientSurname>,<SeverityLevel>,<HealthInsurance> : registers a patient with given name and surname to an ED with given name.\n"
					+ "<SeverityLevel> representing the level of severity of the patient. It has to be : 'L1', 'L2', 'L3', 'L4' or 'L5'.\n"
					+ "<HealthInsurance> representing the health insurance of the patient. It has to be : 'GOLD', 'SILVER', 'NONE'.");
			
		}if(param.contentEquals("setPatientInsurance") || param.contentEquals("f") || param.contentEquals("ed")){
			
		}if(param.contentEquals("display") || param.contentEquals("f") || param.contentEquals("ed")){
		
		}if(param.contentEquals("simulation") || param.contentEquals("f") || param.contentEquals("ed") || param.contentEquals("sim")){
			
		}if(param.contentEquals("reset") || param.contentEquals("f") || param.contentEquals("ed") || param.contentEquals("sim")){
			
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
				+ border;
		res += "\n\n# Time : " + ed.getClock().computeTime();
		res += "\n\n# Patients (" + ed.getPatients().size() + ") :";
		for(Patient p : ed.getPatients()){
			res += "\n### " + p;
		}
		res += "\n\n# Resources :";
		for(String resourceType : ed.getResources().keySet()){
			res += "\n### " + resourceType + " (" + ed.getResources().get(resourceType).size() + ") : ";
			for(Resource r : ed.getResources().get(resourceType)){
				res += r.getName() + ", ";
			}
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
