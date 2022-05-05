package com.example.timetable.app.lecturerspecialization;

public class LecturerspecializationBean {
private int lecturerspecializationId, lecturerspecializationLecturerId, lecturerspecializationSpecializationId;

public LecturerspecializationBean() {
	super();
	// TODO Auto-generated constructor stub
}

	public LecturerspecializationBean(int lecturerspecializationId) {
		this.lecturerspecializationId = lecturerspecializationId;
	}

	public LecturerspecializationBean(int lecturerspecializationId, int lecturerspecializationLecturerId,
									  int lecturerspecializationSpecializationId) {
	super();
	this.lecturerspecializationId = lecturerspecializationId;
	this.lecturerspecializationLecturerId = lecturerspecializationLecturerId;
	this.lecturerspecializationSpecializationId = lecturerspecializationSpecializationId;
}

public int getLecturerspecializationId() {
	return lecturerspecializationId;
}

public void setLecturerspecializationId(int lecturerspecializationId) {
	this.lecturerspecializationId = lecturerspecializationId;
}

public int getLecturerspecializationLecturerId() {
	return lecturerspecializationLecturerId;
}

public void setLecturerspecializationLecturerId(int lecturerspecializationLecturerId) {
	this.lecturerspecializationLecturerId = lecturerspecializationLecturerId;
}

public int getLecturerspecializationSpecializationId() {
	return lecturerspecializationSpecializationId;
}

public void setLecturerspecializationSpecializationId(int lecturerspecializationSpecializationId) {
	this.lecturerspecializationSpecializationId = lecturerspecializationSpecializationId;
}


}
