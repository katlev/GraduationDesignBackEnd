package com.katle.design.vo;

import lombok.Data;

@Data
public class ChooseTitleVO {
    /**
     * 选题消息学生id
     */
    private Long userId;

    private Long titleId;

    private String state;

    private String titleName;

    private String usernum;

    private String username;

    private String avatar;


}
