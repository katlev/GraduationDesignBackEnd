package com.katle.design.vo;

import lombok.Data;


@Data
public class TaskListVO {
    //学生id
    private Long userId;

    private Long titleId;

    private String titleName;

    private String titleMajor;

    //任务书
    private String taskName;

    private String taskPath;

    private Integer taskCheck;

    private String taskOpinion;

    //审核教师
    private String taskCheckman;

    //开题教师
    private String username;

    private String position;


}
