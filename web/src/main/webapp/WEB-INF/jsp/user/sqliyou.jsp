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
  <title>个人资料->查找好友->申请理由</title>
    <link rel="stylesheet" type="text/css" href="css/amazeui.css">
    <link rel="stylesheet" href="css/admin.css" type="text/css">
<script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  
<script type="text/javascript">
	 function message()
	 {
		 var uname = document.d1.shenqiliyou.value;
			if(uname.length==0){
				alert("申请理由不能为空");
				return false;
			}	
	 }
</script>
  
</head>
<body>
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"><h1>申请添加${bsquser.username}为好友</h1></strong> / <small>Security question</small></div>

    </div>

    <hr>

    <div class="am-g">
    
	 <form class="am-form am-form-horizontal" onsubmit="return message()" name="d1" action="friends/addfrequest" method="post" >
	    <label>申请理由</label>
	    <input type="text" name="shenqiliyou">
	    <input type="text" name="fruserare.userid" value="${bsquser.userid}">
		<input type="text" name="fruser.userid" value="U004">
	    <input type="submit" class="am-btn am-btn-success" value="确定">
	</form>
    </div>
</div>

</body>
</html>