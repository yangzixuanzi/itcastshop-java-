<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>在线书店后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="Css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<script src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
	<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
			});
		});	  
	});
	</script>
 <!--SIGN UP-->
 <h1>后台管理员登录</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="Images/avtar.png" />
	</div>
	<form action="AdminLogion.do" method="post">
		<input type="text" class="text" name="adminName" value="adminName" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'adminName';}" >
		<div class="key">
			<input type="password" name="adminPassword" value="adminPassword" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'adminPassword';}">
		</div>
		<div class="signin">
		<input type="submit" value="Login" >
		</div>
		<p><font color="red">${requestScope.error}</font></p>
	</form>
</div>	
</body>
</html>