package com.katle.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dao.*;
import com.katle.design.dto.AddPlanDTO;
import com.katle.design.entities.*;
import com.katle.design.service.StudentService;
import com.katle.design.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class StudentServicelmpl implements StudentService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private TitlesMapper titlesMapper;
    @Resource
    private ChooseMapper chooseMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private DefenceMapper defenceMapper;
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
     * 选题列表获取
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> selectTitleList(int page, int limit) {

        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andTitleStateEqualTo("审核通过");
        criteria.andTitleSelectEqualTo(false);
        PageHelper.startPage(page,limit);
        List<Titles> selectTitleList = titlesMapper.selectByExample(titlesExample);
        List<TitleListVO> selectListVO = new ArrayList<>();
        for(Titles title:selectTitleList){
            User user = userMapper.selectByPrimaryKey(title.getUserId());
            TitleListVO selectVO = new TitleListVO();
            selectVO.setTitleId(title.getTitleId());
            selectVO.setTitleName(title.getTitleName());
            selectVO.setUsername(user.getUsername());
            selectVO.setCollege(user.getCollege());
            selectVO.setTitleState(title.getTitleState());
            selectListVO.add(selectVO);
        }
        PageInfo pageInfoSelect = new PageInfo(selectTitleList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoSelect",pageInfoSelect);
        map.put("selectListVO",selectListVO);
        return map;
    }

    /**
     * 根据题目titleid和用户userId确认选题
     * @param titleId
     * @param userId
     * @return
     */
    @Override
    public boolean checkSelectTitle(Long titleId, Long userId) {
        Choose chooseUser = chooseMapper.selectByPrimaryKey(userId);
        if(null != chooseUser){
            return false;
        }
        Choose choose = new Choose();
        choose.setUserId(userId);
        choose.setTitleId(titleId);
        choose.setState("待确认");
        chooseMapper.insertSelective(choose);

        Titles titles = titlesMapper.selectByPrimaryKey(titleId);
        titles.setTitleSelect(true);
        return titlesMapper.updateByPrimaryKeySelective(titles)>0;
    }

    /**
     * 根据学生userId上传个人开题报告
     * @param userId
     * @param startName
     * @param startPath
     * @return
     */
    @Override
    public boolean uploadStartFile(Long userId, String startName, String startPath,String schoolYear) {
        StartFile startFile = startFileMapper.selectByPrimaryKey(userId);
        startFile.setStartName(startName);
        startFile.setStartPath(startPath);
        startFile.setStartYear(schoolYear);
        if(startFile.getStartCheck().equals(2)){
            startFile.setStartCheck(0);
        }
        if(null != startFile.getStartOpinion()){
            startFile.setStartOpinion("");
        }
        return startFileMapper.updateByPrimaryKeySelective(startFile)>0;
    }

    /**
     * 根据学生userId上传中期检查
     * @param userId
     * @param middleName
     * @param middlePath
     * @return
     */
    @Override
    public boolean uploadMiddleFile(Long userId, String middleName, String middlePath,String schoolYear) {
        MiddleFile middleFile = middleFileMapper.selectByPrimaryKey(userId);
        middleFile.setMiddleName(middleName);
        middleFile.setMiddlePath(middlePath);
        middleFile.setMiddleYear(schoolYear);
        if(middleFile.getMiddleCheck() == 2){
            middleFile.setMiddleCheck(0);
        }
        if(null != middleFile.getMiddleOpinion()){
            middleFile.setMiddleOpinion("");
        }
        return middleFileMapper.updateByPrimaryKeySelective(middleFile)>0;
    }

    /**
     * 根据userId判断plan表是否有内容,有返回true，没有，返回false
     * @param userId
     * @return
     */
    @Override
    public boolean ifPlan(Long userId) {
        PlanFileExample planFileExample = new PlanFileExample();
        PlanFileExample.Criteria criteria = planFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        PlanFile planFile = planFileMapper.selectByExample(planFileExample).get(0);

        if(planFile.getPlanStart() == null){
            return false;
        }
        return true;
    }

    /**
     * 第一次添加进度计划
     * @param
     * @return
     */
    @Override
    public boolean uploadPlanFile(Long userId, String planName, String planPath, Date planStart, Date planEnd, String planValue, String actualValue,String schoolYear) {
        PlanFileExample planFileExample = new PlanFileExample();
        PlanFileExample.Criteria criteria = planFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        PlanFile planFile = planFileMapper.selectByExample(planFileExample).get(0);

        planFile.setPlanName(planName);
        planFile.setPlanPath(planPath);
        planFile.setPlanStart(planStart);
        planFile.setPlanEnd(planEnd);
        planFile.setPlanValue(planValue);
        planFile.setActualValue(actualValue);
        planFile.setPlanYear(schoolYear);

        return planFileMapper.updateByPrimaryKeySelective(planFile)>0;
    }

    /**
     * 进度计划第二次添加
     * @param userId
     * @param planName
     * @param planPath
     * @param planStart
     * @param planEnd
     * @param planValue
     * @param actualValue
     * @return
     */
    @Override
    public boolean insertPlanItem(Long userId, String planName, String planPath, Date planStart, Date planEnd, String planValue, String actualValue,String schoolYear) {
        PlanFile planFile = new PlanFile();
        planFile.setUserId(userId);
        planFile.setPlanName(planName);
        planFile.setPlanPath(planPath);
        planFile.setPlanStart(planStart);
        planFile.setPlanEnd(planEnd);
        planFile.setPlanValue(planValue);
        planFile.setActualValue(actualValue);
        planFile.setPlanCheck(0);
        planFile.setPlanYear(schoolYear);

        return planFileMapper.insert(planFile)>0;

    }

    /**
     * 根据userId判断是否已填写第一次指导记录,若填写了，返回true，没有填写，返回false
     * @param userId
     * @return
     */
    @Override
    public boolean ifGuidance(Long userId) {
        GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
        GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        GuidanceFile guidanceFile = guidanceFileMapper.selectByExample(guidanceFileExample).get(0);
        if(guidanceFile.getGuidanceDate() == null){
            return false;
        }

        return true;
    }

    /**
     * 根据学生userId第一次上传个人指导记录
     * @param userId
     * @param guidanceName
     * @param guidancePath
     * @return
     */
    @Override
    public boolean uploadGuidanceFile(Long userId, String guidanceName, String guidancePath, Date guidanceDate, String guidanceForm, String guidanceValue,String schoolYear) {
        GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
        GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        GuidanceFile guidanceFile = guidanceFileMapper.selectByExample(guidanceFileExample).get(0);

        guidanceFile.setGuidanceName(guidanceName);
        guidanceFile.setGuidancePath(guidancePath);
        guidanceFile.setGuidanceDate(guidanceDate);
        guidanceFile.setGuidanceForm(guidanceForm);
        guidanceFile.setGuidanceValue(guidanceValue);
        guidanceFile.setGuidanceYear(schoolYear);

        return guidanceFileMapper.updateByPrimaryKeySelective(guidanceFile)>0;
    }

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
    @Override
    public boolean insertGuidance(Long userId, String guidanceName, String guidancePath, Date guidanceDate, String guidanceForm, String guidanceValue,String schoolYear) {
        GuidanceFile guidanceFile = new GuidanceFile();
        guidanceFile.setUserId(userId);
        guidanceFile.setGuidanceName(guidanceName);
        guidanceFile.setGuidancePath(guidancePath);
        guidanceFile.setGuidanceDate(guidanceDate);
        guidanceFile.setGuidanceForm(guidanceForm);
        guidanceFile.setGuidanceValue(guidanceValue);
        guidanceFile.setGuidanceCheck(0);
        guidanceFile.setGuidanceYear(schoolYear);

        return guidanceFileMapper.insert(guidanceFile)>0;
    }

    /**
     * 根据学生userId上传个人外文译文
     * @param userId
     * @param translationName
     * @param translationPath
     * @return
     */
    @Override
    public boolean uploadTranslationFile(Long userId, String translationName, String translationPath,String schoolYear) {
        TranslationFile translationFile = translationFileMapper.selectByPrimaryKey(userId);
        translationFile.setTranslationName(translationName);
        translationFile.setTranslationPath(translationPath);
        translationFile.setTranslationYear(schoolYear);
        if(translationFile.getTranslationCheck() == 2){
            translationFile.setTranslationCheck(0);
        }
        if(null != translationFile.getTranslationOpinion()){
            translationFile.setTranslationOpinion("");
        }
        return translationFileMapper.updateByPrimaryKeySelective(translationFile)>0;
    }

    /**
     * 根据学生userId上传个人外文原文
     * @param userId
     * @param originalName
     * @param originalPath
     * @return
     */
    @Override
    public boolean uploadOriginalFile(Long userId, String originalName, String originalPath,String schoolYear) {
        OriginalFile originalFile = originalFileMapper.selectByPrimaryKey(userId);
        originalFile.setOriginalName(originalName);
        originalFile.setOriginalPath(originalPath);
        originalFile.setOriginalYear(schoolYear);
        if(originalFile.getOriginalCheck() == 2){
            originalFile.setOriginalCheck(0);
        }
        if(null != originalFile.getOriginalOpinion()){
            originalFile.setOriginalOpinion("");
        }
        return originalFileMapper.updateByPrimaryKeySelective(originalFile)>0;
    }

    /**
     * 根据学生userId上传个人文献综述
     * @param userId
     * @param literatureName
     * @param literaturePath
     * @return
     */
    @Override
    public boolean uploadLiteratureFile(Long userId, String literatureName, String literaturePath,String schoolYear) {
        LiteratureFile literatureFile = literatureFileMapper.selectByPrimaryKey(userId);
        literatureFile.setLiteratureName(literatureName);
        literatureFile.setLiteraturePath(literaturePath);
        literatureFile.setLiteratureYear(schoolYear);
        if(literatureFile.getLiteratureCheck() == 2){
            literatureFile.setLiteratureCheck(0);
        }
        if(null != literatureFile.getLiteratureOpinion()){
            literatureFile.setLiteratureOpinion("");
        }
        return literatureFileMapper.updateByPrimaryKeySelective(literatureFile)>0;
    }

    /**
     * 根据学生userId上传个人毕业论文
     * @param userId
     * @param thesisName
     * @param thesisPath
     * @return
     */
    @Override
    public boolean uploadThesisFile(Long userId, String thesisName, String thesisPath,String schoolYear) {
       ThesisFile thesisFile = thesisFileMapper.selectByPrimaryKey(userId);
       thesisFile.setThesisName(thesisName);
       thesisFile.setThesisPath(thesisPath);
       thesisFile.setThesisYear(schoolYear);
       if(thesisFile.getThesisCheck() == 2){
           thesisFile.setThesisCheck(0);
       }
       if(thesisFile.getThesisOpinion() != null){
           thesisFile.setThesisOpinion("");
       }
       return thesisFileMapper.updateByPrimaryKeySelective(thesisFile)>0;
    }

    /**
     * 根据学生姓名查询开题答辩分组
     * @param openStudents
     * @return
     */
    @Override
    public DefenceGroupVO stuOpenGroup(String openStudents) {
        OpenDefenceExample openDefenceExample = new OpenDefenceExample();
        OpenDefenceExample.Criteria criteria = openDefenceExample.createCriteria();
        criteria.andOpenStudentsLike("%"+openStudents+"%");
        OpenDefence open = openDefenceMapper.selectByExample(openDefenceExample).get(0);

        DefenceGroupVO defenceGroupVO = new DefenceGroupVO();
        defenceGroupVO.setDefenceId(open.getOpenId());
        defenceGroupVO.setDefenceName(open.getOpenName());
        defenceGroupVO.setDefencePlace(open.getOpenPlace());
        defenceGroupVO.setDefenceDate(open.getOpenDate());
        defenceGroupVO.setDefenceTime(open.getOpenTime());
        defenceGroupVO.setDefenceTeachs(open.getOpenTeachs());
        defenceGroupVO.setDefenceLeader(open.getOpenLeader());
        defenceGroupVO.setDefenceStudents(open.getOpenStudents());

        return defenceGroupVO;
    }

    /**
     * 根据学生姓名查询毕设答辩分组
     * @param defenceStudents
     * @return
     */
    @Override
    public DefenceGroupVO stuDefenceGroup(String defenceStudents) {
        DefenceExample defenceExample = new DefenceExample();
        DefenceExample.Criteria criteria = defenceExample.createCriteria();
        criteria.andDefenceStudentsLike("%"+defenceStudents+"%");
        Defence defence = defenceMapper.selectByExample(defenceExample).get(0);

        DefenceGroupVO defenceGroupVO = new DefenceGroupVO();
        defenceGroupVO.setDefenceId(defence.getDefenceId());
        defenceGroupVO.setDefenceName(defence.getDefenceName());
        defenceGroupVO.setDefencePlace(defence.getDefencePlace());
        defenceGroupVO.setDefenceDate(defence.getDefenceDate());
        defenceGroupVO.setDefenceTime(defence.getDefenceTime());
        defenceGroupVO.setDefenceTeachs(defence.getDefenceTeachs());
        defenceGroupVO.setDefenceStudents(defence.getDefenceStudents());
        defenceGroupVO.setDefenceLeader(defence.getDefenceLeader());
        return defenceGroupVO;
    }

    /**
     * 根据学生userId查询学生成绩
     * @param userId
     * @return
     */
    @Override
    public Score studentScore(Long userId) {
        Score score = scoreMapper.selectByPrimaryKey(userId);
        return score;
    }

    /**
     * 根据学生userId获取学生选题信息
     * @param userId
     * @return
     */
    @Override
    public StuTitleDetialVO stuSelectTitleDetails(Long userId) {
        Choose choose = chooseMapper.selectByPrimaryKey(userId);
        Titles title = titlesMapper.selectByPrimaryKey(choose.getTitleId());
        User user = userMapper.selectByPrimaryKey(title.getUserId());

        StuTitleDetialVO stuTitleDetialVO = new StuTitleDetialVO();
        stuTitleDetialVO.setTitleId(title.getTitleId());
        stuTitleDetialVO.setTitleName(title.getTitleName());
        stuTitleDetialVO.setTitleKind(title.getTitleKind());
        stuTitleDetialVO.setTitleSource(title.getTitleSource());
        stuTitleDetialVO.setTitleModel(title.getTitleModel());
        stuTitleDetialVO.setTitleMajor(title.getTitleMajor());
        stuTitleDetialVO.setTitleState(title.getTitleState());
        stuTitleDetialVO.setState(choose.getState());
        stuTitleDetialVO.setUserId(title.getUserId());
        stuTitleDetialVO.setUsername(user.getUsername());
        stuTitleDetialVO.setCollege(user.getCollege());
        stuTitleDetialVO.setPosition(user.getPosition());
        stuTitleDetialVO.setEmail(user.getEmail());

       return stuTitleDetialVO;
    }

    /**
     * 根据学生userId取消学生选题信息
     * @param userId
     * @return
     */
    @Override
    public boolean stuCancelTitle(Long userId) {
        Choose choose = chooseMapper.selectByPrimaryKey(userId);
        Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

        String value = "待确认";

        if(!choose.getState().equals(value)){
            return false;
        }

        chooseMapper.deleteByPrimaryKey(userId);

        titles.setTitleSelect(false);
        return titlesMapper.updateByPrimaryKeySelective(titles)>0;
    }

    /**
     * 根据关键词进行题目模糊查询
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchTitles(int page,int limit,String searchValue) {
        PageHelper.startPage(page,limit);

        TitlesExample titlesExample = new TitlesExample();

        titlesExample.or().andTitleNameLike("%"+searchValue+"%");
        titlesExample.or().andUserNameLike("%"+searchValue+"%");
        titlesExample.or().andTitleKindLike("%"+searchValue+"%");
        titlesExample.or().andTitleSourceLike("%"+searchValue+"%");
        titlesExample.or().andTitleModelLike("%"+searchValue+"%");
        titlesExample.or().andTitleTypeLike("%"+searchValue+"%");
        titlesExample.or().andTitleCompleteLike("%"+searchValue+"%");
        titlesExample.or().andTitleValueLike("%"+searchValue+"%");
        titlesExample.or().andTitleRequireLike("%"+searchValue+"%");
        titlesExample.or().andTitleResultLike("%"+searchValue+"%");
        titlesExample.or().andTitleMajorLike("%"+searchValue+"%");

        List<Titles> searchTitles = titlesMapper.selectByExample(titlesExample);

        List<TitleListVO> searchLists = new ArrayList<>();

        for(Titles title:searchTitles){
            User user = userMapper.selectByPrimaryKey(title.getUserId());

            String state = "审核通过";
            boolean select = false;

            TitleListVO listVO = new TitleListVO();

            if(title.getTitleState().equals(state) && title.getTitleSelect().equals(select)){
                listVO.setTitleId(title.getTitleId());
                listVO.setUserId(title.getUserId());
                listVO.setTitleName(title.getTitleName());
                listVO.setTitleKind(title.getTitleKind());
                listVO.setTitleYear(title.getTitleYear());
                listVO.setTitleState(title.getTitleState());
                listVO.setUsername(user.getUsername());
                listVO.setCollege(user.getCollege());

                searchLists.add(listVO);
            }

        }

        PageInfo pageInfoSearch = new PageInfo(searchLists);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoSearch",pageInfoSearch);
        map.put("searchLists",searchLists);

        return map;
    }

    /**
     * 根据进度计划的planID获取进度计划详细内容
     * @param planId
     * @return
     */
    @Override
    public PlanItemDetail getPlanItemDetail(Long planId) {
        PlanFile planFile = planFileMapper.selectByPrimaryKey(planId);
        PlanItemDetail planItemDetail = new PlanItemDetail();

        planItemDetail.setPlanId(planId);
        planItemDetail.setUserId(planFile.getUserId());
        planItemDetail.setPlanName(planFile.getPlanName());
        planItemDetail.setPlanPath(planFile.getPlanPath());
        planItemDetail.setPlanStart(planFile.getPlanStart());
        planItemDetail.setPlanEnd(planFile.getPlanEnd());
        planItemDetail.setPlanValue(planFile.getPlanValue());
        planItemDetail.setActualValue(planFile.getActualValue());
        planItemDetail.setPlanCheck(planFile.getPlanCheck());
        planItemDetail.setPlanOpinion(planFile.getPlanOpinion());

        return planItemDetail;
    }

    /**
     * 根据指导记录的guidanceId获取指导记录的详细内容
     * @param guidanceId
     * @return
     */
    @Override
    public GuidanceItemDetail getGuidanceItemDetail(Long guidanceId) {
        GuidanceFile guidanceFile = guidanceFileMapper.selectByPrimaryKey(guidanceId);

        GuidanceItemDetail guidanceItemDetail = new GuidanceItemDetail();
        guidanceItemDetail.setGuidanceId(guidanceId);
        guidanceItemDetail.setUserId(guidanceFile.getUserId());
        guidanceItemDetail.setGuidanceName(guidanceFile.getGuidanceName());
        guidanceItemDetail.setGuidancePath(guidanceFile.getGuidancePath());
        guidanceItemDetail.setGuidanceDate(guidanceFile.getGuidanceDate());
        guidanceItemDetail.setGuidanceForm(guidanceFile.getGuidanceForm());
        guidanceItemDetail.setGuidanceValue(guidanceFile.getGuidanceValue());
        guidanceItemDetail.setGuidanceCheck(guidanceFile.getGuidanceCheck());
        guidanceItemDetail.setGuidanceOpinion(guidanceFile.getGuidanceOpinion());

        return guidanceItemDetail;
    }

    /**
     * 根据学生userId获取学生过程文档审核情况
     * @param userId
     * @return
     */
    @Override
    public FileCheckVO getFileCheck(Long userId) {
        StartFile startFile = startFileMapper.selectByPrimaryKey(userId);
        MiddleFile middleFile = middleFileMapper.selectByPrimaryKey(userId);
        TranslationFile translationFile = translationFileMapper.selectByPrimaryKey(userId);
        OriginalFile originalFile = originalFileMapper.selectByPrimaryKey(userId);
        LiteratureFile literatureFile = literatureFileMapper.selectByPrimaryKey(userId);
        ThesisFile thesisFile = thesisFileMapper.selectByPrimaryKey(userId);

        FileCheckVO fileCheckVO = new FileCheckVO();

        fileCheckVO.setUserId(userId);
        fileCheckVO.setStartName(startFile.getStartName());
        fileCheckVO.setStartPath(startFile.getStartPath());
        fileCheckVO.setStartCheck(startFile.getStartCheck());
        fileCheckVO.setStartOpinion(startFile.getStartOpinion());

        fileCheckVO.setMiddleName(middleFile.getMiddleName());
        fileCheckVO.setMiddlePath(middleFile.getMiddlePath());
        fileCheckVO.setMiddleCheck(middleFile.getMiddleCheck());
        fileCheckVO.setMiddleOpinion(middleFile.getMiddleOpinion());

        fileCheckVO.setTranslationName(translationFile.getTranslationName());
        fileCheckVO.setTranslationPath(translationFile.getTranslationPath());
        fileCheckVO.setTranslationCheck(translationFile.getTranslationCheck());
        fileCheckVO.setTranslationOpinion(translationFile.getTranslationOpinion());

        fileCheckVO.setOriginalName(originalFile.getOriginalName());
        fileCheckVO.setOriginalPath(originalFile.getOriginalPath());
        fileCheckVO.setOriginalCheck(originalFile.getOriginalCheck());
        fileCheckVO.setOriginalOpinion(originalFile.getOriginalOpinion());

        fileCheckVO.setLiteratureName(literatureFile.getLiteratureName());
        fileCheckVO.setLiteraturePath(literatureFile.getLiteraturePath());
        fileCheckVO.setLiteratureCheck(literatureFile.getLiteratureCheck());
        fileCheckVO.setLiteratureOpinion(literatureFile.getLiteratureOpinion());

        fileCheckVO.setThesisName(thesisFile.getThesisName());
        fileCheckVO.setThesisPath(thesisFile.getThesisPath());
        fileCheckVO.setThesisCheck(thesisFile.getThesisCheck());
        fileCheckVO.setThesisOpinion(thesisFile.getThesisOpinion());

        return fileCheckVO;
    }

    /**
     * 根据学生userId获取学生进度计划审核情况
     * @param userId
     * @return
     */
    @Override
    public List<PlanCheckVO> getPlanCheck(Long userId) {
        PlanFileExample planFileExample = new PlanFileExample();
        PlanFileExample.Criteria criteria = planFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<PlanFile> planFileList = planFileMapper.selectByExample(planFileExample);

        List<PlanCheckVO> planCheckVO = new ArrayList<>();

        for (PlanFile planFile: planFileList){
            PlanCheckVO planCheck = new PlanCheckVO();

            planCheck.setPlanId(planFile.getPlanId());
            planCheck.setUserId(userId);
            planCheck.setPlanName(planFile.getPlanName());
            planCheck.setPlanPath(planFile.getPlanPath());
            planCheck.setPlanStart(planFile.getPlanStart());
            planCheck.setPlanEnd(planFile.getPlanEnd());
            planCheck.setPlanCheck(planFile.getPlanCheck());
            planCheck.setPlanOpinion(planFile.getPlanOpinion());

            planCheckVO.add(planCheck);

        }
        return planCheckVO;
    }

    /**
     * 根据学生userId获取学生指导记录审核情况
     * @param userId
     * @return
     */
    @Override
    public List<GuidanceCheckVO> getGuidanceCheck(Long userId) {
        GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
        GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<GuidanceFile> guidanceFileList = guidanceFileMapper.selectByExample(guidanceFileExample);

        List<GuidanceCheckVO> guidanceCheckVO = new ArrayList<>();

        for(GuidanceFile guidanceFile:guidanceFileList){
            GuidanceCheckVO guidanceCheck = new GuidanceCheckVO();

            guidanceCheck.setGuidanceId(guidanceFile.getGuidanceId());
            guidanceCheck.setUserId(userId);
            guidanceCheck.setGuidanceName(guidanceFile.getGuidanceName());
            guidanceCheck.setGuidancePath(guidanceFile.getGuidancePath());
            guidanceCheck.setGuidanceDate(guidanceFile.getGuidanceDate());
            guidanceCheck.setGuidanceCheck(guidanceFile.getGuidanceCheck());
            guidanceCheck.setGuidanceOpinion(guidanceFile.getGuidanceOpinion());

            guidanceCheckVO.add(guidanceCheck);
        }
        return guidanceCheckVO;
    }
}
