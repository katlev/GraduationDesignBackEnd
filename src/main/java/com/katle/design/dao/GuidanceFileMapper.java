package com.katle.design.dao;

import com.katle.design.entities.GuidanceFile;
import com.katle.design.entities.GuidanceFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuidanceFileMapper {
    int countByExample(GuidanceFileExample example);

    int deleteByExample(GuidanceFileExample example);

    int deleteByPrimaryKey(Long guidanceId);

    int insert(GuidanceFile record);

    int insertSelective(GuidanceFile record);

    List<GuidanceFile> selectByExample(GuidanceFileExample example);

    GuidanceFile selectByPrimaryKey(Long guidanceId);

    int updateByExampleSelective(@Param("record") GuidanceFile record, @Param("example") GuidanceFileExample example);

    int updateByExample(@Param("record") GuidanceFile record, @Param("example") GuidanceFileExample example);

    int updateByPrimaryKeySelective(GuidanceFile record);

    int updateByPrimaryKey(GuidanceFile record);
}