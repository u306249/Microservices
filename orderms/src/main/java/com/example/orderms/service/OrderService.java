package com.example.orderms.service;

import java.util.List;

import com.example.orderms.Order;

public interface OrderService {

	public List<Order> getAllOrders();
	
	public Order getSingleOrder(Long id);
	
	public void createOrder(Order order);
	
	public void deleteOrder(Order order);
}
