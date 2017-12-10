package simergy.userinterface;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.distributions.ProbabilityDistribution;
import simergy.core.resources.HealthService;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;

public abstract class AddHealthService implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	private String type;
	
	public AddHealthService(StringTokenizer st, CommandLineUserInterface clui, String type){
		this.st = st;
		this.clui = clui;
		this.type = type;
	}
		
	public void execute(){
		if(st.countTokens()==1){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource service = ed.getResourceFactory().getRessource(type);
				ed.addResource(service);
				System.out.println(service.getName() + " was successfully added to " + ed.getName() + ".\n"
						+ "Distribution was set Uniform(10,20)");
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else if(st.countTokens()>=3){
			EmergencyDept ed = clui.getSys().getEDs().get(st.nextToken());
			if(ed!=null){
				Resource service = ed.getResourceFactory().getRessource(type);
				String distributionType = st.nextToken();
				ArrayList<Double> params = new ArrayList<Double>();
				try{
					for(int i=0;i<st.countTokens();i++){
						params.add(Double.parseDouble(st.nextToken()));
					}
				}catch(NumberFormatException e){
					System.out.println("ERROR : <DistParams> must be integers or doubles.");
				}
				
				((HealthService)service).setDistribution(ProbabilityDistribution.createDistribution(distributionType, params));
				ed.addResource(service);
				System.out.println(service.getName() + " was successfully added to " + ed.getName() 
					+ " with the given distribution");
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
		}else{
			System.out.println("ERROR : Requires 1 or 3 arguments (<EDname>,<DistType>,<DistParams>).");
		}
	}
	
}
