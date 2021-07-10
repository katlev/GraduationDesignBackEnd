package com.katle.design.dao;

import com.katle.design.entities.ThesisFile;
import com.katle.design.entities.ThesisFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThesisFileMapper {
    int countByExample(ThesisFileExample example);

    int deleteByExample(ThesisFileExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ThesisFile record);

    int insertSelective(ThesisFile record);

    List<ThesisFile> selectByExample(ThesisFileExample example);

    ThesisFile selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") ThesisFile record, @Param("example") ThesisFileExample example);

    int updateByExample(@Param("record") ThesisFile record, @Param("example") ThesisFileExample example);

    int updateByPrimaryKeySelective(ThesisFile record);

    int updateByPrimaryKey(ThesisFile record);
}