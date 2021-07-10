package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class GuidanceItemDetail {
    private Long guidanceId;

    private Long userId;

    private String guidanceName;

    private String guidancePath;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date guidanceDate;

    private String guidanceForm;

    private String guidanceValue;

    private Integer guidanceCheck;

    private String guidanceOpinion;

    private String guidanceCheckman;

    private String usernum;

    private String username;

    private String titleName;

    private String teachName;
}
