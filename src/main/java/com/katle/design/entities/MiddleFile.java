package com.katle.design.entities;

public class MiddleFile {
    private Long userid;

    private String middleName;

    private String middlePath;

    private Integer middleCheck;

    private String middleOpinion;

    private Long middleCheckman;

    private String middleYear;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? null : middleName.trim();
    }

    public String getMiddlePath() {
        return middlePath;
    }

    public void setMiddlePath(String middlePath) {
        this.middlePath = middlePath == null ? null : middlePath.trim();
    }

    public Integer getMiddleCheck() {
        return middleCheck;
    }

    public void setMiddleCheck(Integer middleCheck) {
        this.middleCheck = middleCheck;
    }

    public String getMiddleOpinion() {
        return middleOpinion;
    }

    public void setMiddleOpinion(String middleOpinion) {
        this.middleOpinion = middleOpinion == null ? null : middleOpinion.trim();
    }

    public Long getMiddleCheckman() {
        return middleCheckman;
    }

    public void setMiddleCheckman(Long middleCheckman) {
        this.middleCheckman = middleCheckman;
    }

    public String getMiddleYear() {
        return middleYear;
    }

    public void setMiddleYear(String middleYear) {
        this.middleYear = middleYear == null ? null : middleYear.trim();
    }
}