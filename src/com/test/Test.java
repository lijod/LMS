package com.test;

import com.lms.dao.UserCourseDetailDao;
import com.lms.enumeration.Role;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		/*User user = new User("sam2", "jon", "sam", "sam1", "sam@sam.com", new Date());
		Course course = new Course("CS1", 01, "Shillman", new Date(), new Date(), "Monday");
		user = new UserDao().createUser(user);
		course = new CourseDao().createCourse(course);
		UserCourseDetail ucd = new UserCourseDetail(course.getCourseId(), user.getUserId(), Role.PROFESSOR.toString());
		new UserCourseDetailDao().createUserCourseDetail(ucd);
		
		System.out.println(user);
		System.out.println(course);
		System.out.println(ucd);
		
		user = null;
		user = new UserDao().findUserByUserId(1);
		
		System.out.println("select:\n" + user);*/
		
		new UserCourseDetailDao().deleteUserCourseDetail(6, 1, Role.PROFESSOR.toString());
	}
	
}
