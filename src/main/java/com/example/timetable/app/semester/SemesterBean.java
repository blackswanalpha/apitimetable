package com.example.timetable.app.semester;

public class SemesterBean {
	private int semesterId , semesterYear;
	private String semesterName;
	public SemesterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SemesterBean(int semesterId) {
		this.semesterId = semesterId;
	}

	public SemesterBean(int semesterId, int semesterYear, String semesterName) {
		super();
		this.semesterId = semesterId;
		this.semesterYear = semesterYear;
		this.semesterName = semesterName;
	}
	public int getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}
	public int getSemesterYear() {
		return semesterYear;
	}
	public void setSemesterYear(int semesterYear) {
		this.semesterYear = semesterYear;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	

}
