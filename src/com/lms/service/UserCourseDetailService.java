package com.lms.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.lms.dao.UserCourseDetailDao;
import com.lms.model.User;
import com.lms.model.UserCourseDetail;
import com.lms.util.UserCourseDetailUtil;

// /com.lms.servic/jwsUserCourseDetailService
@Path("/jwsUserCourseDetailService")
public class UserCourseDetailService {

	// /com.lms.servic/jwsUserCourseDetailService/createUserCourseDetail
	
	@Path("/createUserCourseDetail/{courseId}/{userId}/{roleName}")
	public UserCourseDetail createUserCourseDetail(
			@PathParam("courseId") int courseId,
			@PathParam("userId") int userId,
			@PathParam("roleName") String roleName) {
		UserCourseDetail ucd = new UserCourseDetail(courseId, userId, roleName);
		UserCourseDetailDao userCourseDetailDaoObj = new UserCourseDetailDao();
		return userCourseDetailDaoObj.createUserCourseDetail(ucd);
	}

	// /com.lms.servic/jwsUserCourseDetailService/deleteUserCourseDetail

	@Path("/deleteUserCourseDetail/{courseId}/{userId}/{roleName}")
	public Boolean deleteUserCourseDetailService(
			@PathParam("courseId") int courseId,
			@PathParam("userId") int userId,
			@PathParam("roleName") String roleName) {
		UserCourseDetailDao ucd = new UserCourseDetailDao();
		return ucd.deleteUserCourseDetail(courseId, userId, roleName);
	}

	// /com.lms.servic/jwsUserCourseDetailService/findByUserId

	@Path("/findByUserId/{userId}")
	public List<UserCourseDetail> findByUserIdService(@PathParam("userId") int userId) {
		UserCourseDetailDao ucd = new UserCourseDetailDao();
		return ucd.findByUserId(userId);
	}
	
	// /com.lms.servic/jwsUserCourseDetailService/findByCourseId

	@Path("/findByCourseId/{userId}")
	public List<UserCourseDetail> findByCourseIdService(@PathParam("courseIdId") int courseId) {
		UserCourseDetailDao ucd = new UserCourseDetailDao();
		return ucd.findByUserId(courseId);
	}
	
	@GET
	@Path("/findUserByRole/{role}")
	public List<User> findUserByRole(@PathParam("role") String role) {
		UserCourseDetailDao ucd = new UserCourseDetailDao();
		System.out.println(UserCourseDetailUtil.getUsersFromUserCourseDetail(ucd.findByRole(role)));
		return UserCourseDetailUtil.getUsersFromUserCourseDetail(ucd.findByRole(role));
	}
}
