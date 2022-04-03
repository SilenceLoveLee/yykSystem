<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.misst.yyksystem.entity.SysLogin" %>
<%@ page import="com.misst.yyksystem.entity.SysLogin" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	SysLogin sysLogin=(SysLogin)request.getSession().getAttribute("sysLogin");
%>
<html>
    <head>
		<base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="<%=basePath%>static/assets/js/jquery-1.11.1.min.js"></script>
        <script src="<%=basePath%>static/bootstrap/js/bootstrap.min.js"></script>
         <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=basePath%>static/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=basePath%>static/css/menu.css?ver=1">
        <style>
        .nav{
         margin-top: 20px; 
        }
        .sub>li{
        padding-top: 4px;
        }
        .nav>li{
        border-bottom: 1px solid #414040;
        padding-top: 20px;
       
        }
       /*  .nav>li>span>{
        padding-top: 13px;
        } */
        li>span>{
        padding-top: 13px;
        }
       .nav>li>.right{
           padding-top: 22px;
       
       }
       
        </style>
 </head>
    <body>
	<input type="hidden" id="userList" value="<%=basePath%>userListManage/" />
	<input type="hidden" id="checkPanel" value="<%=basePath%>checkPanelManage/" />
	<input type="hidden" id="checkResult" value="<%=basePath%>checkResultManage/" />


    	<ul class="nav" >
    		<li id="system"><i class="fa fa-gear fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统管理<span class="right glyphicon glyphicon-chevron-right"></span>
    			<ul class="sub">
    				<li class="checkPanel">检测面板</li>
    				<li class="checkResult">结果检测</li>
    			</ul>
    		</li>
    		<li id="user"><i class="fa fa-users fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员工管理<span class="right glyphicon glyphicon-chevron-right"></span>
    			<ul class="sub">
    				<li class="userList">员工信息</li>
    			</ul>
    		</li>
    		
    	</ul>
	<%--用于提交数据的表单--%>
	<form id="menuForm" method="post" action="">
		<input type="hidden">
	</form>
 	</body>
	<script>
	
	
	
        $(function() {
            //监听一级菜单点击事件
            $(".nav>li").click(function() {
                //找到二级菜单，让二级菜单展开
                $(this).children(".sub").slideToggle(500);
                //控制下拉箭头
                $(this).children(".right").toggleClass("glyphicon glyphicon-chevron-right").toggleClass("glyphicon glyphicon-chevron-down");
            });

           $(".sub>li").click(function(event) {
                //监听二级阻止事件冒泡
                event.stopPropagation();
                //获取所点击li 的id
                var getId=$(this).attr("class");
                console.info(getId+"-------");
                var userListUrl=$("#"+getId).val();
                console.info(userListUrl+"-----");
                $("#menuForm").attr("action",userListUrl);
                $("#menuForm").submit();

            })

        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	</script>
</html>