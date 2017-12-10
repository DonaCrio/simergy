package simergy.userinterface;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Load implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public Load(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	public void execute(){
		System.out.println("Maybe you should save your system before loading another one...\n"
				+ "Are you sure you want to load a save ? (Type 'yes' to continue)");
		System.out.print("\n>>> ");
		Scanner confirm = new Scanner(System.in);
		if(confirm.next().equalsIgnoreCase("yes")){
			if(st.countTokens()==1){
				clui.setSys(LoadSave.loadSys(st.nextToken()));
			}else{
				clui.setSys(LoadSave.loadSys(""));
			}
		}
	}
}
