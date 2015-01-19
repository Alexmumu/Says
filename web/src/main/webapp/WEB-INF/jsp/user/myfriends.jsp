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
  <title>好友管理->我的好友</title>
  <link rel="stylesheet" type="text/css" href="css/amazeui.css">
  <link rel="stylesheet" href="css/admin.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="css/haoyou.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
</head>
<body>
  <div class="admin-content">
    <div class="am-cf am-padding">
    	
      <div class="am-fl am-cf"> <strong class="am-text-primary am-text-lg">我的好友</strong>
        /
        <small>Security question</small>
      </div>
      	
<!--       <div class="am-fr am-cf"> -->
<%--       	  <button class="am-btn am-btn-default " ><a href="friends/finduserid?userid=${u.userid}">添加好友</a></button> --%>
<!--   </div> -->
  
<!--   	<form action="friends/findallfriends" method="post" style="float: right;"> -->
<!--          		<input type="hidden" name="userid" value="U004"> -->
<!--          		<input type="submit" class="am-btn am-btn-default " value="我的好友"> -->
<!--     </form> -->
  
	</div>
      </div>

    <hr>

	<c:if test="${not empty list}">
      		<p>您还木有好友，去查找哦！</p>
     </c:if>
    <div class="am-g am-container am-text-centere">
      <ul class="am-avg-sm-2 am-avg-md-5 am-avg-lg-4 am-thumbnails" id="haoyou">
      	${msg }
            <c:forEach items="${page.result}" var="p">
              <li>
          <div id="hyneirong">
            <a href="friends/deletedfriends?friendid=${p.friendid}" class="am-close am-close-alt am-close-spin">&times;</a>
          <div class="am-g">
            <div class="am-u-md-12 am-text-center ">
              <a href="friends/finduserfriendid?userfriendid=${p.userfriendid.userid}">
                <img src="images/${p.userfriendid.userimg}" width="64" height="64"></a>
              <br>        
             	${p.userfriendid.username}
             	<c:if test="${p.userfriendid.usersex=='0'}">
						<td>帅哥</i></td>
				</c:if>
				<c:if test="${p.userfriendid.usersex=='1'}">
						<td>美女</td>
				</c:if>
              <br>${p.friendstime}</div>
          </div>
          </div>
        </li>
          </c:forEach>
      
      </ul>
    </div>
  </div>
</body>
  </html>


