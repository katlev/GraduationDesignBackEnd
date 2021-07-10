package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TitleListVO {
    private Long titleId;

    /**
     * 教师userId
     */
    private Long userId;

    private String titleName;

    private String titleKind;

    /**
     * 指定年份格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date titleYear;

    private String titleState;

    private String checkTeach;

    private String username;

    private String college;
}
