package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public abstract class InputHumanResource extends InputTab{

	private static final long serialVersionUID = -290194176764468417L;
	private JTextField inputName;
	private JTextField inputSurname;
	private String EDName;

	public InputHumanResource(String name, String type, GraphicalUserInterface gui){
		super(name, type, gui);
		this.EDName = gui.getCurrentED()==null?" ":gui.getCurrentED().getName();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2,2));
		JTextArea t1 = new JTextArea("Name");
		t1.setEditable(false);
		inputName = new JTextField();
		JTextArea t2 = new JTextArea("Surname");
		t2.setEditable(false);
		inputSurname = new JTextField();
	
		pan.add(t1);		
		pan.add(inputName);
		pan.add(t2);
		pan.add(inputSurname);
		
		this.add(pan,BorderLayout.NORTH);
	}
	
	public String computeParams(){
		return(" " + EDName + " " + inputName.getText() + " " + inputSurname.getText());
	}
}
