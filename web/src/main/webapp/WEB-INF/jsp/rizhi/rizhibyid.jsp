<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
	<link rel="stylesheet" type="text/css" href="css/laypage/skin/laypage.css">

  	<script src="js/jquery.min.js"></script>
  	<script src="js/amazeui.js"></script>
</head>
<body>
<article class="am-article">
  <div class="am-article-hd">
    <h1 class="am-article-title"><p>${srz.rizhititle}</p></h1>
    <p class="am-article-meta">${srz.rizhitype.typename}</p>
  </div>

  <div class="am-article-bd">
    <p class="am-article-lead">
     ${srz.rizhicontent}
    </p>
    <p>

     ${srz.rizhidate}
  </p>
  </div>
</article>

<div class="am-g am-text-sm">
              <div class="am-fr">
                <span>
                  <button href="" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>评论(20)</button>

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
            <button href="" class="am-link-muted" alt="转发">
        <i class="am-icon-share" alt="转发"></i>
        转发(10)</button>
                </span>
                  <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <span>
                  <button href="" class="am-link-muted"><i class="am-icon-thumbs-up"></i>赞(150)</button>
                </span>
              
            
              </div>
            </div>

</body>
</html>