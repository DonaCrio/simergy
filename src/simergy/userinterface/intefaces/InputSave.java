package simergy.userinterface.intefaces;

import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import simergy.userinterface.clui.CommandFactory;

public class InputSave {

	private MainPanel mainPanel;
	private CommandFactory factory;
	private JFileChooser fileChooser;
	
	public InputSave(GraphicalUserInterface gui){
		this.mainPanel = gui.getMainPanel();
		this.factory = gui.getCommandFactory();
		fileChooser = new JFileChooser(gui.getCurrentDirectory());
		fileChooser.setFileFilter(new FileNameExtensionFilter("Serializable Simergy file (.ser)", "ser"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int returnVal = fileChooser.showOpenDialog(gui.getFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION) 
			mainPanel.display(factory.getCommand(new StringTokenizer("save" + computeParams())).execute());
	}
	
	public String computeParams(){
		String fileName = fileChooser.getSelectedFile().getName();
		return(" " + fileName);
	}
}
