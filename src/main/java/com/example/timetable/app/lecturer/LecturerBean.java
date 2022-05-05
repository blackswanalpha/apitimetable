package com.example.timetable.app.lecturer;

public class LecturerBean {
	
	private int lecturerId,lecturerContact,lecturerLoginId, lecturerStaffNo,lecturerTypeId;
	private String lecturerName,lecturerEmail,lecturerImage,lecturerGender,lecturerLocation,lecturerActive;
	public LecturerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LecturerBean(int lecturerId) {
		this.lecturerId = lecturerId;
	}

	public LecturerBean(int lecturerId, int lecturerContact, int lecturerLoginId, int lecturerStaffNo,
						int lecturerTypeId, String lecturerName, String lecturerEmail, String lecturerImage, String lecturerGender,
						String lecturerLocation, String lecturerActive) {
		super();
		this.lecturerId = lecturerId;
		this.lecturerContact = lecturerContact;
		this.lecturerLoginId = lecturerLoginId;
		this.lecturerStaffNo = lecturerStaffNo;
		this.lecturerTypeId = lecturerTypeId;
		this.lecturerName = lecturerName;
		this.lecturerEmail = lecturerEmail;
		this.lecturerImage = lecturerImage;
		this.lecturerGender = lecturerGender;
		this.lecturerLocation = lecturerLocation;
		this.lecturerActive = lecturerActive;
	}
	public int getLecturerId() {
		return lecturerId;
	}
	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}
	public int getLecturerContact() {
		return lecturerContact;
	}
	public void setLecturerContact(int lecturerContact) {
		this.lecturerContact = lecturerContact;
	}
	public int getLecturerLoginId() {
		return lecturerLoginId;
	}
	public void setLecturerLoginId(int lecturerLoginId) {
		this.lecturerLoginId = lecturerLoginId;
	}
	public int getLecturerStaffNo() {
		return lecturerStaffNo;
	}
	public void setLecturerStaffNo(int lecturerStaffNo) {
		this.lecturerStaffNo = lecturerStaffNo;
	}
	public int getLecturerTypeId() {
		return lecturerTypeId;
	}
	public void setLecturerTypeId(int lecturerTypeId) {
		this.lecturerTypeId = lecturerTypeId;
	}
	public String getLecturerName() {
		return lecturerName;
	}
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	public String getLecturerEmail() {
		return lecturerEmail;
	}
	public void setLecturerEmail(String lecturerEmail) {
		this.lecturerEmail = lecturerEmail;
	}
	public String getLecturerImage() {
		return lecturerImage;
	}
	public void setLecturerImage(String lecturerImage) {
		this.lecturerImage = lecturerImage;
	}
	public String getLecturerGender() {
		return lecturerGender;
	}
	public void setLecturerGender(String lecturerGender) {
		this.lecturerGender = lecturerGender;
	}
	public String getLecturerLocation() {
		return lecturerLocation;
	}
	public void setLecturerLocation(String lecturerLocation) {
		this.lecturerLocation = lecturerLocation;
	}
	public String getLecturerActive() {
		return lecturerActive;
	}
	public void setLecturerActive(String lecturerActive) {
		this.lecturerActive = lecturerActive;
	}

	
	

}
