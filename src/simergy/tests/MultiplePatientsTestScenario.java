/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import org.junit.Test;

import simergy.core.events.Workflow;
import simergy.core.patients.HealthInsurance;
import simergy.core.patients.Patient;
import simergy.core.patients.PatientState;
import simergy.core.patients.SeverityLevel;
import simergy.core.resources.*;
import simergy.core.system.EmergencyDept;

public class MultiplePatientsTestScenario {

	@Test
	public void PassIfTwoPatientsAreTreatedThenReleased() {
		EmergencyDept ed = new EmergencyDept("myED");
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
		Patient patient1 = new Patient(SeverityLevel.L4);
		patient1.setHealthInsurance(HealthInsurance.SILVER);
		Patient patient2 = new Patient(SeverityLevel.L4);
		patient2.setHealthInsurance(HealthInsurance.GOLD);
		ed.addWorkflow(new Workflow(ed,patient1));
		ed.addWorkflow(new Workflow(ed,patient2));
		//for(int i=0;i<20;i++){
		while(ed.getWorkflows().get(0).getPatient().getState()!=PatientState.R || ed.getWorkflows().get(1).getPatient().getState()!=PatientState.R){
			ed.updateTest();
			System.out.println("Time = "+ ed.getClock().getTime());
			System.out.println(ed.getWorkflows().get(0).getCurrentEvent().toString());
			System.out.println(ed.getWorkflows().get(1).getCurrentEvent().toString());
		}
	}

}
