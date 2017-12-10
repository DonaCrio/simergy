package simergy.userinterface;

import java.util.ArrayList;
import java.util.StringTokenizer;

import simergy.core.system.EmergencyDept;
import simergy.core.system.SimErgy;

public class Simulation implements Command{

	private StringTokenizer st;
	private CommandLineUserInterface clui;
	
	public Simulation(StringTokenizer st, CommandLineUserInterface clui){
		this.st = st;
		this.clui = clui;
	}
	
	public void execute(){
		SimErgy sys = clui.getSys();
		if(st.countTokens()==3){
			EmergencyDept ed = sys.getEDs().get(st.nextToken());
			if(ed!=null){
				try{
					int endTime = Integer.parseInt(st.nextToken());
					boolean enableGen = st.nextToken().equalsIgnoreCase("ACTIVATE");
					ArrayList<Double> KPIs = sys.simulation(ed, endTime, enableGen);
					System.out.println("\n# Key performance indicators for ED : " + ed.getName() + "\n"
							+ "### Patients Released : " + KPIs.get(0) + "/" + KPIs.get(1) + "\n"
							+ "### DTDT = " +  KPIs.get(2) + "\n"
							+ "### LOS = " + KPIs.get(3));
				}catch(NumberFormatException e){
					System.out.println("ERROR : <SimulationTime> must be an integer.");
				}
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
			
		}else if(st.countTokens()==2){
			EmergencyDept ed = sys.getEDs().get(st.nextToken());
			if(ed!=null){
				try{
					int endTime = Integer.parseInt(st.nextToken());
					ArrayList<Double> KPIs = sys.simulation(ed, endTime, false);
					System.out.println("\n# Key performance indicators for ED : " + ed.getName() + "\n"
							+ "### Patients Released : " + KPIs.get(0) + "/" + KPIs.get(1) + "\n"
							+ "### DTDT = " +  KPIs.get(2) + "\n"
							+ "### LOS = " + KPIs.get(3));
				}catch(NumberFormatException e){
					System.out.println("ERROR : <SimulationTime> must be an integer.");
				}
			}else{
				System.out.println("ERROR : This ED doesn't exists.");
			}
			
		}else{
			System.out.println("Type 'simulation <EDName>,<SimulationTime>,ACTIVATE' to simulate Ed with given name during given time.\n"
					+ "Type ACTIVATE if the simulation enables patient generation."
					+ "List of EDs present in the system :\n");
			for(String name : sys.getEDs().keySet()){
				System.out.println("# " + name);
			}
		}
		
	}
}
