package com.katle.design.service;

import com.katle.design.dto.*;
import com.katle.design.entities.Semester;
import com.katle.design.entities.Titles;
import com.katle.design.entities.User;
import com.katle.design.vo.StuListVO;
import com.katle.design.vo.TeachListVO;
import com.katle.design.vo.TitleDetailVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdminService {
    /**
     * 教师账号添加
     * @param usernum
     * @return
     */
    boolean addTeachAccount(String usernum,String username,String password,String position,String college,String email,String schoolYear);

    /**
     *学生账号添加
     * @param usernum
     * @param username
     * @param password
     * @param grade
     * @param college
     * @param major
     * @return
     */
    boolean addStuAccount(String usernum,String username,String password,String grade,String college,String major,String schoolYear);

    /**
     * 修改学生账号信息
     * @param userId
     * @param usernum
     * @param username
     * @param password
     * @param grade
     * @param college
     * @param major
     * @return
     */
    User updateStuInfo(Long userId, String usernum, String username, String password, String grade, String college, String major);

    /**
     * 教师账号修改
     * @param userId
     * @param usernum
     * @param username
     * @param password
     * @param position
     * @param college
     * @param email
     * @return
     */
    User updateTeachInfo(Long userId, String usernum, String username, String password, String position, String college, String email);

    /**
     * 根据管理员userId获取相应学院学生列表
     * @param userId
     * @return
     */
    Map<String, Object> studentVoList(int page,int limit,Long userId,String schoolYear);

    /**
     * 根据管理员userId获取相应学院教师列表
     * @param userId
     * @return
     */
    Map<String,Object> teachVoList(int page,int limit,Long userId,String schoolYear);

    /**
     * 账号删除
     * @param userIdDTO
     * @return
     */
    boolean deleteStudent(UserIdDTO userIdDTO);

    /**
     * 学生账号查询
     * @param userId 管理员userId
     * @param page
     * @param limit
     * @param usernum
     * @param username
     * @param grade
     * @param major
     * @return
     */
    Map<String, Object> findStuVoList(int page,int limit,Long userId,String usernum,String username,String grade,String major,String schoolYear);

    /**
     * 教师账号查询
     * @param page
     * @param limit
     * @param usernum
     * @param username
     * @param position
     * @param userId 管理员userId
     * @param
     * @return
     */
    Map<String, Object> findTeachVoList(int page,int limit,Long userId,String usernum,String username,String position,String schoolYear);

    /**
     * 根据管理员userId获取相应学院开题列表
     * @param page
     * @param limit
     * @param userId 管理员userid
     * @return
     */
    Map<String, Object> getTitleVoList(int page,int limit,Long userId,String titleSemester);

    /**
     * 题目详情获取
     * @param topicId
     * @return
     */
    TitleDetailVO topicDetailVO(Long topicId);

    /**
     * 题目通过审核
     * @param titleIdDTO
     * @return
     */
    boolean updateCheckTitle(TitleIdDTO titleIdDTO);

    /**
     * 题目回退修改
     * @param titleIdDTO
     * @return
     */
    boolean updateReturnTitle(TitleIdDTO titleIdDTO);

    /**
     * 题目列表查询
     * @param page
     * @param limit
     * @param titleSearchDTO
     * @return
     */
    Map<String, Object> findTitleVoList(int page, int limit, TitleSearchDTO titleSearchDTO);

    /**
     * 学生成绩录入列表
     * @param page
     * @param limit
     * @param userId 管理员userId
     * @return
     */
    Map<String, Object> getScoreListVO(int page,int limit,Long userId,String schoolYear);

    /**
     * 查询答辩成绩列表
     * @param page
     * @param limit
     * @param usernum
     * @param userId 管理员userId
     * @return
     */
    Map<String, Object> findScoreListVO(int page,int limit,Long userId,String usernum);

    /**
     * 题目模糊查询
     * @param titleName
     * @return
     */
    List<Titles> getTitleByName(String titleName);

    /**
     * 创建毕设答辩分组
     * @param defenceName
     * @param defencePlace
     * @param defenceTime
     * @param defenceDate
     * @param defenceTeachs
     * @param defenceStudents
     * @param defenceLeader
     * @param defenceYear
     * @return
     */
    boolean addDefenceGroup(String defenceName, String defencePlace, Date defenceTime, Date defenceDate,String defenceTeachs,String defenceStudents,String defenceLeader,String defenceYear,Long adminId);

    /**
     * 答辩分组创建
     * @param defenceGroupDTO
     * @return
     */
    boolean insertDefence(DefenceGroupDTO defenceGroupDTO);

    /**
     * 获取当前学年答辩分组列表
     * @param page
     * @param limit
     * @return
     */
    Map<String, Object> getDefenceGroupVO(int page,int limit,String schoolYear,Long adminId);

    /**
     * 根据关键词查询毕设答辩
     * @param page
     * @param limit
     * @param schoolYear
     * @param searchValue
     * @return
     */
    Map<String, Object> searchDefence(int page,int limit,String schoolYear,Long adminId,String searchValue);
    /**
     * 根据管理员userId获取相应学院教师名字
     * @param userId
     * @return
     */
    List<TeachListVO> getTeachName(Long userId,String schoolYear);

    /**
     * 根据管理员userId获取相应学院学生名字
     * @param userId
     * @return
     */
    List<StuListVO> getStuName(Long userId,String schoolYear);

    /**
     * 获取年份信息
     * @return
     */
    List<Semester> getSemester();

    /**
     * 判断该学年是否已存在
     * @param semester
     * @return
     */
    boolean isSemester(String semester);

    /**
     * 添加学年
     * @return
     */
    boolean addSemester(String semesterValue);

    /**
     * 根据教师userId指定相应教师为评阅专家
     * @param userIdDTO
     * @return
     */
    boolean setExpert(UserIdDTO userIdDTO);

    /**
     * 根据题目id修改题目信息
     * @return
     */
    boolean updateTitles(UpdateTitleDetailDTO updateTitleDetailDTO);

    /**
     * 指定审题教师
     * @param idAndNameDTO
     * @return
     */
    boolean setTitleCheckMan(IdAndNameDTO idAndNameDTO);


}
