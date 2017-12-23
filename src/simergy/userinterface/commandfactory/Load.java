/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.Scanner;
import java.util.StringTokenizer;

import simergy.userinterface.intefaces.LoadSave;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class Load.
 */
public class Load implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/** The confirm. */
	private boolean confirm;
	
	/**
	 * Instantiates a new load.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 * @param confirm the confirm
	 */
	public Load(StringTokenizer st, UserInterface userInterface, boolean confirm){
		this.st = st;
		this.userInterface = userInterface;
		this.confirm = confirm;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		if(confirm){
			System.out.println("Maybe you should save your system before loading another one...\n"
					+ "Are you sure you want to load a save ? (Type 'yes' to continue)");
			System.out.print("\n>>> ");
			Scanner input = new Scanner(System.in);
			if(input.next().equalsIgnoreCase("yes")){
				if(st.countTokens()==1){
					userInterface.setSys(LoadSave.loadSys(st.nextToken()));
				}else{
					userInterface.setSys(LoadSave.loadSys(""));
				}
			}
		}else{
			if(st.countTokens()==1){
				userInterface.setSys(LoadSave.loadSys(st.nextToken()));
			}else{
				userInterface.setSys(LoadSave.loadSys(""));
			}
		}
		
		return "";
	}
}
