package com.katle.design.controller;

import com.github.pagehelper.PageInfo;
import com.katle.design.entities.Score;
import com.katle.design.service.StudentService;
import com.katle.design.utils.FileUploadUtil;
import com.katle.design.utils.ResponseData;
import com.katle.design.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(value = "学生模块",tags = "学生模块")
/**
 * 注入控制器
 */
@RestController
/**
 *  跨域
 */
@CrossOrigin
public class StudentController {
    /**
     * 注入相应文件
     */
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "选题列表获取",notes = "全部可选题目列表")
    @GetMapping("/selectList")
    @RequiresRoles("student")
    public TableVO selectTitleList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "limit",defaultValue = "10") Integer limit){
        Map<String,Object> map = studentService.selectTitleList(page,limit);
        PageInfo pageInfoSelect = (PageInfo) map.get("pageInfoSelect");
        List<TitleListVO> selectListVO = (List<TitleListVO>) map.get("selectListVO");
        return new TableVO(pageInfoSelect,selectListVO);
    }

    @ApiOperation(value = "学生选题",notes = "根据题目titleId和学生userId进行选题操作")
    @PostMapping("/checkSelect")
    @RequiresRoles("student")
    public ResponseData checkSelectTitle(Long titleId,Long userId){
        try {
            boolean boolValue = studentService.checkSelectTitle(titleId,userId);
            if(boolValue == false){
                return new ResponseData(500,"你已选题");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"选题失败");
        }
    }

    @ApiOperation(value = "开题报告上传",notes = "根据学生userId上传开题报告")
    @PostMapping("/uploadStartFile")
    @RequiresRoles("student")
    public ResponseData uploadStartFile(Long userId, String startName, MultipartFile file,String schoolYear, HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String startPath = FileUploadUtil.getUrl();
            studentService.uploadStartFile(userId,startName,startPath,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "中期检查上传",notes = "根据学生userId上传个人中期检查")
    @PostMapping("/uploadMiddleFile")
    @RequiresRoles("student")
    public ResponseData uploadMiddleFile(Long userId,String middleName,MultipartFile file,String schoolYear,HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String middlePath = FileUploadUtil.getUrl();
            studentService.uploadMiddleFile(userId,middleName,middlePath,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "进度计划添加",notes = "添加进度计划")
    @PostMapping("/addPlanItem")
    @RequiresRoles("student")
    public ResponseData addPlanItem(Long userId,String planName,MultipartFile file,String planStart,String planEnd,String planValue,String actualValue,String schoolYear,HttpServletRequest request){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        FileUploadUtil.uploadFile(file,request);
        String planPath = FileUploadUtil.getUrl();
        boolean value = studentService.ifPlan(userId);
        if(value == false){
            /*内容表示第一次插入*/
            try {
                Date start = simpleDateFormat.parse(planStart);
                Date end = simpleDateFormat.parse(planEnd);
                studentService.uploadPlanFile(userId,planName,planPath,start,end,planValue,actualValue,schoolYear);
                return ResponseData.ok();
            }catch (Exception e){
                return new ResponseData(500,"修改失败");
            }
        }
        /*value == true,表示此时已是第二次添加进度计划*/
        try {
            Date start = simpleDateFormat.parse(planStart);
            Date end = simpleDateFormat.parse(planEnd);

            studentService.insertPlanItem(userId,planName,planPath,start,end,planValue,actualValue,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"添加失败");

        }
    }

    @ApiOperation(value = "添加指导记录",notes = "根据个人userId添加相应学生指导记录")
    @PostMapping("/addGuidanceItem")
    @RequiresRoles("student")
    public ResponseData addGuidanceItem(Long userId,String guidanceName,MultipartFile file,String guidanceDate,String guidanceForm,String guidanceValue,String schoolYear,HttpServletRequest request){
        boolean value = studentService.ifGuidance(userId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        /*value == false 表示第一次更新指导记录内容*/
        if(value == false){
            try {
                FileUploadUtil.uploadFile(file,request);
                String guiPath = FileUploadUtil.getUrl();
                Date guidance = simpleDateFormat.parse(guidanceDate);

                studentService.uploadGuidanceFile(userId,guidanceName,guiPath,guidance,guidanceForm,guidanceValue,schoolYear);
                return ResponseData.ok();

            }catch (Exception e){
                return new ResponseData(500,"更新失败");
            }
        }

        /*value == true  表示此时已是第二次添加指导记录*/
        try {
            Date guidance = simpleDateFormat.parse(guidanceDate);
            FileUploadUtil.uploadFile(file,request);
            String guidPath = FileUploadUtil.getUrl();
            studentService.insertGuidance(userId,guidanceName,guidPath,guidance,guidanceForm,guidanceValue,schoolYear);
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"添加失败");
        }
    }

    @ApiOperation(value = "外文译文上传",notes = "根据学生userId上传个人外文译文")
    @PostMapping("/uploadTranslationFile")
    @RequiresRoles("student")
    public ResponseData uploadTranslationFile(Long userId,String translationName,MultipartFile file,String schoolYear,HttpServletRequest request){
        try{
            FileUploadUtil.uploadFile(file,request);
            String translationPath = FileUploadUtil.getUrl();
            studentService.uploadTranslationFile(userId,translationName,translationPath,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "外文原文上传",notes = "根据学生userid上传个人外文原文")
    @PostMapping("/uploadOriginalFile")
    @RequiresRoles("student")
    public ResponseData uploadOriginalFile(Long userId,String originalName,MultipartFile file,String schoolYear,HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String originalPath = FileUploadUtil.getUrl();
            studentService.uploadOriginalFile(userId,originalName,originalPath,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "文献综述上传",notes = "根据学生userId上个个人文献综述")
    @PostMapping("/uploadLiteratureFile")
    @RequiresRoles("student")
    public ResponseData uploadLiteratureFile(Long userId,String literatureName,MultipartFile file,String schoolYear,HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String literaturePath = FileUploadUtil.getUrl();
            studentService.uploadLiteratureFile(userId,literatureName,literaturePath,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "毕业论文上传",notes = "根据学生userId上传个人毕业论文")
    @PostMapping("/uploadThesisFile")
    @RequiresRoles("student")
    public ResponseData uploadThesisFile(Long userId,String thesisName,MultipartFile file,String schoolYear,HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String thesisPath = FileUploadUtil.getUrl();
            studentService.uploadThesisFile(userId,thesisName,thesisPath,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "开题答辩分组查询",notes = "根据学生姓名查询开题答辩分组情况")
    @GetMapping("stuOpenGroup")
    @RequiresRoles("student")
    public ResponseData stuOpenGroup(String openStudents){
        try {
            DefenceGroupVO defenceGroupVO = studentService.stuOpenGroup(openStudents);
            return ResponseData.ok().putDataValue(defenceGroupVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "毕设答辩分组查询",notes = "根据学生姓名模糊搜索答辩分组情况")
    @GetMapping("/stuDefenceGroup")
    @RequiresRoles("student")
    public ResponseData stuDefenceGroup(String defenceStudents){
        try {
            DefenceGroupVO defenceGroupVO = studentService.stuDefenceGroup(defenceStudents);
            return ResponseData.ok().putDataValue(defenceGroupVO);
        }catch (Exception e){
            return new ResponseData(500,"搜索失败");
        }
    }

    @ApiOperation(value = "学生成绩获取",notes = "根据学生userId获取学生成绩")
    @GetMapping("/stuScore")
    public ResponseData stuScore(Long userId){
        try {
            Score score = studentService.studentScore(userId);
            return ResponseData.ok().putDataValue(score);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "学生选题信息",notes = "根据学生userId获取学生选题信息")
    @GetMapping("/stuTitleDetail")
    public ResponseData stuTitleDetail(Long userId){
        try {
            StuTitleDetialVO stuTitleDetialVO = studentService.stuSelectTitleDetails(userId);
            return ResponseData.ok().putDataValue(stuTitleDetialVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "取消个人选题信息",notes = "根据学生usereId取消个人选题信息,在教师确认选题之前")
    @GetMapping("/stuCancelTitle")
    @RequiresRoles("student")
    public ResponseData stuCancelTitle(Long userId){
        try {
            studentService.stuCancelTitle(userId);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"取消失败");
        }
    }

    @ApiOperation(value = "题目搜索",notes = "根据关键词进行题目搜索")
    @GetMapping("/searchTitles")
    @RequiresRoles("student")
    public TableVO searchTitles(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "10")Integer limit,String searchValue){
        Map<String, Object> map = studentService.searchTitles(page,limit,searchValue);
        PageInfo pageInfoSearch = (PageInfo) map.get("pageInfoSearch");
        List<TitleListVO> searchLists = (List<TitleListVO>) map.get("searchLists");
        return new TableVO(pageInfoSearch,searchLists);

    }

    @ApiOperation(value = "进度计划内容获取",notes = "根据进度计划planID获取进度计划详细内容")
    @GetMapping("/getPlanItemDetail")
    public ResponseData getPlanItemDetail(Long planId){
        try {
            PlanItemDetail planItemDetail = studentService.getPlanItemDetail(planId);
            return ResponseData.ok().putDataValue(planItemDetail);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "指导记录内容获取",notes = "根据指导记录guidanceID获取指导记录详细内容")
    @GetMapping("/getGuidanceItemDetail")
    public ResponseData getGuidanceItemDetail(Long guidanceId){
        try{
            GuidanceItemDetail guidanceItemDetail = studentService.getGuidanceItemDetail(guidanceId);
            return ResponseData.ok().putDataValue(guidanceItemDetail);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "文件审核情况",notes = "根据学生userId获取个人文件审核情况")
    @GetMapping("/getFileCheck")
    public ResponseData getFileCheck(Long userId){
        try {
            FileCheckVO fileCheckVO = studentService.getFileCheck(userId);
            return ResponseData.ok().putDataValue(fileCheckVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "进度计划审核情况",notes = "根据学生userId获取个人进度计划审核情况")
    @GetMapping("/getPlanCheck")
    public ResponseData getPlanCheck(Long userId){
        try {
            List<PlanCheckVO> planCheckVO = studentService.getPlanCheck(userId);
            return ResponseData.ok().putDataValue(planCheckVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "指导记录审核情况",notes = "根据学生userId获取个人指导记录审核情况")
    @GetMapping("/getGuidanceCheck")
    public ResponseData getGuidanceCheck(Long userId){
        try {
            List<GuidanceCheckVO> guidanceCheckVO = studentService.getGuidanceCheck(userId);
            return ResponseData.ok().putDataValue(guidanceCheckVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

}
