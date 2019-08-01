package com.edureka.commandms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@SpringBootApplication
@RestController
@EnableJms
public class CommandmsApplication {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue inventoryQueue;
	@Autowired
	private Queue paymentQueue;

	@Bean
	public Queue inventoryQueue() {
		return new ActiveMQQueue("inv-queue");
	}

	@Bean
	public Queue paymentQueue() {
		return new ActiveMQQueue("payment-queue");
	}

	@GetMapping("/messages/{message}")
	public void publish(@PathVariable String message) {
		System.out.printf("CommandMS: " + message);
		jmsTemplate.convertAndSend(inventoryQueue, "inv-" + message);
		jmsTemplate.convertAndSend(paymentQueue, "pay-" + message);
	}


	public static void main(String[] args) {
		SpringApplication.run(CommandmsApplication.class, args);
	}

}
