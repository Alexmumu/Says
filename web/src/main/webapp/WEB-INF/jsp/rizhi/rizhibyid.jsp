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
  <script src="js/dianzan.js"></script>
  <script type="text/javascript">
//为了让父窗口弹出模态窗 里面方的是ifream
function tanchuang(url){
	//1.获取父窗口的元素 这个元素我方在了top。jsp里面 然后改属性 就是改url地址
	$('#myframe',window.parent.document).attr('src',url);
	//2.使用模态窗口的方法 激活弹出
	$('#my-popup',window.parent.document).modal('open');
}
</script>

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
							<span class="am-icon-eye am-fr">
							 	 ${yuedu}人浏览
							 </span>
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
											<a href="user/myhome?userid=${rzr.useridare.userid}"target="view_window">${rzr.useridare.usernickname}</a></small>
									</c:if>
								  </span>
						</h1>
						<p class="am-article-meta" style="font-size: 16px">${srz.data.rizhitype.typename}</p>
					</div>

					<div class="am-article-bd">
						<div class="am-article-lead">${srz.data.rizhicontent}</div>
						<p style="float: right; text-align: center;">
							发表时间：${srz.datadate}</p>
					</div>
				</article>

				<div class="am-g am-text-sm">
					<div class="am-fr">
						<span>
							<button onclick="tanchuang('Comments/toCommentsaa?commentsforid=${srz.data.rizhiid}&userid.userid=${srz.data.rizhiuserid.userid}&type=2')"  data-am-modal="{target: '#my-popup'}"
								class="am-link-muted">
								<i class="am-icon-comments"></i>评论(${srz.pinglunnum})
							</button> 
						</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span> 
						<c:if 	test="${srz.data.rizhiuserid.userid!=myuser.userid}">
								<button onclick="tanchuang('Relay/findall?type=2&useridare.userid=${srz.data.rizhiuserid.userid}&relayfrom=${srz.data.rizhiid}')" class="am-link-muted" alt="转发">
									<i class="am-icon-share" alt="转发"></i> 转发(${srz.zhuanfanum})
								</button>
							</c:if>
						</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
							<button onclick="dianzan('${srz.data.rizhiuserid.userid}','${srz.data.rizhiid}',this)" class="am-link-muted">
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