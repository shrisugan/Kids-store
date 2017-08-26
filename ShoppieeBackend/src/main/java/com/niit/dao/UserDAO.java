package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	
List<User> getAllUserDetails();
	
	User getUserDetail(String id);
	
	void updateUserDetail(User obj);
	void addUser(User obj);

	void deleteUser(User entity);

}
