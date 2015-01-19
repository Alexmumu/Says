<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Document</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css"
	href="js/laypage/skin/laypage.css">
<link rel="stylesheet" type="text/css" href="css/appdefault.css">


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="js/laypage/laypage.js"></script>
<script src="js/laytpl.js"></script>
<script src="js/laytpl.js"></script>

<script type="text/javascript">
	$(function(){
		$('#my-popup').on('close.modal.amui', function(){
			window.location.reload();
			});
	})

</script>

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
	<div class="am-g ">
		<div class="am-container">
		<div class="am-u-sm-8 am-animation-slide-left block">
			<!-- <div class="am-panel am-panel-default">
				<div class="am-panel-hd">日志列表<span style="float: right;">日志数量：${page.dataSum}</span></div> -->
			<c:if test="${uid==myuser.userid}">
				<div style="margin-left: 30px; margin-top: 12px"><a class="am-btn am-btn-default  am-radius" href="rizhi/toaddrizhi?userid=${myuser.userid}">T写日志</a></div>
			<hr>
			</c:if>
			
				<table class="am-table">
				<c:if test="${page.dataSum==0}" ><tr><td>
				<c:if test="${uid!=myuser.userid}">您的好友在这个分类下还没有保存日志！</c:if>
				<c:if test="${uid==myuser.userid}">您在这个分类下还没有保存日志
				，<a href="rizhi/toaddrizhi?userid=${myuser.userid}">立刻添加一篇，与朋友分享您的生活吧。</a></c:if>
				</td>
				</tr></c:if>
				<c:if test="${page.dataSum>0}">
				<c:forEach items="${page.result}" var="rz">
				
				<tr>
				  <td style="width: 80px;">
				  <c:if test="${rz.rizhinature==1}">
								&nbsp&nbsp<span class='am-icon-share'>[转]</span>&nbsp&nbsp
                  </c:if> 
                  <c:if test="${rz.rizhinature==0}">
								&nbsp&nbsp<span class="am-icon-user">[原创]</span>&nbsp&nbsp
                  </c:if> 
				  </td>
				  <td>
				  	   <span> 
                                 <a href="rizhi/getRizhiid?rizhiid=${rz.rizhiid}&rizhiuserid.userid=${rz.rizhiuserid.userid}">${rz.rizhititle}</a>
					   </span>
				  </td>
				  <td>
			               <span> ${rz.rizhitype.typename} </span> 
				  </td>
				  <td>
			              <span> ${rz.rizhidate} </span> 
				  </td>
				  <td>
				    <c:if test="${rz.rizhiuserid.userid==myuser.userid}">
						        <span >
						        <a class="am-btn am-btn-default am-icon-sm am-round" href="rizhi/toupdatarizhi?rizhiid=${rz.rizhiid}&rizhiuserid.userid=${rz.rizhiuserid.userid}">编辑</a>
						        
						        <a  href="rizhi/deleterizhibyid?rizhiid=${rz.rizhiid}&rizhiuserid.userid=${rz.rizhiuserid.userid}"><i class="am-icon-trash am-icon-sm"></i></a>
						        </span>
		           </c:if>
				  </td>
				</tr>
				</c:forEach>
				</c:if>
				</table>
			<!-- </div> -->

			<div id="page1">
				<ul class="am-pagination am-pagination-centered ">
					<c:if test="${page.pageNo<=1}">
						<li class="am-pagination am-disabled"><a
							href="rizhi/${rz}Rizhi?userid=${uid}&pageNo=${page.pageNo-1}&rizhitype.typeid=${typeid}">&laquo;
								上一页</a>
					</c:if>
					<c:if test="${page.pageNo>1}">
						<li class="am-pagination"><a
							href="rizhi/${rz}Rizhi?userid=${uid}&pageNo=${page.pageNo-1}&rizhitype.typeid=${typeid}">&laquo;
								上一页</a>
					</c:if>
					<c:if test="${page.pageNo==page.pageSum}">
						<li class="am-pagination am-disabled"><a
							href="rizhi/${rz}Rizhi?userid=${uid}&pageNo=${page.pageNo+1}&rizhitype.typeid=${typeid}">下一页
								&raquo;</a>
					</c:if>
					<c:if test="${page.pageNo!=page.pageSum}">
						<li class="am-pagination"><a
							href="rizhi/${rz}Rizhi?userid=${uid}&pageNo=${page.pageNo+1}&rizhitype.typeid=${typeid}">下一页
								&raquo;</a>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="am-u-sm-4 am-animation-slide-right " >
			<!--  <div class="am-panel am-panel-default">
				<div class="am-panel-hd">   -->
				<div class="am-g">
					<div class="am-u-sm-1">
					
					</div>
					<div class="am-u-sm-11 block">
					日志类型
					<!--判断是否是用户本人 session中访客的ID与myuser.userid比较-->
					<c:if test="${uid==myuser.userid}">
					<button onclick="tanchuang('rizhi/toRizhitypegl?userid.userid=${myuser.userid}')"  
					class=" am-icon-wrench am-fr">管理</button>
					<hr>
                   </c:if>
					<!--日志管理弹窗-->
					<!-- 
					<div class="am-popup" id="my-popup" style="display: none;">
						<div class="am-popup-inner">
							<div class="am-popup-hd">
								<h4 class="am-popup-title">日志类型管理</h4>
								<span data-am-modal-close="" class="am-close am-close-alt am-close-spin am-icon-times"></span>
							</div>
							<div class="am-popup-bd">

								<iframe src="rizhi/toRizhitypegl?userid.userid=U001" name="rightF" width="600px"
									height="550px" marginheight="0" marginwidth="0"
									style="margin: 0px; padding: 0px;"> </iframe>

							</div>
						</div>
					</div>
					-->
					<ul class="am-list am-list-static">
				        <li><a class="a1" href="rizhi/toRizhi?userid=${uid}">全部日志</a></li>
					<c:forEach items="${type}" var="t">
						<li><a class="a1" href="rizhi/typeRizhi?userid=${uid}&rizhitype.typeid=${t.typeid}">${t.typename}</a></li>
					</c:forEach>
					</ul>
					</div>
				</div>
					
				</div>
				
			</div>
		</div>
		<!-- 
	</div>
</div> -->
</body>
</html>