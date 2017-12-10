package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.patients.HealthInsurance;
import simergy.core.patients.Patient;
import simergy.core.system.EmergencyDept;

public class SetPatientInsurance implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public SetPatientInsurance(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	public void execute(){
		if(st.countTokens()==3){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
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
	}
}
