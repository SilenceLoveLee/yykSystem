package com.misst.yyksystem.dto.LoginDTO;


import com.misst.yyksystem.entity.SysLogin;

/**
* @author 作者 E-mail:
* @version 创建时间：2019年5月25日 下午12:35:44
* 类说明
*/
public class LoginResDTO extends SysLogin {
	private String sexName;

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
}
