<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href="Css/Top.css" rel="stylesheet" type="text/css" />
<title>top</title>
</head>
<body>
	<div id="top">
      <div id="time">您好，今天是<span id="date">2017年12月4日&nbsp;星期一</span></div>
         	 <script type="text/javascript">
             var d=new Date();
             document.getElementById("date").innerHTML=d.getFullYear()+"年"+(d.getMonth()+1)+"月"+d.getDate()+"日"+" 星期"+"日一二三四五六 ".charAt(d.getDay());
             </script>
    </div>
    <div id="menuBg">
       <div id="name">${admin.admin_name }</div>
       <div id="menu">
             <a href="main.jsp" target="mainFrame" id="home">首页</a>
       </div>
    </div>
</body>
</html>