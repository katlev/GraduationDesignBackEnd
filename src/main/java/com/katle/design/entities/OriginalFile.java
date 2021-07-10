package com.katle.design.entities;

public class OriginalFile {
    private Long userId;

    private String originalName;

    private String originalPath;

    private Integer originalCheck;

    private String originalOpinion;

    private Long originalCheckman;

    private String originalYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath == null ? null : originalPath.trim();
    }

    public Integer getOriginalCheck() {
        return originalCheck;
    }

    public void setOriginalCheck(Integer originalCheck) {
        this.originalCheck = originalCheck;
    }

    public String getOriginalOpinion() {
        return originalOpinion;
    }

    public void setOriginalOpinion(String originalOpinion) {
        this.originalOpinion = originalOpinion == null ? null : originalOpinion.trim();
    }

    public Long getOriginalCheckman() {
        return originalCheckman;
    }

    public void setOriginalCheckman(Long originalCheckman) {
        this.originalCheckman = originalCheckman;
    }

    public String getOriginalYear() {
        return originalYear;
    }

    public void setOriginalYear(String originalYear) {
        this.originalYear = originalYear == null ? null : originalYear.trim();
    }
}