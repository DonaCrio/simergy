package simergy.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import simergy.core.patients.*;
import simergy.core.resources.*;

public class WaitingForExamTest {

	@Test
	public void PassIfWaitingQueueIsProgressing() {
		HealthService mri = new MRI(0);
		Patient p1 = new Patient(SeverityLevel.L5);
		Patient p2 = new Patient(SeverityLevel.L5);
		mri.newArrival(p1);
		mri.newArrival(p2);
		assertTrue(mri.nextPatient()==p1);
		assertFalse(mri.nextPatient()==p2);
		mri.hasBeenTreated(p1);
		assertTrue(mri.nextPatient()==p2);
	}

}
