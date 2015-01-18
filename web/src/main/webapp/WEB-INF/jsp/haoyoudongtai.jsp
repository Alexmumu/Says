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
 <style type="text/css">
  		.line-clamp{
					  overflow : hidden;
					  text-overflow: ellipsis;
					  display: -webkit-box;
					  -webkit-line-clamp: 5;
					  -webkit-box-orient: vertical;
					}
</style>

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

<!-- 动态模版开始 -->
<script type="text/html" id="dongtai">
{{# for(var i = 0, len = d.newslist.length; i < len; i++){ }}
<!-- 发表/转发说说 -->
	{{# if(d.newslist[i].datatype===1 || d.newslist[i].datatype===2){ }}
<div class="am-g" style="margin-bottom: 40px;">
			<!--左边头像-->
			<div class="am-u-lg-2">
				<div class="am-g">
					<img src="{{d.newslist[i].data.userid.userimg}}" width="64" height="64">
				</div>
			</div>
			<!--左边头像结束-->
			<!--右边内容-->
		<div class="am-u-lg-9">
					<div class="am-g  block">
						<!--小三角-->
						<div class="pop-triangle"></div>
						<!--日志的例子-->
						{{# if(d.newslist[i].datatype===1){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="">{{d.newslist[i].data.userid.username}}</a> 于
							 {{d.newslist[i].datadate}} 发表了一篇说说
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						{{# if(d.newslist[i].datatype===2){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="">{{d.newslist[i].data.userid.username}}</a> 于
							 {{d.newslist[i].datadate}} 转发了一篇说说
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						<div class="am-g" style="height:0px;">
							<hr>
						</div>
						{{# if(d.newslist[i].datatype===1){ }}
						<div class="am-g am-text-lg">
							<h3 style="margin:0px;padding:0px;">
								<br>
							</h3>
						</div>
						{{# } }}
						{{# if(d.newslist[i].datatype===2){ }}
						<div class="am-g am-text-lg">
							{{d.newslist[i].ralaycontent}}<br><hr>
						</div>
						{{# } }}
						<div class="am-g am-text-sm">
						{{# if(d.newslist[i].datatype===2){ }}
							<a class="am-link-muted" href="">
							<i class="am-icon-link"> </i> {{d.newslist[i].fromname}}∶</a>
						{{# } }}
							{{d.newslist[i].data.shuocontent}}
							<img src="{{d.newslist[i].data.shuoimg}}">
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>
										评论 ({{d.newslist[i].pinglunnum}})</button>
								</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
						<button href="" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 ({{d.newslist[i].zhuanfanum}})</button>
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button href="" class="am-link-muted">
									<i class="am-icon-thumbs-up"></i> {{d.newslist[i].dianzannum}}</button>
								</span>
							
						
							</div>
						</div>




					</div>

			</div>
				
				<!--中间间隔-->
			<div class="am-u-lg-1">
				
			</div>
		</div>
	{{# } }}	
<!-- 发表/转载日志 -->
	{{# if(d.newslist[i].datatype===3 || d.newslist[i].datatype===4){ }}
	<div class="am-g" style="margin-bottom: 40px;">
			<!--左边头像-->
			<div class="am-u-lg-2">
				<div class="am-g">
					<img src="{{d.newslist[i].data.rizhiuserid.userimg}}" width="64" height="64">
				</div>
			</div>
			<!--左边头像结束-->
			<!--右边内容-->
		<div class="am-u-lg-9">
					<div class="am-g  block">
						<!--小三角-->
						<div class="pop-triangle"></div>
						<!--日志的例子-->
						{{# if(d.newslist[i].datatype===3){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="">{{d.newslist[i].data.rizhiuserid.username}}</a> 于
							 {{d.newslist[i].datadate}} 发表了一篇日志
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						{{# if(d.newslist[i].datatype===4){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="">{{d.newslist[i].data.rizhiuserid.username}}</a> 于
							 {{d.newslist[i].datadate}} 转载了一篇日志
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						<div class="am-g" style="height:0px;">
							<hr>
						</div>
						<div class="am-g am-text-lg">
							{{# if(d.newslist[i].datatype===3){ }}
								<h3 style="margin:0px;padding:0px;">
								<a class="am-link-muted" href="">
								<i class="am-icon-quote-left"></i>{{d.newslist[i].data.rizhititle}}
								<i class="am-icon-quote-right"></i></a>
							</h3>
							{{# } }}
							{{# if(d.newslist[i].datatype===4){ }}
							<h3 style="margin:0px;padding:0px;">
								<a class="am-link-muted" href="">
								<strong>「转」</strong>
								<i class="am-icon-quote-left"></i>{{d.newslist[i].data.rizhititle}}
								<i class="am-icon-quote-right"></i></a>
							</h3>
							{{# } }}
						</div>
						<div class="am-g am-text-sm">
							<p class="line-clamp">
									{{d.newslist[i].data.rizhicontent}}
								</p>
									<a href="javascript:;" class="am-link-muted"style=" float: right;">
										 查看日志 <i class="am-icon-chevron-circle-right"></i>
									</a>
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted">
										<i class="am-icon-comments"></i>
										评论 ({{d.newslist[i].pinglunnum}})</button>
								</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
						<button href="" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 ({{d.newslist[i].zhuanfanum}})</button>
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i> 
									{{d.newslist[i].dianzannum}}</button>
								</span>
							
						
							</div>
						</div>




					</div>

			</div>
				<!--中间间隔-->
			<div class="am-u-lg-1">
				
			</div>
		</div>
	 {{# } }}
	 {{# if(d.newslist[i].datatype===5 || d.newslist[i].datatype===6){ }}
	 <!-- 上传/转载相片-->
	 		<div class="am-g" style="margin-bottom: 40px;">
			<!--左边头像-->
			<div class="am-u-lg-2">
				<div class="am-g">
					<img src="{{d.newslist[i].data.userid.userimg}}" width="64" height="64">
				</div>
			</div>
			<!--左边头像结束-->
			<!--右边内容-->
		<div class="am-u-lg-9">
					<div class="am-g  block">
						<!--小三角-->
						<div class="pop-triangle"></div>
						<!--相片的例子-->
						{{# if(d.newslist[i].datatype===5){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="">{{d.newslist[i].data.userid.username}}</a> 于
							{{d.newslist[i].datadate}} 上传了一张照片到<a class="am-link-muted" href=" ">
							<i class="am-icon-angle-double-left"></i>
							{{d.newslist[i].data.albumid.albumtitle}}
							<i class="am-icon-angle-double-right"></i></a>
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						{{# if(d.newslist[i].datatype===6){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="">{{d.newslist[i].data.userid.username}}</a> 于
							{{d.newslist[i].datadate}} 转载了一张照片到<a class="am-link-muted" href=" ">
							<i class="am-icon-angle-double-left"></i>
							{{d.newslist[i].data.albumid.albumtitle}}
							<i class="am-icon-angle-double-right"></i></a>
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						<div class="am-g" style="height:0px;">
							<hr>
						</div>
						<div class="am-g am-text-lg">
							<h3 style="margin:0px;padding:0px;">
								<br>
							</h3>
						</div>
						<div class="am-g am-text-sm">
							<img src="images/body_1.png">
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted">
									<i class="am-icon-comments"></i>评论 ({{d.newslist[i].pinglunnum}})
									</button>

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
				转发 ({{d.newslist[i].zhuanfanum}})</button>
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i> 
									  {{d.newslist[i].dianzannum}}</button>
								</span>
							
						
							</div>
						</div>

					</div>

			</div>
				
				<!--中间间隔-->
			<div class="am-u-lg-1">
				
			</div>
		</div>
		{{# } }}
{{# } }}

</script>
<!-- 动态模版结束 -->

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
			<div class="am-u-lg-9  " id="showdongtai">
			
			</div>
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