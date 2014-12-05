package com.lms.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lms.dao.CourseDao;
import com.lms.model.Course;

// /com.lms.service/jwsCourseService
@Path("/jwsCourseService")
public class CourseService {

	// /com.lms.service/jwsCourseService/createCourse
	/*
	 * @GET
	 * 
	 * @Path("/createCourse/{courseName}/{sectionNumber}") public Course
	 * createCourseService(@PathParam("courseName") String courseName,
	 * 
	 * @PathParam("sectionNumber") int sectionNumber) { Course course =new
	 * Course (courseName,sectionNumber); CourseDao courseObj = new CourseDao();
	 * courseObj.createCourse(course); return course; }
	 */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createCourse")
	public Course createCourseService(Course course) {

		CourseDao courseDaoObj = new CourseDao();
		courseDaoObj.createCourse(course);
		return course;
	}

	// /com.lms.service/jwsCourseService/findCourseById
	@GET
	@Path("/findCourseById/{id}")
	public Course findCourseByIdService(@PathParam("id") int id) {
		Course course = new Course();
		CourseDao courseDaoObj = new CourseDao();
		course = courseDaoObj.findCourseById(id);
		return course;
	}

	// /com.lms.service/jwsCourseService/deleteCourse
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteCourseById")
	public Boolean deleteCourseService(int id) {
		CourseDao courseDaoObj = new CourseDao();
		return courseDaoObj.deleteCourse(id);
	}

	// /com.lms.service/jwsCourseService/findAllCourses
	@GET
	@Path("/findAllCourses")
	public List<Course> findAlleCoursesService() {
		
		CourseDao courseDaoObj = new CourseDao();
		return courseDaoObj.findAllCourses();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateCourse")
	public Course updateCourseService(Course course) {
        System.out.println("updateCourseService");
		CourseDao courseDaoObj = new CourseDao();
		courseDaoObj.updateCourse(course);
		return course;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/findAllCoursesForAUserId")
	public List<Course> findAllCoursesForAUserIdService(int userId) {		
		CourseDao courseDaoObj = new CourseDao();
		return courseDaoObj.findAllCoursesForAUserId(userId);
	}

	

}
