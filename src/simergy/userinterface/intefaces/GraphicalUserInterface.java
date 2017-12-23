/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.intefaces;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import simergy.core.system.SimErgy;
import simergy.userinterface.guicomponents.MainPanel;
import simergy.userinterface.guicomponents.MenuBar;
import simergy.userinterface.guicomponents.MessagePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class GraphicalUserInterface.
 */
public class GraphicalUserInterface extends UserInterface implements Runnable{

	/** The frame. */
	private JFrame frame;
	
	/** The menu bar. */
	private MenuBar menuBar;
	
	/** The main panel. */
	private MainPanel mainPanel;
	
	/** The message panel. */
	private MessagePanel messagePanel;
	
	/**
	 * Instantiates a new graphical user interface.
	 */
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
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		frame.setVisible(true);
		frame.pack();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		GraphicalUserInterface gui = new GraphicalUserInterface();
		gui.run();
	}

	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Sets the frame.
	 *
	 * @param frame the new frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Gets the menu bar.
	 *
	 * @return the menu bar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * Sets the menu bar.
	 *
	 * @param menuBar the new menu bar
	 */
	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * Gets the main panel.
	 *
	 * @return the main panel
	 */
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * Sets the main panel.
	 *
	 * @param mainPanel the new main panel
	 */
	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	/**
	 * Gets the message panel.
	 *
	 * @return the message panel
	 */
	public MessagePanel getMessagePanel() {
		return messagePanel;
	}

	/**
	 * Sets the message panel.
	 *
	 * @param messagePanel the new message panel
	 */
	public void setMessagePanel(MessagePanel messagePanel) {
		this.messagePanel = messagePanel;
	}
}
