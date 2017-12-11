package simergy.userinterface;

import java.util.StringTokenizer;

public class CommandFactory {
	
	private CommandLineUserInterface clui;
	
	public CommandFactory(CommandLineUserInterface clui){
		this.clui = clui;
	}

	public Command getCommand(StringTokenizer st){
		
		if(st.countTokens()>0){
			
			String cmd = st.nextToken();
			
			if(cmd.contentEquals("help")){
				return new Help(st);
				
			}else if(cmd.contentEquals("save")){
				return new Save(st,clui);
				
			}else if(cmd.contentEquals("load")){
				return new Load(st,clui);
				
			}else if(cmd.contentEquals("listSaves")){
				return new ListSaves(clui);				
				
			}else if(cmd.contentEquals("currentSave")){
				return new CurrentSave(clui);			
				
			}else if(cmd.contentEquals("exit")){
				return new Exit(clui);
			
			}else if(cmd.contentEquals("display")){
				return new Display(st,clui);
				
			}else if(cmd.contentEquals("createED")){
				return new CreateED(st,clui);
				
			}else if(cmd.contentEquals("addRoom")){
				return new AddRoom(st,clui);	
				
			}else if(cmd.contentEquals("addRadioService")){
				return new AddRadioService(st,clui);
				
			}else if(cmd.contentEquals("addMRI")){
				return new AddMRI(st,clui);
				
			}else if(cmd.contentEquals("addBloodTest")){
				return new AddBloodTest(st,clui);
				
			}else if(cmd.contentEquals("addNurse")){
				return new AddNurse(st,clui);
				
			}else if(cmd.contentEquals("addTransp")){
				return new AddTransp(st,clui);
				
			}else if(cmd.contentEquals("addPhysi")){
				return new AddPhysi(st,clui);
				
			}else if(cmd.contentEquals("setL1arrivalDist")){
				return new SetL1ArrivalDist(st,clui);
				
			}else if(cmd.contentEquals("setL2arrivalDist")){
				return new SetL2ArrivalDist(st,clui);
				
			}else if(cmd.contentEquals("setL3arrivalDist")){
				return new SetL3ArrivalDist(st,clui);
				
			}else if(cmd.contentEquals("setL4arrivalDist")){
				return new SetL4ArrivalDist(st,clui);
				
			}else if(cmd.contentEquals("setL5arrivalDist")){
				return new SetL4ArrivalDist(st,clui);
				
			}else if(cmd.contentEquals("addPatient")){
				return new AddPatient(st,clui);
			
			
			}else if(cmd.contentEquals("setPatientInsurance")){
				return new SetPatientInsurance(st,clui);
				
			}else if(cmd.contentEquals("executeEvent")){
				return new ExecuteEvent(st,clui);	
				
			}else if(cmd.contentEquals("simulation")){
				return new Simulation(st,clui);
				
			}else if(cmd.contentEquals("reset")){
				return new Reset(st,clui);
				
			}else{
				return new NullCommand();
			}
			
		}else{
			return new NullCommand();
		}
	}

	public CommandLineUserInterface getClui() {
		return clui;
	}	
	
}
