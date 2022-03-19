package com.example.timetable.app.login;

public class LoginBean {
private int loginId, loginRankId;
private String loginName, loginPassword;
public LoginBean() {
	super();
	// TODO Auto-generated constructor stub
}
public LoginBean(int loginId, int loginRankId, String loginName, String loginPassword) {
	super();
	this.loginId = loginId;
	this.loginRankId = loginRankId;
	this.loginName = loginName;
	this.loginPassword = loginPassword;
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
