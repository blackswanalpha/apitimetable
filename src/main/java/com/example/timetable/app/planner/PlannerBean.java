package com.example.timetable.app.planner;

public class PlannerBean {
private int plannerId,plannerSemesterId, plannerUnitId;

	public PlannerBean(int plannerId) {
		this.plannerId = plannerId;
	}

	public PlannerBean(int plannerId, int plannerSemesterId, int plannerUnitId) {
	super();
	this.plannerId = plannerId;
	this.plannerSemesterId = plannerSemesterId;
	this.plannerUnitId = plannerUnitId;
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
