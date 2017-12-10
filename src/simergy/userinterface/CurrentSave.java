package simergy.userinterface;

public class CurrentSave implements Command{

	private CommandLineUserInterface clui;
	
	public CurrentSave(CommandLineUserInterface clui){
		this.clui = clui;
	}
	
	public void execute(){
		System.out.println("Current save : " + clui.getSys().getName() + ".ser");
	}
}
