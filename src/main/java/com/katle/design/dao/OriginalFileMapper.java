package com.katle.design.dao;

import com.katle.design.entities.OriginalFile;
import com.katle.design.entities.OriginalFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OriginalFileMapper {
    int countByExample(OriginalFileExample example);

    int deleteByExample(OriginalFileExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(OriginalFile record);

    int insertSelective(OriginalFile record);

    List<OriginalFile> selectByExample(OriginalFileExample example);

    OriginalFile selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") OriginalFile record, @Param("example") OriginalFileExample example);

    int updateByExample(@Param("record") OriginalFile record, @Param("example") OriginalFileExample example);

    int updateByPrimaryKeySelective(OriginalFile record);

    int updateByPrimaryKey(OriginalFile record);
}