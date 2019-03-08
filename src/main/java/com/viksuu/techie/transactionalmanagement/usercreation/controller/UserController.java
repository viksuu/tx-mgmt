package com.viksuu.techie.transactionalmanagement.usercreation.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viksuu.techie.transactionalmanagement.model.User;
import com.viksuu.techie.transactionalmanagement.usercreation.services.UserServices;

@RestController
@RequestMapping(value="/tx")
public class UserController {

	@Autowired 
	private UserServices services;
	
	/*List<User> users;
	
	@PostConstruct
	public void insertUser() {
		users.add(new User());
	}
	*/
	
	@PostMapping(value="/create")
	public ResponseEntity<User>  createUser(@RequestBody User user){
		
		
	
		try {
			
			if (user.getCreated_date() == null) {
				Date createdDate = new Date();
				user.setCreated_date(createdDate);
			}
			Date updatedDate = new Date();
			user.setUpdated_date(updatedDate);
			
			User u =services.createUser(user);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("TodayDate", new Date().toString());
			
			return new ResponseEntity<User>(u, headers, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
		}
	}
	
	

	
	
	
}
