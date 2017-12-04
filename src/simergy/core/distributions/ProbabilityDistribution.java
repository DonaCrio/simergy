/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.distributions;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ProbabilityDistribution.
 */
public interface ProbabilityDistribution extends Serializable{

	/**
	 * Generate a sample following a specific distribution.
	 *
	 * @return the sample as an integer
	 */
	public double generateSample();
}
