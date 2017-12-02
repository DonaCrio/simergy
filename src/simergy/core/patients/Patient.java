/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.patients;

import simergy.core.resources.*;

import java.io.Serializable;

import simergy.core.events.Workflow;

/**
 * The Class Patient.
 * 
 * This class is used to represent a patient in the ED.
 * Attributes name, and surname are not mandatory.
 * Contains all the  personal informations about a patient.
 *  @see simergy.events.Workflow to get informations about patient's stay in the ed.
 */
public class Patient implements Serializable{

	private static final long serialVersionUID = 3751205721606981449L;

	/** The integer used to generate unique ids. */
	private static int i=0;
	
	private int id;
	private String name;
	private String surname;
	private HealthInsurance healthInsurance;
	private SeverityLevel severityLevel;
	private Workflow workflow;
	private PatientState state;
	private String prescription;
	private double charges;
	private Physician physician;
	private String outcome;
	
	/**
	 * Instantiates a new patient.
	 *
	 * @param severityLevel the severity level of the patient
	 */
	public Patient(SeverityLevel severityLevel){
		this.id = i++;
		this.severityLevel = severityLevel;
		this.state = PatientState.W;
		this.charges = 0;
		this.healthInsurance = HealthInsurance.NONE;
	}
	
	/**
	 * Instantiates a new patient.
	 *
	 * @param name the patient's name
	 * @param surname the patient's surname
	 * @param severityLevel the patient's severity level
	 * @param healthInsurance the patient's health insurance
	 */
	public Patient(String name, String surname, String severityLevel, String healthInsurance){
		this.id = i++;
		this.name = name;
		this.surname = surname;
		this.state = PatientState.W;
		this.charges = 0;
		switch(severityLevel.toUpperCase()){
		case("L1"):
			this.severityLevel = SeverityLevel.L1;
			break;
		case("L2"):
			this.severityLevel = SeverityLevel.L2;
			break;
		case("L3"):
			this.severityLevel = SeverityLevel.L3;
			break;
		case("L4"):
			this.severityLevel = SeverityLevel.L4;
			break;
		case("L5"):
			this.severityLevel = SeverityLevel.L5;
			break;
		default:
			this.severityLevel = SeverityLevel.L5;
			break;
		}
		switch(healthInsurance.toUpperCase()){
		case("GOLD"):
			this.healthInsurance = HealthInsurance.GOLD;
			break;
		case("SILVER"):
			this.healthInsurance = HealthInsurance.SILVER;
			break;
		case("NONE"):
			this.healthInsurance = HealthInsurance.NONE;
			break;
		default:
			this.healthInsurance = HealthInsurance.NONE;
			break;
		}
	}
	
	
/*
 * @see java.lang.Object#toString()
 */
@Override
	public String toString() {
		return name + " [id=" + id + ", severityLevel=" + severityLevel + ", state=" + state + ", healthInsurance=" + healthInsurance + ", charges=" + charges + (physician==null?"":", physicianID="
				+ physician.getId()) + "]";
	}

	/**
	 * Adds the charges.
	 *
	 * @param cost the cost
	 */
	public void addCharges(double cost){
		charges += (1 - healthInsurance.getDiscount()) * cost;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	/* Getters and Setters */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the health insurance.
	 *
	 * @return the health insurance
	 */
	public HealthInsurance getHealthInsurance() {
		return healthInsurance;
	}

	/**
	 * Sets the health insurance.
	 *
	 * @param healthInsurance the new health insurance
	 */
	public void setHealthInsurance(HealthInsurance healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	/**
	 * Gets the severity level.
	 *
	 * @return the severity level
	 */
	public SeverityLevel getSeverityLevel() {
		return severityLevel;
	}

	/**
	 * Sets the severity level.
	 *
	 * @param severityLevel the new severity level
	 */
	public void setSeverityLevel(SeverityLevel severityLevel) {
		this.severityLevel = severityLevel;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public PatientState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(PatientState state) {
		this.state = state;
	}

	/**
	 * Gets the charges.
	 *
	 * @return the charges
	 */
	public double getCharges() {
		return charges;
	}

	/**
	 * Sets the charges.
	 *
	 * @param charges the new charges
	 */
	public void setCharges(double charges) {
		this.charges = charges;
	}

	/**
	 * Gets the physician.
	 *
	 * @return the physician
	 */
	public Physician getPhysician() {
		return physician;
	}

	/**
	 * Sets the physician.
	 *
	 * @param physician the new physician
	 */
	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	/**
	 * Gets the prescription.
	 *
	 * @return the prescription
	 */
	public String getPrescription() {
		return prescription;
	}

	/**
	 * Sets the prescription.
	 *
	 * @param prescription the new prescription
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	/**
	 * Gets the outcome.
	 *
	 * @return the outcome
	 */
	public String getOutcome() {
		return outcome;
	}

	/**
	 * Sets the outcome.
	 *
	 * @param outcome the new outcome
	 */
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	
}
