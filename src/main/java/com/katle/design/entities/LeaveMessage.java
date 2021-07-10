package com.katle.design.entities;

import java.util.Date;

public class LeaveMessage {
    private Long messageId;

    private Long stuId;

    private String stuMessage;

    private Date stuDate;

    private Date stuTime;

    private Long teachId;

    private String teachMessage;

    private Date teachDate;

    private Date teachTime;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuMessage() {
        return stuMessage;
    }

    public void setStuMessage(String stuMessage) {
        this.stuMessage = stuMessage == null ? null : stuMessage.trim();
    }

    public Date getStuDate() {
        return stuDate;
    }

    public void setStuDate(Date stuDate) {
        this.stuDate = stuDate;
    }

    public Date getStuTime() {
        return stuTime;
    }

    public void setStuTime(Date stuTime) {
        this.stuTime = stuTime;
    }

    public Long getTeachId() {
        return teachId;
    }

    public void setTeachId(Long teachId) {
        this.teachId = teachId;
    }

    public String getTeachMessage() {
        return teachMessage;
    }

    public void setTeachMessage(String teachMessage) {
        this.teachMessage = teachMessage == null ? null : teachMessage.trim();
    }

    public Date getTeachDate() {
        return teachDate;
    }

    public void setTeachDate(Date teachDate) {
        this.teachDate = teachDate;
    }

    public Date getTeachTime() {
        return teachTime;
    }

    public void setTeachTime(Date teachTime) {
        this.teachTime = teachTime;
    }
}