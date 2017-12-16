package simergy.userinterface.commandfactory;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public class ExecuteEvent implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public ExecuteEvent(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
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
