package simergy.userinterface.intefaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class InputHumanResource extends InputTab{

	private static final long serialVersionUID = -290194176764468417L;
	private JTextField inputName;
	private JTextField inputSurname;
	private String EDName;

	public InputHumanResource(String name, String type, GraphicalUserInterface gui){
		super(name, type, gui);
		this.EDName = gui.getCurrentED()==null?" ":gui.getCurrentED().getName();
		JPanel pan = new JPanel();
//		pan.setPreferredSize(new Dimension(500,100));
		pan.setLayout(new GridLayout(2,2));
		JTextArea t1 = new JTextArea("Name");
		inputName = new JTextField();
		JTextArea t2 = new JTextArea("Surname");
		inputSurname = new JTextField();
		
//		t1.setMaximumSize(new Dimension(20,20));
//		inputName.setMaximumSize(new Dimension(20,20));
//		t2.setMaximumSize(new Dimension(20,20));
//		inputSurname.setMaximumSize(new Dimension(20,20));
		pan.add(t1);		
		pan.add(inputName);
		pan.add(t2);
		pan.add(inputSurname);
		
		this.add(pan,BorderLayout.NORTH);
	}
	
	public String computeParams(){
		System.out.println(" " + inputName.getText() + " " + inputSurname.getText());
		return(" " + EDName + " " + inputName.getText() + " " + inputSurname.getText());
	}
}
