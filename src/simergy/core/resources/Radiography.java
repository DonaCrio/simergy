/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import simergy.core.distributions.Uniform;

/**
 * The Class Radiography.
 * 
 * Represents the health service performing a radiography
 * 
 * @see simergy.core.resources.HealthService
 */
public class Radiography extends HealthService{

	private static final long serialVersionUID = -963380009018676741L;

	/** The service's cost. */
	private static double cost = 100;
	
	/**
	 * Instantiates a new radiography.
	 */
	public Radiography(){
		super("Radiography service", "RADIOGRAPHY", cost, new Uniform(10,20));
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
