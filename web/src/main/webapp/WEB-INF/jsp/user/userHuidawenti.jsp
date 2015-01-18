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
    <title>个人资料->找回密码->回答问题</title>
      <link rel="stylesheet" type="text/css" href="css/amazeui.css">
      <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  
<script language="javascript">   
	function back()   
	{   
		window.history.back();   
	}
</script>

<script type="text/javascript">
	 function message()
	 {
	 	if(window.confirm('您好，确定要重置密码吗?'+'重置后的密码为：123456'))
	 	{
	    	return true;
	    }
	 	else
	 	{
	    	return false;
	    }	
	 }
</script>
  
</head>
<body>
    <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">回答问题</strong> / 
      <small>
      		<c:forEach items="${ user}" var="u">
      			帐号：${u.username}
      		</c:forEach>
      </small></div>

    </div>
    
    <div style="padding-left: 80%;">
			<button type="button" class="am-btn am-btn-default" onclick="back()">返回上一步</button>
	</div>

    <hr>
<c:if test="${not empty plist}">
	<c:forEach items="${plist}" var="p">
    <div class="am-g">
 <form class="am-form am-form-horizontal" action="protection/yanzhen" method="post">
  <div class="am-form-group">
  	<input type="hidden" name="protectionid" value="${p.protectionid}">
	<input type="hidden" name="userid.userid" value="${p.userid.userid}">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">问题1：</label>
    <div class="am-u-sm-10">
      <input type="text"  style="color: blue" name="questionno1" value="${p.questionno1}" readonly="readonly">
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">回答1：</label>
    <div class="am-u-sm-10">
      <input type="text"  placeholder="请输入答案" name="answerno1">
    </div>
  </div>
   <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">问题2：</label>
    <div class="am-u-sm-10">
      <input type="text"  style="color: blue" name="questionno2" value="${p.questionno2 }" readonly="readonly">
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">回答2：</label>
    <div class="am-u-sm-10">
      <input type="text"  placeholder="请输入答案" name="answerno2">
    </div>
  </div>
   <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">问题3：</label>
    <div class="am-u-sm-10">
      <input type="text"  style="color: blue" name="questionno3" value="${p.questionno3 }" readonly="readonly">
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">回答3：</label>
    <div class="am-u-sm-10">
      <input type="text"  placeholder="请输入答案" name="answerno3">
    </div>
  </div>
  
   <div class="am-form-group">
    <div class="am-u-sm-10 am-u-sm-offset-2">
      <button type="submit" class="am-btn am-btn-default">确定</button>
    </div>
  </div>
  <hr>
</form>
</div>
</c:forEach>
</c:if>
<c:if test="${ empty plist}">
    		<h2 style="color: red;">${msg}</h2>
    		<h3>目前可行的方法是：</h3>&nbsp;

		<div align="center">
			<form action="userzh/updatepwd" method="post">
				<c:forEach items="${ user}" var="u">
					<input type="hidden" name="userid" value="${u.userid}">
      				<input type="hidden" name="username" value="${u.username}">
      				<input type="hidden" name="usernickname" value="${u.usernickname}">
      				<input type="hidden" name="usersex" value="${u.usersex}">
      				<input type="hidden" name="userimg" value="${u.userimg}">
      				<input type="hidden" name="usersig" value="${u.usersig}">
      				<input type="hidden" name="userbirthday" value="${u.userbirthday}">
      				<input type="hidden" name="userregisterday" value="${u.userregisterday}">
      				<input type="hidden" name="userarea" value="${u.userarea}">	
      			</c:forEach>
				<input type="submit" class="am-text-primary am-text-lg" name="tijiao" value="重置密码" onclick="return message();">
			</form>
		</div>
</c:if>
    </div>

</body>
</html>


