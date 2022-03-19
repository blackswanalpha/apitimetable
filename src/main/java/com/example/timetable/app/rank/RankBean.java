package com.example.timetable.app.rank;

public class RankBean {
	private long rank_id;
	

	private String rank_status;


	public RankBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RankBean(String rANK_STATUS) {
		super();
		rank_status = rANK_STATUS;
	}


	public RankBean(long rank_id, String rANK_STATUS) {
		super();
		this.rank_id = rank_id;
		rank_status = rANK_STATUS;
	}


	public long getrank_id() {
		return rank_id;
	}


	public void setrank_id(long iD) {
		rank_id = iD;
	}


	public String getrank_status() {
		return rank_status;
	}


	public void setrank_status(String rANK_STATUS) {
		rank_status = rANK_STATUS;
	}

		
}
