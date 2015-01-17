<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>好友动态</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css" href="css/appdefault.css">
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="js/haoyoudongtai.js"></script>
<script src="js/laytpl.js"></script>

<!-- 访客记录的模版开始 -->
<script type="text/html" id="fangkeTpl">
    	<ul class="am-avg-sm-3" id="fangke" >
    		{{# for(var i = 0, len = d.result.length; i
    		< len; i++){ }}
			<li>
    			<div style="padding:5px;">
    				<a href="javascrip:;">
    					<img  class="am-circle" content="{{d.result[i].fromuserid.username}} 于  {{d.result[i].visittime}}"  src="images/touxiang1.jpg"  width="64" height="64"></a>
				</div>
    		</li>
    		{{# } }}
    	<ul class="am-avg-sm-3" >
</script>

<!-- 访客记录模块 结束 -->
</head>
<body>
	<!-- 导入头部文件jsp -->
	<%@include file="/WEB-INF/jsp/top.jsp"%>
	<!-- 导入结束 -->

	<!-- 页面的标题开始 -->
	<div class="am-g am-animation-slide-top">
		<div class="am-container">
			<div class="am-u-lg-12 block">
				<h1>逆旅人的好友动态2</h1>
			</div>
		</div>
	</div>
	<!-- 页面标题结束 -->

	<!--主页展示核心内容-->
	<div class="am-g">
		<div class="am-container">
			<!-- 左边边栏开始 -->
			<div class="am-u-lg-9  "></div>
			<!--左边栏结束 -->
			<!-- -----------------分割线---------------------- -->
			<!--右边栏-->
			<div class="am-u-lg-3 face am-animation-slide-right"
				style="padding: 0px;">
				<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
					<ul class="am-tabs-nav am-cf">
						<li class="am-active"><a href="[data-tab-panel-0]" class="">我看过谁</a>
						</li>
						<li class=""><a href="[data-tab-panel-1]" class="">谁看过我</a></li>
					</ul>
					<div class="am-tabs-bd">
						<div data-tab-panel-0 class="am-tab-panel am-active"
							id="fangkebody1"></div>
						<div data-tab-panel-1 class="am-tab-panel " id="fangkebody2">

						</div>
					</div>
				</div>
			</div>
			<!--右边栏结束-->
		</div>
	</div>
	<!-- 主页展示核心结束 -->
</body>
</html>