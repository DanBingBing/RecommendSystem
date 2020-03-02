package com.movie.pojo;

public class Movie {
    private Integer mId;

    private String mName;

    private String mPoster;

    private String mYear;

    private String mTag;

    private String mPerformer;

    private String mPicture;

    private Float mGrade;

    private String mDescribe;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmPoster() {
        return mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster == null ? null : mPoster.trim();
    }

    public String getmYear() {
        return mYear;
    }

    public void setmYear(String mYear) {
        this.mYear = mYear == null ? null : mYear.trim();
    }

    public String getmTag() {
        return mTag;
    }

    public void setmTag(String mTag) {
        this.mTag = mTag == null ? null : mTag.trim();
    }

    public String getmPerformer() {
        return mPerformer;
    }

    public void setmPerformer(String mPerformer) {
        this.mPerformer = mPerformer == null ? null : mPerformer.trim();
    }

    public String getmPicture() {
        return mPicture;
    }

    public void setmPicture(String mPicture) {
        this.mPicture = mPicture == null ? null : mPicture.trim();
    }

    public Float getmGrade() {
        return mGrade;
    }

    public void setmGrade(Float mGrade) {
        this.mGrade = mGrade;
    }

    public String getmDescribe() {
        return mDescribe;
    }

    public void setmDescribe(String mDescribe) {
        this.mDescribe = mDescribe == null ? null : mDescribe.trim();
    }
}