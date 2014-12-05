package com.lms.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.lms.dao.ThreadDao;
import com.lms.model.Thread;

@Path("/jwsThreadService")
public class ThreadService {

	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findAllThreads")
	public List<Thread> findAllThreads() {		
		ThreadDao courseDaoObj = new ThreadDao();
		return courseDaoObj.findAllThreads();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findAThreadByThreadId")
	public Thread findAThreadByThreadIdService(int threadId) {		
		ThreadDao courseDaoObj = new ThreadDao();
		return courseDaoObj.findAThreadByThreadId(threadId);
	}
	
}
