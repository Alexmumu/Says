<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <base href="<%=basePath%>">
  <title>个人资料->添加密码保护</title>
    <link rel="stylesheet" type="text/css" href="css/amazeui.css">
    <link rel="stylesheet" href="css/admin.css" type="text/css">
<script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  
<script type="text/javascript">
	 function message()
	 {
		 var un1 = document.aq.questionno1.value;
		 var un2 = document.aq.answerno1.value;
		 var un3 = document.aq.questionno2.value;
		 var un4 = document.aq.answerno2.value;
		 var un5 = document.aq.questionno3.value;
		 var un6 = document.aq.answerno3.value;
		 
			if(un1.length==0){
				alert("问题1不能为空");
				return false;
			}
			if(un2.length==0){
				alert("答案1不能为空");
				return false;
			} 
			if(un3.length==0){
				alert("问题2不能为空");
				return false;
			} 
			if(un4.length==0){
				alert("答案2不能为空");
				return false;
			} 
			if(un5.length==0){
				alert("问题3不能为空");
				return false;
			} 
			if(un6.length==0){
				alert("答案3不能为空");
				return false;
			} 
	 }
</script>
  
  
  
  
</head>
<body>
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">密保问题管理</strong> / <small>Security question</small></div>

    </div>
    	<div style="padding-left: 11%; margin-top: 1%;">
			<p class="am-text-primary am-text-lg">添加密保</p>
		</div>
    		 
    <hr>

    <div class="am-g">
 <form action="protection/protectionadd" method="post" class="am-form am-form-horizontal" name="aq">
 	
					<input type="hidden" name="userid.userid" value="${myuser.userid }">
     
  <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">问题1：</label>
    <div class="am-u-sm-10">
      <input type="text" id="doc-ipt-2" name="questionno1" placeholder="输入你的个性问题1">
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">回答1：</label>
    <div class="am-u-sm-10">
      <input type="text" id="doc-ipt-pwd-2" name="answerno1" placeholder="设置答案">
    </div>
  </div>
   <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">问题2：</label>
    <div class="am-u-sm-10">
      <input type="text" id="doc-ipt-2" name="questionno2" placeholder="输入你的个性问题2">
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">回答2：</label>
    <div class="am-u-sm-10">
      <input type="text" id="doc-ipt-pwd-2" name="answerno2" placeholder="设置答案">
    </div>
  </div>
   <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">问题3：</label>
    <div class="am-u-sm-10">
      <input type="text" id="doc-ipt-2" name="questionno3" placeholder="输入你的个性问题3">
    </div>
  </div>

  <div class="am-form-group">
    <label for="doc-ipt-pwd-2" class="am-u-sm-2 am-form-label">回答3：</label>
    <div class="am-u-sm-10">
      <input type="text" id="doc-ipt-pwd-2" name="answerno3" placeholder="设置答案">
    </div>
  </div>


  <div class="am-form-group">
    <div class="am-u-sm-10 am-u-sm-offset-2">
      <button type="submit" class="am-btn am-btn-default" onclick="return message()">确定</button><br>
    </div>
  </div>
</form>
    </div>
</div>

</body>
</html>