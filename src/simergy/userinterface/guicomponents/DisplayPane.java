package simergy.userinterface.guicomponents;

import java.awt.Color;
import javax.swing.JEditorPane;
import simergy.core.resources.Resource;
import simergy.core.system.EmergencyDept;

public class DisplayPane extends JEditorPane{

	private static final long serialVersionUID = 4504175158554536978L;
	
	public DisplayPane(){
		super();
		setBackground(Color.GRAY);
		setContentType("text/html");
	}
	
	public void buildED(EmergencyDept ed){
		if(ed!=null){
			String html =
					"<html>"
					+ "<body>"
					+ "<h2> Informations on " + ed.getName() + "</h2>";
			for(String resourceType : ed.getResources().keySet()){
				html += "<h3>" + resourceType.charAt(0)+resourceType.substring(1).toLowerCase() + " <br>[" 
			+ ed.getResources().get(resourceType).size() + "]  ";
				for(Resource r : ed.getResources().get(resourceType)){
					html += r.getName() + ",";
				}
				html += "</h3>";
			}
			
			html += "</body></html>";
			setText(html);

		}else{
			String html =
					"<html>"
					+ "<body>	"
					+ "<h2>Welcome to Simergy</h2>"
					+ "<p>This tool emulates an emergency department.</p>"
					+ "<p>To get started we strongly advice you to read the help by clicking 'help' in the menu.</p>"
					+ "<p>To load a previous configuration, click File > load...</p>"
					+ "</body></html>";
			setText(html);
		}
	}
}
