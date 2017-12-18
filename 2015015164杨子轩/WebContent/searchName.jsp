<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>searchName</title>
<base target="mainFrame">
</head>
<body>
	<table border="1" bgcolor="yellow">
		<tr>
        	<td>图书号</td>
        	<td>图书名称</td>
        	<td>图书出版社</td>
        	<td>图书价格</td>
        	<td>图书类型</td>
        	<td>操作</td>
        </tr>
		<tr>
			<td>${NameBook.book_id }</td>
			<td>${NameBook.book_name }</td>
			<td>${NameBook.book_publisher }</td>
			<td>${NameBook.book_price }</td>
			<td>${NameBook.bookType.type_name }</td>
        	<td><a href="updateGoods.do?id=${NameBook.book_id }">修改</a> <a href="deleteGoods.do?id=${NameBook.book_id }">删除</a></td>
        </tr>	
	</table>
</body>
</html>