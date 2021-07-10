package com.katle.design.vo;

import lombok.Data;

@Data
public class StuScoreVO {

    /**
     * 学生userId
     */
    private Long userId;

    private Float guidanceScore;

    private String guidancdValue;

    private Float readScore;

    private String readValue;

    private Float defenceScore;

    private String defenceValue;

    private Float total;

    private String defenceEditor;

    /**
     * 指导教师姓名
     */
    private String username;
}
