package simergy.userinterface.intefaces;

import javax.swing.JFrame;

public class GraphicalUserInterface extends UserInterface implements Runnable{

	private JFrame frame;
	private MenuBar menuBar;
	private MainPanel mainPanel;
	
	public GraphicalUserInterface(){
		
		frame = new JFrame();
		frame.setTitle("SimErgy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new MainPanel(this);
		frame.setContentPane(mainPanel);
		
		menuBar = new MenuBar(this);
		frame.setJMenuBar(menuBar);
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
}
