package com.misst.yyksystem.dao;

import com.misst.yyksystem.entity.BaseCode;
import com.misst.yyksystem.entity.BaseCodeCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseCodeMapper {
    int countByExample(BaseCodeCriteria example);

    int deleteByExample(BaseCodeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseCode record);

    int insertSelective(BaseCode record);

    List<BaseCode> selectByExample(BaseCodeCriteria example);

    BaseCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseCode record, @Param("example") BaseCodeCriteria example);

    int updateByExample(@Param("record") BaseCode record, @Param("example") BaseCodeCriteria example);

    int updateByPrimaryKeySelective(BaseCode record);

    int updateByPrimaryKey(BaseCode record);
}