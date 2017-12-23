/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.commandfactory;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.distributions.ProbabilityDistribution;
import simergy.core.patients.SeverityLevel;
import simergy.core.system.EmergencyDept;
import simergy.core.system.PatientGenerator;
import simergy.userinterface.intefaces.UserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class SetPatientArrivalDist.
 */
public abstract class SetPatientArrivalDist implements Command{

	/** The st. */
	private StringTokenizer st;
	
	/** The user interface. */
	private UserInterface userInterface;
	
	/** The lvl. */
	private SeverityLevel lvl;
	
	/**
	 * Instantiates a new sets the patient arrival dist.
	 *
	 * @param st the st
	 * @param userInterface the user interface
	 * @param lvl the lvl
	 */
	public SetPatientArrivalDist(StringTokenizer st, UserInterface userInterface, SeverityLevel lvl){
		this.st = st;
		this.userInterface = userInterface;
		this.lvl = lvl;
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.commandfactory.Command#execute()
	 */
	public String execute(){
		if(st.countTokens()>=3){
			EmergencyDept ed = userInterface.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				PatientGenerator generator = ed.getPatientGenerator();
				String distributionType = st.nextToken();
				ArrayList<Double> params = new ArrayList<Double>();
				try{
					for(int i=0;i<st.countTokens();i++){
						params.add(Double.parseDouble(st.nextToken()));
					}
				}catch(NumberFormatException e){
					return("ERROR : <DistParams> must be integers or doubles.");
				}
				generator.getDistributions().put(lvl, ProbabilityDistribution.createDistribution(distributionType, params));
				return("The arrival time has succesfully been associated with the given distribution : \n" 
						+ generator.getDistributions().toString());
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : Invalid arguments, consult the help for more informations.");
		}
	}
}
