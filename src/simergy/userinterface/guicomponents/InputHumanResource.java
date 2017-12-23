/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputHumanResource.
 */
public abstract class InputHumanResource extends InputTab{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -290194176764468417L;
	
	/** The input name. */
	private JTextField inputName;
	
	/** The input surname. */
	private JTextField inputSurname;
	
	/** The ED name. */
	private String EDName;

	/**
	 * Instantiates a new input human resource.
	 *
	 * @param name the name
	 * @param type the type
	 * @param gui the gui
	 */
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
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.guicomponents.InputTab#computeParams()
	 */
	public String computeParams(){
		return(" " + EDName + " " + inputName.getText() + " " + inputSurname.getText());
	}
}
