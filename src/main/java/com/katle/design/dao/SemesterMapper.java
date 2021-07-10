package com.katle.design.dao;

import com.katle.design.entities.Semester;
import com.katle.design.entities.SemesterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SemesterMapper {
    int countByExample(SemesterExample example);

    int deleteByExample(SemesterExample example);

    int deleteByPrimaryKey(Long semesterId);

    int insert(Semester record);

    int insertSelective(Semester record);

    List<Semester> selectByExample(SemesterExample example);

    Semester selectByPrimaryKey(Long semesterId);

    int updateByExampleSelective(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByExample(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);
}