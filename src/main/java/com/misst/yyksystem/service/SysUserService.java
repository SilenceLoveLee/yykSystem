package com.misst.yyksystem.service;


import com.misst.yyksystem.common.PageInfo;
import com.misst.yyksystem.common.ResDataDTO;
import com.misst.yyksystem.entity.SysLogin;
import com.misst.yyksystem.entity.SysLoginCriteria;

import java.util.List;

/**
* @author 作者 E-mail:
* @version 创建时间：2019年4月13日 下午9:02:59
* 类说明
*/
public interface SysUserService {
	 ResDataDTO<List<SysLogin>> selectSysUserByPage(SysLoginCriteria criteria, PageInfo pageInfo);
}
