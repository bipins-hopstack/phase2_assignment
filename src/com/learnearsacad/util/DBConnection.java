package com.learnearsacad.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
    public static Connection con=null;
	public static Connection getDBConnection() {
	if(con==null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYS as SYSDBA","pass");
			    System.out.println("connection sucessfull");
			    return con;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	return con;
			
	}
	
//	public static void main(String args[]) throws SQLException {
//	
//		Statement stmt;
//		try {
//			stmt = getDBConnection().createStatement();
//		
//		String query="delete from student where regno='1007'";
//		int result=stmt.executeUpdate(query);
//		
//		System.out.println("no of records impacted "+result);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		con.close();}
	}
		
	

