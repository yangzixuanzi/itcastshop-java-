<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OrderManage</title>
</head>
<body>
	<h3>搜索订单</h3>
	<form action="selectOrder.do" method="post">
		<input type="text" name="username" value="根据下单用户搜索">
		<input type="submit" value="搜索">
	</form>
	<br/>
	<form action="selectOrder1.do" method="post">
		<input type="text" name="id" value="根据订单号搜索">
		<input type="submit" value="搜索">
	</form>
	<br/>
	<h3>全部订单</h3>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>订单号</td>
        	<td>下单时间</td>
        	<td>下单用户</td>
        	<td>订单状态</td>
        	<td>操作</td>
        </tr>
		<c:forEach items="${OrderList}" var="order" varStatus="loop">
		<tr>
			<td>${order.order_id}</td>
			<td>${order.order_time}</td>
			<td>${order.user.user_name}</td>
			<td>${order.order_state}</td>
        	<td><a href="deleteOrder1.do?orderId2=${order.order_id}">删除</a>  <a href="sendOutgoods.do?orderId=${order.order_id}">发货</a>  <a href="showDetail.do?orderId1=${order.order_id}">显示详情</a></td>
        </tr>	
		</c:forEach>
	</table>
</body>
</html>