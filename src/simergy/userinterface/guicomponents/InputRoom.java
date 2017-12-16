package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import simergy.userinterface.intefaces.GraphicalUserInterface;

public class InputRoom  extends InputTab{

	private static final long serialVersionUID = -290194176764468417L;
	private JComboBox<String> roomType;
	private String EDName;

	public InputRoom(GraphicalUserInterface gui){
		super("Add new room", "addRoom",gui);
		this.EDName = gui.getCurrentED()==null?" ":gui.getCurrentED().getName();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1,2));
		JTextArea t1 = new JTextArea("Type");
		t1.setEditable(false);
		roomType = new JComboBox<String>(new String[]{"Box room", "Shock room"});
	
		pan.add(t1);		
		pan.add(roomType);
		this.add(pan,BorderLayout.NORTH);
	}
	
	public String computeParams(){
		String choice = ((String)roomType.getSelectedItem());
		if(choice.contentEquals("Box room")){
			return(" " + EDName + " " + "boxRoom");
		}else if(choice.contentEquals("Shock room")){
			return(" " + EDName + " " + "shockRoom");
		}else{
			return("");
		}
		
	}
}
