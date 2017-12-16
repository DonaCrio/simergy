package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public abstract class InputHealthService extends InputTab{

	private static final long serialVersionUID = -290194176764468417L;
	private JComboBox<String> distributionType;
	private JTextField param1;
	private JTextField param2;
	private String EDName;

	public InputHealthService(String name, String cmd, GraphicalUserInterface gui){
		super(name, cmd,gui);
		this.EDName = gui.getCurrentED()==null?" ":gui.getCurrentED().getName();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3,2));
		JTextArea t1 = new JTextArea("Distribution");
		t1.setEditable(false);
		distributionType = new JComboBox<String>(new String[]{"Deterministic", "Exponential", "Uniform"});
		JTextArea t2 = new JTextArea("Parameter 1");
		t2.setEditable(false);
		param1 = new JTextField();
		JTextArea t3 = new JTextArea("Parameter 2 (if required)");
		t3.setEditable(false);
		param2 = new JTextField();
	
		pan.add(t1);
		pan.add(distributionType);
		pan.add(t2);		
		pan.add(param1);
		pan.add(t3);
		pan.add(param2);
		
		this.add(pan,BorderLayout.NORTH);
	}
	
	public String computeParams(){
		return(" " + EDName + " " + ((String)distributionType.getSelectedItem()).toUpperCase()
				+ " " + param1.getText() + "  " + param2.getText());
	}
}
