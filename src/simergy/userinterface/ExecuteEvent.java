package simergy.userinterface;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;

public class ExecuteEvent implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public ExecuteEvent(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	public void execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				ArrayList<Double> KPIs = clui.getSys().executeNextEvent(ed);
				System.out.println("\n# Key performance indicators for ED : " + ed.getName() + "\n"
						+ "### Patients Released : " + KPIs.get(0) + "/" + KPIs.get(1) + "\n"
						+ "### DTDT = " +  KPIs.get(2) + "\n"
						+ "### LOS = " + KPIs.get(3));
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
			
		}else{
			System.out.println("Type 'executeEvent <EDName> to execute next Event in the Ed with given name.\n"
					+ "List of EDs present in the system :\n");
			for(String name : clui.getSys().getEDs().keySet()){
				System.out.println("# " + name);
			}
		}
	}
}
