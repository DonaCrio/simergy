package simergy.userinterface.intefaces;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import simergy.core.system.EmergencyDept;
import simergy.userinterface.clui.CommandFactory;

public class InputLoad {

	private MainPanel mainPanel;
	private CommandFactory factory;
	private JFileChooser fileChooser;
	
	public InputLoad(GraphicalUserInterface gui){
		this.mainPanel = gui.getMainPanel();
		this.factory = gui.getCommandFactory();
		fileChooser = new JFileChooser(gui.getCurrentDirectory());
		fileChooser.setFileFilter(new FileNameExtensionFilter("Serializable Simergy file (.ser)", "ser"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int returnVal = fileChooser.showOpenDialog(gui.getFrame());
		if (returnVal == JFileChooser.APPROVE_OPTION){
			mainPanel.display(factory.getCommand(new StringTokenizer("load" + computeParams())).execute());
			gui.getFrame().setTitle("SimErgy : " + fileChooser.getSelectedFile().getName());
			HashMap<String,EmergencyDept> EDs = gui.getSys().getEDs();
			if(EDs.size()>0){
				gui.setCurrentED(EDs.get(EDs.keySet().toArray(new String[EDs.keySet().size()])[0]));
			}else{
				gui.setCurrentED(null);
			}
		}
			
	}
	
	public String computeParams(){
		String fileName = fileChooser.getSelectedFile().getName();
		return(" " + fileName);
	}
}
