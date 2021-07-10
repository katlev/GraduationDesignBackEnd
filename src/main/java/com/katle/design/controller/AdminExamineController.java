package com.katle.design.controller;

import com.github.pagehelper.PageInfo;
import com.katle.design.dto.*;
import com.katle.design.entities.User;
import com.katle.design.service.AdminService;
import com.katle.design.service.UserService;
import com.katle.design.utils.ResponseData;
import com.katle.design.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Api(value = "管理员模块",tags = "管理员模块")
@RestController
@CrossOrigin

public class AdminExamineController {
    /**
     * Autowired 注入相应文件
     */
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "教师账户添加", notes = "教师账户添加")
    @PostMapping("/addTeachAccount")
    @RequiresRoles("administrators")
    public ResponseData addTeachAccount(String usernum,String username,String password,String position,String college,String email,String schoolYear){
       User user = userService.getUserByUsernum(usernum);
       if (null != user){
           return new ResponseData(500,"用户已存在");
       }
        try {
            adminService.addTeachAccount(usernum,username,password,position,college,email,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"添加失败");
        }
    }

    @ApiOperation(value = "学生账户添加", notes = "学生账户添加")
    @PostMapping("/addStudentAccount")
    @RequiresRoles("administrators")
    public ResponseData addStudent(String usernum,String username,String password,String grade,String college,String major,String schoolYear){
       User user = userService.getUserByUsernum(usernum);
       if(null != user){
           return new ResponseData(500,"用户已存在");
       }
       try {
           adminService.addStuAccount(usernum ,username,password,grade,college,major,schoolYear);
           return ResponseData.ok();

       }catch (Exception e){
           return new ResponseData(500,"添加失败");
       }
    }

    @ApiOperation(value = "文件导入学生账号",notes = "根据文件导入学生账号")
    @PostMapping("/uploadStudent")
    @RequiresRoles("administrators")
    public ResponseData uploadStudent(String schoolYear,MultipartFile file) throws IOException {
        InputStream in = null;
        try {
            in = file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        //将InputStream转XLSX对象（即表格对象）
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowNum = xssfSheet.getLastRowNum();
        for (int i=1 ; i<=rowNum ; i++){
            XSSFRow xssfRow = xssfSheet.getRow(i);
            xssfRow.getCell(0).setCellType(CellType.STRING);
            xssfRow.getCell(2).setCellType(CellType.STRING);
            xssfRow.getCell(5).setCellType(CellType.STRING);

            String usernum = xssfRow.getCell(0).toString();
            String username = xssfRow.getCell(1).toString();
            String password = xssfRow.getCell(2).toString();
            String college = xssfRow.getCell(3).toString();
            String major = xssfRow.getCell(4).toString();
            String grade = xssfRow.getCell(5).toString();

            LOGGER.info(usernum);
            LOGGER.info(username);
            LOGGER.info(password);
            LOGGER.info(college);
            LOGGER.info(major);
            LOGGER.info(grade);

            User user = userService.getUserByUsernum(usernum);
            if(null != user){
                adminService.updateStuInfo(user.getUserId(),usernum,username,password,grade,college,major);
                continue;
            }

            adminService.addStuAccount(usernum ,username,password,grade,college,major,schoolYear);
        }
        return ResponseData.ok();

    }

    @ApiOperation(value = "文件导入教师账号",notes = "文件导入教师账号")
    @PostMapping("/uploadTeach")
    @RequiresRoles("administrators")
    public ResponseData uploadTeach(String schoolYear,MultipartFile file) throws IOException {
        InputStream in = null;
        try {
            //将file转InputStre
            in = file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }

        //将InputStream转XLSX对象（即表格对象）
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        //获取表格的第一页
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        //该页的总条数
        int rowNum = xssfSheet.getLastRowNum();
        for(int i=1 ; i<=rowNum ; i++){

            XSSFRow xssfRow = xssfSheet.getRow(i);

            xssfRow.getCell(0).setCellType(CellType.STRING);
            xssfRow.getCell(2).setCellType(CellType.STRING);

            String usernum = xssfRow.getCell(0).toString();
            String username = xssfRow.getCell(1).toString();
            String password = xssfRow.getCell(2).toString();
            String position = xssfRow.getCell(3).toString();
            String college = xssfRow.getCell(4).toString();
            String email = xssfRow.getCell(5).toString();
            LOGGER.info(usernum);
            LOGGER.info(username);
            LOGGER.info(password);
            LOGGER.info(position);
            LOGGER.info(college);
            LOGGER.info(email);

            User user = userService.getUserByUsernum(usernum);
            if(null != user){
                adminService.updateTeachInfo(user.getUserId(),usernum,username,password,position,college,email);
                continue;
            }

            adminService.addTeachAccount(usernum,username,password,position,college,email,schoolYear);

        }

        return ResponseData.ok();

    }

    @ApiOperation(value = "学生账号账号修改",notes = "学生账号修改")
    @PutMapping("/updateStuInfo")
    @RequiresRoles("administrators")
    public ResponseData updateStuInfo(Long userId, String usernum,String username,String password,String grade,String college,String major){
        try {
            adminService.updateStuInfo(userId,usernum,username,password,grade,college,major);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"修改失败");
        }
    }

    @ApiOperation(value = "教师账号修改",notes = "教师账号修改")
    @PutMapping("/updateTeachInfo")
    @RequiresRoles("administrators")
    public ResponseData updateTeachInfo(Long userId,String usernum,String username,String password,String position,String college,String email){
        try {
            adminService.updateTeachInfo(userId,usernum,username,password,position,college,email);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"修改失败");
        }
    }

    @ApiOperation(value = "学生列表获取",notes = "根据管理员userId获取相应学院学生列表")
    @GetMapping("/getStuList")
    @RequiresRoles("administrators")
    public TableVO stuAccountList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = adminService.studentVoList(page,limit,userId,schoolYear);
        PageInfo pageInfo = (PageInfo) map.get("pageInfoStu");
        List<StuListVO> stuListVO = (List<StuListVO>) map.get("stuListVO");
        return new TableVO(pageInfo,stuListVO);
    }

    @ApiOperation(value = "教师列表获取",notes = "根据管理员userId获取相应学院教师账号列表")
    @GetMapping("/getTeachList")
    @RequiresRoles("administrators")
    public TableVO teachAccountList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId,String schoolYear){
        Map<String,Object> map = adminService.teachVoList(page,limit,userId,schoolYear);
        PageInfo pageInfoTeach = (PageInfo) map.get("pageInfoTeach");
        List<StuListVO> teachListVO = (List<StuListVO>) map.get("teachListVO");
       return new TableVO(pageInfoTeach,teachListVO);
    }

    @ApiOperation(value = "账号删除",notes = "账号删除")
    @DeleteMapping("/deleteStudent")
    @RequiresRoles("administrators")
    public ResponseData deleteStudent(@RequestBody UserIdDTO userIdDTO){
        if(null == userIdDTO){
            return new ResponseData(500,"id为空");
        }
       try {
           adminService.deleteStudent(userIdDTO);
           return ResponseData.ok();
       }catch (Exception e){
           return new ResponseData(500,"删除失败");
       }
    }

    @ApiOperation(value = "学生账号查询",notes = "学生账号查询，其中userId为管理员userId")
    @GetMapping("/findStu")
    @RequiresRoles("administrators")
   public TableVO findStuByKey(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String usernum,String username,String grade,String major,String schoolYear){
        Map<String, Object> map = adminService.findStuVoList(page,limit,userId,usernum,username,grade,major,schoolYear);
        PageInfo pageInfo = (PageInfo) map.get("pageInfo");
        List<StuListVO> stuFindListVO = (List<StuListVO>) map.get("stuFindListVO");
        return new TableVO(pageInfo,stuFindListVO);
   }

   @ApiOperation(value = "教师账号查询",notes = "教师账号查询，其中userid为管理员userId")
   @GetMapping("/findTeach")
   @RequiresRoles("administrators")
   public TableVO findTeachByKey(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String usernum,String username,String position,String schoolYear){
        Map<String, Object> map = adminService.findTeachVoList(page,limit,userId,usernum,username,position,schoolYear);
        PageInfo pageInfo = (PageInfo) map.get("pageInfo");
        List<TeachListVO> teachFindListVO = (List<TeachListVO>) map.get("teachFindListVO");
        return new TableVO(pageInfo,teachFindListVO);
   }

   @ApiOperation(value = "题目列表获取",notes = "根据管理员userId获取相应学院教师开题列表")
   @GetMapping("/getTitleList")
   @RequiresRoles("administrators")
   public TableVO getTitleList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId,String titleSemester){
        Map<String, Object> map = adminService.getTitleVoList(page,limit,userId,titleSemester);
        PageInfo pageInfoTopic = (PageInfo) map.get("pageInfoTopic");
        List<TitleListVO> titleListVO = (List<TitleListVO>) map.get("titleListVO");
        return new TableVO(pageInfoTopic,titleListVO);

   }

   @ApiOperation(value = "题目详情",notes = "根据titleId获取题目详情")
   @GetMapping("/getTitleDetail")
   public ResponseData getTitleDetail(Long titleId){
        try {
            TitleDetailVO titleDetailVO = adminService.topicDetailVO(titleId);
            return ResponseData.ok().putDataValue(titleDetailVO);
        }catch (Exception e){
            return new ResponseData(500,"获取出错");
        }
   }

   @ApiOperation(value = "审核通过",notes = "审核通过")
   @PutMapping("/updateCheckTitle")
   public ResponseData updateCheckTitle(@RequestBody TitleIdDTO titleIdDTO){
        try {
            adminService.updateCheckTitle(titleIdDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"修改失败");
        }
   }

   @ApiOperation(value = "审核退回", notes = "审核退回")
   @PutMapping("/updateReturnTitle")
    public ResponseData updateReturnTitle(@RequestBody TitleIdDTO titleIdDTO){
        try {
            adminService.updateReturnTitle(titleIdDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"修改失败");
        }
    }

    @ApiOperation(value = "题目列表搜索",notes = "题目列表搜索")
    @PostMapping("/findTitleList")
    @RequiresRoles("administrators")
    public TableVO findTitleList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit",defaultValue = "20") Integer limit, @RequestBody TitleSearchDTO titleSearchDTO){
        Map<String, Object> map = adminService.findTitleVoList(page,limit,titleSearchDTO);
        PageInfo pageInfoTitles = (PageInfo) map.get("pageInfoTitles");
        List<TitleListVO> titleListVO = (List<TitleListVO>) map.get("titleListVO");
        return new TableVO(pageInfoTitles,titleListVO);
    }

    @ApiOperation(value = "成绩录入列表",notes = "根据管理员userId获取相应学院学生成绩列表")
    @GetMapping("/getScoreList")
    @RequiresRoles("administrators")
    public TableVO getScoreListVO(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = adminService.getScoreListVO(page,limit,userId,schoolYear);
        PageInfo pageInfoScore = (PageInfo) map.get("pageInfoScore");
        List<ScoreListVO> scoreVOList = (List<ScoreListVO>) map.get("scoreVOList");
        return new TableVO(pageInfoScore,scoreVOList);
    }

    @ApiOperation(value = "答辩成绩查询",notes = "userId为管理员userId")
    @GetMapping("/findDefenceScore")
    @RequiresRoles("administrators")
    public TableVO findDefenceScore(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId,String usernum){
        Map<String, Object> map = adminService.findScoreListVO(page,limit,userId,usernum);
        PageInfo pageInfoScoreFind = (PageInfo) map.get("pageInfoScoreFind");
        List<ScoreListVO> scoreListVOFind = (List<ScoreListVO>) map.get("scoreListVOFind");
        return new TableVO(pageInfoScoreFind,scoreListVOFind);
    }

    @ApiOperation(value = "答辩分组创建",notes = "答辩分组创建")
    @PostMapping("/addDefenceGroup")
    @RequiresRoles("administrators")
    public ResponseData addDefenceGroup(String defenceName,String defencePlace,String defenceDate,String defenceTime,String defenceTeachs,String defenceStudents,String defenceLeader,String defenceYear,Long adminId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        try {
            Date defDate = simpleDateFormat.parse(defenceDate);
            Date defTime = simpleDateFormat1.parse(defenceTime);
            adminService.addDefenceGroup(defenceName,defencePlace,defDate,defTime,defenceTeachs,defenceStudents,defenceLeader,defenceYear,adminId);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"创建失败");
        }
    }

    @ApiOperation(value = "答辩分组添加",notes = "答辩分组添加方法二")
    @PostMapping("/addDefence")
    @RequiresRoles("administrators")
    public ResponseData addDefences(@RequestBody DefenceGroupDTO defenceGroupDTO){
        try {
            adminService.insertDefence(defenceGroupDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"添加失败");
        }
    }

    @ApiOperation(value = "答辩分组列表",notes = "答辩分组列表")
    @GetMapping("/getDefenceGroup")
    @RequiresRoles("administrators")
    public TableVO getDefenceGroup(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit",defaultValue = "20") Integer limit,String schoolYear,Long adminId){
        Map<String, Object> map = adminService.getDefenceGroupVO(page,limit,schoolYear,adminId);
        PageInfo pageInfoDefence = (PageInfo) map.get("pageInfoDefence");
        List<DefenceGroupVO> defenceListVO = (List<DefenceGroupVO>) map.get("defenceListVO");
        return new TableVO(pageInfoDefence,defenceListVO);
    }

    @ApiOperation(value = "答辩分组搜索",notes = "根据关键词搜索答辩分组")
    @GetMapping("/searchDefence")
    @RequiresRoles("administrators")
    public TableVO searchDefence(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                 @RequestParam(value = "limit",defaultValue = "20")Integer limit,String schoolYear,Long adminId,String searchValue){
        Map<String, Object> map = adminService.searchDefence(page,limit,schoolYear,adminId,searchValue);
        PageInfo pageInfoDefenceSearch = (PageInfo) map.get("pageInfoDefenceSearch");
        List<DefenceGroupVO> defenceListSearchVO = (List<DefenceGroupVO>) map.get("defenceListSearchVO");
        return new TableVO(pageInfoDefenceSearch,defenceListSearchVO);
    }

    @ApiOperation(value = "毕设答辩分组文件导入",notes = "毕设答辩文件导入")
    @PostMapping("/importDefenceFile")
    @RequiresRoles("administrators")
    public ResponseData importDefenceGroup(Long adminId,String schoolYear,MultipartFile file) throws IOException, ParseException {
        InputStream in = null;
        try {
            in = file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowNum = xssfSheet.getLastRowNum();
        LOGGER.info(String.valueOf(rowNum));
        for(int i=1;i<=rowNum;i++){
            XSSFRow xssfRow = xssfSheet.getRow(i);

            xssfRow.getCell(1).setCellType(CellType.STRING);
            xssfRow.getCell(2).setCellType(CellType.NUMERIC);
            xssfRow.getCell(3).setCellType(CellType.NUMERIC);

            String defenceName = xssfRow.getCell(0).toString();
            String defencePlace = xssfRow.getCell(1).toString();

            Date timeValue = xssfRow.getCell(2).getDateCellValue();
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            String defenceTime = format.format(timeValue);

            Date dateValue = xssfRow.getCell(3).getDateCellValue();
            DateFormat format1 = new SimpleDateFormat("yyyy:MM:dd");
            String defenceDate = format1.format(dateValue);

            String defenceTeachs = xssfRow.getCell(4).toString();
            String defenceStudents = xssfRow.getCell(5).toString();
            String defenceLeader = xssfRow.getCell(6).toString();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
            Date defDate = simpleDateFormat.parse(defenceDate);
            Date defTime = simpleDateFormat1.parse(defenceTime);

            adminService.addDefenceGroup(defenceName,defencePlace,defTime,defDate,defenceTeachs,defenceStudents,defenceLeader,schoolYear,adminId);

        }
        return ResponseData.ok();

    }

    @ApiOperation(value="教师名单获取",notes = "根据管理员userId获取相应学院教师名单")
    @GetMapping("/getTeachName")
    @RequiresRoles("administrators")
    public ResponseData getTeachName(Long userId,String schoolYear){
        try {
            List<TeachListVO> list = adminService.getTeachName(userId,schoolYear);
            return ResponseData.ok().putDataValue(list);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value="学生开题答辩名单获取",notes = "根据管理员userId获取相应学院学生名单")
    @GetMapping("/getStuName")
    @RequiresRoles("administrators")
    public ResponseData getStuName(Long userId,String schoolYear){
        try {
            List<StuListVO> stuList = adminService.getStuName(userId,schoolYear);
            return ResponseData.ok().putDataValue(stuList);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    /**
     * 判断学年是否已存在
     * @return
     */
    @ApiOperation(value = "获取学年信息",notes = "获取学年信息")
    @GetMapping("/getSemester")
    public ResponseData getSemester(){
        try {
            return ResponseData.ok().putDataValue(adminService.getSemester());
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "添加学年",notes = "添加学年")
    @GetMapping("/addSemester")
    @RequiresRoles("administrators")
    public ResponseData addSemester(String semesterValue){
        boolean value = adminService.isSemester(semesterValue);
        LOGGER.info(String.valueOf(value));
        if(value == true){
            return new ResponseData(500,"该学年已存在");
        }

        try {
            adminService.addSemester(semesterValue);
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"添加失败");
        }
    }

    @ApiOperation(value = "指定评阅专家",notes = "根据教师userId指定相应教师为评阅专家身份")
    @PutMapping("/setExpert")
    @RequiresRoles("administrators")
    public ResponseData setExpert(@RequestBody UserIdDTO userIdDTO){
        try {
            adminService.setExpert(userIdDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"设置失败");
        }

    }

    @ApiOperation(value = "修改题目信息",notes = "根据题目id修改题目信息")
    @PutMapping("/updateTitleMsg")
    public ResponseData updateTitleMsg(@RequestBody UpdateTitleDetailDTO updateTitleDetailDTO){
        try {
            adminService.updateTitles(updateTitleDetailDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"修改失败");
        }
    }

    @ApiOperation(value = "指定审题教师",notes = "根据题目id指定审核教师")
    @PostMapping("/setTitleCheckMan")
    @RequiresRoles("administrators")
    public ResponseData setTitleCheckMan(@RequestBody IdAndNameDTO idAndNameDTO){
        try {
            adminService.setTitleCheckMan(idAndNameDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"指定失败");
        }
    }
}
