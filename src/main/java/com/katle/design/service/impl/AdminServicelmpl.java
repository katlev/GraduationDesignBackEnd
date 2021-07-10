package com.katle.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dao.*;
import com.katle.design.dto.*;
import com.katle.design.entities.*;
import com.katle.design.service.AdminService;
import com.katle.design.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Supplier;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


@Service
public class AdminServicelmpl implements AdminService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private TitlesMapper titlesMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private ChooseMapper chooseMapper;
    @Resource
    private DefenceMapper defenceMapper;
    @Resource
    private OpenidMapper openidMapper;
    @Resource
    private SemesterMapper semesterMapper;


    /**
     * 教师账号添加
     * @param usernum
     * @param username
     * @param password
     * @param position
     * @param college
     * @param email
     * @return
     */
    @Override
    public boolean addTeachAccount(String usernum, String username, String password, String position, String college, String email,String schoolYear) {
        /*将教师账号插入用户表*/
        User user = new User();
        user.setUsernum(usernum);
        user.setUsername(username);
        user.setPassword(password);
        user.setPosition(position);
        user.setCollege(college);
        user.setEmail(email);
        user.setSchoolYear(schoolYear);
        userMapper.insertSelective(user);
        /*根据输入的学号查询用户输入的id*/
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernumEqualTo(usernum);
        User userItem = userMapper.selectByExample(userExample).get(0);
        /*获取用户id*/
        Long userId = userItem.getUserId();
        /*根据用户id将teach身份插入到角色表和权限表*/
        Role role = new Role();
        role.setUserId(userId);
        role.setRole("teacher");
        roleMapper.insertSelective(role);

        Openid openid = new Openid();
        openid.setUserId(userId);
        openidMapper.insertSelective(openid);

        Permission permission = new Permission();
        permission.setUserId(userId);
        permission.setPermission("study");

        return permissionMapper.insertSelective(permission)>0;
    }

    /**
     * 学生账号添加
     * @param usernum
     * @param username
     * @param password
     * @param grade
     * @param college
     * @param major
     * @return
     */
    @Override
    public boolean addStuAccount(String usernum, String username, String password, String grade, String college, String major,String schoolYear) {
        /*将学生账户插入到用户表中*/
        User user = new User();
        user.setUsernum(usernum);
        user.setUsername(username);
        user.setPassword(password);
        user.setGrade(grade);
        user.setCollege(college);
        user.setMajor(major);
        user.setSchoolYear(schoolYear);
        userMapper.insertSelective(user);
        /*根据学号查询用户表中学生id*/
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernumEqualTo(usernum);
        User userItem = userMapper.selectByExample(userExample).get(0);

        Long userId = userItem.getUserId();

        /*将查到的学生id插入到角色表和权限表中中*/
        Role role = new Role();
        role.setUserId(userId);
        role.setRole("student");
        roleMapper.insertSelective(role);

        Openid openid = new Openid();
        openid.setUserId(userId);
        openidMapper.insertSelective(openid);

        Permission permission = new Permission();
        permission.setUserId(userId);
        permission.setPermission("study");
        return permissionMapper.insertSelective(permission)>0;

    }

    /**
     * 修改学号账号
     * @param userId
     * @param usernum
     * @param username
     * @param password
     * @param grade
     * @param college
     * @param major
     * @return
     */
    @Override
    public User updateStuInfo(Long userId,String usernum, String username, String password, String grade, String college, String major) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUsernum(usernum);
        user.setUsername(username);
        user.setPassword(password);
        user.setGrade(grade);
        user.setCollege(college);
        user.setMajor(major);

        userMapper.updateByPrimaryKeySelective(user);

        return user;
    }

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
    @Override
    public User updateTeachInfo(Long userId, String usernum, String username, String password, String position, String college, String email) {
        User user = userMapper.selectByPrimaryKey(userId);

        user.setUsernum(usernum);
        user.setUsername(username);
        user.setPassword(password);
        user.setPosition(position);
        user.setCollege(college);
        user.setEmail(email);

        userMapper.updateByPrimaryKeySelective(user);

        return user;
    }

    /**
     * 根据管理员userId获取相应学院学生列表
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> studentVoList(int page,int limit,Long userId,String schoolYear) {
        User admi = userMapper.selectByPrimaryKey(userId);
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleEqualTo("student");
        PageHelper.startPage(page,limit);
        List<Role> userList = roleMapper.selectByExample(roleExample);
        List<StuListVO> stuListVO = new ArrayList<>();

        for(Role item:userList){

            UserExample userExample = new UserExample();
            UserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andUserIdEqualTo(item.getUserId());
            criteria1.andSchoolYearEqualTo(schoolYear);
            criteria1.andCollegeEqualTo(admi.getCollege());
            List<User> list = userMapper.selectByExample(userExample);

            for(User user:list){
                LOGGER.info(user.getUsername());
                StuListVO stuVo = new StuListVO();

                stuVo.setUserId(user.getUserId());
                stuVo.setUsernum(user.getUsernum());
                stuVo.setUsername(user.getUsername());
                stuVo.setPassword(user.getPassword());
                stuVo.setGrade(user.getGrade());
                stuVo.setCollege(user.getCollege());
                stuVo.setMajor(user.getMajor());
                stuVo.setRole(item.getRole());
                stuListVO.add(stuVo);

            }
        }

        PageInfo pageInfoStu = new PageInfo<>(userList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoStu",pageInfoStu);
        map.put("stuListVO",stuListVO);
        return map;

    }

    /**
     * 根据管理员userId获取相应学院教师账号列表
     * @param userId
     * @return
     */
    @Override
    public Map<String,Object> teachVoList(int page,int limit,Long userId,String schoolYear) {
        User admi = userMapper.selectByPrimaryKey(userId);
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        String teacher = "teacher";
        criteria.andRoleLike("%"+teacher+"%");
        PageHelper.startPage(page,limit);
        List<Role> userList = roleMapper.selectByExample(roleExample);
        List<TeachListVO> teachListVO = new ArrayList<>();

        for (Role item:userList){

            UserExample userExample = new UserExample();
            UserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andUserIdEqualTo(item.getUserId());
            criteria1.andSchoolYearEqualTo(schoolYear);
            criteria1.andCollegeEqualTo(admi.getCollege());
            List<User> list = userMapper.selectByExample(userExample);

            for(User user:list){
                TeachListVO teachVO = new TeachListVO();

                teachVO.setUserId(user.getUserId());
                teachVO.setUsernum(user.getUsernum());
                teachVO.setUsername(user.getUsername());
                teachVO.setPassword(user.getPassword());
                teachVO.setPosition(user.getPosition());
                teachVO.setCollege(user.getCollege());
                teachVO.setEmail(user.getEmail());
                teachVO.setRole(item.getRole());
                teachListVO.add(teachVO);

            }
        }
        PageInfo pageInfoTeach = new PageInfo<>(userList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoTeach",pageInfoTeach);
        map.put("teachListVO",teachListVO);
        return map;
    }

    /**
     * 账号删除
     * @param userIdDTO
     * @return
     */
    @Override
    public boolean deleteStudent(UserIdDTO userIdDTO) {
        Long[] userId = userIdDTO.getUserId();
        for (Long id:userId){
            userMapper.deleteByPrimaryKey(id);
            roleMapper.deleteByPrimaryKey(id);
            permissionMapper.deleteByPrimaryKey(id);
            openidMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    /**
     * 学生账号查询
     * @param page
     * @param limit
     * @param usernum
     * @param username
     * @param grade
     * @param major
     * @return
     */
    @Override
    public Map<String, Object> findStuVoList(int page,int limit,Long userId,String usernum,String username,String grade,String major,String schoolYear) {
        User admi = userMapper.selectByPrimaryKey(userId);

        PageHelper.startPage(page,limit);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andCollegeEqualTo(admi.getCollege());
        if (null != usernum && !"".equals(usernum.trim())){
            criteria.andUsernumLike("%"+usernum+"%");
        }
        if (null != username && !"".equals(username.trim())){
            criteria.andUsernameLike("%"+username+"%");
        }
        if (null != grade && !"".equals(grade.trim())){
            criteria.andGradeLike("%"+grade+"%");
        }
        if (null != major && !"".equals(major.trim())){
            criteria.andMajorLike("%"+major+"%");
        }
        List<User> userList = userMapper.selectByExample(userExample);
        List<StuListVO> stuFindListVO = new ArrayList<>();

        for(User user:userList){
            Role role = roleMapper.selectByPrimaryKey(user.getUserId());
            StuListVO stuVO = new StuListVO();
            String value = "student";
            if(role.getRole().equals(value) && user.getSchoolYear().equals(schoolYear)){
                stuVO.setUserId(user.getUserId());
                stuVO.setUsernum(user.getUsernum());
                stuVO.setUsername(user.getUsername());
                stuVO.setPassword(user.getPassword());
                stuVO.setGrade(user.getGrade());
                stuVO.setCollege(user.getCollege());
                stuVO.setMajor(user.getMajor());
                stuVO.setRole(role.getRole());

                stuFindListVO.add(stuVO);
            }
        }
        PageInfo pageInfo = new PageInfo<>(stuFindListVO);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo",pageInfo);
        map.put("stuFindListVO",stuFindListVO);
        return map;
    }

    /**
     * 教师账号查询
     * @param page
     * @param limit
     * @param usernum
     * @param username
     * @param position
     * @param userId 管理员userId
     * @return
     */
    @Override
    public Map<String, Object> findTeachVoList(int page, int limit, Long userId, String usernum,String username,String position,String schoolYear) {
        PageHelper.startPage(page,limit);
        User admi = userMapper.selectByPrimaryKey(userId);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (null != usernum && !"".equals(usernum.trim())){
            criteria.andUsernumLike("%"+usernum+"%");
        }
        if (null != username && !"".equals(username.trim())){
            criteria.andUsernameLike("%"+username+"%");
        }
        if (null != position && !"".equals(position.trim())){
            criteria.andPositionLike("%"+position+"%");
        }

        List<User> userList = userMapper.selectByExample(userExample);
        List<TeachListVO> teachFindListVO = new ArrayList<>();

        for(User user:userList){
            Role role = roleMapper.selectByPrimaryKey(user.getUserId());
            TeachListVO teachVO = new TeachListVO();
            String value = "teacher";
            String identity = role.getRole();
            String[] arr = identity.split(",");
            String firstRole = arr[0];

            if(firstRole.equals(value) && user.getSchoolYear().equals(schoolYear)){
                teachVO.setUserId(user.getUserId());
                teachVO.setUsernum(user.getUsernum());
                teachVO.setUsername(user.getUsername());
                teachVO.setPosition(user.getPosition());
                teachVO.setPassword(user.getPassword());
                teachVO.setCollege(user.getCollege());
                teachVO.setEmail(user.getEmail());
                teachVO.setRole(role.getRole());

                teachFindListVO.add(teachVO);
            }
        }
        PageInfo pageInfo = new PageInfo<>(teachFindListVO);
        Map<String, Object> map= new HashMap<>();
        map.put("pageInfo",pageInfo);
        map.put("teachFindListVO",teachFindListVO);

        return map;
    }

    /**
     * 根据管理员userId获取相应学院教师开题列表
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getTitleVoList(int page, int limit,Long userId,String titleSemester) {
        PageHelper.startPage(page,limit);
        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andTitleSemesterEqualTo(titleSemester);
        List<Titles> topicList = titlesMapper.selectByExample(titlesExample);
        List<TitleListVO> titleListVO = new ArrayList<>();

        for (Titles topic:topicList){
            User admi = userMapper.selectByPrimaryKey(userId);
            User user = userMapper.selectByPrimaryKey(topic.getUserId());
            TitleListVO titleVO = new TitleListVO();
            String checkMan;
            if(topic.getTitleCheckman() == null){
                checkMan = null;
            }else{
                User checkTeach = userMapper.selectByPrimaryKey(topic.getTitleCheckman());
                checkMan = checkTeach.getUsername();
            }

            if(user.getCollege().equals(admi.getCollege())){
                titleVO.setTitleId(topic.getTitleId());
                titleVO.setUserId(topic.getUserId());
                titleVO.setTitleName(topic.getTitleName());
                titleVO.setUsername(user.getUsername());
                titleVO.setCollege(user.getCollege());
                titleVO.setTitleKind(topic.getTitleKind());
                titleVO.setTitleYear(topic.getTitleYear());
                titleVO.setTitleState(topic.getTitleState());
                titleVO.setCheckTeach(checkMan);


                titleListVO.add(titleVO);
            }
        }
        PageInfo pageInfoTopic = new PageInfo<>(topicList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoTopic",pageInfoTopic);
        map.put("titleListVO",titleListVO);

        return map;
    }

    /**
     * 题目详情,根据题目id获取题目详情
     * @param topicId
     * @return
     */
    @Override
    public TitleDetailVO topicDetailVO(Long topicId) {
        Titles topic = titlesMapper.selectByPrimaryKey(topicId);
        Long userId = topic.getUserId();
        User user = userMapper.selectByPrimaryKey(userId);

        TitleDetailVO titleDetailVO = new TitleDetailVO();
        titleDetailVO.setTitleId(topic.getTitleId());
        titleDetailVO.setUserId(topic.getUserId());
        titleDetailVO.setTitleName(topic.getTitleName());
        titleDetailVO.setTitleKind(topic.getTitleKind());
        titleDetailVO.setTitleSource(topic.getTitleSource());
        titleDetailVO.setTitleModel(topic.getTitleModel());
        titleDetailVO.setUsername(user.getUsername());
        titleDetailVO.setPosition(user.getPosition());
        titleDetailVO.setCollege(user.getCollege());
        titleDetailVO.setEmail(user.getEmail());
        titleDetailVO.setTitleYear(topic.getTitleYear());
        titleDetailVO.setTitleState(topic.getTitleState());
        titleDetailVO.setTitleMajor(topic.getTitleMajor());
        titleDetailVO.setTitleType(topic.getTitleType());
        titleDetailVO.setTitleComplete(topic.getTitleComplete());
        titleDetailVO.setTitleValue(topic.getTitleValue());
        titleDetailVO.setTitleRequire(topic.getTitleRequire());
        titleDetailVO.setTitleResult(topic.getTitleResult());

        return titleDetailVO;
    }

    /**
     * 题目审核通过
     * @param titleIdDTO
     * @return
     */
    @Override
    public boolean updateCheckTitle(TitleIdDTO titleIdDTO) {
        Long[] titleId = titleIdDTO.getTitleId();
        for (Long id:titleId){
            Titles title = titlesMapper.selectByPrimaryKey(id);
            title.setTitleState("审核通过");
            titlesMapper.updateByPrimaryKeySelective(title);
        }
        return true;
    }

    /**
     * 题目审核退回
     * @param titleIdDTO
     * @return
     */
    @Override
    public boolean updateReturnTitle(TitleIdDTO titleIdDTO) {
        Long[] titleId = titleIdDTO.getTitleId();
        for(Long id:titleId){
            Titles titles = titlesMapper.selectByPrimaryKey(id);
            titles.setTitleState("审核不通过");
            titlesMapper.updateByPrimaryKeySelective(titles);
        }
        return true;
    }

    /**
     * 题目列表查询
     * @param page
     * @param limit
     * * @param titleSearchDTO
     * @return
     */
    @Override
    public Map<String, Object> findTitleVoList(int page, int limit, TitleSearchDTO titleSearchDTO){
        PageHelper.startPage(page,limit);
        String titlesState = titleSearchDTO.getTitleState();
        Date titlesYear = titleSearchDTO.getTitleYear();
        LOGGER.info(String.valueOf(titlesYear));
        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andTitleSemesterEqualTo(titleSearchDTO.getTitleSemester());
        if(null != titlesYear){
            criteria.andTitleYearEqualTo(titlesYear);
        }
        if(null != titlesState && !"".equals(titlesState.trim())){
            criteria.andTitleStateEqualTo(titlesState);
        }
        List<Titles> titlesList = titlesMapper.selectByExample(titlesExample);
        List<TitleListVO> titleListVO = new ArrayList<>();

        for (Titles title:titlesList){
            User admin = userMapper.selectByPrimaryKey(titleSearchDTO.getUserId());
            User user = userMapper.selectByPrimaryKey(title.getUserId());
            TitleListVO titleVO = new TitleListVO();
            String checkMan;
            if(title.getTitleCheckman() == null){
                checkMan = null;
            }else{
                User teachCheck = userMapper.selectByPrimaryKey(title.getTitleCheckman());
                checkMan = teachCheck.getUsername();
            }

            if(user.getCollege().equals(admin.getCollege())){
                titleVO.setTitleId(title.getTitleId());
                titleVO.setUserId(title.getUserId());
                titleVO.setTitleName(title.getTitleName());
                titleVO.setUsername(user.getUsername());
                titleVO.setCollege(user.getCollege());
                titleVO.setTitleYear(title.getTitleYear());
                titleVO.setTitleKind(title.getTitleKind());
                titleVO.setTitleState(title.getTitleState());
                titleVO.setCheckTeach(checkMan);
                titleListVO.add(titleVO);
            }
        }

        PageInfo pageInfoTitles = new PageInfo<>(titleListVO);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoTitles",pageInfoTitles);
        map.put("titleListVO",titleListVO);

        return map;
    }

    /**
     * 根据管理员userId获取相应学院和相应学年的学生成绩列表
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getScoreListVO(int page, int limit,Long userId,String schoolYear) {

        ScoreExample scoreExample = new ScoreExample();
        PageHelper.startPage(page,limit);
        List<Score> scoreList = scoreMapper.selectByExample(scoreExample);
        List<ScoreListVO> scoreVOList = new ArrayList<>();

        for(Score score:scoreList){
            User admi = userMapper.selectByPrimaryKey(userId);
            User user = userMapper.selectByPrimaryKey(score.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(score.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            ScoreListVO scoreVO = new ScoreListVO();
            String state = "教师已确认";
            if(choose.getState().equals(state) && user.getCollege().equals(admi.getCollege()) && user.getSchoolYear().equals(schoolYear)){
                if(score.getGuidanceScore() != null || score.getReadScore() != null || score.getDefenceScore() != null){
                    scoreVO.setUserId(score.getUserId());
                    scoreVO.setUsernum(user.getUsernum());
                    scoreVO.setUsername(user.getUsername());
                    scoreVO.setTitleName(titles.getTitleName());
                    scoreVO.setTeachName(titles.getUserName());
                    scoreVO.setGuidanceScore(score.getGuidanceScore());
                    scoreVO.setGuidancdValue(score.getGuidancdValue());
                    scoreVO.setGuidanceEditor(score.getGuidanceEditor());
                    scoreVO.setGuidanceSignature(score.getGuidanceSignature());
                    scoreVO.setReadScore(score.getReadScore());
                    scoreVO.setReadValue(score.getReadValue());
                    scoreVO.setReadEditor(score.getReadEditor());
                    scoreVO.setReadSignature(score.getReadSignature());
                    scoreVO.setDefenceScore(score.getDefenceScore());
                    scoreVO.setDefenceValue(score.getDefenceValue());
                    scoreVO.setDefenceEditor(score.getDefenceEditor());
                    scoreVO.setDefenceSignature(score.getDefenceSignature());
                    scoreVO.setTotal(score.getTotal());
                    scoreVOList.add(scoreVO);
                }
            }
        }
        PageInfo pageInfoScore = new PageInfo(scoreList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoScore",pageInfoScore);
        map.put("scoreVOList",scoreVOList);
        return map;
    }
    /**
     * 答辩成绩查询
     * @param page
     * @param limit
     * @param usernum
     * @param userId 管理员userId
     * @return
     */
    @Override
    public Map<String, Object> findScoreListVO(int page, int limit,Long userId, String usernum) {
        PageHelper.startPage(page,limit);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(null != usernum && !"".equals(usernum.trim())){
            criteria.andUsernumLike("%"+usernum+"%");
        }
       /* if(null != username && !"".equals(username.trim())){
            criteria.andUsernameEqualTo(username);
        }*/
        List<User> userList = userMapper.selectByExample(userExample);
        List<ScoreListVO> scoreListVOFind = new ArrayList<>();

        for(User user:userList){
            User admin = userMapper.selectByPrimaryKey(userId);
            Score score = scoreMapper.selectByPrimaryKey(user.getUserId());
            Role role = roleMapper.selectByPrimaryKey(user.getUserId());
            Choose choose = chooseMapper.selectByPrimaryKey(user.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(choose.getTitleId());
            ScoreListVO scoreVO = new ScoreListVO();
            String state = "教师已确认";
            String value = "student";
            if(role.getRole().equals(value) && choose.getState().equals(state) && user.getCollege().equals(admin.getCollege())){
                scoreVO.setUserId(user.getUserId());
                scoreVO.setUsernum(user.getUsernum());
                scoreVO.setUsername(user.getUsername());
                scoreVO.setTitleName(titles.getTitleName());
                scoreVO.setDefenceScore(score.getDefenceScore());
                scoreVO.setDefenceValue(score.getDefenceValue());

                scoreListVOFind.add(scoreVO);

            }
        }
        PageInfo pageInfoScoreFind = new PageInfo(scoreListVOFind);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoScoreFind",pageInfoScoreFind);
        map.put("scoreListVOFind",scoreListVOFind);
        return map;
    }

    /**
     * 题目模糊查询
     * @param titleName
     * @return
     */
    @Override
    public List<Titles> getTitleByName(String titleName) {
        TitlesExample titlesExample = new TitlesExample();
        TitlesExample.Criteria criteria = titlesExample.createCriteria();
        criteria.andTitleNameLike("%"+titleName+"%");
        return titlesMapper.selectByExample(titlesExample);
    }

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
    @Override
    public boolean addDefenceGroup(String defenceName, String defencePlace, Date defenceTime, Date defenceDate, String defenceTeachs, String defenceStudents, String defenceLeader, String defenceYear,Long adminId) {
        Defence defence = new Defence();
        defence.setDefenceName(defenceName);
        defence.setDefencePlace(defencePlace);
        defence.setDefenceDate(defenceDate);
        defence.setDefenceTime(defenceTime);
        defence.setDefenceTeachs(defenceTeachs);
        defence.setDefenceStudents(defenceStudents);
        defence.setDefenceLeader(defenceLeader);
        defence.setDefenceYear(defenceYear);
        defence.setAdminId(adminId);
        return defenceMapper.insert(defence)>0;
    }

    /**
     * 答辩分组创建
     * @param defenceGroupDTO
     * @return
     */
    @Override
    public boolean insertDefence(DefenceGroupDTO defenceGroupDTO) {
        Defence defence = new Defence();
        defence.setDefenceName(defenceGroupDTO.getDefenceName());
        defence.setDefencePlace(defenceGroupDTO.getDefencePlace());
        defence.setDefenceDate(defenceGroupDTO.getDefenceDate());
        defence.setDefenceTime(defenceGroupDTO.getDefenceTime());
        defence.setDefenceTeachs(defenceGroupDTO.getDefenceTeachs());
        defence.setDefenceLeader(defenceGroupDTO.getDefenceLeader());
        defence.setDefenceStudents(defenceGroupDTO.getDefenceStudents());
        defence.setDefenceYear(defenceGroupDTO.getDefenceYear());
        defence.setAdminId(defenceGroupDTO.getAdminId());
        return defenceMapper.insert(defence)>0;
    }

    /**
     * 答辩分组列表
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> getDefenceGroupVO(int page, int limit,String schoolYear,Long adminId) {
        DefenceExample defenceExample = new DefenceExample();
        DefenceExample.Criteria criteria = defenceExample.createCriteria();
        criteria.andDefenceYearEqualTo(schoolYear);
        criteria.andAdminIdEqualTo(adminId);
        PageHelper.startPage(page,limit);
        List<Defence> defenceList = defenceMapper.selectByExample(defenceExample);
        List<DefenceGroupVO> defenceListVO = new ArrayList<>();

        for(Defence defence:defenceList){
            DefenceGroupVO defenceVO = new DefenceGroupVO();
            defenceVO.setDefenceId(defence.getDefenceId());
            defenceVO.setDefenceName(defence.getDefenceName());
            defenceVO.setDefencePlace(defence.getDefencePlace());
            defenceVO.setDefenceDate(defence.getDefenceDate());
            defenceVO.setDefenceTime(defence.getDefenceTime());
            defenceVO.setDefenceTeachs(defence.getDefenceTeachs());
            defenceVO.setDefenceStudents(defence.getDefenceStudents());
            defenceVO.setDefenceLeader(defence.getDefenceLeader());

            defenceListVO.add(defenceVO);
        }
        PageInfo pageInfoDefence = new PageInfo(defenceList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoDefence",pageInfoDefence);
        map.put("defenceListVO",defenceListVO);
        return map;
    }

    /**
     * 根据关键词查询答辩分组
     * @param page
     * @param limit
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public Map<String, Object> searchDefence(int page, int limit, String schoolYear, Long adminId,String searchValue) {

        DefenceExample defenceExample = new DefenceExample();

        defenceExample.or().andDefenceNameLike("%"+searchValue+"%");
        defenceExample.or().andDefencePlaceLike("%"+searchValue+"%");
        defenceExample.or().andDefenceTeachsLike("%"+searchValue+"%");
        defenceExample.or().andDefenceStudentsLike("%"+searchValue+"%");
        defenceExample.or().andDefenceYearLike("%"+searchValue+"%");

        PageHelper.startPage(page,limit);
        List<Defence> defenceList = defenceMapper.selectByExample(defenceExample);
        List<DefenceGroupVO> defenceListSearchVO = new ArrayList<>();

        for(Defence defence:defenceList){
            DefenceGroupVO defenceVO = new DefenceGroupVO();
            if(defence.getDefenceYear().equals(schoolYear) && defence.getAdminId().equals(adminId)){
                defenceVO.setDefenceId(defence.getDefenceId());
                defenceVO.setDefenceName(defence.getDefenceName());
                defenceVO.setDefencePlace(defence.getDefencePlace());
                defenceVO.setDefenceDate(defence.getDefenceDate());
                defenceVO.setDefenceTime(defence.getDefenceTime());
                defenceVO.setDefenceTeachs(defence.getDefenceTeachs());
                defenceVO.setDefenceStudents(defence.getDefenceStudents());

                defenceListSearchVO.add(defenceVO);
            }
        }
        PageInfo pageInfoDefenceSearch = new PageInfo(defenceList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfoDefenceSearch",pageInfoDefenceSearch);
        map.put("defenceListSearchVO",defenceListSearchVO);
        return map;

    }

    /**
     * 根据管理员userId获取当前学年教师名单
     * @param userId
     * @return
     */
    @Override
    public List<TeachListVO> getTeachName(Long userId,String schoolYear) {
       User admin = userMapper.selectByPrimaryKey(userId);
       String teach = "teacher";
       RoleExample roleExample = new RoleExample();
       RoleExample.Criteria criteria = roleExample.createCriteria();
       criteria.andRoleLike("%" + teach + "%");
       List<Role> roles = roleMapper.selectByExample(roleExample);
       List<TeachListVO> teachList = new ArrayList<>();
       for(Role item:roles){
           User user = userMapper.selectByPrimaryKey(item.getUserId());
           if(user.getCollege().equals(admin.getCollege()) && user.getSchoolYear().equals(schoolYear)){
               TeachListVO listVO = new TeachListVO();
               listVO.setUserId(user.getUserId());
               listVO.setUsernum(user.getUsernum());
               listVO.setUsername(user.getUsername());
               listVO.setCollege(user.getCollege());
               listVO.setPosition(user.getPosition());
               teachList.add(listVO);
           }
       }
       return teachList;
    }

    /**
     * 根据管理员userId获取相应学院学生开题答辩名单
     * @param userId
     * @return
     */
    @Override
    public List<StuListVO> getStuName(Long userId,String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(userId);
        ChooseExample chooseExample = new ChooseExample();
        ChooseExample.Criteria criteria = chooseExample.createCriteria();
        criteria.andStateEqualTo("教师已确认");
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);
        List<StuListVO> stuList = new ArrayList<>();

        for(Choose item:chooseList){
            Role role = roleMapper.selectByPrimaryKey(item.getUserId());
            User user = userMapper.selectByPrimaryKey(item.getUserId());

            if(user.getCollege().equals(admin.getCollege()) && user.getSchoolYear().equals(schoolYear) && role.getRole().equals("student")){
                StuListVO list = new StuListVO();
                list.setUserId(user.getUserId());
                list.setUsernum(user.getUsernum());
                list.setUsername(user.getUsername());
                list.setCollege(user.getCollege());
                list.setMajor(user.getMajor());
                stuList.add(list);
            }
        }
        return stuList;
    }

    /**
     * 获取学年信息
     * @return
     */
    @Override
    public List<Semester> getSemester() {
        SemesterExample semesterExample = new SemesterExample();
        return semesterMapper.selectByExample(semesterExample);
    }

    /**
     * 判断该学年是否已存在
     * @param semester
     * @return
     */
    @Override
    public boolean isSemester(String semester) {
        SemesterExample semesterExample = new SemesterExample();
        List<Semester> semesterList = semesterMapper.selectByExample(semesterExample);

        for(Semester semesterItem:semesterList){
            String value = semesterItem.getSemesterValue();
            if (value.equals(semester)){
                return true;
            }
        }
        return false;
    }

    /**
     * 添加学年
     * @param
     * @return
     */
    @Override
    public boolean addSemester(String semesterValue) {
        Semester semester = new Semester();
        semester.setSemesterValue(semesterValue);
        return semesterMapper.insert(semester)>0;
    }

    /**
     * 根据教师userId指定相应教师为评阅专家
     * @param userIdDTO
     * @return
     */
    @Override
    public boolean setExpert(UserIdDTO userIdDTO) {
        Long[] userId = userIdDTO.getUserId();
        for(Long id: userId){
            Role role = roleMapper.selectByPrimaryKey(id);
            String identity = role.getRole();
            String value = "teacher,expert";
            if(identity.equals(value)){
                continue;
            }
            String expert = "expert";
            String newIdentity = identity + "," + expert;
            role.setRole(newIdentity);
            LOGGER.info(newIdentity);
            roleMapper.updateByPrimaryKeySelective(role);
        }
        return true;
    }

    /**
     * 根据题目id修改题目信息
     * @param
     * @return
     */
    @Override
    public boolean updateTitles(UpdateTitleDetailDTO updateTitleDetailDTO) {
        Titles titles = titlesMapper.selectByPrimaryKey(updateTitleDetailDTO.getTitleId());
        User user = userMapper.selectByPrimaryKey(titles.getUserId());
        titles.setTitleName(updateTitleDetailDTO.getTitleName());
        titles.setTitleKind(updateTitleDetailDTO.getTitleKind());
        titles.setTitleSource(updateTitleDetailDTO.getTitleSource());
        titles.setTitleModel(updateTitleDetailDTO.getTitleModel());
        titles.setUserName(updateTitleDetailDTO.getUsername());
        user.setPosition(updateTitleDetailDTO.getPosition());
        user.setCollege(updateTitleDetailDTO.getCollege());
        titles.setTitleYear(updateTitleDetailDTO.getTitleYear());
        titles.setTitleState(updateTitleDetailDTO.getTitleState());
        titles.setTitleMajor(updateTitleDetailDTO.getTitleMajor());
        titles.setTitleType(updateTitleDetailDTO.getTitleType());
        titles.setTitleComplete(updateTitleDetailDTO.getTitleComplete());
        titles.setTitleValue(updateTitleDetailDTO.getTitleValue());
        titles.setTitleRequire(updateTitleDetailDTO.getTitleRequire());
        titles.setTitleResult(updateTitleDetailDTO.getTitleResult());

        userMapper.updateByPrimaryKeySelective(user);
        return titlesMapper.updateByPrimaryKeySelective(titles)>0;
    }

    /**
     * 指定审题教师
     * @param idAndNameDTO
     * @return
     */
    @Override
    public boolean setTitleCheckMan(IdAndNameDTO idAndNameDTO) {
        Long[] titleId = idAndNameDTO.getId();
        try {
            for(Long id:titleId){
                Titles titles = titlesMapper.selectByPrimaryKey(id);
                titles.setTitleCheckman(idAndNameDTO.getTeachId());
                titlesMapper.updateByPrimaryKeySelective(titles);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
