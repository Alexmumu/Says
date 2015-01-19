<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
   <meta charset="utf-8">
   <base href="<%=basePath%>">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="css/amazeui.css">
  <link rel="stylesheet" type="text/css" href="css/album.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  <script src="js/laypage.js"></script>
   <script src="js/album/album.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     	
<form class="am-form am-form-horizontal" action="album/updateAlbum" method="post"  enctype="multipart/form-data">
  <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">相册标题</label>
    <div class="am-u-sm-10">
      <input type="text" id="doc-ipt-3" value="${album. albumtitle}" name="albumtitle">
      <span></span>
    </div>
  </div>
  
    <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">相册描述</label>
    <div class="am-u-sm-10">
      <textarea id="doc-ipt-3"  name="albumremark" >${album.albumremark }</textarea>
    </div>
  </div>
  
    <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-2 am-form-label">相册封面</label>
    <div class="am-u-sm-10">
      <img alt="" src="images/albumimg/${album. albumtopimg}" style="width: 150px;height:200px; ">
      <input type="file" id="doc-ipt-3" name="img">
      <input type="hidden" value="${album. albumtopimg}" name="albumtopimg">
    </div>
  </div>
  
      
      <input type="hidden" id="doc-ipt-3" value="${album.albumid}" name="albumid">
 
    <div class="am-form-group">
    <div class="am-u-sm-10 am-u-sm-offset-2">
      <button type="submit" class="am-btn am-btn-default" onclick="javascript:parent.location.reload();">确定</button>
       <button type="submit" class="am-btn am-btn-default">取消</button>
    </div>
  </div>
 
 
	</form>
 
</body>
</html>