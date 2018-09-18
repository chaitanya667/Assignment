package com.uxpsystems.assignment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uxpsystems.assignment.dao.UserDaoImpl;
import com.uxpsystems.assignment.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-assignment-servlet.xml"})
public class TestUserDaoImpl {

	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Test
	public void register() {
		User user = new User();
		user.setUsername("testdao");
		user.setPassword("password");
		userDaoImpl.register(user);
		assertTrue(userDaoImpl.isUserNameExists(user.getUsername()));	
		
		
		User user1 = new User();
		user1.setUsername("testdao1");
		user1.setPassword("password");
		userDaoImpl.register(user1);
		assertTrue(userDaoImpl.isUserNameExists(user1.getUsername()));	
		
		User user2 = new User();
		user2.setUsername("testdao2");
		user2.setPassword("password");
		userDaoImpl.register(user2);
		assertTrue(userDaoImpl.isUserNameExists(user2.getUsername()));	
		
		User user3 = new User();
		user3.setUsername("testdao3");
		user3.setPassword("password");
		userDaoImpl.register(user3);
		assertTrue(userDaoImpl.isUserNameExists(user3.getUsername()));	
		
	}
	
	
	@Test
	public void editUser() {
		User user = userDaoImpl.getUser(1);
		userDaoImpl.editUser(user,"password4");

		assertEquals("password4",userDaoImpl.getUser(1).getPassword());	
	}
	
	
	@Test
	public void delUser() {
		User user = userDaoImpl.getUser(2);
		userDaoImpl.delUser(2);	
		assertFalse(userDaoImpl.isUserNameExists(user.getUsername()));
	}
	
	@Test
	public void isUserNameExists() {
		assertFalse(userDaoImpl.isUserNameExists("sadss"));	
	}
	
	@Test
	public void updateUserStatus() {
		
		User user =userDaoImpl.getUser(1);
		userDaoImpl.updateUserStatus(user,"Deactivated");	
		assertEquals("Deactivated",userDaoImpl.getUser(1).getStatus());	
	}

}
