package com.katle.design.entities;

import java.util.Date;

public class PlanFile {
    private Long planId;

    private Long userId;

    private String planName;

    private String planPath;

    private Date planStart;

    private Date planEnd;

    private String planValue;

    private String actualValue;

    private Integer planCheck;

    private String planOpinion;

    private Long planCheckMan;

    private String planYear;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getPlanStart() {
        return planStart;
    }

    public void setPlanStart(Date planStart) {
        this.planStart = planStart;
    }

    public Date getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(Date planEnd) {
        this.planEnd = planEnd;
    }

    public String getPlanValue() {
        return planValue;
    }

    public void setPlanValue(String planValue) {
        this.planValue = planValue == null ? null : planValue.trim();
    }

    public String getActualValue() {
        return actualValue;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue == null ? null : actualValue.trim();
    }

    public Integer getPlanCheck() {
        return planCheck;
    }

    public void setPlanCheck(Integer planCheck) {
        this.planCheck = planCheck;
    }

    public String getPlanOpinion() {
        return planOpinion;
    }

    public void setPlanOpinion(String planOpinion) {
        this.planOpinion = planOpinion == null ? null : planOpinion.trim();
    }

    public Long getPlanCheckMan() {
        return planCheckMan;
    }

    public void setPlanCheckMan(Long planCheckMan) {
        this.planCheckMan = planCheckMan;
    }

    public String getPlanYear() {
        return planYear;
    }

    public void setPlanYear(String planYear) {
        this.planYear = planYear == null ? null : planYear.trim();
    }
}