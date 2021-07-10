package com.katle.design.entities;

public class Document {
    private Long userId;

    private String taskName;

    private String taskPath;

    private String startName;

    private String startPath;

    private Boolean startCheck;

    private String middleName;

    private String middlePath;

    private Boolean middleCheck;

    private String planName;

    private String planPath;

    private Boolean planCheck;

    private String guidanceName;

    private String guidancePath;

    private Boolean guidanceCheck;

    private String translationName;

    private String translationPath;

    private Boolean translationCheck;

    private String originalName;

    private String originalPath;

    private Boolean originalCheck;

    private String literatureName;

    private String literaturePath;

    private Boolean literatureCheck;

    private String thesisName;

    private String thesisPath;

    private Boolean thesisCheck;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskPath() {
        return taskPath;
    }

    public void setTaskPath(String taskPath) {
        this.taskPath = taskPath == null ? null : taskPath.trim();
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

    public Boolean getStartCheck() {
        return startCheck;
    }

    public void setStartCheck(Boolean startCheck) {
        this.startCheck = startCheck;
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

    public Boolean getMiddleCheck() {
        return middleCheck;
    }

    public void setMiddleCheck(Boolean middleCheck) {
        this.middleCheck = middleCheck;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getPlanPath() {
        return planPath;
    }

    public void setPlanPath(String planPath) {
        this.planPath = planPath == null ? null : planPath.trim();
    }

    public Boolean getPlanCheck() {
        return planCheck;
    }

    public void setPlanCheck(Boolean planCheck) {
        this.planCheck = planCheck;
    }

    public String getGuidanceName() {
        return guidanceName;
    }

    public void setGuidanceName(String guidanceName) {
        this.guidanceName = guidanceName == null ? null : guidanceName.trim();
    }

    public String getGuidancePath() {
        return guidancePath;
    }

    public void setGuidancePath(String guidancePath) {
        this.guidancePath = guidancePath == null ? null : guidancePath.trim();
    }

    public Boolean getGuidanceCheck() {
        return guidanceCheck;
    }

    public void setGuidanceCheck(Boolean guidanceCheck) {
        this.guidanceCheck = guidanceCheck;
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

    public Boolean getTranslationCheck() {
        return translationCheck;
    }

    public void setTranslationCheck(Boolean translationCheck) {
        this.translationCheck = translationCheck;
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

    public Boolean getOriginalCheck() {
        return originalCheck;
    }

    public void setOriginalCheck(Boolean originalCheck) {
        this.originalCheck = originalCheck;
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

    public Boolean getLiteratureCheck() {
        return literatureCheck;
    }

    public void setLiteratureCheck(Boolean literatureCheck) {
        this.literatureCheck = literatureCheck;
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

    public Boolean getThesisCheck() {
        return thesisCheck;
    }

    public void setThesisCheck(Boolean thesisCheck) {
        this.thesisCheck = thesisCheck;
    }
}