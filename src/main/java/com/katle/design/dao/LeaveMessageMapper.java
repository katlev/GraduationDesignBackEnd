package com.katle.design.dao;

import com.katle.design.entities.LeaveMessage;
import com.katle.design.entities.LeaveMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaveMessageMapper {
    int countByExample(LeaveMessageExample example);

    int deleteByExample(LeaveMessageExample example);

    int deleteByPrimaryKey(Long messageId);

    int insert(LeaveMessage record);

    int insertSelective(LeaveMessage record);

    List<LeaveMessage> selectByExample(LeaveMessageExample example);

    LeaveMessage selectByPrimaryKey(Long messageId);

    int updateByExampleSelective(@Param("record") LeaveMessage record, @Param("example") LeaveMessageExample example);

    int updateByExample(@Param("record") LeaveMessage record, @Param("example") LeaveMessageExample example);

    int updateByPrimaryKeySelective(LeaveMessage record);

    int updateByPrimaryKey(LeaveMessage record);
}