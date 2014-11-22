package com.lms.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */

@Entity
@Table(name="course")
public class Course implements Serializable {
	   
	@Id
	@Column(name="course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	@Column(name="course_name")
	private String courseName;
	@Column(name="section_num")
	private int sectionNumber;
	@Column(name="course_location")
	
	private String courseLocation;
	@Column(name="course_start_time")
	@Temporal(TemporalType.TIME)
	private Date courseStartTime;
	@Column(name="course_end_time")
	@Temporal(TemporalType.TIME)
	private Date courseEndTime;
	@Column(name="course_day")
	private String courseDay;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="course_id", referencedColumnName = "course_id")
	private List<UserCourseDetail> userCourseDetail;

	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}   
	
	public Course(String courseName, int sectionNumber, String courseLocation,
			Date courseStartTime, Date courseEndTime, String courseDay) {
		super();
		this.courseName = courseName;
		this.sectionNumber = sectionNumber;
		this.courseLocation = courseLocation;
		this.courseStartTime = courseStartTime;
		this.courseEndTime = courseEndTime;
		this.courseDay = courseDay;
	}

	public Course(int courseId, String courseName, int sectionNumber,
			String courseLocation, Date courseStartTime, Date courseEndTime,
			String courseDay) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.sectionNumber = sectionNumber;
		this.courseLocation = courseLocation;
		this.courseStartTime = courseStartTime;
		this.courseEndTime = courseEndTime;
		this.courseDay = courseDay;
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}   
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}   
	public int getSectionNumber() {
		return this.sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}   
	public String getCourseLocation() {
		return this.courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}   
	public Date getCourseStartTime() {
		return this.courseStartTime;
	}

	public void setCourseStartTime(Date courseStartTime) {
		this.courseStartTime = courseStartTime;
	}   
	public Date getCourseEndTime() {
		return this.courseEndTime;
	}

	public void setCourseEndTime(Date courseEndTime) {
		this.courseEndTime = courseEndTime;
	}   
	public String getCourseDay() {
		return this.courseDay;
	}

	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}
   
	public List<UserCourseDetail> getUserCourseDetail() {
		return userCourseDetail;
	}

	public void setUserCourseDetail(List<UserCourseDetail> userCourseDetail) {
		this.userCourseDetail = userCourseDetail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [courseId=");
		builder.append(courseId);
		builder.append(", courseName=");
		builder.append(courseName);
		builder.append(", sectionNumber=");
		builder.append(sectionNumber);
		builder.append(", courseLocation=");
		builder.append(courseLocation);
		builder.append(", courseStartTime=");
		builder.append(courseStartTime);
		builder.append(", courseEndTime=");
		builder.append(courseEndTime);
		builder.append(", courseDay=");
		builder.append(courseDay);
		builder.append(", userCourseDetail=");
		builder.append(userCourseDetail);
		builder.append("]");
		return builder.toString();
	}
	
}
