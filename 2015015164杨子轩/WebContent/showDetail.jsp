<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>showDetail</title>
<base target="mainFrame">
</head>
<body>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>订单详情号</td>
        	<td>图书名称</td>
        	<td>购买数量</td>
        </tr>
		<c:forEach items="${showList}" var="orderdetail" varStatus="loop">
		<tr>
			<td>${orderdetail.orderdetail_id}</td>
			<td>${orderdetail.book.book_name}</td>
			<td>${orderdetail.count}</td>
        </tr>	
		</c:forEach>
	</table>
</body>
</html>