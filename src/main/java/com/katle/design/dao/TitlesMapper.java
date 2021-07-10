package com.katle.design.dao;

import com.katle.design.entities.Titles;
import com.katle.design.entities.TitlesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitlesMapper {
    int countByExample(TitlesExample example);

    int deleteByExample(TitlesExample example);

    int deleteByPrimaryKey(Long titleId);

    int insert(Titles record);

    int insertSelective(Titles record);

    List<Titles> selectByExample(TitlesExample example);

    Titles selectByPrimaryKey(Long titleId);

    int updateByExampleSelective(@Param("record") Titles record, @Param("example") TitlesExample example);

    int updateByExample(@Param("record") Titles record, @Param("example") TitlesExample example);

    int updateByPrimaryKeySelective(Titles record);

    int updateByPrimaryKey(Titles record);
}