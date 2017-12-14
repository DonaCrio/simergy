package simergy.userinterface.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = -1962445858262321682L;
	private GraphicalUserInterface gui;

	public MenuBar(GraphicalUserInterface gui){
		this.gui = gui;
		
		JMenu menu1 = new JMenu("File");
		JMenuItem menu11 = new JMenuItem("List all saves");
		JMenuItem menu12 = new JMenuItem("Load");
		JMenuItem menu13 = new JMenuItem("Save");
		JMenuItem menu14 = new JMenuItem("Display current Save");
		menu11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println(gui.getCommandFactory().getCommand(new StringTokenizer("listSaves")).execute());;
			}
			
		});
//		menu12.addActionListener(gui);
//		menu13.addActionListener(gui);
//		menu14.addActionListener(gui);
		menu1.add(menu11);
		menu1.add(menu12);
		menu1.add(menu13);
		menu1.add(menu14);
		this.add(menu1);
		
		JMenu menu2 = new JMenu("Emergency Department");
		JMenuItem menu21 = new JMenuItem("Create new ED");
		JMenuItem menu22 = new JMenuItem("Select ED");
		JMenuItem menu23 = new JMenuItem("Reset ED");
//		menu21.addActionListener(gui);
//		menu22.addActionListener(gui);
//		menu23.addActionListener(gui);
		menu2.add(menu21);
		menu2.add(menu22);
		menu2.add(menu23);
		this.add(menu2);
		
		JMenu menu3 = new JMenu("Add...");
		JMenu menu31 = new JMenu("Add employee");
		JMenu menu32 = new JMenu("Add service");
		JMenu menu33 = new JMenu("Add room");
		JMenuItem menu34 = new JMenuItem("Add patient");
		JMenuItem menu311 = new JMenuItem("Add physician");
		JMenuItem menu312 = new JMenuItem("Add nurse");
		JMenuItem menu313 = new JMenuItem("Add transporter");
		JMenuItem menu321 = new JMenuItem("Add radiography service");
		JMenuItem menu322 = new JMenuItem("Add blood test service");
		JMenuItem menu323 = new JMenuItem("Add MRI service");
		JMenuItem menu331 = new JMenuItem("Add box room");
		JMenuItem menu332 = new JMenuItem("Add shock room");
//		menu34.addActionListener(gui);
//		menu311.addActionListener(gui);
//		menu312.addActionListener(gui);
//		menu313.addActionListener(gui);
//		menu321.addActionListener(gui);
//		menu322.addActionListener(gui);
//		menu323.addActionListener(gui);
//		menu331.addActionListener(gui);
//		menu332.addActionListener(gui);
		menu31.add(menu311);
		menu31.add(menu312);
		menu31.add(menu313);
		menu32.add(menu321);
		menu32.add(menu322);
		menu32.add(menu323);
		menu33.add(menu331);
		menu33.add(menu332);
		menu3.add(menu31);
		menu3.add(menu32);
		menu3.add(menu33);
		menu3.add(menu34);
		this.add(menu3);
		
		JMenu menu4 = new JMenu("Simulation");
		JMenuItem menu41 = new JMenuItem("Execute next event");
		JMenuItem menu42 = new JMenuItem("Simulation...");
		menu4.add(menu41);
		menu4.add(menu42);
		this.add(menu4);
		
	}
}
