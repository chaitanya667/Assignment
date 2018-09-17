package com.uxpsystems.assignment.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

import com.uxpsystems.assignment.model.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-assignment-servlet.xml"})
public class TestUserController {

	@Autowired
	private UserController userController;
	@Autowired
	private UserController userController1;
	
	@Test
	public void registerPosModelCheck()
	{
		ModelAndView modelAndView1 = userController.register("test1", "testPwd1");
		ModelAndView modelAndView2 = userController.register("123123", "234334");
		System.out.println("Inside register");
		assertEquals("index", modelAndView1.getViewName());
		assertEquals("<br>User Registered Succesfully<br>", modelAndView1.getModel().get("message"));
	}
	
	@Test
	public void registerNegEmptyInputs()
	{
		ModelAndView modelAndView3 = userController.register("", "testPwd1");
		ModelAndView modelAndView4 = userController.register("te345st1", "");
		ModelAndView modelAndView5 = userController.register("", "");
		System.out.println("Inside registerUsrNameEmpty");
		assertEquals("index", modelAndView3.getViewName());
		assertEquals("<br>Username/Password is not valid", modelAndView3.getModel().get("message"));
		
		assertEquals("index", modelAndView4.getViewName());
		assertEquals("<br>Username/Password is not valid", modelAndView4.getModel().get("message"));
		
		assertEquals("index", modelAndView5.getViewName());
		assertEquals("<br>Username/Password is not valid", modelAndView5.getModel().get("message"));
	}

	@Test
	public void getUserListWithData()
	{
		System.out.println("Inside getUserList - success flow");
		ModelAndView modelAndView6 = userController.register("ABCD", "ABDNN");
		ModelAndView modelAndView7 = userController.register("CDFFAS", "DDASSDF");
		ModelAndView modelAndView10 = userController.getUserList();
		 List<User> users = (List<User>) modelAndView10.getModel().get("users");
		 if (users != null && users.size() > 0)
		 {
			 assertEquals("index", modelAndView10.getViewName());
		 }
		 else
		 {
			 assertEquals("<br>No User Data to Display <br>", modelAndView10.getModel().get("message"));
		 }
		
	}
	
	@Test
	public void getUserListWithoutData()
	{
		ModelAndView modelAndView1 = new ModelAndView();
		modelAndView1 = userController1.getUserList();   // No users are inserted
		 List<User> users = (List<User>) modelAndView1.getModel().get("users");
		 if (users != null && users.size() > 0)
		 {
			 assertEquals("index", modelAndView1.getViewName());
		 }
		 else
		 {
			 assertEquals("<br>No User Data to Display <br>", modelAndView1.getModel().get("message"));
		 }
	}
	
	@Test
	public void editUser()
	{
		ModelAndView modelAndView1 = new ModelAndView();
		modelAndView1 = userController.register("ABCD", "ABDNN");
		modelAndView1 = userController.getUserList();
		List<User> users = (List<User>) modelAndView1.getModel().get("users");
		String newPassword = "sdfsdfdsf";
		
		modelAndView1 = userController.editUser(newPassword, users.get(0).getUserId());
		assertEquals("index", modelAndView1.getViewName());
		String successMessage = "<br>User Password updated Succesfully for User ID : " +users.get(0).getUserId()+"<br>";
		assertEquals(successMessage, modelAndView1.getModel().get("message"));
	}
}
