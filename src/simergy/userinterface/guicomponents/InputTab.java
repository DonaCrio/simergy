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
import javax.swing.JPanel;

import simergy.userinterface.commandfactory.CommandFactory;
import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputTab.
 */
public abstract class InputTab extends JPanel{

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
	private InputTab obj;
	
	/**
	 * Instantiates a new input tab.
	 *
	 * @param name the name
	 * @param command the command
	 * @param gui the gui
	 */
	public InputTab(String name, String command, GraphicalUserInterface gui){
		obj = this;
		this.name = name;
		this.cmd = command;
		this.mainPanel = gui.getMainPanel();
		this.factory = gui.getCommandFactory();
		setLayout(new BorderLayout());
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1,2));
		this.validation = new JButton(name);
		validation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainPanel.display(factory.getCommand(new StringTokenizer(cmd + computeParams())).execute());
				mainPanel.getTabbedPane().remove(obj);
			}
		});
		pan.add(validation);
		this.cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainPanel.getTabbedPane().remove(obj);
			}
		});
		pan.add(cancel);
		this.add(pan,BorderLayout.SOUTH);
	}
	
	/**
	 * Compute params.
	 *
	 * @return the string
	 */
	public abstract String computeParams();

	/* (non-Javadoc)
	 * @see java.awt.Component#getName()
	 */
	public String getName() {
		return name;
	}

	
}
