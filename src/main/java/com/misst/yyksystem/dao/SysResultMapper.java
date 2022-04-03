package com.misst.yyksystem.dao;

import com.misst.yyksystem.entity.SysResult;
import com.misst.yyksystem.entity.SysResultCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResultMapper {
    int countByExample(SysResultCriteria example);

    int deleteByExample(SysResultCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysResult record);

    int insertSelective(SysResult record);

    List<SysResult> selectByExample(SysResultCriteria example);

    SysResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysResult record, @Param("example") SysResultCriteria example);

    int updateByExample(@Param("record") SysResult record, @Param("example") SysResultCriteria example);

    int updateByPrimaryKeySelective(SysResult record);

    int updateByPrimaryKey(SysResult record);
}