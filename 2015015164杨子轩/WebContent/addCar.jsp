<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="Css/reset.css" />
<link type="text/css" rel="stylesheet" href="Css/1024_768.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="Css/pad_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="Css/pad.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="Css/tel_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="Css/tel.css" />
</head>
<body>
	<form action="addCar.do" method="post">
		<dl>
       		<dd><a href="#"><img src="${book.book_img}" alt="book" /></a></dd>
       		<dt>
                                                 书籍名称:<p class="book_title">${book.book_name}</p>
              <br/>                       
                                                 图书价格:<p class="book_inline">${book.book_price}</p>
              <br/>                        
                                                 出版社:<p class="book_inline">${book.book_publisher}</p>
              <br/>
                                                 购买数量:<input type="text" name="count">
              <input type="hidden" name="book_name" value="${book.book_name}">                                                                                          
              <input type="submit" value="加入购物车">
              </dt>
     	</dl>
	</form>
</body>
</html>