<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
    <center>
      <h1>欢迎你，${empty nowuser ? "游客":nowuser.username }，来到我主页！</h1>
      <h2>
         ${empty nowuser ? "<a href='login.jsp'>请登录</a>":"" }
         
         <c:if test="${not empty nowuser}">
         <a href='logout.do' 
         onclick='return window.confirm("是否确定退出系统？");'>退出登录</a>
         </c:if>
      </h2>
      <h2>
        <a href="usersctrl/list.do">查看用户列表</a>
      </h2>
      <h2>
        <a href="usersctrl/listpage.do">查看用户列表-分页</a>
      </h2>
      
    </center>
    
  </body>
</html>
