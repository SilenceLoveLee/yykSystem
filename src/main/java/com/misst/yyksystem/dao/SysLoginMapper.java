package com.misst.yyksystem.dao;

import com.misst.yyksystem.entity.SysLogin;
import com.misst.yyksystem.entity.SysLoginCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SysLoginMapper {
    int countByExample(SysLoginCriteria example);

    int deleteByExample(SysLoginCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLogin record);

    int insertSelective(SysLogin record);

    List<SysLogin> selectByExample(SysLoginCriteria example);

    SysLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLogin record, @Param("example") SysLoginCriteria example);

    int updateByExample(@Param("record") SysLogin record, @Param("example") SysLoginCriteria example);

    int updateByPrimaryKeySelective(SysLogin record);

    int updateByPrimaryKey(SysLogin record);
}