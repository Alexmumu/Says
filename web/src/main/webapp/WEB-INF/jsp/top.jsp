<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="/web/css/amazeui.css">
<link rel="stylesheet" type="text/css" href="/web/css/top.css">
<link rel="stylesheet" type="text/css" href="/web/css/laypage/skin/laypage.css">


<script src="/web/js/jquery.min.js"></script>
<script src="/web/js/amazeui.js"></script>
<script src="/web/js/laytpl.js"></script>
<script src="/web/css/laypage/laypage.js"></script>
<script src="/web/js/top.js"></script>


<script type="text/html" id="xiaoximb">
<h1 class="am-text-center">消息中心</h1>
<!-- 消息中心的列表折叠开始 -->
<div class="am-panel-group" id="accordion">
{{# for(var i = 0, len = d.msglist.length; i < len; i++){ }}
	{{#if(d.msglist[i].mctype==1) { }}
	<div class="am-panel am-panel-default">
	<div class="am-panel-hd">
		{{#if(d.msglist[i].mcstatus==1) { }}
			<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
				data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
				好友申请
				<span id="remove{{i}}" class="am-badge am-badge-warning">
				<i>1</i></span>
			</p>
		{{# } }}
		{{#if(d.msglist[i].mcstatus==0) { }}
			<p class="am-panel-title"
				data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
				好友申请
			</p>
		{{# } }}
	</div>
	<div id="doc{{i}}" class="am-panel-collapse am-collapse">
		<div class="am-panel-bd">
			<a href="">{{d.msglist[i].data.fruser.username}}</a>申请与你为好友
			<hr>
			<b>申请理由：</b>{{d.msglist[i].data.shenqiliyou}}
			<hr>
			<div class="am-text-center">
			{{#if(d.msglist[i].data.frstatus==1) { }}

				<button onclick="updateFrequest('{{d.msglist[i].data.frid}}','2')"  class="am-btn am-btn-primary am-btn-xs">同意</button>
				<button onclick="updateFrequest('{{d.msglist[i].data.frid}}','3')"  class="am-btn am-btn-danger am-btn-xs">
					拒绝</button>
			{{# } }}
			{{#if(d.msglist[i].data.frstatus==2) { }}
				你已经同意加此用户为好友
			{{# } }}
			{{#if(d.msglist[i].data.frstatus==3) { }}
				你拒绝了加此用户为好友
			{{# } }}
				<br>
				{{d.msglist[i].msctime}}
			</div>
		</div>
	</div>
</div>
	{{# } }}
	<!--说说被评论-->
	{{#if(d.msglist[i].mctype==2) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								说说被评论
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								说说被评论
							</p>
							{{# } }}
						</div>
						<div id="doc{{i}}"  class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">
									{{d.msglist[i].fromname}}
								</a> 评论你的说说 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--说说被转发-->
	{{#if(d.msglist[i].mctype==3) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								说说被转发
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								说说被转发</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 转发你的说说 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--说说被赞-->
	{{#if(d.msglist[i].mctype==4) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								说说被赞
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								说说被赞</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 赞了你的说说 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--日志被评论-->
	{{#if(d.msglist[i].mctype==5) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								日志被评论
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								日志被评论</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 评论了你的日志 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--日志被转发-->
	{{#if(d.msglist[i].mctype==6) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								日志被转发
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								日志被转发</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 转发了你的日志 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--日志被赞-->
	{{#if(d.msglist[i].mctype==7) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								日志被赞
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								日志被赞</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 赞了你的日志 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--相片被评论-->
	{{#if(d.msglist[i].mctype==8) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								相片被评论
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								相片被评论</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 评论了你的相片 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--相片被转发-->
	{{#if(d.msglist[i].mctype==9) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}},i')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								相片被转发
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								相片被转发</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 转发了你的相片 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	<!--相片被赞-->
	{{#if(d.msglist[i].mctype==10) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								相片被赞
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								相片被赞</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 赞了你的相片 <br />
								{{d.msglist[i].msctime}} <a href="">点击查看</a>
							</div>
						</div>
					</div>
	{{# } }}
	{{#if(d.msglist[i].mctype==11) { }}
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							{{#if(d.msglist[i].mcstatus==1) { }}
							<p onclick="updateMsgStatus('{{d.msglist[i].msgid}}','{{i}}')" class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								新的留言
								<span id="remove{{i}}" class="am-badge am-badge-warning"><i>1</i></span>
							</p>
							{{# } }}
							{{#if(d.msglist[i].mcstatus==0) { }}
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#doc{{i}}'}">
								新的留言</p>
							{{# } }}
						</div>
						<div id="doc{{i}}" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">{{d.msglist[i].fromname}}</a> 
								在{{d.msglist[i].msctime}}的留言： <br />
								 <p>{{d.msglist[i].data.leavewordcontent}}</p>
							</div>
						</div>
					</div>
	{{# } }}
{{# } }}
</div>
<!-- 消息列表的折叠结束 -->

</script>

</head>
<body>
			<!--消息分页所用from-->	
			<form id="xxmyform">
				<input type="hidden" name="id" value="${myuser.userid}">
				<input type="hidden" name="pageNo" value="1">
				<input type="hidden" name="pageSize" value="50">
			</form>
			<!--消息分页所用from-->
			
	<!--头部-->
	<header class="am-topbar am-topbar-inverse">
	<div class="am-container">
		<h1 class="am-topbar-brand">
			<a href="#" class="am-kai">想说网</a>
		</h1>
		<div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li><a href="user/myhome?userid=${myuser.userid}">我的领土</a></li>
				<li><a href="News/tolistNews">好友动态</a></li>
			</ul>
			<ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right"
				style="margin-top: 0px;">
				<li><a href="javascript:;" id="axxnum"
					data-am-offcanvas="{target: '#doc-oc-demo1'}"><span
						class="am-icon-envelope-o"></span>消息盒子 <span id='xxnumspan'
						class="am-badge am-badge-warning"><i id="xxnum">0</i></span></a></li>

				<li class="am-dropdown" data-am-dropdown=""><a
					class="am-dropdown-toggle" data-am-dropdown-toggle=""
					href="javascript:;"> <span class="am-icon-user">${myuser.username}</span><span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="user/toManger?type=1" ><span class="am-icon-group"></span> 好友管理</a></li>
						<li><a href="user/toManger?type=2" ><span class="am-icon-cog"></span>个人资料</a></li>
						<li><a href="user/exit"><span class="am-icon-power-off"></span>
								退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!--右边消息中心-->
	<div id="doc-oc-demo1" class="am-offcanvas">
		<div class="am-offcanvas-bar am-offcanvas-bar-flip">
			<div class="am-offcanvas-content" id="xiaoxibody">
				<h1 class="am-text-center">消息中心</h1>
				<!-- 消息中心的列表折叠开始 -->
				<div class="am-panel-group" id="accordion">
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#do-not-say-1'}">
								好友申请</p>
						</div>
						<div id="do-not-say-1" class="am-panel-collapse am-collapse am-in">
							<div class="am-panel-bd">
								<a href="">逆旅人</a>申请与你为好友
								<hr>
								<b>申请理由：</b>我是你的小学同学我是你的小学同学我是你的小学同学我是你的小学同学
								<hr>
								<div class="am-text-center">
									<button href="" class="am-btn am-btn-primary am-btn-xs">同意</button>
									<button href="" class="am-btn am-btn-danger am-btn-xs">
										拒绝</button>
									2015:10:12:08:15
								</div>
							</div>
						</div>
					</div>
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#do-not-say-2'}">
								说说被赞了</p>
						</div>
						<div id="do-not-say-2" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">
								<a href="">逆旅人</a> 赞了你的说说 <br />2015:10:12:08:15 <a href="">点击查看</a>
							</div>
						</div>
					</div>
					<div class="am-panel am-panel-default">
						<div class="am-panel-hd">
							<p class="am-panel-title"
								data-am-collapse="{parent: '#accordion', target: '#do-not-say-3'}">...</p>
						</div>
						<div id="do-not-say-3" class="am-panel-collapse am-collapse">
							<div class="am-panel-bd">...</div>
						</div>
					</div>
				</div>
				<!-- 消息列表的折叠结束 -->
			</div>
			<div id="page2" ></div>
							
			
		</div>
	</div>
	<!--右边消息中心结束--> </header>
	<!--头部结束-->


	<!--评论弹出框-->
	<div class="am-popup" id="my-popup">
		<div class="am-popup-inner">
			<div class="am-popup-hd">
				<h4 class="am-popup-title">...</h4>
				<span data-am-modal-close class="am-close">&times;</span>
			</div>
			<div class="am-popup-bd">
<iframe src="" id="myframe"  marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;" width="100%" height="700px;">
	
</iframe>
			</div>
		</div>
	</div>
	<!--评论弹出框结束-->
</body>
</html>
