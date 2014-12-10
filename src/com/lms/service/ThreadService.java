package com.lms.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lms.dao.ThreadDao;
import com.lms.dao.UserDao;
import com.lms.model.Thread;
import com.lms.model.User;

@Path("/jwsThreadService")
public class ThreadService {

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findThreadsByCourseId")
	public List<Thread> findThreadsByCourseIdService(int courseId) {		
		ThreadDao courseDaoObj = ThreadDao.getInstance();
		return courseDaoObj.findThreadsByCourseId(courseId);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findAllThreads")
	public List<Thread> findAllThreads() {		
		ThreadDao courseDaoObj = ThreadDao.getInstance();
		return courseDaoObj.findAllThreads();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findAThreadByThreadId")
	public Thread findAThreadByThreadIdService(int threadId) {		
		ThreadDao courseDaoObj = ThreadDao.getInstance();
		return courseDaoObj.findAThreadByThreadId(threadId);
	}
	
	@POST
	@Path("/createThread") 
	public Thread createThread(Thread thread){
		thread.setThreadTime(new Time(new Date().getTime()));
		thread.setThreadDate(new Date());
		ThreadDao.getInstance().createThread(thread);
		return thread;
	}
	
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/setFavThreadForUser")
	 public Thread setFavThreadForUser(Thread thread){		 
		 System.out.println(thread.getUserId() + "_" + thread.getThreadId());
		 ThreadDao threadDao = ThreadDao.getInstance(); 
		 User user = UserDao.getInstance().findUserByUserId(thread.getUserId());
		 Thread threadNew = threadDao.findAThreadByThreadId(thread.getThreadId());
		 System.out.println(thread.getFavUsers());
		 List<User> userList = threadNew.getFavUsers();
		 System.out.println(userList);
		 userList.add(user);
		 System.out.println(userList);
		 threadNew.setFavUsers(userList);
		 threadNew = ThreadDao.getInstance().updateThread(threadNew);
		 return threadNew;
	 }
	 
	 @DELETE
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/undoFavThreadForUser")
	 public Thread undoFavThreadForUser(Thread thread){
		 ThreadDao threadDao = ThreadDao.getInstance(); 
		 Thread threadNew = threadDao.findAThreadByThreadId(thread.getThreadId());
		 List<User> userList = new CopyOnWriteArrayList<User>(threadNew.getFavUsers());
		 for(User user : userList){
			if(user.getUserId() == thread.getUserId())
				userList.remove(user);
		 }
		 threadNew.setFavUsers(userList);
		 threadNew = ThreadDao.getInstance().updateThread(threadNew);
		 
		 return threadNew;
	 }
	 
}
