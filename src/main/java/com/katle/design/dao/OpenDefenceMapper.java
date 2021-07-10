package com.katle.design.dao;

import com.katle.design.entities.OpenDefence;
import com.katle.design.entities.OpenDefenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenDefenceMapper {
    int countByExample(OpenDefenceExample example);

    int deleteByExample(OpenDefenceExample example);

    int deleteByPrimaryKey(Long openId);

    int insert(OpenDefence record);

    int insertSelective(OpenDefence record);

    List<OpenDefence> selectByExample(OpenDefenceExample example);

    OpenDefence selectByPrimaryKey(Long openId);

    int updateByExampleSelective(@Param("record") OpenDefence record, @Param("example") OpenDefenceExample example);

    int updateByExample(@Param("record") OpenDefence record, @Param("example") OpenDefenceExample example);

    int updateByPrimaryKeySelective(OpenDefence record);

    int updateByPrimaryKey(OpenDefence record);
}