<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>在线书店</title>
<link type="text/css" rel="stylesheet" href="Css/reset.css" />
<link type="text/css" rel="stylesheet" href="Css/1024_768.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="Css/pad_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="Css/pad.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="Css/tel_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="Css/tel.css" />
</head>
<body>

<div class="w_100_l">
	<div class="main">
      <div class="top_banner">
            <div class="top_logo"><img src="Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
            <div class="top_menu">
            	<ul>
                	<li class="sel"><a href="#">首页</a></li>
                	<li><a href="#">图书列表</a></li>
                	<li><a href="#">图书分类</a></li>
                	<li><a href="#">关于</a></li>
                	<li><a href="showOrder.do">查询订单</a></li>
                </ul>
            </div>
            <div class="top_shop_cur"><a href="showCar.do"><img src="Images/top_shop_cur.jpg" alt="shopping car" /></a></div>
        </div>
        <span class="index_img"><img src="Images/banner_img.jpg" alt="Dan Cederholm" border="0" usemap="#Map" />
        <map name="Map" id="Map">
          <area shape="rect" coords="857,230,930,269" href="#" alt="buy now" />
        </map>
        </span>
        <p class="index_hr"></p>
      <div class="content">
            <h1 class="h1_book_title"><a href="index01.jsp">热销商品</a>&nbsp;&nbsp;<a href="index02.jsp">最新商品</a>&nbsp;&nbsp;<a href="index03.jsp">全部商品</a></h1>
        	<ul>
        	<c:forEach items="${list}" var="book">
            	<li>
                	<dl>
                    	<dd><a href="#"><img src="${book.book_img}" alt="book" /></a></dd>
                        <dt>
                        	<p class="book_title"><a href="#" target="_blank">${book.book_name}</a></p>
                            <p class="book_inline">${book.book_price}</p>
                            <a class="book_buy" href="buy.do?book_id=${book.book_id}">BUY</a>
                        </dt>
                    </dl>
                </li>
            	</c:forEach>
            </ul>
            
            <ul>
        	<c:forEach items="${list1}" var="book">
            	<li>
                	<dl>
                    	<dd><a href="#"><img src="${book.book_img}" alt="book" /></a></dd>
                        <dt>
                        	<p class="book_title"><a href="#" target="_blank">${book.book_name}</a></p>
                            <p class="book_inline">${book.book_price}</p>
                            <a class="book_buy" href="buy.do?book_id=${book.book_id}">BUY</a>
                        </dt>
                    </dl>
                </li>
            	</c:forEach>
            </ul>
            
            <ul>
        	<c:forEach items="${list2}" var="book">
            	<li>
                	<dl>
                    	<dd><a href="#"><img src="${book.book_img}" alt="book" /></a></dd>
                        <dt>
                        	<p class="book_title"><a href="#" target="_blank">${book.book_name}</a></p>
                            <p class="book_inline">${book.book_price}</p>
                            <a class="book_buy" href="buy.do?book_id=${book.book_id}">BUY</a>
                        </dt>
                    </dl>
                </li>
            	</c:forEach>
            </ul>
      </div>
        <p class="index_hr"></p>
        <div class="content_press">
        	<div class="press_porsen_01">
                <h1>Press Room</h1>
            	<dl>
                	<dd><img src="Images/img_men.jpg" alt="person" /></dd>
                    <dt>
                    	<p class="date">Apr 03, 2014</p>
                        <p class="book_title"><a href="#" target="_blank">Design Is a Job audiobook</a></p>
                        <p class="book_intro">
                        We’re pleased to announce that <a href="#">Design Is a Job</a> by Mike Monteiro is now available in audiobook format, through <a href="#">Audible.com</a> and <a href="#">Amazon.com</a>. Narrated by the raconteur himself, experience the guidance, real-talk, and humor of our seminal book on design as a job.
                        </p>
                    </dt>
                </dl>
            </div>
            <div class="press_porsen_02">
                <h1><span class="span_2"><a href="#"> More Articles →</a></span><span class="span_1"><a href="#">Press Room RSS</a></span></h1>
            	<dl>
                	<dd><img src="Images/img_lives.jpg" alt="book img" /></dd>
                    <dt>
                    	<p class="date">Mar 31, 2014</p>
                        <p class="book_title"><a href="#" target="_blank">A Few of Our Faves: March 31st</a></p>
                        <p class="book_intro">
                        As the madness of March comes to a close, we gathered up a few things that caught our attention during the last half of the month. <a href="#">Read on for more.</a>                        </p>
                    </dt>
                </dl>
            </div>
        </div>
        <p class="index_hr"></p>
        <h1 class="news_title">Newsletter</h1>
        <p class="news_title_1"><span class="span_1">Keep up to date with new book releases and announcements with our newsletter.</span><span class="span_2"><img src="Images/img_inp.jpg" /></span></p>
        <p class="index_hr" style="margin-top:20px;"></p>
        <div class="footer">
           <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">Help & Contact us</a>
            <a class="a1" href="#">Press Room RSS feed</a>
            <a class="a2" href="#">abookapart on Twitter</a>
            <span class="span_2"><b>Published by</b><img src="Images/icon_hg.jpg" align="absmiddle" /></span>
        </div>
    </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>