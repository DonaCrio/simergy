/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import simergy.core.system.*;
import simergy.core.resources.*;
import simergy.core.patients.*;
import simergy.core.events.*;

public class FirstScenarioTest {

	@Test
	public void PassIfOnePatientIsFullyTreatedThenReleased() {
		SimErgy sys = new SimErgy("");
		EmergencyDept ed = new EmergencyDept("myED");
		sys.addED(ed);
		ed.addResource(new Physician(0, "Said","Sammy"));
		ed.addResource(new Physician(1, "Guerzider","Antoine"));
		ed.addResource(new Physician(2, "Said","Antoine"));
		ed.addResource(new Physician(3, "Guerzider","Sammy"));
		ed.addResource(new Nurse(4, "Picard","Alex"));
		ed.addResource(new Nurse(5, "Ripoche","Arnaud"));
		ed.addResource(new Nurse(6, "Picard","Arnaud"));
		ed.addResource(new Nurse(7, "Ripoche","Alex"));
		ed.addResource(new Transporter(8, "Cisneros","Hugo"));
		ed.addResource(new Transporter(9, "Plessis","Quentin"));
		ed.addResource(new Transporter(10, "Cisneros","Quentin"));
		ed.addResource(new Transporter(11, "Plessis","Hugo"));
		ed.addResource(new BoxRoom(12));
		ed.addResource(new BoxRoom(13));
		ed.addResource(new BoxRoom(14));
		ed.addResource(new BoxRoom(15));
		ed.addResource(new ShockRoom(16));
		ed.addResource(new BloodTest(17));
		ed.addResource(new MRI(18));
		ed.addResource(new Radiography(19));
		Patient patient = new Patient(SeverityLevel.L4);
		patient.setHealthInsurance(HealthInsurance.SILVER);
		ed.addWorkflow(new Workflow(ed,patient,0));
		sys.simulationNoAutomation(ed, 500);
		assertTrue(ed.getWorkflows().get(0).getCurrentEvent().getType()=="OUTCOME");
		System.out.println("Time = "+ ed.getTime());
		System.out.println(ed.getWorkflows().get(0).getCurrentEvent().toString()+"\n");
	}
}
