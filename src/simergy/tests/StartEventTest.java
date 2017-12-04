/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import simergy.core.system.EmergencyDept;
import simergy.core.resources.*;
import simergy.core.events.*;
import simergy.exceptions.EventStartFailedException;
import simergy.core.patients.*;

public class StartEventTest {

	@Test
	public void PassIfRegistrationStartsCorrectly() {
		EmergencyDept ed = new EmergencyDept("myED");
		ed.addResource(new Nurse(0, "Blanco", "Camille"));
		ed.addResource(new Physician(1, "Said","Sammy"));
		Workflow workflow = new Workflow(ed, new Patient(SeverityLevel.L5),0);
		workflow.setCurrentEvent(new Registration(workflow,0));
		try{
			workflow.getCurrentEvent().startEvent();
		}catch(EventStartFailedException e){}
		assertTrue(workflow.getCurrentEvent().getState() == EventState.IP);
		System.out.println(ed.toString());
	}
	
	@Test
	public void PassIfAllErrorsAreThrownCorrectly() {
		EmergencyDept ed = new EmergencyDept("myED");
		Workflow workflow = new Workflow(ed, new Patient(SeverityLevel.L5),0);
		ed.addResource(new Physician(0, "Said","Sammy"));
		workflow.setCurrentEvent(new Registration(workflow,0));
		try{
			workflow.getCurrentEvent().startEvent();
		}catch(EventStartFailedException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void PassIfNurseIsAvailable() {
		EmergencyDept ed = new EmergencyDept("myED");
		ed.addResource(new Nurse(0, "Blanco", "Camille"));
		ed.addResource(new Physician(1, "Said","Sammy"));
		Workflow workflow = new Workflow(ed, new Patient(SeverityLevel.L5),0);
		workflow.setCurrentEvent(new Registration(workflow,0));
		assertTrue(workflow.getCurrentEvent().requirementsAllGood());
	}
}
