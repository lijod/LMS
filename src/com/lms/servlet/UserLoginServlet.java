package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.UserDao;
import com.lms.model.User;
import com.lms.model.UserCourseDetail;

/**
 * Servlet implementation class UserLoginServlet
 */
//@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		  out.println("<HTML>");
		  out.println("<HEAD>");
		  out.println("<TITLE>Servlet Testing</TITLE>");
		  out.println("</HEAD>");
		  out.println("<BODY>");
		  out.println("Welcome to the Servlet Testing Center");
		  out.println("</BODY>");
		  out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Boolean isUserFound=false;
		Boolean hasUserSelectedCorrectRole=false; 
		
		String userName = request.getParameter("user-name").toLowerCase();
		String userPassword = request.getParameter("password").toLowerCase();
		String userType = request.getParameter("user-type").toLowerCase();
		System.out.println(userName);
		System.out.println(userPassword);
		System.out.println(userType);
		UserDao userDaoObj=new UserDao();
		List<User> allUsersList=userDaoObj.findAllUsers();
		RequestDispatcher rd = null;
		for(User user :  allUsersList){
			if((userName.equals(user.getUserName().toLowerCase()) && (userPassword.equals(user.getPassword().toLowerCase())))){
				isUserFound=true;
				for(UserCourseDetail ucd:user.getUserCourseDetail()){
					if(userType.equals(ucd.getRoleName().toLowerCase())){
					System.out.println("course found");					
					hasUserSelectedCorrectRole=true;
					request.setAttribute("user", user);
					rd = request.getRequestDispatcher("/jsp/user/user-profile.jsp");
					rd.forward(request, response);
					
			}
					else
						break;
					
				}
			}
		}
		
		if (isUserFound == true && hasUserSelectedCorrectRole == false) {
			request.setAttribute("errorMessage", "This role does not exist for the current user.");
			rd = request.getRequestDispatcher("/jsp/user/user-login.jsp");
			rd.forward(request, response);		
		}
		else if (isUserFound == false && hasUserSelectedCorrectRole == false) {
				request.setAttribute("errorMessage", "User does not exist,Please try again.");
				rd = request.getRequestDispatcher("/jsp/user/user-login.jsp");
				rd.forward(request, response);		
			}
		
		
		
		
					
		
		
		
	}

}