<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="/web/css/amazeui.css">
<link rel="stylesheet" type="text/css" href="/web/css/top.css">

<script src="/web/js/jquery.min.js"></script>
<script src="/web/js/amazeui.js"></script>
<script src="/web/js/top.js"></script>
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
				<li><a href="user/myhome?userid=${myuser.userid}">我的领土</a></li>
				<li><a href="News/tolistNews">好友动态</a></li>
			</ul>

			<ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right"
				style="margin-top: 0px;">
				<li><a href="javascript:;" id="axxnum"
					data-am-offcanvas="{target: '#doc-oc-demo1'}"><span
						class="am-icon-envelope-o"></span>消息盒子 <span id='xxnumspan'
						class="am-badge am-badge-warning"><i id="xxnum">0</i></span></a></li>
				<li class="am-dropdown" data-am-dropdown=""><a
					class="am-dropdown-toggle" data-am-dropdown-toggle=""
					href="javascript:;"> <span class="am-icon-user">${myuser.username}</span><span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="user/toManger?type=1" ><span class="am-icon-group"></span> 好友管理</a></li>
						<li><a href="user/toManger?type=2" ><span class="am-icon-cog"></span>个人资料</a></li>
						<li><a href="user/exit"><span class="am-icon-power-off"></span>
								退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!--右边消息中心-->
	<div id="doc-oc-demo1" class="am-offcanvas">
		<div class="am-offcanvas-bar am-offcanvas-bar-flip">
			<div class="am-offcanvas-content">
				<h1 class="am-text-center">消息中心</h1>
				<!-- 消息中心的列表折叠开始 -->
				<div class="am-panel-group" id="accordion">
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#do-not-say-1'}">
								好友申请</p>
						</div>
						<div id="do-not-say-1" class="am-panel-collapse am-collapse am-in">
							<div class="am-panel-bd">
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
						</div>
					</div>
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#do-not-say-2'}">
								说说被赞了</p>
						</div>
						<div id="do-not-say-2" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">逆旅人</a> 赞了你的说说 <br />2015:10:12:08:15 <a href="">点击查看</a>
							</div>
						</div>
					</div>
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#do-not-say-3'}">...</p>
						</div>
						<div id="do-not-say-3" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">...</div>
						</div>
					</div>
				</div>
				<!-- 消息列表的折叠结束 -->

			</div>
		</div>
	</div>
	<!--右边消息中心结束--> </header>
	<!--头部结束-->


	<!--评论弹出框-->
	<div class="am-popup" id="my-popup">
		<div class="am-popup-inner">
			<div class="am-popup-hd">
				<h4 class="am-popup-title">...</h4>
				<span data-am-modal-close class="am-close">&times;</span>
			</div>
			<div class="am-popup-bd">
				<iframe src="" id="myframe"  marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;" width="100%" height="700px;">
		
</iframe>
			</div>
		</div>
	</div>
	<!--评论弹出框结束-->
</body>
</html>