package com.katle.design.service;

import com.katle.design.dto.DefenceGroupDTO;
import com.katle.design.dto.IdAndNameDTO;
import com.katle.design.entities.OpenDefence;
import com.katle.design.vo.TeachListVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProcessDocService {

    /**
     * 根据管理员userId获取相应学院的学生任务书，根据设置的学年获取该学年的任务书
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String,Object> getTaskList(int page, int limit, Long userId, String schoolYear);

    /**
     * 根据任务书状态查询
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String,Object> searchTaskList(int page,int limit,Long userId,String schoolYear,String taskCheck);

    /**
     * 指定任务书的审核教师
     * @param idAndNameDTO
     * @return
     */
    boolean setTaskCheckMan(IdAndNameDTO idAndNameDTO);

    /**
     * 审核任务书
     * @param userId
     * @param checkValue
     * @return
     */
    boolean checkTaskFile(Long userId,String checkValue);

    /**
     * 获取答辩分组列表
     * @param page
     * @param limit
     * @param schoolYear
     * @return
     */
    Map<String,Object> getOpenList(int page,int limit,String schoolYear,Long adminId);

    /**
     * 根据关键字查询开题答辩分组
     * @param page
     * @param limit
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String,Object> searchOpenList(int page,int limit,String schoolYear,Long adminId,String searchValue);

    /**
     * 创建开题答辩分组
     * @param openName
     * @param openPlace
     * @param openDate
     * @param openTime
     * @param openTeachs
     * @param openStudents
     * @param openLeader
     * @param openYear
     * @return
     */
    boolean insertOpenDefence(String openName, String openPlace, Date openDate, Date openTime, String openTeachs, String openStudents,String openLeader,String openYear,Long adminId);

    /**
     * 添加开题答辩分组
     * @param defenceGroupDTO
     * @return
     */
    boolean addOpenDefence(DefenceGroupDTO defenceGroupDTO);

    /**
     * 判断是否有同名分组
     * @param openName
     * @return
     */
    OpenDefence findOpenByOpenName(String openName);

    /**
     * 修改答辩分组信息
     * @param openName
     * @param openPlace
     * @param openDate
     * @param openTime
     * @param openTeachs
     * @param openStudents
     * @param openLeader
     * @param openYear
     * @return
     */
    boolean updateOpenDefence(Long openId,String openName,String openPlace,Date openDate,Date openTime,String openTeachs,String openStudents,String openLeader,String openYear);

    /**
     * 根据管理员id获取相应学院当前学年的开题报告列表
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String,Object> startFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键字查询开题报告
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String,Object> searchStartFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据管理员userId获取当前学年的中期检查
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String, Object> middleFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键词查找开题报告
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchMiddleFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据管理员id获取当前年份外文译文报告
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String, Object> translationFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键字查找开题报告
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchTranslationFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据管理员userId获取当前年份外文原文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String, Object> originalFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键字查询外文原文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchOriginalFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据管理员userId获取当前年份的文献综述
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String, Object> literatureFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键字查询文献综述
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchLiteratureFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据管理员userId获取当前年份毕业论文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String, Object> thesisFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键词查询毕业论文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchThesisFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据管理员userId获取当前学年的指导记录
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String, Object> guidanceFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键字查询指导记录
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchGuidanceFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据管理员id获取当前学年进度计划
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    Map<String, Object> planFileList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键词查询进度计划
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchPlanFile(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 根据学生userId获取学生提交的指导记录
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    Map<String, Object> guiDetailList(int page,int limit,Long userId);

    /**
     * 根据学生userId获取学生提交的指进度计划
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    Map<String, Object> planDetailList(int page,int limit,Long userId);

    /**
     * 获取选题学生列表
     * @param page
     * @param limit
     * @param
     * @return
     */
    Map<String,Object> getChooseTitleList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据关键词：学生学号，姓名查询选题情况
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchChooseTitle(int page,int limit,Long userId,String schoolYear,String searchValue);

    /**
     * 为评阅专家分配评阅学生
     * @param
     * @return
     */
    boolean setStuToExpert(IdAndNameDTO idAndNameDTO);

    /**
     * 根据管理员id获取当前学年同一学院评阅专家
     * @param userId
     * @param schoolYear
     * @return
     */
    List<TeachListVO> getExpertList(Long userId, String schoolYear);

    /**
     * 导出分数表
     * @return
     */
    XSSFWorkbook exportScore();
}
