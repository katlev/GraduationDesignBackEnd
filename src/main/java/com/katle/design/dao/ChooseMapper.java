package com.katle.design.dao;

import com.katle.design.entities.Choose;
import com.katle.design.entities.ChooseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChooseMapper {
    int countByExample(ChooseExample example);

    int deleteByExample(ChooseExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(Choose record);

    int insertSelective(Choose record);

    List<Choose> selectByExample(ChooseExample example);

    Choose selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") Choose record, @Param("example") ChooseExample example);

    int updateByExample(@Param("record") Choose record, @Param("example") ChooseExample example);

    int updateByPrimaryKeySelective(Choose record);

    int updateByPrimaryKey(Choose record);
}