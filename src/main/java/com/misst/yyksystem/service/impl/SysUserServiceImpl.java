package com.misst.yyksystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.misst.yyksystem.common.PageInfo;
import com.misst.yyksystem.common.ResDataDTO;
import com.misst.yyksystem.dao.SysLoginMapper;
import com.misst.yyksystem.entity.SysLogin;
import com.misst.yyksystem.entity.SysLoginCriteria;
import com.misst.yyksystem.service.SysLoginService;
import com.misst.yyksystem.service.SysUserService;
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
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysLoginMapper sysLoginDao;

	@Override
	public ResDataDTO<List<SysLogin>> selectSysUserByPage(SysLoginCriteria criteria, PageInfo pageInfo) {
		List<SysLogin> sysLoginList=null;
		if(pageInfo!=null){
			PageHelper.startPage((pageInfo.getPageNum()/pageInfo.getPageSize()+1), pageInfo.getPageSize());
			sysLoginList=sysLoginDao.selectByExample(criteria);
			PageHelper.clearPage();
			pageInfo.setTotal(sysLoginDao.countByExample(criteria));
			int pageTotal=(int)Math.ceil(pageInfo.getTotal()/(pageInfo.getPageSize()*1.0));
			pageInfo.setPageTotal(pageTotal);
		}else{
			sysLoginList=sysLoginDao.selectByExample(criteria);
		}
		ResDataDTO<List<SysLogin>> listRes=new ResDataDTO<List<SysLogin>>();
		listRes.setData(sysLoginList);
		listRes.setPageInfo(pageInfo);
		return listRes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
