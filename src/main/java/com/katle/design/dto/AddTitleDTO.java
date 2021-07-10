package com.katle.design.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AddTitleDTO {

    private Long userId;

    private String titleName;

    private String titleKind;

    private String titleSource;

    private String titleModel;

    /**
     * 日期格式转化
     */
    /*@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date titleYear;*/

    private String titleType;

    private String titleComplete;

    private String titleValue;

    private String titleRequire;

    private String titleResult;

    private String titleMajor;

    private String titleSemester;

}
