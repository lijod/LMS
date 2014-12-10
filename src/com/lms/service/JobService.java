package com.lms.service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lms.dao.JobDao;
import com.lms.dao.ThreadDao;
import com.lms.dao.UserDao;
import com.lms.model.Job;
import com.lms.model.Thread;
import com.lms.model.User;

@Path("/jwsJobService")
public class JobService {

	
	
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/createAJob")
	public Job createJobService(Job jobObject) {	
		 System.out.println(jobObject);
		JobDao jobDaoObj = JobDao.getInstance();
		jobDaoObj.createJob(jobObject);
		return jobObject;
	}
	 
	 
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/findJobsByProfessorId")
	 public List<Job> findJobsByProfessorIdService(int userId){
	  JobDao jobDaoObj = JobDao.getInstance();
	  return jobDaoObj.findJobsByProfessorId(userId);
	 }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Path("/findJobsByProfessorIdAndCourseId")
	 public List<Job> findJobsByProfessorIdAndCourseIdService(@FormParam("userId") int userId, @FormParam("courseId") int courseId){
	  JobDao jobDaoObj = JobDao.getInstance();
	  return jobDaoObj.findJobsByProfessorIdAndCourseId(userId,courseId);
	 }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Path("/findAllJobsByCourseId")
	 public List<Job> findJobsByCourseIdService(@FormParam("courseId") int courseId){
	  JobDao jobDaoObj = JobDao.getInstance();
	  return jobDaoObj.findJobsByCourseId(courseId);
	 }
	 
	    @POST
		@Produces(MediaType.APPLICATION_JSON)
		//@Consumes(MediaType.APPLICATION_JSON)
		@Path("/findAJobByJobId")
		public Job findAJobByJobIdService(int jobId) {		
			JobDao courseDaoObj = JobDao.getInstance();
			return courseDaoObj.findAJobByJobId(jobId);
		}
	 
	 //
	 
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Path("/deleteJobByJobId")
		public Boolean deleteJobByJobIdService(@FormParam("jobId") int jobId) {
			JobDao jobDaoObj = JobDao.getInstance();
			return jobDaoObj.deletejOB(jobId);
		}
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/updateJobByJobId")
		public Job updateJobByJobIdService(Job job) {
			JobDao jobDaoObj = JobDao.getInstance();
			return jobDaoObj.updateJob(job);
		}
	 
	
}
