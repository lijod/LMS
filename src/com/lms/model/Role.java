package com.lms.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */

@Entity
@Table(name="role")
public class Role implements Serializable {
	   
	@Id
	@Column(name="role_name")
	private String roleName;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	}   
	
	public String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
   
}
