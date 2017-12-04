/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import simergy.core.events.*;
import simergy.core.patients.*;
import simergy.core.resources.*;
import simergy.exceptions.EventStartFailedException;


/**
 * The Class SimErgy.
 * 
 * This class represents the system running during a simulation and during the use of the CLUI.
 */
public class SimErgy implements Serializable{

	private static final long serialVersionUID = -412240945789262714L;

	private HashMap<String,EmergencyDept> EDs;
	
	/**
	 * Instantiates a new system.
	 */
	public SimErgy() {
		this.EDs = new HashMap<String,EmergencyDept>();
	}

	/**
	 * Gets the EDs present in the system.
	 *
	 * @return the EDs
	 */
	public HashMap<String, EmergencyDept> getEDs() {
		return EDs;
	}
	
	/**
	 * Adds an ED to the system.
	 *
	 * @param ed the ed
	 */
	public void addED(EmergencyDept ed){
		EDs.put(ed.getName(), ed);
	}
	
	/**
	 * Simulation of a given Ed over a given Time.
	 * Computes the KPIs of the Ed 
	 *
	 * @param ed the ED
	 * @param endTime the end time
	 * @return the array list containing : (number of patients released, number of patients, DTDT, LOS).
	 */
	public ArrayList<Double> simulation(EmergencyDept ed, int endTime){
		double simTime = 0;
		ArrayList<Event> eventQueue = new ArrayList<Event>();
		ArrayList<Integer> enabledEvents = new ArrayList<Integer>();
		initializeSimErgy(ed);
		enabledEvents = updateEnabledEvents(ed);
		eventQueue = updateEventQueue(enabledEvents, ed);
		while(simTime < endTime){
			Event e = eventQueue.get(0);
			executeEvent(e);
			simTime = e.getOccurenceTime();
			ed.setTime(simTime);
			enabledEvents = updateEnabledEvents(ed);
			eventQueue = updateEventQueue(enabledEvents, ed);
		}
		return computeKPIs(ed);
	}
	
	/**
	 * Initializes SimErgy by generating the Arrival Time of the next patients of each severity level.
	 *
	 * @param ed the ED
	 */
	public void initializeSimErgy(EmergencyDept ed){
		ed.getPatientGenerator().initializePatients();
		
	}
	
	/**
	 * Updates enabled events.
	 *
	 * @param ed the ED
	 * @return the enabled events
	 */
	public ArrayList<Integer> updateEnabledEvents(EmergencyDept ed){
		ArrayList<Integer> enabledEvents = new ArrayList<Integer>();
		for(Workflow w : ed.getWorkflows()){
			if(w.getState()==EventState.IP){
				Event event = w.getCurrentEvent();
				if(event.getState()==EventState.NS && event.requirementsAllGood()){
					if(event.getStartTime()<ed.getTime()){
						event.setStartTime(ed.getTime());
					}
					event.setOccurenceTime(event.getStartTime());
					enabledEvents.add(event.getId());
				}else if(event.getState()==EventState.IP){
					event.setOccurenceTime(event.getEndTime());
					enabledEvents.add(event.getId());
				}
			}			
		}
		return enabledEvents;
	}

	
	/**
	 * Updates event queue.
	 *
	 * @param enabledEvents the enabled events
	 * @param ed the ED
	 * @return the event queue
	 */
	public ArrayList<Event> updateEventQueue(ArrayList<Integer> enabledEvents, EmergencyDept ed){
		ArrayList<Event> eventQueue = new ArrayList<Event>();
		for(Workflow w : ed.getWorkflows()){
			if(w.getState()==EventState.IP){
				if(enabledEvents.contains(w.getCurrentEvent().getId())){
					eventQueue.add(w.getCurrentEvent());
				}
			}
		}
		Collections.sort(eventQueue, new Comparator<Event>(){
			public int compare(Event event1, Event event2){
				double res = event1.getOccurenceTime()-event2.getOccurenceTime();
				if(res>0){return 1;}else if(res==0){return 0;}else{return -1;}}});
		return eventQueue;
	}
	
	/**
	 * Executes an event.
	 *
	 * @param event the event
	 */
	public void executeEvent(Event event){
		try{
			if(event.getState()==EventState.NS){
				event.startEvent();
			}else{
				event.endEvent();
			}
		}catch(EventStartFailedException e){}
	}
	
	/**
	 * Resets an ED.
	 * Deletes all the patients in the ED, the resources waiting queues, reset the time.
	 * 
	 * @param ed the ED
	 */
	public void reset(EmergencyDept ed){
		ed.setWorkflows(new ArrayList<Workflow>());
		ed.setPatients(new ArrayList<Patient>());
		ed.setTime(0);
		for(String resourceType : ed.getResources().keySet()){
			for(Resource r : ed.getResources().get(resourceType)){
				r.setState(State.IDLE);
			}
		}
		for(Resource r : ed.getResources().get("MRI")){
			((HealthService)r).setWaitingQueue(new ArrayList<Patient>());
		}
		for(Resource r : ed.getResources().get("BLOODTEST")){
			((HealthService)r).setWaitingQueue(new ArrayList<Patient>());
		}
		for(Resource r : ed.getResources().get("RADIOGRAPHY")){
			((HealthService)r).setWaitingQueue(new ArrayList<Patient>());
		}
		for(Resource r : ed.getResources().get("PHYSICIAN")){
			((Physician)r).setOverseenPatients(new ArrayList<Patient>());
			((Physician)r).setToBeSeenPatients(new ArrayList<Patient>());
			((Physician)r).setTreatedPatients(new ArrayList<Patient>());
			((Physician)r).setCurrentPatient(null);
		}
	}
	
	/**
	 * Computes KPIs.
	 *
	 * @param ed the ED
	 * @return the KPI's
	 */
	public ArrayList<Double> computeKPIs(EmergencyDept ed){
		double DTDT = 0;
		double LOS = 0;
		double nbR = 0;
		double nbPatients = ed.getWorkflows().size();
		for(Workflow w : ed.getWorkflows()){
			if(w.getState()==EventState.AF){
				nbR += 1;
				DTDT += w.getConsultationTime()-w.getStartTime();
				LOS += w.getEndTime()-w.getStartTime();
			}
		}
		ArrayList<Double> KPIs = new ArrayList<Double>();
		KPIs.add(nbR);
		KPIs.add(nbPatients);
		KPIs.add(DTDT/nbR);
		KPIs.add(LOS/nbR);
		
		return KPIs;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimErgy [EDs=" + EDs + "]";
	}	
	
	/**
	 * Simulation used to run some tests.
	 *
	 * @param ed the ed
	 * @param endTime the end time
	 * @return the array list
	 */
	public ArrayList<Double> simulationNoAutomation(EmergencyDept ed, int endTime){
		double simTime = 0;
		ArrayList<Event> eventQueue = new ArrayList<Event>();
		ArrayList<Integer> enabledEvents = new ArrayList<Integer>();
		enabledEvents = updateEnabledEvents(ed);
		eventQueue = updateEventQueue(enabledEvents, ed);
		while(simTime < endTime){
			Event e = eventQueue.get(0);
			executeEvent(e);
			simTime = e.getOccurenceTime();
			ed.setTime(simTime);
			enabledEvents = updateEnabledEvents(ed);
			eventQueue = updateEventQueue(enabledEvents, ed);
		}
		return computeKPIs(ed);
	}
	
}
