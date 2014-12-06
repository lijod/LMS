package com.lms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lms.dao.PostDao;
import com.lms.dao.UserCourseDetailDao;
import com.lms.dao.UserDao;
import com.lms.model.Post;
import com.lms.model.User;
import com.lms.model.UserCourseDetail;

// /com.lms.servic/JWSUserService
@Path("/jwsUserService")
public class UserService {

	// /com.lms.servic/jwsUserService/createUser

	@Path("/createUser/{userName}/{password}/{firstName}/{lastName}/{email}/{dateOfBirth}")
	public User createUserService(@PathParam("userName") String userName,
			@PathParam("password") String password,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("email") String email,
			@PathParam("dateOfBirth") String dateOfBirth) {
		User user =new User (userName,password,firstName,lastName,email,new Date(), null);
		UserDao userDaoObj = new UserDao();
		userDaoObj.createUser(user);
		return user;
	}
	
	@GET
	@Path("/createUser/{userName}/{password}/{firstName}/{lastName}/{email}/{dateOfBirth}/{role}/{courses}")
	public User createUserServiceWithRole(@PathParam("userName") String userName,
			@PathParam("password") String password,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("email") String email,
			@PathParam("dateOfBirth") String dateOfBirth,
			@PathParam("role") String role,
			@PathParam("courses") String courses) {
		User user =new User (userName,password,firstName,lastName,email,new Date(), null);
		user = new UserDao().createUser(user);
		List<UserCourseDetail> ucdList = new ArrayList<UserCourseDetail>();
		for(String id : courses.split(",")){
			UserCourseDetail ucd = new UserCourseDetail(
					Integer.parseInt(id), user.getUserId(), role);
			ucdList.add(new UserCourseDetailDao().createUserCourseDetail(ucd));
		}
		user.setUserCourseDetail(ucdList);
		return user;
	}

	// /com.lms.servic/jwsUserService/findUserByUserId

	@Path("/findUserByUserId/{id}")
	public User findUserByUserIdService(@PathParam("id") int id) {
		User user =new User();
		UserDao userDaoObj = new UserDao();
		user=userDaoObj.findUserByUserId(id);
		return user;
	}
	
	
	// /com.lms.servic/jwsUserService/deleteUser

	@GET
	@Path("/deleteUser/{id}")
	public Boolean deleteUserService(@PathParam("id") int id) {
		System.out.println("id" + id);
		UserDao userDaoObj = new UserDao();
		return userDaoObj.deleteUser(id);
	}

	@GET
	@Path("/updateUser/{userId}/{userName}/{password}/{firstName}/{lastName}/{email}/{dateOfBirth}/{role}/{courses}")
	public User updateUserService(@PathParam("userId") int userId,
			@PathParam("userName") String userName,
			@PathParam("password") String password,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("email") String email,
			@PathParam("dateOfBirth") String dateOfBirth,
			@PathParam("role") String role,
			@PathParam("courses") String courses){
		UserDao userDaoObj = new UserDao();
		User user = userDaoObj.findUserByUserId(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setUserName(userName);
		user.setEmail(email);
		userDaoObj.updateUser(user);
		UserCourseDetailDao ucdDao = new UserCourseDetailDao();
		ucdDao.deleteByUserIdAndRole(userId, role);
		for(String id : courses.split(",")){
			UserCourseDetail ucd = new UserCourseDetail(
					Integer.parseInt(id), user.getUserId(), role);
			new UserCourseDetailDao().createUserCourseDetail(ucd);
		}
		return user;
	}
	
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/findAllUsers")
	 public List<User> findAllUsersService(){
	  UserDao userDaoObj = new UserDao();
	  return userDaoObj.findAllUsers();
	 }
	 
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/findAllUsersNotTAForACourse")
	 public List<User> findAllUsersNotTAForACourseService(int courseId){
	  UserDao userDaoObj = new UserDao();
	  return userDaoObj.findAllUsersNotTAForACourse(courseId);
	 }
	 
	    @POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/UserFollowsAnotherUser")
		public User UserFollowsAnotherUserService(int followerUserId,int followedUserId) {	
			UserDao userDaoObj = new UserDao();			
			User followerUserObj = userDaoObj.findUserByUserId(followerUserId);
			System.out.println("service before dao call1"+followerUserObj);						
			List<User> existingFollowedUserList = followerUserObj.getFollowedUsersList();			
			User followedUserObj = userDaoObj.findUserByUserId(followedUserId);
			System.out.println("service before dao call2"+followedUserObj);
			existingFollowedUserList.add(followedUserObj);			
			followerUserObj.setFollowedUsersList(existingFollowedUserList);			
		  return userDaoObj.updateUser(followerUserObj);
	    	//return followerUserObj;
		}
	    
	    @POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/UserUnFollowsAnotherUser")
		public User UserUnFollowsAnotherUserService(int followerUserId,int followedUserIdToBeRemoved) {	
			UserDao userDaoObj = new UserDao();			
			User followerUserObj = userDaoObj.findUserByUserId(followerUserId);
			System.out.println("service before dao call1"+followerUserObj);			
					
			List<User> usersWhoHaveAlreadyFollowedUsers = new CopyOnWriteArrayList<User>(followerUserObj.getFollowedUsersList());
			
			for(User u : usersWhoHaveAlreadyFollowedUsers) {
				if(u.getUserId() == followedUserIdToBeRemoved){
					usersWhoHaveAlreadyFollowedUsers.remove(u);
				}
			}
			
					
			followerUserObj.setFollowedUsersList(usersWhoHaveAlreadyFollowedUsers);			
		  return userDaoObj.updateUser(followerUserObj);
	    	//return followerUserObj;
		}
	
}
