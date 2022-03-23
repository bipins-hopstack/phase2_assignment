package com.learnearsacad.admin.bean;

public class StudentBean {
	
	 private int studentid;
	 private String studentName;
	 private String studentGender;
	 private int studentClass;
	
	 public StudentBean() {}
	 @Override
		public String toString() {
			return "StudentBean [studentid=" + studentid + ", studentName=" + studentName + ", studentGender="
					+ studentGender + ", studentClass=" + studentClass + "]";
		}
 public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	

}
