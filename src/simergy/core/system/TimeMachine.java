/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.system;


/**
 * The Class TimeMachine.
 * 
 * This class is used to represent time in an ED.
 * This is a basic clock representing time by minute with an integer.
 */

public class TimeMachine{

	private int time;
	
	/**
	 * Instantiates a new time machine.
	 * Time is set to 0.
	 */
	public TimeMachine(){
		this.time = 0;
	}

	/**
	 * Increments time by 1 (1 minute)
	 */
	public void toNextTime(){
		this.time += 1;
	}
	
	/**
	 * Computes time in day, hours and minutes.
	 *
	 * @return the string describing time
	 */
	public String computeTime(){
		int r = time%1440;
		int day = (int)(time-r)/1440;
		int minutes = r%60;
		int hours = (int)(r-minutes)/60;
		return "day" + day + ":" + hours + "h" + minutes; 
	}
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TimeMachine [time=" + time + " minutes]";
	}
		
}
