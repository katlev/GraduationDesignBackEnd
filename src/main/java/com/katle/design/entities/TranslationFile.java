package com.katle.design.entities;

public class TranslationFile {
    private Long userId;

    private String translationName;

    private String translationPath;

    private Integer translationCheck;

    private String translationOpinion;

    private Long translationCheckman;

    private String translationYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTranslationName() {
        return translationName;
    }

    public void setTranslationName(String translationName) {
        this.translationName = translationName == null ? null : translationName.trim();
    }

    public String getTranslationPath() {
        return translationPath;
    }

    public void setTranslationPath(String translationPath) {
        this.translationPath = translationPath == null ? null : translationPath.trim();
    }

    public Integer getTranslationCheck() {
        return translationCheck;
    }

    public void setTranslationCheck(Integer translationCheck) {
        this.translationCheck = translationCheck;
    }

    public String getTranslationOpinion() {
        return translationOpinion;
    }

    public void setTranslationOpinion(String translationOpinion) {
        this.translationOpinion = translationOpinion == null ? null : translationOpinion.trim();
    }

    public Long getTranslationCheckman() {
        return translationCheckman;
    }

    public void setTranslationCheckman(Long translationCheckman) {
        this.translationCheckman = translationCheckman;
    }

    public String getTranslationYear() {
        return translationYear;
    }

    public void setTranslationYear(String translationYear) {
        this.translationYear = translationYear == null ? null : translationYear.trim();
    }
}