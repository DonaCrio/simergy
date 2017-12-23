/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputPhysi.
 */
public class InputPhysi extends InputHumanResource{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -434139648848565225L;

	/**
	 * Instantiates a new input physi.
	 *
	 * @param gui the gui
	 */
	public InputPhysi(GraphicalUserInterface gui){
		super("Add new physician","addPhysi",gui);
	}
}
