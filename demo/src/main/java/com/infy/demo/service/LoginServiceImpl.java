package com.infy.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.demo.entity.User;
import com.infy.demo.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductFeignService pfs;

	@Override
	public List checkLogin(User user)  {
		// TODO Auto-generated method stub
		final Logger logger;
		List resultList = new ArrayList();
		logger = LoggerFactory.getLogger(this.getClass());
		String sMessage = "";
		logger.info("Provided userName is "+user.getUserName());
		try {
			if (user.getUserName() != null && user.getPassword() != null) {

				User userIns = userRepo.findByUserName(user.getUserName());
				
			

				if (userIns.getPassword().equals(user.getPassword())) {
					
					logger.info("login Successfull!!!! for user "+user.getUserName());

					sMessage = "Hey " + user.getUserName() + " login Successfull!!!!";
					
					resultList.add(sMessage);
					resultList.add(pfs.findAllProductDetails());
					
					

				} else {
					logger.info("login Failed!!! for user"+user.getUserName());
					sMessage = "Hey " + user.getUserName() + " login Failed!!!";
					resultList.add(sMessage);
				}

			} else {
				logger.info("User name or Password is null");
				sMessage = "User name or Password can't be null";
				resultList.add(sMessage);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			
		}
		return resultList;
	}

}
