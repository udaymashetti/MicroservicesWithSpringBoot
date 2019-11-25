package com.infy.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.demo.entity.User;
import com.infy.demo.repository.UserRepository;
import com.infy.demo.service.LoginService;



@RestController
@EnableEurekaClient
@EnableFeignClients
public class UserController {
	
	@Autowired
	LoginService loginServ;
	
	@Autowired 
	DiscoveryClient client;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @GetMapping (value = "/")
    public ResponseEntity<?> redLogin() throws Exception
    {
         User user= new User();
         user.setUserName("uday");
         user.setPassword("uday@123");
         return login(user);
    }
	

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody User user) throws Exception {
		
		logger.info("UserController.login()");
		
		List sMessage = loginServ.checkLogin(user);
	
		
		return new ResponseEntity<>(sMessage,HttpStatus.OK);
	}	

}
