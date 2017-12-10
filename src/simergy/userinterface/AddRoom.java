package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;

public class AddRoom implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public AddRoom(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
		
	}
	
	public void execute(){
		
		if(st.countTokens()==2){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){	
				Resource room = ed.getResourceFactory().getRessource(st.nextToken());
				if(room!=null){
					 ed.addResource(room);
					 System.out.println(room.getName() + " was successfully added to " + ed.getName());
				}
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else{
			System.out.println("ERROR : Requires 2 arguments (<EDname>,<RoomType>)");
		}
	}
	
}
