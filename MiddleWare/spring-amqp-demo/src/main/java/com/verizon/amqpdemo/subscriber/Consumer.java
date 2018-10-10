package com.verizon.amqpdemo.subscriber;

public class Consumer {
	public void listen(String dtf) {
		System.out.println("Received Date and Time: "+ dtf);
		
	}
}
