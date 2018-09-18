package com.uxpsystems.assignment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uxpsystems.assignment.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-assignment-servlet.xml"})
public class TestUserService {
	@Autowired
	UserService userService;
	

	
	@Test
	public void register() {
		User user = new User();
		user.setUsername("testSer");
		user.setPassword("password");
		userService.register(user);
		assertTrue(userService.isUserNameExists(user.getUsername()));	
		
		
		User user1 = new User();
		user1.setUsername("testSer1");
		user1.setPassword("password");
		userService.register(user1);
		assertTrue(userService.isUserNameExists(user1.getUsername()));	
		
		User user2 = new User();
		user2.setUsername("testSer2");
		user2.setPassword("password");
		userService.register(user2);
		assertTrue(userService.isUserNameExists(user2.getUsername()));	
		
		User user3 = new User();
		user3.setUsername("testSer3");
		user3.setPassword("password");
		userService.register(user3);
		assertTrue(userService.isUserNameExists(user3.getUsername()));	
	}
	
	
	@Test
	public void editUser() {
		userService.editUser(1,"password3");

		assertEquals("password3",userService.getUser(1).getPassword());	
	}
	
	
	@Test
	public void delUser() {
		User user = userService.getUser(3);
		userService.delUser(3);	
		assertFalse(userService.isUserNameExists(user.getUsername()));
	}
	
	@Test
	public void isUserNameExists() {
		assertFalse(userService.isUserNameExists("sadss"));	
	}
	
	@Test
	public void updateUserStatus() {
		userService.updateUserStatus(4,"Activated");	
		assertEquals("Activated",userService.getUser(4).getStatus());	
	}
}
