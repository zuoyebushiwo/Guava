package com.google.test.eventbus;

public class TestEvent {
	
	private final int message;
	
	public TestEvent(int message) {
		this.message = message;
		System.out.println("Event message: " + message);
	}

	public int getMessage() {
        return message;
    }
	
}
