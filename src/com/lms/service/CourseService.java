package com.lms.service;

import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.lms.dao.CourseDao;
import com.lms.model.Course;


// /com.lms.servic/jwsCourseService
@Path("/jwsCourseService")

public class CourseService {
	
	// /com.lms.servic/jwsCourseService/createCourse

		@Path("/createCourse/{courseName}/{sectionNumber}/{courseLocation}/{courseStartTime}/{courseEndTime}/{courseDay}")
		public Course createCourseService(@PathParam("courseName") String courseName,
				@PathParam("sectionNumber") int sectionNumber,
				@PathParam("courseLocation") String courseLocation,
				@PathParam("courseStartTime") String courseStartTime,
				@PathParam("courseEndTime") String courseEndTime,
				@PathParam("courseDay") String courseDay) {
			Course course =new Course (courseName,sectionNumber,courseLocation,new Date(),new Date(),courseDay);
			CourseDao courseObj = new CourseDao();
			courseObj.createCourse(course);
			return course;
		}

	
	
		// /com.lms.servic/jwsCourseService/findCourseById

		@Path("/findCourseById/{id}")
		public Course findCourseByIdService(@PathParam("id") int id) {
			Course course =new Course();
			CourseDao courseObj = new CourseDao();
			course=courseObj.findCourseById(id);
			return course;
		}
		
		
		// /com.lms.servic/jwsCourseService/deleteCourse

		@Path("/deleteCourse/{id}")
		public Boolean deleteCourseService(@PathParam("id") int id) {
			CourseDao courseObj = new CourseDao();
			return courseObj.deleteCourse(id);
		}

	
}
