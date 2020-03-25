package com.movie.pojo;

public class RecommendMovieTemp {
	
	private int uId;
	
	private String mId_rGrade;

	public RecommendMovieTemp() {
		super();
	}

	public RecommendMovieTemp(int uId, String mId_rGrade) {
		super();
		this.uId = uId;
		this.mId_rGrade = mId_rGrade;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getmId_rGrade() {
		return mId_rGrade;
	}

	public void setmId_rGrade(String mId_rGrade) {
		this.mId_rGrade = mId_rGrade;
	}

	@Override
	public String toString() {
		return "RecommendMovieTemp [uId=" + uId + ", mId_rGrade=" + mId_rGrade + "]";
	}
	
}
