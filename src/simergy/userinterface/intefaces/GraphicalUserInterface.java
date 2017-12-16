package simergy.userinterface.intefaces;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import simergy.core.system.SimErgy;
import simergy.userinterface.guicomponents.MainPanel;
import simergy.userinterface.guicomponents.MenuBar;
import simergy.userinterface.guicomponents.MessagePanel;

public class GraphicalUserInterface extends UserInterface implements Runnable{

	private JFrame frame;
	private MenuBar menuBar;
	private MainPanel mainPanel;
	private MessagePanel messagePanel;
	
	public GraphicalUserInterface(){
		
		frame = new JFrame();
		frame.setTitle("SimErgy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new MainPanel(this);
		frame.getContentPane().add(mainPanel,BorderLayout.CENTER);
		
		menuBar = new MenuBar(this);
		frame.setJMenuBar(menuBar);
		
		messagePanel = new MessagePanel();
		frame.add(messagePanel,BorderLayout.SOUTH);
		
		sys = new SimErgy("default");
	}
	
	@Override
	public void run(){
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args) {
		GraphicalUserInterface gui = new GraphicalUserInterface();
		gui.run();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public MessagePanel getMessagePanel() {
		return messagePanel;
	}

	public void setMessagePanel(MessagePanel messagePanel) {
		this.messagePanel = messagePanel;
	}
}
