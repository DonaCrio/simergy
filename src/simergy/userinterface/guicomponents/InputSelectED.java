/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.util.Set;

import javax.swing.JComboBox;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputSelectED.
 */
public class InputSelectED extends InputTab{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6329405195154788866L;

	/** The combo box. */
	private JComboBox<String> comboBox;
	
	/**
	 * Instantiates a new input select ED.
	 *
	 * @param gui the gui
	 */
	public InputSelectED(GraphicalUserInterface gui){
		super("Select ED", "selectED", gui);
		Set<String> keys = gui.getSys().getEDs().keySet();
		comboBox = new JComboBox<String>(keys.toArray(new String[keys.size()]));
		this.add(comboBox,BorderLayout.NORTH);
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.guicomponents.InputTab#computeParams()
	 */
	public String computeParams(){
		return(" " + comboBox.getSelectedItem());
	}
}