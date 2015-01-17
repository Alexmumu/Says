<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="UTF-8">
	<title>Document</title>
	<base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
		<link rel="stylesheet" type="text/css" href="css/laypage/skin/laypage.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.js"></script>
  	 <script src="css/laypage/laypage.js"></script>
  	  	
	<script type="text/javascript">
  	$(function(){
  			
  			laypage({
		    cont: 'page1', //容器。值支持id名、原生dom对象，jquery对象,
		    pages: $("#pageSum").val(),//总页数
		    skin: '#AF0000', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
		    groups: 5, //连续显示分页数
		    jump: function(e){
		    	//alert(e.curr);
		    	var aa=e.curr;
		    	$("#pageNoHidden").val(aa);	
		    	//alert($("#myform").serialize());
		    	$("#neirongframe").attr("src","Leavword/toLeavwordneirong?"+$("#myform").serialize()+"");
		    	
		    }
		});
  			$("#lyjy").mouseout(function(){
  				$(this).css("border","0px dashed #000");
  			});
  			$("#lyjy").mouseover(function(){
  				$(this).css("border","1px dashed #000");
  			});
				$("#lyjy").click(function(){
						var tds = $(this).text();
						//alert(tds);
					
						$("#lyjyinout").val(tds);
						$("#lyjyinout").show();
						$("#lyjy").hide();
						$("#updateuserword").show();
				});
  	});
  	</script>
</head>
<body>
<div class="am-panel am-panel-default">
  <div class="am-panel-hd" >留言寄语</div>
  <div class="am-panel-bd" style=" text-align:center; " >
  	<span id="lyjy">${userword.userwordcontent}</span>
  	<form action="Leavword/updateUserWord" method="post">
  	<input  type="text" value="${userword.userwordid}" name="userwordid" style="display: none;" />	
  	<input  type="text" value="${userword.userid.userid}" name="userid.userid" style="display: none;" />
  	<input size="100%;" height="40px;" type="text" id="lyjyinout" name="userwordcontent" value="" style="display: none;"/>
  	<input style="display: none; width:50px; height:27px; line-height:10px; font-size:12px; margin-left: -55px;"  type="submit" id="updateuserword" class="am-btn am-btn-primary" value="编辑"/>
 	</form>
  </div>
</div>

<div class="am-panel am-panel-default">
  <div class="am-panel-hd" >留言板</div>
	
	  <div class="am-panel-bd" style=" text-align:center;  ">

	 <iframe scrolling="no"  id="neirongframe" src="" name="rightF" width="100%" height="560px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>

	</div>
</div>
	<form id="myform">
		<input type="hidden" name="userid.userid" value="${userword.userid.userid}">
		<input type="hidden" name="levewodidstatus" value="1">
		<input id="pageNoHidden" type="hidden" name="pageNo" >	
	</form>
	<input type="hidden" id="pageSum" value="${pageSum}">

<div id="page1"></div>
		<a style="display:none;  " id="dijiye"></a>				
</body>
</html>