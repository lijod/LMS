package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.UserDao;

/**
 * Servlet implementation class ViewProfile
 */
@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		int displayUserId = Integer.parseInt(request.getParameter("displayUserId"));
		System.out.println("Displaying userId:"+ displayUserId +" to userId:" + userId);
		request.setAttribute("user", new UserDao().findUserByUserId(userId));
		request.setAttribute("displayUser", new UserDao().findUserByUserId(displayUserId));
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/user/user-profile.jsp");
		rd.forward(request, response);
	}
	
}
