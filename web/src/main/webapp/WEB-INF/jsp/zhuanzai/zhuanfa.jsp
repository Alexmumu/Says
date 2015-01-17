<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.js"></script>
</head>

<body>
	<div style="text-align:center;">	
						</div>
								<form action="Relay/addRelayshuoshuo" method="post">
								<div class="am-g">
							     <div class="am-u-lg-12">
								    <input type="text" value="${Relay.useridare.userid}" name="useridare.userid">
								     <input type="text" value="${Relay.relayfrom }" name="relayfrom">
								    
								     <textarea name="relayfor" style="width:100%";  id="doc-vld-name-2" minlength="3" placeholder="输入转载内容" required="" class="am-field-error am-active"></textarea>
							     </div>
							     </div>

							     <div class="am-g">
							     	 <div class="am-u-lg-12 ">
							     	 <button type="submit" class="am-btn am-btn-default am-fr" >确定</button>
							     	 </div>
							     </div>
							 
							</form>
								 
	
</html>