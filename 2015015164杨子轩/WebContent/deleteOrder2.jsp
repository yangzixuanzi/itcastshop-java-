<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deleteOrder2</title>
<base target="mainFrame">
</head>
<body>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>订单号</td>
        	<td>下单时间</td>
        	<td>订单状态</td>
        	<td>操作</td>
        </tr>
		<c:forEach items="${Order2List}" var="order" varStatus="loop">
		<tr>
			<td>${order.order_id}</td>
			<td>${order.order_time}</td>
			<td>${order.order_state}</td>
        	<td><a href="deleteOrder2.do?orderId1=${order.order_id}&name=${name1}">删除</a>  <a href="sendOutgoods.do?orderId=${order.order_id}">发货</a>  <a href="showDetail.do?orderId1=${order.order_id}">显示详情</a></td>
        </tr>	
		</c:forEach>
	</table>
</body>
</html>