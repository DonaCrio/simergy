package simergy.userinterface.guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;

public class DisplayPane extends JPanel{

	private static final long serialVersionUID = 4504175158554536978L;
	
	public void buildED(EmergencyDept ed){
		if(ed!=null){
			this.removeAll();
			setLayout(new BorderLayout());
			JEditorPane name = new JEditorPane();
			name.setText(ed.getName());
			name.setEditable(false);
			this.add(name,BorderLayout.NORTH);
			
			JPanel content = new JPanel();
			content.setLayout(new GridLayout(1,2));
			
			JPanel resourcePane = new JPanel();
			resourcePane.setLayout(new GridLayout(0,1));
			for(String resourceType : ed.getResources().keySet()){
				JPanel p = new JPanel();
				p.setLayout(new GridLayout(1,2));
				JEditorPane resourceName = new JEditorPane();
				resourceName.setText(resourceType.charAt(0)+resourceType.substring(1).toLowerCase());
				resourceName.setEditable(false);
				p.add(resourceName);
				JEditorPane resource = new JEditorPane();
				String t = "";
				for(Resource r : ed.getResources().get(resourceType)){
					t += " " + r.getName();
				}
				resource.setText(t);	
				resource.setEditable(false);
				p.add(resource);
				resourcePane.add(p);
			}
		
			content.add(new JScrollPane(resourcePane));
			this.add(content,BorderLayout.CENTER);
			
//			eventPane = new JPanel();
//			this.add(eventPane,BorderLayout.SOUTH);
		}else{
			setLayout(new BorderLayout());
			JEditorPane start = new JEditorPane();
			start.setText("Welcome to Simergy.\n"
					+ "\nThis tool emulates an emergency department."
					+ "\n\nTo get started we strongly advice you to read the help by clicking 'help' in the menu bar.\n"
					+ "\nTo load a previous configuration, click File > load...");
			this.add(start, BorderLayout.NORTH);
		}
	}
}
