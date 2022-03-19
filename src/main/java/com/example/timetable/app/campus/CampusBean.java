package com.example.timetable.app.campus;

public class CampusBean {
private int campusId;
private String campusName,campusDesc, campusLocation;
public CampusBean() {
	super();
	// TODO Auto-generated constructor stub
}

	public CampusBean(int campusId) {
		this.campusId = campusId;
	}

	public CampusBean(int campusId, String campusName, String campusDesc, String campusLocation) {
	super();
	this.campusId = campusId;
	this.campusName = campusName;
	this.campusDesc = campusDesc;
	this.campusLocation = campusLocation;
}
public int getCampusId() {
	return campusId;
}
public void setCampusId(int campusId) {
	this.campusId = campusId;
}
public String getCampusName() {
	return campusName;
}
public void setCampusName(String campusName) {
	this.campusName = campusName;
}
public String getCampusDesc() {
	return campusDesc;
}
public void setCampusDesc(String campusDesc) {
	this.campusDesc = campusDesc;
}
public String getCampusLocation() {
	return campusLocation;
}
public void setCampusLocation(String campusLocation) {
	this.campusLocation = campusLocation;
}

}
