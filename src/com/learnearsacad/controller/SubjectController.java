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

import com.learnearsacad.admin.bean.SubjectBean;
import com.learnearsacad.admin.bean.TeacherBean;
import com.learnearsacad.admin.dao.Subjectdao;
import com.learnearsacad.admin.dao.Teacherdao;

/**
 * Servlet implementation class SubjectController
 */
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String function=request.getParameter("functionbutton");
		
		
		if(function!=null && function.equals("viewallsubjects"))
		{
			SubjectBean bean=new SubjectBean();
			RequestDispatcher rd=null;
			Subjectdao obj=new Subjectdao();
				
			if(obj.getallSubjects()!=null){
				rd=request.getRequestDispatcher("Subject.jsp");
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				List<SubjectBean> listofallsubjects=new ArrayList<SubjectBean>();
				listofallsubjects=obj.getallSubjects();
				
				for(int i=0;i<listofallsubjects.size();i++) {
					System.out.println("inside while "+i);
				bean=listofallsubjects.get(i);
				out.println("<centre><span style='color:green'>Subject ID    |"+bean.getSubjectId()+"|</span></centre>");
				out.println("<centre><span style='color:green'>Subject Name  |"+bean.getSubjectName()+"|</span></centre>");
				out.println("<br>");
			}
			
			}
			
		}else if(function!=null && function.equals("deletetsubject"))
		 {
			Subjectdao obj=new Subjectdao();
			SubjectBean bean=new SubjectBean();
			RequestDispatcher rd=null;
			bean.setSubjectId(request.getParameter("subjectid"));
					try {System.out.println("inside delete");
				if(obj.deleteSubject(bean)!=0) {
					rd=request.getRequestDispatcher("Subject.jsp");
					PrintWriter out=response.getWriter();
					rd.include(request, response);
					out.println("<centre><span style='color:green'>Subject Deleted successfuly</span></centre>");
				};
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		else if(function!=null && function.equals("insertsubject")) {
	  
		SubjectBean bean=new SubjectBean();
		RequestDispatcher rd=null;
			
		bean.setSubjectId(request.getParameter("subjectid"));
		bean.setSubjectName(request.getParameter("subjectname"));	
		Subjectdao obj=new Subjectdao();
		try {
			if(obj.insertSubject(bean)!=0) {
				rd=request.getRequestDispatcher("Subject.jsp");
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				out.println("<centre><span style='color:green'>Subject Record Inserted</span></centre>");
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}	
}


