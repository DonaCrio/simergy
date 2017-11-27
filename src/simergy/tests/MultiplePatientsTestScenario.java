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
		Patient patient1 = new Patient("Imbert", "Quentin", SeverityLevel.L4);
		patient1.setHealthInsurance(HealthInsurance.SILVER);
		Patient patient2 = new Patient("Suquet", "Victor", SeverityLevel.L4);
		patient2.setHealthInsurance(HealthInsurance.GOLD);
		ed.addWorkflow(new Workflow(ed,patient1));
		ed.addWorkflow(new Workflow(ed,patient2));
		//for(int i=0;i<20;i++){
		while(ed.getWorkflows().get(0).getPatient().getState()!=PatientState.R || ed.getWorkflows().get(1).getPatient().getState()!=PatientState.R){
			ed.updateTest();
			System.out.println("Time = "+ ed.getClock().getTime());
			System.out.println(ed.getWorkflows().get(0).getCurrentEvent().toString());
			System.out.println(ed.getWorkflows().get(0).getPatient().getPhysician().toString());
			System.out.println(ed.getWorkflows().get(1).getCurrentEvent().toString());
			System.out.println(ed.getWorkflows().get(1).getPatient().getPhysician().toString()+"\n");
		}
	}

}
