/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import simergy.core.system.TimeMachine;

public class TimeMachineTest {

	@Test
	public void assertTrueIfTimeIsIncrementedByOne() {
		TimeMachine timeMachine = new TimeMachine();
		int oldTime = timeMachine.getTime();
		timeMachine.toNextTime();
		int newTime = timeMachine.getTime();
		assertEquals(oldTime+1,newTime);
	}
	
	@Test
	public void asserTrueIfTimeIsCorrectlyComputed() {
		TimeMachine timeMachine2 = new TimeMachine();
		timeMachine2.setTime(1649);
		String expectedResult = "day1:3h29";
		String result = timeMachine2.computeTime();
		assertTrue(result.equals(expectedResult));
	}

}
