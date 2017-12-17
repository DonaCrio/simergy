package simergy.userinterface.guicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import simergy.userinterface.intefaces.GraphicalUserInterface;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 5447848031915306642L;

	private GraphicalUserInterface gui;
	private JTabbedPane tabbedPane;
	private DisplayPane displayPane;

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
