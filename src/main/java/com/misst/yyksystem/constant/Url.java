package com.misst.yyksystem.constant;

public interface Url {
	 /*============通用url开始===========*/
    /*列表数据查询所有*/
    String SELECT_LIST_ALL = "/selectListAll";
    /*列表数据分页查询*/
    String SELECT_LIST_BY_PAGE = "/selectListByPage";
    /*左侧列表数查询*/
    String SELECT_LEFT_TREE = "/selectLeftTree";

    /*信息查询*/
    String SELECT_INFO = "/selectInfo";
    /*插入数据或修改数据*/
    String INSERT_OR_UPDATE_INFO = "/insertOrUpdateInfo";
    /*插入数据*/
    String INSERT_INFO = "/insertInfo";
    /*更新数据*/
    String UPDATE_INFO = "/updateInfo";
    /*删除信息*/
    String DELETE_INFO = "/deleteInfo";
    /*批量删除*/
    String DELETE_LIST = "/deleteList";
    
    
   
    /*登录注册*/
	String LOGIN_MANAGE = "/loginManage";
	/*登录请求地址*/
	String BACK_LOGIN_URL = "/login/user";
	/*注册*/
	String REGIS_URL = "/regisUrl";
	/*登录*/
	String LOGIN_URL = "/loginUrl";
	 /*初始化页面*/
   	String WELCOME_URL = "/welcomeUrl";
   	/*用户修改密码*/
    String UPDATE_USER_PSW="/updateUserPsw";
    /*用户信息*/
    String USER_LIST_MANAGE="/userListManage";
    /*检测面板*/
    String CHECK_PANEL_MANAGE="/checkPanelManage";
    /*结果分析*/
    String CHECK_RESULT_MANAGE="/checkResultManage";


    
    
    
    
    
    
    
    
    
    
}
