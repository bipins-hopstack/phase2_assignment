package com.learnearsacad.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.learnearsacad.util.DBConnection;
import com.learnearsacad.admin.bean.StudentBean;
public class Studentdao {

	public int insertStudent(StudentBean bean) throws SQLException {
		int recordInserted=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYS as SYSDBA","pass");
		    String query="insert into student values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bean.getStudentid());
			pstmt.setString(2,bean.getStudentName());
			pstmt.setString(3, bean.getStudentGender());
			pstmt.setInt(4,bean.getStudentClass());
			recordInserted = pstmt.executeUpdate();
		    
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return recordInserted ;
	}
			
}
