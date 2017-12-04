/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.distributions;

/**
 * The Class Deterministic.
 */
public class Deterministic implements ProbabilityDistribution{
	
	private static final long serialVersionUID = 7194064361603320285L;
	private double delta;
	
	/**
	 * Instantiates a new deterministic distribution.
	 *
	 * @param delta the deterministic parameter
	 */
	public Deterministic(double delta){
		this.delta = delta;
	}
	
	/*
	 * @see simergy.core.distributions.ProbabilityDistribution#generateSample()
	 */
	public double generateSample(){
		return delta;
	}
}
