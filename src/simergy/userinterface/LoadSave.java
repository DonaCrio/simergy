package simergy.userinterface;

import java.io.*;
import simergy.core.system.SimErgy;

public class LoadSave {

	public static void saveSys(SimErgy sys){
		try{
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/data/SimErgy.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sys);
			oos.close();
			fos.close();
			System.out.println("System was saved without any issue.");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static SimErgy loadSys(){
		SimErgy sys = null;
		
		try{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/SimErgy.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			sys = (SimErgy)ois.readObject();
			System.out.println("System was loaded without issue.");
			return sys;
		}catch(IOException e){
			System.out.println("There is no current save, a brand new SimErgy system has been created !\n");
			return new SimErgy();
		}catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException, a brand new SimErgy system has been created !\n");
			return new SimErgy();
		}
		
		
	}
}
