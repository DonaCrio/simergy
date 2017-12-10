package simergy.userinterface;

import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;

public class Reset implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public Reset(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	public void execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				clui.getSys().reset(ed);
				System.out.println(ed.getName() + " was successfully reset.");
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else{
			System.out.println("ERROR : Requires 1 arguments (<EDname>).");
		}
	}
}
