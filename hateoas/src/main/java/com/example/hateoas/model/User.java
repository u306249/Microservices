package com.example.hateoas.model;

import org.springframework.hateoas.ResourceSupport;

public class User extends ResourceSupport{
	
	private String name;
	private Long salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public User(String name, Long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

}
