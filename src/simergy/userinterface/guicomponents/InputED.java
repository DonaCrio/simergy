/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import javax.swing.JTextField;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputED.
 */
public class InputED extends InputTab{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6329405195154788866L;

	/** The input name. */
	private JTextField inputName;
	
	/**
	 * Instantiates a new input ED.
	 *
	 * @param gui the gui
	 */
	public InputED(GraphicalUserInterface gui){
		super("Create new ED", "createED", gui);
		inputName = new JTextField("Name of the new ED");
		this.add(inputName);
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.guicomponents.InputTab#computeParams()
	 */
	public String computeParams(){
		return(" " + inputName.getText());
	}
}
