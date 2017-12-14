package simergy.userinterface.cmdfactory;

import java.util.StringTokenizer;

import simergy.core.events.Workflow;
import simergy.core.patients.Patient;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public class AddPatient implements Command{
	
	private StringTokenizer st;
	private UserInterface userInterface;
	
	public AddPatient(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	public String execute(){
		if(st.countTokens()==5){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				String name = st.nextToken();
				String surname = st.nextToken();
				String severityLevel = st.nextToken();
				String healthInsurance = st.nextToken();
				Patient patient = new Patient(name,surname,severityLevel,healthInsurance);
				ed.addWorkflow(new Workflow(ed, patient, 0));
				return(patient.getName() + " was successfully added to " + ed.getName() + ".");
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Requires 5 arguments (<EDname>,<PatientName>,<PatientSurname>,<SeverityLevel>,<HealthInsurance>).");
		}
	}

}
