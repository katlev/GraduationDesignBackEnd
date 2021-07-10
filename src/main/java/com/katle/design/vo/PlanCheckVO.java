package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PlanCheckVO {
    private Long planId;

    private Long userId;

    private String planName;

    private String planPath;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planStart;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planEnd;

    private Integer planCheck;

    private String planOpinion;


}
