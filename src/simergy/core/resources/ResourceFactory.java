/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import java.io.Serializable;

public class ResourceFactory implements Serializable{

	private static final long serialVersionUID = 1395870175966825284L;

	private int i = 0;
	
	public Resource getRessource(String resourceType){
		if(resourceType == null){
	         return null;
	      }		
	      if(resourceType.equalsIgnoreCase("PHYSICIAN")){
	         return new Physician(i++);
	         
	      }else if(resourceType.equalsIgnoreCase("NURSE")){
	         return new Nurse(i++);
	         
	      }else if(resourceType.equalsIgnoreCase("TRANSPORTER")){
	         return new Transporter(i++);
	         
	      }else if(resourceType.equalsIgnoreCase("BOXROOM")){
		         return new BoxRoom(i++);
		         
	      }else if(resourceType.equalsIgnoreCase("SHOCKROOM")){
		         return new ShockRoom(i++);
		         
	      }else if(resourceType.equalsIgnoreCase("MRI")){
		         return new MRI(i++);
		         
	      }else if(resourceType.equalsIgnoreCase("RADIOGRAPHY")){
		         return new Radiography(i++);
		         
	      }else if(resourceType.equalsIgnoreCase("BLOODTEST")){
		         return new BloodTest(i++);
	      }
	      
	      return null;
	}
}
