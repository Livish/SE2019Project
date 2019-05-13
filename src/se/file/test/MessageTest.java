package se.file.test;

import java.util.ArrayList;
import java.util.List;

import se.file.process.Message;

public class MessageTest {

	public static void main(String[] args) {
		
		List<Integer> message = new ArrayList<>();
		List<Integer> microMessage = new ArrayList<>();
		

		Message m = new Message(20);
		message = m.createMessage();
		microMessage = m.createMicroMessage();


		//Test per second message count
		for (int i = 0; i < 20; i++) {
			System.out.println(message.get(i));
		}
		
		
		//Test microsecond message count
		for (int i = 0; i < 20; i++) {
			System.out.println(microMessage.get(i));
		}
		
	}
}
