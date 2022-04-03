package com.misst.yyksystem.service.impl;

import com.misst.yyksystem.dao.SysLoginMapper;
import com.misst.yyksystem.dto.LoginDTO.LoginResDTO;
import com.misst.yyksystem.entity.SysLogin;
import com.misst.yyksystem.entity.SysLoginCriteria;
import com.misst.yyksystem.service.SysLoginService;
import com.misst.yyksystem.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 作者 E-mail:
* @version 创建时间：2019年4月13日 下午9:03:38
* 类说明
*/
@Service("sysLoginService")
public class SysLoginServiceImpl implements SysLoginService {
	
	@Autowired
	private SysLoginMapper sysLoginDao;


	@Override
	public int insertLogin(SysLogin sysLogin) {
		sysLogin.setStatus("1");
		sysLogin.setLoginId(UUIDGenerator.create32Key());
		sysLogin.setCreateTime(new Date());
		sysLogin.setUpdateTime(new Date());
		return sysLoginDao.insertSelective(sysLogin);
	}

	@Override
	public int updateLogin(SysLoginCriteria criteria, SysLogin sysLogin) {
		return sysLoginDao.updateByExampleSelective(sysLogin,criteria);
	}

	@Override
	public List<SysLogin> selectInfoLogin(SysLoginCriteria criteria) {
		return sysLoginDao.selectByExample(criteria);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
