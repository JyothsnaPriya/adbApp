package com.verizon.amqpassgn.subscriber;

public class Consumer {
	public void listen(String message) {
		System.out.println("Received: "+ message);
	}
}
