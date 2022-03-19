package com.example.timetable.app.lecturertype;

public class LecturertypeBean {
	private int lecturertypeId, lecturertypeMax;
	private String lecturertypeName,lecturertypeDesc;

	public LecturertypeBean(int lecturertypeId) {
		this.lecturertypeId = lecturertypeId;
	}

	public LecturertypeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LecturertypeBean(int lecturertypeId, int lecturertypeMax, String lecturertypeName, String lecturertypeDesc) {
		super();
		this.lecturertypeId = lecturertypeId;
		this.lecturertypeMax = lecturertypeMax;
		this.lecturertypeName = lecturertypeName;
		this.lecturertypeDesc = lecturertypeDesc;
	}
	public int getLecturertypeId() {
		return lecturertypeId;
	}
	public void setLecturertypeId(int lecturertypeId) {
		this.lecturertypeId = lecturertypeId;
	}
	public int getLecturertypeMax() {
		return lecturertypeMax;
	}
	public void setLecturertypeMax(int lecturertypeMax) {
		this.lecturertypeMax = lecturertypeMax;
	}
	public String getLecturertypeName() {
		return lecturertypeName;
	}
	public void setLecturertypeName(String lecturertypeName) {
		this.lecturertypeName = lecturertypeName;
	}
	public String getLecturertypeDesc() {
		return lecturertypeDesc;
	}
	public void setLecturertypeDesc(String lecturertypeDesc) {
		this.lecturertypeDesc = lecturertypeDesc;
	}
	

}
