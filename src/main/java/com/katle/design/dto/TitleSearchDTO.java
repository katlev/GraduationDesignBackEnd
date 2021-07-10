package com.katle.design.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TitleSearchDTO {
    /**
     * 管理员userId
     */
    private Long userId;
    /**
     * 日期格式转化
     */
    /*@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")*/

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date titleYear;

    private String titleState;

    private String titleSemester;
}
