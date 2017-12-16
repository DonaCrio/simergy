/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.system;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;

import simergy.core.events.*;
import simergy.core.resources.*;
import simergy.exceptions.*;
import simergy.core.patients.*;

/**
 * The Class EmergencyDept.
 * 
 * This is the most important class of the core.
 * One instance of this class contains all the informations, workflows and description of the ED.
 * 
 */
public class EmergencyDept implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6699762321132104984L;

	/** The name. */
	private String name;
	
	/** The workflows. */
	private ArrayList<Workflow> workflows;
	
	/** The patients. */
	private ArrayList<Patient> patients;
	
	/** The time. */
	private double time;
	
	/** The resources. */
	private HashMap<String,ArrayList<Resource>> resources;
	
	/** The resource factory. */
	private ResourceFactory resourceFactory;
	
	/** The patient generator. */
	PatientGenerator patientGenerator;
	
	/**
	 * Instantiates a new emergency department.
	 * Sets the name and initialise all the arrays containing the workflows and the patients.
	 * Generates the HashMap describing the resources present in the ED.
	 *
	 * @param name the department's name
	 * @see simergy.core.system.EmergencyDept#generateResources
	 */
	public EmergencyDept(String name) {
		this.name = name;
		this.workflows = new ArrayList<Workflow>();
		this.patients = new ArrayList<Patient>();
		this.time = 0;
		this.resources = generateResources();
		this.resourceFactory = new ResourceFactory();
		this.patientGenerator = new PatientGenerator(this);
	}
	
	/**
	 * Generates the HashMap containing all the resources.
	 * The index is made of Strings representing a canonical type of the resource.
	 *
	 * @return the hash map containing all the ED's resources.
	 */
	public static HashMap<String,ArrayList<Resource>> generateResources(){
		HashMap<String,ArrayList<Resource>> resources = new HashMap<String,ArrayList<Resource>>();
		resources.put("PHYSICIAN",new ArrayList<Resource>());
		resources.put("NURSE",new ArrayList<Resource>());
		resources.put("TRANSPORTER",new ArrayList<Resource>());
		resources.put("BOXROOM",new ArrayList<Resource>());
		resources.put("SHOCKROOM",new ArrayList<Resource>());
		resources.put("MRI",new ArrayList<Resource>());
		resources.put("BLOODTEST",new ArrayList<Resource>());
		resources.put("RADIOGRAPHY",new ArrayList<Resource>());
		return resources;
	}
	
	/**
	 * Updates the time in the ED. Then it checks for a new patient arrival.
	 * Then all the workflows are updated.
	 *
	 * @param resourceType the resource type
	 * @param patient the patient
	 * @return true, if is available
	 * @see simergy.core.system.TimeMachine#toNextTime()
	 * @see simergy.events.Workflow#update()
	 */
	
	/**
	 * Checks if a resource is available for a patient.
	 *
	 * @param resourceType the resource type
	 * @param patient the patient
	 * @return true, if is available
	 */
	public boolean isAvailable(String resourceType, Patient patient){
		if(resourceType=="PHYSICIAN"){
			if(patient.getPhysician().getState()==State.IDLE){
				return patient.getPhysician().nextPatient()==null || patient.getPhysician().nextPatient()==patient;
			}else{
				return false;
			}
			
		}else{
			ArrayList<Resource> askedResources = resources.get(resourceType);
			for(Resource r : askedResources){
				if(r.getState()==State.IDLE){
					return r.nextPatient()==null || r.nextPatient()==patient;
				}
			}
			return false;
		}
	}
	
	/**
	 * Gives a resource and set its state to VISITING.
	 *
	 * @param resourceType the resource type
	 * @return the resource
	 * @throws ResourceNotAvailableException if the resource is not available
	 */
	public Resource giveResource(String resourceType) throws ResourceNotAvailableException{
		/*
		 * Check si la ressource demandée est disponible ou non
		 * Si oui, change son état et la renvoie
		 * Sinon, leve une exception
		 */
		ArrayList<Resource> askedRessource = resources.get(resourceType);
		for(Resource ressource : askedRessource){
			if(ressource.getState() == State.IDLE){
				ressource.setState(State.VISITING);
				return ressource;
			}
		}
		throw new ResourceNotAvailableException(resourceType);
	}
	
	/**
	 * Take back a resource by setting its state to IDLE.
	 *
	 * @param resource the resource
	 */
	public void takeBackResource(Resource resource){
		resource.setState(State.IDLE);
	}
	
	/**
	 * Adds a resource to the ED.
	 *
	 * @param resource the resource
	 */
	public void addResource(Resource resource){
		this.resources.get(resource.getType()).add(resource);
	}
	
	/**
	 * Adds a workflow to the ED.
	 *
	 * @param workflow the workflow
	 */
	public void addWorkflow(Workflow workflow){
		if(workflow.getPatient().getSeverityLevel()==SeverityLevel.L1 || workflow.getPatient().getSeverityLevel()==SeverityLevel.L2){
			workflows.add(0,workflow);
			patients.add(workflow.getPatient());
		}else{
			workflows.add(workflow);
			patients.add(workflow.getPatient());
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmergencyDept [patients=" + patients + ", time=" + time + ", resources="
				+ resources + "]";
	}
/* Getters and Setters */
	


	/**
	 * Gets the resources.
	 *
	 * @return the resources
	 */
	public HashMap<String, ArrayList<Resource>> getResources() {
		return resources;
	}

	/**
	 * Gets the workflows.
	 *
	 * @return the workflows
	 */
	public ArrayList<Workflow> getWorkflows() {
		return workflows;
	}

	
	/**
	 * Sets the workflows.
	 *
	 * @param workflows the new workflows
	 */
	public void setWorkflows(ArrayList<Workflow> workflows){
		this.workflows = workflows;
	}

	/**
	 * Gets the patients.
	 *
	 * @return the patients
	 */
	public ArrayList<Patient> getPatients() {
		return patients;
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
	 * Gets the resource factory.
	 *
	 * @return the resource factory
	 */
	public ResourceFactory getResourceFactory() {
		return resourceFactory;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public double getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * Sets the patients.
	 *
	 * @param patients the new patients
	 */
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

	/**
	 * Gets the patient generator.
	 *
	 * @return the patient generator
	 */
	public PatientGenerator getPatientGenerator() {
		return patientGenerator;
	}
	
}
