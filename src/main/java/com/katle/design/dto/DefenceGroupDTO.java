package com.katle.design.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DefenceGroupDTO {

    private String defenceName;

    private String defencePlace;

    /**
     * 日期格式转化
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date defenceDate;

    /**
     * 日期格式转化
     */
    /*@JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")*/
    @DateTimeFormat(pattern="HH:mm:ss")
    private Date defenceTime;

    private String defenceTeachs;

    private String defenceStudents;

    private String defenceLeader;

    private String defenceYear;

    private Long adminId;
}
