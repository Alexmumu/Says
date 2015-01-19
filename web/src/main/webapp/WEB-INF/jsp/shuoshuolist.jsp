<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
    <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<link rel="stylesheet" type="text/css" href="css/myhome.css">
	<link rel="stylesheet" type="text/css" href="css/appdefault.css">
	
  	<script src="js/jquery.min.js"></script>
  	<script src="js/amazeui.js"></script>
  	<style type="text/css">
  		.line-clamp{
					  overflow : hidden;
					  text-overflow: ellipsis;
					  display: -webkit-box;
					  -webkit-line-clamp: 5;
					  -webkit-box-orient: vertical;
					}
  	</style>
</head>
<body>
<div>
<form class="am-form">
  <fieldset>
    
    <div class="am-form-group">
      <label for="doc-ta-1">发表说说</label>
      <textarea class="" rows="5" id="doc-ta-1"></textarea>
    </div>
    <div class="am-form-group">
    <div>
    <input type="file" style="border: 0;">
    <p class="am-form-help">请选择要上传的图片...</p>
    </div>
    <div style="float: right;"><p><button type="submit" class="am-btn am-btn-secondary">发表</button></p></div>  
    </div>
  </fieldset>
</form>


</div>
<!--发表说说的表单结束-->


		<!--主页展示核心内容-->
<div class="am-g">
	<div class="am-container">
<!--内容开始-->
	<div class="am-u-lg-9  ">

         <c:forEach items="${shou.result }" var="s">
		<!-- 说说动态模版 -->
		<div class="am-g">
			<!--左边头像-->
			<div class="am-u-lg-2">
				<div class="am-g">
					<img src="http://imgsize.ph.126.net/?imgurl=http://img1.ph.126.net/ZrhdtF-AbQNZ4HLMe7NWjQ==/764204561869566439.jpg_64x64x0.jpg" width="64" height="64">
				</div>
			</div>
			<!--左边头像结束-->
			<!--右边内容-->
		<div class="am-u-lg-9">
					<div class="am-g  block">
						<!--小三角-->
						<div class="pop-triangle"></div>
						<!--日志的例子-->
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="">  I'm diandian</a>
							 ${s.data.shuodate } 发表了一篇说说
							 <span class="am-icon-eye am-fr">
							 	 40人浏览
							 </span>
						</div>
						<div class="am-g" style="height:0px;">
							<hr>
						</div>
						<div class="am-g am-text-lg">
							<h3 style="margin:0px;padding:0px;">
								<br>
							</h3>
						</div>
						<div class="am-g am-text-sm">
                              ${p.data.shuocontent}
							<img src="C:\Users\Public\Pictures\Sample Pictures\壁纸.jpg">
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论 (20)</button>

<!--评论弹出框-->
					<div class="am-popup" id="my-popup" style="display: none;">
						<div class="am-popup-inner">
							<div class="am-popup-hd">
								<h4 class="am-popup-title">评论输入窗口</h4>
								<span data-am-modal-close="" class="am-close">×</span>
							</div>
							<div class="am-popup-bd">

								 <iframe src="pinglun.html" name="rightF" width="600px" height="550px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>

					</div>
					</div>
					</div>
<!--评论弹出框结束-->
					</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
						<button href="" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 (10)</button>
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i> 150</button>
								</span>
							
						
							</div>
						</div>




					</div>

			</div>
				
				<!--中间间隔-->
			<div class="am-u-lg-1">
				
			</div>
		</div>
		<!-- 说说动态模版结束 -->
</c:forEach>




</div>
<!--内容结束-->
</div>
</div>
</body>
</html>