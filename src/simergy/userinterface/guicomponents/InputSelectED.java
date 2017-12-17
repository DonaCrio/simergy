package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.util.Set;

import javax.swing.JComboBox;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public class InputSelectED extends InputTab{

	private static final long serialVersionUID = -6329405195154788866L;

	private JComboBox<String> comboBox;
	
	public InputSelectED(GraphicalUserInterface gui){
		super("Select ED", "selectED", gui);
		Set<String> keys = gui.getSys().getEDs().keySet();
		comboBox = new JComboBox<String>(keys.toArray(new String[keys.size()]));
		this.add(comboBox,BorderLayout.NORTH);
	}
	
	public String computeParams(){
		return(" " + comboBox.getSelectedItem());
	}
}