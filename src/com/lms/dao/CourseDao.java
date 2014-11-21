package com.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lms.model.Course;

public class CourseDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
	EntityManager em = null;
	
	public CourseDao() {
		em = emf.createEntityManager();
	}
	
	public Course createCourse(Course course){
		
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		
		return course;
	}

}
