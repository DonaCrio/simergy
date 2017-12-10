/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.distributions;

import java.io.Serializable;
import java.util.ArrayList;

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
	
	/**
	 * Creates a new distribution.
	 * 
	 * @param type the distribution's type
	 * @param params the distribution's params
	 * @return the distribution
	 */
	public static ProbabilityDistribution createDistribution(String type, ArrayList<Double> params){
		if(type.equalsIgnoreCase("DETERMINISTIC") && params.size()==1){
			return new Deterministic(params.get(0));
		}else if(type.equalsIgnoreCase("EXPONENTIAL") && params.size()==1){
			return new Exponential(params.get(0));
		}else if(type.equalsIgnoreCase("UNIFORM") && params.size()==2){
			return new Uniform(params.get(0),params.get(1));
		}else{
			return null;
		}
	}
}
