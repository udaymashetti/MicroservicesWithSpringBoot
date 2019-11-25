package com.infy.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.demo.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);
	
	
	
	
	

}
