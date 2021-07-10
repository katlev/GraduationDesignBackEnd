package com.katle.design.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

public interface GraphicService {

    /**
     * 获取当前院系学生总人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer stuTotalNum(Long adminId,String schoolYear);

    /**
     * 获取开题报告提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer startFileNum(Long adminId,String schoolYear);

    /**
     * 获取中期检查提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer middleFileNum(Long adminId,String schoolYear);

    /**
     * 获取外文译文提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer translationNum(Long adminId,String schoolYear);

    /**
     * 获取外文原文提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer originalNum(Long adminId,String schoolYear);

    /**
     * 获取文献综述提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer literatureNum(Long adminId,String schoolYear);

    /**
     * 获取毕业论文提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer thesisNum(Long adminId,String schoolYear);

    /**
     * 获取指导记录提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer guidanceNum(Long adminId,String schoolYear);

    /**
     * 进度计划提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    Integer planNum(Long adminId,String schoolYear);

    /**
     * 获取分数统计
     * @param adminId
     * @param schoolYear
     * @return
     */
    Map<String,Integer> scoreGrade(Long adminId, String schoolYear);

    /**
     * 导出指导记录表
     * @return
     */
    XSSFWorkbook exportGuidance(Long userId,String schoolYear);

    /**
     * 导出进度计划
     * @param userId
     * @param schoolYear
     * @return
     */
    XSSFWorkbook exportPlan(Long userId,String schoolYear);
}
