package com.learnearsacad.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnearsacad.admin.bean.ClassBean;
import com.learnearsacad.admin.bean.SubjectBean;
import com.learnearsacad.util.DBConnection;

public class Classdao {

	public int insertClass(ClassBean bean) throws SQLException {
		int recordInserted=0;
		try {
		  Connection con=DBConnection.getDBConnection();
				  String query="insert into Class_table values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bean.getCalssId());
			pstmt.setString(2,bean.getTime());
			pstmt.setInt(3,bean.getTeacherId());
			pstmt.setString(4,bean.getSubId());
			
			recordInserted = pstmt.executeUpdate();
		    
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return recordInserted ;
	}
	

public List<ClassBean> getclassinfo(int classid) {
		
	
	List<ClassBean> classinfo=new ArrayList<ClassBean>();
		try {
			Connection con= DBConnection.getDBConnection();
			Statement stmt=con.createStatement();
			String query="select distinct class_table.classid,class_table.time,class_table.teacherid,class_table.subid,student.name as studentname from student inner join class_table on class_table.classid=student.classid where class_table.classid="+classid;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				ClassBean bean=new ClassBean();
				bean.setCalssId(rs.getInt(1));
				bean.setTime(rs.getString(2));
				bean.setTeacherId(rs.getInt(3));
				bean.setSubId(rs.getString(4));
				bean.setStudent(rs.getString(5));
				classinfo.add(bean);
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return classinfo;
	}

	//select student.regno,student.name from student inner join class_table on student.classid=class_table.classid;
}
