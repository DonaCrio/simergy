package simergy.userinterface.guicomponents;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public class InputBloodTest extends InputHealthService{

	private static final long serialVersionUID = -8013834537547197543L;

	public InputBloodTest(GraphicalUserInterface gui) {
		super("Add new Blood Test", "addBloodTest", gui);
	}
}
