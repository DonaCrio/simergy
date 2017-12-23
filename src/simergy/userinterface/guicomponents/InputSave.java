/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import simergy.userinterface.commandfactory.CommandFactory;
import simergy.userinterface.intefaces.GraphicalUserInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InputSave.
 */
public class InputSave {

	/** The main panel. */
	private MainPanel mainPanel;
	
	/** The factory. */
	private CommandFactory factory;
	
	/** The file chooser. */
	private JFileChooser fileChooser;
	
	/**
	 * Instantiates a new input save.
	 *
	 * @param gui the gui
	 */
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
	
	/**
	 * Compute params.
	 *
	 * @return the string
	 */
	public String computeParams(){
		String fileName = fileChooser.getSelectedFile().getName();
		return(" " + fileName);
	}
}
