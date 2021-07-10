package com.katle.design.service;

import com.katle.design.entities.Score;
import com.katle.design.vo.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService {
    /**
     * 可选题目列表
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> selectTitleList(int page, int limit);

    /**
     * 根据题目id和学生userId确认选题
     * @param titleId
     * @return
     */
    boolean checkSelectTitle(Long titleId,Long userId);

    /**
     * 根据学生userId上传个人开题报告
     * @param userId
     * @param startName
     * @param startPath
     * @return
     */
    boolean uploadStartFile(Long userId,String startName,String startPath,String schoolYear);

    /**
     * 根据学生userId上传个人中期检查
     * @param userId
     * @param middleName
     * @param middlePath
     * @return
     */
    boolean uploadMiddleFile(Long userId,String middleName,String middlePath,String schoolYear);

    /**
     * 判断plan表中是否有userId以及内容
     * @param userId
     * @return
     */
    boolean ifPlan(Long userId);

    /**
     * 进度计划，第一次添加，用upload
     * @param
     * @return
     */
    boolean uploadPlanFile(Long userId, String planName, String planPath, Date planStart, Date planEnd, String planValue, String actualValue,String schoolYear);

    /**
     * 进度计划添加，除第一次以后的添加
     * @param userId
     * @param planName
     * @param planPath
     * @param planStart
     * @param planEnd
     * @param planValue
     * @param actualValue
     * @return
     */
    boolean insertPlanItem(Long userId, String planName, String planPath, Date planStart, Date planEnd, String planValue, String actualValue,String schoolYear);

    /**
     * 根据userId判断第一次知道记录是否已填写
     * @param userId
     * @return
     */
    boolean ifGuidance(Long userId);

    /**
     * 根据学生userId上传个人指导记录
     * @param userId
     * @param guidanceName
     * @param guidancePath
     * @param guidanceDate
     * @param guidanceForm
     * @param guidanceValue
     * @return
     */
    boolean uploadGuidanceFile(Long userId,String guidanceName,String guidancePath,Date guidanceDate,String guidanceForm,String guidanceValue,String schoolYear);

    /**
     * 第二次添加个人指导记录
     * @param userId
     * @param guidanceName
     * @param guidancePath
     * @param guidanceDate
     * @param guidanceForm
     * @param guidanceValue
     * @return
     */
    boolean insertGuidance(Long userId,String guidanceName,String guidancePath,Date guidanceDate,String guidanceForm,String guidanceValue,String schoolYear);

    /**
     * 根据学生userId上传个人外文译文
     * @param userId
     * @param translationName
     * @param translationPath
     * @return
     */
    boolean uploadTranslationFile(Long userId,String translationName,String translationPath,String schoolYear);

    /**
     * 根据学生userId上传个人外文原文
     * @param userId
     * @param originalName
     * @param originalPath
     * @return
     */
    boolean uploadOriginalFile(Long userId,String originalName,String originalPath,String schoolYear);

    /**
     * 根据学生userId上传个人文献综述
     * @param userId
     * @param literatureName
     * @param literaturePath
     * @return
     */
    boolean uploadLiteratureFile(Long userId,String literatureName,String literaturePath,String schoolYear);

    /**
     * 根据学生userId上传个人毕业论文
     * @param userId
     * @param thesisName
     * @param thesisPath
     * @return
     */
    boolean uploadThesisFile(Long userId,String thesisName,String thesisPath,String schoolYear);

    /**
     * 根据学生姓名查询开题答辩分组
     * @param openStudents
     * @return
     */
    DefenceGroupVO stuOpenGroup(String openStudents);

    /**
     * 根据学生姓名查询答辩分组
     * @param defenceStudents
     * @return
     */
    DefenceGroupVO stuDefenceGroup(String defenceStudents);

    /**
     * 根据学生userId查询学生成绩
     * @param userId
     * @return
     */
    Score studentScore(Long userId);

    /**
     * 根据学生学号获取选题详细信息
     * @param userId
     * @return
     */
   StuTitleDetialVO stuSelectTitleDetails(Long userId);

    /**
     * 根据学生学号取消学生选题信息
     * @param userId
     * @return
     */
   boolean stuCancelTitle(Long userId);

    /**
     * 根据关键词进行题目模糊查询
     * @param searchValue
     * @return
     */
   Map<String, Object> searchTitles(int page,int limit,String searchValue);

    /**
     * 根据学生提交的进度计划planID获取进度计划详细内容
     * @param planId
     * @return
     */
   PlanItemDetail getPlanItemDetail(Long planId);

    /**
     * 根据指导记录的guidanceID获取指导记录的详细内容
     * @param guidanceId
     * @return
     */
   GuidanceItemDetail getGuidanceItemDetail(Long guidanceId);

    /**
     * 根据学生userId获取学生过程文档的审核情况
     * @param userId
     * @return
     */
   FileCheckVO getFileCheck(Long userId);

    /**
     * 根据学生userId获取学生进度计划审核情况
     * @param userId
     * @return
     */
   List<PlanCheckVO> getPlanCheck(Long userId);

    /**
     * 根据学生userId获取学生指导记录审核情况
     * @param userId
     * @return
     */
   List<GuidanceCheckVO> getGuidanceCheck(Long userId);





}
