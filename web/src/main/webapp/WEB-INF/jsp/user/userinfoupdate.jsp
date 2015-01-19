<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html lang="en">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<meta charset="UTF-8">
	 <base href="<%=basePath%>">
	<title>个人资料->修改个人资料</title>
		<link rel="stylesheet" type="text/css" href="css/amazeui.css">
				<link rel="stylesheet" href="css/admin.css" type="text/css">

		  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
   <script src="js/jquery.provincesCity.js" type="text/javascript"></script>
  <script src="js/provincesdata.js" type="text/javascript"></script>
  
  <script type="text/javascript">
  	$(function(){
  		$("#dizhi").ProvinceCity();
  	})
  </script>
  
</head>
<body>
	<div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>Personal information</small></div>
    </div>

	<div style="padding-left: 11%;">
			<p class="am-text-primary am-text-lg">修改个人资料</p>
	</div>
		
    <hr>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="am-g">
              <div class="am-u-md-4">
                <img class="am-img-circle am-img-thumbnail" src="images/touxiang/${myuser.userid}.jpg" alt="">
              </div>
              <div class="am-u-md-7">
                <p>你可以使用<a href="">gravatar.com</a>提供的头像或者使用本地上传头像。 </p>
               
                <form class="am-form" action="user/updatetouxiang" method="post"  enctype="multipart/form-data" >
                  <div class="am-form-group">
                    <input type="file" name="tximg" id="user-pic">
                    <p class="am-form-help">请选择要上传的文件...</p>
                    <button type="sublime" class="am-btn am-btn-primary am-btn-xs">保存</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
           <div class="user-info">
               <h3>安全等级: 一般</h3>
               <h3 align="center">${msg}</h3>
               
<%--                	<c:if test="${uplist==null}"> --%>
<!--               		 <a href="protection/toprotection"><button type="button" class="am-btn am-btn-primary am-btn-block">添加密保</button></a> -->
<!--              		  <p>安全等级：</p> -->
              		<div class="am-progress am-progress-sm">
                		<div class="am-progress-bar am-progress-bar-success" style="width: 30%"></div>
           			</div>   			
<%--            		</c:if> --%>
<%--            		<c:if test="${uplist!=null}"> --%>
<!--            			 <a href="protection/findidprotection?userid.userid=U004"><button type="button" class="am-btn am-btn-primary am-btn-block">修改密保</button></a> -->
<%--            		</c:if> --%>
<%--            		<c:forEach items="${uinfo}" var="uf"> --%>
<%--            			<a href="protection/findidprotection?userid.userid=${uf.userid }"><button type="button" class="am-btn am-btn-primary am-btn-block">修改密码</button></a> --%>
<%--             	</c:forEach> --%>
            </div>
          </div>
        </div>

      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
      	${msg }
        <form class="am-form am-form-horizontal" action="user/finduserupdate" method="post">
        	<c:forEach items="${uinfo}" var="h">
        		<input type="hidden" name="userid" value="${h.userid}">
        		<input type="hidden" name="username" value="${h.username}">
        		<input type="hidden" name="userpassword" value="${h.userpassword}">
        		<input type="hidden" name="userimg" value="${h.userimg}">
        		<input type="hidden" name="userregisterday" value="${h.userregisterday}">
        	
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">昵称/ Name</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name" name="usernickname" value="${h.usernickname}">
              <small>输入你的昵称，让我们记住你。</small>
            </div>
          </div>

          <div class="am-form-group">
            <label  class="am-u-sm-3 am-form-label">性别 / Sex</label>
            <div class="am-u-sm-9">
            <c:if test="${h.usersex==0}">
              	<input type="radio" name="usersex" value="${h.usersex}" size="8px;" checked>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<input type="radio" name="usersex" value="${h.usersex}" size="8px;">女<br>
            </c:if>
            <c:if test="${h.usersex==1}">
                <input type="radio" name="usersex" value="${h.usersex}" size="8px;">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<input type="radio" name="usersex" value="${h.usersex}" size="8px;"  checked>女<br>
             </c:if>
              <small>性别你懂得...</small>
            </div>
          </div>

       	 <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label">出生年月/ birthday</label>
            <div class="am-u-sm-9" style="float: left;">
			<!-- <div id="dizhi"></div>	 -->
			<input type="text" name="userbirthday" value="${h.userbirthday}" >
            </div>
          </div>

          <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label">所在地/ location</label>
            <div class="am-u-sm-9" style="float: left;">
			<!-- <div id="dizhi"></div>	 -->
			<input type="text" name="userarea" value="${h.userarea}">
            </div>
          </div>

          <div class="am-form-group">
            <label  class="am-u-sm-3 am-form-label">个人简介 / Intro</label>
            <div class="am-u-sm-9">
              <input type="text" name="usersig" value="${h.usersig}" maxlength="50px;">
              <small>50字以内写出你的一生...</small>
            </div>
          </div>

          <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="submit" class="am-btn am-btn-primary">保存修改</button>
            </div>
          </div>
          </c:forEach>
        </form>
        
        
      </div>
    </div>
  </div>
</body>
</html>