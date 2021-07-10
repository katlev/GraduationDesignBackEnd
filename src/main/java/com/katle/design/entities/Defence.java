package com.katle.design.entities;

import java.util.Date;

public class Defence {
    private Long defenceId;

    private String defenceName;

    private String defencePlace;

    private Date defenceTime;

    private Date defenceDate;

    private String defenceTeachs;

    private String defenceStudents;

    private String defenceLeader;

    private String defenceYear;

    private Long adminId;

    public Long getDefenceId() {
        return defenceId;
    }

    public void setDefenceId(Long defenceId) {
        this.defenceId = defenceId;
    }

    public String getDefenceName() {
        return defenceName;
    }

    public void setDefenceName(String defenceName) {
        this.defenceName = defenceName == null ? null : defenceName.trim();
    }

    public String getDefencePlace() {
        return defencePlace;
    }

    public void setDefencePlace(String defencePlace) {
        this.defencePlace = defencePlace == null ? null : defencePlace.trim();
    }

    public Date getDefenceTime() {
        return defenceTime;
    }

    public void setDefenceTime(Date defenceTime) {
        this.defenceTime = defenceTime;
    }

    public Date getDefenceDate() {
        return defenceDate;
    }

    public void setDefenceDate(Date defenceDate) {
        this.defenceDate = defenceDate;
    }

    public String getDefenceTeachs() {
        return defenceTeachs;
    }

    public void setDefenceTeachs(String defenceTeachs) {
        this.defenceTeachs = defenceTeachs == null ? null : defenceTeachs.trim();
    }

    public String getDefenceStudents() {
        return defenceStudents;
    }

    public void setDefenceStudents(String defenceStudents) {
        this.defenceStudents = defenceStudents == null ? null : defenceStudents.trim();
    }

    public String getDefenceLeader() {
        return defenceLeader;
    }

    public void setDefenceLeader(String defenceLeader) {
        this.defenceLeader = defenceLeader == null ? null : defenceLeader.trim();
    }

    public String getDefenceYear() {
        return defenceYear;
    }

    public void setDefenceYear(String defenceYear) {
        this.defenceYear = defenceYear == null ? null : defenceYear.trim();
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}