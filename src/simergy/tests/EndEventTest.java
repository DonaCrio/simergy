/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import simergy.core.events.EventState;
import simergy.core.events.Registration;
import simergy.core.events.Workflow;
import simergy.exceptions.*;
import simergy.core.patients.Patient;
import simergy.core.patients.SeverityLevel;
import simergy.core.resources.Nurse;
import simergy.core.resources.Physician;
import simergy.core.system.EmergencyDept;

public class EndEventTest {

	@Test
	public void PassIfRegistrationEndsCorrectly() {
		EmergencyDept ed = new EmergencyDept("myED");
		ed.addResource(new Nurse("Blanco", "Camille"));
		ed.addResource(new Physician("Said","Sammy"));
		Workflow workflow = new Workflow(ed, new Patient(SeverityLevel.L5));
		workflow.setCurrentEvent(new Registration(workflow));
		try{
			workflow.getCurrentEvent().startEvent();
		}catch(EventStartFailedException e){}
		workflow.getCurrentEvent().endEvent();
		// On test si le currentEvent est bien le suivant
		assertTrue(workflow.getCurrentEvent().getState()==EventState.NS);
		assertTrue(workflow.getCurrentEvent().getType()=="TRANSPORTATION");
	}
}
