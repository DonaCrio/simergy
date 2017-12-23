/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.intefaces;

import java.io.*;
import simergy.core.system.SimErgy;

// TODO: Auto-generated Javadoc
/**
 * The Class LoadSave.
 */
public class LoadSave {

	/**
	 * Save sys.
	 *
	 * @param sys the sys
	 * @param fileName the file name
	 */
	public static void saveSys(SimErgy sys, String fileName){
		sys.setName(fileName);
		if(fileName.contentEquals("")){
			fileName = "SimErgy";
			System.out.println("Default name has been set : SimErgy");
		}
		if(fileName.length()>4 && fileName.substring(fileName.length()-4,fileName.length()).equalsIgnoreCase(".SER")){
			fileName = fileName.substring(0,fileName.length()-4);
		}
		try{
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/data/" + fileName + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sys);
			oos.close();
			fos.close();
			System.out.println(fileName + ".ser was saved without any issue in /data/" + fileName + ".ser");
			
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("ERROR : Failed to save the system.");;
		}
	}
	
	/**
	 * Load sys.
	 *
	 * @param fileName the file name
	 * @return the sim ergy
	 */
	public static SimErgy loadSys(String fileName){
		SimErgy sys = null;
		if(fileName.contentEquals("")){
			System.out.println("A brand new SimErgy system has been created !");
			return new SimErgy("");
		}
		if(fileName.length()>4 && fileName.substring(fileName.length()-4,fileName.length()).equalsIgnoreCase(".SER")){
			fileName = fileName.substring(0,fileName.length()-4);
		}
		try{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/" + fileName + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			sys = (SimErgy)ois.readObject();
			System.out.println(fileName + ".ser was loaded without any issue.");
			ois.close();
			fis.close();
			return sys;
		}catch(IOException e){
			System.out.println("ERROR : Save couldn't be loaded, a brand new SimErgy system has been created !\n");
			return new SimErgy("");
		}catch(ClassNotFoundException e){
			System.out.println("EClassNotFoundException, a brand new SimErgy system has been created !\n");
			return new SimErgy("");
		}
		
		
	}
}
