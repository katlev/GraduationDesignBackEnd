package com.katle.design.dao;

import com.katle.design.entities.Openid;
import com.katle.design.entities.OpenidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenidMapper {
    int countByExample(OpenidExample example);

    int deleteByExample(OpenidExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(Openid record);

    int insertSelective(Openid record);

    List<Openid> selectByExample(OpenidExample example);

    Openid selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") Openid record, @Param("example") OpenidExample example);

    int updateByExample(@Param("record") Openid record, @Param("example") OpenidExample example);

    int updateByPrimaryKeySelective(Openid record);

    int updateByPrimaryKey(Openid record);
}