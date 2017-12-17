package simergy.userinterface.guicomponents;

import java.awt.Color;

import javax.swing.JEditorPane;

public class MessagePanel extends JEditorPane{

	private static final long serialVersionUID = 667080774509109058L;
	
	public MessagePanel(){
		super();
		setEditable(false);
		setBackground(Color.WHITE);
	}

}
