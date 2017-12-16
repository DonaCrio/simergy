package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import simergy.userinterface.commandfactory.CommandFactory;
import simergy.userinterface.intefaces.GraphicalUserInterface;

public class InputSimulation extends JPanel{

	private static final long serialVersionUID = 6426461615323688847L;

	protected MainPanel mainPanel;
	protected CommandFactory factory;
	protected JButton validation;
	protected JButton cancel;
	
	public InputSimulation(GraphicalUserInterface gui){
		super();
		this.mainPanel = gui.getMainPanel();
		this.factory = gui.getCommandFactory();
		setLayout(new BorderLayout());
		
		JPanel panTop = new JPanel();
		panTop.setLayout(new GridLayout(2,1));
		JTextArea t1 = new JTextArea("Simulation");
		t1.setEditable(false);
		panTop.add(t1);
		JPanel subTop = new JPanel();
		subTop.setLayout(new GridLayout(2,3));
		JTextArea t2 = new JTextArea("Duration");
		t2.setEditable(false);
		subTop.add(t2);
		JTextField t3 = new JTextField();
		subTop.add(t3);
		JTextArea t4 = new JTextArea("Minutes");
		t2.setEditable(false);
		subTop.add(t4);
		JTextArea t5 = new JTextArea("Enable patient generation");
		t4.setEditable(false);
		subTop.add(t5);
		JRadioButton yes = new JRadioButton("Yes");
		JRadioButton no = new JRadioButton("No",true);
		ButtonGroup group = new ButtonGroup();
		group.add(yes);
		group.add(no);
		subTop.add(yes);
		subTop.add(no);
		panTop.add(subTop);
		this.add(panTop,BorderLayout.NORTH);
		
		JTextArea kpi = new JTextArea();
		kpi.setEditable(false);
		this.add(kpi,BorderLayout.CENTER);
		
		JPanel panBot = new JPanel();
		JButton b1 = new JButton("Launch simulation");
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(group.getSelection().equals(yes.getModel())) {
					kpi.setText(factory.getCommand(new StringTokenizer("simulation" + " " + (gui.getCurrentED()==null?" ":gui.getCurrentED().getName()
							+ " " + t3.getText() + " activate"))).execute());
				}else{
					kpi.setText(factory.getCommand(new StringTokenizer("simulation" + " " + (gui.getCurrentED()==null?" ":gui.getCurrentED().getName()
							+ " " + t3.getText()))).execute());
				}
			}
		});
		panBot.add(b1);
		JButton b2 = new JButton("Execute next Event");
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainPanel.display(factory.getCommand(new StringTokenizer("executeEvent" + " " + (gui.getCurrentED()==null?" ":gui.getCurrentED().getName()))).execute());
			}
		});
		panBot.add(b2);
		this.add(panBot,BorderLayout.SOUTH);
	}
}
