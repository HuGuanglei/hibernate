package com.guanglei.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guanglei.javaBean.User;

public class Hibernate {
	static Logger logger = LoggerFactory.getLogger(Hibernate.class);

	public static void main(String[] args) {

		try {
			Session session = null;
			Configuration cfg = new Configuration().configure();
			SessionFactory factory = cfg.buildSessionFactory();
			session = factory.openSession();
			session.beginTransaction();
			User user1 = new User();
			User user2 = new User();
			user1.setUserId("1");
			user1.setUsername("hgl");
			user1.setPassword("111");
			
			user2.setUserId("2");
			user2.setUsername("hgl2");
			user2.setPassword("222");
			
			
			session.save(user1);
			session.save(user2);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			logger.error("hibernateDao error", e);
		}
	}

}
