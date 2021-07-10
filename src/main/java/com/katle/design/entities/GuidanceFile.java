package com.katle.design.entities;

import java.util.Date;

public class GuidanceFile {
    private Long guidanceId;

    private Long userId;

    private String guidanceName;

    private String guidancePath;

    private Date guidanceDate;

    private String guidanceForm;

    private String guidanceValue;

    private Integer guidanceCheck;

    private String guidanceOpinion;

    private Long guidanceCheckMan;

    private String guidanceYear;

    public Long getGuidanceId() {
        return guidanceId;
    }

    public void setGuidanceId(Long guidanceId) {
        this.guidanceId = guidanceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getGuidanceDate() {
        return guidanceDate;
    }

    public void setGuidanceDate(Date guidanceDate) {
        this.guidanceDate = guidanceDate;
    }

    public String getGuidanceForm() {
        return guidanceForm;
    }

    public void setGuidanceForm(String guidanceForm) {
        this.guidanceForm = guidanceForm == null ? null : guidanceForm.trim();
    }

    public String getGuidanceValue() {
        return guidanceValue;
    }

    public void setGuidanceValue(String guidanceValue) {
        this.guidanceValue = guidanceValue == null ? null : guidanceValue.trim();
    }

    public Integer getGuidanceCheck() {
        return guidanceCheck;
    }

    public void setGuidanceCheck(Integer guidanceCheck) {
        this.guidanceCheck = guidanceCheck;
    }

    public String getGuidanceOpinion() {
        return guidanceOpinion;
    }

    public void setGuidanceOpinion(String guidanceOpinion) {
        this.guidanceOpinion = guidanceOpinion == null ? null : guidanceOpinion.trim();
    }

    public Long getGuidanceCheckMan() {
        return guidanceCheckMan;
    }

    public void setGuidanceCheckMan(Long guidanceCheckMan) {
        this.guidanceCheckMan = guidanceCheckMan;
    }

    public String getGuidanceYear() {
        return guidanceYear;
    }

    public void setGuidanceYear(String guidanceYear) {
        this.guidanceYear = guidanceYear == null ? null : guidanceYear.trim();
    }
}