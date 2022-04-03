package com.misst.yyksystem.dto.LoginDTO;

import com.misst.yyksystem.common.PageInfo;
import com.misst.yyksystem.entity.SysLogin;


/**
* @author 作者 E-mail:
* @version 创建时间：2019年4月13日 下午9:31:58
* 类说明
*/
public class SysUserListReqDTO  extends SysLogin {
	private PageInfo pageInfo;

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

}
