package com.example.timetable.app.day;

public class DayBean {
	private int dayId;
	private String dayName,dayDesc;
	public DayBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DayBean(int dayId, String dayName, String dayDesc) {
		super();
		this.dayId = dayId;
		this.dayName = dayName;
		this.dayDesc = dayDesc;
	}
	public int getDayId() {
		return dayId;
	}
	public void setDayId(int dayId) {
		this.dayId = dayId;
	}
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	public String getDayDesc() {
		return dayDesc;
	}
	public void setDayDesc(String dayDesc) {
		this.dayDesc = dayDesc;
	}
	

}
