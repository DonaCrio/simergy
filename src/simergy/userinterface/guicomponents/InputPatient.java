/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import simergy.core.patients.HealthInsurance;
import simergy.core.patients.SeverityLevel;
import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputPatient.
 */
public class InputPatient extends InputTab{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -290194176764468417L;
	
	/** The input name. */
	private JTextField inputName;
	
	/** The input surname. */
	private JTextField inputSurname;
	
	/** The severity level. */
	private JComboBox<SeverityLevel> severityLevel;
	
	/** The health insurance. */
	private JComboBox<HealthInsurance> healthInsurance;
	
	/** The ED name. */
	private String EDName;

	/**
	 * Instantiates a new input patient.
	 *
	 * @param gui the gui
	 */
	public InputPatient(GraphicalUserInterface gui){
		super("Add new Patient", "addPatient", gui);
		this.EDName = gui.getCurrentED()==null?" ":gui.getCurrentED().getName();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(4,2));
		JTextArea t1 = new JTextArea("Name");
		t1.setEditable(false);
		inputName = new JTextField();
		JTextArea t2 = new JTextArea("Surname");
		t2.setEditable(false);
		inputSurname = new JTextField();
		JTextArea t3 = new JTextArea("Severity Level");
		t3.setEditable(false);
		severityLevel = new JComboBox<SeverityLevel>(SeverityLevel.values());
		JTextArea t4 = new JTextArea("HealthInsurance");
		t4.setEditable(false);
		healthInsurance = new JComboBox<HealthInsurance>(HealthInsurance.values());
	
		pan.add(t1);		
		pan.add(inputName);
		pan.add(t2);
		pan.add(inputSurname);
		pan.add(t3);		
		pan.add(severityLevel);
		pan.add(t4);
		pan.add(healthInsurance);
		
		this.add(pan,BorderLayout.NORTH);
	}
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.guicomponents.InputTab#computeParams()
	 */
	public String computeParams(){
		return(" " + EDName + " " + inputName.getText() + " " + inputSurname.getText()
		+ " " + severityLevel.getSelectedItem()+ " " + healthInsurance.getSelectedItem());
	}
}
