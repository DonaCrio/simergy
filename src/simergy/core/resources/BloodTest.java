/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import simergy.core.distributions.Uniform;

/**
 * The Class BloodTest.
 * 
 * Represents the health service performing a blood test
 * 
 * @see simergy.core.resources.HealthService
 */
public class BloodTest  extends HealthService{
	
	private static final long serialVersionUID = -4967539955821341583L;

	/** The service's cost. */
	private static double cost = 50;
	
	/**
	 * Instantiates a new blood test.
	 */
	public BloodTest(int id){
		super(id, "Blood Test service", "BLOODTEST", cost, new Uniform(15,90));
	}
	
	/**
	 * Gets the cost of the service
	 * 
	 * @return cost the service's cost
	 */
	public static double getCost(){
		return cost;
	}
}
