package com.learnearsacad.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnearsacad.admin.bean.SubjectBean;
import com.learnearsacad.util.DBConnection;

public class Subjectdao {

	public int insertSubject(SubjectBean bean) throws SQLException {
		int recordInserted=0;
		try {
		  Connection con=DBConnection.getDBConnection();
				  String query="insert into Subject values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bean.getSubjectId());
			pstmt.setString(2,bean.getSubjectName());
			recordInserted = pstmt.executeUpdate();
		    
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return recordInserted ;
	}

	
public List<SubjectBean> getallSubjects() {
		
	
	List<SubjectBean> listofsubjects=new ArrayList<SubjectBean>();
		try {
			Connection con= DBConnection.getDBConnection();
			Statement stmt=con.createStatement();
			String query="select * from subject";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				SubjectBean bean=new SubjectBean();
				bean.setSubjectId(rs.getString(1));
				bean.setSubjectName(rs.getString(2));
				listofsubjects.add(bean);
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return listofsubjects;
	}

public int deleteSubject(SubjectBean bean) throws SQLException {
	int recordDeleted=0;
	try {
	  Connection con=DBConnection.getDBConnection();
	    String query="delete from subjects where subid=(?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, bean.getSubjectId());
		recordDeleted = pstmt.executeUpdate();
	    
	}
	catch(Exception e) {
		System.out.println(e.toString());
	}
	return recordDeleted;
}


}
