package simergy.userinterface.guicomponents;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public class InputRadioService extends InputHealthService{

	private static final long serialVersionUID = -5260588711202735300L;

	public InputRadioService(GraphicalUserInterface gui) {
		super("Add new Radiography", "addRadioService", gui);
	}
}
