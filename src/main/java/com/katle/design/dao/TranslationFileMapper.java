package com.katle.design.dao;

import com.katle.design.entities.TranslationFile;
import com.katle.design.entities.TranslationFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TranslationFileMapper {
    int countByExample(TranslationFileExample example);

    int deleteByExample(TranslationFileExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(TranslationFile record);

    int insertSelective(TranslationFile record);

    List<TranslationFile> selectByExample(TranslationFileExample example);

    TranslationFile selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TranslationFile record, @Param("example") TranslationFileExample example);

    int updateByExample(@Param("record") TranslationFile record, @Param("example") TranslationFileExample example);

    int updateByPrimaryKeySelective(TranslationFile record);

    int updateByPrimaryKey(TranslationFile record);
}