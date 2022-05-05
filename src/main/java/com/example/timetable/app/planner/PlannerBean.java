package com.example.timetable.app.planner;

public class PlannerBean {
private int plannerId,plannerSemesterId, plannerUnitId;

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	private String semesterName;
	private String unitName;

	public PlannerBean(int plannerId) {
		this.plannerId = plannerId;
	}

	public PlannerBean(int plannerId, int plannerSemesterId, int plannerUnitId, String semesterName, String unitName) {
	super();
	this.plannerId = plannerId;
	this.plannerSemesterId = plannerSemesterId;
	this.plannerUnitId = plannerUnitId;
		this.semesterName = semesterName;
		this.unitName = unitName;
	}

public PlannerBean() {
	super();
	// TODO Auto-generated constructor stub
}

public int getPlannerId() {
	return plannerId;
}

public void setPlannerId(int plannerId) {
	this.plannerId = plannerId;
}

public int getPlannerSemesterId() {
	return plannerSemesterId;
}

public void setPlannerSemesterId(int plannerSemesterId) {
	this.plannerSemesterId = plannerSemesterId;
}

public int getPlannerUnitId() {
	return plannerUnitId;
}

public void setPlannerUnitId(int plannerUnitId) {
	this.plannerUnitId = plannerUnitId;
}



}
