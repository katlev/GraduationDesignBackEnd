package com.katle.design.vo;

import lombok.Data;

import java.security.PrivateKey;

@Data
public class CheckTaskDetailVO {

    /*题目信息*/
    private Long titleId;

    private Long userId;

    private String userName;

    private String position;

    private String titleName;

    private String titleKind;

    private String titleSource;

    private String titleValue;

    /*选题学生信息*/
    private String stuNum;

    private String stuName;

    private String major;

    /*任务书信息*/
    private String taskName;

    private String taskPath;

    private Integer taskCheck;
}
