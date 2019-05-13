package se.file.process;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	private int messageNumber;
	private List<Integer> message = new ArrayList<>();
	private List<Integer> microMessage = new ArrayList<>();

	public Message() {

	}

	public Message(int messageNumber) {
		this.messageNumber = messageNumber;
	}
	public int getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}

	public List<Integer> getMicroMessage() {
		return microMessage;
	}

	public void setMicroMessage(List<Integer> microMessage) {
		this.microMessage = microMessage;
	}

	public List<Integer> getMessage() {
		return message;
	}

	public void setMessage(List<Integer> message) {
		this.message = message;
	}
	
	// Using random to create per second message count. scope is 10,000 ~ 10,000,000
	public List<Integer> createMessage() {
		for (int i = 0; i < messageNumber; i++) {
			int num = (int) (Math.random() * (10000000 - 10000 + 1) + 10000);
			message.add(num);
		}
		return message;
	}

	// Using random to create microsecond message count. scope is 0 ~ 10
	public List<Integer> createMicroMessage() {
		for (int i = 0; i < messageNumber; i++) {
			int num = (int) (Math.random() * (10000000 - 10000 + 1) + 10000) / 1000000;
			microMessage.add(num);
		}
		return microMessage;
	}

}
