package com.learnearsacad.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnearsacad.admin.bean.StudentBean;
import com.learnearsacad.admin.dao.Studentdao;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean bean=new StudentBean();
		bean.setStudentid(Integer.parseInt(request.getParameter("studentid")));
		bean.setStudentGender(request.getParameter("studentGender"));
		bean.setStudentName(request.getParameter("studentName"));
		bean.setStudentClass(Integer.parseInt(request.getParameter("studentClass")));
		RequestDispatcher rd=null;
		Studentdao obj=new Studentdao();
		try {
			if(obj.insertStudent(bean)!=0) {
				rd=request.getRequestDispatcher("Student.jsp");
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				out.println("<centre><span style='color:green'>Student Record Inserted</span></centre>");
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
