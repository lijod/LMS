package com.lms.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lms.dao.CourseDao;
import com.lms.dao.PostDao;
import com.lms.dao.ThreadDao;
import com.lms.dao.UserDao;
import com.lms.model.Course;
import com.lms.model.Post;
import com.lms.model.Thread;
import com.lms.model.User;
import com.mysql.fabric.xmlrpc.base.Data;

@Path("/jwsPostService")
public class PostService {
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createPost")
	public Post createPostService(Post post) {
		post.setPostDate(new Date());
        post.setPostTime(new Time(new Date().getTime()));
		PostDao poastDaoObj = new PostDao();
		poastDaoObj.createPost(post);
		return post;
	}
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findAllPostsByThreadId")
	public List<Post> findAllPostsByThreadIdService(int threadId) {		
		PostDao postDaoObject = new PostDao();
		return postDaoObject.findAllPostsByThreadId(threadId);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/likeAPost")
	public Post likeAPostService(Post post) {	
				
		UserDao userDaoObj = new UserDao();
		User userObj=userDaoObj.findUserByUserId(post.getUserId());		
		
		PostDao postDaoObject = new PostDao();
		Post postObj = postDaoObject.findPostByPostId(post.getPostId());
		
		List<User> usersWhoHaveAlreadyLikedThisPostLst =postObj.getUsersWhoHaveLikedPosts();
		usersWhoHaveAlreadyLikedThisPostLst.add(userObj);
		
		postObj.setUsersWhoHaveLikedPosts(usersWhoHaveAlreadyLikedThisPostLst);
		
		return postDaoObject.updatePost(postObj);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/unLikeAPost")
	public Post UnLikeAPostService(Post post) {	
				
		UserDao userDaoObj = new UserDao();
		PostDao postDaoObject = new PostDao();
		Post postObj = postDaoObject.findPostByPostId(post.getPostId());
		
		List<User> usersWhoHaveAlreadyLikedThisPostLst = new CopyOnWriteArrayList<User>(postObj.getUsersWhoHaveLikedPosts());
		
		for(User u : usersWhoHaveAlreadyLikedThisPostLst) {
			if(u.getUserId() == post.getUserId()){
				usersWhoHaveAlreadyLikedThisPostLst.remove(u);
			}
		}
		postObj.setUsersWhoHaveLikedPosts(usersWhoHaveAlreadyLikedThisPostLst);
		return postDaoObject.updatePost(postObj);
		
	}
	
}
