package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PlanItemDetail {
    private Long planId;

    private Long userId;

    private String planName;

    private String planPath;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planStart;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planEnd;

    private String planValue;

    private String actualValue;

    private Integer planCheck;

    private String planOpinion;

    private String planCheckman;

    private String usernum;

    private String username;

    private String titleName;

    private String teachName;
}
