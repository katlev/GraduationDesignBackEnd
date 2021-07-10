package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class GuidanceListVO {

    private Long guidanceId;

    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date guidanceDate;

    private Integer guidanceCheck;
}
