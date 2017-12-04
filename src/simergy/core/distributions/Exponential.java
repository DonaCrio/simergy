/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.distributions;

/**
 * The Class Exponential.
 */
public class Exponential implements ProbabilityDistribution{

	private static final long serialVersionUID = 270894906569412062L;
	private double lambda;
	
	/**
	 * Instantiates a new exponential distribution.
	 *
	 * @param lambda the exponential parameter
	 */
	public Exponential(double lambda){
		this.lambda = lambda;
	}
	
	/*
	 * @see simergy.core.distributions.ProbabilityDistribution#generateSample()
	 */
	public double generateSample(){
		double r = Math.random();
		return -Math.log(1-r)/this.lambda;
	}
}
