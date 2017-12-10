package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.patients.Patient;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;

public class Display implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public Display(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	
	

	public void execute(){
		
		if(st.countTokens()==1){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			
			if(ed!=null){
				String res ="";
				String name = ed.getName();
				String border = "";
				for(int i=0;i<name.length()+23;i++){
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
				System.out.println(res);
				
			}else{
				System.out.println("ERROR : This ED doesn't exist.\n"
						+ "List of EDs present in the system :\n");
				for(String n : clui.getSys().getEDs().keySet()){
					System.out.println("# " + n);
				}
			}
			
		}else{
			System.out.println("Type 'display <EDName>' to display Ed with given name.\n"
					+ "List of EDs present in the system :\n");
			for(String name : clui.getSys().getEDs().keySet()){
				System.out.println("# " + name);
			}
		}
	}
}
