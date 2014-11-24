package com.lms.util;

import java.util.ArrayList;
import java.util.List;

import com.lms.model.User;
import com.lms.model.UserCourseDetail;

public class UserCourseDetailUtil {

	public static List<User> getUsersFromUserCourseDetail(List<UserCourseDetail> ucdList){
		List<User> userList = new ArrayList<User>();
		for(UserCourseDetail ucd : ucdList){
			userList.add(ucd.getUser());
		}
		return userList;
	}

}
