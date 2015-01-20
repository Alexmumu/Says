<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css"
	href="css/laypage/skin/laypage.css">
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="css/laypage/laypage.js"></script>

<script type="text/javascript">
	$(function() {
		//alert($("#pageSum").val());
		laypage({
			cont : 'page1', //容器。值支持id名、原生dom对象，jquery对象,
			pages : $("#zonggeye").val(), //总页数
			skin : '#AF0000', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
			groups : 5, //连续显示分页数
			jump : function(e) {
				alert(e.curr);
				$("#pageNotb").val(e.curr);
				$("#replayframe").attr("src",
						"Relay/list?" + $("#zhuanfaform").serialize() + "");
			}
		});
		$('#zhuanfaok').click(function(){
			$.ajax({
				url:'Relay/addRelay',
				type:'post',
				data:$('#fabiaoform').serialize(),
				success:function(data){
						alert(data);
				}
			});
		});
	});
</script>

<style type="text/css">
li {
	list-style-type: none
}
</style>

</head>
<body>
	<div class="am-g"
		style="background: #fafafa; border: 1px dashed #ededef;">

		<!--转发内容框-->
		<div class="am-g">
			<form id="fabiaoform"
				action="Relay/addRelay?" method="post">
				<div class="am-u-lg-12" style="height: 100px;">
					<textarea name="relayfor" style="width: 100%; height: 100%; border: 1px solid #A6A6A6;"></textarea>
				</div>
				<div class="am-u-lg-12">
						<c:if test="${mytype==2 }">
						日志你要转载到哪个分类下：
							<select name="alorrtypeId">
									<c:forEach items="${rtypelist}" var="rt">
										<option value="${rt.typeid}">${rt.typename}</option>
									</c:forEach>
							</select>
						</c:if>
						<c:if test="${mytype==3 }">
						相片你要转载到哪个相册下：	<select name="alorrtypeId">
									<c:forEach items="${allist}" var="rt">
										<option value="${rt.albumid}">${rt.albumtitle}</option>
									</c:forEach>
							</select>
				         </c:if>
				</div>
				
				<input type="hidden" name="type" value="${mytype}">
				<input type="hidden" name="relayfrom" value="${mysr.relayfrom}">
				<input type="hidden" name="userid.userid" value="${myuser.userid}">
				<input type="hidden" name="useridare.userid" value="${mysr.useridare.userid}">
			
				<div class="am-u-lg-12 ">
					<button type="button" class="am-btn am-btn-default am-fr"
						style="margin-top: -45px; margin-right: 5px;"
						onclick="javascript:window.parent.location.reload();" id="zhuanfaok">确定</button>
				</div>
			</form>
		</div>
		<!--转发内容框-->

		<!--评论列表-->
		<div class="am-g">
			<iframe scrolling="no" id="replayframe" src="" name="rightF"
				width="100%" height="560px" marginheight="0" marginwidth="0"
				style="margin: 0px; padding: 0px;"> </iframe>

		</div>
	</div>


	<div id="page1"></div>
	<form id="zhuanfaform">
		<input type="hidden" name="relayfrom" value="${mysr.relayfrom}"> 
		<input type="hidden" id="pageNotb" name="pageNo" value="1">

	</form>
	
	
	<form>
		<input type="hidden" id="zonggeye" value="${pageSum}">
	</form>
</body>
</html>