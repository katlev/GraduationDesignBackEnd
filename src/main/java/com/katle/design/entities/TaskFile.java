package com.katle.design.entities;

public class TaskFile {
    private Long userId;

    private String taskName;

    private String taskPath;

    private Integer taskCheck;

    private String taskOpinion;

    private Long taskCheckman;

    private String taskYear;

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

    public Integer getTaskCheck() {
        return taskCheck;
    }

    public void setTaskCheck(Integer taskCheck) {
        this.taskCheck = taskCheck;
    }

    public String getTaskOpinion() {
        return taskOpinion;
    }

    public void setTaskOpinion(String taskOpinion) {
        this.taskOpinion = taskOpinion == null ? null : taskOpinion.trim();
    }

    public Long getTaskCheckman() {
        return taskCheckman;
    }

    public void setTaskCheckman(Long taskCheckman) {
        this.taskCheckman = taskCheckman;
    }

    public String getTaskYear() {
        return taskYear;
    }

    public void setTaskYear(String taskYear) {
        this.taskYear = taskYear == null ? null : taskYear.trim();
    }
}