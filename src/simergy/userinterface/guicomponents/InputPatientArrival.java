/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import simergy.core.patients.SeverityLevel;
import simergy.userinterface.commandfactory.CommandFactory;
import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputPatientArrival.
 */
public class InputPatientArrival extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4458682304440431610L;
	
	/** The main panel. */
	protected MainPanel mainPanel;
	
	/** The factory. */
	protected CommandFactory factory;
	
	/** The name. */
	protected String name;
	
	/** The cmd. */
	protected String cmd;
	
	/** The validation. */
	protected JButton validation;
	
	/** The cancel. */
	protected JButton cancel;
	
	/** The obj. */
	private JPanel obj;
	
	/** The severity level. */
	private JComboBox<SeverityLevel> severityLevel;
	
	/** The ED name. */
	private String EDName;
	
	/** The distribution type. */
	private JComboBox<String> distributionType;
	
	/** The param 1. */
	private JTextField param1;
	
	/** The param 2. */
	private JTextField param2;
	
	/**
	 * Instantiates a new input patient arrival.
	 *
	 * @param gui the gui
	 */
	public InputPatientArrival(GraphicalUserInterface gui){
		super();
		obj = this;
		this.name = "Set patient arrival";
		this.cmd = "";
		this.mainPanel = gui.getMainPanel();
		this.factory = gui.getCommandFactory();
		this.EDName = gui.getCurrentED()==null?" ":gui.getCurrentED().getName();
		setLayout(new BorderLayout());
		
		JPanel panS = new JPanel();
		panS.setLayout(new GridLayout(1,2));
		this.validation = new JButton(name);
		validation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainPanel.display(factory.getCommand(new StringTokenizer(cmd + computeParams())).execute());
				mainPanel.getTabbedPane().remove(obj);
			}
		});
		panS.add(validation);
		this.cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainPanel.getTabbedPane().remove(obj);
			}
		});
		panS.add(cancel);
		this.add(panS,BorderLayout.SOUTH);
		
		JPanel panN = new JPanel();
		panN.setLayout(new GridLayout(4,2));
		JTextArea t0 = new JTextArea("Severity Level");
		t0.setEditable(false);
		severityLevel = new JComboBox<SeverityLevel>(SeverityLevel.values());
		panN.add(t0);
		panN.add(severityLevel);
		
		JTextArea t1 = new JTextArea("Distribution");
		t1.setEditable(false);
		distributionType = new JComboBox<String>(new String[]{"Deterministic", "Exponential", "Uniform"});
		JTextArea t2 = new JTextArea("Parameter 1");
		t2.setEditable(false);
		param1 = new JTextField();
		JTextArea t3 = new JTextArea("Parameter 2 (if required)");
		t3.setEditable(false);
		param2 = new JTextField();
	
		panN.add(t1);
		panN.add(distributionType);
		panN.add(t2);		
		panN.add(param1);
		panN.add(t3);
		panN.add(param2);
		
		this.add(panN,BorderLayout.NORTH);
	}

	
	
	/**
	 * Compute params.
	 *
	 * @return the string
	 */
	public String computeParams(){
		return("set" + severityLevel.getSelectedItem() + "arrivalDist " + EDName + " " + ((String)distributionType.getSelectedItem()).toUpperCase()
				+ " " + param1.getText() + "  " + param2.getText());
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#getName()
	 */
	public String getName() {
		return name;
	}

	
}
