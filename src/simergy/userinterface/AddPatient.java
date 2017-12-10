package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.events.Workflow;
import simergy.core.patients.Patient;
import simergy.core.system.EmergencyDept;

public class AddPatient implements Command{
	
	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public AddPatient(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	public void execute(){
		if(st.countTokens()==5){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				String name = st.nextToken();
				String surname = st.nextToken();
				String severityLevel = st.nextToken();
				String healthInsurance = st.nextToken();
				Patient patient = new Patient(name,surname,severityLevel,healthInsurance);
				ed.addWorkflow(new Workflow(ed, patient, 0));
				System.out.println(patient.getName() + " was successfully added to " + ed.getName() + ".");
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else{
			System.out.println("ERROR : Requires 5 arguments (<EDname>,<PatientName>,<PatientSurname>,<SeverityLevel>,<HealthInsurance>).");
		}
	}

}
