<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateGoods</title>
<base target="mainFrame">
</head>
<body>
	<form action="updateGoods2.do" method="post">
		<input type="hidden" name="bookId" value="${goods.book_id }">
		图书名称:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="bookName" value="${goods.book_name }">
		<br/>
		<br/>
		图书出版社:	<input type="text" name="bookPublisher" value="${goods.book_publisher }">
		<br/>
		<br/>
		图书价格:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="bookPrice" value="${goods.book_price }">
		<br/>
		<br/>
		图书类型:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="bookType" value="${goods.bookType.type_name }">
		<br/>
		<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="修改">
	</form>
</body>
</html>