/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.Color;

import javax.swing.JEditorPane;

// TODO: Auto-generated Javadoc
/**
 * The Class MessagePanel.
 */
public class MessagePanel extends JEditorPane{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 667080774509109058L;
	
	/**
	 * Instantiates a new message panel.
	 */
	public MessagePanel(){
		super();
		setEditable(false);
		setBackground(Color.WHITE);
	}

}
