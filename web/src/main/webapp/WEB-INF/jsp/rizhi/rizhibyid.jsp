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
<link rel="stylesheet" type="text/css"
	href="css/laypage/skin/laypage.css">
<link rel="stylesheet" type="text/css" href="css/appdefault.css">

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>

<style type="text/css">
body {
	padding: 0px 10px 0px 10px;
	color: #333333;
	background-color: rgb(237, 237, 239);
}
</style>
</head>


<body>
	<div class="am-g ">
		<div class="am-container">
			<div class="am-u-sm-12 am-animation-slide-left block">
			<div>
				<article class="am-article">
					<div>
						<a href="javascript:history.go(-1)"
							class="am-btn am-btn-default am-round">返回</a>
					</div>
					<div class="am-article-hd" align="center">
						<h1 class="am-article-title">
							<span>
									<c:if test="${srz.data.rizhinature==1}">
										<strong>[转]</strong>
									</c:if>
									${srz.data.rizhititle}
									<c:if test="${srz.data.rizhinature==1}">
										<small class="am-article-meta" style="font-size: 14px;">
											转载自 </small>
										<small style="color: #236; font-size: 14px;">
											${rzr.useridare.usernickname}</small>
									</c:if>
								</p></span>
						</h1>
						<p class="am-article-meta" style="font-size: 16px">${srz.data.rizhitype.typename}</p>
					</div>

					<div class="am-article-bd">
						<div class="am-article-lead">${srz.data.rizhicontent}</div>
						<p style="float: right; text-align: center; width: 280px;">
							发表时间：${srz.datadate}</p>
					</div>
				</article>

				<div class="am-g am-text-sm">
					<div class="am-fr">
						<span>
							<button href="" data-am-modal="{target: '#my-popup'}"
								class="am-link-muted">
								<i class="am-icon-comments"></i>评论(${srz.pinglunnum})
							</button> <!--评论弹出框-->
							<div class="am-popup" id="my-popup" style="display: none;">
								<div class="am-popup-inner">
									<div class="am-popup-hd">
										<h4 class="am-popup-title">评论输入窗口</h4>
										<span data-am-modal-close="" class="am-close">×</span>
									</div>
									<div class="am-popup-bd">

										<iframe src="pinglun.html" name="rightF" width="600px"
											height="550px" marginheight="0" marginwidth="0"
											style="margin: 0px; padding: 0px;"> </iframe>

									</div>
								</div>
							</div> <!--评论弹出框结束-->
						</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span> <c:if
								test="${srz.data.rizhiuserid.userid!=myuser.userid}">
								<button href="" class="am-link-muted" alt="转发">
									<i class="am-icon-share" alt="转发"></i> 转发(${srz.zhuanfanum})
								</button>
							</c:if>
						</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
							<button href="" class="am-link-muted">
								<i class="am-icon-thumbs-up"></i>赞(${srz.dianzannum})
							</button>
						</span>

</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>