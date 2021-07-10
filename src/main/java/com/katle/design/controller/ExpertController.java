package com.katle.design.controller;

import com.github.pagehelper.PageInfo;
import com.katle.design.dto.TitleIdDTO;
import com.katle.design.service.ExpertService;
import com.katle.design.utils.FileUploadUtil;
import com.katle.design.utils.ResponseData;
import com.katle.design.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.control.TableView;
import org.apache.catalina.connector.ResponseFacade;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

@Api(value = "评阅专家模块",tags = "评阅专家模块")
@RestController
@CrossOrigin
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @ApiOperation(value = "审题列表",notes = "根据教师userId获取个人审题列表")
    @GetMapping("/getTitleCheckList")
    @RequiresRoles("teacher")
    public TableVO getTitleCheckList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit",defaultValue = "10") Integer limit, Long userId){
            Map<String,Object> map = expertService.getCheckTitleList(page,limit,userId);
            PageInfo pageInfoCheckTitle = (PageInfo) map.get("pageInfoCheckTitle");
            List<TitleListVO> checkTitleList = (List<TitleListVO>) map.get("checkTitleList");
            return new TableVO(pageInfoCheckTitle,checkTitleList);
    }

    @ApiOperation(value = "任务书审核列表",notes = "根据教师userId获取个人审核任务书列表")
    @GetMapping("/getTaskCheckList")
    @RequiresRoles("teacher")
    public TableVO getTaskCheckList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "10")Integer limit,Long userId){
        Map<String,Object> map = expertService.getCheckTaskList(page,limit,userId);
        PageInfo pageInfoCheckTask = (PageInfo) map.get("pageInfoCheckTask");
        List<TaskListVO> checkTaskList = (List<TaskListVO>) map.get("checkTaskList");
        return new TableVO(pageInfoCheckTask,checkTaskList);
    }

    @ApiOperation(value = "任务书审核通过",notes = "根据学生userId审核通过学生个人提交的任务书")
    @PutMapping("/checkTaskItem")
    @RequiresRoles("teacher")
    public ResponseData checkTaskItem(@RequestBody TitleIdDTO titleIdDTO){
        try {
            expertService.checkTaskItem(titleIdDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "任务书回退修改",notes = "根据学生userId审核回退学生个人提交的任务书")
    @PutMapping("/returnTaskItem")
    @RequiresRoles("teacher")
    public ResponseData returnTaskItem(@RequestBody TitleIdDTO titleIdDTO){
        try {
            expertService.returnTaskItem(titleIdDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "审核任务书详情",notes = "根据学生userId获取审核任务书的详细内容")
    @GetMapping("/getCheckTaskDetail")
    @RequiresRoles("teacher")
    public ResponseData getCheckTaskDetail(Long userId){
        try {
            CheckTaskDetailVO task = expertService.getCheckTaskDetail(userId);
            return ResponseData.ok().putDataValue(task);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "待评阅学生列表",notes = "根据教师userId获取待评阅学生列表")
    @GetMapping("/getReviewStuList")
    @RequiresRoles("expert")
    public TableVO getReviewStuList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "9")Integer limit,Long userId){
        Map<String,Object> map = expertService.getReviewStuList(page,limit,userId);
        PageInfo pageInfoReviewStu = (PageInfo) map.get("pageInfoReviewStu");
        List<StuListVO> reviewStuLists = (List<StuListVO>) map.get("reviewStuLists");
        return new TableVO(pageInfoReviewStu,reviewStuLists);

    }

    @ApiOperation(value = "评阅成绩录入",notes = "根据学生userId录入学生评阅成绩")
    @PostMapping("/inputReadScore")
    @RequiresRoles("teacher")
    public ResponseData inputReviewScore(Long userId, Float readScore, String readValue,String readEditor, MultipartFile file, HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String readSignature = FileUploadUtil.getUrl();
            expertService.inputReviewScore(userId,readScore,readValue,readEditor,readSignature);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"录入失败");
        }
    }

    @ApiOperation(value = "获取答辩组学生列表",notes = "根据答辩组id获取该组答辩学生名单列表")
    @GetMapping("/getDesignStuList")
    @RequiresRoles("teacher")
    public ResponseData getDesignStuList(Long defenceId){
       try {
           List<StuListVO> defenceStuList = expertService.getDesignStuList(defenceId);
           return ResponseData.ok().putDataValue(defenceStuList);
       }catch (Exception e){
           return new ResponseData(500,"获取失败");
       }
    }

    @ApiOperation(value = "毕设答辩成绩录入",notes = "根据学生userId录入学生毕设答辩成绩")
    @PostMapping("/inputGuidanceScore")
    @RequiresRoles("teacher")
    public ResponseData inputGuidanceScore(Long userId, Float defenceScore, String defenceValue, String defenceEditor, MultipartFile file, HttpServletRequest request){
        try {
            FileUploadUtil.uploadFile(file,request);
            String defenceSignature = FileUploadUtil.getUrl();
            expertService.inputDefenceScore(userId,defenceScore,defenceValue,defenceEditor,defenceSignature);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"录入失败");
        }
    }


}
