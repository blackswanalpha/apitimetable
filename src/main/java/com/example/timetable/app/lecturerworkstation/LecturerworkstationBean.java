package com.example.timetable.app.lecturerworkstation;

public class LecturerworkstationBean {
	private int lecturerworkstationId, lecturerworkstationLecturerId,lecturerworkstationCampusId;

	public LecturerworkstationBean(int lecturerworkstationId, int lecturerworkstationLecturerId,
			int lecturerworkstationCampusId) {
		super();
		this.lecturerworkstationId = lecturerworkstationId;
		this.lecturerworkstationLecturerId = lecturerworkstationLecturerId;
		this.lecturerworkstationCampusId = lecturerworkstationCampusId;
	}

	public LecturerworkstationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LecturerworkstationBean(int lecturerworkstationId) {
		this.lecturerworkstationId = lecturerworkstationId;
	}

	public int getLecturerworkstationId() {
		return lecturerworkstationId;
	}

	public void setLecturerworkstationId(int lecturerworkstationId) {
		this.lecturerworkstationId = lecturerworkstationId;
	}

	public int getLecturerworkstationLecturerId() {
		return lecturerworkstationLecturerId;
	}

	public void setLecturerworkstationLecturerId(int lecturerworkstationLecturerId) {
		this.lecturerworkstationLecturerId = lecturerworkstationLecturerId;
	}

	public int getLecturerworkstationCampusId() {
		return lecturerworkstationCampusId;
	}

	public void setLecturerworkstationCampusId(int lecturerworkstationCampusId) {
		this.lecturerworkstationCampusId = lecturerworkstationCampusId;
	}

}
