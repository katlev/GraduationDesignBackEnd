package com.katle.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dao.*;
import com.katle.design.dto.AddTitleDTO;
import com.katle.design.dto.DefenceGroupDTO;
import com.katle.design.dto.RecordSearchDTO;
import com.katle.design.entities.*;
import com.katle.design.service.TeacherService;
import com.katle.design.vo.*;
import javafx.scene.control.TitledPane;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.*;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private TitlesMapper titlesMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private ChooseMapper chooseMapper;
    @Resource
    private DefenceMapper defenceMapper;
    @Resource
    private TaskFileMapper taskFileMapper;
    @Resource
    private StartFileMapper startFileMapper;
    @Resource
    private MiddleFileMapper middleFileMapper;
    @Resource
    private PlanFileMapper planFileMapper;
    @Resource
    private GuidanceFileMapper guidanceFileMapper;
    @Resource
    private TranslationFileMapper translationFileMapper;
    @Resource
    private OriginalFileMapper originalFileMapper;
    @Resource
    private LiteratureFileMapper literatureFileMapper;
    @Resource
    private ThesisFileMapper thesisFileMapper;
    @Resource
    private OpenDefenceMapper openDefenceMapper;

    /**
     * 根据教师userId确定教师开题列表
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getTeachTitleVO(int page, int limit, Long userId) {
        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        PageHelper.startPage(page,limit);
        List<Titles> titlesList = titlesMapper.selectByExample(titlesExample);

        List<TeachTitleListVO> teachTitleVO = new ArrayList<>();
        for(Titles titles:titlesList){
            TeachTitleListVO titleVO = new TeachTitleListVO();
            titleVO.setTitleId(titles.getTitleId());
            titleVO.setUserId(titles.getUserId());
            titleVO.setTitleName(titles.getTitleName());
            titleVO.setTitleState(titles.getTitleState());
            teachTitleVO.add(titleVO);
        }
        PageInfo pageInfoTeach = new PageInfo<>(titlesList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoTeach",pageInfoTeach);
        map.put("teachTitleVO",teachTitleVO);
        return map;
    }

    /**
     * 题目表添加
     * @param addTitleDTO
     * @return
     */
    @Override
    public boolean addTitle(AddTitleDTO addTitleDTO) {
        Date date = new Date();
        User user = userMapper.selectByPrimaryKey(addTitleDTO.getUserId());
        Titles titles = new Titles();
        titles.setUserId(addTitleDTO.getUserId());
        titles.setUserName(user.getUsername());
        titles.setTitleName(addTitleDTO.getTitleName());
        titles.setTitleKind(addTitleDTO.getTitleKind());
        titles.setTitleSource(addTitleDTO.getTitleSource());
        titles.setTitleModel(addTitleDTO.getTitleModel());
        titles.setTitleYear(date);
        titles.setTitleType(addTitleDTO.getTitleType());
        titles.setTitleComplete(addTitleDTO.getTitleComplete());
        titles.setTitleValue(addTitleDTO.getTitleValue());
        titles.setTitleRequire(addTitleDTO.getTitleRequire());
        titles.setTitleResult(addTitleDTO.getTitleResult());
        titles.setTitleState("待审核");
        titles.setTitleMajor(addTitleDTO.getTitleMajor());
        titles.setTitleSelect(false);
        titles.setTitleSemester(addTitleDTO.getTitleSemester());

        return titlesMapper.insertSelective(titles)>0;
    }

    /**
     * 根据userId判断教师开题数量
     * @param userId
     * @return
     */
    @Override
    public int titlesNumber(Long userId) {
        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Titles> titlesList = titlesMapper.selectByExample(titlesExample);
        List<Long> arr = new ArrayList<>();
        for(Titles title:titlesList){
            arr.add(title.getTitleId());
        }
        return arr.size();
    }

    /**
     * 根据教师userid获取选题消息
     * @param page
     * @param limit
     * @param userId 教师id
     * @return
     */
    @Override
    public Map<String, Object> chooseTitleVO(int page, int limit, Long userId) {

        ChooseExample chooseExample = new ChooseExample();
        PageHelper.startPage(page,limit);
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);
        List<ChooseTitleVO> chooseTitleVO = new ArrayList<>();

        for(Choose choose:chooseList){
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            User user = userMapper.selectByPrimaryKey(choose.getUserId());
            ChooseTitleVO chooseVO = new ChooseTitleVO();
            if(titles.getUserId().equals(userId)){
                chooseVO.setUserId(choose.getUserId());
                chooseVO.setTitleId(choose.getTitleId());
                chooseVO.setTitleName(titles.getTitleName());
                chooseVO.setUsernum(user.getUsernum());
                chooseVO.setUsername(user.getUsername());
                chooseVO.setState(choose.getState());
                chooseVO.setAvatar(user.getAvatar());

                chooseTitleVO.add(chooseVO);
            }
        }
        PageInfo pageInfoChoose = new PageInfo(chooseList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoChoose",pageInfoChoose);
        map.put("chooseTitleVO",chooseTitleVO);
        return map;
    }

    /**
     * 根据题目id获取选择信息详情
     * @param titleId
     * @return
     */
    @Override
    public ChooseTitleDetailVO chooseTitleDetail(Long titleId) {
        Titles titles = titlesMapper.selectByPrimaryKey(titleId);

        ChooseExample chooseExample = new ChooseExample();
        ChooseExample.Criteria criteria = chooseExample.createCriteria();
        criteria.andTitleIdEqualTo(titleId);
        Choose choose = chooseMapper.selectByExample(chooseExample).get(0);

        User user = userMapper.selectByPrimaryKey(choose.getUserId());

        ChooseTitleDetailVO chooseTitleDetailVO = new ChooseTitleDetailVO();
        chooseTitleDetailVO.setUserId(choose.getUserId());
        chooseTitleDetailVO.setTitleId(titles.getTitleId());
        chooseTitleDetailVO.setTitleName(titles.getTitleName());
        chooseTitleDetailVO.setTitleKind(titles.getTitleKind());
        chooseTitleDetailVO.setTitleModel(titles.getTitleModel());
        chooseTitleDetailVO.setTitleMajor(titles.getTitleMajor());
        chooseTitleDetailVO.setTitleType(titles.getTitleType());
        chooseTitleDetailVO.setTitleComplete(titles.getTitleComplete());
        chooseTitleDetailVO.setTitleValue(titles.getTitleValue());
        chooseTitleDetailVO.setTitleRequire(titles.getTitleRequire());
        chooseTitleDetailVO.setTitleResult(titles.getTitleResult());
        chooseTitleDetailVO.setUsernum(user.getUsernum());
        chooseTitleDetailVO.setUsername(user.getUsername());
        chooseTitleDetailVO.setCollege(user.getCollege());
        chooseTitleDetailVO.setMajor(user.getMajor());
        chooseTitleDetailVO.setGrade(user.getGrade());
        chooseTitleDetailVO.setState(choose.getState());
        chooseTitleDetailVO.setAvatar(user.getAvatar());

        return chooseTitleDetailVO;
    }

    /**
     * 根据题目id确认学生选题
     * @param titleId
     * @return
     */
    @Override
    public String checkChooseTitle(Long titleId) {
        ChooseExample chooseExample = new ChooseExample();
        ChooseExample.Criteria criteria = chooseExample.createCriteria();
        criteria.andTitleIdEqualTo(titleId);
        Choose choose = chooseMapper.selectByExample(chooseExample).get(0);
        String value = "待确认";
        if(choose.getState().equals(value)){
            choose.setState("教师已确认");
            chooseMapper.updateByPrimaryKeySelective(choose);

            Score score = new Score();
            score.setUserId(choose.getUserId());
            scoreMapper.insertSelective(score);

            TaskFile taskFile = new TaskFile();
            taskFile.setUserId(choose.getUserId());
            taskFile.setTaskCheck(0);
            taskFileMapper.insert(taskFile);

            StartFile startFile = new StartFile();
            startFile.setUserId(choose.getUserId());
            startFile.setStartCheck(0);
            startFileMapper.insert(startFile);

            MiddleFile middleFile = new MiddleFile();
            middleFile.setUserid(choose.getUserId());
            middleFile.setMiddleCheck(0);
            middleFileMapper.insert(middleFile);

            PlanFile planFile = new PlanFile();
            planFile.setUserId(choose.getUserId());
            planFile.setPlanCheck(0);
            planFileMapper.insert(planFile);

            GuidanceFile guidanceFile = new GuidanceFile();
            guidanceFile.setUserId(choose.getUserId());
            guidanceFile.setGuidanceCheck(0);
            guidanceFileMapper.insert(guidanceFile);

            TranslationFile translationFile = new TranslationFile();
            translationFile.setUserId(choose.getUserId());
            translationFile.setTranslationCheck(0);
            translationFileMapper.insert(translationFile);

            OriginalFile originalFile = new OriginalFile();
            originalFile.setUserId(choose.getUserId());
            originalFile.setOriginalCheck(0);
            originalFileMapper.insert(originalFile);

            LiteratureFile literatureFile = new LiteratureFile();
            literatureFile.setUserId(choose.getUserId());
            literatureFile.setLiteratureCheck(0);
            literatureFileMapper.insert(literatureFile);

            ThesisFile thesisFile = new ThesisFile();
            thesisFile.setUserId(choose.getUserId());
            thesisFile.setThesisCheck(0);
            thesisFileMapper.insert(thesisFile);

        }else{
            return "请勿重复操作";
        }
        return "教师已确认";
    }

    /**
     * 根据题目id拒绝学生选题消息
     * @param titleId
     * @return
     */
    @Override
    public String refuseChooseTitle(Long titleId) {
        ChooseExample chooseExample = new ChooseExample();
        ChooseExample.Criteria criteria = chooseExample.createCriteria();
        criteria.andTitleIdEqualTo(titleId);
        Choose choose = chooseMapper.selectByExample(chooseExample).get(0);
        String value = "待确认";
        if(choose.getState().equals(value)){
            /*choose.setState("教师已拒绝");
            chooseMapper.updateByPrimaryKeySelective(choose);*/
            chooseMapper.deleteByPrimaryKey(choose.getUserId());
            Titles title = titlesMapper.selectByPrimaryKey(titleId);
            title.setTitleSelect(false);
            titlesMapper.updateByPrimaryKeySelective(title);

        }else{
            return "请勿重复操作";
        }
        return "教师已拒绝";
    }

    /**
     * 根据教师userId获取选题学生列表
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> chooseStuVO(int page, int limit, Long userId) {

        ChooseExample chooseExample = new ChooseExample();
        PageHelper.startPage(page,limit);
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);
        List<ChooseTitleVO> chooseStuVO = new ArrayList<>();

        for(Choose choose:chooseList){
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            User user = userMapper.selectByPrimaryKey(choose.getUserId());
            ChooseTitleVO chooseVO = new ChooseTitleVO();
            String value = "教师已确认";
            if(titles.getUserId().equals(userId) && choose.getState().equals(value)){
                chooseVO.setUserId(choose.getUserId());
                chooseVO.setTitleId(choose.getTitleId());
                chooseVO.setUsernum(user.getUsernum());
                chooseVO.setUsername(user.getUsername());
                chooseVO.setTitleName(titles.getTitleName());
                chooseVO.setAvatar(user.getAvatar());
                chooseVO.setState(choose.getState());
                chooseStuVO.add(chooseVO);
            }
        }
        PageInfo pageInfoStu = new PageInfo<>(chooseList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoStu",pageInfoStu);
        map.put("chooseStuVO",chooseStuVO);
        return map;
    }

    /**
     * 根据学生userId上传任务书
     * @param userId
     * @param taskName
     * @param taskPath
     * @return
     */
    @Override
    public boolean uploadTaskFiles(Long userId, String taskName, String taskPath,String schoolYear) {
        TaskFile taskFile = taskFileMapper.selectByPrimaryKey(userId);
        taskFile.setTaskName(taskName);
        taskFile.setTaskPath(taskPath);
        taskFile.setTaskYear(schoolYear);
        return taskFileMapper.updateByPrimaryKeySelective(taskFile)>0;
    }

    /**
     * 根据学生userId获取过程文档
     * @param userId
     * @return
     */
    @Override
    public FilesVO getDocuments(Long userId) {
        TaskFile taskFile = taskFileMapper.selectByPrimaryKey(userId);
        StartFile startFile = startFileMapper.selectByPrimaryKey(userId);
        MiddleFile middleFile = middleFileMapper.selectByPrimaryKey(userId);
        TranslationFile translationFile = translationFileMapper.selectByPrimaryKey(userId);
        OriginalFile originalFile = originalFileMapper.selectByPrimaryKey(userId);
        LiteratureFile literatureFile = literatureFileMapper.selectByPrimaryKey(userId);
        ThesisFile thesisFile = thesisFileMapper.selectByPrimaryKey(userId);

        PlanFileExample planFileExample = new PlanFileExample();
        PlanFileExample.Criteria criteria = planFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<PlanFile> planFileList = planFileMapper.selectByExample(planFileExample);
        PlanFile planFile = planFileList.get(planFileList.size()-1);

        GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
        GuidanceFileExample.Criteria criteria1 = guidanceFileExample.createCriteria();
        criteria1.andUserIdEqualTo(userId);
        List<GuidanceFile> guidanceFileList = guidanceFileMapper.selectByExample(guidanceFileExample);
        GuidanceFile guidanceFile = guidanceFileList.get(guidanceFileList.size()-1);

        FilesVO filesVO = new FilesVO();

        filesVO.setUserId(userId);
        filesVO.setTaskName(taskFile.getTaskName());
        filesVO.setTaskPath(taskFile.getTaskPath());
        filesVO.setTaskCheck(taskFile.getTaskCheck());
        filesVO.setStartName(startFile.getStartName());
        filesVO.setStartPath(startFile.getStartPath());
        filesVO.setStartCheck(startFile.getStartCheck());
        filesVO.setMiddleName(middleFile.getMiddleName());
        filesVO.setMiddlePath(middleFile.getMiddlePath());
        filesVO.setMiddleCheck(middleFile.getMiddleCheck());
        filesVO.setPlanStart(planFile.getPlanStart());
        filesVO.setPlanEnd(planFile.getPlanEnd());
        filesVO.setPlanCheck(planFile.getPlanCheck());
        filesVO.setGuidanceDate(guidanceFile.getGuidanceDate());
        filesVO.setGuidanceCheck(guidanceFile.getGuidanceCheck());
        filesVO.setTranslationName(translationFile.getTranslationName());
        filesVO.setTranslationPath(translationFile.getTranslationPath());
        filesVO.setTranslationCheck(translationFile.getTranslationCheck());
        filesVO.setOriginalName(originalFile.getOriginalName());
        filesVO.setOriginalPath(originalFile.getOriginalPath());
        filesVO.setOriginalCheck(originalFile.getOriginalCheck());
        filesVO.setLiteratureName(literatureFile.getLiteratureName());
        filesVO.setLiteraturePath(literatureFile.getLiteraturePath());
        filesVO.setLiteratureCheck(literatureFile.getLiteratureCheck());
        filesVO.setThesisName(thesisFile.getThesisName());
        filesVO.setThesisPath(thesisFile.getThesisPath());
        filesVO.setThesisCheck(thesisFile.getThesisCheck());

        return filesVO;

    }

    /**
     * 根据学生userId录入学生指导成绩
     * @param userId
     * @param guidanceScore
     * @param guidanceValue
     * @param guidanceEditor
     * @param guidanceSignature
     * @return
     */
    @Override
    public boolean inputGuidanceScore(Long userId, Float guidanceScore, String guidanceValue, String guidanceEditor, String guidanceSignature) {
        Score score = scoreMapper.selectByPrimaryKey(userId);
        score.setGuidanceScore(guidanceScore);
        score.setGuidanceEditor(guidanceEditor);
        score.setGuidancdValue(guidanceValue);
        score.setGuidanceSignature(guidanceSignature);

        if(score.getReadScore() != null && score.getDefenceScore() != null){
            float a = 0.4f;
            float b = 0.6f;
            float defence = score.getDefenceScore();
            float sum = a * guidanceScore + b * defence;
            LOGGER.info("sum=" + sum);
            score.setTotal(sum);
        }

        return scoreMapper.updateByPrimaryKeySelective(score)>0;
    }

    /**
     * 按教师名查询开题答辩分组信息
     * @param openTeachs
     * @param schoolYear
     * @return
     */
    @Override
    public List<DefenceGroupVO> openDefenceGroup(String openTeachs, String schoolYear) {
        OpenDefenceExample openDefenceExample = new OpenDefenceExample();
        OpenDefenceExample.Criteria criteria = openDefenceExample.createCriteria();
        criteria.andOpenYearEqualTo(schoolYear);
        criteria.andOpenTeachsLike("%"+openTeachs+"%");
        List<OpenDefence> openList = openDefenceMapper.selectByExample(openDefenceExample);
        List<DefenceGroupVO> openListVO = new ArrayList<>();

        for(OpenDefence item:openList){
            DefenceGroupVO group = new DefenceGroupVO();
            group.setDefenceId(item.getOpenId());
            group.setDefenceName(item.getOpenName());
            group.setDefencePlace(item.getOpenPlace());
            group.setDefenceDate(item.getOpenDate());
            group.setDefenceTime(item.getOpenTime());
            group.setDefenceTeachs(item.getOpenTeachs());
            group.setDefenceStudents(item.getOpenStudents());
            group.setDefenceLeader(item.getOpenLeader());
            openListVO.add(group);
        }
        return openListVO;
    }

    /**
     * 按教师名查询毕设答辩分组情况
     * @param defenceTeachs
     * @return
     */
    @Override
    public List<DefenceGroupVO> selectByTeachName(String defenceTeachs,String schoolYear) {
        DefenceExample defenceExample = new DefenceExample();
        DefenceExample.Criteria criteria = defenceExample.createCriteria();
        criteria.andDefenceYearEqualTo(schoolYear);
        criteria.andDefenceTeachsLike("%"+defenceTeachs+"%");
        List<DefenceGroupVO> defenceGroupVO = new ArrayList<>();
        List<Defence> defences = defenceMapper.selectByExample(defenceExample);
        for(Defence defence:defences){
            DefenceGroupVO defenceGroup = new DefenceGroupVO();
            defenceGroup.setDefenceId(defence.getDefenceId());
            defenceGroup.setDefenceName(defence.getDefenceName());
            defenceGroup.setDefencePlace(defence.getDefencePlace());
            defenceGroup.setDefenceDate(defence.getDefenceDate());
            defenceGroup.setDefenceTime(defence.getDefenceTime());
            defenceGroup.setDefenceTeachs(defence.getDefenceTeachs());
            defenceGroup.setDefenceStudents(defence.getDefenceStudents());
            defenceGroup.setDefenceLeader(defence.getDefenceLeader());
            defenceGroupVO.add(defenceGroup);
        }
        return defenceGroupVO;
    }

    /**
     * 根据教师UserId获取教师开题记录
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> teachTitleRecord(int page, int limit, Long userId) {

        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        PageHelper.startPage(page,limit);
        List<Titles> titlesList = titlesMapper.selectByExample(titlesExample);

        List<TeachTitleListVO> teachTitleRecordVO = new ArrayList<>();
        for(Titles titles:titlesList){
            TeachTitleListVO titleVO = new TeachTitleListVO();
            String value = "审核通过";
            if(titles.getTitleState().equals(value)){
                titleVO.setTitleId(titles.getTitleId());
                titleVO.setUserId(titles.getUserId());
                titleVO.setTitleName(titles.getTitleName());
                titleVO.setTitleState(titles.getTitleState());
                teachTitleRecordVO.add(titleVO);
            }
        }
        PageInfo pageInfoRecord = new PageInfo<>(titlesList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoRecord",pageInfoRecord);
        map.put("teachTitleRecordVO",teachTitleRecordVO);
        return map;
    }

    /**
     * 根据年份查询教师开题记录
     * @param recordSearchDTO
     * @return
     */
    @Override
    public List<TeachTitleListVO> selectRecordByYear(RecordSearchDTO recordSearchDTO) {
        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andUserIdEqualTo(recordSearchDTO.getUserId());
        criteria.andTitleYearEqualTo(recordSearchDTO.getTitleYear());
        List<Titles> titleRecord = titlesMapper.selectByExample(titlesExample);
        List<TeachTitleListVO> searchRecordVO = new ArrayList<>();
        for(Titles title:titleRecord){
            TeachTitleListVO searchVO = new TeachTitleListVO();
            searchVO.setUserId(title.getUserId());
            searchVO.setTitleId(title.getTitleId());
            searchVO.setTitleName(title.getTitleName());
            searchVO.setTitleState(title.getTitleState());
            searchRecordVO.add(searchVO);
        }

        return searchRecordVO;
    }

    /**
     * 根据学生userId获取学生个人成绩
     * @param userId
     * @return
     */
    @Override
    public Score getStuScore(Long userId) {
        Score score = scoreMapper.selectByPrimaryKey(userId);
        return score;
    }

    /**
     * 根据学生userId取消学生选题信息，在教师已确认学生选题后
     * @param userId
     * @return
     */
    @Override
    public boolean cancelStuTitle(Long userId) {
        try {
            Choose choose = chooseMapper.selectByPrimaryKey(userId);

            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            titles.setTitleSelect(false);
            titlesMapper.updateByPrimaryKeySelective(titles);

            chooseMapper.deleteByPrimaryKey(userId);
            scoreMapper.deleteByPrimaryKey(userId);
            taskFileMapper.deleteByPrimaryKey(userId);
            startFileMapper.deleteByPrimaryKey(userId);
            middleFileMapper.deleteByPrimaryKey(userId);
            translationFileMapper.deleteByPrimaryKey(userId);
            originalFileMapper.deleteByPrimaryKey(userId);
            literatureFileMapper.deleteByPrimaryKey(userId);
            thesisFileMapper.deleteByPrimaryKey(userId);

            PlanFileExample planFileExample = new PlanFileExample();
            PlanFileExample.Criteria criteria = planFileExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            planFileMapper.deleteByExample(planFileExample);

            GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
            GuidanceFileExample.Criteria criteria1 =guidanceFileExample.createCriteria();
            criteria1.andUserIdEqualTo(userId);
            return guidanceFileMapper.deleteByExample(guidanceFileExample)>0;


        }catch (Exception e){
            return false;
        }
    }

    /**
     * 根据学生userId审核个人开题报告
     * @param userId
     * @return
     */
    @Override
    public boolean checkStartFile(Long userId,String check,String startOpinion) {
        StartFile startFile = startFileMapper.selectByPrimaryKey(userId);
        if(check.equals("true")){
            startFile.setStartCheck(1);
        }else if(check.equals("false")){
            startFile.setStartCheck(2);
        }
        startFile.setStartOpinion(startOpinion);
        return startFileMapper.updateByPrimaryKeySelective(startFile)>0;
    }

    /**
     * 根据学生userId审核个人中期检查
     * @param userId
     * @return
     */
    @Override
    public boolean checkMiddleFile(Long userId,String check,String middleOpinion) {
        MiddleFile middleFile = middleFileMapper.selectByPrimaryKey(userId);
        if(check.equals("true")){
            middleFile.setMiddleCheck(1);
        }else if(check.equals("false")){
            middleFile.setMiddleCheck(2);
        }
        middleFile.setMiddleOpinion(middleOpinion);
        return middleFileMapper.updateByPrimaryKeySelective(middleFile)>0;
    }

    /**
     * 根据计划进度planID审核个人计划进度
     * @param planId
     * @param check
     * @param planOpinion
     * @return
     */
    @Override
    public boolean checkPlanFile(Long planId,String check,String planOpinion) {
       PlanFile planFile = planFileMapper.selectByPrimaryKey(planId);
       if(check.equals("true")){
           planFile.setPlanCheck(1);
       }else if(check.equals("false")){
           planFile.setPlanCheck(2);
       }

       planFile.setPlanOpinion(planOpinion);
       return planFileMapper.updateByPrimaryKeySelective(planFile)>0;
    }

    /**
     * 根据指导记录guidanceID审核个人指导记录
     * @param guidanceId
     * @param check
     * @param guidanceOpinion
     * @return
     */
    @Override
    public boolean checkGuidanceFile(Long guidanceId,String check,String guidanceOpinion) {
        GuidanceFile guidanceFile = guidanceFileMapper.selectByPrimaryKey(guidanceId);
        if(check.equals("true")){
            guidanceFile.setGuidanceCheck(1);
        }else if(check.equals("false")){
            guidanceFile.setGuidanceCheck(2);
        }
        guidanceFile.setGuidanceOpinion(guidanceOpinion);
        return guidanceFileMapper.updateByPrimaryKeySelective(guidanceFile)>0;
    }

    /**
     * 根据学生userId审核个人外文译文
     * @param userId
     * @return
     */
    @Override
    public boolean checkTranslationFile(Long userId,String check,String translationOpinion) {
        TranslationFile translationFile = translationFileMapper.selectByPrimaryKey(userId);
        if(check.equals("true")){
            translationFile.setTranslationCheck(1);
        }else if(check.equals("false")){
            translationFile.setTranslationCheck(2);
        }
        translationFile.setTranslationOpinion(translationOpinion);
        return translationFileMapper.updateByPrimaryKeySelective(translationFile)>0;
    }

    /**
     * 根据学生userId审核个人外文原文
     * @param userId
     * @return
     */
    @Override
    public boolean checkOriginalFile(Long userId,String check,String originalOpinion) {
        OriginalFile originalFile = originalFileMapper.selectByPrimaryKey(userId);
        if(check.equals("true")){
            originalFile.setOriginalCheck(1);
        }else if(check.equals("false")){
            originalFile.setOriginalCheck(2);
        }
        originalFile.setOriginalOpinion(originalOpinion);
        return originalFileMapper.updateByPrimaryKeySelective(originalFile)>0;

    }

    /**
     * 根据学生userId审核个人文献综述
     * @param userId
     * @return
     */
    @Override
    public boolean checkLiteratureFile(Long userId,String check,String literatureOpinion) {
        LiteratureFile literatureFile = literatureFileMapper.selectByPrimaryKey(userId);
        if(check.equals("true")){
            literatureFile.setLiteratureCheck(1);
        }else if(check.equals("false")){
            literatureFile.setLiteratureCheck(2);
        }
        literatureFile.setLiteratureOpinion(literatureOpinion);
        return literatureFileMapper.updateByPrimaryKeySelective(literatureFile)>0;

    }

    /**
     * 根据学生userId审核个人毕业论文
     * @param userId
     * @return
     */
    @Override
    public boolean checkThesisFile(Long userId,String check,String thesisOpinion) {
        ThesisFile thesisFile = thesisFileMapper.selectByPrimaryKey(userId);
        String trueValue = "true";
        String falseValue = "false";
        if(check.equals(trueValue)){
            thesisFile.setThesisCheck(1);
        }else if(check.equals(falseValue)){
            thesisFile.setThesisCheck(2);
        }
        thesisFile.setThesisOpinion(thesisOpinion);
        return thesisFileMapper.updateByPrimaryKeySelective(thesisFile)>0;
    }

    /**
     * 根据题目titleId判断题目是否有人选
     * @param titleId
     * @return
     */
    @Override
    public boolean ifSelectTitle(Long titleId) {
        Titles titles = titlesMapper.selectByPrimaryKey(titleId);
        boolean value = titles.getTitleSelect();
        return value;
    }

    /**
     * 根据题目titleId删除题目
     * @param titleId
     * @return
     */
    @Override
    public boolean delTitle(Long titleId) {
        return titlesMapper.deleteByPrimaryKey(titleId)>0;
    }

    /**
     * 根据学生userId获取个人上传进度计划记录
     * @param userId
     * @return
     */
    @Override
    public List<PlanListVO> getPlanList(Long userId) {
        PlanFileExample planFileExample = new PlanFileExample();
        PlanFileExample.Criteria criteria = planFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<PlanFile> planFileList = planFileMapper.selectByExample(planFileExample);

        List<PlanListVO> planListVO = new ArrayList<>();

        for(PlanFile planFile: planFileList){
            PlanListVO planList = new PlanListVO();

            planList.setPlanId(planFile.getPlanId());
            planList.setUserId(userId);
            planList.setPlanStart(planFile.getPlanStart());
            planList.setPlanEnd(planFile.getPlanEnd());
            planList.setPlanCheck(planFile.getPlanCheck());
            planListVO.add(planList);
        }
        return planListVO;
    }

    /**
     * 根据学生userId获取个人指导记录
     * @param userId
     * @return
     */
    @Override
    public List<GuidanceListVO> getGuidanceList(Long userId) {
        GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
        GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<GuidanceFile> guidanceFileList = guidanceFileMapper.selectByExample(guidanceFileExample);

        List<GuidanceListVO> guidanceListVO = new ArrayList<>();

        for(GuidanceFile guidanceFile: guidanceFileList){
            GuidanceListVO guidanceList = new GuidanceListVO();

            guidanceList.setGuidanceId(guidanceFile.getGuidanceId());
            guidanceList.setUserId(userId);
            guidanceList.setGuidanceDate(guidanceFile.getGuidanceDate());
            guidanceList.setGuidanceCheck(guidanceFile.getGuidanceCheck());

            guidanceListVO.add(guidanceList);
        }
        return guidanceListVO;
    }
}
