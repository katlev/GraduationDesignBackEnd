package com.katle.design.entities;

public class StartFile {
    private Long userId;

    private String startName;

    private String startPath;

    private Integer startCheck;

    private String startOpinion;

    private Long startCheckman;

    private String startYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName == null ? null : startName.trim();
    }

    public String getStartPath() {
        return startPath;
    }

    public void setStartPath(String startPath) {
        this.startPath = startPath == null ? null : startPath.trim();
    }

    public Integer getStartCheck() {
        return startCheck;
    }

    public void setStartCheck(Integer startCheck) {
        this.startCheck = startCheck;
    }

    public String getStartOpinion() {
        return startOpinion;
    }

    public void setStartOpinion(String startOpinion) {
        this.startOpinion = startOpinion == null ? null : startOpinion.trim();
    }

    public Long getStartCheckman() {
        return startCheckman;
    }

    public void setStartCheckman(Long startCheckman) {
        this.startCheckman = startCheckman;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear == null ? null : startYear.trim();
    }
}