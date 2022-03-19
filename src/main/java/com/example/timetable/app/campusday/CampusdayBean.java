package com.example.timetable.app.campusday;

public class CampusdayBean {
private int campusdayId, campusdayCampusId,campusdayDayId,campusdayModeId,campusdayTimeslotId;

public CampusdayBean() {
	super();
	// TODO Auto-generated constructor stub
}

public CampusdayBean(int campusdayId, int campusdayCampusId, int campusdayDayId, int campusdayModeId,
		int campusdayTimeslotId) {
	super();
	this.campusdayId = campusdayId;
	this.campusdayCampusId = campusdayCampusId;
	this.campusdayDayId = campusdayDayId;
	this.campusdayModeId = campusdayModeId;
	this.campusdayTimeslotId = campusdayTimeslotId;
}

public int getCampusdayId() {
	return campusdayId;
}

public void setCampusdayId(int campusdayId) {
	this.campusdayId = campusdayId;
}

public int getCampusdayCampusId() {
	return campusdayCampusId;
}

public void setCampusdayCampusId(int campusdayCampusId) {
	this.campusdayCampusId = campusdayCampusId;
}

public int getCampusdayDayId() {
	return campusdayDayId;
}

public void setCampusdayDayId(int campusdayDayId) {
	this.campusdayDayId = campusdayDayId;
}

public int getCampusdayModeId() {
	return campusdayModeId;
}

public void setCampusdayModeId(int campusdayModeId) {
	this.campusdayModeId = campusdayModeId;
}

public int getCampusdayTimeslotId() {
	return campusdayTimeslotId;
}

public void setCampusdayTimeslotId(int campusdayTimeslotId) {
	this.campusdayTimeslotId = campusdayTimeslotId;
}


}
