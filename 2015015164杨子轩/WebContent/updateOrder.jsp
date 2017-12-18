<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>图书名称</td>
        	<td>购买数量</td>
        	<td>操作</td>
        </tr>
		<c:forEach items="${odList}" var="orderdetail">
		<tr>
			<td>${orderdetail.book.book_name }</td>
			<td>${orderdetail.count }</td>
        	<td><a href="updateOrderTwo.do?name=${orderdetail.book.book_name }&id=${orderdetail.orderdetail_id }">修改</a>  <a href="deleteOrderdetail.do?id=${orderdetail.orderdetail_id }">取消</a></td>
        </tr>	
		</c:forEach>
	</table>
</body>
</html>