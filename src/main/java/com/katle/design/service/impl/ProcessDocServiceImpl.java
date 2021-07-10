package com.katle.design.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dao.*;
import com.katle.design.dto.DefenceGroupDTO;
import com.katle.design.dto.IdAndNameDTO;
import com.katle.design.dto.TitleIdDTO;
import com.katle.design.entities.*;
import com.katle.design.service.ProcessDocService;
import com.katle.design.vo.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TitledPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import sun.misc.OSEnvironment;

import javax.annotation.Resource;
import java.nio.file.OpenOption;
import java.util.*;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class ProcessDocServiceImpl implements ProcessDocService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private TitlesMapper titlesMapper;
    @Resource
    private TaskFileMapper taskFileMapper;
    @Resource
    private ChooseMapper chooseMapper;
    @Resource
    private OpenDefenceMapper openDefenceMapper;
    @Resource
    private StartFileMapper startFileMapper;
    @Resource
    private MiddleFileMapper middleFileMapper;
    @Resource
    private TranslationFileMapper translationFileMapper;
    @Resource
    private LiteratureFileMapper literatureFileMapper;
    @Resource
    private OriginalFileMapper originalFileMapper;
    @Resource
    private ThesisFileMapper thesisFileMapper;
    @Resource
    private GuidanceFileMapper guidanceFileMapper;
    @Resource
    private PlanFileMapper planFileMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private ScoreMapper scoreMapper;

    /**
     * 根据管理员id和相应的年份选择获取相应的任务书
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String,Object> getTaskList(int page,int limit,Long userId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(userId);
        TaskFileExample taskFileExample = new TaskFileExample();
        TaskFileExample.Criteria criteria = taskFileExample.createCriteria();
        criteria.andTaskYearEqualTo(schoolYear);
        PageHelper.startPage(page,limit);
        List<TaskFile> taskFiles = taskFileMapper.selectByExample(taskFileExample);

        List<TaskListVO> taskList = new ArrayList<>();

        for(TaskFile item:taskFiles){
            TaskListVO task = new TaskListVO();
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            User teach = userMapper.selectByPrimaryKey(titles.getUserId());
            String checkName;
            if(item.getTaskCheckman() == null){
                checkName = null;
            }else{
                User checkMan = userMapper.selectByPrimaryKey(item.getTaskCheckman());
                checkName = checkMan.getUsername();
            }
            String adminCollege = admin.getCollege();
            String teachCollege = teach.getCollege();
            LOGGER.info(checkName);

            if(item.getTaskName() != null && adminCollege.equals(teachCollege)){
                task.setUserId(item.getUserId());
                task.setTitleId(titles.getTitleId());
                task.setTitleName(titles.getTitleName());
                task.setTitleMajor(titles.getTitleMajor());
                task.setTaskName(item.getTaskName());
                task.setTaskPath(item.getTaskPath());
                task.setTaskCheck(item.getTaskCheck());
                task.setTaskOpinion(item.getTaskOpinion());
                task.setTaskCheckman(checkName);
                task.setUsername(teach.getUsername());
                task.setPosition(teach.getPosition());
                taskList.add(task);
            }
        }

        PageInfo pageInfoTask = new PageInfo(taskFiles);
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfoTask",pageInfoTask);
        map.put("taskList",taskList);
        return map;

    }

    /**
     * 根据审核状态查询任务书
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param
     * @return
     */
    @Override
    public Map<String, Object> searchTaskList(int page, int limit, Long userId, String schoolYear, String taskCheck) {
        PageHelper.startPage(page,limit);
        User admin = userMapper.selectByPrimaryKey(userId);

        TaskFileExample taskFileExample = new TaskFileExample();
        TaskFileExample.Criteria criteria = taskFileExample.createCriteria();
        criteria.andTaskYearEqualTo(schoolYear);
        if(taskCheck.equals("待审核")){
            criteria.andTaskCheckEqualTo(0);
        }else if(taskCheck.equals("审核通过")){
            criteria.andTaskCheckEqualTo(1);
        }else if(taskCheck.equals("审核不通过")){
            criteria.andTaskCheckEqualTo(2);
        }

        List<TaskFile> taskFiles = taskFileMapper.selectByExample(taskFileExample);

        List<TaskListVO> taskListVO = new ArrayList<>();
        for(TaskFile item: taskFiles){
            TaskListVO taskList = new TaskListVO();
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            User teach = userMapper.selectByPrimaryKey(titles.getUserId());

            String checkMan;
            if(item.getTaskCheck() == null){
                checkMan = null;
            }else{
                User check = userMapper.selectByPrimaryKey(item.getUserId());
                checkMan = check.getUsername();
            }
            LOGGER.info(checkMan);

            if(admin.getCollege().equals(teach.getCollege()) && item.getTaskName() != null){
                taskList.setUserId(item.getUserId());
                taskList.setTitleId(titles.getTitleId());
                taskList.setTitleName(titles.getTitleName());
                taskList.setTitleMajor(titles.getTitleMajor());
                taskList.setTaskName(item.getTaskName());
                taskList.setTaskPath(item.getTaskPath());
                taskList.setTaskCheck(item.getTaskCheck());
                taskList.setTaskCheckman(checkMan);
                taskList.setTaskOpinion(item.getTaskOpinion());
                taskList.setUsername(teach.getUsername());
                taskList.setPosition(teach.getPosition());
                taskListVO.add(taskList);
            }
        }
        PageInfo pageInfoSearchTask = new PageInfo(taskFiles);
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfoSearchTask",pageInfoSearchTask);
        map.put("taskListSearch",taskListVO);
        return map;
    }

    /**
     * 根获取的userId指定任务书的审核教师
     * @param idAndNameDTO
     * @return
     */
    @Override
    public boolean setTaskCheckMan(IdAndNameDTO idAndNameDTO) {
        Long[] userId = idAndNameDTO.getId();
        try {
            for(Long id:userId){
                TaskFile taskFile = taskFileMapper.selectByPrimaryKey(id);
                taskFile.setTaskCheckman(idAndNameDTO.getTeachId());
                taskFileMapper.updateByPrimaryKeySelective(taskFile);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 审核任务书
     * @param userId
     * @param checkValue
     * @return
     */
    @Override
    public boolean checkTaskFile(Long userId, String checkValue) {
        TaskFile taskFile = taskFileMapper.selectByPrimaryKey(userId);
        if(checkValue.equals("审核通过")){
            taskFile.setTaskCheck(1);
        }else if(checkValue.equals("审核不通过")){
            taskFile.setTaskCheck(2);
        }else if(checkValue.equals("待审核")){
            taskFile.setTaskCheck(0);
        }
        return taskFileMapper.updateByPrimaryKeySelective(taskFile)>0;
    }

    /**
     * 根据年份获取答辩分组列表
     * @param page
     * @param limit
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> getOpenList(int page, int limit, String schoolYear,Long adminId) {

        OpenDefenceExample openDefenceExample = new OpenDefenceExample();
        OpenDefenceExample.Criteria criteria = openDefenceExample.createCriteria();
        criteria.andOpenYearEqualTo(schoolYear);
        criteria.andAdminIdEqualTo(adminId);
        PageHelper.startPage(page,limit);
        List<OpenDefence> openDefenceList = openDefenceMapper.selectByExample(openDefenceExample);
        List<DefenceGroupVO> openDefenceVO = new ArrayList<>();

        for(OpenDefence item:openDefenceList){
            DefenceGroupVO openVO = new DefenceGroupVO();

            openVO.setDefenceId(item.getOpenId());
            openVO.setDefenceName(item.getOpenName());
            openVO.setDefencePlace(item.getOpenPlace());
            openVO.setDefenceDate(item.getOpenDate());
            openVO.setDefenceTime(item.getOpenTime());
            openVO.setDefenceTeachs(item.getOpenTeachs());
            openVO.setDefenceStudents(item.getOpenStudents());
            openVO.setDefenceLeader(item.getOpenLeader());

            openDefenceVO.add(openVO);

        }
        PageInfo pageInfoOpen = new PageInfo(openDefenceList);
        Map<String ,Object> map = new HashMap<>();
        map.put("pageInfoOpen",pageInfoOpen);
        map.put("openDefenceVO",openDefenceVO);
        return map;
    }

    /**
     * 根据关键字搜索答辩分组信息
     * @param page
     * @param limit
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchOpenList(int page, int limit, String schoolYear,Long adminId, String searchValue) {

        OpenDefenceExample openDefenceExample = new OpenDefenceExample();

        openDefenceExample.or().andOpenNameLike("%"+searchValue+"%");
        openDefenceExample.or().andOpenPlaceLike("%"+searchValue+"%");
        openDefenceExample.or().andOpenTeachsLike("%"+searchValue+"%");
        openDefenceExample.or().andOpenStudentsLike("%"+searchValue+"%");
        openDefenceExample.or().andOpenYearLike("%"+searchValue+"%");
        PageHelper.startPage(page,limit);
        List<OpenDefence> openDefenceList = openDefenceMapper.selectByExample(openDefenceExample);
        List<DefenceGroupVO> openDefenceSearchVO = new ArrayList<>();

        for(OpenDefence item:openDefenceList){
            DefenceGroupVO openVO = new DefenceGroupVO();

            if(item.getOpenYear().equals(schoolYear) && item.getAdminId().equals(adminId)){
                openVO.setDefenceId(item.getOpenId());
                openVO.setDefenceName(item.getOpenName());
                openVO.setDefencePlace(item.getOpenPlace());
                openVO.setDefenceDate(item.getOpenDate());
                openVO.setDefenceTime(item.getOpenTime());
                openVO.setDefenceTeachs(item.getOpenTeachs());
                openVO.setDefenceStudents(item.getOpenStudents());
                openVO.setDefenceLeader(item.getOpenLeader());

                openDefenceSearchVO.add(openVO);
            }
        }
        PageInfo pageInfoOpenSearch = new PageInfo(openDefenceList);
        Map<String ,Object> map = new HashMap<>();
        map.put("pageInfoOpenSearch",pageInfoOpenSearch);
        map.put("openDefenceSearchVO",openDefenceSearchVO);
        return map;

    }

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
    @Override
    public boolean insertOpenDefence( String openName, String openPlace, Date openDate, Date openTime, String openTeachs, String openStudents, String openLeader, String openYear,Long adminId) {
        OpenDefence openDefence = new OpenDefence();
        openDefence.setOpenName(openName);
        openDefence.setOpenPlace(openPlace);
        openDefence.setOpenDate(openDate);
        openDefence.setOpenTime(openTime);
        openDefence.setOpenTeachs(openTeachs);
        openDefence.setOpenStudents(openStudents);
        openDefence.setOpenLeader(openLeader);
        openDefence.setOpenYear(openYear);
        openDefence.setAdminId(adminId);

        return openDefenceMapper.insert(openDefence)>0;
    }

    /**
     * 添加开题答辩分组
     * @param defenceGroupDTO
     * @return
     */
    @Override
    public boolean addOpenDefence(DefenceGroupDTO defenceGroupDTO) {
        OpenDefence openDefence = new OpenDefence();
        openDefence.setOpenName(defenceGroupDTO.getDefenceName());
        openDefence.setOpenPlace(defenceGroupDTO.getDefencePlace());
        openDefence.setOpenTime(defenceGroupDTO.getDefenceTime());
        openDefence.setOpenDate(defenceGroupDTO.getDefenceDate());
        openDefence.setOpenTeachs(defenceGroupDTO.getDefenceTeachs());
        openDefence.setOpenStudents(defenceGroupDTO.getDefenceStudents());
        openDefence.setOpenLeader(defenceGroupDTO.getDefenceLeader());
        openDefence.setOpenYear(defenceGroupDTO.getDefenceYear());
        openDefence.setAdminId(defenceGroupDTO.getAdminId());
        return openDefenceMapper.insert(openDefence)>0;
    }

    /**
     * 判断是否与同名分组
     * @param openName
     * @return
     */
    @Override
    public OpenDefence findOpenByOpenName(String openName) {
        OpenDefenceExample openDefenceExample = new OpenDefenceExample();
        OpenDefenceExample.Criteria criteria = openDefenceExample.createCriteria();
        criteria.andOpenNameEqualTo(openName);
        List<OpenDefence> openDefenceList = openDefenceMapper.selectByExample(openDefenceExample);

        if(openDefenceList.size() != 0){
            return openDefenceList.get(0);
        }
        return null;
    }

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
    @Override
    public boolean updateOpenDefence(Long openId,String openName, String openPlace, Date openDate, Date openTime, String openTeachs, String openStudents, String openLeader, String openYear) {
        OpenDefence openDefence = openDefenceMapper.selectByPrimaryKey(openId);
        openDefence.setOpenName(openName);
        openDefence.setOpenPlace(openPlace);
        openDefence.setOpenDate(openDate);
        openDefence.setOpenTime(openTime);
        openDefence.setOpenTeachs(openTeachs);
        openDefence.setOpenStudents(openStudents);
        openDefence.setOpenLeader(openLeader);
        openDefence.setOpenYear(openYear);
        return openDefenceMapper.updateByPrimaryKeySelective(openDefence)>0;
    }

    /**
     * 根据管理员id获取相应学院当前学年的开题报告列表
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> startFileList(int page, int limit, Long userId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(userId);
        StartFileExample startFileExample = new StartFileExample();
        StartFileExample.Criteria criteria  = startFileExample.createCriteria();
        criteria.andStartYearEqualTo(schoolYear);
        PageHelper.startPage(page,limit);
        List<StartFile> startFileList = startFileMapper.selectByExample(startFileExample);
        List<FilesListVO> filesListVO = new ArrayList<>();

        for(StartFile item:startFileList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            String checkMan;
            if(item.getStartCheckman() == null){
                checkMan = null;
            }else{
                User checkTeach = userMapper.selectByPrimaryKey(item.getStartCheckman());
                checkMan = checkTeach.getUsername();
            }
            if(stu.getCollege().equals(admin.getCollege()) && item.getStartName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(item.getStartName());
                file.setFilePath(item.getStartPath());
                file.setFileCheck(item.getStartCheck());
                file.setFileOpinion(item.getStartOpinion());
                file.setFileCheckman(checkMan);
                filesListVO.add(file);
            }
        }
        PageInfo pageInfoStartFile = new PageInfo(startFileList);
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfoStartFile",pageInfoStartFile);
        map.put("startFileList",filesListVO);

        return map;
    }

    /**
     * 根据关键字查询开题报告
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchStartFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);

        User admin = userMapper.selectByPrimaryKey(userId);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andUsernumEqualTo(searchValue);
        criteria.andCollegeEqualTo(admin.getCollege());
        userExample.or().andUsernameLike("%"+searchValue+"%");

        List<User> searchList = userMapper.selectByExample(userExample);

        List<FilesListVO> searchStartList = new ArrayList<>();

        for(User item:searchList){
            StartFile startFile = startFileMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            if(choose == null){
                continue;
            }
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(startFile.getStartCheckman() == null){
                checkMan = null;
            }else{
                User checkTeach = userMapper.selectByPrimaryKey(startFile.getStartCheckman());
                checkMan = checkTeach.getUsername();
            }

            if(startFile.getStartName() != null){
                FilesListVO file = new FilesListVO();

                file.setUserId(item.getUserId());
                file.setUsernum(item.getUsernum());
                file.setUsername(item.getUsername());
                file.setMajor(item.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(startFile.getStartName());
                file.setFilePath(startFile.getStartPath());
                file.setFileCheck(startFile.getStartCheck());
                file.setFileOpinion(startFile.getStartOpinion());
                file.setFileCheckman(checkMan);

                searchStartList.add(file);
            }
        }
        PageInfo pageInfoSearchStart = new PageInfo(searchStartList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoSearchStart",pageInfoSearchStart);
        map.put("searchStartList",searchStartList);
        return map;
    }

    /**
     *根据管理员userId获取当前学年的中期检查
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> middleFileList(int page, int limit, Long userId, String schoolYear) {

        User admin = userMapper.selectByPrimaryKey(userId);

        MiddleFileExample middleFileExample = new MiddleFileExample();
        MiddleFileExample.Criteria criteria  = middleFileExample.createCriteria();
        criteria.andMiddleYearEqualTo(schoolYear);
        PageHelper.startPage(page,limit);
        List<MiddleFile> middleFileList = middleFileMapper.selectByExample(middleFileExample);
        List<FilesListVO> middleListVO = new ArrayList<>();

        for(MiddleFile item:middleFileList){
            User stu = userMapper.selectByPrimaryKey(item.getUserid());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserid());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            String checkMan;
            if(item.getMiddleCheckman() == null){
                checkMan = null;
            }else{
                User teachCheck = userMapper.selectByPrimaryKey(item.getMiddleCheckman());
                checkMan = teachCheck.getUsername();
            }

            if(stu.getCollege().equals(admin.getCollege()) && item.getMiddleName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(item.getMiddleName());
                file.setFilePath(item.getMiddlePath());
                file.setFileCheck(item.getMiddleCheck());
                file.setFileOpinion(item.getMiddleOpinion());
                file.setFileCheckman(checkMan);
                middleListVO.add(file);
            }

        }
        PageInfo pageInfoMiddle = new PageInfo(middleFileList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoMiddle",pageInfoMiddle);
        map.put("middleListVO",middleListVO);
        return map;
    }

    /**
     * 根据关键词:学号，姓名查中期报告
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchMiddleFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);

        User admin = userMapper.selectByPrimaryKey(userId);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andUsernumEqualTo(searchValue);
        criteria.andCollegeEqualTo(admin.getCollege());
        userExample.or().andUsernameLike("%"+searchValue+"%");

        List<User> userList = userMapper.selectByExample(userExample);
        List<FilesListVO> searchMiddleList = new ArrayList<>();

        for(User item:userList){
            MiddleFile middleFile = middleFileMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            if(choose == null){
                continue;
            }
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            String checkMan;
            if(middleFile.getMiddleCheckman() == null){
                checkMan = null;
            }else{
                User teachCheck = userMapper.selectByPrimaryKey(middleFile.getMiddleCheckman());
                checkMan = teachCheck.getUsername();
            }

            if(middleFile.getMiddleName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(item.getUserId());
                file.setUsernum(item.getUsernum());
                file.setUsername(item.getUsername());
                file.setMajor(item.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(middleFile.getMiddleName());
                file.setFilePath(middleFile.getMiddlePath());
                file.setFileCheck(middleFile.getMiddleCheck());
                file.setFileOpinion(middleFile.getMiddleOpinion());
                file.setFileCheckman(checkMan);
                searchMiddleList.add(file);
            }

        }
        PageInfo pageInfoSearchMiddle = new PageInfo(searchMiddleList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoSearchMiddle",pageInfoSearchMiddle);
        map.put("searchMiddleList",searchMiddleList);
        return map;
    }

    /**
     * 根据管理员UserId获取当前年份的外文译文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> translationFileList(int page, int limit, Long userId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(userId);

        TranslationFileExample translationFileExample = new TranslationFileExample();
        TranslationFileExample.Criteria criteria = translationFileExample.createCriteria();
        criteria.andTranslationYearEqualTo(schoolYear);
        PageHelper.startPage(page,limit);
        List<TranslationFile> translationFileList = translationFileMapper.selectByExample(translationFileExample);

        List<FilesListVO> translationListVO = new ArrayList<>();

        for(TranslationFile item:translationFileList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(item.getTranslationCheckman() == null){
                checkMan = null;
            }else{
                User teachCheck = userMapper.selectByPrimaryKey(item.getTranslationCheckman());
                checkMan = teachCheck.getUsername();
            }

            if(stu.getCollege().equals(admin.getCollege()) && item.getTranslationName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(item.getTranslationName());
                file.setFilePath(item.getTranslationPath());
                file.setFileCheck(item.getTranslationCheck());
                file.setFileOpinion(item.getTranslationOpinion());
                file.setFileCheckman(checkMan);

                translationListVO.add(file);

            }

        }
        PageInfo pageInfoTranslation = new PageInfo(translationFileList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoTranslation",pageInfoTranslation);
        map.put("translationListVO",translationListVO);
        return map;
    }

    /**
     * 根据关键字查找外文译文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchTranslationFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);

        User admin = userMapper.selectByPrimaryKey(userId);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andUsernumEqualTo(searchValue);
        criteria.andCollegeEqualTo(admin.getCollege());
        userExample.or().andUsernameLike("%"+searchValue+"%");
        List<User> userList = userMapper.selectByExample(userExample);
        List<FilesListVO> translationSearchVO = new ArrayList<>();


        for(User item:userList){
            TranslationFile translationFile = translationFileMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            if(choose == null){
                continue;
            }
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(translationFile.getTranslationCheckman() == null){
                checkMan = null;
            }else{
                User teachCheck = userMapper.selectByPrimaryKey(translationFile.getTranslationCheckman());
                checkMan = teachCheck.getUsername();
            }

            if(translationFile.getTranslationName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(item.getUserId());
                file.setUsernum(item.getUsernum());
                file.setUsername(item.getUsername());
                file.setMajor(item.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(translationFile.getTranslationName());
                file.setFilePath(translationFile.getTranslationPath());
                file.setFileCheck(translationFile.getTranslationCheck());
                file.setFileOpinion(translationFile.getTranslationOpinion());
                file.setFileCheckman(checkMan);
                translationSearchVO.add(file);
            }

        }
        PageInfo pageInfoTranslationSearch = new PageInfo(translationSearchVO);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoTranslationSearch",pageInfoTranslationSearch);
        map.put("translationSearchVO",translationSearchVO);
        return map;

    }

    /**
     * 根据管理员userId获取当前年份外文原文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> originalFileList(int page, int limit, Long userId, String schoolYear) {

        OriginalFileExample originalFileExample = new OriginalFileExample();
        OriginalFileExample.Criteria criteria = originalFileExample.createCriteria();
        criteria.andOriginalYearEqualTo(schoolYear);
        PageHelper.startPage(page,limit);
        List<OriginalFile> originalFileList = originalFileMapper.selectByExample(originalFileExample);
        List<FilesListVO> originalListVO = new ArrayList<>();

        User admin = userMapper.selectByPrimaryKey(userId);
        for(OriginalFile item:originalFileList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(item.getOriginalCheckman() == null){
                checkMan = null;
            }else{
                User teachMan = userMapper.selectByPrimaryKey(item.getOriginalCheckman());
                checkMan = teachMan.getUsername();
            }

            if(stu.getCollege().equals(admin.getCollege()) && item.getOriginalName() != null){
                FilesListVO file = new FilesListVO();

                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(item.getOriginalName());
                file.setFilePath(item.getOriginalPath());
                file.setFileCheck(item.getOriginalCheck());
                file.setFileOpinion(item.getOriginalOpinion());
                file.setFileCheckman(checkMan);

                originalListVO.add(file);
            }
        }
        PageInfo pageInfoOriginal = new PageInfo(originalFileList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoOriginal",pageInfoOriginal);
        map.put("originalListVO",originalListVO);
        return map;
    }

    /**
     * 根据关键字查询外文原文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchOriginalFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);

        User admin = userMapper.selectByPrimaryKey(userId);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andCollegeEqualTo(admin.getCollege());
        criteria.andUsernumEqualTo(searchValue);
        userExample.or().andUsernameLike("%"+searchValue+"%");

        List<User> userList = userMapper.selectByExample(userExample);
        List<FilesListVO> originalListSearchVO = new ArrayList<>();

        for(User item:userList){
            OriginalFile originalFile = originalFileMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            if(choose == null){
                continue;
            }
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            String checkMan;
            if(originalFile.getOriginalCheckman() == null){
                checkMan = null;
            }else{
                User teachCheck = userMapper.selectByPrimaryKey(originalFile.getOriginalCheckman());
                checkMan = teachCheck.getUsername();
            }

            if(originalFile.getOriginalName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(item.getUserId());
                file.setUsernum(item.getUsernum());
                file.setUsername(item.getUsername());
                file.setMajor(item.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(originalFile.getOriginalName());
                file.setFilePath(originalFile.getOriginalPath());
                file.setFileCheck(originalFile.getOriginalCheck());
                file.setFileOpinion(originalFile.getOriginalOpinion());
                file.setFileCheckman(checkMan);

                originalListSearchVO.add(file);
            }
        }
        PageInfo pageInfoOriginalSearch = new PageInfo<>(originalListSearchVO);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoOriginalSearch",pageInfoOriginalSearch);
        map.put("originalListSearchVO",originalListSearchVO);
        return map;

    }

    /**
     * 根据管理员UserId获取当前年份的文献综述
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> literatureFileList(int page, int limit, Long userId, String schoolYear) {

        LiteratureFileExample literatureFileExample = new LiteratureFileExample();
        LiteratureFileExample.Criteria criteria = literatureFileExample.createCriteria();
        criteria.andLiteratureYearEqualTo(schoolYear);
        PageHelper.startPage(page,limit);
        List<LiteratureFile> literatureFileList = literatureFileMapper.selectByExample(literatureFileExample);

        List<FilesListVO> literatureListVO = new ArrayList<>();
        User admin = userMapper.selectByPrimaryKey(userId);
        for(LiteratureFile item:literatureFileList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(item.getLiteratureCheckman() == null){
                checkMan = null;
            }else{
                User checkTeach = userMapper.selectByPrimaryKey(item.getLiteratureCheckman());
                checkMan = checkTeach.getUsername();
            }

            if(stu.getCollege().equals(admin.getCollege()) && item.getLiteratureName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(item.getLiteratureName());
                file.setFilePath(item.getLiteraturePath());
                file.setFileCheck(item.getLiteratureCheck());
                file.setFileOpinion(item.getLiteratureOpinion());
                file.setFileCheckman(checkMan);
                literatureListVO.add(file);

            }
        }
        PageInfo pageInfoLiterature = new PageInfo(literatureFileList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoLiterature",pageInfoLiterature);
        map.put("literatureListVO",literatureListVO);
        return map;
    }

    /**
     * 根据关键字查询文献综述
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchLiteratureFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);
        User admin = userMapper.selectByPrimaryKey(userId);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andCollegeEqualTo(admin.getCollege());
        criteria.andUsernumEqualTo(searchValue);
        userExample.or().andUsernameLike("%"+searchValue+"%");

        List<User> userList = userMapper.selectByExample(userExample);
        List<FilesListVO> literatureListSearch = new ArrayList<>();

        for(User item:userList){
            LiteratureFile literatureFile = literatureFileMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            if (choose == null){
                continue;
            }

            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(literatureFile.getLiteratureCheckman() == null){
                checkMan = null;
            }else{
                User teachMan = userMapper.selectByPrimaryKey(literatureFile.getLiteratureCheckman());
                checkMan = teachMan.getUsername();
            }

            if(literatureFile.getLiteratureName() != null) {
                FilesListVO file = new FilesListVO();
                file.setUserId(item.getUserId());
                file.setUsernum(item.getUsernum());
                file.setUsername(item.getUsername());
                file.setMajor(item.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(literatureFile.getLiteratureName());
                file.setFilePath(literatureFile.getLiteraturePath());
                file.setFileCheck(literatureFile.getLiteratureCheck());
                file.setFileOpinion(literatureFile.getLiteratureOpinion());
                file.setFileCheckman(checkMan);

                literatureListSearch.add(file);
            }

        }
        PageInfo pageInfoLiteratureSearch = new PageInfo(literatureListSearch);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoLiteratureSearch",pageInfoLiteratureSearch);
        map.put("literatureListSearch",literatureListSearch);
        return map;

    }

    /**
     * 根据管理员userId获取当前年份毕业论文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> thesisFileList(int page, int limit, Long userId, String schoolYear) {


        ThesisFileExample thesisFileExample = new ThesisFileExample();
        ThesisFileExample.Criteria criteria = thesisFileExample.createCriteria();
        criteria.andThesisYearEqualTo(schoolYear);
        PageHelper.startPage(page,limit);
        List<ThesisFile> thesisFileList = thesisFileMapper.selectByExample(thesisFileExample);
        List<FilesListVO> thesisFileListVO = new ArrayList<>();

        User admin = userMapper.selectByPrimaryKey(userId);

        for(ThesisFile item:thesisFileList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(item.getThesisCheckman() == null){
                checkMan = null;
            }else{
                User teachMan = userMapper.selectByPrimaryKey(item.getThesisCheckman());
                checkMan = teachMan.getUsername();
            }

            if(stu.getCollege().equals(admin.getCollege()) && item.getThesisName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(item.getThesisName());
                file.setFilePath(item.getThesisPath());
                file.setFileCheck(item.getThesisCheck());
                file.setFileOpinion(item.getThesisOpinion());
                file.setFileCheckman(checkMan);

                thesisFileListVO.add(file);
            }
        }

        PageInfo pageInfoThesis = new PageInfo(thesisFileList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoThesis",pageInfoThesis);
        map.put("thesisFileListVO",thesisFileListVO);
        return map;

    }

    /**
     * 根据关键字查询毕业论文
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchThesisFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);

        User admin = userMapper.selectByPrimaryKey(userId);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andCollegeEqualTo(admin.getCollege());
        criteria.andUsernumEqualTo(searchValue);
        userExample.or().andUsernameLike("%"+searchValue+"%");

        List<User> userList = userMapper.selectByExample(userExample);
        List<FilesListVO> thesisListSearchVO = new ArrayList<>();

        for (User item:userList){
            ThesisFile thesisFile = thesisFileMapper.selectByPrimaryKey(item.getUserId());

            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            if(choose == null){
                continue;
            }

            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            String checkMan;
            if(thesisFile.getThesisCheckman() == null){
                checkMan = null;
            }else{
                User teachMan = userMapper.selectByPrimaryKey(thesisFile.getThesisCheckman());
                checkMan = teachMan.getUsername();
            }

            if(thesisFile.getThesisName() != null){
                FilesListVO file = new FilesListVO();
                file.setUserId(item.getUserId());
                file.setUsernum(item.getUsernum());
                file.setUsername(item.getUsername());
                file.setMajor(item.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setFileName(thesisFile.getThesisName());
                file.setFilePath(thesisFile.getThesisPath());
                file.setFileCheck(thesisFile.getThesisCheck());
                file.setFileOpinion(thesisFile.getThesisOpinion());
                file.setFileCheckman(checkMan);

                thesisListSearchVO.add(file);
            }

        }
        PageInfo pageInfoThesisSearch = new PageInfo<>(thesisListSearchVO);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoThesisSearch",pageInfoThesisSearch);
        map.put("thesisListSearchVO",thesisListSearchVO);
        return map;
    }

    /**
     * 根据管理员id获取当前学年指导记录
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> guidanceFileList(int page, int limit, Long userId, String schoolYear) {

        User admin = userMapper.selectByPrimaryKey(userId);
        PageHelper.startPage(page,limit);
        ChooseExample chooseExample = new ChooseExample();
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);
        List<GuiAndPlanFileVO> guidanceListVO = new ArrayList<>();

        for(Choose item: chooseList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(item.getTitleId());

            GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
            GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
            criteria.andUserIdEqualTo(item.getUserId());
            List<GuidanceFile> guidanceFileList = guidanceFileMapper.selectByExample(guidanceFileExample);
            GuidanceFile guidanceFile = guidanceFileList.get(0);
            Integer count = guidanceFileList.size();
            LOGGER.info(String.valueOf(count));

            if(stu.getCollege().equals(admin.getCollege()) && guidanceFile.getGuidanceName() != null && guidanceFile.getGuidanceYear().equals(schoolYear)){
                GuiAndPlanFileVO file = new GuiAndPlanFileVO();
                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setCount(count);

                guidanceListVO.add(file);
            }

        }
        PageInfo pageInfoGuidance = new PageInfo(chooseList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoGuidance",pageInfoGuidance);
        map.put("guidanceListVO",guidanceListVO);
        return map;
    }

    /**
     * 根据关键字查询指导记录
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchGuidanceFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
       PageHelper.startPage(page,limit);

       User admin = userMapper.selectByPrimaryKey(userId);

       UserExample userExample = new UserExample();
       UserExample.Criteria criteria = userExample.createCriteria();
       criteria.andSchoolYearEqualTo(schoolYear);
       criteria.andCollegeEqualTo(admin.getCollege());
       criteria.andUsernumEqualTo(searchValue);
       userExample.or().andUsernameLike("%"+searchValue+"%");
       List<User> userList = userMapper.selectByExample(userExample);

       List<GuiAndPlanFileVO> guidanceListSearchVO = new ArrayList<>();

       for(User item:userList){
           Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
           if(choose == null){
               continue;
           }
           Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

           GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
           GuidanceFileExample.Criteria criteria1 = guidanceFileExample.createCriteria();
           criteria1.andUserIdEqualTo(choose.getUserId());
           List<GuidanceFile> guidanceFileList = guidanceFileMapper.selectByExample(guidanceFileExample);
           GuidanceFile guidanceFile = guidanceFileList.get(0);
           Integer count = guidanceFileList.size();
           LOGGER.info(String.valueOf(count));

           if(guidanceFile.getGuidanceName() != null){
               GuiAndPlanFileVO file = new GuiAndPlanFileVO();
               file.setUserId(item.getUserId());
               file.setUsernum(item.getUsernum());
               file.setUsername(item.getUsername());
               file.setMajor(item.getMajor());
               file.setTitleId(titles.getTitleId());
               file.setTitleName(titles.getTitleName());
               file.setTeachName(titles.getUserName());
               file.setCount(count);

               guidanceListSearchVO.add(file);
           }

       }

       PageInfo pageInfoGuidanceSearch = new PageInfo<>(guidanceListSearchVO);
       Map<String, Object> map = new HashMap<>();
       map.put("pageInfoGuidanceSearch",pageInfoGuidanceSearch);
       map.put("guidanceListSearchVO",guidanceListSearchVO);
       return map;

    }

    /**
     * 根据管理员id获取当前学年进度计划
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> planFileList(int page, int limit, Long userId, String schoolYear) {

        User admin = userMapper.selectByPrimaryKey(userId);

        ChooseExample chooseExample = new ChooseExample();
        PageHelper.startPage(page,limit);
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);
        List<GuiAndPlanFileVO> planListVO = new ArrayList<>();

        for(Choose item:chooseList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(item.getTitleId());

            PlanFileExample planFileExample = new PlanFileExample();
            PlanFileExample.Criteria criteria = planFileExample.createCriteria();
            criteria.andUserIdEqualTo(item.getUserId());
            List<PlanFile> planFileList = planFileMapper.selectByExample(planFileExample);
            PlanFile planFile = planFileList.get(0);
            Integer count = planFileList.size();

            if(stu.getCollege().equals(admin.getCollege()) && planFile.getPlanName() != null && planFile.getPlanYear().equals(schoolYear)){
                GuiAndPlanFileVO file = new GuiAndPlanFileVO();
                file.setUserId(stu.getUserId());
                file.setUsernum(stu.getUsernum());
                file.setUsername(stu.getUsername());
                file.setMajor(stu.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setCount(count);

                planListVO.add(file);
            }
        }
        PageInfo pageInfoPlan = new PageInfo(chooseList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoPlan",pageInfoPlan);
        map.put("planListVO",planListVO);
        return map;
    }

    /**
     * 根据关键词查询进度计划
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchPlanFile(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);

        User admin = userMapper.selectByPrimaryKey(userId);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andCollegeEqualTo(admin.getCollege());
        criteria.andUsernumEqualTo(searchValue);
        userExample.or().andUsernameLike("%"+searchValue+"%");
        List<User> userList = userMapper.selectByExample(userExample);
        List<GuiAndPlanFileVO> planListSearchVO = new ArrayList<>();

        for(User item:userList){
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());

            if(choose == null){
                continue;
            }
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            PlanFileExample planFileExample = new PlanFileExample();
            PlanFileExample.Criteria criteria1 = planFileExample.createCriteria();
            criteria1.andUserIdEqualTo(choose.getUserId());
            List<PlanFile> planFileList = planFileMapper.selectByExample(planFileExample);
            PlanFile planFile = planFileList.get(0);
            Integer count = planFileList.size();

            if(planFile.getPlanName() != null){
                GuiAndPlanFileVO file = new GuiAndPlanFileVO();
                file.setUserId(item.getUserId());
                file.setUsernum(item.getUsernum());
                file.setUsername(item.getUsername());
                file.setMajor(item.getMajor());
                file.setTitleId(titles.getTitleId());
                file.setTitleName(titles.getTitleName());
                file.setTeachName(titles.getUserName());
                file.setCount(count);

                planListSearchVO.add(file);
            }

        }

        PageInfo pageInfoPlanSearch = new PageInfo(planListSearchVO);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoPlanSearch",pageInfoPlanSearch);
        map.put("planListSearchVO",planListSearchVO);
        return map;

    }

    /**
     * 根据学生userId获取学生提交的指导记录
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> guiDetailList(int page, int limit, Long userId) {

        GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
        GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        PageHelper.startPage(page,limit);
        List<GuidanceFile> guidanceFileList = guidanceFileMapper.selectByExample(guidanceFileExample);

        List<GuidanceItemDetail> guidanceDetailList = new ArrayList<>();

        for(GuidanceFile item: guidanceFileList){
            GuidanceItemDetail file = new GuidanceItemDetail();
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(item.getGuidanceCheckMan() == null){
                checkMan = null;
            }else{
                User teachCheck = userMapper.selectByPrimaryKey(item.getGuidanceCheckMan());
                checkMan = teachCheck.getUsername();
            }

            file.setUserId(item.getUserId());
            file.setGuidanceId(item.getGuidanceId());
            file.setGuidanceName(item.getGuidanceName());
            file.setGuidancePath(item.getGuidancePath());
            file.setGuidanceDate(item.getGuidanceDate());
            file.setGuidanceForm(item.getGuidanceForm());
            file.setGuidanceValue(item.getGuidanceValue());
            file.setGuidanceCheck(item.getGuidanceCheck());
            file.setGuidanceOpinion(item.getGuidanceOpinion());
            file.setGuidanceCheckman(checkMan);
            file.setUsernum(stu.getUsernum());
            file.setUsername(stu.getUsername());
            file.setTitleName(titles.getTitleName());
            file.setTeachName(titles.getUserName());
            guidanceDetailList.add(file);
        }
        PageInfo pageInfoGuidanceDetail = new PageInfo(guidanceFileList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoGuidanceDetail",pageInfoGuidanceDetail);
        map.put("guidanceDetailList",guidanceDetailList);
        return map;
    }

    /**
     * 获取个人进度计划列表
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> planDetailList(int page, int limit, Long userId) {
        PlanFileExample planFileExample = new PlanFileExample();
        PlanFileExample.Criteria criteria = planFileExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        PageHelper.startPage(page,limit);
        List<PlanFile> planFileList = planFileMapper.selectByExample(planFileExample);

        List<PlanItemDetail> planDetailList = new ArrayList<>();

        for (PlanFile item:planFileList){
            PlanItemDetail file = new PlanItemDetail();
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());

            String checkMan;
            if(item.getPlanCheckMan() == null){
                checkMan = null;
            }else{
                User teachMan = userMapper.selectByPrimaryKey(item.getPlanCheckMan());
                checkMan = teachMan.getUsername();
            }

            file.setPlanId(item.getPlanId());
            file.setUserId(item.getUserId());
            file.setPlanName(item.getPlanName());
            file.setPlanPath(item.getPlanPath());
            file.setPlanStart(item.getPlanStart());
            file.setPlanEnd(item.getPlanEnd());
            file.setPlanValue(item.getPlanValue());
            file.setActualValue(item.getActualValue());
            file.setPlanCheck(item.getPlanCheck());
            file.setPlanOpinion(item.getPlanOpinion());
            file.setPlanCheckman(checkMan);
            file.setUsernum(stu.getUsernum());
            file.setUsername(stu.getUsername());
            file.setTitleName(titles.getTitleName());
            file.setTeachName(titles.getUserName());

            planDetailList.add(file);
        }
        PageInfo pageInfoPlanDetail = new PageInfo<>(planFileList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoPlanDetail",pageInfoPlanDetail);
        map.put("planDetailList",planDetailList);
        return map;

    }

    /**
     * 获取学生选题列表
     * @param page
     * @param limit
     * @param
     * @return
     */
    @Override
    public Map<String, Object> getChooseTitleList(int page, int limit,Long userId,String schoolYear) {

        User admin = userMapper.selectByPrimaryKey(userId);
        ChooseExample chooseExample = new ChooseExample();
        ChooseExample.Criteria criteria = chooseExample.createCriteria();
        criteria.andStateEqualTo("教师已确认");
        PageHelper.startPage(page,limit);
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);
        List<ChooseTitleDetailVO> chooseTitle = new ArrayList<>();
        for (Choose item:chooseList){
            Titles titles = titlesMapper.selectByPrimaryKey(item.getTitleId());
            User student = userMapper.selectByPrimaryKey(item.getUserId());
            StartFile file = startFileMapper.selectByPrimaryKey(item.getUserId());

            String expertMan;
            if(file.getStartCheckman() == null){
                expertMan = null;
            }else{
                User checkMan = userMapper.selectByPrimaryKey(file.getStartCheckman());
                expertMan = checkMan.getUsername();
            }

            if(student.getCollege().equals(admin.getCollege()) && student.getSchoolYear().equals(schoolYear)){
                ChooseTitleDetailVO list = new ChooseTitleDetailVO();
                list.setTitleId(titles.getTitleId());
                list.setTitleName(titles.getTitleName());
                list.setTeachName(titles.getUserName());
                list.setState(item.getState());
                list.setTitleMajor(titles.getTitleMajor());
                list.setUserId(item.getUserId());
                list.setUsernum(student.getUsernum());
                list.setUsername(student.getUsername());
                list.setMajor(student.getMajor());
                list.setCollege(student.getCollege());
                list.setExpertMan(expertMan);

                chooseTitle.add(list);
            }
        }
        PageInfo pageInfoChoose = new PageInfo<>(chooseList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoChoose",pageInfoChoose);
        map.put("chooseTitle",chooseTitle);
        return map;
    }

    /**
     * 根据关键词学生学号，姓名查询选题消息
     * @param page
     * @param limit
     * @param userId
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchChooseTitle(int page, int limit, Long userId, String schoolYear, String searchValue) {
        PageHelper.startPage(page,limit);

        User admin = userMapper.selectByPrimaryKey(userId);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andCollegeEqualTo(admin.getCollege());
        criteria.andUsernumEqualTo(searchValue);
        userExample.or().andUsernameLike("%"+searchValue+"%");
        List<User> userList = userMapper.selectByExample(userExample);

        List<ChooseTitleDetailVO> searchChooseList = new ArrayList<>();

        for (User item: userList){
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            if(choose == null){
                continue;
            }
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            StartFile file = startFileMapper.selectByPrimaryKey(item.getUserId());

            String expertMan;
            if(file.getStartCheckman() == null){
                expertMan = null;
            }else{
                User checkMan = userMapper.selectByPrimaryKey(file.getStartCheckman());
                expertMan = checkMan.getUsername();
            }

            ChooseTitleDetailVO list = new ChooseTitleDetailVO();
            list.setTitleId(titles.getTitleId());
            list.setTitleName(titles.getTitleName());
            list.setTeachName(titles.getUserName());
            list.setState(choose.getState());
            list.setTitleMajor(titles.getTitleMajor());
            list.setUserId(item.getUserId());
            list.setUsernum(item.getUsernum());
            list.setUsername(item.getUsername());
            list.setMajor(item.getMajor());
            list.setCollege(item.getCollege());
            list.setExpertMan(expertMan);

            searchChooseList.add(list);
        }
        PageInfo pageInfoChooseSearch = new PageInfo<>(searchChooseList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoChooseSearch",pageInfoChooseSearch);
        map.put("searchChooseList",searchChooseList);
        return map;
    }

    /**
     * 为评阅专家分配待评阅学生
     * @param
     * @return
     */
    @Override
    public boolean setStuToExpert(IdAndNameDTO idAndNameDTO) {
        Long[] userIds = idAndNameDTO.getId();
        try {
            for (Long id:userIds){
                StartFile startFile = startFileMapper.selectByPrimaryKey(id);
                startFile.setStartCheckman(idAndNameDTO.getTeachId());
                startFileMapper.updateByPrimaryKeySelective(startFile);

                MiddleFile middleFile = middleFileMapper.selectByPrimaryKey(id);
                middleFile.setMiddleCheckman(idAndNameDTO.getTeachId());
                middleFileMapper.updateByPrimaryKeySelective(middleFile);

                TranslationFile translationFile = translationFileMapper.selectByPrimaryKey(id);
                translationFile.setTranslationCheckman(idAndNameDTO.getTeachId());
                translationFileMapper.updateByPrimaryKeySelective(translationFile);

                OriginalFile originalFile = originalFileMapper.selectByPrimaryKey(id);
                originalFile.setOriginalCheckman(idAndNameDTO.getTeachId());
                originalFileMapper.updateByPrimaryKeySelective(originalFile);

                LiteratureFile literatureFile = literatureFileMapper.selectByPrimaryKey(id);
                literatureFile.setLiteratureCheckman(idAndNameDTO.getTeachId());
                literatureFileMapper.updateByPrimaryKeySelective(literatureFile);

                ThesisFile thesisFile = thesisFileMapper.selectByPrimaryKey(id);
                thesisFile.setThesisCheckman(idAndNameDTO.getTeachId());
                thesisFileMapper.updateByPrimaryKeySelective(thesisFile);

                GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
                GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
                criteria.andUserIdEqualTo(id);
                List<GuidanceFile> guidanceList = guidanceFileMapper.selectByExample(guidanceFileExample);

                for(GuidanceFile guidance:guidanceList){
                    guidance.setGuidanceCheckMan(idAndNameDTO.getTeachId());
                    guidanceFileMapper.updateByPrimaryKeySelective(guidance);
                }

                PlanFileExample planFileExample = new PlanFileExample();
                PlanFileExample.Criteria criteria1 = planFileExample.createCriteria();
                criteria1.andUserIdEqualTo(id);
                List<PlanFile> planList = planFileMapper.selectByExample(planFileExample);

                for(PlanFile plan: planList){
                    plan.setPlanCheckMan(idAndNameDTO.getTeachId());
                    planFileMapper.updateByPrimaryKeySelective(plan);
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 根据管理员userId获取当前学年同一学院评阅专家
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public List<TeachListVO> getExpertList(Long userId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(userId);
        String expert = "expert";
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleLike("%"+expert+"%");
        List<Role> roles = roleMapper.selectByExample(roleExample);
        List<TeachListVO> expertList = new ArrayList<>();
        for(Role item: roles){
            User user = userMapper.selectByPrimaryKey(item.getUserId());

            if(user.getCollege().equals(admin.getCollege()) && user.getSchoolYear().equals(schoolYear)){
                TeachListVO listVO = new TeachListVO();
                listVO.setUserId(user.getUserId());
                listVO.setUsernum(user.getUsernum());
                listVO.setUsername(user.getUsername());
                listVO.setCollege(user.getCollege());
                listVO.setPosition(user.getPosition());
                expertList.add(listVO);
            }
        }
        return expertList;
    }

    /**
     * 导出分数
     * @return
     */
    @Override
    public XSSFWorkbook exportScore() {
        ScoreExample scoreExample = new ScoreExample();
        List<Score> list = scoreMapper.selectByExample(scoreExample);

        XSSFWorkbook wb = new XSSFWorkbook();

        //创建一张表
        Sheet sheet = wb.createSheet("Score");
        //创建第一行
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("学号");
        titleRow.createCell(1).setCellValue("姓名");
        titleRow.createCell(2).setCellValue("所选题目");
        titleRow.createCell(3).setCellValue("指导成绩");
        titleRow.createCell(4).setCellValue("指导评语");
        titleRow.createCell(5).setCellValue("评阅成绩");
        titleRow.createCell(6).setCellValue("评阅评语");
        titleRow.createCell(7).setCellValue("答辩成绩");
        titleRow.createCell(8).setCellValue("答辩评语");
        titleRow.createCell(9).setCellValue("总成绩");

        int cell = 1;
        for(Score item: list){
            User user = userMapper.selectByPrimaryKey(item.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            if(item.getGuidanceScore() != null || item.getReadScore() != null || item.getDefenceScore() != null){
                Row row = sheet.createRow(cell);
                row.createCell(0).setCellValue(user.getUsernum());
                row.createCell(1).setCellValue(user.getUsername());
                row.createCell(2).setCellValue(titles.getTitleName());
                if(item.getGuidanceScore() == null){
                    row.createCell(3).setCellValue("");
                }else{
                    row.createCell(3).setCellValue(item.getGuidanceScore());
                }
                if(item.getGuidancdValue() == null){
                    row.createCell(4).setCellValue("");
                }else{
                    row.createCell(4).setCellValue(item.getGuidancdValue());
                }

                if(item.getReadScore() == null){
                    row.createCell(5).setCellValue("");
                }else{
                    row.createCell(5).setCellValue(item.getReadScore());
                }

                if(item.getReadValue() == null){
                    row.createCell(6).setCellValue("");
                }else{
                    row.createCell(6).setCellValue(item.getReadValue());
                }

                if(item.getDefenceScore() == null){
                    row.createCell(7).setCellValue("");
                }else{
                    row.createCell(7).setCellValue(item.getDefenceScore());
                }

                if(item.getDefenceValue() == null){
                    row.createCell(8).setCellValue("");
                }else{
                    row.createCell(8).setCellValue(item.getDefenceValue());
                }

                if(item.getTotal() == null){
                    row.createCell(9).setCellValue("");
                }else{
                    row.createCell(9).setCellValue(item.getTotal());
                }
                cell++;
            }

        }
        return wb;
    }
}
