package com.katle.design.entities;

public class LiteratureFile {
    private Long userId;

    private String literatureName;

    private String literaturePath;

    private Integer literatureCheck;

    private String literatureOpinion;

    private Long literatureCheckman;

    private String literatureYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLiteratureName() {
        return literatureName;
    }

    public void setLiteratureName(String literatureName) {
        this.literatureName = literatureName == null ? null : literatureName.trim();
    }

    public String getLiteraturePath() {
        return literaturePath;
    }

    public void setLiteraturePath(String literaturePath) {
        this.literaturePath = literaturePath == null ? null : literaturePath.trim();
    }

    public Integer getLiteratureCheck() {
        return literatureCheck;
    }

    public void setLiteratureCheck(Integer literatureCheck) {
        this.literatureCheck = literatureCheck;
    }

    public String getLiteratureOpinion() {
        return literatureOpinion;
    }

    public void setLiteratureOpinion(String literatureOpinion) {
        this.literatureOpinion = literatureOpinion == null ? null : literatureOpinion.trim();
    }

    public Long getLiteratureCheckman() {
        return literatureCheckman;
    }

    public void setLiteratureCheckman(Long literatureCheckman) {
        this.literatureCheckman = literatureCheckman;
    }

    public String getLiteratureYear() {
        return literatureYear;
    }

    public void setLiteratureYear(String literatureYear) {
        this.literatureYear = literatureYear == null ? null : literatureYear.trim();
    }
}