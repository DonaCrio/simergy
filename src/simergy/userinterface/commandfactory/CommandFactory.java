package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.system.SimErgy;
import simergy.userinterface.intefaces.CommandLineUserInterface;
import simergy.userinterface.intefaces.UserInterface;

public class CommandFactory {
	
	private UserInterface userInterface;
	
	public CommandFactory(UserInterface userInterface){
		this.userInterface = userInterface;
	}

	public Command getCommand(StringTokenizer st){
		if(userInterface.getSys()==null){
			userInterface.setSys(new SimErgy("default"));
		}
		if(st.countTokens()>0){
			
			String cmd = st.nextToken();
			
			if(cmd.contentEquals("help")){
				return new Help(st);
				
			}else if(cmd.contentEquals("save")){
				return new Save(st,userInterface);
				
			}else if(cmd.contentEquals("load")){
				if(userInterface instanceof CommandLineUserInterface){
					return new Load(st,userInterface,true);
				}else{
					return new Load(st,userInterface,false);
				}
				
				
			}else if(cmd.contentEquals("listSaves")){
				return new ListSaves(userInterface);				
				
			}else if(cmd.contentEquals("currentSave")){
				return new CurrentSave(userInterface);			
				
			}else if(cmd.contentEquals("exit")){
				return new Exit(userInterface);
			
			}else if(cmd.contentEquals("display")){
				return new Display(st,userInterface);
				
			}else if(cmd.contentEquals("createED")){
				return new CreateED(st,userInterface);
				
			}else if(cmd.contentEquals("addRoom")){
				return new AddRoom(st,userInterface);	
				
			}else if(cmd.contentEquals("addRadioService")){
				return new AddRadioService(st,userInterface);
				
			}else if(cmd.contentEquals("addMRI")){
				return new AddMRI(st,userInterface);
				
			}else if(cmd.contentEquals("addBloodTest")){
				return new AddBloodTest(st,userInterface);
				
			}else if(cmd.contentEquals("addNurse")){
				return new AddNurse(st,userInterface);
				
			}else if(cmd.contentEquals("addTransp")){
				return new AddTransp(st,userInterface);
				
			}else if(cmd.contentEquals("addPhysi")){
				return new AddPhysi(st,userInterface);
				
			}else if(cmd.contentEquals("setL1arrivalDist")){
				return new SetL1ArrivalDist(st,userInterface);
				
			}else if(cmd.contentEquals("setL2arrivalDist")){
				return new SetL2ArrivalDist(st,userInterface);
				
			}else if(cmd.contentEquals("setL3arrivalDist")){
				return new SetL3ArrivalDist(st,userInterface);
				
			}else if(cmd.contentEquals("setL4arrivalDist")){
				return new SetL4ArrivalDist(st,userInterface);
				
			}else if(cmd.contentEquals("setL5arrivalDist")){
				return new SetL4ArrivalDist(st,userInterface);
				
			}else if(cmd.contentEquals("addPatient")){
				return new AddPatient(st,userInterface);
			
			}else if(cmd.contentEquals("setPatientInsurance")){
				return new SetPatientInsurance(st,userInterface);
				
			}else if(cmd.contentEquals("executeEvent")){
				return new ExecuteEvent(st,userInterface);	
				
			}else if(cmd.contentEquals("simulation")){
				return new Simulation(st,userInterface);
				
			}else if(cmd.contentEquals("reset")){
				return new Reset(st,userInterface);
				
			}else if(cmd.contentEquals("selectED")){
				return new SelectED(st,userInterface);
				
			}else{
				return new NullCommand();
			}
			
		}else{
			return new NullCommand();
		}
	}

	public UserInterface getUserInterface() {
		return userInterface;
	}	
	
}
