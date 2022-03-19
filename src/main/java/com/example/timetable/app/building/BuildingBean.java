package com.example.timetable.app.building;

public class BuildingBean {
	private int buildingId;



	private int buildingCampusId;
	private String buildingName, buildingDesc;
	public BuildingBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuildingBean(int buildingId) {
		this.buildingId = buildingId;
	}

	public BuildingBean(int buildingId, String buildingName, String buildingDesc) {
		super();
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.buildingDesc = buildingDesc;
	}

	public int getBuildingCampusId() {
		return buildingCampusId;
	}

	public void setBuildingCampusId(int buildingCampusId) {
		this.buildingCampusId = buildingCampusId;
	}
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingDesc() {
		return buildingDesc;
	}
	public void setBuildingDesc(String buildingDesc) {
		this.buildingDesc = buildingDesc;
	}
	

}
