package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.resources.HumanResource;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;

public abstract class AddHumanResource implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	private String type;
	
	public AddHumanResource(StringTokenizer st, CommandLineUserInterface clui, String type){
		this.st = st;
		this.clui = clui;
		this.type = type;
	}
	
	public void execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource human = ed.getResourceFactory().getRessource(type);
				ed.addResource(human);
				System.out.println(human.getName() + " was successfully added to " + ed.getName() + ".");
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else if(st.countTokens()==3){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource human = ed.getResourceFactory().getRessource(type);
				String name = st.nextToken();
				String surname = st.nextToken();
				((HumanResource)human).setName(name);
				((HumanResource)human).setSurname(surname);
				ed.addResource(human);
				System.out.println(human.getName() + " was successfully added to " + ed.getName() + ".");
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else{
			System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<NurseName>,<NurseSurname>).");
		}
	}
}
