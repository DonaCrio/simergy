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


	L1("Resuscitation",0.004),
	L2("Emergency",0.008),
	L3("Urgent",0.016),
	L4("Less urgent",0.016),
	L5("Non-urgent",0.016);
	
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
