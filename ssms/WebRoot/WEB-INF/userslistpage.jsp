<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userslist.jsp' starting page</title>
    
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
       <h1>用户列表</h1>
       <h2>
         <a href="usersctrl/goadd.do">添加用户</a>
       </h2>
       <table border="1" width="80%" cellpadding="0" cellspacing="0" 
                style="text-align: center;">
         <tr>
             <th>编号</th>
             <th>头像</th>
             <th>用户名</th>
             <th>性别</th>
             <th>年龄</th>
             <th>生日</th>
             <th>状态</th>
             <th>操作</th>
         </tr>
         
         <c:forEach items="${p.list }" var="u">
            <tr>
               <td>
                 ${u.uid }
               </td>
               <td>
                 <img alt="暂无图片" src="upload/${u.pic }" 
                    width="40px" height="40px">
               </td>
               <td>
                 ${u.uname }
               </td>
               <td>
                 ${u.sex }
               </td>
               <td>
                 ${u.age }
               </td>
               <td>
                 
                 <fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-dd"/>
               </td>
               <td>
                 ${u.active=="0" ? "启用":"禁用" }
               </td>
               <td>
                 <a href="usersctrl/goupdate.do?uid=${u.uid }">修改</a>
                 /
                 <a href="usersctrl/delete.do?uid=${u.uid }"
                   onclick="return confirm('是否确定删除？')">删除</a>
               </td>
            </tr>
         </c:forEach>
         
          <tr>
             <td style="text-align: center;" colspan="8">
                <a href="usersctrl/listpage.do?pageNum=${p.firstPage }">首页</a>
                <a href="usersctrl/listpage.do?pageNum=${p.prePage }">上一页</a>
                <a href="usersctrl/listpage.do?pageNum=${p.nextPage }">下一页</a>
                <a href="usersctrl/listpage.do?pageNum=${p.lastPage }">尾页</a>
                                       当前${p.pageNum }/${p.pages }页，共${p.total }条
             </td>
          </tr> 
         
       </table>
    </center>
    
  </body>
</html>
