package com.example.timetable.app.faculty;

public class FacultyBean {
	private int facultyId,facultyMobile, facultyInstitutionId;
	private String facultyName;
	private String facultyEmail;
	private String facultyDesc;

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	private String institutionName;
	public FacultyBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacultyBean(int facultyId) {
		this.facultyId = facultyId;
	}

	public FacultyBean(int facultyId, int facultyMobile, int facultyInstitutionId, String facultyName,
					   String facultyEmail, String facultyInstitutionName, String institutionName) {
		super();
		this.facultyId = facultyId;
		this.facultyMobile = facultyMobile;
		this.facultyInstitutionId = facultyInstitutionId;
		this.facultyName = facultyName;
		this.facultyEmail = facultyEmail;
		this.institutionName = institutionName;

	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public int getFacultyMobile() {
		return facultyMobile;
	}
	public void setFacultyMobile(int facultyMobile) {
		this.facultyMobile = facultyMobile;
	}
	public int getFacultyInstitutionId() {
		return facultyInstitutionId;
	}
	public void setFacultyInstitutionId(int facultyInstitutionId) {
		this.facultyInstitutionId = facultyInstitutionId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	public String getFacultyDesc() {
		return facultyDesc;
	}
	public void setFacultyDesc(String facultyDesc) {
		this.facultyDesc = facultyDesc;
	} 

}
