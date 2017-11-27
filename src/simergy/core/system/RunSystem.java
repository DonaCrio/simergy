package simergy.core.system;

import simergy.core.patients.*;
import simergy.core.resources.*;
import simergy.core.events.Workflow;

import java.io.*;
import java.util.ArrayList;


public class RunSystem {

	public static void main(String[] args) {
//		createAndSaveED();
		double avgDTDT = 0;
		double avgLOS = 0;
		double avgCount = 0;
		double avgcritCount = 0;
		double avgTotPatient = 0;
		for(int i=0;i<100;i++){
			EmergencyDept myEd = loadED("my_simergy.ini");
			for(int j=0;j<10080;j++){ //Simulation sur une semaine
				myEd.update();
			}
			double DTDT = 0;
			double LOS = 0;
			int count = 0;
			int critCount = 0;
			for(Patient p : myEd.getPatients()){
				if(p.getState()==PatientState.R){
					DTDT += p.getWorkflow().getConsultationTime()-p.getWorkflow().getStartTime();
					LOS +=  p.getWorkflow().getEndTime()-p.getWorkflow().getStartTime();
					count++;
					if(p.getSeverityLevel()==SeverityLevel.L1 || p.getSeverityLevel()==SeverityLevel.L2){
						critCount++;
					}
				}
			}
			DTDT /= count;
			LOS /= count;
			avgDTDT += DTDT;
			avgLOS += LOS;
			avgCount += count;
			avgcritCount += critCount;
			avgTotPatient += myEd.getPatients().size();
		}
		avgDTDT /= 100;
		avgLOS /= 100;
		avgCount /= 100;
		avgcritCount /= 100;
		avgTotPatient /=100;
		System.out.println(avgCount + "/" + avgTotPatient+" patients released");
		System.out.println(avgcritCount + " were in a critical state");
		System.out.println("Average DTDT = "+avgDTDT+"min");
		System.out.println("Average LOS = "+avgLOS+"min");
	}

	
	public static void createAndSaveED(){
		EmergencyDept ed = new EmergencyDept("myEd)");
		ed.addResource(new Physician("Said","Sammy"));
		ed.addResource(new Physician("Said","Sammy"));
		ed.addResource(new Physician("Guerzider","Antoine"));
		ed.addResource(new Physician("Said","Antoine"));
		ed.addResource(new Physician("Guerzider","Sammy"));
		ed.addResource(new Physician("Said","Antoine"));
		ed.addResource(new Physician("Guerzider","Sammy"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Ripoche","Arnaud"));
		ed.addResource(new Nurse("Picard","Arnaud"));
		ed.addResource(new Nurse("Ripoche","Alex"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Picard","Alex"));
		ed.addResource(new Nurse("Ripoche","Arnaud"));
		ed.addResource(new Nurse("Picard","Arnaud"));
		ed.addResource(new Nurse("Ripoche","Alex"));
		ed.addResource(new Transporter("Cisneros","Hugo"));
		ed.addResource(new Transporter("Plessis","Quentin"));
		ed.addResource(new Transporter("Cisneros","Quentin"));
		ed.addResource(new Transporter("Plessis","Hugo"));
		ed.addResource(new Transporter("Cisneros","Hugo"));
		ed.addResource(new Transporter("Plessis","Quentin"));
		ed.addResource(new Transporter("Cisneros","Quentin"));
		ed.addResource(new Transporter("Plessis","Hugo"));
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new BoxRoom());
		ed.addResource(new ShockRoom());
		ed.addResource(new ShockRoom());
		ed.addResource(new ShockRoom());
		ed.addResource(new ShockRoom());
		ed.addResource(new BloodTest());
		ed.addResource(new MRI());
		ed.addResource(new Radiography());
		ed.addResource(new BloodTest());
		ed.addResource(new MRI());
		ed.addResource(new Radiography());
		
		try{
			FileOutputStream fos = new FileOutputStream("my_simergy.ini");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ed);
			oos.close();
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static EmergencyDept loadED(String filePath){
		EmergencyDept ed=null;
		try{
			FileInputStream fis = new FileInputStream("my_simergy.ini");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ed = (EmergencyDept) ois.readObject();
			ois.close();
			fis.close();
			ed.setClock(new TimeMachine());
			ed.setPatientGenerator(new PatientGenerator());
			ed.setPatients(new ArrayList<Patient>());
			ed.setWorkflows(new ArrayList<Workflow>());
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return ed;
	}
}
