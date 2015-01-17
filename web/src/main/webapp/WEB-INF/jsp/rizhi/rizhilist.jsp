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

</head>
<body>
	<div class="am-g">
		<div class="am-u-lg-8">
			<div class="am-panel am-panel-default">
				<div class="am-panel-hd">日志列表<span style="float: right;">日志数量：${page.dataSum}</span></div>
			<c:if test="${uid=='U001'}">
				<div style="margin-left: 30px; margin-top: 12px"><a class="am-btn am-btn-default  am-radius" href="rizhi/toaddrizhi">T写日志</a></div>
			<hr>
			</c:if>
			
				<table class="am-table">
				<c:if test="${page.dataSum==0}" ><tr><td>您在这个分类下还没有保存日志，<a href="rizhi/toaddrizhi">立刻添加一篇，与朋友分享您的生活吧。</a></td></tr></c:if>
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
                                 <a href="rizhi/getRizhiid?rizhiid=${rz.rizhiid}">${rz.rizhititle}</a>
					   </span>
				  </td>
				  <td>
			              类型: <span> ${rz.rizhitype.typename} </span> 
				  </td>
				  <td>
			              发表时间: <span> ${rz.rizhidate} </span> 
				  </td>
				  <td>
				    <c:if test="${rz.rizhiuserid.userid=='U001'}">
						        <span >
						        <a class="am-btn am-btn-default am-round am-btn-lg" href="rizhi/toupdatarizhi?rizhiid=${rz.rizhiid}&rizhiuserid.userid=${rz.rizhiuserid.userid}">编辑</a>
						        
						        <a  href="rizhi/deleterizhibyid?rizhiid=${rz.rizhiid}&rizhiuserid.userid=${rz.rizhiuserid.userid}"><i class="am-icon-trash am-icon-btn am-icon-twitter"></i></a>
						        </span>
		           </c:if>
				  </td>
				</tr>
				</c:forEach>
				</c:if>
				</table>
			</div>

			<div id="page1">
				<ul class="am-pagination am-pagination-centered ">
					<c:if test="${page.pageNo<=1}">
						<li class="am-pagination am-disabled"><a
							href="rizhi/${rz}Rizhi?userid=U001&pageNo=${page.pageNo-1}&rizhitype.typeid=${typeid}">&laquo;
								上一页</a>
					</c:if>
					<c:if test="${page.pageNo>1}">
						<li class="am-pagination"><a
							href="rizhi/${rz}Rizhi?userid=U001&pageNo=${page.pageNo-1}&rizhitype.typeid=${typeid}">&laquo;
								上一页</a>
					</c:if>
					<c:if test="${page.pageNo==page.pageSum}">
						<li class="am-pagination am-disabled"><a
							href="rizhi/${rz}Rizhi?userid=U001&pageNo=${page.pageNo+1}&rizhitype.typeid=${typeid}">下一页
								&raquo;</a>
					</c:if>
					<c:if test="${page.pageNo!=page.pageSum}">
						<li class="am-pagination"><a
							href="rizhi/${rz}Rizhi?userid=U001&pageNo=${page.pageNo+1}&rizhitype.typeid=${typeid}">下一页
								&raquo;</a>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="am-u-lg-4" >
			<div class="am-panel am-panel-default">
				<div class="am-panel-hd">
					日志类型
					<!--判断是否是用户本人-->
					<c:if test="${uid=='U001'}">
					<button data-am-modal="{target: '#my-popup'}" 
					class=" am-icon-wrench am-fr">管理</button>
                   </c:if>
					<!--日志管理弹窗-->
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
				</div>
				<ul class="am-list am-list-static am-list-border am-list-striped">
				        <li><a class="a1" href="rizhi/toRizhi?userid=U001">全部日志</a></li>
					<c:forEach items="${type}" var="t">
						<li><a class="a1" href="rizhi/typeRizhi?userid=${t.userid.userid}&rizhitype.typeid=${t.typeid}">${t.typename}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>