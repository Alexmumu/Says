<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
	<link rel="stylesheet" type="text/css" href="css/laypage/skin/laypage.css">
	<script src="js/jquery.min.js"></script>
  	<script src="js/amazeui.js"></script>
  	<script src="css/laypage/laypage.js"></script>
  
  	<script type="text/javascript">
  	$(function(){
  		//alert($("#pageSum").val());
  			laypage({
		    cont: 'page1', //容器。值支持id名、原生dom对象，jquery对象,
		    pages:  $("#pageSum").val(), //总页数
		    skin: '#AF0000', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
		    groups: 5, //连续显示分页数
		    jump: function(e){
		    	//alert(e.curr);
		    	$("#pageNotb").val(e.curr);
		    	$("#pinlunframe").attr("src","Comments/toComments?"+$("#myform").serialize()+""); 	
				   
		    }
		});
  	});
  	</script>
  	
  	<style type="text/css">
  	li{ list-style-type:none}
  	</style>
  	
</head>
<body>
<div class="am-g" style="background: #fafafa; border:1px dashed #ededef;">

		<!--评论框-->
						

<!--评论列表-->
							     <div class="am-g">
				 <iframe scrolling="no"  id="pinlunframe" src="" name="rightF" width="100%" height="560px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>
				
							     </div>
							</div>
							<form id="myform">
							<input type="hidden" id="pageNotb" name="pageNo" value="2"> 
							
							
							</form>
							<input type="hidden" id="pageSum" value="${pageSum}">
							<div id="page1"></div>
</body>
</html>