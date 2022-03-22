package com.learnearsacad.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnearsacad.admin.bean.StudentBean;
import com.learnearsacad.admin.bean.TeacherBean;
import com.learnearsacad.util.DBConnection;

public class Teacherdao {

	public int insertTeacher(TeacherBean bean) throws SQLException {
		int recordInserted=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYS as SYSDBA","pass");
		    String query="insert into teacher values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bean.getTeacherId());
			pstmt.setString(2,bean.getTeacherName());
			recordInserted = pstmt.executeUpdate();
		    
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return recordInserted ;
	}

	
public List<TeacherBean> getallTeachers() {
		
	
	List<TeacherBean> listofteachers=new ArrayList<TeacherBean>();
		try {
			System.out.println("inside select teacher dAO");
			Connection con= DBConnection.getDBConnection();
			Statement stmt=con.createStatement();
			String query="select * from teacher";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				TeacherBean bean=new TeacherBean();
				bean.setTeacherId(rs.getInt(1));
				bean.setTeacherName(rs.getString(2));
			listofteachers.add(bean);
			}
			
		}catch(Exception e) {
			
		}
		return listofteachers;
	}

public int deleteTeacher(TeacherBean bean) throws SQLException {
	int recordDeleted=0;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYS as SYSDBA","pass");
	    String query="delete from teacher where teacherid=(?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1, bean.getTeacherId());
		recordDeleted = pstmt.executeUpdate();
	    
	}
	catch(Exception e) {
		System.out.println(e.toString());
	}
	return recordDeleted ;
}


}