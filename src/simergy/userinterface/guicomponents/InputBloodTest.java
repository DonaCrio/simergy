/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputBloodTest.
 */
public class InputBloodTest extends InputHealthService{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8013834537547197543L;

	/**
	 * Instantiates a new input blood test.
	 *
	 * @param gui the gui
	 */
	public InputBloodTest(GraphicalUserInterface gui) {
		super("Add new Blood Test", "addBloodTest", gui);
	}
}
