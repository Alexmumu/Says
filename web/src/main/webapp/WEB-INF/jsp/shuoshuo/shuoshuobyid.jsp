<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css" href="css/top.css">
<link rel="stylesheet" type="text/css" href="css/myhome.css">
<link rel="stylesheet" type="text/css" href="css/appdefault.css">
<link rel="stylesheet" type="text/css"
	href="js/laypage/skin/laypage.css">
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="js/laypage/laypage.js"></script>
<script src="js/laytpl.js"></script>
<script src="js/laytpl.js"></script>
</head>
<body>
<div>

<a href="javascript:history.go(-1)"
							class="am-btn am-btn-default am-round">返回</a>
</div>
	
	<!--主页展示核心内容-->
	<div class="am-g">
		<div class="am-container">
			<!--内容开始-->
			
			<div class="am-u-lg-9  ">


				<c:if test="${con.data.shuonature == 0 }">
					<!-- 说说动态模版 -->
					<div class="am-g">
						<!--左边头像-->
						<div class="am-u-lg-2">
							<div class="am-g">
								<img src="${con.data.userid.userimg }" width="64" height="64">
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
									<a class="am-link-muted" href="">${con.data.userid.username}
									</a> 于 ${con.data.shuodate } 发表了一篇说说 <span
										class="am-icon-eye am-fr"> ${con.yuedunum }人浏览 </span>
								</div>
								<div class="am-g" style="height: 0px;">
									<hr>
								</div>
								<div class="am-g am-text-lg">
									<h3 style="margin: 0px; padding: 0px;">
										<br>
									</h3>
								</div>
								<div class="am-g am-text-sm">
									${con.data.shuocontent } <img
										src="images/shuoshuo/${con.data.shuoimg }">
								</div>
								<hr>

								<!--下面关于的操作-->
								<div class="am-g am-text-sm">
									<div class="am-fr">
										<span>
											<button href="" data-am-modal="{target: '#my-popup'}"
												class="am-link-muted">
												<i class="am-icon-comments"></i>评论 (${con.pinglunnum })
											</button>
										</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
											<button href="" class="am-link-muted" alt="转发">
												<i class="am-icon-share" alt="转发"></i> 转发 (${con.zhuanfanum })
											</button>
										</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
											<button href="" class="am-link-muted">
												<i class="am-icon-thumbs-up"></i> ${con.dianzannum }
											</button>
										</span>
										<c:if test="${con.data.userid.userid==myuser.userid }">
											<span> <a
												href="Shuoshuo/deleteshuoshuo?shuoid=${con.data.shuoid }"><i
													class="am-icon-trash am-icon-sm"></i></a>
											</span>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<!--中间间隔-->
						<div class="am-u-lg-1"></div>
					</div>
					<!-- 说说动态模版结束 -->
				</c:if>
				<c:if test="${con.data.shuonature == 1 }">
					<!-- 说说动态模版 -->
					<div class="am-g">
						<!--左边头像-->
						<div class="am-u-lg-2">
							<div class="am-g">
								<img src="${con.data.userid.userimg }" width="64" height="64">
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
									<a class="am-link-muted" href="">${con.data.userid.username}</a>
									于 ${con.data.shuodate} 转发了一篇说说 <span class="am-icon-eye am-fr">
										${con.yuedunum}人浏览 </span>
								</div>
								<div class="am-g" style="height: 0px;">
									<hr>
								</div>
								<div class="am-g am-text-lg">
									${con.ralaycontent}<br>
									<hr>
								</div>
								<div class="am-g am-text-sm">
									<a class="am-link-muted" href=""> <i class="am-icon-link">
									</i> ${con.fromname}∶
									</a> ${con.data.shuocontent } <img
										src="images/shuoshuo/${con.data.shuoimg }">
								</div>
								<hr>

								<!--下面关于的操作-->
								<div class="am-g am-text-sm">
									<div class="am-fr">
										<span>
											<button href="" data-am-modal="{target: '#my-popup'}"
												class="am-link-muted">
												<i class="am-icon-comments"></i>评论 (${con.pinglunnum })
											</button>
										</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
											<button href="" class="am-link-muted" alt="转发">
												<i class="am-icon-share" alt="转发"></i> 转发 (${con.zhuanfanum })
											</button>
										</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
											<button href="" class="am-link-muted">
												<i class="am-icon-thumbs-up"></i> ${con.dianzannum }
											</button>
										</span>
										<c:if test="${con.data.userid.userid==myuser.userid }">
											<span> <a
												href="Shuoshuo/deleteshuoshuo?shuoid=${con.data.shuoid }"><i
													class="am-icon-trash am-icon-sm"></i></a>
											</span>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<!--中间间隔-->
						<div class="am-u-lg-1"></div>
					</div>
					<!-- 说说动态模版结束 -->
				</c:if>


			</div>
		</div>
	</div>



</body>
</html>