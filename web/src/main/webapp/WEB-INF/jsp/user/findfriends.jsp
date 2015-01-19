<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>好友管理->查找好友</title>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" href="css/admin.css" type="text/css">
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>

</head>
<body>
	<div class="admin-content">
		<div class="am-cf am-padding">
			<div class="am-fl am-cf">
				<strong class="am-text-primary am-text-lg">查找好友</strong> / <small>Find
					My Friends </small>
			</div>
			
<!-- 				用户： -->
<%-- 					<c:forEach items="${uid}" var="uid"> --%>
<%-- 						${uid.username } --%>
<%-- 					</c:forEach> --%>
<%-- 				<button class="am-btn am-btn-default " style="float: right;"><a href="friends/findallfriends?userid=${myuser.userid}">返回</a></button> --%>
 			<hr> 
			<div class=" am-cf">

				<form class="am-form am-form-horizontal"
					action="finduser/findfriend" method="post">
					<div class="am-form-group">
						<label for="doc-ipt-3" class="am-u-sm-2 am-form-label">用户帐号:</label>
						<div class="am-u-sm-10">
							<input type="text" id="doc-ipt-3" name="username"
								placeholder="请输入帐号">
							<input type="hidden" name="userid" value="${myuser.userid }">	
						</div>
					</div>
			</div>
			<div class="am-form-group">
				<div class="am-u-sm-10 am-u-sm-offset-2">
					<button type="submit" class="am-btn am-btn-default">搜索</button>
				</div>
			</div>
			</form>
		</div>

	</div>

	<hr>

	<div class="am-g am-container am-text-centere">
		<table class="am-table">
			
			<c:if test="${not empty page.result}">
			<thead>
				<tr>
					<th>头像</th>
					<th>帐号</th>
					<th>呢称</th>
					<th>性别</th>
					<th>操作</th>
				</tr>
				
			</thead>
			</c:if>
			<c:if test="${empty page.result}">
				<h2 style="color: purple; padding-top: 35px;" align="center" >木有搜索到可以添加的好友哦</h2>
			</c:if>
			<tbody>
				<c:forEach items="${page.result}" var="pr">
					<tr>
						
						<td><img src="images/${pr.userimg}" width="34" height="34"></td>
						<td>${pr.username}</td>
						<td>${pr.usernickname}</td>
						<!-- 性别 -->
						<c:if test="${pr.usersex=='0'}">	
							<td><i class="am-icon-child am-icon-btn"></i></td>
						</c:if>
						<c:if test="${pr.usersex=='1'}">
							<td><i class="am-icon-female am-icon-btn"></i></td>
						</c:if>
						<td>
						<!-- 操作 -->
						<c:if test="${pr.userid==myuser.userid}">
							<p>无法添加自己为好友哦！</p>
						</c:if>
						<c:if test="${pr.userid!=myuser.userid}">
							<button class="am-btn am-btn-default "
									data-am-modal="{target: '#my-popup${pr.userid}'}">添加</button>
						</c:if>
						
<%-- 						<c:forEach items="${page2.result}" var="p"> --%>
<%-- 							<c:if test="${p.userfriendid.userid==pr.userid}"> --%>
												
<%-- 							</c:if>											 --%>
<%-- 							<c:if test="${p.userfriendid.userid!=pr.userid}"> --%>
								
<%-- 							</c:if> --%>
<%-- 						</c:forEach>   --%>
								
						 
						
						<!--申请理由弹出框开始-->
							<div class="am-popup" id="my-popup${pr.userid}">
								<div class="am-popup-inner">
									<div class="am-popup-hd">
										<h4 class="am-popup-title">好友申请</h4>
										<span data-am-modal-close class="am-close">关闭</span>
									</div>
									<div class="am-popup-bd">
										<iframe src="finduser/tosqfriends?userid=${pr.userid}" name="rightF" width="600px"
											height="300px" marginheight="0" marginwidth="0"
											style="margin: 0px; padding: 0px;"> </iframe>
									</div>
								</div>
							</div> 
						<!--申请理由弹出框结束-->
						</td>

					</tr>
				</c:forEach>
				
			

			</tbody>
		</table>

<!-- 		<ul class="am-pagination am-pagination-centered "> -->
<%-- 			<c:if test="${page.pageNo<=1}"> --%>
<!-- 				<li class="am-pagination am-disabled"><a -->
<%-- 					href="finduser/findfriend?zt=1&username=${p.username}&pageNo=${page.pageNo-1}">&laquo; --%>
<!-- 						上一页</a> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${page.pageNo>1}"> --%>
<!-- 				<li class="am-pagination"><a -->
<%-- 					href="finduser/findfriend?zt=1&username=${p.username}&pageNo=${page.pageNo-1}">&laquo; --%>
<!-- 						上一页</a> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${page.pageNo==page.pageSum}"> --%>
<!-- 				<li class="am-pagination am-disabled"><a -->
<%-- 					href="finduser/findfriend?zt=1&username=${p.username}&pageNo=${page.pageNo+1}">下一页 --%>
<!-- 						&raquo;</a> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${page.pageNo!=page.pageSum}"> --%>
<!-- 				<li class="am-pagination"><a -->
<%-- 					href="finduser/findfriend?zt=1&username=${p.username}&pageNo=${page.pageNo+1}">下一页 --%>
<!-- 						&raquo;</a> -->
<%-- 			</c:if> --%>
<!-- 		</ul> -->



	</div>
	</div>
</body>
</html>