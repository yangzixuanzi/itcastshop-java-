<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车清单</title>
</head>
<body>
	<p>尊敬的用户: ${user.user_name}</p>
	<p>您的购物清单如下:</p>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>图书名称</td>
        	<td>购买数量</td>
        	<td>所需费用</td>
        	<td>操作</td>
        </tr>
		<c:forEach items="${bookList1}" var="book" varStatus="loop">
		<tr>
			<td>${book}</td>
        	<td>${countList1[loop.count-1]}</td>
        	<td>${sumList1[loop.count-1]}</td>
        	<td><a href="update.do?bookName=${book}">修改</a>  <a href="delete.do?bookName=${book}&count=${countList1[loop.count-1]}">删除</a></td>
        </tr>	
		</c:forEach>
	</table>
	<p>您购买的物品的总价格为:  ${sum }</p>
	<font color="red" size="4" face="黑体"><a href="alldelete.do">清空购物车</a></font>
	<p><a href="index03.jsp">继续选购</a></p>
	<p><a href="takeOver.jsp">您还未填写您的收货信息</a></p>
</body>
</html>