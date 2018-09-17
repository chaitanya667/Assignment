package com.uxpsystems.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uxpsystems.assignment.dao.UserDaoImpl;
import com.uxpsystems.assignment.model.User;

@Component
public class UserService {
	@Autowired
	UserDaoImpl usrDaoImpl;
	public void register(User user) {
		usrDaoImpl.register(user);
		
	}
	
	public List<User> getUserList() {
		List<User> users = usrDaoImpl.getUserList();
		return users;
	}
	
	public void editUser(Integer userId,String newPassword) {
		User user = getUser(userId);
		usrDaoImpl.editUser(user,newPassword);
		
	}
	
	public User getUser(Integer userId) {
		return usrDaoImpl.getUser(userId);
		
	}
	
	public void delUser(Integer userId) {
		usrDaoImpl.delUser(userId);
		
	}

	public boolean isUserNameExists(String userName) {
		return usrDaoImpl.isUserNameExists(userName);
	}
	
	public void updateUserStatus(Integer userId,String status) {
		User user = getUser(userId);
		usrDaoImpl.updateUserStatus(user,status);
		
	}
}
