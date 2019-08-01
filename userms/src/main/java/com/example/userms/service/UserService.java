package com.example.userms.service;

import java.util.List;

import com.example.userms.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getSingleUser(Long id);
	
	public Object getAllOrders() ;
}
