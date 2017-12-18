<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
<base target="mainFrame">
</head>
<body>
	<form action="searchType.do" method="post">
		<input type="text" value="按照类型搜索" name="typeName">
		<input type="submit" value="搜索">
	</form>
	<br/>
	<form action="searchName.do" method="post">
		<input type="text" value="按照名称搜索" name="goodsName">
		<input type="submit" value="搜索">
	</form>
	<br/>
	<h3>按照价格搜索</h3>
	<form action="searchPrice.do" method="post">
		<input type="text" value="最低价格" name="lowPrice">
		<input type="text" value="最高价格" name="highPrice">
		<input type="submit" value="搜索">
	</form>
</body>
</html>