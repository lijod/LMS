package com.lms.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Entity implementation class for Entity: User
 *
 */

@Entity
@Cacheable(false)
@Table(name="user")
public class User implements Serializable {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Lob
	@Column(name="user_image")
	private byte[] userImage;
	
	//@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName = "user_id")
	private List<UserCourseDetail> userCourseDetail;
	
	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Post> posts;
	
	@JsonIgnore
	@ManyToMany(mappedBy="usersWhoHaveLikedPosts", fetch=FetchType.EAGER)
	private List<Post> likedPosts ;
	
	//bi-directional many-to-many association to Tag
	@JsonIgnore
	@ManyToMany(mappedBy="favUsers", fetch=FetchType.EAGER)
	private List<Thread> favThreads;	
		
	//bi-directional many-to-one association to Post
	@JsonIgnore
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Thread> threads;
	

	public List<Post> getLikedPosts() {
		return likedPosts;
	}

	public void setLikedPosts(List<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}



	private static final long serialVersionUID = 1L;
	   
	public User() {
		super();
	}
	
	public User(String userName, String password, String firstName,
			String lastName, String email, Date dateOfBirth, byte[] userImage) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.userImage = userImage;
	}
	public User(int userId, String userName, String password, String firstName,
			String lastName, String email, Date dateOfBirth, byte[] userImage) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.userImage = userImage;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}   
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
   
	public List<UserCourseDetail> getUserCourseDetail() {
		return userCourseDetail;
	}

	public void setUserCourseDetail(List<UserCourseDetail> userCourseDetail) {
		this.userCourseDetail = userCourseDetail;
	}
	
	public byte[] getUserImage() {
		return userImage;
	}
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
	
	
	
	public List<Thread> getFavThreads() {
		return favThreads;
	}

	public void setFavThreads(List<Thread> favThreads) {
		this.favThreads = favThreads;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", userImage="
				+ Arrays.toString(userImage) + ", userCourseDetail="
				+ userCourseDetail.size() + ", posts=" + posts.size() + ", thread=" + threads.size()
				+ "]";
	}

	
}
