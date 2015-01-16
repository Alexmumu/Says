<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css" href="css/top.css">

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="js/top.js"></script>
</head>
<body>
	<!--头部-->
	<header class="am-topbar am-topbar-inverse">
	<div class="am-container">
		<h1 class="am-topbar-brand">
			<a href="#" class="am-kai">想说网</a>
		</h1>
		<div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li><a href="#">我的领土</a></li>
				<li><a href="#">好友动态</a></li>
			</ul>

			<ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right"
				style="margin-top: 0px;">
				<li><a href="javascript:;" id="axxnum"
					data-am-offcanvas="{target: '#doc-oc-demo3'}" ><span
						class="am-icon-envelope-o"></span>消息盒子 <span id='xxnumspan'
						class="am-badge am-badge-warning"><i id="xxnum">0</i></span></a></li>
				<li class="am-dropdown" data-am-dropdown=""><a
					class="am-dropdown-toggle" data-am-dropdown-toggle=""
					href="javascript:;"> <span class="am-icon-user">${myuser.username}</span><span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="#"><span class="am-icon-user"></span> 好友管理</a></li>
						<li><a href="#"><span class="am-icon-cog"></span>个人资料</a></li>
						<li><a href="#"><span class="am-icon-power-off"></span>
								退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!--右边消息中心-->
	<div id="doc-oc-demo3" class="am-offcanvas">
		<div class="am-offcanvas-bar am-offcanvas-bar-flip">
			<div class="am-offcanvas-content">
				<h1 class="am-text-center">消息中心</h1>
				<section data-am-widget="accordion"
					class="am-accordion am-accordion-gapped" data-am-accordion='{  }'>
				<dl class="am-accordion-item am-active">
					<dt class="am-accordion-title">说说被赞了</dt>
					<dd class="am-accordion-bd am-collapse am-in">
						<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
						<div class="am-accordion-content">
							<a href="">逆旅人</a> 赞了你的说说 <br />2015:10:12:08:15 <a href="">点击查看</a>
						</div>
					</dd>
				</dl>
				<dl class="am-accordion-item">
					<dt class="am-accordion-title">好友申请</dt>
					<dd class="am-accordion-bd am-collapse ">
						<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
						<div class="am-accordion-content">
							<a href="">逆旅人</a>申请与你为好友
							<hr>
							<b>申请理由：</b>我是你的小学同学我是你的小学同学我是你的小学同学我是你的小学同学
							<hr>
							<div class="am-text-center">
								<button href="" class="am-btn am-btn-primary am-btn-xs">同意</button>
								<button href="" class="am-btn am-btn-danger am-btn-xs">
									拒绝</button>
								2015:10:12:08:15
							</div>
						</div>
					</dd>
				</dl>
				<dl class="am-accordion-item">
					<dt class="am-accordion-title">我就这样告别山下的家</dt>
					<dd class="am-accordion-bd am-collapse ">
						<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
						<div class="am-accordion-content">我就这样告别山下的家，我实在不愿轻易让眼泪留下。我以为我并不差不会害怕，我就这样自己照顾自己长大。我不想因为现实把头低下，我以为我并不差能学会虚假。怎样才能够看穿面具里的谎话？别让我的真心散的像沙。如果有一天我变得更复杂，还能不能唱出歌声里的那幅画？</div>
					</dd>
				</dl>

				</section>
			</div>
		</div>
	</div>
	<!--右边消息中心结束--> </header>
	<!--头部结束-->
</body>
</html>