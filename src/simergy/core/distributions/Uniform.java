/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.distributions;

/**
 * The Class Uniform.
 */
public class Uniform implements ProbabilityDistribution{

	private static final long serialVersionUID = -2502585131849458741L;
	private double l;
	private double r;
	
	/**
	 * Instantiates a new uniform distribution.
	 *
	 * @param l the left bound of the distribution's interval
	 * @param r the right bound of the distribution's interval
	 */
	public Uniform(double l, double r){
		this.l = l;
		this.r = r;
	}
	
	/*
	 * @see simergy.core.distributions.ProbabilityDistribution#generateSample()
	 */
	public double generateSample(){
		double a = Math.random();
		return a*(r-l)+l;
	}

	@Override
	public String toString() {
		return "Uniform [l=" + l + ", r=" + r + "]";
	}
	
}
