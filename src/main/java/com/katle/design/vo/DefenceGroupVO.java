package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DefenceGroupVO {
    private Long defenceId;

    private String defenceName;

    private String defencePlace;

    /**
     * 日期格式转化
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date defenceDate;

    /**
     * 日期格式转化
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date defenceTime;

    private String defenceTeachs;

    private String defenceStudents;

    private String defenceLeader;

}
