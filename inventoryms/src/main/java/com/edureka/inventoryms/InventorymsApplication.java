package com.edureka.inventoryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class InventorymsApplication {

	@JmsListener(destination = "inv-queue")
	public void listen(String message) {
		System.out.println("invms: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(InventorymsApplication.class, args);
	}

}
