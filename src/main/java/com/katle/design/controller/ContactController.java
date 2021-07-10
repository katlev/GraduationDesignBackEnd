package com.katle.design.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.annotations.GwtCompatible;
import com.katle.design.entities.LeaveMessage;
import com.katle.design.service.ContactService;
import com.katle.design.utils.ResponseData;
import com.katle.design.vo.MessageListVO;
import com.katle.design.vo.StuListVO;
import com.katle.design.vo.TableVO;
import com.katle.design.vo.TeachListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(value = "联系教师模块",tags = "联系教师模块")
@RestController
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;

    @ApiOperation(value = "联系教师列表",notes = "获取当前学年联系教师列表")
    @GetMapping("/getContactList")
    @RequiresRoles("student")
    public TableVO getContactList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit",defaultValue = "10")Integer limit, String schoolYear){
        Map<String,Object> map = contactService.contactTeachList(page,limit,schoolYear);
        PageInfo pageInfoContact = (PageInfo) map.get("pageInfoContact");
        List<TeachListVO> contactList = (List<TeachListVO>) map.get("contactList");
        return new TableVO(pageInfoContact,contactList);
    }

    @ApiOperation(value = "联系教师查询",notes = "根据关键词查询联系教师")
    @GetMapping("/searchContactList")
    @RequiresRoles("student")
    public ResponseData getContactSearchList(String schoolYear,String searchValue){
        try {
            List<TeachListVO> list = contactService.searchContactList(schoolYear,searchValue);
            return ResponseData.ok().putDataValue(list);
        }catch (Exception e){
            return new ResponseData(500,"搜索失败");
        }
    }

    @ApiOperation(value = "学生给教师留言",notes = "根据学生id和教师id,学生给教师发送留言信息")
    @PostMapping("/sendMessageToTeach")
    @RequiresRoles("student")
    public ResponseData sendMessageToTeach(Long stuId,String stuMessage,Long teachId){
        try {
            contactService.sendMessageToTeach(stuId,stuMessage,teachId);
            return ResponseData.ok();

        }catch (Exception e){
            return new ResponseData(500,"留言失败");
        }
    }

    @ApiOperation(value = "学生留言记录获取",notes = "根据学生id和教师id获取学生发送给指定教师的留言记录")
    @GetMapping("/getStuMessage")
    public ResponseData getStuMessage(Long stuId,Long teachId){
        try {
            List<MessageListVO> leaveMessages = contactService.getStuMessageList(stuId,teachId);
            return ResponseData.ok().putDataValue(leaveMessages);
        }catch (Exception e){
            return new ResponseData(500,"获取失败");
        }
    }

    @ApiOperation(value = "收到留言列表",notes = "根据教师id获取收到的留言消息列表")
    @GetMapping("/getReceiveStuList")
    @RequiresRoles("teacher")
    public TableVO getReceiveStuList(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "10")Integer limit,Long teachId){
        Map<String, Object> map = contactService.getMyMessageList(page,limit,teachId);
        PageInfo pageInfoLeave = (PageInfo) map.get("pageInfoLeave");
        List<StuListVO> receiveList = (List<StuListVO>) map.get("receiveList");
        return new TableVO(pageInfoLeave,receiveList);
    }

    @ApiOperation(value = "教师回复学生留言",notes = "根据留言id教师回复学生相应留言信息")
    @PostMapping("/sendMessageToStu")
    @RequiresRoles("teacher")
    public ResponseData sendMessageToStudent(Long messageId,String teachMessage){
        try {
            contactService.sendMessageToStudent(messageId,teachMessage);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"发送失败");
        }
    }

    @ApiOperation(value = "教师删除留言",notes = "根据学生userId教师删除学生发送给自己的留言记录")
    @GetMapping("/deleteContact")
    @RequiresRoles("teacher")
    public ResponseData deleteContactItem(Long stuId){
        try {
            contactService.deleteContactItem(stuId);
            return ResponseData.ok();
        }catch (Exception e){
            return new ResponseData(500,"删除失败");
        }
    }


}
