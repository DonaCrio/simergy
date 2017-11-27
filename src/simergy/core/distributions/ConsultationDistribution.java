/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.distributions;

/**
 * The Class ConsultationDistribution.
 */
@SuppressWarnings("unused")

public class ConsultationDistribution{

	private double none = 0.35;
	private double radiography = 0.20;
	private double bloodTest = 0.40;
	private double mri = 0.05;
		
	/**
	 * Instantiates a new consultation distribution.
	 */
	public ConsultationDistribution(){}		
		
	/**
	 * Generate prescription.
	 *
	 * @return the string
	 * 
	 */
	public String generatePrescription(){
		double r = Math.random();
		if(r<none){
			return "NONE";
		}else if(none<=r && r<none+radiography){
			return "RADIOGRAPHY";
		}else if(none+radiography<=r && r<none+radiography+bloodTest){
			return "BLOODTEST";
		}else{
			return "MRI";
		}
	}
}
