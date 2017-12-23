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

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputHealthService.
 */
public abstract class InputHealthService extends InputTab{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -290194176764468417L;
	
	/** The distribution type. */
	private JComboBox<String> distributionType;
	
	/** The param 1. */
	private JTextField param1;
	
	/** The param 2. */
	private JTextField param2;
	
	/** The ED name. */
	private String EDName;

	/**
	 * Instantiates a new input health service.
	 *
	 * @param name the name
	 * @param cmd the cmd
	 * @param gui the gui
	 */
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
	
	/* (non-Javadoc)
	 * @see simergy.userinterface.guicomponents.InputTab#computeParams()
	 */
	public String computeParams(){
		return(" " + EDName + " " + ((String)distributionType.getSelectedItem()).toUpperCase()
				+ " " + param1.getText() + "  " + param2.getText());
	}
}
