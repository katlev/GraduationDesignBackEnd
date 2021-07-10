package com.katle.design.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FilesVO {
    private Long userId;

    private String taskName;

    private String taskPath;

    private Integer taskCheck;

    private String startName;

    private String startPath;

    private Integer startCheck;

    private String middleName;

    private String middlePath;

    private Integer middleCheck;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planStart;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planEnd;

    private Integer planCheck;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date guidanceDate;

    private Integer guidanceCheck;

    private String translationName;

    private String translationPath;

    private Integer translationCheck;

    private String originalName;

    private String originalPath;

    private Integer originalCheck;

    private String literatureName;

    private String literaturePath;

    private Integer literatureCheck;

    private String thesisName;

    private String thesisPath;

    private Integer thesisCheck;
}
