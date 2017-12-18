<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
</head>
<body>
	<p>尊敬的用户:   ${user.user_name}</p>
	<p>您的订单如下:</p>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>订单号</td>
        	<td>下单时间</td>
        	<td>订单明细</td>
        	<td>订单状态</td>
        </tr>
		<c:forEach items="${OrderList1}" var="order" varStatus="loop">
		<tr>
			<td>${order.order_id }</td>
			<td>${order.order_time }</td>
			<td>
        	<c:forEach items="${OrderdetailList1[loop.count-1]}" var="Orderdetail">  
				图书名称:        ${Orderdetail.book.book_name }
				购买数量:        ${Orderdetail.count }
            </c:forEach>
            </td>
        	<td>${order.order_state }</td>
        	<td><a href="updateOrder.do?OrderId=${order.order_id }">修改</a>  <a href="deleteOrder.do?OrderId=${order.order_id }">取消</a></td>
        </tr>	
		</c:forEach>
	</table>
	<p><a href="index03.jsp">继续选购</a></p>
</body>
</html>