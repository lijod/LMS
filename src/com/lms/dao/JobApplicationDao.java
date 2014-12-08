package com.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lms.model.JobApplication;

public class JobApplicationDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
	EntityManager em = null;
	
	public JobApplicationDao() {
		em = emf.createEntityManager();
	}
	
	
	public JobApplication createJobApplication(JobApplication jobApplicationObj){		
		em.getTransaction().begin();
		em.persist(jobApplicationObj);
		em.getTransaction().commit();		
		return jobApplicationObj;
	}
	
	

}
