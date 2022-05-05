package com.example.timetable.app.login;

import com.example.timetable.app.exceptions.UserValidation;

import javax.validation.constraints.*;


public class LoginBean {

private int loginId, loginRankId;

	@NotNull(message = "username shouldn't be null")
	@NotBlank(message = "user must noy be blank")
	@UserValidation
private String loginName;
//	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
//	@Min(18)
//	@Max(60)
	private String loginPassword;

	public String getRankStatus() {
		return rankStatus;
	}

	public void setRankStatus(String rankStatus) {
		this.rankStatus = rankStatus;
	}

	private String rankStatus;



public LoginBean() {
	super();
	// TODO Auto-generated constructor stub
}
public LoginBean(int loginId, int loginRankId, String loginName, String loginPassword, String rankStatus) {
	super();
	this.loginId = loginId;
	this.loginRankId = loginRankId;
	this.loginName = loginName;
	this.loginPassword = loginPassword;
	this.rankStatus = rankStatus;
}
public int getLoginId() {
	return loginId;
}
public void setLoginId(int loginId) {
	this.loginId = loginId;
}
public int getLoginRankId() {
	return loginRankId;
}
public void setLoginRankId(int loginRankId) {
	this.loginRankId = loginRankId;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getLoginPassword() {
	return loginPassword;
}
public void setLoginPassword(String loginPassword) {
	this.loginPassword = loginPassword;
}



}
