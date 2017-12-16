package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.patients.HealthInsurance;
import simergy.core.patients.Patient;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public class SetPatientInsurance implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public SetPatientInsurance(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	public String execute(){
		if(st.countTokens()==3){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				try{
					int id = Integer.parseInt(st.nextToken());
					Patient p = ed.getPatients().get(id);
					String healthInsurance = st.nextToken();
					p.setHealthInsurance(HealthInsurance.getHealthInsurance(healthInsurance));
					return(p.getName() + "'s health insurance was successfully set");
				}catch(NumberFormatException e){
					return("ERROR : <PatientID> must be an integer.");
				}catch(NullPointerException e){
					return("ERROR : This Patient doesn't exists.");
				}
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}
}
