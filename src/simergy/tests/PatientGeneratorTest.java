/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

import simergy.core.patients.*;
import simergy.core.patients.SeverityLevel;
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
		PatientGenerator generator = new PatientGenerator();
		System.out.println(generator);
		int time = generator.getNextPatients().get(SeverityLevel.L1);
		ArrayList<Patient> newPatients = generator.getPatients(time);
		assertTrue(generator.getNextPatients().get(SeverityLevel.L1) >= time);
		System.out.println(generator);
		System.out.println(newPatients);
	}

}
