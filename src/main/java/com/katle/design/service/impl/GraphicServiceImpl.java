package com.katle.design.service.impl;

import com.katle.design.dao.*;
import com.katle.design.entities.*;
import com.katle.design.service.GraphicService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class GraphicServiceImpl implements GraphicService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private StartFileMapper startFileMapper;
    @Resource
    private MiddleFileMapper middleFileMapper;
    @Resource
    private TranslationFileMapper translationFileMapper;
    @Resource
    private OriginalFileMapper originalFileMapper;
    @Resource
    private LiteratureFileMapper literatureFileMapper;
    @Resource
    private ThesisFileMapper thesisFileMapper;
    @Resource
    private GuidanceFileMapper guidanceFileMapper;
    @Resource
    private PlanFileMapper planFileMapper;
    @Resource
    private ChooseMapper chooseMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private TitlesMapper titlesMapper;

    /**
     * 获取当前院系学生总人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer stuTotalNum(Long adminId, String schoolYear) {
        User user = userMapper.selectByPrimaryKey(adminId);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andCollegeEqualTo(user.getCollege());
        List<User> userList = userMapper.selectByExample(userExample);
        Integer num = 0;
        for(User item:userList){
            Role role = roleMapper.selectByPrimaryKey(item.getUserId());
            if(role.getRole().equals("student")){
                num += 1;
            }
        }

        return num;
    }

    /**
     * 获取开题报告提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer startFileNum(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        StartFileExample startFileExample = new StartFileExample();
        StartFileExample.Criteria criteria = startFileExample.createCriteria();
        criteria.andStartYearEqualTo(schoolYear);
        List<StartFile> startList = startFileMapper.selectByExample(startFileExample);
        Integer start = 0;
        for(StartFile item:startList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            if(stu.getCollege().equals(admin.getCollege()) && item.getStartName() != null){
                start += 1;
            }
        }
        return start;
    }

    /**
     * 获取中期检查提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer middleFileNum(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        MiddleFileExample middleFileExample = new MiddleFileExample();
        MiddleFileExample.Criteria criteria = middleFileExample.createCriteria();
        criteria.andMiddleYearEqualTo(schoolYear);
        List<MiddleFile> middleList = middleFileMapper.selectByExample(middleFileExample);
        Integer middle = 0;
        for(MiddleFile item:middleList){
            User stu = userMapper.selectByPrimaryKey(item.getUserid());
            if(stu.getCollege().equals(admin.getCollege()) && item.getMiddleName() != null){
                middle += 1;
            }
        }
        return middle;
    }

    /**
     * 获取外文译文提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer translationNum(Long adminId, String schoolYear) {

        User admin = userMapper.selectByPrimaryKey(adminId);
        TranslationFileExample translationFileExample = new TranslationFileExample();
        TranslationFileExample.Criteria criteria = translationFileExample.createCriteria();
        criteria.andTranslationYearEqualTo(schoolYear);
        List<TranslationFile> translationList = translationFileMapper.selectByExample(translationFileExample);

        Integer translationNum = 0;

        for(TranslationFile item : translationList) {
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            if(stu.getCollege().equals(admin.getCollege()) && item.getTranslationName() != null){
                translationNum += 1;
            }
        }

        return translationNum;
    }

    /**
     * 获取外文原文提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer originalNum(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        OriginalFileExample originalFileExample = new OriginalFileExample();
        OriginalFileExample.Criteria criteria = originalFileExample.createCriteria();
        criteria.andOriginalYearEqualTo(schoolYear);
        List<OriginalFile> originalList = originalFileMapper.selectByExample(originalFileExample);

        Integer originalNum = 0;
        for (OriginalFile item: originalList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            if(stu.getCollege().equals(admin.getCollege()) && item.getOriginalName() != null){
                originalNum += 1;
            }
        }
        return originalNum;
    }

    /**
     * 获取文献综述提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer literatureNum(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        LiteratureFileExample literatureFileExample = new LiteratureFileExample();
        LiteratureFileExample.Criteria criteria = literatureFileExample.createCriteria();
        criteria.andLiteratureYearEqualTo(schoolYear);
        List<LiteratureFile> literatureList = literatureFileMapper.selectByExample(literatureFileExample);

        Integer literatureNum = 0;
        for (LiteratureFile item: literatureList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());

            if(stu.getCollege().equals(admin.getCollege()) && item.getLiteratureName() != null){
                literatureNum += 1;
            }
        }
        return literatureNum;
    }

    /**
     * 获取毕业论文提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer thesisNum(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        ThesisFileExample thesisFileExample = new ThesisFileExample();
        ThesisFileExample.Criteria criteria = thesisFileExample.createCriteria();
        criteria.andThesisYearEqualTo(schoolYear);
        List<ThesisFile> thesisList = thesisFileMapper.selectByExample(thesisFileExample);

        Integer thesisNum = 0;
        for(ThesisFile item: thesisList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());

            if(stu.getCollege().equals(admin.getCollege()) && item.getThesisName() != null){
                thesisNum += 1;
            }
        }
        return thesisNum;
    }

    /**
     * 获取指导记录提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer guidanceNum(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        ChooseExample chooseExample = new ChooseExample();
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);

        Integer guidanceNum = 0;
        for(Choose item: chooseList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
            GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
            criteria.andUserIdEqualTo(item.getUserId());
            List<GuidanceFile> guidanceList = guidanceFileMapper.selectByExample(guidanceFileExample);
            GuidanceFile guidanceFile = guidanceList.get(0);

            if(stu.getCollege().equals(admin.getCollege()) && guidanceFile.getGuidanceName() != null && guidanceFile.getGuidanceYear().equals(schoolYear)){
                guidanceNum += 1;
            }
        }
        return guidanceNum;
    }

    /**
     * 获取进度计划提交人数
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Integer planNum(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        ChooseExample chooseExample = new ChooseExample();
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);

        Integer planNum = 0;
        for(Choose item:chooseList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());

            PlanFileExample planFileExample = new PlanFileExample();
            PlanFileExample.Criteria criteria = planFileExample.createCriteria();
            criteria.andUserIdEqualTo(item.getUserId());
            List<PlanFile> planList = planFileMapper.selectByExample(planFileExample);
            PlanFile planFile = planList.get(0);

            if (stu.getCollege().equals(admin.getCollege()) && planFile.getPlanName() != null && planFile.getPlanYear().equals(schoolYear)){
                planNum += 1;
            }
        }
        return planNum;
    }

    /**
     * 获取分数统计数据
     * @param adminId
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String,Integer> scoreGrade(Long adminId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(adminId);

        ScoreExample scoreExample = new ScoreExample();
        List<Score> scoreList = scoreMapper.selectByExample(scoreExample);

        Integer aGrade = 0;
        Integer bGrade = 0;
        Integer cGrade = 0;
        Integer dGrade = 0;
        Integer eGrade = 0;

        for(Score item : scoreList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());

            if( item.getTotal() != null && stu.getCollege().equals(admin.getCollege()) && stu.getSchoolYear().equals(schoolYear)){

                if(item.getTotal() >= 90 && item.getTotal() <= 100){
                    aGrade += 1;
                }else if(item.getTotal() >= 80 && item.getTotal() < 90){
                    bGrade += 1;
                }else if(item.getTotal() >= 70 && item.getTotal() < 80){
                    cGrade += 1;
                }else if(item.getTotal() >= 60 && item.getTotal() < 70){
                    dGrade += 1;
                }else if(item.getTotal() < 60){
                    eGrade += 1;
                }
            }
        }
        LOGGER.info(String.valueOf(aGrade));
        LOGGER.info(String.valueOf(bGrade));
        LOGGER.info(String.valueOf(cGrade));
        LOGGER.info(String.valueOf(dGrade));
        LOGGER.info(String.valueOf(eGrade));
        Map<String,Integer> map = new HashMap<>();
        map.put("aGrade",aGrade);
        map.put("bGrade",bGrade);
        map.put("cGrade",cGrade);
        map.put("dGrade",dGrade);
        map.put("eGrade",eGrade);

        return map;
    }

    /**
     * 导出指导记录表
     * @return
     */
    @Override
    public XSSFWorkbook exportGuidance(Long userId,String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(userId);
        ChooseExample chooseExample = new ChooseExample();
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);

        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("GuidanceList");
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("学号");
        titleRow.createCell(1).setCellValue("姓名");
        titleRow.createCell(2).setCellValue("专业");
        titleRow.createCell(3).setCellValue("题目");
        titleRow.createCell(4).setCellValue("指导教师");
        titleRow.createCell(5).setCellValue("提交次数");

        int cell = 1;
        for(Choose item:chooseList){
            User stu = userMapper.selectByPrimaryKey(item.getUserId());
            Titles titles = titlesMapper.selectByPrimaryKey(item.getTitleId());
            GuidanceFileExample guidanceFileExample = new GuidanceFileExample();
            GuidanceFileExample.Criteria criteria = guidanceFileExample.createCriteria();
            criteria.andUserIdEqualTo(item.getUserId());
            List<GuidanceFile> guidanceFileList = guidanceFileMapper.selectByExample(guidanceFileExample);
            GuidanceFile guidanceFile = guidanceFileList.get(0);
            Integer count = guidanceFileList.size();

            if(stu.getCollege().equals(admin.getCollege()) && guidanceFile.getGuidanceName() != null && guidanceFile.getGuidanceYear().equals(schoolYear)){
                Row row = sheet.createRow(cell);
                row.createCell(0).setCellValue(stu.getUsernum());
                row.createCell(1).setCellValue(stu.getUsername());
                row.createCell(2).setCellValue(stu.getMajor());
                row.createCell(3).setCellValue(titles.getTitleName());
                row.createCell(4).setCellValue(titles.getUserName());
                row.createCell(5).setCellValue(count);

                cell++;

            }
        }
        return wb;
    }

    /**
     * 导出进度计划
     * @param userId
     * @param schoolYear
     * @return
     */
    @Override
    public XSSFWorkbook exportPlan(Long userId, String schoolYear) {
        User admin = userMapper.selectByPrimaryKey(userId);

        ChooseExample chooseExample = new ChooseExample();
        List<Choose> chooseList = chooseMapper.selectByExample(chooseExample);

        XSSFWorkbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("PlanList");
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("学号");
        titleRow.createCell(1).setCellValue("姓名");
        titleRow.createCell(2).setCellValue("专业");
        titleRow.createCell(3).setCellValue("题目");
        titleRow.createCell(4).setCellValue("指导教师");
        titleRow.createCell(5).setCellValue("提交次数");

        int cell = 1;
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
                Row row = sheet.createRow(cell);
                row.createCell(0).setCellValue(stu.getUsernum());
                row.createCell(1).setCellValue(stu.getUsername());
                row.createCell(2).setCellValue(stu.getMajor());
                row.createCell(3).setCellValue(titles.getTitleName());
                row.createCell(4).setCellValue(titles.getUserName());
                row.createCell(5).setCellValue(count);

                cell++;
            }
        }
        return wb;
    }
}
