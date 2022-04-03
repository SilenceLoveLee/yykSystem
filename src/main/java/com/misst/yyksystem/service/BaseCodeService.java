package com.misst.yyksystem.service;


import com.misst.yyksystem.entity.BaseCode;
import com.misst.yyksystem.entity.BaseCodeCriteria;

import java.util.List;

/**
* @author 作者 E-mail:
* @version 创建时间：2019年4月21日 上午1:01:47
* 类说明
*/
public interface BaseCodeService {

	int insertBaseCode(BaseCode baseCode);

	int updateBaseCode(BaseCodeCriteria criteria, BaseCode baseCode);
	
	List<BaseCode> selectInfoCode(BaseCodeCriteria criteria);
}
