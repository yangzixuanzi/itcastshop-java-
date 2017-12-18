<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="Css/Left.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
//菜单点击用方法--隐藏
function hideAll() 
{
    if (document.all.list.length==null)
    {
        list.style.display="none";
    }
    else
    {
        for(i=0;i<list.length;i++) 
        {
            list[i].style.display="none";
        }
    }
}

//菜单点击用方法--显示
function showobj(num) 
{
    if (document.all.list.length==null)
    {
        if (list.style.display=="none") 
        {
            hideAll();
            list.style.display="inline";
        }
        else 
        {
            list.style.display="none";
        }
    }
    else
    {
        if (list[num].style.display=="none") 
        {
            hideAll();
            list[num].style.display="inline";
        }
        else 
        {
            list[num].style.display="none";
        }
    }
}
</script>
<style type="text/css">
/*<![CDATA[*/
.yincang {
    display:none;
}
/*]]>*/
</style>

<title>left</title>
</head>
<body>
	 <div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="leftMenu">
            <tr onclick="showobj(0)">
                 <td><a target="mainFrame">管理中心</a></td>
            </tr>
            <tr id="list" style="display:none;">
                  <td>
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      	  <tr>
                              <td><a href="UserManage.do" target="mainFrame">用户管理</a></td>
                          </tr>	
                          <tr>
                              <td><a href="OrderManage.do" target="mainFrame">订单管理</a></td>
                          </tr>
                          <tr>
                              <td><a href="GoodsManage.do" target="mainFrame">商品管理</a></td>
                          </tr>
                          <tr>
                          	  <td><a href="admin.jsp" target="_top">退出登录</a></td> 	
                          </tr>
                      </table>
                  </td>
             </tr>
     </table>
  </div>                  
</body>
</html>