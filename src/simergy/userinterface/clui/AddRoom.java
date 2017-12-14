package simergy.userinterface.clui;

import java.util.StringTokenizer;

import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

public class AddRoom implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	
	public AddRoom(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
		
	}
	
	public String execute(){
		
		if(st.countTokens()==2){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){	
				Resource room = ed.getResourceFactory().getRessource(st.nextToken());
				if(room!=null){
					 ed.addResource(room);
					 return(room.getName() + " was successfully added to " + ed.getName());
				}else{
					return("This kind of room doesn't exists.");
				}
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Requires 2 arguments (<EDname>,<RoomType>)");
		}
	}
	
}
