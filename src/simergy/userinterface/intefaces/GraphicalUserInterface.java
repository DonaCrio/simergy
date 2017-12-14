package simergy.userinterface.intefaces;

import javax.swing.JFrame;

import simergy.userinterface.cmdfactory.CommandFactory;

public class GraphicalUserInterface extends UserInterface implements Runnable{

	private JFrame frame;
	
	public GraphicalUserInterface(){
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setJMenuBar(new MenuBar(this));
	}
	
	@Override
	public void run(){
		
	}
	
	public static void main(String[] args) {
		GraphicalUserInterface gui = new GraphicalUserInterface();
	}

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}
}
