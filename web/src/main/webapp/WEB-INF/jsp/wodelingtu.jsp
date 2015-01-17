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
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${myuser.usernickname}的领土-想说网</title>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css" href="css/appdefault.css">
<link rel="stylesheet" type="text/css" href="css/myhome.css">

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
</head>
<body>
	<!-- 导入头部文件jsp -->
	<%@include file="/WEB-INF/jsp/top.jsp"%>
	<!-- 导入结束 -->
	
	<!--主页展示 top 部分-->
<div class="am-g am-animation-slide-top">
	<div class="am-container " id='fmtop'>
		<div class="am-u-lg-12 block" style="padding: 0 20px;">
		<div class="am-u-lg-3">
			<div class="am-g" style="margin-top:20px;">
				<img class="am-img-thumbnail"  src="http://imgsize.ph.126.net/?imgurl=http://imglf0.ph.126.net/zWJqlfYp6_2J_rykisp63g==/2210985942162543330.jpg_180x180x0x90.jpg">
			</div>
		</div>
		<div class="am-u-lg-9">
			<div class="am-g am-text-center am-text-xxl">
				${myuser.usernickname}的领土
			</div>
			<div class="am-g am-text-center">
				<small style="font-size: 20px;"><i class="am-icon-angle-double-left"></i>${myuser.usersig}<i class="am-icon-angle-double-right"></i></small>
			</div>
			<div class="am-g">
				<ul class="am-avg-sm-1 am-avg-md-5 am-margin am-padding am-text-center admin-content-list " id='caidan'>
		      <li><a href="#" class="am-link-muted" ><span class="am-icon-btn am-icon-newspaper-o"></span><br>主页动态<br>${usercount.newscount}条</a></li>
		      <li><a href="#" class="am-link-muted" ><span class="am-icon-btn am-icon-twitch"></span><br>说说<br>${usercount.shuoshuocount}条</a></li>
		      <li><a href="#" class="am-link-muted" ><span class="am-icon-btn am-icon-edit"></span><br>日志<br>${usercount.rizhicount}条</a></li>
		      <li><a href="#" class="am-link-muted" ><span class="am-icon-btn am-icon-image"></span><br>相册<br>${usercount.rizhicount }条</a></li>
		      <li><a href="#" class="am-link-muted" ><span class="am-icon-btn am-icon-reorder"></span><br>留言板<br>${usercount.liuyancount }条</a></li>
  		 </ul>
			</div>				
		</div>
		</div>
	</div>
</div>
<!--主页展示top部分结束-->
<iframe src="user/zhuyedongtai"  marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;" width="100%" height="700px;">
		
</iframe>

	
</body>
</html>