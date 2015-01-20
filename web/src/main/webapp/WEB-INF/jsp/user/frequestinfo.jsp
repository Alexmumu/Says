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
	<title>个人资料->申请记录</title>
		<link rel="stylesheet" type="text/css" href="css/amazeui.css">
				<link rel="stylesheet" href="css/admin.css" type="text/css">

		  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
   <script src="js/jquery.provincesCity.js" type="text/javascript"></script>
  <script src="js/provincesdata.js" type="text/javascript"></script>

  
</head>
<body>
	<div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">申请记录资料</strong> / <small>Personal information</small></div>
    </div>
	
	<table  class="am-table am-table-striped am-table-hover">
	
		<c:if test="${empty msg}">
	<c:if test="${not empty page}">
    	<thead>
        	<tr>
	            <th>被申请人</th>
	            <th>申请理由</th>
	            <th>申请时间</th>
	            <th>申请状态</th>
       		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${page}" var="p">
	        <tr>
	            <td>${p.fruserare.username}</td>
		        <c:if test="${p.shenqiliyou==null}">
		          <td>无</td>
		        </c:if>
		        <c:if test="${p.shenqiliyou!=null}">
		          <td>${p.shenqiliyou}</td>
		        </c:if>
	            <td>${p.frtime}</td>
	            <c:if test="${p.frstatus==1}">
		            <td>申请已发出</td>
		        </c:if>
		        <c:if test="${p.frstatus==2}">
		            <td>申请已同意</td>
		        </c:if>
		        <c:if test="${p.frstatus==3}">
		            <td>申请已被拒绝</td>
		        </c:if>
	            
<%-- 	            <td><a href="frequest/deletedfrequest?frid=${p.frid}">删除记录</a></td> --%>
	        </tr>
	        </c:forEach>
   		</tbody>
   		</c:if>
   		<c:if test="${empty page}">
   			<p>木有记录信息!</p>
   		</c:if>
   		</c:if>
   		<c:if test="${not empty msg}">
   			<p>${msg }</p>
   		</c:if>
	</table>
	
  </div>
</body>
</html>