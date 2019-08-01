package com.example.userms.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.userms.model.User;
import com.example.userms.service.UserService;

@RestController
public class UserResource {
	
	private UserService userService;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity getSingleUser(@PathVariable Long id) {
		User user = userService.getSingleUser(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(user);
		}
		
	}

	
	
	
}
