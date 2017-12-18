<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>在线书店</title>
		<meta charset="utf-8">
		<link href="Css/style2.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
	<!-----start-main---->
	 <div class="main">
		<div class="login-form">
			<h1>用户登录</h1>
			<div class="head">
				<img src="Images/user.png" alt=""/>
			</div>
			<form action="Logion.do" method="get">
				<input type="text"  name="username">
				<input type="password"  name="password">
				<div class="submit">
					<input type="submit"  value="LOGIN" >
				</div>	
				<p><a href="register.jsp">用户注册</a></p>
				<br>
				<p><font color="red">${errormsg}</font></p>
			</form>
		</div>
			<!--//End-login-form-->
			 <!-----start-copyright---->
   					<div class="copy-right">
						<p>在线书店欢迎您</p> 
					</div>
				<!-----//end-copyright---->
		</div>
			 <!-----//end-main---->
		 		
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>