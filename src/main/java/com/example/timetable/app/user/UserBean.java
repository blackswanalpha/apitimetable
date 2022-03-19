package com.example.timetable.app.user;

public class UserBean {

	private int userId, userDepartmentId, userMobile,userLoginId;



	private String userFullName, userEmail, userimageUrl;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(int userId, int userDepartmentId, int userMobile, int userLoginId, String userFullName,
					String userEmail, String userimageUrl) {
		super();
		this.userId = userId;
		this.userDepartmentId = userDepartmentId;
		this.userMobile = userMobile;
		this.userLoginId = userLoginId;
		this.userFullName = userFullName;
		this.userimageUrl = userimageUrl;
		this.userEmail = userEmail;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserDepartmentId() {
		return userDepartmentId;
	}
	public void setUserDepartmentId(int userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}
	public int getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(int userMobile) {
		this.userMobile = userMobile;
	}
	public int getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserimageUrl() {
		return userimageUrl;
	}

	public void setUserimageUrl(String userimageUrl) {
		this.userimageUrl = userimageUrl;
	}
	
	
	
}
