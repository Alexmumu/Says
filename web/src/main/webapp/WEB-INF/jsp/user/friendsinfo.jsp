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
	<title>个人资料->好友个人资料</title>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">好友个人资料</strong> / <small>Personal information</small></div>
    </div>
<c:forEach items="${ufid}" var="uf">
	<div style="padding-left: 11%;">
			<p class="am-text-primary am-text-lg">"${uf.username}"的个人资料</p>
<%-- 			<c:forEach items="${ hh}" var="h"> --%>
<%--       			帐号：${h.username} --%>
<%--       		</c:forEach> --%>
	</div>
		
    <hr>

    <div class="am-g">
	
      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="am-g">
              <div class="am-u-md-4">
                 <a href="user/myhome?userid=${uf.userid}"target="view_window"><img src="images/${uf.userimg}" alt="${uf.username}"></a>

              </div>
              <div class="am-u-md-8">
               
                <form class="am-form" action="user/userupdate" method="post">
                  <div class="am-form-group">
                   
                    
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <div class="user-info">
              <p>等级信息</p>
              <div class="am-progress am-progress-sm">
                <div class="am-progress-bar" style="width: 60%"></div>
              </div>
              <p class="user-info-order">当前等级：<strong>LV8</strong> 活跃天数：<strong>587</strong> 距离下一级别：<strong>160</strong></p>
            </div>
            <div class="user-info">
              <p>信用信息</p>
              <div class="am-progress am-progress-sm">
                <div class="am-progress-bar am-progress-bar-success" style="width: 80%"></div>
              </div>
              <p class="user-info-order">信用等级：正常当前 信用积分：<strong>80</strong></p>
            </div>
          </div>
        </div>

      </div>

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
      
        <form class="am-form am-form-horizontal" action="user/userupdate" method="post">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">昵称/ Name</label>
            <div class="am-u-sm-9">
            	<input type="text" id="user-name" name="usernickname" readonly="readonly" placeholder="${uf.usernickname}">
             
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">性别 / Sex</label>
            <div class="am-u-sm-9">
            	<c:if test="${uf.usersex =='0'}">
              		<input type="text" id="user-name"name="usernickname" readonly="readonly" placeholder="男">
				</c:if>
				<c:if test="${uf.usersex =='1'}">
              		<input type="text" id="user-name"  name="usernickname" readonly="readonly" placeholder="女">
				</c:if>
            </div>
          </div>

          <div class="am-form-group" style="margin: 0px; padding: 0px;">
            <label for="user-phone" class="am-u-sm-3 am-form-label">出生年月 / Birthday</label>
            <div class="am-u-sm-9">
           <input type="text" id="user-name" name="usernickname" readonly="readonly" placeholder="${uf.userbirthday }">

            </div>
          </div>

          <div class="am-form-group">
            <label for="user-QQ" class="am-u-sm-3 am-form-label">所在地/ location</label>
            <div class="am-u-sm-9" style="float: left;">
            	<input type="text" id="user-name" name="usernickname" readonly="readonly" placeholder="${uf.userarea }">

            </div>
          </div>

          <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">个人简介 / Intro</label>
            <div class="am-u-sm-9">
              <textarea class="" rows="4" id="user-intro" name="usersig" placeholder="${uf.usersig }" readonly="readonly"></textarea>
              
            </div>
          </div>
        </form>
        
        <div align="center">
          <a href="friends/findallfriends?userid=${myuser.userid}"><button class="am-btn am-btn-default ">返回</button></a></div>
      </div>
    </div>
    </c:forEach>
  </div>
</body>
</html>