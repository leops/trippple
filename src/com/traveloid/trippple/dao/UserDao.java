package com.traveloid.trippple.dao;

import java.util.List;

import com.traveloid.trippple.entity.User;

public interface UserDao {
	List<User> findAll();
	User findById(Long id);
	User addUser(User user);
	void updateUser(User user);
	void removeUser(User user);
}
