package com.lms.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lms.dao.CourseDao;
import com.lms.dao.PostDao;
import com.lms.dao.ThreadDao;
import com.lms.model.Course;
import com.lms.model.Post;
import com.lms.model.Thread;
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

}
