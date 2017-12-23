/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.intefaces;

import java.io.File;
import java.util.Scanner;

import simergy.core.system.EmergencyDept;
import simergy.core.system.SimErgy;
import simergy.userinterface.commandfactory.CommandFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInterface.
 */
public abstract class UserInterface {

	/** The command factory. */
	protected CommandFactory commandFactory;
	
	/** The sys. */
	protected SimErgy sys;
	
	/** The current ED. */
	protected EmergencyDept currentED;
	
	/** The current directory. */
	protected File currentDirectory;
	
	/** The sc. */
	protected Scanner sc;
	
	/** The run. */
	protected boolean run;
	
	/**
	 * Instantiates a new user interface.
	 */
	public UserInterface(){
		commandFactory = new CommandFactory(this);
		this.currentDirectory = new File(System.getProperty("user.dir") + "/data/");
	}

	/**
	 * Gets the command factory.
	 *
	 * @return the command factory
	 */
	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	/**
	 * Gets the sys.
	 *
	 * @return the sys
	 */
	public SimErgy getSys() {
		return sys;
	}
	
	/**
	 * Sets the sys.
	 *
	 * @param sys the new sys
	 */
	public void setSys(SimErgy sys) {
		this.sys = sys;
	}

	/**
	 * Gets the current directory.
	 *
	 * @return the current directory
	 */
	public File getCurrentDirectory() {
		return currentDirectory;
	}

	/**
	 * Sets the current directory.
	 *
	 * @param currentDirectory the new current directory
	 */
	public void setCurrentDirectory(File currentDirectory) {
		this.currentDirectory = currentDirectory;
	}

	/**
	 * Gets the sc.
	 *
	 * @return the sc
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * Sets the sc.
	 *
	 * @param sc the new sc
	 */
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * Checks if is run.
	 *
	 * @return true, if is run
	 */
	public boolean isRun() {
		return run;
	}

	/**
	 * Sets the run.
	 *
	 * @param run the new run
	 */
	public void setRun(boolean run) {
		this.run = run;
	}

	/**
	 * Sets the command factory.
	 *
	 * @param commandFactory the new command factory
	 */
	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	/**
	 * Gets the current ED.
	 *
	 * @return the current ED
	 */
	public EmergencyDept getCurrentED() {
		return currentED;
	}

	/**
	 * Sets the current ED.
	 *
	 * @param currentED the new current ED
	 */
	public void setCurrentED(EmergencyDept currentED) {
		this.currentED = currentED;
	}
	
}
