package com.example.timetable.app.course;

public class CourseBean {
private int courseId, courseDepartmentId;
private String courseName;
	private String courseDesc;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	private String departmentName;
public CourseBean() {
	super();
	// TODO Auto-generated constructor stub
}

	public CourseBean(int courseId) {
		this.courseId = courseId;
	}

	public CourseBean(int courseId, int courseDepartmentId, String courseName, String courseDesc, String departmentName) {
	super();
	this.courseId = courseId;
	this.courseDepartmentId = courseDepartmentId;
	this.courseName = courseName;
	this.courseDesc = courseDesc;
		this.departmentName = departmentName;
	}
public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}
public int getCourseDepartmentId() {
	return courseDepartmentId;
}
public void setCourseDepartmentId(int courseDepartmentId) {
	this.courseDepartmentId = courseDepartmentId;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getCourseDesc() {
	return courseDesc;
}
public void setCourseDesc(String courseDesc) {
	this.courseDesc = courseDesc;
}


}
