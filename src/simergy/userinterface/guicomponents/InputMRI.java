/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputMRI.
 */
public class InputMRI extends InputHealthService{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3540761791656995923L;

	/**
	 * Instantiates a new input MRI.
	 *
	 * @param gui the gui
	 */
	public InputMRI(GraphicalUserInterface gui) {
		super("Add new MRI", "addMRI", gui);
	}

}
