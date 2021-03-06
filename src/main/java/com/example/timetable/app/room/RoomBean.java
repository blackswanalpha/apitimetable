package com.example.timetable.app.room;

public class RoomBean {
private int roomId,roomDepartmentId,roomBuildingId;
private String roomName;
	private String roomDesc;
	private String roomCapacity;
	private String roomLab;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	private String departmentName;
	private String buildingName;
public RoomBean() {
	super();
	// TODO Auto-generated constructor stub
}

	public RoomBean(int roomId) {
		this.roomId = roomId;
	}

	public RoomBean(int roomId, int roomDepartmentId, int roomBuildingId, String roomDesc, String name, String roomCapacity,
					String roomLab, String departmentName, String buildingName) {
	super();
	this.roomId = roomId;
	this.roomDepartmentId = roomDepartmentId;
	this.roomBuildingId = roomBuildingId;
	this.roomDesc = roomDesc;
	this.roomCapacity = roomCapacity;
	this.roomLab = roomLab;
	this.roomName = name;
		this.departmentName = departmentName;
		this.buildingName = buildingName;
	}
public int getRoomId() {
	return roomId;
}
public void setRoomId(int roomId) {
	this.roomId = roomId;
}
public int getRoomDepartmentId() {
	return roomDepartmentId;
}
public void setRoomDepartmentId(int roomDepartmentId) {
	this.roomDepartmentId = roomDepartmentId;
}
public int getRoomBuildingId() {
	return roomBuildingId;
}
public void setRoomBuildingId(int roomBuildingId) {
	this.roomBuildingId = roomBuildingId;
}
public String getRoomDesc() {
	return roomDesc;
}
public void setRoomDesc(String roomDesc) {
	this.roomDesc = roomDesc;
}
public String getRoomCapacity() {
	return roomCapacity;
}
public void setRoomCapacity(String roomCapacity) {
	this.roomCapacity = roomCapacity;
}
public String getRoomLab() {
	return roomLab;
}
public void setRoomLab(String roomLab) {
	this.roomLab = roomLab;
}
public String getRoomName() {
	return roomName;
}
public void setRoomName(String roomName) {
	this.roomName = roomName;
}

}
