<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/amazeui.css">
    <link rel="stylesheet" href="css/admin.css" type="text/css">
    <script src="js/jquery.min.js"></script>
    <script src="js/amazeui.js"></script>

</head>
<body>

<form class="am-form am-form-horizontal" action="rizhi/updatarizhitype" method="post">
  <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">类型名称</label>
    <div class="am-u-sm-10">
      <input type="text" name="typename" id="doc-ipt-3" value="${rzt.typename}" placeholder="输入日志类型名称">
      <input type="hidden" name="timedate" value="${rzt.timedate}">
      <input type="hidden" name="typestatus" value="${rzt.typestatus}">
      <input type="hidden" name="typeid" value="${rzt.typeid}">
      <input type="hidden" name="userid.userid" value="${rzt.userid.userid}">
    </div>
      <p>${cz}</p>
  </div>
    <div class="am-form-group">
    <div class="am-u-sm-10 am-u-sm-offset-2">
      <button type="submit" class="am-btn am-btn-default" onclick="javascript:parent.location.reload();">确定</button>
    </div>
  </div>
  </form>
					
</body>
</html>