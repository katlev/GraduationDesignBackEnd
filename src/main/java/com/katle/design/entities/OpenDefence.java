package com.katle.design.entities;

import java.util.Date;

public class OpenDefence {
    private Long openId;

    private String openName;

    private String openPlace;

    private Date openTime;

    private Date openDate;

    private String openTeachs;

    private String openStudents;

    private String openLeader;

    private String openYear;

    private Long adminId;

    public Long getOpenId() {
        return openId;
    }

    public void setOpenId(Long openId) {
        this.openId = openId;
    }

    public String getOpenName() {
        return openName;
    }

    public void setOpenName(String openName) {
        this.openName = openName == null ? null : openName.trim();
    }

    public String getOpenPlace() {
        return openPlace;
    }

    public void setOpenPlace(String openPlace) {
        this.openPlace = openPlace == null ? null : openPlace.trim();
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getOpenTeachs() {
        return openTeachs;
    }

    public void setOpenTeachs(String openTeachs) {
        this.openTeachs = openTeachs == null ? null : openTeachs.trim();
    }

    public String getOpenStudents() {
        return openStudents;
    }

    public void setOpenStudents(String openStudents) {
        this.openStudents = openStudents == null ? null : openStudents.trim();
    }

    public String getOpenLeader() {
        return openLeader;
    }

    public void setOpenLeader(String openLeader) {
        this.openLeader = openLeader == null ? null : openLeader.trim();
    }

    public String getOpenYear() {
        return openYear;
    }

    public void setOpenYear(String openYear) {
        this.openYear = openYear == null ? null : openYear.trim();
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}