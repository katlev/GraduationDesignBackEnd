package com.katle.design.service.impl;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dao.*;
import com.katle.design.dto.TitleIdDTO;
import com.katle.design.entities.*;
import com.katle.design.service.ExpertService;
import com.katle.design.vo.CheckTaskDetailVO;
import com.katle.design.vo.StuListVO;
import com.katle.design.vo.TaskListVO;
import com.katle.design.vo.TitleListVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class ExpertServiceImpl implements ExpertService {
    @Resource
    private TitlesMapper titlesMapper;
    @Resource
    private TaskFileMapper taskFileMapper;
    @Resource
    private ChooseMapper chooseMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private StartFileMapper startFileMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private DefenceMapper defenceMapper;

    /**
     * 根据教师userId获取个人审题列表
     * @param userId
     * @return
     */
    @Override
    public Map<String,Object> getCheckTitleList(int page,int limit,Long userId) {

        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andTitleCheckmanEqualTo(userId);
        PageHelper.startPage(page,limit);
        List<Titles> titles = titlesMapper.selectByExample(titlesExample);

        List<TitleListVO> checkTitleList = new ArrayList<>();
        for(Titles item:titles){
            TitleListVO list = new TitleListVO();
            list.setTitleId(item.getTitleId());
            list.setTitleName(item.getTitleName());
            list.setTitleState(item.getTitleState());

            checkTitleList.add(list);
        }
        PageInfo pageInfoCheckTitle = new PageInfo(titles);
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfoCheckTitle",pageInfoCheckTitle);
        map.put("checkTitleList",checkTitleList);
        return map;
    }

    /**
     * 根据教师userId获取个人审核任务书列表
     * @param userId
     * @return
     */
    @Override
    public Map<String,Object> getCheckTaskList(int page,int limit,Long userId) {
        TaskFileExample taskFileExample = new TaskFileExample();
        TaskFileExample.Criteria criteria = taskFileExample.createCriteria();
        criteria.andTaskCheckmanEqualTo(userId);
        PageHelper.startPage(page,limit);
        List<TaskFile> tasks = taskFileMapper.selectByExample(taskFileExample);

        List<TaskListVO> checkTaskList = new ArrayList<>();

        for(TaskFile item:tasks){
            TaskListVO list = new TaskListVO();
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            list.setUserId(item.getUserId());
            list.setTitleId(titles.getTitleId());
            list.setTitleName(titles.getTitleName());
            list.setTaskName(item.getTaskName());
            list.setTaskPath(item.getTaskPath());
            list.setTaskCheck(item.getTaskCheck());
            checkTaskList.add(list);
        }
        PageInfo pageInfoCheckTask = new PageInfo(tasks);
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfoCheckTask",pageInfoCheckTask);
        map.put("checkTaskList",checkTaskList);
        return map;
    }

    /**
     * 根据学生userId审核通过所提交的任务书
     * @param titleIdDTO
     * @return
     */
    @Override
    public boolean checkTaskItem(TitleIdDTO titleIdDTO) {
        Long[] userId = titleIdDTO.getTitleId();
        for(Long id: userId){
            TaskFile taskFile = taskFileMapper.selectByPrimaryKey(id);
            taskFile.setTaskCheck(1);
            taskFileMapper.updateByPrimaryKeySelective(taskFile);
        }
        return true;
    }

    /**
     * 根据学生的userId审核回退学生所提交的任务书
     * @param titleIdDTO
     * @return
     */
    @Override
    public boolean returnTaskItem(TitleIdDTO titleIdDTO) {
        Long[] userId = titleIdDTO.getTitleId();
        for(Long id:userId){
            TaskFile taskFile = taskFileMapper.selectByPrimaryKey(id);
            taskFile.setTaskCheck(2);
            taskFileMapper.updateByPrimaryKeySelective(taskFile);
        }
        return true;
    }

    /**
     * 根据学生的userId获取审核任务书的详细信息
     * @param userId
     * @return
     */
    @Override
    public CheckTaskDetailVO getCheckTaskDetail(Long userId) {
        TaskFile taskFile = taskFileMapper.selectByPrimaryKey(userId);
        Choose choose = chooseMapper.selectByPrimaryKey(userId);
        Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
        User teach = userMapper.selectByPrimaryKey(titles.getUserId());
        User stu = userMapper.selectByPrimaryKey(userId);

        CheckTaskDetailVO item = new CheckTaskDetailVO();
        item.setTitleId(titles.getTitleId());
        item.setUserId(titles.getUserId());
        item.setUserName(teach.getUsername());
        item.setPosition(teach.getPosition());
        item.setTitleName(titles.getTitleName());
        item.setTitleKind(titles.getTitleKind());
        item.setTitleSource(titles.getTitleSource());
        item.setTitleValue(titles.getTitleValue());
        item.setStuNum(stu.getUsernum());
        item.setStuName(stu.getUsername());
        item.setMajor(stu.getMajor());
        item.setTaskName(taskFile.getTaskName());
        item.setTaskPath(taskFile.getTaskPath());
        item.setTaskCheck(taskFile.getTaskCheck());

        return item;
    }

    /**
     * 根据教师userId获取待评阅学生列表
     * @param userId
     * @return
     */
    @Override
    public Map<String,Object> getReviewStuList(int page,int limit,Long userId) {
       StartFileExample startFileExample = new StartFileExample();
       StartFileExample.Criteria criteria = startFileExample.createCriteria();
       criteria.andStartCheckmanEqualTo(userId);
       PageHelper.startPage(page,limit);
       List<StartFile> startFileList = startFileMapper.selectByExample(startFileExample);
       List<StuListVO> reviewStuLists = new ArrayList<>();

       for(StartFile item: startFileList){
           User user = userMapper.selectByPrimaryKey(item.getUserId());
           Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
           Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
           StuListVO list = new StuListVO();

           list.setUserId(user.getUserId());
           list.setTitleId(titles.getTitleId());
           list.setUsernum(user.getUsernum());
           list.setUsername(user.getUsername());
           list.setAvatar(user.getAvatar());
           reviewStuLists.add(list);

       }
       PageInfo pageInfoReviewStu = new PageInfo(startFileList);
       Map<String,Object> map = new HashMap<>();
       map.put("pageInfoReviewStu",pageInfoReviewStu);
       map.put("reviewStuLists",reviewStuLists);
       return map;
    }

    /**
     * 根据学生userId录入学生评阅成绩
     * @param userId
     * @param readScore
     * @param readValue
     * @param readEditor
     * @param readSignature
     * @return
     */
    @Override
    public boolean inputReviewScore(Long userId, Float readScore, String readValue, String readEditor, String readSignature) {
        Score score = scoreMapper.selectByPrimaryKey(userId);

        score.setReadScore(readScore);
        score.setReadValue(readValue);
        score.setReadEditor(readEditor);
        score.setReadSignature(readSignature);
        if(score.getGuidanceScore() != null && score.getDefenceScore() != null){
            float a = 0.4f;
            float b = 0.6f;
            float defence = score.getDefenceScore();
            float guidance = score.getGuidanceScore();
            float sum = a * guidance + b * defence;
            LOGGER.info("sum=" + sum);
            score.setTotal(sum);
        }
        return scoreMapper.updateByPrimaryKeySelective(score)>0;
    }

    /**
     *  根据答辩组id获取该答辩组分组学生名单
     * @param defenceId
     * @return
     */
    @Override
    public List<StuListVO> getDesignStuList(Long defenceId) {
        Defence defence = defenceMapper.selectByPrimaryKey(defenceId);
        String stuList = defence.getDefenceStudents();
        String[] stuListArr = stuList.split(" ");
        LOGGER.info(stuList);
        List<StuListVO> defenceStuList = new ArrayList<>();
        for(String item: stuListArr){
            String value = "";
            if(item.equals(value)){
                continue;
            }
            LOGGER.info(item);
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUsernameEqualTo(item);
            User user = userMapper.selectByExample(userExample).get(0);

            Choose choose = chooseMapper.selectByPrimaryKey(user.getUserId());
            if(choose == null){
                continue;
            }
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            Score score = scoreMapper.selectByPrimaryKey(choose.getUserId());
            StuListVO list = new StuListVO();

            list.setUserId(user.getUserId());
            list.setUsernum(user.getUsernum());
            list.setUsername(user.getUsername());
            list.setAvatar(user.getAvatar());
            list.setTitleId(titles.getTitleId());
            list.setTitleName(titles.getTitleName());
            list.setDefenceScore(score.getDefenceScore());

            defenceStuList.add(list);
        }

        return defenceStuList;
    }

    /**
     * 根据学生userId录入学生答辩成绩
     * @param userId
     * @return
     */
    @Override
    public boolean inputDefenceScore(Long userId, Float defenceScore, String defenceValue, String defenceEditor, String defenceSignature) {
        Score score = scoreMapper.selectByPrimaryKey(userId);
        score.setDefenceScore(defenceScore);
        score.setDefenceValue(defenceValue);
        score.setDefenceEditor(defenceEditor);
        score.setDefenceSignature(defenceSignature);
        if(score.getReadScore() != null && score.getGuidanceScore() != null){
            float a = 0.4f;
            float b = 0.6f;
            float guidance = score.getGuidanceScore();
            float sum = a * guidance + b * defenceScore;
            LOGGER.info("sum=" + sum);
            score.setTotal(sum);
        }
        return scoreMapper.updateByPrimaryKeySelective(score)>0;
    }
}
