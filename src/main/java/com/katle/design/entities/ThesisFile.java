package com.katle.design.entities;

public class ThesisFile {
    private Long userId;

    private String thesisName;

    private String thesisPath;

    private Integer thesisCheck;

    private String thesisOpinion;

    private Long thesisCheckman;

    private String thesisYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getThesisName() {
        return thesisName;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName == null ? null : thesisName.trim();
    }

    public String getThesisPath() {
        return thesisPath;
    }

    public void setThesisPath(String thesisPath) {
        this.thesisPath = thesisPath == null ? null : thesisPath.trim();
    }

    public Integer getThesisCheck() {
        return thesisCheck;
    }

    public void setThesisCheck(Integer thesisCheck) {
        this.thesisCheck = thesisCheck;
    }

    public String getThesisOpinion() {
        return thesisOpinion;
    }

    public void setThesisOpinion(String thesisOpinion) {
        this.thesisOpinion = thesisOpinion == null ? null : thesisOpinion.trim();
    }

    public Long getThesisCheckman() {
        return thesisCheckman;
    }

    public void setThesisCheckman(Long thesisCheckman) {
        this.thesisCheckman = thesisCheckman;
    }

    public String getThesisYear() {
        return thesisYear;
    }

    public void setThesisYear(String thesisYear) {
        this.thesisYear = thesisYear == null ? null : thesisYear.trim();
    }
}