/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import org.junit.Test;

import simergy.core.patients.SeverityLevel;
import simergy.core.system.EmergencyDept;
import simergy.core.system.PatientGenerator;

public class PatientGeneratorTest {

	//Ici on test si le constructeur est valide (on a un HashMap(SeverityLevel/prochaine occurence temporelle)
/*	@Test
	public void generatedPatientAreOK() {
		PatientGenerator generator = new PatientGenerator();
		System.out.println(generator);
	}
*/
	// Ici on vérifie que la méthode createPatients a bien généré une autre occurence valide et retourné un ArrayList des nouveaux patients
	@Test
	public void PassIfANewPatientIsGeneratedTest(){
		EmergencyDept ed = new EmergencyDept("myED");
		PatientGenerator generator = new PatientGenerator(ed);
		System.out.println(ed.getWorkflows());
		generator.initializePatients();
		System.out.println(ed.getWorkflows());
		generator.giveNewPatient(0,SeverityLevel.L1);
		System.out.println(ed.getWorkflows());
	}

}
