package com.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lms.model.UserCourseDetail;
import com.lms.model.UserCourseDetailPK;

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
		em.refresh(ucd);
		return ucd;
	}
	
	public void deleteUserCourseDetail(int courseId, int userId, String roleName){
		em.getTransaction().begin();
		em.remove(em.find(UserCourseDetail.class, new UserCourseDetailPK(courseId, userId, roleName)));
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCourseDetail> findByUserId(int userId){
		em.getTransaction().begin();
		Query query = em.createQuery("select ucd from UserCourseDetail ucd where ucd.userid = :userId");
		query.setParameter("userId", userId);
		List<UserCourseDetail> result = query.getResultList();
		em.getTransaction().commit();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCourseDetail> findByCourseId(int courseId){
		em.getTransaction().begin();
		Query query = em.createQuery("select ucd from UserCourseDetail ucd where ucd.courseId = :courseId");
		query.setParameter("courseId", courseId);
		List<UserCourseDetail> result = query.getResultList();
		em.getTransaction().commit();
		return result;
	}
	
}
