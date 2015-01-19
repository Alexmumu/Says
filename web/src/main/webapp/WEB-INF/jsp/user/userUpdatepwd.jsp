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
    <title>个人资料->找回密码->修改密码</title>
      <link rel="stylesheet" type="text/css" href="css/amazeui.css">
      <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  
<script type="text/javascript">
	 function message()
	 {
		 var upwd = document.up.userpassword.value;
			if(upwd.length==0){
				alert("输入密码不能为空");
				return false;
			} 
	 }
</script>
  
  
  
</head>
 
<body>
    <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改密码</strong> / <small>Security question</small></div>
    </div>

    <hr>

    <div class="am-g">
		 <form  class="am-form am-form-horizontal" action="protection/updatepwd2" method="post" onsubmit="return message()" name="up">
		    <label>输入新密码</label>
		    <input type="text"  name="userpassword"/>
		    
		    <br>
		    <button class="am-btn am-btn-success">确定</button>
		    <c:forEach items="${ uinfo}" var="uf">
					<input type="hidden" name="userid" value="${uf.userid}">
      				<input type="hidden" name="username" value="${uf.username}">
      				<input type="hidden" name="usernickname" value="${uf.usernickname}">
      				<input type="hidden" name="usersex" value="${uf.usersex}">
      				<input type="hidden" name="userimg" value="${uf.userimg}">
      				<input type="hidden" name="usersig" value="${uf.usersig}">
      				<input type="hidden" name="userbirthday" value="${uf.userbirthday}">
      				<input type="hidden" name="userregisterday" value="${uf.userregisterday}">
      				<input type="hidden" name="userarea" value="${uf.userarea}">	
      		</c:forEach>
		</form>
    </div>
    
		
</div>
</body>
</html>


