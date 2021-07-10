package com.katle.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dao.LeaveMessageMapper;
import com.katle.design.dao.RoleMapper;
import com.katle.design.dao.UserMapper;
import com.katle.design.entities.*;
import com.katle.design.service.ContactService;
import com.katle.design.vo.MessageListVO;
import com.katle.design.vo.StuListVO;
import com.katle.design.vo.TeachListVO;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Service
public class ContactServiceImpl implements ContactService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private LeaveMessageMapper leaveMessageMapper;

    /**
     * 获取当前学年可联系教师列表
     * @param schoolYear
     * @return
     */
    @Override
    public Map<String, Object> contactTeachList(int page,int limit,String schoolYear) {
        String teacher = "teacher";
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleLike("%" + teacher + "%");
        PageHelper.startPage(page,limit);
        List<Role> roleList = roleMapper.selectByExample(roleExample);

        List<TeachListVO> contactList = new ArrayList<>();

        for(Role item: roleList){
            User user = userMapper.selectByPrimaryKey(item.getUserId());

            if(user.getSchoolYear().equals(schoolYear)){
                TeachListVO list = new TeachListVO();
                list.setUserId(user.getUserId());
                list.setUsernum(user.getUsernum());
                list.setUsername(user.getUsername());
                list.setCollege(user.getCollege());
                list.setPosition(user.getPosition());
                list.setAvatar(user.getAvatar());

                contactList.add(list);
            }
        }
        PageInfo pageInfoContact = new PageInfo(roleList);
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfoContact",pageInfoContact);
        map.put("contactList",contactList);
        return map;
    }

    /**
     * 根据关键词收缩可联系教师列表
     * @param schoolYear
     * @param searchValue
     * @return
     */
    @Override
    public List<TeachListVO> searchContactList(String schoolYear, String searchValue) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSchoolYearEqualTo(schoolYear);
        criteria.andUsernameLike("%"+ searchValue+"%");
        List<User> userList = userMapper.selectByExample(userExample);
        List<TeachListVO> contactSearchList = new ArrayList<>();

        for(User item: userList){
            Role role = roleMapper.selectByPrimaryKey(item.getUserId());
            String identity = role.getRole();
            String[] roleArr = identity.split(",");
            String teach = roleArr[0];
            if(teach.equals("teacher")){
                TeachListVO list = new TeachListVO();
                list.setUserId(item.getUserId());
                list.setUsernum(item.getUsernum());
                list.setUsername(item.getUsername());
                list.setCollege(item.getCollege());
                list.setPosition(item.getPosition());
                list.setAvatar(item.getAvatar());

                contactSearchList.add(list);
            }
        }
        return contactSearchList;
    }

    /**
     * 学生给教师留言
     * @param stuId
     * @param stuMessage
     * @param teachId
     * @return
     */
    @Override
    public boolean sendMessageToTeach(Long stuId, String stuMessage, Long teachId) {
        Date date = new Date();
        LeaveMessage message = new LeaveMessage();
        message.setStuId(stuId);
        message.setStuMessage(stuMessage);
        message.setStuDate(date);
        message.setStuTime(date);
        message.setTeachId(teachId);
        return leaveMessageMapper.insertSelective(message)>0;
    }

    /**
     * 根据学生id和教师id获取学生发送给指定教师的留言记录
     * @param stuId
     * @param teachId
     * @return
     */
    @Override
    public List<MessageListVO> getStuMessageList(Long stuId, Long teachId) {
        LeaveMessageExample leaveMessageExample = new LeaveMessageExample();
        LeaveMessageExample.Criteria criteria = leaveMessageExample.createCriteria();
        criteria.andStuIdEqualTo(stuId);
        criteria.andTeachIdEqualTo(teachId);
        List<LeaveMessage> leaveMessageList = leaveMessageMapper.selectByExample(leaveMessageExample);
        List<MessageListVO> messageListVo = new ArrayList<>();

        for(LeaveMessage item: leaveMessageList){
            MessageListVO list = new MessageListVO();
            list.setMessageId(item.getMessageId());
            list.setStuId(item.getStuId());
            list.setStuMessage(item.getStuMessage());
            list.setStuDate(item.getStuDate());
            list.setStuTime(item.getStuTime());
            list.setTeachId(item.getTeachId());
            list.setTeachMessage(item.getTeachMessage());
            list.setTeachDate(item.getTeachDate());
            list.setTeachTime(item.getTeachTime());

            messageListVo.add(list);
        }
        return messageListVo;
    }

    /**
     * 根据相应教师id获取发送给相应教师的学生留言列表
     * @param teachId
     * @return
     */
    @Override
    public Map<String,Object> getMyMessageList(int page,int limit,Long teachId) {
        LeaveMessageExample leaveMessageExample = new LeaveMessageExample();
        LeaveMessageExample.Criteria criteria = leaveMessageExample.createCriteria();
        criteria.andTeachIdEqualTo(teachId);
        PageHelper.startPage(page,limit);
        List<LeaveMessage> leaveMessages = leaveMessageMapper.selectByExample(leaveMessageExample);
        List<StuListVO> receiveList = new ArrayList<>();

        List<Long> idArr = new ArrayList<>();

        /*列表根据属性去重*/
        List<LeaveMessage> newList = leaveMessages.stream().filter( v -> {
            boolean flag = !idArr.contains(v.getStuId());
            idArr.add(v.getStuId());
            return flag;
        }).collect(Collectors.toList());

       for(LeaveMessage item : newList){
           StuListVO list = new StuListVO();

           User stu = userMapper.selectByPrimaryKey(item.getStuId());

           list.setUserId(stu.getUserId());
           list.setUsernum(stu.getUsernum());
           list.setUsername(stu.getUsername());
           list.setMajor(stu.getMajor());
           list.setAvatar(stu.getAvatar());

           receiveList.add(list);
       }
       PageInfo pageInfoLeave = new PageInfo<>(leaveMessages);
       Map<String,Object> map = new HashMap<>();
       map.put("pageInfoLeave",pageInfoLeave);
       map.put("receiveList",receiveList);
       return map;
    }

    /**
     * 教师给学生回复留言
     * @param messageId
     * @return
     */
    @Override
    public boolean sendMessageToStudent(Long messageId, String teachMessage) {
        Date date = new Date();

        LeaveMessage leaveMessage = leaveMessageMapper.selectByPrimaryKey(messageId);
        leaveMessage.setTeachMessage(teachMessage);
        leaveMessage.setTeachDate(date);
        leaveMessage.setTeachTime(date);
        return leaveMessageMapper.updateByPrimaryKeySelective(leaveMessage)>0;
    }

    /**
     * 根据学生userId删除学生发送给教师的留言记录
     * @param stuId
     * @return
     */
    @Override
    public boolean deleteContactItem(Long stuId) {
        LeaveMessageExample leaveMessageExample = new LeaveMessageExample();
        LeaveMessageExample.Criteria criteria = leaveMessageExample.createCriteria();
        criteria.andStuIdEqualTo(stuId);

        return leaveMessageMapper.deleteByExample(leaveMessageExample)>0;
    }
}
