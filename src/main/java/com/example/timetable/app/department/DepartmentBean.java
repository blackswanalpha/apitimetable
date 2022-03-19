package com.example.timetable.app.department;

public class DepartmentBean {
	
	
	private int departmentId,departmentMobile,departmentFacultyId;
	private String departmentName,departmentDesc,departmentEmail;
	public DepartmentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentBean(int departmentId) {
		this.departmentId = departmentId;
	}

	public DepartmentBean(int departmentId, int departmentMobile, int departmentFacultyId, String departmentName,
						  String departmentDesc, String departmentEmail) {
		super();
		this.departmentId = departmentId;
		this.departmentMobile = departmentMobile;
		this.departmentFacultyId = departmentFacultyId;
		this.departmentName = departmentName;
		this.departmentDesc = departmentDesc;
		this.departmentEmail = departmentEmail;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getDepartmentMobile() {
		return departmentMobile;
	}
	public void setDepartmentMobile(int departmentMobile) {
		this.departmentMobile = departmentMobile;
	}
	public int getDepartmentFacultyId() {
		return departmentFacultyId;
	}
	public void setDepartmentFacultyId(int departmentFacultyId) {
		this.departmentFacultyId = departmentFacultyId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	public String getDepartmentEmail() {
		return departmentEmail;
	}
	public void setDepartmentEmail(String departmentEmail) {
		this.departmentEmail = departmentEmail;
	}
	
	
}
