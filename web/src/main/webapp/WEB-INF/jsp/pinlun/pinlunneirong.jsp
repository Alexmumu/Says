<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/amazeui.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.js"></script>
	<script type="text/javascript">
	
		
	})
	</script>

</head>
<body>
	<div class="am-panel am-panel-default">
  
		<!--评论框-->
							
<!--评论列表
							     <div class="am-g">
				     	<div class="am-u-lg-12">
	
<ul class="am-comments-list">
	
	<li class="am-comment am-comment-primary">
  <a href="#link-to-user-home">
    <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
  </a>

  <div class="am-comment-main">
    <header class="am-comment-hd">
      <h3 class="am-comment-title">评论标题</h3>
      <div class="am-comment-meta">
        <a href="#link-to-user" class="am-comment-author">某人</a>
        评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
        <a href="" class="am-fr"> 回复</a>
      </div>
    </header>

    <div class="am-comment-bd">
      ...
    </div>
  </div>
</li>
<li class="am-comment am-comment-flip ">
  <a href="#link-to-user-home">
    <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
  </a>

  <div class="am-comment-main">
    <header class="am-comment-hd">
      <h3 class="am-comment-title">评论标题</h3>
      <div class="am-comment-meta">
        <a href="#link-to-user" class="am-comment-author">某人</a>
        评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
        <a href="" class="am-fr"> 回复</a>
      </div>
    </header>

    <div class="am-comment-bd">
      你现在在哪列呢？
    </div>

  </div>
</li>
</ul>
							     	</div>
							     </div>-->
		

<div class="am-panel-bd" style="padding-left:20px;padding-right:20px;">
  <ul class="am-list">
<c:forEach items="${page1.result}" var="pro">
  <li style="height:80px; line-height:78px;"><span style="display:block;width:80px; float:left;"><img  src="images/${pro.userid.userimg}" alt="" class="am-comment-avatar" width="48" height="48"></span><span>${pro.commentcontent}</span><span style="float:right;"> <a href="javascript:void(0);" data-am-modal="{target: '#my-popup'}" class="am-link-muted"><i class="am-icon-comments"></i>回复(0)</a></span></li>
  <li ><span style="font-size: 12px;">${pro.userid.usernickname} 在</span><span style="color: blue;">${pro.commentdate}</span><span style="font-size: 12px;">发表了评论</span></li>
  <a  id="sanchu" onclick="javascript:window.parent.location.reload();" style="background-color:A2A2A2; font-size:14px; color:blue; margin-top: -118px ; float:right;" class="am-close am-close-alt am-close-spin" href="Comments/deleteComment?commentid=${pro.commentid}">
  x
</a>
</c:forEach>
  </ul>
 </div>
</body>
</html>