package com.lms.model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Time;

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
	private Time courseStartTime;
	@Column(name="course_end_time")
	private Time courseEndTime;
	@Column(name="course_day")
	private String courseDay;
	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}   
	
	public Course(String courseName, int sectionNumber, String courseLocation,
			Time courseStartTime, Time courseEndTime, String courseDay) {
		super();
		this.courseName = courseName;
		this.sectionNumber = sectionNumber;
		this.courseLocation = courseLocation;
		this.courseStartTime = courseStartTime;
		this.courseEndTime = courseEndTime;
		this.courseDay = courseDay;
	}

	public Course(int courseId, String courseName, int sectionNumber,
			String courseLocation, Time courseStartTime, Time courseEndTime,
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
	public Time getCourseStartTime() {
		return this.courseStartTime;
	}

	public void setCourseStartTime(Time courseStartTime) {
		this.courseStartTime = courseStartTime;
	}   
	public Time getCourseEndTime() {
		return this.courseEndTime;
	}

	public void setCourseEndTime(Time courseEndTime) {
		this.courseEndTime = courseEndTime;
	}   
	public String getCourseDay() {
		return this.courseDay;
	}

	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}
   
}
