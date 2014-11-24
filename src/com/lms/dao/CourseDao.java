package com.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lms.model.Course;
import com.lms.model.User;

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

	public Course findCourseById(int courseId){
		em.getTransaction().begin();
		Course course = em.find(Course.class, courseId);
		em.getTransaction().commit();
		return course;
	}
	
	public void deleteCourse(int courseId){
		em.getTransaction().begin();
		Course course = em.find (Course.class, courseId);
		em.remove(course);
		em.getTransaction().commit();
	}
	
}
