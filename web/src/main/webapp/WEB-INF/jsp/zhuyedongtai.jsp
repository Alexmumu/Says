<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" type="text/css" href="js/laypage/skin/laypage.css">


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="js/tanchuang.js"></script>
<script src="js/zhuyedongtai.js"></script>
<script src="js/laytpl.js"></script>
<script src="js/tanchuang.js"></script>
<script src="js/laypage/laypage.js"></script>
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



<script type="text/html" id="mydongtaitp">
    	{{# for(var i = 0, len = d.newslist.length; i < len; i++){ }}
<!-- 发表/转发说说 -->
	{{# if(d.newslist[i].datatype===1 || d.newslist[i].datatype===2){ }}
<div class="am-g" style="margin-bottom: 40px;">
			<!--左边头像-->
			<div class="am-u-lg-2">
				<div class="am-g">
					<img src="images/touxiang/{{d.newslist[i].data.userid.userimg}}" width="64" height="64">
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
							<a class="am-link-muted" href="user/myhome?userid={{d.newslist[i].data.userid.userid}}" target="view_window">
							{{d.newslist[i].data.userid.username}}</a> 于
							 {{d.newslist[i].datadate}} 发表了一篇说说
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						{{# if(d.newslist[i].datatype===2){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="user/myhome?userid={{d.newslist[i].data.userid.userid}}" target="view_window">
							{{d.newslist[i].data.userid.username}}</a> 于
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
							<a class="am-link-muted" href="user/myhome?userid={{d.newslist[i].fromid}}" target="view_window">
							<i class="am-icon-link"> </i> {{d.newslist[i].fromname}}∶</a>
						{{# } }}
							{{d.newslist[i].data.shuocontent}}
		
							<img src="images/shuoshuo/{{d.newslist[i].data.shuoimg}}">
					
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button onclick="tanchuang('Comments/toCommentsaa?commentsforid={{d.newslist[i].data.shuoid}}&userid.userid={{d.newslist[i].data.userid.userid}}&type=1')"  class="am-link-muted"><i class="am-icon-comments"></i>
										评论 ({{d.newslist[i].pinglunnum}})</button>
								</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
				{{# if(d.newslist[i].datatype===1){ }}
					<button onclick="tanchuang('Relay/findall?type=1&useridare.userid={{d.newslist[i].data.userid.userid}}&relayfrom={{d.newslist[i].data.shuoid}}')" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 ({{d.newslist[i].zhuanfanum}})</button>
				{{# } }}
				{{# if(d.newslist[i].datatype===2){ }}
						<button onclick="tanchuang('Relay/findall?type=1&useridare.userid={{d.newslist[i].data.userid.userid}}&relayfrom={{d.newslist[i].contentfromid}}')" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 ({{d.newslist[i].zhuanfanum}})</button>
				{{# } }}
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button onclick="dianzan('{{d.newslist[i].data.userid.userid}}','{{d.newslist[i].data.shuoid}}',this)" class="am-link-muted">
									<i class="am-icon-thumbs-up"></i>{{d.newslist[i].dianzannum}}</button>
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
					<img src="images/touxiang/{{d.newslist[i].data.rizhiuserid.userimg}}" width="64" height="64">
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
							<a class="am-link-muted" href="user/myhome?userid={{d.newslist[i].data.rizhiuserid.userid}}" target="view_window">
							{{d.newslist[i].data.rizhiuserid.username}}</a> 于
							 {{d.newslist[i].datadate}} 发表了一篇日志
							 <span class="am-icon-eye am-fr">
							 	 {{d.newslist[i].yuedunum}}人浏览
							 </span>
						</div>
						{{# } }}
						{{# if(d.newslist[i].datatype===4){ }}
						<div class="am-g am-text-xs">
							<a class="am-link-muted" href="user/myhome?userid={{d.newslist[i].data.rizhiuserid.userid}}" target="view_window">
							{{d.newslist[i].data.rizhiuserid.username}}</a> 于
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
								<a class="am-link-muted" href="rizhi/getRizhiid?rizhiid={{d.newslist[i].data.rizhiid}}&rizhiuserid.userid={{d.newslist[i].data.rizhiuserid.userid}}">
								<i class="am-icon-quote-left"></i>{{d.newslist[i].data.rizhititle}}
								<i class="am-icon-quote-right"></i></a>
							</h3>
							{{# } }}
							{{# if(d.newslist[i].datatype===4){ }}
							<h3 style="margin:0px;padding:0px;">
							<a class="am-link-muted" href="rizhi/getRizhiid?rizhiid={{d.newslist[i].data.rizhiid}}&rizhiuserid.userid={{d.newslist[i].data.rizhiuserid.userid}}">
								<strong>「转」</strong>
								<i class="am-icon-quote-left"></i>{{d.newslist[i].data.rizhititle}}
								<i class="am-icon-quote-right"></i>
						</a>
							</h3>
							{{# } }}
						</div>
						<div class="am-g am-text-sm">
							<p class="line-clamp">
									{{d.newslist[i].data.rizhicontent}}
								</p>
									<a href="rizhi/getRizhiid?rizhiid={{d.newslist[i].data.rizhiid}}&rizhiuserid.userid={{d.newslist[i].data.rizhiuserid.userid}}" class="am-link-muted"style=" float: right;">
										 查看日志 <i class="am-icon-chevron-circle-right"></i>
									</a>
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button onclick="tanchuang('Comments/toCommentsaa?commentsforid={{d.newslist[i].data.rizhiid}}&userid.userid={{d.newslist[i].data.rizhiuserid.userid}}&type=2')"  class="am-link-muted"><i class="am-icon-comments"></i>
										评论 ({{d.newslist[i].pinglunnum}})</button>
								</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
						<button onclick="tanchuang('Relay/findall?type=2&useridare.userid={{d.newslist[i].data.rizhiuserid.userid}}&relayfrom={{d.newslist[i].data.rizhiid}}')" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 ({{d.newslist[i].zhuanfanum}})</button>
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button onclick="dianzan('{{d.newslist[i].data.rizhiuserid.userid}}','{{d.newslist[i].data.rizhiid}}',this)" class="am-link-muted">
									<i class="am-icon-thumbs-up"></i>{{d.newslist[i].dianzannum}}</button>
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
					<img src="images/touxiang/{{d.newslist[i].data.userid.userimg}}" width="64" height="64">
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
							<a class="am-link-muted" href="user/myhome?userid={{d.newslist[i].data.userid.userid}}">
							{{d.newslist[i].data.userid.username}}</a> 于
							{{d.newslist[i].datadate}} 上传了一张照片到<a class="am-link-muted" href="photo/listphoto?albumid={{d.newslist[i].data.albumid.albumid}}&userid={{d.newslist[i].data.userid.userid}}">
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
							<a class="am-link-muted" href="user/myhome?userid={{d.newslist[i].data.userid.userid}}">
							{{d.newslist[i].data.userid.username}}</a> 于
							{{d.newslist[i].datadate}} 转载了一张照片到<a class="am-link-muted" href="photo/listphoto?albumid={{d.newslist[i].data.albumid.albumid}}&userid={{d.newslist[i].data.userid.userid}}">
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
							<img src="images/photo/{{d.newslist[i].data.photosrc}}">
						</div><hr>

						<!--下面关于的操作-->
						<div class="am-g am-text-sm">
							<div class="am-fr">
								<span>
									<button onclick="tanchuang('Comments/toCommentsaa?commentsforid={{d.newslist[i].data.photoid}}&userid.userid={{d.newslist[i].data.userid.userid}}&type=3')"  class="am-link-muted"><i class="am-icon-comments"></i>
										评论 ({{d.newslist[i].pinglunnum}})</button>
								</span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>
						<button onclick="tanchuang('Relay/findall?type=3&useridare.userid={{d.newslist[i].data.userid.userid}}&relayfrom={{d.newslist[i].data.photoid}}')" class="am-link-muted" alt="转发">
				<i class="am-icon-share" alt="转发"></i>
				转发 ({{d.newslist[i].zhuanfanum}})</button>
								</span>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span>
									<button onclick="dianzan('{{d.newslist[i].data.userid.userid}}','{{d.newslist[i].data.photoid}}',this)" class="am-link-muted">
									<i class="am-icon-thumbs-up"></i>{{d.newslist[i].dianzannum}}</button>
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



</head>
<body style="background-color: rgb(237, 237, 239); height: 1500px;">
	<input type="hidden" id="zhuyeuserid" value="${zhuyeuser.userid }">
	<input type="hidden" id="zongyeshu" value="${zongyeshu }">
	<!--主页展示核心内容-->
	<div class="am-g">
		<div class="am-container">
			<!--内容开始-->
			<div class="am-u-lg-9  " id="mydongtai">
			&nbsp;	
				<div class="am-g am-text-center" id="zhuanzhuan">
								<i style="font-size:65px;" class="am-icon-refresh am-icon-spin"></i>
				</div>
			</div>
			<!--内容结束-->
			
			<!--右边栏-->
			<div  class="am-u-lg-3 face am-animation-slide-right " id="jieshaolan">
				<p>
					<span class="am-icon-tag"></span> 主人简介
				</p>

				<p>呢称：${zhuyeuser.usernickname}</p>

				<p>帐号：${zhuyeuser.username }</p>

				<p>
					性别：
					<c:if test="${zhuyeuser.usersex==1}">
					霉女
					</c:if>
					<c:if test="${zhuyeuser.usersex==0 }">
					帅锅
					</c:if>
				</p>

				<p>居住地：${zhuyeuser.userarea }</p>
				<p class="am-text-truncate">出生年月：${zhuyeuser.userbirthday}</p>

			</div>
			<!--右边栏结束-->
						<div id="page1"></div>
			
		</div>
	</div>
</body>
</html>