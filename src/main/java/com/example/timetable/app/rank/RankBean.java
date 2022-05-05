package com.example.timetable.app.rank;

public class RankBean {
	private int rankId;

	public RankBean() {
		super();
	}

	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	public String getRankStatus() {
		return rankStatus;
	}

	public void setRankStatus(String rankStatus) {
		this.rankStatus = rankStatus;
	}

	private String rankStatus;


	public RankBean(int rankId, String rankStatus) {
		super();
		this.rankId = rankId;
		// TODO Auto-generated constructor stub
		this.rankStatus = rankStatus;
	}



}
