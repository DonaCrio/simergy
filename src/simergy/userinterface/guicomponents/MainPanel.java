package simergy.userinterface.guicomponents;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 5447848031915306642L;

	private GraphicalUserInterface gui;
	private JTabbedPane tabbedPane;
	private DisplayPane displayPane;

	/**
	 * Constructor used to intensity the first MainPanel at start.
	 */
	public MainPanel(GraphicalUserInterface gui){
		super();
		this.gui = gui;
		setLayout(new GridLayout());
		tabbedPane = new JTabbedPane();
		this.add(tabbedPane);
		displayPane = new DisplayPane();
		displayPane.buildED(null);
		this.add(displayPane);
		this.setPreferredSize(new Dimension(1000,500));
	}
	
	public void display(String message){
		gui.getMessagePanel().setText(message);
	}
	
	public void addInputTab(JPanel p){
		tabbedPane.addTab(p.getName(), p);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public DisplayPane getDisplayPane() {
		return displayPane;
	}

	public void setDisplayPane(DisplayPane displayPane) {
		this.displayPane = displayPane;
	}
}
