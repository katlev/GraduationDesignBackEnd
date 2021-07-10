package com.katle.design.controller;

import com.github.pagehelper.PageInfo;
import com.katle.design.dto.DefenceGroupDTO;
import com.katle.design.dto.IdAndNameDTO;
import com.katle.design.service.ProcessDocService;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Api(value = "过程文档和答辩管理",tags = "过程文档答辩管理")
@RestController
@CrossOrigin
public class ProcessDocController {
    @Autowired
    private ProcessDocService processDocService;

    @ApiOperation(value = "获取任务书列表",notes = "任务书列表获取")
    @GetMapping("/getTaskList")
    @RequiresRoles("administrators")
    public TableVO getTaskList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId,String schoolYear){
       Map<String,Object> map = processDocService.getTaskList(page,limit,userId,schoolYear);
       PageInfo pageInfo = (PageInfo) map.get("pageInfoTask");
       List<TaskListVO> taskList = (List<TaskListVO>) map.get("taskList");
       return new TableVO(pageInfo,taskList);

    }

    @ApiOperation(value = "任务书查询",notes = "根据题目名查询任务书")
    @GetMapping("/searchTask")
    @RequiresRoles("administrators")
    public TableVO searchTaskList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit",defaultValue = "20") Integer limit,Long userId,String schoolYear,String checkTask){
        Map<String,Object> map = processDocService.searchTaskList(page,limit,userId,schoolYear,checkTask);
        PageInfo pageInfo = (PageInfo) map.get("pageInfoSearchTask");
        List<TaskListVO> taskList = (List<TaskListVO>) map.get("taskListSearch");
        return new TableVO(pageInfo,taskList);
    }

    @ApiOperation(value = "指定任务书审核教师",notes = "根据userId指定相应教师为任务书审题教师")
    @PostMapping("/setTaskCheckMan")
    @RequiresRoles("administrators")
    public ResponseData setTaskCheckMan(@RequestBody IdAndNameDTO idAndNameDTO){
        try {
            processDocService.setTaskCheckMan(idAndNameDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"指定失败");
        }
    }

    @ApiOperation(value = "审核任务书",notes = "根据userId来审核任务书")
    @GetMapping("/checkTaskFile")
    public ResponseData checkTaskFile(Long userId,String checkValue){
        try {
            processDocService.checkTaskFile(userId,checkValue);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"审核失败");
        }
    }

    @ApiOperation(value = "获取开题答辩列表",notes = "获取当前年份开题答辩列表")
    @GetMapping("/getOpenList")
    @RequiresRoles("administrators")
    public TableVO getOpenDefenceList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "20")Integer limit,String schoolYear,Long adminId){
        Map<String,Object> map = processDocService.getOpenList(page,limit,schoolYear,adminId);
        PageInfo pageInfo = (PageInfo) map.get("pageInfoOpen");
        List<TaskListVO> openList = (List<TaskListVO>) map.get("openDefenceVO");
        return new TableVO(pageInfo,openList);
    }

    @ApiOperation(value = "开题答辩分组搜索",notes = "根据关键词搜搜开题答辩分组")
    @GetMapping("/searchOpenDefence")
    @RequiresRoles("administrators")
    public TableVO searchOpenDefence(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "20")Integer limit,String schoolYear,String searchValue,Long adminId){
        Map<String, Object> map = processDocService.searchOpenList(page,limit,schoolYear,adminId,searchValue);
        PageInfo pageInfoOpenSearch = (PageInfo) map.get("pageInfoOpenSearch");
        List<DefenceGroupVO> openDefenceSearchVO = (List<DefenceGroupVO>) map.get("openDefenceSearchVO");
        return new TableVO(pageInfoOpenSearch,openDefenceSearchVO);
    }

    @ApiOperation(value = "创建开题答辩分组",notes = "插入开题答辩组")
    @PostMapping("/insertOpenDefence")
    @RequiresRoles("administrators")
    public ResponseData insertOpenDefence(String openName,String openPlace,String openDate,String openTime,String openTeachs,String openStudents,String openLeader,String openYear,Long adminId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        //OpenDefence openDefence = processDocService.findOpenByOpenName(openName);
        /*if(openDefence != null){
            return new ResponseData(500,"分组名重复，请重新命名");
        }*/
        try {
            Date date = simpleDateFormat.parse(openDate);
            Date time = simpleDateFormat1.parse(openTime);
            processDocService.insertOpenDefence(openName,openPlace,date,time,openTeachs,openStudents,openLeader,openYear,adminId);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"添加失败");
        }
    }

    @ApiOperation(value = "创建开题答辩分组2",notes = "创建开题答辩分组2")
    @PostMapping("/addOpenDefence")
    @RequiresRoles("administrators")
    public ResponseData addOpenDefence(@RequestBody DefenceGroupDTO defenceGroupDTO){
        try {
            processDocService.addOpenDefence(defenceGroupDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"添加失败");
        }
    }

    @ApiOperation(value = "开题答辩文件导入",notes = "开题答辩文件导入")
    @PostMapping("/batchImport")
    @RequiresRoles("administrators")
    public ResponseData importStartFile(Long adminId,String schoolYear,MultipartFile file) throws IOException, ParseException {
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

            String openName = xssfRow.getCell(0).toString();
            String openPlace = xssfRow.getCell(1).toString();

            Date timeValue = xssfRow.getCell(2).getDateCellValue();
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            String openTime = format.format(timeValue);

            Date dateValue = xssfRow.getCell(3).getDateCellValue();
            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            String openDate = formater.format(dateValue);

            String openTeachs = xssfRow.getCell(4).toString();
            String openStudents = xssfRow.getCell(5).toString();
            String openLeader = xssfRow.getCell(6).toString();

            LOGGER.info(openName);
            LOGGER.info(openPlace);
            LOGGER.info(openTime);
            LOGGER.info(openDate);
            LOGGER.info(openTeachs);
            LOGGER.info(openStudents);
            LOGGER.info(openLeader);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
            Date defDate = simpleDateFormat.parse(openDate);
            Date defTime = simpleDateFormat1.parse(openTime);

            processDocService.insertOpenDefence(openName,openPlace,defDate,defTime,openTeachs,openStudents,openLeader,schoolYear,adminId);

        }
        return ResponseData.ok();
    }

    @ApiOperation(value = "开题报告列表获取",notes = "根据管理员userId获取相应学院和当前学年的开题报告")
    @GetMapping("getStartFileList")
    @RequiresRoles("administrators")
    public TableVO getStartFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.startFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoStartFile = (PageInfo) map.get("pageInfoStartFile");
        List<FilesListVO> startFileList = (List<FilesListVO>) map.get("startFileList");
        return new TableVO(pageInfoStartFile,startFileList);
    }

    @ApiOperation(value = "开题报告查询",notes = "根据关键字查询开题报告")
    @GetMapping("/searchStartFile")
    @RequiresRoles("administrators")
    public TableVO searchStartFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                   @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchStartFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfo = (PageInfo) map.get("pageInfoSearchStart");
        List<FilesListVO> searchStartList = (List<FilesListVO>) map.get("searchStartList");
        return new TableVO(pageInfo,searchStartList);
    }

    @ApiOperation(value = "中期检查列表获取",notes = "根据管理员userId获取当前学年的中期检查报告")
    @GetMapping("/getMiddleFileList")
    @RequiresRoles("administrators")
    public TableVO getMiddleFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.middleFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoMiddle = (PageInfo) map.get("pageInfoMiddle");
        List<FilesListVO> middleListVO = (List<FilesListVO>) map.get("middleListVO");
        return new TableVO(pageInfoMiddle,middleListVO);

    }

    @ApiOperation(value = "中期检查查询",notes = "根据关键词查询中期检查")
    @GetMapping("/searchMiddleFile")
    @RequiresRoles("administrators")
    public TableVO searchMiddleFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchMiddleFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoSearchMiddle = (PageInfo) map.get("pageInfoSearchMiddle");
        List<FilesListVO> searchMiddleList = (List<FilesListVO>) map.get("searchMiddleList");
        return new TableVO(pageInfoSearchMiddle,searchMiddleList);
    }

    @ApiOperation(value = "外文译文获取",notes = "根据管理员id获取当前学年外文译文")
    @GetMapping("/getTranslationFile")
    @RequiresRoles("administrators")
    public TableVO translationFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                       @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.translationFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoTranslation = (PageInfo) map.get("pageInfoTranslation");
        List<FilesListVO> translationListVO = (List<FilesListVO>) map.get("translationListVO");
        return new TableVO(pageInfoTranslation,translationListVO);

    }

    @ApiOperation(value = "外文译文查询",notes = "根据关键字查询外文译文")
    @GetMapping("/searchTranslationFile")
    @RequiresRoles("administrators")
    public TableVO searchTranslationFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                        @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchTranslationFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoTranslationSearch = (PageInfo) map.get("pageInfoTranslationSearch");
        List<FilesListVO> translationSearchVO = (List<FilesListVO>) map.get("translationSearchVO");
        return new TableVO(pageInfoTranslationSearch,translationSearchVO);
    }

    @ApiOperation(value = "外文原文获取",notes = "根据管理员userId获取当前年份外文原文")
    @GetMapping("/getOriginalFile")
    @RequiresRoles("administrators")
    public TableVO originalFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.originalFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoOriginal = (PageInfo) map.get("pageInfoOriginal");
        List<FilesListVO> originalListVO = (List<FilesListVO>) map.get("originalListVO");
        return new TableVO(pageInfoOriginal,originalListVO);
    }

    @ApiOperation(value = "外文原文搜索",notes = "根据关键词搜索外文原文")
    @GetMapping("/searchOriginalFile")
    @RequiresRoles("administrators")
    public TableVO searchOriginalFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchOriginalFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoOriginalSearch = (PageInfo) map.get("pageInfoOriginalSearch");
        List<FilesListVO> originalListSearchVO = (List<FilesListVO>) map.get("originalListSearchVO");
        return new TableVO(pageInfoOriginalSearch,originalListSearchVO);
    }

    @ApiOperation(value = "文献综述获取",notes = "根据管理员userId获取当前年份文献综述")
    @GetMapping("/getLiteratureFile")
    @RequiresRoles("administrators")
    public TableVO literatureFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                       @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.literatureFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoLiterature = (PageInfo) map.get("pageInfoLiterature");
        List<FilesListVO> literatureListVO = (List<FilesListVO>) map.get("literatureListVO");
        return new TableVO(pageInfoLiterature, literatureListVO);
    }

    @ApiOperation(value = "文献综述查询",notes = "根据关键字查询文献综述")
    @GetMapping("/searchLiteratureFile")
    @RequiresRoles("administrators")
    public TableVO searchLiteratureFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                        @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchLiteratureFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoLiteratureSearch = (PageInfo) map.get("pageInfoLiteratureSearch");
        List<FilesListVO> literatureListSearch = (List<FilesListVO>) map.get("literatureListSearch");
        return new TableVO(pageInfoLiteratureSearch,literatureListSearch);
    }

    @ApiOperation(value = "毕业论文获取",notes = "根据管理员userId获取当前年份毕业论文")
    @GetMapping("/getThesisFile")
    @RequiresRoles("administrators")
    public TableVO thesisFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                  @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.thesisFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoThesis = (PageInfo) map.get("pageInfoThesis");
        List<FilesListVO> thesisFileListVO = (List<FilesListVO>) map.get("thesisFileListVO");
        return new TableVO(pageInfoThesis,thesisFileListVO);
    }

    @ApiOperation(value = "毕业论文查询",notes = "根据关键词查询毕业论文")
    @GetMapping("/searchThesisFile")
    @RequiresRoles("administrators")
    public TableVO searchThesisFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchThesisFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoThesisSearch = (PageInfo) map.get("pageInfoThesisSearch");
        List<FilesListVO> thesisListSearchVO = (List<FilesListVO>) map.get("thesisListSearchVO");
        return new TableVO(pageInfoThesisSearch,thesisListSearchVO);
    }

    @ApiOperation(value = "指导记录获取",notes = "根据管理员id获取当前学年指导记录")
    @GetMapping("/getGuidanceFile")
    @RequiresRoles("administrators")
    public TableVO guidanceFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.guidanceFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoGuidance = (PageInfo) map.get("pageInfoGuidance");
        List<GuiAndPlanFileVO> guidanceListVO = (List<GuiAndPlanFileVO>) map.get("guidanceListVO");
        return new TableVO(pageInfoGuidance,guidanceListVO);
    }

    @ApiOperation(value = "指导记录查询",notes = "根据关键词查询指导记录")
    @GetMapping("/searchGudianceFile")
    @RequiresRoles("administrators")
    public TableVO searchGuidanceFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchGuidanceFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoGuidanceSearch = (PageInfo) map.get("pageInfoGuidanceSearch");
        List<GuiAndPlanFileVO> guidanceListSearchVO = (List<GuiAndPlanFileVO>) map.get("guidanceListSearchVO");
        return new TableVO(pageInfoGuidanceSearch,guidanceListSearchVO);
    }

    @ApiOperation(value = "进度计划获取",notes = "根据管理员id获取当前学年的进度计划")
    @GetMapping("/getPlanFileList")
    @RequiresRoles("administrators")
    public TableVO planFileList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.planFileList(page,limit,userId,schoolYear);
        PageInfo pageInfoPlan = (PageInfo) map.get("pageInfoPlan");
        List<GuiAndPlanFileVO> planListVO = (List<GuiAndPlanFileVO>) map.get("planListVO");
        return new TableVO(pageInfoPlan,planListVO);
    }

    @ApiOperation(value = "进度计划查询",notes = "根据关键词查询进度计划")
    @GetMapping("/searchPlanFile")
    @RequiresRoles("administrators")
    public TableVO searchPlanFile(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                  @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchPlanFile(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoPlanSearch = (PageInfo) map.get("pageInfoPlanSearch");
        List<GuiAndPlanFileVO> planListSearchVO = (List<GuiAndPlanFileVO>) map.get("planListSearchVO");
        return new TableVO(pageInfoPlanSearch,planListSearchVO);
    }

    @ApiOperation(value = "个人指导记录获取",notes = "根据学生userId获取个人指导记录")
    @GetMapping("/getGuiDetailList")
    @RequiresRoles("administrators")
    public TableVO guidanceDetailList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId){
        Map<String, Object> map = processDocService.guiDetailList(page,limit,userId);
        PageInfo pageInfoGuidanceDetail = (PageInfo) map.get("pageInfoGuidanceDetail");
        List<GuidanceItemDetail> guidanceDetailList = (List<GuidanceItemDetail>) map.get("guidanceDetailList");
        return new TableVO(pageInfoGuidanceDetail,guidanceDetailList);
    }

    @ApiOperation(value = "个人进度计划获取",notes = "根据学生userId获取个人进度计划")
    @GetMapping("/getGuiPlanList")
    @RequiresRoles("administrators")
    public TableVO planDetailList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                  @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId){
        Map<String, Object> map = processDocService.planDetailList(page,limit,userId);
        PageInfo pageInfoPlanDetail = (PageInfo) map.get("pageInfoPlanDetail");
        List<PlanItemDetail> planDetailList = (List<PlanItemDetail>) map.get("planDetailList");
        return new TableVO(pageInfoPlanDetail,planDetailList);
    }

    @ApiOperation(value = "选题管理",notes = "选题管理列表")
    @GetMapping("/getChooseTitleList")
    @RequiresRoles("administrators")
    public TableVO chooseTitleList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                   @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear){
        Map<String, Object> map = processDocService.getChooseTitleList(page,limit,userId,schoolYear);
        PageInfo pageInfoChoose = (PageInfo) map.get("pageInfoChoose");
        List<ChooseTitleDetailVO> chooseTitle = (List<ChooseTitleDetailVO>) map.get("chooseTitle");
        return new TableVO(pageInfoChoose,chooseTitle);
    }

    @ApiOperation(value = "选题搜索",notes = "根据关键词进行选题搜索")
    @GetMapping("/searchChooseTitle")
    @RequiresRoles("administrators")
    public TableVO searchChooseTitle(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "20")Integer limit,Long userId,String schoolYear,String searchValue){
        Map<String, Object> map = processDocService.searchChooseTitle(page,limit,userId,schoolYear,searchValue);
        PageInfo pageInfoChooseSearch = (PageInfo) map.get("pageInfoChooseSearch");
        List<ChooseTitleDetailVO> searchChooseList = (List<ChooseTitleDetailVO>) map.get("searchChooseList");
        return new TableVO(pageInfoChooseSearch,searchChooseList);
    }

    @ApiOperation(value = "分配审核专家",notes = "根据学生userId为学生分配审核教师")
    @PostMapping("/setStuToExpert")
    @RequiresRoles("administrators")
    public ResponseData setStuToExpert(@RequestBody IdAndNameDTO idAndNameDTO){
        try {
            processDocService.setStuToExpert(idAndNameDTO);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"分配失败");
        }
    }

    @ApiOperation(value = "获取评阅专家列表",notes = "获取评阅专家列表")
    @GetMapping("/getExpertList")
    @RequiresRoles("administrators")
    public ResponseData getExpertList(Long userId,String schoolYear){
        try {
            List<TeachListVO> expertList = processDocService.getExpertList(userId,schoolYear);
            return ResponseData.ok().putDataValue(expertList);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "文件导出",notes = "导出学生成绩表")
    @GetMapping("/exportFile")
    public ResponseData fileExport(HttpServletResponse response){
        XSSFWorkbook wb = processDocService.exportScore();
        String fileName = "分数表.xlsx";
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

        }catch(Exception e){
            return new ResponseData(500,"导出失败");
        }
    }

}
