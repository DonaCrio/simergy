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
		ed.addResource(new Physician("Said","Sammy"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Ripoche","Arnaud"));
		ed.addResource(new Nurse("Picard","Arnaud"));
		ed.addResource(new Transporter("Cisneros","Hugo"));
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new ShockRoom());
		ed.addResource(new BloodTest());
		ed.addResource(new MRI());
		ed.addResource(new Radiography());
		Patient patient1 = new Patient("Imbert", "Quentin", SeverityLevel.L5);
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
		
		Patient patient2 = new Patient("Suquet", "Victor", SeverityLevel.L1);
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
