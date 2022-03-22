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

import com.learnearsacad.admin.bean.ClassBean;
import com.learnearsacad.admin.bean.SubjectBean;
import com.learnearsacad.admin.dao.Classdao;
import com.learnearsacad.admin.dao.Subjectdao;

/**
 * Servlet implementation class ClassController
 */
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String function=request.getParameter("functionbutton");
		if(function!=null && function.equals("viewallclass"))
		{
			ClassBean bean=new ClassBean();
			RequestDispatcher rd=null;
			Classdao obj=new Classdao();
				
			if(obj.getclassinfo(Integer.parseInt(request.getParameter("classid")))!=null){
				rd=request.getRequestDispatcher("ClassStd.jsp");
				
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				List<ClassBean> listofclassinfo=new ArrayList<ClassBean>();
				listofclassinfo=obj.getclassinfo(Integer.parseInt(request.getParameter("classid")));
				
				for(int i=0;i<listofclassinfo.size();i++) {
				bean=listofclassinfo.get(i);
				out.println("<centre><span style='color:green'>Class ID    |"+bean.getCalssId()+"|</span></centre>");
				out.println("<centre><span style='color:green'>Subject ID  |"+bean.getSubId()+"|</span></centre>");
				out.println("<centre><span style='color:green'>Teacher ID  |"+bean.getTeacherId()+"|</span></centre>");
				out.println("<centre><span style='color:green'>Class time  |"+bean.getTime()+"|</span></centre>");
				out.println("<br>");
			}
			
			}
			
		}
		else if(function!=null && function.equals("insert")) {
	  
		ClassBean bean=new ClassBean();
		RequestDispatcher rd=null;
		bean.setCalssId(Integer.parseInt(request.getParameter("classid")));
		bean.setSubId(request.getParameter("subjectid"));
		bean.setTeacherId(Integer.parseInt(request.getParameter("teacherid")));
		bean.setTime(request.getParameter("classtime"));
		Classdao obj=new Classdao();
		try {
			if(obj.insertClass(bean)!=0) {
				rd=request.getRequestDispatcher("ClassStd.jsp");
				PrintWriter out=response.getWriter();
				rd.include(request, response);
				out.println("<centre><span style='color:green'>Class Record Inserted</span></centre>");
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}	
	}

