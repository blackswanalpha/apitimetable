package com.example.timetable.app.mode;

public class ModeBean {
	private int  modeId;
	private String modeName , modeDesc;
	public ModeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeBean(int modeId) {
		this.modeId = modeId;
	}

	public ModeBean(int modeId, String modeName, String modeDesc) {
		super();
		this.modeId = modeId;
		this.modeName = modeName;
		this.modeDesc = modeDesc;
	}
	public int getModeId() {
		return modeId;
	}
	public void setModeId(int modeId) {
		this.modeId = modeId;
	}
	public String getModeName() {
		return modeName;
	}
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
	public String getModeDesc() {
		return modeDesc;
	}
	public void setModeDesc(String modeDesc) {
		this.modeDesc = modeDesc;
	}
	
	

}
