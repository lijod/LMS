package com.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lms.model.Tag;
import com.lms.model.User;

public class TagDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
	EntityManager em = null;
	
	public TagDao() {
		em = emf.createEntityManager();
	}
	
	public List<Tag> findAllTags(){
		List<Tag> tags = null;
		em.getTransaction().begin();
		Query query = em.createNamedQuery("Tag.findAll", Tag.class);
		tags = query.getResultList();
		em.getTransaction().commit();
		return tags;
	}

	public Tag findTagByTagId(int tagId){
		Tag tag = new Tag();
		em.getTransaction().begin();
		tag = em.find(Tag.class, tagId);
		em.getTransaction().commit();
		return tag;
	}

	public Tag createTag(Tag tag) {
		em.getTransaction().begin();
		em.persist(tag);
		em.getTransaction().commit();
		return tag;
	}
	
}