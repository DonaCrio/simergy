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

public abstract class InputTab extends JPanel{

	private static final long serialVersionUID = 4458682304440431610L;
	
	protected MainPanel mainPanel;
	protected CommandFactory factory;
	protected String name;
	protected String cmd;
	protected JButton validation;
	protected JButton cancel;
	private InputTab obj;
	
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
	
	public abstract String computeParams();

	public String getName() {
		return name;
	}

	
}
