package com.test.dao;

import java.util.List;

import com.test.model.UserDetails;

public interface UserDetailsDAOInt {

	public abstract UserDetails addUser(UserDetails userDetails);
	public abstract UserDetails loginCheck(UserDetails userDetails);
	public abstract List<UserDetails> getAllUsers();
}
