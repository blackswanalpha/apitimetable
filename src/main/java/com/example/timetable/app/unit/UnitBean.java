package com.example.timetable.app.unit;

public class UnitBean {
	private int unitId,unitCourseId,unitSpecializationId;
	
	private String unitCode,unitName,unitDesc,unitRequireLab;

	public UnitBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnitBean(int unitId) {
		this.unitId = unitId;
	}

	public UnitBean(int unitId, int unitCourseId, int unitSpecializationId, String unitCode, String unitName,
					String unitDesc) {
		super();
		this.unitId = unitId;
		this.unitCourseId = unitCourseId;
		this.unitSpecializationId = unitSpecializationId;
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.unitDesc = unitDesc;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getUnitCourseId() {
		return unitCourseId;
	}

	public void setUnitCourseId(int unitCourseId) {
		this.unitCourseId = unitCourseId;
	}

	public int getUnitSpecializationId() {
		return unitSpecializationId;
	}

	public void setUnitSpecializationId(int unitSpecializationId) {
		this.unitSpecializationId = unitSpecializationId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitDesc() {
		return unitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}

	public String getUnitRequireLab() {
		return unitRequireLab;
	}

	public void setUnitRequireLab(String unitRequireLab) {
		this.unitRequireLab = unitRequireLab;
	}


	
	
	
	
	
	
}
