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

public class InputPatient extends InputTab{

	private static final long serialVersionUID = -290194176764468417L;
	private JTextField inputName;
	private JTextField inputSurname;
	private JComboBox<SeverityLevel> severityLevel;
	private JComboBox<HealthInsurance> healthInsurance;
	private String EDName;

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
	
	public String computeParams(){
		return(" " + EDName + " " + inputName.getText() + " " + inputSurname.getText()
		+ " " + severityLevel.getSelectedItem()+ " " + healthInsurance.getSelectedItem());
	}
}
