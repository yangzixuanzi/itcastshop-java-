<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线书店后台管理系统</title>
</head>

<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0" >
    <frame src="top.jsp" name="topFrame" noresize="noresize" id="topFrame" title="topFrame" />
    <frameset name="main_frm" id="main_frm" cols="177,*" frameborder="no" border="0" framespacing="0">
        <frame src="left.jsp" name="leftFrame" id="leftFrame" noresize="noresize" title="leftFrame"  />
        <frameset name="mainFrame" id="mainFrame" cols="8,*" frameborder="no" border="0" framespacing="0">
              <frame src="border.jsp" name="oc" frameborder="no" scrolling="no" noresize="noresize" id="oc" title="mainFrame" />
              <frame src="main.jsp" name="mainFrame" frameborder="no" scrolling="yes" id="mainFrame" title="mainFrame" />
        </frameset>
     </frameset>
</frameset>
<noframes>
<body>

</body>
</noframes> 
</html>