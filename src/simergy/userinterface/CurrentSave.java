package simergy.userinterface;

public class CurrentSave implements Command{

	private CommandLineUserInterface clui;
	
	public CurrentSave(CommandLineUserInterface clui){
		this.clui = clui;
	}
	
	public void execute(){
		System.out.println(clui.getSys()==null?"There is no current save.":"Current save : " + clui.getSys().getName() + ".ser");
	}
}
