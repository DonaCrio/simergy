package simergy.userinterface;

import java.util.StringTokenizer;

public class Help implements Command{
	
	private StringTokenizer st;
	
	public Help(StringTokenizer st){
		this.st = st;
	}

	public void execute(){
		
		if(st.countTokens()==0){
			System.out.println("Welcome into SimErgy's help.\n\n"
					+ "To get the full commands guide type : 'help f'.\n"
					+ "To get the save/load commands guide type : 'help s'\n"
					+ "To get the ED command guide type : 'help ed'\n"
					+ "To get the ED simulation command guide type : 'help sim'\n"
					+ "To get help on a specific command type : 'help <commandeName>.");
		}else if(st.countTokens()==1){
			String option = st.nextToken();
			
			if(option.contentEquals("save") || option.contentEquals("f") || option.contentEquals("s")){
				System.out.println("\n# save <SaveName> : saves the system's state. <SaveName> is optional (the save then will be named 'SimErgy.ser'). ");
				
			}if(option.contentEquals("load")|| option.contentEquals("f") || option.contentEquals("s")){			
				System.out.println("\n# load <SaveName> : Loads a system's state from a save. If <SaveName> is not found, a new system is instanciated.");
				
			}if(option.contentEquals("currentSave")|| option.contentEquals("f") || option.contentEquals("s")){
				System.out.println("\n# currentSave : displays the current save's name.");
				
			}if(option.contentEquals("listSaves")|| option.contentEquals("f") || option.contentEquals("s")){
				System.out.println("\n# listSaves : displays the saves found in /data.");
				
			}if(option.contentEquals("exit") || option.contentEquals("f") || option.contentEquals("s")){
				System.out.println("\n# exit : exitss SimErgy.");
				
			}if(option.contentEquals("createED") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# createED <EDname> : creates an ED with given name.");
				
			}if(option.contentEquals("addRoom") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# addRoom <EDname>,<RoomType> : adds a room of given type to an ED with given name :\n"
						+ "-boxRoom\n"
						+ "-shockRoom");
			
			}if(option.contentEquals("addRadioService") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# addRadioService <EDname>,<DistType>,<Distoptions> : adds a radiology service to an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the service time of the radiology : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "<DistType> and <Distoptions> are not mandatory. If not specified, the distribution will be Uniform(10,20)");
				
			}if(option.contentEquals("addMRI") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# addMRI <EDname>,<DistType>,<Distoptions> : adds a mri service to an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the service time of the mri : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "<DistType> and <Distoptions> are not mandatory. If not specified, the distribution will be Uniform(30,70)");
				
			}if(option.contentEquals("addBloodTest") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# addBloodTest <EDname>,<DistType>,<Distoptions> : adds a blood test service to an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the service time of the blood test : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "<DistType> and <Distoptions> are not mandatory. If not specified, the distribution will be Uniform(15,90)");
				
			}if(option.contentEquals("addNurse") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# addNurse <EDname>,<NurseName>,<NurseSurname> : adds a nurse with given name and surname to an ED with given name.\n"
						+ "<NurseName> and <NurseSurname> are not mandatory. If not specified, the name and surname will be 'nurseN' where N is the nurse's ID");
			
			}if(option.contentEquals("addPhysi") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# addPhysi <EDname>,<PhysiName>,<PhysiSurname> : adds a physician with given name and surname to an ED with given name.\n"
						+ "<PhysiName> and <PhysiSurname> are not mandatory. If not specified, the name and surname will be 'physiN' where N is the physician's ID");
			
			}if(option.contentEquals("setL1arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				
			}if(option.contentEquals("setL2arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				
			}if(option.contentEquals("setL3arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				
			}if(option.contentEquals("setL4arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				
			}if(option.contentEquals("setL5arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				
			}if(option.contentEquals("addPatient") || option.contentEquals("f") || option.contentEquals("ed")){
				System.out.println("\n# addPatient <EDname>,<PatientName>,<PatientSurname>,<SeverityLevel>,<HealthInsurance> : registers a patient with given name and surname to an ED with given name.\n"
						+ "<SeverityLevel> representing the level of severity of the patient. It has to be : 'L1', 'L2', 'L3', 'L4' or 'L5'.\n"
						+ "<HealthInsurance> representing the health insurance of the patient. It has to be : 'GOLD', 'SILVER', 'NONE'.");
				
			}if(option.contentEquals("setPatientInsurance") || option.contentEquals("f") || option.contentEquals("ed")){
				
			}if(option.contentEquals("display") || option.contentEquals("f") || option.contentEquals("ed")){
			
			}if(option.contentEquals("simulation") || option.contentEquals("f") || option.contentEquals("ed") || option.contentEquals("sim")){
				
			}if(option.contentEquals("reset") || option.contentEquals("f") || option.contentEquals("ed") || option.contentEquals("sim")){
				
			}
		}else{
			System.out.println("ERROR : 1 argument required, 2 were given.\n\n"
					+ "To get the full commands guide type : 'help f'.\n"
					+ "To get the save/load commands guide type : 'help s'\n"
					+ "To get the ED command guide type : 'help ed'\n"
					+ "To get the ED simulation command guide type : 'help sim'\n"
					+ "To get help on a specific command type : 'help <commandeName>.");
		}				
	}
}
