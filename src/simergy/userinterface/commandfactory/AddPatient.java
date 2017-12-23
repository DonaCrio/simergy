/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.events.Workflow;
import simergy.core.patients.Patient;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddPatient.
 */
public class AddPatient implements Command{
	
	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new adds the patient.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public AddPatient(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
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
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}

}
