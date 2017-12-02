package simergy.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import simergy.core.events.Workflow;
import simergy.core.patients.HealthInsurance;
import simergy.core.patients.Patient;
import simergy.core.patients.SeverityLevel;
import simergy.core.resources.BloodTest;
import simergy.core.resources.BoxRoom;
import simergy.core.resources.MRI;
import simergy.core.resources.Nurse;
import simergy.core.resources.Physician;
import simergy.core.resources.Radiography;
import simergy.core.resources.ShockRoom;
import simergy.core.resources.Transporter;
import simergy.core.system.EmergencyDept;

public class SeverityLevelPriorityTest {

	@Test
	public void PassIfPriorityPatientIsTreateadInsteadOfOtherPatient() {
		EmergencyDept ed = new EmergencyDept("myED");

		ed.addResource(new Physician(0, "Said","Sammy"));
		ed.addResource(new Nurse(4, "Picard","Alex"));
		ed.addResource(new Nurse(5, "Ripoche","Arnaud"));
		ed.addResource(new Nurse(6, "Picard","Arnaud"));
		ed.addResource(new Transporter(11, "Plessis","Hugo"));
		ed.addResource(new BoxRoom(14));
		ed.addResource(new BoxRoom(15));
		ed.addResource(new ShockRoom(16));
		ed.addResource(new BloodTest(17));
		ed.addResource(new MRI(18));
		ed.addResource(new Radiography(19));
		Patient patient1 = new Patient(SeverityLevel.L5);
		patient1.setHealthInsurance(HealthInsurance.SILVER);
		ed.addWorkflow(new Workflow(ed,patient1));
		System.out.println("Before priority patient'arrival :");
		for(int i=0;i<10;i++){
			ed.updateTest();
			System.out.println(ed.getClock().getTime());
			for(Workflow w : ed.getWorkflows()){
				System.out.println(w.getCurrentEvent());
			}
		}
		
		Patient patient2 = new Patient(SeverityLevel.L1);
		patient2.setHealthInsurance(HealthInsurance.GOLD);
		ed.addWorkflow(new Workflow(ed,patient2));
		assertTrue(ed.getWorkflows().get(0).getPatient()==patient2);
		System.out.println("\nAfter priority patient'arrival :");
		for(int i=0;i<30;i++){
			ed.updateTest();
			System.out.println(ed.getClock().getTime());
			for(Workflow w : ed.getWorkflows()){
				System.out.println(w.getCurrentEvent());
			}
			if(ed.getWorkflows().get(0).getCurrentEvent().getType()=="CONSULTATION"){
				assertTrue(patient2.getPhysician().nextPatient()==patient2);
			}
		}
	}

}
