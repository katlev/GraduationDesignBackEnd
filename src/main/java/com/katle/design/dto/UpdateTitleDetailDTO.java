package com.katle.design.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateTitleDetailDTO {
    private Long titleId;

    private String titleName;

    private String titleKind;

    private String titleSource;

    private String titleModel;

    /**
     * 指定年份格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date titleYear;

    private String titleType;

    private String titleComplete;

    private String titleValue;

    private String titleRequire;

    private String titleResult;

    private String titleState;

    private String titleMajor;

    private String username;

    private String position;

    private String college;

}
