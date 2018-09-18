package com.uxpsystems.assignment.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.util.HibernateUtil;

@Component
public class UserDaoImpl implements UserDao{
	
	public void register(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		session.save(user);		
		session.getTransaction().commit();
		session.close();
	}

	public List<User> getUserList() {
		 List<User> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM com.uxpsystems.assignment.model.User";
        Query query = session.createQuery(hql);
        userList = query.list();
        return userList;
	}

	public void editUser(User user, String newPassword) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		user.setPassword(newPassword);
		session.beginTransaction();
       session.update(user);
       User updatedUser = getUser(user.getUserId());
       session.getTransaction().commit();
		session.close();
	}

	public User getUser(Integer userId) {
		 List<User> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM com.uxpsystems.assignment.model.User usr where usr.id = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId",userId);
        userList = query.list();
      return userList.get(0);
	}

	public void delUser(Integer userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User usr = getUser(userId);
		session.beginTransaction();
		session.delete(usr);	
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean isUserNameExists(String userName) {
		 List<User> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM com.uxpsystems.assignment.model.User usr where usr.username = :userName";
       Query query = session.createQuery(hql);
       query.setParameter("userName",userName);
       userList = query.list();
       if(userList != null && userList.size() > 0) {
    	   return true;
       }
       else
       {
    	   return false;
       }     
	}

	public void updateUserStatus(User user, String status) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		user.setStatus(status);
		session.beginTransaction();
       session.update(user);
       User updatedUser = getUser(user.getUserId());
       session.getTransaction().commit();
		session.close();
		
	}

}
