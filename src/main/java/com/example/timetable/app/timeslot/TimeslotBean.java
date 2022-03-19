package com.example.timetable.app.timeslot;

public class TimeslotBean {
private int timeslotId, timeslotCampusId,timeslotModeId;
private String timeslotName,timeslotDesc;
public TimeslotBean() {
	super();
	// TODO Auto-generated constructor stub
}
public TimeslotBean(int timeslotId, int timeslotCampusId, int timeslotModeId, String timeslotName,
		String timeslotDesc) {
	super();
	this.timeslotId = timeslotId;
	this.timeslotCampusId = timeslotCampusId;
	this.timeslotModeId = timeslotModeId;
	this.timeslotName = timeslotName;
	this.timeslotDesc = timeslotDesc;
}
public int getTimeslotId() {
	return timeslotId;
}
public void setTimeslotId(int timeslotId) {
	this.timeslotId = timeslotId;
}
public int getTimeslotCampusId() {
	return timeslotCampusId;
}
public void setTimeslotCampusId(int timeslotCampusId) {
	this.timeslotCampusId = timeslotCampusId;
}
public int getTimeslotModeId() {
	return timeslotModeId;
}
public void setTimeslotModeId(int timeslotModeId) {
	this.timeslotModeId = timeslotModeId;
}
public String getTimeslotName() {
	return timeslotName;
}
public void setTimeslotName(String timeslotName) {
	this.timeslotName = timeslotName;
}
public String getTimeslotDesc() {
	return timeslotDesc;
}
public void setTimeslotDesc(String timeslotDesc) {
	this.timeslotDesc = timeslotDesc;
}


}
