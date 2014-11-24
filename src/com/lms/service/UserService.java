package com.lms.service;

import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.lms.dao.UserDao;
import com.lms.model.User;

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
		User user =new User (userName,password,firstName,lastName,email,new Date());
		UserDao userDaoObj = new UserDao();
		userDaoObj.createUser(user);
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

	@Path("/deleteUser/{id}")
	public Boolean deleteUserService(@PathParam("id") int id) {
		UserDao userDaoObj = new UserDao();
		return userDaoObj.deleteUser(id);
	}

}
