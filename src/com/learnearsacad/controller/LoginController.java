package com.learnearsacad.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		RequestDispatcher rd=null;
		
		if(username.equalsIgnoreCase("tom") && password.equalsIgnoreCase("pass")) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			rd=request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("login.html");
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.println("<centre><span style='color:red' align='center'>invalid credentials!!</span></centre>");
		}
	}

	public void logout() 
	{
		
	}
}
