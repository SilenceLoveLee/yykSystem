package com.misst.yyksystem.service.impl;

import com.misst.yyksystem.dao.BaseCodeMapper;
import com.misst.yyksystem.entity.BaseCode;
import com.misst.yyksystem.entity.BaseCodeCriteria;
import com.misst.yyksystem.service.BaseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 作者 E-mail:
* @version 创建时间：2019年4月21日 上午1:02:18
* 类说明
*/
@Service("baseCodeService")
public class BaseCodeServiceImpl implements BaseCodeService {
	@Autowired
	private BaseCodeMapper baseCodeDao;

	@Override
	public int insertBaseCode(BaseCode baseCode) {
		baseCode.setCreateTime(new Date());
		baseCode.setUpdateTime(new Date());
		return baseCodeDao.insert(baseCode);
	}

	@Override
	public int updateBaseCode(BaseCodeCriteria criteria, BaseCode baseCode) {
		baseCode.setUpdateTime(new Date());
		return baseCodeDao.updateByExampleSelective(baseCode, criteria);
	}

	@Override
	public List<BaseCode> selectInfoCode(BaseCodeCriteria criteria) {
		return baseCodeDao.selectByExample(criteria);
	} 
}
