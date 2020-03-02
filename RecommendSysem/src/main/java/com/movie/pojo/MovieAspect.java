package com.movie.pojo;

public class MovieAspect {
    private Integer maId;

    private String maName;

    public Integer getMaId() {
        return maId;
    }

    public void setMaId(Integer maId) {
        this.maId = maId;
    }

    public String getMaName() {
        return maName;
    }

    public void setMaName(String maName) {
        this.maName = maName == null ? null : maName.trim();
    }
}