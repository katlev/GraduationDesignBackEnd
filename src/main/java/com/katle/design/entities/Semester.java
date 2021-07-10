package com.katle.design.entities;

public class Semester {
    private Long semesterId;

    private String semesterValue;

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterValue() {
        return semesterValue;
    }

    public void setSemesterValue(String semesterValue) {
        this.semesterValue = semesterValue == null ? null : semesterValue.trim();
    }
}