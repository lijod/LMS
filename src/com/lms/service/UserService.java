package com.lms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.lms.dao.CourseDao;
import com.lms.dao.UserCourseDetailDao;
import com.lms.dao.UserDao;
import com.lms.model.User;
import com.lms.model.UserCourseDetail;
import com.lms.model.UserCourseDetailPK;

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
	
}
