package com.katle.design.dao;

import com.katle.design.entities.MiddleFile;
import com.katle.design.entities.MiddleFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MiddleFileMapper {
    int countByExample(MiddleFileExample example);

    int deleteByExample(MiddleFileExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(MiddleFile record);

    int insertSelective(MiddleFile record);

    List<MiddleFile> selectByExample(MiddleFileExample example);

    MiddleFile selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") MiddleFile record, @Param("example") MiddleFileExample example);

    int updateByExample(@Param("record") MiddleFile record, @Param("example") MiddleFileExample example);

    int updateByPrimaryKeySelective(MiddleFile record);

    int updateByPrimaryKey(MiddleFile record);
}