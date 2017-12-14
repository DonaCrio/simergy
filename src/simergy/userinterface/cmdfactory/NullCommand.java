package simergy.userinterface.cmdfactory;

public class NullCommand implements Command{

	public String execute(){
		return "Command not found.\n"
				+ "Type 'help f' to see the list of all commands.";
	};
}
