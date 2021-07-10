package com.katle.design.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.katle.design.entities.Openid;
import com.katle.design.service.SubscribeService;
import com.katle.design.service.TeacherService;
import com.katle.design.utils.ResponseData;
import com.katle.design.vo.ChooseTitleDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.ws.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Api(value = "订阅消息",tags = "用于消息订阅")

/**
 * 注入控制器
 */
@RestController

/**
 * 跨域
 */
@CrossOrigin
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    public String getAccessToken(){
        /*你的appId*/
        String appId = "wxad592d94592676a3";
        /*你的小程序秘钥*/
        String appSecret = "4dff31cc7b93738ac4c3cf5aa105d9ef";
        String result = cn.hutool.http.HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret);
        LOGGER.info("result:" + result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject.getString("access_token");

    }

    @ApiOperation(value = "选题消息提醒",notes = "学生选题后向教师推送的消息模板")
    @GetMapping("/sendSelectMsg")
    public ResponseData send(String openId,String usernum,String username,String titleName){
        try {
           /* ChooseTitleDetailVO chooseTitleDetailVO = teacherService.chooseTitleDetail(titleId);
            LOGGER.info(chooseTitleDetailVO.toString());*/
            JSONObject body = new JSONObject();

            /*用户的openId*/
            body.put("touser",openId);
            /*选题消息推送模板Id*/
            body.put("template_id","UO7X3CbeJZ3REJndljqRuXENCsmU94Whvhg0xLvw9PU");

            JSONObject json = new JSONObject();

            JSONObject number1 = new JSONObject();
            number1.put("value", usernum);
            json.put("number1", number1);

            JSONObject thing2 = new JSONObject();
            thing2.put("value", username);
            json.put("thing2", thing2);

            JSONObject thing3 = new JSONObject();
            thing3.put("value",titleName);
            json.put("thing3", thing3);

            JSONObject time4 = new JSONObject();
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = dateTime.format(formatter);
            time4.put("value", time);
            json.put("time4", time4);

            LOGGER.info("json:"+ json);

            body.put("data",json);
            LOGGER.info("body:" + body.toString());

            String accessToken = getAccessToken();
            LOGGER.info(accessToken);

            String post = cn.hutool.http.HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken, body.toString());

            LOGGER.info("post:" + post);
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"发送失败");
        }
    }

    @ApiOperation(value = "选题进度提醒",notes = "教师确认学生选题后向学生发送确认结果")
    @GetMapping("/teachSend")
    public ResponseData teachSend(String openId,String titleName,String username,String titleState){
        try {
            JSONObject body = new JSONObject();

            body.put("touser",openId);
            body.put("template_id","iLZOh4WPTrnjpacJA4WOaRPhCkRb-qyOBwt9DrP6poE");

            JSONObject json = new JSONObject();

            JSONObject thing1 = new JSONObject();
            thing1.put("value",titleName);
            json.put("thing1",thing1);

            JSONObject thing2 = new JSONObject();
            thing2.put("value",username);
            json.put("thing2",thing2);

            JSONObject thing3 = new JSONObject();
            thing3.put("value",titleState);
            json.put("thing3",thing3);

            JSONObject time4 = new JSONObject();
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = dateTime.format(formatter);
            time4.put("value", time);
            json.put("time4", time4);

            body.put("data",json);
            LOGGER.info("body:" + body.toString());

            String accessToken = getAccessToken();

            String post = cn.hutool.http.HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken, body.toString());
            LOGGER.info(("post:" + post));
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"发送失败");
        }

    }

    @ApiOperation(value = "取消选题提醒",notes = "在教师确认学生选题后，学生还想要取消选题")
    @GetMapping("/cancelTitle")
    public ResponseData cancelTitle(String openId,String usernum,String username,String titleName,String remarks){
        try {
            JSONObject body = new JSONObject(true);

            body.put("touser",openId);
            body.put("template_id","1JGJ-f9hY9PjAp94ufwjdD1fCPozS52j1Ynxx00Dgj4");

            JSONObject json = new JSONObject();

            JSONObject number1 = new JSONObject();
            number1.put("value",usernum);
            json.put("number1",number1);

            JSONObject thing2 = new JSONObject();
            thing2.put("value",username);
            json.put("thing2",thing2);

            JSONObject thing3 = new JSONObject();
            thing3.put("value",titleName);
            json.put("thing3",thing3);

            JSONObject thing4 = new JSONObject();
            thing4.put("value",remarks);
            json.put("thing4",thing4);

            JSONObject time5 = new JSONObject();
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = dateTime.format(formatter);
            time5.put("value", time);
            json.put("time5", time5);

            body.put("data",json);
            LOGGER.info("body:" + body.toString());

            String accessToken = getAccessToken();

            String post = cn.hutool.http.HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken, body.toString());
            LOGGER.info(("post:" + post));
            return ResponseData.ok();

        }catch (Exception e){

            return new ResponseData(500,"发送失败");

        }
    }

    @ApiOperation(value = "上传openID",notes = "根据用户userId上传用户唯一标识openID")
    @PostMapping("/uploadOpenId")
    public ResponseData uploadOpenId(Long userId,String openId){
        try {

            boolean value = subscribeService.uploadOpenId(userId,openId);
            if(value == false){
                return new ResponseData(500,"上传失败");
            }
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"上传失败");
        }
    }

    @ApiOperation(value = "获取openID",notes = "根据用户userId获取用户唯一标识openID")
    @GetMapping("/getOpenId")
    public ResponseData getOpenId(Long userId){
        try {
            Openid openid = subscribeService.getOpenId(userId);
            return ResponseData.ok().putDataValue(openid);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }


}
