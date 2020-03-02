package com.movie.pojo;

public class MoviePerformer {
    private Integer mpId;

    private String mpName;

    private Integer mpRole;

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public String getMpName() {
        return mpName;
    }

    public void setMpName(String mpName) {
        this.mpName = mpName == null ? null : mpName.trim();
    }

    public Integer getMpRole() {
        return mpRole;
    }

    public void setMpRole(Integer mpRole) {
        this.mpRole = mpRole;
    }
}