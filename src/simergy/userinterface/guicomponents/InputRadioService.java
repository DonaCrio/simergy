/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputRadioService.
 */
public class InputRadioService extends InputHealthService{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5260588711202735300L;

	/**
	 * Instantiates a new input radio service.
	 *
	 * @param gui the gui
	 */
	public InputRadioService(GraphicalUserInterface gui) {
		super("Add new Radiography", "addRadioService", gui);
	}
}
