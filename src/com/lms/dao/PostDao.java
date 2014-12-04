package com.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lms.model.Post;
import com.lms.model.Thread;

public class PostDao {

	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LMS");
		EntityManager em = null;
		
		public PostDao(){
			em = emf.createEntityManager();	
		}
		
		public Post createPost(Post post){
			
			em.getTransaction().begin();
			em.persist(post);
			em.getTransaction().commit();
			
			return post;
		}
		
		public Post findPostByPostId(int postId){
			Post post = new Post();
			em.getTransaction().begin();
			post = em.find(Post.class, postId);
			em.getTransaction().commit();
			return post;
		}
		
		public Boolean deletePost(int postId){
			em.getTransaction().begin();
			Post post = em.find (Post.class, postId);
			System.out.println("delete:" + postId);
			em.remove(post);
			em.getTransaction().commit();
			return true;
		}
		
		public Post updatePost(Post post){
			em.getTransaction().begin();
			em.merge(post);
			em.getTransaction().commit();
			return post;
		}
		
		public List<Post> findPostByUserId(int userId){
			List<Post> postList = null;
			em.getTransaction().begin();
			Query query = em.createQuery("select post from Post post where userId = :userId");
			query.setParameter("userId", userId);
			postList = query.getResultList();
			em.getTransaction().commit();
			return postList;
		}
		
	

}
