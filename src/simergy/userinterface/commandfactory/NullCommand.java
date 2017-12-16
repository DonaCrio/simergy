package simergy.userinterface.commandfactory;

public class NullCommand implements Command{

	public String execute(){
		return("Command not found, consult the help for more informations");
	};
}
