/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuBar.
 */
public class MenuBar extends JMenuBar{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1962445858262321682L;
	

	/**
	 * Instantiates a new menu bar.
	 *
	 * @param gui the gui
	 */
	public MenuBar(GraphicalUserInterface gui){

		JMenu menu1 = new JMenu("File");
		JMenuItem menu11 = new JMenuItem("Save...");
		JMenuItem menu12 = new JMenuItem("Load...");
		JMenuItem menu13 = new JMenuItem("Display current Save");
		menu11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				new InputSave(gui);
			}
		});
		menu12.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				new InputLoad(gui);
			}
		});
		menu13.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().display(gui.getCommandFactory().getCommand(new StringTokenizer("currentSave")).execute());
			}
		});
		menu1.add(menu11);
		menu1.add(menu12);
		menu1.add(menu13);
		this.add(menu1);
		
		JMenu menu2 = new JMenu("Emergency Department");
		JMenuItem menu21 = new JMenuItem("Create new ED");
		JMenuItem menu22 = new JMenuItem("Select ED");
		JMenuItem menu23 = new JMenuItem("Display ED");
		JMenuItem menu24 = new JMenuItem("Reset ED");
		
		menu21.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputED(gui));
			}
		});
		menu22.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputSelectED(gui));
			}
		});
		menu23.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(gui.getCurrentED()!=null){
					gui.getMainPanel().getDisplayPane().buildED(gui.getCurrentED());
					gui.getMainPanel().validate();
				}else{
					gui.getMainPanel().display("ERROR : No ED is selected.");
				}
			}
				
		});
		menu24.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int choice = JOptionPane.showOptionDialog(gui.getFrame(), "Are you sure you want to reset " + gui.getCurrentED().getName(), 
						"Reset " + gui.getCurrentED().getName(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null);
				if(choice == JOptionPane.YES_NO_OPTION){
					gui.getMainPanel().display(gui.getCommandFactory().getCommand(new StringTokenizer("reset " + gui.getCurrentED().getName())).execute());
				}
			}
		});
		
		menu2.add(menu21);
		menu2.add(menu22);
		menu2.add(menu23);
		menu2.add(menu24);
		this.add(menu2);
		
		JMenu menu3 = new JMenu("Add");
		JMenu menu31 = new JMenu("Add employee");
		JMenu menu32 = new JMenu("Add service");
		JMenuItem menu33 = new JMenuItem("Add room...");
		JMenuItem menu34 = new JMenuItem("Add patient...");
		JMenuItem menu311 = new JMenuItem("Add physician...");
		JMenuItem menu312 = new JMenuItem("Add nurse...");
		JMenuItem menu313 = new JMenuItem("Add transporter...");
		JMenuItem menu321 = new JMenuItem("Add Radiography...");
		JMenuItem menu322 = new JMenuItem("Add MRI...");
		JMenuItem menu323 = new JMenuItem("Add Blood Test...");
		menu311.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputPhysi(gui));
			}
		});
		menu312.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputNurse(gui));
			}
		});
		menu313.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputTransp(gui));
			}
		});
		menu321.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputRadioService(gui));
			}
		});
		menu322.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputMRI(gui));
			}
		});
		menu323.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputBloodTest(gui));
			}
		});
		menu33.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputRoom(gui));
			}
		});
		menu34.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gui.getMainPanel().addInputTab(new InputPatient(gui));
			}
		});
		menu31.add(menu311);
		menu31.add(menu312);
		menu31.add(menu313);
		menu32.add(menu321);
		menu32.add(menu322);
		menu32.add(menu323);
		menu3.add(menu31);
		menu3.add(menu32);
		menu3.add(menu33);
		menu3.add(menu34);
		this.add(menu3);
		
		JMenu menu4 = new JMenu("Simulation");
		JMenuItem menu41 = new JMenuItem("Run Simulation...");
		JMenuItem menu42 = new JMenuItem("Set patient arrival time...");
		menu41.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(gui.getCurrentED()!=null){
					gui.getMainPanel().addInputTab(new InputSimulation(gui));
				}else{
					gui.getMainPanel().display("ERROR : No Ed is selected");
				}
			}
		});
		menu42.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(gui.getCurrentED()!=null){
					gui.getMainPanel().addInputTab(new InputPatientArrival(gui));
				}else{
					gui.getMainPanel().display("ERROR : No Ed is selected");
				}
			}
		});
		
		menu4.add(menu41);
		menu4.add(menu42);
		this.add(menu4);
		
	}
}
