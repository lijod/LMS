package com.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lms.model.User;

public class UserDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
	EntityManager em = null;
	public UserDao() {
		em = emf.createEntityManager();
	}
	
	public User createUser(User user){
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		return user;
	}

	public User findUserByUserId(int userId){
		User user = null;
		em.getTransaction().begin();
		user = em.find(User.class, userId);
		em.getTransaction().commit();
		return user;
	}
	
	public Boolean deleteUser(int userId){
		em.getTransaction().begin();
		User user = em.find (User.class, userId);
		System.out.println("delete:" + user);
		em.remove(user);
		em.getTransaction().commit();
		return true;
	}
	
	public User updateUser(User user){
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		return user;
	}
	
}
