package com.misst.yyksystem.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.misst.yyksystem.common.PageInfo;
import com.misst.yyksystem.common.ResDataDTO;
import com.misst.yyksystem.constant.Url;
import com.misst.yyksystem.constant.Views;
import com.misst.yyksystem.dto.LoginDTO.SysUserListReqDTO;
import com.misst.yyksystem.entity.SysLogin;
import com.misst.yyksystem.entity.SysLoginCriteria;
import com.misst.yyksystem.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 
 * @author YYK
 * @version 5.2.0
 * @since 
 * 创建时间：2019年4月13日
 * 功能描述：
 */
@Controller
@RequestMapping(Url.USER_LIST_MANAGE)
public class SysUserController {
	
	@Autowired
	@Qualifier("sysUserService")
	private SysUserService sysUserService;

	 @RequestMapping("/")
	 public String get(){
	   return Views.USER_VIEW;
	 }
	

	 @RequestMapping(value = Url.SELECT_LIST_BY_PAGE, produces = "application/json;charset=utf-8", method = RequestMethod.POST)
		public @ResponseBody String queryPages(@RequestParam(required=false,value = "aoData") String aoData) {
		 JSONArray jsonarray=(JSONArray) JSONArray.parseArray(aoData);//json格式化用的是fastjson
		 SysUserListReqDTO sysUserListReqDTO=new SysUserListReqDTO();
		 String sEcho = null;
		 PageInfo pageInfo=new PageInfo();
		 for (int i = 0; i < jsonarray.size(); i++) {
	            JSONObject obj = (JSONObject) jsonarray.get(i);
	            if (obj.get("name").equals("sEcho")){
	            	sEcho = obj.get("value").toString();
	            }
	 
	            if (obj.get("name").equals("iDisplayStart")){
	            	pageInfo.setPageNum(Integer.parseInt(obj.get("value").toString()));
	            }
	            	
	            if (obj.get("name").equals("iDisplayLength")){
	            	pageInfo.setPageSize(Integer.parseInt(obj.get("value").toString()));
	            }
	            
	            if (obj.get("name").equals("userNameSearch")){
	            	sysUserListReqDTO.setLoginName( obj.get("value").toString());
	            }
	        }
		    SysLoginCriteria criteria = new SysLoginCriteria();
		    SysLoginCriteria.Criteria cri = criteria.createCriteria();
			cri.andStatusEqualTo("1");// 只查询状态为1的
			if (StringUtils.isNotBlank(sysUserListReqDTO.getLoginName())) { // 客户姓名查询
				cri.andLoginNameLike("%" + sysUserListReqDTO.getLoginName() + "%");
			}
			if(pageInfo!=null)
			{
				if(pageInfo.getPageNum()==null || pageInfo.getPageSize()==null || pageInfo.getPageNum()<1 ||pageInfo.getPageSize()<1){
					
				}
			}
			ResDataDTO<List<SysLogin>> list=sysUserService.selectSysUserByPage(criteria, pageInfo);
			PageInfo page=list.getPageInfo();
			JSONObject getObj = new JSONObject();
		    getObj.put("sEcho", sEcho);// DataTable前台必须要的
		    getObj.put("iTotalRecords",list.getData().size()); //返回总记录数
		    getObj.put("iTotalDisplayRecords",page.getTotal()); //过滤后的记录数
		    getObj.put("aaData", list.getData());//把查到数据装入aaData,要以JSON格式返回
		    return getObj.toString();
		}
	 
		 

	 
	 
	 
	 
	 
	 
	 
	 
}
