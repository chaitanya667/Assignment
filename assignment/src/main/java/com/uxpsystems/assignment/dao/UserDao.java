package com.uxpsystems.assignment.dao;
import java.util.List;

import com.uxpsystems.assignment.model.User;


public interface UserDao {
  void register(User user);
  List<User> getUserList();
  void editUser(User user, String newPwd);
  User getUser(Integer userId);
  void updateUserStatus(User user, String status);
  
}