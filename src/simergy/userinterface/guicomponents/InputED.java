package simergy.userinterface.guicomponents;

import javax.swing.JTextField;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public class InputED extends InputTab{

	private static final long serialVersionUID = -6329405195154788866L;

	private JTextField inputName;
	
	public InputED(GraphicalUserInterface gui){
		super("Create new ED", "createED", gui);
		inputName = new JTextField("Name of the new ED");
		this.add(inputName);
	}
	
	public String computeParams(){
		return(" " + inputName.getText());
	}
}
