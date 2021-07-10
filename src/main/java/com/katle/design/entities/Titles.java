package com.katle.design.entities;

import java.util.Date;

public class Titles {
    private Long titleId;

    private Long userId;

    private String userName;

    private String titleName;

    private String titleKind;

    private String titleSource;

    private String titleModel;

    private Date titleYear;

    private String titleType;

    private String titleComplete;

    private String titleValue;

    private String titleRequire;

    private String titleResult;

    private String titleState;

    private String titleMajor;

    private Boolean titleSelect;

    private String titleSemester;

    private Long titleCheckman;

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public String getTitleKind() {
        return titleKind;
    }

    public void setTitleKind(String titleKind) {
        this.titleKind = titleKind == null ? null : titleKind.trim();
    }

    public String getTitleSource() {
        return titleSource;
    }

    public void setTitleSource(String titleSource) {
        this.titleSource = titleSource == null ? null : titleSource.trim();
    }

    public String getTitleModel() {
        return titleModel;
    }

    public void setTitleModel(String titleModel) {
        this.titleModel = titleModel == null ? null : titleModel.trim();
    }

    public Date getTitleYear() {
        return titleYear;
    }

    public void setTitleYear(Date titleYear) {
        this.titleYear = titleYear;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType == null ? null : titleType.trim();
    }

    public String getTitleComplete() {
        return titleComplete;
    }

    public void setTitleComplete(String titleComplete) {
        this.titleComplete = titleComplete == null ? null : titleComplete.trim();
    }

    public String getTitleValue() {
        return titleValue;
    }

    public void setTitleValue(String titleValue) {
        this.titleValue = titleValue == null ? null : titleValue.trim();
    }

    public String getTitleRequire() {
        return titleRequire;
    }

    public void setTitleRequire(String titleRequire) {
        this.titleRequire = titleRequire == null ? null : titleRequire.trim();
    }

    public String getTitleResult() {
        return titleResult;
    }

    public void setTitleResult(String titleResult) {
        this.titleResult = titleResult == null ? null : titleResult.trim();
    }

    public String getTitleState() {
        return titleState;
    }

    public void setTitleState(String titleState) {
        this.titleState = titleState == null ? null : titleState.trim();
    }

    public String getTitleMajor() {
        return titleMajor;
    }

    public void setTitleMajor(String titleMajor) {
        this.titleMajor = titleMajor == null ? null : titleMajor.trim();
    }

    public Boolean getTitleSelect() {
        return titleSelect;
    }

    public void setTitleSelect(Boolean titleSelect) {
        this.titleSelect = titleSelect;
    }

    public String getTitleSemester() {
        return titleSemester;
    }

    public void setTitleSemester(String titleSemester) {
        this.titleSemester = titleSemester == null ? null : titleSemester.trim();
    }

    public Long getTitleCheckman() {
        return titleCheckman;
    }

    public void setTitleCheckman(Long titleCheckman) {
        this.titleCheckman = titleCheckman;
    }
}