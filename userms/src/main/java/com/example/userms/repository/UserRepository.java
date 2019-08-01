package com.example.userms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
