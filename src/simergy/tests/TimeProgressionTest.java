package simergy.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import simergy.core.events.Event;
import simergy.core.system.EmergencyDept;
import simergy.core.system.SimErgy;
import simergy.userinterface.intefaces.LoadSave;

public class TimeProgressionTest {

	@Test
	public void PassIfNewTimeIsLargerThanPrevious() {
		SimErgy sys = LoadSave.loadSys("testP.ser");
		EmergencyDept ed = sys.getEDs().get("myED");
		double endTime = 1440;
		simulationTest(sys, ed, endTime);
	}
	
	public static void simulationTest(SimErgy sys, EmergencyDept ed, double endTime){
		double simTime = 0;
		ArrayList<Event> eventQueue = new ArrayList<Event>();
		ArrayList<Integer> enabledEvents = new ArrayList<Integer>();
		sys.initializeSimErgy(ed);
		enabledEvents = sys.updateEnabledEvents(ed);
		eventQueue = sys.updateEventQueue(enabledEvents, ed);
		while(simTime < endTime){
			System.out.println(simTime);
			System.out.println(eventQueue);
			Event e = eventQueue.get(0);
			sys.executeEvent(e);
			assertTrue(simTime<=e.getOccurenceTime());
			simTime = e.getOccurenceTime();
			ed.setTime(simTime);
			enabledEvents = sys.updateEnabledEvents(ed);
			eventQueue = sys.updateEventQueue(enabledEvents, ed);
		}
	}
}
