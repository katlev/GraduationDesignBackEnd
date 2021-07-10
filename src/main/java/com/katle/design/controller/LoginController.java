package com.katle.design.controller;

import com.katle.design.entities.User;
import com.katle.design.service.UserService;
import com.katle.design.utils.FileUploadUtil;
import com.katle.design.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Api(value = "用户注册登录",tags = "用户注册登录")
/**
 * 注入控制器
 */
@RestController
/**
 * 跨域
 */
@CrossOrigin

public class LoginController {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoginController.class);
    private UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService=userService;
    }

    @ApiOperation(value = "管理员登录",notes = "根据学号密码登录")
    @PostMapping("/login")
    public ResponseData userLogin(String usernum, String password){
        User user=userService.getUserByUsernum(usernum);
        if(null==user){
            return new ResponseData(500,"用户不存在");
        }
        String admin = userService.getRoleByUsernum(usernum);
        String value = "administrators";
        if(!admin.equals(value)){
            return new ResponseData(500,"用户身份错误");
        }
        try {
            Map<String,String> map=new HashMap<>(6);
            //password=new Md5Hash(password,phoneNumber,3).toString();
            UsernamePasswordToken token=new UsernamePasswordToken(usernum,password);
            Subject subject= SecurityUtils.getSubject();
            String sessionId=(String)subject.getSession().getId();
            subject.login(token);
            LOGGER.info("hahahaa");

            String role=userService.getRole(user.getUserId());
            map.put("token",sessionId);
            map.put("usernum",usernum);
            map.put("role",role);
            map.put("userId",user.getUserId()+"");
            map.put("username",user.getUsername());

            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return new ResponseData(500,"login failed");
        }
    }

    @ApiOperation(value = "学生教师登录",notes = "学生教师登录")
    @PostMapping("/stuAndTeachLogin")
    public ResponseData stuOrTeachLogin(String usernum,String password,String identity){
        User user = userService.getUserByUsernum(usernum);
        if (null == user){
            return new ResponseData(500,"用户不存在");
        }
        String value = userService.getRoleByUsernum(usernum);
        String[] arr = value.split(",");
        LOGGER.info(arr[0]);
        String roleValue = arr[0];
        if(!roleValue.equals(identity)){
            return new ResponseData(500,"身份错误");
        }
        try {
            Map<String, Object> map = new HashMap<>(6);
            UsernamePasswordToken token = new UsernamePasswordToken(usernum,password );
            Subject subject = SecurityUtils.getSubject();
            String sessionId = (String) subject.getSession().getId();
            subject.login(token);

            String role = userService.getRole(user.getUserId());
            map.put("token",sessionId);
            map.put("usernum",usernum);
            map.put("role",role);
            map.put("userId",user.getUserId());
            map.put("username",user.getUsername());
            map.put("schoolYear",user.getSchoolYear());
            return ResponseData.ok().putDataValue(map);
        }catch (Exception e){
            return new ResponseData(500,"login failed");
        }

    }

    @ApiOperation(value = "获取用户信息",notes = "根据用户id获取用户信息")
    @GetMapping("/getUserInfo")
    public ResponseData getUserInfo(Long userId){
        User user = userService.getUserByUserId(userId);
        try {
            return ResponseData.ok().putDataValue(user);
        }catch (Exception e){
            return new ResponseData(500,"获取用户信息失败");
        }
    }

    @ApiOperation(value = "用户密码修改",notes = "根据用户id修改用户密码")
    @PostMapping("/updataUserPwd")
    public ResponseData updateUserPassword(Long id,String password){
        try {
            userService.updateUserPwd(id,password);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"修改密码失败");
        }
    }

    @ApiOperation(value = "管理员个人信息修改",notes = "根据用户id修改管理员个人信息")
    @PutMapping("/updateAdminInfo")
    @RequiresRoles("administrators")
    public ResponseData updateAdminInfo(Long id,String usernum,String username,String password,String position,String college,String avatar){
        try {
            userService.updateAdminInfo(id,usernum,username,password,position,college,avatar);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"修改失败");
        }
    }

    @ApiOperation(value = "管理员注册",notes = "管理员注册")
    @PostMapping("/addAdmin")
    public ResponseData addAdmin(String usernum,String username,String password,String position,String college){
        try{
            userService.adminRegister(usernum,username,password,position,college);
            return ResponseData.ok();
        }catch (Exception e) {
            boolean checkAdmin = userService.checkAdmin(usernum);
            System.out.println(checkAdmin);
            if(checkAdmin == true){
                return new ResponseData(500,"该用户已存在");
            }else{
                return new ResponseData(500,"注册失败");
            }
        }
    }

    @ApiOperation(value = "图片上传",notes = "根据用户userId上传图片")
    @PostMapping("/uploadImg")
    public ResponseData uploadImg(MultipartFile file, HttpServletRequest request,Long userId){
        try {
            //LOGGER.info("ddd"+String.valueOf(file));
            FileUploadUtil.uploadFile(file,request);
            String avatar = FileUploadUtil.getUrl();
            userService.uploadImg(userId,avatar);
            return ResponseData.ok().putDataValue(avatar);
        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "退出登录",notes = "用户退出登录")
    @GetMapping("/signOut")
    public ResponseData signOut(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"退出失败");
        }

    }
}
