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
   <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.js"></script>
</head>
<body>
  <div class="am-panel am-panel-default">
  <div class="am-panel-hd">某某相册</div>
  <div class="am-panel-bd">
<figure data-am-widget="figure" class="am am-figure am-figure-default "
data-am-figure="{  pureview: 'auto' }">
<ul class="am-avg-lg-4 am-thumbnail">
 <c:if test="${ empty photo.result }">
         <h3 align="center">还没有靓照哦！</h3>
 </c:if>
 
 <c:if test="${ not empty photo.result }">
  <c:forEach items="${photo.result}" var="p">
<li>
<img src="images/photo/${p.photosrc }" data-rel="photo/${p.photosrc}"alt="hello world" />
   <figcaption class="am-figure-capition-btm"> <div class="am-g am-text-sm">
              <div class="">
                <span>
                  <a href="javascript:void(0);" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论(20)</a>

<!--评论弹出框-->
  <div class="am-popup" id="my-popup" style="display: none;">
    <div class="am-popup-inner">
      <div class="am-popup-hd">
        <h4 class="am-popup-title">评论输入窗口</h4>
        <span data-am-modal-close="" class="am-close">×</span>
      </div>
      <div class="am-popup-bd">

         <iframe src="pinglun.html" name="rightF" width="600px" height="550px" marginheight="0" marginwidth="0" style="margin: 0px;padding: 0px;"> </iframe>

  </div>
  </div>
  </div>
<!--评论弹出框结束-->
          </span>
          <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span>
            <a href="" class="am-link-muted" alt="转发">
        <i class="am-icon-share" alt="转发"></i>
        转发(10)</a>
                </span>
                  <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <span>
                  <a href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i>赞(150)</a>
                </span>

              </div>
            </div>
            </figcaption>
  
  
</li>
 </c:forEach> 
 </c:if>
</ul>
</figure>
 
</div>
</div>


</body>
</html>