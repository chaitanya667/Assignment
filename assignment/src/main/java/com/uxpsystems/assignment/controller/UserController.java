package com.uxpsystems.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	  public UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	  public ModelAndView register(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password) {
	    if (username == null || password==null || username.length() <=0 || password.length() <=0)
	    {
	    	String validationMessage = "<br>Username/Password is not valid";
	    	return new ModelAndView("index", "message", validationMessage);
	    }
	    if(userService.isUserNameExists(username))
	    {
	    	String validationMessage = "<br>Username already Exists";
	    	return new ModelAndView("index", "message", validationMessage);
	    }
	    
	    User user = new User();
	    user.setUsername(username);
	    user.setPassword(password);
	    //UserService us = new UserService();
	    userService.register(user);
	    String successMessage = "<br>User Registered Succesfully<br>";
		return new ModelAndView("index", "message", successMessage);
	  }
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	  public ModelAndView getUserList() {	    
	    List<User> users = userService.getUserList();
	    if(users != null && users.size() > 0)
	    {
	    	return new ModelAndView("index", "users", users);
	    }
	    else
	    {
	    	String message = "<br>No User Data to Display <br>";
	    	return new ModelAndView("index", "message", message);
	    }
		
	  }
	
	@RequestMapping(value = "/changePwd/editUser", method = RequestMethod.POST)
	  public ModelAndView editUser(@RequestParam(value = "password") String password,
			  @RequestParam(value = "userId") Integer id) { 
	    userService.editUser(id,password);
	    String successMessage = "<br>User Password updated Succesfully for User ID : " +id+"<br>";
		return new ModelAndView("index", "message", successMessage);
	  }
	

	@RequestMapping(value = "/changePwd/{id}")
	  public ModelAndView changePwdPage(@PathVariable(value = "id") Integer id) {
	    User user = userService.getUser(id);
	    return new ModelAndView("changePwd", "user", user);
	  }
	
	@RequestMapping(value = "/deleteUser/{id}")
	  public ModelAndView delUser(@PathVariable(value = "id") Integer id) {
	    userService.delUser(id);
	    String successMessage = "<br> User data deleted succesfully for User ID : " +id+"<br>";
		return new ModelAndView("index", "message", successMessage);
	  }
	
	@RequestMapping(value = "/activate/{id}")
	  public ModelAndView activateUser(@PathVariable(value = "id") Integer id) {
	    userService.updateUserStatus(id,"Activated");
	    String successMessage = "<br> User activated succesfully for User ID : " +id+"<br>";
		return new ModelAndView("index", "message", successMessage);
		
	  }
	
	@RequestMapping(value = "/deActivate/{id}")
	  public ModelAndView deActivateUser(@PathVariable(value = "id") Integer id) {
	    userService.updateUserStatus(id,"Deactivated");
	    
	    String successMessage = "<br> User deactivated succesfully for User ID : " +id+"<br>";
		return new ModelAndView("index", "message", successMessage);
	  }
	
	@RequestMapping(value = "/back")
	  public ModelAndView backPage() {
	    return new ModelAndView("index", "", "");
	  }
}
