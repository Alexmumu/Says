<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">

        <script src="js/jquery.min.js"></script>
        <script src="js/amazeui.js"></script>
        <script src="laypage/laypage.js"></script>
</head>
<script type="text/javascript">
$(function() {
   
	$("#bianji").click(function(){	
		 alert("我被点了 ！");
    });
	
	});



</script>
<body>
		
		<form class="am-form am-form-horizontal" action="rizhi/addrizhitype" method="post">
  <div class="am-form-group">
    <label for="doc-ipt-3"  class="am-u-sm-2 am-form-label">添加类型:</label>
    <div class="am-u-sm-10">
      <input type="text" name="typename"  class="am-form-field am-radius" placeholder="输入日志类型名称">
      <input type="hidden" name="userid.userid" value="${myuser.userid}">
      <p>${cz}</p>
    </div>
  </div>
    <div class="am-form-group">
    <div class="am-u-sm-10 am-u-sm-offset-2">
      <button type="submit" class="am-btn">确定</button>
      
    </div>
  </div>
	</form>

	<table class="am-table">
    <thead>
        <tr>
            <th>日志类型</th>
            <th>添加时间</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${type}" var="t">
        <tr>
            <td>${t.typename}</td>
            <td>${t.timedate}</td>
            <td>
            <c:if test="${t.typestatus==1}">
            <button class="am-btn am-btn-default am-round am-btn-lg" data-am-modal="{target: '#my-popup2${t.typeid}'}">编辑</button>
            <a href="rizhi/deleterizhitype?userid.userid=${t.userid.userid}&typeid=${t.typeid}"><i class="am-icon-trash am-icon-btn am-icon-twitter"></i></a>  
              <div class="am-popup" id="my-popup2${t.typeid}">
                <div class="am-popup-inner">
                    <div class="am-popup-hd">
                       <h4 class="am-popup-title" id="bianji" >编辑类型</h4>
                       <span data-am-modal-close class="am-close am-close-alt am-close-spin am-icon-times"></span>
                    </div>
                <div class="am-popup-bd">
                <iframe src="rizhi/getRizhitypeid?typeid=${t.typeid}"  width="600px" height="300px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>
            </div>
    </div>
</div>
             </c:if>
             <c:if test="${t.typestatus==2}">
             <h4 class="am-popup-title">默认类型</h4>
             </c:if>
           
 
            </td>
           
        </tr>
        </c:forEach>
    </tbody>
</table>


</body>
</html>