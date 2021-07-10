package com.katle.design.dao;

import com.katle.design.entities.LiteratureFile;
import com.katle.design.entities.LiteratureFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LiteratureFileMapper {
    int countByExample(LiteratureFileExample example);

    int deleteByExample(LiteratureFileExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(LiteratureFile record);

    int insertSelective(LiteratureFile record);

    List<LiteratureFile> selectByExample(LiteratureFileExample example);

    LiteratureFile selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") LiteratureFile record, @Param("example") LiteratureFileExample example);

    int updateByExample(@Param("record") LiteratureFile record, @Param("example") LiteratureFileExample example);

    int updateByPrimaryKeySelective(LiteratureFile record);

    int updateByPrimaryKey(LiteratureFile record);
}