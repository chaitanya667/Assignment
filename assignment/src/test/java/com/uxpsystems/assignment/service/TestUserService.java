package com.uxpsystems.assignment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uxpsystems.assignment.model.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-assignment-servlet.xml"})
public class TestUserService {
	@Autowired
	UserService userService;
	
	@Test
	public void register() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("password");
		userService.register(user);
		
		/*User user1 = new User();
		user1.setUsername("test1");
		user1.setPassword("password");
		userService.register(user1);
		
		User user2 = new User();
		user2.setUsername("test2");
		user2.setPassword("password");
		userService.register(user2);
		
		User user3 = new User();
		user3.setUsername("test3");
		user3.setPassword("password");
		userService.register(user3);*/
	}
	
/*	@Test
	public void getUserList() {
		List<User> list = userService.getUserList();
		assertEquals("test1",list.get(1).getUsername());
	}
	
	@Test
	public void editUser() {
		userService.editUser(1,"password3");	
	}
	
	@Test
	public void getUser() {
		User user = userService.getUser(2);	
		assertEquals("test1", user.getUsername());
	}
	
	@Test
	public void delUser() {
		userService.delUser(3);	
	}
	
	@Test
	public void isUserNameExists() {
		assertFalse(userService.isUserNameExists("test"));	
	}
	
	@Test
	public void updateUserStatus() {
		userService.updateUserStatus(4,"Activate");	
	}*/
}
