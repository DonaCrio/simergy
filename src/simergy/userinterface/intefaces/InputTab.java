package simergy.userinterface.intefaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JPanel;

import simergy.userinterface.clui.CommandFactory;

public abstract class InputTab extends JPanel{

	private static final long serialVersionUID = 4458682304440431610L;
	
	protected MainPanel mainPanel;
	protected CommandFactory factory;
	protected String name;
	protected String cmd;
	protected JButton validation;
	private InputTab obj;
	
	public InputTab(String name, String cmd, GraphicalUserInterface gui){
		obj = this;
		this.name = name;
		this.cmd = cmd;
		this.mainPanel = gui.getMainPanel();
		this.factory = gui.getCommandFactory();
		setLayout(new BorderLayout());
		this.validation = new JButton(name);
		validation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainPanel.display(factory.getCommand(new StringTokenizer(cmd + computeParams())).execute());
				mainPanel.getTabbedPane().remove(obj);
			}
		});
		this.add(validation,BorderLayout.SOUTH);
	}
	
	public abstract String computeParams();

	public String getName() {
		return name;
	}

	
}
