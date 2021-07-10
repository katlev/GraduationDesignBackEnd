package com.katle.design.dao;

import com.katle.design.entities.PlanFile;
import com.katle.design.entities.PlanFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanFileMapper {
    int countByExample(PlanFileExample example);

    int deleteByExample(PlanFileExample example);

    int deleteByPrimaryKey(Long planId);

    int insert(PlanFile record);

    int insertSelective(PlanFile record);

    List<PlanFile> selectByExample(PlanFileExample example);

    PlanFile selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") PlanFile record, @Param("example") PlanFileExample example);

    int updateByExample(@Param("record") PlanFile record, @Param("example") PlanFileExample example);

    int updateByPrimaryKeySelective(PlanFile record);

    int updateByPrimaryKey(PlanFile record);
}