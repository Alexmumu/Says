<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!doctype html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>个人资料->找回密码->输入账号</title>
      <link rel="stylesheet" type="text/css" href="css/amazeui.css">
      <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
</head>
 
<body>
    <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">输入账号</strong> / <small>Security question</small></div>
    </div>

    <hr>
    
    <div class="am-g">
		 <form action="userzh/findbyusername" method="post" class="am-form am-form-horizontal">
		    <label>输入帐号</label><p style="color: red; font-size: 20px;">${msg}</p>
		    <input type="text" name="username"/>
		    <br>
		    <button class="am-btn am-btn-success">确定</button>
		</form>
    </div>
</div>
</body>
</html>


