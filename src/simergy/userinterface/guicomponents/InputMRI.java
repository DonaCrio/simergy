package simergy.userinterface.guicomponents;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public class InputMRI extends InputHealthService{

	private static final long serialVersionUID = -3540761791656995923L;

	public InputMRI(GraphicalUserInterface gui) {
		super("Add new MRI", "addMRI", gui);
	}

}
