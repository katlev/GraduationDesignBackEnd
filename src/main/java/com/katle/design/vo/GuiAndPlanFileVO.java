package com.katle.design.vo;

import lombok.Data;

@Data
public class GuiAndPlanFileVO {
    /*学生信息*/
    private Long userId;

    private String usernum;

    private String username;

    private String major;

    //题目信息
    private Long titleId;

    private String titleName;

    private String teachName;

    //t提交次数
    private Integer count;
}
