package simergy.userinterface.cmdfactory;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.distributions.ProbabilityDistribution;
import simergy.core.patients.SeverityLevel;
import simergy.core.system.EmergencyDept;
import simergy.core.system.PatientGenerator;
import simergy.userinterface.intefaces.UserInterface;

public abstract class SetPatientArrivalDist implements Command{

	private StringTokenizer st;
	private UserInterface userInterface;
	private SeverityLevel lvl;
	
	public SetPatientArrivalDist(StringTokenizer st, UserInterface userInterface, SeverityLevel lvl){
		this.st = st;
		this.userInterface = userInterface;
		this.lvl = lvl;
	}
	
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
				return("The arrival time has succesfully been associated with the given distribution.");
			}else{
				return("ERROR : This ED doesn't exists.");
			}
		}else{
			return("ERROR : 3 arguments (<EDname>,<DistType>,<DistParams>).");
		}
	}
}
