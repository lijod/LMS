package com.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lms.model.UserCourseDetail;

public class UserCourseDetailDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
	EntityManager em = null;
	public UserCourseDetailDao() {
		em = emf.createEntityManager();
	}
	
	public UserCourseDetail createUserCourseDetail(UserCourseDetail ucd){
		em.getTransaction().begin();
		em.persist(ucd);
		em.getTransaction().commit();
		return ucd;
	}
	
}
