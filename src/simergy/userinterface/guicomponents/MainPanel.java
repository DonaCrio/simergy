/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class MainPanel.
 */
public class MainPanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5447848031915306642L;

	/** The gui. */
	private GraphicalUserInterface gui;
	
	/** The tabbed pane. */
	private JTabbedPane tabbedPane;
	
	/** The display pane. */
	private DisplayPane displayPane;

	/**
	 * Instantiates a new main panel.
	 *
	 * @param gui the gui
	 */
	public MainPanel(GraphicalUserInterface gui){
		super();
		this.gui = gui;
		setLayout(new GridLayout());
		
		tabbedPane = new TabBackground();
		tabbedPane.setPreferredSize(new Dimension(500,500));
		this.add(tabbedPane);
		
		displayPane = new DisplayPane();
		displayPane.buildED(null);
		displayPane.setPreferredSize(new Dimension(500,500));
		this.add(new JScrollPane(displayPane));
		
		this.setPreferredSize(new Dimension(1000,500));
		setBackground(Color.WHITE);
	}
	
	/**
	 * Display.
	 *
	 * @param message the message
	 */
	public void display(String message){
		gui.getMessagePanel().setText(message);
	}
	
	/**
	 * Adds the input tab.
	 *
	 * @param p the p
	 */
	public void addInputTab(JPanel p){
		tabbedPane.addTab(p.getName(), p);
	}

	/**
	 * Gets the tabbed pane.
	 *
	 * @return the tabbed pane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * Sets the tabbed pane.
	 *
	 * @param tabbedPane the new tabbed pane
	 */
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	/**
	 * Gets the display pane.
	 *
	 * @return the display pane
	 */
	public DisplayPane getDisplayPane() {
		return displayPane;
	}

	/**
	 * Sets the display pane.
	 *
	 * @param displayPane the new display pane
	 */
	public void setDisplayPane(DisplayPane displayPane) {
		this.displayPane = displayPane;
	}
}
