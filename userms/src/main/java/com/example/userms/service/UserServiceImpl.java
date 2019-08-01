package com.example.userms.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userms.model.User;
import com.example.userms.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;
	private RestTemplate restTemplate;

   	
	public UserServiceImpl(UserRepository userRepo,RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.restTemplate = restTemplate;
    }

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getSingleUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	@Override
    @HystrixCommand(fallbackMethod = "getResponseFromCache")
    public Object getAllOrders() {
        Object allOrders = restTemplate.getForObject("http://orderms/orders", Object.class);
        return allOrders;
    }

    private Object getResponseFromCache() {
        return Arrays.asList(new User(1l, "A"), new User(2l, "B"));
    }

}
