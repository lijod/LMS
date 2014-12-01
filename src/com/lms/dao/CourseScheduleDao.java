package com.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lms.model.CourseSchedule;
import com.lms.model.UserCourseDetail;

public class CourseScheduleDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
	EntityManager em = null;
	
	public CourseScheduleDao() {
		em = emf.createEntityManager();
	}
	
	public CourseSchedule createCourseSchedule(CourseSchedule courseSchedule){
		
		em.getTransaction().begin();
		em.persist(courseSchedule);
		em.getTransaction().commit();
		
		return courseSchedule;
	}

	public List<UserCourseDetail> findCourseScheduleBycourseId(int courseId){
		em.getTransaction().begin();
		Query query = em.createQuery("select cs from CourseSchedule cs where cs.courseId = :courseId");
		query.setParameter("courseId", courseId);
		@SuppressWarnings("unchecked")
		List<UserCourseDetail> result = query.getResultList();
		em.getTransaction().commit();
		return result;
	}
	

	
	public Boolean deleteCourseSchedule(int courseId){
		em.getTransaction().begin();
		CourseSchedule courseSchedule = em.find (CourseSchedule.class, courseId);
		em.remove(courseSchedule);
		em.getTransaction().commit();
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<CourseSchedule> findAllCourseSchedule() {
		Query query = em.createQuery("select courseSchedule from CourseSchedule courseSchedule");
		List<CourseSchedule> result = query.getResultList();
		return result;
	}

}
