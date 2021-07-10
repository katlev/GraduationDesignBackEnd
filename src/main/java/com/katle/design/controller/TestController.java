package com.katle.design.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dto.UserDTO;
import com.katle.design.entities.Titles;
import com.katle.design.entities.User;
import com.katle.design.service.AdminService;
import com.katle.design.service.UserService;
import com.katle.design.utils.FileUploadUtil;
import com.katle.design.utils.ResponseData;
import com.katle.design.vo.TableVO;
import com.katle.design.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Api(value = "测试",tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "教师角色测试",notes = "教师角色角色测试")//swagger的接口说明
    @GetMapping("/test1")
    @RequiresRoles("teacher")
    public ResponseData getUser(String usernum){
        //return userService.getUserByPhone(phone);
        User user = userService.getUserByUsernum(usernum);
        if(user==null){
            return new ResponseData(500,"号码输入错误");
        }
        return ResponseData.ok().putDataValue(user);
    }

    @GetMapping("/test2")
    @ApiOperation(value = "学生角色测试2",notes = "学生角色测试2")
    @RequiresRoles("student") //角色设置
    //@RequiresPermissions("")
    public ResponseData test2(){
        return ResponseData.ok();
    }

    @GetMapping("/textAdmin")
    @ApiOperation(value = "管理员角色", notes = "管理员角色测试")
    @RequiresRoles("administrators")
    public ResponseData testAdmin(){
        return ResponseData.ok();
    }

    @GetMapping("/test3")
    @ApiOperation(value = "分页测试",notes = "分页测试")
    public TableVO test3(@RequestParam(value = "page",defaultValue = "1") Integer page,
                         @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);

        List<User> userList=userService.getUserList();
        PageInfo pageInfo=new PageInfo<>(userList);
        return new TableVO(pageInfo,userList);

    }
    @GetMapping("/test4")
    @ApiOperation(value = "分页测试2",notes = "分页测试2")
    public TableVO test4(@RequestParam(value = "page",defaultValue = "1") Integer page,
                         @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        Map<String,Object> map=userService.userVoList(page,limit);
        PageInfo pageInfo=(PageInfo)map.get("pageInfo");
        List<UserVO> userVOList=(List<UserVO>)map.get("userVOList");
        return new TableVO(pageInfo,userVOList);

    }

    @PostMapping("/test5")
    @ApiOperation(value = "文件上传测试",notes = "文件上传测试")
    public ResponseData test5(MultipartFile file, HttpServletRequest request){
        FileUploadUtil.uploadFile(file, request);
        String path=FileUploadUtil.getUrl();
        return ResponseData.ok().putDataValue(path);
    }

    /*Map<String,Object> map;
    map.put("1",list1);
    map.put("2",list2);*/


    @PostMapping("/test6")
    @ApiOperation(value = "数据校验测试",notes = "数据校验测试")
    public ResponseData test6(@Validated @RequestBody UserDTO userDTO){

        return ResponseData.ok();
    }

    @ApiOperation(value = "题目模糊查询",notes = "题目模糊查询")
    @GetMapping("/findTitle")
    public List<Titles> getTitleInfo(String titleName){
        return adminService.getTitleByName(titleName);
    }

    @ApiOperation(value = "多值模糊查询",notes = "一张表多字段模糊查询")
    @GetMapping("/getUserByValue")
    public List<User> getUsers(String value){
        return userService.getUsers(value);
    }

    @ApiOperation(value = "文件导入",notes = "文件导入")
    @PostMapping("/uploadFile")
    public ResponseData uploadFile(MultipartFile file) throws IOException {
        InputStream in = null;
        try{
            in = file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowNum = xssfSheet.getLastRowNum();
        LOGGER.info(String.valueOf(rowNum));
        for(int i=1;i<rowNum;i++){
            //当前行
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

            /*将数据写入实体类*/
            /*User user = new User();
            user.setUserId(null);
            user.setUsernum(usernum);
            user.setUsername(username);
            user.setPassword(password);
            user.setCollege(college);
            user.setMajor(major);
            user.setGrade(grade);
            user.setPosition(null);
            user.setEmail(null);
            user.setAvatar(null);*/

            //userService.insert(user);
        }
        return ResponseData.ok();
    }

    @ApiOperation(value = "文件导入测试2",notes = "文件导入测试2")
    @PostMapping("/uploadFileText")
    public ResponseData uploadFileText(MultipartFile file) throws IOException {
        InputStream in = null;
        try {
            //将file转InputStream
            in = file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        /*将InputStream转XLSX对象（及表格对象）*/
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        /*获取表格的第一页*/
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        /*该页有多少数据*/
        int rowNum = xssfSheet.getLastRowNum();
        LOGGER.info(String.valueOf(rowNum));
        for (int i=1;i<=rowNum;i++){
            /*获取当前行*/
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

        }
        return ResponseData.ok();

    }

}
