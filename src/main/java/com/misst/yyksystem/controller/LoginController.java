package com.misst.yyksystem.controller;


import com.misst.yyksystem.constant.Url;
import com.misst.yyksystem.constant.Views;
import com.misst.yyksystem.dto.LoginDTO.LoginReqDTO;
import com.misst.yyksystem.dto.LoginDTO.LoginResDTO;
import com.misst.yyksystem.entity.BaseCode;
import com.misst.yyksystem.entity.BaseCodeCriteria;
import com.misst.yyksystem.entity.SysLogin;
import com.misst.yyksystem.entity.SysLoginCriteria;
import com.misst.yyksystem.service.BaseCodeService;
import com.misst.yyksystem.service.SysLoginService;
import com.misst.yyksystem.util.JsonChangeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(Url.LOGIN_MANAGE)
public class LoginController {

	@Autowired
	@Qualifier("baseCodeService")
	private BaseCodeService baseCodeService;

	@Autowired
	@Qualifier("sysLoginService")
	private SysLoginService sysLoginService;

	@RequestMapping(Url.BACK_LOGIN_URL)
	public String loginPage(final ModelMap model) {
		List<BaseCode> roleIdList = selectCode("ROLEID");
		model.put("roleIdList", JsonChangeUtil.list2json(roleIdList));
		return Views.USER_LOGIN_VIEW;
	}

	@RequestMapping(value = Url.WELCOME_URL)
    public String welcome(){
        return  Views.WELCOME_VIEW;
    }

	public List<BaseCode> selectCode(String codeType){
		BaseCodeCriteria criteria = new BaseCodeCriteria();
		BaseCodeCriteria.Criteria cri = criteria.createCriteria();
		cri.andCodeTypeEqualTo(codeType);
		List<BaseCode> topicTypeList = this.baseCodeService.selectInfoCode(criteria);
	    return topicTypeList;
     }
	
	
	 @RequestMapping(value = Url.LOGIN_URL)
	    public @ResponseBody
     Map<String, Object> login(LoginReqDTO  loginReqDTO, HttpServletRequest request, HttpSession session){
		    Map<String, Object> map = new HashMap<String, Object>();
	        String flag;
	        if(StringUtils.isNotBlank(loginReqDTO.getVerificationCode())){
	        	Object key = session.getAttribute("key");
	        	//验证码一致
	        	if(key.equals(loginReqDTO.getVerificationCode())){
	        		SysLoginCriteria criteria=new SysLoginCriteria();
	      	        SysLoginCriteria.Criteria cri=criteria.createCriteria();
	      	        if(StringUtils.isNotBlank(loginReqDTO.getLoginName())&&StringUtils.isNotBlank(loginReqDTO.getLoginPassword())) {
	      	            cri.andLoginNameEqualTo(loginReqDTO.getLoginName());
	      	            cri.andLoginPasswordEqualTo(loginReqDTO.getLoginPassword());
	      	        }
	      	        List<SysLogin> sysLoginList = sysLoginService.selectInfoLogin(criteria);
	      	        if(sysLoginList.size()==1){
						flag="true";
						map.put("result", flag);
						session=request.getSession();
						session.setAttribute("sysLogin",sysLoginList.get(0));
						session.setAttribute("loginName", sysLoginList.get(0).getLoginName());
	      	        }
	      	        else{
	      	        	flag="false";
	      	        	map.put("result", flag);
	      	        }
	      	        
	        	}
	        	else{
	        		flag="repeat";
      	        	map.put("result", flag);
	        	}
	        }
	      
	        return map;
	    }
	
	
	 
	 @RequestMapping(value = Url.REGIS_URL)
	    public @ResponseBody
     Map<String, Object> regis(SysLogin sysLogin, HttpServletRequest request){
		    Map<String, Object> map = new HashMap<String, Object>();
	        String flag;
	        SysLoginCriteria criteria=new SysLoginCriteria();
	        SysLoginCriteria.Criteria cri=criteria.createCriteria();
	        if(StringUtils.isNotBlank(sysLogin.getLoginName())) {
	            cri.andLoginNameEqualTo(sysLogin.getLoginName());
	        }
	        List<SysLogin> list=sysLoginService.selectInfoLogin(criteria);
	        if(list==null || list.isEmpty()){
	        	int i= sysLoginService.insertLogin(sysLogin);
	 	        if(i==1){
	 	            flag="true";
	 	            map.put("result", flag);
	 	        }else{
	 	        	flag="false";
	 	            map.put("result", flag);
	 	        }
	 	        
	        }
	        else{
 	        	flag="repeat";
 	            map.put("result", flag);
 	        }
	        return map;
	    }
	 
	 
	 
	 @RequestMapping(value = Url.UPDATE_USER_PSW)
	    public @ResponseBody
     Map<String, Object> updatePassword(LoginReqDTO loginReqDTO, HttpServletRequest request){
		    Map<String, Object> map = new HashMap<String, Object>();
		    String flag;
		    SysLoginCriteria criteria=new SysLoginCriteria();
	        SysLoginCriteria.Criteria cri=criteria.createCriteria();
	        if(StringUtils.isNotBlank(loginReqDTO.getLoginName())) {
	            cri.andLoginNameEqualTo(loginReqDTO.getLoginName());
	        }
	        if(StringUtils.isNotBlank(loginReqDTO.getOldPassword())) {
	            cri.andLoginPasswordEqualTo(loginReqDTO.getOldPassword());
	        }
	        List<SysLogin> list=sysLoginService.selectInfoLogin(criteria);
	        if(list.size()>0 || !list.isEmpty()){
	        	int i= sysLoginService.updateLogin(criteria, loginReqDTO);
	 	        if(i==1){
	 	            flag="true";
	 	            map.put("result", flag);
	 	        }else{
	 	        	flag="false";
	 	            map.put("result", flag);
	 	        }
	        }
	        else{
 	        	flag="repeat";
 	            map.put("result", flag);
 	        }
	        return map;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
