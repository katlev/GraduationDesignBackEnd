package com.katle.design.service;

import com.katle.design.dto.TitleIdDTO;
import com.katle.design.vo.CheckTaskDetailVO;
import com.katle.design.vo.StuListVO;
import com.katle.design.vo.TaskListVO;
import com.katle.design.vo.TitleListVO;

import java.util.List;
import java.util.Map;

public interface ExpertService {

    /**
     * 根据教师userId获取个人审题列表
     * @param userId
     * @return
     */
    Map<String,Object> getCheckTitleList(int page,int limit,Long userId);

    /**
     * 根据教师user爱的获取个人审核任务书列表
     * @param userId
     * @return
     */
    Map<String,Object> getCheckTaskList(int page,int limit,Long userId);

    /**
     * 根据学生的userId审核任务书通过
     * @param titleIdDTO
     * @return
     */
    boolean checkTaskItem(TitleIdDTO titleIdDTO);

    /**
     * 根据学生的userId审核任务书回退
     * @param titleIdDTO
     * @return
     */
    boolean returnTaskItem(TitleIdDTO titleIdDTO);

    /**
     * 根据学生userId获取审核任务书的详细信息
     * @param userId
     * @return
     */
    CheckTaskDetailVO getCheckTaskDetail (Long userId);

    /**
     * 根据教师userId获取待评阅学生列表
     * @param userId
     * @return
     */
    Map<String,Object> getReviewStuList(int page,int limit,Long userId);

    /**
     * 根据学生UserId录入学生评阅成绩
     * @param userId
     * @param readScore
     * @param readValue
     * @param readEditor
     * @param readSignature
     * @return
     */
    boolean inputReviewScore(Long userId,Float readScore,String readValue,String readEditor,String readSignature);

    /**
     * 根据毕设答辩组Id获取答辩组学生名单
     * @param defenceId
     * @return
     */
    List<StuListVO> getDesignStuList(Long defenceId);

    /**
     * 根据学生userId录入学生答辩成绩
     * @param userId
     * @return
     */
    boolean inputDefenceScore(Long userId,Float defenceScore,String defenceValue,String defenceEditor,String defenceSignature);
}
