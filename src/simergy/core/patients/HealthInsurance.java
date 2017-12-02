/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.patients;

/**
 * The Enum HealthInsurance.
 */
public enum HealthInsurance {

	NONE(0.0),
	SILVER(0.5),
	GOLD(0.8);

	private double discount;
	
	/**
	 * Instantiates a new health insurance.
	 *
	 * @param discount the discount
	 */
	private HealthInsurance(double discount){
		this.discount = discount;
	}
	
	public static HealthInsurance getHealthInsurance(String type){
		if(type.equalsIgnoreCase("GOLD")){
			return HealthInsurance.GOLD;
		}else if(type.equalsIgnoreCase("SILVER")){
			return HealthInsurance.SILVER;
		}else{
			return HealthInsurance.NONE;
		}
	}
	
	/**
	 * Gets the patient's discount.
	 *
	 * @return the discount
	 */
	public double getDiscount(){
		return discount;
	}
}
