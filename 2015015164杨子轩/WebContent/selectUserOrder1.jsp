<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selectUserOrder1</title>
<base target="mainFrame">
</head>
<body>
	<table border="1" bgcolor="yellow">
		<tr>
			<td>订单号</td>
        	<td>下单时间</td>
        	<td>下单用户</td>
        	<td>订单状态</td>
        	<td>操作</td>
        </tr>
		<tr>
			<td>${Order1.order_id}</td>
			<td>${Order1.order_time}</td>
			<td>${Order1.user.user_name}</td>
			<td>${Order1.order_state}</td>
        	<td><a href="deleteOrder1.do?orderId2=${Order1.order_id}">删除</a>  <a href="sendOutgoods.do?orderId=${Order1.order_id}">发货</a>  <a href="showDetail.do?orderId1=${Order1.order_id}">显示详情</a></td>
        </tr>	
	</table>
</body>
</html>