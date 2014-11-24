package com.lms.service;

import javax.ws.rs.Path;

import com.lms.dao.UserDao;
import com.lms.model.User;

// /com.lms.servic/JWSUserService
@Path("/jwsUserService")
public class UserService {
	
	// /com.lms.servic/JWSUserService/createUser
	
	@Path("/createUser/{userName}/{password}/{firstName}/{lastName}/{email}/{dateOfBirth}}")
	public void createUserService(User user){
	UserDao userObj = new UserDao();
	userObj.createUser(user);
	}
	
	@Path("/findUserByUserId/{}")
	public void findUserByUserIdService(User user){
	UserDao userObj = new UserDao();
	userObj.createUser(user);
	}

}
