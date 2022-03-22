package com.learnearsacad.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnearsacad.admin.bean.StudentBean;
import com.learnearsacad.admin.bean.TeacherBean;
import com.learnearsacad.admin.dao.Studentdao;
import com.learnearsacad.admin.dao.Teacherdao;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String function=request.getParameter("functionbutton");
		if(function!=null && function.equals("viewallteachers"))
		{
			TeacherBean bean=new TeacherBean();
			RequestDispatcher rd=null;
			Teacherdao obj=new Teacherdao();
				
			if(obj.getallTeachers()!=null){
				rd=request.getRequestDispatcher("Teacher.jsp");
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				List<TeacherBean> listofallteachers=new ArrayList<TeacherBean>();
				listofallteachers=obj.getallTeachers();
				
				for(int i=0;i<listofallteachers.size();i++) {
					System.out.println("inside while "+i);
				bean=listofallteachers.get(i);
				out.println("<centre><span style='color:green'>Teacher ID    |"+bean.getTeacherId()+"|</span></centre>");
				out.println("<centre><span style='color:green'>Teacher Name  |"+bean.getTeacherName()+"|</span></centre>");
				out.println("<br>");
			}
			
			}
			
		}else if(function!=null && function.equals("deleteteacher"))
		 {
			Teacherdao obj=new Teacherdao();
			TeacherBean bean=new TeacherBean();
			RequestDispatcher rd=null;
			bean.setTeacherId(Integer.parseInt(request.getParameter("teacherid")));
					try {
				if(obj.deleteTeacher(bean)!=0) {
					rd=request.getRequestDispatcher("Teacher.jsp");
					PrintWriter out=response.getWriter();
					rd.include(request, response);
					out.println("<centre><span style='color:green'>Teacher Deleted successfuly</span></centre>");
				};
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		else {
	  
		TeacherBean bean=new TeacherBean();
		RequestDispatcher rd=null;
		bean.setTeacherId(Integer.parseInt(request.getParameter("teacherid")));
		bean.setTeacherName(request.getParameter("teachername"));
		Teacherdao obj=new Teacherdao();
		try {
			if(obj.insertTeacher(bean)!=0) {
				rd=request.getRequestDispatcher("Teacher.jsp");
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				out.println("<centre><span style='color:green'>Teacher Record Inserted</span></centre>");
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}

}
