package simergy.userinterface.commandfactory;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.events.Event;
import simergy.core.patients.Patient;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.CommandLineUserInterface;
import simergy.userinterface.intefaces.UserInterface;

public class Display implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	private int nbBorder;
	
	public Display(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
		this.nbBorder = (userInterface instanceof CommandLineUserInterface)?23:19;
	}
	
	public String execute(){
		
		if(st.countTokens()==1){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			
			if(ed!=null){
				String res ="";
				String name = ed.getName();
				String border = "";
				for(int i=0;i<name.length()+nbBorder;i++){
					border += "#";
				}
				res += border + "\n"
						+ "### Informations : " + name + " ###\n"
						+ border;
				res += "\n\n# Time : " + ed.getTime();
				res += "\n\n# Resources :";
				for(String resourceType : ed.getResources().keySet()){
					res += "\n### " + resourceType + " (" + ed.getResources().get(resourceType).size() + ") : ";
					for(Resource r : ed.getResources().get(resourceType)){
						res += r.getName() + ", ";
					}
				}
				res += "\n\n# Patients (" + ed.getPatients().size() + ") :";
				for(Patient p : ed.getPatients()){
					res += "\n### " + p;
				}
				ed.getPatientGenerator().setEnableGen(false);
				ArrayList<Integer> enabledEvents = userInterface.getSys().updateEnabledEvents(ed);
				ArrayList<Event> eventQueue = userInterface.getSys().updateEventQueue(enabledEvents, ed);
				res += "\n\n# Events in queue (" + eventQueue.size() + ") :";
				for(Event e : eventQueue){
					res += "\n### " + e;
				}
				return(res);
				
			}else{
				String res = "ERROR : This ED doesn't exist.\n"
						+ "List of EDs present in the system :\n";
				for(String n : userInterface.getSys().getEDs().keySet()){
					res += "# " + n;
				}
				return res;
			}
			
		}else{
			String res = "Type 'display <EDName>' to display Ed with given name.\n"
					+ "List of EDs present in the system :\n";
			for(String name : userInterface.getSys().getEDs().keySet()){
				res += "# " + name + "\n";
			}
			return res;
		}
	}
}
