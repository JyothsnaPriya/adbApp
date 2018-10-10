package com.verizon.amqpdemo.publisher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMessagePublisher {
	public static void main(String[] args) {
		AbstractApplicationContext ctx 
		= new ClassPathXmlApplicationContext("Beans.xml");
	
		AmqpTemplate template = ctx.getBean(RabbitTemplate.class);
		
		while(true) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			System.out.println("Sending Message");
			System.out.println(dtf.format(now));  
			template.convertAndSend(dtf.format(now));
			System.out.println("sent!");
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
