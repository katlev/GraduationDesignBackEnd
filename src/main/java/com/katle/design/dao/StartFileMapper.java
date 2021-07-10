package com.katle.design.dao;

import com.katle.design.entities.StartFile;
import com.katle.design.entities.StartFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StartFileMapper {
    int countByExample(StartFileExample example);

    int deleteByExample(StartFileExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(StartFile record);

    int insertSelective(StartFile record);

    List<StartFile> selectByExample(StartFileExample example);

    StartFile selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") StartFile record, @Param("example") StartFileExample example);

    int updateByExample(@Param("record") StartFile record, @Param("example") StartFileExample example);

    int updateByPrimaryKeySelective(StartFile record);

    int updateByPrimaryKey(StartFile record);
}