package com.katle.design.vo;

import lombok.Data;

@Data
public class StuListVO {
    private Long userId;

    private String usernum;

    private String username;

    private String password;

    private String college;

    private String grade;

    private String major;

    private String role;

    private String avatar;

    private Long titleId;

    private String titleName;

    private Float defenceScore;
}
