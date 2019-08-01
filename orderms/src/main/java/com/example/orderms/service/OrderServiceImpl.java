package com.example.orderms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orderms.Order;
import com.example.orderms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getSingleOrder(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public void createOrder(Order order) {
		orderRepository.save(order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		orderRepository.delete(order);
	}

}
