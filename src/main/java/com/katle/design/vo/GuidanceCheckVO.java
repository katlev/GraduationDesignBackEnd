package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class GuidanceCheckVO {
    private Long guidanceId;

    private Long userId;

    private String guidanceName;

    private String guidancePath;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date guidanceDate;

    private Integer guidanceCheck;

    private String guidanceOpinion;

}
