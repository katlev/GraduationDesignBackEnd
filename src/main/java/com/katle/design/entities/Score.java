package com.katle.design.entities;

public class Score {
    private Long userId;

    private Float guidanceScore;

    private String guidancdValue;

    private String guidanceEditor;

    private String guidanceSignature;

    private Float readScore;

    private String readValue;

    private String readEditor;

    private String readSignature;

    private Float defenceScore;

    private String defenceValue;

    private String defenceSignature;

    private Float total;

    private String defenceEditor;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getGuidanceScore() {
        return guidanceScore;
    }

    public void setGuidanceScore(Float guidanceScore) {
        this.guidanceScore = guidanceScore;
    }

    public String getGuidancdValue() {
        return guidancdValue;
    }

    public void setGuidancdValue(String guidancdValue) {
        this.guidancdValue = guidancdValue == null ? null : guidancdValue.trim();
    }

    public String getGuidanceEditor() {
        return guidanceEditor;
    }

    public void setGuidanceEditor(String guidanceEditor) {
        this.guidanceEditor = guidanceEditor == null ? null : guidanceEditor.trim();
    }

    public String getGuidanceSignature() {
        return guidanceSignature;
    }

    public void setGuidanceSignature(String guidanceSignature) {
        this.guidanceSignature = guidanceSignature == null ? null : guidanceSignature.trim();
    }

    public Float getReadScore() {
        return readScore;
    }

    public void setReadScore(Float readScore) {
        this.readScore = readScore;
    }

    public String getReadValue() {
        return readValue;
    }

    public void setReadValue(String readValue) {
        this.readValue = readValue == null ? null : readValue.trim();
    }

    public String getReadEditor() {
        return readEditor;
    }

    public void setReadEditor(String readEditor) {
        this.readEditor = readEditor == null ? null : readEditor.trim();
    }

    public String getReadSignature() {
        return readSignature;
    }

    public void setReadSignature(String readSignature) {
        this.readSignature = readSignature == null ? null : readSignature.trim();
    }

    public Float getDefenceScore() {
        return defenceScore;
    }

    public void setDefenceScore(Float defenceScore) {
        this.defenceScore = defenceScore;
    }

    public String getDefenceValue() {
        return defenceValue;
    }

    public void setDefenceValue(String defenceValue) {
        this.defenceValue = defenceValue == null ? null : defenceValue.trim();
    }

    public String getDefenceSignature() {
        return defenceSignature;
    }

    public void setDefenceSignature(String defenceSignature) {
        this.defenceSignature = defenceSignature == null ? null : defenceSignature.trim();
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getDefenceEditor() {
        return defenceEditor;
    }

    public void setDefenceEditor(String defenceEditor) {
        this.defenceEditor = defenceEditor == null ? null : defenceEditor.trim();
    }
}