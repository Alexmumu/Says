<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关于我的管理-想说网</title>
   <base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<link rel="stylesheet" type="text/css" href="css/admin.css">
 <script src="js/jquery.min.js"></script>
 <script src="js/amazeui.js"></script>
<script type="text/javascript">
	function tiaozhuan(url){
		$('#mainframe').attr('src',url);
		
	}
</script> 
 
</head>
<body>
	<!-- 导入头部文件jsp -->
	<%@include file="/WEB-INF/jsp/top.jsp"%>
	<!-- 导入结束 -->
	<div class="am-g">
    <div class="am-u-lg-3">
      <div  class="am-cf admin-main" >
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a ><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 个人资料<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="javascript:;" onclick="tiaozhuan('user/finduser?userid=${myuser.userid}')"   class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>

          <li><a href="javascript:;" onclick="tiaozhuan('protection/findidprotection?userid.userid=${myuser.userid}')"><span class="am-icon-bug"></span>密保问题</a></li>
        </ul>
      </li>
   
            <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-users"></span> 好友管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
          <li><a href="javascript:;" onclick="tiaozhuan('friends/findallfriends?userid=${myuser.userid}')" class="am-cf"><span class="am-icon-male"></span> 我的好友</span></a></li>

          <li><a href="javascript:;" onclick="tiaozhuan('finduser/findfriend')" ><span class="am-icon-search"></span>好友查找</a></li>
          
          <li><a href="javascript:;" onclick="tiaozhuan('finduser/findfriend')" ><span class="am-icon-search"></span>已发出的申请</a></li>
        </ul>
      </li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span>所属用户</p>
        <p>--> ${myuser.username}</p>
      </div>
    </div>
  </div>
</div>
    </div>
    <div class="am-u-lg-9">
	    <c:if test="${type==1}">
	    	<iframe src="friends/findallfriends?userid=${myuser.userid}"  id="mainframe" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;" width="100%" height="720">
	  		</iframe> 
	    </c:if>
	    <c:if test="${type==2}">
	    	<iframe src="user/finduser?userid=${myuser.userid}"  id="mainframe" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;" width="100%" height="720">
	  		</iframe> 
	   </c:if>
    </div>
</div>
	
</body>
</html>