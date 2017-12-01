/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import simergy.core.distributions.Uniform;

// TODO: Auto-generated Javadoc
/**
 * The Class MRI.
 * 
 * Represents the health service performing a MRI
 * 
 * @see simergy.core.resources.HealthService
 */
public class MRI extends HealthService{
	
	private static final long serialVersionUID = 6343208792379628419L;

	/** The service's cost. */
	private static double cost = 200;
	
	/**
	 * Instantiates a new MRI.
	 */
	public MRI(int id){
		super(id, "MRI service", "MRI", cost, new Uniform(30,70));
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
