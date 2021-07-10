package com.katle.design.vo;

import lombok.Data;

/**
 * 成绩录入模块：学生成绩列表
 */
@Data
public class ScoreListVO {

    //学生信息
    private Long userId;

    private String usernum;

    private String username;

    //题目信息
    private String titleName;

    private String teachName;

    //成绩信息
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
}
