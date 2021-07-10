package com.katle.design.dao;

import com.katle.design.entities.Defence;
import com.katle.design.entities.DefenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefenceMapper {
    int countByExample(DefenceExample example);

    int deleteByExample(DefenceExample example);

    int deleteByPrimaryKey(Long defenceId);

    int insert(Defence record);

    int insertSelective(Defence record);

    List<Defence> selectByExample(DefenceExample example);

    Defence selectByPrimaryKey(Long defenceId);

    int updateByExampleSelective(@Param("record") Defence record, @Param("example") DefenceExample example);

    int updateByExample(@Param("record") Defence record, @Param("example") DefenceExample example);

    int updateByPrimaryKeySelective(Defence record);

    int updateByPrimaryKey(Defence record);
}