package com.katle.design.vo;

import lombok.Data;

@Data
public class TeachTitleListVO {
    private Long titleId;
    /**
     * 教师id
     */
    private Long userId;

    private String titleName;

    private String titleState;


}
