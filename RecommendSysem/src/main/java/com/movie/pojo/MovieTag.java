package com.movie.pojo;

public class MovieTag {
    private Integer mtId;

    private Integer aspId;

    private String mtName;

    public Integer getMtId() {
        return mtId;
    }

    public void setMtId(Integer mtId) {
        this.mtId = mtId;
    }

    public Integer getAspId() {
        return aspId;
    }

    public void setAspId(Integer aspId) {
        this.aspId = aspId;
    }

    public String getMtName() {
        return mtName;
    }

    public void setMtName(String mtName) {
        this.mtName = mtName == null ? null : mtName.trim();
    }

	@Override
	public String toString() {
		return "MovieTag [mtId=" + mtId + ", aspId=" + aspId + ", mtName=" + mtName + "]";
	}
    
}