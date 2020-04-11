package com.movie.pojo;

public class UserTag {
    private Integer utId;

    private Integer userId;

    private String utName;

    public Integer getUtId() {
        return utId;
    }

    public void setUtId(Integer utId) {
        this.utId = utId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUtName() {
        return utName;
    }

    public void setUtName(String utName) {
        this.utName = utName == null ? null : utName.trim();
    }
}