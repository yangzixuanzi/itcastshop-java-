<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserManage</title>
</head>
<body>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>用户ID</td>
        	<td>用户名</td>
        	<td>用户密码</td>
        	<td>用户邮箱</td>
        	<td>注册时间</td>
        	<td>身份证号</td>
        	<td>操作</td>
        </tr>
		<c:forEach items="${UserList}" var="user" varStatus="loop">
		<tr>
			<td>${user.id}</td>
			<td>${user.user_name}</td>
			<td>${user.user_password}</td>
			<td>${user.user_email}</td>
			<td>${user.user_posttime}</td>
			<td>${user.IDnumber}</td>
        	<td><a href="deleteUser.do?userId=${user.id}">删除</a></td>
        </tr>	
		</c:forEach>
	</table>
</body>
</html>