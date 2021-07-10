package com.katle.design.controller;

import com.github.pagehelper.PageInfo;
import com.katle.design.dto.AddTitleDTO;
import com.katle.design.dto.RecordSearchDTO;
import com.katle.design.entities.Score;
import com.katle.design.service.TeacherService;
import com.katle.design.utils.FileUploadUtil;
import com.katle.design.utils.ResponseData;
import com.katle.design.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "教师模块",tags = "教师模块")
/**
 * 注入控制器
 */
@RestController
/**
 * 跨域
 */
@CrossOrigin
public class TeacherController {
    /**
     * 注入相应文件
     */
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "教师开题列表",notes = "根据教师id获取开题列表")
    @GetMapping("/teachTitleList")
    @RequiresRoles("teacher")
    public TableVO teachTitleList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit",defaultValue = "10") Integer limit,Long userId){
        Map<String, Object> map = teacherService.getTeachTitleVO(page,limit,userId);
        PageInfo pageInfoTeach = (PageInfo) map.get("pageInfoTeach");
        List<TeachTitleListVO> teachTitleVO = (List<TeachTitleListVO>) map.get("teachTitleVO");
        return new TableVO(pageInfoTeach,teachTitleVO);
    }

    @ApiOperation(value = "教师开题",notes = "根据教师id进行开题")
    @PostMapping("/addTitles")
    @RequiresRoles("teacher")
    public ResponseData teachAddTitles(@RequestBody AddTitleDTO addTitleDTO){
        Long userId = addTitleDTO.getUserId();
        System.out.println("userId:"+userId);
        int len = teacherService.titlesNumber(userId);
        System.out.println("len:"+len);
        /**
         * num:教师开题数目限制
         */
        int num = 10;
        if (len >= num){
            return new ResponseData(500,"超出开题数目");
        }
        try {
            teacherService.addTitle(addTitleDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"添加失败");
        }
    }

    @ApiOperation(value = "题目数量",notes = "根据教师id获取开题数量")
    @GetMapping("/titleNumber")
    public ResponseData titleNum(Long userId){
        Integer len = teacherService.titlesNumber(userId);
        return ResponseData.ok().putDataValue(len);
    }

    @ApiOperation(value = "选题消息列表",notes = "根据教师id获取选题消息列表")
    @GetMapping("/chooseTitle")
    @RequiresRoles("teacher")
    public TableVO getChooseTitleList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                      @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId){
        Map<String, Object> map = teacherService.chooseTitleVO(page,limit,userId);
        PageInfo pageInfoChoose = (PageInfo) map.get("pageInfoChoose");
        List<ChooseTitleVO> chooseTitleVO = (List<ChooseTitleVO>) map.get("chooseTitleVO");
        return new TableVO(pageInfoChoose,chooseTitleVO);
    }

    @ApiOperation(value = "选题信息详情",notes = "根据titleId获取选题信息详情")
    @GetMapping("/chooseTitleDetail")
    @RequiresRoles("teacher")
    public ResponseData chooseTitleDetail(Long titleId){
        try {
            ChooseTitleDetailVO chooseTitleDetailVO = teacherService.chooseTitleDetail(titleId);
            return ResponseData.ok().putDataValue(chooseTitleDetailVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "确认学生选题",notes = "根据题目id确认学生选题信息")
    @GetMapping("/checkChoose")
    @RequiresRoles("teacher")
    public ResponseData checkChooseTitle(Long titleId){
        String value = teacherService.checkChooseTitle(titleId);
        String notes = "教师已确认";
        if(value.equals(notes)){
            return ResponseData.ok().putDataValue(value);
        }else{
            return new ResponseData(500,"请勿重复操作");
        }
    }

    @ApiOperation(value = "拒绝学生选题",notes = "根据题目id拒绝学生选题消息")
    @GetMapping("/refuseChoose")
    @RequiresRoles("teacher")
    public ResponseData refuseChooseTitle(Long titleId){
        String value = teacherService.refuseChooseTitle(titleId);
        String notes = "教师已拒绝";
        if(value.equals(notes)){
            return ResponseData.ok().putDataValue(value);
        }else{
            return new ResponseData(500,"请勿重复操作");
        }
    }

    @ApiOperation(value = "选题学生列表",notes = "根据教师userId获取确认选题学生列表")
    @GetMapping("/choiceTitleStu")
    @RequiresRoles("teacher")
    public TableVO getStuChoiceTitle(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId){
        Map<String, Object> map = teacherService.chooseStuVO(page,limit,userId);
        PageInfo pageInfoStu = (PageInfo) map.get("pageInfoStu");
        List<ChooseTitleVO> chooseStuVO = (List<ChooseTitleVO>) map.get("chooseStuVO");
        return new TableVO(pageInfoStu,chooseStuVO);
    }

    @ApiOperation(value = "任务书上传",notes = "根据学生userId上传任务书")
    @PostMapping("/uploadTaskFile")
    @RequiresRoles("teacher")
    public ResponseData uploadTaskFile(Long userId, String taskName, MultipartFile file,String schoolYear,HttpServletRequest request ){
        try {
            FileUploadUtil.uploadFile(file,request);
            String taskPath = FileUploadUtil.getUrl();
            teacherService.uploadTaskFiles(userId,taskName,taskPath,schoolYear);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "过程文档获取",notes = "根据学生userId获取学生提交的过程文档")
    @GetMapping("/readStuDocuments")
    public  ResponseData getStuDocuments(Long userId){
        try {
            FilesVO filesVO = teacherService.getDocuments(userId);
            return ResponseData.ok().putDataValue(filesVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "指导教师录入成绩",notes = "根据学生userId录入学生成绩")
    @PostMapping("/inputScore")
    @RequiresRoles("teacher")
    public ResponseData inputScore(Long userId,Float guidanceScore,String guidanceValue,String guidanceEditor,MultipartFile file,HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String guidanceSignature = FileUploadUtil.getUrl();
            teacherService.inputGuidanceScore(userId,guidanceScore,guidanceValue,guidanceEditor,guidanceSignature);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"录入失败");
        }
    }

    @ApiOperation(value = "教师开题答辩分组",notes = "按教师名对开题答辩分组进行查询")
    @GetMapping("/teachSelectOpen")
    @RequiresRoles("teacher")
    public ResponseData selectOpenDefence(String openTeachs,String schoolYear){
        try {
            List<DefenceGroupVO> openListVO = teacherService.openDefenceGroup(openTeachs,schoolYear);
            return ResponseData.ok().putDataValue(openListVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "教师毕设答辩分组",notes = "按教师名对答辩分组进行查询")
    @GetMapping("/teachSelectDefence")
    @RequiresRoles("teacher")
    public ResponseData selectByTeachName(String defenceTeachs,String schoolYear){
        try {
            List<DefenceGroupVO> defenceGroups = teacherService.selectByTeachName(defenceTeachs,schoolYear);
            return ResponseData.ok().putDataValue(defenceGroups);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "开题记录列表",notes = "根据教师userId获取教师开题记录")
    @GetMapping("/titleRecord")
    @RequiresRoles("teacher")
    public TableVO titleRecord(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId){
        Map<String, Object> map = teacherService.teachTitleRecord(page,limit ,userId);
        PageInfo pageInfoRecord = (PageInfo) map.get("pageInfoRecord");
        List<TeachTitleListVO> teachTitleRecordVO = (List<TeachTitleListVO>) map.get("teachTitleRecordVO");
        return new TableVO(pageInfoRecord,teachTitleRecordVO);
    }

    @ApiOperation(value = "搜索开题记录",notes = "按年份搜索开题记录")
    @PostMapping("/searchRecord")
    @RequiresRoles("teacher")
    public ResponseData recordSearch(@RequestBody RecordSearchDTO recordSearchDTO){
        try {
            List<TeachTitleListVO> recordList = teacherService.selectRecordByYear(recordSearchDTO);
            return ResponseData.ok().putDataValue(recordList);
        }catch (Exception e){
            return new ResponseData(500,"搜索错误");
        }
    }

    @ApiOperation(value = "学生成绩预览",notes = "根据学生userId预览学生成绩")
    @GetMapping("/getStuScore")
    @RequiresRoles("teacher")
    public ResponseData getStuScore(Long userId){
        Score score = teacherService.getStuScore(userId);
        if(null == score){
            return new ResponseData(500,"查找不到该学生成绩");
        }
        try {
            return ResponseData.ok().putDataValue(score);
        }catch (Exception e){
            return new ResponseData(500,"获取错误");
        }

    }

    @ApiOperation(value = "取消学生选题",notes = "在教师确认学生选题后，由于学生需要，根据学生userId取消学生选题信息")
    @GetMapping("/cancelStuTitle")
    @RequiresRoles("teacher")
    public ResponseData cancelStuTitle(Long userId){
        try {
            teacherService.cancelStuTitle(userId);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"删除失败");
        }
    }

    @ApiOperation(value = "开题报告审核",notes = "根据学生userId审核通过个人开题报告")
    @GetMapping("/checkStartFile")
    @RequiresRoles("teacher")
    public ResponseData checkStartFile(Long userId,String check,String startOpinion){
        try {
            boolean value = teacherService.checkStartFile(userId,check,startOpinion);
            if(value == false){
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "中期检查审核",notes = "根据学生userId审核通过个人中期检查")
    @GetMapping("/checkMiddleFile")
    @RequiresRoles("teacher")
    public ResponseData checkMiddleFile(Long userId,String check,String middleOpinion){
        try {
            boolean value = teacherService.checkMiddleFile(userId,check,middleOpinion);
            if (value == false) {
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "进度计划审核",notes = "根据学生userId审核通过个人进度计划")
    @GetMapping("/checkPlanFile")
    @RequiresRoles("teacher")
    public ResponseData checkPlanFile(Long planId,String check,String planOpinion){
        try {
            boolean value = teacherService.checkPlanFile(planId,check,planOpinion);
            if(value == false){
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "指导记录审核",notes = "根据个人userId审核通过个人指导记录")
    @GetMapping("/checkGuidanceFile")
    @RequiresRoles("teacher")
    public ResponseData checkGuidanceFile(Long guidanceId,String check,String guidanceOpinion){
        try {
            boolean value = teacherService.checkGuidanceFile(guidanceId,check,guidanceOpinion);
            if(value == false){
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "外文译文审核",notes = "根据学生userId审核通过个人外文译文")
    @GetMapping("/checkTranslationFile")
    @RequiresRoles("teacher")
    public ResponseData checkTranslationFile(Long userId,String check,String translationOpinion){
        try {
            boolean value = teacherService.checkTranslationFile(userId,check,translationOpinion);
            if(value == false){
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "外文原文审核",notes = "根据学生userId审核通过个人外文原文")
    @GetMapping("/checkOriginalFile")
    @RequiresRoles("teacher")
    public ResponseData checkOriginalFile(Long userId,String check,String originalOpinion){
        try {
            boolean value = teacherService.checkOriginalFile(userId,check,originalOpinion);
            if(value == false){
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "文献综述审核",notes = "根据学生userId审核通过个人文献综述")
    @GetMapping("/checkLiteratureFile")
    @RequiresRoles("teacher")
    public ResponseData checkLiteratureFile(Long userId,String check,String literatureOpinion){
        try {
            boolean value = teacherService.checkLiteratureFile(userId,check,literatureOpinion);
            if(value == false){
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "毕业论文审核",notes = "根据学生userId审核通过个人毕业论文")
    @GetMapping("/checkThesisFile")
    @RequiresRoles("teacher")
    public ResponseData checkThesisFile(Long userId,String check,String thesisOpinion){
        try {
            boolean value = teacherService.checkThesisFile(userId,check,thesisOpinion);
            if(value == false){
                return new ResponseData(500,"审核失败");
            }
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "删除题目",notes = "根据题目titleId删除题目")
    @GetMapping("/delTitle")
    @RequiresRoles("teacher")
    public ResponseData delTitle(Long titleId){
        boolean value = teacherService.ifSelectTitle(titleId);

        if(value == true){
            return new ResponseData(500,"该题目已被学生选择");
        }

        try {
            teacherService.delTitle(titleId);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"删除失败");
        }
    }

    @ApiOperation(value = "获取学生进度计划",notes = "根据学生userId获取个人进度计划记录")
    @GetMapping("/getPlanList")
    public ResponseData getPlanListVO(Long userId){
        try {
            List<PlanListVO> planListVO = teacherService.getPlanList(userId);
            return ResponseData.ok().putDataValue(planListVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "获取学生指导记录",notes = "根据学生userId获取学生个人指导记录")
    @GetMapping("/getGuidanceList")
    public ResponseData getGuidanceList(Long userId){
        try {
            List<GuidanceListVO> guidanceListVO = teacherService.getGuidanceList(userId);
            return ResponseData.ok().putDataValue(guidanceListVO);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }
}
