/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;


import org.junit.Test;

import simergy.core.system.*;
import simergy.core.resources.*;
import simergy.core.patients.*;
import simergy.core.events.*;

public class FirstScenarioTest {

	@Test
	public void PassIfOnePatientIsFullyTreatedThenReleased() {
		EmergencyDept ed = new EmergencyDept("myED");
		ed.addResource(new Physician("Said","Sammy"));
		ed.addResource(new Physician("Guerzider","Antoine"));
		ed.addResource(new Physician("Said","Antoine"));
		ed.addResource(new Physician("Guerzider","Sammy"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Ripoche","Arnaud"));
		ed.addResource(new Nurse("Picard","Arnaud"));
		ed.addResource(new Nurse("Ripoche","Alex"));
		ed.addResource(new Transporter("Cisneros","Hugo"));
		ed.addResource(new Transporter("Plessis","Quentin"));
		ed.addResource(new Transporter("Cisneros","Quentin"));
		ed.addResource(new Transporter("Plessis","Hugo"));
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new ShockRoom());
		ed.addResource(new BloodTest());
		ed.addResource(new MRI());
		ed.addResource(new Radiography());
		Patient patient = new Patient("Imbert", "Quentin", SeverityLevel.L4);
		patient.setHealthInsurance(HealthInsurance.SILVER);
		ed.addWorkflow(new Workflow(ed,patient));
		while(ed.getWorkflows().get(0).getPatient().getState()!=PatientState.R){
			System.out.println("Time = "+ ed.getClock().getTime());
			System.out.println(ed.getWorkflows().get(0).getPatient().getPhysician());
			System.out.println(ed.getWorkflows().get(0).getCurrentEvent().toString()+"\n");
			ed.updateTest();
		}
	}
}
