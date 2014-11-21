package com.lms.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserCourseDetail
 *
 */
@Entity
@Table(name="user_course_detail")

@IdClass(UserCourseDetailPK.class)
public class UserCourseDetail implements Serializable {

	@Id
	@Column(name="course_id")
	private int courseId;   
	@Id
	@Column(name="user_id")
	private int userid;   
	@Id
	@Column(name="role")
	private String roleName;
	private static final long serialVersionUID = 1L;

	public UserCourseDetail() {
		super();
	}   
	
	public UserCourseDetail(int courseId, int userid, String roleName) {
		super();
		this.courseId = courseId;
		this.userid = userid;
		this.roleName = roleName;
	}
	
	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}   
	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}   
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
   
}
