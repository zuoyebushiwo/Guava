package com.google.test.eventbus;

public class IntegerListener {

	private Integer lastMessage;
	
	public void listen(Integer integer) {
		lastMessage = integer;
		System.out.println("Message: " + lastMessage);
	}
	
	public Integer getLastMessage() {
		return lastMessage;
	}
	
}
