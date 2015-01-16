<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
   <meta charset="utf-8">
   <base href="<%=basePath%>">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="css/amazeui.css">
  <link rel="stylesheet" type="text/css" href="css/album.css">
   <link rel="stylesheet" type="text/css" href="css/laypage.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
  <script src="js/laypage.js"></script>
  <script src="js/album/album.js"></script>
  
  <script type="text/javascript">
    $(function(){
    	  //$("#update").attr({ src: ""});
    	  $(".am-icon-edit am-icon-md").click(function(){
    		  //alert("修改");
    		  //$("#update").attr({ src: "album/getAlbumbyAlbumid?albumid=${a.albumid}"}); 
    	  });
    	  $("#shanchu").click(function(){
    		alert("要删除我？");
    	  });
    	
    })
  
  </script>
</head>


<body>
<div class="am-panel am-panel-default">
  <div class="am-panel-hd">相册
  
  <a href="javascripg:void(0)" data-am-modal="{target: '#my-album'}" c class=" am-icon-wrench am-fr">创建相册</a>
  </div>
  
  <div class="am-panel-bd">
  <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-4 am-avg-lg-5 am-gallery-bordered" data-am-gallery="{  }">
     <c:forEach items="${page.result}" var="a">
   <li>
    <div class="am-gallery-item">
        <img id="img" src="images/albumimg/${a.albumtopimg}"
        alt="${a.albumremark }" />
           <div class="bianji" style="position: absolute;  margin-top:-30px;color:#fff;float:right;
          margin-left:130px;width:70px;">
                <c:if test="${a.albumstatus==2 }">
                 <a href="javascripg:void(0)" data-am-modal="{target: '#update-album'}" class="am-icon-edit am-icon-md" style="display: none;"></a>
                 <a href="javascripg:void(0)" class="am-icon-trash am-icon-md" style="display: none;"></a>
                </c:if>
             
                 <c:if test="${a.albumstatus!=2 }">
                 <a href="javascripg:void(0)"class="am-icon-edit am-icon-md" 
                 data-am-modal="{target: '#my-popup2${a.albumid}'}" ></a>
                 
                 <a href="album/delectAlbum?albumid=${a.albumid}" 
                 class="am-icon-trash am-icon-md" id="shanchu"></a>
                </c:if>
          </div>
        <h3 class="am-gallery-title"><a href="photo/listphoto?albumid=${a.albumid}&pageNo=1">${a.albumtitle}</a></h3>
        <div class="am-gallery-desc">${a.albumdate}</div>
        
    </div>
  </li>
  
  
  
     <!--修改弹窗-->
  <div class="am-popup" id="my-popup2${a.albumid}" style="display: none; height: 400px; ">
    <div class="am-popup-inner">
      <div class="am-popup-hd">
        <h4 class="am-popup-title">修改相册</h4>
        <span data-am-modal-close="" class="am-close">×</span>
      </div>
      <div class="am-popup-bd">

         <iframe src="album/getAlbumbyAlbumid?albumid=${a.albumid}" name="rightF" width="600px" height="350px" marginheight="0" marginwidth="0"  style="margin: 0px; padding: 0px" id="update"> </iframe>

  </div>
  </div>
  </div>
  
  
  </c:forEach>
  </ul>
<ul class="am-pagination am-pagination-centered ">
	<c:if test="${page.pageNo<=1}">
  	<li class="am-pagination am-disabled"><a href="album/listalbum?userid=U001&albumstatus=0&pageNo=${page.pageNo-1}">&laquo; 上一页</a></li>
  </c:if>
  <c:if test="${page.pageNo>1}">
  	<li class="am-pagination"><a href="album/listalbum?userid=U001&albumstatus=0&pageNo=${page.pageNo-1}">&laquo; 上一页</a></li>
  </c:if>
  <c:if test="${page.pageNo==page.pageSum}">
  <li class="am-pagination am-disabled"><a href="album/listalbum?userid=U001&albumstatus=0&pageNo=${page.pageNo+1}">下一页 &raquo;</a></li>
  </c:if>
  <c:if test="${page.pageNo!=page.pageSum}">
  <li class="am-pagination"><a href="album/listalbum?userid=U001&albumstatus=0&pageNo=${page.pageNo+1}">下一页 &raquo;</a></li>
  </c:if>
</ul>
 </div>
 </div>
 <!--添加弹窗-->
  <div class="am-popup" id="my-album" style="display: none; height: 400px; ">
    <div class="am-popup-inner">
      <div class="am-popup-hd">
        <h4 class="am-popup-title">创建相册</h4>
        <span data-am-modal-close="" class="am-close">×</span>
      </div>
      <div class="am-popup-bd">

         <iframe src="album/toaddalbum" name="rightF" width="600px" height="350px" marginheight="0" marginwidth="0"  style="margin: 0px; padding: 0px"> </iframe>

     </div>
  </div>
  </div>
  
  
  

  
</body>
</html>