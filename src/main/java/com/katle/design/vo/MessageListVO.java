package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MessageListVO {

    private Long messageId;

    private Long stuId;

    private String stuMessage;

    /**
     * 日期格式转化
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stuDate;

    /**
     * 日期格式转化
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date stuTime;

    private Long teachId;

    private String teachMessage;

    /**
     * 日期格式转化
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date teachDate;

    /**
     * 日期格式转化
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date teachTime;
}
