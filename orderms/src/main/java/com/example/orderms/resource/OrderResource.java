package com.example.orderms.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderms.Order;
import com.example.orderms.service.OrderService;

@RestController
public class OrderResource {
    
	private OrderService orderService;
	
	public OrderResource(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	@GetMapping("/orders/{id")
	public Order getSingleOrder(@PathVariable Long id) {
		return orderService.getSingleOrder(id);
	}
}
