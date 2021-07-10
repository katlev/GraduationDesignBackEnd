package com.katle.design.service;

import com.katle.design.dto.AddTitleDTO;
import com.katle.design.dto.RecordSearchDTO;
import com.katle.design.entities.Score;
import com.katle.design.vo.*;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    /**
     * 教师开题列表
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    Map<String,Object> getTeachTitleVO(int page,int limit,Long userId);

    /**
     * 题目表添加
     * @param addTitleDTO
     * @return
     */
    boolean addTitle(AddTitleDTO addTitleDTO);

    /**
     * 每位教师开题数量
     * @param userId
     * @return
     */
    int titlesNumber(Long userId);

    /**
     * 根据教师userId获取选题消息列表
     * @param userId
     * @return
     */
    Map<String, Object> chooseTitleVO(int page,int limit,Long userId);

    /**
     * 根据题目id获取选题信息详情
     * @param titleId
     * @return
     */
    ChooseTitleDetailVO chooseTitleDetail(Long titleId);

    /**
     * 根据题目id确认学生选题
     * @param titleId
     * @return
     */
    String checkChooseTitle(Long titleId);

    /**
     * 根据题目id拒绝学生选题消息
     * @param titleId
     * @return
     */
    String refuseChooseTitle(Long titleId);

    /**
     * 根据教师userId获取选题学生列表
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    Map<String, Object> chooseStuVO(int page,int limit,Long userId);


    /**
     * 根据学生userId上传任务书
     * @param userId
     * @param taskName
     * @param taskPath
     * @return
     */
    boolean uploadTaskFiles(Long userId, String taskName, String taskPath,String schoolYear);

    /**
     * 根据学生userId获取过程文档
     * @param userId
     * @return
     */
    FilesVO getDocuments(Long userId);

    /**
     * 指导教师录入成绩
     * @param userId
     * @param guidanceScore
     * @param guidanceValue
     * @return
     */
    boolean inputGuidanceScore(Long userId,Float guidanceScore,String guidanceValue,String guidanceEditor,String guidanceSignature);

    /**
     * 按教师名查询开题答辩分组信息
     * @param openTeachs
     * @param schoolYear
     * @return
     */
    List<DefenceGroupVO> openDefenceGroup(String openTeachs,String schoolYear);

    /**
     * 按教师名查询答辩分组
     * @param defenceTeachs
     * @return
     */
    List<DefenceGroupVO> selectByTeachName(String defenceTeachs,String schoolYear);

    /**
     * 根据教师userId获取教师开题记录
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    Map<String, Object> teachTitleRecord(int page,int limit,Long userId);

    /**
     * 根据教师userId和年份查询教师开题列表
     * @param recordSearchDTO
     * @return
     */
    List<TeachTitleListVO> selectRecordByYear(RecordSearchDTO recordSearchDTO);

    /**
     * 根据学生userId获取学生个人成绩
     * @param userId
     * @return
     */
    Score getStuScore(Long userId);

    /**
     * 根据学生userId取消学生选题信息(教师已确认选题后再取消选题)
     * @param userId
     * @return
     */
    boolean cancelStuTitle(Long userId);

    /**
     * 根据学生userId审核开题报告
     * @param userId
     * @return
     */
    boolean checkStartFile(Long userId,String check,String startOpinion);

    /**
     * 根据学生userId审核个人中期检查
     * @param userId
     * @return
     */
    boolean checkMiddleFile(Long userId,String check,String middleOpinion);

    /**
     * 根据计划进度planID审核个人计划进度
     * @param planId
     * @param check
     * @param planOpinion
     * @return
     */
    boolean checkPlanFile(Long planId,String check,String planOpinion);


    /**
     * 根据指导记录guidanceID审核个人指导记录
     * @param guidanceId
     * @param check
     * @param guidanceOpinion
     * @return
     */
    boolean checkGuidanceFile(Long guidanceId,String check,String guidanceOpinion);

    /**
     * 根据学生userId审核个人外文译文
     * @param userId
     * @return
     */
    boolean checkTranslationFile(Long userId,String check,String translationOpinion);

    /**
     * 根据学生userId审核个人外文原文
     * @param userId
     * @return
     */
    boolean checkOriginalFile(Long userId,String check,String originalOpinion);

    /**
     * 根据学生userId审核个人文献综述
     * @param userId
     * @return
     */
    boolean checkLiteratureFile(Long userId,String check,String literatureOpinion);

    /**
     * 根据学生userId审核个人毕业论文
     * @param userId
     * @return
     */
    boolean checkThesisFile(Long userId,String check,String thesisOpinion);

    /**
     * 根据题目titleId判断题目是否有人选
     * @param titleId
     * @return
     */
    boolean ifSelectTitle(Long titleId);

    /**
     * 根据题目titleId删除题目
     * @param titleId
     * @return
     */
    boolean delTitle(Long titleId);

    /**
     * 根据学生userId获取个人上传进度计划
     * @param userId
     * @return
     */
    List<PlanListVO> getPlanList(Long userId);

    /**
     * 根据学生userId获取个人指导记录
     * @param userId
     * @return
     */
    List<GuidanceListVO> getGuidanceList(Long userId);

}
