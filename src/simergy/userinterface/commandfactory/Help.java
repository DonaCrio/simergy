/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class Help.
 */
public class Help implements Command{
	
	/** The st. */
	private StringTokenizer st;
	
	/**
	 * Instantiates a new help.
	 *
	 * @param st the st
	 */
	public Help(StringTokenizer st){
		this.st = st;
	}

	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		
		if(st.countTokens()==0){
			return("Welcome into SimErgy's help.\n\n"
					+ "To get the full commands guide type : 'help f'.\n"
					+ "To get the save/load commands guide type : 'help s'\n"
					+ "To get the ED command guide type : 'help ed'\n"
					+ "To get the ED simulation command guide type : 'help sim'\n"
					+ "To get help on a specific command type : 'help <commandeName>.");
		}else if(st.countTokens()==1){
			String option = st.nextToken();
			String res = "";
			
			if(option.contentEquals("save") || option.contentEquals("f") || option.contentEquals("s")){
				res += "\n# save <SaveName> : saves the system's state.\n"
						+ "<SaveName> is optional (the save then will be named 'SimErgy.ser').\n";
				
			}if(option.contentEquals("load")|| option.contentEquals("f") || option.contentEquals("s")){			
				res += "\n# load <SaveName> : Loads a system's state from a save.\n"
						+ "If <SaveName> is not found, a new system is instanciated.\n";
				
			}if(option.contentEquals("currentSave")|| option.contentEquals("f") || option.contentEquals("s")){
				res += "\n# currentSave : displays the current save's name.\n";
				
			}if(option.contentEquals("listSaves")|| option.contentEquals("f") || option.contentEquals("s")){
				res += "\n# listSaves : displays the saves found in /data.\n";
				
			}if(option.contentEquals("exit") || option.contentEquals("f") || option.contentEquals("s")){
				res += "\n# exit : exits SimErgy.\n";
				
			}if(option.contentEquals("createED") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# createED <EDname> : creates a new ED with given name.\n";
				
			}if(option.contentEquals("addRoom") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addRoom <EDname>,<RoomType> : adds a room of given type to an ED with given name.\n"
						+ "<RoomType> has to be : 'BoxRoom' or 'ShockRoom'.\n";
			
			}if(option.contentEquals("addRadioService") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addRadioService <EDname>,<DistType>,<DistOptions> : adds a radiology service to an ED with given name.\n"
						+ "<DistType>, <DistOptions> representing the probability distribution for the service time of the radiology : \n"
						+ "- uniform : <DistOptions> = leftBound,rightbound\n"
						+ "- exponential : <DistOptions> = exponentialoption\n"
						+ "- deterministic : <DistOptions> = deterministicoption\n"
						+ "<DistType> and <DistOptions> are not mandatory. If not specified, the distribution will be Uniform(10,20).\n";
				
			}if(option.contentEquals("addMRI") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addMRI <EDname>,<DistType>,<DistOptions> : adds a mri service to an ED with given name.\n"
						+ "<DistType>, <DistOptions> representing the probability distribution for the service time of the mri : \n"
						+ "- uniform : <DistOptions> = leftBound,rightbound\n"
						+ "- exponential : <DistOptions> = exponentialoption\n"
						+ "- deterministic : <DistOptions> = deterministicoption\n"
						+ "<DistType> and <DistOptions> are not mandatory. If not specified, the distribution will be Uniform(30,70).\n";
				
			}if(option.contentEquals("addBloodTest") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addBloodTest <EDname>,<DistType>,<DistOptions> : adds a blood test service to an ED with given name.\n"
						+ "<DistType>, <DistOptions> representing the probability distribution for the service time of the blood test : \n"
						+ "- uniform : <DistOptions> = leftBound,rightbound\n"
						+ "- exponential : <DistOptions> = exponentialoption\n"
						+ "- deterministic : <DistOptions> = deterministicoption\n"
						+ "<DistType> and <DistOptions> are not mandatory. If not specified, the distribution will be Uniform(15,90).\n";
				
			}if(option.contentEquals("addNurse") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addNurse <EDname>,<NurseName>,<NurseSurname> : adds a nurse with given name and surname to an ED with given name.\n"
						+ "<NurseName> and <NurseSurname> are not mandatory. If not specified, the name and surname will be 'nurseN' where N is the nurse's ID.\n";
			
			}if(option.contentEquals("addPhysi") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addPhysi <EDname>,<PhysiName>,<PhysiSurname> : adds a physician with given name and surname to an ED with given name.\n"
						+ "<PhysiName> and <PhysiSurname> are not mandatory. If not specified, the name and surname will be 'physiN' where N is the physician's ID.\n";
			
			}if(option.contentEquals("addTransp") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addTransp <EDname>,<TranspName>,<TranspSurname> : adds a transporter with given name and surname to an ED with given name.\n"
						+ "<TranspName> and <TranspSurname> are not mandatory. If not specified, the name and surname will be 'transpN' where N is the physician's ID.\n";
			
			}if(option.contentEquals("setL1arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# setL1arrivalDist <EDname>,<DistType>,<DistParams> : sets the distribution of arrival for L1-patient in an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the arrival time of L1-patient : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "The initial distribution is Exponential(0.00069) : 2 patient/day.\n";
				
			}if(option.contentEquals("setL2arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# setL2arrivalDist <EDname>,<DistType>,<DistParams> : sets the distribution of arrival for L2-patient in an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the arrival time of L2-patient : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "The initial distribution is Exponential(0.00138) : 5 patient/day.\n";
				
			}if(option.contentEquals("setL3arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# setL3arrivalDist <EDname>,<DistType>,<DistParams> : sets the distribution of arrival for L3-patient in an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the arrival time of L3-patient : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "The initial distribution is Exponential(0.00276) : 10 patient/day.\n";
				
			}if(option.contentEquals("setL4arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# setL4arrivalDist <EDname>,<DistType>,<DistParams> : sets the distribution of arrival for L4-patient in an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the arrival time of L4-patient : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "The initial distribution is Exponential(0.00276) : 10 patient/day.\n";
				
			}if(option.contentEquals("setL5arrivalDist") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# setL5arrivalDist <EDname>,<DistType>,<DistParams> : sets the distribution of arrival for L5-patient in an ED with given name.\n"
						+ "<DistType>, <Distoptions> representing the probability distribution for the arrival time of L5-patient : \n"
						+ "- uniform : <Distoptions> = leftBound,rightbound\n"
						+ "- exponential : <Distoptions> = exponentialoption\n"
						+ "- deterministic : <Distoptions> = deterministicoption\n"
						+ "The initial distribution is Exponential(0.00276) : 10 patient/day.\n";
				
			}if(option.contentEquals("addPatient") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# addPatient <EDname>,<PatientName>,<PatientSurname>,<SeverityLevel>,<HealthInsurance> : registers a patient with given name and surname to an ED with given name.\n"
						+ "<SeverityLevel> representing the level of severity of the patient. It has to be : 'L1', 'L2', 'L3', 'L4' or 'L5'.\n"
						+ "<HealthInsurance> representing the health insurance of the patient. It has to be : 'GOLD', 'SILVER', 'NONE'.\n";
				
			}if(option.contentEquals("setPatientInsurance") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# setPatientInsurance <EDname>,<PatientID>,<HealthInsurance> : sets the health insurance of a patient with given ID.\n"
						+ "<HealthInsurance> has to be : 'GOLD', 'SILVER', 'NONE'.\n";
			
			}if(option.contentEquals("display") || option.contentEquals("f") || option.contentEquals("ed")){
				res += "\n# display <EDname> : displays the entire status (patients, resources, queues) of an ED with given name.\n";
			
			}if(option.contentEquals("executeEvent") || option.contentEquals("f") || option.contentEquals("ed") || option.contentEquals("sim")){
				res += "\n# executeEvent <EDname> : executes the first event in the event-queue of an ED with given name.\n";
			
			}if(option.contentEquals("simulation") || option.contentEquals("f") || option.contentEquals("ed") || option.contentEquals("sim")){
				res += "\n# simulation <Edname>,<EndTime>,<Activate> : starts a simulation of an ED with given name up to the given time.\n"
						+ "<Activate> is optional, if <Activate> == activate then the simulation will generate new patients.\n";
				
			}if(option.contentEquals("reset") || option.contentEquals("f") || option.contentEquals("ed") || option.contentEquals("sim")){
				res += "\n# reset <EDname> : resets an ED with given name (only keeps the resources).\n";
			}
			return res;
		}else{
			return("ERROR : 1 argument required, 2 were given.\n\n"
					+ "To get the full commands guide type : 'help f'.\n"
					+ "To get the save/load commands guide type : 'help s'\n"
					+ "To get the ED command guide type : 'help ed'\n"
					+ "To get the ED simulation command guide type : 'help sim'\n"
					+ "To get help on a specific command type : 'help <commandeName>.");
		}				
	}
}
