/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class ExecuteEvent.
 */
public class ExecuteEvent implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new execute event.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public ExecuteEvent(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				ArrayList<Double> KPIs = userInterface.getSys().executeNextEvent(ed);
				return("\n# Key performance indicators for ED : " + ed.getName() + "\n"
						+ "### Patients Released : " + KPIs.get(0) + "/" + KPIs.get(1) + "\n"
						+ "### DTDT = " +  KPIs.get(2) + "\n"
						+ "### LOS = " + KPIs.get(3));
			}else{
				return("ERROR : This ED doesn't exists.");
			}
			
		}else{
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}
}
