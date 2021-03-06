<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodsManage</title>
<base target="mainFrame">
</head>
<body>
	<form action="search.jsp" method="post">
		<input type="submit" value="添加">
		<input type="submit" value="搜索">
	</form>
	<br/>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>图书号</td>
        	<td>图书名称</td>
        	<td>图书出版社</td>
        	<td>图书价格</td>
        	<td>图书类型</td>
        	<td>操作</td>
        </tr>
		<c:forEach items="${bList}" var="book">
		<tr>
			<td>${book.book_id }</td>
			<td>${book.book_name }</td>
			<td>${book.book_publisher }</td>
			<td>${book.book_price }</td>
			<td>${book.bookType.type_name }</td>
        	<td><a href="updateGoods.do?id=${book.book_id }">修改</a> <a href="deleteGoods.do?id=${book.book_id }">删除</a></td>
        </tr>	
		</c:forEach>
	</table>
</body>
</html>