package com.example.timetable.app.specialization;

public class SpecializationBean {
private int specializationId;
private String specializationName, specializationDesc;
public SpecializationBean() {
	super();
	// TODO Auto-generated constructor stub
}

	public SpecializationBean(int specializationId) {
		this.specializationId = specializationId;
	}

	public SpecializationBean(int specializationId, String specializationName, String specializationDesc) {
	super();
	this.specializationId = specializationId;
	this.specializationName = specializationName;
	this.specializationDesc = specializationDesc;
}
public int getSpecializationId() {
	return specializationId;
}
public void setSpecializationId(int specializationId) {
	this.specializationId = specializationId;
}
public String getSpecializationName() {
	return specializationName;
}
public void setSpecializationName(String specializationName) {
	this.specializationName = specializationName;
}
public String getSpecializationDesc() {
	return specializationDesc;
}
public void setSpecializationDesc(String specializationDesc) {
	this.specializationDesc = specializationDesc;
}

}
