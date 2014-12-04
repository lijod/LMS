package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lms.dao.CourseDao;
import com.lms.dao.CourseScheduleDao;
import com.lms.dao.UserCourseDetailDao;
import com.lms.dao.UserDao;
import com.lms.enumeration.Role;
import com.lms.model.Course;
import com.lms.model.CourseSchedule;
import com.lms.model.User;
import com.lms.model.UserCourseDetail;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

/*		User user = new User("sam2", "jon", "sam", "sam1", "sam@sam.com", new Date());
		Course course = new Course("CS1", 01);
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
		
		//new UserCourseDetailDao().deleteUserCourseDetail(6, 1, Role.PROFESSOR.toString());
		
	CourseSchedule cs= new CourseSchedule(15,new Date(), new Date(),31,"b",new Date(), new Date(),"f");
	/*	new CourseScheduleDao().createCourseSchedule(cs);
		
		List<CourseSchedule> courseSchedulelist=null;
		courseSchedulelist =new CourseScheduleDao().findAllCourseSchedule();
		System.out.println("select:\n" + courseSchedulelist.get(0).getCourseLocation());*/
		
		
		//CourseDao obj = new 	CourseDao();
		/*List<Course> result = obj.findAllCourses();
		System.out.println(result.get(0).getCourseScheduleList().get(0).getDay());
		*/
		
	/*	Course result = obj.findCourseById(1);
		System.out.println(result.getCourseScheduleList().get(0).getDay());*/
		
		/*List<CourseSchedule> csList=new ArrayList<CourseSchedule>();
		csList.add(cs);
		Course course =new Course ("ioioio",12, csList); 
		CourseDao courseObj = new CourseDao();
		courseObj.createCourse(course);*/
		
/*		List<CourseSchedule> csList = new ArrayList<CourseSchedule>();
		csList.add(cs);
		Course course = new Course(31, "ioioioioioioioi", 121212, csList);
		CourseDao courseObj = new CourseDao();
		courseObj.updateCourse(course);*/
	
	
	/*User user = new User();
	UserDao userDaoObj = new UserDao();
	user=userDaoObj.findUserByUserId(8);
	System.out.println(user);
	System.out.println(user.getUserCourseDetail().get(1).getCourse());*/
/*	
	UserCourseDetailDao userCourseDetailDaoObj = new UserCourseDetailDao();
	userCourseDetailDaoObj.createUserCourseDetail(new UserCourseDetail(4,4,"TA"));*/
	
	UserDao userDaoObj=new	UserDao();
	System.out.println(userDaoObj.findAllUsersNotTAForACourse(38));
	
		
	}
	
}
