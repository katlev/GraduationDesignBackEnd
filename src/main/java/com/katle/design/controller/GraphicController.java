package com.katle.design.controller;

import com.katle.design.service.GraphicService;
import com.katle.design.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Api(value = "统计模块",tags = "统计模块")

@RestController

@CrossOrigin
public class GraphicController {
    @Autowired
    private GraphicService graphicService;

    @ApiOperation(value = "开题报告统计",notes = "获取当前院系开题报告统计情况")
    @GetMapping("/startGraphic")
    @RequiresRoles("administrators")
    public ResponseData startGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer startNum = graphicService.startFileNum(adminId,schoolYear);
            Integer unSubmitNum = stuNum - startNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("startNum",startNum);
            map.put("unSubmitNum",unSubmitNum);
            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "中期检查统计",notes = "获取当前院系中期检查报告统计情况")
    @GetMapping("/middleGraphic")
    @RequiresRoles("administrators")
    public ResponseData middleGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer middleNum = graphicService.middleFileNum(adminId,schoolYear);
            Integer unSubmit = stuNum - middleNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("middleNum",middleNum);
            map.put("unSubmit",unSubmit);

            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "外文译文统计",notes = "获取当前院系外文译文提交统计情况")
    @GetMapping("/translationGraphic")
    @RequiresRoles("administrators")
    public ResponseData translationGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer translationNum = graphicService.translationNum(adminId,schoolYear);
            Integer unSubmit = stuNum - translationNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("translationNum",translationNum);
            map.put("unSubmit",unSubmit);
            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "外文原文统计",notes = "获取当前院系外文原文统计情况")
    @GetMapping("/originalGraphic")
    @RequiresRoles("administrators")
    public ResponseData originalGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer originalNum = graphicService.originalNum(adminId,schoolYear);
            Integer unSubmit = stuNum - originalNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("originalNum",originalNum);
            map.put("unSubmit",unSubmit);
            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "文献综述统计",notes = "获取当前院系文献综述统计情况")
    @GetMapping("/literatureGraphic")
    @RequiresRoles("administrators")
    public ResponseData literatureGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer literatureNum = graphicService.literatureNum(adminId,schoolYear);
            Integer unSubmit = stuNum - literatureNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("literatureNum",literatureNum);
            map.put("unSubmit",unSubmit);

            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "毕业论文统计",notes = "获取当前院系毕业论文统计情况")
    @GetMapping("/thesisGraphic")
    @RequiresRoles("administrators")
    public ResponseData thesisGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer thesisNum = graphicService.thesisNum(adminId,schoolYear);
            Integer unSubmit = stuNum - thesisNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("thesisNum",thesisNum);
            map.put("unSubmit",unSubmit);
            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "指导记录统计情况",notes = "获取当前院系指导记录统计情况")
    @GetMapping("/guidanceGraphic")
    @RequiresRoles("administrators")
    public ResponseData guidanceGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer guidanceNum = graphicService.guidanceNum(adminId,schoolYear);
            Integer unSubmit = stuNum - guidanceNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("guidanceNum",guidanceNum);
            map.put("unSubmit",unSubmit);

            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "进度计划统计",notes = "获取当前院系进度计划统计情况")
    @GetMapping("/planGraphic")
    @RequiresRoles("administrators")
    public ResponseData planGraphic(Long adminId,String schoolYear){
        try {
            Integer stuNum = graphicService.stuTotalNum(adminId,schoolYear);
            Integer planNum = graphicService.planNum(adminId,schoolYear);
            Integer unSubmit = stuNum - planNum;

            Map<String, Integer> map = new HashMap<>();
            map.put("stuNum",stuNum);
            map.put("planNum",planNum);
            map.put("unSubmit",unSubmit);

            return ResponseData.ok().putDataValue(map);
        }catch (Exception e ){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "分数统计",notes = "获取当前学年分数统计情况")
    @GetMapping("/scoreGraphic")
    @RequiresRoles("administrators")
    public ResponseData scoreGraphic(Long adminId,String schoolYear){
        try {
            Map<String, Integer> map = graphicService.scoreGrade(adminId,schoolYear);
            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "导出指导记录",notes = "导出当前学年指导记录")
    @GetMapping("/exportGuidance")
    public ResponseData exportGuidance(Long userId,String schoolYear,HttpServletResponse response){
        XSSFWorkbook wb = graphicService.exportGuidance(userId,schoolYear);
        String fileName = "学生指导记录表.xlsx";
        OutputStream outputStream = null;
        try {
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //设置content-type请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();

            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"导出失败");
        }
    }

    @ApiOperation(value = "导出进度计划",notes = "导出当前学年进度计划")
    @GetMapping("/exportPlan")
    public ResponseData exportPlan(Long userId,String schoolYear,HttpServletResponse response){
        XSSFWorkbook wb = graphicService.exportPlan(userId,schoolYear);
        String fileName = "学生进度计划表.xlsx";
        OutputStream outputStream = null;
        try {
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //设置content-type请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();

            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"导出失败");
        }

    }


}
