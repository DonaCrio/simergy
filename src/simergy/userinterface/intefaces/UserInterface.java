package simergy.userinterface.intefaces;

import java.io.File;
import java.util.Scanner;

import simergy.core.system.EmergencyDept;
import simergy.core.system.SimErgy;
import simergy.userinterface.commandfactory.CommandFactory;

public abstract class UserInterface {

	protected CommandFactory commandFactory;
	protected SimErgy sys;
	protected EmergencyDept currentED;
	protected File currentDirectory;
	protected Scanner sc;
	protected boolean run;
	
	public UserInterface(){
		commandFactory = new CommandFactory(this);
		this.currentDirectory = new File(System.getProperty("user.dir") + "/data/");
	}

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public SimErgy getSys() {
		return sys;
	}
	
	public void setSys(SimErgy sys) {
		this.sys = sys;
	}

	public File getCurrentDirectory() {
		return currentDirectory;
	}

	public void setCurrentDirectory(File currentDirectory) {
		this.currentDirectory = currentDirectory;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	public EmergencyDept getCurrentED() {
		return currentED;
	}

	public void setCurrentED(EmergencyDept currentED) {
		this.currentED = currentED;
	}
	
}
