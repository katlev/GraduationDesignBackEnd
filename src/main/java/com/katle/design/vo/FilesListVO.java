package com.katle.design.vo;

import lombok.Data;

@Data
public class FilesListVO {
    /*学生信息*/
    private Long userId;

    private String usernum;

    private String username;

    private String major;

    //题目信息
    private Long titleId;

    private String titleName;

    private String teachName;

    //文件信息
    private String fileName;

    private String filePath;

    private Integer fileCheck;

    private String fileOpinion;

    private String fileCheckman;
}
