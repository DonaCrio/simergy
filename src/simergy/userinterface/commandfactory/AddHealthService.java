/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.distributions.ProbabilityDistribution;
import simergy.core.resources.HealthService;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class AddHealthService.
 */
public abstract class AddHealthService implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/** The type. */
	private String type;
	
	/**
	 * Instantiates a new adds the health service.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 * @param type the type
	 */
	public AddHealthService(StringTokenizer st, UserInterface userInterface, String type){
		this.st = st;
		this.userInterface = userInterface;
		this.type = type;
	}
		
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource service = ed.getResourceFactory().getRessource(type);
				ed.addResource(service);
				return(service.getName() + " was successfully added to " + ed.getName() + ".\n"
						+ "Distribution was set Uniform(10,20)");
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else if(st.countTokens()>=3){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource service = ed.getResourceFactory().getRessource(type);
				String distributionType = st.nextToken();
				ArrayList<Double> params = new ArrayList<Double>();
				try{
					for(int i=0;i<st.countTokens();i++){
						params.add(Double.parseDouble(st.nextToken()));
					}
				}catch(NumberFormatException e){
					return("ERROR : Parameters of the distribution must be integers or doubles.");
				}
				
				((HealthService)service).setDistribution(ProbabilityDistribution.createDistribution(distributionType, params));
				ed.addResource(service);
				return(service.getName() + " was successfully added to " + ed.getName() 
				+ " with the given distribution");
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}
	
}
