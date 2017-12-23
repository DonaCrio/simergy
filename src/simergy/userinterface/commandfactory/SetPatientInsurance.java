/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.StringTokenizer;

import simergy.core.patients.HealthInsurance;
import simergy.core.patients.Patient;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class SetPatientInsurance.
 */
public class SetPatientInsurance implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new sets the patient insurance.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public SetPatientInsurance(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
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
