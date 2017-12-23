/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.patients;

import simergy.core.distributions.*;

/**
 * The Enum SeverityLevel.
 */
public enum SeverityLevel {


	L1("Resuscitation",0.0014), // 2 par jour
	L2("Emergency",0.0028), // 4 par jour
	L3("Urgent",0.0112), //16 par jour
	L4("Less urgent",0.0167), //24 par jour
	L5("Non-urgent",0.0167);//24 par jour
	
	/** The distribution. */
	public ProbabilityDistribution distribution;
	
	/** The severity level's name. */
	public String name;
	
	
	/**
	 * Instantiates a new severity level.
	 *
	 * @param name the name
	 */
	private SeverityLevel(String name, double param){
		this.name = name;
		this.distribution = new Exponential(param);
	}


	public ProbabilityDistribution getDistribution() {
		return distribution;
	}


	public void setDistribution(ProbabilityDistribution distribution) {
		this.distribution = distribution;
	}
	
	
}
