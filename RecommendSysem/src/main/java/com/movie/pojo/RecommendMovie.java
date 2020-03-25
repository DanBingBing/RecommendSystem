package com.movie.pojo;

public class RecommendMovie {
    private Integer recId;

    private Integer userId;

    private Integer movId;

    private Integer recGrade;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public Integer getRecGrade() {
        return recGrade;
    }

    public void setRecGrade(Integer recGrade) {
        this.recGrade = recGrade;
    }

	@Override
	public String toString() {
		return "RecommendMovie [recId=" + recId + ", userId=" + userId + ", movId=" + movId + ", recGrade=" + recGrade
				+ "]";
	}
    
}