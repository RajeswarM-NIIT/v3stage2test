package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dao.UserDetailsDAOInt;
import com.test.model.UserDetails;
import com.test.model.Error;

@RestController
public class UserController {

	@Autowired
	private UserDetailsDAOInt userDetailsDao;
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody UserDetails userDetails){
		userDetails.setEnabled(true);
		userDetails.setIsonline(false);
		userDetails.setUserrole("ROLE_USER");
		UserDetails result = userDetailsDao.addUser(userDetails);
		
		if(result!=null){// if signup is success, return userdetails object
			return new  ResponseEntity<UserDetails> (result,HttpStatus.OK);
		}
		else{ // if signup failed, return error object
			Error error = new Error(1,"Signup process failed..");
			return new  ResponseEntity<Error> (error, HttpStatus.CONFLICT);			
		}			
	}
	
	@RequestMapping(value="/getAllUsers", method=RequestMethod.GET)
	public ResponseEntity<?> getAllUserDetails(){
		List<UserDetails> data = userDetailsDao.getAllUsers();
		return new ResponseEntity<List<UserDetails>> (data,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public ResponseEntity<?> loginCheck(@RequestBody UserDetails userDetails){
		UserDetails data = userDetailsDao.loginCheck(userDetails);
		if(data!=null)
			return new ResponseEntity<UserDetails> (data,HttpStatus.OK);
		else
			return new ResponseEntity<Error> (new Error(2,"Authentication failed"),HttpStatus.UNAUTHORIZED);		
	}
	
}
