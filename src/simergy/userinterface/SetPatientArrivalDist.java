package simergy.userinterface;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.distributions.ProbabilityDistribution;
import simergy.core.patients.SeverityLevel;
import simergy.core.system.EmergencyDept;
import simergy.core.system.PatientGenerator;

public abstract class SetPatientArrivalDist implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	private SeverityLevel lvl;
	
	public SetPatientArrivalDist(StringTokenizer st, CommandLineUserInterface clui, SeverityLevel lvl){
		this.st = st;
		this.clui = clui;
		this.lvl = lvl;
	}
	
	public void execute(){
		if(st.countTokens()>=3){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				PatientGenerator generator = ed.getPatientGenerator();
				String distributionType = st.nextToken();
				ArrayList<Double> params = new ArrayList<Double>();
				try{
					for(int i=0;i<st.countTokens();i++){
						params.add(Double.parseDouble(st.nextToken()));
					}
				}catch(NumberFormatException e){
					System.out.println("ERROR : <DistParams> must be integers or doubles.");
				}
				generator.getDistributions().put(lvl, ProbabilityDistribution.createDistribution(distributionType, params));
				System.out.println("The arrival time has succesfully been associated with the given distribution.");
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else{
			System.out.println("ERROR : 3 arguments (<EDname>,<DistType>,<DistParams>).");
		}
	}
}
