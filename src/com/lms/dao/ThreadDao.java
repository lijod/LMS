package com.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lms.model.Thread;

public class ThreadDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
	EntityManager em = null;
	
	public ThreadDao() {
		em = emf.createEntityManager();
	}
	
	public Thread createThread(Thread thread){
		
		em.getTransaction().begin();
		em.persist(thread);
		em.getTransaction().commit();
		
		return thread;
	}
	
	public Thread findThreadByThreadId(int threadId){
		Thread thread = new Thread();
		em.getTransaction().begin();
		thread = em.find(Thread.class, threadId);
		em.getTransaction().commit();
		return thread;
	}
	
	public Boolean deleteThread(int threadId){
		em.getTransaction().begin();
		Thread thread = em.find (Thread.class, threadId);
		System.out.println("delete:" + thread);
		em.remove(thread);
		em.getTransaction().commit();
		return true;
	}
	
	public Thread updateThread(Thread thread){
		em.getTransaction().begin();
		em.merge(thread);
		em.getTransaction().commit();
		return thread;
	}
	
	public List<Thread> findThreadByUserId(int userId){
		List<Thread> threadList = null;
		em.getTransaction().begin();
		Query query = em.createQuery("select thread from Thread thread where userId = :userId");
		query.setParameter("userId", userId);
		threadList = query.getResultList();
		em.getTransaction().commit();
		return threadList;
	}
	
	public List<Thread> findThreadByCourseId(int courseId){
		List<Thread> threadList = null;
		em.getTransaction().begin();
		Query query = em.createQuery("select thread from Thread thread where courseId = :courseId");
		query.setParameter("courseId", courseId);
		threadList = query.getResultList();
		em.getTransaction().commit();
		return threadList;
	}
	
}
