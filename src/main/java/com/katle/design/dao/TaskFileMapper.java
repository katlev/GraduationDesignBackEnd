package com.katle.design.dao;

import com.katle.design.entities.TaskFile;
import com.katle.design.entities.TaskFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskFileMapper {
    int countByExample(TaskFileExample example);

    int deleteByExample(TaskFileExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(TaskFile record);

    int insertSelective(TaskFile record);

    List<TaskFile> selectByExample(TaskFileExample example);

    TaskFile selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TaskFile record, @Param("example") TaskFileExample example);

    int updateByExample(@Param("record") TaskFile record, @Param("example") TaskFileExample example);

    int updateByPrimaryKeySelective(TaskFile record);

    int updateByPrimaryKey(TaskFile record);
}