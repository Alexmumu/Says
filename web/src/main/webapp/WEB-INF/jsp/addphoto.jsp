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
 
<title>上传照片</title>
 
</head>
<body>
     	
<form class="am-form am-form-horizontal" action="photo/addPhoto" method="post"  enctype="multipart/form-data">

   <input type="hidden" value="${album.albumid}" name="albumid.albumid">
   <div class="am-form-group">
    <label for="doc-ipt-3" class="am-u-sm-4 am-form-label">上传图片到
    <strong style="color: #0e90d2"> ${album.albumtitle }</strong>
    </label>
   </div>
   <div style="width: 550px;height:400px;margin-left: auto;margin-right: auto; border:solid 1px #C5C1AA ;">
   
       <c:forEach begin="1" end="5">
         <div id="up" style="padding-top: 10px;">
             <input type="file" name="myphoto">
         </div>    
       </c:forEach>
   
   

   </div>
   <div class="am-form-group" style="margin-top: 10px;margin-right: 50px; float: right;">
       <div >
            <button type="submit" class="am-btn am-btn-default" style="background:#0e90d2 " onclick="javascript:parent.location.reload();">确定</button>
           <button type="submit" class="am-btn am-btn-default">取消</button>
       </div>
  </div>

 
   
	</form>
 
</body>
</html>