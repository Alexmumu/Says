<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="stylesheet" type="text/css" href="js/laypage/skin/laypage.css">
  	<script src="js/jquery.min.js"></script>
  	<script src="js/amazeui.js"></script>
  	<script src="js/laypage/laypage.js"></script>
   <script src="js/laytpl.js"></script>
  <script src="js/laytpl.js"></script>
</head>
<body style="background-color: rgb(237, 237, 239);" >
<div class="am-g ">
		<div class="am-container">
		
		<div class="am-u-lg-12 block">
		
<c:if test="${userid==myuser.userid}">
<div style="margin-bottom:  160px;">
<form class="am-form" action="Shuoshuo/addshuoshuo"
 method="post" enctype="multipart/form-data">
    <div class="am-form-group">
      <label>发表说说</label>
      <textarea name="shuocontent" rows="5" ></textarea>
    </div>
    <div class="am-form-group">
    <div>
  
    <input type="file" name="shuoimg1" style="border: 0;">
    <p class="am-form-help">请选择要上传的图片...</p>
    <div style="float: right;"><p><button type="submit" class="am-btn am-btn-secondary">发表</button></p></div>  
    </div>
    </div>
</form>
</div>
</c:if>
<!--发表说说的表单结束-->


		<!--主页展示核心内容-->
<div class="am-g">
	<div class="am-container">
<!--内容开始-->
	<div class="am-u-lg-9  ">

		<c:forEach items="${page2}" var="p">
			<c:if test="${p.data.shuonature == 0 }">
			<!-- 说说动态模版 -->
		<div class="am-g">
			<!--左边头像-->
			<div class="am-u-lg-2">
				<div class="am-g">
					<img src="${p.data.userid.userimg }" width="64" height="64">
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
							<a class="am-link-muted" href="">${p.data.userid.username} </a> 于
							 ${p.data.shuodate } 发表了一篇说说
							 <span class="am-icon-eye am-fr">
							 	 ${p.yuedunum }人浏览
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
								${p.data.shuocontent }
							<img src="images/shuoshuo/${p.data.shuoimg }">
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论 (${p.pinglunnum })</button>
								</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
						<button href="" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 (${p.zhuanfanum })</button>
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i> ${p.dianzannum }</button>
								</span>
								<c:if test="${p.data.userid.userid==myuser.userid }">
								<span>
									<a  href="Shuoshuo/deleteshuoshuo?shuoid=${p.data.shuoid }"><i class="am-icon-trash am-icon-sm"></i></a>
								</span>
								</c:if>
							</div>
						</div>
					</div>
			</div>
				<!--中间间隔-->
			<div class="am-u-lg-1">
				
			</div>
		</div>
		<!-- 说说动态模版结束 -->
			</c:if>
			<c:if test="${p.data.shuonature == 1 }">
						<!-- 说说动态模版 -->
		<div class="am-g">
			<!--左边头像-->
			<div class="am-u-lg-2">
				<div class="am-g">
					<img src="${p.data.userid.userimg }" width="64" height="64">
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
							<a class="am-link-muted" href="">${p.data.userid.username}</a> 于
							 ${p.data.shuodate} 转发了一篇说说
							 <span class="am-icon-eye am-fr">
							 	 ${p.yuedunum}人浏览
							 </span>
						</div>
						<div class="am-g" style="height:0px;">
							<hr>
						</div>
						<div class="am-g am-text-lg">
							${p.ralaycontent}<br><hr>
						</div>
						<div class="am-g am-text-sm">
							<a class="am-link-muted" href="">
								<i class="am-icon-link"> </i> ${p.fromname}∶
							</a>
								${p.data.shuocontent }
							<img src="images/shuoshuo/${p.data.shuoimg }">
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论 (${p.pinglunnum })</button>
								</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
						<button href="" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 (${p.zhuanfanum })</button>
								</span>
								
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i> ${p.dianzannum }</button>
								</span>
								<c:if test="${p.data.userid.userid==myuser.userid }">
								<span>
									<a  href="Shuoshuo/deleteshuoshuo?shuoid=${p.data.shuoid }"><i class="am-icon-trash am-icon-sm"></i></a>
								</span>
								</c:if>
							</div>
						</div>
					</div>
			</div>
				<!--中间间隔-->
			<div class="am-u-lg-1">
				
			</div>
		</div>
		<!-- 说说动态模版结束 -->
			</c:if>
		
		</c:forEach>
		

<!--内容结束-->
<div id="page1">
				<ul class="am-pagination am-pagination-centered ">
					<c:if test="${page1.pageNo<=1}">
						<li class="am-pagination am-disabled">
						<a href="Shuoshuo/toshuoshuo?userid=${userid}&pageNo=${page1.pageNo-1}">&laquo;
								上一页</a>
					</c:if>
					<c:if test="${page1.pageNo>1}">
						<li class="am-pagination">
						<a href="Shuoshuo/toshuoshuo?userid=${userid}&pageNo=${page1.pageNo-1}">&laquo;
								上一页</a>
					</c:if>
					<c:if test="${page1.pageNo==page1.pageSum}">
						<li class="am-pagination am-disabled">
						<a href="Shuoshuo/toshuoshuo?userid=${userid}&pageNo=${page1.pageNo+1}">下一页
								&raquo;</a>
					</c:if>
					<c:if test="${page1.pageNo!=page1.pageSum}">
						<li class="am-pagination">
						<a href="Shuoshuo/toshuoshuo?userid=${userid}&pageNo=${page1.pageNo+1}">下一页
								&raquo;</a>
					</c:if>
				</ul>
			</div>
		</div>
</div>
		</div>
	</div>

</body>
</html>