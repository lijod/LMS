package com.lms.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lms.dao.PostDao;
import com.lms.dao.ThreadDao;
import com.lms.model.Post;
import com.lms.model.Thread;

@Path("/jwsPostService")
public class PostService {
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findAllPostsByThreadId")
	public List<Post> findAllPostsByThreadIdService(int threadId) {		
		PostDao postDaoObject = new PostDao();
		return postDaoObject.findAllPostsByThreadId(threadId);
	}

}
