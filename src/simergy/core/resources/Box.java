/*
 * @author Donatien Criaud
 * 
 */
package simergy.core.resources;

import java.util.ArrayList;

/**
 * The Class Box.
 */
public class Box {
	//Attributes
	/** The messages. */
	private ArrayList<Message> messages;
	
	/**
	 * Instantiates a new box.
	 */
	// Constructor
	public Box(){
		messages = new ArrayList<Message>();
	}
	
	/**
	 * Adds the message.
	 *
	 * @param m the message
	 */
	//Methods
	public void addMessage(Message m){
		messages.add(m);
	}
	
	/**
	 * Delete message.
	 *
	 * @param m the message
	 */
	public void deleteMessage(Message m){
		messages.remove(m);
	}
	
	/**
	 * Delete message.
	 *
	 * @param index the message's index
	 */
	public void deleteMessage(int index){
		messages.remove(index);
	}
	
	/**
	 * Gets the message.
	 *
	 * @param index the message's index
	 * @return the message
	 */
	public Message getMessage(int index){
		return messages.get(index);
	}
	
	/**
	 * Sets the message as seen.
	 *
	 * @param index the message's index
	 * @param read the read
	 */
	public void setMessageAsSeen(int index, boolean read){
		messages.get(index).setSeen(read);
	}
	
	/**
	 * Display messages.
	 *
	 * @return the string
	 */
	public String displayMessages(){
		String result = "MessageList: ";
		for(Message m: messages){
			result += "\n"+messages.indexOf(m)+": "+m.toString();
		}
		return result;
	}
	
	/**
	 * Display unread messages.
	 *
	 * @return the string
	 */
	public String displayUnreadMessages(){
		String result = "UnreadMessages: ";
		for(Message m: messages){
			if(m.isSeen()==false){
			result += "\n"+messages.indexOf(m)+": "+m.toString();
			}
		}
		return result;
	}
}
