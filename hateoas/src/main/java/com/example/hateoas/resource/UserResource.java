package com.example.hateoas.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hateoas.model.User;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

	@GetMapping("/all")
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		
		User user1 = new User("Peter", 2000L);
		User user2 = new User("John", 2500L);
		
		users.add(user1);
		users.add(user2);
		
		return users;
	}
	@GetMapping(value="/hateoas/all",produces = MediaTypes.HAL_JSON_VALUE)
	public List<User> getAllHateoasUsers(){
		List<User> users = new ArrayList<>();
		
		User user1 = new User("Peter", 2000L);
		
		Link link1 = ControllerLinkBuilder.linkTo(UserResource.class).slash(user1.getName()).withSelfRel();
		user1.add(link1);
		User user2 = new User("John", 2500L);
		Link link2 = ControllerLinkBuilder.linkTo(UserResource.class).slash(user2.getName()).withSelfRel();
		user2.add(link2);
		
		users.add(user1);
		users.add(user2);
		
		return users;
	}
}
