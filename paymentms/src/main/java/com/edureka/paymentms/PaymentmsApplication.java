package com.edureka.paymentms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class PaymentmsApplication {

	@JmsListener(destination = "payment-queue")
	public void listen(String message) {
		System.out.println("paymentms: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentmsApplication.class, args);
	}

}
