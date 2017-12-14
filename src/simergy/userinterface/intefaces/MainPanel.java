package simergy.userinterface.intefaces;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 5447848031915306642L;

	private MessagePanel messagePanel;
	private JTabbedPane tabbedPane;

	/**
	 * Constructor used to intensity the first MainPanel at start.
	 */
	public MainPanel(GraphicalUserInterface gui){
		super();
		setLayout(new GridLayout());
		messagePanel = new MessagePanel();
		messagePanel.setPreferredSize(new Dimension(500,500));
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(500,500));
		this.add(tabbedPane);
		this.add(messagePanel);
		this.setPreferredSize(new Dimension(1000,500));
	}
	
	public void display(String message){
		messagePanel.setText(message);
	}
	
	public void addInputTab(InputTab p){
		tabbedPane.addTab(p.getName(), p);
	}

	public MessagePanel getMessagePanel() {
		return messagePanel;
	}

	public void setMessagePanel(MessagePanel messagePanel) {
		this.messagePanel = messagePanel;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
}
