package com.lms.service;

import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.lms.dao.UserDao;
import com.lms.model.User;

// /com.lms.servic/JWSUserService
@Path("/jwsUserService")
public class UserService {

	// /com.lms.servic/JWSUserService/createUser

	@Path("/createUser/{userName}/{password}/{firstName}/{lastName}/{email}/{dateOfBirth}}")
	public User createUserService(@PathParam("userName") String userName,
			@PathParam("password") String password,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("email") String email,
			@PathParam("dateOfBirth") Date dateOfBirth) {
		User user =new User (userName,password,firstName,lastName,email,dateOfBirth);
		UserDao userObj = new UserDao();
		userObj.createUser(user);
		return user;
	}



}
