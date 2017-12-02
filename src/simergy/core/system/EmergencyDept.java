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

	private static final long serialVersionUID = 6699762321132104984L;

	private String name;
	private ArrayList<Workflow> workflows;
	private ArrayList<Patient> patients;
	private TimeMachine clock;
	private PatientGenerator generator;
	private HashMap<String,ArrayList<Resource>> resources;
	private ResourceFactory resourceFactory;
	
	/**
	 * Instantiates a new emergency department.
	 * Sets the name and initialise all the arrays containing the workflows and the patients.
	 * Generates the HashMap describing the resources present in the ED.
	 * 
	 * @see simergy.core.system.EmergencyDept#generateResources
	 *
	 * @param name the department's name
	 */
	public EmergencyDept(String name) {
		this.name = name;
		this.workflows = new ArrayList<Workflow>();
		this.patients = new ArrayList<Patient>();
		this.clock = new TimeMachine();
		this.generator = new PatientGenerator();
		this.resources = generateResources();
		this.resourceFactory = new ResourceFactory();
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
		resources.put("WAITINGROOM",new ArrayList<Resource>());
		resources.put("STRETCHER",new ArrayList<Resource>());
		resources.put("MRI",new ArrayList<Resource>());
		resources.put("BLOODTEST",new ArrayList<Resource>());
		resources.put("RADIOGRAPHY",new ArrayList<Resource>());
		return resources;
	}
	
	/**
	 * Updates the time in the ED. Then it checks for a new patient arrival.
	 * Then all the workflows are updated.
	 * 
	 * @see simergy.core.system.TimeMachine#toNextTime()
	 * @see simergy.events.Workflow#update()
	 */
	public void update(){
		clock.toNextTime();
		ArrayList<Patient> newPatients = generator.getPatients(clock.getTime());
		if(newPatients!=null){
			for(Patient p : newPatients){
				addWorkflow(new Workflow(this, p));
			}
		}
		for(Workflow workflow : workflows){
			if(workflow.getState()==EventState.IP){
				workflow.update();
			}
		}
	}
	
	/**
	 * @deprecated
	 * A method used only to perform tests on workflows
	 * 
	 */
	public void updateTest(){
		clock.toNextTime();
		for(Workflow workflow : workflows){
			if(workflow.getState()==EventState.IP){
				workflow.update();
			}
		}
	}
	
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
	
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmergencyDept [patients=" + patients + ", clock=" + clock + ", resources="
				+ resources + "]";
	}
/* Getters and Setters */
	
	/**
 * Gets the clock.
 *
 * @return the clock
 */
public TimeMachine getClock(){
		return clock;
	}


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

	public void setClock(TimeMachine clock) {
		this.clock = clock;
		
	}

	public void setPatientGenerator(PatientGenerator generator) {
		this.generator = generator;
		
	}
	
	public void setWorkflows(ArrayList<Workflow> workflows){
		this.workflows = workflows;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceFactory getResourceFactory() {
		return resourceFactory;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	
}
