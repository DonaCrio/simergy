package simergy.userinterface;

import java.util.StringTokenizer;

public class Save implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public Save(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
		
	}
	
	public void execute(){
		if(st.countTokens()==1){
			LoadSave.saveSys(clui.getSys(), st.nextToken());
		}else{
			LoadSave.saveSys(clui.getSys(), clui.getSys().getName());
		}
		
	}

}
