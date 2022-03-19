package com.example.timetable.app.institution;

public class InstitutionBean {
private int institutionId,institutionMobile;
private String institutionName, institutionDesc,institutionEmail,institutionLogo;





public InstitutionBean() {
	super();
	// TODO Auto-generated constructor stub
}





public InstitutionBean(int institutionId, int institutionMobile, String institutionName, String institutionDesc,
		String institutionEmail, String institutionLogo) {
	super();
	this.institutionId = institutionId;
	this.institutionMobile = institutionMobile;
	this.institutionName = institutionName;
	this.institutionDesc = institutionDesc;
	this.institutionEmail = institutionEmail;
	this.institutionLogo = institutionLogo;
}





public int getInstitutionId() {
	return institutionId;
}





public void setInstitutionId(int institutionId) {
	this.institutionId = institutionId;
}





public int getInstitutionMobile() {
	return institutionMobile;
}





public void setInstitutionMobile(int institutionMobile) {
	this.institutionMobile = institutionMobile;
}





public String getInstitutionName() {
	return institutionName;
}





public void setInstitutionName(String institutionName) {
	this.institutionName = institutionName;
}





public String getInstitutionDesc() {
	return institutionDesc;
}





public void setInstitutionDesc(String institutionDesc) {
	this.institutionDesc = institutionDesc;
}





public String getInstitutionEmail() {
	return institutionEmail;
}





public void setInstitutionEmail(String institutionEmail) {
	this.institutionEmail = institutionEmail;
}





public String getInstitutionLogo() {
	return institutionLogo;
}





public void setInstitutionLogo(String institutionLogo) {
	this.institutionLogo = institutionLogo;
}



}
