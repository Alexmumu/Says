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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css" href="css/appdefault.css">
<link rel="stylesheet" type="text/css" href="css/myhome.css">

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="js/tanchuang.js"></script>
<script type="text/javascript">
//为了让父窗口弹出模态窗 里面方的是ifream
function tanchuang(url){
	//1.获取父窗口的元素 这个元素我方在了top。jsp里面 然后改属性 就是改url地址
	$('#myframe',window.parent.document).attr('src',url);
	//2.使用模态窗口的方法 激活弹出
	$('#my-popup',window.parent.document).modal('open');
}
</script>
</head>
<body style="background-color: rgb(237, 237, 239);">
	<!--主页展示核心内容-->
	<div class="am-g">
		<div class="am-container">

			<!--内容开始-->
			<div class="am-u-lg-9 am-animation-slide-left ">
				<div class="am-g">
					<!--左边头像-->
					<div class="am-u-lg-2">
						<div class="am-g">
							<img
								src="http://imgsize.ph.126.net/?imgurl=http://img1.ph.126.net/ZrhdtF-AbQNZ4HLMe7NWjQ==/764204561869566439.jpg_64x64x0.jpg"
								width="64" height="64">
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
								<a class="am-link-muted" href=""> I'm diandian</a> 于
								2015-12-12:08:11 发表了一篇日志 <span class="am-icon-eye am-fr">
									100人浏览 </span>
							</div>
							<div class="am-g" style="height: 0px;">
								<hr>
							</div>
							<div class="am-g am-text-lg">
								<h3 style="margin: 0px; padding: 0px;">
									<a class="am-link-muted" href=""><i
										class="am-icon-quote-left"></i>我不知道这个世界会怎样<i
										class="am-icon-quote-right"></i></a>
								</h3>
							</div>
							<div class="am-g am-text-sm">现在这个是一个日志的排版方式 现在这个是一个日志的排版方式
								现在这个是一个日志的排版方式 现在这个是一个日志的排版方式 现在这个是一个日志的排版方式 现在这个是一个日志的排版方式
								现在这个是一个日志的排版方式 现在这个是一个日志的排版方式 现在这个是一个日志的排版方式 现在这个是一个日志的排版方式
								现在这个是一个日志的排版方式 现在这个是一个日志的排版方式 现在这个是一个日志的排版方式 现在这个是一个日志的排版方式
								现在这个是一个日志的排版方式 现在这个是一个日志的排版方式</div>

							<!--下面关于的操作-->
							<div class="am-g am-text-sm">
							
								<div class="am-fr">
									<span>
										<button
											class="am-link-muted" onclick="tanchuang('user/toLogin')">
											<i class="am-icon-comments"></i>评论(20)
										</button>
									</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
										<button href="" class="am-link-muted" alt="转发">
											<i class="am-icon-share" alt="转发"></i> 转发(10)
										</button>
									</span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>
										<button href="" class="am-link-muted">
											<i class="am-icon-thumbs-up"></i>赞(150)
										</button>
									</span>


								</div>
							</div>




						</div>

					</div>

					<!--中间间隔-->
					<div class="am-u-lg-1"></div>
				</div>
			</div>
			<!--内容结束-->

			<!--右边栏-->
			<div class="am-u-lg-3 face am-animation-slide-right" id="jieshaolan">
				<p>
					<span class="am-icon-tag"></span> 主人简介
				</p>

				<p>呢称：${myuser.usernickname}</p>

				<p>帐号：${myuser.username }</p>

				<p>
					性别：
					<c:if test="${myuser.usersex==1}">
					霉女
				</c:if>
					<c:if test="${myuser.usersex==0 }">
					帅锅
				</c:if>
				</p>

				<p>居住地：${myuser.userarea }</p>
				<p class="am-text-truncate">出生年月：${myuser.userbirthday}</p>

			</div>
			<!--右边栏结束-->
		</div>
	</div>
</body>
</html>