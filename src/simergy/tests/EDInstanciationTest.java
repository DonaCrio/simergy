/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import simergy.core.system.EmergencyDept;

public class EDInstanciationTest {

	@Test
	public void PassIfEDIsCorrectlyInstatiated() {
		EmergencyDept ed = new EmergencyDept("myED");
		assertTrue(ed!=null);
	}

}
