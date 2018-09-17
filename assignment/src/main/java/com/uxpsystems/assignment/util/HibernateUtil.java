package com.uxpsystems.assignment.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	   private static SessionFactory sessionFactory = buildSessionFactory();
	   
	   private static SessionFactory buildSessionFactory()
	   {
	      try
	      {
	         if (sessionFactory == null)
	         {
	        	 System.out.println("######################### sessionFactory is null");
	            Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
	            System.out.println("configuration"+configuration);
	            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
	            System.out.println("serviceRegistryBuilder"+serviceRegistryBuilder);
	            serviceRegistryBuilder.applySettings(configuration.getProperties());
	            System.out.println("Applied");
	            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	            System.out.println("serviceRegistry:"+serviceRegistry);
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            System.out.println("sessionFactory"+sessionFactory);
	         }
	         return sessionFactory;
	      } catch (Throwable ex)
	      {
	         System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	      }
	   }
	 
	   public static SessionFactory getSessionFactory()
	   {
	      return sessionFactory;
	   }
	 
	   public static void shutdown()
	   {
	      getSessionFactory().close();
	   }
}
