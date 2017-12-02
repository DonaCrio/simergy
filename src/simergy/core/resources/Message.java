/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import simergy.core.patients.Patient;

/**
 * The Class Message.
 */
public class Message {

	private String content;
	private int time;
	private Patient p;
	private boolean seen;
	
	/**
	 * Instantiates a new message.
	 *
	 * @param content the content
	 * @param time the time
	 * @param p the p
	 */
	public Message(String content, int time, Patient p){
		this.content = content;
		this.time = time;
		this.p = p;
		this.seen = false;
	}
	
	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "Message "+(seen?"seen":"not seen") + "\nTime:" + time + " Patient:" + p.getName()+" " + p.getSurname() + "\nContent: " + content;
	}

	/**
	 * Sets the message's status (seen or not).
	 *
	 * @param seen the status
	 */
	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	/**
	 * Checks if the message has been seen.
	 *
	 * @return true, if message has been seen
	 */
	public boolean isSeen() {
		return seen;
	}
	
	
}
