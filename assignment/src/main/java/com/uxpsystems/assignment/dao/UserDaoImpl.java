package com.uxpsystems.assignment.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.util.HibernateUtil;


public class UserDaoImpl implements UserDao{
	
	public void register(User user) {
		System.out.println("Inside register!!!"+ user.getUsername());
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*User user = new User();
		login.setUserId(1);
		login.setUsername("haripriya");
		login.setPassword("qwe");*/
		session.beginTransaction();
		session.save(user);		
		session.getTransaction().commit();
		session.close();
	}

	public List<User> getUserList() {
		System.out.println("Inside getUserList!!!");
		 List<User> userList = null;System.out.println("********* userList: "+userList);
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM com.uxpsystems.assignment.model.User";
        Query query = session.createQuery(hql);
        System.out.println("***** query : "+query);
        userList = query.list();
        System.out.println("********* userList: "+userList);
        return userList;
	}

	public void editUser(User user, String newPassword) {
		System.out.println("Inside editUser!!!   "+user.getUserId());
		Session session = HibernateUtil.getSessionFactory().openSession();
		user.setPassword(newPassword);
		session.beginTransaction();
       session.update(user);
       User updatedUser = getUser(user.getUserId());
       System.out.println("Updated succesfully"+updatedUser.getPassword());
       session.getTransaction().commit();
		session.close();
	}

	public User getUser(Integer userId) {
		System.out.println("Inside getUser!!!   "+userId);
		 List<User> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM com.uxpsystems.assignment.model.User usr where usr.id = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId",userId);
        System.out.println("***** query : "+query);
        userList = query.list();
      System.out.println("********* userList: "+userList.get(0).getUsername());
      return userList.get(0);
	}

	public void delUser(Integer userId) {
		System.out.println("!!!!!!!!!! Inside deleteUser!!!   "+userId);
		Session session = HibernateUtil.getSessionFactory().openSession();
		User usr = getUser(userId);
		System.out.println("!!!!!!!!!! Inside deleteUser!!! usr: "+usr.getUsername());
		session.beginTransaction();
		session.delete(usr);	
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean isUserNameExists(String userName) {
		System.out.println("Inside getUserByUserName!!!   "+userName);
		 List<User> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM com.uxpsystems.assignment.model.User usr where usr.username = :userName";
       Query query = session.createQuery(hql);
       query.setParameter("userName",userName);
       System.out.println("***** query : "+query);
       userList = query.list();
       if(userList != null && userList.size() > 0) {
    	   System.out.println("********* userList: "+userList.get(0).getUsername());
    	   return true;
       }
       else
       {
    	   return false;
       }     
	}

	public void updateUserStatus(User user, String status) {
		System.out.println("Inside editUser!!!   "+user.getUserId());
		Session session = HibernateUtil.getSessionFactory().openSession();
		user.setStatus(status);
		session.beginTransaction();
       session.update(user);
       User updatedUser = getUser(user.getUserId());
       System.out.println("Updated succesfully"+updatedUser.getStatus());
       session.getTransaction().commit();
		session.close();
		
	}

/*	public User getUserByUserName(String userName) {
		System.out.println("Inside getUserByUserName!!!   "+userName);
		 List<User> userList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM com.uxpsystems.assignment.model.User usr where usr.username = :userName";
       Query query = session.createQuery(hql);
       query.setParameter("userName",userName);
       System.out.println("***** query : "+query);
       userList = query.list();
       if(userList != null && userList.size() > 0) {
    	   System.out.println("********* userList: "+userList.get(0).getUsername());
    	   return userList.get(0);
       }
       else
       {
    	   return null;
       }
     
     
	}*/

}
