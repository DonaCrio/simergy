/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.core.system.SimErgy;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class Simulation.
 */
public class Simulation implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/**
	 * Instantiates a new simulation.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 */
	public Simulation(StringTokenizer st, UserInterface userInterface){
		this.st = st;
		this.userInterface = userInterface;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		SimErgy sys = userInterface.getSys();
		if(st.countTokens()==3){
			EmergencyDept ed = sys.getEDs().get(st.nextToken());
			if(ed!=null){
				try{
					int endTime = Integer.parseInt(st.nextToken());
					boolean enableGen = st.nextToken().equalsIgnoreCase("ACTIVATE");
					ArrayList<Double> KPIs = sys.simulation(ed, endTime, enableGen);
					return("\n# Key performance indicators for ED : " + ed.getName() + "\n\n"
							+ "### Patients Released : " + KPIs.get(0) + "/" + KPIs.get(1) + "\n"
							+ "### DTDT = " +  KPIs.get(2) + "\n"
							+ "### LOS = " + KPIs.get(3));
				}catch(NumberFormatException e){
					return("ERROR : Simulation time must be an integer.");
				}
			}else{
				return("ERROR : This ED doesn't exists.");
			}
			
		}else if(st.countTokens()==2){
			EmergencyDept ed = sys.getEDs().get(st.nextToken());
			if(ed!=null){
				try{
					int endTime = Integer.parseInt(st.nextToken());
					ArrayList<Double> KPIs = sys.simulation(ed, endTime, false);
					return("\n# Key performance indicators for ED : " + ed.getName() + "\n"
							+ "### Patients Released : " + KPIs.get(0) + "/" + KPIs.get(1) + "\n"
							+ "### DTDT = " +  KPIs.get(2) + "min\n"
							+ "### LOS = " + KPIs.get(3) + "min");
				}catch(NumberFormatException e){
					return("ERROR : Simulation time must be an integer.");
				}
			}else{
				return("ERROR : This ED doesn't exists.");
			}
			
		}else{
			return "ERROR : Invalid arguments, consult the help for more informations.";
		}
		
	}
}
