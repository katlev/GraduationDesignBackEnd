package com.katle.design.service;

import com.katle.design.entities.LeaveMessage;
import com.katle.design.entities.User;
import com.katle.design.vo.MessageListVO;
import com.katle.design.vo.StuListVO;
import com.katle.design.vo.TeachListVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ContactService {

    /**
     * 获取当前学年的教师列表
     * @param schoolYear
     * @return
     */
    Map<String,Object> contactTeachList(int page, int limit, String schoolYear);

    /**
     * 根据关键词搜索可联系教师列表
     * @param schoolYear
     * @param searchValue
     * @return
     */
    List<TeachListVO> searchContactList(String schoolYear,String searchValue);

    /**
     * 学生给教师留言
     * @param stuId
     * @param stuMessage
     * @param teachId
     * @return
     */
    boolean sendMessageToTeach(Long stuId, String stuMessage,Long teachId);

    /**
     * 根据学生id和教师id获取学生发给指定教师的留言记录
     * @param stuId
     * @param teachId
     * @return
     */
    List<MessageListVO> getStuMessageList(Long stuId, Long teachId);

    /**
     * 根据教师id获取发送给相应教师的留言学生列表
     * @param teachId
     * @return
     */
    Map<String,Object> getMyMessageList(int page,int limit,Long teachId);

    /**
     * 教师给学生回复
     * @param messageId
     * @return
     */
    boolean sendMessageToStudent(Long messageId,String teachMessage);

    /**
     * 根据学生userId删除学生发送的教师的留言记录
     * @param stuId
     * @return
     */
    boolean deleteContactItem(Long stuId);


}
